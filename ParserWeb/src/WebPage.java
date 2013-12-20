/*
 * File name : WebPage.java
 * Project name: NCKU-LOSP-TEAM1 project
 * Description:
 * 				The class implement WebPageInterface 
 * 				and define abstract function parsingData.
 */

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public abstract class WebPage implements WebPageInterface{
	
	protected String URL;
	protected ArrayList<DataUnit> myList = new ArrayList<DataUnit>(); //The list store DataUnit
	
	public void setURL(String inputURL){
		URL = inputURL;
	}
	
	public String getURL(){	
		return  URL;
	}
	public ArrayList<DataUnit> getDataUnit() {		
		return myList;
	}
	
	/*
	 * sortByTime() : The function can sort DataUnit by time from earlier to late. 
	 */
	public void sortByTime(){
		
		Collections.sort(myList, new Comparator<DataUnit>(){
			
			@Override
			public int compare(DataUnit arg0, DataUnit arg1) {
					return arg0.getTime().compareTo(arg1.getTime());
			}   
		});
	}

	abstract void parsingData() throws IOException;
}
