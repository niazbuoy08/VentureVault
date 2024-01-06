import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import com.toedter.calendar.JDateChooser;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;


public class Signup1 extends JFrame implements ActionListener {

    private JRadioButton male, female, others, married, unmarried;
    private JButton backButton, nextButton;

    private long random;

    private JTextField nameTextField, fnameTextField, mnameTextField, emailTextField, addressTextField;
    private JDateChooser dateChooser;

    public Signup1() {
        setLayout(new BorderLayout());

        JLabel formNoLabel = new JLabel("APPLICATION FORM NO " + random);
        formNoLabel.setFont(new Font("Raleway", Font.BOLD, 20));
        formNoLabel.setHorizontalAlignment(SwingConstants.CENTER);
        add(formNoLabel, BorderLayout.NORTH);


        JPanel formPanel = new JPanel();
        formPanel.setLayout(new GridLayout(10, 2));

        formPanel.add(new JLabel("Name:"));
        nameTextField = new JTextField();
        formPanel.add(nameTextField);

        formPanel.add(new JLabel("Father's Name:"));
        fnameTextField = new JTextField();
        formPanel.add(fnameTextField);

        formPanel.add(new JLabel("Mother's Name:"));
        mnameTextField = new JTextField();
        formPanel.add(mnameTextField);

        formPanel.add(new JLabel("Date of Birth:"));
        dateChooser = new JDateChooser();
        formPanel.add(dateChooser);

        formPanel.add(new JLabel("Gender:"));
        male = new JRadioButton("Male");
        female = new JRadioButton("Female");
        others = new JRadioButton("Others");

        ButtonGroup genderGroup = new ButtonGroup();
        genderGroup.add(male);
        genderGroup.add(female);
        genderGroup.add(others);

        JPanel genderPanel = new JPanel();
        genderPanel.add(male);
        genderPanel.add(female);
        genderPanel.add(others);
        formPanel.add(genderPanel);

        formPanel.add(new JLabel("E-Mail:"));
        emailTextField = new JTextField();
        formPanel.add(emailTextField);

        formPanel.add(new JLabel("Marital Status:"));
        married = new JRadioButton("Married");
        unmarried = new JRadioButton("Unmarried");

        ButtonGroup maritalgroup = new ButtonGroup();
        maritalgroup.add(married);
        maritalgroup.add(unmarried);

        JPanel maritalPanel = new JPanel();
        maritalPanel.add(married);
        maritalPanel.add(unmarried);
        formPanel.add(maritalPanel);

        formPanel.add(new JLabel("Current Address:"));
        addressTextField = new JTextField();
        formPanel.add(addressTextField);

        add(formPanel, BorderLayout.CENTER);

        nextButton = new JButton("Next");
        nextButton.setBackground(Color.lightGray);
        nextButton.setFont(new Font("Raleway", Font.BOLD, 16));
        nextButton.addActionListener(this);
        add(nextButton, BorderLayout.SOUTH);

        backButton = new JButton("Back");
        backButton.setBackground(Color.lightGray);
        backButton.setFont(new Font("Raleway", Font.BOLD, 16));
        backButton.addActionListener(this);
        add(backButton, BorderLayout.WEST);



        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == backButton) {
            LoginPage loginPage = new LoginPage();
            loginPage.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            dispose();
        } else if (ae.getSource() == nextButton) {

            if (validateInputs()) {
                insertDataIntoDatabase(
                        nameTextField.getText(),
                        fnameTextField.getText(),
                        mnameTextField.getText(),
                        dateChooser.getDate(),
                        getSelectedGender(),
                        emailTextField.getText(),
                        getMaritalStatus(),
                        addressTextField.getText()
                );
            }
        }
    }

    private boolean validateInputs() {
        if (nameTextField.getText().isEmpty() || fnameTextField.getText().isEmpty() ||
                mnameTextField.getText().isEmpty() || dateChooser.getDate() == null ||
                getSelectedGender() == null || emailTextField.getText().isEmpty() ||
                getMaritalStatus() == null || addressTextField.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please fill in all fields.", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        return true;
    }

    private String getSelectedGender() {
        if (male.isSelected()) {
            return "Male";
        } else if (female.isSelected()) {
            return "Female";
        } else if (others.isSelected()) {
            return "Others";
        } else {
            return null;
        }
    }

    private String getMaritalStatus() {
        if (married.isSelected()) {
            return "Married";
        } else if (unmarried.isSelected()) {
            return "Unmarried";
        } else {
            return null;
        }
    }

    private void insertDataIntoDatabase(String name, String fatherName, String motherName,
                                        Date dob, String gender, String email, String maritalStatus, String address) {
        try (Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "BankUser", "niaz081210")) {
            // Use the next value from the sequence for the form number
            String sql = "INSERT INTO USER_INFO (FORM_NO, NAME, FATHER_NAME, MOTHER_NAME, DOB, GENDER, EMAIL, MARITAL_STATUS, ADDRESS) " +
                    "VALUES (form_number_seq.NEXTVAL, ?, ?, ?, TO_DATE(?, 'YYYY-MM-DD'), ?, ?, ?, ?)";

            try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                preparedStatement.setString(1, name);
                preparedStatement.setString(2, fatherName);
                preparedStatement.setString(3, motherName);

                // Convert java.util.Date to java.sql.Date
                java.sql.Date sqlDate = new java.sql.Date(dob.getTime());
                preparedStatement.setDate(4, sqlDate);

                preparedStatement.setString(5, gender);
                preparedStatement.setString(6, email);
                preparedStatement.setString(7, maritalStatus);
                preparedStatement.setString(8, address);

                int rowsAffected = preparedStatement.executeUpdate();
                if (rowsAffected > 0) {
                    JOptionPane.showMessageDialog(this, "Data inserted into database successfully!");
                } else {
                    JOptionPane.showMessageDialog(this, "No rows were affected. Data not inserted.");
                }
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error inserting data into database: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }


}

