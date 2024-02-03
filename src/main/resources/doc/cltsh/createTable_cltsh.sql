/******************************************* 테이블 **********************************************/
DROP TABLE CLT_USR_BASE;
DROP TABLE CLT_GOODS_INFO;
DROP TABLE CLT_SALE_BOARD_RVW;
DROP TABLE CLT_QNA_BOARD;
DROP TABLE CLT_STD_CD_BASE;
DROP TABLE CLT_ENTR_BASE;
DROP TABLE CLT_GOODS_CATA;
DROP TABLE CLT_SALE_BOARD;
DROP TABLE CLT_ORD_BASE;
DROP TABLE CLT_ORD_DTL;
DROP TABLE CLT_ORD_BASKET;
DROP TABLE CLT_ORD_BASKET_HIST;
DROP TABLE CLT_COUPON_TBL;
DROP TABLE CLT_EVENT_TBL;
DROP TABLE CLT_GOODS_OPTS;

CREATE TABLE CLT_USR_BASE
( USR_BASE_SEQ	INT(20)		AUTO_INCREMENT PRIMARY KEY
, USR_ID	VARCHAR(200)		NOT NULL
, USR_NM	VARCHAR(200)		NULL
, PASS_WD	VARCHAR(200)		NULL
, USR_BIRTH     VARCHAR(200)   NULL
, EMAIL_ADDR	VARCHAR(200)		NULL
, CELL_NO	VARCHAR(100)		NULL
, LAND_ADDR_BASE	VARCHAR(1000)		NULL
, LAND_ADDR_DTL	VARCHAR(1000)		NULL
, LAND_POST_NO	VARCHAR(10)		NULL
, LOAD_ADDR_BASE	VARCHAR(1000)		NULL
, LOAD_ADDR_DTL	VARCHAR(1000)		NULL
, LOAD_POST_NO	VARCHAR(100)		NULL
, PASS_WD_CHG_DATE 	DATETIME 		NULL
, LOCK_YN	VARCHAR(1)		NULL
, RGST_ID	VARCHAR(200)		NULL
, RGST_DATE 	DATETIME 		NULL
, UPDT_ID	VARCHAR(200)		NULL
, UPDT_DATE 	DATETIME 		NULL
, USE_YN	VARCHAR(1)		NULL
, USR_GRDE	VARCHAR(20)	NULL	/*ORD002 / 회원등급*/
, ADM_GRDE	VARCHAR(20)	NULL	/*ORD003 /  관리자등급*/
);

CREATE TABLE CLT_GOODS_INFO
( GOODS_INFO_SEQ INT(20) AUTO_INCREMENT PRIMARY KEY
, GOODS_CD	INT(12)	NOT NULL /*상품 코드*/
, ENTR_NO	INT(12)	NULL /*거래처 번호*/
, GOODS_NM	VARCHAR(200)	NULL /*상품이름*/
, GOODS_PRC	INT(12)	NULL /*상품가격*/
, CATGRY_CD	VARCHAR(20)	NULL /*대분류*/
, CATGRY_CD2	VARCHAR(20)	NULL /*소분류*/
, INY_QTY	INT(14)	NULL /*재고수량*/
, DLV_PRC	INT(20)	NULL /*배송비*/
, GOODS_SIZE	VARCHAR(200)	NULL /*상품싸이즈*/
, GOODS_CLR	VARCHAR(200)	NULL /*상품컬러*/
, IMG_PATH	VARCHAR(500)	NULL /*이미지경로*/
, IMG_NM	VARCHAR(300)	NULL /*이미지이름*/
, GOODS_INTR	VARCHAR(4000)	NULL /*상품소개*/
, SALE_STAT_CD	VARCHAR(10)	NULL /*판매상태*/
, USE_YN	VARCHAR(1)	NULL /*사용여부*/
, RGST_ID	VARCHAR(20)	NULL /*등록자*/
, RGST_DATE 	DATETIME 	NULL /*등록일*/
, UPDT_ID	VARCHAR(20)	NULL /*수정자*/
, UPDT_DATE 	DATETIME 	NULL /*수정일*/
);

CREATE TABLE CLT_SALE_BOARD_RVW
( SALE_BOARD_RPY_SEQ	INT(20)		AUTO_INCREMENT PRIMARY KEY
, SALE_BOARD_SEQ	INT(12)		NOT NULL
, GOODS_CD	INT(12)		NOT NULL,
  ENTR_NO	INT(12)		NOT NULL,
  BUL_TIT_NM	VARCHAR(100)		NULL,
  BUL_CONT	VARCHAR(500)		NULL,
  RPY_LVL	INT(3)		NULL,
  PAR_SALE_BOARD_RPY_SN	INT(12)		NULL,
  QRY_CNT	INT(14)		NULL,
  LKE_CNT	INT(14)		NULL,
  RGST_ID	VARCHAR(200)		NULL,
  RGST_DATE 	DATETIME 		NULL,
  UPDT_ID	VARCHAR(200)		NULL,
  UPDT_DATE 	DATETIME 		NULL,
  USE_YN	VARCHAR(1)		NULL,
  IMG_PATH	VARCHAR(500)		NULL,
  IMG_NM	VARCHAR(300)		NULL,
  ORD_NO	VARCHAR(200)		NULL,
  RVW_TAG	VARCHAR(200)		NULL,
  ORD_DTL_NO	INT(12)		NULL
);

CREATE TABLE CLT_QNA_BOARD (
	QNA_BOARD_SEQ	INT(20)	AUTO_INCREMENT PRIMARY KEY,
	TIT_NM	VARCHAR(1000)	NULL,
	CONT	TEXT	NULL,
	RGST_ID	VARCHAR(200)	NULL,
	RGST_DATE 	DATETIME 	NULL,
	UPDT_ID	VARCHAR(200)	NULL,
	UPDT_DATE 	DATETIME 	NULL,
	QNA_TP	VARCHAR(20)	NULL,
	ANSR_STAT	VARCHAR(20)	NULL,
	USE_YN	VARCHAR(1)	NULL,
	PASS_YN	VARCHAR(1)	NULL,
	PASS_WD	VARCHAR(200)	NULL,
	GOODS_CD	INT(12)	NULL,
	ANSWER	TEXT	NULL
);

CREATE TABLE CLT_STD_CD_BASE
( STD_CD_BASE_SEQ	INT	AUTO_INCREMENT PRIMARY KEY
, CODE_NM	VARCHAR(200)	NOT NULL
, CODE_VAL	VARCHAR(200)	NOT NULL
, CODE_DESC	VARCHAR(2000)	NULL
, GRP_CD	VARCHAR(200)	NULL
, GRP_ORDR	INT(8)	NULL
, USE_YN	VARCHAR(1)	NULL
, RGST_ID	VARCHAR(200)	NULL
, RGST_DATE 	DATETIME 	NULL
, UPDT_ID	VARCHAR(200)	NULL
, UPDT_DATE 	DATETIME 	NULL
);

CREATE TABLE CLT_ENTR_BASE
( ENTR_NO	INT(12)		AUTO_INCREMENT PRIMARY KEY
, USR_ID	VARCHAR(20)		NOT NULL
, ENTR_NM	VARCHAR(100)		NULL
, BMAN_REG_NO	VARCHAR(20)		NULL
, PRES_NM	VARCHAR(100)		NULL
, PRES_TELL	VARCHAR(20)		NULL
, PRES_EMAIL	VARCHAR(200)		NULL
, AEMP_NM	VARCHAR(100)		NULL
, AEMP_TELL	VARCHAR(20)		NULL
, AEMP_EMAIL	VARCHAR(200)		NULL
, SCORE	INT(5)		NULL
, LAND_ADDR_BASE	VARCHAR(1000)		NULL
, LAND_ADDR_DTL	VARCHAR(1000)		NULL
, LAND_POST_NO	VARCHAR(10)		NULL
, LOAD_ADDR_BASE	VARCHAR(1000)		NULL
, LOAD_POST_NO	VARCHAR(100)		NULL
, OPN_DATE 	DATETIME 		NULL
, CLOSE_DATE 	DATETIME 		NULL
, OPN_YN	VARCHAR(1)		NULL
, USE_YN	VARCHAR(1)		NULL
, RGST_ID	VARCHAR(20)		NULL
, RGST_DATE 	DATETIME 		NULL
, UPDT_ID	VARCHAR(20)		NULL
, UPDT_DATE 	DATETIME 		NULL
);

CREATE TABLE CLT_GOODS_CATA
( GOODS_CATA_SEQ	INT(20)		AUTO_INCREMENT PRIMARY KEY
, CATGRY_CD	VARCHAR(20)		NOT NULL
, GOODS_CD	INT(12)		NOT NULL
, CATGRY_NM	VARCHAR(400)		NULL
, NOTE_CONT	VARCHAR(4000)		NULL
, CLASS_LVL_CD	VARCHAR(20)		NULL
, UPR_CLASS_CD	VARCHAR(20)		NULL
, RGST_ID	VARCHAR(200)		NULL
, RGST_DATE 	DATETIME 		NULL
, UPDT_ID	VARCHAR(200)		NULL
, UPDT_DATE 	DATETIME 		NULL
, USE_YN	VARCHAR(1)		NULL
);

CREATE TABLE CLT_SALE_BOARD (
    SALE_BOARD_SEQ	INT(20)		AUTO_INCREMENT PRIMARY KEY,
    ENTR_NO	INT(12)		NOT NULL,
    GOODS_CD	INT(12)		NOT NULL,
    SALE_STAT_CD	VARCHAR(2)		NULL,
    BUL_TIT_NM	VARCHAR(100)		NULL,
    BUL_STRT_DT	DATETIME 		NULL,
    BUL_END_DT	DATETIME 		NULL,
    BUL_YN	VARCHAR(2)		NULL,
    NTC_SCT_CD	VARCHAR(2)		NULL,
    BUL_CONT	TEXT		NULL,
    QRY_CNT	INT(14)		NULL,
    LKE_CNT	INT(14)		NULL,
    GOODS_PRC	INT(12)		NULL,
    GOODS_SALE_PRC	INT(12)		NULL,
    PRCL_WAY	VARCHAR(100)		NULL,
    SALE_CNT	INT(12)		NULL,
    RGST_ID	VARCHAR(200)		NULL,
    RGST_DATE 	DATETIME 		NULL,
    UPDT_ID	VARCHAR(200)		NULL,
    UPDT_DATE 	DATETIME 		NULL,
    USE_YN	VARCHAR(1)		NULL,
    DESCRIPTION	VARCHAR(100)		NULL
);

CREATE TABLE CLT_ORD_BASE (
    ORD_NO	VARCHAR(100)		PRIMARY KEY,
    USR_ID	VARCHAR(200)		NOT NULL,
    ORD_STAT	VARCHAR(8)		NULL,
    ORDR_ID	VARCHAR(200)		NULL,
    ORDR_NM	VARCHAR(200)		NULL,
    ORDR_PHON	VARCHAR(20)		NULL,
    ORDR_EMAIL	VARCHAR(200)		NULL,
    ACQR_PHON	VARCHAR(20)		NULL,
    ACQR_NM	VARCHAR(200)		NULL,
    ACQR_ADDR	VARCHAR(1000)		NULL,
    ACQR_ADDR_DTL	VARCHAR(500)		NULL,
    ACQR_EMAIL	VARCHAR(200)		NULL,
    PRCL_WAY	VARCHAR(100)		NULL,
    PACK_WAY	VARCHAR(100)		NULL,
    PAY_WAY	VARCHAR(100)		NULL,
    PAY_MNY	INT(12)		NULL,
    REQ_MEMO	VARCHAR(500)		NULL,
    ORD_DATE 	DATETIME 		NULL,
    UPDT_DATE 	DATETIME 		NULL,
    UPDT_ID	VARCHAR(200)		NULL,
    RGST_DATE 	DATETIME 		NULL,
    RGST_ID	VARCHAR(200)		NULL,
    BILL_NUM	INT(12)		NULL,
    SALE_BOARD_SEQ	INT(20)		NOT NULL,
    ENTR_NO	INT(12)		NOT NULL,
    GOODS_CD	INT(12)		NOT NULL
);

CREATE TABLE CLT_ORD_DTL (
	ORD_DTL_NO	INT(12)	AUTO_INCREMENT PRIMARY KEY,
	USR_ID	VARCHAR(20)	NOT NULL,
	ORD_NO	VARCHAR(200)	NOT NULL,
	GOODS_NM	VARCHAR(200)	NULL,
	GOODS_CD	INT(12)	NULL,
	GOODS_QTY	INT	NULL,
	UPDT_DATE 	DATETIME 	NULL,
	UPDT_ID	VARCHAR(200)	NULL,
	RGST_DATE 	DATETIME 	NULL,
	RGST_ID	VARCHAR(20)	NULL
);

CREATE TABLE CLT_ORD_BASKET (
  ORD_BASKET_SEQ	INT(20)		AUTO_INCREMENT PRIMARY KEY,
  USR_ID	VARCHAR(200)		NOT NULL,
  GOODS_QTY	INT(12)		NULL,
  PRCL_WAY	VARCHAR(100)		NULL,
  PACK_WAY	VARCHAR(100)		NULL,
  RGST_DATE 	DATETIME 		NULL,
  USE_YN	VARCHAR(1)		NULL,
  SALE_BOARD_SEQ	INT(20)		NOT NULL,
  GOODS_CD	INT(12)		NOT NULL,
  ENTR_NO	INT(12)		NOT NULL
);

CREATE TABLE CLT_ORD_BASKET_HIST (
   ORD_BASKET_HIST_SEQ	INT(20)		AUTO_INCREMENT PRIMARY KEY,
   ORD_BASKET_SEQ	INT(20)		NOT NULL,
   USR_ID	VARCHAR(200)		NOT NULL,
   GOODS_CD	INT(12)		NULL,
   GOODS_QTY	INT(12)		NULL,
   RGST_ID	VARCHAR(200)		NULL,
   RGST_DATE 	DATETIME 		NULL,
   HIST_MEMO	VARCHAR(2000)		NULL
);

CREATE TABLE CLT_COUPON_TBL (
	COU_INFO_SEQ INT(20) 	AUTO_INCREMENT PRIMARY KEY, 	/*쿠폰 시퀀스*/
	COU_NUM		 INT(12)		NOT NULL,		/*쿠폰 코드*/
	COU_NAME	 VARCHAR(200)	NULL,			/*쿠폰 이름*/
	COU_DISCOUNT INT(12)		NULL,			/*쿠폰 할인율*/
	COU_REGIST_DATE 	DATETIME 		NULL,			/*쿠폰 등록 날짜*/
	COU_END_DATE 	DATETIME 		NULL,			/*쿠폰 만료 날짜*/
	COU_COUNT	 INT(12)		NULL			/*쿠폰 개수*/
);

CREATE TABLE CLT_EVENT_TBL (
	EVENT_INFO_SEQ 	INT(20) 	AUTO_INCREMENT PRIMARY KEY, 	/*이벤트 시퀀스*/
	EVENT_NUM		INT(12)	 NOT NULL,		/*이벤트 코드*/
	EVENT_NAME	 	VARCHAR(200)	NULL,		/*이벤트 이름*/
	IMG_PATH		VARCHAR(500)	NULL,		/*이미지경로*/
	IMG_NM			VARCHAR(300)	NULL, 		/*이미지이름*/
	EVENT_REGIST_DATE 	DATETIME 		NULL,		/*이벤트 등록 날짜*/
	EVENT_END_DATE 		DATETIME 		NULL		/*이벤트 만료 날짜*/
);

CREATE TABLE CLT_GOODS_OPTS (
	GOODS_OPTS_SEQ	INT(20)	AUTO_INCREMENT PRIMARY KEY, /* 상품 옵션 시퀀스 */
	OPTS_CD		VARCHAR(400)	NOT NULL, /* 옵션 코드 */
	OPTS_NM		VARCHAR(400)	NULL, /* 옵션이름 */
	OPTS_VAL	VARCHAR(400)	NULL, /* 옵션값 */
	USE_YN		VARCHAR(1)	NULL, /* 사용여부 */
	RGST_ID		VARCHAR(200)	NULL, /* 등록아이디 */
	RGST_DATE	DATETIME	NULL, /* 등록일 */
	UPDT_ID		VARCHAR(200)	NULL, /* 수정아이디 */
	UPDT_DATE	DATETIME	NULL, /* 수정일 */
	GOODS_CD	INT(12)	NOT NULL /* 상품코드 */
);


ALTER DATABASE chunkind CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci;

ALTER TABLE CLT_USR_BASE CONVERT TO CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;
ALTER TABLE CLT_GOODS_INFO CONVERT TO CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;
ALTER TABLE CLT_SALE_BOARD_RVW CONVERT TO CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;
ALTER TABLE CLT_QNA_BOARD CONVERT TO CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;
ALTER TABLE CLT_STD_CD_BASE CONVERT TO CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;
ALTER TABLE CLT_ENTR_BASE CONVERT TO CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;
ALTER TABLE CLT_GOODS_CATA CONVERT TO CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;
ALTER TABLE CLT_SALE_BOARD CONVERT TO CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;
ALTER TABLE CLT_ORD_BASE CONVERT TO CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;
ALTER TABLE CLT_ORD_DTL CONVERT TO CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;
ALTER TABLE CLT_ORD_BASKET CONVERT TO CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;
ALTER TABLE CLT_ORD_BASKET_HIST CONVERT TO CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;
ALTER TABLE CLT_COUPON_TBL CONVERT TO CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;
ALTER TABLE CLT_EVENT_TBL CONVERT TO CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;

ALTER TABLE CLT_SALE_BOARD_RVW ADD COLUMN ORD_DTL_NO INT(12) NULL;