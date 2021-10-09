# simple_bank_client_CRUD_app
A Java application that allows bank staff to carry out CRUD (create, read, update and delete) operations on behalf of the clients.

#### *Disclaimers*
The functions in this app is client-focused, user will always be the __bank staff__.

* #### Client Accounts
  * There are 2 account types for the clients: Savings and Current.
  * The table for [client's details](https://github.com/maybeaveragedude/simple_bank_client_CRUD_app/blob/master/db/clientdetails.txt) has a flaw where you'll see 2 entries of the same individual, BUT with different account types. Account No. are auto-incremental.
  * Client's password are tied to their account type, example: 
    * account no | account type | name | password |
      ------------ | ------------- | ------------ | -------------
      1 | current | John Dough | 123
      6 | savings | John Dough | 420
  * Most of the account identifications are done through referring client's IC No. and Account No.
* #### Password
  * Password encryption is SHA1 hash and salted with 30 total random alphabets and integers. [[Reference Link](https://www.appsdeveloperblog.com/encrypt-user-password-example-java/)]
  * If you want to add new staff entries, you'll have to call the methods individually from [PasswordUtils.java](https://github.com/maybeaveragedude/simple_bank_client_CRUD_app/blob/master/src/jpbankpjct/PasswordUtils.java) or [PasswordTools.java](https://github.com/maybeaveragedude/simple_bank_client_CRUD_app/blob/master/src/jpbankpjct/PasswordTools.java) to get encrypted password and salt.
* #### QR Code Login
  * In real-world simulation, staffs can print out or email the client's login QR code for easy access.
  * QR code image will be automatically generated after changing or creating passwords. *In case of any error, QR code can be generated again by pressing "Show QR" from the client's home interface.*
  * QR code images are generated in [QRUtils.java](https://github.com/maybeaveragedude/simple_bank_client_CRUD_app/blob/master/src/jpbankpjct/QRUtils.java). [[Reference Link](https://www.callicoder.com/qr-code-reader-scanner-in-java-using-zxing/)]
  * Reading QR code done through using webcam in [QRWebcamReader.java](https://github.com/maybeaveragedude/simple_bank_client_CRUD_app/blob/master/src/jpbankpjct/QRWebcamReader.java). [[Reference Link](https://github.com/vivekkairi/webcam-qr-barcode-scanner)]

## How does it function?
1. Bank staff will login by running [StaffLogin.java](https://github.com/maybeaveragedude/simple_bank_client_CRUD_app/blob/master/src/jpbankpjct/StaffLogin.java)
  * username | password
    ------------ | -------------
    admin | 123
2. Client can be registered by staffs.
3. Staffs can choose to login on behalf of the client through QR method or entering account no. and password.
4. Clients can request to change password and staffs can change it from the menu bar (Client > Edit). *Changing password will take immediate effect*

### Folders
* #### [src](https://github.com/maybeaveragedude/simple_bank_client_CRUD_app/tree/master/src)
  * contains all the Java classes
  * [log4j.properties](https://github.com/maybeaveragedude/simple_bank_client_CRUD_app/blob/master/src/log4j.properties) was created to fix weird logging behaviours.
* #### [db](https://github.com/maybeaveragedude/simple_bank_client_CRUD_app/tree/master/db)
  * the flat-file database repo
  * db files are in headerless CSV format, column name for each tables can be refered from [dbtables.txt](https://github.com/maybeaveragedude/simple_bank_client_CRUD_app/blob/master/db/dbtables.txt)
* #### [QRrepo](https://github.com/maybeaveragedude/simple_bank_client_CRUD_app/tree/master/QRrepo)
  * repository for the generated client login QR codes
* #### [bin](https://github.com/maybeaveragedude/simple_bank_client_CRUD_app/tree/master/bin)
  * folder for the compiled classes (auto-generated)
