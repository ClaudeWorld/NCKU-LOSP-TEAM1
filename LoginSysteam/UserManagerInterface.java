public interface UserManagerInterface
{
	public int setUserUnit( String userName, String passwd );
	public void listAllUser();
	public UserUnit getUserUnit( String userName ) throws Exception;
	//public void saveUsersToFile();
}