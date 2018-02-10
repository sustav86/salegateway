package ua.sustavov.payment.service;

import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import org.springframework.stereotype.Service;
import org.zkoss.zk.ui.Executions;
import ua.sustavov.payment.model.Card;
import ua.sustavov.payment.model.Transaction;
import com.sun.jersey.api.client.Client;

import javax.ws.rs.core.MediaType;

/**
 * Created by SUSTAVOV on 08.02.2018.
 */

@Service("transaction")
public class JerseyPOSTTransactionalityImpl implements Transactionality {

    private static String BASE_URL = "https://sandbox-secure.unitedthinkers.com/gates/xurl";

    @Override
    public String sale(Card card, Transaction transaction) {

        Client client = Client.create();
        WebResource webResource = client.resource(BASE_URL);

        ClientResponse response = webResource.type(MediaType.APPLICATION_FORM_URLENCODED)
                .post(ClientResponse.class, transaction.toPOSTString());

        if (response.getStatus() == 200) {
            Executions.sendRedirect("/pages/success.zul");
        }

        return response.toString();

    }


}
