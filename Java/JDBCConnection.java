import java.sql.*;

class JDBCConnection {
    public static void main(String args[]) {

        String url = "jdbc:mysql://localhost:3306/college";
        String user = "root";
        String password = "Ashok@8465";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection conn = DriverManager.getConnection(url, user, password);

            Statement st = conn.createStatement();

            ResultSet rs = st.executeQuery("SELECT * FROM java");

            while (rs.next()) {
                System.out.println(
                    rs.getInt("id") + " " +
                    rs.getString("name") + " " +
                    rs.getInt("age")
                );
            }

            conn.close();
        }
        catch (Exception e) {
            System.out.println(e);
        }
    }
}