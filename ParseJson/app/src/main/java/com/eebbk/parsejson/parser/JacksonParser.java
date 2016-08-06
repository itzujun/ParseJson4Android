package com.eebbk.parsejson.parser;

import com.eebbk.parsejson.bean.Person;

import org.codehaus.jackson.JsonFactory;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.annotate.JsonSerialize;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public class JacksonParser implements IJsonParser{
    @Override
    public Person fromJson(String jsonString, Class<Person> object){
        ObjectMapper objectMapper = new ObjectMapper();
        try{
            return objectMapper.readValue(jsonString, object);
        }catch(IOException e){
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public String toJson(Object object){
        ObjectMapper objectMapper = new ObjectMapper();
        //设置输出包含的属性
        objectMapper.getSerializationConfig().setSerializationInclusion(JsonSerialize.Inclusion.NON_DEFAULT);
        //设置输入时忽略JSON字符串中存在而Java对象实际没有的属性
        objectMapper.getDeserializationConfig().set(org.codehaus.jackson.map.DeserializationConfig.Feature.FAIL_ON_UNKNOWN_PROPERTIES, false);

        try{
            return objectMapper.writeValueAsString(object);
        }catch(IOException e){
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public List<Person> listFromJson(String jsonString, Class<Person> object){
        ObjectMapper objectMapper = new ObjectMapper();
        //设置输出包含的属性
        objectMapper.getSerializationConfig().setSerializationInclusion(JsonSerialize.Inclusion.NON_DEFAULT);
        //设置输入时忽略JSON字符串中存在而Java对象实际没有的属性
        objectMapper.getDeserializationConfig().set(org.codehaus.jackson.map.DeserializationConfig.Feature.FAIL_ON_UNKNOWN_PROPERTIES, false);

        try{
            return objectMapper.readValue(jsonString, List.class);
        }catch(IOException e){
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public Map<String, Person> mapFromJson(String jsonString, Class<Person> object){
        JsonFactory factory = new JsonFactory();
        ObjectMapper objectMapper = new ObjectMapper(factory);
        try{
            return objectMapper.readValue(jsonString, Map.class);
        }catch(IOException e){
            e.printStackTrace();
        }

        return null;
    }
}
