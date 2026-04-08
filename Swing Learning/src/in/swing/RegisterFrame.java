package in.swing;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class RegisterFrame implements ActionListener {

	//create window for register --> designing
	
	JFrame jf;
	JLabel nameLabel,emailLabel,genderLabel,passwordLabel,j1,cityLabel;
	JPasswordField passwordField;
	JTextField nameField,emailField;
	JComboBox<String> cityField;
	JRadioButton male,female;
	ButtonGroup bg;
	JButton Submit,Cancel;
	
		public void createFrame(){
			
			jf = new JFrame();
			jf.setTitle("Registration Form");
			jf.setLocationRelativeTo(null);
			jf.setSize(600,400);
			jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			jf.setLayout(null);
			
			//title
			j1 = new JLabel("Register Here");
			j1.setBounds(250,20,100,30);
			jf.add(j1);
			
			//name
			nameLabel = new JLabel("Enter Name : ");
			nameLabel.setBounds(50,50,100,30);
			jf.add(nameLabel);
			
			nameField = new JTextField();
			nameField.setBounds(200,50,250,30);
			jf.add(nameField);
			
			//emailLabel
			emailLabel = new JLabel("Enter Email : ");
			emailLabel.setBounds(50,90,100,30);
			jf.add(emailLabel);
			
			
			emailField = new JTextField();
			emailField.setBounds(200,90,250,30);
			jf.add(emailField);
			
			//passwordLabel JpasswordFieldield
			passwordLabel = new JLabel("Enter Password : ");
			passwordLabel.setBounds(50,130,100,30);
			jf.add(passwordLabel);
			
			passwordField = new JPasswordField();
			passwordField.setBounds(200,130,250,30);
			jf.add(passwordField);
			
			//genderLabel JRadioButton
			
			genderLabel = new JLabel("Enter Gender : ");
			genderLabel.setBounds(50,170,100,30);
			jf.add(genderLabel);
			
			male = new JRadioButton("Male");
			male.setBounds(200,170,100,30);
			jf.add(male);
			
			female = new JRadioButton("Female");
			female.setBounds(350,170,100,30);
			jf.add(female);
			
			//combining radio buttons
			bg = new ButtonGroup();
			bg.add(male);
			bg.add(female);
			
			//cityLabel JComboBox<e>
			
			cityLabel = new JLabel("Enter City : ");
			cityLabel.setBounds(50,210,100,30);
			jf.add(cityLabel);
			
			cityField = new JComboBox<String>();
			cityField.addItem("Pune");
			cityField.addItem("Nashik");
			cityField.addItem("Mumbai");

			
			cityField.setBounds(200,210,250,30);
			jf.add(cityField);
			
			//submit button
			Submit = new JButton("Submit");
			Submit.addActionListener(this);
			Submit.setBounds(200,250,100,40);
//			Submit.setEnabled(false);
			jf.add(Submit);
			
			//Cancel button
			Cancel = new JButton("Cancel");
			Cancel.addActionListener(this);
			Cancel.setBounds(350,250,100,40);
			jf.add(Cancel);
					
			jf.setVisible(true);
		}
		
		//clearing fields
		void clearFields() {
			nameField.setText(null);
			emailField.setText(null);
			passwordField.setText(null);
			male.setSelected(false);
			female.setSelected(false);
		}
		
		//validate fun
		void validateAndSubmit() {
			String password = new String(passwordField.getPassword());
			if(nameField.getText().trim().equals("")) {
				JOptionPane.showMessageDialog(jf, "Name field can't be Vacant");
				return;
			}
			else if(!emailField.getText().contains("@")) {
			    JOptionPane.showMessageDialog(jf, "Invalid Email");
			    return;
			}
			else if(password.length() < 6 ) {
				JOptionPane.showMessageDialog(Submit, "Password must be at least 6 characters");
				return;
			}else if(!male.isSelected() && !female.isSelected()) {
			    JOptionPane.showMessageDialog(jf, "Please select gender");
			    return;
			}

			String uname = nameField.getText();
			String email = emailField.getText();
			String gender = male.isSelected() ? "Male" : "Female";
			String city = (String) cityField.getSelectedItem();
			JOptionPane.showMessageDialog(jf, "Form has been submitted\n"
					+ "Name : " +uname
					+ "\nEmail : " + email
					+ "\nGender : " + gender
					+ "\nCity : " + city
					);
			clearFields();

			System.out.println("Form is get submitted");
		}
		
	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource() == Cancel) {
		    clearFields();
		    return;
		}
		
		if(e.getSource() == Submit) {
		    validateAndSubmit();
		}
	
	}

}
