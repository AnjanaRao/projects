import java.io.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
public class Login implements ActionListener
{
	ResultSet rs;
	Connection con;
	Statement st;
	JFrame fr;
	JLabel lusername,lpassword;
	JTextField txtusename;
	JTextField passwd;
	JButton bt;
	JPanel pn;
	public Login()
	{
		fr = new JFrame("User Login Page:");
		lusername = new JLabel("User_Name:");
		lpassword = new JLabel("Password:");
		txtusename = new JTextField(10);
		passwd = new JTextField(10);
		bt = new JButton("Login");
		pn = new JPanel(); 
		System.out.println("memories are insilized");
		connect();
		frame();
	}
	public void connect()
	{
		try
		{
			System.out.println("Connection Establishing.......!");
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost/ANJAN","root","");
			Statement st=con.createStatement();
			System.out.println("\n\nConnection Established");
		}
		catch(Exception e)
		{
			System.out.println("\n\nConnection Problem");
			//createMessageBox(e.getMessage());
		}
	}
	public void frame()
	{
		fr.setSize(1024,600);
		fr.setVisible(true);
		fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		pn.add(lusername);
		pn.add(txtusename);
		pn.add(lpassword);
		pn.add(passwd);
		pn.add(bt);

		fr.add(pn);

		bt.addActionListener(this);
	}
		public void actionPerformed(ActionEvent evt)
		{
				try
				{
					Class.forName("com.mysql.jdbc.Driver");
					Connection con=DriverManager.getConnection("jdbc:mysql://localhost/ANJAN","root","");
					Statement st=con.createStatement();
					int count=0;
					String user = txtusename.getText();
					String pass = passwd.getText();
					String sql="select username,password from Login where username = '"+user+"' and password = '"+pass+"' ";
					rs=st.executeQuery(sql);
					while(rs.next())
					{
						count= count+1;
					}
					if(count == 1)
					{
						JOptionPane.showMessageDialog(null,"User Found, ascess Difined");
					}
					else if(count>1)
					{
						JOptionPane.showMessageDialog(null,"more than one users");
					}
					else if(count==0)
					{
						JOptionPane.showMessageDialog(null,"No Users Found");
					}
				}
				catch(Exception e)
				{
					System.out.println("Exception occured");
				}
		}

	public static void main(String[] args)
	{
		Login lgobj = new Login(); 	
	}
}
