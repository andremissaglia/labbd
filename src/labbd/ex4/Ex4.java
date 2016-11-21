package labbd.ex4;

import com.mongodb.Block;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.function.BiConsumer;
import labbd.connection.MongoConnection;
import org.bson.Document;

public class Ex4 {

    public static ArrayList<String> fieldsArray;

    public ArrayList<String> getCollections() {
        ArrayList<String> collections = new ArrayList<>();

        MongoConnection.getDatabase().listCollectionNames().forEach(new Block<String>() {
            @Override
            public void apply(String t) {
                collections.add(t);
            }
        });
        return collections;
    }

    public void getFields(String collection) {
        fieldsArray = new ArrayList<>();
        HashSet<String> fields = new HashSet<>();
        MongoConnection.getCollection(collection).find().forEach(new Block() {
            @Override
            public void apply(Object t) {
                Document doc = (Document) t;
                addKeys(fields, doc, "");
            }
        });
        for (String field : fields) {
            fieldsArray.add(field);
        }
    }

    public void addKeys(HashSet hs, Document doc, String prefix) {
        doc.forEach(new BiConsumer<String, Object>() {
            @Override
            public void accept(String t, Object u) {
                if(u instanceof Document){
                    addKeys(hs, (Document) u, prefix + t + ".");
                } else {
                    hs.add(prefix+t);
                }
                
                
            }
        });
    }
}
