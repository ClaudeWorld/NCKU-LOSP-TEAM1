/*
 * File name : PoliticalEconomy.java
 * Project name: NCKU-LOSP-TEAM1 project
 * Description:
 * 				The class extend WebPage can parse web :  http://www.gipe.ncku.edu.tw/newslists.asp?clsid=1&title=%BAt%C1%BF%B0T%AE%A7
 * 				Because time on this web doesn't have fixed  format, the DataUnit don't store Date.
 */
import java.io.IOException;
import java.util.ArrayList;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class PoliticalEconomy extends WebPage
{
	@Override
	void parsingData() throws IOException
	{
		String cmp = "ActNews.asp?newsid=";
		String GIoPEurl = "http://www.gipe.ncku.edu.tw/";
		ArrayList<String> listStr = new ArrayList<String>();  //The list store links which select a[href]	
		ArrayList<String> tdListStr = new ArrayList<String>();  //The list store tds which select td[width]  
		ArrayList<String> titleList = new ArrayList<String>();  //The list store title
		ArrayList<String> timeList = new ArrayList<String>();  //The list store time
		ArrayList<String> linkList = new ArrayList<String>();  //The list store link
		try
		{						
			Document doc = Jsoup.connect("http://www.gipe.ncku.edu.tw/newslists.asp?clsid=1&title=%BAt%C1%BF%B0T%AE%A7").get();			
			Elements links = doc.select("a[href]");
			Elements tds = doc.select("td[width]");
			Elements fonts = doc.getElementsByClass("font");
			
			for(Element td : tds)
			{
				tdListStr.add(td.text());					
			}			
			
			for(int i=14; i < tdListStr.size() - 2; i = i + 4)
			{				
				titleList.add(tdListStr.get(i));				
			}
			
			for(Element font : fonts)
			{
				timeList.add(font.text());				
			}
			
			for(Element link : links)
			{				
				listStr.add(link.attr("href"));				
			}
			
			for(int i=0; i<listStr.size(); i++)
			{
				//System.out.println(listStr.get(i));
				if( strncmp(cmp, listStr.get(i), cmp.length()) == 0)
				{		
					String parTmp = GIoPEurl.concat(listStr.get(i));
					linkList.add(parTmp);
				}
			}
			
			/*if(timeList.size() == titleList.size())
			{
				System.out.println("true");
			}
			
			if(timeList.size() == linkList.size())
			{
				System.out.println("true");
			}*/
			
			for(int i=0; i < timeList.size(); i++)
			{				
				DataUnit tmpData = new DataUnit();				
				tmpData.setTitle(titleList.get(i));
				//System.out.println(titleList.get(i));				
				//System.out.println(timeList.get(i));
				tmpData.setURL(linkList.get(i));
				//System.out.println(linkList.get(i));
				//System.out.println();
				myList.add(tmpData);
			}
		}
		catch(Exception e)
		{
			System.out.println("Connect Graduate Institute of Political Economy error.");
		}			
	}
	
	/*
	 * strncmp : the function implement the function strncmp in C <string.h>
	 *           if String str1 is same as str2 from  index 0 to index n, return 0.
	 *           else return -1. 
	 */
	public static int strncmp(String str1, String str2, int n)
	{			
		if(str1.length() < n || str2.length() < n)
		{
			return -1;
		}
		else
		{
			str1 = str1.substring(0, n);
			str2 = str2.substring(0, n);			
		}
		
		if(str1.equals(str2))
		{
			return 0;
		}
		else
		{
			return -1;
		}
	}

}
