import java.lang.*;
import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class  UpdateCustomer  extends JFrame implements ActionListener
{
	private JPanel panel;
	private JTextField searchField;
	private JButton search,back,update;
	private JLabel logolabel;
	private ImageIcon logo;
	private JLabel CName,CFatherName,CGender,CDOB,CPhoneInfo,CAddress,CNID,CBankId,CPassword,CBalance;
	private JTextField Name,FatherName,Gender,DOB,PhoneInfo,Address,NID,BankId,Password,Balance;
	private double userBalance;

	String Bank_id;
	
	public UpdateCustomer (String Bank_id)
	{
		super("Update Customer Information");
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
		searchField=new JTextField();
		searchField.setBounds(10,120,150,30);
		searchField.setFont(myFont);
		searchField.addActionListener(this);
		panel.add(searchField);
		
		search =new JButton("Search");
		search.setBounds(10,160,150,30);
		search.setFont(myFont);
		search.setForeground(fontColor);
		search.setBackground(buttonColColor);
		search.addActionListener(this);
		panel.add(search);
		
		back =new JButton("back");
		back.setBounds(0,530,100,30);
		back.setFont(myFont);
		back.setForeground(fontColor);
		back.setBackground(buttonColColor);
		back.addActionListener(this);
		panel.add(back);

		/*---------------Info main-----------------*/
		
		int labelxAxis=200,labelyAxis=120,labelWidth=200,labelHeight=30;
		
		CName=new JLabel("Name");
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
		
		NID=new JTextField("");
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

		update =new JButton("Update");
		update.setBounds(labelxAxis+250,labelyAxis+400,150,30);
		update.setFont(myFont);
		update.setForeground(fontColor);
		update.setBackground(buttonColColor);
		update.addActionListener(this);
		panel.add(update);		
		
		this.add(panel);	
	}
	
	public void actionPerformed(ActionEvent ae)
	{
		String text = ae.getActionCommand();
		
		if(ae.getSource()== back)
		{
			ManageCustomer manageC = new ManageCustomer(Bank_id);
			manageC.setVisible(true);
			this.setVisible(false);
		}
		
		if(ae.getSource()== search)
		{
			 if (searchField.getText().length()==0){
					JOptionPane.showMessageDialog(this, "!!Missing Bank ID !!");
				}
			else
			{
			loadFromDB();
			}
			loadFromDB1();
		}
		
		if(ae.getSource()== update)
		{
			userBalance=Double.parseDouble(Balance.getText());
			if(userBalance>0)
			{	 
				updateInDB();
				updateInDB1();
			}
			else{
				JOptionPane.showMessageDialog(this,"You are inserting negative value in Balance!!!","Inane warning",JOptionPane.WARNING_MESSAGE);
			}
	     }
	}
	
	
	public void updateInDB()
	{
		String loadId = searchField.getText();
		
		String iname=null;
		String ifathername=null;
		String igender=null;
		String ibankid=null;
		String idob=null;
		String iphone=null;
		String iaddress=null;
		int inid=0;
		double ibalance=0.0;
		
		iname=Name.getText();
		ifathername=FatherName.getText();
		igender=Gender.getText();
		ibankid=BankId.getText();
		idob=DOB.getText();
		iphone=PhoneInfo.getText();
		iaddress=Address.getText();
		inid=Integer.parseInt( NID.getText());
		ibalance=Double.parseDouble(Balance.getText());
		
		
		
		String query = "UPDATE customer SET Bank_id='"+ibankid+"', Name='"+iname+"', Father_name='"+ifathername+"', Gender='"+igender+"', Date_of_birth='"+idob+"', Phone_number='"+iphone+"', Address='"+iaddress+"', NID='"+inid+"', Balance="+ibalance+" WHERE Bank_id='"+loadId+"'";	
        Connection con=null;//for connection
        Statement st = null;//for query execution
		System.out.println(query);
        try
		{
			Class.forName("com.mysql.jdbc.Driver");//load driver
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bank","root","");
			st = con.createStatement();//create statement
			st.executeUpdate(query);
			st.close();
			con.close();
			JOptionPane.showMessageDialog(this, "Success !!!");
			    
			
			
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
			JOptionPane.showMessageDialog(this, "opps !!!");
		}
	}
	
	public void loadFromDB()
	{
		String loadId = searchField.getText();
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
                iBalance = rs.getDouble("Balance");
				
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
			JOptionPane.showMessageDialog(this, "Enter Valid BankID");	
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
		String loadId = searchField.getText();;
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
	public void updateInDB1()
	{
		String loadId = searchField.getText();
		String ipass = Password.getText();
		String query = "UPDATE login SET Password='"+ipass+"' WHERE Bank_id='"+loadId+"'";	
        Connection con=null;//for connection
        Statement st = null;//for query execution
		System.out.println(query);
        try
		{
			Class.forName("com.mysql.jdbc.Driver");//load driver
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bank","root","");
			st = con.createStatement();//create statement
			st.executeUpdate(query);
			st.close();
			con.close();

                Name.setText("");
				FatherName.setText("");
				Gender.setText("");
				DOB.setText("");
				PhoneInfo.setText("");
				Address.setText("");
				NID.setText("");
				BankId.setText("");
				Balance.setText("");
				searchField.setText("");
				Password.setText("");			
			
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
			JOptionPane.showMessageDialog(this, "Oops !!!");
		}
	}
	
}
		