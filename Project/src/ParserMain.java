/* File name: ParserMain.java
 * Project name: NCKU-LOSP-TEAM1 project
 * Environment: Eclipse
 * Description: 
 * 		This is a project to parser web site of lecture info, 
 * 		(URL¡Btitle¡Btime¡Blocation...)
 * Design Pattern: 
 * 		1.Simple Factory   
 *  	2.Iterator
 * */

import java.io.IOException;
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
			default:
				System.out.println("Error: no such page ID");
				break;
		
		}
		return NewPage;
	}

	/*Iterator Design pattern to print out the result*/
	public static void foreach(Collection<WebPageInterface.DataUnit> collection) {

		Iterator<WebPageInterface.DataUnit> iterator = collection.iterator();
		WebPageInterface.DataUnit Data;
		
		while(iterator.hasNext()) {
			Data = iterator.next();
			System.out.println(Data.getTime());
			System.out.println(Data.getTitle());
			System.out.println(Data.getURL());
		}
		
	}
	
	
	public static void main(String[] args) throws IOException {
	
			String url[] = { 
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
			}; /*There are 15 pages now*/

			
		for(int i=1; i <= 16; ++i){
		
			if(i!=3 && i!=13){
				
				/*use "polymorphism" to get child web page
				  get new Page Object */
				WebPage webPage = getPage(i);
				
				/*set this page's URL*/
				webPage.setURL(url[i]);
				
				/*parse and store data*/
				webPage.parsingData();		
				
				/*by ascending*/
				webPage.sortByTime();
			
				/*print out the result*/
				foreach(webPage.getDataUnit());
				
				System.out.printf("-------End Page %d-------\n", i);
			}
		}
	}
}
