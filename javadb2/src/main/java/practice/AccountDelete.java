package practice;

import db.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class AccountDelete {
    public void deleteAccount(int accountNumber) {
        Connection conn = DBConnection.getInstance();

        try {
            String sql = "DELETE FROM account_tb WHERE account_number = ?";

            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setInt(1, accountNumber);

            int result = statement.executeUpdate();
            System.out.println("계좌 삭제 결과: " + result);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

//import model.account.AccountDAO;
//        import java.sql.SQLException;
//public class AccountDelete {
//    public static void main(String[] args) {
//        Connection connection = DBConnection.getInstance();
//        AccountDAO accountDAO = new AccountDAO(connection);
//        try {
//            accountDAO.deleteAccount("1111");
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//    }
//}
