package com.corschdi.spring.json.stream.service;

import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.springframework.web.servlet.mvc.method.annotation.StreamingResponseBody;

import com.fasterxml.jackson.core.JsonEncoding;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonResponseBodyService implements StreamingResponseBody {

    private static final ObjectMapper MAPPER = new ObjectMapper();
    private LargeAndSlowInputStream inputStream;

    private boolean isArray;

    public JsonResponseBodyService() throws IOException {
        this.inputStream = new LargeAndSlowInputStream();
    }

    public void readAll(int collectionSize) {
        this.isArray = true;
        this.inputStream.setIds(IntStream.range(1, collectionSize).boxed().collect(Collectors.toList()));
    }

    public void readSingle(int id) {
        this.isArray = false;
        this.inputStream.setIds(new ArrayList<>(Arrays.asList(id)));
    }

    public void writeTo(OutputStream outputStream) throws IOException {
        JsonGenerator generator = MAPPER.getFactory().createGenerator(outputStream, JsonEncoding.UTF8);

        if (this.isArray) {
            generator.writeStartArray();
        }

        try {
            Object object;

            while ((object = this.inputStream.readObject()) != null) {
                generator.writeObject(object);
            }
        } catch (ClassNotFoundException e) {
            throw new IOException(e);
        }

        if (this.isArray) {
            generator.writeEndArray();
        }
        generator.close();
    }

}
