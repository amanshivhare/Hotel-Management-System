


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotel.management.system;


import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

/**
 *
 * @author chaudhari ji
 */
public class PassbookShow extends javax.swing.JFrame {

    /**
     * Creates new form PassbookShow
     */
    
    int userid;
    ResultSet rs;
    
    public PassbookShow(int uid,ResultSet rs) {
        this.rs=rs;
        this.userid=uid;
        initComponents();
    }
    
    

    //self defined code for getting the row count of result set
    public static int getRowCount(ResultSet rs) throws SQLException{
        int rowCount;
        rs.last(); 
        rowCount = rs.getRow();
        rs.beforeFirst();
        return rowCount;
    }
        
    public static Object[][] tableArrayGenerator(ResultSet rs) throws SQLException{
        int rowCount=getRowCount(rs);
               
        //Result Set Meta data
        ResultSetMetaData metaData = rs.getMetaData();
        int columns = metaData.getColumnCount();
        Object[][] arr= new Object [rowCount][columns] ;
        
        for(int r=0;r<rowCount;r++){
            rs.next();
            for (int c = 1; c <=columns; c++) {
                arr[r][c-1]=rs.getObject(c);
            }
        }
        return arr;
    }

    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        try{
            jScrollPane1 = new javax.swing.JScrollPane();
            passbookTable = new javax.swing.JTable();
            jLabel1 = new javax.swing.JLabel();
            backButton = new javax.swing.JButton();

            

            setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

            passbookTable.setBorder(javax.swing.BorderFactory.createCompoundBorder(new javax.swing.border.MatteBorder(null), javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0))));
            passbookTable.setModel(new javax.swing.table.DefaultTableModel(tableArrayGenerator(this.rs),
                new String [] {
                    "Date", "Expense Type", "Amount", "Note"
                }
            ) {
                Class[] types = new Class [] {
                    java.lang.Object.class, java.lang.String.class, java.lang.Float.class, java.lang.String.class
                };
                boolean[] canEdit = new boolean [] {
                    false, false, false, false
                };

                public Class getColumnClass(int columnIndex) {
                    return types [columnIndex];
                }

                public boolean isCellEditable(int rowIndex, int columnIndex) {
                    return canEdit [columnIndex];
                }
            });
            jScrollPane1.setViewportView(passbookTable);
            if (passbookTable.getColumnModel().getColumnCount() > 0) {
                passbookTable.getColumnModel().getColumn(0).setPreferredWidth(100);
                passbookTable.getColumnModel().getColumn(1).setPreferredWidth(200);
                passbookTable.getColumnModel().getColumn(2).setPreferredWidth(200);
                passbookTable.getColumnModel().getColumn(3).setPreferredWidth(500);
            }

            jLabel1.setFont(new java.awt.Font("Papyrus", 1, 32)); // NOI18N
            jLabel1.setForeground(new java.awt.Color(0, 153, 255));
            jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
            jLabel1.setText("Passbook");

            backButton.setFont(new java.awt.Font("SansSerif", 0, 24)); // NOI18N
            backButton.setText("🡐");
            backButton.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    backButtonActionPerformed(evt);
                }
            });

            javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
            getContentPane().setLayout(layout);
            layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addComponent(backButton, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(320, 320, 320)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 402, Short.MAX_VALUE))
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jScrollPane1)
                    .addContainerGap())
            );
            layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(backButton, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createSequentialGroup()
                            .addGap(30, 30, 30)
                            .addComponent(jLabel1)))
                    .addGap(18, 18, 18)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 485, Short.MAX_VALUE)
                    .addContainerGap())
            );

            pack();
            setLocationRelativeTo(null);
        }catch(Exception e){
            System.out.println(e);
        }
    }// </editor-fold>//GEN-END:initComponents

    private void backButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backButtonActionPerformed
        // TODO add your handling code here:
        dispose();
        new PassbookSearch(userid).setVisible(true);
    }//GEN-LAST:event_backButtonActionPerformed

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
            java.util.logging.Logger.getLogger(PassbookShow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PassbookShow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PassbookShow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PassbookShow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

//        /* Create and display the form */
        
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new PassbookShow().setVisible(true);
//            }
//        });
        
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton backButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable passbookTable;
    // End of variables declaration//GEN-END:variables
}
