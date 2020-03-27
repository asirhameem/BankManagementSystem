import java.lang.*;
import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class  AdminInfo extends JFrame implements ActionListener
{
	private JPanel panel;
	private JButton info,manageEmployee,logOut;
	private JLabel logolabel;
	private ImageIcon logo;
	
	private JLabel AName,AID,ADOB,AGender,APhoneInfo,AAddress,ANID,AJoinDate,APassword,ASalary;
	private JTextField Name,ID,DOB,Gender,PhoneInfo,Address,NID,JoinDate,Password,Salary;
    private static String Bank_id;
	
	
	public AdminInfo(String Bank_id)
	{
		super("Admin Information");
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
		
		manageEmployee =new JButton("Manage Employee");
		manageEmployee.setBounds(xAxis,yAxis+40,width,height);
		manageEmployee.setFont(myFont);
		manageEmployee.setForeground(fontColor);
		manageEmployee.setBackground(buttonColColor);
		manageEmployee.addActionListener(this);
		panel.add(manageEmployee);
		
		logOut =new JButton("LOGOUT");
		logOut.setBounds(xAxis,yAxis+420,width,height);
		logOut.setFont(myFont);
		logOut.setForeground(fontColor);
		logOut.setBackground(buttonColColor);
		logOut.addActionListener(this);
		panel.add(logOut);

		/*---------------Info main-----------------*/
		
		int labelxAxis=290,labelyAxis=120,labelWidth=200,labelHeight=40;
		
		AName=new JLabel("Name");
		AName.setBounds(labelxAxis,labelyAxis,labelWidth,labelHeight);
		AName.setFont(myFont);
		AName.setForeground(fontColor);
		panel.add(AName);
		
		Name=new JTextField("");
		Name.setBounds(labelxAxis+250,labelyAxis,labelWidth,labelHeight);
		Name.setFont(myFont);
		Name.setForeground(fontColor);
		panel.add(Name);

		AID=new JLabel("ID");
		AID.setBounds(labelxAxis,labelyAxis+40,labelWidth,labelHeight);
		AID.setFont(myFont);
		AID.setForeground(fontColor);
		panel.add(AID);
		
		ID=new JTextField("");
		ID.setBounds(labelxAxis+250,labelyAxis+40,labelWidth,labelHeight);
		ID.setFont(myFont);
		ID.setForeground(fontColor);
		panel.add(ID);

		ADOB=new JLabel("Date Of Birth");
		ADOB.setBounds(labelxAxis,labelyAxis+80,labelWidth,labelHeight);
		ADOB.setFont(myFont);
		ADOB.setForeground(fontColor);
		panel.add(ADOB);
		
		DOB=new JTextField("");
		DOB.setBounds(labelxAxis+250,labelyAxis+80,labelWidth,labelHeight);
		DOB.setFont(myFont);
		DOB.setForeground(fontColor);
		panel.add(DOB);
		
		AGender=new JLabel("Gender");
		AGender.setBounds(labelxAxis,labelyAxis+120,labelWidth,labelHeight);
		AGender.setFont(myFont);
		AGender.setForeground(fontColor);
		panel.add(AGender);
		
		Gender=new JTextField("");
		Gender.setBounds(labelxAxis+250,labelyAxis+120,labelWidth,labelHeight);
		Gender.setFont(myFont);
		Gender.setForeground(fontColor);
		panel.add(Gender);

		APhoneInfo=new JLabel("Phone No");
		APhoneInfo.setBounds(labelxAxis,labelyAxis+160,labelWidth,labelHeight);
		APhoneInfo.setFont(myFont);
		APhoneInfo.setForeground(fontColor);
		panel.add(APhoneInfo);
		
		PhoneInfo=new JTextField("");
		PhoneInfo.setBounds(labelxAxis+250,labelyAxis+160,labelWidth,labelHeight);
		PhoneInfo.setFont(myFont);
		PhoneInfo.setForeground(fontColor);
		panel.add(PhoneInfo);

		AAddress=new JLabel("Address");
		AAddress.setBounds(labelxAxis,labelyAxis+200,labelWidth,labelHeight);
		AAddress.setFont(myFont);
		AAddress.setForeground(fontColor);
		panel.add(AAddress);
		
		Address=new JTextField("");
		Address.setBounds(labelxAxis+250,labelyAxis+200,labelWidth,labelHeight);
		Address.setFont(myFont);
		Address.setForeground(fontColor);
		panel.add(Address);

		ANID=new JLabel("NID");
		ANID.setBounds(labelxAxis,labelyAxis+240,labelWidth,labelHeight);
		ANID.setFont(myFont);
		ANID.setForeground(fontColor);
		panel.add(ANID);
		
		NID=new JTextField("");
		NID.setBounds(labelxAxis+250,labelyAxis+240,labelWidth,labelHeight);
		NID.setFont(myFont);
		NID.setForeground(fontColor);
		panel.add(NID);

		AJoinDate=new JLabel("Join Date");
		AJoinDate.setBounds(labelxAxis,labelyAxis+280,labelWidth,labelHeight);
		AJoinDate.setFont(myFont);
		AJoinDate.setForeground(fontColor);
		panel.add(AJoinDate);
		
		JoinDate=new JTextField("");
		JoinDate.setBounds(labelxAxis+250,labelyAxis+280,labelWidth,labelHeight);
		JoinDate.setFont(myFont);
		JoinDate.setForeground(fontColor);
		panel.add(JoinDate);

		APassword=new JLabel("Password");
		APassword.setBounds(labelxAxis,labelyAxis+320,labelWidth,labelHeight);
		APassword.setFont(myFont);
		APassword.setForeground(fontColor);
		panel.add(APassword);
		
		Password=new JTextField("");
		Password.setBounds(labelxAxis+250,labelyAxis+320,labelWidth,labelHeight);
		Password.setFont(myFont);
		Password.setForeground(fontColor);
		panel.add(Password);

		ASalary=new JLabel("Salary");
		ASalary.setBounds(labelxAxis,labelyAxis+360,labelWidth,labelHeight);
		ASalary.setFont(myFont);
		ASalary.setForeground(fontColor);
		panel.add(ASalary);

		Salary=new JTextField("");
		Salary.setBounds(labelxAxis+250,labelyAxis+360,labelWidth,labelHeight);
		Salary.setFont(myFont);
		Salary.setForeground(fontColor);
		panel.add(Salary);		
		
		this.add(panel);	
	}
	
	public void actionPerformed(ActionEvent ae)
	{
		String text = ae.getActionCommand();
		
		if(ae.getSource()== manageEmployee)
		{
			ManageEmployee manageE = new ManageEmployee(Bank_id);
			manageE.setVisible(true);
			this.setVisible(false);
		}
		if(ae.getSource()== logOut)
		{
			Login login = new Login();
			login.setVisible(true);
			this.setVisible(false);
			
		}
		if(ae.getSource()== info)
		{
			loadFromDB();
            loadFromDB1();
		}
	}
	
	
	public void loadFromDB()
	{
		String loadId = Bank_id;
		String query = "SELECT `Name`, `DOB`,`Phone_no`,`Gender`, `Address`,`NID`,`Join_date`,`Salary` FROM `admin` WHERE `Bank_id`='"+loadId+"';";     
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
			//String iEtype = null;
			int iNID = 0;
			String iJoindate=null;
			double iBalance = 0.0;
			while(rs.next())
			{   
		        
                iName = rs.getString("Name");
                iDOB = rs.getString("DOB");
                iPhonenumber = rs.getString("Phone_no");
                iAddress = rs.getString("Address");
                iGender = rs.getString("Gender");
                iNID = rs.getInt("NID");
                iBalance = rs.getDouble("Salary");
				iJoindate = rs.getString("Join_date");
				flag=true;
				
				Name.setText(iName);
				Gender.setText(iGender);
				DOB.setText(iDOB);
				PhoneInfo.setText(iPhonenumber);
				Address.setText(iAddress);
				Gender.setText(iGender);
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
		