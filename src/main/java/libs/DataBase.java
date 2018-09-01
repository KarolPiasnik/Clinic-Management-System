package libs;

import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.MongoClient;

import java.net.UnknownHostException;

public class DataBase {
    private MongoClient mongoClient;
    private DB database;
    private DBCollection patients;
    private DBCollection workers;
    private DBCollection appointments;
    private DBCollection persons;


    public DBCollection getPersons() {
        return persons;
    }

    public MongoClient getMongoClient() {
        return mongoClient;
    }

    public DB getDatabase() {
        return database;
    }

    public DBCollection getPatients() {
        return patients;
    }

    public DBCollection getWorkers() {
        return workers;
    }

    public DBCollection getAppointments() {
        return appointments;
    }

    public DataBase(){
        MongoClient mongoClient = null;
            try {
            mongoClient = new MongoClient();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }

        database = mongoClient.getDB("ClientManagementSystem");
        patients = database.getCollection("persons");
        workers = database.getCollection("workers");
        persons = database.getCollection("persons");
        appointments = database.getCollection("appointments");
    }
}
