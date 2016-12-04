package ThreeGo;
  
import java.sql.*;

public class connectDatabase {
	public int quesNum;
	public int id;
	public String question;
	public String answer;
	
	public connectDatabase(int qNum){
		quesNum = qNum;
		initDB();
	}
	
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
	public void initDB(){
		try{
			Connection con = makeConnection();
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM bingo" + " WHERE ID=\'" + quesNum+"\'");
			
			while(rs.next()){
				id = rs.getInt("ID");
				question = rs.getString("QUESTION");
				answer = rs.getString("ANSWER");
			}
		}catch(SQLException e){
			e.printStackTrace();
		}
	}
}

