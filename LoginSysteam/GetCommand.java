import java.util.Scanner;

/**
 * Handle the command issued from the user.
 * And call UserManager for proper operation.
 */
public class GetCommand
{
	// User manager object
	private UserManager uManager = new UserManager();

	/**
	 * Case sensitive.
	 * currentUser will be modified by login() and logout()
	 *
	 * Avaliable command and its return value:
	 * - /register	: Create a new user data
	 *		>  1	: Registerd success
	 *		> -2	: Too few arguments for register command
	 *		> -3	: Too many characters for username or password
	 * - /list		: List all registerd accounts
	 *		>  2	: N/A
	 * - /login		: Login to the LoginSystem
	 *		>  3	: Login success
	 *		> -4	: Login failed
	 * - /logout	: Logout from the LoginSystem
	 *		>  4	: Logout success
	 * - /exit		: Exit the login system
	 *		>  0	: Issued /exit command
	 * - CMD_NOT_FOUND:
	 *		> -1	: User issued the command that is not defined
	 */
	public int getCommand( String command, String[] currentUser )
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

			System.out.println( "Register success!" );
			return 1;
		}	// end if ( /register )

		// issued /list
		if ( arguments[0].compareTo( "/list" ) == 0 )
		{
			uManager.listAllUser();
			return 2;
		}	// end if ( /list )

		// issued /login
		if ( arguments[0].compareTo( "/login" ) == 0 )
		{
			if ( login( currentUser ) == 0 )
			{
				System.out.println( "Login success!" );
				return 3;
			}

			return -4;
		}	// end if ( /login )

		// issued /logout
		if ( arguments[0].compareTo( "/logout" ) == 0 )
		{
			logout( currentUser );
			return 4;
		}

		// command not found
		return -1;

	}	//end getCommand() func

	/**
	 * The login process.
	 *
	 * When a user wants to login, the UserManager will check
	 * if that username is in the list.
	 * If the user exists,
	 * system will give user 3 chances to try password.
	 * If all 3 chances are faild, login() will return failed.
	 * If login success, the function will update the current username. 
	 *
	 * Here is the return value:
	 *	> 0		: Login success
	 *	> -1	: User not found
	 *	> -2	: Incorrect password
	 */
	public int login( String[] currentUser )
	{
		// The initial number of the login chance is 3.
		int chances = 3;
		// Store the username and passed form user.
		String buffer;
		Scanner keyboard = new Scanner( System.in );
		UserUnit tmp = new UserUnit();

		// Remind user to enter the username
		System.out.print( "Please enter the username: " );
		buffer = keyboard.next();

		// Find if the specified user exists or not.
		try
		{
			tmp = uManager.getUserUnit( buffer );
		}
		catch( Exception e )
		{
			System.out.println( "User not found. Please check if you entered the right account" );
			System.out.println( "Or use command \"/register <username> <passwd>\" to create new account." );
			return -1;
		}

		// Checking password
		while ( chances != 0 )
		{
			// One chance used
			--chances;

			System.out.print( "Enter Password: " );
			buffer = keyboard.next();

			// Check if the passwd is correct.
			if ( buffer.compareTo( tmp.getPasswd() ) == 0 )
			{
				// Update the Current username
				currentUser[0] = tmp.getUsername();

				return 0;
			}	// end if 

			// Wrong!!!
			System.out.println( "Wrong password. " + chances + " chances remains." );
		}	// end while()

		// Password is wrong.
		return -2;

	}	// end login() func

	/**
	 * Logout from the LoginSystem.
	 * It will change the currentUser state.
	 */
	public void logout( String[] currentUser )
	{
		currentUser[0] = "NotLogin";

		System.out.println( "Logout success" );
	}	// end logout() func

}	// end class GetCommand