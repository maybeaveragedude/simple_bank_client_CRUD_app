package jpbankpjct;

import java.awt.Color;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.UIManager;
import javax.swing.WindowConstants;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

public class ClientLogin {

	private JFrame clientlogin;
	private JPanel contentPane;
	private JTextField txtCAccountNo;
	private JPasswordField txtPass;
	//	public JFrame frame;

	/**
	 * Launch the application.
	 */
	//	public static void main(String[] args) {
	//		EventQueue.invokeLater(new Runnable() {
	//			@Override
	//			public void run() {
	//				try {
	//					ClientLogin window = new ClientLogin();
	//					window.clientlogin.setVisible(true);
	//					window.clientlogin.setLocationRelativeTo(null);
	//				} catch (Exception e) {
	//					e.printStackTrace();
	//				}
	//			}
	//		});
	//	}

	public ClientLogin() {
		//		Integer tempHighestID = retrieve("newID");
		initialize();

	}

	/**
	 * Create the frame.
	 */
	public void initialize() {
		clientlogin = new JFrame();
		clientlogin.setTitle("Client Login");
		clientlogin.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		clientlogin.setBounds(100, 100, 450, 261);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		clientlogin.setContentPane(contentPane);

		JLabel lblAccountNo = new JLabel("Account No.");
		lblAccountNo.setForeground(Color.BLACK);
		lblAccountNo.setFont(new Font("Tahoma", Font.PLAIN, 12));

		txtCAccountNo = new JTextField();
		txtCAccountNo.setForeground(Color.BLACK);
		txtCAccountNo.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtCAccountNo.setColumns(10);
		txtCAccountNo.setBorder(new CompoundBorder(new LineBorder(new Color(160, 160, 160)), new EmptyBorder(5, 5, 5, 5)));

		txtPass = new JPasswordField();
		txtPass.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtPass.setBorder(new CompoundBorder(new LineBorder(new Color(160, 160, 160)), new EmptyBorder(5, 5, 5, 5)));
		txtPass.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Integer CAccountNo = Integer.parseInt(txtCAccountNo.getText());
				String clientPassInput = String.valueOf(txtPass.getPassword());
				Boolean loginStatus = loginClient(CAccountNo, clientPassInput);

				if (loginStatus) {
					System.out.println("Login Successful.");
					UI.popupMessages.create("Login Successful.", "Login status");
					clientlogin.dispose();

					ClientHome.showThis(CAccountNo);


				} else {
					System.out.println("Login Failed.");
					UI.popupMessages.create("Login Failed.\nPlease check your credentials.", "Login status");
				}

			}
		});

		JLabel lblPass = new JLabel("Password");
		lblPass.setForeground(Color.BLACK);
		lblPass.setFont(new Font("Tahoma", Font.PLAIN, 12));

		JButton btnLogin = new JButton("Login");
		btnLogin.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Integer CAccountNo = Integer.parseInt(txtCAccountNo.getText());
				String clientPassInput = String.valueOf(txtPass.getPassword());
				Boolean loginStatus = loginClient(CAccountNo, clientPassInput);

				if (loginStatus) {
					System.out.println("Login Successful.");
					UI.popupMessages.create("Login Successful.", "Login status");
					clientlogin.dispose();

					ClientHome.showThis(CAccountNo);


				} else {
					System.out.println("Login Failed.");
					UI.popupMessages.create("Login Failed.\nPlease check your credentials.", "Login status");
				}

			}
		});
		btnLogin.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnLogin.setBackground(SystemColor.menu);
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
				gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
						.addContainerGap(40, Short.MAX_VALUE)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
										.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
												.addGroup(gl_contentPane.createSequentialGroup()
														.addComponent(lblAccountNo, GroupLayout.PREFERRED_SIZE, 84, GroupLayout.PREFERRED_SIZE)
														.addGap(26)
														.addComponent(txtCAccountNo, GroupLayout.PREFERRED_SIZE, 238, GroupLayout.PREFERRED_SIZE))
												.addGroup(gl_contentPane.createSequentialGroup()
														.addComponent(lblPass, GroupLayout.PREFERRED_SIZE, 51, GroupLayout.PREFERRED_SIZE)
														.addGap(59)
														.addComponent(txtPass, GroupLayout.PREFERRED_SIZE, 238, GroupLayout.PREFERRED_SIZE)))
										.addGap(36))
								.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
										.addComponent(btnLogin, GroupLayout.PREFERRED_SIZE, 73, GroupLayout.PREFERRED_SIZE)
										.addGap(170))))
				);
		gl_contentPane.setVerticalGroup(
				gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
						.addGap(58)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createSequentialGroup()
										.addGap(7)
										.addComponent(lblAccountNo, GroupLayout.PREFERRED_SIZE, 15, GroupLayout.PREFERRED_SIZE))
								.addComponent(txtCAccountNo, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE))
						.addGap(11)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createSequentialGroup()
										.addGap(7)
										.addComponent(lblPass, GroupLayout.PREFERRED_SIZE, 15, GroupLayout.PREFERRED_SIZE))
								.addComponent(txtPass, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE))
						.addGap(30)
						.addComponent(btnLogin, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
						.addContainerGap(62, Short.MAX_VALUE))
				);
		clientlogin.getContentPane().setLayout(gl_contentPane);
	}

	public static Boolean loginClient(Integer CAccountNo, String passwordInput) {
		try {
			File file = new File("db/clientdetails.txt");

			// Opening file in read mode.

			RandomAccessFile read = new RandomAccessFile(file, "r");

			while (read.getFilePointer() < read.length()) {

				// reading line from the file.
				String clientCredentials = read.readLine();

				String[] lineSplit = clientCredentials.split(",");

				// separating name and number.
				Integer existAccountNo = Integer.parseInt(lineSplit[0]);
				String passwordSalt = lineSplit[5];
				String hashedPassword = lineSplit[6];




				if (CAccountNo.equals(existAccountNo)) {
					System.out.println("Account Exists");
					if (PasswordTools.verify(hashedPassword, passwordSalt, passwordInput)) {
						System.out.println("Encryption Check Successful.");
						read.close();
						return true;

					} else {
						System.out.println("Encryption Check Failed.");
						read.close();
						return false;

					}
				}

			}
			read.close();
		}
		catch (IOException ioe) {
			System.out.println(ioe);
			return false;
		}
		catch (NumberFormatException nef) {
			System.out.println(nef);
			return false;
		}

		return false;

	}

	public static Boolean loginQRClient(Integer CAccountNo, String encryptedPass) {
		try {
			File file = new File("db/clientdetails.txt");

			// Opening file in read mode.

			RandomAccessFile read = new RandomAccessFile(file, "r");

			while (read.getFilePointer() < read.length()) {

				// reading line from the file.
				String clientCredentials = read.readLine();

				String[] lineSplit = clientCredentials.split(",");

				//getting the values of account no. and password salt
				Integer existAccountNo = Integer.parseInt(lineSplit[0]);
				//	          String passwordSalt = lineSplit[5];
				String existHashedPassword = lineSplit[6];




				if (CAccountNo.equals(existAccountNo)) {
					System.out.println("Account Exists");
					if (PasswordTools.verify(encryptedPass, existHashedPassword)) {
						System.out.println("Encryption Check Successful.");
						read.close();
						return true;

					} else {
						System.out.println("Encryption Check Failed.");
						read.close();
						return false;

					}
				}

			}
			read.close();
		}
		catch (IOException ioe) {
			System.out.println(ioe);
			return false;
		}
		catch (NumberFormatException nef) {
			System.out.println(nef);
			return false;
		}

		return false;

	}

	public static void showThis() {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch(Exception e) {
			System.out.println("Error setting native LAF: " + e);
		}
		try {
			ClientLogin window = new ClientLogin();
			window.clientlogin.setVisible(true);
			window.clientlogin.setLocationRelativeTo(null);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
