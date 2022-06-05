package com.mx.bankaya.challenge.utils;

import com.mx.bankaya.challenge.client.PokemonClient;
import com.mx.bankaya.challenge.exception.NoDataFoundException;
import feign.FeignException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ClientUtil {

    @Autowired
    PokemonClient pokemonClient;

    public JSONObject callService(String name) {
        try {
            String datos = pokemonClient.getPokemonInformation(name);
            return new JSONObject(datos);
        }catch (FeignException e){
            throw new NoDataFoundException("El pokemón " + name + " no fue encontrado");
        }
    }
}
