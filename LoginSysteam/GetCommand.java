/**
 * Handle the command issued from the user.
 * And call UserManager for proper operation.
 */
public class GetCommand
{
	// User manager object
	private UserManager uManager = new UserManager();

	/**
	 * Case sensitive
	 * Avaliable command and its return value:
	 * - /register	: Create a new user data
	 *		>  1	: Registerd successfully
	 *		> -2	: Too few arguments for register command
	 *		> -3	: Too many characters for username or password
	 * - /exit		: Exit the login system
	 *		>  0	: Issued /exit command
	 *
	 * If the command is unavaliable, it will return -1;
	 */
	public int getCommand( String command )
	{
		// Split the command line into several arguments.
		String[] arguments = command.split( "\\s" );

		// arguments[0] is the primary command.
		// issued /exit. (too many arguments should be handled)
		if ( arguments[0].compareTo( "/exit" ) == 0 )
			return 0;

		// issued /register
		if ( arguments[0].compareTo( "/register" ) == 0 )
		{
			// Too few arguments for command /register
			if ( arguments.length < 3 )
			{
				System.out.println( "Too few arguments for command /register: /register <username> <password>" );
				return -2;
			}
			// Too many characters for username or password
			if ( uManager.setUserUnit( arguments[1], arguments[2] ) < 0 )
			{
				System.out.println( "Too many characters for username or password, max 8 characters" );
				return -3;
			}

			System.out.println( "Register successfully!" );
			return 1;
		}	// end if ( /register )

		// command not found
		return -1;

	}	//end getCommand() func

}	// end class GetCommand