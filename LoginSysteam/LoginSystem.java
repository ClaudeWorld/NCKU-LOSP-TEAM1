import java.util.Scanner;

/**
 * The User Interface of the Login System.
 */
public class LoginSystem
{
	public static void main( String[] args )
	{
		Scanner keyboard = new Scanner( System.in );
		GetCommand gCommand = new GetCommand();

		String userCommand;
		/**
		 * The currentUser identifies the user's status
		 */
		String[] currentUser = new String[1];
		currentUser[0] = "NotLogin";

		int commandID;
		boolean go_on = true;

		// Print the welcome message
		System.out.println( "Login system Version 1.3" );

		// The loop will go on until user enter "/exit".
		while ( go_on )
		{
			// Tell user that system is waiting for input.
			System.out.print( currentUser[0] + " > " );
			// Get user command from stdin
			userCommand = keyboard.nextLine();
			// Get the CommandID
			commandID = gCommand.getCommand( userCommand, currentUser );

			// Operating the command
			switch ( commandID )
			{
			case 0:		// /exit
				go_on = false;
				break;
			case -1:	//Command not found
				System.out.println( userCommand + ": Command not found!" );
				break;
			default:	//Command is handled by GetCommand
				break;
			}	// end switch( commandID )

			//System.out.println( userCommand );
		}	// end while ( go_on )

	}	// end main()
}