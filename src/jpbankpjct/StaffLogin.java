package jpbankpjct;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
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

public class StaffLogin extends JFrame {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	private JFrame staffLoginFrame;
	//	private JFrame frame;
	private JPanel contentPane;
	private JTextField txtUsername;
	private JPasswordField txtPass;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				try {
					StaffLogin window = new StaffLogin();
					window.staffLoginFrame.setVisible(true);
					window.staffLoginFrame.setLocationRelativeTo(null);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 *
	 * Create the frame.
	 */
	public StaffLogin() {
		staffLoginFrame = new JFrame();
		staffLoginFrame.setResizable(false);
		staffLoginFrame.setTitle("Staff Login");
		staffLoginFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		staffLoginFrame.setBounds(100, 100, 380, 240);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		staffLoginFrame.setContentPane(contentPane);

		txtUsername = new JTextField();
		txtUsername.setBorder(new CompoundBorder(new LineBorder(new Color(160, 160, 160)), new EmptyBorder(5, 5, 5, 5)));
		txtUsername.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtUsername.setForeground(new Color(0, 0, 0));
		txtUsername.setColumns(10);
		txtUsername.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				absLogin();
			}
		});

		JLabel lblUsername = new JLabel("Staff Username");
		lblUsername.setForeground(new Color(0, 0, 0));
		lblUsername.setFont(new Font("Tahoma", Font.PLAIN, 12));

		JLabel lblPass = new JLabel("Password");
		lblPass.setForeground(new Color(0, 0, 0));
		lblPass.setFont(new Font("Tahoma", Font.PLAIN, 12));

		JButton btnLogin = new JButton("Login");
		btnLogin.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnLogin.setBackground(new Color(240, 240, 240));
		btnLogin.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				absLogin();

			}

		});

		txtPass = new JPasswordField();
		txtPass.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				absLogin();
			}
		});
		txtPass.setBorder(new CompoundBorder(new LineBorder(new Color(160, 160, 160)), new EmptyBorder(5, 5, 5, 5)));
		txtPass.setFont(new Font("Tahoma", Font.PLAIN, 12));
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
				gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
						.addGap(6)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
								.addGroup(gl_contentPane.createSequentialGroup()
										.addComponent(btnLogin, GroupLayout.PREFERRED_SIZE, 73, GroupLayout.PREFERRED_SIZE)
										.addGap(140))
								.addGroup(gl_contentPane.createSequentialGroup()
										.addPreferredGap(ComponentPlacement.RELATED)
										.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
												.addComponent(lblPass)
												.addComponent(lblUsername))
										.addPreferredGap(ComponentPlacement.RELATED, 20, Short.MAX_VALUE)
										.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING, false)
												.addComponent(txtPass)
												.addComponent(txtUsername, GroupLayout.DEFAULT_SIZE, 238, Short.MAX_VALUE))
										.addContainerGap())))
				);
		gl_contentPane.setVerticalGroup(
				gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
						.addContainerGap(38, Short.MAX_VALUE)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(txtUsername, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblUsername))
						.addPreferredGap(ComponentPlacement.UNRELATED)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(txtPass, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblPass))
						.addGap(30)
						.addComponent(btnLogin, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
						.addGap(32))
				);
		staffLoginFrame.getContentPane().setLayout(gl_contentPane);
	}


	public static Boolean loginStaff(String StaffUsername, String passwordInput) {
		try {
			File file = new File("db/staffdetails.txt");

			// Opening file in read mode.

			RandomAccessFile read = new RandomAccessFile(file, "r");

			while (read.getFilePointer() < read.length()) {

				// reading line from the file.
				String staffCredentials = read.readLine();

				String[] lineSplit = staffCredentials.split(",");

				// separating name and number.
				String existStaffUsername = lineSplit[0];
				String hashedPassword = lineSplit[1];
				String passwordSalt = lineSplit[2];



				if (StaffUsername.equals(existStaffUsername)) {
					System.out.println("User Exists");
					if (PasswordTools.verify(hashedPassword, passwordSalt, passwordInput)) {
						System.out.println("Encryption Check Successful.");
						read.close();
						return true;

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
		StaffLogin window = new StaffLogin();
		window.staffLoginFrame.setVisible(true);
		window.staffLoginFrame.setLocationRelativeTo(null);
	}



	private void absLogin() {
		String username = txtUsername.getText();
		String password = String.valueOf(txtPass.getPassword());

		Boolean loginStatus = loginStaff(username,password);
		if (loginStatus) {
			System.out.println("Login Successful.");
			UI.popupMessages.create("Login Successful.", "Login status");
			staffLoginFrame.dispose();
			//			ClientRegistration frame = new ClientRegistration();
			//			frame.setVisible(true);
			//			frame.setLocationRelativeTo(null);
			StaffHome.showThis(username);

		} else {
			System.out.println("Login Failed.");
			UI.popupMessages.create("Login Failed.\nPlease check your credentials.", "Login status");
		}
	}
}
