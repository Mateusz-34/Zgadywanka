import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class ZgadywankaGui {
    private JButton wylosujLiczbeButton;
    private JPanel glowny;
    private JButton sprawdzButton;
    private JPanel gorny;
    private JPanel srodkowy1;
    private JPanel srodkowy3;
    private JPanel srodkowy2;
    private JLabel napis;
    private JTextField textField1;
    private JPanel dolny;
    private JLabel wynik;
    private JLabel iloscProb;

    private int wylosowanaLiczba;
    private int iloscprob = 0;

    public ZgadywankaGui() {
        wylosujLiczbeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Random random = new Random();

                wylosowanaLiczba = random.nextInt(127) + 1;
                napis.setText("Liczba wylosowana. Odgadnij te liczbe ");
                napis.setVisible(true);
                textField1.setVisible(true);
                sprawdzButton.setVisible(true);
            }
        });
        sprawdzButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int wpisanaLiczba = Integer.parseInt(textField1.getText());

                if (wpisanaLiczba == wylosowanaLiczba){
                    wynik.setText("Trafiles");
                } else if (wpisanaLiczba > wylosowanaLiczba){
                    wynik.setText("Podales za duza liczbe");
                } else if (wpisanaLiczba < wylosowanaLiczba) {
                    wynik.setText("Podales za mala liczbe");
                }
                iloscProb.setText("Proba: " + iloscprob++);
                wynik.setVisible(true);
                iloscProb.setVisible(true);
            }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("ZgadywankaGui");
        frame.setContentPane(new ZgadywankaGui().glowny);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setSize(600, 500);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
