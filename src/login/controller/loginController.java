package login.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class loginController {
	//call fxid's:
	@FXML TextField userNameTxt;
	@FXML TextField passwordTxt;
	@FXML Button loginBtn;
	
	
	//login account as administrator/root on mySQL
	@FXML public void getConnection(ActionEvent e) throws SQLException{
		System.out.println("Test");
		//Set text fields as userName and Password:
		String userName;
		String password;
		userName = userNameTxt.getText().toString();
		password = passwordTxt.getText().toString();

		
		//get connection
		Connection connectMe = DriverManager.getConnection("jdbc:mysql://localhost:3306/exampledatabase1?verifyServerCertificate=false&useSSL=true", userName, password);
		System.out.println("Connected bes.");
		
		Statement mySqlStatement = connectMe.createStatement();
		
		ResultSet mySqlResultStatement = mySqlStatement.executeQuery("SELECT * FROM employee");
		
		//outputresultset
		while(mySqlResultStatement.next()){
			System.out.println(mySqlResultStatement.getInt("empId") + ", " + mySqlResultStatement.getString("emp_LastName")
			+ ", " + mySqlResultStatement.getString("emp_FirstName"));
		}
		
		
		
				
	}
	
}
