
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

public class Aeronautics extends WebPage{
		
		public void parsingData() throws IOException{
			
			Document doc = Jsoup.connect(URL).get();
			
			Elements time = doc.select("#LabelDate");
			Elements title = doc.select("#LabelTitleCh");
			Elements location =  doc.select("#LabelPlace");
			
			for (int i = 0; i < title.size(); ++i) {
				
				/*new a DataUnit to push to arrayList*/
				DataUnit Data = new DataUnit();
				

				/*convert string to Date format*/
				SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
				Date date = null;
				try {
					date = dateFormat.parse(time.get(i).text());
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}  
					
				/*set value to Data unit*/
					Data.setTitle(title.get(i).text());
					Data.setTime(date);
		            Data.setLocation(location.get(i).text());
		        /*add to arrayList*/
		            myList.add(Data);
		            
		     }
			
		}
}
