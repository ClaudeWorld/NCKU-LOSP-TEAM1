import java.util.Scanner;

/**
 * The User Interface of the Login System.
 */
public class LoginSystem
{
	public static void main( String[] args )
	{
		Scanner keyboard = new Scanner( System.in );
		UserManager uManager = new UserManager();
		GetCommand gCommand = new GetCommand();

		String userCommand;
		int commandID;
		boolean go_on = true;

		// Print the welcome message
		System.out.println( "Login system Version 1.2" );

		while ( go_on )
		{
			// Tell user that system is waiting for input.
			System.out.print( "> " );
			// Get user command from stdin
			userCommand = keyboard.next();
			// Get the CommandID
			commandID = gCommand.getCommand( userCommand );

			// Operating the command
			switch ( commandID )
			{
			case 0:	// /exit
				go_on = false;
				break;
			case 1:	// /register
				System.out.println( "Register?" );
				break;
			case -1: //Command not found
				System.out.println( userCommand + ": Command not found!" );
				break;
			}	// end switch( commandID )

			//System.out.println( userCommand );
		}	// end while ( go_on )

	}	// end main()
}