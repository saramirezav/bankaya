package com.mx.bankaya.challenge.client;

import com.mx.bankaya.challenge.configuration.MyClientConfiguration;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Component
@FeignClient(value = "pokemonapi",
        url = "https://pokeapi.co/api/v2/pokemon",
        configuration = MyClientConfiguration.class)
public interface PokemonClient {

    @GetMapping(value = "/{name}", produces = "application/json")
    String getPokemonInformation(@PathVariable("name") String name);
}
