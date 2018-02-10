package ua.sustavov.payment;

import org.zkoss.bind.annotation.Command;
import org.zkoss.zk.ui.Executions;
import org.zkoss.zk.ui.Page;
import org.zkoss.zk.ui.select.Selectors;
import org.zkoss.zk.ui.select.annotation.VariableResolver;
import org.zkoss.zk.ui.select.annotation.WireVariable;
import org.zkoss.zk.ui.util.Initiator;
import ua.sustavov.payment.service.AuthenticationService;

import java.io.IOException;
import java.util.Map;

/**
 * Created by SUSTAVOV on 10.02.2018.
 */

@VariableResolver(org.zkoss.zkplus.spring.DelegatingVariableResolver.class)
public class AuthenticationInit implements Initiator {

    @WireVariable
    AuthenticationService authenticationService;

    @Override
    public void doInit(Page page, Map<String, Object> map) throws Exception {

        Selectors.wireVariables(page, this, Selectors.newVariableResolvers(getClass(), null));

        authenticationService.getCurrentUser();
    }

    @Command
    public void returnHome() throws IOException {
        Executions.sendRedirect("/index.zul");
    }
}
