
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class FrozenFoodApp extends JFrame {
    public FrozenFoodApp() {
        setTitle("Aplikasi Bisnis Frozen Food");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Tabbed Pane untuk navigasi
        JTabbedPane tabbedPane = new JTabbedPane();

        // Halaman Pengelolaan Data Produk
        tabbedPane.add("Kelola Produk", createManageProductsPanel());

        // Halaman Pemesanan Produk
        tabbedPane.add("Pemesanan", createOrderProductsPanel());

        // Halaman Pencatatan Transaksi
        tabbedPane.add("Transaksi", createTransactionsPanel());

        // Halaman Laporan Penjualan
        tabbedPane.add("Laporan Penjualan", createSalesReportPanel());

        // Menambahkan tabbed pane ke frame
        add(tabbedPane);
    }

    // Panel Pengelolaan Data Produk
    private JPanel createManageProductsPanel() {
        JPanel panel = new JPanel(null);

        // Label dan kolom pencarian
        JLabel searchLabel = new JLabel("Cari Produk:");
        searchLabel.setBounds(20, 20, 100, 30);
        panel.add(searchLabel);

        JTextField searchField = new JTextField();
        searchField.setBounds(120, 20, 200, 30);
        panel.add(searchField);

        // Tabel data produk
        String[] columnNames = {"Nama Produk", "Deskripsi", "Ketersediaan"};
        Object[][] data = {
            {"Ayam Beku", "500g, halal", "Tersedia"},
            {"Ikan Beku", "1kg, segar", "Habis"},
        };
        DefaultTableModel tableModel = new DefaultTableModel(data, columnNames);
        JTable productTable = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(productTable);
        scrollPane.setBounds(20, 70, 750, 300);
        panel.add(scrollPane);

        // Tombol aksi
        JButton addButton = new JButton("Tambah Produk");
        addButton.setBounds(20, 400, 150, 30);
        panel.add(addButton);

        JButton editButton = new JButton("Edit Produk");
        editButton.setBounds(200, 400, 150, 30);
        panel.add(editButton);

        JButton deleteButton = new JButton("Hapus Produk");
        deleteButton.setBounds(380, 400, 150, 30);
        panel.add(deleteButton);

        return panel;
    }

    // Panel Pemesanan Produk
    private JPanel createOrderProductsPanel() {
        JPanel panel = new JPanel(null);

        // Form input
        JLabel nameLabel = new JLabel("Nama:");
        nameLabel.setBounds(20, 20, 100, 30);
        panel.add(nameLabel);

        JTextField nameField = new JTextField();
        nameField.setBounds(120, 20, 200, 30);
        panel.add(nameField);

        JLabel addressLabel = new JLabel("Alamat:");
        addressLabel.setBounds(20, 70, 100, 30);
        panel.add(addressLabel);

        JTextArea addressArea = new JTextArea();
        JScrollPane addressScroll = new JScrollPane(addressArea);
        addressScroll.setBounds(120, 70, 300, 100);
        panel.add(addressScroll);

        JLabel phoneLabel = new JLabel("No. WhatsApp:");
        phoneLabel.setBounds(20, 200, 100, 30);
        panel.add(phoneLabel);

        JTextField phoneField = new JTextField();
        phoneField.setBounds(120, 200, 200, 30);
        panel.add(phoneField);

        JButton orderButton = new JButton("Pesan");
        orderButton.setBounds(20, 300, 100, 30);
        panel.add(orderButton);

        return panel;
    }

    // Panel Pencatatan Transaksi
    private JPanel createTransactionsPanel() {
        JPanel panel = new JPanel(null);

        // Filter status transaksi
        JLabel filterLabel = new JLabel("Filter Status:");
        filterLabel.setBounds(20, 20, 100, 30);
        panel.add(filterLabel);

        JComboBox<String> filterComboBox = new JComboBox<>(new String[]{"Semua", "Diproses", "Selesai"});
        filterComboBox.setBounds(120, 20, 200, 30);
        panel.add(filterComboBox);

        // Tabel transaksi
        String[] columnNames = {"ID Transaksi", "Nama Pelanggan", "Status"};
        Object[][] data = {
            {"T001", "John Doe", "Diproses"},
            {"T002", "Jane Smith", "Selesai"},
        };
        DefaultTableModel tableModel = new DefaultTableModel(data, columnNames);
        JTable transactionTable = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(transactionTable);
        scrollPane.setBounds(20, 70, 750, 300);
        panel.add(scrollPane);

        JButton detailsButton = new JButton("Lihat Detail");
        detailsButton.setBounds(20, 400, 150, 30);
        panel.add(detailsButton);

        return panel;
    }

    // Panel Laporan Penjualan
    private JPanel createSalesReportPanel() {
        JPanel panel = new JPanel(null);

        // Filter laporan
        JLabel filterLabel = new JLabel("Pilih Periode:");
        filterLabel.setBounds(20, 20, 100, 30);
        panel.add(filterLabel);

        JComboBox<String> filterComboBox = new JComboBox<>(new String[]{"Harian", "Mingguan", "Bulanan"});
        filterComboBox.setBounds(120, 20, 200, 30);
        panel.add(filterComboBox);

        // Tabel laporan
        String[] columnNames = {"Nama Produk", "Jumlah Terjual", "Total"};
        Object[][] data = {
            {"Ayam Beku", "50", "Rp 2,500,000"},
            {"Ikan Beku", "20", "Rp 1,000,000"},
        };
        DefaultTableModel tableModel = new DefaultTableModel(data, columnNames);
        JTable reportTable = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(reportTable);
        scrollPane.setBounds(20, 70, 750, 300);
        panel.add(scrollPane);

        JButton downloadButton = new JButton("Unduh Laporan");
        downloadButton.setBounds(20, 400, 150, 30);
        panel.add(downloadButton);

        return panel;
    }

    public static void main(String[] args) {
        new FrozenFoodApp().setVisible(true);
    }
}
