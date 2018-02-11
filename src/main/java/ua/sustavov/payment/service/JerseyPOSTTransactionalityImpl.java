package ua.sustavov.payment.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.base.Joiner;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import org.springframework.stereotype.Service;
import org.zkoss.zk.ui.Executions;
import ua.sustavov.payment.model.Card;
import ua.sustavov.payment.model.Transaction;
import com.sun.jersey.api.client.Client;
import ua.sustavov.payment.model.User;

import javax.ws.rs.core.MediaType;
import java.util.Map;

/**
 * Created by SUSTAVOV on 08.02.2018.
 */

@Service("transaction")
public class JerseyPOSTTransactionalityImpl implements Transactionality {

    private static String BASE_URL = "https://sandbox-secure.unitedthinkers.com/gates/xurl";

    private AuthenticationService authenticationService = new AuthenticationServiceImpl();

    @Override
    public String sale(Card card, Transaction transaction) {

        Client client = Client.create();
        WebResource webResource = client.resource(BASE_URL);
        User currentUser = authenticationService.getCurrentUser();

        ObjectMapper objectMapper = new ObjectMapper();

        Map<String, String> map = objectMapper.convertValue(transaction, Map.class);
        map.put("userName", currentUser.getUserName());
        map.put("password", currentUser.getPassword());
        map.put("requestType", map.getOrDefault("requestType", "sale").toLowerCase());

        StringBuilder mapJoined = Joiner.on("&").useForNull("").withKeyValueSeparator("=")
                .appendTo(new StringBuilder(), map);

        ClientResponse response = webResource.type(MediaType.APPLICATION_FORM_URLENCODED)
                .post(ClientResponse.class, mapJoined.toString());

        System.out.println(response);

        if (response.getStatus() == 200) {
            Executions.sendRedirect("/pages/success.zul");
        }

        return response.toString();

    }


}
