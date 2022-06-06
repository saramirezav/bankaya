package com.mx.bankaya.challenge.utils;

import com.mx.bankaya.challenge.exception.NoDataFoundException;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * Class that gets the information
 * @author Sarahy Ramirez
 */
@Component
public class InformationUtil {

    /**
     * Gets the information according to the attribute
     * @param attribute
     * @param jsonArray
     * @return information
     */
    public List<String> processInformation(String attribute, JSONArray jsonArray){

        List<String> informacion = new ArrayList<>();

        for (int i = 0; i < jsonArray.length(); i++) {
            JSONObject object = jsonArray.getJSONObject(i);
            informacion.add(object.getJSONObject(attribute).get("name").toString());
        }

        if(informacion.isEmpty()){
            throw new NoDataFoundException("No se encontro información de atributo " + attribute);
        }

        return informacion;
    }

}
