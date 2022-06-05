package com.mx.bankaya.challenge.controller;

import com.mx.bankaya.challenge.beans.GeneralResponse;
import com.mx.bankaya.challenge.beans.PokemonRequest;
import com.mx.bankaya.challenge.service.IPokemonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import javax.xml.bind.JAXBElement;
import javax.xml.namespace.QName;

@Endpoint
public class PokemonController {

    private static final String NAMESPACE_URI = "http://pokemon/challenge/bankaya-web-service";

    @Autowired
    IPokemonService iPokemonService;

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getAbilitiesRequest")
    @ResponsePayload
    public JAXBElement<GeneralResponse>getAbilities(@RequestPayload JAXBElement<PokemonRequest> request) {
        String abilities= iPokemonService.getInformation(request.getValue().getName().toLowerCase(), "abilities").toString();
        GeneralResponse generalResponse= new GeneralResponse(200, "Consulta exitosa", abilities);
        return createJaxbElement(generalResponse, GeneralResponse.class);
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getBaseExperienceRequest")
    @ResponsePayload
    public JAXBElement<GeneralResponse> getBaseExperience(@RequestPayload JAXBElement<PokemonRequest> request) {
        int base_experience = Integer.valueOf(iPokemonService.getInformation(request.getValue().getName().toLowerCase(), "base_experience").toString());
        GeneralResponse generalResponse= new GeneralResponse(200, "Consulta exitosa", base_experience);
        return createJaxbElement(generalResponse, GeneralResponse.class);
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getHeldItemsRequest")
    @ResponsePayload
    public JAXBElement<GeneralResponse> getHeldItems(@RequestPayload JAXBElement<PokemonRequest> request) {
        String held_items= iPokemonService.getInformation(request.getValue().getName().toLowerCase(), "held_items").toString();
        GeneralResponse generalResponse= new GeneralResponse(200, "Consulta exitosa", held_items);
        return createJaxbElement(generalResponse, GeneralResponse.class);
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getIdRequest")
    @ResponsePayload
    public JAXBElement<GeneralResponse> getId(@RequestPayload JAXBElement<PokemonRequest> request) {
        int id = Integer.valueOf(iPokemonService.getInformation(request.getValue().getName().toLowerCase(), "id").toString());
        GeneralResponse generalResponse= new GeneralResponse(200, "Consulta exitosa", id);
        return createJaxbElement(generalResponse, GeneralResponse.class);
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getNameRequest")
    @ResponsePayload
    public JAXBElement<GeneralResponse> getName(@RequestPayload JAXBElement<PokemonRequest> request) {
        String name = iPokemonService.getInformation(request.getValue().getName().toLowerCase(), "name").toString();
        GeneralResponse generalResponse= new GeneralResponse(200, "Consulta exitosa", name);
        return createJaxbElement(generalResponse, GeneralResponse.class);
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getLocationAreaEncountersRequest")
    @ResponsePayload
    public JAXBElement<GeneralResponse> getLocationAreaEncounters(@RequestPayload JAXBElement<PokemonRequest> request) {
        String name = iPokemonService.getInformation(request.getValue().getName().toLowerCase(), "location_area_encounters").toString();
        GeneralResponse generalResponse= new GeneralResponse(200, "Consulta exitosa", name);
        return createJaxbElement(generalResponse, GeneralResponse.class);
    }

    private <T> JAXBElement<T> createJaxbElement(T object, Class<T> clazz) {
        return new JAXBElement<>(new QName(clazz.getSimpleName()), clazz, object);
    }
}
