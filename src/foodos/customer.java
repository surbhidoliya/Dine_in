package foodos;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.table.*;

public class customer extends JFrame {

    P666demo f1;
    static String[] Name;
    static String[] contact;
    static int[] orderId;
    static int tableNo[];

    customer() {
        super("Customer");
        setBounds(100, 100, 950, 600);
        setResizable(false);
        setLocationRelativeTo(null);
        f1 = new P666demo();
        add(f1);
    }

    public static void main(String[] args) {
        customer f1 = new customer();
        f1.setVisible(true);
        f1.setDefaultCloseOperation(f1.EXIT_ON_CLOSE);
    }

}

class P666demo extends JPanel implements ActionListener {

    ImageIcon img1;
    Image bg1;
    JButton b1, b2;
    JLabel l1, l2, l3, l4;
    DefaultTableModel model;
    static JTable table;
    int x = 0;

    P666demo() {
        setLayout(null);
        Font f = new Font("Georgia", Font.BOLD, 13);

        img1 = new ImageIcon(ClassLoader.getSystemResource("foodos/image/cart.jpg"));
        bg1 = img1.getImage();

        String[] columnNames = {"Order Id", "Customer Name", "Contact", "View"};
        model = new DefaultTableModel(columnNames, 0);

        for (int i = 0; i < adminlogin.totalcus; i++) {
            String[] rowData = {
                ""
                + customer.orderId[i],
                "" + customer.Name[i],
                "" + customer.contact[i],
                "View Item"
            };
            model.addRow(rowData);
        }

        l2 = new JLabel("Customers");
        l2.setBounds(380, 50, 250, 30);
        l2.setFont(new Font("Algerian", Font.BOLD, 35));
        add(l2);

        table = new JTable(model) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return column == 3; // Allow editing only for the "Edit Item" column
            }
        };

        table.getColumnModel().getColumn(3).setCellRenderer(new ButtonRenderer());
        table.getColumnModel().getColumn(3).setCellEditor(new ButtonEditor(new JCheckBox()));

        table.setBounds(175, 170, 600, 200);
        table.setOpaque(false);
        table.setFont(new Font("Arial", Font.PLAIN, 20));
        table.setForeground(Color.BLACK);
        table.setBackground(new Color(0, 0, 0, 0));
        table.getTableHeader().setFont(new Font("Arial", Font.BOLD, 20));
        table.getTableHeader().setOpaque(false);
        table.getTableHeader().setBackground(new Color(0, 0, 0, 0));
        table.setRowHeight(30);

        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(175, 170, 600, 200);
        scrollPane.setBorder(BorderFactory.createEmptyBorder());
        scrollPane.setOpaque(false);
        scrollPane.getViewport().setOpaque(false);
        add(scrollPane);

    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(bg1, 0, 0, this.getWidth(), this.getHeight(), null);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == b1) {
            cart f1 = (cart) SwingUtilities.getWindowAncestor(this);
            f1.dispose();

            // Open another class here
            cuisine f2 = new cuisine();
            f2.setVisible(true);
        }
        if (e.getSource() == b2) {
            cart f1 = (cart) SwingUtilities.getWindowAncestor(this);
            f1.dispose();

            payment f2 = new payment();
            f2.setVisible(true);
        }
    }

    class ButtonRenderer extends JButton implements TableCellRenderer {

        public ButtonRenderer() {
            setOpaque(true);
        }

        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            setText((value == null) ? "" : value.toString());
            return this;
        }
    }

    class ButtonEditor extends DefaultCellEditor {

        protected JButton button;

        private String label;

        private boolean isPushed;

        public ButtonEditor(JCheckBox checkBox) {
            super(checkBox);
            button = new JButton();
            button.setOpaque(true);
            button.addActionListener(e -> fireEditingStopped());
        }

        public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
            if (isSelected) {
                button.setForeground(table.getSelectionForeground());
                button.setBackground(table.getSelectionBackground());
            } else {
                button.setForeground(table.getForeground());
                button.setBackground(UIManager.getColor("Button.background"));
            }

            label = (value == null) ? "" : value.toString();
            button.setText(label);
            isPushed = true;
            return button;
        }

        public Object getCellEditorValue() {
            if (isPushed) {
                int row = table.getEditingRow();
                int orderIdColumnIndex = 0;
                int orderId = Integer.parseInt(table.getValueAt(row, orderIdColumnIndex).toString());

                // Fetch and display order details from the database
                displayOrderDetails(orderId);
            }
            isPushed = false;
            return label;

        }
        
         private void displayOrderDetails(int orderId) {
        // Replace this with your actual database retrieval logic
        // For simplicity, I'm using a placeholder class DatabaseManager
        String[] columnNames = {"Item NO","Item Name","Quantity"};
        DefaultTableModel model = new DefaultTableModel(columnNames, 0);
        
        
        
        FetchCartAdmin fc=new FetchCartAdmin();
        fc.getTotalItems(orderId);
        fc.fetchCartDetails(orderId);
        
        
        
        for (int i = 0; i <FetchCartAdmin.c; i++) {
            Object[] Data = {
                ""
                + FetchCartAdmin.itemNo[i],
                "" + FetchCartAdmin.itemName[i],
                "" + FetchCartAdmin.quantity[i]
            };
            model.addRow(Data);
        }

        JFrame orderDetailsFrame = new JFrame("Order Details");
        orderDetailsFrame.setSize(600, 400);
        // Create the JTable with order details data
        JTable orderDetailsTable = new JTable(model);
        orderDetailsTable.setFont(new Font("Arial", Font.PLAIN, 16));

        // Add the table to a JScrollPane
        JScrollPane scrollPane = new JScrollPane(orderDetailsTable);

        // Add the scroll pane to the frame
        orderDetailsFrame.add(scrollPane);

        // Show the frame
        orderDetailsFrame.setVisible(true);
    }

        public boolean stopCellEditing() {
            isPushed = false;
            return super.stopCellEditing();
        }

        protected void fireEditingStopped() {
            super.fireEditingStopped();
        }
    }
}
