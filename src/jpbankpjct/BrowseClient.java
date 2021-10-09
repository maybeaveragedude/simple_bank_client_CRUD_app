package jpbankpjct;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.UIManager;
import javax.swing.WindowConstants;

public class BrowseClient {

	private JFrame frmBrowseClient;

	/**
	 * Launch the application.
	 */
	
	/**
	 * Create the application.
	 */
	public BrowseClient() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmBrowseClient = new JFrame();
		frmBrowseClient.setTitle("Browse Client");
		frmBrowseClient.setBounds(100, 100, 540, 550);
		frmBrowseClient.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		frmBrowseClient.getContentPane().setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setMaximumSize(new Dimension(218, 32767));
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.setForeground(Color.BLACK);
		scrollPane.setFont(new Font("Tahoma", Font.PLAIN, 11));
		scrollPane.setBackground(SystemColor.menu);
		scrollPane.setBounds(10, 77, 504, 401);
		frmBrowseClient.getContentPane().add(scrollPane);

		JPanel panBrowse = new JPanel();
		scrollPane.setViewportView(panBrowse);
		GridBagLayout gbl_panBrowse = new GridBagLayout();
		gbl_panBrowse.columnWidths = new int[]{494, 0};


		int[] initArr = new int[]{};
		gbl_panBrowse.rowHeights = initArr;
		gbl_panBrowse.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_panBrowse.rowWeights = new double[]{};
		panBrowse.setLayout(gbl_panBrowse);



		int i = 0;

		try {

			String clientRecord;
			String[] returnRecord;

			File file = new File("db/clientdetails.txt");

			if (!file.exists()) {

				file.createNewFile();
			}

			RandomAccessFile raf = new RandomAccessFile(file, "r");


			while (raf.getFilePointer() < raf.length()) {

				//getting the client record string line
				clientRecord = raf.readLine();

				returnRecord = clientRecord.split(",");



				//[0]		 [1]   [2]	[3]		[4]		[5]	 [6]	[7]	 [8]
				//accountNo, name, IC, contact, email, salt, pass, type, date

				String existAccountNo = returnRecord[0];
				String existLegalName = returnRecord[1];
				//                String existIC = returnRecord[2];
				Long existContact = Long.parseLong(returnRecord[3]);
				String sExistContact = (String.format("%010d",existContact));
				String existEmail = returnRecord[4];
				String existType = returnRecord[7];
				//                String existDate = returnRecord[8];



				//                change the components inside the frame with details of the logged in client
				JPanel panRecord = new JPanel();
				panRecord.setBackground(Color.ORANGE);
				panRecord.setLayout(null);
				GridBagConstraints gbc_panel = new GridBagConstraints();
				gbc_panel.insets = new Insets(5, 5, 5, 5);
				gbc_panel.fill = GridBagConstraints.BOTH;
				gbc_panel.gridx = 0;
				gbc_panel.gridy = i;
				panBrowse.add(panRecord, gbc_panel);

				JLabel lblAccNo = new JLabel("#**");
				lblAccNo.setFont(new Font("Tahoma", Font.PLAIN, 12));
				lblAccNo.setBounds(10, 23, 27, 14);
				//            		panRecord.add(lblAccNo);

				JLabel lblName = new JLabel("Name");
				lblName.setFont(new Font("Tahoma", Font.PLAIN, 12));
				lblName.setBounds(147, 11, 153, 38);
				//            		panRecord.add(lblName);

				JLabel lblContact = new JLabel("Contact");
				lblContact.setBounds(310, 11, 172, 14);
				//            		panRecord.add(lblContact);

				JLabel lblEmail = new JLabel("Email");
				lblEmail.setBounds(310, 35, 172, 14);
				//            		panRecord.add(lblEmail);

				JLabel lblType = new JLabel("Current");
				lblType.setFont(new Font("Tahoma", Font.PLAIN, 12));
				lblType.setBounds(59, 23, 78, 14);
				//            		panRecord.add(lblType);


				lblAccNo.setText("# " + existAccountNo);
				panRecord.add(lblAccNo);

				lblName.setText(existLegalName);
				panRecord.add(lblName);

				lblContact.setText(sExistContact);
				panRecord.add(lblContact);

				lblEmail.setText(existEmail);
				panRecord.add(lblEmail);

				lblType.setText(existType);
				panRecord.add(lblType);


				i++;


				Integer newArrayLength = initArr.length + i;

				int[] tempArray = new int[newArrayLength];

				for (int x = 0; x < newArrayLength; x++) {
					tempArray[x] = 70;
				}



				gbl_panBrowse.rowHeights = tempArray;
				panBrowse.setLayout(gbl_panBrowse);

			}

			raf.close();
		}

		catch (IOException ioe) {

			System.out.println(ioe);
		}
		catch (NumberFormatException nef) {

			System.out.println(nef);
		}

		JLabel lblNewLabel = new JLabel("Browse");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel.setBounds(10, 11, 133, 28);
		frmBrowseClient.getContentPane().add(lblNewLabel);

		JPanel panHeader = new JPanel();
		panHeader.setBounds(10, 50, 504, 28);
		frmBrowseClient.getContentPane().add(panHeader);
		panHeader.setLayout(null);

		JLabel lblTitleAccNo = new JLabel("Acc No.");
		lblTitleAccNo.setBounds(10, 7, 46, 14);
		panHeader.add(lblTitleAccNo);

		JLabel lblTitleName = new JLabel("Name");
		lblTitleName.setBounds(153, 7, 46, 14);
		panHeader.add(lblTitleName);

		JLabel lblTitleContact = new JLabel("Contacts");
		lblTitleContact.setBounds(317, 7, 76, 14);
		panHeader.add(lblTitleContact);

		JLabel lblTitleType = new JLabel("Type");
		lblTitleType.setBounds(66, 7, 46, 14);
		panHeader.add(lblTitleType);

		JMenuBar menuBar = new JMenuBar();
		frmBrowseClient.setJMenuBar(menuBar);

		JMenu mnEdit = new JMenu("Edit");
		menuBar.add(mnEdit);

		JMenuItem mntmRefresh = new JMenuItem("Refresh");
		mntmRefresh.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				frmBrowseClient.dispose();
				showThis();
			}
		});
		mnEdit.add(mntmRefresh);

		JMenu mnClient = new JMenu("Client");
		menuBar.add(mnClient);

		JMenuItem mntmRegisterClient = new JMenuItem("Register");
		mntmRegisterClient.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				ClientRegistration.showThis();
			}
		});
		mnClient.add(mntmRegisterClient);

		JMenuItem mntmLoginClient = new JMenuItem("Login");
		mntmLoginClient.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				ClientLogin.showThis();
			}
		});
		mnClient.add(mntmLoginClient);
	}

	public static void showThis(){
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch(Exception e) {
			System.out.println("Error setting native LAF: " + e);
		}
		BrowseClient window = new BrowseClient();
		window.frmBrowseClient.setVisible(true);
		window.frmBrowseClient.setLocationRelativeTo(null);

	}

}
