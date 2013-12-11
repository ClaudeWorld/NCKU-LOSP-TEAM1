/* File name: WebPage.java
 * Function: a parent class use to let other child class inherent
 * */
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public abstract class WebPage implements WebPageInterface{
	
	protected String URL;
	protected ArrayList<DataUnit> myList = new ArrayList<DataUnit>(); 
	
	public void setURL(String inputURL){
		
		URL = inputURL;
	}
	
	public String getURL(){	
		
		return  URL;
	}
	public ArrayList<DataUnit> getDataUnit() {
		
		return myList;
	}
	
	
	public void sortByTime(){
		
		Collections.sort(myList, new Comparator<DataUnit>(){
			@Override
			public int compare(DataUnit arg0, DataUnit arg1) {
				// TODO Auto-generated method stub
					return arg0.getTime().compareTo(arg1.getTime());
			}   
		});
	}

	abstract void parsingData() throws IOException;
}
