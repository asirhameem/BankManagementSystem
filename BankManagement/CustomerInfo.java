import java.lang.*;
import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class  CustomerInfo extends JFrame implements ActionListener
{
	private JPanel panel;
	private JTextField userfield;
	private JPasswordField passfield;
	private JButton info,bill,logOut;
	private JLabel logolabel;
	private ImageIcon logo;
	
	private JLabel CName,CFatherName,CGender,CDOB,CPhoneInfo,CAddress,CNID,CBankId,CPassword,CBalance;
	private JTextField Name,FatherName,Gender,DOB,PhoneInfo,Address,NID,BankId,Password,Balance;
    private static String Bank_id;
    private static double tk=0;
	
	
	public CustomerInfo(String Bank_id)
	{
		super("Your Information");
		this.Bank_id=Bank_id;
		this.setSize(800,600);
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
		int xAxis=0,yAxis=100,width=150,height=40;
		
		info =new JButton("INFO");
		info.setBounds(xAxis,yAxis,width,height);
		info.setFont(myFont);
		info.setForeground(fontColor);
		info.setBackground(activeButtonColColor);
		info.addActionListener(this);
		panel.add(info);
		
		bill =new JButton("PAY BILL");
		bill.setBounds(xAxis,yAxis+80,width,height);
		bill.setFont(myFont);
		bill.setForeground(fontColor);
		bill.setBackground(buttonColColor);
		bill.addActionListener(this);
		panel.add(bill);
		
		logOut =new JButton("LOGOUT");
		logOut.setBounds(xAxis,yAxis+420,width,height);
		logOut.setFont(myFont);
		logOut.setForeground(fontColor);
		logOut.setBackground(buttonColColor);
		logOut.addActionListener(this);
		panel.add(logOut);

		/*---------------Info main-----------------*/
		
		int labelxAxis=200,labelyAxis=120,labelWidth=200,labelHeight=40;
		
		CName=new JLabel("Name :");
		CName.setBounds(labelxAxis,labelyAxis,labelWidth,labelHeight);
		CName.setFont(myFont);
		CName.setForeground(fontColor);
		panel.add(CName);
		
		Name=new JTextField("");
		Name.setBounds(labelxAxis+250,labelyAxis,labelWidth,labelHeight);
		Name.setFont(myFont);
		Name.setForeground(fontColor);
		panel.add(Name);

		CFatherName=new JLabel("Fathers Name");
		CFatherName.setBounds(labelxAxis,labelyAxis+40,labelWidth,labelHeight);
		CFatherName.setFont(myFont);
		CFatherName.setForeground(fontColor);
		panel.add(CFatherName);
		
		FatherName=new JTextField("");
		FatherName.setBounds(labelxAxis+250,labelyAxis+40,labelWidth,labelHeight);
		FatherName.setFont(myFont);
		FatherName.setForeground(fontColor);
		panel.add(FatherName);

		CGender=new JLabel("Gender");
		CGender.setBounds(labelxAxis,labelyAxis+80,labelWidth,labelHeight);
		CGender.setFont(myFont);
		CGender.setForeground(fontColor);
		panel.add(CGender);
		
		Gender=new JTextField("");
		Gender.setBounds(labelxAxis+250,labelyAxis+80,labelWidth,labelHeight);
		Gender.setFont(myFont);
		Gender.setForeground(fontColor);
		panel.add(Gender);

		CDOB=new JLabel("Date Of Birth");
		CDOB.setBounds(labelxAxis,labelyAxis+120,labelWidth,labelHeight);
		CDOB.setFont(myFont);
		CDOB.setForeground(fontColor);
		panel.add(CDOB);
		
		DOB=new JTextField("");
		DOB.setBounds(labelxAxis+250,labelyAxis+120,labelWidth,labelHeight);
		DOB.setFont(myFont);
		DOB.setForeground(fontColor);
		panel.add(DOB);

		CPhoneInfo=new JLabel("Phone No");
		CPhoneInfo.setBounds(labelxAxis,labelyAxis+160,labelWidth,labelHeight);
		CPhoneInfo.setFont(myFont);
		CPhoneInfo.setForeground(fontColor);
		panel.add(CPhoneInfo);
		
		PhoneInfo=new JTextField("");
		PhoneInfo.setBounds(labelxAxis+250,labelyAxis+160,labelWidth,labelHeight);
		PhoneInfo.setFont(myFont);
		PhoneInfo.setForeground(fontColor);
		panel.add(PhoneInfo);

		CAddress=new JLabel("Address");
		CAddress.setBounds(labelxAxis,labelyAxis+200,labelWidth,labelHeight);
		CAddress.setFont(myFont);
		CAddress.setForeground(fontColor);
		panel.add(CAddress);
		
		Address=new JTextField("");
		Address.setBounds(labelxAxis+250,labelyAxis+200,labelWidth,labelHeight);
		Address.setFont(myFont);
		Address.setForeground(fontColor);
		panel.add(Address);

		CNID=new JLabel("NID");
		CNID.setBounds(labelxAxis,labelyAxis+240,labelWidth,labelHeight);
		CNID.setFont(myFont);
		CNID.setForeground(fontColor);
		panel.add(CNID);
		
		NID=new JTextField();
		NID.setBounds(labelxAxis+250,labelyAxis+240,labelWidth,labelHeight);
		NID.setFont(myFont);
		NID.setForeground(fontColor);
		panel.add(NID);

		CBankId=new JLabel("Bank ID");
		CBankId.setBounds(labelxAxis,labelyAxis+280,labelWidth,labelHeight);
		CBankId.setFont(myFont);
		CBankId.setForeground(fontColor);
		panel.add(CBankId);
		
		BankId=new JTextField("");
		BankId.setBounds(labelxAxis+250,labelyAxis+280,labelWidth,labelHeight);
		BankId.setFont(myFont);
		BankId.setForeground(fontColor);
		panel.add(BankId);

		CPassword=new JLabel("Password");
		CPassword.setBounds(labelxAxis,labelyAxis+320,labelWidth,labelHeight);
		CPassword.setFont(myFont);
		CPassword.setForeground(fontColor);
		panel.add(CPassword);
		
		Password=new JTextField("");
		Password.setBounds(labelxAxis+250,labelyAxis+320,labelWidth,labelHeight);
		Password.setFont(myFont);
		Password.setForeground(fontColor);
		panel.add(Password);

		CBalance=new JLabel("Balance");
		CBalance.setBounds(labelxAxis,labelyAxis+360,labelWidth,labelHeight);
		CBalance.setFont(myFont);
		CBalance.setForeground(fontColor);
		panel.add(CBalance);

		Balance=new JTextField("");
		Balance.setBounds(labelxAxis+250,labelyAxis+360,labelWidth,labelHeight);
		Balance.setFont(myFont);
		Balance.setForeground(fontColor);
		panel.add(Balance);		
		
		this.add(panel);	
	}
	
	public void actionPerformed(ActionEvent ae)
	{
		String text = ae.getActionCommand();
		
		if(ae.getSource()== info)
		{
            fetchFromCustomer();
			System.out.println("Information about Customer");
            fetchFromLogin();		
			
		}
		if(ae.getSource()== bill)
		{
			CustomerBill cbill = new CustomerBill(Bank_id);
			cbill.setVisible(true);
			this.setVisible(false);
		}
		if(ae.getSource()== logOut)
		{
			Login login = new Login();
			login.setVisible(true);
			this.setVisible(false);
			
		}
	}
	
	public void fetchFromCustomer()
	{
		String loadId = Bank_id;
		String query = "SELECT `Name`, `Father_name`, `Gender`, `Date_of_birth`,`Phone_number`,`Address`,`NID`,`Balance` FROM `customer` WHERE `Bank_id`='"+loadId+"';";     
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
			String iFatherName = null;
			String iGender = null;
			String iDOB = null;
			String iPhonenumber = null;
			String iAddress = null;
			int iNID = 0;
			//String iBankId = null;
			double iBalance = 0.0;			
			while(rs.next())
			{   
                iName = rs.getString("Name");
                iFatherName = rs.getString("Father_name");
                iGender = rs.getString("Gender");
                iDOB = rs.getString("Date_of_birth");
                iPhonenumber = rs.getString("Phone_number");
                iAddress = rs.getString("Address");
                iNID = rs.getInt("NID");
                //iBankId=rs.getString("Bank_id");
                iBalance = rs.getDouble("Balance");
				tk=rs.getDouble("Balance");
				flag=true;
				
				Name.setText(iName);
				FatherName.setText(iFatherName);
				Gender.setText(iGender);
				DOB.setText(iDOB);
				PhoneInfo.setText(iPhonenumber);
				Address.setText(iAddress);
				NID.setText(""+iNID);
				BankId.setText(""+loadId);
				Balance.setText(""+iBalance);
			}
			if(!flag)
			{
				JOptionPane.showMessageDialog(this,"Something is Wrong!!!","Inane warning",JOptionPane.WARNING_MESSAGE);
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
	
	public void fetchFromLogin()
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
		