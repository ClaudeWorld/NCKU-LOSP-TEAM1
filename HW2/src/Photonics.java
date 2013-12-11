import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class Photonics extends WebPage{

		
		public void parsingData() throws IOException{
			
			Document doc = Jsoup.connect(URL).get();
		
			//Elements titles = doc.select(".node h2 a[title]");
			Elements links = doc.select("#boxB3 tbody a[href]");
			
			//int timeIndex; 
			int titleIndex;
			for (Element link : links) {
				System.out.printf("%s", link.text());
				
				DataUnit Data = new DataUnit();
					titleIndex =  link.text().indexOf(' ');
					//titleIndex = 1 + link.attr("title").indexOf("¡G");
					if(titleIndex != -1){
						String time =  link.text().substring( 0, titleIndex - 1 );
						String title = link.text().substring( titleIndex , link.text().length() );
					
					SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
					Date date = null;
					try {
						date = dateFormat.parse(time);
					} catch (ParseException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} 
					
					Data.setTitle(title);
					Data.setTime(date);
		            Data.setLocation("­×»ô¤j¼Ó");
		            /*add to arrayList*/
		            myList.add(Data);
				}
		    }
			
		}

}

