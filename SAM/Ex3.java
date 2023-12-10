import java.sql.*;

public class Ex2 {
  public static void main(String[] args) {

    String url_1 = "jdbc:h2:tcp://localhost:9093/~/base1";
    String url_2 = "jdbc:h2:tcp://localhost:9094/~/base2";
    String usr = "moi";
    String pwd = "";
    try {
      Connection connection_1 = DriverManager.getConnection(url_1, usr, pwd);
      Connection connection_2 = DriverManager.getConnection(url_2, usr, pwd);

      Statement statement_g = connection_1.createStatement();
      Statement statement_h = connection_2.createStatement();

      ResultSet garage = statement_g.executeQuery("SELECT * FROM GARAGE ORDER BY idgarage");
      ResultSet habilite = statement_h.executeQuery("SELECT * FROM HABILITE ORDER BY idgarage");

      garage.next();
      habilite.next();
      while (true) {
        if(garage.getString("idgarage").equals(habilite.getString("idgarage"))) {
          System.out.println(" idgarage: " + garage.getString("idgarage") + " marque: " + personne.getString("marque")+ "Age: " + personne.getString("age"));
        }
      }
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }
}