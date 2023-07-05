package model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;
import java.sql.Timestamp;

@ToString
@Getter
@AllArgsConstructor

public class Account {
    private int accountNumber;
    private String accountPassword;
    private int accountBalance;
    private Timestamp accountCreatedAt;
}
