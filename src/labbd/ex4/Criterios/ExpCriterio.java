package labbd.ex4.Criterios;

import javax.swing.JLabel;

public class ExpCriterio extends Criterio{

    public ExpCriterio(Criterio container) {
        super(container);
        JLabel lbl = new JLabel("Expression");
        this.add(lbl);
    }
    

}
