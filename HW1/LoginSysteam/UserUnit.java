/**
 * UserUnit: define a user data unit structure
 * Provide set/get function to access the private data.
 */
public class UserUnit
{
	/**
	 * username	: The user's account( max 8 characters )
	 * uUID		: The user's unique id
	 * passwd	: The passwd for account( max 8 characters )
	 */
	private String username;
	private Integer uUID;
	private String passwd;

	public void setUsername( String buffer )
	{
		username = buffer;
	}	// end setUsername()

	public void setPasswd( String buffer )
	{
		passwd = buffer;
	}	// end setPasswd()

	public void setUUID( Integer buffer )
	{
		uUID = buffer;
	}	// end setUUID()

	public String getUsername()
	{
		return username;
	}	// end getUsername()

	public String getPasswd()
	{
		return passwd;
	}	// end getPasswd();

	public Integer getUUID()
	{
		return uUID;
	}	// end getUUID();
}	// end class UserUnit