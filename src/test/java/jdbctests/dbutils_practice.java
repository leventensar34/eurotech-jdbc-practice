package jdbctests;

import org.testng.annotations.Test;
import utilities.DBUtils;

import java.util.List;
import java.util.Map;

public class dbutils_practice {

    @Test
    public void test1(){
        //create connection
        DBUtils.createConnection();

        //using method to get result as a list of maps
        List<Map<String, Object>> queryResult =  DBUtils.getQueryResultMap("SELECT customernumber,customername FROM customers");

        //printing the result
       for (Map<String, Object> map: queryResult){
           System.out.println(map.toString());
       }


        //close connection
        DBUtils.destroy();
    }

    @Test
    public void test2(){
        //create connection
        DBUtils.createConnection();

        //using method to get result as a list of maps
        Map<String, Object> rowMap =  DBUtils.getRowMap("SELECT customerNumber,customerName,contactLastName,contactFirstName,\n" +
                                            "phone,addressLine1,addressLine2,city_id,town_id,postalCode,country_id,\n" +
                                            "salesRepEmployeeNumber,creditLimit FROM customers WHERE customerNumber = 146");

        System.out.println(rowMap.toString());

        //close connection
        DBUtils.destroy();
    }
}
