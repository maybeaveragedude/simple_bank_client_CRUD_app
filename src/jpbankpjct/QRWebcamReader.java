package jpbankpjct;

import java.awt.Dimension;
import java.awt.event.WindowAdapter;
import java.awt.image.BufferedImage;

import javax.swing.JFrame;
import javax.swing.WindowConstants;

import org.apache.log4j.PropertyConfigurator;

import com.github.sarxos.webcam.Webcam;
import com.github.sarxos.webcam.WebcamPanel;
import com.google.zxing.BinaryBitmap;
import com.google.zxing.LuminanceSource;
import com.google.zxing.MultiFormatReader;
import com.google.zxing.NotFoundException;
import com.google.zxing.Result;
import com.google.zxing.client.j2se.BufferedImageLuminanceSource;
import com.google.zxing.common.HybridBinarizer;

// Referenced from https://github.com/vivekkairi/webcam-qr-barcode-scanner
public class QRWebcamReader extends JFrame{

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	public static void main(String[] args) {
		showThis();
	}

	public static void showThis() {


		//starts a new thread for the scanner and jframe to work concurrently
		new Thread(() -> {

			//setting the config file for logger
			String log4jConfPath = "src/log4j.properties";
			PropertyConfigurator.configure(log4jConfPath);


			Webcam webcam = Webcam.getDefault();   //Generate Webcam Object
			webcam.setViewSize(new Dimension(640,480));
			WebcamPanel webcamPanel = new WebcamPanel(webcam);
			webcamPanel.setMirrored(false);
			JFrame webCamBuffer = new JFrame();
			webCamBuffer.add(webcamPanel);
			webCamBuffer.setTitle("Webcam Window");
			webCamBuffer.pack();
			webCamBuffer.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			webCamBuffer.addWindowListener(new WindowAdapter() {
				@Override
				public void windowClosing(java.awt.event.WindowEvent windowEvent) {
					//	            	webCamBuffer.dispose();
					webcam.close(); //close the resource and process on window close

				}
			});
			webCamBuffer.setLocationRelativeTo(null);
			webCamBuffer.setVisible(true);



			do {
				try {
					webCamBuffer.setVisible(true);
					BufferedImage image = webcam.getImage();
					LuminanceSource source = new BufferedImageLuminanceSource(image);
					BinaryBitmap bitmap = new BinaryBitmap(new HybridBinarizer(source));
					Result result = new MultiFormatReader().decode(bitmap);
					if(result.getText() != null) {
						//	                    System.out.println(result.getText());

						String combinedString = result.getText();
						String[] splitString = combinedString.split(",");

						Integer accountNo = Integer.parseInt(splitString[0]);
						String encryptedPass = splitString[1];
						System.out.println(encryptedPass);

						if(ClientLogin.loginQRClient(accountNo, encryptedPass)) {
							if(UI.popupMessages.createYesNo("Client with Account No: " + String.valueOf(accountNo) + ", continue?", "Login Client")) {
								ClientHome.showThis(accountNo);
								webCamBuffer.setVisible(false);
								webCamBuffer.dispose();
								webcam.close();
								break;
							} else {
								continue;
							}

						} else {
							continue;
						}


					}

				}catch (NotFoundException e ) {
					//pass
				}catch (NullPointerException e) {
					System.out.println("QR Reader closed with no QR	 :: " + e.getMessage());
					break;
				}

			} while(true);

		}).start();

	}
}