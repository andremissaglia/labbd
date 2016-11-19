package labbd.ex4.Criterios;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.BoxLayout;
import javax.swing.JComponent;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;

public abstract class Criterio extends JPanel implements MouseListener{
    protected final Criterio container;
    public Criterio(Criterio container) {
        super();
        setBorder(javax.swing.BorderFactory.createEtchedBorder());
        this.setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
        this.container = container;
        this.addMouseListener(this);
    }    
    protected final void addItem(JComponent c){
        Border empty = new EmptyBorder(0, 20, 0, 0);
        c.setBorder(new CompoundBorder(empty, c.getBorder()));
        this.add(c);
    }
    public final void addItem(JComponent c, AddCriterio add){
        Border empty = new EmptyBorder(0, 20, 0, 0);
        c.setBorder(new CompoundBorder(empty, c.getBorder()));
        this.remove(add);
        this.add(c);
        this.add(add);
        this.revalidate();
    }
    public void delete(){
        if(this.container == null){
            return;
        }
        this.container.remove(this);
        this.container.revalidate();
    }
    @Override
    public void mouseClicked(MouseEvent me) {
        if(me.getButton() == MouseEvent.BUTTON3){
            
            this.delete();
        }
    }

    @Override
    public void mousePressed(MouseEvent me) {
    }

    @Override
    public void mouseReleased(MouseEvent me) {
    }
    @Override
    public void mouseEntered(MouseEvent me) {
    }

    @Override
    public void mouseExited(MouseEvent me) {

    }
    public Criterio getContainer(){
        return this.container;
    }
    
}
