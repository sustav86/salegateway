package ua.sustavov.payment.service;

import org.springframework.stereotype.Service;
import org.zkoss.zk.ui.Executions;
import ua.sustavov.payment.model.Card;
import ua.sustavov.payment.model.Transaction;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by SUSTAVOV on 10.02.2018.
 */

//@Service("transaction")
public class HttpPostTransactionalityImpl implements Transactionality {

    private static String BASE_URL = "https://sandbox-secure.unitedthinkers.com/gates/xurl?";
    private static int CONNECT_TIMEOUT = 10 * 1000;
    private static int READ_TIMEOUT = 1 * 60 * 1000;

    @Override
    public String sale(Card card, Transaction transaction) {

        String response = "";

        try {
            response = sendPOST(BASE_URL, transaction.toPOSTString());
        } catch (IOException e) {
            return e.getMessage();
        }

        return response;

    }

    private static String sendPOST(String url, String data) throws IOException {

        HttpURLConnection conn = null;
        InputStream stream = null;
        URL urlLink = new URL(url);
        OutputStreamWriter writer = null;
        String response = "";

        conn = (HttpURLConnection) urlLink.openConnection();
        conn.setDoInput(true);
        conn.setDoOutput(true);
        conn.setUseCaches(false);
        conn.setConnectTimeout(CONNECT_TIMEOUT);
        conn.setReadTimeout(READ_TIMEOUT);
        conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
        conn.setRequestMethod("POST");

        writer = new OutputStreamWriter(conn.getOutputStream());
        writer.write(data);
        writer.flush();
        writer.close();

        if (conn.getResponseCode() == HttpURLConnection.HTTP_OK) {
            stream = conn.getInputStream();
            response = stream2String(stream);
            if (!response.contains("responseType=exception")) {
                Executions.sendRedirect("/pages/success.zul");
            }
        } else {
            stream = conn.getErrorStream();
            response = stream2String(stream);
        }
        if (stream == null) {
            System.out.println("Response code is " + conn.getResponseCode());
            return String.valueOf(conn.getResponseCode());
        }

        return response;
    }

    private static String stream2String(InputStream is) throws IOException {
        StringBuilder sb = new StringBuilder(8192);
        BufferedReader br = new BufferedReader(new InputStreamReader(is));
        String line = null;
        while ((line = br.readLine()) != null) {
            sb.append(line);
        }

        return sb.toString();

    }

}
