package ua.sustavov.payment.rest;

import ua.sustavov.payment.model.Transaction;

import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.ext.MessageBodyWriter;
import javax.ws.rs.ext.Provider;
import java.io.IOException;
import java.io.OutputStream;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;

/**
 * Created by SUSTAVOV on 08.02.2018.
 */

@Provider
@Produces(MediaType.TEXT_PLAIN)
public class TransactionMessageBodyWriter implements MessageBodyWriter<Transaction> {

    @Override
    public boolean isWriteable(Class<?> aClass, Type type, Annotation[] annotations, MediaType mediaType) {
        return Transaction.class.isAssignableFrom(aClass);
    }

    @Override
    public void writeTo(Transaction transaction, Class<?> aClass, Type type, Annotation[] annotations, MediaType mediaType, MultivaluedMap<String, Object> multivaluedMap, OutputStream outputStream) throws IOException, WebApplicationException {

        outputStream.write(transaction.toString().getBytes());
    }

    @Override
    public long getSize(Transaction transaction, Class<?> type, Type genericType, Annotation[] annotations, MediaType mediaType) {
        return -1;
    }
}
