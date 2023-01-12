package jdbctests;

import org.testng.annotations.Test;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class listofmap_example {
    String dbUrl = "jdbc:mysql://localhost:3306/ornekdb";
    String dbUsername = "root";
    String dbPassword = "Gs19052008";

    @Test
    public void MetaDataExample1() throws SQLException {
        //create connection
        Connection connection = DriverManager.getConnection(dbUrl,dbUsername,dbPassword);
        // Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/ornekdb","root", "3292");

        //create statement object
        Statement statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);

        //run query and get the result in resultset object
        ResultSet resultSet = statement.executeQuery("SELECT * FROM sales");

        //get the resultset object metadata
        ResultSetMetaData rsMetaData = resultSet.getMetaData();
        //list for keeping all rows a map
        List<Map<String, Object>> queryData = new ArrayList<>();

        Map<String, Object> row1 = new HashMap<>();
        row1.put("year", 2022);
        row1.put("country", "Central");
        row1.put("name", "Kivell");
        row1.put("product", "Pen Set");
        row1.put("units", 80);
        row1.put("unitcost", 25.21);
        row1.put("profit", 2016.80);

        System.out.println(row1.toString());

        Map<String, Object> row2 = new HashMap<>();
        row2.put("year", 2022);
        row2.put("country", "East");
        row2.put("name", "Jane");
        row2.put("product", "NoteBook");
        row2.put("units", 100);
        row2.put("unitcost", 3);
        row2.put("profit", 300);

        System.out.println(row2.toString());

        System.out.println(row2.get("product") + " " + row2.get("profit"));

        queryData.add(row1);
        queryData.add(row2);

        //get the kivell name directly from the list
        System.out.println(queryData.get(0).get("name"));

        //close all connections
        resultSet.close();
        statement.close();
        connection.close();
    }

    @Test
    public void MetaDataExample2() throws SQLException {
        //create connection
        Connection connection = DriverManager.getConnection(dbUrl,dbUsername,dbPassword);
        // Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/ornekdb","root", "3292");

        //create statement object
        Statement statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);

        //run query and get the result in resultset object
        ResultSet resultSet = statement.executeQuery("SELECT * FROM sales");

        //get the database related data inside the dbmetadata object
        DatabaseMetaData dbMetadata = connection.getMetaData();

        ResultSetMetaData rsMetadata = resultSet.getMetaData();

        //list for keeping all rows a map
        List<Map<String, Object>> queryData = new ArrayList<>();

        //move to first row
        resultSet.next();
        Map<String, Object> row1 = new HashMap<>();
        row1.put(rsMetadata.getColumnLabel(1), resultSet.getString(1));
        row1.put(rsMetadata.getColumnLabel(2), resultSet.getString(2));
        row1.put(rsMetadata.getColumnLabel(3), resultSet.getString(3));
        row1.put(rsMetadata.getColumnLabel(4), resultSet.getString(4));
        row1.put(rsMetadata.getColumnLabel(5), resultSet.getString(5));
        row1.put(rsMetadata.getColumnLabel(6), resultSet.getString(6));
        row1.put(rsMetadata.getColumnLabel(7), resultSet.getString(7));

        System.out.println(row1.toString());

        //move to second row
        resultSet.next();
        Map<String, Object> row2 = new HashMap<>();
        row2.put(rsMetadata.getColumnLabel(1), resultSet.getString(1));
        row2.put(rsMetadata.getColumnLabel(2), resultSet.getString(2));
        row2.put(rsMetadata.getColumnLabel(3), resultSet.getString(3));
        row2.put(rsMetadata.getColumnLabel(4), resultSet.getString(4));
        row2.put(rsMetadata.getColumnLabel(5), resultSet.getString(5));
        row2.put(rsMetadata.getColumnLabel(6), resultSet.getString(6));
        row2.put(rsMetadata.getColumnLabel(7), resultSet.getString(7));

        System.out.println(row2.toString());

        System.out.println(row2.get("product") + " " + row2.get("profit"));

        queryData.add(row1);
        queryData.add(row2);

        //get the kivell name directly from the list
        System.out.println(queryData.get(0).get("name"));

        //close all connections
        resultSet.close();
        statement.close();
        connection.close();
    }
}
