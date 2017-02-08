import java.awt.*;
import java.awt.event.*;

/**
 * Created by Perry on 2/4/2017.
 */
public class MorseCodeMachine extends Frame{
    private TextArea inputField;
    private TextArea outputField;

    public MorseCodeMachine() {
        Font uniform = new Font("Times New Roman", Font.PLAIN, 25);

        Panel panelDisplay = new Panel(new FlowLayout());
        inputField = new TextArea(4, 30);
        inputField.setFont(uniform);
        panelDisplay.add(inputField);

        outputField = new TextArea(4,30);
        outputField.setEditable(false);
        outputField.setFont(uniform);
        panelDisplay.add(outputField);

        Panel buttonsDisplay = new Panel(new GridLayout(1, 2, 5, 5));

        Button toMorse = new Button("Translate to Morse");
        Button toEnglish = new Button("Translate to English");
        ButtonListener listener = new ButtonListener();
        toMorse.addActionListener(listener);
        toEnglish.addActionListener(listener);

        toMorse.setFont(uniform);
        toEnglish.setFont(uniform);

        buttonsDisplay.add(toMorse);
        buttonsDisplay.add(toEnglish);

        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });

        setLayout(new BorderLayout());
        add(panelDisplay, BorderLayout.NORTH);
        add(buttonsDisplay, BorderLayout.CENTER);

        int windowWidth = 950;
        int windowHeight = 300;
        setTitle("Morse Code Machine");
        setSize(windowWidth, windowHeight);

        //Puts window in middle of screen
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (dim.width - windowWidth)/2;
        int y = (dim.height - windowHeight)/2;

        setLocation(x, y);
        setVisible(true);
    }

    public static void main(String[] args) {
        new MorseCodeMachine();
    }

    private class ButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (inputField.getText().equals("")) {
                outputField.setText("Please enter something in the \nbox to the left.");
                return;
            }

            Translator translator = new Translator();
            String symbol = ((Button) e.getSource()).getLabel();
            String input = inputField.getText();

            if (symbol.equals("Translate to Morse")) {
                outputField.setText(translator.translate(input, "morse"));
            } else {
                outputField.setText(translator.translate(input, "english"));
            }

            inputField.setText("");
        }
    }
}