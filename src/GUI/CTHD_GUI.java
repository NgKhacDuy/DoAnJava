/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package GUI;

import BUS.CTHD_BUS;
import DAO.CTHD_DAO;
import DAO.MyConnect;
import DTO.CTHD_DTO;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.sql.Connection;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.plaf.basic.BasicInternalFrameUI;
import javax.swing.table.DefaultTableModel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.data.jdbc.JDBCCategoryDataset;

/**
 *
 * @author DELL
 */
public class CTHD_GUI extends javax.swing.JInternalFrame {
    CTHD_DAO cthd_dao = new CTHD_DAO();
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    CTHD_BUS cthd_bus = new CTHD_BUS();
    private MyConnect myconnect;

    /**
     * Creates new form CTHD_GUI
     */
    public CTHD_GUI() {
        initComponents();
        loadDataLenTable();
        BasicInternalFrameUI BI = (BasicInternalFrameUI)this.getUI();
        BI.setNorthPane(null);
    }
    public boolean validateForm(){
        if(Integer.parseInt(txtMaSP.getText())==0|| Integer.parseInt(txtSoLuong.getText())==0|| Integer.parseInt(txtDonGia.getText())==0|| Integer.parseInt(txtThanhTien.getText())==0|| txtDate.getDate().equals("")){
            JOptionPane.showMessageDialog(rootPane, "Vui lòng nhập lại dữ liệu");
            return false;
        }
        return true;
        
    }
    private void timTheoMasp(){
        if(txt_TimMaSP.getText().isEmpty())
            loadDataLenTable();
        else{
            DefaultTableModel dtm = (DefaultTableModel)table.getModel();
            dtm.setRowCount(0);
            ArrayList<CTHD_DTO>dscthd=null;
            dscthd=cthd_bus.getCTHDTheoMaSP(txt_TimMaSP.getText());
            for(CTHD_DTO cthd : dscthd){
            Vector vec = new Vector();
            vec.add(cthd.getMahd());
            vec.add(cthd.getMasp());
            vec.add(cthd.getSoluong());
            vec.add(cthd.getDongia());
            vec.add(cthd.getThanhtien());
            vec.add(cthd.getNgaylap());
            dtm.addRow(vec);
            }
        }
    }
    private void timTheoMahd(){
        if(txt_TimMaHD.getText().isEmpty())
            loadDataLenTable();
        else{
            DefaultTableModel dtm = (DefaultTableModel)table.getModel();
            dtm.setRowCount(0);
            ArrayList<CTHD_DTO>dscthd=null;
            dscthd=cthd_bus.getCTHDTheoMaHD(txt_TimMaHD.getText());
            for(CTHD_DTO cthd : dscthd){
            Vector vec = new Vector();
            vec.add(cthd.getMahd());
            vec.add(cthd.getMasp());
            vec.add(cthd.getSoluong());
            vec.add(cthd.getDongia());
            vec.add(cthd.getThanhtien());
            vec.add(cthd.getNgaylap());
            dtm.addRow(vec);
            }
        }
    }
    private void xulySuaHD(){
        boolean flag =cthd_bus.suaCthd(Integer.parseInt(txtMaHD.getText()),Integer.parseInt(txtMaSP.getText()), Integer.parseInt(txtSoLuong.getText()), Integer.parseInt(txtDonGia.getText()), Integer.parseInt(txtThanhTien.getText()),sdf.format(txtDate.getDate()));
        if(flag)
            JOptionPane.showMessageDialog(rootPane, "Sửa thành công");
        else
            JOptionPane.showMessageDialog(rootPane, "Sửa thất bại");
        loadDataLenTable();
    }
    private void xulyXoaHD(){
        int response= JOptionPane.showConfirmDialog(rootPane, "Bạn có chắc chắn muốn xóa ?","Confirm",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
        if(response==JOptionPane.YES_OPTION){
            boolean flag = cthd_bus.xoaCthd(Integer.parseInt(txtMaHD.getText()));
            if(flag){
                JOptionPane.showMessageDialog(rootPane, "Xóa thành công");
                loadDataLenTable();
            }
        }
    }
    private void xulythemHD(){
        boolean flag=cthd_bus.themCthd(Integer.parseInt(txtMaSP.getText()), Integer.parseInt(txtSoLuong.getText()), Integer.parseInt(txtDonGia.getText()), Integer.parseInt(txtThanhTien.getText()), sdf.format(txtDate.getDate()));
        try{
            cthd_bus.doclistcthd();
            loadDataLenTable();
        } catch(Exception e){}
    }
    private void xulyClickTable() throws ParseException{
        DefaultTableModel dtm = (DefaultTableModel)table.getModel();
        if(table.getSelectedRow()>-1){
            String mahd=table.getValueAt(table.getSelectedRow(), 0)+"";
            String masp=table.getValueAt(table.getSelectedRow(), 1)+"";
            String soluong=table.getValueAt(table.getSelectedRow(), 2)+"";
            String dongia=table.getValueAt(table.getSelectedRow(), 3)+"";
            String thanhtien=table.getValueAt(table.getSelectedRow(), 4)+"";
            String ngaylap = table.getValueAt(table.getSelectedRow(), 5)+"";
            txtMaHD.setText(mahd);
            txtMaSP.setText(masp);
            txtSoLuong.setText(soluong);
            txtDonGia.setText(dongia);
            txtThanhTien.setText(thanhtien);
            txtDate.setDate(sdf.parse(ngaylap));
            label_PDF_MAHD.setText(mahd);
            label_PDF_MASP.setText(masp);
            label_PDF_DONGIA.setText(dongia);
            label_PDF_SOLUONG.setText(soluong);
            label_PDF_THANHTIEN.setText(thanhtien);
            label_PDF_NGAYLAP.setText(ngaylap);
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
    private void loadDataLenTable(){
        DefaultTableModel dtm = (DefaultTableModel)table.getModel();
        cthd_bus.doclistcthd();
        dtm.setRowCount(0);
        ArrayList<CTHD_DTO>dscthd = cthd_bus.getlistcthd();
        for(CTHD_DTO cthd:dscthd){
            Vector vec = new Vector();
            vec.add(cthd.getMahd());
            vec.add(cthd.getMasp());
            vec.add(cthd.getSoluong());
            vec.add(cthd.getDongia());
            vec.add(cthd.getThanhtien());
            vec.add(cthd.getNgaylap());
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
        table = new javax.swing.JTable();
        txtMaHD = new Custom.TextField();
        txtMaSP = new Custom.TextField();
        txtSoLuong = new Custom.TextField();
        txtDonGia = new Custom.TextField();
        txtThanhTien = new Custom.TextField();
        txtDate = new com.toedter.calendar.JDateChooser();
        jLabel1 = new javax.swing.JLabel();
        RB_Them = new javax.swing.JRadioButton();
        RB_Sua = new javax.swing.JRadioButton();
        RB_Xoa = new javax.swing.JRadioButton();
        button1 = new Custom.Button();
        button2 = new Custom.Button();
        jLabel2 = new javax.swing.JLabel();
        Panel_In_PDF = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        label_PDF_MAHD = new javax.swing.JLabel();
        label_PDF_MASP = new javax.swing.JLabel();
        label_PDF_DONGIA = new javax.swing.JLabel();
        label_PDF_SOLUONG = new javax.swing.JLabel();
        label_PDF_THANHTIEN = new javax.swing.JLabel();
        label_PDF_NGAYLAP = new javax.swing.JLabel();
        panel1 = new Custom.Panel();
        jLabel3 = new javax.swing.JLabel();
        txt_TimMaHD = new Custom.TextField();
        txt_TimMaSP = new Custom.TextField();
        btn_Tim = new Custom.Button();
        btnHuyTim = new Custom.Button();
        btn_IN_PDF = new Custom.Button();
        btnTHongKe = new Custom.Button();

        setBackground(new java.awt.Color(255, 255, 255));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 566, Short.MAX_VALUE)
        );

        jScrollPane1.setBackground(new java.awt.Color(255, 255, 255));

        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Mã hóa đơn", "Mã sản phẩm", "Số lượng", "Đơn giá", "Thành tiền", "Ngày lập"
            }
        ));
        table.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(table);

        txtMaHD.setEditable(false);
        txtMaHD.setLabelText("Mã hóa đơn");

        txtMaSP.setLabelText("Mã sản phẩm");
        txtMaSP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtMaSPActionPerformed(evt);
            }
        });
        txtMaSP.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtMaSPKeyReleased(evt);
            }
        });

        txtSoLuong.setLabelText("Số lượng");
        txtSoLuong.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSoLuongActionPerformed(evt);
            }
        });
        txtSoLuong.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtSoLuongKeyReleased(evt);
            }
        });

        txtDonGia.setEditable(false);
        txtDonGia.setLabelText("Đơn giá");

        txtThanhTien.setLabelText("Thành tiền");
        txtThanhTien.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtThanhTienActionPerformed(evt);
            }
        });

        txtDate.setDateFormatString("yyyy-MM-dd");
        txtDate.setMaxSelectableDate(new java.util.Date(253370743276000L));
        txtDate.setMinSelectableDate(new java.util.Date(-62135791124000L));

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel1.setText("Ngày lập");

        buttonGroup1.add(RB_Them);
        RB_Them.setSelected(true);
        RB_Them.setText("THÊM");

        buttonGroup1.add(RB_Sua);
        RB_Sua.setText("SỬA");
        RB_Sua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RB_SuaActionPerformed(evt);
            }
        });

        buttonGroup1.add(RB_Xoa);
        RB_Xoa.setText("XÓA");
        RB_Xoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RB_XoaActionPerformed(evt);
            }
        });

        button1.setText("Hủy");
        button1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button1ActionPerformed(evt);
            }
        });

        button2.setText("OK");
        button2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button2ActionPerformed(evt);
            }
        });

        jLabel2.setBackground(new java.awt.Color(255, 255, 255));
        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setText("CHI TIẾT HÓA ĐƠN");

        Panel_In_PDF.setBackground(new java.awt.Color(255, 255, 255));
        Panel_In_PDF.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel4.setText("CHI TIẾT HÓA ĐƠN");

        jLabel5.setText("MÃ HÓA ĐƠN");

        jLabel6.setText("MÃ SẢN PHẨM");

        jLabel7.setText("ĐƠN GIÁ");

        jLabel8.setText("SỐ LƯỢNG");

        jLabel9.setText("THÀNH TIỀN");

        jLabel10.setText("NGÀY LẬP");

        javax.swing.GroupLayout Panel_In_PDFLayout = new javax.swing.GroupLayout(Panel_In_PDF);
        Panel_In_PDF.setLayout(Panel_In_PDFLayout);
        Panel_In_PDFLayout.setHorizontalGroup(
            Panel_In_PDFLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, Panel_In_PDFLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(Panel_In_PDFLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(Panel_In_PDFLayout.createSequentialGroup()
                        .addGroup(Panel_In_PDFLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addComponent(jLabel7)
                            .addComponent(jLabel8)
                            .addComponent(jLabel9)
                            .addComponent(jLabel10))
                        .addGroup(Panel_In_PDFLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, Panel_In_PDFLayout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 97, Short.MAX_VALUE)
                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(Panel_In_PDFLayout.createSequentialGroup()
                                .addGap(13, 13, 13)
                                .addGroup(Panel_In_PDFLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(label_PDF_NGAYLAP, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(label_PDF_THANHTIEN, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(label_PDF_SOLUONG, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(label_PDF_DONGIA, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(label_PDF_MASP, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                    .addGroup(Panel_In_PDFLayout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addGap(18, 18, 18)
                        .addComponent(label_PDF_MAHD, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(172, 172, 172))
        );
        Panel_In_PDFLayout.setVerticalGroup(
            Panel_In_PDFLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Panel_In_PDFLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(Panel_In_PDFLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(label_PDF_MAHD))
                .addGap(18, 18, 18)
                .addGroup(Panel_In_PDFLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(label_PDF_MASP))
                .addGap(18, 18, 18)
                .addGroup(Panel_In_PDFLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(label_PDF_DONGIA))
                .addGap(18, 18, 18)
                .addGroup(Panel_In_PDFLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(label_PDF_SOLUONG))
                .addGap(18, 18, 18)
                .addGroup(Panel_In_PDFLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(label_PDF_THANHTIEN))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(Panel_In_PDFLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(label_PDF_NGAYLAP))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        panel1.setBackground(new java.awt.Color(153, 255, 255));

        jLabel3.setBackground(new java.awt.Color(255, 255, 255));
        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel3.setText("TÌM KIẾM");

        txt_TimMaHD.setLabelText("Tìm theo mã hóa đơn");

        txt_TimMaSP.setLabelText("Tìm theo mã sản phẩm");

        btn_Tim.setText("Tìm");
        btn_Tim.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_TimActionPerformed(evt);
            }
        });

        btnHuyTim.setText("Hủy");
        btnHuyTim.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHuyTimActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panel1Layout = new javax.swing.GroupLayout(panel1);
        panel1.setLayout(panel1Layout);
        panel1Layout.setHorizontalGroup(
            panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel1Layout.createSequentialGroup()
                .addContainerGap(150, Short.MAX_VALUE)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(129, 129, 129))
            .addGroup(panel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txt_TimMaHD, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txt_TimMaSP, javax.swing.GroupLayout.DEFAULT_SIZE, 236, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btn_Tim, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnHuyTim, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panel1Layout.setVerticalGroup(
            panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_TimMaHD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_Tim, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_TimMaSP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnHuyTim, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(15, Short.MAX_VALUE))
        );

        btn_IN_PDF.setText("IN");
        btn_IN_PDF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_IN_PDFActionPerformed(evt);
            }
        });

        btnTHongKe.setText("BẢNG THỐNG KÊ");
        btnTHongKe.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTHongKeActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1142, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addContainerGap()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(button2, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                    .addComponent(button1, javax.swing.GroupLayout.DEFAULT_SIZE, 73, Short.MAX_VALUE)
                                                    .addComponent(txtMaHD, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                    .addComponent(txtMaSP, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                    .addComponent(txtSoLuong, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                    .addComponent(RB_Them))
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addGroup(layout.createSequentialGroup()
                                                        .addGap(29, 29, 29)
                                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                            .addComponent(txtDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                                .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 75, Short.MAX_VALUE)
                                                                .addComponent(txtThanhTien, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                .addComponent(txtDonGia, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                                                    .addGroup(layout.createSequentialGroup()
                                                        .addGap(18, 18, 18)
                                                        .addComponent(RB_Sua)
                                                        .addGap(18, 18, 18)
                                                        .addComponent(RB_Xoa)))))
                                        .addGap(19, 19, 19)
                                        .addComponent(panel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(354, 354, 354)
                                        .addComponent(jLabel2)))
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(btnTHongKe, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btn_IN_PDF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addComponent(Panel_In_PDF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(31, 31, 31)))
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(Panel_In_PDF, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txtMaHD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtDonGia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txtMaSP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtThanhTien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtSoLuong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(panel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(RB_Them)
                            .addComponent(RB_Sua)
                            .addComponent(RB_Xoa))
                        .addGap(29, 29, 29)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(button1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(button2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 45, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btn_IN_PDF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnTHongKe, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(21, 21, 21)))
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void RB_SuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RB_SuaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_RB_SuaActionPerformed

    private void RB_XoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RB_XoaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_RB_XoaActionPerformed

    private void tableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableMouseClicked
        try {
            // TODO add your handling code here:
            xulyClickTable();
        } catch (ParseException ex) {
            Logger.getLogger(CTHD_GUI.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_tableMouseClicked

    private void txtMaSPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtMaSPActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_txtMaSPActionPerformed

    private void txtMaSPKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtMaSPKeyReleased
        // TODO add your handling code here:
        String masp=txtMaSP.getText();
        try {
            txtDonGia.setText(String.valueOf(cthd_dao.getDonGiaTuMaSP(Integer.parseInt(masp))));
        } catch (SQLException ex) {
            Logger.getLogger(CTHD_GUI.class.getName()).log(Level.SEVERE, null, ex);
        }
        int dongia=Integer.parseInt(txtDonGia.getText());
        int soluong=Integer.parseInt(txtSoLuong.getText());
        txtThanhTien.setText(String.valueOf(dongia*soluong));
    }//GEN-LAST:event_txtMaSPKeyReleased

    private void txtThanhTienActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtThanhTienActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_txtThanhTienActionPerformed

    private void txtSoLuongActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSoLuongActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_txtSoLuongActionPerformed

    private void txtSoLuongKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSoLuongKeyReleased
        // TODO add your handling code here:
        int dongia=Integer.parseInt(txtDonGia.getText());
        int soluong=Integer.parseInt(txtSoLuong.getText());
        txtThanhTien.setText(String.valueOf(dongia*soluong));
    }//GEN-LAST:event_txtSoLuongKeyReleased

    private void button1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button1ActionPerformed
        // TODO add your handling code here:
        txtMaHD.setText("");
        txtMaSP.setText("");
        txtSoLuong.setText("");
        txtDonGia.setText("");
        txtThanhTien.setText("");
        txtDate.setDate(null);
    }//GEN-LAST:event_button1ActionPerformed

    private void button2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button2ActionPerformed
        // TODO add your handling code here:
        if(validateForm()){
            if(RB_Them.isSelected())
                xulythemHD();
            else if(RB_Sua.isSelected())
                xulySuaHD();
            else
                xulyXoaHD();
        }
            
    }//GEN-LAST:event_button2ActionPerformed

    private void btnHuyTimActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHuyTimActionPerformed
        // TODO add your handling code here:
        txt_TimMaSP.setText("");
        txt_TimMaHD.setText("");
        loadDataLenTable();
    }//GEN-LAST:event_btnHuyTimActionPerformed

    private void btn_TimActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_TimActionPerformed
        // TODO add your handling code here:
        if(txt_TimMaSP.getText().isEmpty()&&txt_TimMaHD.getText().isEmpty())
            JOptionPane.showMessageDialog(rootPane, "Bạn hãy nhập gì rồi mới tìm kiếm được");
        else if(!txt_TimMaSP.getText().isEmpty()&&txt_TimMaHD.getText().isEmpty())
            timTheoMasp();
        else
            timTheoMahd();
    }//GEN-LAST:event_btn_TimActionPerformed

    private void btn_IN_PDFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_IN_PDFActionPerformed
        // TODO add your handling code here:
        InPDF_Jpanel(Panel_In_PDF);
    }//GEN-LAST:event_btn_IN_PDFActionPerformed

    private void btnTHongKeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTHongKeActionPerformed
        try {
            // TODO add your handling code here:
            myconnect=new MyConnect();
            Connection con = myconnect.getCon();
            String sql="SELECT NGAYLAP,THANHTIEN FROM CTHOADON";
            JDBCCategoryDataset dataset=new JDBCCategoryDataset(con,sql);
            JFreeChart chart =ChartFactory.createBarChart("Thống kê chi tiết hóa đơn", "Ngày lập", "Số tiền thu được", dataset,PlotOrientation.VERTICAL,false,true,true);
            BarRenderer renderer=null;
            CategoryPlot plot=null;
            renderer=new BarRenderer();
            ChartFrame frame=new ChartFrame("Thống kê", chart);
            frame.setVisible(true);
            frame.setSize(800,600);
        } catch (SQLException ex) {
            Logger.getLogger(CTHD_GUI.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_btnTHongKeActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Panel_In_PDF;
    private javax.swing.JRadioButton RB_Sua;
    private javax.swing.JRadioButton RB_Them;
    private javax.swing.JRadioButton RB_Xoa;
    private Custom.Button btnHuyTim;
    private Custom.Button btnTHongKe;
    private Custom.Button btn_IN_PDF;
    private Custom.Button btn_Tim;
    private Custom.Button button1;
    private Custom.Button button2;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel label_PDF_DONGIA;
    private javax.swing.JLabel label_PDF_MAHD;
    private javax.swing.JLabel label_PDF_MASP;
    private javax.swing.JLabel label_PDF_NGAYLAP;
    private javax.swing.JLabel label_PDF_SOLUONG;
    private javax.swing.JLabel label_PDF_THANHTIEN;
    private Custom.Panel panel1;
    private javax.swing.JTable table;
    private com.toedter.calendar.JDateChooser txtDate;
    private Custom.TextField txtDonGia;
    private Custom.TextField txtMaHD;
    private Custom.TextField txtMaSP;
    private Custom.TextField txtSoLuong;
    private Custom.TextField txtThanhTien;
    private Custom.TextField txt_TimMaHD;
    private Custom.TextField txt_TimMaSP;
    // End of variables declaration//GEN-END:variables
}
