import java.lang.*;
import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class  RemoveEmployee extends JFrame implements ActionListener
{
	private JPanel panel;
	private JLabel logolabel;
	private ImageIcon logo;
	private JButton search,back,remove;
	private JTextField searchField;
	private JLabel EName,EGender,EDOB,EJoinDate,EPhoneInfo,EAddress,ENID,EBankId,EType,ESalary;
	private JTextField Name,Gender,DOB,JoinDate,PhoneInfo,Address,NID,BankId,Type,Salary;
    private static String Bank_id;
	
	
	public RemoveEmployee(String Bank_id)
	{
		super("Remove Employee");
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
		
		EName=new JLabel("Name");
		EName.setBounds(xAxis,yAxis,width,height);
		EName.setFont(myFont);
		EName.setForeground(fontColor);
		panel.add(EName);
		
		Name=new JTextField("");
		Name.setBounds(xAxis+250,yAxis,width,height);
		Name.setFont(myFont);
		Name.setForeground(fontColor);
		panel.add(Name);

		EGender=new JLabel("Gender");
		EGender.setBounds(xAxis,yAxis+40,width,height);
		EGender.setFont(myFont);
		EGender.setForeground(fontColor);
		panel.add(EGender);
		
		Gender=new JTextField("");
		Gender.setBounds(xAxis+250,yAxis+40,width,height);
		Gender.setFont(myFont);
		Gender.setForeground(fontColor);
		panel.add(Gender); 
		
		
		EDOB=new JLabel("Date Of Birth");
		EDOB.setBounds(xAxis,yAxis+80,width,height);
		EDOB.setFont(myFont);
		EDOB.setForeground(fontColor);
		panel.add(EDOB);
		
		DOB=new JTextField("");
		DOB.setBounds(xAxis+250,yAxis+80,width,height);
		DOB.setFont(myFont);
		DOB.setForeground(fontColor);
		panel.add(DOB);
		
		EJoinDate=new JLabel("Join Date");
		EJoinDate.setBounds(xAxis,yAxis+120,width,height);
		EJoinDate.setFont(myFont);
		EJoinDate.setForeground(fontColor);
		panel.add(EJoinDate);
		
		JoinDate=new JTextField("");
		JoinDate.setBounds(xAxis+250,yAxis+120,width,height);
		JoinDate.setFont(myFont);
		JoinDate.setForeground(fontColor);
		panel.add(JoinDate);

		EPhoneInfo=new JLabel("Phone No");
		EPhoneInfo.setBounds(xAxis,yAxis+160,width,height);
		EPhoneInfo.setFont(myFont);
		EPhoneInfo.setForeground(fontColor);
		panel.add(EPhoneInfo);
		
		PhoneInfo=new JTextField("");
		PhoneInfo.setBounds(xAxis+250,yAxis+160,width,height);
		PhoneInfo.setFont(myFont);
		PhoneInfo.setForeground(fontColor);
		panel.add(PhoneInfo);

		EAddress=new JLabel("Address");
		EAddress.setBounds(xAxis,yAxis+200,width,height);
		EAddress.setFont(myFont);
		EAddress.setForeground(fontColor);
		panel.add(EAddress);
		
		Address=new JTextField("");
		Address.setBounds(xAxis+250,yAxis+200,width,height);
		Address.setFont(myFont);
		Address.setForeground(fontColor);
		panel.add(Address);

		ENID=new JLabel("NID");
		ENID.setBounds(xAxis,yAxis+240,width,height);
		ENID.setFont(myFont);
		ENID.setForeground(fontColor);
		panel.add(ENID);
		
		NID=new JTextField("");
		NID.setBounds(xAxis+250,yAxis+240,width,height);
		NID.setFont(myFont);
		NID.setForeground(fontColor);
		panel.add(NID);

		EBankId=new JLabel("Bank ID");
		EBankId.setBounds(xAxis,yAxis+280,width,height);
		EBankId.setFont(myFont);
		EBankId.setForeground(fontColor);
		panel.add(EBankId);
		
		BankId=new JTextField("");
		BankId.setBounds(xAxis+250,yAxis+280,width,height);
		BankId.setFont(myFont);
		BankId.setForeground(fontColor);
		panel.add(BankId);

		EType=new JLabel("Employee Type");
		EType.setBounds(xAxis,yAxis+320,width,height);
		EType.setFont(myFont);
		EType.setForeground(fontColor);
		panel.add(EType);

		Type=new JTextField("");
		Type.setBounds(xAxis+250,yAxis+320,width,height);
		Type.setFont(myFont);
		Type.setForeground(fontColor);
		panel.add(Type);
		
		ESalary=new JLabel("Salary");
		ESalary.setBounds(xAxis,yAxis+360,width,height);
		ESalary.setFont(myFont);
		ESalary.setForeground(fontColor);
		panel.add(ESalary);

		Salary=new JTextField("");
		Salary.setBounds(xAxis+250,yAxis+360,width,height);
		Salary.setFont(myFont);
		Salary.setForeground(fontColor);
		panel.add(Salary);		
		
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
			ManageEmployee manageE = new ManageEmployee(Bank_id);
			manageE.setVisible(true);
			this.setVisible(false);
		}
		if(ae.getSource()== search)
		{
			if(!isNullCheck())
			{
				viewEmployeeFromDB();
			}
			else
			{
				JOptionPane.showMessageDialog(this,"Insert Employee ID","Inane warning",JOptionPane.WARNING_MESSAGE);
			}
		}
		if(ae.getSource()== remove)
		{
			if(!isNullCheck())
			{
				updateEmployeeToDB();
			}
			else
			{
				JOptionPane.showMessageDialog(this,"Insert Employee ID in Search Box","Inane warning",JOptionPane.WARNING_MESSAGE);
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
	
	public void viewEmployeeFromDB()
	{
		String loadId = searchField.getText();
		String query = "SELECT `Name`, `Date_of_birth`, `Gender`, `Employee_type`,`Phone_no`,`Address`,`NID`,`Join_date`,`Salary` FROM `employee` WHERE `Bank_id`='"+loadId+"';";     
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
			String iGender = null;
			String iEtype = null;
			String iPhonenumber = null;
			String iAddress = null;
			int iNID = 0;
			String ijoin = null;
			double iSalary= 0.0;
						
			while(rs.next())
			{   
		        
                iName = rs.getString("Name");
				iDOB = rs.getString("Date_of_birth");
				iGender = rs.getString("Gender");
                iEtype = rs.getString("Employee_type");
                iPhonenumber = rs.getString("Phone_no");
                iAddress = rs.getString("Address");
                iNID = rs.getInt("NID");
                ijoin = rs.getString("Join_date");
                iSalary = rs.getDouble("Salary");
               
				
				flag=true;
				
				Name.setText(iName);
				Gender.setText(iGender);
				DOB.setText(iDOB);
				Type.setText(iEtype);
				PhoneInfo.setText(iPhonenumber);
				Address.setText(iAddress);
				NID.setText(""+iNID);
				JoinDate.setText(ijoin);
				Salary.setText(""+iSalary);
				BankId.setText(""+loadId);

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
			catch(Exception e)
			{
				System.out.println(e.getMessage());
			}
        }
	}
	
	
	public void updateEmployeeToDB()
	{
		String newId = searchField.getText();
		String query1 = "DELETE from employee WHERE Bank_id='"+newId+"';";
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
				Gender.setText("");
				DOB.setText("");
				Type.setText("");
				PhoneInfo.setText("");
				Address.setText("");
				NID.setText("");
				JoinDate.setText("");
				Salary.setText("");
				BankId.setText("");
				searchField.setText("");
			
		}
        catch(Exception ex)
		{
			JOptionPane.showMessageDialog(this, "Oops !!!");
        }
	}
	
}	