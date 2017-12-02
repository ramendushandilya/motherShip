package corejava.jdbc;

import java.sql.*;

/**
 * Created by failedOptimus on 02-12-2017.
 */
public class JdbcTest {

    public static  void main(String[] args) {
        Connection connection = null;
        try {
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/jdbc_learn","postgres","1qazxsw2");
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM public.\"Chips\"");
            while (resultSet.next()) {
                System.out.println(resultSet.getInt(1)+resultSet.getString(2));
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException exception) {
            exception.printStackTrace();
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
