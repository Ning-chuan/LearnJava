package dao;

import pool.ConnectionPool;

import java.sql.Connection;

public class StudentDao {

    //新增记录的方法
    public void insert(){
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection conn = pool.getMyConnection();

    }
}
