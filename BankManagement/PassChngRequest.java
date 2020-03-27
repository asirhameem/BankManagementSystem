import java.lang.*;
import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.*;

public class  PassChngRequest extends JFrame implements ActionListener
{
	public JPanel panel;
	private JButton info,manageCustomer,deposit,withdraw,transfer,passChngRequest,logOut,bttn;
	public JLabel userlabel,passlabel,logolabel;
	public JTextField userfield;
	public JTextField passfield;
	public JButton submit,generate;
	public ImageIcon logo;
	String Bank_id;
	
	public PassChngRequest(String Bank_id)
	{
		super("submit Form");
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
		manageCustomer.setBackground(buttonColColor);
		manageCustomer.addActionListener(this);
		panel.add(manageCustomer);
		
		passChngRequest =new JButton("Pass Change");
		passChngRequest.setBounds(xAxis,yAxis+200,width,height);
		passChngRequest.setFont(myFont);
		passChngRequest.setForeground(fontColor);
		passChngRequest.setBackground(activeButtonColColor);
		passChngRequest.addActionListener(this);
		panel.add(passChngRequest);
		
		logOut =new JButton("LOGOUT");
		logOut.setBounds(xAxis,yAxis+420,width,height);
		logOut.setFont(myFont);
		logOut.setForeground(fontColor);
		logOut.setBackground(buttonColColor);
		logOut.addActionListener(this);
		panel.add(logOut);
		
		
		/*-----------------------Info Main---------------------*/
		
		int labelxAxis=350,labelyAxis=150,labelWidth=200,labelHeight=40;
		int fieldxAxis=350,fieldyAxis=205,fieldWidth=200,fieldHeight=30;
		
		
		userlabel=new JLabel("Bank ID:");
		userlabel.setBounds(labelxAxis,labelyAxis,labelWidth,labelHeight);
		userlabel.setFont(myFont);
		userlabel.setForeground(fontColor);
		panel.add(userlabel);
		
		userfield=new JTextField();
		userfield.setBounds(fieldxAxis,fieldyAxis,fieldWidth,fieldHeight);
		userfield.setFont(myFont);
		panel.add(userfield);
		
		passlabel=new JLabel("New Password:");
		passlabel.setBounds(labelxAxis,labelyAxis+100,labelWidth,labelHeight);
		passlabel.setFont(myFont);
		passlabel.setForeground(fontColor);
		panel.add(passlabel);
		
		passfield=new JTextField();
		passfield.setBounds(fieldxAxis,fieldyAxis+100,fieldWidth,fieldHeight);
		passfield.setFont(myFont);
		panel.add(passfield);
		
		
		submit=new JButton("submit");
		submit.setBounds(labelxAxis,labelyAxis+200,labelWidth-80,labelHeight);
		submit.setFont(myFont);
		submit.setForeground(fontColor);
		submit.setBackground(buttonColColor);
		submit.addActionListener(this);
		panel.add(submit);
		
		generate=new JButton("Generate");
		generate.setBounds(labelxAxis+210,labelyAxis+150,labelWidth-50,labelHeight);
		generate.setFont(myFont);
		generate.setForeground(fontColor);
		generate.addActionListener(this);
		panel.add(generate);
		
		
		this.add(panel);	
	}
	public void actionPerformed(ActionEvent ae)
	{
		String text = ae.getActionCommand();
		if(ae.getSource()== submit)
		{
			checkLogin();
		}
		if(ae.getSource()== generate)
		{
			Random r = new Random();
			passfield.setText(r.nextInt(899999)+100000+"");
		}
		if(ae.getSource()== manageCustomer)
		{
			ManageCustomer manageC = new ManageCustomer(Bank_id);
			manageC.setVisible(true);
			this.setVisible(false);
		}
		if(ae.getSource()== info)
		{
			EmployeeInfo ei = new EmployeeInfo(Bank_id);
			ei.setVisible(true);
			this.setVisible(false);
		}
		if(ae.getSource()== withdraw)
		{
			EmployeeWithdraw ewithdraw = new EmployeeWithdraw(Bank_id);
			ewithdraw.setVisible(true);
			this.setVisible(false);
		}
		if(ae.getSource()== transfer)
		{
			EmployeeTransfer etransfer = new EmployeeTransfer(Bank_id);
			etransfer.setVisible(true);
			this.setVisible(false);
		}
		if(ae.getSource()== deposit)
		{
			CustomerDeposit deposit = new CustomerDeposit(Bank_id);
			deposit.setVisible(true);
			this.setVisible(false);
		}
		if(ae.getSource()== logOut)
		{
			Login login = new Login();
			login.setVisible(true);
			this.setVisible(false);
			
		}
	}
	
	
	
	public void checkLogin()
	{
		String query = "SELECT `Bank_id` FROM `recovery`;";     
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
			
            if (rs.next()== false)
			{
				JOptionPane.showMessageDialog(this,"No password change request");
				userfield.setText("");
			    passfield.setText("");
			}
          else 
		  {			
			do
			{
                String iBank_id = rs.getString("Bank_id");
			           
					   if(iBank_id.equals(userfield.getText()))
				     {
					    updateInDB();	
                        JOptionPane.showMessageDialog(this,"success!!");
                        deleteFromDB();				  
				     }
				   else
				     {
				        JOptionPane.showMessageDialog(this,"Invalid ID or Password");
						userfield.setText("");
			            passfield.setText("");
				     }		
			}while(rs.next());
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
	
	
	
	public void updateInDB()
	{
		String loadId = userfield.getText();
		String ipass = passfield.getText();
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
			
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
	}
	
	public void deleteFromDB()
	{
		String newId = userfield.getText();
		String query1 = "DELETE from recovery WHERE Bank_id='"+newId+"';";
		//String query2 = "DELETE from login WHERE Bank_id='"+newId+"';";
		System.out.println(query1);
		//System.out.println(query2);
        try
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bank", "root", "");
			Statement stm = con.createStatement();
			stm.execute(query1);
			//stm.execute(query2);
			stm.close();
			con.close();
			//JOptionPane.showMessageDialog(this, "Success !!!");
			
			
			userfield.setText("");
			passfield.setText("");
			
		}
        catch(Exception ex)
		{
			JOptionPane.showMessageDialog(this, "Oops !!!");
        }
	}
	
}
