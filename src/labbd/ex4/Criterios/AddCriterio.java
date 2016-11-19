package labbd.ex4.Criterios;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import labbd.ex4.SelecionarCriterio;

public class AddCriterio extends Criterio implements ActionListener {

    public AddCriterio(Criterio container) {
        super(container);
        JButton btn = new JButton("+");
        btn.addActionListener(this);
        this.add(btn);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        SelecionarCriterio.addCriterio(this);
    }

    @Override
    public void delete() {
        if (this.container == null) {
            return;
        }
        this.container.delete();
    }
}
