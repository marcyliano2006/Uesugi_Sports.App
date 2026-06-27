import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class Koneksi {
    private static Connection mysqlconfig;
    
    public static Connection configDB() throws SQLException {
        if (mysqlconfig == null) {
            try {
                String url = "jdbc:mysql://localhost:3306/db_uesugi_sports";
                String user = "root";
                String pass = ""; 
                
                Class.forName("com.mysql.cj.jdbc.Driver");
                
                mysqlconfig = DriverManager.getConnection(url, user, pass);            
            } catch (ClassNotFoundException e) {
                JOptionPane.showMessageDialog(null, "Driver Tidak Ditemukan: " + e.getMessage());
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "Koneksi Database Gagal: " + e.getMessage());
            }
        }
        return mysqlconfig;
    }
}