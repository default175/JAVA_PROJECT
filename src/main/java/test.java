import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class test {
    public static void main(String[] args) {
        String connectionUrl = "jdbc:postgresql://localhost:5432/postgres";
        Connection con = null;
        ResultSet rs = null;
        Statement stmt = null;
        try {
            Class.forName("org.postgresql.Driver");

            con = DriverManager.getConnection(connectionUrl, "postgres", "3789");
            stmt = con.createStatement();

            rs = stmt.executeQuery("select * from student");

            while (rs.next())
                System.out.println(rs.getString("name"));
        }catch (Exception aae){
            aae.printStackTrace();
        }
    }
}
