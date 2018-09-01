package entities;

import com.mongodb.BasicDBObject;
import enums.WorkerFunctionEnum;

public class Worker extends Person {


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



    public BasicDBObject toDBObject() {
        BasicDBObject dbobject = super.toDBObject();

        if (this.getJob() != null)
            dbobject.append("job", this.getJob());
        if (this.getSalary() != null)
            dbobject.append("salary", this.getSalary());
        if (this.getScientificTitle() != null)
            dbobject.append("scientificTitle", this.getScientificTitle());
        if (this.getFunction() != null)
            dbobject.append("function", this.getFunction());

        return dbobject;

    }

}
