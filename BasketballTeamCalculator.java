import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BasketballTeamCalculator extends JFrame {
    private JTextField totalPlayersField;
    private JTextField playersOnCourtField;
    private JTextField resultField;

    public BasketballTeamCalculator() {
        // Πλαίσιο
        setTitle("Basketball Player Calculator");
        setSize(600, 600);
        

        // Δημιουργία του panel και του layout
        // Απίστευτα πολύ έρευνα για να καταλάβω πώς να το κάνω :΄)
        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        // Προσθήκη τίτλου
        JLabel titleLabel = new JLabel("Υπολογιστής Διαφορετικών Ομάδων Μπάσκετ", SwingConstants.CENTER);
        titleLabel.setFont(new Font(null, Font.BOLD, 16));
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        panel.add(titleLabel, gbc);

        // Προσθήκη υποτίτλου
        JLabel subtitleLabel = new JLabel("Συνολικός αριθμός διαθέσιμων παικτών ομάδας μπάσκετ", SwingConstants.CENTER);
        subtitleLabel.setFont(new Font(null, Font.PLAIN, 14));
        gbc.gridy = 1;
        panel.add(subtitleLabel, gbc);

        // Κείμενο για συνολικούς παίκτες
        gbc.gridwidth = 2;
        gbc.gridx = 0;
        gbc.gridy = 2;
        panel.add(new JLabel("Συνολικός αριθμός διαθέσιμων παικτών ομάδας μπάσκετ:", SwingConstants.CENTER), gbc);

        // Συνολικοί παίκτες
        totalPlayersField = new JTextField(10);
        gbc.gridy = 3;
        gbc.gridx= 0;
        panel.add(totalPlayersField, gbc);

        // Κείμενο για παίκτες στο παρκέ
        gbc.gridy = 4;
        panel.add(new JLabel("Αριθμός παικτών ταυτόχρονα μέσα στο παρκέ:", SwingConstants.CENTER), gbc);

        // Παίκτες στο παρκέ
        playersOnCourtField = new JTextField(10);
        gbc.gridy = 5;
        panel.add(playersOnCourtField, gbc);

        // κείμενο για το αποτέλεσμα
        gbc.gridy = 6;
        panel.add(new JLabel("Πλήθος διαφορετικών ομάδων:", SwingConstants.CENTER), gbc);

        // Αποτέλεσμα
        resultField = new JTextField(10);
        resultField.setEditable(false);
        gbc.gridy = 7;
        panel.add(resultField, gbc);

        // Κουμπί υπολογισμού
        JButton calculateButton = new JButton("Υπολογισμός");
        calculateButton.addActionListener(e -> calculateCombinations());
        gbc.gridwidth = 1;
        gbc.gridx = 0;
        gbc.gridy = 8;
        panel.add(calculateButton, gbc);

        // Κουμπί reset
        JButton resetButton = new JButton("Reset");
        resetButton.addActionListener(e -> {
            totalPlayersField.setText("");
            playersOnCourtField.setText("");
            resultField.setText("");
        });
        gbc.gridx = 1;
        panel.add(resetButton, gbc);

        // Κουμπί τερματισμού
        JButton exitButton = new JButton("Τερματισμός");
        exitButton.addActionListener(e -> System.exit(0));
        gbc.gridx = 0;
        gbc.gridy = 9;
        gbc.gridwidth = 2;
        panel.add(exitButton, gbc);

        add(panel);
    
    }

    private void calculateCombinations() {
        try {
            int n = Integer.parseInt(totalPlayersField.getText());
            int k = Integer.parseInt(playersOnCourtField.getText());
            int result = factorial(n) / (factorial(k) * factorial(n - k));
            resultField.setText(String.valueOf(result));
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Παρακαλώ εισάγετε έγκυρους αριθμούς", "Σφάλμα", JOptionPane.ERROR_MESSAGE);
        }
    }

    private int factorial(int num) {
        if (num == 0) {
            return 1;
        }
        int result = 1;
        for (int i = 1; i <= num; i++) {
            result *= i;
        }
        return result;
    }

    public static void main(String[] args) {
                new BasketballTeamCalculator().setVisible(true);

    }
}
