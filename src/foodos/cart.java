package foodos;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.table.*;

public class cart extends JFrame {

    P6demo f1;

    cart() {
        super("Cart");
        setBounds(100, 100, 950, 600);
        setResizable(false);
        setLocationRelativeTo(null);
        f1 = new P6demo();
        add(f1);
    }

    public static void main(String[] args) {
        cart f1 = new cart();
        f1.setVisible(true);
        f1.setDefaultCloseOperation(f1.EXIT_ON_CLOSE);
    }

}

class P6demo extends JPanel implements ActionListener {

    ImageIcon img1;
    Image bg1;
    JButton b1, b2;
    JLabel l1, l2, l3, l4;
    DefaultTableModel model;
    static JTable table;
    int  x = 0;
    P6demo() {
        setLayout(null);
        Font f = new Font("Georgia", Font.BOLD, 13);

        img1 = new ImageIcon(ClassLoader.getSystemResource("foodos/image/cart.jpg"));
        bg1 = img1.getImage();

        int sum = 0;
        String[] columnNames = {"Item no.", "Item Name", "Quantity", "Price", "Amount", "Edit Item"};
        model = new DefaultTableModel(columnNames, 0);

        for (int i = 0; i < login.totalItem; i++) {
            String[] rowData = {
                "" + (i + 1),
                FetchCart.itemName[i],
                "" + FetchCart.quantity[i],
                "" + FetchCart.price[i],
                "" + (FetchCart.quantity[i] * FetchCart.price[i]),
                "Edit"
            };
            model.addRow(rowData);
            sum += Integer.parseInt(rowData[4]);
        }

        if (login.totalItem < 6) {
            x = login.totalItem;
        } else {
            x = 6;
        }

        l1 = new JLabel("Amount: " + sum);
        l1.setBounds(500, (200 + 30 * x), 300, 30);
        l1.setFont(new Font("Arial", Font.BOLD, 20));
        add(l1);

        l3 = new JLabel("GST: " + (sum * 18) / 100);;
        l3.setBounds(530, (230 + 30 * x), 300, 30);
        l3.setFont(new Font("Arial", Font.BOLD, 20));
        add(l3);
        l4 = new JLabel("Total Amount: " + (sum + (sum * 18) / 100));
        l4.setBounds(450, (260 + 30 * x), 300, 30);
        l4.setFont(new Font("Arial", Font.BOLD, 20));
        add(l4);

        l2 = new JLabel("Your Cart");
        l2.setBounds(380, 50, 250, 30);
        l2.setFont(new Font("Algerian", Font.BOLD, 35));
        add(l2);

        b1 = new JButton("Back");
        b1.setBounds(30, 500, 100, 30);
        b1.setBackground(Color.white);
        b1.setFont(f);
        b1.addActionListener(this);
        add(b1);

        b2 = new JButton("Place order");
        b2.setBounds(800, 500, 120, 30);
        b2.setBackground(Color.white);
        b2.setFont(f);
        b2.addActionListener(this);
        add(b2);

        table = new JTable(model) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return column == 5; // Allow editing only for the "Edit Item" column
            }
        };

        table.getColumnModel().getColumn(5).setCellRenderer(new ButtonRenderer());
        table.getColumnModel().getColumn(5).setCellEditor(new ButtonEditor(new JCheckBox()));

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
                int selectedRow = table.getSelectedRow();
                if (selectedRow >= 0 && selectedRow < table.getRowCount()) {

                    String itemName = (String) table.getValueAt(selectedRow, 1);

                    // Create a dialog to input the new quantity
                    String newQuantityStr = JOptionPane.showInputDialog(table, "Enter new quantity for " + itemName, "Update Quantity", JOptionPane.PLAIN_MESSAGE);
                    if (newQuantityStr != null) {
                        try {
                            int newQuantity = Integer.parseInt(newQuantityStr);
                            UpdateCart uc = new UpdateCart();
                            if (newQuantity == 0) {
                                // Delete the row
                                DefaultTableModel model = (DefaultTableModel) table.getModel();
                                model.removeRow(selectedRow);
                                uc.updateTable(login.orderId, itemName, 0);
                                x--;
                            } else {
                                // Update the SQL table here with the new quantity
                                // You need to implement the database update logic

                                // Update the table model
                                if (selectedRow >= 0 && selectedRow < table.getRowCount()) {
                                    table.setValueAt("" + newQuantity, selectedRow, 2);
                                    int price = Integer.parseInt((String) table.getValueAt(selectedRow, 3));
                                    table.setValueAt("" + (newQuantity * price), selectedRow, 4);

                                    // Recalculate the total sum
                                    uc.updateTable(login.orderId, itemName, newQuantity);

                                }
                            }
                            int sum = 0;
                            for (int row = 0; row < table.getRowCount(); row++) {
                                sum += Integer.parseInt((String) table.getValueAt(row, 4));
                            }

                            // Update the "Total Amount" label
                            l1.setText("Total Amount: " + sum);
                            l1.setBounds(500, (200 + 30 * x), 300, 30);
                            l3.setText("GST: " + (sum * 18) / 100);;
                            l3.setBounds(530, (230 + 30 * x), 300, 30);
                            l4.setText("Total Amount: " + (sum + (sum * 18) / 100));
                            l4.setBounds(450, (260 + 30 * x), 300, 30);

                            uc.close();
                            SwingUtilities.getWindowAncestor(table).revalidate();
                            SwingUtilities.getWindowAncestor(table).repaint();
                        } catch (NumberFormatException e) {
                            JOptionPane.showMessageDialog(table, "Invalid quantity input. Please enter a valid number.", "Error", JOptionPane.ERROR_MESSAGE);
                        }
                    }
                }
            }
            isPushed = false;
            return label;
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
