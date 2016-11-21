package labbd.ex4.Criterios;

import java.util.ArrayList;
import javax.swing.JLabel;
import org.bson.Document;

public class OrCriterio extends BoolCriterio {

    public OrCriterio(Criterio container) {
        super(container);
        JLabel lbl = new JLabel("OR");
        this.add(lbl);
        this.addItem(new AddCriterio(this));
    }
    @Override
    public Document getBson(){
        Document doc = new Document();
        ArrayList<Document> criterios = new ArrayList<>();
        for(Criterio c : children){
            Document cb = c.getBson();
            if(!cb.isEmpty()){
                criterios.add(cb);
            }
            
        }
        doc.append("$or", criterios);
        return doc;
    }
}
