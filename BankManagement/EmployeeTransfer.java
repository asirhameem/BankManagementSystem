import java.lang.*;
import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class  EmployeeTransfer extends JFrame implements ActionListener
{
	private JPanel panel;
	private JTextField BankId,RBankIdField,AmountField;
	private JButton info,manageCustomer,deposit,withdraw,transfer,passChngRequest,logOut,bttn;
	private JLabel Amount,CBankId,RBankId,logolabel;
	private JButton submit;
	private ImageIcon logo;
	String Bank_id;
	private static double inputUser,userID,sendingAmount,remainingBalance,senderNewBalance,recieverNewBalance,recieverOldBalance;
	
	
	public EmployeeTransfer(String Bank_id)
	{
		super("Transfer Your money");
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
		
		/*---------------Sidebar-----------------*/
		
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
		transfer.setBackground(activeButtonColColor);
		transfer.addActionListener(this);
		panel.add(transfer);
		
		manageCustomer =new JButton("Manage Customer");
		manageCustomer.setBounds(xAxis,yAxis+160,width,height);
		manageCustomer.setFont(myFont);
		manageCustomer.setForeground(fontColor);
		manageCustomer.setBackground(buttonColColor);
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
		
		/*---------------Transfer main-----------------*/
		
		int labelxAxis=300,labelyAxis=120,labelWidth=200,labelHeight=40;
		
		CBankId=new JLabel("Bank ID");
		CBankId.setBounds(labelxAxis,labelyAxis,labelWidth,labelHeight);
		CBankId.setFont(myFont);
		CBankId.setForeground(fontColor);
		panel.add(CBankId);
		
		BankId=new JTextField();
		BankId.setBounds(labelxAxis+200,labelyAxis,labelWidth,labelHeight);
		BankId.setFont(myFont);
		panel.add(BankId);
		
		RBankId=new JLabel("Reciever Bank ID");
		RBankId.setBounds(labelxAxis,labelyAxis+80,labelWidth+30,labelHeight);
		RBankId.setFont(myFont);
		RBankId.setForeground(fontColor);
		panel.add(RBankId);
		
		RBankIdField=new JTextField();
		RBankIdField.setBounds(labelxAxis+200,labelyAxis+80,labelWidth,labelHeight);
		RBankIdField.setFont(myFont);
		panel.add(RBankIdField);
		
		
		Amount=new JLabel("Amount");
		Amount.setBounds(labelxAxis,labelyAxis+160,labelWidth,labelHeight);
		Amount.setFont(myFont);
		Amount.setForeground(fontColor);
		panel.add(Amount);
		
		AmountField=new JTextField();
		AmountField.setBounds(labelxAxis+200,labelyAxis+160,labelWidth,labelHeight);
		AmountField.setFont(myFont);
		panel.add(AmountField);
		
		submit=new JButton("SUBMIT");
		submit.setBounds(labelxAxis,labelyAxis+240,labelWidth-50,labelHeight);
		submit.setFont(myFont);
		submit.setForeground(fontColor);
		submit.setBackground(buttonColColor);
		submit.addActionListener(this);
		panel.add(submit);
		
		
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
		
		if(ae.getSource()== withdraw)
		{
			EmployeeWithdraw ewithdraw = new EmployeeWithdraw(Bank_id);
			ewithdraw.setVisible(true);
			this.setVisible(false);
		}
		
		if(ae.getSource()== manageCustomer)
		{
			ManageCustomer manageC = new ManageCustomer(Bank_id);
			manageC.setVisible(true);
			this.setVisible(false);
		}
		if(ae.getSource()== deposit)
		{
			EmployeeDeposit deposit = new EmployeeDeposit(Bank_id);
			deposit.setVisible(true);
			this.setVisible(false);
		}
		if(ae.getSource()== transfer)
		{
			EmployeeTransfer etransfer = new EmployeeTransfer(Bank_id);
			etransfer.setVisible(true);
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
		if(ae.getSource()== submit)
		{
			fetchUser();
			inputUser=Double.parseDouble(BankId.getText());
			if (userID == inputUser)
			{
				sendingAmount=Double.parseDouble(AmountField.getText());
				fetchingSenderAmount();
				fetchingRecieverAmount();
				if(sendingAmount>0)
				{
					if(sendingAmount<remainingBalance)
					{ 
						senderNewBalance=remainingBalance-sendingAmount;		
						if(senderNewBalance>500)
						{
						   updateSenderBalance(senderNewBalance);
						   
						   recieverNewBalance=recieverOldBalance+sendingAmount;
						   updateRecieverBalance(recieverNewBalance);
						   
						   BankId.setText("");
						   AmountField.setText("");
						   RBankIdField.setText("");
						}
						else
						{
							JOptionPane.showMessageDialog(this,"You have to keep minimum 500$ at account ","Inane warning",JOptionPane.WARNING_MESSAGE);
							BankId.setText("");
							AmountField.setText("");
							RBankIdField.setText("");
						}	
				   
					}
					else 
					{
						JOptionPane.showMessageDialog(this,"Your balance is less than money you are willing for to withdraw.","Inane warning",JOptionPane.WARNING_MESSAGE);
						BankId.setText("");
						AmountField.setText("");
						RBankIdField.setText("");
					}
				}
				else
				{
					JOptionPane.showMessageDialog(this,"You are inserting negative value!!!","Inane warning",JOptionPane.WARNING_MESSAGE);
				}
			}
			else 
			 {
				JOptionPane.showMessageDialog(this,"Insert Correct Bank ID","Inane warning",JOptionPane.WARNING_MESSAGE);
				BankId.setText("");
				AmountField.setText("");
				RBankIdField.setText("");
			 }
			
		}
	}
	public void fetchUser()
	{
		String loadId = BankId.getText();
		String query = "SELECT Bank_id FROM `customer` WHERE `Bank_id`='"+loadId+"';";     
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
			while(rs.next())
			{
                userID = rs.getDouble("Bank_id");
				flag=true;	
			}
			if(!flag)
			{
				JOptionPane.showMessageDialog(this,"Insert Correct Bank ID","Inane warning",JOptionPane.WARNING_MESSAGE);
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
	
	public void fetchingSenderAmount()
	{
		String loadId = BankId.getText();
		String query = "SELECT `Balance` FROM `customer` WHERE `Bank_id`='"+loadId+"';";     
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
			while(rs.next())
			{
                remainingBalance= rs.getDouble("Balance");
				flag=true;
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
	public void fetchingRecieverAmount()
	{
		String loadId =  RBankIdField.getText();
		String query = "SELECT `Balance` FROM `customer` WHERE `Bank_id`='"+loadId+"';";     
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
						
			while(rs.next())
			{
                recieverOldBalance= rs.getDouble("Balance");
				flag=true;	
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
	
	public void updateSenderBalance(double senderNewBalance)
	{
		double iBalance=senderNewBalance;
		String loadId = BankId.getText();
		String query = "UPDATE customer SET Balance='"+iBalance+"' WHERE Bank_id='"+loadId+"'";	
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
			JOptionPane.showMessageDialog(this, "Successfully Send to your Desirable Account!!!");
			
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
	}
	
	public void updateRecieverBalance(double recieverNewBalance)
	{
		double temp=recieverNewBalance;
		String loadId = RBankIdField.getText();
		double iBalance = temp;
		String query = "UPDATE customer SET Balance='"+iBalance+"' WHERE Bank_id='"+loadId+"'";	
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
			
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
	}
}	