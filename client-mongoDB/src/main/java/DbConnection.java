
import com.mongodb.DBCollection;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.MongoCredential;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

import java.text.SimpleDateFormat;
import java.util.Date;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
public class DbConnection {
 //   @Value("${server.addr}")

 //  @Value("${server.port}")
    private int port;



    public static void main( String args[] ) {
        try {
             String ipAddress;

            MongoClient mongoClient = new MongoClient("127.0.0.1" , 27017 );
            //String arg1 = args[0];
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
                System.out.println(i);
                System.out.print(ipAddress);
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
