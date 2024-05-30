package module;

//import java.sql.Statement;
import java.util.Scanner;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class StudentDb {

	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Scanner sc = new Scanner(System.in);
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc", "root", "Sa123");
//			String qurey="insert into student(namel,pecentage,address) values('john',78,'mysore')";
//			Statement statement = connection.createStatement();
//             statement.execute(qurey);

			String query = "insert into student(namel,pecentage,address) values(?,?,?)";
			PreparedStatement preparedStatement = connection.prepareStatement(query);

			System.out.println("enter name");
			preparedStatement.setString(1, sc.next());

			System.out.println("enter percentage");
			preparedStatement.setDouble(2, sc.nextDouble());

			System.out.println("enter address");
			preparedStatement.setString(3, sc.next());
			int ex = preparedStatement.executeUpdate();
			System.out.println(ex);
			sc.close();
			connection.close();
		} catch (ClassNotFoundException | SQLException e) {

			e.printStackTrace();
		}
	}

}
