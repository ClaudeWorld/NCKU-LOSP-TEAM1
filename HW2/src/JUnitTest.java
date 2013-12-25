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
			"http://cge.ncku.edu.tw/bin/home.php"
	};
	
	public static WebPage getWeb(int i){
		WebPage webPage = null;
		if(i==1)
			webPage = new Eagle();
		else if(i==2)
			webPage = new Math();
		else if(i==3)
			webPage = new Aeronautics();
		else if(i==4)
			webPage = new Economics();
		else if(i==5)
			webPage = new Engineer();
		else if(i==6)
			webPage = new PoliticalEconomy();
		else if(i==7)
			webPage = new NCKU_Center_for_General_Education();
		return webPage;
	}
	
	 /*new object and call parsingData function*/
	@Before 
	public void setUp(){
		System.out.println("@Before setUp");
		web = getWeb(7);
		web.setURL(url[7]);
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
		assertNotNull(web.getDataUnit().get(0).getTime());
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
