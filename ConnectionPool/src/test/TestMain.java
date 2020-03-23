package test;

import java.sql.DriverManager;

public class TestMain {
    public static void main(String[] args) throws Exception {
        Class.forName("com.mysql.cj.jdbc.Driver");
        DriverManager.getConnection("jdbc:","root","root");
    }
}
