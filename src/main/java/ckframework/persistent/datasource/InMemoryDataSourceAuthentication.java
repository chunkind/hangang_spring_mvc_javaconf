package ckframework.persistent.datasource;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class InMemoryDataSourceAuthentication implements DataSourceAuthentication{
	String user;
	String password;
}
