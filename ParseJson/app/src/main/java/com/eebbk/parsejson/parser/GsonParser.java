package com.eebbk.parsejson.parser;

import com.eebbk.parsejson.bean.Person;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class GsonParser implements IJsonParser{
    @Override
    public Person fromJson(String jsonString, Class<Person> object){
        return new Gson().fromJson(jsonString, object);
    }

    @Override
    public String toJson(Object object){
        return new Gson().toJson(object);
    }

    @Override
    public List<Person> listFromJson(String jsonString, Class<Person> object){
        return new Gson().fromJson(jsonString, new TypeToken<ArrayList<Person>>() {}.getType());
    }

    @Override
    public Map<String, Person> mapFromJson(String jsonString, Class<Person> object){
        return new Gson().fromJson(jsonString, new TypeToken<Map<String, Person>>(){}.getType());
    }
}
