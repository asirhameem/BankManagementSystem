import java.lang.*;
import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class  UpdateEmployee  extends JFrame implements ActionListener
{
	private JPanel panel;
	private JTextField searchField;
	private JButton search,back,update;
	private JLabel logolabel;
	private ImageIcon logo;
	private JLabel EName,EID,CDOB,CPhoneInfo,CAddress,CNID,EJoinDate,CPassword,Etype,ESalary;
	private JTextField Name,ID,DOB,PhoneInfo,Address,NID,JoinDate,Password,Type,Salary;

	private static String Bank_id;
	private double employeeSalary;
	
	public UpdateEmployee (String Bank_id)
	{
		super("Update Employee Information");
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
		
		int labelxAxis=180,labelyAxis=120,labelWidth=200,labelHeight=30;
		
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

		CPhoneInfo=new JLabel("Phone No");
		CPhoneInfo.setBounds(labelxAxis,labelyAxis+120,labelWidth,labelHeight);
		CPhoneInfo.setFont(myFont);
		CPhoneInfo.setForeground(fontColor);
		panel.add(CPhoneInfo);
		
		PhoneInfo=new JTextField("");
		PhoneInfo.setBounds(labelxAxis+250,labelyAxis+120,labelWidth,labelHeight);
		PhoneInfo.setFont(myFont);
		PhoneInfo.setForeground(fontColor);
		panel.add(PhoneInfo);

		CAddress=new JLabel("Address");
		CAddress.setBounds(labelxAxis,labelyAxis+160,labelWidth,labelHeight);
		CAddress.setFont(myFont);
		CAddress.setForeground(fontColor);
		panel.add(CAddress);
		
		Address=new JTextField("");
		Address.setBounds(labelxAxis+250,labelyAxis+160,labelWidth,labelHeight);
		Address.setFont(myFont);
		Address.setForeground(fontColor);
		panel.add(Address);

		CNID=new JLabel("NID");
		CNID.setBounds(labelxAxis,labelyAxis+200,labelWidth,labelHeight);
		CNID.setFont(myFont);
		CNID.setForeground(fontColor);
		panel.add(CNID);
		
		NID=new JTextField("");
		NID.setBounds(labelxAxis+250,labelyAxis+200,labelWidth,labelHeight);
		NID.setFont(myFont);
		NID.setForeground(fontColor);
		panel.add(NID);

		EJoinDate=new JLabel("Join Date");
		EJoinDate.setBounds(labelxAxis,labelyAxis+240,labelWidth,labelHeight);
		EJoinDate.setFont(myFont);
		EJoinDate.setForeground(fontColor);
		panel.add(EJoinDate);
		
		JoinDate=new JTextField("");
		JoinDate.setBounds(labelxAxis+250,labelyAxis+240,labelWidth,labelHeight);
		JoinDate.setFont(myFont);
		JoinDate.setForeground(fontColor);
		panel.add(JoinDate);

		CPassword=new JLabel("Password");
		CPassword.setBounds(labelxAxis,labelyAxis+280,labelWidth,labelHeight);
		CPassword.setFont(myFont);
		CPassword.setForeground(fontColor);
		panel.add(CPassword);
		
		Password=new JTextField("");
		Password.setBounds(labelxAxis+250,labelyAxis+280,labelWidth,labelHeight);
		Password.setFont(myFont);
		Password.setForeground(fontColor);
		panel.add(Password);
		

		update =new JButton("Update");
		update.setBounds(labelxAxis+250,labelyAxis+400,150,30);
		update.setFont(myFont);
		update.setForeground(fontColor);
		update.setBackground(buttonColColor);
		update.addActionListener(this);
		panel.add(update);

        Etype=new JLabel("Employee Type");
		Etype.setBounds(labelxAxis,labelyAxis+320,labelWidth,labelHeight);
		Etype.setFont(myFont);
		Etype.setForeground(fontColor);
		panel.add(Etype);

		Type=new JTextField("");
		Type.setBounds(labelxAxis+250,labelyAxis+320,labelWidth,labelHeight);
		Type.setFont(myFont);
		Type.setForeground(fontColor);
		panel.add(Type);
		
		ESalary=new JLabel("Salary");
		ESalary.setBounds(labelxAxis,labelyAxis+360,labelWidth,labelHeight);
		ESalary.setFont(myFont);
		ESalary.setForeground(fontColor);
		panel.add(ESalary);

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
		
		if(ae.getSource()== back)
		{
			ManageEmployee manageE = new ManageEmployee(Bank_id);
			manageE.setVisible(true);
			this.setVisible(false);
		}
		if(ae.getSource()== update)
		{
			employeeSalary=Double.parseDouble(Salary.getText());
			if(employeeSalary>0)
			{
				updateEmployeeInformationFromDB();
				updateLoginInformationFromDB();
			}
			else
			{
				JOptionPane.showMessageDialog(this,"You are inserting negative value in Salary!!!","Inane warning",JOptionPane.WARNING_MESSAGE);
			}
		}
		if(ae.getSource()== search)
		{
			if(!isNullCheck())
			{
				viewLoginInformationFromDB();
				viewEmployeeInformationFromDB();
			}
			else
			{
				JOptionPane.showMessageDialog(this,"Insert Employee ID","Inane warning",JOptionPane.WARNING_MESSAGE);
			}
		}
	}
	public boolean isNullCheck()
    { 
		if(searchField.getText().equals(""))
		{
			return true;
		}		
		else 
		{
			return false;
		}
	}

	public void viewEmployeeInformationFromDB()
	{
		String loadId = searchField.getText();
		String query = "SELECT `Name`, `Date_of_birth`,`Employee_type`, `Phone_no`, `Address`,`NID`,`Join_date`,`Salary` FROM `employee` WHERE `Bank_id`='"+loadId+"';";     
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
			String iEtype = null;
			String iJoindate=null;
			int iNID = 0;
			double iBalance = 0.0;
			
			while(rs.next())
			{   
		        
                iName = rs.getString("Name");
                iDOB = rs.getString("Date_of_birth");
                iPhonenumber = rs.getString("Phone_no");
                iAddress = rs.getString("Address");
                iEtype = rs.getString("Employee_type");
                iNID = rs.getInt("NID");
                iBalance = rs.getDouble("Salary");
				iJoindate = rs.getString("Join_date");
				
				flag=true;
				
				
				Name.setText(iName);
				DOB.setText(iDOB);
				PhoneInfo.setText(iPhonenumber);
				Address.setText(iAddress);
				Type.setText(iEtype);
				NID.setText(""+iNID);
				ID.setText(""+loadId);
				Salary.setText(""+iBalance);
				JoinDate.setText(iJoindate);
			}
			if(!flag)
			{
				JOptionPane.showMessageDialog(this,"Insert Correct Employee ID","Inane warning",JOptionPane.WARNING_MESSAGE);
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
	
	
	
	public void viewLoginInformationFromDB()
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
	
	public void updateEmployeeInformationFromDB()
	{
		String loadId = searchField.getText();
		
		String iname=null;
		String ibankid=null;
		String idob=null;
		String iphone=null;
		String itype=null;
		String iaddress=null;
		String ijoin=null;
		int inid=0;
		double isalary=0.0;
		
		iname=Name.getText();
		itype=Type.getText();
		ibankid=ID.getText();
		idob=DOB.getText();
		iphone=PhoneInfo.getText();
		iaddress=Address.getText();
		inid=Integer.parseInt( NID.getText());
		isalary=Double.parseDouble(Salary.getText());
		ijoin=JoinDate.getText();
		
		
		
		String query = "UPDATE employee SET Bank_id='"+ibankid+"', Name='"+iname+"',Employee_type='"+itype+"', Date_of_birth='"+idob+"', Phone_no='"+iphone+"', Address='"+iaddress+"', NID='"+inid+"', Salary="+isalary+" WHERE Bank_id='"+loadId+"'";	
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
		}
	}
	
	public void updateLoginInformationFromDB()
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
			DOB.setText("");
			PhoneInfo.setText("");
			Address.setText("");
			NID.setText("");
			ID.setText("");
			Salary.setText("");
			searchField.setText("");
			JoinDate.setText("");
			Type.setText("");		
			Password.setText("");
			
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
	}
}
		