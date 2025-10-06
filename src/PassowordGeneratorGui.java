import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PassowordGeneratorGui extends JFrame {
    private PassowordGenerator passowordGenerator;
    public PassowordGeneratorGui(){
        super("Passoword Generator");

        setSize(540,570);

        setResizable(false);

        setLayout(null);

        setDefaultCloseOperation(EXIT_ON_CLOSE);

        setLocationRelativeTo(null);

        passowordGenerator = new PassowordGenerator();

        addGuiComponents();
    }
    private  void addGuiComponents(){
        JLabel titleLabel = new JLabel("Passoword Generator");

        titleLabel.setFont(new Font("Dialog",Font.BOLD,32));

        titleLabel.setBounds(0,10,540,39);

        add(titleLabel);


        JTextArea passowordOutput = new JTextArea();

        passowordOutput.setEditable(false);
        passowordOutput.setFont(new Font("Dialog",Font.BOLD,32));

        JScrollPane passowordOutputPane = new JScrollPane(passowordOutput);

        passowordOutputPane.setBounds(25,97,479,70);

        passowordOutputPane.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        add(passowordOutputPane);

        JLabel passowordLength = new JLabel("Passoword Length");
        passowordLength.setFont(new Font("Dialog",Font.BOLD,32));
        passowordLength.setBounds(25,215,272,39);
        add(passowordLength);

        JTextArea passowordLengthInputArea = new JTextArea();
        passowordLengthInputArea.setFont(new Font("Dialog",Font.PLAIN,32));
        passowordLengthInputArea.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        passowordLengthInputArea.setBounds(310,215,192,39);
        add(passowordLengthInputArea);


        JToggleButton uppercaseToggle = new JToggleButton("Uppercase");
        uppercaseToggle.setFont(new Font("Dialog",Font.PLAIN,26));
        uppercaseToggle.setBounds(25,302,225,56);
        add(uppercaseToggle);

        JToggleButton lowercaseToggle = new JToggleButton("Lowercase");
        lowercaseToggle.setFont(new Font("Dialog",Font.PLAIN,26));
        lowercaseToggle.setBounds(282,302,225,56);
        add(lowercaseToggle);

        JToggleButton numbersToggle = new JToggleButton("Numbers");
        numbersToggle.setFont(new Font("Dialog",Font.PLAIN,26));
        numbersToggle.setBounds(25,373,225,56);
        add(numbersToggle);

        JToggleButton symbolsToggle = new JToggleButton("Symbols");
        symbolsToggle.setFont(new Font("Dialog",Font.PLAIN,26));
        symbolsToggle.setBounds(282,382,225,56);
        add(symbolsToggle);


        JButton generateButton = new JButton("Generate");
        generateButton.setFont(new Font("Dialog",Font.PLAIN,32));
        generateButton.setBounds(155,477,222,41);
        generateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(passowordLengthInputArea.getText().length() <= 0) return;
                boolean anyToggleSelected = lowercaseToggle.isSelected() || uppercaseToggle.isSelected() || numbersToggle.isSelected() || symbolsToggle.isSelected();
                int passowordLength = Integer.parseInt(passowordLengthInputArea.getText());
                if(anyToggleSelected){
                    String generatePassoword = passowordGenerator.generatePassoword(passowordLength,uppercaseToggle.isSelected(),lowercaseToggle.isSelected(),numbersToggle.isSelected(),symbolsToggle.isSelected());
                    passowordOutput.setText(generatePassoword);
                }
            }
        });
        add(generateButton);

    }
}
