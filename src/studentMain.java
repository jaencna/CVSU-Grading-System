import javax.swing.JOptionPane;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.DriverManager;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.table.DefaultTableModel;
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */

/**
 *
 * @author josep
 */
public class studentMain extends javax.swing.JFrame {

    /**
     * Creates new form studentMain
     */
    public studentMain() {
        initComponents();
        Connect();
        LoadInfoStu();
//        Fetch();
  
    }
    
    Connection con;
    PreparedStatement pst;
    ResultSet rs;

    public void Connect(){
    
        try {
            
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost/gradingsystem","root","");
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(studentLogin.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(studentLogin.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }
    
    private void LoadInfoStu(){
    
        try {
            String stunumber = txt_stunum.getText();
            // Write your SQL query
            String sqlQuery = "SELECT * FROM stulogin_tbl ORDER BY logID DESC LIMIT 1;";

            // Create a PreparedStatement
            pst = con.prepareStatement(sqlQuery);

            // Execute the query and retrieve the result set
            rs = pst.executeQuery();
            
            // Process the result set
            while (rs.next()) {
                // Retrieve and display data from the latest record
                
                String column1Value = rs.getString("stu_Em");
                // Add more columns as needed

                // Display the data (you can customize this part based on your UI)

                
                

                pst = con.prepareStatement("SELECT * FROM studentinfo_tbl WHERE stu_Em=?");
                pst.setString(1, column1Value);
                rs = pst.executeQuery();

                if(rs.next()==true){

                    txt_stunum.setText(rs.getString(2));
                    stu_Year.setText(rs.getString(12));
                    stu_Section.setText(rs.getString(13));
                    stu_Dept.setText(rs.getString(11));
                    
                    String fname = rs.getString(3);
                    String mname = rs.getString(4);
                    String lname = rs.getString(5);
                    
                    stu_Name.setText(fname+ " " + mname + " "  + lname);
                 
                    

                } else {

                    JOptionPane.showMessageDialog(this,"No Record Found");

                }
                }

        } catch (SQLException e) {

        } 
    
    
    
    }
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel4 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        gradeTBL = new javax.swing.JTable();
        cmb_semNum = new javax.swing.JComboBox<>();
        jButton1 = new javax.swing.JButton();
        lbl_gpa = new javax.swing.JLabel();
        stu_Year = new javax.swing.JLabel();
        stu_Section = new javax.swing.JLabel();
        stu_Dept = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        stu_Name = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txt_stunum = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        cmb_Year = new javax.swing.JComboBox<>();
        jLabel11 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jButton8 = new javax.swing.JButton();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Student Main");
        setMinimumSize(new java.awt.Dimension(900, 550));
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel4.setBackground(new java.awt.Color(0, 51, 51));
        jPanel4.setForeground(new java.awt.Color(255, 255, 255));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        gradeTBL.setBackground(new java.awt.Color(204, 204, 204));
        gradeTBL.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        gradeTBL.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        gradeTBL.setForeground(new java.awt.Color(0, 51, 51));
        gradeTBL.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"", ""},
                {"", null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Subject", "Grade"
            }
        ));
        gradeTBL.setRowHeight(40);
        gradeTBL.setShowGrid(true);
        jScrollPane1.setViewportView(gradeTBL);

        jPanel4.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 250, 810, 310));

        cmb_semNum.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        cmb_semNum.setForeground(new java.awt.Color(0, 51, 51));
        cmb_semNum.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2" }));
        jPanel4.add(cmb_semNum, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 170, 60, 40));

        jButton1.setBackground(new java.awt.Color(25, 149, 73));
        jButton1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton1.setForeground(new java.awt.Color(0, 51, 51));
        jButton1.setText("Select");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel4.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 170, 80, 40));

        lbl_gpa.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        lbl_gpa.setForeground(new java.awt.Color(255, 255, 255));
        jPanel4.add(lbl_gpa, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 580, 80, 50));

        stu_Year.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        stu_Year.setForeground(new java.awt.Color(255, 255, 255));
        jPanel4.add(stu_Year, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 170, 40, 40));

        stu_Section.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        stu_Section.setForeground(new java.awt.Color(255, 255, 255));
        jPanel4.add(stu_Section, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 170, 40, 40));

        stu_Dept.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        stu_Dept.setForeground(new java.awt.Color(255, 255, 255));
        jPanel4.add(stu_Dept, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 120, 110, 40));

        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Example: INC grades aquired in the current Second Semester can only be completed until the Second Semester of the next Academic Year");
        jPanel4.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 670, 820, -1));

        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("INC - Incomplete; DRP - Dropped; S - Satisfactory; US - Unsatisfacory");
        jPanel4.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 630, -1, -1));

        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("INC and 5.00 grade(s) CAN ONLY be completed within one (1) Academic Year otherwise completion will be marked 5.00.");
        jPanel4.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 650, -1, -1));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Student Name:");
        jPanel4.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 120, -1, 40));

        stu_Name.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        stu_Name.setForeground(new java.awt.Color(255, 255, 255));
        jPanel4.add(stu_Name, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 120, 165, 40));

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Student Number:");
        jPanel4.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 120, -1, 40));

        txt_stunum.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        txt_stunum.setForeground(new java.awt.Color(255, 255, 255));
        jPanel4.add(txt_stunum, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 120, 92, 40));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Year & Section:");
        jPanel4.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 170, -1, 40));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Semester:");
        jPanel4.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 170, -1, 40));

        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Year:");
        jPanel4.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 170, -1, 40));

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("GPA:");
        jPanel4.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 580, 90, 50));

        cmb_Year.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        cmb_Year.setForeground(new java.awt.Color(0, 51, 51));
        cmb_Year.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4" }));
        jPanel4.add(cmb_Year, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 170, 60, 40));

        jLabel11.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Program:");
        jPanel4.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 120, -1, 40));

        jLabel15.setFont(new java.awt.Font("Segoe UI", 1, 150)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(63, 171, 46));
        jLabel15.setText("IMUS");
        jPanel4.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(910, 210, 410, 170));

        jLabel16.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/cvsu logo.png"))); // NOI18N
        jPanel4.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(1070, 620, 340, 320));

        jLabel18.setFont(new java.awt.Font("Segoe UI", 1, 154)); // NOI18N
        jLabel18.setText("IMUS");
        jPanel4.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(920, 220, 410, 170));

        jPanel1.setBackground(new java.awt.Color(63, 171, 46));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 48)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 51, 51));
        jLabel3.setText("Student Grade");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 0, 320, 70));

        jButton8.setBackground(new java.awt.Color(255, 0, 0));
        jButton8.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton8.setForeground(new java.awt.Color(255, 255, 255));
        jButton8.setText("Log Out");
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton8, new org.netbeans.lib.awtextra.AbsoluteConstraints(1260, 20, 100, 30));

        jPanel4.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1420, 70));

        jLabel20.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/cvsu logo.png"))); // NOI18N
        jPanel4.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(1210, 300, 340, 320));

        jLabel21.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/cvsu logo.png"))); // NOI18N
        jPanel4.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 390, 340, 320));

        jLabel19.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/cvsu logo.png"))); // NOI18N
        jPanel4.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(900, -150, 340, 320));

        jLabel22.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/cvsu logo.png"))); // NOI18N
        jPanel4.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(1210, -180, 340, 320));

        jLabel23.setFont(new java.awt.Font("Segoe UI", 1, 48)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(63, 171, 46));
        jLabel23.setText("Cavite State University");
        jPanel4.add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 170, 550, 60));

        jLabel24.setFont(new java.awt.Font("Segoe UI", 1, 48)); // NOI18N
        jLabel24.setText("Cavite State University");
        jPanel4.add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 170, 530, 70));

        getContentPane().add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1400, 750));

        getAccessibleContext().setAccessibleDescription("");

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
//        try {
//            
//            int q;
//             
//            String semName = "";
//            
//            String semNum = (String) cmb_semNum.getSelectedItem();
//            String stunum = txt_stunum.getText();
//            
//            
//            if ("1".equals(semNum)) {
//                semName = "sem1_tbl";
//            } else if ("2".equals(semNum)) {
//                semName = "sem2_tbl";
//            }
//            
//            
//            
//            pst = con.prepareStatement("SELECT * FROM "+semName+" WHERE stu_Num = ?");
//            pst.setString(1, stunum);
//            
//
//            rs = pst.executeQuery();
//            ResultSetMetaData rss = rs.getMetaData();
//            q = rss.getColumnCount();
//            
//            DefaultTableModel df = (DefaultTableModel)gradeTBL.getModel();
//            df.setRowCount(0);
//            
//            if(rs.next()){
//                String qfin = rs.getString("stu_sem1engfin");
//                String lfin = rs.getString("stu_sem1matfin");
//                String efin = rs.getString("stu_sem1scifin");
//                
//                float fqfin = Float.parseFloat(qfin);
//                float flfin = Float.parseFloat(lfin);
//                float fefin = Float.parseFloat(efin);
//                
//                float gwa = (fqfin + flfin + fefin) /3;
//                
//                lbl_gpa.setText(String.valueOf(gwa));
//                
//                
//                Vector v2 = new Vector();
//                for(int a=1; a<=q; a++){
//                
//                    v2.add(rs.getString("stu_sem1engfin"));
//                    v2.add(rs.getString("stu_sem1matfin"));
//                    v2.add(rs.getString("stu_sem1scifin"));
//                    
//                    
//                    
//                
//                }
//                df.addRow(v2);
//            }  else {
//                JOptionPane.showMessageDialog(null, "User not found!");
//            }
            
//            String stureggrade = stu_Year.getText();
//            String sturegdept = stu_Dept.getText();
//            String stregsem = cmb_semNum.getSelectedItem().toString();
//            String stunum = txt_stunum.getText();
//
//
//            String query = "SELECT * FROM subject_tbl WHERE stu_Grade = ? AND sem_Num = ? AND stu_Dept = ?";
//              pst = con.prepareStatement(query);
//              pst.setString(1, stureggrade);
//              pst.setString(2, stregsem);
//              pst.setString(3, sturegdept);
//              rs = pst.executeQuery();
//
//              // Clear existing items in studentComboBox
//
//              // Add retrieved student IDs to studentComboBox
//            while (rs.next()) {
//                String selectedSub = rs.getString("sub_Name");
//
//                PreparedStatement pstSub = con.prepareStatement("SELECT * FROM "+selectedSub+"_tbl"+" WHERE stu_Num = ?");
//                pstSub.setString(1, stunum);
//
//                ResultSet rsCheck = pstSub.executeQuery();
//
//                ResultSetMetaData rss = rsCheck.getMetaData();
//                q = rss.getColumnCount();
//
//                DefaultTableModel df = (DefaultTableModel)gradeTBL.getModel();
//                df.setRowCount(0);
//
//                  while(rsCheck.next()){
//                  
//                    
//
//                    
//                        String ffin = rsCheck.getString("fingrade");
//                        
//                        
////                        float gwa = (fqfin + flfin + fefin) /3;
//
////                        lbl_gpa.setText(String.valueOf(gwa));
//
//
//                        Vector v2 = new Vector();
//                        for(int a=1; a<=q; a++){
//
//                            v2.add(rs.getString(ffin));
//                            
//
//
//
//
//                        }
//                        df.addRow(v2);
//                  
//                  }
////                    else {
////                    JOptionPane.showMessageDialog(this, "Data Not Recorded!");
////                }
//
//              }
//            
//        } catch (SQLException ex) {
//            Logger.getLogger(teacherMain.class.getName()).log(Level.SEVERE, null, ex);
//        }

try {
    String stureggrade = cmb_Year.getSelectedItem().toString();
    String sturegdept = stu_Dept.getText();
    String stregsem = cmb_semNum.getSelectedItem().toString();
    String stunum = txt_stunum.getText();

    // Clear existing items in JTable
    DefaultTableModel df = (DefaultTableModel) gradeTBL.getModel();
    df.setRowCount(0);
    
    String query = "SELECT * FROM subject_tbl WHERE stu_Grade = ? AND sem_Num = ? AND stu_Dept = ?";
    pst = con.prepareStatement(query);
    pst.setString(1, stureggrade);
    pst.setString(2, stregsem);
    pst.setString(3, sturegdept);
    rs = pst.executeQuery();

    int count = 0; // To count the number of grades
    double sum = 0; // To store the sum of grades
    
   
    
    while (rs.next()) {
        
        String selectedSub = rs.getString("sub_Name");
        
        if (!selectedSub.matches("[a-zA-Z0-9_]+")) {
        // Handle the case where the selectedSub contains invalid characters
        continue; // Skip to the next iteration
        }
        
        PreparedStatement pstSub = con.prepareStatement("SELECT * FROM " + selectedSub + "_tbl WHERE stu_Num = ?");
        pstSub.setString(1, stunum);

        ResultSet rsCheck = pstSub.executeQuery();

        while (rsCheck.next()) {
            String ffin = rsCheck.getString("fingrade");

            Vector<Object> row = new Vector<>();
            row.add(selectedSub); // Add subject name to the first column
            row.add(ffin); // Add fingrade value to the second column

            df.addRow(row);

            // Update sum and count for averaging
            sum += Double.parseDouble(ffin);
            count++;
        }
    }

    // Calculate average fingrade
    if (count > 0) {
        double average = sum / count;
        lbl_gpa.setText(String.valueOf(average));
    } else {
        JOptionPane.showMessageDialog(this, "No grades found for the specified criteria.");
    }

} catch (SQLException ex) {
    Logger.getLogger(teacherMain.class.getName()).log(Level.SEVERE, null, ex);
}

//    try {
//        String stureggrade = stu_Year.getText();
//        String sturegdept = stu_Dept.getText();
//        String stregsem = cmb_semNum.getSelectedItem().toString();
//        String stunum = txt_stunum.getText();
//
//        // Clear existing items in JTable
//        DefaultTableModel df = (DefaultTableModel) gradeTBL.getModel();
//        df.setRowCount(0);
//
//        String query = "SELECT * FROM subject_tbl WHERE stu_Grade = ? AND sem_Num = ? AND stu_Dept = ?";
//        pst = con.prepareStatement(query);
//        pst.setString(1, stureggrade);
//        pst.setString(2, stregsem);
//        pst.setString(3, sturegdept);
//        rs = pst.executeQuery();
//
//        int count = 0; // To count the number of grades
//        double sum = 0; // To store the sum of grades
//
//        while (rs.next()) {
//            String selectedSub = rs.getString("sub_Name");
//            String selectSub = selectedSub + "_tbl";
//
//            PreparedStatement pstSub = con.prepareStatement("SELECT * FROM "+selectSub+" WHERE stu_Num = ?");
//            pstSub.setString(1, stunum);
//            
//            
//            
//            ResultSet rsCheck = pstSub.executeQuery();
//            
//            
//
//            while (rsCheck.next()) {
//                String ffin = rsCheck.getString("fingrade");
//
//                Vector<Object> row = new Vector<>();
//                row.add(selectedSub); // Add subject name to the first column
//                row.add(ffin); // Add fingrade value to the second column
//
//                df.addRow(row);
//
//                // Update sum and count for averaging
//                sum += Double.parseDouble(ffin);
//                count++;
//                
//                
//            }
//            
//        }
//
//        // Calculate average fingrade
//        if (count > 0) {
//            double average = sum / count;
//            lbl_gpa.setText(String.valueOf(average));
//        } else {
//            JOptionPane.showMessageDialog(this, "2nd Semester Grades Not Available");
//        }
//
//    } catch (SQLException ex) {
//        Logger.getLogger(teacherMain.class.getName()).log(Level.SEVERE, null, ex);
//    }

    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        // TODO add your handling code here:
        dispose();

        // Open the login form
        new studentLogin().setVisible(true);
        this.setVisible(false);;
    }//GEN-LAST:event_jButton8ActionPerformed

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
            java.util.logging.Logger.getLogger(studentMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(studentMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(studentMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(studentMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new studentMain().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> cmb_Year;
    private javax.swing.JComboBox<String> cmb_semNum;
    private javax.swing.JTable gradeTBL;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton8;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbl_gpa;
    private javax.swing.JLabel stu_Dept;
    private javax.swing.JLabel stu_Name;
    private javax.swing.JLabel stu_Section;
    private javax.swing.JLabel stu_Year;
    private javax.swing.JLabel txt_stunum;
    // End of variables declaration//GEN-END:variables
}
