import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginFrame extends JFrame {

    private Container cp;
    private JLabel jlid = new JLabel("ID:");
    private JLabel jlpw = new JLabel("password:");
    private JTextField jtfid = new JTextField();
    private JPasswordField jtfpw = new JPasswordField();
    private JButton jbexit = new JButton("Exit");
    private JButton jblogin = new JButton("Login");
    private  Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
    private int fmW=300,fmH=150,screenW,screenH;

    public LoginFrame(){
        initComp();
    }

    private void initComp(){
        screenW = dim.width;
        screenH = dim.height;
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setBounds(screenW/2-fmW/2,screenH/2-fmH/2,fmW,fmH);
        cp = this.getContentPane();
        cp.setLayout(new GridLayout(3,2,3,3));

        jlid.setHorizontalAlignment(JLabel.RIGHT);
        jlpw.setHorizontalAlignment(JLabel.RIGHT);


        jbexit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        jblogin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(jtfid.getText().equals("h304") && new String(jtfpw.getPassword()).equals("23323456")){
                    MainFrame mf = new MainFrame(LoginFrame.this);
                    mf.setVisible(true);
                    LoginFrame.this.setVisible(false);
                }else{
                    JOptionPane.showMessageDialog(LoginFrame.this,"Wrong ID or Password");
                }
            }
        });

        cp.add(jlid);
        cp.add(jtfid);
        cp.add(jlpw);
        cp.add(jtfpw);
        cp.add(jbexit);
        cp.add(jblogin);

    }
    public void reset(){
        jtfid.setText("");
        jtfpw.setText("");
    }
}
