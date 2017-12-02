package corejava.jdbc;

import java.sql.*;

/**
 * Created by failedOptimus on 02-12-2017.
 * Steps required to connect Java app with any kind of SQL (Postgres for example in our case)
 * Step 1: Register the Driver Class
 * Step 2: Create the connection object
 * Step 3: Create the statement object
 * Step 4: Execute the query
 * Step 5: Close the connection
 */
public class JdbcTest {

    /**
     * Forks the connection to database
     * @return connection object
     */
    public static Connection forkConnection() {
        Connection connection = null;
        try {
            Class.forName("org.postgresql.Driver"); //Step 1
            connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/jdbc_learn","postgres",
                    "1qazxsw2"); //Step 2
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }

    /**
     * Insert records into the table
     * @param id
     * @param name
     */
    public static void insertRecords(int id, String name) {
        try {
            String insertSql = "INSERT INTO public.\"Chips\"(\n" +
                    "\tuid, \"Name\")\n" +
                    "\tVALUES (?, ?);";
            PreparedStatement preparedStatement = forkConnection().prepareStatement(insertSql); //Step 3
            preparedStatement.setInt(1, id);
            preparedStatement.setString(2, name);
            if(preparedStatement.executeUpdate() == 1) { //Step 4
                System.out.println("One row affected, added successfully");
            } else {
                System.out.println("No rows affected, nothing added");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Fetch the records from the table
     */
    public static void fetchRecords() {
        try {
            Statement statement = forkConnection().createStatement(); //Step 3
            String fetchSql = "SELECT * from public.\"Chips\"";
            ResultSet resultSet = statement.executeQuery(fetchSql); //Step 4
            while(resultSet.next()) {
                System.out.println(resultSet.getInt(1)+"->"+resultSet.getString(2));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static  void main(String[] args) {
        fetchRecords();
        insertRecords(4,"Zdrousky Chips");
    }
}
