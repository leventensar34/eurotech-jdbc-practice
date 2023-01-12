package jdbctests;

import java.sql.*;

public class Main {
    public static void main(String[] args) throws SQLException, SQLException {
        String dbUrl = "jdbc:mysql://localhost:3306/ornekdb";
        String dbUsername = "root";
        String dbPassword = "Gs19052008";

        //create connection
        Connection connection = DriverManager.getConnection(dbUrl,dbUsername,dbPassword);
        // Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/ornekdb","root", "3292");

        //create statement object
        Statement statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);

        //run query and get result in resultset object
        ResultSet resultSet = statement.executeQuery("SELECT * FROM customers ");

        //move pointer to first row
        resultSet.next();

        // getting information with column name
        System.out.println(resultSet.getInt("customernumber") + "-" + resultSet.getString("customername"));

        //getting information with column index (starts from 1)
        System.out.println(resultSet.getInt(1) + "-" + resultSet.getString(2));
        //}

        //move pointer to second row
        resultSet.next();
        // getting information with column name
        System.out.println(resultSet.getInt("customernumber") + "-" + resultSet.getString("customername"));

        //getting information with column index (starts from 1)
        System.out.println(resultSet.getInt(1) + "-" + resultSet.getString(2));

        System.out.println(resultSet.getInt(1) + "-" + resultSet.getString("customername") + "-" + resultSet.getString("contactlastname")+resultSet.getString("contactfirstname"));

        //move pointer to third row
        resultSet.next();
        System.out.println(resultSet.getInt(1) + "-" + resultSet.getString("customername") + "-" + resultSet.getString("contactlastname")+resultSet.getString("contactfirstname"));

        System.out.println("--------------------------------------");
        resultSet.beforeFirst();
        while (resultSet.next()){
            System.out.println(resultSet.getInt(1)+" - "+resultSet.getString("customername"));
        }

        //close all connections
        resultSet.close();
        statement.close();
        connection.close();
    }
}
