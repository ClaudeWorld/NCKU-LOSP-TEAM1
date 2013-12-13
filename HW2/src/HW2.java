/* File name: HW2.java
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
import java.util.Collection;
import java.util.Iterator;

public class HW2{
	
	/*simple Factory: Use only one class to get all other web page(object)*/
	public static WebPage getWeb(int i){
		WebPage webPage = null;
		if(i==1)
			webPage = new Eagle();
		else if(i==2)
			webPage = new Photonics();
		else if(i==3)
			webPage = new Math();
		else if(i==4)
			webPage = new Aeronautics();
		else if(i==5)
			webPage = new NCKU_Center_for_Gereral_Education ();
		return webPage;
	}

	/*Iterator Design pattern to print out the result*/
	public static void foreach(Collection<WebPageInterface.DataUnit> collection) {

		Iterator<WebPageInterface.DataUnit> iterator = collection.iterator();
		WebPageInterface.DataUnit Data;
		
		while(iterator.hasNext()) {
			Data = iterator.next();
			System.out.println(Data.getTime());
			System.out.println(Data.getTitle());
		}
		
	}
	
	
	public static void main(String[] args) throws IOException {
	
		/*URL: 1.成鷹計畫    2.光電    3.數學     4.航太*/
			String url[] = { 
					"",
					"http://english.ncku.edu.tw/eagle/?q=taxonomy/term/21",
					"http://www.dps.ncku.edu.tw/main.php",
					"http://www.math.ncku.edu.tw/research/talk.php?period=new",
					"http://www.iaa.ncku.edu.tw/Disquisition/Disquisition.aspx",
					"http://cge.ncku.edu.tw/bin/home.php"
			};

			
		for(int i=3; i <= 5; ++i){
			if(i!=2){
				/*use "polymorphism" to get child web page*/	
				
				WebPage webPage = getWeb(i);
				webPage.setURL(url[i]);
				
				/*parse and store data*/
				webPage.parsingData();		
				
				/*by ascending*/
				webPage.sortByTime();
			
				/*print out the result*/
				foreach(webPage.getDataUnit());
			}
		}
	}
}
