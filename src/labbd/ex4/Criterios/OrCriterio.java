package labbd.ex4.Criterios;

import javax.swing.JLabel;

public class OrCriterio extends BoolCriterio {

    public OrCriterio(Criterio container) {
        super(container);
        JLabel lbl = new JLabel("OR");
        this.add(lbl);
        this.addItem(new AddCriterio(this));
    }
}
