/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package licencias_tamps;

import java.awt.Image;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

/**
 *
 * @author Julio Sosa
 */
public class frmlic extends javax.swing.JFrame {

    /**
     * Creates new form frmlic
     */
       Connection conn;
      Statement stm,stm1,stm2,stm3,stm4,stm5;
     ResultSet rs1,rs,rs2,rs3;
    String selectedImagePath = null;
    String filename = null;
    InputStream inputstream = null;
    public frmlic() {
        initComponents();
       
    }
    String curplic="";
    public frmlic(String curplic){
        this.curplic=curplic;
        initComponents();
        System.out.println(this.curplic+"yeyeye");
            try {
                
            String user = "u795221605_root1";
            String pass = "rootadmin";
            String url = "jdbc:mysql://213.190.6.85:3306/u795221605_licencias_tam";
             Class.forName("com.mysql.jdbc.Driver");

            conn = DriverManager.getConnection (url, user, pass);
            stm= conn.createStatement();
            stm1 =conn.createStatement();
          stm2=conn.createStatement();
             stm3=conn.createStatement();
              stm4=conn.createStatement();
              stm5=conn.createStatement();
        }
        catch ( ClassNotFoundException e ) {
            System.out.println(e);
        }
        catch(SQLException e) {
            System.out.println(e);
            JOptionPane.showMessageDialog(this,"Verifique su conexion a internet o consulte al administrador");
        }
            
      
        int n=0;
       System.out.println(curplic);
       try { 
           rs=stm.executeQuery("SELECT * FROM licencia WHERE curp='"+curplic+"'");
         
                   if(rs.next()){
                    
                         rs1=stm2.executeQuery("SELECT nombre,direccion,colon,id_c FROM ciudadano WHERE curp='"+rs.getString(2)+"'");
                      if(rs1.next()){
                             rs2=stm3.executeQuery("SELECT nombre FROM ciudad WHERE id_c='"+rs1.getInt(4)+"'");
                             
                             if(rs2.next()){
                                 nom.setText(rs1.getString(1));
                                 String auxx[]= rs1.getString(1).split(" ");
                                 if(auxx.length==4){
                                     nom.setText(auxx[0]+" "+auxx[1]);
                                      nom1.setText(auxx[2]+" "+auxx[3]);
                                 }
                                 else if(auxx.length==3){
                                       nom.setText(auxx[0]);
                                      nom1.setText(auxx[1]+" "+auxx[2]);
                                 }
                                 byte[] img = rs.getBytes(3);
                    ImageIcon image = new ImageIcon(img);
                    Image im = image.getImage();
                    Image myImg = im.getScaledInstance(foto1.getWidth(), foto1.getHeight(),Image.SCALE_SMOOTH);
                    ImageIcon newImage = new ImageIcon(myImg);
                             foto1.setIcon(newImage);
                               ImageIcon image1 = new ImageIcon(img);
                    Image im1 = image1.getImage();
                    Image myImg1 = im1.getScaledInstance(foto2.getWidth(), foto2.getHeight(),Image.SCALE_SMOOTH);
                    ImageIcon newImage1 = new ImageIcon(myImg1);
                    foto2.setIcon(newImage1);
                      id_lic.setText(rs.getString(1));
                   curpp.setText(rs.getString(2));
                 dire.setText(rs1.getString(2));
                 col.setText(rs1.getString(3));
                  SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd");
                            DateTimeFormatter form =DateTimeFormatter.ofPattern("yyyy-MM-dd");
                 LocalDate ld =rs.getDate(5) .toLocalDate();
                          LocalDate venc= ld;
                           java.sql.Date sqlDate = java.sql.Date.valueOf(venc);
                 f_exp.setText(format1.format(sqlDate));
                    LocalDate ld1 =rs.getDate(4) .toLocalDate();
                          LocalDate venc1= ld1;
                           java.sql.Date sqlDate1 = java.sql.Date.valueOf(venc1);
                 f_venc.setText(format1.format(sqlDate1));
                 mun.setText(rs2.getString(1));
                             }
                             
                        
                       }
                
               
                   }
            
                   
       } catch (SQLException ex) {
           System.out.println(ex);
       }
     
       
    }
  
    
   public void cargar1(){
 

      
      
        int n=0;
       System.out.println(curplic);
       try { 
           rs=stm.executeQuery("SELECT * FROM licencia WHERE curp='"+curplic+"'");
         
                   if(rs.next()){
                    
                         rs1=stm2.executeQuery("SELECT nombre,direccion,id_c FROM ciudadano WHERE curp='"+rs.getString(2)+"'");
                      if(rs1.next()){
                             rs2=stm3.executeQuery("SELECT nombre FROM ciudad WHERE id_c='"+rs1.getInt(3)+"'");
                             
                             if(rs2.next()){
                                 nom.setText(rs1.getString(1));
                                 String auxx[]= rs1.getString(1).split(" ");
                                 if(auxx.length==4){
                                     
                                 }
                                 else if(auxx.length==3){
                                     
                                 }
                             }
                        
                       }
                
               
                   }
            
                   
       } catch (SQLException ex) {
           System.out.println(ex);
       }
     
       
       
    }
       
  
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLayeredPane1 = new javax.swing.JLayeredPane();
        jPanel1 = new javax.swing.JPanel();
        foto1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        nom = new javax.swing.JLabel();
        nom1 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        curpp = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        dire = new javax.swing.JLabel();
        col = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        mun = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        f_exp = new javax.swing.JLabel();
        id_lic = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        f_venc = new javax.swing.JLabel();
        foto2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));

        jLayeredPane1.setBackground(new java.awt.Color(255, 255, 255));
        jLayeredPane1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setOpaque(false);

        jLabel2.setBackground(new java.awt.Color(51, 51, 51));
        jLabel2.setFont(new java.awt.Font("Century Gothic", 2, 11)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setText("Conductor/Driver");

        nom.setFont(new java.awt.Font("Century Gothic", 1, 16)); // NOI18N
        nom.setForeground(new java.awt.Color(0, 0, 0));
        nom.setText("jLabel3");

        nom1.setFont(new java.awt.Font("Century Gothic", 1, 16)); // NOI18N
        nom1.setForeground(new java.awt.Color(0, 0, 0));
        nom1.setText("jLabel5");

        jLabel6.setBackground(new java.awt.Color(51, 51, 51));
        jLabel6.setFont(new java.awt.Font("Century Gothic", 2, 11)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 0, 0));
        jLabel6.setText("CURP/Population Registry");

        curpp.setFont(new java.awt.Font("Century Gothic", 1, 16)); // NOI18N
        curpp.setForeground(new java.awt.Color(0, 0, 0));
        curpp.setText("jLabel7");

        jLabel8.setBackground(new java.awt.Color(51, 51, 51));
        jLabel8.setFont(new java.awt.Font("Century Gothic", 2, 11)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(0, 0, 0));
        jLabel8.setText("Dirección");

        dire.setFont(new java.awt.Font("Century Gothic", 1, 16)); // NOI18N
        dire.setForeground(new java.awt.Color(0, 0, 0));
        dire.setText("jLabel9");

        col.setFont(new java.awt.Font("Century Gothic", 1, 16)); // NOI18N
        col.setForeground(new java.awt.Color(0, 0, 0));
        col.setText("jLabel10");

        jLabel11.setBackground(new java.awt.Color(51, 51, 51));
        jLabel11.setFont(new java.awt.Font("Century Gothic", 2, 11)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(0, 0, 0));
        jLabel11.setText("Municipio");

        mun.setFont(new java.awt.Font("Century Gothic", 1, 16)); // NOI18N
        mun.setForeground(new java.awt.Color(0, 0, 0));
        mun.setText("jLabel11");

        jLabel13.setBackground(new java.awt.Color(51, 51, 51));
        jLabel13.setFont(new java.awt.Font("Century Gothic", 2, 11)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(0, 0, 0));
        jLabel13.setText("Expedición/Date Issued");

        f_exp.setFont(new java.awt.Font("Century Gothic", 1, 16)); // NOI18N
        f_exp.setForeground(new java.awt.Color(0, 0, 0));
        f_exp.setText("jLabel11");

        id_lic.setFont(new java.awt.Font("Century Gothic", 1, 16)); // NOI18N
        id_lic.setForeground(new java.awt.Color(0, 0, 0));
        id_lic.setText("jLabel17");

        jLabel18.setBackground(new java.awt.Color(51, 51, 51));
        jLabel18.setFont(new java.awt.Font("Century Gothic", 2, 11)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(0, 0, 0));
        jLabel18.setText("Vencimiento/Expiration Date");

        f_venc.setFont(new java.awt.Font("Century Gothic", 1, 16)); // NOI18N
        f_venc.setForeground(new java.awt.Color(0, 0, 0));
        f_venc.setText("jLabel19");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(109, 109, 109)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel13)
                    .addComponent(jLabel11)
                    .addComponent(jLabel8)
                    .addComponent(jLabel6)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel18, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 165, Short.MAX_VALUE)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(f_venc, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 165, Short.MAX_VALUE)
                                    .addComponent(f_exp, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(mun, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(col, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(dire, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(curpp, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(nom1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(nom, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addGap(13, 13, 13)
                                    .addComponent(foto1, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(jLabel2)))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(45, 45, 45)
                                .addComponent(id_lic, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(58, 58, 58)
                                .addComponent(foto2, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(113, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(204, 204, 204)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(foto1, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(9, 9, 9)
                        .addComponent(jLabel2)
                        .addGap(0, 0, 0)
                        .addComponent(nom)
                        .addGap(0, 0, 0)
                        .addComponent(nom1)
                        .addGap(0, 0, 0)
                        .addComponent(jLabel6)
                        .addGap(0, 0, 0)
                        .addComponent(curpp)
                        .addGap(0, 0, 0)
                        .addComponent(jLabel8)
                        .addGap(0, 0, 0)
                        .addComponent(dire)
                        .addGap(0, 0, 0)
                        .addComponent(col)
                        .addGap(0, 0, 0)
                        .addComponent(jLabel11)
                        .addGap(0, 0, 0)
                        .addComponent(mun)
                        .addGap(0, 0, 0)
                        .addComponent(jLabel13)
                        .addGap(0, 0, 0)
                        .addComponent(f_exp)
                        .addGap(0, 0, 0)
                        .addComponent(jLabel18)
                        .addGap(0, 0, 0)
                        .addComponent(f_venc))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(id_lic)
                        .addGap(99, 99, 99)
                        .addComponent(foto2, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(91, Short.MAX_VALUE))
        );

        jLayeredPane1.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 560, 710));

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/licencias_tamps/lic.png"))); // NOI18N
        jLabel4.setText("jLabel1");
        jLayeredPane1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 560, 710));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLayeredPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLayeredPane1, javax.swing.GroupLayout.Alignment.TRAILING)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
            java.util.logging.Logger.getLogger(frmlic.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmlic.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmlic.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmlic.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmlic().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel col;
    private javax.swing.JLabel curpp;
    private javax.swing.JLabel dire;
    private javax.swing.JLabel f_exp;
    private javax.swing.JLabel f_venc;
    private javax.swing.JLabel foto1;
    private javax.swing.JLabel foto2;
    private javax.swing.JLabel id_lic;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLayeredPane jLayeredPane1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel mun;
    private javax.swing.JLabel nom;
    private javax.swing.JLabel nom1;
    // End of variables declaration//GEN-END:variables
}
