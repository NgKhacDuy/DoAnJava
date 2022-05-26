/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package GUI;

import BUS.NHANVIEN_BUS;
import DTO.NHANVIEN_DTO;
import java.awt.event.KeyEvent;
import java.text.ParseException;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Vector;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;
import javax.swing.plaf.basic.BasicInternalFrameUI;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author DELL
 */
public class NHANVIEN_GUI extends javax.swing.JInternalFrame {
    NHANVIEN_BUS nv_BUS=new NHANVIEN_BUS();
    String regex_Time="([01]?[0-9]|2[0-3]):[0-5][0-9]";
    String regex = "^(3[01]|[12][0-9]|0[1-9])/(1[0-2]|0[1-9])/[0-9]{4}$";
    /**
     * Creates new form NHANVIEN__GUI
     */
    public NHANVIEN_GUI() {
        initComponents();
        BasicInternalFrameUI BI = (BasicInternalFrameUI)this.getUI();
        BI.setNorthPane(null);
        RB_Them.setSelected(true);
        loadDatalenTable();
    }
    private void timKiemTongHop(){
            String ma=txt_TimTheoMa.getText();
            String ten=txt_NgaySinh.getText();
            DefaultTableModel dtm = (DefaultTableModel)jTable.getModel();
            dtm.setRowCount(0);
            ArrayList<NHANVIEN_DTO>dsnv=null;
            dsnv=nv_BUS.getNVTongHop(ma, ten);
            for(NHANVIEN_DTO nv :dsnv){
                Vector vec = new Vector();
                vec.add(nv.getMANV());
                vec.add(nv.getTENNV());
                vec.add(nv.getNGAYSINH());
                vec.add(nv.getDIACHI());
                vec.add(nv.getSDT());
                vec.add(nv.getCHUCVU());
                vec.add(nv.getCALAM());
                dtm.addRow(vec);
            }
    }
    private void timKiemTheoMa(){
        if(txt_TimTheoMa.getText().isEmpty()){
            loadDatalenTable();
        }
        else{
            String ma=txt_TimTheoMa.getText();
            DefaultTableModel dtm = (DefaultTableModel)jTable.getModel();
            dtm.setRowCount(0);
            ArrayList<NHANVIEN_DTO>dsnv=null;
            dsnv=nv_BUS.getNVTheoMa(ma);
            for(NHANVIEN_DTO nv :dsnv){
                Vector vec = new Vector();
                vec.add(nv.getMANV());
                vec.add(nv.getTENNV());
                vec.add(nv.getNGAYSINH());
                vec.add(nv.getDIACHI());
                vec.add(nv.getSDT());
                vec.add(nv.getCHUCVU());
                vec.add(nv.getCALAM());
                dtm.addRow(vec);
            }
        }
    }
    private void timKiemTheoTen(){
        if(txtTimTheoTen.getText().isEmpty()){
            loadDatalenTable();
        }
        else{
            String ten=txtTimTheoTen.getText();
            DefaultTableModel dtm = (DefaultTableModel)jTable.getModel();
            dtm.setRowCount(0);
            ArrayList<NHANVIEN_DTO>dsnv=null;
            dsnv=nv_BUS.getNVTheoTen(ten);
            for(NHANVIEN_DTO nv :dsnv){
                Vector vec = new Vector();
                vec.add(nv.getMANV());
                vec.add(nv.getTENNV());
                vec.add(nv.getNGAYSINH());
                vec.add(nv.getDIACHI());
                vec.add(nv.getSDT());
                vec.add(nv.getCHUCVU());
                vec.add(nv.getCALAM());
                dtm.addRow(vec);
            }
        }
    }
    private void xulyXoaNV(){
        int response= JOptionPane.showConfirmDialog(rootPane, "Bạn có chắc chắn muốn xóa ?","Confirm",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
        if(response==JOptionPane.YES_OPTION){
            boolean flag = nv_BUS.xoaNV(txtMaNV.getText());
            if(flag){
                JOptionPane.showMessageDialog(rootPane, "Xóa thành công");
                loadDatalenTable();
            }
        }
    }
    private void xulySuaNV(){
        boolean flag = nv_BUS.suaNV(txtMaNV.getText(),txtTenNV.getText(), txt_NgaySinh.getText(), txtDiaCHi.getText(), txtSDT.getText(), txtChucVu.getText(), txtCaLam.getText());
        nv_BUS.docListNV();
        if(flag)
            JOptionPane.showMessageDialog(rootPane, "Sửa thành công");
        else
            JOptionPane.showMessageDialog(rootPane, "Sửa thất bại");
        loadDatalenTable();

    }
    private void xulyThemNV(){
        boolean flag = nv_BUS.themNV(txtTenNV.getText(), txt_NgaySinh.getText(), txtDiaCHi.getText(), txtSDT.getText(), txtChucVu.getText(), txtCaLam.getText());
        try {
            nv_BUS.docListNV();
            loadDatalenTable();
        } catch (Exception e) {
        }
    }
    private void loadDatalenTable(){
        DefaultTableModel dtm = (DefaultTableModel)jTable.getModel();
        nv_BUS.docListNV();
        dtm.setRowCount(0);
        ArrayList<NHANVIEN_DTO>dsnv=nv_BUS.getListNV();
        for(NHANVIEN_DTO nv:dsnv){
            Vector vec = new Vector();
            vec.add(nv.getMANV());
            vec.add(nv.getTENNV());
            vec.add(nv.getNGAYSINH());
            vec.add(nv.getDIACHI());
            vec.add(nv.getSDT());
            vec.add(nv.getCHUCVU());
            vec.add(nv.getCALAM());
            dtm.addRow(vec);
        }
    }
    public boolean validateDateFormat(){
        Pattern pattern=Pattern.compile(regex);
        Matcher matcher = pattern.matcher(txt_NgaySinh.getText());
        if(!matcher.matches()){
            JOptionPane.showMessageDialog(rootPane, "Định dạng ngày tháng năm sai (dd/mm/yyyy)");
            return false;
        }
        else
            return true;
    }
    public boolean validateTimeFormat(){
        Pattern pattern=Pattern.compile(regex_Time);
        Matcher matcher = pattern.matcher(txtCaLam.getText());
        if(!matcher.matches()){
            JOptionPane.showMessageDialog(rootPane, "Định dạng giờ sai (hh::mm)");
            return false;
        }
        else
            return true;
    }
    public boolean validateForm(){
        if(!(txtTenNV.getText().isEmpty()||txtDiaCHi.getText().isEmpty()||txt_NgaySinh.getText().isEmpty()||txtChucVu.getText().isEmpty()||txtSDT.getText().isEmpty()||txtCaLam.getText().isEmpty())){
            if(validateDateFormat()&&validateTimeFormat())
                return true;
        }
        else 
            JOptionPane.showMessageDialog(rootPane, "Vui lòng nhập đầy đủ thông tin");
            return false;
    }
    private void xulyClickTable(){
        DefaultTableModel dtm =(DefaultTableModel)jTable.getModel();
        if(jTable.getSelectedRow()>-1){
            txtMaNV.setText(jTable.getValueAt(jTable.getSelectedRow(), 0)+"");
            txtTenNV.setText(jTable.getValueAt(jTable.getSelectedRow(), 1)+"");
            txt_NgaySinh.setText(jTable.getValueAt(jTable.getSelectedRow(), 2)+"");
            txtDiaCHi.setText(jTable.getValueAt(jTable.getSelectedRow(), 3)+"");
            txtSDT.setText(jTable.getValueAt(jTable.getSelectedRow(), 4)+"");
            txtChucVu.setText(jTable.getValueAt(jTable.getSelectedRow(), 5)+"");
            txtCaLam.setText(jTable.getValueAt(jTable.getSelectedRow(), 6)+"");
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

        buttonGroup1 = new javax.swing.ButtonGroup();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable = new javax.swing.JTable();
        RB_Them = new javax.swing.JRadioButton();
        RB_XOa = new javax.swing.JRadioButton();
        txtCaLam = new Custom.TextField();
        jLabel1 = new javax.swing.JLabel();
        RB_Sua = new javax.swing.JRadioButton();
        btn_Huy = new Custom.Button();
        txtMaNV = new Custom.TextField();
        btn_OK = new Custom.Button();
        txtTenNV = new Custom.TextField();
        txtDiaCHi = new Custom.TextField();
        txtSDT = new Custom.TextField();
        txtChucVu = new Custom.TextField();
        panel1 = new Custom.Panel();
        txt_TimTheoMa = new Custom.TextField();
        txtTimTheoTen = new Custom.TextField();
        btnHuyTimKiem = new Custom.Button();
        button2 = new Custom.Button();
        txt_NgaySinh = new Custom.TextField();

        setBackground(new java.awt.Color(255, 255, 255));

        jScrollPane1.setBackground(new java.awt.Color(255, 255, 255));

        jTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Mã nhân viên", "Tên nhân viên", "Ngày sinh", "Địa chỉ", "Số điện thoại", "Chức vụ", "Ca làm"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable);
        if (jTable.getColumnModel().getColumnCount() > 0) {
            jTable.getColumnModel().getColumn(0).setResizable(false);
            jTable.getColumnModel().getColumn(1).setResizable(false);
            jTable.getColumnModel().getColumn(2).setResizable(false);
            jTable.getColumnModel().getColumn(3).setResizable(false);
            jTable.getColumnModel().getColumn(4).setResizable(false);
            jTable.getColumnModel().getColumn(5).setResizable(false);
        }

        RB_Them.setBackground(new java.awt.Color(255, 204, 0));
        buttonGroup1.add(RB_Them);
        RB_Them.setSelected(true);
        RB_Them.setText("THÊM");

        RB_XOa.setBackground(new java.awt.Color(255, 204, 0));
        buttonGroup1.add(RB_XOa);
        RB_XOa.setText("XÓA");
        RB_XOa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RB_XOaActionPerformed(evt);
            }
        });

        txtCaLam.setLabelText("CA LÀM");
        txtCaLam.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCaLamActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setText("THÔNG TIN NHÂN VIÊN");

        RB_Sua.setBackground(new java.awt.Color(255, 204, 0));
        buttonGroup1.add(RB_Sua);
        RB_Sua.setText("SỬA");

        btn_Huy.setText("HỦY");
        btn_Huy.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_HuyActionPerformed(evt);
            }
        });

        txtMaNV.setEditable(false);
        txtMaNV.setBackground(new java.awt.Color(255, 255, 255));
        txtMaNV.setLabelText("MÃ NHÂN VIÊN");

        btn_OK.setText("OK");
        btn_OK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_OKActionPerformed(evt);
            }
        });

        txtTenNV.setLabelText("TÊN NHÂN VIÊN");

        txtDiaCHi.setLabelText("ĐỊA CHỈ");

        txtSDT.setLabelText("SỐ ĐIỆN THOẠI");
        txtSDT.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtSDTKeyTyped(evt);
            }
        });

        txtChucVu.setLabelText("CHỨC VỤ");

        panel1.setBackground(new java.awt.Color(255, 255, 255));
        panel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        txt_TimTheoMa.setLabelText("TÌM THEO MÃ");

        txtTimTheoTen.setLabelText("TÌM THEO TÊN");

        btnHuyTimKiem.setText("Hủy");
        btnHuyTimKiem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHuyTimKiemActionPerformed(evt);
            }
        });

        button2.setText("Tìm");
        button2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panel1Layout = new javax.swing.GroupLayout(panel1);
        panel1.setLayout(panel1Layout);
        panel1Layout.setHorizontalGroup(
            panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panel1Layout.createSequentialGroup()
                        .addGap(0, 73, Short.MAX_VALUE)
                        .addComponent(btnHuyTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(39, 39, 39)
                        .addComponent(button2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(78, 78, 78))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel1Layout.createSequentialGroup()
                        .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txtTimTheoTen, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txt_TimTheoMa, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addContainerGap())))
        );
        panel1Layout.setVerticalGroup(
            panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txt_TimTheoMa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 8, Short.MAX_VALUE)
                .addComponent(txtTimTheoTen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnHuyTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(button2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        txt_NgaySinh.setLabelText("NGÀY SINH");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
            .addGroup(layout.createSequentialGroup()
                .addGap(94, 94, 94)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtTenNV, javax.swing.GroupLayout.DEFAULT_SIZE, 120, Short.MAX_VALUE)
                    .addComponent(txtMaNV, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtCaLam, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txt_NgaySinh, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(56, 56, 56)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtSDT, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtChucVu, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtDiaCHi, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(RB_Them)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(RB_Sua)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(RB_XOa))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btn_Huy, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_OK, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 77, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(panel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(316, 316, 316))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtDiaCHi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtMaNV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtTenNV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtSDT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(76, 76, 76)
                                .addComponent(txtCaLam, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(15, 15, 15))
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txtChucVu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txt_NgaySinh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(7, 7, 7)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(RB_Them)
                                    .addComponent(RB_Sua)
                                    .addComponent(RB_XOa))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(btn_Huy, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btn_OK, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addComponent(panel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 256, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void RB_XOaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RB_XOaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_RB_XOaActionPerformed

    private void btn_OKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_OKActionPerformed
        // TODO add your handling code here:
        if(validateForm())
            if(RB_Them.isSelected())
                xulyThemNV();
            else if(RB_Sua.isSelected())
                xulySuaNV();
            else if(RB_XOa.isSelected())
                xulyXoaNV();
        
    }//GEN-LAST:event_btn_OKActionPerformed

    private void txtCaLamActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCaLamActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCaLamActionPerformed

    private void btnHuyTimKiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHuyTimKiemActionPerformed
        // TODO add your handling code here:
        txtTimTheoTen.setText("");
        txt_TimTheoMa.setText("");
        loadDatalenTable();
    }//GEN-LAST:event_btnHuyTimKiemActionPerformed

    private void button2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button2ActionPerformed
        // TODO add your handling code here:
        if(txtTimTheoTen.getText().isEmpty()&&txt_TimTheoMa.getText().isEmpty())
            JOptionPane.showMessageDialog(rootPane, "Vui lòng nhập đầy đủ thông tin để tìm kiếm");
        else if(!txtTimTheoTen.getText().isEmpty()&&txt_TimTheoMa.getText().isEmpty())
            timKiemTheoTen();
        else if(txtTimTheoTen.getText().isEmpty()&&!txt_TimTheoMa.getText().isEmpty())
            timKiemTheoMa();
        else if(!txtTimTheoTen.getText().isEmpty()&&!txt_TimTheoMa.getText().isEmpty())
            timKiemTongHop();
            
            
    }//GEN-LAST:event_button2ActionPerformed

    private void jTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableMouseClicked
        // TODO add your handling code here:a
        xulyClickTable();
    }//GEN-LAST:event_jTableMouseClicked

    private void btn_HuyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_HuyActionPerformed
        // TODO add your handling code here:
        txtMaNV.setText("");
        txtTenNV.setText("");
        txt_NgaySinh.setText("");
        txtDiaCHi.setText("");
        txtSDT.setText("");
        txtChucVu.setText("");
        txtCaLam.setText("");
    }//GEN-LAST:event_btn_HuyActionPerformed

    private void txtSDTKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSDTKeyTyped
        // TODO add your handling code here:
        char c = evt.getKeyChar();
        if(!((Character.isDigit(c))||(c==KeyEvent.VK_BACK_SPACE)||c==KeyEvent.VK_DELETE))
            evt.consume();
    }//GEN-LAST:event_txtSDTKeyTyped


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JRadioButton RB_Sua;
    private javax.swing.JRadioButton RB_Them;
    private javax.swing.JRadioButton RB_XOa;
    private Custom.Button btnHuyTimKiem;
    private Custom.Button btn_Huy;
    private Custom.Button btn_OK;
    private Custom.Button button2;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable;
    private Custom.Panel panel1;
    private Custom.TextField txtCaLam;
    private Custom.TextField txtChucVu;
    private Custom.TextField txtDiaCHi;
    private Custom.TextField txtMaNV;
    private Custom.TextField txtSDT;
    private Custom.TextField txtTenNV;
    private Custom.TextField txtTimTheoTen;
    private Custom.TextField txt_NgaySinh;
    private Custom.TextField txt_TimTheoMa;
    // End of variables declaration//GEN-END:variables
}
