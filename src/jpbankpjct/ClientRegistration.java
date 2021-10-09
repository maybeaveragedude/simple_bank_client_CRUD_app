package jpbankpjct;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.UIManager;
import javax.swing.WindowConstants;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.text.MaskFormatter;

import org.apache.commons.validator.routines.EmailValidator;


public class ClientRegistration extends ClientCRUD{

	private JFrame frmJpBankBaby;
	private JTextField txtAccountNo;
	private static JTextField txtName;
	private static JTextField txtIC;
	private JPasswordField txtPass;
	private static JTextField txtEmail;
	private static JTextField txtContact;
	static String[] cmbOptions = {"Savings","Current"};
	private static JComboBox<String> cmbAccountType  = new JComboBox<>(cmbOptions);



	/**
	 * Launch the application.
	 */
	//	public static void main(String[] args) {
	//		EventQueue.invokeLater(new Runnable() {
	//			@Override
	//			public void run() {
	//				try {
	//					ClientRegistration window = new ClientRegistration();
	//					window.frmJpBankBaby.setVisible(true);
	//				} catch (Exception e) {
	//					e.printStackTrace();
	//				}
	//			}
	//		});
	//	}

	/**
	 * Create the application.
	 */
	public ClientRegistration() {
		Integer tempHighestID = retrieve("newID");
		initialize(tempHighestID);

	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(Integer tempHighestID) {
		frmJpBankBaby = new JFrame();
		frmJpBankBaby.setTitle("Client Registration");
		frmJpBankBaby.setBounds(100, 100, 799, 500);
		frmJpBankBaby.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

		JLabel lblAccount = new JLabel("Account No.");
		lblAccount.setFont(new Font("Tahoma", Font.PLAIN, 12));

		txtAccountNo = new JTextField();
		txtAccountNo.setBorder(new CompoundBorder(new LineBorder(new Color(160, 160, 160)), new EmptyBorder(5, 5, 5, 5)));
		txtAccountNo.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtAccountNo.setEditable(false);
		lblAccount.setLabelFor(txtAccountNo);
		txtAccountNo.setColumns(10);
		txtAccountNo.setText(String.valueOf(tempHighestID));

		JLabel lblName = new JLabel("Legal Name");
		lblName.setFont(new Font("Tahoma", Font.PLAIN, 12));

		txtName = new JTextField();
		txtName.setBorder(new CompoundBorder(new LineBorder(new Color(160, 160, 160)), new EmptyBorder(5, 5, 5, 5)));
		txtName.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtName.setColumns(10);

		JLabel lblIC = new JLabel("I/C No.");
		lblIC.setFont(new Font("Tahoma", Font.PLAIN, 12));

		MaskFormatter ICMask = null;
		try {
			ICMask = new MaskFormatter("###### - ## - ####");
			ICMask.setPlaceholderCharacter('_');
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		txtIC = new JFormattedTextField(ICMask);
		txtIC.setBorder(new CompoundBorder(new LineBorder(new Color(160, 160, 160)), new EmptyBorder(5, 5, 5, 5)));
		txtIC.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtIC.setColumns(10);

		JLabel lblPassword = new JLabel("Password");
		lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 12));


		JLabel lblAccountType = new JLabel("Account Type");
		lblAccountType.setFont(new Font("Tahoma", Font.PLAIN, 12));

		txtPass = new JPasswordField();
		char tempChar = txtPass.getEchoChar();
		txtPass.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				txtPass.setEchoChar((char)0);

			}
			@Override
			public void mouseExited(MouseEvent e) {
				txtPass.setEchoChar(tempChar);

			}
		});
		txtPass.setBorder(new CompoundBorder(new LineBorder(new Color(160, 160, 160)), new EmptyBorder(5, 5, 5, 5)));
		txtPass.setFont(new Font("Tahoma", Font.PLAIN, 12));

		//		String[] cmbOptions = {"Savings","Current"};
		//		JComboBox<String> cmbAccountType = new JComboBox<>(cmbOptions);
		cmbAccountType.setFont(new Font("Tahoma", Font.PLAIN, 12));
		cmbAccountType.setBackground(new Color(255, 255, 255));


		JLabel lblEmail = new JLabel("Email");
		lblEmail.setFont(new Font("Tahoma", Font.PLAIN, 12));

		txtEmail = new JTextField();


		txtEmail.setBorder(new CompoundBorder(new LineBorder(new Color(160, 160, 160)), new EmptyBorder(5, 5, 5, 5)));
		txtEmail.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtEmail.setColumns(10);



		JLabel lblContact = new JLabel("Contact No.");
		lblContact.setFont(new Font("Tahoma", Font.PLAIN, 12));

		MaskFormatter phoneNumberMask = null;
		try {
			phoneNumberMask = new MaskFormatter("(###) ### - ####");
			phoneNumberMask.setPlaceholderCharacter('_');
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		txtContact = new JFormattedTextField(phoneNumberMask);
		txtContact.setBorder(new CompoundBorder(new LineBorder(new Color(160, 160, 160)), new EmptyBorder(5, 5, 5, 5)));
		txtContact.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtContact.setColumns(10);

		JButton btnNewButton = new JButton("Create Account");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked (MouseEvent e) {

				Integer AccountNo;
				Long ICNo, ContactNo;
				String[] CPassword;
				String LegalName, AccountType, DateCreated, Email;
				//
				AccountNo = Integer.parseInt(txtAccountNo.getText());
				System.out.println("New Account No.: "+AccountNo);

				LegalName = txtName.getText();
				System.out.println("Name: "+LegalName);

				//REMOVES MASK FROM THE FORMATTED INPUT
				String thisICText = txtIC.getText();
				String tempIC = thisICText.replaceAll("[^0-9]", "");
				ICNo = Long.parseLong(tempIC);
				System.out.println("I/C No.: "+ICNo);

				String thisContactText = txtContact.getText();
				String tempContact = thisContactText.replaceAll("[^0-9]", "");
				ContactNo = Long.parseLong(tempContact);

				Email = txtEmail.getText();

				String tempPass = String.valueOf(txtPass.getPassword());
				CPassword = PasswordTools.generate(tempPass); //Generates password salt and hashed password
				//[0] is salt
				//[1] is hashed password

				System.out.println("Password Salt: " + CPassword[0]);
				System.out.println("Hashed Password: " + CPassword[1]);

				AccountType = String.valueOf(cmbAccountType.getSelectedItem());
				System.out.println("Selected Account Type: "+ AccountType);

				SimpleDateFormat formatDate = new SimpleDateFormat("dd/MM/yyyy");
				Date date = new Date();
				DateCreated = formatDate.format(date);
				System.out.println("Creation Date: " + DateCreated);

				if (create(AccountNo, LegalName, ICNo, ContactNo, Email, CPassword[0], CPassword[1], AccountType, DateCreated)) {
					destroyThis();
					UI.popupMessages.create("Account " + AccountNo + "\nAccount Type: " + AccountType, "Successful Account Creation");
					ClientHome.showThis(AccountNo);

				} else {
					UI.popupMessages.create("Duplicate account type: " + AccountType + "\nRegistered under IC No.: " + thisICText, "Duplicate Registered Client");

				}

				//				ClientHome frame = new ClientHome(AccountNo);
				//				frame.setVisible(true);
				//				frame.setLocationRelativeTo(null);


			}
		});
		btnNewButton.setBackground(new Color(240, 240, 240));
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 12));

		txtEmail.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				EmailValidator validator = EmailValidator.getInstance();
				if (validator.isValid(txtEmail.getText())) {
					txtEmail.setBackground(Color.WHITE);
					btnNewButton.setEnabled(true);
				} else {
					txtEmail.setBackground(Color.RED);
					btnNewButton.setEnabled(false);
				}
			}
		});


		GroupLayout groupLayout = new GroupLayout(frmJpBankBaby.getContentPane());
		groupLayout.setHorizontalGroup(
				groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
						.addGap(183)
						.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
										.addComponent(lblAccountType, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(ComponentPlacement.RELATED)
										.addComponent(cmbAccountType, GroupLayout.PREFERRED_SIZE, 220, GroupLayout.PREFERRED_SIZE))
								.addGroup(groupLayout.createSequentialGroup()
										.addComponent(lblEmail, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(ComponentPlacement.RELATED)
										.addComponent(txtEmail, GroupLayout.PREFERRED_SIZE, 314, GroupLayout.PREFERRED_SIZE))
								.addGroup(groupLayout.createSequentialGroup()
										.addComponent(lblAccount, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(ComponentPlacement.RELATED)
										.addComponent(txtAccountNo, GroupLayout.PREFERRED_SIZE, 217, GroupLayout.PREFERRED_SIZE))
								.addGroup(groupLayout.createSequentialGroup()
										.addComponent(lblName, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(ComponentPlacement.RELATED)
										.addComponent(txtName, 314, 314, 314))
								.addGroup(groupLayout.createSequentialGroup()
										.addComponent(lblIC, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(ComponentPlacement.RELATED)
										.addComponent(txtIC, 314, 314, 314))
								.addGroup(groupLayout.createSequentialGroup()
										.addComponent(lblContact, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(ComponentPlacement.RELATED)
										.addComponent(txtContact, GroupLayout.PREFERRED_SIZE, 219, GroupLayout.PREFERRED_SIZE))
								.addGroup(groupLayout.createSequentialGroup()
										.addComponent(lblPassword, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(ComponentPlacement.RELATED)
										.addComponent(txtPass, GroupLayout.PREFERRED_SIZE, 314, GroupLayout.PREFERRED_SIZE))
								.addComponent(btnNewButton, Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 137, GroupLayout.PREFERRED_SIZE))
						.addGap(182))
				);
		groupLayout.setVerticalGroup(
				groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
						.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
										.addGap(29)
										.addComponent(lblAccount, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE))
								.addGroup(groupLayout.createSequentialGroup()
										.addGap(26)
										.addComponent(txtAccountNo, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)))
						.addGap(18)
						.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblName, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
								.addComponent(txtName, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
										.addGap(21)
										.addComponent(lblIC, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE))
								.addGroup(groupLayout.createSequentialGroup()
										.addGap(18)
										.addComponent(txtIC, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)))
						.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
										.addGap(21)
										.addComponent(lblContact, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE))
								.addGroup(groupLayout.createSequentialGroup()
										.addGap(18)
										.addComponent(txtContact, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)))
						.addGap(21)
						.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblEmail, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
								.addComponent(txtEmail, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))
						.addGap(21)
						.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblPassword, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
								.addComponent(txtPass, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))
						.addGap(19)
						.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblAccountType, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
								.addComponent(cmbAccountType, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))
						.addGap(29)
						.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
						.addGap(22))
				);
		frmJpBankBaby.getContentPane().setLayout(groupLayout);

		JMenuBar menuBar = new JMenuBar();
		menuBar.setBackground(new Color(240, 240, 240));
		frmJpBankBaby.setJMenuBar(menuBar);

		JMenu mnEditMenu = new JMenu("Edit");
		mnEditMenu.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		menuBar.add(mnEditMenu);

		JMenuItem mntmReset = new JMenuItem("Reset");
		mntmReset.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		mnEditMenu.add(mntmReset);
		mntmReset.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				//				frmStaffHome.dispose();
				destroyThis();
				showThis();
			}
		});
	}

	public void destroyThis() {
		frmJpBankBaby.dispose();
	}

	public static void showThis() {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch(Exception e) {
			System.out.println("Error setting native LAF: " + e);
		}
		ClientRegistration window = new ClientRegistration();


		cmbAccountType.setSelectedIndex(0);
		cmbAccountType.setEnabled(true);

		window.frmJpBankBaby.setVisible(true);
		window.frmJpBankBaby.setLocationRelativeTo(null);
	}

	public static void showThis(String existName, Long existIC, Long existContact, String existEmail, String selectedType) {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch(Exception e) {
			System.out.println("Error setting native LAF: " + e);
		}
		ClientRegistration window = new ClientRegistration();

		txtName.setText(existName);
		txtName.setEditable(false);

		txtIC.setText(String.format("%012d",existIC));
		txtIC.setEditable(false);

		txtContact.setText(String.format("%010d",existContact));

		txtEmail.setText(existEmail);
		//

		if (selectedType == "Savings") {
			System.out.println(selectedType);
			cmbAccountType.setSelectedIndex(0);
		} else {
			System.out.println(selectedType);
			cmbAccountType.setSelectedIndex(1);
		}
		cmbAccountType.setEnabled(false);


		window.frmJpBankBaby.setVisible(true);
		window.frmJpBankBaby.setLocationRelativeTo(null);
	}


}
