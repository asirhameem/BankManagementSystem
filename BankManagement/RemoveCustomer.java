import java.lang.*;
import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class  RemoveCustomer extends JFrame implements ActionListener
{
	private JPanel panel;
	private JLabel logolabel;
	private ImageIcon logo;
	private JButton search,back,remove;
	private JTextField searchField;
	private JLabel CName,CFatherName,CGender,CDOB,CPhoneInfo,CAddress,CNID,CBankId,CPassword,CBalance;
	private JTextField Name,FatherName,Gender,DOB,PhoneInfo,Address,NID,BankId,Balance;
    private static String Bank_id;
	
	
	public RemoveCustomer(String Bank_id)
	{
		super("Add New Customer");
		this.setSize(800,700);
		this.Bank_id=Bank_id;
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Font myFont= new Font("Consolas",Font.PLAIN, 25);
		Color fontColor = new Color (41,41,41);
		Color panelColor = new Color (225,225,225);
		Color buttonColColor = new Color (74,96,132);
	
		panel= new JPanel ();
		panel.setLayout(null);
		panel.setBackground(panelColor);
	
		logo = new ImageIcon("logo.jpg");
		logolabel = new JLabel(logo);
		logolabel.setBounds(0,-25,800,150);
		panel.add(logolabel);

		/*---------------Info main-----------------*/
		searchField=new JTextField();
		searchField.setBounds(140,120,200,30);
		searchField.setFont(myFont);
		searchField.addActionListener(this);
		panel.add(searchField);
		
		search =new JButton("Search");
		search.setBounds(350,120,120,30);
		search.setFont(myFont);
		search.setForeground(fontColor);
		search.setBackground(buttonColColor);
		search.addActionListener(this);
		panel.add(search);
		
		int xAxis=140,yAxis=160,width=200,height=30;
		
		CName=new JLabel("Name");
		CName.setBounds(xAxis,yAxis,width,height);
		CName.setFont(myFont);
		CName.setForeground(fontColor);
		panel.add(CName);
		
		Name=new JTextField("");
		Name.setBounds(xAxis+250,yAxis,width,height);
		Name.setFont(myFont);
		Name.setForeground(fontColor);
		panel.add(Name);

		CFatherName=new JLabel("Fathers Name");
		CFatherName.setBounds(xAxis,yAxis+40,width,height);
		CFatherName.setFont(myFont);
		CFatherName.setForeground(fontColor);
		panel.add(CFatherName);
		
		FatherName=new JTextField("");
		FatherName.setBounds(xAxis+250,yAxis+40,width,height);
		FatherName.setFont(myFont);
		FatherName.setForeground(fontColor);
		panel.add(FatherName);

		CGender=new JLabel("Gender");
		CGender.setBounds(xAxis,yAxis+80,width,height);
		CGender.setFont(myFont);
		CGender.setForeground(fontColor);
		panel.add(CGender);
		
		Gender=new JTextField("");
		Gender.setBounds(xAxis+250,yAxis+80,width,height);
		Gender.setFont(myFont);
		Gender.setForeground(fontColor);
		panel.add(Gender);

		CDOB=new JLabel("Date Of Birth");
		CDOB.setBounds(xAxis,yAxis+120,width,height);
		CDOB.setFont(myFont);
		CDOB.setForeground(fontColor);
		panel.add(CDOB);
		
		DOB=new JTextField("");
		DOB.setBounds(xAxis+250,yAxis+120,width,height);
		DOB.setFont(myFont);
		DOB.setForeground(fontColor);
		panel.add(DOB);

		CPhoneInfo=new JLabel("Phone No");
		CPhoneInfo.setBounds(xAxis,yAxis+160,width,height);
		CPhoneInfo.setFont(myFont);
		CPhoneInfo.setForeground(fontColor);
		panel.add(CPhoneInfo);
		
		PhoneInfo=new JTextField("");
		PhoneInfo.setBounds(xAxis+250,yAxis+160,width,height);
		PhoneInfo.setFont(myFont);
		PhoneInfo.setForeground(fontColor);
		panel.add(PhoneInfo);

		CAddress=new JLabel("Address");
		CAddress.setBounds(xAxis,yAxis+200,width,height);
		CAddress.setFont(myFont);
		CAddress.setForeground(fontColor);
		panel.add(CAddress);
		
		Address=new JTextField("");
		Address.setBounds(xAxis+250,yAxis+200,width,height);
		Address.setFont(myFont);
		Address.setForeground(fontColor);
		panel.add(Address);

		CNID=new JLabel("NID");
		CNID.setBounds(xAxis,yAxis+240,width,height);
		CNID.setFont(myFont);
		CNID.setForeground(fontColor);
		panel.add(CNID);
		
		NID=new JTextField("");
		NID.setBounds(xAxis+250,yAxis+240,width,height);
		NID.setFont(myFont);
		NID.setForeground(fontColor);
		panel.add(NID);

		CBankId=new JLabel("Bank ID");
		CBankId.setBounds(xAxis,yAxis+280,width,height);
		CBankId.setFont(myFont);
		CBankId.setForeground(fontColor);
		panel.add(CBankId);
		
		BankId=new JTextField("");
		BankId.setBounds(xAxis+250,yAxis+280,width,height);
		BankId.setFont(myFont);
		BankId.setForeground(fontColor);
		panel.add(BankId);

		CBalance=new JLabel("Balance");
		CBalance.setBounds(xAxis,yAxis+320,width,height);
		CBalance.setFont(myFont);
		CBalance.setForeground(fontColor);
		panel.add(CBalance);

		Balance=new JTextField("");
		Balance.setBounds(xAxis+250,yAxis+320,width,height);
		Balance.setFont(myFont);
		Balance.setForeground(fontColor);
		panel.add(Balance);	
		
		remove =new JButton("Remove");
		remove.setBounds(xAxis+250,yAxis+400,width-50,height);
		remove.setFont(myFont);
		remove.setForeground(fontColor);
		remove.setBackground(buttonColColor);
		remove.addActionListener(this);
		panel.add(remove);	

		back =new JButton("Back");
		back.setBounds(10,yAxis+460,width-50,height);
		back.setFont(myFont);
		back.setForeground(fontColor);
		back.setBackground(buttonColColor);
		back.addActionListener(this);
		panel.add(back);		
		
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
			loadFromDB();
		}
		if(ae.getSource()== remove)
		{
			deleteFromDB();
		}
		
	}
	
	public void loadFromDB()
	{
		if  (searchField.getText().length()==0)
		{
			JOptionPane.showMessageDialog(this, "!!Please Enter Bank ID!!");
		}
		else
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
			JOptionPane.showMessageDialog(this, "Success !!!");
			
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
				//tk=rs.getDouble("Balance");
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
            catch(Exception ex){
				JOptionPane.showMessageDialog(this, "Oops !!!");
			}
        }
		}
	}
	
	
	public void deleteFromDB()
	{
		if  (searchField.getText().length()==0)
		{
			JOptionPane.showMessageDialog(this, "!!Please Enter Bank ID!!");
		}
	else
	{		
		String newId = searchField.getText();
		String query1 = "DELETE from customer WHERE Bank_id='"+newId+"';";
		String query2 = "DELETE from login WHERE Bank_id='"+newId+"';";
		System.out.println(query1);
		System.out.println(query2);
        try
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bank", "root", "");
			Statement stm = con.createStatement();
			stm.execute(query1);
			stm.execute(query2);
			stm.close();
			con.close();
			JOptionPane.showMessageDialog(this, "Success !!!");
			
			
			Name.setText("");
			FatherName.setText("");
			Gender.setText("");
			DOB.setText("");
			PhoneInfo.setText("");
			Address.setText("");
			NID.setText("");
			BankId.setText("");
			Balance.setText("");
		}
        catch(Exception ex)
		{
			JOptionPane.showMessageDialog(this, "Oops !!!");
        }
	 } 
	}

}	