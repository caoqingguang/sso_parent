package sso.util.primarykey;
public interface PrimarykeyGenerator {
	/** 自定义key实际存储时会增加的前缀，最终存入的key是：PREFIX +  自定义key  */
//	public static final String PREFIX = "GET_PRIMERYKEY_OF_TABLE_";
	/** 最终存入的key是：PREFIX_DB + dbName + PREFIX_TB + tableName */
	public static final String PREFIX_DB = "GET_PRIMERYKEY_OF_TABLE_DB_";
	/** 最终存入的key是：PREFIX_DB + dbName + PREFIX_TB + tableName */
	public static final String PREFIX_TB = "_DB_";
	public Long  generateId(String dbName, String tableName);
}