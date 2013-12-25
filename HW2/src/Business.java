/*
 * File name : Business.java
 * Project name: NCKU-LOSP-TEAM1 project
 * Description:
 * 				The class extend WebPage can parse web :  http://www.ba.ncku.edu.tw/design/index.php
 * 				Because some time on this web disappear, some DataUnit don't store time.
 */

import java.io.IOException;
import java.util.ArrayList;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import java.util.Date;
import java.text.DateFormat;

public class Business extends WebPage
{	
	@Override
	void parsingData() throws IOException
	{
		String cmp = "news_board.php?id=";
		String DoBurl = "http://www.ba.ncku.edu.tw/design/";
		ArrayList<String> listStr = new ArrayList<String>();  //The list store links which select a[href]
		ArrayList<String> tdListStr = new ArrayList<String>();  //The list store links' text
		ArrayList<String> titleList = new ArrayList<String>();  //The list store title
		ArrayList<String> timeList = new ArrayList<String>();  //The list store time
		ArrayList<String> linkList = new ArrayList<String>();  //The list store link
		try
		{				
			Document doc = Jsoup.connect("http://www.ba.ncku.edu.tw/design/index.php").get();
			
			Elements links = doc.select("a[href]");
			
			for(Element link : links)
			{
				listStr.add(link.attr("href"));
				tdListStr.add(link.text());			
			}
			
			for(int i = 53; i < 58; i++)
			{
				titleList.add(tdListStr.get(i).substring(10));
				timeList.add(tdListStr.get(i).substring(0, 10));				
			}
			
			/*for(int i = 0; i < titleList.size(); i++)
			{
				timeList.add(titleList.get(i).substring(0, 10));				
			}*/
			
			for(int i = 0; i < listStr.size(); i++)
			{
				if( strncmp(cmp, listStr.get(i), cmp.length()) == 0)
				{		
					String parTmp = DoBurl.concat(listStr.get(i));
					linkList.add(parTmp);
				}
			}
			
			for(int i = 0; i < titleList.size(); i++)
			{
				DataUnit tmpData = new DataUnit();
				DateFormat tmpDateFormat = DateFormat.getDateInstance();
				Date tmpDate;
				tmpData.setTitle(titleList.get(i));
				//System.out.println(titleList.get(i));
				tmpDate = tmpDateFormat.parse(timeList.get(i));
				tmpData.setTime(tmpDate);
				//System.out.println(timeList.get(i));
				tmpData.setURL(linkList.get(i));
				//System.out.println(linkList.get(i));
				//System.out.println();
				myList.add(tmpData);
			}
			
		}
		catch(Exception e)
		{
			System.out.println("Connect Department of Business Error");
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
