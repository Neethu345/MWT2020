package com.hft2020mwt.helloworldnew;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@SpringBootApplication
@RestController
public class HelloWorldNewApplication {

    private Logger logger= LoggerFactory.getLogger(HelloWorldNewApplication.class);

    ArrayList<String>  ListOfStrings = new ArrayList<>();

    @GetMapping("/")
    public String sayHello(){
        return "Hello, HFT Students !";
    }

    @RequestMapping("/test")
    public String sayHelloFromOtherEndpoint(){
        logger.info("Say hello from other endpoint invoked");
        return "Hello, from request endpoint !";
    }

    @GetMapping("/personalizedHello/{id}")
    public String sayPersonalHello(@PathVariable String id){
        logger.info("sayHelloFromOtherEndpoint invoked with parameter {}",id);
        return "Hello, dear " + id;
    }

    @GetMapping("/strings")
    public String getAllStrings(){

        return ListOfStrings.toString();
    }

    @PutMapping("/strings/{newString}")
    public String addNewString(@PathVariable String newString){

        ListOfStrings.add(newString);
        return newString + " added";
    }

    @DeleteMapping("/strings/{stringToDelete}")
    public String deleteString(@PathVariable String stringToDelete){
        logger.debug("trying to delete {}",stringToDelete);
        logger.info("list prior to deletion {}", ListOfStrings.toString());
        ListOfStrings.remove(stringToDelete);
       logger.debug("list after deletion {}" , ListOfStrings.toString());
        return stringToDelete+" probably deleted";
    }
    public static void main(String[] args) {
        SpringApplication.run(HelloWorldNewApplication.class, args);
    }

}
