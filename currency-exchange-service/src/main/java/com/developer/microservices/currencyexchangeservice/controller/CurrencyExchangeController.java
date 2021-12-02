package com.developer.microservices.currencyexchangeservice.controller;

import com.developer.microservices.currencyexchangeservice.bean.CurrencyExchange;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RestController
public class CurrencyExchangeController {

    @Autowired
    Environment environment;

    @GetMapping("/currency-exchange/from/{from}/to/{to}")
    public CurrencyExchange retrieveExchangeVal(
            @PathVariable String from,
            @PathVariable String to
    ) {
        CurrencyExchange currencyExchange = new CurrencyExchange(1000L, from, to,
                BigDecimal.valueOf(75));
        //to get the local port
       String port= environment.getProperty("local.server.port");
        currencyExchange.setEnvironment(port);
        return currencyExchange;
    }
}
