import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

import java.io.FileWriter;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import static java.lang.Thread.sleep;


public class DbConnection {
    public static void main(String[] args) {
        try {
            /*MongoClient mongoClient = new MongoClient("localhost", 27017);
            MongoDatabase db = mongoClient.getDatabase("benchmark");
            MongoCollection<Document> table = db.getCollection("student");

            DataWriter dataWriter = new DataWriter("./csvFile/output.csv");

            for (int i = 0; i < 10; i++) {
                System.out.println(i);
                Document document = new Document("name", "Michael Kora");
                document.append("id", 123456);

                SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");

                Date start = new Date(System.currentTimeMillis());
                //write in database
                table.insertOne(document);

                Date end = new Date(System.currentTimeMillis());

                dataWriter.writeLine(new String[]{formatter.format(start), formatter.format(end), "instert"});


            }
            dataWriter.closeWriter();
*/
            // Our example data
            List<List<String>> rows = Arrays.asList(
                    Arrays.asList("Jean", "author", "Java"),
                    Arrays.asList("David", "editor", "Python"),
                    Arrays.asList("Scott", "editor", "Node.js")
            );

            FileWriter csvWriter = new FileWriter("new.csv");
            csvWriter.append("Name");
            csvWriter.append(",");
            csvWriter.append("Role");
            csvWriter.append(",");
            csvWriter.append("Topic");
            csvWriter.append("\n");

            for (List<String> rowData : rows) {
                csvWriter.append(String.join(",", rowData));
                csvWriter.append("\n");
            }

            csvWriter.flush();
            csvWriter.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
