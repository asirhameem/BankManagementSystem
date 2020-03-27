import java.lang.*;
import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class  ForgetPassword extends JFrame implements ActionListener
{
	public JPanel panel;
	public JLabel bankid,nid,logolabel;
	public JTextField bankidField,nidField;
	public JButton submit,back;
	public ImageIcon logo;
	
	public ForgetPassword()
	{
		super("PASSWORD RECOVERY");
		this.setSize(800,600);
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
		
		int xAxis=200,yAxis=200,width=200,height=30;
		
		
		bankid=new JLabel("BANK ID");
		bankid.setBounds(xAxis,yAxis,width,height);
		bankid.setFont(myFont);
		bankid.setForeground(fontColor);
		panel.add(bankid);
		
		bankidField=new JTextField();
		bankidField.setBounds(xAxis+200,yAxis,width,height);
		bankidField.setFont(myFont);
		panel.add(bankidField);
		
		nid=new JLabel("NID");
		nid.setBounds(xAxis,yAxis+100,width,height);
		nid.setFont(myFont);
		nid.setForeground(fontColor);
		panel.add(nid);
		
		nidField=new JTextField();
		nidField.setBounds(xAxis+200,yAxis+100,width,height);
		nidField.setFont(myFont);
		panel.add(nidField);
		
		submit=new JButton("SUBMIT");
		submit.setBounds(xAxis,yAxis+200,width-80,height);
		submit.setFont(myFont);
		submit.setForeground(fontColor);
		submit.setBackground(buttonColColor);
		submit.addActionListener(this);
		panel.add(submit);
		
		
		back=new JButton("BACK");
		back.setBounds(xAxis+300,yAxis+300,width-100,height);
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
			Login login = new Login();
			login.setVisible(true);
			this.setVisible(false);
		}
		if(ae.getSource()== submit)
		{
			updateInDB();
			bankidField.setText("");
			nidField.setText("");
		}
	}
	
	
	
	
	public void updateInDB()
	{
		
		String loadId = bankidField.getText();
		String newNID =nidField.getText();
		String query = "INSERT INTO recovery VALUES ('"+loadId+"',"+newNID+");";	
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
