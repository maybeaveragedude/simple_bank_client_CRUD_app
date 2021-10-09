package jpbankpjct;

import java.io.File;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Path;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;

// referenced from https://www.callicoder.com/qr-code-reader-scanner-in-java-using-zxing/
public class QRUtils {

	public static void generateQRCodeImage(String generateString) throws WriterException, IOException {
		Integer width = 350, height = 350;
		String[] splitString = generateString.split(",");

		String sAccountNo = splitString[0];
		String filePath = "QRrepo/client" + sAccountNo +".png";


		File temp = new File(filePath); //rewrite files
		System.out.println(temp);
		if (temp.exists()) {

			temp.delete();
			System.out.println("File deleted!");
		} else {
			System.out.println("File doesnt exist!");
		}


		QRCodeWriter qrCodeWriter = new QRCodeWriter();
		BitMatrix bitMatrix = qrCodeWriter.encode(generateString, BarcodeFormat.QR_CODE, width, height);

		Path path = FileSystems.getDefault().getPath(filePath);
		MatrixToImageWriter.writeToPath(bitMatrix, "PNG", path);
	}

}
