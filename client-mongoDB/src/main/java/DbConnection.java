import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

import java.text.SimpleDateFormat;
import java.util.Date;


public class DbConnection {
    public static void main(String[] args) {
        try {
            System.out.println(11111);


            MongoClient mongoClient = new MongoClient("localhost", 27017);
            System.out.println(22222);
            MongoDatabase db = mongoClient.getDatabase("benchmark");
            System.out.println(33333);
            MongoCollection<Document> table = db.getCollection("student");
            System.out.println(44444);
            DataWriter dataWriter = new DataWriter("./csvFile/output.csv");

            System.out.println(5555555);
            for (int i = 0; i < 10; i++) {
                System.out.println(i);
                Document document = new Document("name", "Michael Kora");
                document.append("id", 123456);

                SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
                Date start = new Date(System.currentTimeMillis());

                //write in dabase
                table.insertOne(document);

                Date end = new Date(System.currentTimeMillis());

                dataWriter.writeLine(new String[]{formatter.format(start), formatter.format(end), "instert"});

           }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
