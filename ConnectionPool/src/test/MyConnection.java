package test;

import java.sql.Connection;
import java.sql.DriverManager;

public class MyConnection {
    private Connection connection;
    private boolean canUsed = true;//初始值为true表示当前conn可用 false表示不可用
    static{
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    {
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/test?serverTimezone=CST","root","root");
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public Connection getConnection() {
        return connection;
    }

    public boolean isCanUsed() {
        return canUsed;
    }

    public void setCanUsed(boolean canUsed) {
        this.canUsed = canUsed;
    }
}
