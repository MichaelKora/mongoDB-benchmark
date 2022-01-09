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
    public static void main( String[] args ) {
        try {
           // String ipAddr = args[0];
           // int portNr = Integer.parseInt(args[1]);
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
            SimpleDateFormat formatterTZ = new SimpleDateFormat("z");
            String timeZone= formatterTZ.format(System.currentTimeMillis());
            for (int i = 0; i < 10; i++) {
//                System.out.println(ipAddr);
                // data to be inserted
                Document document = new Document("name", "Michael Kora");
                document.append("id", 123456);

                SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss.SSS");
                Date start = new Date(System.currentTimeMillis());
                long startInt = System.currentTimeMillis();
                //write in database
                collection.insertOne(document);

                long end = System.currentTimeMillis();
                long duration = end - startInt;

                dataWriter.writeLine(new String[]{timeZone, formatter.format(start),  String.valueOf(duration), "instert"});
            }

            dataWriter.closeWriter();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
