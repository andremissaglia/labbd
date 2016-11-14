package labbd.ex4;

import com.mongodb.Block;
import java.util.ArrayList;
import labbd.connection.MongoConnection;

public class Ex4 {
    public ArrayList<String> getCollections(){
        ArrayList<String> collections = new ArrayList<>();
        
        MongoConnection.getDatabase().listCollectionNames().forEach(new Block<String>() {
            @Override
            public void apply(String t) {
                collections.add(t);
            }
        });
        return collections;
    }
}
