package com.eebbk.parsejson.bean;

public class Person{
    // 种族
    private String race;
    // 国家
    private String country;
    // 民族
    private String nation;
    // 姓名
    private String name;
    // 性别
    private String sex;
    // 年龄
    private int age;
    // 住址
    private String address;
    // 电话
    private String telephone;
    // 是否已婚
    private boolean married;
    // 薪水
    private float salary;
    // 生日
    private Birthday birthday;

    public Person(){

    }

    public Person(String address, int age, Birthday birthday, String country, boolean married, String name, String nation, String race, float salary, String sex, String telephone){
        this.address = address;
        this.age = age;
        this.birthday = birthday;
        this.country = country;
        this.married = married;
        this.name = name;
        this.nation = nation;
        this.race = race;
        this.salary = salary;
        this.sex = sex;
        this.telephone = telephone;
    }

    public String getAddress(){
        return address;
    }

    public void setAddress(String address){
        this.address = address;
    }

    public int getAge(){
        return age;
    }

    public void setAge(int age){
        this.age = age;
    }

    public String getCountry(){
        return country;
    }

    public void setCountry(String country){
        this.country = country;
    }

    public boolean isMarried(){
        return married;
    }

    public void setMarried(boolean married){
        this.married = married;
    }

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    public String getNation(){
        return nation;
    }

    public void setNation(String nation){
        this.nation = nation;
    }

    public String getRace(){
        return race;
    }

    public void setRace(String race){
        this.race = race;
    }

    public float getSalary(){
        return salary;
    }

    public void setSalary(float salary){
        this.salary = salary;
    }

    public String getSex(){
        return sex;
    }

    public void setSex(String sex){
        this.sex = sex;
    }

    public String getTelephone(){
        return telephone;
    }

    public void setTelephone(String telephone){
        this.telephone = telephone;
    }

    public Birthday getBirthday(){
        return birthday;
    }

    public void setBirthday(Birthday birthday){
        this.birthday = birthday;
    }

    @Override
    public String toString(){
        return "Person{" +
                "address='" + address + '\'' +
                ", race='" + race + '\'' +
                ", country='" + country + '\'' +
                ", nation='" + nation + '\'' +
                ", name='" + name + '\'' +
                ", sex='" + sex + '\'' +
                ", age=" + age +
                ", telephone='" + telephone + '\'' +
                ", married=" + married +
                ", salary=" + salary +
                ", birthday=" + birthday.toString() +
                '}';
    }
}
