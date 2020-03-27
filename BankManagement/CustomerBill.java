import java.lang.*;
import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class  CustomerBill extends JFrame implements ActionListener
{
	private JPanel panel;
	private JTextField AmountField,BillField,BankId;
	private JButton info,bill,logOut;
	private JLabel Bill,Amount,passlabel,logolabel;
	private JButton submit;
	private JComboBox type;
	private ImageIcon logo;
	String Bank_id;
	private static double desireAmount=0,remainingAmount=0,newAmount=0;
	
	public CustomerBill(String Bank_id)
	{
		super("Pay Your Bill");
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
		
		int xAxis=0,yAxis=100,width=150,height=40;
		
		info =new JButton("INFO");
		info.setBounds(xAxis,yAxis,width,height);
		info.setFont(myFont);
		info.setForeground(fontColor);
		info.setBackground(activeButtonColColor);
		info.addActionListener(this);
		panel.add(info);
		
		bill =new JButton("PAY BILL");
		bill.setBounds(xAxis,yAxis+40,width,height);
		bill.setFont(myFont);
		bill.setForeground(fontColor);
		bill.setBackground(buttonColColor);
		bill.addActionListener(this);
		panel.add(bill);
		
		logOut =new JButton("LOGOUT");
		logOut.setBounds(xAxis,yAxis+420,width,height);
		logOut.setFont(myFont);
		logOut.setForeground(fontColor);
		logOut.setBackground(buttonColColor);
		logOut.addActionListener(this);
		panel.add(logOut);
		
		/*---------------Bill main-----------------*/
		
		int labelxAxis=200,labelyAxis=120,labelWidth=200,labelHeight=40;
		
		Bill=new JLabel("Bill Number");
		Bill.setBounds(labelxAxis,labelyAxis,labelWidth,labelHeight);
		Bill.setFont(myFont);
		Bill.setForeground(fontColor);
		panel.add(Bill);
		
		String items[] = new String[]{"Electricity", "Gas", "Water"};
		type= new JComboBox(items);
		type.setBounds(labelxAxis+170,labelyAxis,90,labelHeight);
		panel.add(type);
		
		BillField=new JTextField();
		BillField.setBounds(labelxAxis+270,labelyAxis,labelWidth,labelHeight);
		BillField.setFont(myFont);
		panel.add(BillField);
		
		passlabel=new JLabel("Bank Id :");
		passlabel.setBounds(labelxAxis,labelyAxis+80,labelWidth,labelHeight);
		passlabel.setFont(myFont);
		passlabel.setForeground(fontColor);
		panel.add(passlabel);
		
		BankId=new JTextField();
		BankId.setBounds(labelxAxis+270,labelyAxis+80,labelWidth,labelHeight);
		BankId.setFont(myFont);
		panel.add(BankId);
		
		Amount=new JLabel("Amount");
		Amount.setBounds(labelxAxis,labelyAxis+160,labelWidth,labelHeight);
		Amount.setFont(myFont);
		Amount.setForeground(fontColor);
		panel.add(Amount);
		
		AmountField=new JTextField();
		AmountField.setBounds(labelxAxis+270,labelyAxis+160,labelWidth,labelHeight);
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
	        CustomerInfo cinfo = new CustomerInfo(Bank_id);
			cinfo.setVisible(true);
			this.setVisible(false);
		}
		if (ae.getSource()== logOut)
		{
			Login login = new Login();
			login.setVisible(true);
			this.setVisible(false);
		}
		if(ae.getSource()== submit)
		{
			if (Bank_id.equals(BankId.getText()))
			{
				desireAmount=Double.parseDouble(AmountField.getText());
				fetchBalance();
				System.out.println (desireAmount);
				System.out.println (remainingAmount);
				if (remainingAmount>desireAmount)
				{ 
					newAmount=remainingAmount-desireAmount;
					if(newAmount>500)
					{
						System.out.println (newAmount);
						updateBalance(newAmount);
						BankId.setText("");
						AmountField.setText("");
						BillField.setText("");
					}
					else
					{
						JOptionPane.showMessageDialog(this,"You have to keep minimum 500$ at account ","Inane warning",JOptionPane.WARNING_MESSAGE);
						BankId.setText("");
						AmountField.setText("");
						BillField.setText("");
					}
				   
				}
				else 
				{
					JOptionPane.showMessageDialog(this,"Your balance is less than money you yarn for to withdraw.","Inane warning",JOptionPane.WARNING_MESSAGE);
					BankId.setText("");
					AmountField.setText("");
					BillField.setText("");
				}
			}
			else 
			{
				JOptionPane.showMessageDialog(this,"Insert Correct Bank ID","Inane warning",JOptionPane.WARNING_MESSAGE);
				BankId.setText("");
				AmountField.setText("");
				BillField.setText("");
			}
			
		}
		else {}
	}
	
	public void fetchBalance()
	{
		String loadId = Bank_id;
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
                remainingAmount= rs.getDouble("Balance");
				flag=true;	
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
	
	public void updateBalance(double newAmount)
	{
		String loadId = Bank_id;
		double iBalance = newAmount;
		String query = "UPDATE customer SET Balance='"+iBalance+"' WHERE Bank_id='"+Bank_id+"'";	
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
			JOptionPane.showMessageDialog(this, "Successfully Billed !!!");
			
			
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
		finally
		{
            try
			{
                if(st!=null)
					st.close();

                if(con!=null)
					con.close();
            }
            catch(Exception ex){}
        }
	}
}
		