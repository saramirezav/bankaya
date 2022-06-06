package com.mx.bankaya.challenge.controller;

import org.springframework.ws.server.endpoint.annotation.Endpoint;
import com.mx.bankaya.challenge.service.IPokemonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;
import pokemon.challenge.bankaya_web_service.*;

import java.util.List;

@Endpoint
public class PokemonController {

    private static final String NAMESPACE_URI = "http://pokemon/challenge/bankaya-web-service";

    @Autowired
    IPokemonService iPokemonService;

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getAbilitiesRequest")
    @ResponsePayload
    public GetAbilitiesResponse getAbilities(@RequestPayload GetAbilitiesRequest request) {

        List<String> abilities= (List<String>) iPokemonService.getInformation(request.getName().toLowerCase(), "abilities");

        GetAbilitiesResponse getAbilitiesResponse= new GetAbilitiesResponse();

        for (String ability: abilities) {
            getAbilitiesResponse.getAbility().add(ability);
        }

        return getAbilitiesResponse;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getBaseExperienceRequest")
    @ResponsePayload
    public GetBaseExperienceResponse getBaseExperience(@RequestPayload GetBaseExperienceRequest request) {

        int base_experience = Integer.valueOf(iPokemonService.getInformation(request.getName().toLowerCase(), "base_experience").toString());

        GetBaseExperienceResponse getBaseExperienceResponse = new GetBaseExperienceResponse();
        getBaseExperienceResponse.setBaseExperience(base_experience);

        return getBaseExperienceResponse;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getHeldItemsRequest")
    @ResponsePayload
    public GetHeldItemsResponse getHeldItems(@RequestPayload GetHeldItemsRequest request) {

        List<String> held_items= (List<String>) iPokemonService.getInformation(request.getName().toLowerCase(), "held_items");

        GetHeldItemsResponse getHeldItemsResponse = new GetHeldItemsResponse();

       for (String item: held_items) {
           getHeldItemsResponse.getHeldItem().add(item);
       }

        return getHeldItemsResponse;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getIdRequest")
    @ResponsePayload
    public GetIdResponse getId(@RequestPayload GetIdRequest request) {

        int id = Integer.valueOf(iPokemonService.getInformation(request.getName().toLowerCase(), "id").toString());

        GetIdResponse getIdResponse = new GetIdResponse();
        getIdResponse.setId(id);

        return getIdResponse;
    }


    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getNameRequest")
    @ResponsePayload
    public GetNameResponse getName(@RequestPayload GetNameRequest request) {

        String name = iPokemonService.getInformation(request.getName().toLowerCase(), "name").toString();

        GetNameResponse getNameResponse = new GetNameResponse();
        getNameResponse.setNamePokemon(name);

        return getNameResponse;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getLocationAreaEncountersRequest")
    @ResponsePayload
    public GetLocationAreaEncountersResponse getLocationAreaEncounters(@RequestPayload GetLocationAreaEncountersRequest request) {

        List<String> locations = (List<String>) iPokemonService.getInformation(request.getName().toLowerCase(), "location_area_encounters");

        GetLocationAreaEncountersResponse response = new GetLocationAreaEncountersResponse();

        for (String location: locations){
            response.getLocation().add(location);
        }

        return response;
    }

}
