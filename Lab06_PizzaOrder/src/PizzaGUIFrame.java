import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PizzaGUIFrame extends JFrame {
    private JRadioButton thinCrustRadio, regularCrustRadio, deepDishCrustRadio;
    private JComboBox<String> sizeComboBox;
    private JCheckBox[] toppingsCheckBoxes;
    private JTextArea orderTextArea;

    public PizzaGUIFrame() {
        // Set up the main frame
        setTitle("Pizza Order");
        setSize(500, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Create the panels for different components
        JPanel crustPanel = createCrustPanel();
        JPanel sizePanel = createSizePanel();
        JPanel toppingsPanel = createToppingsPanel();
        JPanel orderPanel = createOrderPanel();
        JPanel buttonPanel = createButtonPanel();

        // Set the layout for the main frame
        setLayout(new BorderLayout());

        // Add panels to the main frame
        add(crustPanel, BorderLayout.WEST);
        add(sizePanel, BorderLayout.CENTER);
        add(toppingsPanel, BorderLayout.EAST);
        add(orderPanel, BorderLayout.NORTH);
        add(buttonPanel, BorderLayout.SOUTH);
    }

    private JPanel createCrustPanel() {
        // Create a JPanel for crust selection
        JPanel crustPanel = new JPanel();
        crustPanel.setBorder(BorderFactory.createTitledBorder("Crust Type"));
        thinCrustRadio = new JRadioButton("Thin");
        regularCrustRadio = new JRadioButton("Regular");
        deepDishCrustRadio = new JRadioButton("Deep-dish");

        // Add radio buttons to a ButtonGroup
        ButtonGroup crustGroup = new ButtonGroup();
        crustGroup.add(thinCrustRadio);
        crustGroup.add(regularCrustRadio);
        crustGroup.add(deepDishCrustRadio);

        // Add radio buttons to the panel
        crustPanel.add(thinCrustRadio);
        crustPanel.add(regularCrustRadio);
        crustPanel.add(deepDishCrustRadio);

        return crustPanel;
    }

    private JPanel createSizePanel() {
        // Create a JPanel for size selection
        JPanel sizePanel = new JPanel();
        sizePanel.setBorder(BorderFactory.createTitledBorder("Pizza Size"));
        String[] sizes = {"Small", "Medium", "Large", "Super"};
        sizeComboBox = new JComboBox<>(sizes);

        sizePanel.add(sizeComboBox);

        return sizePanel;
    }

    private JPanel createToppingsPanel() {
        // Create a JPanel for toppings selection
        JPanel toppingsPanel = new JPanel();
        toppingsPanel.setBorder(BorderFactory.createTitledBorder("Toppings"));
        String[] toppingNames = {"Cheese", "Pepperoni", "Mushrooms", "Bacon", "Olives", "Pineapple"};
        toppingsCheckBoxes = new JCheckBox[toppingNames.length];

        for (int i = 0; i < toppingNames.length; i++) {
            toppingsCheckBoxes[i] = new JCheckBox(toppingNames[i]);
            toppingsPanel.add(toppingsCheckBoxes[i]);
        }

        return toppingsPanel;
    }

    private JPanel createOrderPanel() {
        // Create a JPanel for displaying the order using JTextArea
        JPanel orderPanel = new JPanel();
        orderPanel.setBorder(BorderFactory.createTitledBorder("Order Details"));
        orderTextArea = new JTextArea(10, 40);
        orderTextArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(orderTextArea);

        orderPanel.add(scrollPane);

        return orderPanel;
    }

    private JPanel createButtonPanel() {
        // Create a JPanel for Order, Clear, and Quit buttons
        JPanel buttonPanel = new JPanel();
        JButton orderButton = new JButton("Order");
        JButton clearButton = new JButton("Clear");
        JButton quitButton = new JButton("Quit");

        orderButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Handle the order button click and display the order details in the JTextArea
                displayOrder();
            }
        });

        clearButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Handle the clear button click to reset the form
                clearForm();
            }
        });

        quitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Handle the quit button click with confirmation dialog
                int choice = JOptionPane.showConfirmDialog(PizzaGUIFrame.this,
                        "Are you sure you want to quit?",
                        "Quit Confirmation",
                        JOptionPane.YES_NO_OPTION);

                if (choice == JOptionPane.YES_OPTION) {
                    System.exit(0);
                }
            }
        });

        buttonPanel.add(orderButton);
        buttonPanel.add(clearButton);
        buttonPanel.add(quitButton);

        return buttonPanel;
    }

    private void displayOrder() {
        // Implement the logic to display the order details in the JTextArea
        // Calculate the total and tax based on user selections
    }

    private void clearForm() {
        // Implement the logic to clear all selections in the form
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            PizzaGUIFrame frame = new PizzaGUIFrame();
            frame.setVisible(true);
        });
    }
}
