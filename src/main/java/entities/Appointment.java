package entities;

import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;

import java.util.Date;

public class Appointment {

    private String id;
    private Date date;

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

    private Patient patient;
    private Worker medicalWorker;
    private String name;

    public Appointment(Date date, Worker medicalWorker, Patient patient, int roomNumber) {
        this.date = date;
        this.medicalWorker = medicalWorker;
        this.patient = patient;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public Worker getMedicalWorker() {
        return medicalWorker;
    }

    public void setMedicalWorker(Worker medicalWorker) {
        this.medicalWorker = medicalWorker;
    }


    public DBObject toDBObject() {
        BasicDBObject dbobject = new BasicDBObject();
        if (this.getName() != null)
            dbobject.append("name", this.getName());
        if (this.getPatient() != null)
            dbobject.append("patient", this.getPatient().toDBObject());
        if (this.getMedicalWorker() != null)
            dbobject.append("medicalWorker", this.getMedicalWorker().toDBObject());
        if (this.getName() != null)
            dbobject.append("date", this.getDate());
        if (id != null) {
            dbobject.append("_id", id);
        }
        return dbobject;
    }
}
