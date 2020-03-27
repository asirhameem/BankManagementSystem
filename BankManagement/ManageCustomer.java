import java.lang.*;
import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.awt.event.*;

public class  ManageCustomer extends JFrame implements ActionListener
{
	private JPanel panel;
	private JButton info,manageCustomer,deposit,withdraw,transfer,passChngRequest,logOut,bttn;
	private JLabel logolabel;
	private ImageIcon logo;
	private JButton addC,viewC,removeC,updateC;
	private JLabel about;
    private static String Bank_id;
	
	
	public ManageCustomer(String Bank_id)
	{
		super("Manage Your Customer");
		this.setSize(800,600);
		this.Bank_id=Bank_id;
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Font myFont= new Font("Consolas",Font.PLAIN, 25);
		Color fontColor = new Color (41,41,41);
		Color panelColor = new Color (225,225,225);
		Color buttonColColor = new Color (74,96,132);
		Color activeButtonColColor = new Color (249,249,249);
		Color customerButtonColor = new Color (223, 227, 238);
	
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
		info.setBackground(buttonColColor);
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
		manageCustomer.setBackground(activeButtonColColor);
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
		
		int buttonxAxis=370,buttonyAxis=200,buttonWidth=250,buttonHeight=70;
		
		  
		addC =new JButton("Add Customer");
		addC.setBounds(buttonxAxis,buttonyAxis-50,buttonWidth,buttonHeight);
		addC.setFont(myFont);
		addC.setForeground(fontColor);
		addC.setBackground(customerButtonColor);
		addC.addActionListener(this);
		panel.add(addC);
		
		viewC =new JButton("View Customer");
		viewC.setBounds(buttonxAxis,buttonyAxis+50,buttonWidth,buttonHeight);
		viewC.setFont(myFont);
		viewC.setForeground(fontColor);
		viewC.setBackground(customerButtonColor);
		viewC.addActionListener(this);
		panel.add(viewC);
		
		removeC =new JButton("Remove Customer");
		removeC.setBounds(buttonxAxis,buttonyAxis+150,buttonWidth,buttonHeight);
		removeC.setFont(myFont);
		removeC.setForeground(fontColor);
		removeC.setBackground(customerButtonColor);
		removeC.addActionListener(this);
		panel.add(removeC);
		
		updateC =new JButton("Update Customer");
		updateC.setBounds(buttonxAxis,buttonyAxis+250,buttonWidth,buttonHeight);
		updateC.setFont(myFont);
		updateC.setForeground(fontColor);
		updateC.setBackground(customerButtonColor);
		updateC.addActionListener(this);
		panel.add(updateC);
		  
		this.add(panel);	
	}
	
	public void actionPerformed(ActionEvent ae)
	{
		String text = ae.getActionCommand();
		
		if(ae.getSource()== info)
		{
	        EmployeeInfo info = new EmployeeInfo(Bank_id);
			info.setVisible(true);
			this.setVisible(false);
		}
		if(ae.getSource()== transfer)
		{
			EmployeeTransfer etransfer = new EmployeeTransfer(Bank_id);
			etransfer.setVisible(true);
			this.setVisible(false);
		}
		if(ae.getSource()== withdraw)
		{
			EmployeeWithdraw ewithdraw = new EmployeeWithdraw(Bank_id);
			ewithdraw.setVisible(true);
			this.setVisible(false);
		}
		
		if(ae.getSource()== addC)
		{
	        AddCustomer addC = new AddCustomer(Bank_id);
			addC.setVisible(true);
			this.setVisible(false);
		}
		if(ae.getSource()== viewC)
		{
	        ViewCustomer viewC = new ViewCustomer(Bank_id);
			viewC.setVisible(true);
			this.setVisible(false);
		}
		if(ae.getSource()== removeC)
		{
	        RemoveCustomer removeC = new RemoveCustomer(Bank_id);
			removeC.setVisible(true);
			this.setVisible(false);
		}
		if(ae.getSource()== deposit)
		{
			EmployeeDeposit deposit = new EmployeeDeposit(Bank_id);
			deposit.setVisible(true);
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
		
		if(ae.getSource()== updateC)
		{
	        UpdateCustomer updateC = new UpdateCustomer(Bank_id);
			updateC.setVisible(true);
			this.setVisible(false);
		}
	}
	
	
	
}