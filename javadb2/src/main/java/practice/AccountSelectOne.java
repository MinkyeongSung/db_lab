package practice;

import db.DBConnection;
import model.Account;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class AccountSelectOne {

    public static void main(String[] args) {
        Account account = null;
        Connection conn = DBConnection.getInstance();

        try {
            String sql = "select * from account_tb where account_number = ?";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setInt(1, 1111);

            ResultSet rs = statement.executeQuery();

            if(rs.next()){
                account = new Account(
                        rs.getInt("account_number"),
                        rs.getString("account_password"),
                        rs.getInt("account_balance"),
                        rs.getTimestamp("account_created_at")
                );
            }

            System.out.println("계좌번호: "+account.getAccountNumber());
            System.out.println("계좌비번: "+account.getAccountPassword());
            System.out.println("계좌잔액: "+account.getAccountBalance());
            System.out.println("계좌생성일: "+account.getAccountCreatedAt());

        }catch (Exception e){
            e.printStackTrace();
        }
    }
}

//package practice;
//
//import db.DBConnection;
//import model.Account;
//
//import java.sql.Connection;
//import java.sql.PreparedStatement;
//
//public class AccountSelectOne {
//    public static void main(String[] args) {
//        Connection conn = DBConnection.getInstance();
//
//        try {
//            String sql = "select * from account_tb where account_number = ?";
//            PreparedStatement statement = conn.prepareStatement(sql);
//            statement.setInt(1, 1111);
//
//            statement.executeQuery();
//
//            if(rs.next()){
//                Account account = new Account(
//                        rs.getInt("account_number"),
//                        rs.getString("account_password"),
//                        rs.getInt("account_balance"),
//                        rs.getTimestamp("account_created_at"));
//                )
//            }
//        }catch (Exception e){
//            e.printStackTrace();
//        }
//    }
//}
