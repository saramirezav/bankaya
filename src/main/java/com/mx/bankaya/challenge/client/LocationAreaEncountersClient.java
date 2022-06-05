package com.mx.bankaya.challenge.client;

import com.mx.bankaya.challenge.configuration.MyClientConfiguration;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Component
@FeignClient(value = "location-area-encounters",
        url = "https://pokeapi.co/api/v2/pokemon",
        configuration = MyClientConfiguration.class)
public interface LocationAreaEncountersClient {

    @GetMapping(value = "/{id}/encounters", produces = "application/json")
    String getLocations(@PathVariable("id") int id);
}
