package com.fabiale.vegetarianguide.gson;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.lang.reflect.Type;
import java.nio.charset.Charset;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpInputMessage;
import org.springframework.http.HttpOutputMessage;
import org.springframework.http.MediaType;
import org.springframework.http.converter.AbstractHttpMessageConverter;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.http.converter.HttpMessageNotWritableException;
import org.springframework.stereotype.Component;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonParseException;
import com.google.gson.reflect.TypeToken;

@Component
public class GSONHttpMessageConverter extends AbstractHttpMessageConverter<Object> {

    public static final Charset DEFAULT_CHARSET = Charset.forName("UTF-8");
    private Logger logger = Logger.getLogger(GSONHttpMessageConverter.class.getName());

    private GsonBuilder gsonBuilder = new GsonBuilder()
            .setDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSZ");

    public GSONHttpMessageConverter() {
        super(new MediaType("application", "json", DEFAULT_CHARSET));
    }

    @Override
    protected boolean supports(Class<?> clazz) {
        // should not be called, since we override canRead/Write instead
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean canRead(Class<?> clazz, MediaType mediaType) {
        return MediaType.APPLICATION_JSON.isCompatibleWith(mediaType);
    }

    public boolean canWrite(Class<?> clazz, MediaType mediaType) {
        return MediaType.APPLICATION_JSON.isCompatibleWith(mediaType);
    }

    public void registerTypeAdapter(Type type, Object serializer) {
        gsonBuilder.registerTypeAdapter(type, serializer);
    }

    @Override
    protected Object readInternal(Class<? extends Object> clazz, HttpInputMessage inputMessage) throws IOException, HttpMessageNotReadableException {
        try {
        	final Reader json = new InputStreamReader(inputMessage.getBody(), getCharset(inputMessage.getHeaders()));
            Gson gson = gsonBuilder.create();
            return gson.fromJson(json, clazz);
        } catch (JsonParseException e) {
        	logger.log(Level.SEVERE, "Could not read JSON: " + e.getMessage(), e);
            throw new HttpMessageNotReadableException("Could not read JSON: " + e.getMessage(), e);
        }
    }

    @Override
    protected void writeInternal(Object o, HttpOutputMessage outputMessage) throws IOException, HttpMessageNotWritableException {
        Type genericType = TypeToken.get(o.getClass()).getType();

        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(outputMessage.getBody(), DEFAULT_CHARSET));
        try {
            // See http://code.google.com/p/google-gson/issues/detail?id=199 for details on SQLTimestamp conversion
            Gson gson = gsonBuilder.create();
            writer.append(gson.toJson(o, genericType));
        } catch(Exception e) {
        	logger.log(Level.SEVERE, "Could write JSON: " + e.getMessage(), e);
        	throw new HttpMessageNotWritableException("Could write JSON: " + e.getMessage(), e);
        } finally {
            writer.flush();
            writer.close();
        }
    }
    
    private Charset getCharset(HttpHeaders headers) {
        if (headers != null && headers.getContentType() != null && headers.getContentType().getCharSet() != null) {
            return headers.getContentType().getCharSet();
        }
        return DEFAULT_CHARSET;
    }
}
