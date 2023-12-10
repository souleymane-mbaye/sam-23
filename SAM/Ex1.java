import java.sql.*;

public class Ex1 {
  public static void main(String[] args) {

    String url = "jdbc:h2:tcp://localhost:9093/~/base1";
    String usr = "moi";
    String pwd = "";
    try {
      Connection connection = DriverManager.getConnection(url, usr, pwd);
      Statement statement = connection.createStatement();
      ResultSet rs = statement.executeQuery("SELECT * FROM GARAGE");
      while (rs.next()) {
        System.out.print("ID: " + rs.getString("idgarage") + " Nom: " + rs.getString("nom"));
        System.out.println(" Ville: " + rs.getString("ville") + " Ferme: " + rs.getString("jourdefermeture"));
      }
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }
}