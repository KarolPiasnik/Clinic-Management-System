package entities;

import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;
import enums.PatientStatusEnum;
import enums.SexEnum;

public class PatientEntity {
    String id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
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
    private String name;
    private String surname;
    private String pesel;
    private Integer age;
    private SexEnum sex;

    public SexEnum getSex() {
        return sex;
    }

    public void setSex(SexEnum sex) {
        this.sex = sex;
    }



    public DBObject toDBObject() {
        return new BasicDBObject("name", this.getName())
                .append("surname", this.getSurname())
                .append("pesel", this.getPesel())
                .append("age", this.getAge())
                .append("sex", this.getSex());
    }

}
