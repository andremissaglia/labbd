package labbd.ex4.Criterios;

import javax.swing.JLabel;

public class AndCriterio extends BoolCriterio {

    public AndCriterio(Criterio container) {
        super(container);
        JLabel lbl = new JLabel("AND");
        this.add(lbl);
        this.addItem(new AddCriterio(this));
    }
}
