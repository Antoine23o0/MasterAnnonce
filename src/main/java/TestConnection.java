
import db.ConnectionDB;
import java.sql.Connection;

public class TestConnection {
    public static void main(String[] args) {
        try {
            Connection connection = ConnectionDB.getInstance();
            if (connection != null) {
                System.out.println("Test de connexion réussi !");
            } else {
                System.out.println("Test de connexion échoué !");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
