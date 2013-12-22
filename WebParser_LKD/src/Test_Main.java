import java.io.IOException;

public class Test_Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		//EE aEE = new EE();
		NCTSSouth aNCTSSouth = new NCTSSouth();
		
		try
		{
			aNCTSSouth.setURL( "http://www.ncts.ncku.edu.tw/" );
			aNCTSSouth.parsingData();
			for ( WebPageInterface.DataUnit temp : aNCTSSouth.myList )
			{
				System.out.println( temp.getTitle() + "/" + temp.getTime().toString() + "/" + temp.getLocation() );
			}
		}
		catch( Exception e )
		{
			System.out.println();
		}

		System.out.println( "-----------\nTest finished" );
	}

}
