/* File name: ParserMain.java
 * Project name: NCKU-LOSP-TEAM1 project
 * Environment: Eclipse
 * Description: 
 * 		This is a project to parser web site of lecture info, 
 * 		(URL、title、time、location...)
 * Design Pattern: 
 * 		1.Simple Factory   
 *  	2.Iterator
 * */

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class ParserMain{
	
	/*simple Factory: Use only one class to get all other web page(object)*/
	public static WebPage getPage(int i){
		WebPage NewPage = null;
		
		switch(i){
			case 1:
				NewPage = new Eagle();
				break;
			case 2:
				NewPage = new Math();
				break;
			case 3:
				NewPage = new Aeronautics();
				break;
			case 4:
				NewPage = new Economics();
				break;
			case 5:
				NewPage = new Engineer();
				break;
			case 6:
				NewPage = new PoliticalEconomy();
				break;
			case 7:
				NewPage = new NCKU_Center_for_General_Education();
				break;
			case 8:
				NewPage = new NCKUSpeech();
				break;
			case 9:
				NewPage = new NCKUSpeechTwo();
				break;
			case 10:
				NewPage = new NCKUSpeechThree();
				break;
			case 11:
				NewPage = new NCKUSpeechFour();
				break;
			case 12:
				NewPage = new NCKUSpeechFive();
				break;
			case 13:
				NewPage = new NCKUSpeechSix();
				break;
			case 14:
				NewPage = new CSIE();
				break;
			case 15:
				NewPage = new NCTSSouth();
				break;
			case 16:
				NewPage = new Statistic();
				break;
			default:
				System.out.println("Error: no such page ID");
				break;
		
		}
		return NewPage;
	}

	/*Iterator Design pattern to insert the result to database*/
	public static void insertToDatabase(DatabaseInterface Database, String tableName, int id, Collection<WebPageInterface.DataUnit> collection) throws SQLException {
		
		int first = 1;
		Iterator<WebPageInterface.DataUnit> iterator = collection.iterator();
		WebPageInterface.DataUnit Data;
		
		String recordTable = "parserecord";
		
		/*size = number of column data*/
		String dataSet[] = new String[5];
		
		dataSet[0] = Integer.toString(id);
		while(iterator.hasNext()) {
			
			Data = iterator.next();
			if( Data.getTime() != null){
				dataSet[1] = Data.getTime().toString();
			}
			else{
				dataSet[1] = null;
			}
			if( insertCheck(Database, recordTable,  Data.getTitle() ) ){
				dataSet[2] = Data.getTitle();
				dataSet[3] = Data.getURL();
				dataSet[4] = Data.getLocation();
				Database.insertData(tableName, dataSet);
				
				if(first == 1 && insertCheck(Database, recordTable, Data.getTitle() )){
					String temp[] = new String[2];
					temp[0] = dataSet[0];
					temp[1] = Data.getTitle();
					Database.insertData(recordTable, temp);
					first = -1;
				}
			}else{
				break;
			}
		}
		
	}
	
	public static boolean insertCheck(DatabaseInterface Database, String tableName, String title) throws SQLException{
		
		
		ResultSet rs = Database.selectData(tableName); 
		
		while ( rs.next() ){
			
			/*check if the insert tile is the same to data in database*/
			if( title.equals(rs.getString(2)) ){
			 	
				return false;
			}
			else{
				
				return true;
			}
		}
		return true;
	}
	
	public static void main(String[] args) throws IOException, SQLException, InstantiationException, IllegalAccessException, ClassNotFoundException {
	
			String DATABASE_URL = "jdbc:postgresql://210.61.10.89:9999/Team1";
			String USER_NAME = "Team1";
			String PASSWORD = "2013postgres";
			String TABLE_NAME = "Lecture";
			
			String WebURL[] = { 
					"",
					"http://english.ncku.edu.tw/eagle/?q=taxonomy/term/21",
					"http://www.math.ncku.edu.tw/research/talk.php?period=new",
					"http://www.iaa.ncku.edu.tw/Disquisition/Disquisition.aspx",
					"http://economics.ncku.edu.tw/seminar.asp",
					"http://www.eng.ncku.edu.tw/files/13-1283-101409.php",
					"http://www.gipe.ncku.edu.tw/newslists.asp?clsid=1&title=%BAt%C1%BF%B0T%AE%A7",
					"http://cge.ncku.edu.tw/bin/home.php",
					"http://apps.acad.ncku.edu.tw/lecture/main/show_list_goto.php?deptno=&page=1",
					"http://apps.acad.ncku.edu.tw/lecture/main/show_list_goto.php?deptno=&page=2",
					"http://apps.acad.ncku.edu.tw/lecture/main/show_list_goto.php?deptno=&page=3",
					"http://apps.acad.ncku.edu.tw/lecture/main/show_list_goto.php?deptno=&page=4",
					"http://apps.acad.ncku.edu.tw/lecture/main/show_list_goto.php?deptno=&page=5",
					"http://apps.acad.ncku.edu.tw/lecture/main/show_list_goto.php?deptno=&page=6",
					"http://www.csie.ncku.edu.tw/new/nckucsie/index.php?content=speechntalk&year=102_1",
					"http://www.ncts.ncku.edu.tw/",
					"http://www.stat.ncku.edu.tw/news/speech.asp"
			}; /*There are 16 pages now*/
			
		/*List to save each page object*/			
		ArrayList<WebPage> pageList = new ArrayList<WebPage>();	
		
		
		for(int i=1; i <= 12; ++i){
		
			if( i!=3 && i!=13 ){
				
				/*get new Page Object */
				WebPage webPage = getPage(i);
				
				/*set this page's URL*/
				webPage.setURL(WebURL[i]);
				
				/*parse and store data*/
				webPage.parsingData();		
				
				/*by decrease*/
				webPage.sortByTime();
			
				/*add to List*/
				pageList.add(webPage);
				
				System.out.printf("Page %d Parse success.\n", i);
			}
		}
		
		/*initialize database*/
		DatabaseInterface Database = new Database();
		Database.setUrl(DATABASE_URL);
		Database.connect(USER_NAME, PASSWORD);
		
		/*Insert the the result*/
		for(int i=0; i < pageList.size(); ++i){
			insertToDatabase( Database, TABLE_NAME, i, pageList.get(i).getDataUnit());
		}
		
		/*get data form database*/
		ResultSet rs = Database.selectData(TABLE_NAME);
		ResultSetMetaData meta = rs.getMetaData(); 
		while( rs.next() ){
			for(int i=1; i<=meta.getColumnCount(); ++i){
				System.out.printf("%s ", rs.getString(i));
			}
			System.out.printf("\n");
		}
	
		//Database.deleteData(TABLE_NAME);
		//Database.deleteData("parserecord");
		
		/*close database connection*/
		Database.close();
		
		System.out.println("End of program");
	}
}
