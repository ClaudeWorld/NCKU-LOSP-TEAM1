import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class Database implements DatabaseInterface{

	String url = null;  	//database connect URL
	Connection con = null;     
	Statement st = null;       // statement to pass SQL command
	
	@Override
	public void setUrl(String url) {
		this.url = url;
	}

	@Override
	public String getUrl() {
		return url;
	}

	@Override
	public boolean connect(String userName, String password) throws SQLException, InstantiationException, IllegalAccessException, ClassNotFoundException {
		
		if(url == null){
			return false;
		}
		else{
			Class.forName("org.postgresql.Driver").newInstance(); 
			con = DriverManager.getConnection(url, userName, password);
			
			/*initialize statement for following function*/
			st = con.createStatement();
			return true;
		}
		
	}

	@Override
	public void close() throws SQLException {
		if(st!=null && con!=null){
			st.close();
			con.close();
		}
	}

	@Override
	public void insertData(String tableName, String data[]){
		
		/*SQL insert command 
		 * = INSERT INTO "tableName" values ('data1','data2'...);*/
		
		String sql = "INSERT INTO " + tableName + " values " + "(" +  Integer.valueOf(data[0]) + ",";
		
		/*write this enable table column number can be different*/
		for(int i=1; i < data.length; ++i){
			sql = sql +  "'" +  data[i] + "'";
			if( i != data.length -1){
				sql += ",";
			}
		}
		sql += ");";
		
		
		try {
			st.executeQuery(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override    
	public void deleteData(String tableName, String columnName, String key) {
		
		String sql = "DELETE FROM " + tableName;
		sql += " WHERE " + columnName + "=" + "'" + key + "';";
		System.out.printf("%s", sql);
		try {
			st.executeQuery(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}

	@Override
	public ResultSet selectData(String tableName, int DataNumber) {
		
		String sql = "SELECT * FROM " + tableName + " LIMIT "+ Integer.toString(DataNumber) + ";" ;
		
		/*get the SQL result*/
		ResultSet rs = null;
		try {
			rs = st.executeQuery(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rs;
	}

}
