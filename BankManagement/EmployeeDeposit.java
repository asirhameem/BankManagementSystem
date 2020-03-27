import java.lang.*;
import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class  EmployeeDeposit extends JFrame implements ActionListener
{
	private JPanel panel;
	private JButton info,manageCustomer,deposit,withdraw,transfer,passChngRequest,logOut,bttn;
	private JLabel logolabel;
	private ImageIcon logo;
	private JLabel bankId,amount;
	private JTextField bankIdTextArea,amountTextArea;
	private JButton submit;
	String Bank_id;
	private static double inputUser,userID,value=0,value1=0,solve=0;

	
	
	public EmployeeDeposit(String Bank_id)
	{
		super("Deposit Customer Money");
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
		info.setBackground(buttonColColor);
		info.addActionListener(this);
		panel.add(info);
		
		deposit =new JButton("Deposit");
		deposit.setBounds(xAxis,yAxis+40,width,height);
		deposit.setFont(myFont);
		deposit.setForeground(fontColor);
		deposit.setBackground(activeButtonColColor);
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

		/*---------------Info main-----------------*/
		
		int labelxAxis=300,labelyAxis=120,labelWidth=100,labelHeight=40;
		
		
		bankId=new JLabel("Bank ID");
		bankId.setBounds(labelxAxis,labelyAxis,labelWidth,labelHeight);
		bankId.setFont(myFont);
		bankId.setForeground(fontColor);
		panel.add(bankId);
		
		bankIdTextArea=new JTextField("");
		bankIdTextArea.setBounds(labelxAxis+150,labelyAxis,labelWidth+100,labelHeight);
		bankIdTextArea.setFont(myFont);
		bankIdTextArea.addActionListener(this);
		panel.add(bankIdTextArea);
		
		amount=new JLabel("Amount");
		amount.setBounds(labelxAxis,labelyAxis+100,labelWidth,labelHeight);
		amount.setFont(myFont);
		amount.setForeground(fontColor);
		panel.add(amount);
		
		amountTextArea=new JTextField("");
		amountTextArea.setBounds(labelxAxis+150,labelyAxis+100,labelWidth+100,labelHeight);
		amountTextArea.setFont(myFont);
		amountTextArea.addActionListener(this);
		panel.add(amountTextArea);
		
		submit =new JButton("Submit");
		submit.setBounds(labelxAxis+150,labelyAxis+200,labelWidth+30,labelHeight);
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
		if(ae.getSource()== manageCustomer)
		{
			ManageCustomer manageC = new ManageCustomer(Bank_id);
			manageC.setVisible(true);
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
			if ((amountTextArea.getText().length()==0)|| (bankIdTextArea.getText().length()==0))
			{
				JOptionPane.showMessageDialog(this, "!!Missing Bank ID or Amount!!");
			}
		   else
		   {			
				value=Double.parseDouble(amountTextArea.getText());
				if(value>0)
				{
					fetchUser();
					inputUser=Double.parseDouble(bankIdTextArea.getText());
					if (userID == inputUser)
					{
					  loadFromDB1();
					  System.out.println (value);
					  System.out.println (value1);
					  solve=value1+value;
					  System.out.println (solve);
					  updateInDB(solve);
					  bankIdTextArea.setText("");
					  amountTextArea.setText("");
					}	
				}
				else
				{
					JOptionPane.showMessageDialog(this,"You are inserting negative value!!!","Inane warning",JOptionPane.WARNING_MESSAGE);
				}
		   }
		}
	}
	
	public void fetchUser()
	{
		String loadId = bankIdTextArea.getText();
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
	
	public void loadFromDB1()
	{
		String loadId = bankIdTextArea.getText();
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
                 value1= rs.getDouble("Balance");
				flag=true;
				
				//Password.setText(iPassword);
				
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
	
	public void updateInDB(double solve)
	{
		String loadId = bankIdTextArea.getText();
		double iBalance = solve;
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
			JOptionPane.showMessageDialog(this, "Success !!!");
			
			
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
			JOptionPane.showMessageDialog(this, "Oops !!!");
		}
	}
	
	
	
	
}
		