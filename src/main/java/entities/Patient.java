package entities;

import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;
import enums.PatientStatusEnum;
import enums.SexEnum;

public class Patient {

    Object id;
    private String name;
    private String surname;
    private String pesel;
    private Integer age;
    private SexEnum sex;

    public Patient(String name, String surname, String pesel, Integer age, SexEnum sex){
        this.id = null;
        this.name = name;
        this.surname = surname;
        this.sex = sex;
        this.pesel = pesel;
        this.age = age;
    }

    public Patient(DBObject patient){
        this.id = patient.get("id");
        this.name = patient.get("name").toString();
        this.surname = patient.get("surname").toString();
        this.sex = SexEnum.values()[(Integer) patient.get("sex")];
        this.pesel = patient.get("pesel").toString();
        this.age = (Integer) patient.get("age");
    }

    public Object getId() {
        return id;
    }

    public void setId(Object id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getPesel() {
        return pesel;
    }

    public void setPesel(String pesel) {
        this.pesel = pesel;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }


    public SexEnum getSex() {
        return sex;
    }

    public void setSex(SexEnum sex) {
        this.sex = sex;
    }



    public DBObject toDBObject() {
        BasicDBObject dbobject =  new BasicDBObject("name", this.getName())
                .append("surname", this.getSurname())
                .append("pesel", this.getPesel())
                .append("age", this.getAge())
                .append("sex", this.getSex().ordinal());
        if(id != null){
            dbobject.append("_id",id);
        }

        return  dbobject;
    }



}
