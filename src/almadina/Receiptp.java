package almadina;

import javax.swing.JPanel;
import javax.swing.JScrollPane;

import java.awt.EventQueue;
import javax.swing.UIManager;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Font;
import javax.swing.JTextArea;
import java.awt.Insets;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


public class Receiptp extends JPanel {
	JTextArea receipt;
	String s,s1,s2,s3,s4,s5,s6,s7,s8,s9;
	/**
	 * Create the panel.
	 */
	

	public void receipt() {
		// TODO Auto-generated method stub
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Receiptp frame = new Receiptp();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		
	}
	public Receiptp() {
		setBackground(UIManager.getColor("DesktopIcon.background"));
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 315, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 1.0, 0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		receipt = new JTextArea();
		try {

			Class.forName("org.sqlite.JDBC");
			Connection conn=DriverManager.getConnection("jdbc:sqlite:memory.db");
			
			PreparedStatement ps = conn.prepareStatement("select * from almadina ");
			
			
			ResultSet rs =ps.executeQuery();
			while(rs.next()) {
				s = rs.getString(1);
				s1 = rs.getString(2);
				s2 = rs.getString(3);
				s3 = rs.getString(4);
				s4 = rs.getString(5);
				s5 = rs.getString(6);
				s6 = rs.getString(7);
				s7 = rs.getString(8);
				s8 = rs.getString(9);
				
			}
			JScrollPane scrollpane =new JScrollPane(receipt,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
			scrollpane.setAutoscrolls(true);
			receipt.setWrapStyleWord(true);
			receipt.setText(" ********************************************************* \n");
			receipt.setText(receipt.getText()+"                     AL MADINA MOBILES                   \n ");
			receipt.setText(receipt.getText()+"********************************************************* \n");
			
			
			receipt.setText(receipt.getText()+"Date & Time :"+"           "+s2+"\n");
			receipt.setText(receipt.getText()+"Ref No :"+"                    "+s1+"\n");
			receipt.setText(receipt.getText()+"Sales Man :"+"              "+s3+"\n");
			receipt.setText(receipt.getText()+"Customer Name :"+"    "+s4+"\n");
			receipt.setText(receipt.getText()+"Mobile Number :"+"       "+s5+"\n");
			receipt.setText(receipt.getText()+"Model Number :"+"         "+s6+"\n");
			receipt.setText(receipt.getText()+"imei :"+"                         "+s7+"\n");
			receipt.setText(receipt.getText()+"complaints :"+"              "+s8+"\n");
			
			receipt.setText(receipt.getText()+" ------------------------------------------------------------------- \n");
			receipt.setText(receipt.getText()+"                              THANK YOU ....                         \n");
			receipt.setText(receipt.getText()+" ------------------------------------------------------------------- \n");
			receipt.setText(receipt.getText()+"\n");
			receipt.setText(receipt.getText()+"Contact : +971527245544 \n");
			
			receipt.setLineWrap(true);
			receipt.setFont(new Font("Dialog", Font.PLAIN, 12));
			receipt.setEditable(false);
			
			GridBagConstraints gbc_receipt = new GridBagConstraints();
			gbc_receipt.insets = new Insets(0, 0, 5, 5);
			gbc_receipt.fill = GridBagConstraints.BOTH;
			gbc_receipt.gridx = 1;
			gbc_receipt.gridy = 1;
			add(scrollpane, gbc_receipt);
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}

	}
}
