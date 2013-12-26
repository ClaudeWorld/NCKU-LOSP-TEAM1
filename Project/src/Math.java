
/*數學系
 * 沒有地點資訊
 * */
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;


public class Math extends WebPage{
			
		public void parsingData() throws IOException{
			
			try{
				/*connect to the web*/
				Document doc = Jsoup.connect(URL).get();
			
				Elements time = doc.select("table[cellspacing] tr[valign=top] td[width=18%]:contains(/)");
				Elements links = doc.select("table[cellspacing] tbody font a[onclick]");
				
				for (int i = 0; i < links.size(); ++i) {
					
					/*new a DataUnit to push into arrayList*/
					DataUnit Data = new DataUnit();
					/* get title */ 
					String title = links.get(i).text();
					
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
						Data.setTitle(title);
						Data.setTime(date);
			            Data.setLocation(null);
			            Data.setURL(links.get(i).attr("href"));
			         /*add to arrayList*/
			            myList.add(Data);
						
				}
			}
			catch(Exception e)
			{
				System.out.println("Connect to Math Error");
				e.printStackTrace();
			}
		}
	
}
