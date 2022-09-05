package app.mygame.controller;

import app.mygame.dao.DataAccessDao;

/**
 * 
 * @author currently handle using Database. Can integrate with external system.
 *
 */
public class LogicControllder {

	public void updateAnswer(String value) throws Exception {
		// TODO Auto-generated method stub
		new DataAccessDao().updateAnswer(value);
	}

	public void updateCompare(String value) throws Exception {
		new DataAccessDao().updateCompare();
		
	}

}
