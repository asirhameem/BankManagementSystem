import java.lang.*;
import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class  ViewEmployee extends JFrame implements ActionListener
{
	private JPanel panel;
	private JLabel logolabel;
	private ImageIcon logo;
	private JTextField searchField;
	private JButton back,search;
	private JLabel EName,ENID,EBankId,EType,ESalary;
	private JTextField Name,NID,BankId,Type,Salary;
	String Bank_id;
	
	
	public ViewEmployee(String Bank_id)
	{
		super("View Your Employee");
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
		
		ENID=new JLabel("NID");
		ENID.setBounds(xAxis,yAxis+40,width,height);
		ENID.setFont(myFont);
		ENID.setForeground(fontColor);
		panel.add(ENID);
		
		NID=new JTextField("");
		NID.setBounds(xAxis+250,yAxis+40,width,height);
		NID.setFont(myFont);
		NID.setForeground(fontColor);
		panel.add(NID);

		EBankId=new JLabel("Bank ID");
		EBankId.setBounds(xAxis,yAxis+80,width,height);
		EBankId.setFont(myFont);
		EBankId.setForeground(fontColor);
		panel.add(EBankId);
		
		BankId=new JTextField("");
		BankId.setBounds(xAxis+250,yAxis+80,width,height);
		BankId.setFont(myFont);
		BankId.setForeground(fontColor);
		panel.add(BankId);
		
		EType=new JLabel("Type");
		EType.setBounds(xAxis,yAxis+120,width,height);
		EType.setFont(myFont);
		EType.setForeground(fontColor);
		panel.add(EType);

		Type=new JTextField("");
		Type.setBounds(xAxis+250,yAxis+120,width,height);
		Type.setFont(myFont);
		Type.setForeground(fontColor);
		panel.add(Type);
		
		ESalary=new JLabel("Salary");
		ESalary.setBounds(xAxis,yAxis+160,width,height);
		ESalary.setFont(myFont);
		ESalary.setForeground(fontColor);
		panel.add(ESalary);

		Salary=new JTextField("");
		Salary.setBounds(xAxis+250,yAxis+160,width,height);
		Salary.setFont(myFont);
		Salary.setForeground(fontColor);
		panel.add(Salary);	

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
			ManageEmployee manageE = new ManageEmployee(Bank_id);
			manageE.setVisible(true);
			this.setVisible(false);
		}
		if(ae.getSource()== search)
		{
			loadFromDB1();
			
				 Name.setText("");
				 Type.setText("");
				 NID.setText("");
				 Salary.setText("");
				 BankId.setText("");
		}
	}
	
	
	
	public void loadFromDB1()
	{
		String loadId = searchField.getText();
		String query = "SELECT `Name`,`NID`,`Employee_type`,`Salary` FROM `employee` WHERE `Bank_id`='"+loadId+"';";     
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
			String itype = null;
			int iNID = 0;
			double iSalary = 0.0;
			//String iBankid = null;
			
			//double iBalance = 0.0;
			while(rs.next())
			{
				 iName = rs.getString("Name");
				 itype=rs.getString("Employee_type");
				 iSalary = rs.getDouble("Salary");
				 iNID = rs.getInt("NID");
				 
				 Name.setText(iName);
				 Type.setText(itype);
				 NID.setText(""+iNID);
				 Salary.setText(""+iSalary);
				 BankId.setText(""+loadId);
				JOptionPane.showMessageDialog(this, "Success !!!"); 
				searchField.setText("");
				 
				  flag=true;
				
				//Password.setText(iPassword);
		
				
			}
			if(!flag)
			{
				JOptionPane.showMessageDialog(this, "Enter Valid BankID");
				 searchField.setText("");
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
            catch(Exception ex){
				JOptionPane.showMessageDialog(this, "Oops !!!");
			}
        }
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}	