package jpbankpjct;

import java.awt.Color;
import java.awt.Font;
import java.awt.Insets;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;

public class Deposit {

	private JFrame frmDeposit;
	private JTextField txtDeposit;
	private JTextField txtExistingBalance;
	private JTextField txtFinalBalance;
	Double tempDepositAmount = 0.0, temp = 0.0, finalBalance = 0.0;
	private JTextField txtCustomDeposit;

	/**
	 * Launch the application.
	 */
	//	public static void main(String[] args) {
	//		EventQueue.invokeLater(new Runnable() {
	//			@Override
	//			public void run() {
	//				try {
	//					Deposit window = new Deposit();
	//					window.frmDeposit.setVisible(true);
	//					window.frmDeposit.setLocationRelativeTo(null);
	//				} catch (Exception e) {
	//					e.printStackTrace();
	//				}
	//			}
	//		});
	//	}

	/**
	 * Create the application.
	 */
	public Deposit() {
		frmDeposit = new JFrame();
		frmDeposit.setTitle("Deposit");
		frmDeposit.setBounds(100, 100, 420, 310);
		frmDeposit.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

		JButton btnDeposit10 = new JButton("RM 10");
		btnDeposit10.setBounds(10, 41, 158, 39);
		btnDeposit10.setBackground(new Color(240, 240, 240));
		btnDeposit10.setFont(new Font("Tahoma", Font.PLAIN, 11));

		JLabel lblTitleDepositPreset = new JLabel("Deposit Preset");
		lblTitleDepositPreset.setBounds(10, 13, 110, 17);
		lblTitleDepositPreset.setFont(new Font("Tahoma", Font.PLAIN, 14));

		JButton btnDeposit25 = new JButton("RM 25");
		btnDeposit25.setBounds(10, 86, 158, 39);
		btnDeposit25.setBackground(new Color(240, 240, 240));
		btnDeposit25.setFont(new Font("Tahoma", Font.PLAIN, 11));

		JButton btnDeposit50 = new JButton("RM 50");
		btnDeposit50.setBounds(10, 131, 158, 39);
		btnDeposit50.setBackground(new Color(240, 240, 240));
		btnDeposit50.setFont(new Font("Tahoma", Font.PLAIN, 11));

		JButton btnDeposit100 = new JButton("RM 100");
		btnDeposit100.setBounds(10, 176, 158, 39);
		btnDeposit100.setBackground(new Color(240, 240, 240));
		btnDeposit100.setFont(new Font("Tahoma", Font.PLAIN, 11));

		JButton btnDeposit250 = new JButton("RM 250");
		btnDeposit250.setBounds(10, 223, 158, 39);
		btnDeposit250.setBackground(new Color(240, 240, 240));
		btnDeposit250.setFont(new Font("Tahoma", Font.PLAIN, 11));

		JButton btnSubDeposit10 = new JButton("-");
		btnSubDeposit10.setBounds(174, 41, 40, 39);
		btnSubDeposit10.setMargin(new Insets(2, 6, 2, 6));
		btnSubDeposit10.setFont(new Font("Dialog", Font.PLAIN, 26));
		btnSubDeposit10.setBackground(SystemColor.menu);

		JButton btnAddDeposit10 = new JButton("+");
		btnAddDeposit10.setBounds(220, 41, 40, 39);
		btnAddDeposit10.setMargin(new Insets(2, 6, 2, 6));
		btnAddDeposit10.setFont(new Font("Dialog", Font.PLAIN, 18));
		btnAddDeposit10.setBackground(SystemColor.menu);

		JButton btnSubDeposit25 = new JButton("-");
		btnSubDeposit25.setBounds(174, 86, 40, 39);
		btnSubDeposit25.setMargin(new Insets(2, 6, 2, 6));
		btnSubDeposit25.setFont(new Font("Dialog", Font.PLAIN, 26));
		btnSubDeposit25.setBackground(SystemColor.menu);

		JButton btnAddDeposit25 = new JButton("+");
		btnAddDeposit25.setBounds(220, 86, 40, 39);
		btnAddDeposit25.setMargin(new Insets(2, 6, 2, 6));
		btnAddDeposit25.setFont(new Font("Dialog", Font.PLAIN, 18));
		btnAddDeposit25.setBackground(SystemColor.menu);

		JButton btnSubDeposit50 = new JButton("-");
		btnSubDeposit50.setBounds(174, 131, 40, 39);
		btnSubDeposit50.setMargin(new Insets(2, 6, 2, 6));
		btnSubDeposit50.setFont(new Font("Dialog", Font.PLAIN, 26));
		btnSubDeposit50.setBackground(SystemColor.menu);

		JButton btnAddDeposit50 = new JButton("+");
		btnAddDeposit50.setBounds(220, 131, 40, 39);
		btnAddDeposit50.setMargin(new Insets(2, 6, 2, 6));
		btnAddDeposit50.setFont(new Font("Dialog", Font.PLAIN, 18));
		btnAddDeposit50.setBackground(SystemColor.menu);

		JButton btnSubDeposit100 = new JButton("-");
		btnSubDeposit100.setBounds(174, 178, 40, 39);
		btnSubDeposit100.setMargin(new Insets(2, 6, 2, 6));
		btnSubDeposit100.setFont(new Font("Dialog", Font.PLAIN, 26));
		btnSubDeposit100.setBackground(SystemColor.menu);

		JButton btnAddDeposit100 = new JButton("+");
		btnAddDeposit100.setBounds(220, 178, 40, 39);
		btnAddDeposit100.setMargin(new Insets(2, 6, 2, 6));
		btnAddDeposit100.setFont(new Font("Dialog", Font.PLAIN, 18));
		btnAddDeposit100.setBackground(SystemColor.menu);

		JButton btnSubDeposit250 = new JButton("-");
		btnSubDeposit250.setBounds(174, 223, 40, 39);
		btnSubDeposit250.setMargin(new Insets(2, 6, 2, 6));
		btnSubDeposit250.setFont(new Font("Dialog", Font.PLAIN, 26));
		btnSubDeposit250.setBackground(SystemColor.menu);

		JButton btnAddDeposit250 = new JButton("+");
		btnAddDeposit250.setBounds(220, 223, 40, 39);
		btnAddDeposit250.setMargin(new Insets(2, 6, 2, 6));
		btnAddDeposit250.setFont(new Font("Dialog", Font.PLAIN, 18));
		btnAddDeposit250.setBackground(SystemColor.menu);

		JLabel lblExistingBalance = new JLabel("Existing Balance");
		lblExistingBalance.setBounds(317, 16, 77, 14);
		lblExistingBalance.setFont(new Font("Tahoma", Font.PLAIN, 11));

		txtExistingBalance = new JTextField();
		txtExistingBalance.setText("RM");
		txtExistingBalance.setHorizontalAlignment(SwingConstants.RIGHT);
		txtExistingBalance.setBounds(288, 32, 106, 21);
		txtExistingBalance.setEditable(false);
		txtExistingBalance.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtExistingBalance.setColumns(10);
		frmDeposit.getContentPane().setLayout(null);
		frmDeposit.getContentPane().add(btnDeposit10);
		frmDeposit.getContentPane().add(btnSubDeposit10);
		frmDeposit.getContentPane().add(btnAddDeposit10);
		frmDeposit.getContentPane().add(btnDeposit25);
		frmDeposit.getContentPane().add(btnSubDeposit25);
		frmDeposit.getContentPane().add(btnAddDeposit25);
		frmDeposit.getContentPane().add(lblExistingBalance);
		frmDeposit.getContentPane().add(txtExistingBalance);
		frmDeposit.getContentPane().add(lblTitleDepositPreset);
		frmDeposit.getContentPane().add(btnDeposit50);
		frmDeposit.getContentPane().add(btnSubDeposit50);
		frmDeposit.getContentPane().add(btnAddDeposit50);
		frmDeposit.getContentPane().add(btnDeposit100);
		frmDeposit.getContentPane().add(btnSubDeposit100);
		frmDeposit.getContentPane().add(btnAddDeposit100);
		frmDeposit.getContentPane().add(btnDeposit250);
		frmDeposit.getContentPane().add(btnSubDeposit250);
		frmDeposit.getContentPane().add(btnAddDeposit250);

		txtDeposit = new JTextField();
		txtDeposit.setText("- RM");
		txtDeposit.setHorizontalAlignment(SwingConstants.RIGHT);
		txtDeposit.setBackground(new Color(255, 255, 255));
		txtDeposit.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtDeposit.setColumns(10);
		txtDeposit.setBounds(288, 125, 106, 21);
		frmDeposit.getContentPane().add(txtDeposit);

		JLabel lblProposedDeposit = new JLabel("Deposit Amount");
		lblProposedDeposit.setHorizontalAlignment(SwingConstants.RIGHT);
		lblProposedDeposit.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblProposedDeposit.setBounds(298, 109, 96, 14);
		frmDeposit.getContentPane().add(lblProposedDeposit);

		JLabel lblFinalBalance = new JLabel("Final Balance");
		lblFinalBalance.setHorizontalAlignment(SwingConstants.RIGHT);
		lblFinalBalance.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblFinalBalance.setBounds(317, 156, 77, 14);
		frmDeposit.getContentPane().add(lblFinalBalance);

		txtFinalBalance = new JTextField();
		txtFinalBalance.setText("RM");
		txtFinalBalance.setHorizontalAlignment(SwingConstants.RIGHT);
		txtFinalBalance.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtFinalBalance.setColumns(10);
		txtFinalBalance.setBackground(Color.WHITE);
		txtFinalBalance.setBounds(288, 173, 106, 26);
		frmDeposit.getContentPane().add(txtFinalBalance);

		JButton btnConfirm = new JButton("Confirm");
		btnConfirm.setBackground(new Color(240, 240, 240));
		btnConfirm.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnConfirm.setBounds(288, 210, 106, 26);
		frmDeposit.getContentPane().add(btnConfirm);

		JButton btnCancel = new JButton("Cancel");
		btnCancel.setBackground(new Color(240, 240, 240));
		btnCancel.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnCancel.setBounds(288, 236, 106, 26);
		frmDeposit.getContentPane().add(btnCancel);

		txtCustomDeposit = new JTextField();
		txtCustomDeposit.setText("- RM");
		txtCustomDeposit.setHorizontalAlignment(SwingConstants.RIGHT);
		txtCustomDeposit.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtCustomDeposit.setColumns(10);
		txtCustomDeposit.setBackground(Color.WHITE);
		txtCustomDeposit.setBounds(288, 80, 106, 21);
		frmDeposit.getContentPane().add(txtCustomDeposit);

		JLabel lblCustomDeposit = new JLabel("Deposit Amount");
		lblCustomDeposit.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCustomDeposit.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblCustomDeposit.setBounds(298, 64, 96, 14);
		frmDeposit.getContentPane().add(lblCustomDeposit);
	}

	public Deposit(Integer accountNo, Double existingBalance) {


		frmDeposit = new JFrame();
		frmDeposit.setTitle("Deposit");
		frmDeposit.setBounds(100, 100, 420, 310);
		frmDeposit.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);



		JButton btnDeposit10 = new JButton("RM 10");
		btnDeposit10.setBounds(10, 41, 158, 39);
		btnDeposit10.setBackground(new Color(240, 240, 240));
		btnDeposit10.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnDeposit10.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				tempDepositAmount += 10.0;
				temp = 10.0;
				accumulateBalance(tempDepositAmount, temp, existingBalance);
			}
		});


		JLabel lblTitleDepositPreset = new JLabel("Deposit Preset");
		lblTitleDepositPreset.setBounds(10, 13, 110, 17);
		lblTitleDepositPreset.setFont(new Font("Tahoma", Font.PLAIN, 14));

		JButton btnDeposit25 = new JButton("RM 25");
		btnDeposit25.setBounds(10, 86, 158, 39);
		btnDeposit25.setBackground(new Color(240, 240, 240));
		btnDeposit25.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnDeposit25.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				tempDepositAmount += 25.0;
				temp = 25.0;
				accumulateBalance(tempDepositAmount, temp, existingBalance);
			}
		});

		JButton btnDeposit50 = new JButton("RM 50");
		btnDeposit50.setBounds(10, 131, 158, 39);
		btnDeposit50.setBackground(new Color(240, 240, 240));
		btnDeposit50.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnDeposit50.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				tempDepositAmount += 50.0;
				temp = 50.0;
				accumulateBalance(tempDepositAmount, temp, existingBalance);
			}
		});

		JButton btnDeposit100 = new JButton("RM 100");
		btnDeposit100.setBounds(10, 176, 158, 39);
		btnDeposit100.setBackground(new Color(240, 240, 240));
		btnDeposit100.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnDeposit100.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				tempDepositAmount += 100.0;
				temp = 100.0;
				accumulateBalance(tempDepositAmount, temp, existingBalance);
			}
		});

		JButton btnDeposit250 = new JButton("RM 250");
		btnDeposit250.setBounds(10, 223, 158, 39);
		btnDeposit250.setBackground(new Color(240, 240, 240));
		btnDeposit250.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnDeposit250.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				tempDepositAmount += 250.0;
				temp = 250.0;
				accumulateBalance(tempDepositAmount, temp, existingBalance);
			}
		});

		JButton btnSubDeposit10 = new JButton("-");
		btnSubDeposit10.setBounds(174, 41, 40, 39);
		btnSubDeposit10.setMargin(new Insets(2, 6, 2, 6));
		btnSubDeposit10.setFont(new Font("Dialog", Font.PLAIN, 26));
		btnSubDeposit10.setBackground(SystemColor.menu);
		btnSubDeposit10.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				tempDepositAmount -= 10.0;
				temp = 10.0;
				accumulateBalance(tempDepositAmount, temp, existingBalance);
			}
		});


		JButton btnAddDeposit10 = new JButton("+");
		btnAddDeposit10.setBounds(220, 41, 40, 39);
		btnAddDeposit10.setMargin(new Insets(2, 6, 2, 6));
		btnAddDeposit10.setFont(new Font("Dialog", Font.PLAIN, 18));
		btnAddDeposit10.setBackground(SystemColor.menu);
		btnAddDeposit10.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				tempDepositAmount += 10.0;
				temp = 10.0;
				accumulateBalance(tempDepositAmount, temp, existingBalance);
			}
		});

		JButton btnSubDeposit25 = new JButton("-");
		btnSubDeposit25.setBounds(174, 86, 40, 39);
		btnSubDeposit25.setMargin(new Insets(2, 6, 2, 6));
		btnSubDeposit25.setFont(new Font("Dialog", Font.PLAIN, 26));
		btnSubDeposit25.setBackground(SystemColor.menu);
		btnSubDeposit25.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				tempDepositAmount -= 25.0;
				temp = 25.0;
				accumulateBalance(tempDepositAmount, temp, existingBalance);
			}
		});


		JButton btnAddDeposit25 = new JButton("+");
		btnAddDeposit25.setBounds(220, 86, 40, 39);
		btnAddDeposit25.setMargin(new Insets(2, 6, 2, 6));
		btnAddDeposit25.setFont(new Font("Dialog", Font.PLAIN, 18));
		btnAddDeposit25.setBackground(SystemColor.menu);
		btnAddDeposit25.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				tempDepositAmount += 25.0;
				temp = 25.0;
				accumulateBalance(tempDepositAmount, temp, existingBalance);
			}
		});

		JButton btnSubDeposit50 = new JButton("-");
		btnSubDeposit50.setBounds(174, 131, 40, 39);
		btnSubDeposit50.setMargin(new Insets(2, 6, 2, 6));
		btnSubDeposit50.setFont(new Font("Dialog", Font.PLAIN, 26));
		btnSubDeposit50.setBackground(SystemColor.menu);
		btnSubDeposit50.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				tempDepositAmount -= 50.0;
				temp = 50.0;
				accumulateBalance(tempDepositAmount, temp, existingBalance);
			}
		});

		JButton btnAddDeposit50 = new JButton("+");
		btnAddDeposit50.setBounds(220, 131, 40, 39);
		btnAddDeposit50.setMargin(new Insets(2, 6, 2, 6));
		btnAddDeposit50.setFont(new Font("Dialog", Font.PLAIN, 18));
		btnAddDeposit50.setBackground(SystemColor.menu);
		btnAddDeposit50.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				tempDepositAmount += 50.0;
				temp = 50.0;
				accumulateBalance(tempDepositAmount, temp, existingBalance);
			}
		});

		JButton btnSubDeposit100 = new JButton("-");
		btnSubDeposit100.setBounds(174, 178, 40, 39);
		btnSubDeposit100.setMargin(new Insets(2, 6, 2, 6));
		btnSubDeposit100.setFont(new Font("Dialog", Font.PLAIN, 26));
		btnSubDeposit100.setBackground(SystemColor.menu);
		btnSubDeposit100.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				tempDepositAmount -= 100.0;
				temp = 100.0;
				accumulateBalance(tempDepositAmount, temp, existingBalance);
			}
		});

		JButton btnAddDeposit100 = new JButton("+");
		btnAddDeposit100.setBounds(220, 178, 40, 39);
		btnAddDeposit100.setMargin(new Insets(2, 6, 2, 6));
		btnAddDeposit100.setFont(new Font("Dialog", Font.PLAIN, 18));
		btnAddDeposit100.setBackground(SystemColor.menu);
		btnAddDeposit100.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				tempDepositAmount += 100.0;
				temp = 100.0;
				accumulateBalance(tempDepositAmount, temp, existingBalance);
			}
		});

		JButton btnSubDeposit250 = new JButton("-");
		btnSubDeposit250.setBounds(174, 223, 40, 39);
		btnSubDeposit250.setMargin(new Insets(2, 6, 2, 6));
		btnSubDeposit250.setFont(new Font("Dialog", Font.PLAIN, 26));
		btnSubDeposit250.setBackground(SystemColor.menu);
		btnSubDeposit250.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				tempDepositAmount -= 250.0;
				temp = 250.0;
				accumulateBalance(tempDepositAmount, temp, existingBalance);
			}
		});

		JButton btnAddDeposit250 = new JButton("+");
		btnAddDeposit250.setBounds(220, 223, 40, 39);
		btnAddDeposit250.setMargin(new Insets(2, 6, 2, 6));
		btnAddDeposit250.setFont(new Font("Dialog", Font.PLAIN, 18));
		btnAddDeposit250.setBackground(SystemColor.menu);
		btnAddDeposit250.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				tempDepositAmount += 250.0;
				temp = 250.0;
				accumulateBalance(tempDepositAmount, temp, existingBalance);
			}
		});

		JLabel lblExistingBalance = new JLabel("Existing Balance");
		lblExistingBalance.setBounds(317, 16, 77, 14);
		lblExistingBalance.setFont(new Font("Tahoma", Font.PLAIN, 11));

		txtExistingBalance = new JTextField();
		txtExistingBalance.setText("RM "+String.valueOf(existingBalance));
		txtExistingBalance.setHorizontalAlignment(SwingConstants.RIGHT);
		txtExistingBalance.setBounds(288, 32, 106, 21);
		txtExistingBalance.setEditable(false);
		txtExistingBalance.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtExistingBalance.setColumns(10);
		frmDeposit.getContentPane().setLayout(null);
		frmDeposit.getContentPane().add(btnDeposit10);
		frmDeposit.getContentPane().add(btnSubDeposit10);
		frmDeposit.getContentPane().add(btnAddDeposit10);
		frmDeposit.getContentPane().add(btnDeposit25);
		frmDeposit.getContentPane().add(btnSubDeposit25);
		frmDeposit.getContentPane().add(btnAddDeposit25);
		frmDeposit.getContentPane().add(lblExistingBalance);
		frmDeposit.getContentPane().add(txtExistingBalance);
		frmDeposit.getContentPane().add(lblTitleDepositPreset);
		frmDeposit.getContentPane().add(btnDeposit50);
		frmDeposit.getContentPane().add(btnSubDeposit50);
		frmDeposit.getContentPane().add(btnAddDeposit50);
		frmDeposit.getContentPane().add(btnDeposit100);
		frmDeposit.getContentPane().add(btnSubDeposit100);
		frmDeposit.getContentPane().add(btnAddDeposit100);
		frmDeposit.getContentPane().add(btnDeposit250);
		frmDeposit.getContentPane().add(btnSubDeposit250);
		frmDeposit.getContentPane().add(btnAddDeposit250);

		txtDeposit = new JTextField();
		txtDeposit.setText("+ RM");
		txtDeposit.setHorizontalAlignment(SwingConstants.RIGHT);
		txtDeposit.setBackground(new Color(255, 255, 255));
		txtDeposit.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtDeposit.setColumns(10);
		txtDeposit.setEditable(false);
		txtDeposit.setBounds(288, 125, 106, 21);
		txtDeposit.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String tempValue = txtDeposit.getText();
				String tempDigits = tempValue.replaceAll("[^0-9]", "");
				try {

					tempDepositAmount = Double.parseDouble(tempDigits);
					System.out.println(tempDepositAmount);
				} catch (NumberFormatException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

				temp = Double.parseDouble(tempDigits);
				accumulateBalance(tempDepositAmount, temp, existingBalance);
			}
		});

		frmDeposit.getContentPane().add(txtDeposit);

		JLabel lblProposedDeposit = new JLabel("Deposit Amount");
		lblProposedDeposit.setHorizontalAlignment(SwingConstants.RIGHT);
		lblProposedDeposit.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblProposedDeposit.setBounds(298, 109, 96, 14);
		frmDeposit.getContentPane().add(lblProposedDeposit);

		JLabel lblFinalBalance = new JLabel("Final Balance");
		lblFinalBalance.setHorizontalAlignment(SwingConstants.RIGHT);
		lblFinalBalance.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblFinalBalance.setBounds(317, 156, 77, 14);
		frmDeposit.getContentPane().add(lblFinalBalance);

		txtFinalBalance = new JTextField();
		txtFinalBalance.setText("RM");
		txtFinalBalance.setHorizontalAlignment(SwingConstants.RIGHT);
		txtFinalBalance.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtFinalBalance.setColumns(10);
		txtFinalBalance.setBackground(Color.WHITE);
		txtFinalBalance.setBounds(288, 173, 106, 26);
		txtFinalBalance.setEditable(false);
		frmDeposit.getContentPane().add(txtFinalBalance);

		JButton btnConfirm = new JButton("Confirm");
		btnConfirm.setBackground(new Color(240, 240, 240));
		btnConfirm.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnConfirm.setBounds(288, 210, 106, 26);
		btnConfirm.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (finalBalance == 0) {
					UI.popupMessages.create("You cannot deposit RM 0 to the account!", "Error");
				} else {
					ClientCRUD.setBalance(accountNo, finalBalance);
					Integer newTransID = ClientCRUD.getTransactionID();
					ClientCRUD.setTransactionDeposit(newTransID, accountNo, tempDepositAmount);
					ClientHome.refresh();

					frmDeposit.dispose();
				}
			}
		});
		frmDeposit.getContentPane().add(btnConfirm);


		JButton btnCancel = new JButton("Cancel");
		btnCancel.setBackground(new Color(240, 240, 240));
		btnCancel.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnCancel.setBounds(288, 236, 106, 26);
		btnCancel.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				frmDeposit.dispose();
			}
		});
		frmDeposit.getContentPane().add(btnCancel);

		txtCustomDeposit = new JTextField();
		txtCustomDeposit.setText("RM ");
		txtCustomDeposit.setHorizontalAlignment(SwingConstants.RIGHT);
		txtCustomDeposit.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtCustomDeposit.setColumns(10);
		txtCustomDeposit.setBackground(Color.WHITE);
		txtCustomDeposit.setBounds(288, 80, 106, 21);
		txtCustomDeposit.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String tempValue = txtCustomDeposit.getText();
				String tempDigits = tempValue.replaceAll("[^0-9]", "");
				try {

					tempDepositAmount += Double.parseDouble(tempDigits);
					System.out.println(tempDepositAmount);
					txtCustomDeposit.setText("RM ");
				} catch (NumberFormatException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

				temp = Double.parseDouble(tempDigits);
				accumulateBalance(tempDepositAmount, temp, existingBalance);
			}
		});
		frmDeposit.getContentPane().add(txtCustomDeposit);

		JLabel lblCustomDeposit = new JLabel("Custom Deposit");
		lblCustomDeposit.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCustomDeposit.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblCustomDeposit.setBounds(298, 64, 96, 14);
		frmDeposit.getContentPane().add(lblCustomDeposit);

	}

	public static void showThis(Integer accountNo, Double accountBalance) {
		Deposit window = new Deposit(accountNo, accountBalance);
		window.frmDeposit.setVisible(true);
		window.frmDeposit.setLocationRelativeTo(null);
	}

	public void accumulateBalance(Double depositAmount, Double temp, Double existingBalance) {
		finalBalance = 0.0;
		if (depositAmount < 0 ) {
			System.out.println("DepositAmount = " + depositAmount);
			tempDepositAmount += temp;
			System.out.println("After DepositAmount = " + depositAmount);
			UI.popupMessages.create("Cannot deposit negative amount!", "Error");

		} else {

			txtDeposit.setText("+RM " + String.valueOf(depositAmount));
			existingBalance += depositAmount;
			finalBalance = existingBalance;
			txtFinalBalance.setText("RM " + String.valueOf(existingBalance));

		}
	}
}
