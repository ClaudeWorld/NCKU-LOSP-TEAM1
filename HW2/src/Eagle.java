
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class Eagle extends WebPage{

		public void parsingData() throws IOException{
			
			/*connect to the web*/
			Document doc = Jsoup.connect(URL).get();
		
			//Elements titles = doc.select(".node h2 a[title]");
			Elements links = doc.select(".node h2 a[href]");
			
			for (Element link : links) {
					
					/*new a DataUnit to push to arrayList*/
					DataUnit Data = new DataUnit();
					
					/*to cut string*/
					int timeIndex = link.attr("title").indexOf("1");
					int titleIndex = 2 + link.attr("title").indexOf(")");
					/*get the time*/
					String time = link.attr("title").substring( timeIndex, titleIndex - 1 );
					/*get the title*/
					String title = link.attr("title").substring(titleIndex, link.attr("title").length());
					
					time = time.replace("102","2013");
					time = time.replace("103","2014");
					if(time.length()>14){
						String temp = time.substring(0,4);
						time = time.substring(5, time.length());
						time = temp + time;
					}
					
					
					/*convert string to Date format*/
					SimpleDateFormat dateFormat = new SimpleDateFormat("yyy.MM.dd");
					Date date = null;
					
					
					try {
						date = dateFormat.parse(time);
					} catch (ParseException e) {
						// TODO Auto-generated catch block
						//e.printStackTrace();
						
					} 
					if(date != null){
					/*set value to Data unit*/
					Data.setTitle(title);
					Data.setTime(date);
		            Data.setURL(link.attr("href"));
					Data.setLocation("­×»ô¤j¼Ó");
		            
		            /*add to arrayList*/
		            myList.add(Data);
					}
		     }
		}
}
