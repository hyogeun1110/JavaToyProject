package main.java;

public class DBInfo {
    static String DB_USER = "root";
    static String DB_PW = "1234";

    static String DB_DRIVER = "org.mariadb.jdbc.Driver";
    static String DB_IP = "localhost";
    static String DB_PORT = "3306";
    static String DB_NAME = "test";

    static String DB_URL ="jdbc:mariadb://" + DB_IP + ":" + DB_PORT + "/" + DB_NAME;

}
