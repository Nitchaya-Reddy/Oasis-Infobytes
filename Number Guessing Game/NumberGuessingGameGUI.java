import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

public class NumberGuessingGameGUI extends JFrame {
    private JTextField guessTextField;
    private JLabel resultLabel;
    private JButton guessButton;
    private JButton resetButton;
    private int targetNumber;
    private int attempts;

    public NumberGuessingGameGUI() {
        setTitle("Number Guessing Game");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new FlowLayout());

        guessTextField = new JTextField(10);
        add(guessTextField);

        guessButton = new JButton("Guess");
        guessButton.addActionListener(new GuessButtonListener());
        add(guessButton);

        resetButton = new JButton("Reset");
        resetButton.addActionListener(new ResetButtonListener());
        add(resetButton);

        resultLabel = new JLabel("Guess a number!");
        add(resultLabel);

        setVisible(true);

        resetGame();
    }

    private void resetGame() {
        Random random = new Random();
        targetNumber = random.nextInt(100) + 1;
        attempts = 0;
        resultLabel.setText("Guess a number!");
        guessTextField.setText("");
        guessTextField.requestFocus();
    }

    private class GuessButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                int guess = Integer.parseInt(guessTextField.getText());
                attempts++;

                if (guess == targetNumber) {
                    resultLabel.setText("Congratulations! You guessed it right in " + attempts + " attempts.");
                    guessButton.setEnabled(false);
                } else if (guess < targetNumber) {
                    resultLabel.setText("Too low! Try again.");
                } else {
                    resultLabel.setText("Too high! Try again.");
                }
            } catch (NumberFormatException ex) {
                resultLabel.setText("Invalid input! Please enter a number.");
            } finally {
                guessTextField.setText("");
                guessTextField.requestFocus();
            }
        }
    }

    private class ResetButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            guessButton.setEnabled(true);
            resetGame();
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(NumberGuessingGameGUI::new);
    }
}
