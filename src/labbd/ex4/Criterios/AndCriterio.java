package labbd.ex4.Criterios;

import javax.swing.JLabel;
import org.bson.Document;

public class AndCriterio extends BoolCriterio {

    public AndCriterio(Criterio container) {
        super(container);
        JLabel lbl = new JLabel("AND");
        this.add(lbl);
        this.addItem(new AddCriterio(this));
    }
    @Override
    public Document getBson(){
        Document doc = new Document();
        for(Criterio c : children){
            doc.putAll(c.getBson());
        }
        return doc;
    }
}
