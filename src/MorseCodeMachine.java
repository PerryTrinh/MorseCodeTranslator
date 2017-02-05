import java.awt.*;
import java.awt.event.*;

/**
 * Created by Perry on 2/4/2017.
 */
public class MorseCodeMachine extends Frame{
    private TextField inputField;
    private TextArea outputField;

    public MorseCodeMachine() {
        Panel panelDisplay = new Panel(new FlowLayout());
        inputField = new TextField("", 20);
        panelDisplay.add(inputField);

        outputField = new TextArea(5,40);
        outputField.setEditable(false);
        panelDisplay.add(outputField);

        Panel buttonsDisplay = new Panel(new GridLayout(1, 2, 5, 5));

        Button toMorse = new Button("Translate to Morse");
        Button toEnglish = new Button("Translate to English");
        ButtonListener listener = new ButtonListener();
        toMorse.addActionListener(listener);
        toEnglish.addActionListener(listener);

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


        int windowWidth = 600;
        int windowHeight = 350;
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
                System.out.println("Please enter something in the box.");
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