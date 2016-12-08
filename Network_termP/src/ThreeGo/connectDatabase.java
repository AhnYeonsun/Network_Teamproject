package ThreeGo;
  
import java.sql.*;

public class connectDatabase {
   public int quesNum;
   public int id;
   public String question;
   public String Answer;
   
   public connectDatabase(int qNum){
      quesNum = qNum;
      initDB();
   }
   
   //연결 정보가 들어있다. sql에 로그인할 경우
   public static Connection makeConnection() {
      String url = "jdbc:mysql://127.0.0.1:3306/game";
      String id = "root";
      String password = "12345";
      Connection con = null;
      
      try {
         Class.forName("org.gjt.mm.mysql.Driver");
         //System.out.println("드라이버 검색 성공 !");
      }
      catch(ClassNotFoundException e) {
         //System.out.println("드라이버 검색 실패 !");
      }
      try {
         con = DriverManager.getConnection(url, id, password);
         //System.out.println("My-SQL 접속 성공!!");
      }catch(SQLException e) {
         //System.out.println("My-SQL 접속 실패");
      }
      return con;
   }
   public void initDB(){
      try{
         Connection con = makeConnection();
         Statement stmt = con.createStatement();
         //해당 퀴즈의 넘버를 찾아서 rs에 값을 넣어준다. 
         ResultSet rs = stmt.executeQuery("SELECT * FROM bingo" + " WHERE ID=\'" + quesNum+"\'");
         
         //여기서 Question은 문제에 answer는 answer에 넣어준다.
         while(rs.next()){
            id = rs.getInt("ID");
            question = rs.getString("QUESTION");
            Answer = rs.getString("ANSWER");
         }
      }catch(SQLException e){
         e.printStackTrace();
      }
   }
}
