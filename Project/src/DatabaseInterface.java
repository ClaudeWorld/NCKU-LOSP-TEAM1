import java.sql.ResultSet;
import java.sql.SQLException;


public interface DatabaseInterface {
	
	public void setUrl(String url);    
	public String getUrl();
	public boolean connect(String userName, String password)  throws SQLException, InstantiationException, IllegalAccessException, ClassNotFoundException;
	
	public void insertData(String tableName, String data[]);
	
	/*Delete all the same key in this columnName of table*/
	public void deleteData(String tableName, String columnName, String key);
	
	/*getData*/
	public ResultSet selectData(String tableName, int DataNumber);
	
	public void close() throws SQLException ;
}
