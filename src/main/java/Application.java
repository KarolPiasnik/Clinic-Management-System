import com.mongodb.*;
import entities.Patient;
import enums.SexEnum;
import gui.PatientAdminPanel;


import javax.swing.*;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;


public class Application {

    public static void main(String[] args) {


        MongoClient mongoClient = null;
        try {
            mongoClient = new MongoClient();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
        DB database = mongoClient.getDB("ClientManagementSystem");
        DBCollection collection = database.getCollection("patients");

        collection.insert(new Patient("Alice", "Kowalski", "11111111111", 21, SexEnum.FEMALE).toDBObject());
        collection.insert(new Patient("Alice1", "Kowalski4", "11111111111", 21, SexEnum.MALE).toDBObject());
        collection.insert(new Patient("Alice2", "Kowalski3", "11111111111", 21, SexEnum.FEMALE).toDBObject());
        collection.insert(new Patient("Alice3", "Kowalski2", "11111111111", 21, SexEnum.MALE).toDBObject());
        collection.insert(new Patient("Alice4", "Kowalski1", "11111111111", 21, SexEnum.FEMALE).toDBObject());


        DBCursor cursor = collection.find();
        List<Patient> patients = new ArrayList<Patient>();
        Patient patient = null;
        for(DBObject dbPatient : cursor) {
            patient = new Patient(dbPatient);
            patients.add(patient);
        }



        PatientAdminPanel app = new PatientAdminPanel();
        JFrame frame = new JFrame("App");
        frame.setContentPane(app.getPanelMain());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.pack();

        app.updatePatients(patients);
        app.updateTable();
    }
}
