	package jpbankpjct;

import java.awt.Color;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.text.ParseException;

import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.WindowConstants;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.text.MaskFormatter;

import org.apache.commons.validator.routines.EmailValidator;



public class ClientEdit {

	private JFrame frmClientEditor;
	private JTextField txtLegalName;
	private JTextField txtIC;
	private JTextField txtContactNo;
	private JTextField txtEmail;
	private static String[] retrievedClientRecord;
	public static Integer existAccountNo;
	public static String existLegalName, existEmail, existType, existDate;
	public static Long existIC, existContact;
	private Integer counter = 0;
	public ActionListener createSavings = new ActionListener() { //CREATE FUNCTION FOR UNEXISTING SAVINGS ACCOUNT
		@Override
		public void actionPerformed(ActionEvent e) {
			ClientRegistration.showThis(existLegalName, existIC, existContact, existEmail, "Savings");
		}
	};
	public ActionListener createCurrent = new ActionListener() {//CREATE FUNCTION FOR UNEXISTING CURRENT ACCOUNT
		@Override
		public void actionPerformed(ActionEvent e) {
			ClientRegistration.showThis(existLegalName, existIC, existContact, existEmail, "Current");
		}
	};


	/**
	 * Create the application.
	 */
	public ClientEdit() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmClientEditor = new JFrame();
		frmClientEditor.setTitle("Client Editor");
		frmClientEditor.setBounds(100, 100, 443, 669);
		frmClientEditor.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		frmClientEditor.getContentPane().setLayout(null);

		JLabel lblLegalName = new JLabel("Legal Name");
		lblLegalName.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblLegalName.setLabelFor(lblLegalName);
		lblLegalName.setBounds(20, 51, 90, 14);
		frmClientEditor.getContentPane().add(lblLegalName);

		txtLegalName = new JTextField();
		txtLegalName.setBorder(new CompoundBorder(new LineBorder(new Color(160, 160, 160)), new EmptyBorder(5, 5, 5, 5)));
		txtLegalName.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtLegalName.setEditable(false);
		txtLegalName.setBounds(20, 68, 234, 28);
		frmClientEditor.getContentPane().add(txtLegalName);
		txtLegalName.setColumns(10);

		System.out.println(existLegalName);
		txtLegalName.setText(existLegalName);

		JLabel lblTitleDetails = new JLabel("Client Details");
		lblTitleDetails.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblTitleDetails.setBounds(20, 15, 200, 25);
		frmClientEditor.getContentPane().add(lblTitleDetails);

		JLabel lblIC = new JLabel("Identification No.");
		lblIC.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblIC.setBounds(20, 107, 100, 14);
		frmClientEditor.getContentPane().add(lblIC);


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
		txtIC.setEditable(false);
		txtIC.setColumns(10);
		txtIC.setBounds(20, 124, 200, 28);
		//		txtIC.addKeyListener(new KeyAdapter() {
		//			@Override
		//			public void keyPressed(KeyEvent e) {
		//				String thisText = txtIC.getText();
		//				String tempDigits = thisText.replaceAll("[^0-9]", "");
		//				System.out.println(tempDigits);
		//			}
		//		});
		frmClientEditor.getContentPane().add(txtIC);

		System.out.println(existIC);
		//		txtIC.setText(String.valueOf(existIC));
		txtIC.setText(String.format("%012d",existIC));

		JLabel lblTitleContactDetails = new JLabel("Contact Information");
		lblTitleContactDetails.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblTitleContactDetails.setBounds(20, 173, 200, 25);
		frmClientEditor.getContentPane().add(lblTitleContactDetails);

		JLabel lblContactNo = new JLabel("Contact No.");
		lblContactNo.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblContactNo.setBounds(20, 209, 90, 14);
		frmClientEditor.getContentPane().add(lblContactNo);

		MaskFormatter phoneNumberMask = null;
		try {
			phoneNumberMask = new MaskFormatter("(###) ### - ####");
			phoneNumberMask.setPlaceholderCharacter('_');
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		txtContactNo = new JFormattedTextField(phoneNumberMask);
		//		txtContactNo.addKeyListener(new KeyAdapter() {
		//			@Override
		//			public void keyPressed(KeyEvent e) {
		//				String thisText = txtContactNo.getText();
		//				String tempDigits = thisText.replaceAll("[^0-9]", "");
		//				System.out.println(tempDigits);
		//			}
		//		});
		txtContactNo.setBorder(new CompoundBorder(new LineBorder(new Color(160, 160, 160)), new EmptyBorder(5, 5, 5, 5)));
		txtContactNo.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtContactNo.setColumns(10);
		txtContactNo.setBounds(20, 226, 155, 28);
		frmClientEditor.getContentPane().add(txtContactNo);

		System.out.println(existContact);
		//		txtContactNo.setText(String.valueOf(existContact));
		txtContactNo.setText(String.format("%010d",existContact));

		JLabel lblEmail = new JLabel("Email Address");
		lblEmail.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblEmail.setBounds(20, 264, 100, 14);
		frmClientEditor.getContentPane().add(lblEmail);

		txtEmail = new JTextField();



		txtEmail.setBorder(new CompoundBorder(new LineBorder(new Color(160, 160, 160)), new EmptyBorder(5, 5, 5, 5)));
		txtEmail.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtEmail.setColumns(10);
		txtEmail.setBounds(20, 281, 234, 28);
		frmClientEditor.getContentPane().add(txtEmail);

		System.out.println(existEmail);
		txtEmail.setText(existEmail);

		JLabel lblTitleAccount = new JLabel("Accounts");
		lblTitleAccount.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblTitleAccount.setBounds(20, 377, 200, 25);
		frmClientEditor.getContentPane().add(lblTitleAccount);


		JPanel panSavings = new JPanel();
		panSavings.setBackground(SystemColor.activeCaptionBorder);
		panSavings.setBounds(20, 413, 187, 176);
		frmClientEditor.getContentPane().add(panSavings);
		panSavings.setLayout(null);

		JLabel lblSavingsNo = new JLabel("Account No.: Unregistered");
		lblSavingsNo.setBounds(10, 44, 167, 15);
		panSavings.add(lblSavingsNo);
		lblSavingsNo.setFont(new Font("Tahoma", Font.PLAIN, 12));

		JLabel lblSavings = new JLabel("Savings");
		lblSavings.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblSavings.setBounds(10, 11, 167, 25);
		panSavings.add(lblSavings);

		JLabel lblSavingsDate = new JLabel("Date Created: - ");
		lblSavingsDate.setBounds(10, 70, 167, 14);
		panSavings.add(lblSavingsDate);
		lblSavingsDate.setFont(new Font("Tahoma", Font.PLAIN, 12));

		JButton btnChangePassSavings = new JButton("Change Password");
		btnChangePassSavings.setEnabled(false);
		//		btnChangePassSavings.addActionListener(new ActionListener() {
		//			public void actionPerformed(ActionEvent e) {
		//			}
		//		});
		btnChangePassSavings.setBounds(10, 95, 167, 31);
		panSavings.add(btnChangePassSavings);

		JButton btnDeleteCreateSavings = new JButton("Create");
		btnDeleteCreateSavings.addActionListener(createSavings);
		btnDeleteCreateSavings.setBounds(10, 132, 167, 31);
		panSavings.add(btnDeleteCreateSavings);

		JPanel panCurrent = new JPanel();
		panCurrent.setBackground(SystemColor.activeCaptionBorder);
		panCurrent.setBounds(219, 413, 187, 176);
		frmClientEditor.getContentPane().add(panCurrent);
		panCurrent.setLayout(null);

		JLabel lblTitleContactDetails_1_1 = new JLabel("Current");
		lblTitleContactDetails_1_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblTitleContactDetails_1_1.setBounds(10, 11, 167, 25);
		panCurrent.add(lblTitleContactDetails_1_1);

		JLabel lblCurrentNo = new JLabel("Account No.: Unregistered");
		lblCurrentNo.setBounds(10, 44, 167, 14);
		panCurrent.add(lblCurrentNo);
		lblCurrentNo.setFont(new Font("Tahoma", Font.PLAIN, 12));

		JLabel lblCurrentDate = new JLabel("Date Created: - ");
		lblCurrentDate.setBounds(10, 70, 167, 14);
		panCurrent.add(lblCurrentDate);
		lblCurrentDate.setFont(new Font("Tahoma", Font.PLAIN, 12));

		JButton btnChangePassCurrent = new JButton("Change Password");
		btnChangePassCurrent.setEnabled(false);
		//		btnChangePassCurrent.addActionListener(new ActionListener() {
		//			public void actionPerformed(ActionEvent e) {
		//			}
		//		});
		btnChangePassCurrent.setBounds(10, 95, 167, 31);
		panCurrent.add(btnChangePassCurrent);

		JButton btnDeleteCreateCurrent = new JButton("Create");
		btnDeleteCreateCurrent.addActionListener(createCurrent);
		btnDeleteCreateCurrent.setBounds(10, 132, 167, 31);
		panCurrent.add(btnDeleteCreateCurrent);

		String[] returnRecord = {};

		try {


			String clientRecord;

			Integer readexistAccountNo;
			Long readexistIC;
			String readType, readDate;

			// Using file pointer creating the file.

			File file = new File("db/clientdetails.txt");
			//            System.out.println(file.getPath());

			if (!file.exists()) {

				// Create a new file if not exists.
				file.createNewFile();
			}

			// Opening file in reading and write mode.

			RandomAccessFile raf = new RandomAccessFile(file, "r");

			counter = 0;
			while (raf.getFilePointer() < raf.length()) {

				// reading line from the file.
				clientRecord = raf.readLine();

				// splitting the string to get name and
				// number
				returnRecord = clientRecord.split(",");

				readexistAccountNo = Integer.parseInt(returnRecord[0]);
				readexistIC = Long.parseLong(returnRecord[2]);
				readType = returnRecord[7];
				readDate = returnRecord[8];

				if (readexistIC.equals(existIC)) {
					Integer tempAccNo = readexistAccountNo;
					switch (readType) {
					case "Savings" : {
						counter ++;


						btnChangePassSavings.setEnabled(true);
						btnChangePassSavings.addActionListener(new ActionListener() {
							@Override
							public void actionPerformed(ActionEvent e) {
								ChangePassword.showThis(tempAccNo);

							}
						});

						panSavings.setBackground(new Color(144, 238, 144));
						lblSavingsNo.setText("Account No.: " + String.valueOf(readexistAccountNo));
						lblSavingsDate.setText("Date Created: " + readDate);

						btnDeleteCreateSavings.setText("Delete");
						btnDeleteCreateSavings.removeActionListener(createSavings);
						btnDeleteCreateSavings.addActionListener(new ActionListener() {
							@Override
							public void actionPerformed(ActionEvent e) {
								if (UI.popupMessages.createYesNo("Account will be deleted PERMANENTLY, continue?", "Confirmation")) {

									if (ClientCRUD.delete(tempAccNo)) {

										UI.popupMessages.create("Account deleted successfully!", "Delete Status");
										counter --;
										if (counter == 0) {
											UI.popupMessages.create("No traces of client found!", "Client Status");
											frmClientEditor.dispose();
											ClientHome.destroyThis();
										} else {
											frmClientEditor.dispose();
											showThis(existIC);
										}

									} else {
										UI.popupMessages.create("Something went wrong!", "Delete Status");
									}
								} else {

								}


							}
						});

						break;
					}

					case "Current" : {
						counter ++;
						btnChangePassCurrent.setEnabled(true);
						btnChangePassCurrent.addActionListener(new ActionListener() {
							@Override
							public void actionPerformed(ActionEvent e) {
								ChangePassword.showThis(tempAccNo);


							}
						});

						panCurrent.setBackground(new Color(144, 238, 144));
						lblCurrentNo.setText("Account No.: " + String.valueOf(readexistAccountNo));
						lblCurrentDate.setText("Date Created: " + readDate);

						btnDeleteCreateCurrent.setText("Delete");
						btnDeleteCreateCurrent.removeActionListener(createCurrent);

						btnDeleteCreateCurrent.addActionListener(new ActionListener() {
							@Override
							public void actionPerformed(ActionEvent e) {
								if (UI.popupMessages.createYesNo("Account will be deleted PERMANENTLY, continue?", "Confirmation")) {
									if (ClientCRUD.delete(tempAccNo)) {
										UI.popupMessages.create("Account deleted successfully!", "Delete Status");

										counter --;
										if (counter == 0) {
											UI.popupMessages.create("No traces of client found!", "Client Status");
											frmClientEditor.dispose();
											ClientHome.destroyThis();
										} else {
											frmClientEditor.dispose();
											showThis(existIC);
										}
									} else {
										UI.popupMessages.create("Something went wrong!", "Delete Status");
									}
								} else {

								}
							}
						});
						break;

					}
					}



				}
				//
			}


			raf.close();
		}

		catch (IOException ioe) {

			System.out.println(ioe);
		}
		catch (NumberFormatException nef) {

			System.out.println(nef);
		}

		JButton btnApply = new JButton("Apply Changes");
		btnApply.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				//Initializing the variables to be updated
				String thisContactText = txtContactNo.getText();
				String stempContact = thisContactText.replaceAll("[^0-9]", "");
				Long newContact = Long.parseLong(stempContact);

				String newEmail = txtEmail.getText();

				if (ClientCRUD.editClient(existIC, newContact, newEmail)){
					UI.popupMessages.create("Detail Updated!", "Edit Status");
					frmClientEditor.dispose();
					ClientHome.refresh();
				} else {
					UI.popupMessages.create("Something went wrong!", "Edit Status");
					frmClientEditor.dispose();
				}

			}
		});
		btnApply.setBounds(294, 330, 112, 36);
		frmClientEditor.getContentPane().add(btnApply);

		txtEmail.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				EmailValidator validator = EmailValidator.getInstance();
				if (validator.isValid(txtEmail.getText())) {
					txtEmail.setBackground(Color.WHITE);
					btnApply.setEnabled(true);
				} else {
					txtEmail.setBackground(Color.RED);
					btnApply.setEnabled(false);
				}
			}
		});



		JButton btnCancel = new JButton("Cancel");
		btnCancel.setBounds(172, 330, 112, 36);
		btnCancel.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				frmClientEditor.dispose();
			}
		});
		frmClientEditor.getContentPane().add(btnCancel);



		JMenuBar menuBar = new JMenuBar();
		frmClientEditor.setJMenuBar(menuBar);

		JMenu mnStaff = new JMenu("Staff");
		menuBar.add(mnStaff);

		JMenuItem mntmHome = new JMenuItem("Home");
		mntmHome.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				StaffHome.unhideThis();
			}
		});
		mnStaff.add(mntmHome);

		JMenuItem mntmLogout = new JMenuItem("Logout");
		mntmLogout.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				StaffHome.absLogout();
			}
		});
		mnStaff.add(mntmLogout);

		JMenu mnClient = new JMenu("Client");
		menuBar.add(mnClient);

		JMenuItem mntmClientHome = new JMenuItem("Home");
		mntmClientHome.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				frmClientEditor.dispose();
			}
		});
		mnClient.add(mntmClientHome);

		JMenuItem mntmChangeClient = new JMenuItem("Change Client");
		mntmChangeClient.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				frmClientEditor.dispose();
				ClientLogin.showThis();
			}
		});
		mnClient.add(mntmChangeClient);

		JMenu mnEdit = new JMenu("Edit");
		menuBar.add(mnEdit);

		JMenuItem mntmReset = new JMenuItem("Reset");
		mntmReset.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				frmClientEditor.dispose();
				showThis(existIC);
			}
		});
		mnEdit.add(mntmReset);

		JMenuItem mntmDelete = new JMenuItem("Delete Client");
		mntmDelete.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				if (UI.popupMessages.createYesNo("Any related info and accounts will be DELETED for this client, continue?", "Client Deletion")) {


					if (ClientCRUD.delete(existIC)) {
						UI.popupMessages.create("Account related info deleted successfully!", "Delete Status");

						UI.popupMessages.create("No traces of client found!", "Client Status");
						frmClientEditor.dispose();
						ClientHome.destroyThis();

					}
				}



			}
		});
		mnEdit.add(mntmDelete);
	}

	public static Boolean showThis(Long ICNo) {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch(Exception e) {
			System.out.println("Error setting native LAF: " + e);
		}

		try {
			retrieveClient(ICNo);
			ClientEdit window = new ClientEdit();
			window.frmClientEditor.setVisible(true);
			window.frmClientEditor.setLocationRelativeTo(null);

		} catch(Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	public static void retrieveClient(Long ICNo){
		retrievedClientRecord = ClientCRUD.retrieve(ICNo);
		//[0]		 [1]   [2]	[3]		[4]		[5]	 [6]	[7]	 [8]
		//accountNo, name, IC, contact, email, salt, pass, type, date

		existAccountNo = Integer.parseInt(retrievedClientRecord[0]);
		existLegalName = retrievedClientRecord[1];
		existIC = Long.parseLong(retrievedClientRecord[2]);
		existContact = Long.parseLong(retrievedClientRecord[3]);
		existEmail = retrievedClientRecord[4];
		existType = retrievedClientRecord[7];
		existDate = retrievedClientRecord[8];
		System.out.println(existAccountNo);
	}
}
