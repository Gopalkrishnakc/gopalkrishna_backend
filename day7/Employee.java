package module;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Employee {
	private static Connection connection;
	private static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		Employee emp = new Employee();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/jdbc";
			String user = "root";
			String pasw = "Sa123";
			connection = DriverManager.getConnection(url, user, pasw);
			System.out.println("please select choice for operation");
			System.out.println("select 1 for insert data");
			System.out.println("select 2 for select data by id");
			System.out.println("select 3 for selectAll data");
			System.out.println("select 4 for update data");
			int choice = sc.nextInt();
			switch (choice) {
			case 1: {
				emp.insertRecord();
				break;
			}
			case 2: {
				emp.selectRecord();
				break;
			}

			case 3: {
				emp.selectRecordDetails();
				break;
			}

			case 4: {
				emp.updateRecord();
				break;
			}
			}

		} catch (ClassNotFoundException | SQLException e) {
		
			e.printStackTrace();
		}

	}

	private void updateRecord() throws SQLException {
		System.out.println("enter a empId for result");
		int number=Integer.parseInt(sc.next());
	      String query="select* from employee where id="+number;
	      Statement statement=connection.createStatement();
	      ResultSet resultSet=statement.executeQuery(query);
	      if(resultSet.next()) {
	    	  int empid=resultSet.getInt("id");
	    	  String empname=resultSet.getString("name");
	    	  Double empsal=resultSet.getDouble("sal");
	    	  String empdeptname=resultSet.getString("deptname");
	    	  
	    	  System.out.println("id :"+empid);
	    	  
	    	  System.out.println("name :"+empname);
	    	  
	    	  System.out.println("sal :"+empsal);
	    	  System.out.println("deptname :"+empdeptname);
	      }else {
	    	  System.out.println("no record found!!");
	      }
	      System.out.println("select 1 for update emname");
	      System.out.println("select 2 for update empsal");
	      System.out.println("select 3 for update deptname");
	      System.out.println("select 4 for update delete record");
	      int choice=sc.nextInt();
	      String updatequery="update employee set";
	      switch (choice) {
		case 1:{
			System.out.println("enter a new name");
			String name=sc.next();
			updatequery=updatequery +" name=? where id="+number;
			PreparedStatement preparedStatement=connection.prepareStatement(updatequery);
			preparedStatement.setString(1, name);
			break;
		     }
		case 2:{
			System.out.println("enter a new sal");
			Double sal=sc.nextDouble();
			updatequery=updatequery +" sal=? where id="+number;
			PreparedStatement preparedStatement1=connection.prepareStatement(updatequery);
			preparedStatement1.setDouble(2, sal);
			break;
		     }
		case 3:{
			System.out.println("enter a new deptname");
			String deptname=sc.next();
			updatequery=updatequery +" deptname=? where id="+number;
			PreparedStatement preparedStatement2=connection.prepareStatement(updatequery);
			preparedStatement2.setString(1, deptname);
			break;
		     }
		case 4:{
			System.out.println("enter a id to delete row");
			int id=sc.nextInt();
			String query1="delete from employee where id="+id;
			Statement statement1=connection.createStatement();
			int record=statement1.executeUpdate(query1);
			System.out.println(record);
			break;
		     }
		default:
			break;
		}
	}

	private void selectRecordDetails() throws SQLException {

	      String query="select* from employee ";
	      Statement statement=connection.createStatement();
	      ResultSet resultSet=statement.executeQuery(query);
	      while(resultSet.next()) {
	    	  int empid=resultSet.getInt("id");
	    	  String empname=resultSet.getString("name");
	    	  Double empsal=resultSet.getDouble("sal");
	    	  String empdeptname=resultSet.getString("deptname");
	    	  
	    	  System.out.println("id :"+empid);
	    	  
	    	  System.out.println("name :"+empname);
	    	  
	    	  System.out.println("sal :"+empsal);
	    	  System.out.println("deptname :"+empdeptname);
	      }

	}

	private void selectRecord() throws SQLException {
	System.out.println("enter a empId for result");
	int number=Integer.parseInt(sc.next());
      String query="select* from employee where id="+number;
      Statement statement=connection.createStatement();
      ResultSet resultSet=statement.executeQuery(query);
      if(resultSet.next()) {
    	  int empid=resultSet.getInt("id");
    	  String empname=resultSet.getString("name");
    	  Double empsal=resultSet.getDouble("sal");
    	  String empdeptname=resultSet.getString("deptname");
    	  
    	  System.out.println("id :"+empid);
    	  
    	  System.out.println("name :"+empname);
    	  
    	  System.out.println("sal :"+empsal);
    	  System.out.println("deptname :"+empdeptname);
      }else {
    	  System.out.println("no record found!!");
      }
    	  
	}

	private void insertRecord() throws SQLException {
		String qurey="insert into employee(name,sal,deptname) values (?,?,?)";
		PreparedStatement preparedStatement=connection.prepareStatement(qurey);
		while(true) {
			System.out.println("enter a name");
			preparedStatement.setString(1,sc.next());
			System.out.println("enter a sal");
			preparedStatement.setDouble(2,sc.nextDouble());
			System.out.println("enter a deptname");
			preparedStatement.setString(3,sc.next());
			
			int row = preparedStatement.executeUpdate();
			System.out.println(row);
			System.out.println("need to add data into row ?");
			String response=sc.next();
			if(response.equalsIgnoreCase("no")) {
				break;
			}
			
		}

	}
}
