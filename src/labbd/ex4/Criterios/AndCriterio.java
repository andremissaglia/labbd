package labbd.ex4.Criterios;

import javax.swing.JLabel;

public class AndCriterio extends Criterio {

    public AndCriterio() {
        super();
        JLabel lbl = new JLabel("AND");
        this.add(lbl);
        addItem(new AddCriterio());
    }
}
