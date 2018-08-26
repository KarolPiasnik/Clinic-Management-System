package entities;

import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;

import java.util.Date;

public class AppointmentEntity {
    private Date date;
    private PatientEntity patient;
    private WorkerEntity medicalWorker;
    private int roomNumber;

    public AppointmentEntity(Date date, WorkerEntity medicalWorker, PatientEntity patient, int roomNumber){
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

    public PatientEntity getPatient() {
        return patient;
    }

    public void setPatient(PatientEntity patient) {
        this.patient = patient;
    }

    public WorkerEntity getMedicalWorker() {
        return medicalWorker;
    }

    public void setMedicalWorker(WorkerEntity medicalWorker) {
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
