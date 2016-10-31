package labbd;

import com.mongodb.BasicDBObject;
import com.mongodb.Block;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.model.Filters;
import org.bson.Document;

public class Labbd {

    public static void main(String[] args) {
        MongoCollection table = MongoConnection.getCollection("teste");
        BasicDBObject document = new BasicDBObject();
        table.insertOne(new Document()
                .append("nome", "joao")
                .append("idade", 30)
        );
        table.find().forEach(new Block<Document>() {
            @Override
            public void apply(Document t) {
                System.out.println(t.get("nome") + ":" + t.get("idade"));
            }
        });
        /*Find*/
        table.find(Filters.gt("idade", 10)).forEach(new Block<Document>() {
            @Override
            public void apply(Document t) {
                System.out.println(t.get("nome") + "::" + t.get("idade"));
            }
        });;
    }

}
