package db;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {
    //IP랑 포트 앞에 무조건 프로토콜을 적어준다. (어떤방식으로 통신할지를 정해야함 예: http)
    public static Connection getInstance() {
        // MySQL 연결 정보
        String url = "jdbc:mysql://localhost:3306/metadb"; //만드는 사람이 정하는거라 의미 x
        String username = "root";
        String password = "1234";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver"); //class내부의 static을 실행.
            Connection connection = DriverManager.getConnection(url, username, password);
            System.out.printf("DB 연결 성공");
            return connection; // DBMS에 sql문을 전송할 수 있음 : 프로토콜이 적용된 소켓
        } catch (Exception e) {
            System.out.println("DB 연결 실패 : " + e.getMessage());
        }

        return null;
    }

    public static void main(String[] args) {
        getInstance();
    }
}
