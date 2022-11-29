package main.java;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws Exception {
        try {
            DBConn.getInstance().getConn();


        } catch (Exception e) {
            throw new Exception(e);
        } finally {
            try {
                DBConn.getInstance().closeConn();
            } catch (SQLException e) {}
        }
    }
}