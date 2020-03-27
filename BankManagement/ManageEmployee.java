import java.lang.*;
import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.awt.event.*;

public class  ManageEmployee extends JFrame implements ActionListener
{
	private JPanel panel;
	private JButton info,manageEmployee,logOut;
	private JLabel logolabel;
	private ImageIcon logo;
	private JButton addE,viewE,removeE,updateE;
	private JLabel AName,AID,ADOB,APhoneInfo,AAddress,ANID,AJoinDate,APassword,ASalary;
	private JLabel Name,ID,DOB,PhoneInfo,Address,NID,JoinDate,Password,Salary;
    private static String Bank_id;
	
	
	public ManageEmployee(String Bank_id)
	{
		super("Admin Information");
		this.setSize(800,600);
		this.Bank_id=Bank_id;
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Font myFont= new Font("Consolas",Font.PLAIN, 25);
		Color fontColor = new Color (41,41,41);
		Color panelColor = new Color (225,225,225);
		Color buttonColor = new Color (74,96,132);
		Color activeButtonColColor = new Color (249,249,249);
		Color employeerButtonColor = new Color (223, 227, 238);
	
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
		info.setBackground(buttonColor);
		info.addActionListener(this);
		panel.add(info);
		
		manageEmployee =new JButton("Manage Employee");
		manageEmployee.setBounds(xAxis,yAxis+40,width,height);
		manageEmployee.setFont(myFont);
		manageEmployee.setForeground(fontColor);
		manageEmployee.setBackground(activeButtonColColor);
		manageEmployee.addActionListener(this);
		panel.add(manageEmployee);
		
		logOut =new JButton("LOGOUT");
		logOut.setBounds(xAxis,yAxis+420,width,height);
		logOut.setFont(myFont);
		logOut.setForeground(fontColor);
		logOut.setBackground(buttonColor);
		logOut.addActionListener(this);
		panel.add(logOut);

		/*---------------Info main-----------------*/
		
		int buttonxAxis=370,buttonyAxis=200,buttonWidth=250,buttonHeight=70;
		
		  
		addE =new JButton("Add Employee");
		addE.setBounds(buttonxAxis,buttonyAxis-50,buttonWidth,buttonHeight);
		addE.setFont(myFont);
		addE.setForeground(fontColor);
		addE.setBackground(employeerButtonColor);
		addE.addActionListener(this);
		panel.add(addE);
		
		viewE =new JButton("View Employee");
		viewE.setBounds(buttonxAxis,buttonyAxis+50,buttonWidth,buttonHeight);
		viewE.setFont(myFont);
		viewE.setForeground(fontColor);
		viewE.setBackground(employeerButtonColor);
		viewE.addActionListener(this);
		panel.add(viewE);
		
		removeE =new JButton("Remove Employee");
		removeE.setBounds(buttonxAxis,buttonyAxis+150,buttonWidth,buttonHeight);
		removeE.setFont(myFont);
		removeE.setForeground(fontColor);
		removeE.setBackground(employeerButtonColor);
		removeE.addActionListener(this);
		panel.add(removeE);
		
		updateE =new JButton("Update Employee");
		updateE.setBounds(buttonxAxis,buttonyAxis+250,buttonWidth,buttonHeight);
		updateE.setFont(myFont);
		updateE.setForeground(fontColor);
		updateE.setBackground(employeerButtonColor);
		updateE.addActionListener(this);
		panel.add(updateE);
		
			
		
		this.add(panel);	
	}
	
	public void actionPerformed(ActionEvent ae)
	{
		String text = ae.getActionCommand();
		
		if(ae.getSource()== info)
		{
			AdminInfo info = new AdminInfo(Bank_id);
			info.setVisible(true);
			this.setVisible(false);
		}
		
		if(ae.getSource()== addE)
		{
	        AddEmployee addE = new AddEmployee(Bank_id);
			addE.setVisible(true);
			this.setVisible(false);
		}
		if(ae.getSource()== viewE)
		{
	        ViewEmployee viewE = new ViewEmployee(Bank_id);
			viewE.setVisible(true);
			this.setVisible(false);
		}
		if(ae.getSource()== removeE)
		{
	        RemoveEmployee removeE = new RemoveEmployee(Bank_id);
			removeE.setVisible(true);
			this.setVisible(false);
		}
		if(ae.getSource()== logOut)
		{
			Login login = new Login();
			login.setVisible(true);
			this.setVisible(false);
			
		}
		if(ae.getSource()== updateE)
		{
	        UpdateEmployee updateE = new UpdateEmployee(Bank_id);
			updateE.setVisible(true);
			this.setVisible(false);
		}
	}

}
		