/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package GUI;

import BUS.SANPHAM_BUS;
import java.awt.event.KeyEvent;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Vector;
import DTO.SANPHAM_DTO;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.plaf.basic.BasicInternalFrameUI;
import javax.swing.table.DefaultTableModel;



/**
 *
 * @author DELL
 */
public class SANPHAM_GUI extends javax.swing.JInternalFrame {
    SANPHAM_BUS SP_BUS = new SANPHAM_BUS();

    /**
     * Creates new form SANPHAM_GUI
     */
    public SANPHAM_GUI() throws ClassNotFoundException, SQLException {
        initComponents();
        BasicInternalFrameUI BI = (BasicInternalFrameUI)this.getUI();
        BI.setNorthPane(null);
        RB_Them.setSelected(true);
        Panel_advance_searching.setVisible(false);
        loadDataLenBangSanPham();
    }
    private void timKiemGiaTheoKhoang(){
        String gia_min=txt_Minium_Gia.getText();
        String gia_max=txt_Maximum_gia.getText();
        DefaultTableModel dtm = (DefaultTableModel)jtable.getModel();
        dtm.setRowCount(0);
        ArrayList<SANPHAM_DTO> dssp_timKiem=null;
        dssp_timKiem=SP_BUS.getSanPhamTheoKhoangGia(gia_min, gia_max);
        for(SANPHAM_DTO sp : dssp_timKiem){
            Vector vec = new Vector();
                vec.add(sp.getMASP());
                vec.add(sp.getTENSP());
                vec.add(sp.getGIA());
                vec.add(sp.getSIZE());
                vec.add(sp.getSOLUONG());
                dtm.addRow(vec);
        }
    }
    private void timKiemGiaThapNhat(){
        String gia=txt_Minium_Gia.getText();
        DefaultTableModel dtm = (DefaultTableModel)jtable.getModel();
        dtm.setRowCount(0);
        ArrayList<SANPHAM_DTO> dssp_timKiem=null;
        dssp_timKiem=SP_BUS.getSanPhamTheoGiaMinimum(gia);
        for(SANPHAM_DTO sp : dssp_timKiem){
                Vector vec = new Vector();
                vec.add(sp.getMASP());
                vec.add(sp.getTENSP());
                vec.add(sp.getGIA());
                vec.add(sp.getSIZE());
                vec.add(sp.getSOLUONG());
                dtm.addRow(vec);
        }
    }
    private void timKiemTheoMa() throws ClassNotFoundException, SQLException{
        if(txt_TimKiemTheoMa.getText().isEmpty())
            loadDataLenBangSanPham();
        else{
            String ma = txt_TimKiemTheoMa.getText();
            DefaultTableModel dtm = (DefaultTableModel)jtable.getModel();
            dtm.setRowCount(0);
            ArrayList<SANPHAM_DTO> dssp_timKiem=null;
            dssp_timKiem=SP_BUS.getSanPhamTheoMa(ma);
            for(SANPHAM_DTO sp : dssp_timKiem){
                Vector vec = new Vector();
                vec.add(sp.getMASP());
                vec.add(sp.getTENSP());
                vec.add(sp.getGIA());
                vec.add(sp.getSIZE());
                vec.add(sp.getSOLUONG());
                dtm.addRow(vec);
            }
        }
        
        
    }
    private void xulySuaSanPham() throws ClassNotFoundException, SQLException{
        boolean flag = SP_BUS.suaSanPham(txtMaSP.getText(), txtTenSP.getText(), txtDonGia.getText(), txtSize.getText(), txtSoLuong.getText());
        SP_BUS.docListSP();
        if(flag)
            JOptionPane.showMessageDialog(rootPane, "Sửa thành công");
        else
            JOptionPane.showMessageDialog(rootPane, "Sửa thất bại");
        loadDataLenBangSanPham();
    }
    private void xulyXoaSP() throws ClassNotFoundException, SQLException{
        int response= JOptionPane.showConfirmDialog(rootPane, "Bạn có chắc chắn muốn xóa ?","Confirm",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
        if(response==JOptionPane.YES_OPTION){
            boolean flag = SP_BUS.xoaSanPham(txtMaSP.getText());
            if(flag){
                JOptionPane.showMessageDialog(rootPane, "Xóa thành công");
                loadDataLenBangSanPham();
            }
        }
    }
    private void xulyThemSP(){
        boolean flag = SP_BUS.themSanPham(txtTenSP.getText(), txtDonGia.getText(), txtSize.getText(), txtSoLuong.getText());
                try {
                    SP_BUS.docListSP();
                    loadDataLenBangSanPham();
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(SANPHAM_GUI.class.getName()).log(Level.SEVERE, null, ex);
                } catch (SQLException ex) {
                    Logger.getLogger(SANPHAM_GUI.class.getName()).log(Level.SEVERE, null, ex);
                }
    }
    private void timKiem_SoLuong(){
        DefaultTableModel dtm = (DefaultTableModel)jtable.getModel();
        dtm.setRowCount(0);
        ArrayList<SANPHAM_DTO> dssp = null;
        dssp=SP_BUS.getSoLuong(txt_LocTheoSoLuong.getText());
        for(SANPHAM_DTO sp: dssp){
            Vector vec = new Vector();
            vec.add(sp.getMASP());
            vec.add(sp.getTENSP());
            vec.add(sp.getGIA());
            vec.add(sp.getSIZE());
            vec.add(sp.getSOLUONG());
            dtm.addRow(vec);
        }
    }
    private void timKiem_SoLuong_TENSP(){
        DefaultTableModel dtm = (DefaultTableModel)jtable.getModel();
        dtm.setRowCount(0);
        ArrayList<SANPHAM_DTO> dssp = null;
        dssp=SP_BUS.getSoLuong_TENSP(txtTimKiem.getText(), txt_LocTheoSoLuong.getText());
        for(SANPHAM_DTO sp: dssp){
            Vector vec = new Vector();
            vec.add(sp.getMASP());
            vec.add(sp.getTENSP());
            vec.add(sp.getGIA());
            vec.add(sp.getSIZE());
            vec.add(sp.getSOLUONG());
            dtm.addRow(vec);
        }
    }
    private void timKiem_SIZE_TENSP(){
        String size=txt_LocTheoSize.getText();
        String ten=txtTimKiem.getText().toLowerCase();
        DefaultTableModel dtm = (DefaultTableModel)jtable.getModel();
        dtm.setRowCount(0);
        ArrayList<SANPHAM_DTO> dssp = null;
        dssp=SP_BUS.getTENSP_SIZE(size, ten);
        for(SANPHAM_DTO sp: dssp){
            Vector vec = new Vector();
            vec.add(sp.getMASP());
            vec.add(sp.getTENSP());
            vec.add(sp.getGIA());
            vec.add(sp.getSIZE());
            vec.add(sp.getSOLUONG());
            dtm.addRow(vec);
        }
    }
    private void xulyTimKiem(){
        String ten = txtTimKiem.getText().toLowerCase();
        DefaultTableModel dtm = (DefaultTableModel)jtable.getModel();
        dtm.setRowCount(0);
        ArrayList<SANPHAM_DTO> dssp = null;
        dssp=SP_BUS.getSanPhamTheoTen(ten);
        for(SANPHAM_DTO sp: dssp){
            Vector vec = new Vector();
            vec.add(sp.getMASP());
            vec.add(sp.getTENSP());
            vec.add(sp.getGIA());
            vec.add(sp.getSIZE());
            vec.add(sp.getSOLUONG());
            dtm.addRow(vec);
        }
        JOptionPane.showMessageDialog(rootPane, "Số lượng kết quả tìm thấy: "+dssp.size());
    }
    private void xuLyClickTblSanPham() {
        DefaultTableModel dtm =(DefaultTableModel)jtable.getModel();
        if(jtable.getSelectedRow()>-1){
            String ma = dtm.getValueAt(jtable.getSelectedRow(), 0) + "";
            String ten = jtable.getValueAt(jtable.getSelectedRow(), 1) + "";
            String donGia = jtable.getValueAt(jtable.getSelectedRow(), 2) + "";
            String size = jtable.getValueAt(jtable.getSelectedRow(), 3) + "";
            String soLuong = jtable.getValueAt(jtable.getSelectedRow(), 4) + "";

            txtMaSP.setText(ma);
            txtTenSP.setText(ten);
            txtDonGia.setText(donGia);
            txtSoLuong.setText(soLuong);
            txtSize.setText(size);
        }
            
        
    }
    private void loadDataLenBangSanPham() throws ClassNotFoundException, SQLException {
        DefaultTableModel dtm = (DefaultTableModel)jtable.getModel();
        SP_BUS.docListSP();
        dtm.setRowCount(0);

        ArrayList<SANPHAM_DTO> dssp = SP_BUS.getListSanPham();


        for (SANPHAM_DTO sp : dssp) {
            Vector vec = new Vector();
            vec.add(sp.getMASP());
            vec.add(sp.getTENSP());
            vec.add(sp.getGIA());
            vec.add(sp.getSIZE());
            vec.add(sp.getSOLUONG());
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
        jLabel1 = new javax.swing.JLabel();
        txtMaSP = new Custom.TextField();
        txtTenSP = new Custom.TextField();
        txtSize = new Custom.TextField();
        txtDonGia = new Custom.TextField();
        txtSoLuong = new Custom.TextField();
        RB_Them = new javax.swing.JRadioButton();
        RB_Sua = new javax.swing.JRadioButton();
        RB_Xoa = new javax.swing.JRadioButton();
        jLabel3 = new javax.swing.JLabel();
        btnOK = new Custom.Button();
        btnHuy = new Custom.Button();
        panel1 = new Custom.Panel();
        txtTimKiem = new Custom.TextField();
        btnTimKiem = new Custom.Button();
        btnTroLai_TimKiem = new Custom.Button();
        btn_show_advance_searching = new javax.swing.JLabel();
        Panel_advance_searching = new javax.swing.JPanel();
        label_exit_advance_searching = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txt_TimKiemTheoMa = new javax.swing.JTextField();
        txt_Minium_Gia = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        txt_Maximum_gia = new javax.swing.JTextField();
        txt_LocTheoSize = new javax.swing.JTextField();
        txt_LocTheoSoLuong = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jtable = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));
        setBorder(null);
        setOpaque(true);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("THÔNG TIN SẢN PHẨM");
        jLabel1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jLabel1.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);

        txtMaSP.setEditable(false);
        txtMaSP.setBackground(new java.awt.Color(255, 255, 255));
        txtMaSP.setLabelText("Mã sản phẩm");

        txtTenSP.setLabelText("Tên sản phẩm");

        txtSize.setLabelText("Size (S, M, L)");
        txtSize.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtSizeKeyTyped(evt);
            }
        });

        txtDonGia.setLabelText("Đơn giá");
        txtDonGia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDonGiaActionPerformed(evt);
            }
        });
        txtDonGia.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtDonGiaKeyTyped(evt);
            }
        });

        txtSoLuong.setLabelText("Số lượng");
        txtSoLuong.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtSoLuongKeyTyped(evt);
            }
        });

        buttonGroup1.add(RB_Them);
        RB_Them.setText("Thêm");
        RB_Them.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RB_ThemActionPerformed(evt);
            }
        });

        buttonGroup1.add(RB_Sua);
        RB_Sua.setText("Sửa");

        buttonGroup1.add(RB_Xoa);
        RB_Xoa.setText("Xóa");

        jLabel3.setText("đ");

        btnOK.setLabel("OK");
        btnOK.setRadius(16);
        btnOK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOKActionPerformed(evt);
            }
        });

        btnHuy.setLabel("Hủy");
        btnHuy.setRadius(16);
        btnHuy.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHuyActionPerformed(evt);
            }
        });

        panel1.setBackground(new java.awt.Color(51, 153, 255));
        panel1.setRoundBottomRight(100);
        panel1.setRoundTopLeft(100);

        txtTimKiem.setLabelText("TÌM KIẾM THEO TÊN");

        btnTimKiem.setLabel("Tìm kiếm");
        btnTimKiem.setRadius(16);
        btnTimKiem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTimKiemActionPerformed(evt);
            }
        });

        btnTroLai_TimKiem.setText("TRỞ LẠI");
        btnTroLai_TimKiem.setRadius(16);
        btnTroLai_TimKiem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTroLai_TimKiemActionPerformed(evt);
            }
        });

        btn_show_advance_searching.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/icons8_search_in_list_24px.png"))); // NOI18N
        btn_show_advance_searching.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_show_advance_searchingMouseClicked(evt);
            }
        });
        btn_show_advance_searching.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                btn_show_advance_searchingKeyPressed(evt);
            }
        });

        javax.swing.GroupLayout panel1Layout = new javax.swing.GroupLayout(panel1);
        panel1.setLayout(panel1Layout);
        panel1Layout.setHorizontalGroup(
            panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtTimKiem, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(panel1Layout.createSequentialGroup()
                        .addComponent(btnTroLai_TimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 38, Short.MAX_VALUE)
                        .addComponent(btnTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_show_advance_searching)))
                .addContainerGap())
        );
        panel1Layout.setVerticalGroup(
            panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel1Layout.createSequentialGroup()
                .addContainerGap(18, Short.MAX_VALUE)
                .addComponent(txtTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnTroLai_TimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btn_show_advance_searching, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(17, 17, 17))
        );

        Panel_advance_searching.setBackground(new java.awt.Color(255, 255, 255));
        Panel_advance_searching.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));

        label_exit_advance_searching.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        label_exit_advance_searching.setText("X");
        label_exit_advance_searching.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                label_exit_advance_searchingMouseClicked(evt);
            }
        });

        jLabel4.setText("Lọc theo mã :");

        jLabel5.setText("Lọc theo giá");

        jLabel6.setText("Lọc theo Size");

        jLabel7.setText("Lọc theo số lượng");

        txt_TimKiemTheoMa.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_TimKiemTheoMaKeyTyped(evt);
            }
        });

        jLabel8.setText("-");

        javax.swing.GroupLayout Panel_advance_searchingLayout = new javax.swing.GroupLayout(Panel_advance_searching);
        Panel_advance_searching.setLayout(Panel_advance_searchingLayout);
        Panel_advance_searchingLayout.setHorizontalGroup(
            Panel_advance_searchingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Panel_advance_searchingLayout.createSequentialGroup()
                .addGroup(Panel_advance_searchingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(Panel_advance_searchingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, Panel_advance_searchingLayout.createSequentialGroup()
                            .addComponent(jLabel6)
                            .addGap(43, 43, 43)
                            .addComponent(txt_LocTheoSize))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, Panel_advance_searchingLayout.createSequentialGroup()
                            .addComponent(jLabel4)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txt_TimKiemTheoMa, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, Panel_advance_searchingLayout.createSequentialGroup()
                            .addComponent(jLabel5)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(txt_Minium_Gia, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jLabel8)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(txt_Maximum_gia, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(Panel_advance_searchingLayout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addGap(18, 18, 18)
                        .addComponent(txt_LocTheoSoLuong, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(168, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, Panel_advance_searchingLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(label_exit_advance_searching))
        );
        Panel_advance_searchingLayout.setVerticalGroup(
            Panel_advance_searchingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Panel_advance_searchingLayout.createSequentialGroup()
                .addComponent(label_exit_advance_searching, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(Panel_advance_searchingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txt_TimKiemTheoMa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(Panel_advance_searchingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txt_Minium_Gia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8)
                    .addComponent(txt_Maximum_gia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(Panel_advance_searchingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txt_LocTheoSize, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(Panel_advance_searchingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(txt_LocTheoSoLuong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtMaSP, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTenSP, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtSize, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnOK, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnHuy, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtSoLuong, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtDonGia, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(5, 5, 5)
                        .addComponent(jLabel3)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(RB_Them)
                            .addComponent(RB_Sua)
                            .addComponent(RB_Xoa))
                        .addGap(18, 18, 18)
                        .addComponent(panel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(101, 101, 101)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 348, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Panel_advance_searching, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(23, 23, 23))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(57, 57, 57)
                        .addComponent(panel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 15, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                        .addComponent(txtMaSP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(112, 112, 112))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                        .addComponent(txtTenSP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(57, 57, 57))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(jLabel3)
                                            .addComponent(txtDonGia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(txtSoLuong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                                .addGap(66, 66, 66)
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                    .addComponent(txtSize, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(btnOK, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(btnHuy, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(RB_Them)
                                    .addGap(18, 18, 18)
                                    .addComponent(RB_Sua)
                                    .addGap(18, 18, 18)
                                    .addComponent(RB_Xoa)
                                    .addGap(64, 64, 64)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(Panel_advance_searching, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(25, 25, 25))))))
        );

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jScrollPane2.setBackground(new java.awt.Color(255, 255, 255));
        jScrollPane2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jScrollPane2MouseClicked(evt);
            }
        });

        jtable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã sản phẩm", "Tên sản phẩm", "Giá", "Size", "Số lượng"
            }
        ));
        jtable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtableMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jtable);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 1154, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 344, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jLabel2.setBackground(new java.awt.Color(255, 255, 255));
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/coffee_background.jpg"))); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel2)
                .addGap(0, 0, 0)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(60, 60, 60)
                        .addComponent(jLabel2)))
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void RB_ThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RB_ThemActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_RB_ThemActionPerformed

    private void txtSizeKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSizeKeyTyped
        // TODO add your handling code here:
        char c = evt.getKeyChar();
        if(!((c==KeyEvent.VK_L)||(c==KeyEvent.VK_S)||(c==KeyEvent.VK_M)||((c==KeyEvent.VK_BACK_SPACE)||c==KeyEvent.VK_DELETE)))
            evt.consume();
    }//GEN-LAST:event_txtSizeKeyTyped

    private void txtDonGiaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDonGiaKeyTyped
        // TODO add your handling code here:
        char c = evt.getKeyChar();
        if(!((Character.isDigit(c))||(c==KeyEvent.VK_BACK_SPACE)||c==KeyEvent.VK_DELETE))
            evt.consume();
    }//GEN-LAST:event_txtDonGiaKeyTyped

    private void txtSoLuongKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSoLuongKeyTyped
        // TODO add your handling code here:
        char c = evt.getKeyChar();
        if(!((Character.isDigit(c))||(c==KeyEvent.VK_BACK_SPACE)||c==KeyEvent.VK_DELETE))
            evt.consume();
    }//GEN-LAST:event_txtSoLuongKeyTyped
    public boolean validateForm(){
        if(txtTenSP.getText().isEmpty()||txtDonGia.getText().isEmpty()||txtSize.getText().isEmpty()||txtSoLuong.getText().isEmpty())
            JOptionPane.showMessageDialog(this, "Nhập thiếu thông tin, vui lòng nhập lại");
        return true;
    }
    private void btnOKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOKActionPerformed
        // TODO add your handling code here:
        if(validateForm()){
            if(RB_Them.isSelected()){
                xulyThemSP();
            }
            else if(RB_Xoa.isSelected())
                try {
                    xulyXoaSP();
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(SANPHAM_GUI.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                Logger.getLogger(SANPHAM_GUI.class.getName()).log(Level.SEVERE, null, ex);
            }
            else 
                try {
                    xulySuaSanPham();
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(SANPHAM_GUI.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                Logger.getLogger(SANPHAM_GUI.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
         
    }//GEN-LAST:event_btnOKActionPerformed

    private void btnHuyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHuyActionPerformed
        // TODO add your handling code here:
        txtTenSP.setText("");
        txtSoLuong.setText("");
        txtDonGia.setText("");
        txtSize.setText("");
    }//GEN-LAST:event_btnHuyActionPerformed

    private void jScrollPane2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jScrollPane2MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jScrollPane2MouseClicked

    private void jtableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtableMouseClicked
        // TODO add your handling code here:
        xuLyClickTblSanPham();

    }//GEN-LAST:event_jtableMouseClicked

    private void btnTimKiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTimKiemActionPerformed
        // TODO add your handling code here:
       
        if(!txt_TimKiemTheoMa.getText().isEmpty())
            try {
                timKiemTheoMa();
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(SANPHAM_GUI.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                Logger.getLogger(SANPHAM_GUI.class.getName()).log(Level.SEVERE, null, ex);
            }
        else if(!txt_Minium_Gia.getText().isEmpty()&&txt_Maximum_gia.getText().isEmpty())
            timKiemGiaThapNhat();
        else if(txt_Minium_Gia.getText().isEmpty()&&!txt_Maximum_gia.getText().isEmpty())
            JOptionPane.showMessageDialog(rootPane, "Chỉ có thể nhập giá cần tìm ở ô bên trái, hoặc nhập cả 2 ô");
        else if(!txt_Minium_Gia.getText().isEmpty()&&!txt_Maximum_gia.getText().isEmpty())
            timKiemGiaTheoKhoang();
        else if(!txtTimKiem.getText().isEmpty()&&!txt_LocTheoSize.getText().isEmpty())
            timKiem_SIZE_TENSP();
        else if (!txtTimKiem.getText().isEmpty()&&!txt_LocTheoSoLuong.getText().isEmpty())
            timKiem_SoLuong_TENSP();
        else if(!txtTimKiem.getText().isEmpty())
            xulyTimKiem();
        else if (!txt_LocTheoSoLuong.getText().isEmpty())
            timKiem_SoLuong();
    }//GEN-LAST:event_btnTimKiemActionPerformed

    private void btnTroLai_TimKiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTroLai_TimKiemActionPerformed
        // TODO add your handling code here:
        DefaultTableModel dtm = (DefaultTableModel)jtable.getModel();
        dtm.setRowCount(0);
        txtTimKiem.setText("");
        try {
            loadDataLenBangSanPham();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(SANPHAM_GUI.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(SANPHAM_GUI.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnTroLai_TimKiemActionPerformed

    private void btn_show_advance_searchingKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btn_show_advance_searchingKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_show_advance_searchingKeyPressed

    private void btn_show_advance_searchingMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_show_advance_searchingMouseClicked
        // TODO add your handling code here:
        Panel_advance_searching.setVisible(true);

    }//GEN-LAST:event_btn_show_advance_searchingMouseClicked

    private void label_exit_advance_searchingMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_label_exit_advance_searchingMouseClicked
        // TODO add your handling code here:
        Panel_advance_searching.setVisible(false);
    }//GEN-LAST:event_label_exit_advance_searchingMouseClicked

    private void txt_TimKiemTheoMaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_TimKiemTheoMaKeyTyped
        // TODO add your handling code here:
        char c = evt.getKeyChar();
        if(!((Character.isDigit(c))||(c==KeyEvent.VK_BACK_SPACE)||c==KeyEvent.VK_DELETE))
            evt.consume();
    }//GEN-LAST:event_txt_TimKiemTheoMaKeyTyped

    private void txtDonGiaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDonGiaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDonGiaActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Panel_advance_searching;
    private javax.swing.JRadioButton RB_Sua;
    private javax.swing.JRadioButton RB_Them;
    private javax.swing.JRadioButton RB_Xoa;
    private Custom.Button btnHuy;
    private Custom.Button btnOK;
    private Custom.Button btnTimKiem;
    private Custom.Button btnTroLai_TimKiem;
    private javax.swing.JLabel btn_show_advance_searching;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jtable;
    private javax.swing.JLabel label_exit_advance_searching;
    private Custom.Panel panel1;
    private Custom.TextField txtDonGia;
    private Custom.TextField txtMaSP;
    private Custom.TextField txtSize;
    private Custom.TextField txtSoLuong;
    private Custom.TextField txtTenSP;
    private Custom.TextField txtTimKiem;
    private javax.swing.JTextField txt_LocTheoSize;
    private javax.swing.JTextField txt_LocTheoSoLuong;
    private javax.swing.JTextField txt_Maximum_gia;
    private javax.swing.JTextField txt_Minium_Gia;
    private javax.swing.JTextField txt_TimKiemTheoMa;
    // End of variables declaration//GEN-END:variables
}
