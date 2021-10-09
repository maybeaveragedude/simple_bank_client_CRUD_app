package jpbankpjct;

import java.awt.Color;
import java.awt.Desktop;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.UIManager;
import javax.swing.WindowConstants;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

public class ChangePassword {

	private JFrame frmChangePassword;
	private JPasswordField txtPass;
	private JPasswordField txtRepeatPass;
	private JButton btnApply;
	private JButton btnCancel;



	public ChangePassword() {
		frmChangePassword = new JFrame();
		frmChangePassword.setTitle("Change Password");
		frmChangePassword.setBounds(100, 100, 450, 267);
		frmChangePassword.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		frmChangePassword.getContentPane().setLayout(null);

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
		txtPass.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtPass.setBorder(new CompoundBorder(new LineBorder(new Color(160, 160, 160)), new EmptyBorder(5, 5, 5, 5)));
		txtPass.setBounds(131, 51, 277, 30);
		frmChangePassword.getContentPane().add(txtPass);

		JLabel lblPass = new JLabel("New Password");
		lblPass.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblPass.setBounds(19, 55, 389, 22);
		frmChangePassword.getContentPane().add(lblPass);

		JLabel lblRepeatPassword = new JLabel("Repeat Password");
		lblRepeatPassword.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblRepeatPassword.setBounds(19, 92, 102, 22);
		frmChangePassword.getContentPane().add(lblRepeatPassword);

		txtRepeatPass = new JPasswordField();

		//allowing visual checking of the password
		txtRepeatPass.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				txtRepeatPass.setEchoChar((char)0);

			}
			@Override
			public void mouseExited(MouseEvent e) {
				txtRepeatPass.setEchoChar(tempChar);

			}
		});
		txtRepeatPass.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtRepeatPass.setBorder(new CompoundBorder(new LineBorder(new Color(160, 160, 160)), new EmptyBorder(5, 5, 5, 5)));
		txtRepeatPass.setBounds(131, 88, 277, 30);
		frmChangePassword.getContentPane().add(txtRepeatPass);

		btnApply = new JButton("Apply");
		btnApply.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (UI.popupMessages.createYesNo("This change is final, continue?", "Confirmation")) {
					//do update pass on this account
					frmChangePassword.dispose();
				} else {

				}

			}
		});
		btnApply.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnApply.setBounds(293, 169, 115, 30);
		frmChangePassword.getContentPane().add(btnApply);

		btnCancel = new JButton("Cancel");
		btnCancel.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnCancel.setBounds(168, 169, 115, 30);
		frmChangePassword.getContentPane().add(btnCancel);
	}

	public ChangePassword(Integer accountNo) {
		System.out.println(accountNo);
		frmChangePassword = new JFrame();
		frmChangePassword.setTitle("Change Password");
		frmChangePassword.setBounds(100, 100, 450, 267);
		frmChangePassword.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		frmChangePassword.getContentPane().setLayout(null);

		txtPass = new JPasswordField();
		char tempChar = txtPass.getEchoChar();
		//allowing visual checking of the password
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
		txtPass.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtPass.setBorder(new CompoundBorder(new LineBorder(new Color(160, 160, 160)), new EmptyBorder(5, 5, 5, 5)));
		txtPass.setBounds(131, 51, 277, 30);
		frmChangePassword.getContentPane().add(txtPass);

		JLabel lblPass = new JLabel("New Password");
		lblPass.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblPass.setBounds(19, 55, 389, 22);
		frmChangePassword.getContentPane().add(lblPass);

		JLabel lblRepeatPassword = new JLabel("Repeat Password");
		lblRepeatPassword.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblRepeatPassword.setBounds(19, 92, 102, 22);
		frmChangePassword.getContentPane().add(lblRepeatPassword);

		txtRepeatPass = new JPasswordField();
		//allowing visual checking of the password
		txtRepeatPass.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				txtRepeatPass.setEchoChar((char)0);

			}
			@Override
			public void mouseExited(MouseEvent e) {
				txtRepeatPass.setEchoChar(tempChar);

			}
		});
		txtRepeatPass.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtRepeatPass.setBorder(new CompoundBorder(new LineBorder(new Color(160, 160, 160)), new EmptyBorder(5, 5, 5, 5)));
		txtRepeatPass.setBounds(131, 88, 277, 30);
		frmChangePassword.getContentPane().add(txtRepeatPass);

		btnApply = new JButton("Apply");
		btnApply.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (UI.popupMessages.createYesNo("This change is final, continue?", "Confirmation")) {
					//do update pass on this account

					String tempPass = String.valueOf(txtPass.getPassword());
					String[] CPassword = PasswordTools.generate(tempPass); //Generates password salt and hashed password
					//[0] is salt
					//[1] is hashed password

					if (ClientCRUD.newPass(accountNo, CPassword[0], CPassword[1])) {

						UI.popupMessages.create("Password Updated", "Password Change");

						//						updating and showing the QR login image of client
						try {
							File QRfile = new File("QRrepo/client" + accountNo +".png");
							Desktop dt = Desktop.getDesktop();

							if (!QRfile.exists()) {
								// create new QR if doesnt exist
								if (UI.popupMessages.createYesNo("QR login doesnt exist for this account, create new?", "Missing File")) {

									if(ClientCRUD.genQR(accountNo,  CPassword[1])) {
										UI.popupMessages.create("New QR login generated!", "QR Status");
										dt.open(QRfile);
									}

								} else {

									UI.popupMessages.create("Operation cancelled with non-existing QR login image.", "Missing File");
								}

							} else {

								if(ClientCRUD.genQR(accountNo,  CPassword[1])) {
									UI.popupMessages.create("Updated QR login generated!", "QR Status");
									dt.open(QRfile);
								} else {
									UI.popupMessages.create("Critical error!", "Error");
								}
							}


						} catch (IOException e1) {
							e1.printStackTrace();
						}
						System.out.println("QR Image shown.");
					}

					frmChangePassword.dispose();
				} else {

				}

			}
		});
		btnApply.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnApply.setBounds(293, 169, 115, 30);
		frmChangePassword.getContentPane().add(btnApply);

		btnCancel = new JButton("Cancel");
		btnCancel.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnCancel.setBounds(168, 169, 115, 30);
		btnCancel.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				frmChangePassword.dispose();
			}
		});
		frmChangePassword.getContentPane().add(btnCancel);
	}

	public static Boolean showThis(Integer accountNo) {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch(Exception e) {
			System.out.println("Error setting native LAF: " + e);
		}
		try {
			ChangePassword window = new ChangePassword(accountNo);
			window.frmChangePassword.setVisible(true);
			window.frmChangePassword.setLocationRelativeTo(null);
		} catch(Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
}
