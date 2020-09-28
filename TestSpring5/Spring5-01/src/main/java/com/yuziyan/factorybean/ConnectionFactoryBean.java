package com.yuziyan.factorybean;

import org.springframework.beans.factory.FactoryBean;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 * Spring提供的用来创建复杂对象的方式
 */
public class ConnectionFactoryBean implements FactoryBean<Connection> {

    private String driverClassName;
    private String url;
    private String username;
    private String password;

    public Connection getObject() throws Exception {
        Class.forName(driverClassName);
        Connection conn = DriverManager.getConnection(url, username, password);
        return conn;
    }

    public Class<?> getObjectType() {
        return Connection.class;
    }

    public boolean isSingleton() {
        return false;
    }

    public String getDriverClassName() {
        return driverClassName;
    }

    public void setDriverClassName(String driverClassName) {
        this.driverClassName = driverClassName;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
