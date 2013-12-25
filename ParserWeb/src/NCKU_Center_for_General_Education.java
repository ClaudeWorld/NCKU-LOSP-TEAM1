import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Map;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;


class NCKU_Center_for_General_Education extends WebPage
{
	public String url = "http://cge.ncku.edu.tw/bin/home.php";
	public ArrayList<DataUnit> nckuCGE_List = new ArrayList<DataUnit>();

	@Override
	public void parsingData() throws IOException{
		Document doc = Jsoup.connect(url).get();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd");
		Elements content = doc.getElementsByClass("ptname");
		DataUnit nckuCGEUnit[] = new DataUnit[30]; 
		String linkHref = "";
		String linkText = "";
		String tmpTime = "";
		Date linkTime = null;
		
		int i = 0;

		for (Element contents : content) {
			Elements links = contents.getElementsByTag("a");
			linkHref = links.attr("href");
			linkText = links.text();
			
			if(!linkText.equals("通識教育生活實踐認證流程")){
				if(linkText.equals("成大數位學習平台"))
					return;
				tmpTime = linkText.substring(0, 9);
				linkText = linkText.substring(10);
				nckuCGEUnit[i] = new DataUnit();
				nckuCGEUnit[i].setTitle(linkText);
				nckuCGEUnit[i].setUrl(linkHref);
				try {
					linkTime = sdf.parse(tmpTime);
					nckuCGEUnit[i].setTime(linkTime);
				} catch (ParseException e) {
					e.printStackTrace();
				}
				
				//System.out.println(linkText);
				//System.out.println(linkHref);
				//System.out.println(tmpTime);
				nckuCGE_List.add(nckuCGEUnit[i]);
				i++;
			}
		}
	}

	public ArrayList<DataUnit> getDataUnit(){
		return nckuCGE_List; 
	}
}

