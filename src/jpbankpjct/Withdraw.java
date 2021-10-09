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

public class Withdraw {

	private JFrame frmWithdrawal;
	private JTextField txtExistingBalance;
	private JTextField txtWithdraw;
	private JTextField txtFinalBalance;
	private JTextField txtCustomWithdraw;
	Double tempWithdrawAmount = 0.0, btnValue = 0.0, finalBalance = 0.0;

	/**
	 * Launch the application.
	 */
	//	public static void main(String[] args) {
	//		EventQueue.invokeLater(new Runnable() {
	//			@Override
	//			public void run() {
	//				try {
	//					Withdraw window = new Withdraw();
	//					window.frmWithdrawal.setVisible(true);
	//					window.frmWithdrawal.setLocationRelativeTo(null);
	//
	//				} catch (Exception e) {
	//					e.printStackTrace();
	//				}
	//			}
	//		});
	//	}



	public Withdraw() {
		frmWithdrawal = new JFrame();
		frmWithdrawal.setTitle("Withdrawal");
		frmWithdrawal.setBounds(100, 100, 420, 310);
		frmWithdrawal.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

		JButton btnWithdraw10 = new JButton("RM 10");
		btnWithdraw10.setBounds(10, 41, 158, 39);
		btnWithdraw10.setBackground(new Color(240, 240, 240));
		btnWithdraw10.setFont(new Font("Tahoma", Font.PLAIN, 11));

		JLabel lblTitleWithdrawPreset = new JLabel("Withdrawal Preset");
		lblTitleWithdrawPreset.setBounds(10, 13, 110, 17);
		lblTitleWithdrawPreset.setFont(new Font("Tahoma", Font.PLAIN, 14));

		JButton btnWithdraw25 = new JButton("RM 25");
		btnWithdraw25.setBounds(10, 86, 158, 39);
		btnWithdraw25.setBackground(new Color(240, 240, 240));
		btnWithdraw25.setFont(new Font("Tahoma", Font.PLAIN, 11));

		JButton btnWithdraw50 = new JButton("RM 50");
		btnWithdraw50.setBounds(10, 131, 158, 39);
		btnWithdraw50.setBackground(new Color(240, 240, 240));
		btnWithdraw50.setFont(new Font("Tahoma", Font.PLAIN, 11));

		JButton btnWithdraw100 = new JButton("RM 100");
		btnWithdraw100.setBounds(10, 176, 158, 39);
		btnWithdraw100.setBackground(new Color(240, 240, 240));
		btnWithdraw100.setFont(new Font("Tahoma", Font.PLAIN, 11));

		JButton btnWithdraw250 = new JButton("RM 250");
		btnWithdraw250.setBounds(10, 223, 158, 39);
		btnWithdraw250.setBackground(new Color(240, 240, 240));
		btnWithdraw250.setFont(new Font("Tahoma", Font.PLAIN, 11));

		JButton btnSubWithdraw10 = new JButton("-");
		btnSubWithdraw10.setBounds(174, 41, 40, 39);
		btnSubWithdraw10.setMargin(new Insets(2, 6, 2, 6));
		btnSubWithdraw10.setFont(new Font("Dialog", Font.PLAIN, 26));
		btnSubWithdraw10.setBackground(SystemColor.menu);

		JButton btnAddWithdraw10 = new JButton("+");
		btnAddWithdraw10.setBounds(220, 41, 40, 39);
		btnAddWithdraw10.setMargin(new Insets(2, 6, 2, 6));
		btnAddWithdraw10.setFont(new Font("Dialog", Font.PLAIN, 18));
		btnAddWithdraw10.setBackground(SystemColor.menu);

		JButton btnSubWithdraw25 = new JButton("-");
		btnSubWithdraw25.setBounds(174, 86, 40, 39);
		btnSubWithdraw25.setMargin(new Insets(2, 6, 2, 6));
		btnSubWithdraw25.setFont(new Font("Dialog", Font.PLAIN, 26));
		btnSubWithdraw25.setBackground(SystemColor.menu);

		JButton btnAddWithdraw25 = new JButton("+");
		btnAddWithdraw25.setBounds(220, 86, 40, 39);
		btnAddWithdraw25.setMargin(new Insets(2, 6, 2, 6));
		btnAddWithdraw25.setFont(new Font("Dialog", Font.PLAIN, 18));
		btnAddWithdraw25.setBackground(SystemColor.menu);

		JButton btnSubWithdraw50 = new JButton("-");
		btnSubWithdraw50.setBounds(174, 131, 40, 39);
		btnSubWithdraw50.setMargin(new Insets(2, 6, 2, 6));
		btnSubWithdraw50.setFont(new Font("Dialog", Font.PLAIN, 26));
		btnSubWithdraw50.setBackground(SystemColor.menu);

		JButton btnAddWithdraw50 = new JButton("+");
		btnAddWithdraw50.setBounds(220, 131, 40, 39);
		btnAddWithdraw50.setMargin(new Insets(2, 6, 2, 6));
		btnAddWithdraw50.setFont(new Font("Dialog", Font.PLAIN, 18));
		btnAddWithdraw50.setBackground(SystemColor.menu);

		JButton btnSubWithdraw100 = new JButton("-");
		btnSubWithdraw100.setBounds(174, 178, 40, 39);
		btnSubWithdraw100.setMargin(new Insets(2, 6, 2, 6));
		btnSubWithdraw100.setFont(new Font("Dialog", Font.PLAIN, 26));
		btnSubWithdraw100.setBackground(SystemColor.menu);

		JButton btnAddWithdraw100 = new JButton("+");
		btnAddWithdraw100.setBounds(220, 178, 40, 39);
		btnAddWithdraw100.setMargin(new Insets(2, 6, 2, 6));
		btnAddWithdraw100.setFont(new Font("Dialog", Font.PLAIN, 18));
		btnAddWithdraw100.setBackground(SystemColor.menu);

		JButton btnSubWithdraw250 = new JButton("-");
		btnSubWithdraw250.setBounds(174, 223, 40, 39);
		btnSubWithdraw250.setMargin(new Insets(2, 6, 2, 6));
		btnSubWithdraw250.setFont(new Font("Dialog", Font.PLAIN, 26));
		btnSubWithdraw250.setBackground(SystemColor.menu);

		JButton btnAddWithdraw250 = new JButton("+");
		btnAddWithdraw250.setBounds(220, 223, 40, 39);
		btnAddWithdraw250.setMargin(new Insets(2, 6, 2, 6));
		btnAddWithdraw250.setFont(new Font("Dialog", Font.PLAIN, 18));
		btnAddWithdraw250.setBackground(SystemColor.menu);

		JLabel lblExistingBalance = new JLabel("Existing Balance");
		lblExistingBalance.setBounds(317, 41, 77, 14);
		lblExistingBalance.setFont(new Font("Tahoma", Font.PLAIN, 11));

		txtExistingBalance = new JTextField();
		txtExistingBalance.setText("RM");
		txtExistingBalance.setHorizontalAlignment(SwingConstants.RIGHT);
		txtExistingBalance.setBounds(288, 61, 106, 21);
		txtExistingBalance.setEditable(false);
		txtExistingBalance.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtExistingBalance.setColumns(10);
		frmWithdrawal.getContentPane().setLayout(null);
		frmWithdrawal.getContentPane().add(btnWithdraw10);
		frmWithdrawal.getContentPane().add(btnSubWithdraw10);
		frmWithdrawal.getContentPane().add(btnAddWithdraw10);
		frmWithdrawal.getContentPane().add(btnWithdraw25);
		frmWithdrawal.getContentPane().add(btnSubWithdraw25);
		frmWithdrawal.getContentPane().add(btnAddWithdraw25);
		frmWithdrawal.getContentPane().add(lblExistingBalance);
		frmWithdrawal.getContentPane().add(txtExistingBalance);
		frmWithdrawal.getContentPane().add(lblTitleWithdrawPreset);
		frmWithdrawal.getContentPane().add(btnWithdraw50);
		frmWithdrawal.getContentPane().add(btnSubWithdraw50);
		frmWithdrawal.getContentPane().add(btnAddWithdraw50);
		frmWithdrawal.getContentPane().add(btnWithdraw100);
		frmWithdrawal.getContentPane().add(btnSubWithdraw100);
		frmWithdrawal.getContentPane().add(btnAddWithdraw100);
		frmWithdrawal.getContentPane().add(btnWithdraw250);
		frmWithdrawal.getContentPane().add(btnSubWithdraw250);
		frmWithdrawal.getContentPane().add(btnAddWithdraw250);

		txtWithdraw = new JTextField();
		txtWithdraw.setText("- RM");
		txtWithdraw.setHorizontalAlignment(SwingConstants.RIGHT);
		txtWithdraw.setBackground(new Color(255, 255, 255));
		txtWithdraw.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtWithdraw.setColumns(10);
		txtWithdraw.setBounds(288, 113, 106, 21);
		frmWithdrawal.getContentPane().add(txtWithdraw);

		JLabel lblProposedWithdraw = new JLabel("Withdrawal Amount");
		lblProposedWithdraw.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblProposedWithdraw.setBounds(298, 93, 96, 14);
		frmWithdrawal.getContentPane().add(lblProposedWithdraw);

		JLabel lblFinalBalance = new JLabel("Final Balance");
		lblFinalBalance.setHorizontalAlignment(SwingConstants.RIGHT);
		lblFinalBalance.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblFinalBalance.setBounds(317, 145, 77, 14);
		frmWithdrawal.getContentPane().add(lblFinalBalance);

		txtFinalBalance = new JTextField();
		txtFinalBalance.setText("RM");
		txtFinalBalance.setHorizontalAlignment(SwingConstants.RIGHT);
		txtFinalBalance.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtFinalBalance.setColumns(10);
		txtFinalBalance.setBackground(Color.WHITE);
		txtFinalBalance.setBounds(288, 165, 106, 26);
		frmWithdrawal.getContentPane().add(txtFinalBalance);

		JButton btnConfirm = new JButton("Confirm");
		btnConfirm.setBackground(new Color(240, 240, 240));
		btnConfirm.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnConfirm.setBounds(288, 202, 106, 26);
		frmWithdrawal.getContentPane().add(btnConfirm);

		JButton btnCancel = new JButton("Cancel");
		btnCancel.setBackground(new Color(240, 240, 240));
		btnCancel.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnCancel.setBounds(288, 236, 106, 26);
		frmWithdrawal.getContentPane().add(btnCancel);
	}

	public Withdraw(Integer accountNo, String accType, Double existingBalance) {
		frmWithdrawal = new JFrame();
		frmWithdrawal.setTitle("Withdrawal");
		frmWithdrawal.setBounds(100, 100, 420, 310);
		frmWithdrawal.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);


		JLabel lblTitleWithdrawPreset = new JLabel("Withdrawal Preset");
		lblTitleWithdrawPreset.setBounds(10, 13, 110, 17);
		lblTitleWithdrawPreset.setFont(new Font("Tahoma", Font.PLAIN, 14));

		JButton btnWithdraw10 = new JButton("RM 10");
		btnWithdraw10.setBounds(10, 41, 158, 39);
		btnWithdraw10.setBackground(new Color(240, 240, 240));
		btnWithdraw10.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnWithdraw10.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				tempWithdrawAmount += 10.0;
				btnValue = 10.0;
				accumulateBalance(tempWithdrawAmount, accType, btnValue, existingBalance);
			}
		});

		JButton btnWithdraw25 = new JButton("RM 25");
		btnWithdraw25.setBounds(10, 86, 158, 39);
		btnWithdraw25.setBackground(new Color(240, 240, 240));
		btnWithdraw25.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnWithdraw25.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				tempWithdrawAmount += 25.0;
				btnValue = 25.0;
				accumulateBalance(tempWithdrawAmount, accType, btnValue, existingBalance);
			}
		});


		JButton btnWithdraw50 = new JButton("RM 50");
		btnWithdraw50.setBounds(10, 131, 158, 39);
		btnWithdraw50.setBackground(new Color(240, 240, 240));
		btnWithdraw50.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnWithdraw50.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				tempWithdrawAmount += 50.0;
				btnValue = 50.0;
				accumulateBalance(tempWithdrawAmount, accType, btnValue, existingBalance);
			}
		});

		JButton btnWithdraw100 = new JButton("RM 100");
		btnWithdraw100.setBounds(10, 176, 158, 39);
		btnWithdraw100.setBackground(new Color(240, 240, 240));
		btnWithdraw100.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnWithdraw100.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				tempWithdrawAmount += 100.0;
				btnValue = 100.0;
				accumulateBalance(tempWithdrawAmount, accType, btnValue, existingBalance);
			}
		});

		JButton btnWithdraw250 = new JButton("RM 250");
		btnWithdraw250.setBounds(10, 223, 158, 39);
		btnWithdraw250.setBackground(new Color(240, 240, 240));
		btnWithdraw250.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnWithdraw250.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				tempWithdrawAmount += 250.0;
				btnValue = 250.0;
				accumulateBalance(tempWithdrawAmount, accType, btnValue, existingBalance);
			}
		});

		JButton btnSubWithdraw10 = new JButton("-");
		btnSubWithdraw10.setBounds(174, 41, 40, 39);
		btnSubWithdraw10.setMargin(new Insets(2, 6, 2, 6));
		btnSubWithdraw10.setFont(new Font("Dialog", Font.PLAIN, 26));
		btnSubWithdraw10.setBackground(SystemColor.menu);
		btnSubWithdraw10.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				tempWithdrawAmount -= 10.0;
				btnValue = 10.0;
				accumulateBalance(tempWithdrawAmount, accType, btnValue, existingBalance);
			}
		});

		JButton btnAddWithdraw10 = new JButton("+");
		btnAddWithdraw10.setBounds(220, 41, 40, 39);
		btnAddWithdraw10.setMargin(new Insets(2, 6, 2, 6));
		btnAddWithdraw10.setFont(new Font("Dialog", Font.PLAIN, 18));
		btnAddWithdraw10.setBackground(SystemColor.menu);
		btnAddWithdraw10.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				tempWithdrawAmount += 10.0;
				btnValue = 10.0;
				accumulateBalance(tempWithdrawAmount, accType, btnValue, existingBalance);
			}
		});

		JButton btnSubWithdraw25 = new JButton("-");
		btnSubWithdraw25.setBounds(174, 86, 40, 39);
		btnSubWithdraw25.setMargin(new Insets(2, 6, 2, 6));
		btnSubWithdraw25.setFont(new Font("Dialog", Font.PLAIN, 26));
		btnSubWithdraw25.setBackground(SystemColor.menu);
		btnSubWithdraw25.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				tempWithdrawAmount -= 25.0;
				btnValue = 25.0;
				accumulateBalance(tempWithdrawAmount, accType, btnValue, existingBalance);
			}
		});

		JButton btnAddWithdraw25 = new JButton("+");
		btnAddWithdraw25.setBounds(220, 86, 40, 39);
		btnAddWithdraw25.setMargin(new Insets(2, 6, 2, 6));
		btnAddWithdraw25.setFont(new Font("Dialog", Font.PLAIN, 18));
		btnAddWithdraw25.setBackground(SystemColor.menu);
		btnAddWithdraw25.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				tempWithdrawAmount += 25.0;
				btnValue = 25.0;
				accumulateBalance(tempWithdrawAmount, accType, btnValue, existingBalance);
			}
		});

		JButton btnSubWithdraw50 = new JButton("-");
		btnSubWithdraw50.setBounds(174, 131, 40, 39);
		btnSubWithdraw50.setMargin(new Insets(2, 6, 2, 6));
		btnSubWithdraw50.setFont(new Font("Dialog", Font.PLAIN, 26));
		btnSubWithdraw50.setBackground(SystemColor.menu);
		btnSubWithdraw50.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				tempWithdrawAmount -= 50.0;
				btnValue = 50.0;
				accumulateBalance(tempWithdrawAmount, accType, btnValue, existingBalance);
			}
		});

		JButton btnAddWithdraw50 = new JButton("+");
		btnAddWithdraw50.setBounds(220, 131, 40, 39);
		btnAddWithdraw50.setMargin(new Insets(2, 6, 2, 6));
		btnAddWithdraw50.setFont(new Font("Dialog", Font.PLAIN, 18));
		btnAddWithdraw50.setBackground(SystemColor.menu);
		btnAddWithdraw50.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				tempWithdrawAmount += 50.0;
				btnValue = 50.0;
				accumulateBalance(tempWithdrawAmount, accType, btnValue, existingBalance);
			}
		});

		JButton btnSubWithdraw100 = new JButton("-");
		btnSubWithdraw100.setBounds(174, 178, 40, 39);
		btnSubWithdraw100.setMargin(new Insets(2, 6, 2, 6));
		btnSubWithdraw100.setFont(new Font("Dialog", Font.PLAIN, 26));
		btnSubWithdraw100.setBackground(SystemColor.menu);
		btnSubWithdraw100.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				tempWithdrawAmount -= 100.0;
				btnValue = 100.0;
				accumulateBalance(tempWithdrawAmount, accType, btnValue, existingBalance);
			}
		});

		JButton btnAddWithdraw100 = new JButton("+");
		btnAddWithdraw100.setBounds(220, 178, 40, 39);
		btnAddWithdraw100.setMargin(new Insets(2, 6, 2, 6));
		btnAddWithdraw100.setFont(new Font("Dialog", Font.PLAIN, 18));
		btnAddWithdraw100.setBackground(SystemColor.menu);
		btnAddWithdraw100.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				tempWithdrawAmount += 100.0;
				btnValue = 100.0;
				accumulateBalance(tempWithdrawAmount, accType, btnValue, existingBalance);
			}
		});

		JButton btnSubWithdraw250 = new JButton("-");
		btnSubWithdraw250.setBounds(174, 223, 40, 39);
		btnSubWithdraw250.setMargin(new Insets(2, 6, 2, 6));
		btnSubWithdraw250.setFont(new Font("Dialog", Font.PLAIN, 26));
		btnSubWithdraw250.setBackground(SystemColor.menu);
		btnSubWithdraw250.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				tempWithdrawAmount -= 250.0;
				btnValue = 250.0;
				accumulateBalance(tempWithdrawAmount, accType, btnValue, existingBalance);
			}
		});

		JButton btnAddWithdraw250 = new JButton("+");
		btnAddWithdraw250.setBounds(220, 223, 40, 39);
		btnAddWithdraw250.setMargin(new Insets(2, 6, 2, 6));
		btnAddWithdraw250.setFont(new Font("Dialog", Font.PLAIN, 18));
		btnAddWithdraw250.setBackground(SystemColor.menu);
		btnAddWithdraw250.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				tempWithdrawAmount += 250.0;
				btnValue = 250.0;
				accumulateBalance(tempWithdrawAmount, accType, btnValue, existingBalance);
			}
		});

		JLabel lblExistingBalance = new JLabel("Existing Balance");
		lblExistingBalance.setBounds(317, 16, 77, 14);
		lblExistingBalance.setFont(new Font("Tahoma", Font.PLAIN, 11));

		txtExistingBalance = new JTextField();
		txtExistingBalance.setText("RM " + String.valueOf(existingBalance));
		txtExistingBalance.setHorizontalAlignment(SwingConstants.RIGHT);
		txtExistingBalance.setBounds(288, 32, 106, 21);
		txtExistingBalance.setEditable(false);
		txtExistingBalance.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtExistingBalance.setColumns(10);
		frmWithdrawal.getContentPane().setLayout(null);
		frmWithdrawal.getContentPane().add(btnWithdraw10);
		frmWithdrawal.getContentPane().add(btnSubWithdraw10);
		frmWithdrawal.getContentPane().add(btnAddWithdraw10);
		frmWithdrawal.getContentPane().add(btnWithdraw25);
		frmWithdrawal.getContentPane().add(btnSubWithdraw25);
		frmWithdrawal.getContentPane().add(btnAddWithdraw25);
		frmWithdrawal.getContentPane().add(lblExistingBalance);
		frmWithdrawal.getContentPane().add(txtExistingBalance);
		frmWithdrawal.getContentPane().add(lblTitleWithdrawPreset);
		frmWithdrawal.getContentPane().add(btnWithdraw50);
		frmWithdrawal.getContentPane().add(btnSubWithdraw50);
		frmWithdrawal.getContentPane().add(btnAddWithdraw50);
		frmWithdrawal.getContentPane().add(btnWithdraw100);
		frmWithdrawal.getContentPane().add(btnSubWithdraw100);
		frmWithdrawal.getContentPane().add(btnAddWithdraw100);
		frmWithdrawal.getContentPane().add(btnWithdraw250);
		frmWithdrawal.getContentPane().add(btnSubWithdraw250);
		frmWithdrawal.getContentPane().add(btnAddWithdraw250);

		txtWithdraw = new JTextField();
		txtWithdraw.setText("- RM");
		txtWithdraw.setHorizontalAlignment(SwingConstants.RIGHT);
		txtWithdraw.setBackground(new Color(255, 255, 255));
		txtWithdraw.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtWithdraw.setColumns(10);
		txtWithdraw.setBounds(288, 125, 106, 21);
		txtWithdraw.setEditable(false);
		frmWithdrawal.getContentPane().add(txtWithdraw);

		JLabel lblProposedWithdraw = new JLabel("Withdrawal Amount");
		lblProposedWithdraw.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblProposedWithdraw.setBounds(298, 109, 96, 14);
		frmWithdrawal.getContentPane().add(lblProposedWithdraw);

		JLabel lblFinalBalance = new JLabel("Final Balance");
		lblFinalBalance.setHorizontalAlignment(SwingConstants.RIGHT);
		lblFinalBalance.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblFinalBalance.setBounds(317, 156, 77, 14);
		frmWithdrawal.getContentPane().add(lblFinalBalance);

		txtFinalBalance = new JTextField();
		txtFinalBalance.setText("RM");
		txtFinalBalance.setHorizontalAlignment(SwingConstants.RIGHT);
		txtFinalBalance.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtFinalBalance.setColumns(10);
		txtFinalBalance.setBackground(Color.WHITE);
		txtFinalBalance.setBounds(288, 173, 106, 26);
		txtFinalBalance.setEditable(false);
		frmWithdrawal.getContentPane().add(txtFinalBalance);

		JButton btnConfirm = new JButton("Confirm");
		btnConfirm.setBackground(new Color(240, 240, 240));
		btnConfirm.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnConfirm.setBounds(288, 210, 106, 26);
		btnConfirm.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (finalBalance == 0) {
					UI.popupMessages.create("You cannot withdraw RM 0 from the account!", "Error");
				} else {
					ClientCRUD.setBalance(accountNo, finalBalance);
					Integer newTransID = ClientCRUD.getTransactionID();
					ClientCRUD.setTransactionWithdraw(newTransID, accountNo, tempWithdrawAmount);
					ClientHome.refresh();

					frmWithdrawal.dispose();
				}
			}
		});
		frmWithdrawal.getContentPane().add(btnConfirm);

		JButton btnCancel = new JButton("Cancel");
		btnCancel.setBackground(new Color(240, 240, 240));
		btnCancel.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnCancel.setBounds(288, 236, 106, 26);
		btnCancel.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				frmWithdrawal.dispose();

			}
		});
		frmWithdrawal.getContentPane().add(btnCancel);


		txtCustomWithdraw = new JTextField();
		txtCustomWithdraw.setText("RM ");
		txtCustomWithdraw.setHorizontalAlignment(SwingConstants.RIGHT);
		txtCustomWithdraw.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtCustomWithdraw.setColumns(10);
		txtCustomWithdraw.setBackground(Color.WHITE);
		txtCustomWithdraw.setBounds(288, 80, 106, 21);
		txtCustomWithdraw.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String tempValue = txtCustomWithdraw.getText();
				String tempDigits = tempValue.replaceAll("[^0-9]", "");
				try {

					tempWithdrawAmount += Double.parseDouble(tempDigits);
					System.out.println(tempWithdrawAmount);
					txtCustomWithdraw.setText("RM ");
				} catch (NumberFormatException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

				btnValue = Double.parseDouble(tempDigits);
				accumulateBalance(tempWithdrawAmount, accType, btnValue, existingBalance);
			}
		});
		frmWithdrawal.getContentPane().add(txtCustomWithdraw);

		JLabel lblCustomDeposit = new JLabel("Custom Deposit");
		lblCustomDeposit.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCustomDeposit.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblCustomDeposit.setBounds(298, 64, 96, 14);
		frmWithdrawal.getContentPane().add(lblCustomDeposit);

	}

	public static void showThis(Integer accountNo, String accType, Double existingBalance) {
		Withdraw window = new Withdraw(accountNo, accType,existingBalance);
		window.frmWithdrawal.setVisible(true);
		window.frmWithdrawal.setLocationRelativeTo(null);
	}


	//	tempWithdrawAmount += 250.0;
	//	btnValue = 250.0;
	//	accumulateBalance(tempWithdrawAmount, accType, btnValue, existingBalance);
	public void accumulateBalance(Double withdrawAmount, String accType, Double temp, Double existingBalance) {
		finalBalance = 0.0;
		switch (accType) {
		case "Savings": {
			if (withdrawAmount < 0 ) {
				System.out.println("WithdrawAmount = " + withdrawAmount);
				tempWithdrawAmount += temp;
				System.out.println("After WithdrawAmount = " + tempWithdrawAmount);
				UI.popupMessages.create("Cannot withdraw negative amount!", "Error");

			} else if(existingBalance - withdrawAmount < 100){

				System.out.println("WithdrawAmount = " + withdrawAmount);
				tempWithdrawAmount -= temp;
				System.out.println("After WithdrawAmount = " + tempWithdrawAmount);
				UI.popupMessages.create("Savings account must have at least RM 100 in balance!", "Balance Req.");

			} else {

				txtWithdraw.setText("-RM " + String.valueOf(withdrawAmount));
				existingBalance -= withdrawAmount;
				finalBalance = existingBalance;
				txtFinalBalance.setText("RM " + String.valueOf(existingBalance));

			}
			break;


		}

		case "Current": {

			if (withdrawAmount < 0 ) {
				System.out.println("WithdrawAmount = " + withdrawAmount);
				System.out.println("WithdrawAmount = " + withdrawAmount);
				tempWithdrawAmount += temp;
				System.out.println("After WithdrawAmount = " + withdrawAmount);
				UI.popupMessages.create("Cannot withdraw negative amount!", "Error");

			} else if(existingBalance - withdrawAmount < 500){

				System.out.println("WithdrawAmount = " + withdrawAmount);
				tempWithdrawAmount -= temp;
				System.out.println("After WithdrawAmount = " + withdrawAmount);
				UI.popupMessages.create("Current account must have at least RM 500 in balance!", "Balance Req.");

			} else {

				txtWithdraw.setText("-RM " + String.valueOf(withdrawAmount));
				existingBalance -= withdrawAmount;
				finalBalance = existingBalance;
				txtFinalBalance.setText("RM " + String.valueOf(existingBalance));

			}
			break;

		}
		default:
			throw new IllegalArgumentException("Unexpected value: " + accType);
		}



	}
}
