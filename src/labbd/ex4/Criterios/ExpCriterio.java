package labbd.ex4.Criterios;

import javax.swing.JLabel;
import org.bson.Document;

public class ExpCriterio extends Criterio{
    private final String field;
    private final String op;
    private final String value;
    public ExpCriterio(Criterio container, String field, String op, String value) {
        super(container);
        JLabel lbl = new JLabel("Expression");
        this.add(lbl);
        this.field = field;
        this.op = op;
        this.value = value;
        this.addItem(new JLabel(String.format("%s %s '%s'", field, op, value)));
    }
    
    @Override
    public Document getBson(){
        Document doc = new Document();
        Document d2 = new Document();
        switch(op){
            case "=":
                doc.append(field, value);
                break;
            case "<":
                d2.append("$lt", value);
                doc.append(field, d2);
                break;
            case "<=":
                d2.append("$lte", value);
                doc.append(field, d2);
                break;
            case ">":
                d2.append("$gt", value);
                doc.append(field, d2);
                break;
            case ">=":
                d2.append("$gte", value);
                doc.append(field, d2);
                break;
        }
        
        return doc;
    }
}
