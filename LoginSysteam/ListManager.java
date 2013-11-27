import java.util.ArrayList;

/**
 * Array list is used for storing the user data.
 * And ListManaget provides the function that add, delete, load,
 * and save users' data.
 */
public class ListManager
{
	// the arraylist for storing user datas with initial size 10.
	private ArrayList< UserUnit > userList = new ArrayList< UserUnit >();

	/**
	 * Add a user data element to the end of the arraylist.
	 * It will return the current size of the arraylist.
	 */
	public int addAnElement( UserUnit ele )
	{
		userList.add( ele );

		return userList.size();
	}	// end addAnElement()

	/**
	 * Get the specified user element.
	 * Exception from get(): IndexOutOfBoundsException
	 */
	public UserUnit getAnElement( int index )
	{
		return userList.get( index );
	}	// end getAnElement() func

	/**
	 * Find if the specified user is in the list.
	 * If it exists, it will return the user's index.
	 * Otherwise, it will return -1.
	 */
	public int findAnElement( String username )
	{
		UserUnit tmp = new UserUnit();

		for ( int i = 0; i < userList.size(); ++i )
		{
			tmp = getAnElement(i);

			if ( username.compareTo( tmp.getUsername() ) == 0 )
				return i;
		}

		return -1;
	}	// end findAnElement() func

}	// end class ListManager