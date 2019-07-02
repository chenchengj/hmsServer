package IService;

public interface ILoginService {
	/**
	 * 	登录接口
	 * @param username
	 * @param password
	 * @return
	 */
	String login(String username,String password);
	
	/**
	 *	找回密码接口
	 * @param username
	 * @param idNum
	 * @return
	 */
	String findPwd(String username,String idNum);

	String updatePwd(String username, String oldPassword, String newPassword);

	String register(String username, String name, String password, String idNumber, String roleId);

	
}
