package com.mx.bankaya.challenge.service;

import com.mx.bankaya.challenge.client.LocationAreaEncountersClient;
import com.mx.bankaya.challenge.constants.AttributeConstant;
import com.mx.bankaya.challenge.utils.ClientUtil;
import com.mx.bankaya.challenge.utils.InformationUtil;
import org.json.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.json.JSONObject;

import java.util.List;

/**
 * Service that manages the Pokemon information
 * @author Sarahy Ramirez
 */
@Service
public class PokemonService implements IPokemonService{

    @Autowired
    ClientUtil clientUtil;

    @Autowired
    InformationUtil informationUtil;

    @Autowired
    LocationAreaEncountersClient locationAreaEncountersClient;

    /**
     * Gets the information according to the attribute
     * @param name
     * @param information
     * @return information (Object)
     */
    public Object getInformation(String name, String information){

        JSONObject jsonObj = clientUtil.callService(name);

        switch (information){
            case AttributeConstant.ABILITIES:
                List<String> abilities = informationUtil.processInformation("ability", jsonObj.getJSONArray(information));
                return abilities;
            case AttributeConstant.HELD_ITEMS:
                List<String> heldItems = informationUtil.processInformation("item", jsonObj.getJSONArray(information));
                return heldItems;
            case AttributeConstant.NAME:
                return jsonObj.getJSONArray("forms").getJSONObject(0).get("name").toString();
            case AttributeConstant.LOCATION_AREA_ENCOUNTERS:
                int id = Integer.parseInt(jsonObj.get("id").toString());
                String locations = locationAreaEncountersClient.getLocations(id);
                List<String> resultado = informationUtil.processInformation("location_area", new JSONArray(locations));
                return resultado;
            default:
                return jsonObj.get(information).toString();
        }
    }
}
