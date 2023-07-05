package practice;

import db.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class AccountUpdate {
    public static void main(String[] args) {
        Connection conn = DBConnection.getInstance();

        try {
            String sql = "UPDATE account_tb SET account_balance = account_balance + ? WHERE account_number = ?";

            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setInt(1, 900); // 첫 번째 인덱스에 900 바인딩
            statement.setInt(2, 1111); // 두 번째 인덱스에 1111 바인딩

            int result = statement.executeUpdate();
            System.out.println("결과: " + result);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

//public class AccountUpdate {
//    public static void main(String[] args) {
//        Connection conn = DBConnection.getInstance();
//
//        try {
//            String sql = "update account_tb set account_balance = account_balance + ? where account_number = ?";
//
//            PreparedStatement statement = conn.prepareStatement(sql);
//            statement.setInt(1, 900);
//            statement.setInt(2, 1111);
//
//            int result = statement.executeUpdate(); // flush (변경된 row 카운트를 응답)
//            System.out.println("결과 : " + result);
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//    }
//}
