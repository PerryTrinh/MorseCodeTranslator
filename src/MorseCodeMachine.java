import java.awt.*;
import java.awt.event.*;

/**
 * Created by Perry on 2/4/2017.
 */
public class MorseCodeMachine extends Frame{
    private TextField inputField;
    private TextArea outputField;
    private Button toMorse;
    private Button toEnglish;
    private final int WINDOWWIDTH = 500;
    private final int WINDOWHEIGHT = 250;

    public MorseCodeMachine() {
        Panel panelDisplay = new Panel(new FlowLayout());
        inputField = new TextField("", 20);
        panelDisplay.add(inputField);

        outputField = new TextArea(5,40);
        outputField.setEditable(false);
        panelDisplay.add(outputField);

        Panel buttonsDisplay = new Panel(new GridLayout(1, 2, 5, 5));

        toMorse = new Button("Translate to Morse");
        toEnglish = new Button("Translate to English");
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

        setTitle("Morse Code Machine");
        setSize(WINDOWWIDTH, WINDOWHEIGHT);

        //Puts window in middle of screen
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (dim.width - WINDOWWIDTH)/2;
        int y = (dim.height - WINDOWHEIGHT)/2;

        setLocation(x, y);
        setVisible(true);
    }

    public static void main(String[] args) {
        new MorseCodeMachine();
    }

    private class ButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
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
