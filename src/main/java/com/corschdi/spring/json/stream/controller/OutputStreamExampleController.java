package com.corschdi.spring.json.stream.controller;

import java.io.IOException;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.corschdi.spring.json.stream.service.JsonResponseBodyService;

@RestController
public class OutputStreamExampleController {

    @RequestMapping("/cars")
    public ResponseEntity<JsonResponseBodyService> readCars(@RequestParam(defaultValue = "100") int collectionSize)
            throws IOException {
        JsonResponseBodyService responseBody = new JsonResponseBodyService();
        responseBody.readAll(collectionSize);

        return ResponseEntity.ok().contentType(MediaType.APPLICATION_JSON_UTF8).body(responseBody);
    }

    @RequestMapping("/cars/{id}")
    public ResponseEntity<JsonResponseBodyService> readSingleCar(@PathVariable int id) throws IOException {
        JsonResponseBodyService responseBody = new JsonResponseBodyService();
        responseBody.readSingle(id);

        return ResponseEntity.ok().contentType(MediaType.APPLICATION_JSON_UTF8).body(responseBody);
    }

}
