import java.sql.*;

public class Ex2 {
  public static void main(String[] args) {

    String url = "jdbc:h2:tcp://localhost:9093/~/base1";
    String usr = "moi";
    String pwd = "";
    try {
      Connection connection = DriverManager.getConnection(url, usr, pwd);
      Statement statement = connection.createStatement();
      ResultSet mecanicien = statement.executeQuery("SELECT * FROM MECANICIEN");
      while (mecanicien.next()) {
        Statement statement_p = connection.createStatement();
        ResultSet personne = statement_p.executeQuery("SELECT * FROM PERSONNE");
        while(personne.next()) {
          if(mecanicien.getString("idpers").equals(personne.getString("idpers"))) {
            System.out.println(" Nom: " + personne.getString("nom") + " Prenom: " + personne.getString("prenom")+ "Age: " + personne.getString("age"));
          }
        }
      }
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }
}