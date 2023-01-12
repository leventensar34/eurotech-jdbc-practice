package jdbctests;

import org.testng.annotations.Test;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class dynamic_list {
    String dbUrl = "jdbc:mysql://localhost:3306/ornekdb";
    String dbUsername = "root";
    String dbPassword = "Gs19052008";

    @Test
    public void dynamic_list() throws SQLException {
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

        //number of columns
        int colCount = rsMetaData.getColumnCount();

        //loop through each row
        while (resultSet.next()){
            Map<String,Object> row = new HashMap<>();

            for (int i = 1; i <= colCount; i++) {

                //row.put(rsMetadata.getColumnLabel(1),resultset.getObject(1));
                row.put(rsMetaData.getColumnName(i), resultSet.getObject(i));
            }

            queryData.add(row);
        }

        //print the result
        for (Map<String, Object> row : queryData) {
            System.out.println(row.toString());
        }



        //close all connections
        resultSet.close();
        statement.close();
        connection.close();
    }
}
