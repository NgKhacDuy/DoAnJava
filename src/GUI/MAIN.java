/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package GUI;

import java.awt.Color;
import java.awt.MouseInfo;
import java.sql.SQLException;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author DELL
 */
public class MAIN extends javax.swing.JFrame {
    int x,y;
    /**
     * Creates new form MAIN
     */
    public MAIN() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        PopupMenu = new javax.swing.JPopupMenu();
        MenuItem = new javax.swing.JMenuItem();
        PopupMenu2 = new javax.swing.JPopupMenu();
        MenuItem2 = new javax.swing.JMenuItem();
        PopupMenu3 = new javax.swing.JPopupMenu();
        MenuItem3 = new javax.swing.JMenuItem();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        btnSanPham = new javax.swing.JButton();
        btnHoaDon = new javax.swing.JButton();
        btnThongKe = new javax.swing.JButton();
        btnQLNV = new javax.swing.JButton();
        btnKhuyenMai = new javax.swing.JButton();
        btnGopY = new javax.swing.JButton();
        btnNCC = new javax.swing.JButton();
        SanPhamMore = new javax.swing.JLabel();
        NhanVienMore = new javax.swing.JLabel();
        HoaDonMore = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        label_header = new javax.swing.JPanel();
        label_exit_app = new javax.swing.JLabel();
        DesktopPane = new javax.swing.JDesktopPane();

        MenuItem.setText("LOẠI SẢN PHẨM");
        MenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MenuItemActionPerformed(evt);
            }
        });
        PopupMenu.add(MenuItem);

        MenuItem2.setText("Khách hàng");
        MenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MenuItem2ActionPerformed(evt);
            }
        });
        PopupMenu2.add(MenuItem2);

        MenuItem3.setText("Chi tiết hóa đơn");
        MenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MenuItem3ActionPerformed(evt);
            }
        });
        PopupMenu3.add(MenuItem3);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jPanel2.setBackground(new java.awt.Color(153, 102, 0));

        btnSanPham.setBackground(new java.awt.Color(255, 255, 255));
        btnSanPham.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/icons8_coffee_to_go_36px.png"))); // NOI18N
        btnSanPham.setText("SẢN PHẨM");
        btnSanPham.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnSanPham.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        btnSanPham.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnSanPham.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnSanPhamMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnSanPhamMouseExited(evt);
            }
        });
        btnSanPham.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSanPhamActionPerformed(evt);
            }
        });

        btnHoaDon.setBackground(new java.awt.Color(255, 255, 255));
        btnHoaDon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/icons8_bill_36px_1.png"))); // NOI18N
        btnHoaDon.setText("HÓA ĐƠN");
        btnHoaDon.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnHoaDon.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnHoaDon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHoaDonActionPerformed(evt);
            }
        });

        btnThongKe.setBackground(new java.awt.Color(255, 255, 255));
        btnThongKe.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/icons8_combo_chart_36px.png"))); // NOI18N
        btnThongKe.setText("THỐNG KÊ");
        btnThongKe.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnThongKe.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);

        btnQLNV.setBackground(new java.awt.Color(255, 255, 255));
        btnQLNV.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/icons8_employee_36px_1.png"))); // NOI18N
        btnQLNV.setText("NHÂN VIÊN");
        btnQLNV.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnQLNV.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnQLNV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnQLNVActionPerformed(evt);
            }
        });

        btnKhuyenMai.setBackground(new java.awt.Color(255, 255, 255));
        btnKhuyenMai.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/icons8_lease_36px.png"))); // NOI18N
        btnKhuyenMai.setText("KHUYẾN MÃI");
        btnKhuyenMai.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnKhuyenMai.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnKhuyenMai.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnKhuyenMaiActionPerformed(evt);
            }
        });

        btnGopY.setBackground(new java.awt.Color(255, 255, 255));
        btnGopY.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/icons8_feedback_36px_1.png"))); // NOI18N
        btnGopY.setText("GÓP Ý");
        btnGopY.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnGopY.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnGopY.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGopYActionPerformed(evt);
            }
        });

        btnNCC.setBackground(new java.awt.Color(255, 255, 255));
        btnNCC.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/icons8_supplier_36px.png"))); // NOI18N
        btnNCC.setText("NHÀ CUNG CẤP");
        btnNCC.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnNCC.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnNCC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNCCActionPerformed(evt);
            }
        });

        SanPhamMore.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/icons8_more_than_16px_1.png"))); // NOI18N
        SanPhamMore.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                SanPhamMoreMouseClicked(evt);
            }
        });

        NhanVienMore.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/icons8_more_than_16px_1.png"))); // NOI18N
        NhanVienMore.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                NhanVienMoreMouseClicked(evt);
            }
        });

        HoaDonMore.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/icons8_more_than_16px_1.png"))); // NOI18N
        HoaDonMore.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                HoaDonMoreMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnThongKe, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btnKhuyenMai, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btnGopY, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btnNCC, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(btnQLNV)
                .addGap(1, 1, 1)
                .addComponent(NhanVienMore, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(btnHoaDon, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnSanPham, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(SanPhamMore, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(HoaDonMore, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnSanPham, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(SanPhamMore, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnHoaDon, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(HoaDonMore, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(btnThongKe)
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnQLNV)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addComponent(NhanVienMore, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(btnKhuyenMai)
                .addGap(18, 18, 18)
                .addComponent(btnNCC)
                .addGap(18, 18, 18)
                .addComponent(btnGopY)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);

        label_header.setBackground(new java.awt.Color(153, 102, 0));
        label_header.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                label_headerMouseDragged(evt);
            }
        });
        label_header.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                label_headerMousePressed(evt);
            }
        });

        label_exit_app.setBackground(new java.awt.Color(153, 102, 0));
        label_exit_app.setForeground(new java.awt.Color(255, 255, 255));
        label_exit_app.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/icons8_Close_16px.png"))); // NOI18N
        label_exit_app.setOpaque(true);
        label_exit_app.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                label_exit_appMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                label_exit_appMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                label_exit_appMouseExited(evt);
            }
        });

        javax.swing.GroupLayout label_headerLayout = new javax.swing.GroupLayout(label_header);
        label_header.setLayout(label_headerLayout);
        label_headerLayout.setHorizontalGroup(
            label_headerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, label_headerLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(label_exit_app))
        );
        label_headerLayout.setVerticalGroup(
            label_headerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(label_exit_app, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 27, Short.MAX_VALUE)
        );

        DesktopPane.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout DesktopPaneLayout = new javax.swing.GroupLayout(DesktopPane);
        DesktopPane.setLayout(DesktopPaneLayout);
        DesktopPaneLayout.setHorizontalGroup(
            DesktopPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1146, Short.MAX_VALUE)
        );
        DesktopPaneLayout.setVerticalGroup(
            DesktopPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 595, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 2, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(DesktopPane, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addComponent(label_header, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addComponent(label_header, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator1)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(DesktopPane, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
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
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void label_exit_appMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_label_exit_appMouseEntered
        // TODO add your handling code here:
        label_exit_app.setBackground(Color.red);
        label_exit_app.setForeground(Color.BLACK);
    }//GEN-LAST:event_label_exit_appMouseEntered

    private void label_exit_appMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_label_exit_appMouseExited
        // TODO add your handling code here:
        label_exit_app.setBackground(Color.GRAY);
    }//GEN-LAST:event_label_exit_appMouseExited

    private void label_exit_appMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_label_exit_appMouseClicked
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_label_exit_appMouseClicked

    private void label_headerMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_label_headerMousePressed
        // TODO add your handling code here:
        x=evt.getX();
        y=evt.getY();
    }//GEN-LAST:event_label_headerMousePressed

    private void label_headerMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_label_headerMouseDragged
        // TODO add your handling code here:
        int xx=evt.getXOnScreen();
        int yy=evt.getYOnScreen();
        this.setLocation(xx-x, yy-y);
    }//GEN-LAST:event_label_headerMouseDragged

    private void btnSanPhamActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSanPhamActionPerformed
        // TODO add your handling code here:
        DesktopPane.removeAll();
        try {
            DesktopPane.add(new SANPHAM_GUI()).setVisible(true);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(MAIN.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(MAIN.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnSanPhamActionPerformed

    private void btnKhuyenMaiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnKhuyenMaiActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnKhuyenMaiActionPerformed

    private void btnNCCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNCCActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnNCCActionPerformed

    private void btnGopYActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGopYActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnGopYActionPerformed

    private void btnHoaDonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHoaDonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnHoaDonActionPerformed

    private void btnSanPhamMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSanPhamMouseEntered
        // TODO add your handling code here:
        
    }//GEN-LAST:event_btnSanPhamMouseEntered

    private void btnSanPhamMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSanPhamMouseExited
        // TODO add your handling code here:
//        PopupMenu.setVisible(false);
    }//GEN-LAST:event_btnSanPhamMouseExited

    private void MenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenuItemActionPerformed
        // TODO add your handling code here:
        DesktopPane.removeAll();
        try {
            DesktopPane.add(new LOAISP_GUI()).setVisible(true);

        } catch (Exception e) {
        }
    }//GEN-LAST:event_MenuItemActionPerformed

    private void SanPhamMoreMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SanPhamMoreMouseClicked
        // TODO add your handling code here:
        PopupMenu.show(btnSanPham, x, y-25);
    }//GEN-LAST:event_SanPhamMoreMouseClicked

    private void btnQLNVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnQLNVActionPerformed
        // TODO add your handling code here:
        DesktopPane.removeAll();
        DesktopPane.add(new NHANVIEN_GUI()).setVisible(true);
    }//GEN-LAST:event_btnQLNVActionPerformed

    private void MenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenuItem2ActionPerformed
        // TODO add your handling code here:
        DesktopPane.removeAll();
        DesktopPane.add(new KHACHHANG_GUI()).setVisible(true);
    }//GEN-LAST:event_MenuItem2ActionPerformed

    private void NhanVienMoreMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_NhanVienMoreMouseClicked
        // TODO add your handling code here:
        PopupMenu2.show(btnQLNV, x, y-25);
    }//GEN-LAST:event_NhanVienMoreMouseClicked

    private void HoaDonMoreMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_HoaDonMoreMouseClicked
        // TODO add your handling code here:
        PopupMenu3.show(btnHoaDon, x, y-25);
    }//GEN-LAST:event_HoaDonMoreMouseClicked

    private void MenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenuItem3ActionPerformed
        // TODO add your handling code here:
        DesktopPane.removeAll();
        DesktopPane.add(new CTHD_GUI()).setVisible(true);
    }//GEN-LAST:event_MenuItem3ActionPerformed

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
            java.util.logging.Logger.getLogger(MAIN.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MAIN.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MAIN.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MAIN.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MAIN().setVisible(true);
                
                }
            
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JDesktopPane DesktopPane;
    private javax.swing.JLabel HoaDonMore;
    private javax.swing.JMenuItem MenuItem;
    private javax.swing.JMenuItem MenuItem2;
    private javax.swing.JMenuItem MenuItem3;
    private javax.swing.JLabel NhanVienMore;
    private javax.swing.JPopupMenu PopupMenu;
    private javax.swing.JPopupMenu PopupMenu2;
    private javax.swing.JPopupMenu PopupMenu3;
    private javax.swing.JLabel SanPhamMore;
    private javax.swing.JButton btnGopY;
    private javax.swing.JButton btnHoaDon;
    private javax.swing.JButton btnKhuyenMai;
    private javax.swing.JButton btnNCC;
    private javax.swing.JButton btnQLNV;
    private javax.swing.JButton btnSanPham;
    private javax.swing.JButton btnThongKe;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel label_exit_app;
    private javax.swing.JPanel label_header;
    // End of variables declaration//GEN-END:variables
}
