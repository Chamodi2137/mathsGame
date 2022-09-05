package app.mygame.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;


/**
 * 
 * @author 
 *
 */
public class DataAccessDao {

	private static final Log LOG = LogFactory.getLog(DataAccessDao.class);
	/**
	 * 
	 * @param userName
	 * @param passcode
	 * @return
	 */
	public boolean find(String userName, String passcode) {
		
		LOG.info("find is called - user[" + userName + "]passcode[" + passcode + "]");
		boolean isRecordFund = false;
		Connection con = null;
		ResultSet rs = null;
		try {
			LOG.info("DB fetch and login is called.");
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection(AppDBConstant.tblogin, AppDBConstant.username, AppDBConstant.password);
			LOG.info("DB connected ");
			Statement stmt=con.createStatement();
			stmt.setQueryTimeout(AppDBConstant.DB_CALL_TIMEOUT);
			String sql="Select * from tblogin where username='" + userName 
						+ "' and password='" + passcode + "'";
			rs = stmt.executeQuery(sql);
			if(rs.next()) {
				isRecordFund = true;
				LOG.info("Login successful");
			} else {
				isRecordFund = false;
				LOG.info("Login failed");
			}
		} catch(Exception exp) {
			LOG.error("Error::" + exp);
		} finally {
			// close DB resources.
			closeResultSet(rs);
			closeConnection(con);
		}	
		LOG.info("isRecordFund :" + isRecordFund);
		return isRecordFund;
	}

	/**
	 * 
	 * @param value
	 * @throws Exception
	 */
	public void updateAnswer(String value) throws Exception {
		LOG.info("Enter updateAnswer.");
		Connection con = null;
		PreparedStatement pst = null;
		
		try {
			String submitQuery = "INSERT INTO submitanswers(sa) VALUES (?)";
			con = DriverManager.getConnection(AppDBConstant.tblogin, 
							AppDBConstant.username, AppDBConstant.password);
			
			LOG.info("value-->" + value);
			pst = con.prepareStatement(submitQuery);
			pst.setQueryTimeout(AppDBConstant.DB_CALL_TIMEOUT);
			pst.setString(1, value);
			pst.execute();
		} catch(Exception e) {
			LOG.error("Error::" + e);
		} finally {
			// close DB resources.
			closePreparedStatement(pst);
			closeConnection(con);
		}	
		LOG.info("Exit updateAnswer.");
	}
	
	public void updateCompare() {
		LOG.info("Enter updateCompare.");
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		
		try {
			con = DriverManager.getConnection(AppDBConstant.tblogin, 
					AppDBConstant.username, AppDBConstant.password);
			//String extractQuery = "select submitanswers.sa, answer.ans from answer inner join (select sa from submitanswers order by id desc limit 1) as submitanswers on submitanswers.sa = answer.ans ";
			String extractQuery = "select submitanswers.sa, ans.ans from answer ans inner join (select sa from submitanswers order by id desc limit 1) as submitanswers on submitanswers.sa = ans.ans";
			pst = con.prepareStatement(extractQuery);
			rs = pst.executeQuery();
			
			String valueQuery = "INSERT INTO compare (value) VALUES(?)";
			pst = con.prepareStatement(valueQuery);
			
			if(rs.next()) {				
				pst.setString(1, "correct");
			}
			else {
				pst.setString(1, "Incorrect");
			}
			pst.executeUpdate();
		}  catch(Exception e) {
			e.printStackTrace();
			LOG.error("Error::" + e);
		} finally {
			// close DB resources.
			closePreparedStatement(pst);
			closeResultSet(rs);
			closeConnection(con);
		}
		LOG.info("Exit updateCompare.");
	}
	
	private void closeConnection(Connection connection) {
		if (connection != null) {
			try {
				connection.close();
			} catch (SQLException e1) {
				
			}
		} 
	}
	
	private void closeResultSet(ResultSet rs) {
		if (rs != null) {
			try {
				rs.close();
			} catch (SQLException e1) {
				
			}
		} 
	}
	
	private void closePreparedStatement(PreparedStatement pst) {
		if (pst != null) {
			try {
				pst.close();
			} catch (SQLException e1) {
				
			}
		} 
	}

	
	
}
