import java.lang.*;
import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;


public class  ViewCustomer extends JFrame implements ActionListener
{
	private JPanel panel;
	private JLabel logolabel;
	private ImageIcon logo;
	private JTextField searchField;
	private JButton back,search;
	private JLabel CName,CNID,CBankId,CBalance;
	private JTextField Name,NID,BankId,Balance;
	String Bank_id;

	public ViewCustomer(String Bank_id)
	{
		super("View Your Customer");
		this.setSize(800,700);
		this.Bank_id=Bank_id;
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Font myFont= new Font("Consolas",Font.PLAIN, 15);
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
		searchField.setBounds(10,120,200,30);
		searchField.setFont(myFont);
		searchField.addActionListener(this);
		panel.add(searchField);
		
		search =new JButton("Search");
		search.setBounds(220,120,160,30);
		search.setFont(myFont);
		search.setForeground(fontColor);
		search.setBackground(buttonColColor);
		search.addActionListener(this);
		panel.add(search);
		
		
		int xAxis=50,yAxis=200,width=200,height=30;
		
		
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
		
		CNID=new JLabel("NID");
		CNID.setBounds(xAxis,yAxis+40,width,height);
		CNID.setFont(myFont);
		CNID.setForeground(fontColor);
		panel.add(CNID);
		
		NID=new JTextField("");
		NID.setBounds(xAxis+250,yAxis+40,width,height);
		NID.setFont(myFont);
		NID.setForeground(fontColor);
		panel.add(NID);

		CBankId=new JLabel("Bank ID");
		CBankId.setBounds(xAxis,yAxis+80,width,height);
		CBankId.setFont(myFont);
		CBankId.setForeground(fontColor);
		panel.add(CBankId);
		
		BankId=new JTextField("");
		BankId.setBounds(xAxis+250,yAxis+80,width,height);
		BankId.setFont(myFont);
		BankId.setForeground(fontColor);
		panel.add(BankId);

		CBalance=new JLabel("Balance");
		CBalance.setBounds(xAxis,yAxis+120,width,height);
		CBalance.setFont(myFont);
		CBalance.setForeground(fontColor);
		panel.add(CBalance);

		Balance=new JTextField("");
		Balance.setBounds(xAxis+250,yAxis+120,width,height);
		Balance.setFont(myFont);
		Balance.setForeground(fontColor);
		panel.add(Balance);	

		back =new JButton("Back");
		back.setBounds(10,630,100,30);
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
			ManageCustomer manageC = new ManageCustomer(Bank_id);
			manageC.setVisible(true);
			this.setVisible(false);
		}
		if(ae.getSource()== search)
		{
			     if (searchField.getText().length()==0){
					 JOptionPane.showMessageDialog(this, "!!Missing Bank ID !!");
				 }
				 else
				 {
				 loadFromDB1();
			
				 Name.setText("");
				 NID.setText("");
				 Balance.setText("");
				 BankId.setText("");
				 searchField.setText("");
				 }
		}
	}
	
	
	public void loadFromDB1()
	{
		String loadId = searchField.getText();
		String query = "SELECT `Name`,`NID`,`Balance` FROM `customer` WHERE `Bank_id`='"+loadId+"';";     
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
			int iNID = 0;
			double iBalance = 0.0;
			//String iBankid = null;
			
			//double iBalance = 0.0;
			while(rs.next())
			{
				 iName = rs.getString("Name");
				 iBalance = rs.getDouble("Balance");
				 iNID = rs.getInt("NID");
				 
				 Name.setText(iName);
				 NID.setText(""+iNID);
				 Balance.setText(""+iBalance);
				 BankId.setText(""+loadId);
				 
				 flag=true;
				 JOptionPane.showMessageDialog(this, "Success !!!");
				
				//Password.setText(iPassword);
		
				
			}
			if(!flag)
			{
				JOptionPane.showMessageDialog(this, "Enter a valid BankID");
			}
			
			
		}
        catch(Exception ex)
		{
			System.out.println("Exception : " +ex.getMessage());
			JOptionPane.showMessageDialog(this, "Oops !!!");
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
            catch(Exception ex){
				JOptionPane.showMessageDialog(this, "Oops !!!");
			}
        }
		
	}
		
	
}	