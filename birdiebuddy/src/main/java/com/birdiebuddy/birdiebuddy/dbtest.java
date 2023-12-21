package com.birdiebuddy.birdiebuddy;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class dbtest {
    public static void main(String[] args){
        Connection con = null;

        String server = "localhost"; // MySQL 서버 주소
        String database = "birdiebuddy"; // MySQL DATABASE 이름
        String user_name = "root"; //  MySQL 서버 아이디
        String password = "Kjy1234!"; // MySQL 서버 비밀번호

        // 1.드라이버 로딩
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.err.println(" !! <JDBC 오류> Driver load 오류: " + e.getMessage());
            e.printStackTrace();
        }

        // 2.연결
        try {
            String url = "jdbc:mysql://" + server + "/" + database+"?serverTimezone=UTC";
            con = DriverManager.getConnection(url, user_name, password);
            System.out.println(con.toString());
            System.out.println("정상적으로 연결되었습니다.");
        } catch(SQLException e) {
            System.err.println("con 오류:" + e.getMessage());
            System.err.println("SQLState: "+e.getSQLState());
            System.err.println("VendorError: "+e.getErrorCode());
            e.printStackTrace();
        }

        // 3.해제
        try {
            if(con != null)
                con.close();
        } catch (SQLException e) {}
    }


}
