import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Random;

public class MainFrame extends JFrame {
    private int screenW = Toolkit.getDefaultToolkit().getScreenSize().width;
    private int screenH = Toolkit.getDefaultToolkit().getScreenSize().height;
    private int fmW=500,fmH=450;


    private JMenuBar jmb = new JMenuBar();
    private JMenu jmf = new JMenu("File");
    private JMenu jms = new JMenu("Set");
    private JMenu jmg = new JMenu("Game");
    private JMenu jma = new JMenu("About");
    private JMenuItem jmiE = new JMenuItem("Exit");
    private JMenuItem jmiG = new JMenuItem("樂透");
    private JMenuItem jmiM = new JMenuItem("亂數鍵盤");
    private JDesktopPane jdp = new JDesktopPane();
    private JInternalFrame jif = new JInternalFrame();


    private Container jifcp;
    private Container jifｍ;
    private JPanel jplm = new JPanel(new GridLayout(3,3));
    private JButton jbtns[] = new JButton[10];
    private JButton jbd = new JButton(".");
    private JButton jbc = new JButton("c");
    private JTextField jtf = new JTextField();
    private Boolean flag;
    private JPanel jplC = new JPanel(new GridLayout(1,6,3,3));
    private JLabel jlbs[] = new JLabel[6];
    private int data[] = new int[6];
    private Random ran = new Random(System.currentTimeMillis());

    private JPanel jplS = new JPanel(new GridLayout(1,2,3,3));
    private JButton jbC = new JButton("Close");
    private JButton jbG = new JButton("Generate");


    private LoginFrame loginFrame;
    public MainFrame(LoginFrame login){
        loginFrame = login;
        initComp();
    }


    private void initComp(){
        this.setBounds(screenW/2-fmW/2,screenH/2-fmH/2,fmW,fmH);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                loginFrame.reset();
                loginFrame.setVisible(true);
            }
        });
        this.setJMenuBar(jmb);
        for(int i=0;i<6;i++){
            jlbs[i] = new JLabel(Integer.toString(data[i]));
            jplC.add(jlbs[i]);
        }
        jmb.add(jmf);
        jmb.add(jms);
        jmb.add(jmg);
        jmb.add(jma);

        jmf.add(jmiE);
        jmg.add(jmiG);
        jmiE.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                System.exit(0);
            }
        });
        jmiE.setAccelerator(KeyStroke.getKeyStroke('X',Toolkit.getDefaultToolkit().getMenuShortcutKeyMask()));
        this.setContentPane(jdp);
        jif.setBounds(0,0,200,80);
        jmiG.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                jdp.add(jif);
                jif.setVisible(true);
                lotogame();
            }
        });
        jifcp.setLayout(new BorderLayout(5,5));
        jifcp.add(jplC,BorderLayout.CENTER);
        jifcp.add(jplS,BorderLayout.SOUTH);

        jplS.add(jbC);
        jplS.add(jbG);
        jbC.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                jif.dispose();
            }
        });
        jbG.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                lotogame();
            }
        });

    }
    private void lotogame(){
        int i=0;
        while (i<6){
            data[i]=ran.nextInt(42)+1;
            int j=0;
            boolean flag=true;
            while(j<1 && flag){
                if(data[i] == data[j]){
                    flag = false;
                }
                j++;
            }
            if(flag){
                jlbs[i].setText(Integer.toString(data[i]));
                i++;
            }
        }
    }
}
