package com.eebbk.parsejson.bean;

public class Women extends Person{
    // 是否化妆了
    private boolean isMakeuped;

    public Women(String address, int age, Birthday birthday, String country, boolean married, String name, String nation, String race, float salary, String sex, String telephone, boolean isMakeuped){
        super(address, age, birthday, country, married, name, nation, race, salary, sex, telephone);
        this.isMakeuped = isMakeuped;
    }

    public boolean isMakeuped(){
        return isMakeuped;
    }

    public void setMakeuped(boolean makeuped){
        isMakeuped = makeuped;
    }
}
