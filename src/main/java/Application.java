import com.mongodb.*;
import gui.PatientAdminPanel;

import javax.swing.*;
import java.net.UnknownHostException;
import java.util.Arrays;
import java.util.List;



public class Application {

    public static void main(String[] args) {


        MongoClient mongoClient = null;
        try {
            mongoClient = new MongoClient();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
        DB database = mongoClient.getDB("Examples");
        DBCollection collection = database.getCollection("people");


        DBObject query = new BasicDBObject("_id", "jo");
        DBCursor cursor = collection.find(query);
        System.out.println(cursor.one().get("name"));




        PatientAdminPanel app = new PatientAdminPanel();
        JFrame frame = new JFrame("App");
        frame.setContentPane(app.getPanelMain());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

        frame.pack();
    }
}
