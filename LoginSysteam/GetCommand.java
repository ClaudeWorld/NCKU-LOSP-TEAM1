/**
 * Handle the command issued from the user.
 * Then, return the commandID to UI.
 */
public class GetCommand
{
	/**
	 * Case sensitive
	 * Avaliable command:
	 * - /register	: Create a new user data
	 * - /exit		: Exit the login system
	 *
	 * If the command is unavaliable, it will return -1;
	 */
	public int getCommand( String command )
	{
		if ( command.compareTo( "/exit" ) == 0 )
			return 0;
		if ( command.compareTo( "/register" ) == 0 )
			return 1;

		// command not found
		return -1;

	}	//end getCommand() func

}	// end class GetCommand