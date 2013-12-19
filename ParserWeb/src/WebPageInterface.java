/*
 * File name : WebPageInterface.java
 * Project name: NCKU-LOSP-TEAM1 project
 * Description:
 * 				The interface which define class DataUnit and 
 * 				function setURL, getURL, sortByTime, and getDataUnit. 
 */
import java.util.ArrayList;
import java.util.Date;

public interface WebPageInterface  {
	/*
	 * DataUnit : The class store Data with url, title, time, and location.
	 */
	public class DataUnit{
		
		private String url;
		private String title;
		private Date time;
		private String location;
		
		String getUrl(){
			return url;
		}
		
		void setUrl(String theUrl){
			url = theUrl;
		}
		
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
	}


	public void setURL(String URL);
	public String getURL();
	//public void parsingData() throws IOException;
	public void sortByTime();
	abstract ArrayList<DataUnit> getDataUnit();
	
}
