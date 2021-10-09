package jpbankpjct;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

public class retrieveRecords {

	public static Integer main()
	{
		Integer highestAccountNo = 0;

		try {

			// Get the name of the contact to be updated
			// from the Command line argument
			//            String newName = data[0];

			// Get the number to be updated
			// from the Command line argument
			//            long newNumber = Long.parseLong(data[1]);
			//        	String SAccountNo = String.valueOf(AccountNo);
			//        	String SICNo = String.valueOf(ICNo);
			//

			String clientRecord;

			//            String existLegalName, existIC, existPass, existAccountType, existDate;
			//            String name;
			//            long number;
			//            int index;

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
				existAccountNo = Integer.parseInt(lineSplit[0]);

				if (existAccountNo >= highestAccountNo) {
					highestAccountNo = existAccountNo;
				}
				//                existLegalName = lineSplit[1];
				//                existIC = lineSplit[2];
				//                existPass = lineSplit[3];
				//                existAccountType = lineSplit[4];
				////                existDate = lineSplit[5];
				//                System.out.println();
				//                System.out.println("Existing Account: " + existAccountNo);
				//                System.out.println();
				//                System.out.println("Current Input Account: " + AccountNo);
				//                System.out.println();
				//                System.out.println(existAccountNo == AccountNo);
				//                // if condition to find existence of record.
				//                if (existAccountNo == AccountNo) {
				//                    found = true;
				//                    System.out.println("Record Exists");
				//                    break;
				//                }
			}
			raf.close();
			highestAccountNo ++;

			System.out.println(highestAccountNo);


		}

		catch (IOException ioe) {

			System.out.println(ioe);
		}
		catch (NumberFormatException nef) {

			System.out.println(nef);
		}

		return highestAccountNo;
	}
}




