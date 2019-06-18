package it.prova.test;

import java.sql.Connection;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

import it.prova.connection.MyConnection;
import it.prova.dao.Constants;
import it.prova.dao.user.UserDAO;
import it.prova.dao.user.UserDAOImpl;
import it.prova.model.User;

public class TestUser {

	public static void main(String[] args) {
		User newUserInstance = new User("pluto", "plutotto", "ppp", "pxpx");
		newUserInstance.setDateCreated(new Date());
		
		
		
		UserDAO userDAOInstance = null;
		Connection connection = null;
		try {
			connection = MyConnection.getConnection(Constants.DRIVER_NAME,Constants.CONNECTION_URL);
			userDAOInstance = new UserDAOImpl(connection);
			
			System.out.println("In tabella ci sono "+userDAOInstance.list().size()+" elementi.");
			userDAOInstance.insert(newUserInstance);
			User founded = userDAOInstance.findByLoginAndPassword("bondoks", "ziopaperino");
			System.out.println(founded);
//			userDAOInstance.delete(founded);
//			System.out.println("In tabella ci sono "+userDAOInstance.list().size()+" elementi.");
			
			//da fare il test dopo aver implementato in UserDAOImpl
			User example = new User();
			example.setNome("Marco");
			System.out.println("In tabella ci sono "+userDAOInstance.findByExample(example).size()+" "+example.getNome());
		    for(User u :userDAOInstance.findAllByLoginIniziaCon("bo")) {
		    	System.out.println(u);
		    }
			System.out.println("########################################################################################");
			//cerca gli utenti creati dopo una certa data
			String dataDaCuiPartire = "2019-05-28";
			Date dateCreatedInput = new SimpleDateFormat("yyyy-MM-dd").parse(dataDaCuiPartire);
			for (User userItem : userDAOInstance.findAllWhereDateCreatedGreaterThan(dateCreatedInput)) {
				System.out.println(userItem);
			}
			
			//prova findByExample
			System.out.println("############################## findByExample #######################");
			for (User userItem : userDAOInstance.findByExample(new User(null,"Bianchi","iii",null, new SimpleDateFormat("yyyy-MM-dd").parse("2019-02-01")))) {
				System.out.println(userItem);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}

}
