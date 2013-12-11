

import java.io.IOException;

public interface ParserInterface{
	
	public void setURL(String URL);
	public String getURL();
	public void parsingData() throws IOException;
	public void sortByTime();
	
}