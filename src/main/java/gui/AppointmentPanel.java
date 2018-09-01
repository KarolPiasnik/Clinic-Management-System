package gui;

import base.BaseAdminPanelImpl;
import com.mongodb.*;
import entities.Appointment;
import entities.Person;
import enums.SexEnum;
import libs.DataBase;

import java.util.ArrayList;

public class AppointmentPanel  {
    private ArrayList<Appointment> appointments = new ArrayList<Appointment>();
    private String[] columns = {"Data", "Nazwa", "Lekarz/Terapeuta", "Pacjent"};
    DataBase dataBase = new DataBase();
    DBCollection collection ;

    public AppointmentPanel() {
        collection = dataBase.getAppointments();
    }






    public void fetch() {
        appointments = new ArrayList<Appointment>();
        DBCursor cursor = collection.find();
        Appointment appointment = null;
        for (DBObject dbAppointment : cursor) {
            appointment = new Appointment(dbAppointment);
            appointments.add(appointment);
        }
    }
}
