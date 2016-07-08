package Demo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 * Created by cerebro on 08/07/16.
 */


public class Demo {
    public static void main(String[] args) {

        try {
            Class.forName("org.sqlite.JDBC");
            System.out.println("Sqlite JDBC found");
        } catch (ClassNotFoundException e) {
            System.out.println("Please download JDBC from http://....");
        }

        try {
            Connection connection = DriverManager.getConnection("jdbc:sqlite:src/Demo/codekamp.sqlite");

            Statement statement = connection.createStatement();
            ResultSet resultset = statement.executeQuery("SELECT * FROM students");


            while (resultset.next()) {
                System.out.println("name is " + resultset.getString("name"));
                System.out.println("age is " + resultset.getInt("age"));
            }

            Statement statement1 = connection.createStatement();
            statement1.execute("INSERT INTO students (name, email, age) VALUES ('Suresh', 'suresh@gmail.com', 19)");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
