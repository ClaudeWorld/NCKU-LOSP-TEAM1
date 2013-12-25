/*
 * Filename: CSIE.java
 * Project name: NCKU-LOSP-TEAM1 Project
 * Description:
 * 		CSIE: Computer Science and Information Engineering
 * 		Source Web site: http://www.csie.ncku.edu.tw/new/nckucsie/index.php?content=speechntalk&year=102_1
 * **Problems that have to pay attention to**
 * 		The current web page only contains presentations in the second half of 2013.
 * 		However, in the first half of 2014, We must change the URL of the web site
 * 		which only contains presentation in that term.
 */
import java.io.IOException;
import java.util.Date;
import java.text.DateFormat;
import java.text.ParseException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class CSIE extends WebPage
{
	@Override
	void parsingData() throws IOException
	{
		try
		{
			Document doc = Jsoup.connect( getURL() ).get();
			Elements p_msg = doc.select( "tr" );
			Boolean isTitle = true;
			
			for ( Element tmp : p_msg )
			{
				/*
				 * When the presentation information is valid, the childNodeSize is 13.
				 * And the text of third child is not empty.
				 */
				if ( tmp.childNodeSize() == 13 && tmp.children().get(3).hasText() )
				{
					// Create a new Data Unit to handle the information
					DataUnit newDataUnit = new DataUnit();
					
					if ( isTitle )
					{
						isTitle = false;
						continue;
					}
					/*===== Get Date =====*/
					Date myDate = DateFormat.getDateInstance().parse( tmp.children().get(1).text() );			
					newDataUnit.setTime( myDate );
					/*===== Get Title =====*/
					newDataUnit.setTitle( tmp.children().get(3).text() );
					/*===== Get Location =====*/
					newDataUnit.setLocation( tmp.children().get(4).text() );
					
					/*===== Add this new element to the list =====*/
					myList.add( newDataUnit );
				}	// end if()
			}
			
		}	// end try
		catch ( ParseException e )
		{
			System.out.println( "Exception handled when parseing date" );
		}
		catch ( IOException e )
		{
			System.out.println( "Cannot connect to the web site of CSIE" );
		}	// end catch
		
	}	// end parsingData() function
}	// end class CSIE
