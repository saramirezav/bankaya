package com.mx.bankaya.challenge.service;

import com.mx.bankaya.challenge.client.LocationAreaEncountersClient;
import com.mx.bankaya.challenge.utils.ClientUtil;
import com.mx.bankaya.challenge.utils.InformationUtil;
import org.json.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.json.JSONObject;

@Service
public class PokemonService implements IPokemonService{

    @Autowired
    ClientUtil clientUtil;

    @Autowired
    InformationUtil informationUtil;

    @Autowired
    LocationAreaEncountersClient locationAreaEncountersClient;

    public Object getInformation(String name, String information){

        JSONObject jsonObj = clientUtil.callService(name);

        switch (information){
            case "abilities":
                String abilities = informationUtil.processInformation("ability", jsonObj.getJSONArray(information));
                return abilities;
            case "held_items":
                String held_items = informationUtil.processInformation("item", jsonObj.getJSONArray(information));
                return held_items;
            case "name":
                return jsonObj.getJSONArray("forms").getJSONObject(0).get("name").toString();
            case "location_area_encounters":
                int id = Integer.valueOf(jsonObj.get("id").toString());
                String locations = locationAreaEncountersClient.getLocations(id);
                String resultado = informationUtil.processInformation("location_area", new JSONArray(locations));
                return resultado;
            default:
                return jsonObj.get(information).toString();
        }
    }
}
