/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package GUI;

import BUS.LOAISP_BUS;
import DTO.LOAISP_DTO;
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
public class LOAISP_GUI extends javax.swing.JInternalFrame {
    LOAISP_BUS loaisp_bus = new LOAISP_BUS();

    /**
     * Creates new form LOAISP_GUI
     */
    public LOAISP_GUI() {
        initComponents();
        BasicInternalFrameUI BI = (BasicInternalFrameUI)this.getUI();
        BI.setNorthPane(null);
        RB_Them.setSelected(true);
        LoadDataLenBang();
    }
    private boolean validateForm(){
        if(txtTenLoai.getText().isEmpty()){
                JOptionPane.showMessageDialog(rootPane, "Vui lòng nhập tên loại");
                return false;
        }
        return true;
    }
    private void xulyThemLoai(){
        boolean flag = loaisp_bus.themLoai(txtTenLoai.getText());
        try {
            loaisp_bus.docListLoaiSP();
            LoadDataLenBang();
        } catch (Exception e) {
        }
    }
    private void xulySuaLoai(){
        boolean flag = loaisp_bus.suaLoai(txtMaLoai.getText(), txtTenLoai.getText());
        loaisp_bus.docListLoaiSP();
        if(flag)
            JOptionPane.showMessageDialog(rootPane, "Sửa thành công");
        else
            JOptionPane.showMessageDialog(rootPane, "Sửa thất bại");
        LoadDataLenBang();
    }
    private void xulyXoaLoai(){
        int response=JOptionPane.showConfirmDialog(rootPane, "Bạn có chắc chắn muốn xóa ?","Confirm",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
        if(response==JOptionPane.YES_OPTION){
            boolean flag = loaisp_bus.xoaLoai(txtMaLoai.getText());
            if(flag){
                JOptionPane.showMessageDialog(rootPane, "Xóa thành công");
                LoadDataLenBang();
            }
        }
    }
    private void xulyTimKiemTen(){
        String ten = txt_Tim_Ten.getText().toLowerCase();
        DefaultTableModel dtm =(DefaultTableModel)jTable.getModel();
        dtm.setRowCount(0);
        ArrayList<LOAISP_DTO>dsloai=null;
        dsloai=loaisp_bus.getLoaiTheoTen(ten);
        for(LOAISP_DTO loaisp:dsloai){
            Vector vec = new Vector();
            vec.add(loaisp.getMaloaisp());
            vec.add(loaisp.getTenloaisp());
            dtm.addRow(vec);
        }
    }
    private void xulyTimKiemMa(){
        String loai = txt_Tim_Ma.getText();
        DefaultTableModel dtm =(DefaultTableModel)jTable.getModel();
        dtm.setRowCount(0);
        ArrayList<LOAISP_DTO>dsloai=null;
        dsloai=loaisp_bus.getLoaiTheoMa(loai);
        for(LOAISP_DTO loaisp:dsloai){
            Vector vec = new Vector();
            vec.add(loaisp.getMaloaisp());
            vec.add(loaisp.getTenloaisp());
            dtm.addRow(vec);
        }
    }
    
    private void xulyClickTable(){
        DefaultTableModel dtm =(DefaultTableModel)jTable.getModel();
        if(jTable.getSelectedRow()>-1){
            String ma = jTable.getValueAt(jTable.getSelectedRow(), 0)+"";
            String ten=jTable.getValueAt(jTable.getSelectedRow(), 1)+"";
            txtMaLoai.setText(ma);
            txtTenLoai.setText(ten);
        }
    }
    private void LoadDataLenBang(){
        DefaultTableModel dtm = (DefaultTableModel)jTable.getModel();
        loaisp_bus.docListLoaiSP();
        dtm.setRowCount(0);
        ArrayList<LOAISP_DTO> dsloai=loaisp_bus.getListLoaiSP();
        for(LOAISP_DTO loaisp:dsloai){
            Vector vec = new Vector();
            vec.add(loaisp.getMaloaisp());
            vec.add(loaisp.getTenloaisp());
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
        jTable = new javax.swing.JTable();
        panel1 = new Custom.Panel();
        jLabel1 = new javax.swing.JLabel();
        txtMaLoai = new Custom.TextField();
        txtTenLoai = new Custom.TextField();
        Btn_Huy = new Custom.Button();
        btn_OK = new Custom.Button();
        RB_Them = new javax.swing.JRadioButton();
        RB_Sua = new javax.swing.JRadioButton();
        RB_Xoa = new javax.swing.JRadioButton();
        jLabel2 = new javax.swing.JLabel();
        txt_Tim_Ma = new Custom.TextField();
        txt_Tim_Ten = new Custom.TextField();
        btn_Tim = new Custom.Button();
        btn_Huy_Tim = new Custom.Button();

        setBackground(new java.awt.Color(255, 255, 255));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 3, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 596, Short.MAX_VALUE)
        );

        jScrollPane1.setBackground(new java.awt.Color(255, 255, 255));

        jTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Mã loại sản phẩm", "Tên Loại Sản Phẩm"
            }
        ));
        jTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable);

        panel1.setBackground(new java.awt.Color(153, 255, 153));
        panel1.setRoundBottomLeft(100);
        panel1.setRoundBottomRight(100);
        panel1.setRoundTopLeft(100);
        panel1.setRoundTopRight(100);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setText("THÔNG TIN LOẠI SẢN PHẨM");

        txtMaLoai.setEditable(false);
        txtMaLoai.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txtMaLoai.setLabelText("MÃ LOẠI SẢN PHẨM");

        txtTenLoai.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txtTenLoai.setLabelText("TÊN LOẠI SẢN PHẨM");

        Btn_Huy.setText("HỦY");
        Btn_Huy.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_HuyActionPerformed(evt);
            }
        });

        btn_OK.setText("OK");
        btn_OK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_OKActionPerformed(evt);
            }
        });

        RB_Them.setBackground(new java.awt.Color(255, 255, 255));
        buttonGroup1.add(RB_Them);
        RB_Them.setText("THÊM");

        RB_Sua.setBackground(new java.awt.Color(255, 255, 255));
        buttonGroup1.add(RB_Sua);
        RB_Sua.setText("SỬA ");

        RB_Xoa.setBackground(new java.awt.Color(255, 255, 255));
        buttonGroup1.add(RB_Xoa);
        RB_Xoa.setText("XÓA");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setText("TÌM KIẾM LOẠI SẢN PHẨM");

        txt_Tim_Ma.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        txt_Tim_Ma.setLabelText("TÌM THEO MÃ LOẠI");

        txt_Tim_Ten.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        txt_Tim_Ten.setLabelText("TÌM THEO TÊN LOẠI");

        btn_Tim.setText("TÌM");
        btn_Tim.setRadius(24);
        btn_Tim.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_TimMouseClicked(evt);
            }
        });

        btn_Huy_Tim.setLabel("HỦY");
        btn_Huy_Tim.setRadius(24);
        btn_Huy_Tim.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_Huy_TimActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panel1Layout = new javax.swing.GroupLayout(panel1);
        panel1.setLayout(panel1Layout);
        panel1Layout.setHorizontalGroup(
            panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel1Layout.createSequentialGroup()
                .addContainerGap(270, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(249, 249, 249))
            .addGroup(panel1Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtMaLoai, javax.swing.GroupLayout.DEFAULT_SIZE, 165, Short.MAX_VALUE)
                    .addComponent(txtTenLoai, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(panel1Layout.createSequentialGroup()
                        .addComponent(Btn_Huy, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btn_OK, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(panel1Layout.createSequentialGroup()
                        .addComponent(RB_Them)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(RB_Sua)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(RB_Xoa)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txt_Tim_Ma, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txt_Tim_Ten, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btn_Huy_Tim, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btn_Tim, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(32, 32, 32))
        );
        panel1Layout.setVerticalGroup(
            panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panel1Layout.createSequentialGroup()
                        .addGap(11, 11, 11)
                        .addComponent(jLabel2)
                        .addGap(18, 18, 18)
                        .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(RB_Them)
                                .addComponent(RB_Sua)
                                .addComponent(RB_Xoa))
                            .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(txtMaLoai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txt_Tim_Ma, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(btn_Tim, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 13, Short.MAX_VALUE)
                        .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txt_Tim_Ten, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btn_Huy_Tim, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtTenLoai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(panel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Btn_Huy, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btn_OK, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1132, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(234, 234, 234)
                        .addComponent(panel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 291, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(67, 67, 67)
                .addComponent(panel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 29, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableMouseClicked
        // TODO add your handling code here:
        xulyClickTable();
    }//GEN-LAST:event_jTableMouseClicked

    private void btn_OKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_OKActionPerformed
        // TODO add your handling code here:
        if(validateForm())
            if(RB_Them.isSelected()){
                xulyThemLoai();
            }
            else if (RB_Sua.isSelected())
            xulySuaLoai();
            else 
                xulyXoaLoai();
    }//GEN-LAST:event_btn_OKActionPerformed

    private void Btn_HuyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_HuyActionPerformed
        // TODO add your handling code here:
        txtTenLoai.setText("");
    }//GEN-LAST:event_Btn_HuyActionPerformed

    private void btn_TimMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_TimMouseClicked
        // TODO add your handling code here:
        if(!txt_Tim_Ma.getText().isEmpty()&&txt_Tim_Ten.getText().isEmpty())
            xulyTimKiemMa();
        else if(txt_Tim_Ma.getText().isEmpty()&&!txt_Tim_Ten.getText().isEmpty())
            xulyTimKiemTen();
        else
            JOptionPane.showMessageDialog(rootPane, "Nhập cái gì đó đi mới tìm được chứ nè");
    }//GEN-LAST:event_btn_TimMouseClicked

    private void btn_Huy_TimActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_Huy_TimActionPerformed
        // TODO add your handling code here:
        LoadDataLenBang();
    }//GEN-LAST:event_btn_Huy_TimActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private Custom.Button Btn_Huy;
    private javax.swing.JRadioButton RB_Sua;
    private javax.swing.JRadioButton RB_Them;
    private javax.swing.JRadioButton RB_Xoa;
    private Custom.Button btn_Huy_Tim;
    private Custom.Button btn_OK;
    private Custom.Button btn_Tim;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable;
    private Custom.Panel panel1;
    private Custom.TextField txtMaLoai;
    private Custom.TextField txtTenLoai;
    private Custom.TextField txt_Tim_Ma;
    private Custom.TextField txt_Tim_Ten;
    // End of variables declaration//GEN-END:variables
}