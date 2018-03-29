package com.techjava.springbootloglevelruntimedemo.controller;

import ch.qos.logback.classic.Level;
import ch.qos.logback.classic.LoggerContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LogLevelController {

    private static final Logger log = LoggerFactory.getLogger(LogLevelController.class);

    @GetMapping("/hello")
    public String hello(){
        log.info("We are in logchange method -- Loglevel is INFO");
        log.debug("We are in logchange method -- Loglevel is DEBUG");
        return "Welcome to techjava";
    }

    @GetMapping("/loglevel/{loglevel}")
    public String loglevel(@PathVariable String loglevel){
        log.info("LogLevel----->" + loglevel);
        return setLogLevel(loglevel);
    }

    private String setLogLevel(String loglevel) {
        String retVal;
        LoggerContext loggerContext = (LoggerContext) LoggerFactory.getILoggerFactory();
        if(loglevel.equalsIgnoreCase("INFO")){
            loggerContext.getLogger("com.techjava").setLevel(Level.INFO);
            retVal = "Loglevel has changed";
        } else if(loglevel.equalsIgnoreCase("DEBUG")){
            loggerContext.getLogger("com.techjava").setLevel(Level.DEBUG);
            retVal = "Loglevel has changed";
        } else if(loglevel.equalsIgnoreCase("TRACE")){
            loggerContext.getLogger("com.techjava").setLevel(Level.TRACE);
            retVal = "Loglevel has changed";
        } else {
            log.error("Not a known loglevel: " + loglevel);
            retVal = "Error, not a known loglevel: " + loglevel;
        }
        return retVal;
    }


}
