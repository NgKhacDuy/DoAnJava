/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package GUI;

import BUS.KHACHHANG_BUS;
import BUS.NHANVIEN_BUS;
import DTO.KHACHHANG_DTO;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.plaf.basic.BasicInternalFrameUI;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author DELL
 */
public class KHACHHANG_GUI extends javax.swing.JInternalFrame {
    KHACHHANG_BUS kh_bus = new KHACHHANG_BUS();
    /**
     * Creates new form KHACHHANG_GUI
     */
    public KHACHHANG_GUI() {
        initComponents();
        BasicInternalFrameUI BI = (BasicInternalFrameUI)this.getUI();
        BI.setNorthPane(null);
        RB_Them.setSelected(true);
        LoadDataLenTable();
    }
    private boolean validateForm(){
        if(txtTenKH.getText().isEmpty()||txtSDT.getText().isEmpty()){
            JOptionPane.showMessageDialog(rootPane, "Vui lòng nhập đầy đủ thông tin");
            return false;
        }
        return true;
    }
    private void xulyThemKH(){
        boolean flag = kh_bus.themKH(txtTenKH.getText(), txtSDT.getText());
        try{
            kh_bus.docListKH();
            LoadDataLenTable();
        } catch (Exception e){}
    }
    private void xulySuaKH(){
        boolean flag = kh_bus.suaKH(txtMaKH.getText(), txtTenKH.getText(), txtSDT.getText());
       kh_bus.docListKH();
       if(flag)
            JOptionPane.showMessageDialog(rootPane, "Sửa thành công");
        else
            JOptionPane.showMessageDialog(rootPane, "Sửa thất bại");
        LoadDataLenTable();
    }
    private void xulyXoaKH(){
        int response=JOptionPane.showConfirmDialog(rootPane, "Bạn có chắc chắn muốn xóa ?","Confirm",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
        if(response==JOptionPane.YES_OPTION){
            boolean flag = kh_bus.xoaKH(txtMaKH.getText());
            if(flag){
                JOptionPane.showMessageDialog(rootPane, "Xóa thành công");
                LoadDataLenTable();
            }
            else
                JOptionPane.showMessageDialog(rootPane, "Xóa thất bại");
        }
    }
    private void xulyTimKiemTen(){
        String ten = txtTimTheoTen.getText().toLowerCase();
        DefaultTableModel dtm =(DefaultTableModel)jtable.getModel();
        dtm.setRowCount(0);
        ArrayList<KHACHHANG_DTO>dskh=null;
        dskh=kh_bus.getKHTheoTen(ten);
        for(KHACHHANG_DTO kh:dskh){
            Vector vec = new Vector();
            vec.add(kh.getMAKH());
            vec.add(kh.getTENKH());
            vec.add(kh.getSDT());
            dtm.addRow(vec);
        }
    }
    private void xulyTimKiemMa(){
        String ma = txtTimTheoMa.getText();
        DefaultTableModel dtm =(DefaultTableModel)jtable.getModel();
        dtm.setRowCount(0);
        ArrayList<KHACHHANG_DTO>dskh=null;
        dskh=kh_bus.getKHTheoMa(ma);
        for(KHACHHANG_DTO kh:dskh){
            Vector vec = new Vector();
            vec.add(kh.getMAKH());
            vec.add(kh.getTENKH());
            vec.add(kh.getSDT());
            dtm.addRow(vec);
        }
    }
    
    private void xulyClickTable(){
        DefaultTableModel dtm =(DefaultTableModel)jtable.getModel();
        if(jtable.getSelectedRow()>-1){
            String ma = jtable.getValueAt(jtable.getSelectedRow(), 0)+"";
            String ten=jtable.getValueAt(jtable.getSelectedRow(), 1)+"";
            String sdt=jtable.getValueAt(jtable.getSelectedRow(), 2)+"";
            txtMaKH.setText(ma);
            txtTenKH.setText(ten);
            txtSDT.setText(sdt);
        }
    }
    private void LoadDataLenTable(){
        DefaultTableModel dtm = (DefaultTableModel)jtable.getModel();
        kh_bus.docListKH();
        dtm.setRowCount(0);
        ArrayList<KHACHHANG_DTO> dskh=kh_bus.getListKH();
        for(KHACHHANG_DTO kh:dskh){
            Vector vec = new Vector();
            vec.add(kh.getMAKH());
            vec.add(kh.getTENKH());
            vec.add(kh.getSDT());
            dtm.addRow(vec);
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
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtable = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        txtMaKH = new Custom.TextField();
        txtTenKH = new Custom.TextField();
        txtSDT = new Custom.TextField();
        btnHuy = new Custom.Button();
        btnOK = new Custom.Button();
        RB_Them = new javax.swing.JRadioButton();
        RB_Sua = new javax.swing.JRadioButton();
        RB_Xoa = new javax.swing.JRadioButton();
        panel1 = new Custom.Panel();
        jLabel2 = new javax.swing.JLabel();
        txtTimTheoMa = new Custom.TextField();
        txtTimTheoTen = new Custom.TextField();
        btnHuyTim = new Custom.Button();
        btnTimKiem = new Custom.Button();

        setBackground(new java.awt.Color(255, 255, 255));
        setPreferredSize(new java.awt.Dimension(1146, 595));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jScrollPane1.setBackground(new java.awt.Color(255, 255, 255));

        jtable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Mã khách hàng", "Tên khách hàng", "Số điện thoại"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jtable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jtable);
        if (jtable.getColumnModel().getColumnCount() > 0) {
            jtable.getColumnModel().getColumn(0).setResizable(false);
            jtable.getColumnModel().getColumn(1).setResizable(false);
            jtable.getColumnModel().getColumn(2).setResizable(false);
        }

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setText("THÔNG TIN KHÁCH HÀNG");

        txtMaKH.setEditable(false);
        txtMaKH.setLabelText("Mã khách hàng");

        txtTenKH.setLabelText("Tên khách hàng");
        txtTenKH.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtTenKHKeyTyped(evt);
            }
        });

        txtSDT.setLabelText("Số điện thoại");

        btnHuy.setText("HỦY");
        btnHuy.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHuyActionPerformed(evt);
            }
        });

        btnOK.setText("OK");
        btnOK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOKActionPerformed(evt);
            }
        });

        buttonGroup1.add(RB_Them);
        RB_Them.setText("THÊM");

        buttonGroup1.add(RB_Sua);
        RB_Sua.setText("SỬA");

        buttonGroup1.add(RB_Xoa);
        RB_Xoa.setText("XÓA");

        panel1.setBackground(new java.awt.Color(255, 102, 255));
        panel1.setRoundBottomLeft(100);
        panel1.setRoundBottomRight(100);
        panel1.setRoundTopLeft(100);
        panel1.setRoundTopRight(100);

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("TÌM KIẾM KHÁCH HÀNG");

        txtTimTheoMa.setLabelText("TÌM THEO MÃ");

        txtTimTheoTen.setLabelText("TÌM THEO TÊN");

        btnHuyTim.setText("HỦY");
        btnHuyTim.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHuyTimActionPerformed(evt);
            }
        });

        btnTimKiem.setText("OK");
        btnTimKiem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTimKiemActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panel1Layout = new javax.swing.GroupLayout(panel1);
        panel1.setLayout(panel1Layout);
        panel1Layout.setHorizontalGroup(
            panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel1Layout.createSequentialGroup()
                .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panel1Layout.createSequentialGroup()
                        .addGap(66, 66, 66)
                        .addComponent(jLabel2)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(panel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(txtTimTheoMa, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 40, Short.MAX_VALUE)
                        .addComponent(txtTimTheoTen, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panel1Layout.createSequentialGroup()
                        .addGap(81, 81, 81)
                        .addComponent(btnHuyTim, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(69, 69, 69)))
                .addContainerGap())
        );
        panel1Layout.setVerticalGroup(
            panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtTimTheoMa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTimTheoTen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnHuyTim, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(495, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(409, 409, 409))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(266, 266, 266)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtMaKH, javax.swing.GroupLayout.DEFAULT_SIZE, 133, Short.MAX_VALUE)
                    .addComponent(txtTenKH, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtSDT, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(49, 49, 49)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnHuy, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnOK, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(RB_Them)
                        .addGap(18, 18, 18)
                        .addComponent(RB_Sua)
                        .addGap(18, 18, 18)
                        .addComponent(RB_Xoa)))
                .addGap(127, 127, 127)
                .addComponent(panel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 264, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(txtMaKH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtTenKH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(RB_Them)
                            .addComponent(RB_Sua)
                            .addComponent(RB_Xoa))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtSDT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnHuy, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnOK, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(panel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 63, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnOKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOKActionPerformed
        // TODO add your handling code here:
        if(validateForm())
            if(RB_Them.isSelected())
                xulyThemKH();
            else if(RB_Sua.isSelected())
                xulySuaKH();
            else
                xulyXoaKH();
    }//GEN-LAST:event_btnOKActionPerformed

    private void btnHuyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHuyActionPerformed
        // TODO add your handling code here:
        txtMaKH.setText("");
        txtTenKH.setText("");
        txtSDT.setText("");
    }//GEN-LAST:event_btnHuyActionPerformed

    private void btnTimKiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTimKiemActionPerformed
        // TODO add your handling code here:
        if(txtTimTheoMa.getText().isEmpty()&&txtTimTheoTen.getText().isEmpty())
            JOptionPane.showMessageDialog(rootPane, "Nhập gì đó mới tìm đc chứ");
        else if(!txtTimTheoMa.getText().isEmpty())
            xulyTimKiemMa();
        else
            xulyTimKiemTen();
    }//GEN-LAST:event_btnTimKiemActionPerformed

    private void btnHuyTimActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHuyTimActionPerformed
        txtTimTheoMa.setText("");
        txtTimTheoTen.setText("");
        LoadDataLenTable();
        // TODO add your handling code here:
    }//GEN-LAST:event_btnHuyTimActionPerformed

    private void txtTenKHKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTenKHKeyTyped
        // TODO add your handling code here:
        
        
    }//GEN-LAST:event_txtTenKHKeyTyped

    private void jtableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtableMouseClicked
        // TODO add your handling code here:
        xulyClickTable();
    }//GEN-LAST:event_jtableMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JRadioButton RB_Sua;
    private javax.swing.JRadioButton RB_Them;
    private javax.swing.JRadioButton RB_Xoa;
    private Custom.Button btnHuy;
    private Custom.Button btnHuyTim;
    private Custom.Button btnOK;
    private Custom.Button btnTimKiem;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jtable;
    private Custom.Panel panel1;
    private Custom.TextField txtMaKH;
    private Custom.TextField txtSDT;
    private Custom.TextField txtTenKH;
    private Custom.TextField txtTimTheoMa;
    private Custom.TextField txtTimTheoTen;
    // End of variables declaration//GEN-END:variables
}
