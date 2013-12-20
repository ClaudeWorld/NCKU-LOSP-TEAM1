import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Map;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;


class NCKU_Center_for_Gereral_Education extends WebPage
{
	public String url;
	public ArrayList<DataUnit> nckuCGE_List = new ArrayList<DataUnit>();
	public void sortByTime(){
	}
	public void setURL(String URL){
		this.url = URL;
	}
	public String getURL(){
		return url;
	}
	@Override
	public void parsingData() throws IOException{
		Document doc = Jsoup.connect(url).get();
		Elements content = doc.getElementsByClass("ptname");
		DataUnit nckuCGEUnit[] = new DataUnit[30]; 
		int i = 0;

		for (Element contents : content) {
			Elements links = contents.getElementsByTag("a");
			String linkHref = links.attr("href");
			String linkTarget = links.attr("target");
			String linkText = links.text();
			if(linkTarget.equals("_blank"))
				break;

			nckuCGEUnit[i] = new DataUnit();
			nckuCGEUnit[i].setTitle(linkText);
			nckuCGEUnit[i].setUrl(linkHref);
			Document doc2 = Jsoup.connect(linkHref).get();
			Elements content2 = doc2.getElementsByTag("ptname");
			System.out.println(linkHref);
			i++;
		}
	}

	public ArrayList<DataUnit> getDataUnit(){
		return nckuCGE_List; 
	}
}

