/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package GUI;

import BUS.KHUYENMAI_BUS;
import DTO.KHUYENMAI_DTO;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.plaf.basic.BasicInternalFrameUI;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author DELL
 */
public class KHUYENMAI_GUI extends javax.swing.JInternalFrame {
    KHUYENMAI_BUS km_bus= new KHUYENMAI_BUS();
    /**
     * Creates new form KHUYENMAI_GUI
     */
    public KHUYENMAI_GUI() {
        initComponents();
        BasicInternalFrameUI BI = (BasicInternalFrameUI)this.getUI();
        BI.setNorthPane(null);
        loadDataLenTable();
    }
    public boolean checkMaKH(String ma) throws SQLException{
        if(!km_bus.checkMAKH(ma)){
            JOptionPane.showMessageDialog(rootPane, "Mã khách hàng không tồn tại trong hệ thống");
            return false;
        }
        return true;
    }
    public boolean validateForm(){
        if(txtCTKM.getText().isEmpty()||txtMAKH.getText().isEmpty()||txtGIAMGIA.getText().isEmpty()){
            JOptionPane.showMessageDialog(rootPane, "Vui lòng nhập đủ thông tin");
            return false;
        }
        return true;
    }
    private void timtheomakH(){
        if(txtTimTheoMaKH.getText().isEmpty())
            loadDataLenTable();
        else {
            DefaultTableModel dtm = (DefaultTableModel)table.getModel();
            dtm.setRowCount(0);
            ArrayList<KHUYENMAI_DTO>dskm=null;
            dskm=km_bus.getKMtheoMaKH(txtTimTheoMaKH.getText());
            for(KHUYENMAI_DTO km:dskm){
                Vector vec = new Vector();
                vec.add(km.getCtkm());
                vec.add(km.getMakh());
                vec.add(km.getGiamgia());
                dtm.addRow(vec);
            }
        }
    }
    private void xulythem(){
        boolean flag = km_bus.themKM(txtCTKM.getText(), Integer.parseInt(txtMAKH.getText()), Integer.parseInt(txtGIAMGIA.getText()));
        km_bus.doclistKM();
        loadDataLenTable();
    }
    private void xulysua(){
        boolean flag = km_bus.suaKM(txtCTKM.getText(), Integer.parseInt(txtMAKH.getText()), Integer.parseInt(txtGIAMGIA.getText()));
        if(flag)
            JOptionPane.showMessageDialog(rootPane, "sửa thành công");
        else
            JOptionPane.showMessageDialog(rootPane, "Sửa thất bại");
    }
    private void xulyxoa(){
        int response= JOptionPane.showConfirmDialog(rootPane, "Bạn có chắc chắn muốn xóa ?","Confirm",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
        if(response==JOptionPane.YES_OPTION){
            boolean flag = km_bus.xoaKM(Integer.parseInt(txtMAKH.getText()));
            if(flag){
                JOptionPane.showMessageDialog(rootPane, "Xóa thành công");
                loadDataLenTable();
            }
        }
    }
    private void loadDataLenTable(){
            DefaultTableModel dtm = (DefaultTableModel)table.getModel();
            km_bus.doclistKM();
            dtm.setRowCount(0);
            ArrayList<KHUYENMAI_DTO>dskm=km_bus.getlistKM();
            for(KHUYENMAI_DTO km : dskm){
                Vector vec = new Vector();
                vec.add(km.getCtkm());
                vec.add(km.getMakh());
                vec.add(km.getGiamgia());
                dtm.addRow(vec);
            }
    }
    private void xulyClickTable(){
        DefaultTableModel dtm = (DefaultTableModel)table.getModel();
        int row = table.getSelectedRow();
        if(table.getSelectedRow()>-1){
            String ctkm=table.getValueAt(row, 0)+"";
            String makh=table.getValueAt(row, 1)+"";
            String giamgia=table.getValueAt(row, 2)+"";
            txtCTKM.setText(ctkm);
            txtMAKH.setText(txtMAKH.getText());
            txtGIAMGIA.setText(txtGIAMGIA.getText());
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
        table = new javax.swing.JTable();
        txtCTKM = new Custom.TextField();
        jLabel1 = new javax.swing.JLabel();
        txtMAKH = new Custom.TextField();
        txtGIAMGIA = new Custom.TextField();
        RB_THEM = new javax.swing.JRadioButton();
        RB_SUA = new javax.swing.JRadioButton();
        RB_XOA = new javax.swing.JRadioButton();
        btnOK = new Custom.Button();
        btnHUY = new Custom.Button();
        panel1 = new Custom.Panel();
        txtTimTheoMaKH = new Custom.TextField();
        btnHuyTim = new Custom.Button();
        btnTim = new Custom.Button();

        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Chương trình khuyến mãi", "Mã khách hàng", "% Giảm giá"
            }
        ));
        table.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(table);

        txtCTKM.setLabelText("Chương trình khuyến mãi");

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel1.setText("QUẢN LÝ KHUYẾN MÃI");

        txtMAKH.setLabelText("Mã khách hàng");

        txtGIAMGIA.setLabelText("Giảm giá");

        buttonGroup1.add(RB_THEM);
        RB_THEM.setText("THÊM");

        buttonGroup1.add(RB_SUA);
        RB_SUA.setText("SỬA");

        buttonGroup1.add(RB_XOA);
        RB_XOA.setText("XÓA");

        btnOK.setText("OK");
        btnOK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOKActionPerformed(evt);
            }
        });

        btnHUY.setText("HỦY");
        btnHUY.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHUYActionPerformed(evt);
            }
        });

        panel1.setBackground(new java.awt.Color(204, 255, 153));
        panel1.setRoundBottomRight(100);
        panel1.setRoundTopLeft(100);

        txtTimTheoMaKH.setLabelText("TÌM THEO MÃ KHÁCH HÀNG");

        btnHuyTim.setText("HỦY");
        btnHuyTim.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHuyTimActionPerformed(evt);
            }
        });

        btnTim.setText("OK");

        javax.swing.GroupLayout panel1Layout = new javax.swing.GroupLayout(panel1);
        panel1.setLayout(panel1Layout);
        panel1Layout.setHorizontalGroup(
            panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtTimTheoMaKH, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnHuyTim, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnTim, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(110, Short.MAX_VALUE))
        );
        panel1Layout.setVerticalGroup(
            panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel1Layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtTimTheoMaKH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnHuyTim, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnTim, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(73, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(534, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(473, 473, 473))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(198, 198, 198)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtCTKM, javax.swing.GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE)
                    .addComponent(txtMAKH, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtGIAMGIA, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(47, 47, 47)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnHUY, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(RB_THEM))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(RB_SUA)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(RB_XOA))
                    .addComponent(btnOK, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(127, 127, 127)
                .addComponent(panel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 237, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(53, 53, 53)
                                .addComponent(txtCTKM, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(txtMAKH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(txtGIAMGIA, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(98, 98, 98)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(RB_THEM)
                                    .addComponent(RB_SUA)
                                    .addComponent(RB_XOA))
                                .addGap(27, 27, 27)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(btnOK, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnHUY, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(115, 115, 115)
                        .addComponent(panel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 74, Short.MAX_VALUE))
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
            try {
                if(checkMaKH(txtMAKH.getText()))
                    if(RB_THEM.isSelected())
                        xulythem();
                    else if (RB_SUA.isSelected())
                        xulysua();
                    else if (RB_XOA.isSelected())
                        xulyxoa();
        } catch (SQLException ex) {
            Logger.getLogger(KHUYENMAI_GUI.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnOKActionPerformed

    private void btnHuyTimActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHuyTimActionPerformed
        // TODO add your handling code here:
        loadDataLenTable();
    }//GEN-LAST:event_btnHuyTimActionPerformed

    private void tableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableMouseClicked
        // TODO add your handling code here:
        xulyClickTable();
    }//GEN-LAST:event_tableMouseClicked

    private void btnHUYActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHUYActionPerformed
        // TODO add your handling code here:
        txtCTKM.setText("");
        txtMAKH.setText("");
        txtGIAMGIA.setText("");
    }//GEN-LAST:event_btnHUYActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JRadioButton RB_SUA;
    private javax.swing.JRadioButton RB_THEM;
    private javax.swing.JRadioButton RB_XOA;
    private Custom.Button btnHUY;
    private Custom.Button btnHuyTim;
    private Custom.Button btnOK;
    private Custom.Button btnTim;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private Custom.Panel panel1;
    private javax.swing.JTable table;
    private Custom.TextField txtCTKM;
    private Custom.TextField txtGIAMGIA;
    private Custom.TextField txtMAKH;
    private Custom.TextField txtTimTheoMaKH;
    // End of variables declaration//GEN-END:variables
}
