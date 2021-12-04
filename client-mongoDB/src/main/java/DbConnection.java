import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;


public class DbConnection {
    public static void main(String[] args) {
        try {


            MongoClient mongoClient = new MongoClient("localhost", 27017);
            MongoDatabase db = mongoClient.getDatabase("benchmark");

            MongoCollection<Document> table = db.getCollection("student");
            Document document = new Document("name", "Michael Kora");
            document.append("id", 123456);
            table.insertOne(document);


        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
