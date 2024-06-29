import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class KasirBaru extends javax.swing.JFrame {
    private Barang[] daftarisibarang;
    private DefaultTableModel model;
    
    public KasirBaru() {
        daftarisibarang = new Barang[]{
            new Barang("Televisi", 3000000),
            new Barang("Komputer", 4000000),
            new Barang("Laptop", 5000000),
            new Barang("Kompor", 500000),
            new Barang("Dispenser", 1000000)
        };
        initComponents();
        populateComboBox();
    }

    private void populateComboBox() { 
        DefaultComboBoxModel<String> model = new DefaultComboBoxModel<>();
        model.addElement("Pilih Barang");
        for (Barang brg : daftarisibarang) {
            model.addElement(brg.getNama());
        }
        nama_barang.setModel(model);
    }
    
    private void addItemToCart() {
        String NamaBrg = (String)nama_barang.getSelectedItem();
        int JumlahBeli = Integer.parseInt(jumlah_beli.getText());
        int HargaBarang = 0;
        for (Barang brg : daftarisibarang) {
            if (brg.getNama().equals(NamaBrg)) {
                HargaBarang = brg.getHarga();
                break;
            }
        }
        int TotalHarga = HargaBarang * JumlahBeli;
        model.addRow(new Object[]{NamaBrg, HargaBarang, JumlahBeli, TotalHarga});
        calculateTotalAmount();
    }
    
    private void calculateTotalAmount() {
        int rowCount = model.getRowCount();
        int totalAmount = 0;
        for (int i = 0; i < rowCount; i++) {
            totalAmount += (int)model.getValueAt(i, 3);
        }
        jumlah_harga.setText(Integer.toString(totalAmount));
    }

    private void processPayment() {
        int totalAmount = Integer.parseInt(jumlah_harga.getText());
        int payment = Integer.parseInt(jumlah_bayar.getText());
        
        if (payment >= totalAmount) {
            int change = payment - totalAmount;
            jumlah_kembalian.setText(Integer.toString(change));
            JOptionPane.showMessageDialog(this, "Pembayaran berhasil!\nJumlah Kembalian: " + change, "Sukses", JOptionPane.INFORMATION_MESSAGE);
        } else {
            jumlah_kembalian.setText("Uang Anda Kurang");
            JOptionPane.showMessageDialog(this, "Uang Anda kurang untuk melakukan pembayaran.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void processBankPayment() {
        int totalAmount = Integer.parseInt(jumlah_harga.getText());
        JOptionPane.showMessageDialog(this, "Pembayaran melalui bank sebesar: " + totalAmount + "\nInstruksi pembayaran akan dikirimkan ke email Anda.", "Pembayaran Bank", JOptionPane.INFORMATION_MESSAGE);
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        nama_barang = new javax.swing.JComboBox<>();
        harga_barang = new javax.swing.JTextField();
        jumlah_beli = new javax.swing.JTextField();
        jumlah_harga = new javax.swing.JTextField();
        jumlah_bayar = new javax.swing.JTextField();
        jumlah_kembalian = new javax.swing.JTextField();
        BATAL = new javax.swing.JButton();
        KELUAR = new javax.swing.JButton();
        hitung_jumlah_bayar = new javax.swing.JButton();
        bayar = new javax.swing.JButton();
        bayar_bank = new javax.swing.JButton();
        add_to_cart = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        cart_table = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("APLIKASI KASIR BARANG ELEKTRONIK ");

        jLabel2.setText("NAMA BARANG: ");

        jLabel3.setText("HARGA BARANG: ");

        jLabel4.setText("JUMLAH BELI: ");

        jLabel5.setText("JUMLAH HARGA: ");

        jLabel6.setText("JUMLAH BAYAR:");

        jLabel7.setText("JUMLAH KEMBALIAN: ");

        nama_barang.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        nama_barang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nama_barangActionPerformed(evt);
            }
        });

        harga_barang.setEditable(false);

        jumlah_harga.setEditable(false);

        jumlah_kembalian.setEditable(false);

        BATAL.setText("BATAL");
        BATAL.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BATALActionPerformed(evt);
            }
        });

        KELUAR.setText("KELUAR");
        KELUAR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                KELUARActionPerformed(evt);
            }
        });

        hitung_jumlah_bayar.setText("HITUNG JUMLAH BAYAR");
        hitung_jumlah_bayar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                hitung_jumlah_bayarActionPerformed(evt);
            }
        });

        bayar.setText("BAYAR");
        bayar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bayarActionPerformed(evt);
            }
        });

        bayar_bank.setText("BAYAR VIA BANK");
        bayar_bank.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bayar_bankActionPerformed(evt);
            }
        });

        add_to_cart.setText("TAMBAH KE KERANJANG");
        add_to_cart.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                add_to_cartActionPerformed(evt);
            }
        });

        cart_table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nama Barang", "Harga", "Jumlah", "Total"
            }
        ));
        jScrollPane1.setViewportView(cart_table);
        model = (DefaultTableModel) cart_table.getModel();

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(hitung_jumlah_bayar)
                        .addGap(18, 18, 18)
                        .addComponent(bayar)
                        .addGap(18, 18, 18)
                        .addComponent(bayar_bank)
                        .addGap(18, 18, 18)
                        .addComponent(add_to_cart)
                        .addGap(18, 18, 18)
                        .addComponent(BATAL)
                        .addGap(18, 18, 18)
                        .addComponent(KELUAR))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(jLabel5))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(harga_barang)
                            .addComponent(nama_barang, 0, 100, Short.MAX_VALUE)
                            .addComponent(jumlah_beli)
                            .addComponent(jumlah_harga)
                            .addComponent(jumlah_bayar)
                            .addComponent(jumlah_kembalian)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(103, 103, 103)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 475, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(nama_barang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(harga_barang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jumlah_beli, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jumlah_harga, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jumlah_bayar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jumlah_kembalian, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(hitung_jumlah_bayar)
                    .addComponent(bayar)
                    .addComponent(bayar_bank)
                    .addComponent(add_to_cart)
                    .addComponent(BATAL)
                    .addComponent(KELUAR))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>                        

    private void nama_barangActionPerformed(java.awt.event.ActionEvent evt) {                                            
        String NamaBrg = (String)nama_barang.getSelectedItem();
        for (Barang brg : daftarisibarang) {
            if (brg.getNama().equals(NamaBrg)) {
                harga_barang.setText(Integer.toString(brg.getHarga()));
                break;
            }
        }
    }                                           

    private void hitung_jumlah_bayarActionPerformed(java.awt.event.ActionEvent evt) {                                                    
        calculateTotalAmount();
    }                                                   

    private void bayarActionPerformed(java.awt.event.ActionEvent evt) {                                      
        processPayment();
    }                                     

    private void bayar_bankActionPerformed(java.awt.event.ActionEvent evt) {                                           
        processBankPayment();
    }                                          

    private void BATALActionPerformed(java.awt.event.ActionEvent evt) {                                      
        harga_barang.setText("");
        jumlah_beli.setText("");
        jumlah_harga.setText("");
        jumlah_bayar.setText("");
        jumlah_kembalian.setText("");
        nama_barang.setSelectedIndex(0);
        model.setRowCount(0); // Clear the cart table
    }                                     

    private void KELUARActionPerformed(java.awt.event.ActionEvent evt) {                                       
        System.exit(0);
    }                                      
    
    private void add_to_cartActionPerformed(java.awt.event.ActionEvent evt) {                                            
        addItemToCart();
    }

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new KasirBaru().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify                     
    private javax.swing.JButton BATAL;
    private javax.swing.JButton KELUAR;
    private javax.swing.JButton bayar;
    private javax.swing.JButton bayar_bank;
    private javax.swing.JTextField harga_barang;
    private javax.swing.JButton hitung_jumlah_bayar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JTextField jumlah_bayar;
    private javax.swing.JTextField jumlah_beli;
    private javax.swing.JTextField jumlah_harga;
    private javax.swing.JTextField jumlah_kembalian;
    private javax.swing.JComboBox<String> nama_barang;
    private javax.swing.JButton add_to_cart;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable cart_table;
    // End of variables declaration                   
}
