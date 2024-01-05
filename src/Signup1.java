import java.awt.*;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.util.Random;

public class Signup1 extends JFrame {

    public Signup1() {

        setLayout(null);

        Random ran = new Random();
        long random = Math.abs(ran.nextLong());

        JLabel formNo = new JLabel("APPLICATION FORM NO " + random);
        formNo.setFont(new Font("Raleway", Font.BOLD, 38));
        formNo.setBounds(240, 10, 800, 40);
        add(formNo);

        JLabel PersonalDetails = new JLabel("Personal Details");
        PersonalDetails.setFont(new Font("Raleway", Font.BOLD, 28));
        PersonalDetails.setBounds(500, 60, 500, 30);
        add(PersonalDetails);

        JLabel name = new JLabel("Name:");
        name.setFont(new Font("Raleway", Font.BOLD, 28));
        name.setBounds(200, 160, 100, 30);
        add(name);

        // Get the screen size
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int screenWidth = (int) screenSize.getWidth();
        int screenHeight = (int) screenSize.getHeight();

        setSize(screenWidth, screenHeight);
        setLocationRelativeTo(null); // Center the frame on the screen

        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setVisible(true);
    }
}
