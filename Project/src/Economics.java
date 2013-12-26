/*
 * File name : Economics.java
 * Project name: NCKU-LOSP-TEAM1 project
 * Description:
 * 				The class extend WebPage can parse web :  http://economics.ncku.edu.tw/seminar.asp
 * 				Because time on this web is connect to title, the DataUnit don't store time.
 */

import java.io.IOException;
import java.util.ArrayList;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;


public class Economics extends WebPage
{	
	@Override
	void parsingData() throws IOException
	{
		String cmp = "./ActNews.asp?newsid=";
		String DoEurl = "http://economics.ncku.edu.tw";
		ArrayList<String> listStr = new ArrayList<String>();  //The list store links which select a[href]	
		ArrayList<String> titleList = new ArrayList<String>();  //The list store title
		ArrayList<String> linkList = new ArrayList<String>();  //The list store link
		
		try
		{						
			Document doc = Jsoup.connect("http://economics.ncku.edu.tw/seminar.asp").get();
			Elements links = doc.select("a[href]");
			
			for(Element link : links)
			{				
				listStr.add(link.attr("href"));					
			}
			
			for(int i=0; i<listStr.size(); i++)
			{
				//System.out.println(listStr.get(i));
				if( strncmp(cmp, listStr.get(i), cmp.length()) == 0)
				{		
					String parTmp = DoEurl.concat(listStr.get(i));
					Document docTmp = Jsoup.connect(parTmp).get();
					
					titleList.add(docTmp.title());
					linkList.add(parTmp);
					/*Elements tds = docTmp.select("p[style]");
					
					for(Element td : tds)
					{
						System.out.println(td.text());
					}*/
				}
			}
			
			for(int i=0; i < titleList.size(); i++)
			{
				DataUnit tmpData = new DataUnit();
				tmpData.setTitle(titleList.get(i));
				//System.out.println(titleList.get(i));
				tmpData.setURL(linkList.get(i));
				//System.out.println(linkList.get(i));
				//System.out.println();
				myList.add(tmpData);
			}
		}
		catch(Exception e)
		{
			System.out.println("Connect Department of Economics error.");
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
