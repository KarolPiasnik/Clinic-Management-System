import com.mongodb.*;
import gui.PatientAdminPanel;

import javax.swing.*;
import java.util.Arrays;
import java.util.List;



public class Main {

    public static void main(String[] args) {

        List<Integer> books = Arrays.asList(27464, 747854);
        DBObject person = new BasicDBObject("name", "Jo Bloggs")
                .append("address", new BasicDBObject("street", "123 Fake St")
                        .append("city", "Faketon")
                        .append("state", "MA")
                        .append("zip", 12345))
                .append("books", books);

        MongoClient mongoClient = new MongoClient();
        DB database = mongoClient.getDB("Examples");
        DBCollection collection = database.getCollection("people");

        collection.insert(person);

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
