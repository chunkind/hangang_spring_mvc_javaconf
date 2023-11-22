package com.dev.ck.cltsh.cmm.util;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.*;

/**
 * select, insert, update, delete 쿼리 java Object를
 * 테이블 이름으로 파라미터를 받아 생성한다.
 */
public class MysqlDataBuilder {

	private static final String SETTING_FILE 		= "src/main/resources/config.properties";
	private static final String DRIVER_CLASS_NAME 	= "jdbc.driverClassName";
	private static final String URL 				= "jdbc.url";
	private static final String USER_NAME 			= "jdbc.username";
	private static final String PASS_WORD 			= "jdbc.password";

	private static final String DATABASE_NAME 		= "chunkind";
	private static final String TARGET_TABLE 		= "CM_CODE";

	public static void main(String[] args) throws IOException {
		InputStream is = new FileInputStream(SETTING_FILE);
		Properties props = new Properties();
		props.load(is);
		String driver = props.getProperty(DRIVER_CLASS_NAME);
		String url = props.getProperty(URL);
		String userName = props.getProperty(USER_NAME);
		String userPass = props.getProperty(PASS_WORD);

		System.out.println("driver : " + driver + "\nurl : " + url + "\nuserName : " + userName + "\nuserPass : " + userPass);

		MysqlDataBuilder obj = new MysqlDataBuilder(driver, url, userName, userPass);

		String result = "";

		result = obj.createSelectSql(TARGET_TABLE);
//		result = obj.createInsertSql(TARGET_TABLE);
//		result = obj.createUpdateSql(TARGET_TABLE);
//		result = obj.createDeleteSql(TARGET_TABLE);
//		result = obj.createJavaObject(TARGET_TABLE);

		System.out.println(result);
	}

	private Connection db = null;
	private PreparedStatement ps = null;
	private Connection conn = null;
	private ResultSet rs = null;

	private String driver = "";
	private String url = "";
	private String userName = "";
	private String userPass = "";

	private MysqlDataBuilder(String driver, String url, String userName, String userPass) {
		this.driver = driver;
		this.url = url;
		this.userName = userName;
		this.userPass = userPass;
	}

	public Connection getConnect() {
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, userName, userPass);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException ee) {
			ee.printStackTrace();
		}
		return conn;
	}

	/**
	 * 모든 테이블을 가져온다.
	 * 
	 * @return
	 */
	public List<String> getAllTables() {
		List<String> result = new ArrayList<String>();
		try {
			this.getConnect();
			String sql = "SHOW FULL TABLES";
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				if ("BASE TABLE".equals(rs.getString("Table_type"))) {
					result.add(rs.getString("Tables_in_chunkind"));
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			this.allClose();
		}
		return result;
	}

	/**
	 * 모든 컬럼은 map으로 뽑아온다.
	 * 
	 * @param tableName
	 * @return
	 */
	public List<Map<String, String>> getAllTableColumn(String tableName) {
		List<Map<String, String>> result = new ArrayList<Map<String, String>>();
		Map<String, String> map;
		try {
			this.getConnect();
			String sql = "DESC " + tableName;
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				map = new HashMap<String, String>();
				map.put("field", rs.getString("Field"));
				map.put("type", rs.getString("Type"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			this.allClose();
		}
		return result;
	}

	/**
	 * 테이블이름으로 java object를 만든다.
	 * 
	 * @param tableName
	 * @return
	 */
	public String createJavaObject(String tableName) {
		String result = "";
		String filed = "";
		String comment = "";
		String type = "";
		try {
			this.getConnect();
			String sql = "SELECT * FROM information_schema.columns WHERE table_schema = \'" + DATABASE_NAME
					+ "\'  AND TABLE_NAME = \'" + tableName + "\'";
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			result += "import lombok.AllArgsConstructor;\n";
			result += "import lombok.Builder;\n";
			result += "import lombok.Data;\n";
			result += "import lombok.NoArgsConstructor;\n\n";
			result += "@Data\n";
			result += "@Builder\n";
			result += "@AllArgsConstructor\n";
			result += "@NoArgsConstructor\n";
			result += "public class " + transPascal(tableName) + "{\n";
			while (rs.next()) {
				filed = transCamel(rs.getString("COLUMN_NAME"));
				comment = rs.getString("COLUMN_COMMENT");
				type = rs.getString("DATA_TYPE");
				if (type.toUpperCase().contains("VARCHAR") || type.toUpperCase().contains("CHAR")
						|| type.toUpperCase().contains("TEXT") || type.toUpperCase().contains("BLOB")
						|| type.toUpperCase().contains("TEXT")) {
					result += "\tprivate String " + filed + ";/* " + comment + " */\n";
				}
				if (type.toUpperCase().contains("DATA")) {
					result += "\tprivate Date " + filed + ";/* " + comment + " */\n";
				}
				if (type.toUpperCase().contains("INT") || type.toUpperCase().contains("NUMBER")) {
					result += "\tprivate int " + filed + ";/* " + comment + " */\n";
				}
			}
			result += "}\n";
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			this.allClose();
		}
		return result;
	}

	/**
	 * SELECT 쿼리를 만든다.
	 * 
	 * @param tableName
	 * @return
	 */
	public String createSelectSql(String tableName) {
		String result = "";
		boolean isFirst = true;
		try {
			this.getConnect();
			String sql = "SELECT * FROM information_schema.columns WHERE table_schema = \'" + DATABASE_NAME
					+ "\'  AND TABLE_NAME = \'" + tableName + "\'";
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			String filed = "";
			String comment = "";
			result += "SELECT";
			while (rs.next()) {
				filed = transCamel(rs.getString("COLUMN_NAME"));
				comment = rs.getString("COLUMN_COMMENT");
				if (isFirst) {
					isFirst = false;
					result += " " + rs.getString("COLUMN_NAME") + " AS " + filed + " /* " + comment + " */\n";
				} else {
					result += "\t , " + rs.getString("COLUMN_NAME") + " AS " + filed + " /* " + comment + " */\n";
				}
			}
			result += "  FROM " + tableName;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			this.allClose();
		}
		return result;
	}

	/**
	 * INSERT 쿼리를 만든다.
	 * 
	 * @param tableName
	 * @return
	 */
	public String createInsertSql(String tableName) {
		String result = "";
		boolean isFirst = true;
		String beforeSql = "";
		String afterSql = "";
		try {
			this.getConnect();
			String sql = "SELECT * FROM information_schema.columns WHERE table_schema = \'" + DATABASE_NAME
					+ "\'  AND TABLE_NAME = \'" + tableName + "\'";
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			String filed = "";
			String comment = "";
			result += "INSERT INTO " + tableName + "\n";
			while (rs.next()) {
				filed = transCamel(rs.getString("COLUMN_NAME"));
				comment = rs.getString("COLUMN_COMMENT");
				if (isFirst) {
					isFirst = false;
					beforeSql += "( " + rs.getString("COLUMN_NAME") + " /* " + comment + " */\n";
					afterSql += "( #{" + filed + "} /* " + comment + " */\n";
				} else {
					beforeSql += ", " + rs.getString("COLUMN_NAME") + " /* " + comment + " */\n";
					afterSql += ", #{" + filed + "} /* " + comment + " */\n";
				}
			}
			result += beforeSql + ") VALUES\n" + afterSql + ")";
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			this.allClose();
		}
		return result;
	}

	/**
	 * UPDATE 쿼리를 만든다.
	 * 
	 * @param tableName
	 * @return
	 */
	public String createUpdateSql(String tableName) {
		String result = "";
		boolean isFirst = true;
		try {
			this.getConnect();
			String sql = "SELECT * FROM information_schema.columns WHERE table_schema = \'" + DATABASE_NAME
					+ "\'  AND TABLE_NAME = \'" + tableName + "\'";
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			String filed = "";
			String comment = "";
			result += "UPDATE " + tableName + "\n";
			while (rs.next()) {
				filed = transCamel(rs.getString("COLUMN_NAME"));
				comment = rs.getString("COLUMN_COMMENT");
				if (isFirst) {
					isFirst = false;
					result += "   SET " + rs.getString("COLUMN_NAME") + " = #{" + filed + "} /* " + comment + " */\n";
				} else {
					result += "     , " + rs.getString("COLUMN_NAME") + " = #{" + filed + "} /* " + comment + " */\n";
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			this.allClose();
		}
		return result;
	}

	/**
	 * DELETE 쿼리를 만든다.
	 * 
	 * @param tableName
	 * @return
	 */
	public String createDeleteSql(String tableName) {
		return "DELETE FROM " + tableName;
	}

	/**
	 * 스네이크케이스 -> 카멜케이스로 변환
	 * 
	 * @param text
	 * @return
	 */
	public String transCamel(String text) {
		String targetText = text.toLowerCase();
		int textSize = targetText.length();
		int startCnt = 0;
		String newText = "";
		for (int i = 0; i < textSize; i++) {
			String t = targetText.substring(startCnt, startCnt + 1);
			if (t.equals("_")) {
				startCnt++;
				textSize--;
				newText += targetText.substring(startCnt, startCnt + 1).toUpperCase();
			} else {
				newText += t;
			}
			startCnt++;
		}
		return newText;
	}

	/**
	 * 스네이크케이스 -> 파스칼케이스로 변환
	 * 
	 * @param text
	 * @return
	 */
	public String transPascal(String text) {
		String targetText = text.toLowerCase();
		int textSize = targetText.length();
		int startCnt = 0;
		String newText = "";
		for (int i = 0; i < textSize; i++) {
			String t = targetText.substring(startCnt, startCnt + 1);
			if (i == 0) {
				newText += targetText.substring(startCnt, startCnt + 1).toUpperCase();
			} else if (t.equals("_")) {
				startCnt++;
				textSize--;
				newText += targetText.substring(startCnt, startCnt + 1).toUpperCase();
			} else {
				newText += t;
			}
			startCnt++;
		}
		return newText;
	}

	/**
	 * 자원 클로즈
	 */
	public void allClose() {
		if (null != rs) {
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if (null != ps) {
			try {
				ps.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if (null != conn) {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}