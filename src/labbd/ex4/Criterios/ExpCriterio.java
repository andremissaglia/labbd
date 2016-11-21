package labbd.ex4.Criterios;

import javax.swing.JLabel;

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
}
