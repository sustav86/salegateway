package ua.sustavov.payment.service;

import ua.sustavov.payment.model.User;

/**
 * Created by SUSTAVOV on 10.02.2018.
 */

public interface AuthenticationService {

    boolean login(String account, String password);

    void logout();

    User getCurrentUser();
}
