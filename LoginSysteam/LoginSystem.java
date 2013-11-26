public class LoginSystem
{
	public static void main( String[] args )
	{
		UserManager uManager = new UserManager();

		uManager.setUserUnit( "LanKu", "2134" );
		System.out.println( uManager.getUserUnit() );
	}	// end main()
}