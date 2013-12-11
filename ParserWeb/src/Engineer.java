/*
 * File name : Engineer.java
 * Project name: NCKU-LOSP-TEAM1 project
 * Description:
 * 				The class extend WebPage can parse web :  http://www.eng.ncku.edu.tw/files/13-1283-101409.php
 * 				Because the web will update every half of a year, the parser is fixed.
 * 				If web change, we need to rewrite parser.
 */

import java.io.IOException;
import java.util.ArrayList;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import java.util.Date;
import java.text.DateFormat;


public class Engineer extends WebPage
{
	private String url = "http://www.eng.ncku.edu.tw/files/13-1283-101409.php";
	
	@Override
	void parsingData() throws IOException
	{
		String yearStr = "2013/";
		ArrayList<String> listStr = new ArrayList<String>();  //The list store links select span			
		ArrayList<String> titleList = new ArrayList<String>();  //The list store title
		ArrayList<String> timeList = new ArrayList<String>();  //The list store time
		ArrayList<String> linkList = new ArrayList<String>();  //The list store link
		try
		{	
			
			Document doc = Jsoup.connect("http://www.eng.ncku.edu.tw/files/13-1283-101409.php").get();			
			Elements links = doc.select("span");
			
			for(Element link : links)
			{
				listStr.add(link.text());
				
			}
			
			titleList.add(listStr.get(56).substring(13));			
			titleList.add(listStr.get(68).substring(14,23));
			titleList.add(listStr.get(84));
			titleList.add(listStr.get(96));			
			titleList.add(listStr.get(112).substring(4,13));
			titleList.add(listStr.get(125).substring(4,12));			
			timeList.add(yearStr.concat(listStr.get(58)));
			timeList.add(yearStr.concat(listStr.get(70)));
			timeList.add(yearStr.concat(listStr.get(82)));
			timeList.add(yearStr.concat(listStr.get(95)));
			timeList.add(yearStr.concat(listStr.get(111)));
			timeList.add(yearStr.concat(listStr.get(124)));
			
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
				linkList.add(url);
				tmpData.setUrl(linkList.get(i));
				//System.out.println(linkList.get(i));
				//System.out.println();
				myList.add(tmpData);
			}
		}
		catch(Exception e)
		{
			System.out.println("Connect to College of Engineer Error");
		}
		
	}

}
