package jpbankpjct;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.google.zxing.WriterException;

public class ClientCRUD {

	//	public static void main(String[] args){
	//
	//	}

	public static Boolean create(Integer AccountNo, String LegalName, Long ICNo, Long ContactNo, String Email, String CPasswordSalt, String CPassword, String AccountType, String DateCreated)
	{

		try {

			String SAccountNo = String.valueOf(AccountNo);
			String SICNo = String.valueOf(ICNo);
			String SContactNo = String.valueOf(ContactNo);

			String clientRecord;

			String existAccountType;
			Long existIC;


			// Using file pointer creating the file.

			File file = new File("db/clientdetails.txt");
			//            System.out.println(file.getPath());

			if (!file.exists()) {

				// Create a new file if not exists.
				file.createNewFile();
			}

			File balancefile = new File("db/accountbalance.txt");
			//          System.out.println(file.getPath());

			if (!balancefile.exists()) {

				// Create a new file if not exists.
				balancefile.createNewFile();
			}

			// Opening file in reading and write mode.

			RandomAccessFile raf = new RandomAccessFile(file, "rw");
			boolean found = false;

			// Checking whether the name
			// of contact already exists.
			// getFilePointer() give the current offset
			// value from start of the file.
			while (raf.getFilePointer() < raf.length()) {

				// reading line from the file.
				clientRecord = raf.readLine();

				// splitting the string to get name and
				// number
				String[] lineSplit = clientRecord.split(",");

				// separating name and number.

				//[0]		 [1]   [2]	[3]		[4]		[5]	 [6]	[7]	 [8]
				//accountNo, name, IC, contact, email, salt, pass, type, date

				Integer.parseInt(lineSplit[0]);
				existIC = Long.parseLong(lineSplit[2]);
				existAccountType = lineSplit[7];
				// if condition to find existence of record.
				if (existIC.equals(ICNo) && existAccountType.equals(AccountType)) {
					found = true;
					System.out.println("Record Exists");
					raf.close();
					return false;
					//                    break;

				}
			}

			if (!found) {

				// Enter the if block when a record
				// is not already present in the file.
				clientRecord =
						SAccountNo + "," +
								LegalName + "," +
								SICNo + "," +
								SContactNo + "," +
								Email + "," +
								CPasswordSalt + "," +
								CPassword + "," +
								AccountType + "," +
								DateCreated;

				// writeBytes function to write a string
				// as a sequence of bytes.
				if(genQR(AccountNo, CPassword)) {
					UI.popupMessages.create("QR login generated!", "QR Status");
				}
				raf.writeBytes(clientRecord);

				// To insert the next record in new line.
				raf.writeBytes(System.lineSeparator());

				// Print the message
				System.out.println(clientRecord);
				System.out.println("New record added.");


				Boolean balanceStatus = setBalance(AccountNo);
				if (balanceStatus) {
					System.out.println("New balance added into account!");

				} else {
					System.out.println("Balance can't be initialized!");
				}

				// Closing the resources.
				raf.close();
			}
			// The contact to be updated
			// could not be found
			else {

				// Closing the resources.
				raf.close();

			}
		}

		catch (IOException ioe) {

			System.out.println(ioe);
			return false;
		}
		catch (NumberFormatException nef) {

			System.out.println(nef);
			return false;
		}
		return true;
	}

	public static Boolean delete(Integer AccountNo) {

		String clientRecords;
		Integer existAccountNo;
		Long existIC;


		try {
			File clientsfile = new File("db/clientdetails.txt");
			RandomAccessFile read = new RandomAccessFile(clientsfile, "rw");

			File temp = new File("db/tempentry.txt");
			RandomAccessFile readtemp = new RandomAccessFile(temp, "rw");

			while (read.getFilePointer() < read.length()) {

				// reading line from the file.
				clientRecords = read.readLine();

				// splitting the string
				String[] clientCol = clientRecords.split(",");

				existAccountNo = Integer.parseInt(clientCol[0]);

				//[0]		 [1]   [2]	[3]		[4]		[5]	 [6]	[7]	 [8]
				//accountNo, name, IC, contact, email, salt, pass, type, date
				existAccountNo = Integer.parseInt(clientCol[0]);
				String.valueOf(existAccountNo);

				existIC = Long.parseLong(clientCol[2]);
				String.valueOf(existIC);

				if (AccountNo.equals(existAccountNo)) {
					//skips the selected record
					continue;


				}	else { //Copy original values
					readtemp.writeBytes(clientRecords);
					readtemp.writeBytes(System.lineSeparator());
				}


			} //Rewriting original file with updated values from TEMP

			read.seek(0);
			readtemp.seek(0);

			while (readtemp.getFilePointer() < readtemp.length()) {
				read.writeBytes(readtemp.readLine());
				read.writeBytes(System.lineSeparator());
			}

			read.setLength(readtemp.length());

			readtemp.close();
			read.close();

			// Deleting the temporary file
			temp.delete();

			System.out.println("Record Deleted!");
			deleteTransactions(AccountNo);
			deleteBalance(AccountNo);
			return true;


		}
		catch (IOException ioe) {

			System.out.println(ioe);
			return false;
		}
		catch (NumberFormatException nef) {

			System.out.println(nef);
			return false;
		}






	}

	public static Boolean delete(Long ICNo) {

		String clientRecords;
		Integer existAccountNo;
		Long existIC;


		try {
			File clientsfile = new File("db/clientdetails.txt");
			RandomAccessFile read = new RandomAccessFile(clientsfile, "rw");

			File temp = new File("db/tempentry.txt");
			RandomAccessFile readtemp = new RandomAccessFile(temp, "rw");

			while (read.getFilePointer() < read.length()) {

				// reading line from the file.
				clientRecords = read.readLine();

				// splitting the string
				String[] clientCol = clientRecords.split(",");


				//[0]		 [1]   [2]	[3]		[4]		[5]	 [6]	[7]	 [8]
				//accountNo, name, IC, contact, email, salt, pass, type, date
				existAccountNo = Integer.parseInt(clientCol[0]);
				String.valueOf(existAccountNo);

				existIC = Long.parseLong(clientCol[2]);
				String.valueOf(existIC);

				if (ICNo.equals(existIC)) {
					//skips the selected record
					deleteTransactions(existAccountNo);
					deleteBalance(existAccountNo);
					continue;



				}	else { //Copy original values
					readtemp.writeBytes(clientRecords);
					readtemp.writeBytes(System.lineSeparator());
				}


			} //Rewriting original file with updated values from TEMP

			read.seek(0);
			readtemp.seek(0);

			while (readtemp.getFilePointer() < readtemp.length()) {
				read.writeBytes(readtemp.readLine());
				read.writeBytes(System.lineSeparator());
			}

			read.setLength(readtemp.length());

			readtemp.close();
			read.close();

			// Deleting the temporary file
			temp.delete();

			System.out.println("Record Deleted!");

			return true;


		}
		catch (IOException ioe) {

			System.out.println(ioe);
			return false;
		}
		catch (NumberFormatException nef) {

			System.out.println(nef);
			return false;
		}






	}

	public static Integer retrieve(String setNewRecord) {
		Integer highestAccountNo = 0;

		try {


			String clientRecord;

			Integer existAccountNo;

			// Using file pointer creating the file.

			File file = new File("db/clientdetails.txt");
			//            System.out.println(file.getPath());

			if (!file.exists()) {

				// Create a new file if not exists.
				file.createNewFile();
			}

			// Opening file in reading and write mode.

			RandomAccessFile raf = new RandomAccessFile(file, "rw");

			while (raf.getFilePointer() < raf.length()) {

				// reading line from the file.
				clientRecord = raf.readLine();

				// splitting the string to get name and
				// number
				String[] lineSplit = clientRecord.split(",");

				// separating name and number.
				existAccountNo = Integer.parseInt(lineSplit[0]);

				if (existAccountNo >= highestAccountNo) {
					highestAccountNo = existAccountNo;
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
		highestAccountNo ++;
		return highestAccountNo;
	}

	public static Boolean genQR(Integer accountNo, String encryptedPass) {
		String generatedString = String.valueOf(accountNo) + "," + encryptedPass;

		try {
			QRUtils.generateQRCodeImage(generatedString);
		} catch (WriterException e) {
			System.out.println("Could not generate QR Code, WriterException :: " + e.getMessage());
			return false;
		} catch (IOException e) {
			System.out.println("Could not generate QR Code, IOException :: " + e.getMessage());
			return false;
		}

		return true;
	}

	public static String[] retrieve(Integer AccountNo) {
		String[] returnRecord = {};

		try {


			String clientRecord;

			Integer existAccountNo;

			// Using file pointer creating the file.

			File file = new File("db/clientdetails.txt");
			//            System.out.println(file.getPath());

			if (!file.exists()) {

				// Create a new file if not exists.
				file.createNewFile();
			}

			// Opening file in reading and write mode.

			RandomAccessFile raf = new RandomAccessFile(file, "r");


			while (raf.getFilePointer() < raf.length()) {

				// reading line from the file.
				clientRecord = raf.readLine();

				// splitting the string to get name and
				// number
				returnRecord = clientRecord.split(",");

				existAccountNo = Integer.parseInt(returnRecord[0]);

				if (existAccountNo.equals(AccountNo)) {
					raf.close();
					return returnRecord;

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
		return returnRecord;
	}

	public static String[] retrieve(Long ICNo) {
		String[] returnRecord = {};

		try {


			String clientRecord;

			Long existIC;

			// Using file pointer creating the file.

			File file = new File("db/clientdetails.txt");
			//            System.out.println(file.getPath());

			if (!file.exists()) {

				// Create a new file if not exists.
				file.createNewFile();
			}

			// Opening file in reading and write mode.

			RandomAccessFile raf = new RandomAccessFile(file, "r");


			while (raf.getFilePointer() < raf.length()) {

				// reading line from the file.
				clientRecord = raf.readLine();

				// splitting the string to get name and
				// number
				returnRecord = clientRecord.split(",");

				existIC = Long.parseLong(returnRecord[2]);

				if (existIC.equals(ICNo)) {
					raf.close();
					return returnRecord;

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
		return returnRecord;
	}

	public static String retrieveTransactions(Integer AccountNo) {
		//		Integer skipindex = index;
		String[] returnRecord = {};

		try {


			String clientRecord;

			Integer existAccountNo;

			// Using file pointer creating the file.

			File file = new File("db/transactions.txt");
			//            System.out.println(file.getPath());

			if (!file.exists()) {

				// Create a new file if not exists.
				file.createNewFile();
			}

			// Opening file in reading and write mode.

			RandomAccessFile raf = new RandomAccessFile(file, "r");

			//            raf.seek(skipindex);

			while (raf.getFilePointer() < raf.length()) {

				// reading line from the file.
				clientRecord = raf.readLine();

				returnRecord = clientRecord.split(",");

				// separating name and number.
				existAccountNo = Integer.parseInt(returnRecord[1]);

				if (existAccountNo.equals(AccountNo)) {
					//                	skipindex ++;
					//                	return String.valueOf(skipindex) + "," + clientRecord;
					System.out.println(clientRecord);

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
		//        return returnRecord;
		//        return "end" ;
		return null;
	}

	public static Boolean deleteTransactions(Integer AccountNo) {
		String transactions;
		Integer existAccountNo;

		try {
			File transactionfile = new File("db/transactions.txt");
			RandomAccessFile read = new RandomAccessFile(transactionfile, "rw");

			File temp = new File("db/temptransaction.txt");
			RandomAccessFile readtemp = new RandomAccessFile(temp, "rw");

			while (read.getFilePointer() < read.length()) {

				// reading line from the file.
				transactions = read.readLine();

				// splitting the string
				String[] lineSplit = transactions.split(",");


				existAccountNo = Integer.parseInt(lineSplit[1]);


				if (AccountNo.equals(existAccountNo)) {

					continue;


				} else {
					readtemp.writeBytes(transactions);
					readtemp.writeBytes(System.lineSeparator());


				}



			}
			read.seek(0);
			readtemp.seek(0);

			while (readtemp.getFilePointer() < readtemp.length()) {
				read.writeBytes(readtemp.readLine());
				read.writeBytes(System.lineSeparator());
			}

			// Set the length of the original file
			// to that of temporary.
			read.setLength(readtemp.length());

			// Closing the resources.
			readtemp.close();
			read.close();

			// Deleting the temporary file
			temp.delete();

			System.out.println("Transactions Deleted");



		}
		catch (IOException ioe) {

			System.out.println(ioe);
			return false;
		}
		catch (NumberFormatException nef) {

			System.out.println(nef);
			return false;
		}
		return true;

	}

	public static Integer transLength(Integer AccountNo) {
		int count = 0;
		String[] returnRecord = {};

		try {


			String clientRecord;

			Integer existAccountNo;

			// Using file pointer creating the file.

			File file = new File("db/transactions.txt");
			//            System.out.println(file.getPath());

			if (!file.exists()) {

				// Create a new file if not exists.
				file.createNewFile();
			}

			// Opening file in reading and write mode.

			RandomAccessFile raf = new RandomAccessFile(file, "r");


			while (raf.getFilePointer() < raf.length()) {

				// reading line from the file.
				clientRecord = raf.readLine();

				returnRecord = clientRecord.split(",");

				// separating name and number.
				existAccountNo = Integer.parseInt(returnRecord[1]);

				if (existAccountNo.equals(AccountNo)) {
					count ++;

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
		//        System.out.println(count);
		return count;
	}

	public static Boolean setBalance(Integer AccountNo, Double updateAmount) {
		String accountBalances, SAccountNo;
		Integer existAccountNo;
		Double existBalance;



		try {
			File balancefile = new File("db/accountbalance.txt");

			RandomAccessFile read = new RandomAccessFile(balancefile, "rw");
			File temp = new File("db/tempentry.txt");
			RandomAccessFile readtemp = new RandomAccessFile(temp, "rw");
			while (read.getFilePointer() < read.length()) {

				// reading line from the file.
				accountBalances = read.readLine();

				// splitting the string
				String[] lineSplit = accountBalances.split(",");

				existAccountNo = Integer.parseInt(lineSplit[0]);
				existBalance = Double.parseDouble(lineSplit[1]);
				SAccountNo = String.valueOf(AccountNo);

				if (AccountNo.equals(existAccountNo)) {
					existBalance = updateAmount;

					accountBalances = SAccountNo + "," + String.valueOf(existBalance); //preparing the new string

					readtemp.writeBytes(accountBalances); //writing the string into the file
					readtemp.writeBytes(System.lineSeparator());


				} else {
					readtemp.writeBytes(accountBalances);
					readtemp.writeBytes(System.lineSeparator());


				}



			}
			read.seek(0);
			readtemp.seek(0);

			while (readtemp.getFilePointer() < readtemp.length()) {
				read.writeBytes(readtemp.readLine());
				read.writeBytes(System.lineSeparator());
			}

			// Set the length of the original file
			// to that of temporary.
			read.setLength(readtemp.length());

			// Closing the resources.
			readtemp.close();
			read.close();

			// Deleting the temporary file
			temp.delete();

			System.out.println("Balance Updated");



		}
		catch (IOException ioe) {

			System.out.println(ioe);
		}
		catch (NumberFormatException nef) {

			System.out.println(nef);
		}
		return true;



	}

	public static Boolean editClient(Long ICNo, Long newContact, String newEmail) {
		String clientRecords, existLegalName, sExistAccountNo, sExistICNo, sNewContactNo, existSalt, existPass, existAccountType, existDate;
		Integer existAccountNo;
		Long existIC;


		try {
			File clientsfile = new File("db/clientdetails.txt");
			RandomAccessFile read = new RandomAccessFile(clientsfile, "rw");

			File temp = new File("db/tempentry.txt");
			RandomAccessFile readtemp = new RandomAccessFile(temp, "rw");

			while (read.getFilePointer() < read.length()) {

				// reading line from the file.
				clientRecords = read.readLine();

				// splitting the string
				String[] clientCol = clientRecords.split(",");

				existAccountNo = Integer.parseInt(clientCol[0]);

				//[0]		 [1]   [2]	[3]		[4]		[5]	 [6]	[7]	 [8]
				//accountNo, name, IC, contact, email, salt, pass, type, date
				existAccountNo = Integer.parseInt(clientCol[0]);
				sExistAccountNo = String.valueOf(existAccountNo);

				existLegalName = clientCol[1];

				existIC = Long.parseLong(clientCol[2]);
				sExistICNo = String.valueOf(existIC);

				existSalt = clientCol[5];
				existPass = clientCol[6];
				existAccountType = clientCol[7];
				existDate = clientCol[8];


				if (ICNo.equals(existIC)) {
					sNewContactNo = String.valueOf(newContact);

					clientRecords = //preparing the new string
							sExistAccountNo + "," +
							existLegalName + "," +
							sExistICNo + "," +
							sNewContactNo + "," +
							newEmail + "," +
							existSalt + "," +
							existPass + "," +
							existAccountType + "," +
							existDate;


					readtemp.writeBytes(clientRecords); //writing the string into the file
					readtemp.writeBytes(System.lineSeparator());


				}	else { //Copy original values
					readtemp.writeBytes(clientRecords);
					readtemp.writeBytes(System.lineSeparator());
				}


			} //Rewriting original file with updated values from TEMP

			read.seek(0);
			readtemp.seek(0);

			while (readtemp.getFilePointer() < readtemp.length()) {
				read.writeBytes(readtemp.readLine());
				read.writeBytes(System.lineSeparator());
			}

			read.setLength(readtemp.length());

			readtemp.close();
			read.close();

			// Deleting the temporary file
			temp.delete();

			System.out.println("Record Updated!");
			return true;


		}
		catch (IOException ioe) {

			System.out.println(ioe);
			return false;
		}
		catch (NumberFormatException nef) {

			System.out.println(nef);
			return false;
		}



	}


	public static Boolean deleteBalance(Integer AccountNo) {
		String accountBalances;
		Integer existAccountNo;
		try {
			File balancefile = new File("db/accountbalance.txt");

			RandomAccessFile read = new RandomAccessFile(balancefile, "rw");
			File temp = new File("db/tempbalance.txt");
			RandomAccessFile readtemp = new RandomAccessFile(temp, "rw");
			while (read.getFilePointer() < read.length()) {

				// reading line from the file.
				accountBalances = read.readLine();

				// splitting the string
				String[] lineSplit = accountBalances.split(",");

				existAccountNo = Integer.parseInt(lineSplit[0]);
				Double.parseDouble(lineSplit[1]);
				String.valueOf(AccountNo);

				if (AccountNo.equals(existAccountNo)) {

					continue;


				} else {
					readtemp.writeBytes(accountBalances);
					readtemp.writeBytes(System.lineSeparator());


				}



			}
			read.seek(0);
			readtemp.seek(0);

			while (readtemp.getFilePointer() < readtemp.length()) {
				read.writeBytes(readtemp.readLine());
				read.writeBytes(System.lineSeparator());
			}

			// Set the length of the original file
			// to that of temporary.
			read.setLength(readtemp.length());

			// Closing the resources.
			readtemp.close();
			read.close();

			// Deleting the temporary file
			temp.delete();

			System.out.println("Balance Deleted");



		}
		catch (IOException ioe) {

			System.out.println(ioe);
			return false;
		}
		catch (NumberFormatException nef) {

			System.out.println(nef);
			return false;
		}
		return true;

	}

	public static Boolean newPass(Integer AccountNo, String newSalt, String newEncryptedPass) {
		String clientRecords, existLegalName, sExistAccountNo, sExistICNo, existContact, existEmail, existAccountType, existDate;
		Integer existAccountNo;
		Long existIC;



		try {
			File clientsfile = new File("db/clientdetails.txt");
			RandomAccessFile read = new RandomAccessFile(clientsfile, "rw");

			File temp = new File("db/tempentry.txt");
			RandomAccessFile readtemp = new RandomAccessFile(temp, "rw");

			while (read.getFilePointer() < read.length()) {

				// reading line from the file.
				clientRecords = read.readLine();

				// splitting the string
				String[] clientCol = clientRecords.split(",");

				//[0]		 [1]   [2]	[3]		[4]		[5]	 [6]	[7]	 [8]
				//accountNo, name, IC, contact, email, salt, pass, type, date
				existAccountNo = Integer.parseInt(clientCol[0]);

				existAccountNo = Integer.parseInt(clientCol[0]);
				sExistAccountNo = String.valueOf(existAccountNo);

				existLegalName = clientCol[1];

				existIC = Long.parseLong(clientCol[2]);
				sExistICNo = String.valueOf(existIC);

				existContact = clientCol[3];
				existEmail = clientCol[4];
				existAccountType = clientCol[7];
				existDate = clientCol[8];


				if (AccountNo.equals(existAccountNo)) {

					clientRecords = //preparing the new string
							sExistAccountNo + "," +
							existLegalName + "," +
							sExistICNo + "," +
							existContact + "," +
							existEmail + "," +
							newSalt + "," +
							newEncryptedPass + "," +
							existAccountType + "," +
							existDate;


					readtemp.writeBytes(clientRecords); //writing the string into the file
					readtemp.writeBytes(System.lineSeparator());


				}	else { //Copy original values
					readtemp.writeBytes(clientRecords);
					readtemp.writeBytes(System.lineSeparator());
				}


			} //Rewriting original file with updated values from TEMP

			read.seek(0);
			readtemp.seek(0);

			while (readtemp.getFilePointer() < readtemp.length()) {
				read.writeBytes(readtemp.readLine());
				read.writeBytes(System.lineSeparator());
			}

			read.setLength(readtemp.length());

			readtemp.close();
			read.close();

			// Deleting the temporary file
			temp.delete();

			System.out.println("Password Updated!");
			return true;


		}
		catch (IOException ioe) {

			System.out.println(ioe);
			return false;
		}
		catch (NumberFormatException nef) {

			System.out.println(nef);
			return false;
		}


	}


	public static Boolean setBalance(Integer AccountNo) {
		String accountBalances, SAccountNo;
		Integer existAccountNo;
		Double amount = 0.0;
		SAccountNo = String.valueOf(AccountNo);



		try {
			File balancefile = new File("db/accountbalance.txt");

			RandomAccessFile read = new RandomAccessFile(balancefile, "rw");

			while (read.getFilePointer() < read.length()) {

				// reading line from the file.
				accountBalances = read.readLine();

				// splitting the string
				String[] lineSplit = accountBalances.split(",");

				existAccountNo = Integer.parseInt(lineSplit[0]);
				Double.parseDouble(lineSplit[1]);


				if (AccountNo.equals(existAccountNo)) {
					read.close();
					return false;


				}


			}
			accountBalances = SAccountNo + "," + String.valueOf(amount);

			read.writeBytes(accountBalances);
			read.writeBytes(System.lineSeparator());

			read.close();
			return true;



		}
		catch (IOException ioe) {

			System.out.println(ioe);
		}
		catch (NumberFormatException nef) {

			System.out.println(nef);
		}
		return false;



	}

	public static Double getBalance(Integer AccountNo) {
		Double balance = null;



		try {
			File balancefile = new File("db/accountbalance.txt");
			//      System.out.println(file.getPath());

			if (!balancefile.exists()) {

				// Create a new file if not exists.
				balancefile.createNewFile();
			}

			RandomAccessFile rBalance = new RandomAccessFile(balancefile, "r");
			while (rBalance.getFilePointer() < rBalance.length()) {

				// reading line from the file.
				String clientBalance = rBalance.readLine();

				String[] clientBalanceRecord = clientBalance.split(",");
				Integer dbAccountNo = Integer.parseInt(clientBalanceRecord[0]);
				Double accountBalance = Double.parseDouble(clientBalanceRecord[1]);

				if(dbAccountNo.equals(AccountNo)) {
					rBalance.close();
					return accountBalance;


				}
			}
			rBalance.close();
		}
		catch (IOException ioe) {

			System.out.println(ioe);
		}
		catch (NumberFormatException nef) {

			System.out.println(nef);
		}

		return balance;


	}

	public static Integer getTransactionID() {
		//		Double balance = null;
		Integer maxID = 0;


		try {
			File transactionsfile = new File("db/transactions.txt");
			//      System.out.println(file.getPath());

			if (!transactionsfile.exists()) {

				// Create a new file if not exists.
				transactionsfile.createNewFile();
			}

			RandomAccessFile rBalance = new RandomAccessFile(transactionsfile, "r");
			while (rBalance.getFilePointer() < rBalance.length()) {

				// reading line from the file.
				String transactionsRecord = rBalance.readLine();

				String[] recordString = transactionsRecord.split(",");
				Integer transactionID = Integer.parseInt(recordString[0]);
				Integer.parseInt(recordString[1]);
				Double.parseDouble(recordString[2]);
				Double.parseDouble(recordString[3]);
				if(transactionID >= maxID) {
					maxID = transactionID;

				}
			}
			rBalance.close();
		}
		catch (IOException ioe) {

			System.out.println(ioe);
		}
		catch (NumberFormatException nef) {

			System.out.println(nef);
		}
		maxID ++;
		return maxID;


	}

	public static Boolean setTransactionWithdraw(Integer maxID, Integer accountNo, Double withdrawAmt) {
		//		Double balance = null;
		//		Integer maxID = 0;
		String transactionsRecord;
		SimpleDateFormat formatDate = new SimpleDateFormat("dd/MM/yyyy");
		Date date = new Date();
		String DateCreated = formatDate.format(date);

		try {
			File transactionsfile = new File("db/transactions.txt");
			//      System.out.println(file.getPath());

			if (!transactionsfile.exists()) {

				// Create a new file if not exists.
				transactionsfile.createNewFile();
			}

			RandomAccessFile rwTransaction = new RandomAccessFile(transactionsfile, "rw");
			while (rwTransaction.getFilePointer() < rwTransaction.length()) {

				// reading line from the file.
				transactionsRecord = rwTransaction.readLine();

				String[] recordString = transactionsRecord.split(",");
				Integer transactionID = Integer.parseInt(recordString[0]);
				//                Integer existaccountNo = Integer.parseInt(recordString[1]);
				//                Double withdrawAmt = Double.parseDouble(recordString[2]);
				//                Double depositAmt = Double.parseDouble(recordString[3]);
				//                String transactionDate =(recordString[4]);

				if(transactionID.equals(maxID)) {
					UI.popupMessages.create("Repeated transaction ID", "Internal Error");


				}
			}

			transactionsRecord =
					String.valueOf(maxID) + "," +
							String.valueOf(accountNo) + "," +
							String.valueOf(withdrawAmt) + "," +
							"0.0" + "," +
							DateCreated;

			rwTransaction.writeBytes(transactionsRecord);
			rwTransaction.writeBytes(System.lineSeparator());
			UI.popupMessages.create("Withdrawal transaction recorded!\nWithdrawn RM" + String.valueOf(withdrawAmt), "Transactions");
			rwTransaction.close();
		}
		catch (IOException ioe) {

			System.out.println(ioe);
		}
		catch (NumberFormatException nef) {

			System.out.println(nef);
		}
		return true;


	}

	public static Boolean setTransactionDeposit(Integer maxID, Integer accountNo, Double depositAmt) {
		//		Double balance = null;
		//		Integer maxID = 0;
		String transactionsRecord;
		SimpleDateFormat formatDate = new SimpleDateFormat("dd/MM/yyyy");
		Date date = new Date();
		String DateCreated = formatDate.format(date);

		try {
			File transactionsfile = new File("db/transactions.txt");
			//      System.out.println(file.getPath());

			if (!transactionsfile.exists()) {

				// Create a new file if not exists.
				transactionsfile.createNewFile();
			}

			RandomAccessFile rwTransaction = new RandomAccessFile(transactionsfile, "rw");
			while (rwTransaction.getFilePointer() < rwTransaction.length()) {

				// reading line from the file.
				transactionsRecord = rwTransaction.readLine();

				String[] recordString = transactionsRecord.split(",");
				Integer transactionID = Integer.parseInt(recordString[0]);
				//                Integer existaccountNo = Integer.parseInt(recordString[1]);
				//                Double withdrawAmt = Double.parseDouble(recordString[2]);
				//                Double depositAmt = Double.parseDouble(recordString[3]);
				//                String transactionDate =(recordString[4]);

				if(transactionID.equals(maxID)) {
					UI.popupMessages.create("Repeated transaction ID", "Internal Error");


				}
			}

			transactionsRecord =
					String.valueOf(maxID) + "," +
							String.valueOf(accountNo) + "," +
							"0.0" + "," +
							String.valueOf(depositAmt) + "," +
							DateCreated;

			rwTransaction.writeBytes(transactionsRecord);
			rwTransaction.writeBytes(System.lineSeparator());
			UI.popupMessages.create("Deposit transaction recorded!\nDeposited RM" + String.valueOf(depositAmt), "Transactions");
			rwTransaction.close();
		}
		catch (IOException ioe) {

			System.out.println(ioe);
		}
		catch (NumberFormatException nef) {

			System.out.println(nef);
		}
		return true;


	}


}
