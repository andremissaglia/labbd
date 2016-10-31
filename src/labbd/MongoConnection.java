package labbd;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

public class MongoConnection {
    private final static String HOST = "localhost";
    private final static int PORT = 27017;
    private final static String DBNAME = "projetofinal";
    
    private static MongoConnection con;
    
    private final MongoClient client;
    private final MongoDatabase db;
    
    private MongoConnection(){
        System.out.println("[MONGO] Connecting");
        client = new MongoClient(HOST, PORT);
        db = client.getDatabase(DBNAME);
        System.out.println("[MONGO] Connected");
    }
    private static MongoConnection obj(){
        if(con == null){
            con = new MongoConnection();
        }
        return con;
    }
    public static MongoCollection getCollection(String name){
        return obj().db.getCollection(name);
    }
    public static void close(){
        obj().client.close();
    }
}
