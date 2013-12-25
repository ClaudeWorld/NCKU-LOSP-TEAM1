/*
 * File name : EE.java
 * Project name : NCKU-LOSP-TEAM1 project
 * Description :
 * 		The class extends WebPage can parse web :
 * 		http://www.ee.ncku.edu.tw/nckueechinese/index.php?option=com_content&view=category&layout=blog&id=6&Itemid=6
 */
import java.io.IOException;
import java.util.ArrayList;
//import java.util.Date;
//import java.text.DateFormat;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class EE extends WebPage
{
	@Override
	void parsingData() throws IOException
	{
		ArrayList<String> listStr = new ArrayList<String>();	// The list store links which select <a href>
		
		try
		{
			Document doc = Jsoup.connect("http://www.ee.ncku.edu.tw/nckueechinese/index.php?option=com_content&view=category&layout=blog&id=6&Itemid=6").get();
			Elements links = doc.select( "div" );
			
			for ( Element link : links )
			{
				listStr.add( link.text() );
			}
			
			for ( String temp : listStr )
			{
				System.out.println( temp );
			}
		}
		catch( Exception e )
		{
			System.out.println( "Cannot connect to the webpage of the EE" );
		}
	}	// end parsingData() func
	
}	// end class EE
