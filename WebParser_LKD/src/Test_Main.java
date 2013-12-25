
public class Test_Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		//EE aEE = new EE();
		NCTSSouth aNCTSSouth = new NCTSSouth();
		CSIE aCSIE = new CSIE();
		
		try
		{
			aNCTSSouth.setURL( "http://www.ncts.ncku.edu.tw/" );
			aNCTSSouth.parsingData();
			for ( WebPageInterface.DataUnit temp : aNCTSSouth.myList )
			{
				System.out.println( temp.getTitle() + "/" + temp.getTime().toString() + "/" + temp.getLocation() );
			}
			
			System.out.println( "----------\nNCTSSouth Test Finished\n" );
			
			aCSIE.setURL( "http://www.csie.ncku.edu.tw/new/nckucsie/index.php?content=speechntalk&year=102_1" );
			aCSIE.parsingData();
			for ( WebPageInterface.DataUnit temp : aCSIE.myList )
			{
				System.out.println( temp.getTitle() + "/" + temp.getTime().toString() + "/" + temp.getLocation() );
			}
		}
		catch( Exception e )
		{
			System.out.println( "An exception that not be handled" );
		}

		System.out.println( "-----------\nTest finished" );
	}

}
