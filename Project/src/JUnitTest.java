import static org.junit.Assert.*;

import java.io.IOException;
import java.util.Date;
import java.util.Iterator;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;



public class JUnitTest {
	
	
	/*Initial setting*/
	private WebPage web;
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
			"http://www.ncts.ncku.edu.tw/"
	};
	
	public static WebPage getPage(int i){
		WebPage NewPage = null;
		if(i==1)
			NewPage = new Eagle();
		else if(i==2)
			NewPage = new Math();
		else if(i==3)
			NewPage = new Aeronautics();
		else if(i==4)
			NewPage = new Economics();
		else if(i==5)
			NewPage = new Engineer();
		else if(i==6)
			NewPage = new PoliticalEconomy();
		else if(i==7)
			NewPage = new NCKU_Center_for_General_Education();
		else if(i==8)
			NewPage = new NCKUSpeech();
		else if(i==9)
			NewPage = new NCKUSpeechTwo();
		else if(i==10)
			NewPage = new NCKUSpeechThree();
		else if(i==11)
			NewPage = new NCKUSpeechFour();
		else if(i==12)
			NewPage = new NCKUSpeechFive();
		else if(i==13)
			NewPage = new NCKUSpeechSix();
		else if(i==14)
			NewPage = new CSIE();
		else if(i==15)
			NewPage = new NCTSSouth();
		return NewPage;
	}
	
	 /*new object and call parsingData function*/
	@Before 
	public void setUp(){
		System.out.println("@Before setUp");
		web = getPage(1);
		web.setURL(url[1]);
		try {
			web.parsingData();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	/*Delete object*/
	@After 
	public void tearDown(){
		System.out.println("@After tearDown()");
		web = null;
	}
	
	/*for assertTrue() function use*/
	public boolean IntToBoolean(int value){
		return (value != 0);
	}

	/*test if object not null*/
	@Test     
	public void getWebTest() throws IOException {
		System.out.println("@getWebTest()...");
		assertNotNull(web);
	}
	
	 /*test if getUnitData and get information not null*/
	@Test   
	public void getDataTest(){
		System.out.println("@getDataTest()...");
		//assertNotNull(web.getDataUnit().get(0).getTime());
		assertNotNull(web.getDataUnit().get(0).getTitle());
		assertNotNull(web.getDataUnit().get(0).getURL());
	}
	
	/*test if sort is successful*/
	@Test   
	public void SortByTimeTest(){
		System.out.println("@SortByTimeTest()...");
		WebPageInterface.DataUnit later;
		boolean expected = true;
		Date former = null;
		
		web.sortByTime();	
		Iterator<WebPageInterface.DataUnit> iterator = web.getDataUnit().iterator();
		while(iterator.hasNext()) {
			
			later = iterator.next();		
			
			if(former != null){
				if(!former.equals(later.getTime()))
					expected = IntToBoolean(former.compareTo(later.getTime()));
				assertTrue("sortByTime() test",  expected);
			}
			
			former = later.getTime(); 
		}
	} 
}
