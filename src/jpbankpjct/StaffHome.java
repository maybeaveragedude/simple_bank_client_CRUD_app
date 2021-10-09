package jpbankpjct;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.Timer;
import javax.swing.UIManager;
import javax.swing.WindowConstants;

public class StaffHome {

	private static JFrame frmStaffHome;
	/**
	 * Launch the application.
	 */
	

	public StaffHome() {
		frmStaffHome = new JFrame();
		frmStaffHome.setTitle("Staff Home");
		frmStaffHome.setBounds(100, 100, 424, 300);
		frmStaffHome.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

		JPanel panel = new JPanel();
		panel.setBackground(SystemColor.info);

		JButton btnRegClient = new JButton("Register New Client");
		btnRegClient.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
		btnRegClient.setBackground(new Color(240, 240, 240));
		btnRegClient.setFont(new Font("Tahoma", Font.PLAIN, 11));

		JButton btnLoginClient = new JButton("Login Client");
		btnLoginClient.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnLoginClient.setBackground(new Color(240, 240, 240));
		btnLoginClient.setFont(new Font("Tahoma", Font.PLAIN, 11));

		JButton btnBrowseClients = new JButton("Browse Clients");
		btnBrowseClients.setBackground(new Color(240, 240, 240));
		btnBrowseClients.setFont(new Font("Tahoma", Font.PLAIN, 14));

		JButton btnQRLogin = new JButton("QR Login");
		btnQRLogin.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnQRLogin.setBackground(SystemColor.menu);
		GroupLayout groupLayout = new GroupLayout(frmStaffHome.getContentPane());
		groupLayout.setHorizontalGroup(
				groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
						.addContainerGap()
						.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
								.addComponent(panel, GroupLayout.DEFAULT_SIZE, 398, Short.MAX_VALUE)
								.addGroup(groupLayout.createSequentialGroup()
										.addComponent(btnBrowseClients, GroupLayout.PREFERRED_SIZE, 157, GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(ComponentPlacement.UNRELATED)
										.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
												.addGroup(groupLayout.createSequentialGroup()
														.addComponent(btnLoginClient, GroupLayout.PREFERRED_SIZE, 107, GroupLayout.PREFERRED_SIZE)
														.addPreferredGap(ComponentPlacement.RELATED)
														.addComponent(btnQRLogin, GroupLayout.PREFERRED_SIZE, 107, GroupLayout.PREFERRED_SIZE))
												.addComponent(btnRegClient, GroupLayout.DEFAULT_SIZE, 223, Short.MAX_VALUE))))
						.addContainerGap())
				);
		groupLayout.setVerticalGroup(
				groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
						.addContainerGap()
						.addComponent(panel, GroupLayout.PREFERRED_SIZE, 65, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.UNRELATED)
						.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
								.addGroup(groupLayout.createSequentialGroup()
										.addComponent(btnRegClient, GroupLayout.DEFAULT_SIZE, 64, Short.MAX_VALUE)
										.addGap(11)
										.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
												.addComponent(btnLoginClient, GroupLayout.PREFERRED_SIZE, 66, GroupLayout.PREFERRED_SIZE)
												.addComponent(btnQRLogin, GroupLayout.PREFERRED_SIZE, 66, GroupLayout.PREFERRED_SIZE)))
								.addComponent(btnBrowseClients, GroupLayout.DEFAULT_SIZE, 141, Short.MAX_VALUE))
						.addContainerGap())
				);

		JLabel lblTime = new JLabel("tempTime");
		lblTime.setForeground(new Color(0, 0, 0));
		lblTime.setFont(new Font("Tahoma", Font.PLAIN, 12));

		JLabel lblTItleStaffUsername = new JLabel("Accessing as: ");
		lblTItleStaffUsername.setFont(new Font("Tahoma", Font.PLAIN, 12));

		JLabel lblUsername = new JLabel("LoremIpsum");
		lblUsername.setFont(new Font("Tahoma", Font.PLAIN, 18));

		JButton btnLogout = new JButton("Logout");
		btnLogout.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				absLogout();
			}
		});
		btnLogout.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnLogout.setBackground(new Color(240, 240, 240));
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
				gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
						.addContainerGap()
						.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panel.createSequentialGroup()
										.addComponent(lblTItleStaffUsername)
										.addPreferredGap(ComponentPlacement.RELATED, 231, Short.MAX_VALUE)
										.addComponent(lblTime))
								.addGroup(gl_panel.createSequentialGroup()
										.addComponent(lblUsername)
										.addPreferredGap(ComponentPlacement.RELATED, 194, Short.MAX_VALUE)
										.addComponent(btnLogout, GroupLayout.PREFERRED_SIZE, 75, GroupLayout.PREFERRED_SIZE)))
						.addContainerGap())
				);
		gl_panel.setVerticalGroup(
				gl_panel.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel.createSequentialGroup()
						.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblTItleStaffUsername)
								.addComponent(lblTime))
						.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panel.createSequentialGroup()
										.addGap(6)
										.addComponent(lblUsername))
								.addGroup(gl_panel.createSequentialGroup()
										.addPreferredGap(ComponentPlacement.RELATED)
										.addComponent(btnLogout)))
						.addGap(13))
				);
		panel.setLayout(gl_panel);
		frmStaffHome.getContentPane().setLayout(groupLayout);

		JMenuBar menuBar = new JMenuBar();
		menuBar.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		menuBar.setBackground(new Color(240, 240, 240));
		frmStaffHome.setJMenuBar(menuBar);

		JMenu mnStaff = new JMenu("Staff");
		mnStaff.setBackground(new Color(240, 240, 240));
		mnStaff.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		menuBar.add(mnStaff);

		JMenuItem mntmLogoutStaff = new JMenuItem("Logout");
		mntmLogoutStaff.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				absLogout();
			}
		});
		mntmLogoutStaff.setIcon(null);
		mntmLogoutStaff.setPreferredSize(new Dimension(120, 26));
		mntmLogoutStaff.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		mntmLogoutStaff.setBackground(new Color(240, 240, 240));
		mnStaff.add(mntmLogoutStaff);

		JMenu mnStaffMenu = new JMenu("Client");
		mnStaffMenu.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		mnStaffMenu.setForeground(new Color(0, 0, 0));
		menuBar.add(mnStaffMenu);

		JMenuItem mntmRegClient = new JMenuItem("Register");
		mntmRegClient.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
		mntmRegClient.setIcon(null);
		mntmRegClient.setPreferredSize(new Dimension(120, 26));
		mntmRegClient.setBackground(new Color(240, 240, 240));
		mntmRegClient.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		mntmRegClient.setForeground(new Color(0, 0, 0));
		mnStaffMenu.add(mntmRegClient);

		JMenuItem mntmLoginClient = new JMenuItem("Login");
		mntmLoginClient.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
		mntmLoginClient.setIcon(null);
		mntmLoginClient.setPreferredSize(new Dimension(120, 26));
		mntmLoginClient.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		mntmLoginClient.setForeground(new Color(0, 0, 0));
		mnStaffMenu.add(mntmLoginClient);
	}

	public StaffHome(String staffUsername) {
		frmStaffHome = new JFrame();
		frmStaffHome.setTitle("Staff Home");
		frmStaffHome.setBounds(100, 100, 424, 300);
		frmStaffHome.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

		JPanel panel = new JPanel();
		panel.setBackground(SystemColor.info);

		JButton btnRegClient = new JButton("Register New Client");
		btnRegClient.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				//				frmStaffHome.dispose();
				ClientRegistration.showThis();
			}
		});
		btnRegClient.setBackground(new Color(240, 240, 240));
		btnRegClient.setFont(new Font("Tahoma", Font.PLAIN, 11));

		JButton btnLoginClient = new JButton("Login Client");
		btnLoginClient.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				//				frmStaffHome.dispose();
				ClientLogin.showThis();
			}
		});
		btnLoginClient.setBackground(new Color(240, 240, 240));
		btnLoginClient.setFont(new Font("Tahoma", Font.PLAIN, 11));

		JButton btnBrowseClients = new JButton("Browse Clients");
		btnBrowseClients.setBackground(new Color(240, 240, 240));
		btnBrowseClients.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				BrowseClient.showThis();
			}
		});

		btnBrowseClients.setFont(new Font("Tahoma", Font.PLAIN, 14));
		JButton btnQRLogin = new JButton("QR Login");
		btnQRLogin.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnQRLogin.setBackground(SystemColor.menu);
		btnQRLogin.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				QRWebcamReader.showThis();
			}
		});

		GroupLayout groupLayout = new GroupLayout(frmStaffHome.getContentPane());
		groupLayout.setHorizontalGroup(
				groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
						.addContainerGap()
						.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
								.addComponent(panel, GroupLayout.DEFAULT_SIZE, 398, Short.MAX_VALUE)
								.addGroup(groupLayout.createSequentialGroup()
										.addComponent(btnBrowseClients, GroupLayout.PREFERRED_SIZE, 157, GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(ComponentPlacement.UNRELATED)
										.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
												.addGroup(groupLayout.createSequentialGroup()
														.addComponent(btnLoginClient, GroupLayout.PREFERRED_SIZE, 107, GroupLayout.PREFERRED_SIZE)
														.addPreferredGap(ComponentPlacement.RELATED)
														.addComponent(btnQRLogin, GroupLayout.PREFERRED_SIZE, 107, GroupLayout.PREFERRED_SIZE))
												.addComponent(btnRegClient, GroupLayout.DEFAULT_SIZE, 223, Short.MAX_VALUE))))
						.addContainerGap())
				);
		groupLayout.setVerticalGroup(
				groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
						.addContainerGap()
						.addComponent(panel, GroupLayout.PREFERRED_SIZE, 65, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.UNRELATED)
						.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
								.addGroup(groupLayout.createSequentialGroup()
										.addComponent(btnRegClient, GroupLayout.DEFAULT_SIZE, 64, Short.MAX_VALUE)
										.addGap(11)
										.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
												.addComponent(btnLoginClient, GroupLayout.PREFERRED_SIZE, 66, GroupLayout.PREFERRED_SIZE)
												.addComponent(btnQRLogin, GroupLayout.PREFERRED_SIZE, 66, GroupLayout.PREFERRED_SIZE)))
								.addComponent(btnBrowseClients, GroupLayout.DEFAULT_SIZE, 141, Short.MAX_VALUE))
						.addContainerGap())
				);




		JLabel lblTime = new JLabel("tempTime");
		lblTime.setForeground(new Color(0, 0, 0));
		lblTime.setFont(new Font("Tahoma", Font.PLAIN, 14));



		ActionListener showCurrentTime = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				SimpleDateFormat formatDate = new SimpleDateFormat("hh:mm:ss dd/MM/yyyy");
				Date date = new Date();
				String DateCreated = formatDate.format(date);
				lblTime.setText(DateCreated);
			}
		};
		Timer time = new Timer(1000, showCurrentTime);
		time.start();

		JLabel lblTItleStaffUsername = new JLabel("Accessing as: ");
		lblTItleStaffUsername.setFont(new Font("Tahoma", Font.PLAIN, 12));

		JLabel lblUsername = new JLabel(staffUsername);
		lblUsername.setFont(new Font("Tahoma", Font.PLAIN, 18));

		JButton btnLogout = new JButton("Logout");
		btnLogout.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				absLogout();
			}
		});
		btnLogout.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnLogout.setBackground(new Color(240, 240, 240));
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
				gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
						.addContainerGap()
						.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panel.createSequentialGroup()
										.addComponent(lblTItleStaffUsername)
										.addPreferredGap(ComponentPlacement.RELATED, 257, Short.MAX_VALUE)
										.addComponent(lblTime))
								.addGroup(gl_panel.createSequentialGroup()
										.addComponent(lblUsername)
										.addPreferredGap(ComponentPlacement.RELATED, 220, Short.MAX_VALUE)
										.addComponent(btnLogout, GroupLayout.PREFERRED_SIZE, 75, GroupLayout.PREFERRED_SIZE)))
						.addContainerGap())
				);
		gl_panel.setVerticalGroup(
				gl_panel.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel.createSequentialGroup()
						.addContainerGap(13, Short.MAX_VALUE)
						.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblTItleStaffUsername)
								.addComponent(lblTime))
						.addGap(6)
						.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblUsername)
								.addComponent(btnLogout))
						.addGap(9))
				);
		panel.setLayout(gl_panel);
		frmStaffHome.getContentPane().setLayout(groupLayout);

		JMenuBar menuBar = new JMenuBar();
		menuBar.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		menuBar.setBackground(new Color(240, 240, 240));
		frmStaffHome.setJMenuBar(menuBar);

		JMenu mnStaff = new JMenu("Staff");
		mnStaff.setBackground(new Color(240, 240, 240));
		mnStaff.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		menuBar.add(mnStaff);

		JMenuItem mntmLogoutStaff = new JMenuItem("Logout");
		mntmLogoutStaff.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				absLogout();
			}
		});
		mntmLogoutStaff.setIcon(null);
		mntmLogoutStaff.setPreferredSize(new Dimension(120, 26));
		mntmLogoutStaff.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		mntmLogoutStaff.setBackground(new Color(240, 240, 240));
		mnStaff.add(mntmLogoutStaff);

		JMenu mnStaffMenu = new JMenu("Client");
		mnStaffMenu.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		mnStaffMenu.setForeground(new Color(0, 0, 0));
		menuBar.add(mnStaffMenu);

		JMenuItem mntmRegClient = new JMenuItem("Register");
		mntmRegClient.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				//				frmStaffHome.dispose();
				ClientRegistration.showThis();
			}
		});
		mntmRegClient.setIcon(null);
		mntmRegClient.setPreferredSize(new Dimension(120, 26));
		mntmRegClient.setBackground(new Color(240, 240, 240));
		mntmRegClient.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		mntmRegClient.setForeground(new Color(0, 0, 0));
		mnStaffMenu.add(mntmRegClient);

		JMenuItem mntmLoginClient = new JMenuItem("Login");
		mntmLoginClient.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				//				frmStaffHome.dispose();
				ClientLogin.showThis();
			}
		});
		mntmLoginClient.setIcon(null);
		mntmLoginClient.setPreferredSize(new Dimension(120, 26));
		mntmLoginClient.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		mntmLoginClient.setForeground(new Color(0, 0, 0));
		mnStaffMenu.add(mntmLoginClient);
	}


	public static Boolean showThis(String staffUsername) {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch(Exception e) {
			System.out.println("Error setting native LAF: " + e);
		}
		try {
			new StaffHome(staffUsername);
			StaffHome.frmStaffHome.setVisible(true);
			StaffHome.frmStaffHome.setLocationRelativeTo(null);
		} catch(Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	public static void unhideThis() {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch(Exception e) {
			System.out.println("Error setting native LAF: " + e);
		}

		frmStaffHome.setVisible(true);

	}

	public static Boolean absLogout() {
		try {
			UI.popupMessages.create("Logged out successfully!", "Staff Status");
			frmStaffHome.dispose();
			StaffLogin.showThis();


		} catch(Exception e) {
			UI.popupMessages.create("Something went wrong!", "Staff Status");
			e.printStackTrace();
			return false;
		}
		return true;
	}
}
