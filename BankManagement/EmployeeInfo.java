import java.lang.*;
import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;


public class  EmployeeInfo extends JFrame implements ActionListener
{
	private JPanel panel;
	private JButton info,manageCustomer,deposit,withdraw,transfer,passChngRequest,logOut,bttn;
	private JLabel logolabel;
	private ImageIcon logo;
	
	private JLabel EName,EID,CDOB,EPhoneInfo,ENID,EJoinDate,EAddress,ESalary,EGender,EType,EPassword;
	
	private JTextField Name,ID,DOB,PhoneInfo,Address,NID,JoinDate,Password,Salary,Type,Gender;
    private static String Bank_id;
	
	
	public EmployeeInfo(String Bank_id)
	{
		super("Employee Information");
		this.setSize(800,600);
		this.Bank_id=Bank_id;
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Font myFont= new Font("Consolas",Font.PLAIN, 25);
		Color fontColor = new Color (41,41,41);
		Color panelColor = new Color (225,225,225);
		Color buttonColColor = new Color (74,96,132);
		Color activeButtonColColor = new Color (249,249,249);
	
		panel= new JPanel ();
		panel.setLayout(null);
		panel.setBackground(panelColor);
	
		logo = new ImageIcon("logo.jpg");
		logolabel = new JLabel(logo);
		logolabel.setBounds(0,-25,800,150);
		panel.add(logolabel);
		
		
		/*----------------SIDEBAR----------------*/
		int xAxis=0,yAxis=100,width=250,height=40;
		
		info =new JButton("INFO");
		info.setBounds(xAxis,yAxis,width,height);
		info.setFont(myFont);
		info.setForeground(fontColor);
		info.setBackground(activeButtonColColor);
		info.addActionListener(this);
		panel.add(info);
		
		deposit =new JButton("Deposit");
		deposit.setBounds(xAxis,yAxis+40,width,height);
		deposit.setFont(myFont);
		deposit.setForeground(fontColor);
		deposit.setBackground(buttonColColor);
		deposit.addActionListener(this);
		panel.add(deposit);
		
		withdraw =new JButton("WITHDRAW");
		withdraw.setBounds(xAxis,yAxis+80,width,height);
		withdraw.setFont(myFont);
		withdraw.setForeground(fontColor);
		withdraw.setBackground(buttonColColor);
		withdraw.addActionListener(this);
		panel.add(withdraw);
		
		transfer =new JButton("TRANSFER");
		transfer.setBounds(xAxis,yAxis+120,width,height);
		transfer.setFont(myFont);
		transfer.setForeground(fontColor);
		transfer.setBackground(buttonColColor);
		transfer.addActionListener(this);
		panel.add(transfer);
		
		manageCustomer =new JButton("Manage Customer");
		manageCustomer.setBounds(xAxis,yAxis+160,width,height);
		manageCustomer.setFont(myFont);
		manageCustomer.setForeground(fontColor);
		manageCustomer.setBackground(buttonColColor);
		manageCustomer.addActionListener(this);
		panel.add(manageCustomer);
		
		passChngRequest =new JButton("Pass Change");
		passChngRequest.setBounds(xAxis,yAxis+200,width,height);
		passChngRequest.setFont(myFont);
		passChngRequest.setForeground(fontColor);
		passChngRequest.setBackground(buttonColColor);
		passChngRequest.addActionListener(this);
		panel.add(passChngRequest);
		
		logOut =new JButton("LOGOUT");
		logOut.setBounds(xAxis,yAxis+420,width,height);
		logOut.setFont(myFont);
		logOut.setForeground(fontColor);
		logOut.setBackground(buttonColColor);
		logOut.addActionListener(this);
		panel.add(logOut);

		/*---------------Info main-----------------*/
		
		int labelxAxis=290,labelyAxis=120,labelWidth=200,labelHeight=40;
		
		EName=new JLabel("Name");
		EName.setBounds(labelxAxis,labelyAxis,labelWidth,labelHeight);
		EName.setFont(myFont);
		EName.setForeground(fontColor);
		panel.add(EName);
		
		Name=new JTextField("");
		Name.setBounds(labelxAxis+250,labelyAxis,labelWidth,labelHeight);
		Name.setFont(myFont);
		Name.setForeground(fontColor);
		panel.add(Name);

		EID=new JLabel("Employee ID");
		EID.setBounds(labelxAxis,labelyAxis+40,labelWidth,labelHeight);
		EID.setFont(myFont);
		EID.setForeground(fontColor);
		panel.add(EID);
		
		ID=new JTextField("");
		ID.setBounds(labelxAxis+250,labelyAxis+40,labelWidth,labelHeight);
		ID.setFont(myFont);
		ID.setForeground(fontColor);
		panel.add(ID);

		CDOB=new JLabel("Date Of Birth");
		CDOB.setBounds(labelxAxis,labelyAxis+80,labelWidth,labelHeight);
		CDOB.setFont(myFont);
		CDOB.setForeground(fontColor);
		panel.add(CDOB);
		
		DOB=new JTextField("");
		DOB.setBounds(labelxAxis+250,labelyAxis+80,labelWidth,labelHeight);
		DOB.setFont(myFont);
		DOB.setForeground(fontColor);
		panel.add(DOB);

		EGender=new JLabel("Gender");
		EGender.setBounds(labelxAxis,labelyAxis+120,labelWidth,labelHeight);
		EGender.setFont(myFont);
		EGender.setForeground(fontColor);
		panel.add(EGender);
		
		Gender=new JTextField("");
		Gender.setBounds(labelxAxis+250,labelyAxis+120,labelWidth,labelHeight);
		Gender.setFont(myFont);
		Gender.setForeground(fontColor);
		panel.add(Gender);
		
		EType=new JLabel("Employee Type");
		EType.setBounds(labelxAxis,labelyAxis+160,labelWidth,labelHeight);
		EType.setFont(myFont);
		EType.setForeground(fontColor);
		panel.add(EType);
		
		Type=new JTextField("");
		Type.setBounds(labelxAxis+250,labelyAxis+160,labelWidth,labelHeight);
		Type.setFont(myFont);
		Type.setForeground(fontColor);
		panel.add(Type);

		EPhoneInfo=new JLabel("Phone No");
		EPhoneInfo.setBounds(labelxAxis,labelyAxis+200,labelWidth,labelHeight);
		EPhoneInfo.setFont(myFont);
		EPhoneInfo.setForeground(fontColor);
		panel.add(EPhoneInfo);
		
		PhoneInfo=new JTextField("");
		PhoneInfo.setBounds(labelxAxis+250,labelyAxis+200,labelWidth,labelHeight);
		PhoneInfo.setFont(myFont);
		PhoneInfo.setForeground(fontColor);
		panel.add(PhoneInfo);

		EAddress=new JLabel("Address");
		EAddress.setBounds(labelxAxis,labelyAxis+240,labelWidth,labelHeight);
		EAddress.setFont(myFont);
		EAddress.setForeground(fontColor);
		panel.add(EAddress);
		
		Address=new JTextField("");
		Address.setBounds(labelxAxis+250,labelyAxis+240,labelWidth,labelHeight);
		Address.setFont(myFont);
		Address.setForeground(fontColor);
		panel.add(Address);

		ENID=new JLabel("NID");
		ENID.setBounds(labelxAxis,labelyAxis+280,labelWidth,labelHeight);
		ENID.setFont(myFont);
		ENID.setForeground(fontColor);
		panel.add(ENID);
		
		NID=new JTextField("");
		NID.setBounds(labelxAxis+250,labelyAxis+280,labelWidth,labelHeight);
		NID.setFont(myFont);
		NID.setForeground(fontColor);
		panel.add(NID);

		EJoinDate=new JLabel("Join Date");
		EJoinDate.setBounds(labelxAxis,labelyAxis+320,labelWidth,labelHeight);
		EJoinDate.setFont(myFont);
		EJoinDate.setForeground(fontColor);
		panel.add(EJoinDate);
		
		JoinDate=new JTextField("");
		JoinDate.setBounds(labelxAxis+250,labelyAxis+320,labelWidth,labelHeight);
		JoinDate.setFont(myFont);
		JoinDate.setForeground(fontColor);
		panel.add(JoinDate);

		EPassword=new JLabel("Password");
		EPassword.setBounds(labelxAxis,labelyAxis+360,labelWidth,labelHeight);
		EPassword.setFont(myFont);
		EPassword.setForeground(fontColor);
		panel.add(EPassword);
		
		Password=new JTextField("");
		Password.setBounds(labelxAxis+250,labelyAxis+360,labelWidth,labelHeight);
		Password.setFont(myFont);
		Password.setForeground(fontColor);
		panel.add(Password);

		ESalary=new JLabel("Salary");
		ESalary.setBounds(labelxAxis,labelyAxis+400,labelWidth,labelHeight);
		ESalary.setFont(myFont);
		ESalary.setForeground(fontColor);
		panel.add(ESalary);

		Salary=new JTextField("");
		Salary.setBounds(labelxAxis+250,labelyAxis+400,labelWidth,labelHeight);
		Salary.setFont(myFont);
		Salary.setForeground(fontColor);
		panel.add(Salary);		
		
		this.add(panel);	
	}
	
	public void actionPerformed(ActionEvent ae)
	{
		String text = ae.getActionCommand();
		
		if(ae.getSource()== info)
		{
			loadFromDB();
            loadFromDB1();
		}
		
		if(ae.getSource()== withdraw)
		{
			EmployeeWithdraw ewithdraw = new EmployeeWithdraw(Bank_id);
			ewithdraw.setVisible(true);
			this.setVisible(false);
		}
		
		if(ae.getSource()== manageCustomer)
		{
			ManageCustomer manageC = new ManageCustomer(Bank_id);
			manageC.setVisible(true);
			this.setVisible(false);
		}
		if(ae.getSource()== deposit)
		{
			EmployeeDeposit deposit = new EmployeeDeposit(Bank_id);
			deposit.setVisible(true);
			this.setVisible(false);
		}
		if(ae.getSource()== transfer)
		{
			EmployeeTransfer etransfer = new EmployeeTransfer(Bank_id);
			etransfer.setVisible(true);
			this.setVisible(false);
		}
		if(ae.getSource()== passChngRequest)
		{
			PassChngRequest pcr = new PassChngRequest(Bank_id);
			pcr.setVisible(true);
			this.setVisible(false);
		}
		if(ae.getSource()== logOut)
		{
			Login login = new Login();
			login.setVisible(true);
			this.setVisible(false);
			
		}
	}
	
	
	
	public void loadFromDB()
	{
		String loadId = Bank_id;
		String query = "SELECT `Name`, `Date_of_birth`,`Gender`,`Employee_type`, `Phone_no`, `Address`,`NID`,`Join_date`,`Salary` FROM `employee` WHERE `Bank_id`='"+loadId+"';";     
        Connection con=null;//for connection
        Statement st = null;//for query execution
		ResultSet rs = null;//to get row by row result from DB
		System.out.println(query);
        try
		{
			Class.forName("com.mysql.jdbc.Driver");//load driver
			System.out.println("driver loaded");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bank","root","");
			System.out.println("connection done");//connection with database established
			st = con.createStatement();//create statement
			System.out.println("statement created");
			rs = st.executeQuery(query);//getting result
			System.out.println("results received");
			
			boolean flag = false;
			String iName = null;
			String iDOB = null;
			String iAddress = null;
			String iPhonenumber = null;
			String iGender = null;
			String iEtype = null;
			int iNID = 0;
			String iJoindate=null;
			double iBalance = 0.0;
			
			/*String iFatherName = null;
			String iGender = null;*/
			
			
			
			
			//String iBankId = null;
			
						
			while(rs.next())
			{   
		        
                iName = rs.getString("Name");
                //iFatherName = rs.getString("Father_name");
                //iGender = rs.getString("Gender");
                iDOB = rs.getString("Date_of_birth");
                iPhonenumber = rs.getString("Phone_no");
                iAddress = rs.getString("Address");
                iGender = rs.getString("Gender");
                iEtype = rs.getString("Employee_type");
                iNID = rs.getInt("NID");
                //iBankId=rs.getString("Bank_id");
                iBalance = rs.getDouble("Salary");
				iJoindate = rs.getString("Join_date");
				//tk=rs.getDouble("Balance");
				flag=true;
				
				Name.setText(iName);
				//FatherName.setText(iFatherName);
				//Gender.setText(iGender);
				DOB.setText(iDOB);
				PhoneInfo.setText(iPhonenumber);
				Address.setText(iAddress);
				Gender.setText(iGender);
				Type.setText(iEtype);
				NID.setText(""+iNID);
				ID.setText(""+loadId);
				Salary.setText(""+iBalance);
				JoinDate.setText(iJoindate);
			}
			if(!flag)
			{
				
			}
		}
        catch(Exception ex)
		{
			System.out.println("Exception : " +ex.getMessage());
        }
        finally
		{
            try
			{
                if(rs!=null)
					rs.close();

                if(st!=null)
					st.close();

                if(con!=null)
					con.close();
            }
            catch(Exception ex){}
        }
	}
	
	
	public void loadFromDB1()
	{
		String loadId = Bank_id;
		String query = "SELECT `Password`FROM `login` WHERE `Bank_id`='"+loadId+"';";     
        Connection con=null;//for connection
        Statement st = null;//for query execution
		ResultSet rs = null;//to get row by row result from DB
		System.out.println(query);
        try
		{
			Class.forName("com.mysql.jdbc.Driver");//load driver
			System.out.println("driver loaded");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bank","root","");
			System.out.println("connection done");//connection with database established
			st = con.createStatement();//create statement
			System.out.println("statement created");
			rs = st.executeQuery(query);//getting result
			System.out.println("results received");
			
			boolean flag = false;
			String iPassword=null;			
			while(rs.next())
			{
                iPassword = rs.getString("Password");
				
				flag=true;
				
				Password.setText(iPassword);
				
			}
			if(!flag)
			{
			}
		}
        catch(Exception ex)
		{
			System.out.println("Exception : " +ex.getMessage());
        }
        finally
		{
            try
			{
                if(rs!=null)
					rs.close();

                if(st!=null)
					st.close();

                if(con!=null)
					con.close();
            }
            catch(Exception ex){}
        }
	}
	
	
}
		