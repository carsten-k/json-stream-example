package com.corschdi.spring.json.stream.service;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.List;

import com.corschdi.spring.json.stream.model.Car;

public class LargeAndSlowInputStream extends ObjectInputStream {

    private List<Integer> ids;

    public LargeAndSlowInputStream() throws IOException {
        super();
    }

    public void setIds(List<Integer> ids) {
        this.ids = ids;
    }

    @Override
    protected Object readObjectOverride() throws IOException, ClassNotFoundException {
        if (this.ids == null || this.ids.isEmpty()) {
            return null;
        } else {
            try {
                // simulate long waiting times between records
                Thread.sleep(200);

                return new Car(this.ids.remove(0));
            } catch (InterruptedException e) {
                e.printStackTrace();
                return null;
            }
        }
    }

}
