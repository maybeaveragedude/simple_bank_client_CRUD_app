package jpbankpjct;

import javax.swing.JOptionPane;
import javax.swing.UIManager;

public class UI {
	public static class popupMessages
	{

		public static void create(String message, String title)
		{
			try {
				UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
			} catch(Exception e) {
				System.out.println("Error setting native LAF: " + e);
			}
			JOptionPane.showMessageDialog(null, message, "Information: " + title, JOptionPane.INFORMATION_MESSAGE);

		}

		public static boolean createYesNo(String message, String title)
		{
			try {
				UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
			} catch(Exception e) {
				System.out.println("Error setting native LAF: " + e);
			}
			int thisConfirm = JOptionPane.showConfirmDialog(null, message, "Confirmation: " + title, JOptionPane.YES_NO_OPTION);

			if (thisConfirm == JOptionPane.YES_OPTION) {
				return true;
			} else {
				return false;
			}
		}
	}
}
