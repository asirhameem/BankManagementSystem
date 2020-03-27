import java.lang.*;
import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class  AddEmployee extends JFrame implements ActionListener
{
	private JPanel panel;
	private JPasswordField Password;
	private JLabel logolabel;
	private ImageIcon logo;
	private JButton back,add;
	
	private JRadioButton female;
	private ButtonGroup Gender;
	private JComboBox day,month,year,day1,month1,year1;
	private JLabel EName,EGender,EDOB,EJoinDate,EPhoneInfo,EAddress,ENID,EBankId,EPassword,EType,ESalary;
	private JTextField Name,DOB,JoinDate,PhoneInfo,Address,NID,BankId,Type,Salary,male;
	private static String Bank_id;
	private double employeeSalary;

	
	
	public AddEmployee(String Bank_id)
	{
		super("Add New Employee");
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
		
		int xAxis=140,yAxis=120,width=200,height=30;
		
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
		
		male=new JTextField("");
		male.setFont(myFont);
		male.setBounds(xAxis+250,yAxis+40,120,height);
		male.setForeground(fontColor);
		panel.add(male);
	
		EDOB=new JLabel("Date Of Birth");
		EDOB.setBounds(xAxis,yAxis+80,width,height);
		EDOB.setFont(myFont);
		EDOB.setForeground(fontColor);
		panel.add(EDOB);
		
		String day_arr[]=new String[31];
		for(int i=1;i<=31;i++)
		day_arr[i-1]=Integer.toString(i); 
		day=new JComboBox(day_arr);
		day.setBounds(xAxis+250,yAxis+80,60,30);
		panel.add(day);
		
		String month_arr[]={"Jan","Feb","March","April","May","June","July","Aug","Sept","Oct","Nov","Dec" }; 
		month=new JComboBox(month_arr);
		month.setBounds(xAxis+320,yAxis+80,60,30);
		panel.add(month);
 
		String year_arr[]=new String[52];
		for(int i=1951;i<=2002;i++)
		year_arr[i-1951]=Integer.toString(i);
		year=new JComboBox(year_arr);
		year.setBounds(xAxis+390,yAxis+80,60,30);
		panel.add(year);
		
		EJoinDate=new JLabel("Join Date");
		EJoinDate.setBounds(xAxis,yAxis+120,width,height);
		EJoinDate.setFont(myFont);
		EJoinDate.setForeground(fontColor);
		panel.add(EJoinDate);
		
		String day_arr1[]=new String[31];
		for(int i=1;i<=31;i++)
		day_arr1[i-1]=Integer.toString(i); 
		day1=new JComboBox(day_arr);
		day1.setBounds(xAxis+250,yAxis+120,60,30);
		panel.add(day1);
		
		String month_arr1[]={"Jan","Feb","March","April","May","June","July","Aug","Sept","Oct","Nov","Dec" }; 
		month1=new JComboBox(month_arr1);
		month1.setBounds(xAxis+320,yAxis+120,60,30);
		panel.add(month1);
 
		String year_arr1[]=new String[52];
		for(int i=1951;i<=2002;i++)
		year_arr1[i-1951]=Integer.toString(i);
		year1=new JComboBox(year_arr1);
		year1.setBounds(xAxis+390,yAxis+120,60,30);
		panel.add(year1);

		
		
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

		EPassword=new JLabel("Password");
		EPassword.setBounds(xAxis,yAxis+320,width,height);
		EPassword.setFont(myFont);
		EPassword.setForeground(fontColor);
		panel.add(EPassword);
		
		Password=new JPasswordField("");
		Password.setBounds(xAxis+250,yAxis+320,width,height);
		Password.setFont(myFont);
		Password.setForeground(fontColor);
		panel.add(Password);
		
		EType=new JLabel("Employee Type");
		EType.setBounds(xAxis,yAxis+360,width,height);
		EType.setFont(myFont);
		EType.setForeground(fontColor);
		panel.add(EType);

		Type=new JTextField("");
		Type.setBounds(xAxis+250,yAxis+360,width,height);
		Type.setFont(myFont);
		Type.setForeground(fontColor);
		panel.add(Type);
		
		ESalary=new JLabel("Salary");
		ESalary.setBounds(xAxis,yAxis+400,width,height);
		ESalary.setFont(myFont);
		ESalary.setForeground(fontColor);
		panel.add(ESalary);

		Salary=new JTextField("");
		Salary.setBounds(xAxis+250,yAxis+400,width,height);
		Salary.setFont(myFont);
		Salary.setForeground(fontColor);
		panel.add(Salary);	
		
		add =new JButton("Add");
		add.setBounds(xAxis+250,yAxis+450,width-50,height);
		add.setFont(myFont);
		add.setForeground(fontColor);
		add.setBackground(buttonColColor);
		add.addActionListener(this);
		panel.add(add);	

		back =new JButton("Back");
		back.setBounds(10,yAxis+500,width-50,height);
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
		if(ae.getSource()== add)
		{
			if(!isNullCheck())
			{
				employeeSalary=Double.parseDouble(Salary.getText());
				if(employeeSalary>0)
				{
					insertNewEmployeeInDB();
				}
				else
				{
					JOptionPane.showMessageDialog(this,"You are inserting negative value in Salary!!!","Inane warning",JOptionPane.WARNING_MESSAGE);
				}
			}
			else
			{
				JOptionPane.showMessageDialog(this,"Fill everything","Inane warning",JOptionPane.WARNING_MESSAGE);
			}
		}
	}
	public boolean isNullCheck()
    { 
		if(Name.getText().equals("") || PhoneInfo.getText().equals("") || Address.getText().equals("") || NID.getText().equals("") || 
		   Type.getText().equals("") || BankId.getText().equals("") || Salary.getText().equals(""))
		{
			return true;
		}		
		else 
		{
			return false;
		}
	}

	public void insertNewEmployeeInDB()
	{
		
		String newName=Name.getText();
		String newDOB = day.getSelectedItem().toString()+month.getSelectedItem().toString()+year.getSelectedItem().toString();
		String newjoin = day1.getSelectedItem().toString()+month1.getSelectedItem().toString()+year1.getSelectedItem().toString();
	    String newPhoneinfo= PhoneInfo.getText();
		String newAddress = Address.getText();
		String newNID =NID.getText();
		String newBankid =BankId.getText();
		String newPass =Password.getText();
		String newMale =male.getText();
		String newtype =Type.getText();
		double newSalary = Double.parseDouble(Salary.getText());
		int status = 1;
		
		String query1 = "INSERT INTO employee VALUES ('"+newBankid+"','"+newName+"','"+newDOB+"','"+newMale+"','"+newtype+"','"+newPhoneinfo+"','"+newAddress+"','"+newNID+"','"+newjoin+"',"+newSalary+");";
		String query2 = "INSERT INTO login VALUES ('"+newBankid+"','"+newPass+"',"+status+");";
		System.out.println(query1);
		System.out.println(query2);
        
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bank", "root", "");
			Statement stm1 = con.createStatement();
			Statement stm2 = con.createStatement();
			stm1.execute(query1);
			stm2.execute(query2);
			stm1.close();
			stm2.close();
			con.close();
			JOptionPane.showMessageDialog(this,"Successfully Inserted","Inane warning",JOptionPane.WARNING_MESSAGE);
			
			Name.setText("");
			PhoneInfo.setText("");
			Address.setText("");
			NID.setText("");
			BankId.setText("");
			Password.setText("");
			male.setText("");
			Type.setText("");
			Salary.setText("");
			
			
			
		}
        catch(Exception e)
		{
			System.out.println(e.getMessage());
        }
    }	
	
}	