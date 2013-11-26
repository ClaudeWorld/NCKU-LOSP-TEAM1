public class UserManager implements UserManagerInterface
{
	UserUnit node = new UserUnit();

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

		return 0;
	}	// end setUserUnit()

	public String getUserUnit()
	{
		return node.getUsername() + " " + node.getPasswd();
	}	// end getUserUnit()
}