import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Duszki extends JFrame implements ActionListener {
    public static void main(String[] args) {
        new Duszki();
        while (true) {
            System.out.print("Unik ");
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
            }
        }
    }

    JButton buttonInfo, buttonZamknij;
    JMenuItem menuItemZamknij;

    public Duszki() {
        super("Spadające duszki");

        Image imageIconFrame = new ImageIcon(getClass().getClassLoader().getResource("img_1.png")).getImage();
        setIconImage(imageIconFrame);
        ImageIcon imageIconInfo = new ImageIcon(getClass().getClassLoader().getResource("infoin.png"));
        ImageIcon imageIconZamknij = new ImageIcon(getClass().getClassLoader().getResource("zamknijcl.png"));

        JToolBar toolBar = new JToolBar();
        buttonInfo = new JButton(imageIconInfo);
        buttonZamknij = new JButton(imageIconZamknij);
        buttonInfo.addActionListener(this);
        buttonZamknij.addActionListener(this);

        JPanel panel1 = new JPanel(new BorderLayout());

        PanelDuszki panelDuszki = new PanelDuszki();
        panel1.add(panelDuszki, BorderLayout.CENTER);

        panel1.addKeyListener(panelDuszki);
        panel1.setFocusable(true);
        panelDuszki.requestFocusInWindow();

        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocation((Toolkit.getDefaultToolkit().getScreenSize().width - getSize().width) / 2, (Toolkit.getDefaultToolkit().getScreenSize().height - getSize().height) / 2);


        panel1.add(toolBar, BorderLayout.NORTH);
        toolBar.add(buttonInfo);
        toolBar.add(buttonZamknij);

        JMenuBar jMenuBar = new JMenuBar();
        menuItemZamknij = new JMenuItem(imageIconZamknij);
        menuItemZamknij.addActionListener(this);
        JMenu menuPlik = new JMenu("Plik");
        jMenuBar.add(menuPlik);
        menuPlik.add(menuItemZamknij);
        setJMenuBar(jMenuBar);
        setContentPane(panel1);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object o = e.getSource();
        if (o == buttonInfo) {
            JOptionPane.showMessageDialog(Duszki.this, "Aplikacja o spadających duszkach. " +
                    "Można je zjadać Pacmanem. " +
                    "Stworzył Daniel");
        } else if (o == buttonZamknij || o == menuItemZamknij) {
            int nr = JOptionPane.showConfirmDialog(Duszki.this,
                    "Czy chcesz wyłączyć aplikację?", "Pytanie", JOptionPane.YES_NO_OPTION);
            if (nr == 0)
                System.exit(0);
        }
    }
}
