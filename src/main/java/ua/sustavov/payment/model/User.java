package ua.sustavov.payment.model;

import lombok.Data;
import lombok.ToString;

import java.io.Serializable;

/**
 * Created by SUSTAVOV on 10.02.2018.
 */
@Data
@ToString
public class User implements Serializable {

    private String account;
    private String userName;
    private String password;

    public User(String account, String userName, String passsword) {
        this.account = account;
        this.userName = userName;
        this.password = passsword;
    }

    public User() {
        this.account = "current";
        this.userName = "829000";
        this.password = "TestNt62400~";
    }

//    public String getAccount() {
//        return account;
//    }
//
//    public String getUserName() {
//        return userName;
//    }
//
//    public String getPassword() {
//        return password;
//    }
}
