package labbd.ex4;

import com.mongodb.Block;
import labbd.ex4.Criterios.AddCriterio;
import labbd.ex4.Criterios.AndCriterio;
import labbd.ex4.Criterios.Criterio;
import labbd.ex4.Criterios.ExpCriterio;
import labbd.ex4.Criterios.NotCriterio;
import labbd.ex4.Criterios.OrCriterio;
import org.bson.conversions.Bson;

public class SelecionarCriterio extends javax.swing.JFrame {
    private final Criterio criterioContainer;
    private final AddCriterio addCriterio;
    public SelecionarCriterio(AddCriterio add) {
        initComponents();
        this.criterioContainer = add.getContainer();
        this.addCriterio = add;
        cbOp1.removeAllItems();
        Ex4.fieldsArray.forEach((String t) -> {
            cbOp1.addItem(t);
        });
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        pExpressao = new javax.swing.JPanel();
        cbOp1 = new javax.swing.JComboBox<>();
        btnSelect = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        cbOperador = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        tfValor2 = new javax.swing.JTextField();
        pLogico = new javax.swing.JPanel();
        btnAnd = new javax.swing.JButton();
        btnOr = new javax.swing.JButton();
        btnNot = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        btnSelect.setText("Selecionar");
        btnSelect.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSelectActionPerformed(evt);
            }
        });

        jLabel1.setText("Operando 1");

        jLabel2.setText("Operador");

        cbOperador.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "=", "!=", "<", "<=", ">", ">=" }));

        jLabel3.setText("Operando 2");

        javax.swing.GroupLayout pExpressaoLayout = new javax.swing.GroupLayout(pExpressao);
        pExpressao.setLayout(pExpressaoLayout);
        pExpressaoLayout.setHorizontalGroup(
            pExpressaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pExpressaoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pExpressaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnSelect, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(pExpressaoLayout.createSequentialGroup()
                        .addGroup(pExpressaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pExpressaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(cbOp1, 0, 311, Short.MAX_VALUE)
                            .addComponent(cbOperador, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tfValor2))))
                .addContainerGap())
        );
        pExpressaoLayout.setVerticalGroup(
            pExpressaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pExpressaoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pExpressaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbOp1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(18, 18, 18)
                .addGroup(pExpressaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(cbOperador, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pExpressaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(tfValor2, javax.swing.GroupLayout.DEFAULT_SIZE, 33, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(btnSelect)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Expressão", pExpressao);

        btnAnd.setText("AND");
        btnAnd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAndActionPerformed(evt);
            }
        });

        btnOr.setText("OR");
        btnOr.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOrActionPerformed(evt);
            }
        });

        btnNot.setText("NOT");
        btnNot.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNotActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pLogicoLayout = new javax.swing.GroupLayout(pLogico);
        pLogico.setLayout(pLogicoLayout);
        pLogicoLayout.setHorizontalGroup(
            pLogicoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pLogicoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pLogicoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnAnd, javax.swing.GroupLayout.DEFAULT_SIZE, 402, Short.MAX_VALUE)
                    .addComponent(btnOr, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnNot, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        pLogicoLayout.setVerticalGroup(
            pLogicoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pLogicoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnAnd, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnOr, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnNot, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(25, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Lógica", pLogico);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAndActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAndActionPerformed
        this.criterioContainer.addItem(new AndCriterio(criterioContainer), addCriterio);
        this.dispose();
    }//GEN-LAST:event_btnAndActionPerformed

    private void btnOrActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOrActionPerformed
        this.criterioContainer.addItem(new OrCriterio(criterioContainer), addCriterio);
        this.dispose();
    }//GEN-LAST:event_btnOrActionPerformed

    private void btnSelectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSelectActionPerformed
        String field = ((String)cbOp1.getSelectedItem());
        String op = ((String)cbOperador.getSelectedItem());
        String value = tfValor2.getText();
        this.criterioContainer.addItem(new ExpCriterio(criterioContainer, field, op, value), addCriterio);
        this.dispose();
    }//GEN-LAST:event_btnSelectActionPerformed

    private void btnNotActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNotActionPerformed
        this.criterioContainer.addItem(new NotCriterio(criterioContainer), addCriterio);
        this.dispose();
    }//GEN-LAST:event_btnNotActionPerformed

    public static void addCriterio(AddCriterio add){
        new SelecionarCriterio(add).setVisible(true);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAnd;
    private javax.swing.JButton btnNot;
    private javax.swing.JButton btnOr;
    private javax.swing.JButton btnSelect;
    private javax.swing.JComboBox<String> cbOp1;
    private javax.swing.JComboBox<String> cbOperador;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JPanel pExpressao;
    private javax.swing.JPanel pLogico;
    private javax.swing.JTextField tfValor2;
    // End of variables declaration//GEN-END:variables
}
