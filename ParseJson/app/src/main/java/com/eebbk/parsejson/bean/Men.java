package com.eebbk.parsejson.bean;

public class Men extends Person{
    // 是否是伪娘
    private boolean isCrossDresser;

    public Men(String address, int age, Birthday birthday, String country, boolean married, String name, String nation, String race, float salary, String sex, String telephone, boolean isCrossDresser){
        super(address, age, birthday, country, married, name, nation, race, salary, sex, telephone);
        this.isCrossDresser = isCrossDresser;
    }

    public boolean isCrossDresser(){
        return isCrossDresser;
    }

    public void setCrossDresser(boolean crossDresser){
        isCrossDresser = crossDresser;
    }
}
