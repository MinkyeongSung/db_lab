package dao;

import db.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

// DB 접근 미들웨어
// SRP (Single Responsibility Principle) 단일책임의 원칙
// Data Access Object
public class AccountDAO {
    public void insert(int accountNumber, String accountPassword, int balance) {
        Connection conn = DBConnection.getInstance();

        try {
            String sql = "insert into account_tb" +
                    "(account_number, account_password, account_balance, account_created_at) " +
                    " values(?, ?, ?, now())";

            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setInt(1, accountNumber);
            statement.setString(2, accountPassword);
            statement.setInt(3, balance);

            int result = statement.executeUpdate(); // flush (변경된 row 카운트를 응답)
            System.out.println("결과: " + result);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void update() {
        // 업데이트 로직 구현
    }

    public void delete() {
        // 삭제 로직 구현
    }

    public void selectOne() {
        // 단일 조회 로직 구현
    }

    public void selectAll() {
        // 전체 조회 로직 구현
    }
}

//package dao;
//
//import db.DBConnection;
//
//import java.sql.Connection;
//import java.sql.PreparedStatement;
//import java.sql.SQLException;
//
//// DB 접근 미들웨어
//// SRP (Single Responsibility Principle) 단일책임의 원칙
//// Data Access Object
//public class AccountDAO {
//
//
//    public void insert(int accountNumber, String accountPassword, int balance){...}
//
//    public void update(){}
//    public void delete(){}
//    public void selectOne(){}
//    public void selectAll(){}
//
//
//    public void insert(int accountNumber, String accountPassword, int balance){
//        Connection conn = DBConnection.getInstance();
//
//        try {
//
//            String sql = "insert into account_tb" +
//                    "(account_number, account_password, account_balance, account_created_at) " +
//                    " values(:accountNumber, :accountPassword,:balance,now())";
//
//            PreparedStatement statement = conn.prepareStatement(sql);
//            statement.setInt(1, 1111);
//            statement.setString(2, "1234");
//            statement.setInt(3, 1000);
//
//            int result = statement.executeUpdate(); // flush (변경된 row 카운트를 응답)
//            System.out.println("결과 : "+result);
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//    }
//}
