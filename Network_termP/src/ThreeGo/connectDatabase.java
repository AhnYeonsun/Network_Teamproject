package ThreeGo;

import java.sql.*;
import javax.net.ssl.SSLContext;
import javax.*;
public class connectDatabase {
	public static int id;
	public static String question;
	public static String answer;
	
	public static Connection makeConnection() {
		String url = "jdbc:mysql://127.0.0.1:3306/game";
		String id = "root";
		String password = "12345";
		Connection con = null;

		try {
			Class.forName("org.gjt.mm.mysql.Driver");
			System.out.println("����̹� �˻� ���� !");
		}
		catch(ClassNotFoundException e) {
			System.out.println("����̹� �˻� ���� !");
		}
		try {
			con = DriverManager.getConnection(url, id, password);
			System.out.println("My-SQL ���� ����!!");
		}catch(SQLException e) {
			System.out.println("My-SQL ���� ����");
		}
		return con;
	}
	public static void main(String[] args){
		try{
			Connection con = makeConnection();
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT* FROM game");
			
			while(rs.next()){
				id = rs.getInt("ID");
				question = rs.getString("QUENSTION");
				answer = rs.getString("ANSWER");
			}
		}catch(SQLException e){
			e.printStackTrace();
		}
	}
}
