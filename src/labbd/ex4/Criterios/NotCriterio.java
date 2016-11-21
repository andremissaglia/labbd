package labbd.ex4.Criterios;

import javax.swing.JLabel;
import org.bson.Document;

public class NotCriterio extends BoolCriterio {

    public NotCriterio(Criterio container) {
        super(container);
        JLabel lbl = new JLabel("NOT");
        this.add(lbl);
        this.addItem(new AddCriterio(this));
    }
    @Override
    public Document getBson(){
        Document doc = new Document();
        for(Criterio c : children){
            doc.putAll(c.getBson());
        }
        Document doc2 = new Document();
        doc2.append("$not", doc);
        return doc2;
    }
}
