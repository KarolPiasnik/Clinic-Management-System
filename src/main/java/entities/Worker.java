package entities;

import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;
import enums.ContractTypeEnum;
import enums.WorkerFunctionEnum;
import enums.WorkerStatusEnum;

public class Worker extends Person {

    private WorkerStatusEnum status;
    private String name;
    private String surname;
    private String pesel;
    private String job;
    private WorkerFunctionEnum function;
    private Double salary;
    private String scientificTitle;
    private Integer age;

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public WorkerFunctionEnum getFunction() {
        return function;
    }

    public void setFunction(WorkerFunctionEnum function) {
        this.function = function;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    public String getScientificTitle() {
        return scientificTitle;
    }

    public void setScientificTitle(String scientificTitle) {
        this.scientificTitle = scientificTitle;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }



    public DBObject toDBObject() {
        BasicDBObject dbobject = new BasicDBObject();

        if (this.getName() != null)
            dbobject.append("name", this.getName());
        if (this.getName() != null)
            dbobject.append("surname", this.getSurname());
        if (this.getName() != null)
            dbobject.append("pesel", this.getPesel());
        if (this.getName() != null)
            dbobject.append("job", this.getJob());
        if (this.getName() != null)
            dbobject.append("salary", this.getSalary());
        if (this.getName() != null)
            dbobject.append("title", this.getScientificTitle());
        if (this.getName() != null)
            dbobject.append("age", this.getAge());
        if (this.getName() != null)
            dbobject.append("function", this.getFunction());

        return dbobject;

    }

}
