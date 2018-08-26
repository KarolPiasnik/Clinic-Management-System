package entities;
import org.springframework.data.annotation.Id;
import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;

import java.util.Date;

public class Appointment {

    @Id
    private String id;
    private Date date;
    private Patient patient;
    private Worker medicalWorker;
    private int roomNumber;

    public Appointment(Date date, Worker medicalWorker, Patient patient, int roomNumber){
        this.date = date;
        this.medicalWorker = medicalWorker;
        this.patient = patient;
        this.roomNumber = roomNumber;
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

    public int getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(int roomNumber) {
        this.roomNumber = roomNumber;
    }

    public  DBObject toDBObject() {
        return new BasicDBObject("date", this.getDate())
                .append("doctor", this.getMedicalWorker().toDBObject())
                .append("patient", this.getPatient().toDBObject())
                        .append("room", this.getRoomNumber());
    }
}
