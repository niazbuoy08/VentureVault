import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class LoginPage extends JFrame implements ActionListener {

    JButton clear,signin,signup;
    JTextField cardTextField,pinfield;
    public LoginPage() {
        setTitle("Online Bank Management System");


        ImageIcon originalIcon = new ImageIcon("C:\\Users\\User\\Downloads\\Untitled design (9).png");


        int screenWidth = Toolkit.getDefaultToolkit().getScreenSize().width;
        int screenHeight = Toolkit.getDefaultToolkit().getScreenSize().height;
        int maxScaledWidth = 500;
        int maxScaledHeight = 300;


        int scaledWidth = Math.min(maxScaledWidth, originalIcon.getIconWidth());
        int scaledHeight = Math.min(maxScaledHeight, originalIcon.getIconHeight());


        Image scaledImage = originalIcon.getImage().getScaledInstance(scaledWidth, scaledHeight, Image.SCALE_SMOOTH);
        ImageIcon scaledIcon = new ImageIcon(scaledImage);


        JLabel label = new JLabel(scaledIcon);


        setLayout(null);


        int verticalShift = 150;
        int horizontalShift = 150;
        label.setBounds(horizontalShift, verticalShift, scaledWidth, scaledHeight);


        add(label);


        setSize(screenWidth, screenHeight);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);

        JLabel text = new JLabel("Welcome to Venture Vault");
        text.setFont(new Font("Osward",Font.BOLD,38));
        text.setBounds(430,60,800,60);
        add(text);

        JLabel cardno = new JLabel("Card No:");
        cardno.setFont(new Font("Raleway",Font.BOLD,30));
        cardno.setBounds(670, 250,400,40);
        add(cardno);

        cardTextField = new JTextField();
        cardTextField.setBounds(800,250, 300, 40);
        add(cardTextField);

        JLabel pin = new JLabel("PIN:");
        pin.setFont(new Font("Raleway",Font.BOLD,30));
        pin.setBounds(670, 320,400,40);
        add(pin);

        pinfield = new JTextField();
        pinfield.setBounds(800,320, 300, 40);
        add(pinfield);

        signin = new JButton("SIGN IN");
        signin.setBounds(800,380,100,30);
        signin.addActionListener(this);
        add(signin);


        clear = new JButton("CLEAR");
        clear.setBounds(950,380,100,30);
        clear.addActionListener(this);
        add(clear);

        signup = new JButton("SIGNUP");
        signup.setBounds(880,430,100,30);
        signup.addActionListener(this);
        add(signup);
    }

    public void actionPerformed(ActionEvent ae)
    {
        if(ae.getSource()==clear)
        {
            cardTextField.setText("");
            pinfield.setText("");

        }else if(ae.getSource()==signin)
        {

        } else if (ae.getSource()==signup)
        {
            Signup1 signupPage = new Signup1();
            signupPage.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // Close only the signup page, not the login page
            dispose();
        }
    }

}


