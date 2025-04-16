import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
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
import javax.swing.JFileChooser;
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
public class teacherMain extends javax.swing.JFrame {

    /**
     * Creates new form teacherMain
     */
    public teacherMain() {
        initComponents();
        Connect();
        LoadInfoTeach();
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
    
   private void LoadInfoTeach(){
     
        try {

            // Write your SQL query
            String sqlQuery = "SELECT * FROM tealogin_tbl ORDER BY curlogID DESC LIMIT 1;";

            // Create a PreparedStatement
            pst = con.prepareStatement(sqlQuery);

            // Execute the query and retrieve the result set
            rs = pst.executeQuery();
            
            // Process the result set
            while (rs.next()) {
                // Retrieve and display data from the latest record
                
                String column1Value = rs.getString("tea_Em");
                
                
                
                
                // Add more columns as needed

                // Display the data (you can customize this part based on your UI)

                
                

                pst = con.prepareStatement("SELECT * FROM teainfo_tbl WHERE tea_em=?");
                pst.setString(1, column1Value);
                rs = pst.executeQuery();

                if(rs.next()==true){
                    
                        
                    
//                    sectionComboBox.addItem(rs.getString(10));
//                    sectionComboBox.addItem(rs.getString(11));
//                    sectionComboBox.addItem(rs.getString(12));
                    
                    
                    lbl_prog1.setText(rs.getString(8));
                    lbl_year1.setText(rs.getString(9));
                    lbl_teainfonum.setText(" "+rs.getString(2));
                    lbl_teainfolname.setText(" "+rs.getString(5)+ ", "+ rs.getString(3)+" "+rs.getString(4)+".");
                    lbl_teainfopass.setText(" "+rs.getString(7));
                    lbl_teainfoem.setText(" "+rs.getString(6));
                    lbl_teainfodept.setText(" "+rs.getString(8));
                    lbl_sub.setText(rs.getString(13));
                    sectionComboBox.addItem(rs.getString(10));
                    sectionComboBox.addItem(rs.getString(11));
                    sectionComboBox.addItem(rs.getString(12));


                } else {

                    JOptionPane.showMessageDialog(this,"No Record Found");

                }
                }

        } catch (SQLException e) {

        } 
    
    
    
    }
    
  
    
//    private void Fetch(){
//    
//        try {
//            
//            int q;
//             
//            String tableName;
//            
//            String stuDept = (String) deptComboBox.getSelectedItem();
//            String stuGrade = (String) gradeComboBox.getSelectedItem();
//            String stuSect = (String) sectionComboBox.getSelectedItem();        
//            String stuSub = (String) cmb_subject.getSelectedItem();
//            
//            if ("English".equals(stuSect)) {
//                tableName = "english_tbl";
//            } else if ("Science".equals(stuSect)) {
//                tableName = "science_tbl";
//            } else {
//                // Handle other cases or set a default table name
//                tableName = "math_tbl";
//            }
//            
//            
//            
//            pst = con.prepareStatement("SELECT * FROM "+tableName+" WHERE stu_Dept = ? AND stu_Grade = ? AND stu_Sect = ?");
//            pst.setString(1, stuDept);
//            pst.setString(2, stuGrade);
//            pst.setString(3, stuSect);
//
//            rs = pst.executeQuery();
//            ResultSetMetaData rss = rs.getMetaData();
//            q = rss.getColumnCount();
//            
//            DefaultTableModel df = (DefaultTableModel)tbl_teaview.getModel();
//            df.setRowCount(0);
//            
//            while(rs.next()){
//            
//                Vector v2 = new Vector();
//                for(int a=1; a<=q; a++){
//                
//                    v2.add(rs.getString("stu_Num"));
//                    v2.add(rs.getString("stu_Fname"));
//                    v2.add(rs.getString("stu_Lname"));
//                    v2.add(rs.getString("stu_Dept"));
//                    v2.add(rs.getString("stu_Grade"));
//                    v2.add(rs.getString("stu_Sect"));
//                    v2.add(rs.getString("q1"));
//                    v2.add(rs.getString("q2"));
//                    v2.add(rs.getString("q3"));
//                    v2.add(rs.getString("l1"));
//                    v2.add(rs.getString("l2"));
//                    v2.add(rs.getString("l3"));
//                    v2.add(rs.getString("mid"));
//                    v2.add(rs.getString("fin"));
//                    v2.add(rs.getString("qave"));
//                    v2.add(rs.getString("lave"));
//                    v2.add(rs.getString("eave"));
//                    
//                    
//                
//                }
//                df.addRow(v2);
//            }
//            
//        } catch (SQLException ex) {
//            Logger.getLogger(teacherMain.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        
//    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        popupMenu1 = new java.awt.PopupMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        jMenuBar2 = new javax.swing.JMenuBar();
        jMenu4 = new javax.swing.JMenu();
        jMenu5 = new javax.swing.JMenu();
        jMenuBar3 = new javax.swing.JMenuBar();
        jMenu6 = new javax.swing.JMenu();
        jMenu7 = new javax.swing.JMenu();
        jMenuBar4 = new javax.swing.JMenuBar();
        jMenu8 = new javax.swing.JMenu();
        jMenu9 = new javax.swing.JMenu();
        jTabbedPane2 = new javax.swing.JTabbedPane();
        jPanel3 = new javax.swing.JPanel();
        tabbedPaneCustom1 = new raven.tabbed.TabbedPaneCustom();
        jPanel1 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        txt_q1 = new javax.swing.JTextField();
        txt_q2 = new javax.swing.JTextField();
        txt_q3 = new javax.swing.JTextField();
        txt_lab1 = new javax.swing.JTextField();
        txt_lab2 = new javax.swing.JTextField();
        txt_mid = new javax.swing.JTextField();
        txt_fin = new javax.swing.JTextField();
        txt_lovertot = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        sectionComboBox = new javax.swing.JComboBox<>();
        txt_q1tot = new javax.swing.JTextField();
        txt_lscortot = new javax.swing.JTextField();
        btn_updateGrade = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_teaview = new javax.swing.JTable();
        updateStudentComboBox = new javax.swing.JButton();
        studentComboBox = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        lbl_stuyear = new javax.swing.JLabel();
        lbl_stufname = new javax.swing.JLabel();
        lbl_stusect = new javax.swing.JLabel();
        lbl_stugen = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        txt_lab3 = new javax.swing.JTextField();
        txt_q3tot = new javax.swing.JTextField();
        txt_lab2tot = new javax.swing.JTextField();
        txt_lab1tot = new javax.swing.JTextField();
        txt_q2tot = new javax.swing.JTextField();
        txt_lab3tot = new javax.swing.JTextField();
        txt_midtot = new javax.swing.JTextField();
        txt_fintot = new javax.swing.JTextField();
        txt_qovertot = new javax.swing.JTextField();
        txt_qscortot = new javax.swing.JTextField();
        txt_exovertot = new javax.swing.JTextField();
        txt_exscortot = new javax.swing.JTextField();
        txt_quizave = new javax.swing.JTextField();
        txt_labave = new javax.swing.JTextField();
        txt_exave = new javax.swing.JTextField();
        btn_addtottalitem = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        cmb_semNum = new javax.swing.JComboBox<>();
        jButton3 = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        lbl_prog1 = new javax.swing.JLabel();
        lbl_sub = new javax.swing.JLabel();
        lbl_year1 = new javax.swing.JLabel();
        jButton9 = new javax.swing.JButton();
        lbl_stuprog = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        txt_teainfonum = new javax.swing.JPanel();
        jLabel26 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        lbl_teainfolname = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        lbl_teainfonum = new javax.swing.JLabel();
        lbl_teainfoem = new javax.swing.JLabel();
        lbl_teainfopass = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        lbl_teainfodept = new javax.swing.JLabel();
        jButton8 = new javax.swing.JButton();
        jLabel27 = new javax.swing.JLabel();

        popupMenu1.setLabel("popupMenu1");

        jMenuItem1.setText("jMenuItem1");

        jMenuItem2.setText("jMenuItem2");

        jMenu3.setText("jMenu3");

        jMenu4.setText("File");
        jMenuBar2.add(jMenu4);

        jMenu5.setText("Edit");
        jMenuBar2.add(jMenu5);

        jMenu6.setText("File");
        jMenuBar3.add(jMenu6);

        jMenu7.setText("Edit");
        jMenuBar3.add(jMenu7);

        jMenu8.setText("File");
        jMenuBar4.add(jMenu8);

        jMenu9.setText("Edit");
        jMenuBar4.add(jMenu9);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Teacher Main");
        setBackground(new java.awt.Color(51, 0, 0));
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        getContentPane().add(jTabbedPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 10, -1, -1));

        jPanel3.setBackground(new java.awt.Color(0, 51, 51));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tabbedPaneCustom1.setForeground(new java.awt.Color(0, 51, 51));
        tabbedPaneCustom1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        tabbedPaneCustom1.setSelectedColor(new java.awt.Color(42, 145, 52));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jButton1.setForeground(new java.awt.Color(0, 51, 51));
        jButton1.setText("Register Student");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1520, 440, -1, -1));

        txt_q1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txt_q1.setForeground(new java.awt.Color(0, 51, 51));
        txt_q1.setMinimumSize(new java.awt.Dimension(85, 22));
        txt_q1.setPreferredSize(new java.awt.Dimension(64, 30));
        txt_q1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_q1ActionPerformed(evt);
            }
        });
        jPanel1.add(txt_q1, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 130, 85, 30));

        txt_q2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txt_q2.setForeground(new java.awt.Color(0, 51, 51));
        txt_q2.setMinimumSize(new java.awt.Dimension(85, 22));
        txt_q2.setPreferredSize(new java.awt.Dimension(64, 30));
        jPanel1.add(txt_q2, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 170, 85, 30));

        txt_q3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txt_q3.setForeground(new java.awt.Color(0, 51, 51));
        txt_q3.setMinimumSize(new java.awt.Dimension(85, 22));
        txt_q3.setPreferredSize(new java.awt.Dimension(64, 30));
        jPanel1.add(txt_q3, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 210, 85, 30));

        txt_lab1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txt_lab1.setForeground(new java.awt.Color(0, 51, 51));
        txt_lab1.setMinimumSize(new java.awt.Dimension(85, 22));
        txt_lab1.setPreferredSize(new java.awt.Dimension(64, 30));
        jPanel1.add(txt_lab1, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 130, 85, 30));

        txt_lab2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txt_lab2.setForeground(new java.awt.Color(0, 51, 51));
        txt_lab2.setMinimumSize(new java.awt.Dimension(85, 22));
        txt_lab2.setPreferredSize(new java.awt.Dimension(64, 30));
        jPanel1.add(txt_lab2, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 170, 85, 30));

        txt_mid.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txt_mid.setForeground(new java.awt.Color(0, 51, 51));
        txt_mid.setMinimumSize(new java.awt.Dimension(85, 22));
        txt_mid.setPreferredSize(new java.awt.Dimension(64, 30));
        jPanel1.add(txt_mid, new org.netbeans.lib.awtextra.AbsoluteConstraints(970, 130, 85, 30));

        txt_fin.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txt_fin.setForeground(new java.awt.Color(0, 51, 51));
        txt_fin.setMinimumSize(new java.awt.Dimension(85, 22));
        txt_fin.setPreferredSize(new java.awt.Dimension(64, 30));
        jPanel1.add(txt_fin, new org.netbeans.lib.awtextra.AbsoluteConstraints(970, 170, 85, 30));

        txt_lovertot.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txt_lovertot.setForeground(new java.awt.Color(0, 51, 51));
        txt_lovertot.setMinimumSize(new java.awt.Dimension(85, 22));
        txt_lovertot.setPreferredSize(new java.awt.Dimension(64, 30));
        jPanel1.add(txt_lovertot, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 260, 85, 30));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 51, 51));
        jLabel1.setText("QUIZESS");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 80, -1, -1));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 51, 51));
        jLabel2.setText("LABORATORY");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 80, -1, -1));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 51, 51));
        jLabel3.setText("Total:");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(910, 110, 40, -1));

        sectionComboBox.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        sectionComboBox.setForeground(new java.awt.Color(0, 51, 51));
        jPanel1.add(sectionComboBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 280, 120, 30));

        txt_q1tot.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txt_q1tot.setForeground(new java.awt.Color(0, 51, 51));
        txt_q1tot.setText("0");
        txt_q1tot.setMinimumSize(new java.awt.Dimension(85, 22));
        txt_q1tot.setPreferredSize(new java.awt.Dimension(64, 30));
        jPanel1.add(txt_q1tot, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 130, 85, 30));

        txt_lscortot.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txt_lscortot.setForeground(new java.awt.Color(0, 51, 51));
        txt_lscortot.setMinimumSize(new java.awt.Dimension(85, 22));
        txt_lscortot.setPreferredSize(new java.awt.Dimension(64, 30));
        jPanel1.add(txt_lscortot, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 260, 85, 30));

        btn_updateGrade.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btn_updateGrade.setForeground(new java.awt.Color(0, 51, 51));
        btn_updateGrade.setText("Update Grade");
        btn_updateGrade.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_updateGradeActionPerformed(evt);
            }
        });
        jPanel1.add(btn_updateGrade, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 380, 140, -1));

        tbl_teaview.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        tbl_teaview.setForeground(new java.awt.Color(0, 51, 51));
        tbl_teaview.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Student #", "First Name", "Last Name", "Department", "Year", "Section", "Quiz 1", "Quiz 2", "Quiz 3", "Lab 1", "Lab 2", "Lab 3", "Mid Terms", "Finals", "Quiz Ave", "Lab Ave", "Exam Ave", "Final Grade"
            }
        ));
        tbl_teaview.setRowHeight(30);
        tbl_teaview.setSelectionForeground(new java.awt.Color(0, 51, 51));
        jScrollPane1.setViewportView(tbl_teaview);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 500, 1570, 350));

        updateStudentComboBox.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        updateStudentComboBox.setForeground(new java.awt.Color(0, 51, 51));
        updateStudentComboBox.setText("Search Class");
        updateStudentComboBox.setPreferredSize(null);
        updateStudentComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateStudentComboBoxActionPerformed(evt);
            }
        });
        jPanel1.add(updateStudentComboBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 380, 160, -1));

        studentComboBox.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        studentComboBox.setForeground(new java.awt.Color(0, 51, 51));
        jPanel1.add(studentComboBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 330, 120, 30));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 51, 51));
        jLabel5.setText("Semester:");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 160, 90, 30));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 51, 51));
        jLabel6.setText("Year:");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 240, 50, 30));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 51, 51));
        jLabel7.setText("Student No:");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 330, 110, 30));

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(0, 51, 51));
        jLabel8.setText("Subject:");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 110, -1, 30));

        lbl_stuyear.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lbl_stuyear.setForeground(new java.awt.Color(0, 51, 51));
        jPanel1.add(lbl_stuyear, new org.netbeans.lib.awtextra.AbsoluteConstraints(1420, 220, 20, 30));

        lbl_stufname.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lbl_stufname.setForeground(new java.awt.Color(0, 51, 51));
        jPanel1.add(lbl_stufname, new org.netbeans.lib.awtextra.AbsoluteConstraints(1420, 100, 250, 30));

        lbl_stusect.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jPanel1.add(lbl_stusect, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 20, 20, 30));

        lbl_stugen.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lbl_stugen.setForeground(new java.awt.Color(0, 51, 51));
        jPanel1.add(lbl_stugen, new org.netbeans.lib.awtextra.AbsoluteConstraints(1420, 140, 132, 30));

        jButton2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton2.setForeground(new java.awt.Color(0, 51, 51));
        jButton2.setText("Search Student Info");
        jButton2.setPreferredSize(null);
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 420, -1, 30));

        txt_lab3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txt_lab3.setForeground(new java.awt.Color(0, 51, 51));
        txt_lab3.setMinimumSize(new java.awt.Dimension(85, 22));
        txt_lab3.setPreferredSize(new java.awt.Dimension(64, 30));
        jPanel1.add(txt_lab3, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 210, 85, 30));

        txt_q3tot.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txt_q3tot.setForeground(new java.awt.Color(0, 51, 51));
        txt_q3tot.setText("0");
        txt_q3tot.setMinimumSize(new java.awt.Dimension(85, 22));
        txt_q3tot.setPreferredSize(new java.awt.Dimension(64, 30));
        jPanel1.add(txt_q3tot, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 210, 85, 30));

        txt_lab2tot.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txt_lab2tot.setForeground(new java.awt.Color(0, 51, 51));
        txt_lab2tot.setText("0");
        txt_lab2tot.setMinimumSize(new java.awt.Dimension(85, 22));
        txt_lab2tot.setPreferredSize(new java.awt.Dimension(64, 30));
        jPanel1.add(txt_lab2tot, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 170, 85, 30));

        txt_lab1tot.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txt_lab1tot.setForeground(new java.awt.Color(0, 51, 51));
        txt_lab1tot.setText("0");
        txt_lab1tot.setMinimumSize(new java.awt.Dimension(85, 22));
        txt_lab1tot.setPreferredSize(new java.awt.Dimension(64, 30));
        jPanel1.add(txt_lab1tot, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 130, 85, 30));

        txt_q2tot.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txt_q2tot.setForeground(new java.awt.Color(0, 51, 51));
        txt_q2tot.setText("0");
        txt_q2tot.setMinimumSize(new java.awt.Dimension(85, 22));
        txt_q2tot.setPreferredSize(new java.awt.Dimension(64, 30));
        jPanel1.add(txt_q2tot, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 170, 85, 30));

        txt_lab3tot.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txt_lab3tot.setForeground(new java.awt.Color(0, 51, 51));
        txt_lab3tot.setText("0");
        txt_lab3tot.setMinimumSize(new java.awt.Dimension(85, 22));
        txt_lab3tot.setPreferredSize(new java.awt.Dimension(64, 30));
        jPanel1.add(txt_lab3tot, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 210, 85, 30));

        txt_midtot.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txt_midtot.setForeground(new java.awt.Color(0, 51, 51));
        txt_midtot.setText("0");
        txt_midtot.setMinimumSize(new java.awt.Dimension(85, 22));
        txt_midtot.setPreferredSize(new java.awt.Dimension(64, 30));
        jPanel1.add(txt_midtot, new org.netbeans.lib.awtextra.AbsoluteConstraints(880, 130, 85, 30));

        txt_fintot.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txt_fintot.setForeground(new java.awt.Color(0, 51, 51));
        txt_fintot.setText("0");
        txt_fintot.setMinimumSize(new java.awt.Dimension(85, 22));
        txt_fintot.setPreferredSize(new java.awt.Dimension(64, 30));
        jPanel1.add(txt_fintot, new org.netbeans.lib.awtextra.AbsoluteConstraints(880, 170, 85, 30));

        txt_qovertot.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txt_qovertot.setForeground(new java.awt.Color(0, 51, 51));
        txt_qovertot.setMinimumSize(new java.awt.Dimension(85, 22));
        txt_qovertot.setPreferredSize(new java.awt.Dimension(64, 30));
        jPanel1.add(txt_qovertot, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 260, 85, 30));

        txt_qscortot.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txt_qscortot.setForeground(new java.awt.Color(0, 51, 51));
        txt_qscortot.setMinimumSize(new java.awt.Dimension(85, 22));
        txt_qscortot.setPreferredSize(new java.awt.Dimension(64, 30));
        jPanel1.add(txt_qscortot, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 260, 85, 30));

        txt_exovertot.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txt_exovertot.setForeground(new java.awt.Color(0, 51, 51));
        txt_exovertot.setMinimumSize(new java.awt.Dimension(85, 22));
        txt_exovertot.setPreferredSize(new java.awt.Dimension(64, 30));
        jPanel1.add(txt_exovertot, new org.netbeans.lib.awtextra.AbsoluteConstraints(880, 220, 85, 30));

        txt_exscortot.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txt_exscortot.setForeground(new java.awt.Color(0, 51, 51));
        txt_exscortot.setMinimumSize(new java.awt.Dimension(85, 22));
        txt_exscortot.setPreferredSize(new java.awt.Dimension(64, 30));
        jPanel1.add(txt_exscortot, new org.netbeans.lib.awtextra.AbsoluteConstraints(970, 220, 85, 30));

        txt_quizave.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txt_quizave.setForeground(new java.awt.Color(0, 51, 51));
        txt_quizave.setMinimumSize(new java.awt.Dimension(85, 22));
        txt_quizave.setPreferredSize(new java.awt.Dimension(64, 30));
        jPanel1.add(txt_quizave, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 310, 85, 30));

        txt_labave.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txt_labave.setForeground(new java.awt.Color(0, 51, 51));
        txt_labave.setMinimumSize(new java.awt.Dimension(85, 22));
        txt_labave.setPreferredSize(new java.awt.Dimension(64, 30));
        jPanel1.add(txt_labave, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 310, 85, 30));

        txt_exave.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txt_exave.setForeground(new java.awt.Color(0, 51, 51));
        txt_exave.setMinimumSize(new java.awt.Dimension(85, 22));
        txt_exave.setPreferredSize(new java.awt.Dimension(64, 30));
        jPanel1.add(txt_exave, new org.netbeans.lib.awtextra.AbsoluteConstraints(920, 310, 85, 30));

        btn_addtottalitem.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btn_addtottalitem.setForeground(new java.awt.Color(0, 51, 51));
        btn_addtottalitem.setText("Add Total Items for this Section");
        btn_addtottalitem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_addtottalitemActionPerformed(evt);
            }
        });
        jPanel1.add(btn_addtottalitem, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 380, 260, -1));

        jButton4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton4.setForeground(new java.awt.Color(0, 51, 51));
        jButton4.setText("Update Total Items for this Section");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 420, -1, -1));

        jButton5.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jButton5.setForeground(new java.awt.Color(0, 51, 51));
        jButton5.setText("Sea Table");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton5, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 500, 130, -1));

        jButton6.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton6.setForeground(new java.awt.Color(0, 51, 51));
        jButton6.setText("Compute Grade");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton6, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 420, 140, -1));

        jButton7.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton7.setForeground(new java.awt.Color(0, 51, 51));
        jButton7.setText("Record Grade");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton7, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 390, 140, -1));

        cmb_semNum.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        cmb_semNum.setForeground(new java.awt.Color(0, 51, 51));
        cmb_semNum.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2" }));
        cmb_semNum.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmb_semNumActionPerformed(evt);
            }
        });
        jPanel1.add(cmb_semNum, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 160, -1, 30));

        jButton3.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jButton3.setForeground(new java.awt.Color(0, 51, 51));
        jButton3.setText("Export to CSV");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 810, -1, -1));

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(0, 51, 51));
        jLabel9.setText("Program:");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 200, 80, 30));

        lbl_prog1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lbl_prog1.setForeground(new java.awt.Color(0, 51, 51));
        jPanel1.add(lbl_prog1, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 200, 100, 30));

        lbl_sub.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lbl_sub.setForeground(new java.awt.Color(0, 51, 51));
        jPanel1.add(lbl_sub, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 110, 160, 30));

        lbl_year1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lbl_year1.setForeground(new java.awt.Color(0, 51, 51));
        jPanel1.add(lbl_year1, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 240, 100, 30));

        jButton9.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jButton9.setForeground(new java.awt.Color(0, 51, 51));
        jButton9.setText("Drop Student");
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton9, new org.netbeans.lib.awtextra.AbsoluteConstraints(1360, 440, -1, -1));

        lbl_stuprog.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lbl_stuprog.setForeground(new java.awt.Color(0, 51, 51));
        jPanel1.add(lbl_stuprog, new org.netbeans.lib.awtextra.AbsoluteConstraints(1420, 180, 110, 30));

        jLabel11.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(0, 51, 51));
        jLabel11.setText("Name:");
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(1360, 100, -1, 30));

        jLabel12.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(0, 51, 51));
        jLabel12.setText("Program:");
        jPanel1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(1340, 180, -1, 30));

        jLabel13.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(0, 51, 51));
        jLabel13.setText("Year:");
        jPanel1.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(1373, 220, 50, 30));

        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(0, 51, 51));
        jLabel10.setText("Gender:");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(1350, 140, -1, 30));

        jLabel14.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(0, 51, 51));
        jLabel14.setText("Select Section:");
        jPanel1.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 280, 130, 30));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 51, 51));
        jLabel4.setText("EXAMS");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(940, 80, -1, -1));

        jLabel15.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(0, 51, 51));
        jLabel15.setText("Score:");
        jPanel1.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(990, 110, 40, -1));

        jLabel16.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(0, 51, 51));
        jLabel16.setText("Total:");
        jPanel1.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 110, -1, -1));

        jLabel17.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(0, 51, 51));
        jLabel17.setText("Score:");
        jPanel1.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 110, -1, -1));

        jLabel18.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(0, 51, 51));
        jLabel18.setText("Total:");
        jPanel1.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 110, -1, -1));

        jLabel19.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(0, 51, 51));
        jLabel19.setText("Score:");
        jPanel1.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 110, -1, -1));

        tabbedPaneCustom1.addTab("Grades Info", jPanel1);

        txt_teainfonum.setBackground(new java.awt.Color(255, 255, 255));
        txt_teainfonum.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel26.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel26.setForeground(new java.awt.Color(0, 51, 51));
        jLabel26.setText("Details:");
        txt_teainfonum.add(jLabel26, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 90, -1, -1));

        jLabel21.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(255, 255, 255));
        jLabel21.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/teacher.png"))); // NOI18N
        txt_teainfonum.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 180, -1, 100));

        jLabel22.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(0, 51, 51));
        jLabel22.setText("Teacher Name:");
        txt_teainfonum.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 310, 130, 30));

        lbl_teainfolname.setBackground(new java.awt.Color(255, 255, 255));
        lbl_teainfolname.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lbl_teainfolname.setForeground(new java.awt.Color(0, 51, 51));
        lbl_teainfolname.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(0, 51, 51)));
        txt_teainfonum.add(lbl_teainfolname, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 310, 330, 30));

        jLabel23.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(0, 51, 51));
        jLabel23.setText("Teacher No.");
        txt_teainfonum.add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 400, -1, 30));

        lbl_teainfonum.setBackground(new java.awt.Color(204, 204, 204));
        lbl_teainfonum.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lbl_teainfonum.setForeground(new java.awt.Color(0, 51, 51));
        lbl_teainfonum.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(0, 51, 51)));
        txt_teainfonum.add(lbl_teainfonum, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 400, 330, 30));

        lbl_teainfoem.setBackground(new java.awt.Color(204, 204, 204));
        lbl_teainfoem.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lbl_teainfoem.setForeground(new java.awt.Color(0, 51, 51));
        lbl_teainfoem.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(0, 51, 51)));
        txt_teainfonum.add(lbl_teainfoem, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 480, 330, 30));

        lbl_teainfopass.setBackground(new java.awt.Color(204, 204, 204));
        lbl_teainfopass.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lbl_teainfopass.setForeground(new java.awt.Color(0, 51, 51));
        lbl_teainfopass.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(0, 51, 51)));
        txt_teainfonum.add(lbl_teainfopass, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 560, 330, 30));

        jLabel24.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel24.setForeground(new java.awt.Color(0, 51, 51));
        jLabel24.setText("Password:");
        txt_teainfonum.add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 560, 90, 30));

        jLabel25.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel25.setForeground(new java.awt.Color(0, 51, 51));
        jLabel25.setText("Email:");
        txt_teainfonum.add(jLabel25, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 480, -1, 30));

        jLabel20.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(0, 51, 51));
        jLabel20.setText("Department:");
        txt_teainfonum.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 650, 110, 30));

        lbl_teainfodept.setBackground(new java.awt.Color(204, 204, 204));
        lbl_teainfodept.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lbl_teainfodept.setForeground(new java.awt.Color(0, 51, 51));
        lbl_teainfodept.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(0, 51, 51)));
        txt_teainfonum.add(lbl_teainfodept, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 650, 330, 30));

        jButton8.setBackground(new java.awt.Color(255, 0, 0));
        jButton8.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jButton8.setForeground(new java.awt.Color(255, 255, 255));
        jButton8.setText("Log Out");
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });
        txt_teainfonum.add(jButton8, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 720, 160, -1));

        jLabel27.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/cvsu main.jpg"))); // NOI18N
        txt_teainfonum.add(jLabel27, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, -10, 1740, 870));

        tabbedPaneCustom1.addTab("Teacher Info", txt_teainfonum);

        jPanel3.add(tabbedPaneCustom1, new org.netbeans.lib.awtextra.AbsoluteConstraints(-10, 40, 1780, 920));

        getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1820, 1010));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        new studentRegister().setVisible(true);
                    this.setVisible(false);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void updateStudentComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateStudentComboBoxActionPerformed
            
        
        try {
            // Get the selected grade and section
            
            String selectedDepartment = lbl_prog1.getText();
            String selectedGrade = lbl_year1.getText();
            String selectedSection = (String) sectionComboBox.getSelectedItem();
            
            String selectedSubject = lbl_sub.getText();
            
            PreparedStatement pstTotit = con.prepareStatement("SELECT * FROM totalitems_tbl WHERE stu_Grade = ? AND stu_Dept = ? AND stu_Sect = ? AND subject = ?");
            pstTotit.setString(1, selectedGrade);
            pstTotit.setString(2, selectedDepartment);
            pstTotit.setString(3, selectedSection);
            pstTotit.setString(4, selectedSubject);

            ResultSet rItems = pstTotit.executeQuery();
            
            if(rItems.next()==true ){
                txt_q1tot.setText(rItems.getString(6));
                txt_q2tot.setText(rItems.getString(7));
                txt_q3tot.setText(rItems.getString(8));
                txt_lab1tot.setText(rItems.getString(9));
                txt_lab2tot.setText(rItems.getString(10));
                txt_lab3tot.setText(rItems.getString(11));
                txt_midtot.setText(rItems.getString(12));
                txt_fintot.setText(rItems.getString(13));
            }

            // SQL query to retrieve student IDs based on grade and section
            String query = "SELECT stu_Num FROM studentinfo_tbl WHERE stu_Grade = ? AND stu_Sect = ? AND stu_Dept = ?";
            pst = con.prepareStatement(query);
            pst.setString(1, selectedGrade);
            pst.setString(2, selectedSection);
            pst.setString(3, selectedDepartment);
            rs = pst.executeQuery();

            // Clear existing items in studentComboBox
            studentComboBox.removeAllItems();

            // Add retrieved student IDs to studentComboBox
            while (rs.next()) {
                String studentId = rs.getString("stu_Num");
                studentComboBox.addItem(studentId);
            }
        } catch (SQLException ex) {
            Logger.getLogger(teacherMain.class.getName()).log(Level.SEVERE, null, ex);
        }
 
       

//        try {
//        // Get the selected grade, section, and subject
//        String selectedDepartment = lbl_prog1.getText();
//        String selectedGrade = lbl_year1.getText();
//        String selectedSection = (String) sectionComboBox.getSelectedItem();
//        String selectedSubject = (String) cmb_subject.getSelectedItem();
//        
//        // Print selected values for debugging
//        System.out.println("Selected Department: " + selectedDepartment);
//        System.out.println("Selected Grade: " + selectedGrade);
//        System.out.println("Selected Section: " + selectedSection);
//        System.out.println("Selected Subject: " + selectedSubject);
//
//        // SQL query to retrieve total items
//        PreparedStatement pstTotit = con.prepareStatement("SELECT * FROM totalitems_tbl WHERE stu_Grade = ? AND stu_Dept = ? AND stu_Sect = ? AND subject = ?");
//        pstTotit.setString(1, selectedGrade);
//        pstTotit.setString(2, selectedDepartment);
//        pstTotit.setString(3, selectedSection);
//        pstTotit.setString(4, selectedSubject);
//
//        // Print the total items query for debugging
//        System.out.println("Query 1: " + pstTotit.toString());
//
//        ResultSet rItems = pstTotit.executeQuery();
//        
//        // Check if total items query returned results
//        if (rItems.next()) {
//            // Set the values in UI components
//            txt_q1tot.setText(rItems.getString(6));
//            txt_q2tot.setText(rItems.getString(7));
//            txt_q3tot.setText(rItems.getString(8));
//            txt_lab1tot.setText(rItems.getString(9));
//            txt_lab2tot.setText(rItems.getString(10));
//            txt_lab3tot.setText(rItems.getString(11));
//            txt_midtot.setText(rItems.getString(12));
//            txt_fintot.setText(rItems.getString(13));
//
//            // Print retrieved total items for debugging
//            System.out.println("Total Items Retrieved: " + rItems.getString(6) + ", " + rItems.getString(7) + ", ...");
//        } else {
//            System.out.println("No total items found for the given criteria.");
//        }
//
//        // SQL query to retrieve student IDs
//        String query = "SELECT stu_Num FROM studentinfo_tbl WHERE stu_Grade = ? AND stu_Sect = ? AND stu_Dept = ?";
//        pst = con.prepareStatement(query);
//        pst.setString(1, selectedGrade);
//        pst.setString(2, selectedSection);
//        pst.setString(3, selectedDepartment);
//
//        // Print the student IDs query for debugging
//        System.out.println("Query 2: " + pst.toString());
//
//        rs = pst.executeQuery();
//
//        // Clear existing items in studentComboBox
//        studentComboBox.removeAllItems();
//
//        // Add retrieved student IDs to studentComboBox
//        while (rs.next()) {
//            String studentId = rs.getString("stu_Num");
//            studentComboBox.addItem(studentId);
//        }
//
//        // Print successful update message
//        System.out.println("Student ComboBox updated successfully.");
//    } catch (SQLException ex) {
//        // Improve exception handling - print stack trace or log error
//        ex.printStackTrace();
//        // Logger.getLogger(teacherMain.class.getName()).log(Level.SEVERE, null, ex);
//        System.out.println("Error updating Student ComboBox: " + ex.getMessage());
//    }
        
    }//GEN-LAST:event_updateStudentComboBoxActionPerformed

    private void btn_updateGradeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_updateGradeActionPerformed
        try {
            
            String selectedSub = lbl_sub.getText();
            
            String quiz1 = txt_q1.getText();
            String quiz2 = txt_q2.getText();
            String quiz3 = txt_q3.getText();
            String lab1 = txt_lab1.getText();
            String lab2 = txt_lab2.getText();
            String lab3 = txt_lab3.getText();
            String mid = txt_mid.getText();
            String fin = txt_fin.getText();
            String qave = txt_quizave.getText();
            String lave = txt_labave.getText();
            String eave = txt_exave.getText();
            
            String selectedStudent = (String) studentComboBox.getSelectedItem();
            
            
            String tableName = selectedSub+"_tbl";
            

            

            pst = con.prepareStatement("UPDATE "+tableName+" SET q1=?, q2=?, q3=?, l1=?, l2=?, l3=?, mid=?, fin=?,qave=?,lave=?,eave=? WHERE stu_Num="+selectedStudent+"");
            pst.setString(1, quiz1);
            pst.setString(2, quiz2);
            pst.setString(3, quiz3);
            pst.setString(4, lab1);
            pst.setString(5, lab2);
            pst.setString(6, lab3);
            pst.setString(7, mid);
            pst.setString(8, fin);
            pst.setString(9, qave);
            pst.setString(10, lave);
            pst.setString(11, eave);
            
  
            // Set value for the 11th parameter


            int k = pst.executeUpdate();

            if (k==1){

                JOptionPane.showMessageDialog(this,"Record Updated Succeessfully!");
                txt_q1.setText("");
                txt_q2.setText("");
                txt_q3.setText("");
                txt_lab1.setText("");
                txt_lab2.setText("");
                txt_lab3.setText("");
                txt_mid.setText("");
                txt_fin.setText("");
                txt_quizave.setText("");
                txt_labave.setText("");
                txt_exave.setText("");



            } 

        } catch (SQLException ex) {
            Logger.getLogger(teacherRegister.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btn_updateGradeActionPerformed

    private void cmb_subjectKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cmb_subjectKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_cmb_subjectKeyReleased

    private void cmb_subjectItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmb_subjectItemStateChanged
         
    }//GEN-LAST:event_cmb_subjectItemStateChanged

    private void studentComboBoxItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_studentComboBoxItemStateChanged
                   
        
        
 
       
    }//GEN-LAST:event_studentComboBoxItemStateChanged

    private void studentComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_studentComboBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_studentComboBoxActionPerformed

    private void studentComboBoxMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_studentComboBoxMouseExited
        
    }//GEN-LAST:event_studentComboBoxMouseExited

    private void updateStudentComboBoxMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_updateStudentComboBoxMouseClicked
        
    }//GEN-LAST:event_updateStudentComboBoxMouseClicked

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        try {
            Object selectedStuIdObj = studentComboBox.getSelectedItem();

    // Check if a student is selected in the ComboBox
    if (selectedStuIdObj == null) {
        JOptionPane.showMessageDialog(this, "Please click search class first");
        return; // Exit the method if no student is selected
    }

            String selectedStuId = studentComboBox.getSelectedItem().toString();
            String selectedSub = lbl_sub.getText();

            pst = con.prepareStatement("SELECT * FROM studentinfo_tbl WHERE stu_Num=?");
            pst.setString(1, selectedStuId);
            rs = pst.executeQuery();

            if(rs.next()==true){

                lbl_stufname.setText(rs.getString(3) + " " + rs.getString(5));
                lbl_stuprog.setText(rs.getString(11));
                lbl_stuyear.setText(rs.getString(12));
                lbl_stusect.setText(rs.getString(13));
                lbl_stugen.setText(rs.getString(7));
                    
                    try{
                        String tableName = selectedSub+"_tbl";
                        
                        
                        String selectedStudent = (String) studentComboBox.getSelectedItem();

                        

                        // SQL query to retrieve student IDs based on grade and section                   
                        PreparedStatement pstStudent = con.prepareStatement("SELECT * FROM "+tableName+" WHERE stu_Num = ?");
                        pstStudent.setString(1, selectedStudent);
                        
                        
                        ResultSet rStudent = pstStudent.executeQuery();

                        // Clear existing items in studentComboBox
                       if(rStudent.next()==true ){
               
                            txt_q1.setText(rStudent.getString(8));
                            txt_q2.setText(rStudent.getString(9));
                            txt_q3.setText(rStudent.getString(10));
                            txt_lab1.setText(rStudent.getString(11));
                            txt_lab2.setText(rStudent.getString(12));
                            txt_lab3.setText(rStudent.getString(13));
                            txt_mid.setText(rStudent.getString(14));
                            txt_fin.setText(rStudent.getString(15));
                            txt_quizave.setText(rStudent.getString(16));
                            txt_labave.setText(rStudent.getString(17));
                            txt_exave.setText(rStudent.getString(18));
                            
                            

                            

                    } else {

                        JOptionPane.showMessageDialog(this,"No Student Grade Found");



                    }

                } catch (NumberFormatException ex) {
                            JOptionPane.showMessageDialog(this, "Invalid input. Please enter numeric values for scores.");
                }

            } else {

                JOptionPane.showMessageDialog(this,"No Student Found");

            }
        } catch (SQLException ex) {
            Logger.getLogger(teacherRegister.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(this,"Blank Record!");
        }
//try {
//    // Get selected student ID
//    Object selectedStuIdObj = studentComboBox.getSelectedItem();
//
//    // Check if a student is selected in the ComboBox
//    if (selectedStuIdObj == null) {
//        JOptionPane.showMessageDialog(this, "Please select a student first");
//        return; // Exit the method if no student is selected
//    }
//
//    String selectedStuId = selectedStuIdObj.toString();
//    String selectedSub = lbl_sub.getText();
//
//    // Query to retrieve student information
//    pst = con.prepareStatement("SELECT * FROM studentinfo_tbl WHERE stu_Num=?");
//    pst.setString(1, selectedStuId);
//    rs = pst.executeQuery();
//
//    if (rs.next()) {
//        lbl_stufname.setText(rs.getString(3));
//        lbl_stulname.setText(rs.getString(5)+ ",");
//        lbl_stuprog.setText(rs.getString(11));
//        lbl_stuyear.setText(rs.getString(12));
//        lbl_stusect.setText(rs.getString(13));
//        lbl_stugen.setText(rs.getString(7));
//
//        try {
//            String tableName = selectedSub + "_tbl";
//
//            // SQL query to retrieve student grades based on grade and section
//            PreparedStatement pstStudent = con.prepareStatement("SELECT * FROM " + tableName + " WHERE stu_Num = ?");
//            pstStudent.setString(1, selectedStuId);
//
//            ResultSet rStudent = pstStudent.executeQuery();
//
//            // Clear existing items in studentComboBox
//            if (rStudent.next()) {
//                txt_q1.setText(rStudent.getString(11));
//                txt_q2.setText(rStudent.getString(12));
//                txt_q3.setText(rStudent.getString(13));
//                txt_lab1.setText(rStudent.getString(14));
//                txt_lab2.setText(rStudent.getString(15));
//                txt_lab3.setText(rStudent.getString(16));
//                txt_mid.setText(rStudent.getString(17));
//                txt_fin.setText(rStudent.getString(18));
//            } else {
//                JOptionPane.showMessageDialog(this, "No Student Grade Found");
//            }
//
//        } catch (NumberFormatException ex) {
//            JOptionPane.showMessageDialog(this, "Invalid input. Please enter numeric values for scores.");
//        }
//
//    } else {
//        JOptionPane.showMessageDialog(this, "No Student Found");
//    }
//} catch (SQLException ex) {
//    Logger.getLogger(teacherRegister.class.getName()).log(Level.SEVERE, null, ex);
//    JOptionPane.showMessageDialog(this, "Blank Record!");
//}
    }//GEN-LAST:event_jButton2ActionPerformed

    private void btn_addtottalitemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_addtottalitemActionPerformed
        try{
       
            String selectedSection = (String) sectionComboBox.getSelectedItem();
            String selectedDepartment = lbl_prog1.getText();
            String selectedGrade = lbl_year1.getText();
            String selectedSubject =  lbl_sub.getText();
            String q1tot = txt_q1tot.getText();
            String q2tot = txt_q2tot.getText();
            String q3tot = txt_q3tot.getText();
            String l1tot = txt_lab1tot.getText();
            String l2tot = txt_lab2tot.getText();
            String l3tot = txt_lab3tot.getText();
            String midtot = txt_midtot.getText();
            String fintot = txt_fintot.getText();
            

            PreparedStatement pstCheck = con.prepareStatement("SELECT stu_Grade, stu_Dept, stu_Sect FROM totalitems_tbl WHERE stu_Grade = ? AND stu_Dept = ? AND stu_Sect = ? AND subject = ?");
            pstCheck.setString(1, selectedGrade);
            pstCheck.setString(2, selectedDepartment);
            pstCheck.setString(3, selectedSection);
            pstCheck.setString(4, selectedSubject);

                ResultSet rsCheck = pstCheck.executeQuery();
            if (rsCheck.next()) {
                JOptionPane.showMessageDialog(this, "This Section already have a record!");
            } else {
            
                

                PreparedStatement psttotit = con.prepareStatement("INSERT INTO totalitems_tbl (stu_Grade, stu_Sect,stu_Dept,subject,q1it,q2it,q3it,l1it,l2it,l3it,midit,finit) VALUES (?,?,?,?,?,?,?,?,?,?,?,?)");
                psttotit.setString(1, selectedGrade);
                psttotit.setString(2, selectedSection);
                psttotit.setString(3, selectedDepartment);
                psttotit.setString(4, selectedSubject);
                psttotit.setString(5, q1tot);
                psttotit.setString(6, q2tot);
                psttotit.setString(7, q3tot);
                psttotit.setString(8, l1tot);
                psttotit.setString(9, l2tot);
                psttotit.setString(10, l3tot);
                psttotit.setString(11, midtot);
                psttotit.setString(12, fintot);



                int kpsttotit = psttotit.executeUpdate();

                if (kpsttotit == 1) {
                            JOptionPane.showMessageDialog(this, "Data Added Successfully!");
                } else {
                    JOptionPane.showMessageDialog(this, "Data Not Recorded!");
                }
            
            }
        }catch(SQLException ex){
            Logger.getLogger(studentRegister.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btn_addtottalitemActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        try {
            String quiz1tot = txt_q1tot.getText();
            String quiz2tot = txt_q2tot.getText();
            String quiz3tot = txt_q3tot.getText();
            String lab1tot = txt_lab1tot.getText();
            String lab2tot = txt_lab2tot.getText();
            String lab3tot = txt_lab3tot.getText();
            String midtot = txt_midtot.getText();
            String fintot = txt_fintot.getText();
            String selectedSubject =  lbl_sub.getText();
            String selectedDepartment = lbl_prog1.getText();
            String selectedGrade = lbl_year1.getText();
            String selectedSection = (String) sectionComboBox.getSelectedItem();
            
            // Display a confirmation dialog
            int dialogResult = JOptionPane.showConfirmDialog(this, "Are you sure you want to update the record?", "Confirmation", JOptionPane.YES_NO_OPTION);

            if (dialogResult == JOptionPane.YES_OPTION) {
                pst = con.prepareStatement("UPDATE totalitems_tbl SET q1it=?, q2it=?, q3it=?, l1it=?, l2it=?, l3it=?, midit=?, finit=? WHERE stu_Grade=? AND stu_Dept=? AND stu_Sect=? AND subject=?");
                pst.setString(1, quiz1tot);
                pst.setString(2, quiz2tot);
                pst.setString(3, quiz3tot);
                pst.setString(4, lab1tot);
                pst.setString(5, lab2tot);
                pst.setString(6, lab3tot);
                pst.setString(7, midtot);
                pst.setString(8, fintot);
                pst.setString(9, selectedGrade);
                pst.setString(10, selectedDepartment);
                pst.setString(11, selectedSection);
                pst.setString(12, selectedSubject);

                int k = pst.executeUpdate();

                if (k == 1) {
                    JOptionPane.showMessageDialog(this, "Record Updated Successfully!");
                    
                } else {
                    JOptionPane.showMessageDialog(this, "Record Failed to Update!");
                }
            } else {
                // User clicked "No" in the confirmation dialog
                // Handle accordingly, e.g., do nothing or show a message
            }

            } catch (SQLException ex) {
            Logger.getLogger(teacherRegister.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        try {
            
            int q;
            String selectedSub = lbl_sub.getText();
            String tableName = selectedSub+"_tbl";
            
            String selectedDepartment = lbl_prog1.getText();
            String selectedGrade = lbl_year1.getText();
            String stuSect = (String) sectionComboBox.getSelectedItem();        
     
            
            
            
            
            
            pst = con.prepareStatement("SELECT * FROM "+tableName+" WHERE stu_Dept = ? AND stu_Grade = ? AND stu_Sect = ?");
            pst.setString(1, selectedDepartment);
            pst.setString(2, selectedGrade);
            pst.setString(3, stuSect);

            rs = pst.executeQuery();
            ResultSetMetaData rss = rs.getMetaData();
            q = rss.getColumnCount();
            
            DefaultTableModel df = (DefaultTableModel)tbl_teaview.getModel();
            df.setRowCount(0);
            
            while(rs.next()){
            
                Vector v2 = new Vector();
                for(int a=1; a<=q; a++){
                
                    v2.add(rs.getString("stu_Num"));
                    v2.add(rs.getString("stu_Fname"));
                    v2.add(rs.getString("stu_Lname"));
                    v2.add(rs.getString("stu_Dept"));
                    v2.add(rs.getString("stu_Grade"));
                    v2.add(rs.getString("stu_Sect"));
                    v2.add(rs.getString("q1"));
                    v2.add(rs.getString("q2"));
                    v2.add(rs.getString("q3"));
                    v2.add(rs.getString("l1"));
                    v2.add(rs.getString("l2"));
                    v2.add(rs.getString("l3"));
                    v2.add(rs.getString("mid"));
                    v2.add(rs.getString("fin"));
                    v2.add(rs.getString("qave"));
                    v2.add(rs.getString("lave"));
                    v2.add(rs.getString("eave"));
                    v2.add(rs.getString("fingrade"));
                    
                    
                
                }
                df.addRow(v2);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(teacherMain.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
            
        try {
            String quiz1 = txt_q1.getText();
            String quiz2 = txt_q2.getText();
            String quiz3 = txt_q3.getText();                  
            String lab1 = txt_lab1.getText();
            String lab2 = txt_lab2.getText();
            String lab3 = txt_lab3.getText();
            String mid = txt_mid.getText();
            String fin = txt_fin.getText();

            if (quiz1.isEmpty() || quiz2.isEmpty() || quiz3.isEmpty() || lab1.isEmpty() /* add more conditions for other fields */) {
            JOptionPane.showMessageDialog(this, "Please fill in all score fields.");
            return;
             }
            
            
            
            String quiz1tot = txt_q1tot.getText();
            String quiz2tot = txt_q2tot.getText();
            String quiz3tot = txt_q3tot.getText();
            String lab1tot = txt_lab1tot.getText();
            String lab2tot = txt_lab2tot.getText();
            String lab3tot = txt_lab3tot.getText();
            String midtot = txt_midtot.getText();
            String fintot = txt_fintot.getText();
            
            
            
            int intQuiz1 = Integer.parseInt(quiz1);
            int intQuiz2 = Integer.parseInt(quiz2);
            int intQuiz3 = Integer.parseInt(quiz3);
            int intLab1 = Integer.parseInt(lab1);
            int intLab2 = Integer.parseInt(lab2);
            int intLab3 = Integer.parseInt(lab3);
            int intMid = Integer.parseInt(mid);
            int intFin = Integer.parseInt(fin);

            int intQuiz1tot = Integer.parseInt(quiz1tot);
            int intQuiz2tot = Integer.parseInt(quiz2tot);
            int intQuiz3tot = Integer.parseInt(quiz3tot);
            int intLab1tot = Integer.parseInt(lab1tot);
            int intLab2tot = Integer.parseInt(lab2tot);
            int intLab3tot = Integer.parseInt(lab3tot);
            int intMidtot = Integer.parseInt(midtot);
            int intFintot = Integer.parseInt(fintot);
            
            
            
            
            
            int intQuizovertot = intQuiz1tot + intQuiz2tot +intQuiz3tot;
            int intQuizscortot = intQuiz1 + intQuiz2 + intQuiz3;

            int intLabovertot = intLab1tot + intLab2tot + intLab3tot;
            int intLabscortot = intLab1 + intLab2 + intLab3;

            int intExovertot = intMidtot + intFintot;
            int intExscortot = intMid + intFin;
            
            
            
            txt_qovertot.setText(String.valueOf(intQuizovertot));
            txt_qscortot.setText(String.valueOf(intQuizscortot));

            txt_lovertot.setText(String.valueOf(intLabovertot));
            txt_lscortot.setText(String.valueOf(intLabscortot));

            txt_exovertot.setText(String.valueOf(intExovertot));
            txt_exscortot.setText(String.valueOf(intExscortot));
            
            
            String qovertot = txt_qovertot.getText();
            String qscortot = txt_qscortot.getText();

            String lovertot = txt_lovertot.getText();
            String lscortot = txt_lscortot.getText();

            String exovertot = txt_exovertot.getText();
            String exscortot = txt_exscortot.getText();

            float intAQovertot = Integer.parseInt(qovertot);
            float intAQscortot = Integer.parseInt(qscortot);

            float intALovertot = Integer.parseInt(lovertot);
            float intALscortot = Integer.parseInt(lscortot);

            float intAExovertot = Integer.parseInt(exovertot);
            float intAExscortot = Integer.parseInt(exscortot);

            float intQAVE = (intAQscortot /  intAQovertot) * 100;

            float intLAVE = (intALscortot / intALovertot) * 100;

            float intEAVE = (intAExscortot / intAExovertot) * 100;

            txt_quizave.setText(String.valueOf(intQAVE));
            txt_labave.setText(String.valueOf(intLAVE));
            txt_exave.setText(String.valueOf(intEAVE));
            
            String selectedSub = lbl_sub.getText();
            
//            String quiz1 = txt_q1.getText();
//            String quiz2 = txt_q2.getText();
//            String quiz3 = txt_q3.getText();
//            String lab1 = txt_lab1.getText();
//            String lab2 = txt_lab2.getText();
//            String lab3 = txt_lab3.getText();
//            String mid = txt_mid.getText();
//            String fin = txt_fin.getText();
            String qave = txt_quizave.getText();
            String lave = txt_labave.getText();
            String eave = txt_exave.getText();

            String selectedStudent = (String) studentComboBox.getSelectedItem();            


            String tableName = selectedSub+"_tbl";




            pst = con.prepareStatement("UPDATE "+tableName+" SET q1=?, q2=?, q3=?, l1=?, l2=?, l3=?, mid=?, fin=?,qave=?,lave=?,eave=? WHERE stu_Num="+selectedStudent+"");
            pst.setString(1, quiz1);
            pst.setString(2, quiz2);
            pst.setString(3, quiz3);
            pst.setString(4, lab1);
            pst.setString(5, lab2);
            pst.setString(6, lab3);
            pst.setString(7, mid);
            pst.setString(8, fin);
            pst.setString(9, qave);
            pst.setString(10, lave);
            pst.setString(11, eave);


            // Set value for the 11th parameter


            int k = pst.executeUpdate();

            if (k==1){

                JOptionPane.showMessageDialog(this,"Record Updated Succeessfully!");
                



            }
        } catch (SQLException ex) {
            Logger.getLogger(teacherMain.class.getName()).log(Level.SEVERE, null, ex);
        }
//            try{  
//            String quiz1 = txt_q1.getText();
//            String quiz2 = txt_q2.getText();
//            String quiz3 = txt_q3.getText();                  
//            String lab1 = txt_lab1.getText();
//            String lab2 = txt_lab2.getText();
//            String lab3 = txt_lab3.getText();
//            String mid = txt_mid.getText();
//            String fin = txt_fin.getText();
//            if (quiz1.isEmpty() || quiz2.isEmpty() || quiz3.isEmpty() || lab1.isEmpty() /* add more conditions for other fields */) {
//            JOptionPane.showMessageDialog(this, "Please fill in all score fields.");
//            return;
//        }
//
//
//
//            String quiz1tot = txt_q1tot.getText();
//            String quiz2tot = txt_q2tot.getText();
//            String quiz3tot = txt_q3tot.getText();
//            String lab1tot = txt_lab1tot.getText();
//            String lab2tot = txt_lab2tot.getText();
//            String lab3tot = txt_lab3tot.getText();
//            String midtot = txt_midtot.getText();
//            String fintot = txt_fintot.getText();
//
//
//
//            int intQuiz1 = Integer.parseInt(quiz1);
//            int intQuiz2 = Integer.parseInt(quiz2);
//            int intQuiz3 = Integer.parseInt(quiz3);
//            int intLab1 = Integer.parseInt(lab1);
//            int intLab2 = Integer.parseInt(lab2);
//            int intLab3 = Integer.parseInt(lab3);
//            int intMid = Integer.parseInt(mid);
//            int intFin = Integer.parseInt(fin);
//
//            int intQuiz1tot = Integer.parseInt(quiz1tot);
//            int intQuiz2tot = Integer.parseInt(quiz2tot);
//            int intQuiz3tot = Integer.parseInt(quiz3tot);
//            int intLab1tot = Integer.parseInt(lab1tot);
//            int intLab2tot = Integer.parseInt(lab2tot);
//            int intLab3tot = Integer.parseInt(lab3tot);
//            int intMidtot = Integer.parseInt(midtot);
//            int intFintot = Integer.parseInt(fintot);
//
//
//
//
//
//            int intQuizovertot = intQuiz1tot + intQuiz2tot +intQuiz3tot;
//            int intQuizscortot = intQuiz1 + intQuiz2 + intQuiz3;
//
//            int intLabovertot = intLab1tot + intLab2tot + intLab3tot;
//            int intLabscortot = intLab1 + intLab2 + intLab3;
//
//            int intExovertot = intMidtot + intFintot;
//            int intExscortot = intMid + intFin;
//
//
//
//            txt_qovertot.setText(String.valueOf(intQuizovertot));
//            txt_qscortot.setText(String.valueOf(intQuizscortot));
//
//            txt_lovertot.setText(String.valueOf(intLabovertot));
//            txt_lscortot.setText(String.valueOf(intLabscortot));
//
//            txt_exovertot.setText(String.valueOf(intExovertot));
//            txt_exscortot.setText(String.valueOf(intExscortot));
//            
//            
//            String qovertot = txt_qovertot.getText();
//            String qscortot = txt_qscortot.getText();
//
//            String lovertot = txt_lovertot.getText();
//            String lscortot = txt_lscortot.getText();
//
//            String exovertot = txt_exovertot.getText();
//            String exscortot = txt_exscortot.getText();
//
//            float intAQovertot = Integer.parseInt(qovertot);
//            float intAQscortot = Integer.parseInt(qscortot);
//
//            float intALovertot = Integer.parseInt(lovertot);
//            float intALscortot = Integer.parseInt(lscortot);
//
//            float intAExovertot = Integer.parseInt(exovertot);
//            float intAExscortot = Integer.parseInt(exscortot);
//
//            float intQAVE = (intAQscortot /  intAQovertot) * 100;
//
//            float intLAVE = (intALscortot / intALovertot) * 100;
//
//            float intEAVE = (intAExscortot / intAExovertot) * 100;
//
//            txt_quizave.setText(String.valueOf(intQAVE));
//            txt_labave.setText(String.valueOf(intLAVE));
//            txt_exave.setText(String.valueOf(intEAVE));
//            
//            String selectedStudent = (String) studentComboBox.getSelectedItem();            
////
//
//            String tableName = selectedSub+"_tbl";
//
//
//
//
//            pst = con.prepareStatement("UPDATE "+tableName+" SET q1=?, q2=?, q3=?, l1=?, l2=?, l3=?, mid=?, fin=?,qave=?,lave=?,eave=? WHERE stu_Num="+selectedStudent+"");
//            pst.setString(1, quiz1);
//            pst.setString(2, quiz2);
//            pst.setString(3, quiz3);
//            pst.setString(4, lab1);
//            pst.setString(5, lab2);
//            pst.setString(6, lab3);
//            pst.setString(7, mid);
//            pst.setString(8, fin);
//            pst.setString(9, qave);
//            pst.setString(10, lave);
//            pst.setString(11, eave);
//
//
//            // Set value for the 11th parameter
//
//
//            int k = pst.executeUpdate();
//
//            if (k==1){
//
//                JOptionPane.showMessageDialog(this,"Record Updated Succeessfully!");
//                txt_q1.setText("");
//                txt_q2.setText("");
//                txt_q3.setText("");
//                txt_lab1.setText("");
//                txt_lab2.setText("");
//                txt_lab3.setText("");
//                txt_mid.setText("");
//                txt_fin.setText("");
//                txt_quizave.setText("");
//                txt_labave.setText("");
//                txt_exave.setText("");
//
            
//            
//    }catch (NumberFormatException ex) {
//    JOptionPane.showMessageDialog(this, "Invalid input. Please enter numeric values for scores.");
//}
            
            
            
       
    }//GEN-LAST:event_jButton6ActionPerformed

    private void sectionComboBoxItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_sectionComboBoxItemStateChanged
                   
        
        
 
       
    }//GEN-LAST:event_sectionComboBoxItemStateChanged

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        String quizave = txt_quizave.getText();
        String labave = txt_labave.getText();
        String examave = txt_exave.getText();
        
        if (quizave.isEmpty() || labave.isEmpty() || examave.isEmpty() /* add more conditions for other fields */) {
            JOptionPane.showMessageDialog(this, "Compute Grades First!");
            return;
        }
        
        
        String selectedDepartment = lbl_prog1.getText();
        String selectedGrade = lbl_year1.getText();
        String selectedSub = lbl_sub.getText();
        String selectedSection = (String) sectionComboBox.getSelectedItem();

        String selectedStuId = studentComboBox.getSelectedItem().toString();
        
        

        float quizrec = Float.parseFloat(quizave);
        float labrec = Float.parseFloat(labave);
        float exrec = Float.parseFloat(examave);
        
        try {
            PreparedStatement pstPer = con.prepareStatement("SELECT * FROM percentage_tbl WHERE stu_Grade = ? AND stu_Sect = ? AND stu_Dept = ? AND subject = ?");
            pstPer.setString(1, selectedGrade);
            pstPer.setString(2, selectedSection);
            pstPer.setString(3, selectedDepartment);
            pstPer.setString(4, selectedSub);
            
            rs = pstPer.executeQuery();
            
            if (rs.next()) {
                String qper = rs.getString("qper");
                String lper = rs.getString("lper");
                String eper = rs.getString("eper");
                
                float qperfin = Float.parseFloat(qper);
                float lperfin = Float.parseFloat(lper);
                float eperfin = Float.parseFloat(eper);
                
                float qcalculation = (qperfin*quizrec) / 100;
                float lcalculation = (lperfin*labrec)  /100;
                float ecalculation = (eperfin*exrec)  /100;
                
                float finalGrade = qcalculation + lcalculation + ecalculation;
                float finalComp = 0;

                
                if (finalGrade >= 96){
                
                    finalComp = 1;
                
                } else if (finalGrade >= 94) {
                
                    finalComp = (float) 1.25;
                
                } else if (finalGrade >= 91) {
                
                    finalComp = (float) 1.50;
                
                } 
                
                else if (finalGrade >= 88) {
                
                    finalComp = (float) 1.70;
                
                } else if (finalGrade >= 85) {
                
                    finalComp = (float) 2;
                
                } else if (finalGrade >= 83) {
                
                    finalComp = (float) 2.25;
                
                } else if (finalGrade >= 80) {
                
                    finalComp = (float) 2.50;
                
                } else if (finalGrade >= 78) {
                
                    finalComp = (float) 2.75;
                
                } else if (finalGrade >= 75) {
                
                    finalComp = (float) 3;
                
                } else {
                
                    finalComp = 5;
                
                }
                
                String tblname = selectedSub+"_tbl";
                
            
                
                
                
                              
                PreparedStatement pstSendGrade = con.prepareStatement("UPDATE "+tblname+" SET fingrade=? WHERE stu_Num = ?");
                pstSendGrade.setString(1, String.valueOf(finalComp));
                pstSendGrade.setString(2, selectedStuId);
                

                int ksendGrade = pstSendGrade.executeUpdate();

                
                // Close the connection
 

                if (ksendGrade == 1) {
                    JOptionPane.showConfirmDialog(this, "Confirm?");
                    JOptionPane.showMessageDialog(this, "Accepted!");
                } else {
                    JOptionPane.showMessageDialog(this, "Data Not Recorded!");
                }
            
            

            
            } else {
                JOptionPane.showMessageDialog(null, "User not found!");
                
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(teacherMain.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
        
        
        
        
        
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        JFileChooser chooser = new JFileChooser();
        chooser.showOpenDialog(null);
        
        File f = chooser.getSelectedFile();
        
//        String selectedDepartment = (String) lbl_prog.getSelectedItem();
//        String selectedGrade = (String) lbl_year.getSelectedItem();
        String selectedDepartment = lbl_prog1.getText();
        String selectedGrade = lbl_year1.getText();
        String stuSect = (String) sectionComboBox.getSelectedItem();        
        
        String tableName;
        
        if ("English".equals(stuSect)) {
            tableName = "english_tbl";
        } else if ("Science".equals(stuSect)) {
            tableName = "science_tbl";
        } else {
            // Handle other cases or set a default table name
            tableName = "math_tbl";
        }

        try {
            FileWriter fw = new FileWriter(f);
            pst = con.prepareStatement("SELECT * FROM "+tableName+" WHERE stu_Dept = ? AND stu_Grade = ? AND stu_Sect = ?");
            pst.setString(1, selectedDepartment);
            pst.setString(2, selectedGrade);
            pst.setString(3, stuSect);

            while (rs.next()) {

                fw.append(rs.getString(1));
                fw.append(',');

                fw.append(rs.getString(2));
                fw.append(',');

                fw.append(rs.getString(3));
                fw.append(',');

                fw.append(rs.getString(4));
                fw.append(',');

                fw.append(rs.getString(5));
                fw.append(',');

                fw.append(rs.getString(6));
                fw.append(',');

                fw.append(rs.getString(7));
                fw.append(',');

                fw.append(rs.getString(8));
                fw.append(',');

                fw.append(rs.getString(9));
                fw.append(',');
                
                fw.append(rs.getString(10));
                fw.append(',');

                fw.append(rs.getString(11));
                fw.append('\n');
                
                fw.append(rs.getString(12));
                fw.append('\n');
                
                fw.append(rs.getString(13));
                fw.append('\n');
                
                fw.append(rs.getString(14));
                fw.append('\n');
                fw.append(rs.getString(15));
                fw.append('\n');
                
                fw.append(rs.getString(16));
                fw.append('\n');
                fw.append(rs.getString(17));
                fw.append('\n');
                
                fw.append(rs.getString(18));
                fw.append('\n');
                
                
                
                
                

            }
            JOptionPane.showMessageDialog(this,"Data Exported Successfully!");
            fw.flush();
            fw.close();
        } catch (IOException ex) {
            Logger.getLogger(teacherMain.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(teacherMain.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void sectionComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sectionComboBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_sectionComboBoxActionPerformed

    private void lbl_year1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lbl_year1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_lbl_year1ActionPerformed

    private void cmb_semNumItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmb_semNumItemStateChanged
         
    }//GEN-LAST:event_cmb_semNumItemStateChanged

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
        
        try {
            String sturegnum = studentComboBox.getSelectedItem().toString();
            String stureggrade = lbl_year1.getText();
            String sturegdept = lbl_prog1.getText();
            String stregsem = cmb_semNum.getSelectedItem().toString();
            
            String query = "SELECT * FROM subject_tbl WHERE stu_Grade = ? AND sem_Num = ? AND stu_Dept = ?";
            pst = con.prepareStatement(query);
            pst.setString(1, stureggrade);
            pst.setString(2, stregsem);
            pst.setString(3, sturegdept);
            rs = pst.executeQuery();
            
            // Clear existing items in studentComboBox
            
            // Add retrieved student IDs to studentComboBox
            while (rs.next()) {
                String selectedSub = rs.getString("sub_Name");
                
                
                if (!selectedSub.matches("[a-zA-Z0-9_]+")) {
                // Handle the case where the selectedSub contains invalid characters
                continue; // Skip to the next iteration
                }
                
                PreparedStatement pstSub = con.prepareStatement("DELETE FROM "+selectedSub+"_tbl WHERE stu_Num = ?");
                pstSub.setString(1, sturegnum);
                
                
                int kSub= pstSub.executeUpdate();
                
                
                PreparedStatement pstStu = con.prepareStatement("DELETE FROM studentinfo_tbl WHERE stu_Num = ?");
                pstStu.setString(1, sturegnum);
                int kStu= pstStu.executeUpdate();
                
                while ( kSub == 1 && kStu == 1) {
                    JOptionPane.showMessageDialog(this, "Data Deleted Successfully Successfully!");
                    break;
                }
            }
            
            PreparedStatement pstRem = con.prepareStatement("DELETE FROM studentinfo_tbl WHERE stu_Num = ?");
            pstRem.setString(1, sturegnum);
            
            int kRem= pstRem.executeUpdate();
            
            while ( kRem == 1 ) {
                    JOptionPane.showMessageDialog(this, "Data Deleted Successfully Successfully!");
                    break;
                }
        } catch (SQLException ex) {
            Logger.getLogger(teacherMain.class.getName()).log(Level.SEVERE, null, ex);
        }
            
    }//GEN-LAST:event_jButton9ActionPerformed

    private void txt_q1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_q1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_q1ActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
         dispose();
         new teacherLogin().setVisible(true);
         this.setVisible(false);;
    }//GEN-LAST:event_jButton8ActionPerformed

    private void cmb_semNumActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmb_semNumActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmb_semNumActionPerformed

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
            java.util.logging.Logger.getLogger(teacherMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(teacherMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(teacherMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(teacherMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new teacherMain().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_addtottalitem;
    private javax.swing.JButton btn_updateGrade;
    private javax.swing.JComboBox<String> cmb_semNum;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenu jMenu6;
    private javax.swing.JMenu jMenu7;
    private javax.swing.JMenu jMenu8;
    private javax.swing.JMenu jMenu9;
    private javax.swing.JMenuBar jMenuBar2;
    private javax.swing.JMenuBar jMenuBar3;
    private javax.swing.JMenuBar jMenuBar4;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTabbedPane jTabbedPane2;
    private javax.swing.JLabel lbl_prog1;
    private javax.swing.JLabel lbl_stufname;
    private javax.swing.JLabel lbl_stugen;
    private javax.swing.JLabel lbl_stuprog;
    private javax.swing.JLabel lbl_stusect;
    private javax.swing.JLabel lbl_stuyear;
    private javax.swing.JLabel lbl_sub;
    private javax.swing.JLabel lbl_teainfodept;
    private javax.swing.JLabel lbl_teainfoem;
    private javax.swing.JLabel lbl_teainfolname;
    private javax.swing.JLabel lbl_teainfonum;
    private javax.swing.JLabel lbl_teainfopass;
    private javax.swing.JLabel lbl_year1;
    private java.awt.PopupMenu popupMenu1;
    private javax.swing.JComboBox<String> sectionComboBox;
    private javax.swing.JComboBox<String> studentComboBox;
    private raven.tabbed.TabbedPaneCustom tabbedPaneCustom1;
    private javax.swing.JTable tbl_teaview;
    private javax.swing.JTextField txt_exave;
    private javax.swing.JTextField txt_exovertot;
    private javax.swing.JTextField txt_exscortot;
    private javax.swing.JTextField txt_fin;
    private javax.swing.JTextField txt_fintot;
    private javax.swing.JTextField txt_lab1;
    private javax.swing.JTextField txt_lab1tot;
    private javax.swing.JTextField txt_lab2;
    private javax.swing.JTextField txt_lab2tot;
    private javax.swing.JTextField txt_lab3;
    private javax.swing.JTextField txt_lab3tot;
    private javax.swing.JTextField txt_labave;
    private javax.swing.JTextField txt_lovertot;
    private javax.swing.JTextField txt_lscortot;
    private javax.swing.JTextField txt_mid;
    private javax.swing.JTextField txt_midtot;
    private javax.swing.JTextField txt_q1;
    private javax.swing.JTextField txt_q1tot;
    private javax.swing.JTextField txt_q2;
    private javax.swing.JTextField txt_q2tot;
    private javax.swing.JTextField txt_q3;
    private javax.swing.JTextField txt_q3tot;
    private javax.swing.JTextField txt_qovertot;
    private javax.swing.JTextField txt_qscortot;
    private javax.swing.JTextField txt_quizave;
    private javax.swing.JPanel txt_teainfonum;
    private javax.swing.JButton updateStudentComboBox;
    // End of variables declaration//GEN-END:variables
}
