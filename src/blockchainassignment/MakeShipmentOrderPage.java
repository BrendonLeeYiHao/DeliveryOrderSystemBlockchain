/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package blockchainassignment;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.Random;
import javax.swing.JOptionPane;

/**
 *
 * @author Acer
 */
public class MakeShipmentOrderPage extends javax.swing.JFrame {

    public static String username;
    /**
     * Creates new form MakeShipmentOrder
     */
    public MakeShipmentOrderPage(String name) {
        initComponents();
        username = name;
        txtOrderID.setText(getUniqueId());
        try{
            BufferedReader myfile = new BufferedReader(new FileReader("UserFile.txt"));
            String [] lineArr;
            String line;
            while((line = myfile.readLine())!=null){
                lineArr = line.split(" , ");
                if(lineArr[3].equals("Staff")){
                    cmbDeliveryman.addItem(lineArr[0]);
                }
            }
        }
        catch(IOException e){
            e.printStackTrace();
        }
    }
    
    public MakeShipmentOrderPage(){}

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblTitle = new javax.swing.JLabel();
        lblOrderID = new javax.swing.JLabel();
        lblRecipientAddress = new javax.swing.JLabel();
        lblSenderAddress1 = new javax.swing.JLabel();
        lblDimension = new javax.swing.JLabel();
        lblWeight = new javax.swing.JLabel();
        lblFragility = new javax.swing.JLabel();
        lblPaymentAmount = new javax.swing.JLabel();
        lblPaymentMethod1 = new javax.swing.JLabel();
        txtSenderAddress = new javax.swing.JTextField();
        txtRecipientAddress = new javax.swing.JTextField();
        txtWeight = new javax.swing.JTextField();
        txtPaymentAmount = new javax.swing.JTextField();
        cmbDimension = new javax.swing.JComboBox<>();
        cmbFragility = new javax.swing.JComboBox<>();
        cmbPaymentMethod = new javax.swing.JComboBox<>();
        btnSubmit = new javax.swing.JButton();
        btnBack = new javax.swing.JButton();
        txtOrderID = new javax.swing.JTextField();
        lblFragility1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtAreaDescription = new javax.swing.JTextArea();
        btnViewTransaction = new javax.swing.JButton();
        lblPaymentAmount1 = new javax.swing.JLabel();
        cmbDeliveryman = new javax.swing.JComboBox<>();
        btnViewLedger = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lblTitle.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        lblTitle.setText("Make Shipment Order");

        lblOrderID.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        lblOrderID.setText("OrderID");

        lblRecipientAddress.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        lblRecipientAddress.setText("Recipient Address");

        lblSenderAddress1.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        lblSenderAddress1.setText("Sender Address");

        lblDimension.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        lblDimension.setText("Parcel Dimension");

        lblWeight.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        lblWeight.setText("Weight (kg)");

        lblFragility.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        lblFragility.setText("Fragility");

        lblPaymentAmount.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        lblPaymentAmount.setText("Payment Amount");

        lblPaymentMethod1.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        lblPaymentMethod1.setText("Payment Method");

        txtSenderAddress.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSenderAddressActionPerformed(evt);
            }
        });

        txtRecipientAddress.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtRecipientAddressActionPerformed(evt);
            }
        });

        txtWeight.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtWeightActionPerformed(evt);
            }
        });

        txtPaymentAmount.setEditable(false);
        txtPaymentAmount.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPaymentAmountActionPerformed(evt);
            }
        });

        cmbDimension.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "50 x 50 x 50", "80 x 80 x 80", "100 x 100 x 100", "150 x 150 x 150", "200 x 200 x 200" }));
        cmbDimension.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbDimensionActionPerformed(evt);
            }
        });

        cmbFragility.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Yes", "No" }));
        cmbFragility.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbFragilityActionPerformed(evt);
            }
        });

        cmbPaymentMethod.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Debit/Credit Card", "Touch N Go eWallet", "GrabPay", "ApplePay", " " }));

        btnSubmit.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        btnSubmit.setText("Submit");
        btnSubmit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSubmitActionPerformed(evt);
            }
        });

        btnBack.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        btnBack.setText("Back");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });

        txtOrderID.setEditable(false);

        lblFragility1.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        lblFragility1.setText("Description");

        txtAreaDescription.setColumns(20);
        txtAreaDescription.setRows(5);
        jScrollPane1.setViewportView(txtAreaDescription);

        btnViewTransaction.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        btnViewTransaction.setText("View Transaction");
        btnViewTransaction.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnViewTransactionActionPerformed(evt);
            }
        });

        lblPaymentAmount1.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        lblPaymentAmount1.setText("Delivery person");

        cmbDeliveryman.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbDeliverymanActionPerformed(evt);
            }
        });

        btnViewLedger.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        btnViewLedger.setText("View Ledger");
        btnViewLedger.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnViewLedgerActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(122, 122, 122)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnSubmit, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblSenderAddress1, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblOrderID, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblRecipientAddress, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblDimension, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblWeight, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblFragility, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblPaymentMethod1, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblPaymentAmount, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblFragility1, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblPaymentAmount1, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(67, 67, 67)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(cmbDeliveryman, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtWeight)
                            .addComponent(txtRecipientAddress)
                            .addComponent(txtSenderAddress)
                            .addComponent(txtPaymentAmount)
                            .addComponent(cmbDimension, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cmbFragility, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cmbPaymentMethod, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtOrderID)
                            .addComponent(jScrollPane1))))
                .addContainerGap(110, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnViewTransaction, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnViewLedger, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(43, 43, 43)
                .addComponent(lblTitle)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnBack, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(45, 45, 45))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblTitle)
                            .addComponent(btnBack)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(7, 7, 7)
                        .addComponent(btnViewTransaction)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnViewLedger)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblOrderID)
                    .addComponent(txtOrderID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblSenderAddress1)
                    .addComponent(txtSenderAddress, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblRecipientAddress)
                    .addComponent(txtRecipientAddress, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblDimension)
                    .addComponent(cmbDimension, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblWeight)
                    .addComponent(txtWeight, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblFragility)
                    .addComponent(cmbFragility, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblFragility1)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblPaymentMethod1)
                    .addComponent(cmbPaymentMethod, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblPaymentAmount)
                    .addComponent(txtPaymentAmount, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblPaymentAmount1)
                    .addComponent(cmbDeliveryman, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15)
                .addComponent(btnSubmit)
                .addGap(7, 7, 7))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtSenderAddressActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSenderAddressActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSenderAddressActionPerformed

    private void txtRecipientAddressActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtRecipientAddressActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtRecipientAddressActionPerformed

    private void txtWeightActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtWeightActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtWeightActionPerformed

    private void txtPaymentAmountActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPaymentAmountActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPaymentAmountActionPerformed

    private void cmbFragilityActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbFragilityActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbFragilityActionPerformed

    private void btnSubmitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSubmitActionPerformed
        String formattedWeight = "";
        if(!ShipmentOrder.validAddress.test(txtSenderAddress.getText())){
            JOptionPane.showMessageDialog(null, "Incorrect Sender Address", "Error Message", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        if(!ShipmentOrder.validAddress.test(txtRecipientAddress.getText())){
            JOptionPane.showMessageDialog(null, "Incorrect Recipient Address","Error Message", JOptionPane.ERROR_MESSAGE);
            return;
        }
       
        if(ShipmentOrder.validWeights.test(txtWeight.getText())){
            DecimalFormat df = new DecimalFormat("#.##");
            formattedWeight = df.format(Double.parseDouble(txtWeight.getText()));
        }
        else{
            JOptionPane.showMessageDialog(null, "Incorrect Weight! (Only 0.1 - 100)kg is acceptable","Error Message", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        if(!ShipmentOrder.validDescription.test(txtAreaDescription.getText())){
            JOptionPane.showMessageDialog(null, "Pls provide description","Error Message", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        int paymentAmount = ShipmentOrder.showDeliveryFees.apply(Double.parseDouble(formattedWeight));
        txtPaymentAmount.setText(String.valueOf(paymentAmount));
        
        if(ShipmentOrder.confirmAddOrder(txtOrderID.getText(), txtSenderAddress.getText(), txtRecipientAddress.getText(), cmbDimension.getSelectedItem().toString(), formattedWeight, cmbFragility.getSelectedItem().toString(), txtAreaDescription.getText(), cmbPaymentMethod.getSelectedItem().toString(), String.valueOf(paymentAmount), cmbDeliveryman.getSelectedItem().toString())){
            ShipmentOrder order = new ShipmentOrder(username, txtOrderID.getText(), txtSenderAddress.getText(), txtRecipientAddress.getText(), cmbDimension.getSelectedItem().toString(), formattedWeight, cmbFragility.getSelectedItem().toString(), txtAreaDescription.getText(), cmbPaymentMethod.getSelectedItem().toString(), String.valueOf(paymentAmount), cmbDeliveryman.getSelectedItem().toString());  
            try{
                order.addOrder(username);
            }catch(Exception e){
                e.printStackTrace();
            }
            JOptionPane.showMessageDialog(null, "Shipment Order Made Successfully");
            btnBack.doClick();
        }
    }//GEN-LAST:event_btnSubmitActionPerformed

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        this.setVisible(false);
    }//GEN-LAST:event_btnBackActionPerformed

    private void btnViewTransactionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnViewTransactionActionPerformed
        new ViewTransactionPage(username).setVisible(true);
    }//GEN-LAST:event_btnViewTransactionActionPerformed

    private void cmbDeliverymanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbDeliverymanActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbDeliverymanActionPerformed

    private void cmbDimensionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbDimensionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbDimensionActionPerformed

    private void btnViewLedgerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnViewLedgerActionPerformed
        Ledger l = new Ledger();
        l.setVisible(true);
    }//GEN-LAST:event_btnViewLedgerActionPerformed

    public String getUniqueId(){
        Random r = new Random();
        return "Order" + Integer.toString(r.nextInt(99999-00000) + 00000);
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MakeShipmentOrderPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MakeShipmentOrderPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MakeShipmentOrderPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MakeShipmentOrderPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new MakeShipmentOrderPage().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnSubmit;
    private javax.swing.JButton btnViewLedger;
    private javax.swing.JButton btnViewTransaction;
    private javax.swing.JComboBox<String> cmbDeliveryman;
    private javax.swing.JComboBox<String> cmbDimension;
    private javax.swing.JComboBox<String> cmbFragility;
    private javax.swing.JComboBox<String> cmbPaymentMethod;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblDimension;
    private javax.swing.JLabel lblFragility;
    private javax.swing.JLabel lblFragility1;
    private javax.swing.JLabel lblOrderID;
    private javax.swing.JLabel lblPaymentAmount;
    private javax.swing.JLabel lblPaymentAmount1;
    private javax.swing.JLabel lblPaymentMethod1;
    private javax.swing.JLabel lblRecipientAddress;
    private javax.swing.JLabel lblSenderAddress1;
    private javax.swing.JLabel lblTitle;
    private javax.swing.JLabel lblWeight;
    private javax.swing.JTextArea txtAreaDescription;
    private javax.swing.JTextField txtOrderID;
    private javax.swing.JTextField txtPaymentAmount;
    private javax.swing.JTextField txtRecipientAddress;
    private javax.swing.JTextField txtSenderAddress;
    private javax.swing.JTextField txtWeight;
    // End of variables declaration//GEN-END:variables
}
