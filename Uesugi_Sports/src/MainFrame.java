import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.PreparedStatement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.JPopupMenu;
import javax.swing.JMenuItem;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.text.JTextComponent;




public class MainFrame extends javax.swing.JFrame {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(MainFrame.class.getName());

    /**
     * Creates new form MainFrame
     */
    public MainFrame() {
    initComponents();
   
    
    txtNamaEvent.putClientProperty("JComponent.roundRect", true);
    txtWaktu.putClientProperty("JComponent.roundRect", true);
    txtSirkuit.putClientProperty("JComponent.roundRect", true);
    txtTanggal.putClientProperty("JComponent.roundRect", true);
    
    txtNamaEvent.putClientProperty("JTextField.placeholderText", "Nama Event (Contoh: Monaco GP)");
    txtWaktu.putClientProperty("JTextField.placeholderText", "Format Jam: HH:mm:ss");
    
    btnSimpan.putClientProperty("JButton.buttonType", "toolBarButton");
    btnEdit.putClientProperty("JButton.buttonType", "toolBarButton");
    btnHapus.putClientProperty("JButton.buttonType", "toolBarButton");
    btnClear.putClientProperty("JButton.buttonType", "toolBarButton");
    
    btnSimpanWrestling.putClientProperty("JButton.buttonType", "toolBarButton");
    btnEditWrestling.putClientProperty("JButton.buttonType", "toolBarButton");
    btnHapusWrestling.putClientProperty("JButton.buttonType", "toolBarButton");
    btnClearWrestling.putClientProperty("JButton.buttonType", "toolBarButton");
   
    tabelMotorsport.setShowVerticalLines(false);
    tabelMotorsport.setRowHeight(25);

    txtNamaEventWrestling.putClientProperty("JComponent.roundRect", true);
    txtPegulat.putClientProperty("JComponent.roundRect", true);
    txtTanggalWrestling.putClientProperty("JComponent.roundRect", true);
    txtWaktuWrestling.putClientProperty("JComponent.roundRect", true);
    
    btnSimpanWrestling.putClientProperty("JButton.buttonType", "roundRect");
    btnHapusWrestling.putClientProperty("JButton.buttonType", "roundRect");
    btnEditWrestling.putClientProperty("JButton.buttonType", "roundRect");
    btnClearWrestling.putClientProperty("JButton.buttonType", "roundRect");
    
    tabelWrestling.setShowVerticalLines(false);
    tabelWrestling.setRowHeight(25);

    tabelMotorsport.getColumnModel().getColumn(0).setPreferredWidth(50);
    tabelMotorsport.getColumnModel().getColumn(0).setMaxWidth(60);
    tabelMotorsport.getColumnModel().getColumn(0).setMinWidth(40);

    tabelWrestling.getColumnModel().getColumn(0).setPreferredWidth(50);
    tabelWrestling.getColumnModel().getColumn(0).setMaxWidth(60);
    tabelWrestling.getColumnModel().getColumn(0).setMinWidth(40);
    
    tabelMotorsport.getTableHeader().setResizingAllowed(false);
    tabelWrestling.getTableHeader().setResizingAllowed(false);
    
    javax.swing.table.DefaultTableCellRenderer centerRenderer = new javax.swing.table.DefaultTableCellRenderer();
    centerRenderer.setHorizontalAlignment(javax.swing.JLabel.CENTER);

    // Terapkan ke kolom indeks 0 (ID) di kedua tabel
    tabelMotorsport.getColumnModel().getColumn(0).setCellRenderer(centerRenderer);
    tabelWrestling.getColumnModel().getColumn(0).setCellRenderer(centerRenderer);
    
    jSplitPane1.setEnabled(false);
    
    tabelMotorsport.getTableHeader().setResizingAllowed(false);
    tabelWrestling.getTableHeader().setResizingAllowed(false);
    
    this.setTitle("Uesugi Sports - Management & Information System");
    this.setSize(1100, 600); 
    this.setLocationRelativeTo(null);
    
    tampilkanDataMotorsport();

    tampilkanDataMotorsport();
    tampilkanDataWrestling();
    
    pasangMenuKlikKanan(txtNamaEvent);
    
    this.setLocationRelativeTo(null); 
    
    pasangMenuKlikKanan(txtNamaEvent);
    pasangMenuKlikKanan(txtSirkuit);
    pasangMenuKlikKanan(txtTanggal);
    pasangMenuKlikKanan(txtWaktu);
    
    pasangMenuKlikKanan(txtNamaEventWrestling);
    pasangMenuKlikKanan(txtPegulat);
    pasangMenuKlikKanan(txtTanggalWrestling);
    pasangMenuKlikKanan(txtWaktuWrestling);   
}
 
public void tampilkanHalamanMotorsport() {
    java.awt.CardLayout cl = (java.awt.CardLayout) panelIndukCard.getLayout();
    cl.show(panelIndukCard, "kartu_motorsport");
}   
       
public void tampilkanHalamanWrestling() {
    java.awt.CardLayout cl = (java.awt.CardLayout) panelIndukCard.getLayout();
    cl.show(panelIndukCard, "kartu_wrestling");
}   

public void tampilkanHalamanInformasi() {
    java.awt.CardLayout cl = (java.awt.CardLayout) panelIndukCard.getLayout();
    cl.show(panelIndukCard, "kartu_informasi");
}  


    private void clearForm() {
    txtNamaEvent.setText("");
    txtSirkuit.setText("");
    txtTanggal.setText("");
    txtWaktu.setText("");
    tabelMotorsport.clearSelection();
}

 private void clearFormWrestling() {
    txtNamaEventWrestling.setText(""); // Sesuaikan dengan nama variabel JTextField Anda
    txtPegulat.setText("");
    txtTanggalWrestling.setText("");
    txtWaktuWrestling.setText("");
    tabelWrestling.clearSelection();
}   
    
    
private void pasangMenuKlikKanan(JTextComponent textField) {
    JPopupMenu popupMenu = new JPopupMenu();
    
    JMenuItem cutItem = new JMenuItem("Cut");
    JMenuItem copyItem = new JMenuItem("Copy");
    JMenuItem pasteItem = new JMenuItem("Paste");
    
    cutItem.addActionListener(e -> textField.cut());
    copyItem.addActionListener(e -> textField.copy());
    pasteItem.addActionListener(e -> textField.paste());
    
    popupMenu.add(cutItem);
    popupMenu.add(copyItem);
    popupMenu.add(pasteItem);
    
    textField.addMouseListener(new MouseAdapter() {
        @Override
        public void mousePressed(MouseEvent e) {
            tampilkanMenu(e);
        }

        @Override
        public void mouseReleased(MouseEvent e) {
            tampilkanMenu(e);
        }

        private void tampilkanMenu(MouseEvent e) {
            if (e.isPopupTrigger()) {
                popupMenu.show(e.getComponent(), e.getX(), e.getY());
            }
        }
    });
}
private void tampilkanDataWrestling() {
    DefaultTableModel model = new DefaultTableModel();
    model.addColumn("No");
    model.addColumn("Nama Event");
    model.addColumn("Pegulat");
    model.addColumn("Tanggal");
    model.addColumn("Waktu");
    
    try {
        int no = 1;
        String sql = "SELECT * FROM tbl_wrestling";
        java.sql.Connection conn = (Connection)Koneksi.configDB();
        java.sql.Statement stm = conn.createStatement();
        java.sql.ResultSet res = stm.executeQuery(sql);
        
        while(res.next()){
            model.addRow(new Object[]{
                no++, 
                res.getString("nama_event"), 
                res.getString("pegulat"), 
                res.getString("tanggal_match"), 
                res.getString("waktu_match")
            });
        }
        tabelWrestling.setModel(model); 
        
    } catch (Exception e) {
        JOptionPane.showMessageDialog(this, "Gagal memuat data Wrestling: " + e.getMessage());
    }
}
public void tampilkanDataMotorsport() {
    DefaultTableModel model = new DefaultTableModel();
    model.addColumn("ID");
    model.addColumn("Nama Event");
    model.addColumn("Sirkuit");
    model.addColumn("Tanggal");
    model.addColumn("Waktu");
    
    try {
        String sql = "SELECT * FROM tbl_motorsports";
        Connection conn = (Connection)Koneksi.configDB();
        Statement stm = conn.createStatement();
        ResultSet res = stm.executeQuery(sql);
        
        while(res.next()) {
            model.addRow(new Object[]{
                res.getString("id_race"),
                res.getString("nama_event"),
                res.getString("sirkuit"),
                res.getString("tanggal_race"),
                res.getString("waktu_race")
            });
        }
        tabelMotorsport.setModel(model); 
    } catch (Exception e) {
        System.out.println("Error: " + e.getMessage());
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

        panelIndukCard = new javax.swing.JPanel();
        panelMotorsport = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabelMotorsport = new javax.swing.JTable();
        txtNamaEvent = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        txtSirkuit = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtTanggal = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtWaktu = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        btnEdit = new javax.swing.JButton();
        btnSimpan = new javax.swing.JButton();
        btnHapus = new javax.swing.JButton();
        btnClear = new javax.swing.JButton();
        btnHome = new javax.swing.JButton();
        panelWrestling = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tabelWrestling = new javax.swing.JTable();
        txtNamaEventWrestling = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtPegulat = new javax.swing.JTextField();
        txtTanggalWrestling = new javax.swing.JTextField();
        txtWaktuWrestling = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        btnEditWrestling = new javax.swing.JButton();
        btnSimpanWrestling = new javax.swing.JButton();
        btnHapusWrestling = new javax.swing.JButton();
        btnClearWrestling = new javax.swing.JButton();
        btnHomeWrestling = new javax.swing.JButton();
        panelInformasi = new javax.swing.JPanel();
        jSplitPane1 = new javax.swing.JSplitPane();
        jScrollPane3 = new javax.swing.JScrollPane();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane5 = new javax.swing.JScrollPane();
        txtInfoMotorsport = new javax.swing.JTextArea();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane6 = new javax.swing.JScrollPane();
        txtInfoWrestling = new javax.swing.JTextArea();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        btnHomeInformasi = new javax.swing.JButton();
        btnSaveInfo = new javax.swing.JButton();
        btnEditInfo = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Uesugi Sports\n");
        setResizable(false);

        panelIndukCard.setBackground(new java.awt.Color(255, 0, 0));
        panelIndukCard.setLayout(new java.awt.CardLayout());

        panelMotorsport.setBackground(new java.awt.Color(0, 153, 255));

        tabelMotorsport.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "No", "Nama Event", "Sirkuit", "Tanggal", "Waktu"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tabelMotorsport.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelMotorsportMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabelMotorsport);
        if (tabelMotorsport.getColumnModel().getColumnCount() > 0) {
            tabelMotorsport.getColumnModel().getColumn(0).setResizable(false);
            tabelMotorsport.getColumnModel().getColumn(1).setResizable(false);
            tabelMotorsport.getColumnModel().getColumn(2).setResizable(false);
            tabelMotorsport.getColumnModel().getColumn(3).setResizable(false);
            tabelMotorsport.getColumnModel().getColumn(4).setResizable(false);
        }

        jLabel1.setText("Nama Event:");

        txtSirkuit.addActionListener(this::txtSirkuitActionPerformed);

        jLabel2.setText("Sirkuit:");

        jLabel3.setText("Tanggal:");

        jLabel4.setText("Waktu:");

        btnEdit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons8-edit-pencil-24.png"))); // NOI18N
        btnEdit.addActionListener(this::btnEditActionPerformed);

        btnSimpan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons8-save-24.png"))); // NOI18N
        btnSimpan.addActionListener(this::btnSimpanActionPerformed);

        btnHapus.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons8-delete-24.png"))); // NOI18N
        btnHapus.addActionListener(this::btnHapusActionPerformed);

        btnClear.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons8-clear-symbol-24.png"))); // NOI18N
        btnClear.addActionListener(this::btnClearActionPerformed);

        btnHome.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons8-home-24.png"))); // NOI18N
        btnHome.setBorderPainted(false);
        btnHome.setContentAreaFilled(false);
        btnHome.setFocusPainted(false);
        btnHome.addActionListener(this::btnHomeActionPerformed);

        javax.swing.GroupLayout panelMotorsportLayout = new javax.swing.GroupLayout(panelMotorsport);
        panelMotorsport.setLayout(panelMotorsportLayout);
        panelMotorsportLayout.setHorizontalGroup(
            panelMotorsportLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1052, Short.MAX_VALUE)
            .addGroup(panelMotorsportLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelMotorsportLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtNamaEvent, javax.swing.GroupLayout.DEFAULT_SIZE, 120, Short.MAX_VALUE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(txtSirkuit))
                .addGap(37, 37, 37)
                .addGroup(panelMotorsportLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtWaktu, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelMotorsportLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel3)
                        .addComponent(txtTanggal, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(99, 99, 99)
                .addComponent(btnSimpan, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnHapus, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnClear, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelMotorsportLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnHome, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(14, 14, 14))
        );
        panelMotorsportLayout.setVerticalGroup(
            panelMotorsportLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelMotorsportLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnHome)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 295, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelMotorsportLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(panelMotorsportLayout.createSequentialGroup()
                        .addGroup(panelMotorsportLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(jLabel1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panelMotorsportLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtNamaEvent, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtWaktu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panelMotorsportLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panelMotorsportLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtSirkuit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtTanggal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(panelMotorsportLayout.createSequentialGroup()
                        .addGroup(panelMotorsportLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(btnEdit, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnSimpan, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnHapus, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnClear, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(9, 9, 9)))
                .addContainerGap(46, Short.MAX_VALUE))
        );

        panelIndukCard.add(panelMotorsport, "kartu_motorsport");

        panelWrestling.setBackground(new java.awt.Color(0, 153, 153));

        tabelWrestling.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "No", "Nama Event", "Pegulat", "Tanggal", "Waktu"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tabelWrestling.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_ALL_COLUMNS);
        tabelWrestling.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelWrestlingMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tabelWrestling);
        if (tabelWrestling.getColumnModel().getColumnCount() > 0) {
            tabelWrestling.getColumnModel().getColumn(0).setResizable(false);
            tabelWrestling.getColumnModel().getColumn(1).setResizable(false);
            tabelWrestling.getColumnModel().getColumn(2).setResizable(false);
            tabelWrestling.getColumnModel().getColumn(3).setResizable(false);
            tabelWrestling.getColumnModel().getColumn(4).setResizable(false);
        }

        jLabel5.setText("Nama PPV:");

        jLabel6.setText("Pegulat:");

        jLabel7.setText("Tanggal:");

        jLabel8.setText("Waktu:");

        btnEditWrestling.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons8-edit-pencil-24.png"))); // NOI18N
        btnEditWrestling.addActionListener(this::btnEditWrestlingActionPerformed);

        btnSimpanWrestling.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons8-save-24.png"))); // NOI18N
        btnSimpanWrestling.addActionListener(this::btnSimpanWrestlingActionPerformed);

        btnHapusWrestling.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons8-delete-24.png"))); // NOI18N
        btnHapusWrestling.addActionListener(this::btnHapusWrestlingActionPerformed);

        btnClearWrestling.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons8-clear-symbol-24.png"))); // NOI18N
        btnClearWrestling.addActionListener(this::btnClearWrestlingActionPerformed);

        btnHomeWrestling.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons8-home-24.png"))); // NOI18N
        btnHomeWrestling.setBorderPainted(false);
        btnHomeWrestling.setContentAreaFilled(false);
        btnHomeWrestling.setFocusPainted(false);
        btnHomeWrestling.addActionListener(this::btnHomeWrestlingActionPerformed);

        javax.swing.GroupLayout panelWrestlingLayout = new javax.swing.GroupLayout(panelWrestling);
        panelWrestling.setLayout(panelWrestlingLayout);
        panelWrestlingLayout.setHorizontalGroup(
            panelWrestlingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2)
            .addGroup(panelWrestlingLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelWrestlingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelWrestlingLayout.createSequentialGroup()
                        .addGroup(panelWrestlingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtNamaEventWrestling, javax.swing.GroupLayout.DEFAULT_SIZE, 121, Short.MAX_VALUE)
                            .addComponent(txtPegulat))
                        .addGap(37, 37, 37)
                        .addGroup(panelWrestlingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtTanggalWrestling, javax.swing.GroupLayout.DEFAULT_SIZE, 120, Short.MAX_VALUE)
                            .addComponent(txtWaktuWrestling))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 109, Short.MAX_VALUE)
                        .addComponent(btnSimpanWrestling, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnEditWrestling, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnHapusWrestling, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnClearWrestling, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 135, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelWrestlingLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnHomeWrestling, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        panelWrestlingLayout.setVerticalGroup(
            panelWrestlingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelWrestlingLayout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addComponent(btnHomeWrestling)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 278, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelWrestlingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(panelWrestlingLayout.createSequentialGroup()
                        .addGroup(panelWrestlingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(jLabel7))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panelWrestlingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtNamaEventWrestling, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtTanggalWrestling, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panelWrestlingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(jLabel8))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panelWrestlingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtWaktuWrestling, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtPegulat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(btnSimpanWrestling, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnEditWrestling, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnHapusWrestling, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnClearWrestling, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(55, Short.MAX_VALUE))
        );

        panelIndukCard.add(panelWrestling, "kartu_wrestling");

        panelInformasi.setBackground(new java.awt.Color(255, 0, 51));

        jSplitPane1.setDividerSize(0);
        jSplitPane1.setResizeWeight(0.5);

        jPanel2.setBackground(new java.awt.Color(0, 153, 204));

        txtInfoMotorsport.setEditable(false);
        txtInfoMotorsport.setColumns(20);
        txtInfoMotorsport.setLineWrap(true);
        txtInfoMotorsport.setRows(5);
        txtInfoMotorsport.setText("Formula 1 (F1) adalah kelas tertinggi dari balap mobil roda terbuka satu tempat duduk (open-wheel single-seater) yang diatur oleh Federasi Otomotif Internasional (FIA). Sering disebut sebagai \"puncak olahraga otomotif\", F1 mempertemukan tim-tim terbaik dunia untuk berkompetisi menggunakan mobil berteknologi tercanggih yang mampu melaju hingga kecepatan lebih dari 350 km/jam.\n\nIstilah Penting dalam F1\n\n1. Formula: Kumpulan aturan teknis dan keselamatan ketat yang wajib dipatuhi oleh seluruh tim konstruktor.\n\n2. Grand Prix: Sebutan untuk seri balapan resmi F1 yang diadakan di berbagai sirkuit di seluruh dunia.\n\n3. Konstruktor: Tim balap yang merancang, membangun, dan memproduksi sasis mobil mereka sendiri.\n\n3. Halo: Batang titanium melengkung di atas kokpit yang berfungsi melindungi kepala pembalap dari serpihan kecelakaan.\n\nFormat Kompetisi dan Gelar Juara\n\nSetiap musim berjalan dari bulan Maret hingga Desember. Seluruh tim memperebutkan dua gelar juara dunia utama di akhir musim:\n\n1. Kejuaraan Dunia Pembalap: Diberikan kepada pembalap yang mengumpulkan poin terbanyak sepanjang musim.\n\n2. Kejuaraan Dunia Konstruktor: Diberikan kepada tim pabrikan berdasarkan akumulasi poin dari kedua pembalap mereka.\n\nPoin balapan utama hanya diberikan kepada 10 pembalap terdepan yang berhasil menyentuh garis finis. Durasi balapan umumnya berlangsung sekitar 90 menit \ndengan batas maksimal hingga 2 jam jika terjadi penundaan akibat kecelakaan atau cuaca buruk.");
        txtInfoMotorsport.setWrapStyleWord(true);
        jScrollPane5.setViewportView(txtInfoMotorsport);

        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/foto_F1.jpg"))); // NOI18N

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel10.setText("MOTORSPORT WORLD ENCYCLOPEDIA");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 472, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(87, 87, 87)
                        .addComponent(jLabel10)))
                .addContainerGap(38, Short.MAX_VALUE))
            .addComponent(jScrollPane5)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(jLabel10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 289, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 347, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jScrollPane3.setViewportView(jPanel2);

        jSplitPane1.setLeftComponent(jScrollPane3);

        jPanel3.setBackground(new java.awt.Color(255, 255, 0));

        txtInfoWrestling.setEditable(false);
        txtInfoWrestling.setColumns(20);
        txtInfoWrestling.setLineWrap(true);
        txtInfoWrestling.setRows(5);
        txtInfoWrestling.setText("WWE (World Wrestling Entertainment) adalah perusahaan media dan hiburan global asal Amerika Serikat yang merupakan promotor gulat profesional terbesar di dunia. Acara WWE menyajikan kombinasi antara aksi atletik (gulat) dengan hiburan teatrikal, di mana alur cerita, karakter pegulat, dan hasil pertandingannya sudah dirancang atau diskenariokan sebelumnya.\n\nMeskipun pemenang pertandingan sudah ditentukan, kontak fisik, bantingan, dan lompatan yang dilakukan oleh para atlet (disebut sebagai WWE Superstars) tetap membutuhkan latihan fisik yang nyata dan sangat berbahaya.\n\nBerikut adalah poin-poin penting untuk memahami apa itu WWE:\n\n1. Program Utama dan Merek (Brands).\nWWE membagi daftar pegulat dan acaranya ke dalam beberapa program televisi mingguan yang sangat terkenal:\n\n- WWE Raw: Program mingguan bendera merah yang tayang setiap Senin malam.\n- WWE SmackDown: Program mingguan bendera biru yang tayang setiap Jumat malam. Di Indonesia, masyarakat awam sering kali menyebut seluruh aksi gulat ini sebagai \"SmackDown\" karena popularitas acara ini di televisi lokal pada masa lalu.\n- WWE NXT: Merek pengembangan yang menjadi tempat melatih para pegulat muda sebelum masuk ke program utama.\n\n2. Acara Besar Tahunan (Premium Live Events).\nSelain program mingguan, WWE menyelenggarakan acara berskala besar setiap bulannya. Acara yang paling ikonik adalah WrestleMania, yang sering dianggap sebagai \"Piala Dunia\" atau Super Bowl-nya industri gulat profesional.\n\n3. Asal-usul Nama\nPerusahaan ini didirikan pada tahun 1953 dengan nama Capitol Wrestling Corporation. Sebelum dikenal sebagai WWE, perusahaan ini sangat populer dengan nama WWF (World Wrestling Federation). Pada tahun 2002, nama tersebut resmi diubah menjadi WWE setelah kalah dalam sengketa hukum dengan organisasi lingkungan hidup World Wildlife Fund yang memiliki singkatan sama (WWF).\n\n4. Kepemilikan Saat Ini.\nSaat ini, WWE berada di bawah naungan TKO Group Holdings, sebuah perusahaan hasil merger antara WWE dan promotor beladiri campuran UFC. Keduanya beroperasi di bawah induk perusahaan raksasa Endeavor.");
        txtInfoWrestling.setWrapStyleWord(true);
        jScrollPane6.setViewportView(txtInfoWrestling);

        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/20260622_RAW_final (2).jpg"))); // NOI18N

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel12.setText("WRESTLING WORLD ENCYCLOPEDIA");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 576, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel11))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(130, 130, 130)
                .addComponent(jLabel12))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, 33, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel11)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 375, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jScrollPane4.setViewportView(jPanel3);

        jSplitPane1.setRightComponent(jScrollPane4);

        btnHomeInformasi.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons8-home-24.png"))); // NOI18N
        btnHomeInformasi.setBorderPainted(false);
        btnHomeInformasi.setContentAreaFilled(false);
        btnHomeInformasi.setFocusPainted(false);
        btnHomeInformasi.addActionListener(this::btnHomeInformasiActionPerformed);

        btnSaveInfo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons8-save-24.png"))); // NOI18N
        btnSaveInfo.setBorderPainted(false);
        btnSaveInfo.setContentAreaFilled(false);
        btnSaveInfo.setFocusPainted(false);
        btnSaveInfo.addActionListener(this::btnSaveInfoActionPerformed);

        btnEditInfo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons8-edit-pencil-24.png"))); // NOI18N
        btnEditInfo.setBorderPainted(false);
        btnEditInfo.setContentAreaFilled(false);
        btnEditInfo.setFocusPainted(false);
        btnEditInfo.addActionListener(this::btnEditInfoActionPerformed);

        javax.swing.GroupLayout panelInformasiLayout = new javax.swing.GroupLayout(panelInformasi);
        panelInformasi.setLayout(panelInformasiLayout);
        panelInformasiLayout.setHorizontalGroup(
            panelInformasiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelInformasiLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnSaveInfo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnEditInfo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnHomeInformasi, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addComponent(jSplitPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1089, Short.MAX_VALUE)
        );
        panelInformasiLayout.setVerticalGroup(
            panelInformasiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelInformasiLayout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addGroup(panelInformasiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnEditInfo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnHomeInformasi, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnSaveInfo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSplitPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 507, Short.MAX_VALUE))
        );

        panelIndukCard.add(panelInformasi, "kartu_informasi");

        getContentPane().add(panelIndukCard, java.awt.BorderLayout.CENTER);

        setSize(new java.awt.Dimension(1066, 492));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClearActionPerformed
        clearForm();
    }//GEN-LAST:event_btnClearActionPerformed

    private void btnHapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHapusActionPerformed
        int baris = tabelMotorsport.getSelectedRow();
        if (baris == -1) {
            JOptionPane.showMessageDialog(this, "Silahkan pilih data yang ingin dihapus pada tabel!");
            return;
        }

        String id_race = tabelMotorsport.getValueAt(baris, 0).toString();
        int konfirmasi = JOptionPane.showConfirmDialog(null, "Apakah Anda yakin ingin menghapus data ini?", "Konfirmasi", JOptionPane.YES_NO_OPTION);

        if (konfirmasi == JOptionPane.YES_OPTION) {
            try {
                String sql = "DELETE FROM tbl_motorsports WHERE id_race=?";
                Connection conn = Koneksi.configDB();
                PreparedStatement pst = conn.prepareStatement(sql);
                pst.setString(1, id_race);

                pst.execute();
                JOptionPane.showMessageDialog(null, "Data Berhasil Dihapus");

                tampilkanDataMotorsport();
                clearForm();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, e.getMessage());
            }
        }
    }//GEN-LAST:event_btnHapusActionPerformed

    private void btnSimpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSimpanActionPerformed
        try {
            String sql = "INSERT INTO tbl_motorsports (nama_event, sirkuit, tanggal_race, waktu_race) VALUES (?, ?, ?, ?)";
            Connection conn = Koneksi.configDB();
            PreparedStatement pst = conn.prepareStatement(sql);

            pst.setString(1, txtNamaEvent.getText());
            pst.setString(2, txtSirkuit.getText());
            pst.setString(3, txtTanggal.getText());
            pst.setString(4, txtWaktu.getText());

            pst.execute();
            JOptionPane.showMessageDialog(null, "Penyimpanan Data Berhasil");

            tampilkanDataMotorsport();
            clearForm();               
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }//GEN-LAST:event_btnSimpanActionPerformed

    private void btnEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditActionPerformed
        int baris = tabelMotorsport.getSelectedRow();
        if (baris == -1) {
            JOptionPane.showMessageDialog(this, "Silahkan pilih data pada tabel terlebih dahulu!");
            return;
        }

        String id_race = tabelMotorsport.getValueAt(baris, 0).toString();

        try {
            String sql = "UPDATE tbl_motorsports SET nama_event=?, sirkuit=?, tanggal_race=?, waktu_race=? WHERE id_race=?";
            Connection conn = Koneksi.configDB();
            PreparedStatement pst = conn.prepareStatement(sql);

            pst.setString(1, txtNamaEvent.getText());
            pst.setString(2, txtSirkuit.getText());
            pst.setString(3, txtTanggal.getText());
            pst.setString(4, txtWaktu.getText());
            pst.setString(5, id_race);

            pst.executeUpdate();
            JOptionPane.showMessageDialog(null, "Data Berhasil Diubah");

            tampilkanDataMotorsport();
            clearForm();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Perubahan Data Gagal: " + e.getMessage());
        }
    }//GEN-LAST:event_btnEditActionPerformed

    private void txtSirkuitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSirkuitActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSirkuitActionPerformed

    private void tabelMotorsportMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelMotorsportMouseClicked
        int baris = tabelMotorsport.rowAtPoint(evt.getPoint());

        String namaEvent = tabelMotorsport.getValueAt(baris, 1).toString();
        txtNamaEvent.setText(namaEvent);

        String sirkuit = tabelMotorsport.getValueAt(baris, 2).toString();
        txtSirkuit.setText(sirkuit);

        String tanggal = tabelMotorsport.getValueAt(baris, 3).toString();
        txtTanggal.setText(tanggal);

        String waktu = tabelMotorsport.getValueAt(baris, 4).toString();
        txtWaktu.setText(waktu);
    }//GEN-LAST:event_tabelMotorsportMouseClicked

    private void btnEditWrestlingActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditWrestlingActionPerformed
    try {
        String sql = "INSERT INTO tbl_wrestling (nama_event, pegulat, tanggal_match, waktu_match) VALUES (?, ?, ?, ?)";
        java.sql.Connection conn = (Connection)Koneksi.configDB();
        java.sql.PreparedStatement pst = conn.prepareStatement(sql);
        
        pst.setString(1, txtNamaEventWrestling.getText());
        pst.setString(2, txtPegulat.getText());
        pst.setString(3, txtTanggalWrestling.getText());
        pst.setString(4, txtWaktuWrestling.getText());
        
        pst.execute();
        JOptionPane.showMessageDialog(null, "Penyimpanan Data Wrestling Berhasil");
        tampilkanDataWrestling();
        clearFormWrestling();
    } catch (Exception e) {
        JOptionPane.showMessageDialog(this, e.getMessage());
    }
    }//GEN-LAST:event_btnEditWrestlingActionPerformed

    private void btnClearWrestlingActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClearWrestlingActionPerformed
    clearFormWrestling();
    }//GEN-LAST:event_btnClearWrestlingActionPerformed

    private void btnHapusWrestlingActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHapusWrestlingActionPerformed
    int baris = tabelWrestling.getSelectedRow();
    if (baris != -1) {
        String namaEvent = tabelWrestling.getValueAt(baris, 1).toString();
        int opsi = JOptionPane.showConfirmDialog(null, "Yakin ingin menghapus event " + namaEvent + "?", "Konfirmasi", JOptionPane.YES_NO_OPTION);
        if (opsi == JOptionPane.YES_OPTION) {
            try {
                String sql = "DELETE FROM tbl_wrestling WHERE nama_event = ?";
                java.sql.Connection conn = (Connection)Koneksi.configDB();
                java.sql.PreparedStatement pst = conn.prepareStatement(sql);
                pst.setString(1, namaEvent);
                pst.execute();
                
                JOptionPane.showMessageDialog(null, "Data Berhasil Dihapus");
                tampilkanDataWrestling();
                clearFormWrestling();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, e.getMessage());
            }
        }
    } else {
        JOptionPane.showMessageDialog(this, "Silahkan pilih data di tabel terlebih dahulu!");
    }
    }//GEN-LAST:event_btnHapusWrestlingActionPerformed

    private void btnSimpanWrestlingActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSimpanWrestlingActionPerformed
     if (txtNamaEventWrestling.getText().trim().isEmpty() || 
        txtPegulat.getText().trim().isEmpty() || 
        txtTanggalWrestling.getText().trim().isEmpty() || 
        txtWaktuWrestling.getText().trim().isEmpty()) {
        
        JOptionPane.showMessageDialog(this, "Semua data wajib diisi!", "Peringatan", JOptionPane.WARNING_MESSAGE);
        return;
    }

    try {
       
        String sql = "INSERT INTO tbl_wrestling (nama_event, pegulat, tanggal_match, waktu_match) VALUES (?, ?, ?, ?)";
        
     
        java.sql.Connection conn = (Connection)Koneksi.configDB();
        java.sql.PreparedStatement pst = conn.prepareStatement(sql);
        
        pst.setString(1, txtNamaEventWrestling.getText().trim());
        pst.setString(2, txtPegulat.getText().trim());
        pst.setString(3, txtTanggalWrestling.getText().trim());
        pst.setString(4, txtWaktuWrestling.getText().trim());
        
        pst.execute();
        
        JOptionPane.showMessageDialog(null, "Penyimpanan Data Wrestling Berhasil!");
        
        tampilkanDataWrestling(); 
        clearFormWrestling();    
        
    } catch (Exception e) {
        JOptionPane.showMessageDialog(this, "Gagal menyimpan data: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
    }
    }//GEN-LAST:event_btnSimpanWrestlingActionPerformed

    private void tabelWrestlingMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelWrestlingMouseClicked
   int baris = tabelWrestling.getSelectedRow();
    
    if (baris != -1) {
        String namaEvent = tabelWrestling.getValueAt(baris, 1).toString();
        String pegulat  = tabelWrestling.getValueAt(baris, 2).toString();
        String tanggal   = tabelWrestling.getValueAt(baris, 3).toString();
        String waktu     = tabelWrestling.getValueAt(baris, 4).toString();
        
        txtNamaEventWrestling.setText(namaEvent);
        txtPegulat.setText(pegulat);
        txtTanggalWrestling.setText(tanggal);
        txtWaktuWrestling.setText(waktu);
    }
    }//GEN-LAST:event_tabelWrestlingMouseClicked

    private void btnHomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHomeActionPerformed
    HomePage home = new HomePage();
    
    home.setVisible(true);
    
    this.dispose();
    }//GEN-LAST:event_btnHomeActionPerformed

    private void btnHomeWrestlingActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHomeWrestlingActionPerformed
    HomePage home = new HomePage();
    home.setVisible(true);
    this.dispose();
    }//GEN-LAST:event_btnHomeWrestlingActionPerformed

    private void btnHomeInformasiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHomeInformasiActionPerformed
    HomePage home = new HomePage();
    home.setVisible(true);
    this.dispose();
    }//GEN-LAST:event_btnHomeInformasiActionPerformed

    private void btnEditInfoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditInfoActionPerformed
    txtInfoMotorsport.setEditable(true);
    txtInfoWrestling.setEditable(true);
    
    btnEditInfo.setVisible(false);
    btnSaveInfo.setVisible(true);
    
    txtInfoMotorsport.setBackground(java.awt.Color.WHITE);
    txtInfoWrestling.setBackground(java.awt.Color.WHITE);
    }//GEN-LAST:event_btnEditInfoActionPerformed

    private void btnSaveInfoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveInfoActionPerformed
    String infoMotorsport = txtInfoMotorsport.getText();
    String infoWrestling = txtInfoWrestling.getText();
    
    txtInfoMotorsport.setEditable(false);
    txtInfoWrestling.setEditable(false);
   
    txtInfoMotorsport.setBackground(this.getBackground());
    txtInfoWrestling.setBackground(this.getBackground());
    
    btnSaveInfo.setVisible(false);
    btnEditInfo.setVisible(true);
    
    javax.swing.JOptionPane.showMessageDialog(this, "Seluruh Ensiklopedia Berhasil Diperbarui!");
    }//GEN-LAST:event_btnSaveInfoActionPerformed

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
        } catch (ReflectiveOperationException | javax.swing.UnsupportedLookAndFeelException ex) {
            logger.log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> new MainFrame().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnClear;
    private javax.swing.JButton btnClearWrestling;
    private javax.swing.JButton btnEdit;
    private javax.swing.JButton btnEditInfo;
    private javax.swing.JButton btnEditWrestling;
    private javax.swing.JButton btnHapus;
    private javax.swing.JButton btnHapusWrestling;
    private javax.swing.JButton btnHome;
    private javax.swing.JButton btnHomeInformasi;
    private javax.swing.JButton btnHomeWrestling;
    private javax.swing.JButton btnSaveInfo;
    private javax.swing.JButton btnSimpan;
    private javax.swing.JButton btnSimpanWrestling;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JSplitPane jSplitPane1;
    private javax.swing.JPanel panelIndukCard;
    private javax.swing.JPanel panelInformasi;
    private javax.swing.JPanel panelMotorsport;
    private javax.swing.JPanel panelWrestling;
    private javax.swing.JTable tabelMotorsport;
    private javax.swing.JTable tabelWrestling;
    private javax.swing.JTextArea txtInfoMotorsport;
    private javax.swing.JTextArea txtInfoWrestling;
    private javax.swing.JTextField txtNamaEvent;
    private javax.swing.JTextField txtNamaEventWrestling;
    private javax.swing.JTextField txtPegulat;
    private javax.swing.JTextField txtSirkuit;
    private javax.swing.JTextField txtTanggal;
    private javax.swing.JTextField txtTanggalWrestling;
    private javax.swing.JTextField txtWaktu;
    private javax.swing.JTextField txtWaktuWrestling;
    // End of variables declaration//GEN-END:variables
}
