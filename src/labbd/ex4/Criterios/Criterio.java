package labbd.ex4.Criterios;

import javax.swing.BoxLayout;
import javax.swing.JComponent;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;

public abstract class Criterio extends JPanel{

    public Criterio() {
        super();
        setBorder(javax.swing.BorderFactory.createEtchedBorder());
        this.setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
    }
    protected final void addItem(JComponent c){
        Border empty = new EmptyBorder(0, 20, 0, 0);
        c.setBorder(new CompoundBorder(empty, c.getBorder()));
        this.add(c);
    }
    
}
