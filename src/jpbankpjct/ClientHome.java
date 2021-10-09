package jpbankpjct;

import java.awt.Color;
import java.awt.Desktop;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Rectangle;
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
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.WindowConstants;
import javax.swing.border.EmptyBorder;

public class ClientHome extends JFrame{

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	private static JFrame clientHome;

	private JPanel contentPane;
	private static String[] retrievedClientRecord;
	public static Integer existAccountNo;
	public static String existLegalName, existEmail, existType, existDate, existEncrytedPass;
	public static Long existIC, existContact;


	/**
	 * Launch the application.
	 */
	//	public static void main(String[] args) {
	//		try {
	//			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
	//		} catch(Exception e) {
	//			System.out.println("Error setting native LAF: " + e);
	//		}
	//		EventQueue.invokeLater(new Runnable() {
	//			@Override
	//			public void run() {
	//				try {
	//					new ClientHome();
	//					ClientHome.clientHome.setVisible(true);
	//
	//				} catch (Exception e) {
	//					e.printStackTrace();
	//				}
	//			}
	//		});
	//	}

	/**
	 * Create the frame.
	 */
	public ClientHome() {
		clientHome = new JFrame();
		clientHome.setTitle("Client Home");
		clientHome.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		clientHome.setBounds(100, 100, 602, 366);

		JMenuBar menuBar = new JMenuBar();
		menuBar.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		menuBar.setBackground(new Color(240, 240, 240));
		clientHome.setJMenuBar(menuBar);

		JMenu mnStaff = new JMenu("Staff");
		mnStaff.setBackground(new Color(240, 240, 240));
		mnStaff.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		menuBar.add(mnStaff);

		JMenuItem mntmLogoutStaff = new JMenuItem("Logout");
		mntmLogoutStaff.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		mntmLogoutStaff.setBackground(new Color(240, 240, 240));
		mnStaff.add(mntmLogoutStaff);

		JMenu mnClient = new JMenu("Client");
		mnClient.setBackground(new Color(240, 240, 240));
		mnClient.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		menuBar.add(mnClient);

		JMenuItem mntmRegClient = new JMenuItem("Register");
		mntmRegClient.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		mntmRegClient.setBackground(new Color(240, 240, 240));
		mnClient.add(mntmRegClient);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		clientHome.setContentPane(contentPane);

		JPanel panel = new JPanel();
		panel.setBackground(SystemColor.info);

		JLabel lblNewLabel = new JLabel("Recent Transactions");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));

		JButton btnWithdraw = new JButton("Withdraw");
		btnWithdraw.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

			}
		});
		btnWithdraw.setBackground(new Color(240, 240, 240));
		btnWithdraw.setFont(new Font("Tahoma", Font.PLAIN, 12));

		JButton btnDeposit = new JButton("Deposit");
		btnDeposit.setBackground(new Color(240, 240, 240));
		btnDeposit.setFont(new Font("Tahoma", Font.PLAIN, 12));

		JLabel lblTitleBalance = new JLabel("Balance: ");
		lblTitleBalance.setFont(new Font("Tahoma", Font.PLAIN, 16));

		JLabel lblBalance = new JLabel("tempbalance");
		lblBalance.setFont(new Font("Tahoma", Font.PLAIN, 18));

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.setFont(new Font("Tahoma", Font.PLAIN, 11));
		scrollPane.setForeground(new Color(0, 0, 0));
		scrollPane.setBackground(new Color(240, 240, 240));
		scrollPane.setMaximumSize(new Dimension(218, 32767));
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
				gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
						.addContainerGap()
						.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(panel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addGroup(gl_contentPane.createSequentialGroup()
										.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
												.addGroup(gl_contentPane.createSequentialGroup()
														.addComponent(lblTitleBalance)
														.addPreferredGap(ComponentPlacement.RELATED)
														.addComponent(lblBalance, GroupLayout.PREFERRED_SIZE, 108, GroupLayout.PREFERRED_SIZE))
												.addGroup(gl_contentPane.createSequentialGroup()
														.addComponent(btnWithdraw, GroupLayout.PREFERRED_SIZE, 150, GroupLayout.PREFERRED_SIZE)
														.addPreferredGap(ComponentPlacement.RELATED)
														.addComponent(btnDeposit, GroupLayout.PREFERRED_SIZE, 150, GroupLayout.PREFERRED_SIZE)))
										.addGap(31)
										.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
												.addComponent(lblNewLabel)
												.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 219, GroupLayout.PREFERRED_SIZE))))
						.addContainerGap())
				);
		gl_contentPane.setVerticalGroup(
				gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
						.addGap(7)
						.addComponent(panel, GroupLayout.PREFERRED_SIZE, 75, GroupLayout.PREFERRED_SIZE)
						.addGap(57)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
								.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
										.addComponent(lblTitleBalance)
										.addComponent(lblBalance, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE))
								.addComponent(lblNewLabel))
						.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createSequentialGroup()
										.addGap(18)
										.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
												.addComponent(btnDeposit, GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE)
												.addComponent(btnWithdraw, GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE)))
								.addGroup(gl_contentPane.createSequentialGroup()
										.addPreferredGap(ComponentPlacement.RELATED)
										.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
						.addContainerGap())
				);

		JPanel panTransactions = new JPanel();
		panTransactions.setSize(new Dimension(218, 32767));
		panTransactions.setBounds(new Rectangle(212, 0, 0, 0));
		panTransactions.setMaximumSize(new Dimension(212, 32767));
		panTransactions.setBackground(SystemColor.inactiveCaption);
		scrollPane.setViewportView(panTransactions);
		GridBagLayout gbl_panTransactions = new GridBagLayout();
		int[] initArr = new int[]{};
		gbl_panTransactions.columnWidths = new int[]{216, 0};
		gbl_panTransactions.rowHeights = initArr;
		gbl_panTransactions.columnWeights = new double[]{0.0, Double.MIN_VALUE};
		gbl_panTransactions.rowWeights = new double[]{0.0, 0.0};
		panTransactions.setLayout(gbl_panTransactions);

		JPanel panTransRecord = new JPanel();
		panTransRecord.setBackground(new Color(152, 251, 152));
		panTransRecord.setPreferredSize(new Dimension(220, 36));
		panTransRecord.setLayout(null);
		GridBagConstraints gbc_panTransRecord = new GridBagConstraints();
		gbc_panTransRecord.insets = new Insets(5, 5, 5, 5);
		gbc_panTransRecord.gridx = 0;
		gbc_panTransRecord.gridy = 0;
		panTransactions.add(panTransRecord, gbc_panTransRecord);

		JLabel lblTitleAmount = new JLabel("Amount: ");
		lblTitleAmount.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		lblTitleAmount.setBounds(12, 13, 64, 16);
		panTransRecord.add(lblTitleAmount);

		JLabel lblTempAmount = new JLabel("temp");
		lblTempAmount.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		lblTempAmount.setBounds(76, 13, 52, 16);
		panTransRecord.add(lblTempAmount);

		JLabel lblDateCreated = new JLabel("Date");
		lblDateCreated.setHorizontalAlignment(SwingConstants.TRAILING);
		lblDateCreated.setBounds(162, 15, 46, 14);
		panTransRecord.add(lblDateCreated);

		JPanel panTransRecord_1 = new JPanel();
		panTransRecord_1.setPreferredSize(new Dimension(212, 36));
		GridBagConstraints gbc_panTransRecord_1 = new GridBagConstraints();
		gbc_panTransRecord_1.fill = GridBagConstraints.BOTH;
		gbc_panTransRecord_1.gridx = 0;
		gbc_panTransRecord_1.gridy = 1;
		panTransactions.add(panTransRecord_1, gbc_panTransRecord_1);

		JLabel lblTitleType = new JLabel("Type:");
		lblTitleType.setFont(new Font("Tahoma", Font.PLAIN, 16));

		JLabel lblType = new JLabel("temptype");
		lblType.setFont(new Font("Tahoma", Font.PLAIN, 16));

		JLabel lblGreetings = new JLabel("Greet,");
		lblGreetings.setFont(new Font("Tahoma", Font.BOLD, 24));

		JLabel lblName = new JLabel("templaceholder");
		lblName.setFont(new Font("Tahoma", Font.PLAIN, 24));

		JLabel lblTitleAccountNo = new JLabel("Account No.:");
		lblTitleAccountNo.setFont(new Font("Tahoma", Font.PLAIN, 16));

		JLabel lblAccountNo = new JLabel("41212");
		lblAccountNo.setFont(new Font("Tahoma", Font.PLAIN, 16));

		JButton btnShowQR = new JButton("Show QR");
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
				gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
						.addContainerGap()
						.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panel.createSequentialGroup()
										.addComponent(lblGreetings)
										.addPreferredGap(ComponentPlacement.RELATED)
										.addComponent(lblName, GroupLayout.PREFERRED_SIZE, 317, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_panel.createSequentialGroup()
										.addComponent(lblTitleAccountNo)
										.addGap(18)
										.addComponent(lblAccountNo, GroupLayout.PREFERRED_SIZE, 139, GroupLayout.PREFERRED_SIZE)
										.addGap(18)
										.addComponent(lblTitleType, GroupLayout.PREFERRED_SIZE, 55, GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(ComponentPlacement.RELATED)
										.addComponent(lblType, GroupLayout.PREFERRED_SIZE, 96, GroupLayout.PREFERRED_SIZE)))
						.addPreferredGap(ComponentPlacement.RELATED, 22, Short.MAX_VALUE)
						.addComponent(btnShowQR)
						.addContainerGap())
				);
		gl_panel.setVerticalGroup(
				gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
						.addContainerGap()
						.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
								.addComponent(btnShowQR, GroupLayout.DEFAULT_SIZE, 55, Short.MAX_VALUE)
								.addGroup(Alignment.LEADING, gl_panel.createSequentialGroup()
										.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
												.addComponent(lblGreetings)
												.addComponent(lblName))
										.addPreferredGap(ComponentPlacement.RELATED)
										.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
												.addComponent(lblType)
												.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
														.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
																.addComponent(lblTitleAccountNo)
																.addComponent(lblAccountNo))
														.addComponent(lblTitleType)))))
						.addContainerGap())
				);
		panel.setLayout(gl_panel);
		clientHome.getContentPane().setLayout(gl_contentPane);
	}

	public ClientHome(Integer AccountNo) {
		clientHome = new JFrame();
		clientHome.setTitle("Client Home");
		clientHome.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		clientHome.setBounds(100, 100, 602, 366);


		ClientCRUD.transLength(AccountNo);
		String[] returnRecord;

		retrieveClient(AccountNo);



		//		while (i <= length) {
		//			String getList = ClientCRUD.retrieveTransactions(AccountNo, tempSkip);
		//			String[] formList = getList.split(",");
		//			tempSkip = Integer.parseInt(formList[0]);
		//			System.out.println(tempSkip);
		//			System.out.println(formList[4]);
		//			i++;
		//		}

		Double clientBalance = ClientCRUD.getBalance(AccountNo);

		JMenuBar menuBar = new JMenuBar();
		menuBar.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		menuBar.setBackground(new Color(240, 240, 240));
		clientHome.setJMenuBar(menuBar);

		JMenu mnStaff = new JMenu("Staff");
		mnStaff.setBackground(new Color(240, 240, 240));
		mnStaff.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		menuBar.add(mnStaff);

		JMenuItem mntmStaffHome = new JMenuItem("Home");
		mntmStaffHome.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		mntmStaffHome.setBackground(new Color(240, 240, 240));
		mnStaff.add(mntmStaffHome);
		mntmStaffHome.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				//				frmStaffHome.dispose();
				StaffHome.unhideThis();
			}
		});

		JMenuItem mntmLogoutStaff = new JMenuItem("Logout");
		mntmLogoutStaff.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		mntmLogoutStaff.setBackground(new Color(240, 240, 240));
		mnStaff.add(mntmLogoutStaff);
		mntmLogoutStaff.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				//				frmStaffHome.dispose();
				StaffHome.absLogout();
			}
		});

		JMenu mnClient = new JMenu("Client");
		mnClient.setBackground(new Color(240, 240, 240));
		mnClient.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		menuBar.add(mnClient);

		JMenuItem mntmRegClient = new JMenuItem("Register New");
		mntmRegClient.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		mntmRegClient.setBackground(new Color(240, 240, 240));
		mntmRegClient.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				ClientRegistration.showThis();

			}
		});
		mnClient.add(mntmRegClient);

		JMenuItem mntmEditThis = new JMenuItem("Edit");
		mntmEditThis.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		mntmEditThis.setBackground(new Color(240, 240, 240));
		mntmEditThis.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				ClientEdit.showThis(existIC);

			}
		});
		mnClient.add(mntmEditThis);

		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		clientHome.setContentPane(contentPane);

		JPanel panel = new JPanel();
		panel.setBackground(SystemColor.info);

		JLabel lblTitleRecent = new JLabel("Recent Transactions");
		lblTitleRecent.setFont(new Font("Tahoma", Font.PLAIN, 14));

		JButton btnWithdraw = new JButton("Withdraw");
		btnWithdraw.setFont(new Font("Tahoma", Font.PLAIN, 12));

		btnWithdraw.setBackground(new Color(240, 240, 240));
		btnWithdraw.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnWithdraw.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Withdraw.showThis(AccountNo, existType, clientBalance);

			}
		});

		JButton btnDeposit = new JButton("Deposit");
		btnDeposit.setBackground(new Color(240, 240, 240));
		btnDeposit.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnDeposit.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Deposit.showThis(AccountNo, clientBalance);

			}
		});

		JLabel lblTitleBalance = new JLabel("Balance: ");
		lblTitleBalance.setFont(new Font("Tahoma", Font.PLAIN, 16));

		JLabel lblBalance = new JLabel("RM " + String.valueOf(clientBalance));
		lblBalance.setFont(new Font("Tahoma", Font.PLAIN, 18));

		JPanel panTransactions = new JPanel();
		panTransactions.setBackground(SystemColor.inactiveCaptionBorder);
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setMaximumSize(new Dimension(220, 32767));
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
				gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
						.addContainerGap()
						.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(panel, GroupLayout.DEFAULT_SIZE, 556, Short.MAX_VALUE)
								.addGroup(gl_contentPane.createSequentialGroup()
										.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
												.addGroup(gl_contentPane.createSequentialGroup()
														.addComponent(lblTitleBalance)
														.addPreferredGap(ComponentPlacement.RELATED)
														.addComponent(lblBalance, GroupLayout.PREFERRED_SIZE, 108, GroupLayout.PREFERRED_SIZE))
												.addGroup(gl_contentPane.createSequentialGroup()
														.addComponent(btnWithdraw, GroupLayout.PREFERRED_SIZE, 150, GroupLayout.PREFERRED_SIZE)
														.addPreferredGap(ComponentPlacement.RELATED)
														.addComponent(btnDeposit, GroupLayout.PREFERRED_SIZE, 150, GroupLayout.PREFERRED_SIZE)))
										.addGap(31)
										.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
												.addComponent(lblTitleRecent)
												.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 219, GroupLayout.PREFERRED_SIZE))))
						.addContainerGap())
				);
		gl_contentPane.setVerticalGroup(
				gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
						.addGap(7)
						.addComponent(panel, GroupLayout.PREFERRED_SIZE, 83, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.UNRELATED)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
								.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
										.addComponent(lblTitleBalance)
										.addComponent(lblBalance, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE))
								.addComponent(lblTitleRecent))
						.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createSequentialGroup()
										.addGap(18)
										.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
												.addComponent(btnDeposit, GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE)
												.addComponent(btnWithdraw, GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE)))
								.addGroup(gl_contentPane.createSequentialGroup()
										.addPreferredGap(ComponentPlacement.RELATED)
										.addComponent(scrollPane)))
						.addContainerGap())
				);
		//		panTransactions.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		scrollPane.setViewportView(panTransactions);

		GridBagLayout gbl_panTransactions = new GridBagLayout();
		int[] initArr = new int[]{};
		gbl_panTransactions.columnWidths = new int[]{216, 0};
		gbl_panTransactions.rowHeights = initArr; //42 default
		gbl_panTransactions.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_panTransactions.rowWeights = new double[]{};
		panTransactions.setLayout(gbl_panTransactions);

		int i = 0;

		try {

			String clientRecord;

			Integer existAccountNo;

			File file = new File("db/transactions.txt");

			if (!file.exists()) {

				file.createNewFile();
			}

			RandomAccessFile raf = new RandomAccessFile(file, "r");


			while (raf.getFilePointer() < raf.length()) {

				// reading line from the file.
				clientRecord = raf.readLine();

				returnRecord = clientRecord.split(",");

				// separating name and number.
				existAccountNo = Integer.parseInt(returnRecord[1]);

				if (existAccountNo.equals(AccountNo)) {
					Double checkTransactionType = 0.0;
					JPanel panTransRecord = new JPanel();

					//                	panTransRecord.setBackground(new Color(152, 251, 152));
					panTransRecord.setLayout(null);
					panTransRecord.setPreferredSize(new Dimension(210, 36));
					GridBagConstraints gbc_panTransRecord = new GridBagConstraints();
					gbc_panTransRecord.insets = new Insets(5, 5, 5, 5);
					gbc_panTransRecord.fill = GridBagConstraints.BOTH;
					gbc_panTransRecord.gridx = 0;
					gbc_panTransRecord.gridy = i;
					panTransactions.add(panTransRecord, gbc_panTransRecord);

					//            		JLabel lblTitleAmount = new JLabel("Amount: ");
					//            		lblTitleAmount.setFont(new Font("Segoe UI", Font.PLAIN, 14));
					//            		lblTitleAmount.setBounds(12, 13, 64, 16);
					//            		panTransRecord.add(lblTitleAmount);

					JLabel lblTempAmount = new JLabel("");

					//If withdrawal amount = 0, transaction type is DEPOSIT [Vice versa]
					if (Double.parseDouble(returnRecord[2]) == checkTransactionType) { //DEPOSIT

						panTransRecord.setBackground(new Color(152, 251, 152));
						lblTempAmount.setText(" + RM " + returnRecord[3]);

					} else if (Double.parseDouble(returnRecord[3]) == checkTransactionType) { //WITHDRAW

						panTransRecord.setBackground(new Color(200, 40, 40));
						lblTempAmount.setText(" - RM " + returnRecord[2]);

					}



					lblTempAmount.setFont(new Font("Segoe UI", Font.PLAIN, 14));
					lblTempAmount.setBounds(12, 13, 120, 16);
					panTransRecord.add(lblTempAmount);

					JLabel lblDateCreated = new JLabel(returnRecord[4]);
					lblDateCreated.setHorizontalAlignment(SwingConstants.TRAILING);
					lblDateCreated.setBounds(110, 15, 80, 14);
					panTransRecord.add(lblDateCreated);
					System.out.println(clientRecord);
					i++;


					Integer newArrayLength = initArr.length + i;

					int[] tempArray = new int[newArrayLength];

					for (int x = 0; x < newArrayLength; x++) {
						tempArray[x] = 42;
					}



					gbl_panTransactions.rowHeights = tempArray;
					panTransactions.setLayout(gbl_panTransactions);
				}
			}
			raf.close();
		}

		catch (IOException ioe) {

			System.out.println(ioe);
		}
		catch (NumberFormatException nef) {

			System.out.println(nef);
		}

		//		JPanel panTransRecord = new JPanel();
		//		panTransRecord.setPreferredSize(new Dimension(195, 36));
		//		panTransactions.add(panTransRecord);

		JLabel lblTitleType = new JLabel("Type:");
		lblTitleType.setFont(new Font("Tahoma", Font.PLAIN, 16));

		JLabel lblType = new JLabel(existType);
		lblType.setFont(new Font("Tahoma", Font.PLAIN, 16));

		JLabel lblGreetings = new JLabel("Greet,");
		lblGreetings.setFont(new Font("Tahoma", Font.BOLD, 24));

		JLabel lblName = new JLabel(existLegalName);
		lblName.setFont(new Font("Tahoma", Font.PLAIN, 24));

		JLabel lblTitleAccountNo = new JLabel("Account No.:");
		lblTitleAccountNo.setFont(new Font("Tahoma", Font.PLAIN, 16));

		JLabel lblAccountNo = new JLabel(String.valueOf(existAccountNo));
		lblAccountNo.setFont(new Font("Tahoma", Font.PLAIN, 16));

		JButton btnShowQR = new JButton("Show QR");
		btnShowQR.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					File QRfile = new File("QRrepo/client" + AccountNo +".png");
					Desktop dt = Desktop.getDesktop();

					if (!QRfile.exists()) {
						// Create a new file if not exists.
						if (UI.popupMessages.createYesNo("QR login doesnt exist for this account, create new?", "Missing File")) {

							if(ClientCRUD.genQR(AccountNo, existEncrytedPass)) {
								UI.popupMessages.create("QR login generated!", "QR Status");
								dt.open(QRfile);
							}

						} else {
							UI.popupMessages.create("Operation cancelled with non-existing QR login image.", "Missing File");
						}
					} else {
						dt.open(QRfile);
					}


				} catch (IOException e1) {
					e1.printStackTrace();
				}
				System.out.println("QR Image shown.");

			}
		});



		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
				gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
						.addContainerGap()
						.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panel.createSequentialGroup()
										.addComponent(lblGreetings)
										.addPreferredGap(ComponentPlacement.RELATED)
										.addComponent(lblName, GroupLayout.PREFERRED_SIZE, 317, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_panel.createSequentialGroup()
										.addComponent(lblTitleAccountNo)
										.addGap(18)
										.addComponent(lblAccountNo, GroupLayout.PREFERRED_SIZE, 139, GroupLayout.PREFERRED_SIZE)
										.addGap(18)
										.addComponent(lblTitleType, GroupLayout.PREFERRED_SIZE, 55, GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(ComponentPlacement.RELATED)
										.addComponent(lblType, GroupLayout.PREFERRED_SIZE, 96, GroupLayout.PREFERRED_SIZE)))
						.addPreferredGap(ComponentPlacement.RELATED, 22, Short.MAX_VALUE)
						.addComponent(btnShowQR)
						.addContainerGap())
				);
		gl_panel.setVerticalGroup(
				gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
						.addContainerGap()
						.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
								.addComponent(btnShowQR, GroupLayout.DEFAULT_SIZE, 55, Short.MAX_VALUE)
								.addGroup(Alignment.LEADING, gl_panel.createSequentialGroup()
										.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
												.addComponent(lblGreetings)
												.addComponent(lblName))
										.addPreferredGap(ComponentPlacement.RELATED)
										.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
												.addComponent(lblType)
												.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
														.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
																.addComponent(lblTitleAccountNo)
																.addComponent(lblAccountNo))
														.addComponent(lblTitleType)))))
						.addContainerGap())
				);
		panel.setLayout(gl_panel);
		clientHome.getContentPane().setLayout(gl_contentPane);
	}


	public static void retrieveClient(Integer AccountNo){
		retrievedClientRecord = ClientCRUD.retrieve(AccountNo);
		//[0]		 [1]   [2]	[3]		[4]		[5]	 [6]	[7]	 [8]
		//accountNo, name, IC, contact, email, salt, pass, type, date

		existAccountNo = Integer.parseInt(retrievedClientRecord[0]);
		existLegalName = retrievedClientRecord[1];
		existIC = Long.parseLong(retrievedClientRecord[2]);
		existContact = Long.parseLong(retrievedClientRecord[3]);
		existEmail = retrievedClientRecord[4];
		existEncrytedPass = retrievedClientRecord[6];
		existType = retrievedClientRecord[7];
		existDate = retrievedClientRecord[8];

	}

	public static void showThis(Integer AccountNo){
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch(Exception e) {
			System.out.println("Error setting native LAF: " + e);
		}
		new ClientHome(AccountNo);
		ClientHome.clientHome.setVisible(true);
		ClientHome.clientHome.setLocationRelativeTo(null);

	}

	public static void destroyThis(){
		clientHome.dispose();

	}

	public static void refresh() {

		clientHome.dispose();
		showThis(existAccountNo);
	}


}
