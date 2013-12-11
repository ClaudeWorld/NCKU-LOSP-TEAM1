import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;


public class NCKU_Center_for_Gereral_Education extends WebPage{

		void parsingData() throws IOException{
		
		Document doc = Jsoup.connect(URL).get();
		Elements content = doc.getElementsByClass("ptname");
		DataUnit nckuCGEUnit[] = new DataUnit[50]; 
		DateFormat df = new SimpleDateFormat("yyy.MM.dd");
		Date dt = null;
		
		int i = 0;
		
		for (Element contents : content) {
			Elements links = contents.getElementsByTag("a");
			String linkHref = links.attr("href");
			String linkText = links.text();
			//String linkText = ilinkText.substring(10);
			if(linkText.equals("成大數位學習平台"))
				break;
			else if(!linkText.equals("通識教育生活實踐認證流程")){
				String linkTime = linkText.substring(0, 9);
				nckuCGEUnit[i] = new DataUnit();
				nckuCGEUnit[i].setTitle(linkText);
				nckuCGEUnit[i].setURL(linkHref);
				try {
					dt = df.parse(linkTime);
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				nckuCGEUnit[i].setTime(dt);
				
				myList.add(nckuCGEUnit[i]);
				//System.out.println(linkText);
				//System.out.println(linkHref);
				//System.out.println(linkTime);
				i++;
			}
		}
	}
	
	public void printArrayList(){
		for (DataUnit data : myList) {
	        System.out.println("Title: "+data.getTitle()+"Date: "+data.getTime()+"Link: "+data.getURL());
	    }
	}
}
