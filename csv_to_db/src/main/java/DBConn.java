package main.java;

import java.sql.*;

public class DBConn {
    public static DBConn dbConn;

    Connection conn;

    public static DBConn getInstance(){
        if(dbConn == null){
            dbConn = new DBConn();
        }
        return dbConn;
    }

    public Connection getConn() throws ClassNotFoundException, SQLException {
        if (conn == null){
            Class.forName(DBInfo.DB_DRIVER);
            conn = DriverManager.getConnection(DBInfo.DB_URL, DBInfo.DB_USER, DBInfo.DB_PW);
        }
        System.out.println("DB 연결 성공");
        return conn;
    }

    public void closeConn() throws SQLException {
        if (!conn.isClosed()){
            conn.close();
        }
    }

}
