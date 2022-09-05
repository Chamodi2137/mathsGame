package app.mygame.authenticate;

import app.mygame.dao.DataAccessDao;

/**
 * 
 * @author chamodi samarakoon
 *
 */
public class AppLogin {

	/**
	 * 
	 * @param username
	 * @param passcode
	 * @return
	 */
	public static boolean authenticate(String username, String passcode) {
		DataAccessDao dao = new DataAccessDao();
		boolean isFound = false;
		try {
			dao.find(username, passcode);
			isFound = true;
		} catch(Exception e) {
			
		}
		return isFound;
	}
}
