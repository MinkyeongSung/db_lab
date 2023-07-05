package practice;

import db.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class AccountInsert {

    public static void main(String[] args) {
        // 1. DB 연결
        Connection conn = DBConnection.getInstance();

        // 2. 버퍼로 SQL 쓰기
        try {
            String sql = "insert into account_tb(account_number, account_password, account_balance, account_created_at) values(?,?,?,now())";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setInt(1, 1111);
            statement.setString(2, "1234");
            statement.setInt(3, 1000);

            int result = statement.executeUpdate(); // flush (변경된 row 카운트를 응답)
            System.out.println("결과 : "+result);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}