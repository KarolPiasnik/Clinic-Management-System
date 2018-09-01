package entities;

import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;
import enums.SexEnum;

public class Person {

    Object id;
    protected String name;
    protected String surname;
    protected String pesel;
    protected Integer age;
    protected SexEnum sex;

    public Person() {

    }

    public Person(String name, String surname, String pesel, Integer age, SexEnum sex) {
        this.id = null;
        this.name = name;
        this.surname = surname;
        this.sex = sex;
        this.pesel = pesel;
        this.age = age;
    }

    public Person(DBObject person) {
        this.id = person.get("_id");
        this.name = person.get("name").toString();
        this.surname = person.get("surname").toString();
        this.sex = SexEnum.values()[(Integer) person.get("sex")];
        this.pesel = person.get("pesel").toString();
        this.age = (Integer) person.get("age");
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


    public BasicDBObject toDBObject() {
        BasicDBObject dbobject = new BasicDBObject();
        if (this.getName() != null)
            dbobject.append("name", this.getName());
        if (this.getSurname() != null)
            dbobject.append("surname", this.getSurname());
        if (this.getPesel() != null)
            dbobject.append("pesel", this.getPesel());
        if (this.getAge() != null)
            dbobject.append("age", this.getAge());
        if (this.getSex() != null)
            dbobject.append("sex", this.getSex().ordinal());
        if (id != null) {
            dbobject.append("_id", id);
        }

        return dbobject;
    }


}
