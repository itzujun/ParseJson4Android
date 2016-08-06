package com.eebbk.parsejson.model;

import com.eebbk.parsejson.bean.Birthday;
import com.eebbk.parsejson.bean.Person;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class DataManager{
    private DataManager(){

    }

    public static Person newPerson(){
        return new Person(
                "广东省东莞市长安镇XXX",
                28,
                new Birthday(1988, 6, 6),
                "中国",
                true,
                "小布",
                "汉族",
                "黄种人",
                12800,
                "女",
                "1315757809"
        );
    }

    public static ArrayList<Person> newPersonList(int executeCount){
        ArrayList<Person> personArrayList = new ArrayList<Person>();

        for(int index = 0; index < executeCount; index++){
            Person person = new Person(
                    "广东省东莞市长安镇XXX_" + index,
                    8+index,
                    new Birthday(2008-index, index%12, index%30),
                    "中国",
                    index%3==0?true:false,
                    "小布_" + index,
                    index%2==0?"汉族":"满族",
                    "黄种人",
                    8000+index*100,
                    index%3==0?"女":"男",
                    "131575780"+index%10
            );

            personArrayList.add(person);
        }

        return personArrayList;
    }

    public static Map<String, Person> newPersonMap(int executeCount){
        Map<String, Person> stringPersonMap = new HashMap<String, Person>();

        for(int index = 0; index < executeCount; index++){
            Person person = new Person(
                    "广东省东莞市长安镇XXX_" + index,
                    8+index,
                    new Birthday(2008-index, index%12, index%30),
                    "中国",
                    index%3==0?true:false,
                    "小布_" + index,
                    index%2==0?"汉族":"满族",
                    "黄种人",
                    8000+index*100,
                    index%3==0?"女":"男",
                    "131575780"+index%10
            );

            stringPersonMap.put("person_"+index, person);
        }

        return stringPersonMap;
    }
}
