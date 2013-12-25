/*
 * File name : NCTSSouth.java
 * Project Name : NCKU-LOSP-TEAM1 project
 * Description : 
 * 		NCTS : National Center for Theoretical Sciences
 * 		Source Web Site : http://www.ncts.ncku.edu.tw/
 */
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.text.DateFormat;
import java.text.ParseException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class NCTSSouth extends WebPage
{
	@Override
	void parsingData() throws IOException
	{
		ArrayList<String> weblinkList = new ArrayList<String>();	// The list store sublink
		
		try
		{
			Document doc = Jsoup.connect( getURL() ).get();
			Elements links = doc.select( "a[target]" );
			
			// Get links of the webPage "More detail"
			for ( Element link : links )
			{
				// tmp: Temporarily store the sublink of the web page of presentation detail
				String tmp = link.attr( "href" ); 
				
				// The links I want have the substring "talk_detail" 
				if ( tmp.indexOf( "talk_detail" ) != -1 )
					weblinkList.add( tmp );
			}
			
			// Connect to the web page and store data to titleList, timeList, locationList, and URLList
			for ( String subURL : weblinkList )
			{
				/*
				 * Variable declaration:
				 * - sDoc	: The document of the target web site
				 * - msg	: Containing the information we want
				 * - newDataUnit
				 * 			: Temporarily store the information of the presentation.
				 * 			  Then, add it to the "myList".
				 */
				Document sDoc = Jsoup.connect( subURL ).get();
				Elements msg = sDoc.select( "font" );
				DataUnit newDataUnit = new DataUnit();
				
				/*==== Get Date => [Format] YYYY-MM-DD	====*/
				// DateFormat for parse the Date string to Date
				DateFormat df = DateFormat.getDateInstance();
				// First, change YYYY-MM-DD to YYYY/MM/DD. Then, parse the string and store to myDate
				Date myDate = df.parse( msg.get(1).text().replace( '-', '/' ) );
				newDataUnit.setTime( myDate );
				
				/*==== Get location	====*/
				newDataUnit.setLocation( msg.get(3).text() );
				
				/*==== Get title	====*/
				newDataUnit.setTitle( msg.get(6).text() );
				
				/*==== Get URL	====*/
				newDataUnit.setUrl( subURL );
				
				/*==== Add the new element to myList	====*/
				myList.add( newDataUnit );
			}	// end for(): Handle the data we get
		}	// end try
		catch( ParseException e )
		{
			System.out.println( "Exception from parsing the Date" );
		}
		catch( IOException e )
		{
			System.out.println( "Cannot connect to the webpage NCTS" );
		}
	}	// end parsingData() func

}	// end class NCTSSouth