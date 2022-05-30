/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package GUI;

import BUS.HOADON_BUS;
import DTO.HOADON_DTO;
import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.plaf.basic.BasicInternalFrameUI;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author DELL
 */
public class HoaDon_GUI extends javax.swing.JInternalFrame {
    HOADON_BUS hd_bus = new HOADON_BUS();
    double giagoc,tongtien,giamgia;
    
    /**
     * Creates new form HoaDon_GUI
     */
    public HoaDon_GUI() {
        initComponents();
        BasicInternalFrameUI BI = (BasicInternalFrameUI)this.getUI();
        BI.setNorthPane(null);
        loadDataLenTable();
        
//        jPanel1.add(new CTHD_GUI()).setVisible(true);
    
    }
    public boolean checkMANV() throws SQLException{
        if(!hd_bus.checkMaNV(txtMANV.getText())){
            JOptionPane.showMessageDialog(Panel_HoaDon, "Mã nhân viên không tồn tại");
            return false;
        }
        return true;
            
    }
    public boolean validateForm(){
        if(Integer.parseInt(txtMaHD.getText())==0||Integer.parseInt(txtMAKH.getText())==0||Integer.parseInt(txtMANV.getText())==0||txtGIAMGIA.getText().isEmpty()||txtTONGTIEN.getText().isEmpty()){
            JOptionPane.showMessageDialog(Panel_HoaDon, "Vui lòng nhập đầy đủ thông tin");
            return false;
        }
        return true;
    }
    private void xulySua(){
        boolean flag= hd_bus.suaHD(Integer.parseInt(txtMaHD.getText()), Integer.parseInt(txtMAKH.getText()), Integer.parseInt(txtMANV.getText()), Double.parseDouble(txtGIAMGIA.getText()), Double.parseDouble(txtTONGTIEN.getText()));
        if(flag)
            JOptionPane.showMessageDialog(rootPane, "Sửa thành công");
        else
            JOptionPane.showMessageDialog(rootPane, "Sửa thất bại");
        loadDataLenTable();    
    }
    private void xulyXoa(){
        int response= JOptionPane.showConfirmDialog(rootPane, "Bạn có chắc chắn muốn xóa ?","Confirm",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
        if(response==JOptionPane.YES_OPTION){
            boolean flag = hd_bus.xoaHD(Integer.parseInt(txtMaHD.getText()));
            if(flag){
                JOptionPane.showMessageDialog(rootPane, "Xóa thành công");
                loadDataLenTable();
            }
        }
    }
    private void xulyThem(){
    boolean flag = hd_bus.themHD(Integer.parseInt(txtMaHD.getText()),Integer.parseInt(txtMAKH.getText()),Integer.parseInt(txtMANV.getText()),Double.parseDouble(txtGIAMGIA.getText()),Double.parseDouble(txtTONGTIEN.getText()));
        if(flag)
            JOptionPane.showMessageDialog(Panel_HoaDon, "Thêm thành công");
        else
            JOptionPane.showMessageDialog(Panel_HoaDon, "Thêm thất bại");
        hd_bus.doclistHD();
        loadDataLenTable();
    }
    private void xulyClickTable(){
        DefaultTableModel dtm = (DefaultTableModel)table.getModel();
        if(table.getSelectedRow()>-1){
            int row = table.getSelectedRow();
            String mahd=table.getValueAt(row, 0)+"";
            String makh=table.getValueAt(row, 1)+"";
            String manv=table.getValueAt(row, 2)+"";
            String giamgia=table.getValueAt(row, 3)+"";
            String tongtien=table.getValueAt(row, 4)+"";
            txtMaHD.setText(mahd);
            txtMAKH.setText(makh);
            txtMANV.setText(manv);
            txtGIAMGIA.setText(giamgia);
            txtTONGTIEN.setText(tongtien);
            label_PDF_MAHD.setText(mahd);
            label_PDF_MAKH.setText(makh);
            label_PDF_MANV.setText(manv);
            label_PDF_GIAMGIA.setText(giamgia);
            label_PDF_TONGTIEN.setText(tongtien);
        }   
    }
    private void loadDataLenTable(){
        DefaultTableModel dtm = (DefaultTableModel)table.getModel();
        hd_bus.doclistHD();
        dtm.setRowCount(0);
        ArrayList<HOADON_DTO>dshd=hd_bus.getlistHD();
        for(HOADON_DTO hd:dshd){
            Vector vec = new Vector();
            vec.add(hd.getMahd());
            vec.add(hd.getMakh());
            vec.add(hd.getManv());
            vec.add(hd.getGiamgia());
            vec.add(hd.getTongtien());
            dtm.addRow(vec);
        }
    }
    private void InPDF_Jpanel(JPanel panel){
        PrinterJob printerjob =PrinterJob.getPrinterJob();
        printerjob.setJobName("In");
        printerjob.setPrintable(new Printable() {
            @Override
            public int print(Graphics graphics, PageFormat pageFormat, int pageIndex) throws PrinterException {
                if(pageIndex>0)
                    return Printable.NO_SUCH_PAGE;
                Graphics2D g2d = (Graphics2D)graphics;
                g2d.translate(pageFormat.getImageableX()*2, pageFormat.getImageableY()*2);
                g2d.scale(0.5, 0.5);
                panel.paint(g2d);
                return Printable.PAGE_EXISTS;
            }
        });
        boolean returningResult=printerjob.printDialog();
        if(returningResult){
            try {
                printerjob.print();
            } catch (Exception e) {
                
            }
        }
    }
    class panelGradient extends JPanel{
        protected void paintComponent(Graphics g){
            Graphics2D g2d =(Graphics2D)g;
            int width=getWidth();
            int height=getHeight();
            Color color1=new Color(0, 204, 255);
            Color color2 = Color.GREEN;
            GradientPaint gp = new GradientPaint(0, 0, color1, 180,height,color2);
            g2d.setPaint(gp);
            g2d.fillRect(0, 0, width, height);
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
        buttonGroup2 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jToolBar1 = new javax.swing.JToolBar();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        Panel_HoaDon = new panelGradient();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        label_PDF_MAHD = new javax.swing.JLabel();
        label_PDF_MAKH = new javax.swing.JLabel();
        label_PDF_MANV = new javax.swing.JLabel();
        label_PDF_GIAMGIA = new javax.swing.JLabel();
        label_PDF_TONGTIEN = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();
        txtMaHD = new Custom.TextField();
        txtMAKH = new Custom.TextField();
        txtMANV = new Custom.TextField();
        txtGIAMGIA = new Custom.TextField();
        txtTONGTIEN = new Custom.TextField();
        RB_THEM = new javax.swing.JRadioButton();
        RB_Sua = new javax.swing.JRadioButton();
        RB_Xoa = new javax.swing.JRadioButton();
        btn_HUY = new Custom.Button();
        btn_OK = new Custom.Button();
        button3 = new Custom.Button();

        jToolBar1.setBackground(new java.awt.Color(255, 153, 153));
        jToolBar1.setBorder(null);
        jToolBar1.setFloatable(false);
        jToolBar1.setForeground(new java.awt.Color(255, 153, 153));
        jToolBar1.setRollover(true);
        jToolBar1.setBorderPainted(false);
        jToolBar1.setOpaque(false);

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/icons8_bill_16px.png"))); // NOI18N
        jButton1.setText("HÓA ĐƠN");
        jButton1.setBorderPainted(false);
        jButton1.setContentAreaFilled(false);
        jButton1.setFocusable(false);
        jButton1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton1.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar1.add(jButton1);

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/icons8_bill_16px_1.png"))); // NOI18N
        jButton2.setText("CHI TIẾT HÓA ĐƠN");
        jButton2.setBorderPainted(false);
        jButton2.setContentAreaFilled(false);
        jButton2.setFocusable(false);
        jButton2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton2.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar1.add(jButton2);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel1.setText("HÓA ĐƠN");

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setText("HÓA ĐƠN XUẤT");

        jLabel3.setText("Mã hóa đơn");

        jLabel4.setText("Mã khách hàng");

        jLabel5.setText("Mã nhân viên");

        jLabel6.setText("Giảm giá");

        jLabel7.setText("Tổng tiền");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel2))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jLabel3)
                                .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(jLabel6)
                            .addComponent(jLabel7))
                        .addGap(40, 40, 40)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(label_PDF_MAHD, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(label_PDF_MAKH, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(label_PDF_MANV, javax.swing.GroupLayout.DEFAULT_SIZE, 149, Short.MAX_VALUE)
                            .addComponent(label_PDF_GIAMGIA, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(label_PDF_TONGTIEN, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addGap(128, 128, 128))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(label_PDF_MAHD))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(label_PDF_MAKH))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(label_PDF_MANV))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(label_PDF_GIAMGIA))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(label_PDF_TONGTIEN))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Mã hóa đơn", "Mã khách hàng", "Mã nhân viên", "Giảm giá", "Tổng tiền"
            }
        ));
        table.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(table);

        txtMaHD.setLabelText("Mã hóa đơn");
        txtMaHD.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtMaHDKeyReleased(evt);
            }
        });

        txtMAKH.setLabelText("Mã khách hàng");
        txtMAKH.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtMAKHKeyReleased(evt);
            }
        });

        txtMANV.setLabelText("Mã nhân viên");

        txtGIAMGIA.setEditable(false);
        txtGIAMGIA.setLabelText("Giảm giá");

        txtTONGTIEN.setEditable(false);
        txtTONGTIEN.setLabelText("Tổng tiền");

        buttonGroup1.add(RB_THEM);
        RB_THEM.setSelected(true);
        RB_THEM.setText("THÊM");

        buttonGroup1.add(RB_Sua);
        RB_Sua.setText("SỬA");

        buttonGroup1.add(RB_Xoa);
        RB_Xoa.setText("XÓA");

        btn_HUY.setText("HỦY");
        btn_HUY.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_HUYActionPerformed(evt);
            }
        });

        btn_OK.setText("OK");
        btn_OK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_OKActionPerformed(evt);
            }
        });

        button3.setText("IN HÓA ĐƠN");
        button3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout Panel_HoaDonLayout = new javax.swing.GroupLayout(Panel_HoaDon);
        Panel_HoaDon.setLayout(Panel_HoaDonLayout);
        Panel_HoaDonLayout.setHorizontalGroup(
            Panel_HoaDonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Panel_HoaDonLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(533, 533, 533))
            .addComponent(jScrollPane1)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, Panel_HoaDonLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(Panel_HoaDonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtMaHD, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtMAKH, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtMANV, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtGIAMGIA, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtTONGTIEN, javax.swing.GroupLayout.DEFAULT_SIZE, 92, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(Panel_HoaDonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(Panel_HoaDonLayout.createSequentialGroup()
                        .addComponent(RB_THEM)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(RB_Sua)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(RB_Xoa))
                    .addGroup(Panel_HoaDonLayout.createSequentialGroup()
                        .addComponent(btn_HUY, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btn_OK, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 338, Short.MAX_VALUE)
                .addComponent(button3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        Panel_HoaDonLayout.setVerticalGroup(
            Panel_HoaDonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Panel_HoaDonLayout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addGroup(Panel_HoaDonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(Panel_HoaDonLayout.createSequentialGroup()
                        .addGroup(Panel_HoaDonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(Panel_HoaDonLayout.createSequentialGroup()
                                .addGap(4, 4, 4)
                                .addComponent(txtMaHD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtMAKH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtMANV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(Panel_HoaDonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txtGIAMGIA, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(RB_THEM)
                                    .addComponent(RB_Sua)
                                    .addComponent(RB_Xoa))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(Panel_HoaDonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txtTONGTIEN, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btn_HUY, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btn_OK, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, Panel_HoaDonLayout.createSequentialGroup()
                                .addGap(18, 241, Short.MAX_VALUE)
                                .addComponent(button3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)))
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jToolBar1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(Panel_HoaDon, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(Panel_HoaDon, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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

    private void btn_OKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_OKActionPerformed
        // TODO add your handling code here:
        
            try {
                if(validateForm())
                    if(checkMANV())
                        if(RB_THEM.isSelected())
                            xulyThem();
                        else if(RB_Sua.isSelected())
                            xulySua();
                        else if (RB_Xoa.isSelected())
                            xulyXoa();
        } catch (SQLException ex) {
            Logger.getLogger(HoaDon_GUI.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btn_OKActionPerformed

    private void tableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableMouseClicked
        // TODO add your handling code here:
        xulyClickTable();
    }//GEN-LAST:event_tableMouseClicked

    private void txtMaHDKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtMaHDKeyReleased
        try {
            // TODO add your handling code here:
            txtTONGTIEN.setText(String.valueOf(hd_bus.getTongTien_CTHD(txtMaHD.getText())));
        } catch (SQLException ex) {
            Logger.getLogger(HoaDon_GUI.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_txtMaHDKeyReleased

    private void txtMAKHKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtMAKHKeyReleased
        try {
            // TODO add your handling code here:
            txtGIAMGIA.setText(String.valueOf(hd_bus.checkGIAMGIA(txtMAKH.getText())));
            giamgia=hd_bus.checkGIAMGIA(txtMAKH.getText());
            giagoc=Double.parseDouble(txtTONGTIEN.getText());
            tongtien=Double.parseDouble(txtTONGTIEN.getText());
            tongtien=(tongtien-(giagoc*giamgia/100));
            txtTONGTIEN.setText(String.valueOf(tongtien));
            if(txtMAKH.getText().isEmpty())
                txtTONGTIEN.setText(String.valueOf(giagoc));
        } catch (SQLException ex) {
            Logger.getLogger(HoaDon_GUI.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_txtMAKHKeyReleased

    private void btn_HUYActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_HUYActionPerformed
        // TODO add your handling code here:
        txtMaHD.setText("");
        txtMAKH.setText("");
        txtMANV.setText("");
        txtGIAMGIA.setText("");
        txtTONGTIEN.setText("");
    }//GEN-LAST:event_btn_HUYActionPerformed

    private void button3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button3ActionPerformed
        // TODO add your handling code here:
        InPDF_Jpanel(jPanel2);
    }//GEN-LAST:event_button3ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Panel_HoaDon;
    private javax.swing.JRadioButton RB_Sua;
    private javax.swing.JRadioButton RB_THEM;
    private javax.swing.JRadioButton RB_Xoa;
    private Custom.Button btn_HUY;
    private Custom.Button btn_OK;
    private Custom.Button button3;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JLabel label_PDF_GIAMGIA;
    private javax.swing.JLabel label_PDF_MAHD;
    private javax.swing.JLabel label_PDF_MAKH;
    private javax.swing.JLabel label_PDF_MANV;
    private javax.swing.JLabel label_PDF_TONGTIEN;
    private javax.swing.JTable table;
    private Custom.TextField txtGIAMGIA;
    private Custom.TextField txtMAKH;
    private Custom.TextField txtMANV;
    private Custom.TextField txtMaHD;
    private Custom.TextField txtTONGTIEN;
    // End of variables declaration//GEN-END:variables
}
