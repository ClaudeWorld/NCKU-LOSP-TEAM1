import java.io.IOException;
import java.text.ParseException;
import java.util.Date;
import java.text.DateFormat;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;


class Statistic extends WebPage
{
	public String url = "http://www.stat.ncku.edu.tw/news/speech.asp";
	
	@Override
	public void parsingData() throws IOException{
		try{
			
			Document doc = Jsoup.connect(url).get();;
			Elements content = doc.getElementsByTag("tr");
			
			String linkTitle = "";
			String linkLocation = "";
			Date linkTime = null;
			
			// get each entry in the table
			for (int j = 1; j < content.size() - 1; j++) {
				Element contents = content.get(j);
				Elements tmp = contents.getElementsByTag("font");
				DataUnit staUnit = new DataUnit(); 
				// get each attribute from the table
				linkTime = DateFormat.getDateInstance().parse( tmp.get(0).text() );
				linkTitle = tmp.get(4).text();
				linkLocation = tmp.get(5).text();
				staUnit.setTime(linkTime);
				staUnit.setTitle(linkTitle);
				staUnit.setLocation(linkLocation);
				myList.add(staUnit);
			}
		}
		catch ( ParseException e )
		{
			System.out.println( "Exception handled when parseing date" );
		}
		catch ( IOException e )
		{
			System.out.println( "Cannot connect to the web site of CSIE" );
		}	// end catch
		
	}
}

