package ua.sustavov.payment.service;

import org.springframework.stereotype.Service;
import org.zkoss.zk.ui.Session;
import org.zkoss.zk.ui.Sessions;
import ua.sustavov.payment.model.User;

/**
 * Created by SUSTAVOV on 10.02.2018.
 */

@Service("authenticationService")
public class AuthenticationServiceImpl implements AuthenticationService {

    @Override
    public boolean login(String account, String password) {
        return false;
    }

    @Override
    public void logout() {

    }

    @Override
    public User getCurrentUser() {
        Session sess = Sessions.getCurrent();
        User currentUser = (User)sess.getAttribute("userCredential");
        if(currentUser==null){
            currentUser = new User();//new a anonymous user and set to session
            sess.setAttribute("currentUser", currentUser);
        }
        return currentUser;
    }
}
