import java.awt.*;
import javax.swing.*;
import java.util.Random;
import com.toedter.calendar.JDateChooser;

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
        name.setFont(new Font("Raleway", Font.BOLD, 22));
        name.setBounds(200, 160, 100, 30);
        add(name);

        JTextField nameTextField = new JTextField();
        nameTextField.setFont(new Font("Raleways",Font.BOLD,14));
        nameTextField.setBounds(400,160,400,30);
        add(nameTextField);

        JLabel fname = new JLabel("Father's Name:");
        fname.setFont(new Font("Raleway", Font.BOLD, 22));
        fname.setBounds(200, 205, 400, 30);
        add(fname);

        JTextField fnameTextField = new JTextField();
        fnameTextField.setFont(new Font("Raleways",Font.BOLD,14));
        fnameTextField.setBounds(400,205,400,30);
        add(fnameTextField);


        JLabel mname = new JLabel("Mother's Name:");
        mname.setFont(new Font("Raleway", Font.BOLD, 22));
        mname.setBounds(200, 250, 400, 30);
        add(mname);

        JTextField mnameTextField = new JTextField();
        mnameTextField.setFont(new Font("Raleways",Font.BOLD,14));
        mnameTextField.setBounds(400,250,400,30);
        add(mnameTextField);


        JLabel dob = new JLabel("Date of Birth:");
        dob.setFont(new Font("Raleway", Font.BOLD, 22));
        dob.setBounds(200, 300, 400, 30);
        add(dob);

        JDateChooser dateChooser = new JDateChooser();
        dateChooser.setBounds(400,300,400,30);
        add(dateChooser);

        JLabel gender = new JLabel("Gender:");
        gender.setFont(new Font("Raleway", Font.BOLD, 22));
        gender.setBounds(200, 350, 400, 30);
        add(gender);

        JLabel email = new JLabel("E-Mail:");
        email.setFont(new Font("Raleway", Font.BOLD, 22));
        email.setBounds(200, 400, 400, 30);
        add(email);

        JTextField emailTextField = new JTextField();
        emailTextField.setFont(new Font("Raleways",Font.BOLD,14));
        emailTextField.setBounds(400,400,400,30);
        add(emailTextField);


        JLabel mstatus = new JLabel("Marital Status:");
        mstatus.setFont(new Font("Raleway", Font.BOLD, 22));
        mstatus.setBounds(200, 450, 400, 30);
        add(mstatus);

        JLabel address = new JLabel("Current Address:");
        address.setFont(new Font("Raleway", Font.BOLD, 22));
        address.setBounds(200, 500, 400, 30);
        add(address);

        JTextField addressTextField = new JTextField();
        addressTextField.setFont(new Font("Raleways",Font.BOLD,14));
        addressTextField.setBounds(400,500,400,30);
        add(addressTextField);


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
