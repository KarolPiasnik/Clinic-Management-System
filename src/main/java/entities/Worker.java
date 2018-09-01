package entities;

import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;
import enums.SexEnum;
import enums.WorkerFunctionEnum;

import javax.print.attribute.DocAttributeSet;

public class Worker extends Person {


    private WorkerFunctionEnum function;
    private Double salary;
    private String scientificTitle;

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

    public Worker() {}

    public Worker(DBObject worker){
        super(worker);
        System.out.println(getName());
        if(worker.get("function") != null)
            this.function = WorkerFunctionEnum.values()[(Integer) worker.get("function")];
        if(worker.get("scientificTitle") != null)
            this.scientificTitle = worker.get("scientificTitle").toString();
        if(worker.get("salary") != null)
            this.salary = Double.parseDouble(worker.get("salary").toString());
    }

    public BasicDBObject toDBObject() {
        BasicDBObject dbobject = super.toDBObject();
        System.out.println(dbobject.get("name"));

        if (this.getSalary() != null)
            dbobject.append("salary", this.getSalary());
        if (this.getScientificTitle() != null)
            dbobject.append("scientificTitle", this.getScientificTitle());
        if (this.getFunction() != null)
            dbobject.append("function", this.getFunction().ordinal());

        return dbobject;

    }

}
