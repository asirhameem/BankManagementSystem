import java.lang.*;
import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class  AddCustomer extends JFrame implements ActionListener,MouseListener
{
	private JPanel panel;
	private JPasswordField Password;
	private JLabel logolabel;
	private ImageIcon logo;
	private JButton back,add;
	
	private JRadioButton female;
	private ButtonGroup Gender;
	private JComboBox day,month,year;
	private JLabel CName,CFatherName,CGender,CDOB,CPhoneInfo,CAddress,CNID,CBankId,CPassword,CBalance;
	private JTextField Name,FatherName,DOB,PhoneInfo,Address,NID,BankId,Balance,male;
    private static String Bank_id;
	private double userBalance;
	
	
	
	public AddCustomer(String Bank_id)
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
		
		int xAxis=140,yAxis=120,width=200,height=30;
		
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
		
		male=new JTextField("");
		male.setFont(myFont);
		male.setBounds(xAxis+250,yAxis+80,120,height);
		male.setForeground(fontColor);
		panel.add(male);
		
		
		CDOB=new JLabel("Date Of Birth");
		CDOB.setBounds(xAxis,yAxis+120,width,height);
		CDOB.setFont(myFont);
		CDOB.setForeground(fontColor);
		panel.add(CDOB);
		
		String day_arr[]=new String[31];
		for(int i=1;i<=31;i++)
		day_arr[i-1]=Integer.toString(i); 
		day=new JComboBox(day_arr);
		day.setBounds(xAxis+250,yAxis+120,60,30);
		panel.add(day);
		
		String month_arr[]={"Jan","Feb","March","April","May","June","July","Aug","Sept","Oct","Nov","Dec" }; 
		month=new JComboBox(month_arr);
		month.setBounds(xAxis+320,yAxis+120,60,30);
		panel.add(month);
 
		String year_arr[]=new String[52];
		for(int i=1951;i<=2002;i++)
		year_arr[i-1951]=Integer.toString(i);
		year=new JComboBox(year_arr);
		year.setBounds(xAxis+390,yAxis+120,60,30);
		panel.add(year);
		
		/*DOB=new JTextField("");
		DOB.setBounds();
		DOB.setFont(myFont);
		DOB.setForeground(fontColor);
		panel.add(DOB);*/

		CPhoneInfo=new JLabel("Phone No");
		CPhoneInfo.setBounds(xAxis,yAxis+160,width,height);
		CPhoneInfo.setFont(myFont);
		CPhoneInfo.setForeground(fontColor);
		panel.add(CPhoneInfo);
		
		PhoneInfo=new JTextField("+880");
		PhoneInfo.setBounds(xAxis+250,yAxis+160,width,height);
		PhoneInfo.setFont(myFont);
		PhoneInfo.setForeground(fontColor);
		PhoneInfo.addMouseListener(this);
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

		CPassword=new JLabel("Password");
		CPassword.setBounds(xAxis,yAxis+320,width,height);
		CPassword.setFont(myFont);
		CPassword.setForeground(fontColor);
		panel.add(CPassword);
		
		Password=new JPasswordField("");
		Password.setBounds(xAxis+250,yAxis+320,width,height);
		Password.setFont(myFont);
		Password.setForeground(fontColor);
		panel.add(Password);

		CBalance=new JLabel("Balance");
		CBalance.setBounds(xAxis,yAxis+360,width,height);
		CBalance.setFont(myFont);
		CBalance.setForeground(fontColor);
		panel.add(CBalance);

		Balance=new JTextField("");
		Balance.setBounds(xAxis+250,yAxis+360,width,height);
		Balance.setFont(myFont);
		Balance.setForeground(fontColor);
		panel.add(Balance);	
		
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
	
	public void mousePressed(MouseEvent me){ }
	public void mouseReleased(MouseEvent me){ }
	public void mouseEntered(MouseEvent me) { }
	public void mouseExited(MouseEvent me) { }
	public void mouseClicked(MouseEvent me)
	{
		if(me.getSource()== PhoneInfo)
		{
			PhoneInfo.setText("");
		}
		
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
		
		if(ae.getSource()== add)
		{
			userBalance=Double.parseDouble(Balance.getText());
			if(userBalance>0)
			{
				insertIntoDB();
			}
			else{
				JOptionPane.showMessageDialog(this,"You are inserting negative value in Balance!!!","Inane warning",JOptionPane.WARNING_MESSAGE);
			}
		}
		
	}
	
	
	
	public void insertIntoDB()
	{
		if  ( (Name.getText().length()==0)||(BankId.getText().length()==0)||(NID.getText().length()==0)||(Password.getText().length()==0) )
		{
			JOptionPane.showMessageDialog(this, "Please fill the gap");
		}
		else
		{
		String newName=Name.getText();
		String newFatherName=FatherName.getText();
		String newDOB = day.getSelectedItem().toString()+month.getSelectedItem().toString()+year.getSelectedItem().toString();
	    String newPhoneinfo= PhoneInfo.getText();
		String newAddress = Address.getText();
		String newNID =NID.getText();
		String newBankid =BankId.getText();
		String newPass =Password.getText();
		String newMale =male.getText();
		double newBalance = Double.parseDouble(Balance.getText());
		int status = 0;
		
		
		//roleCombo.getSelectedItem().toString()
		
		String query1 = "INSERT INTO customer VALUES ('"+newBankid+"','"+newName+"','"+newFatherName+"','"+newMale+"','"+newDOB+"','"+newPhoneinfo+"','"+newAddress+"','"+newNID+"',"+newBalance+");";
		String query2 = "INSERT INTO login VALUES ('"+newBankid+"','"+newPass+"',"+status+");";
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
			JOptionPane.showMessageDialog(this, "Customer Added !!!");
			
			    Name.setText("");
				FatherName.setText("");
				male.setText("");
				//DOB.setText("");
				PhoneInfo.setText("");
				Address.setText("");
				NID.setText("");
				BankId.setText("");
				Balance.setText("");
				Password.setText("");
		}
        catch(Exception ex)
		{
			JOptionPane.showMessageDialog(this, "Oops !!!");
        }
}
    }	
	
	
}	