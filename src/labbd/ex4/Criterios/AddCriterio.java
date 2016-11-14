package labbd.ex4.Criterios;

import javax.swing.JButton;

public class AddCriterio extends Criterio{

    public AddCriterio() {
        super();
        JButton btn = new JButton("+");
        this.add(btn);
    }
    
}
