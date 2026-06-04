import java.sql.*;

class Transaction {

    public static void main(String[] args) {

        String url = "jdbc:mysql://localhost:3306/college";
        String user = "root";
        String password = "root";

        try {
            Connection con =
                DriverManager.getConnection(url, user, password);

               con.setAutoCommit(false);

            PreparedStatement debit =
                con.prepareStatement(
                    "UPDATE accounts SET balance = balance - ? WHERE id = ?"
                );

            PreparedStatement credit =
                con.prepareStatement(
                    "UPDATE accounts SET balance = balance + ? WHERE id = ?"
                );

            double amount = 1000;

            debit.setDouble(1, amount);
            debit.setInt(2, 1);
            debit.executeUpdate();

            credit.setDouble(1, amount);
            credit.setInt(2, 2);
            credit.executeUpdate();

            con.commit();

            System.out.println("Transaction Successful");

            con.close();

        } catch (Exception e) {
            System.out.println(e);
        }
    }
}