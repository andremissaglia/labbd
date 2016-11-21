package labbd.ex5;

import com.mongodb.client.MongoCollection;
import java.util.ArrayList;
import java.util.Random;
import labbd.connection.MongoConnection;
import org.bson.Document;
import org.bson.types.ObjectId;

public class Ex5 {

    private static final int NFIELDS = 20;
    private static final int STRLEN = 2000;
    private ArrayList<ObjectId> objStore;

    public void insert(String collection, int amount, int store) {
        objStore = new ArrayList<>();
        MongoCollection col = MongoConnection.getCollection(collection);
        int interval = (amount + store - 1)/ store;
        for (int i = 0; i < amount; i++) {
            Document doc = tuplaRandom();
            col.insertOne(doc);
            if (i % interval == 0) {
                objStore.add(doc.getObjectId("_id"));
            }
        }
    }
    public void find(String collection, int finds){
        MongoCollection col = MongoConnection.getCollection(collection);
        for(int i = 0; i < finds; i++){
            int k  = i % objStore.size();
            Document doc = new Document();
            doc.append("_id", objStore.get(k));
            col.find(doc);
        }
    }
    private Document tuplaRandom() {
        Document doc = new Document();
        StringBuilder sb = new StringBuilder();
        Random r = new Random();
        for (int i = 0; i < STRLEN; i++) {
            char c = (char) (r.nextInt(26) + 'a');
            sb.append(c);
        }
        for (int i = 0; i < NFIELDS; i++) {
            doc.append("field" + i, sb.toString());
        }
        return doc;
    }

    public void dropCollection(String collection) {
        MongoConnection.getCollection(collection).drop();
    }
}
