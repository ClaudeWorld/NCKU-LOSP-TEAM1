import java.io.IOException;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class NCKUSpeechFour extends WebPage
{	
	@Override
	void parsingData() throws IOException
	{
		String cmpGet = "show_list_goto.php?deptno=";
		String cmpBreak = "show_list_goto.php?deptno=&page=1";
		String NCKUurl = "http://apps.acad.ncku.edu.tw/lecture/main/";
		ArrayList<String> listStr = new ArrayList<String>();  //The list store links which select a[href
		ArrayList<String> listTitleStr = new ArrayList<String>();  //The list store links which select a[href
		ArrayList<String> tdListStr = new ArrayList<String>();  //The list store links' text
		ArrayList<String> titleList = new ArrayList<String>();  //The list store title
		ArrayList<String> timeList = new ArrayList<String>();  //The list store time
		ArrayList<String> linkList = new ArrayList<String>();  //The list store link
		ArrayList<String> locationList = new ArrayList<String>();
		try
		{				
			Document doc = Jsoup.connect("http://apps.acad.ncku.edu.tw/lecture/main/show_list_goto.php?deptno=&page=4").get();
			
			Elements links = doc.select("a[href]");
			Elements tds = doc.select("td[style]");
			
			for(Element link : links)
			{
				listStr.add(link.attr("href"));							
			}
			
			for(int i=0; i<listStr.size(); i++)
			{
				//System.out.println(listStr.get(i));
				if( strncmp(cmpBreak, listStr.get(i), cmpBreak.length()) == 0)
				{		
					break;
				}
				else if( strncmp(cmpGet, listStr.get(i), cmpGet.length()) == 0)
				{		
					String parTmp = NCKUurl.concat(listStr.get(i));
					//System.out.println(parTmp);
					linkList.add(parTmp);
				}
			}
						
			for(Element link : links)
			{
				listTitleStr.add(link.attr("title"));
				//System.out.println(link.attr("title"));			
			}
			//System.out.println(listTitleStr.get(1));
			for(int i=0; i<listTitleStr.size(); i = i + 2)
			{
				String locationTmp = "";
				char[] tmp = listTitleStr.get(i).toCharArray();
				for(int j=0; j<tmp.length; j++)
				{					
					if(tmp[j] == '\n')
					{
						locationTmp = listTitleStr.get(i).substring(0, j);
						break;
					}
				}
				locationList.add(locationTmp);
				//System.out.println(locationTmp);
				if(linkList.size() == locationList.size())
				{
					break;
				}
			}
						
			for(Element td : tds)
			{
				tdListStr.add(td.text());
				//System.out.println(td.text());
			}
			
			for(int i=0; i<tdListStr.size(); i = i + 4)
			{
				timeList.add(tdListStr.get(i));
				titleList.add(tdListStr.get(i + 1));
				//System.out.println(tdListStr.get(i));
				//System.out.println(tdListStr.get(i + 1));
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
				tmpData.setLocation(locationList.get(i));
				//System.out.println(linkList.get(i));
				//System.out.println();
				myList.add(tmpData);
			}
			
		}
		catch(Exception e)
		{
			System.out.println("Connect NCKU Speech Four Error");
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
