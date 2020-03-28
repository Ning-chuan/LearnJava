package pool;

import java.sql.*;

public class MyConnection extends ConnectionAdapter {
    private Connection connection;
    private boolean canUsed = true;//初始值为true表示当前conn可用 false表示不可用

    private static String Driver;
    private static String url;
    private static String userName;
    private static String password;
    static{

        try {
            Driver = ConfigurationReader.getString("Driver");
            url = ConfigurationReader.getString("url");
            userName = ConfigurationReader.getString("userName");
            password = ConfigurationReader.getString("password");
            Class.forName(Driver);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    {
        try {
            connection = DriverManager.getConnection(url,userName,password);
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

    //================================================================================

    @Override
    public void close() throws SQLException {
        this.canUsed = true;
    }

    @Override
    public Statement createStatement() throws SQLException {
        return connection.createStatement();
    }

    @Override
    public PreparedStatement prepareStatement(String sql) throws SQLException {
        return connection.prepareStatement(sql);
    }
}
