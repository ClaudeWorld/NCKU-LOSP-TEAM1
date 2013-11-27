public class UserManager implements UserManagerInterface
{
	// A array list to store the user data.
	private ListManager list = new ListManager();
	// the number of the users registered
	private int numOfUsers = 0;

	/**
	 * Handle the data from the user's request.
	 * Check if both userName and passwd are vaild( both max 8 characters ).
	 * If the userUnit is created sccussfully, the function will return 0.
	 * Otherwise, it will return the negative value for manager to handle it.
	 * Here is the returh value:
	 * -  0	: success
	 * - -1 : the length of the username is over 8
	 * - -2 : the length of the password is over 8
	 */
	public int setUserUnit( String userName, String passwd )
	{
		// Create a temp UserUnit to add to the array list
		UserUnit node = new UserUnit();

		// the length of the username is over 8.
		if ( userName.length() > 8 )
			return -1;
		// the length of the password is over 8.
		if ( passwd.length() > 8 )
			return -2;

		// store the user data to the UserUnit
		node.setUUID( userName.hashCode() );
		node.setUsername( userName );
		node.setPasswd( passwd );

		// Add the element to array list.
		numOfUsers = list.addAnElement( node );

		return 0;
	}	// end setUserUnit()

	/**
	 *	List all users' name in the array list.
	 */
	public void listAllUser()
	{
		System.out.println( "There are " + numOfUsers + " users registered." );

		for ( int i = 0; i < numOfUsers; ++i )
		{
			System.out.println( list.getAnElement(i).getUsername() );
		}
	}	// end listAlluser() func

	/**
	 * Find the specified user data, and return it to the caller.
	 * If the user is not exists, throw the exception.
	 */
	public UserUnit getUserUnit( String username ) throws Exception
	{

		for ( int i = 0; i < numOfUsers; ++i )
		{
			if ( username.compareTo( list.getAnElement(i).getUsername() ) == 0 )
				return list.getAnElement(i);
		}

		// If the user dosen't exists.
		throw new Exception( "User not found." );

	}	// end getUserUnit()
}