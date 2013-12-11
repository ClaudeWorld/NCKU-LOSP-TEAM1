/* File name: WebPageInterface.java
 * Function: provide a interface for WebPage.java to implements
 * About DataUnit class & Data processing  
 * */
import java.util.ArrayList;
import java.util.Date;

public interface WebPageInterface  {
	
	public void setURL(String URL);
	public String getURL();
	public void sortByTime();
	abstract ArrayList<DataUnit> getDataUnit();
	
	/* Defined a class about parse web Data*/ 
	public class DataUnit{
		
		private String title;
		private Date time;
		private String location;
		private String URL;
		private String addrURL; 
		
		String getTitle(){
			return title;
		}
		void setTitle(String theTitle){
			title = theTitle;
		}
		Date getTime(){
			return time;
		}
		void setTime(Date theTime){
			time = theTime;
		}
		String getLocation(){
			return location;
		}
		void setLocation(String theLocation){
			location = theLocation;
		}
		String getURL(){
			return URL;
		}
		void setURL(String theURL){
			URL = theURL;
		}
	}
	// end DataUnit
}
