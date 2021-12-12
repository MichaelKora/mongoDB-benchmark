import com.mongodb.DBCollection;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.MongoCredential;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

import java.text.SimpleDateFormat;
import java.util.Date;


public class DbConnection {
    public static void main( String args[] ) {
        try {
            MongoClient mongoClient = new MongoClient("localhost" , 27017 );

            // Creating Credentials
            MongoCredential  credential = MongoCredential.createCredential("sampleUser", "benchmarkDb",
                    "password".toCharArray());
            System.out.println("Connected to the database successfully");

            // create Db and collection
            MongoDatabase db = mongoClient.getDatabase("benchmarkDb");
            MongoCollection<Document> collection = db.getCollection("student");
            // Create csv file
            DataWriter dataWriter = new DataWriter("output.csv");

            for (int i = 0; i < 10; i++) {
                System.out.println(i);
                // data to be inserted
                Document document = new Document("name", "Michael Kora");
                document.append("id", 123456);

                SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");

                Date start = new Date(System.currentTimeMillis());
                //write in database
                collection.insertOne(document);

                Date end = new Date(System.currentTimeMillis());

                dataWriter.writeLine(new String[]{formatter.format(start), formatter.format(end), "instert"});
            }

            dataWriter.closeWriter();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
