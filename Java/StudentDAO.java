import java.sql.*;

public class StudentDAO {

    public static void main(String[] args) {

        String url = "jdbc:mysql://localhost:3306/college";
        String user = "root";
        String password = "root";

        try {
            Connection con = DriverManager.getConnection(url, user, password);

            String insertQuery =
                "INSERT INTO students(id, name, age) VALUES(?, ?, ?)";

            PreparedStatement ps1 =
                con.prepareStatement(insertQuery);

            ps1.setInt(1, 101);
            ps1.setString(2, "Surya");
            ps1.setInt(3, 20);

            ps1.executeUpdate();

            String updateQuery =
                "UPDATE students SET age=? WHERE id=?";

            PreparedStatement ps2 =
                con.prepareStatement(updateQuery);

            ps2.setInt(1, 21);
            ps2.setInt(2, 101);

            ps2.executeUpdate();

            System.out.println("Insert and Update Successful");

            con.close();

        } 
        catch (Exception e) 
        {
            System.out.println(e);
        }
    }
}