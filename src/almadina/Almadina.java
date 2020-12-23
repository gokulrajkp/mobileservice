package almadina;

import java.awt.EventQueue;


import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import java.awt.Color;
import java.awt.Container;

import javax.swing.UIManager;


import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import javax.swing.JTextField;
import java.awt.Insets;
import javax.swing.JSeparator;
import javax.swing.JTextArea;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.print.PrinterException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import javax.swing.JButton;



import javax.swing.ImageIcon;
import java.awt.Cursor;
import java.awt.Toolkit;


public class Almadina {

	private JFrame frame;
	private final JPanel bg = new JPanel();
	private JTextField cust_name;
	private JTextField model_no;
	private JTextField mob_no;
	private JTextField imei;
	JTextArea complaints;
	JPanel headingpanel;
	JPanel sidepanel;
	JPanel search;
	JPanel working_p;
	JPanel home_p;
	JPanel search_p;
	JPanel print_p;
	
	String pdate;
	String s,s1,s2,s3,s4,s5,s6,s7,s8;
	String sal;
	JScrollPane scrollPane;
	private JTextField imei_s;
	private JTextField datetime_s;
	private JTextField refno_s;
	private JTextField salesman_s;
	private JTextField custname_s;
	private JTextField mobno_s;
	private JTextField model_s;
	JTextArea complaints_s;
	private JTextField date_time;
	private JTextField sales_man;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Almadina window = new Almadina();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Almadina() {
		initialize();
		
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage(Almadina.class.getResource("/almadina/img/images.jpeg")));
		frame.setBounds(80, 60, 1118, 660);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		bg.setBackground(UIManager.getColor("Desktop.background"));
		bg.setBounds(0, 0, 1120, 670);
		frame.getContentPane().add(bg);
		bg.setLayout(null);
		frame.setResizable(false);
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd hh:mm:ss");
		LocalDateTime now = LocalDateTime.now();
		pdate = dtf.format(now);
		
		frame.setTitle("NOOR ALWADI MOBILES");
		
		headingpanel = new JPanel();
		headingpanel.setBackground(new Color(153, 0, 255));
		headingpanel.setBounds(192, 40, 926, 110);
		bg.add(headingpanel);
		headingpanel.setLayout(null);
		
		JLabel lblAlMadinaMobiles = new JLabel("NOOR ALWADI MOBILES");
		lblAlMadinaMobiles.setForeground(new Color(255, 255, 255));
		lblAlMadinaMobiles.setFont(new Font("Caladea", Font.BOLD | Font.ITALIC, 24));
		lblAlMadinaMobiles.setBounds(269, 33, 302, 42);
		headingpanel.add(lblAlMadinaMobiles);
		
		JLabel lblQaulityBrilliance = new JLabel("qaulity brilliance...");
		lblQaulityBrilliance.setForeground(new Color(255, 255, 224));
		lblQaulityBrilliance.setFont(new Font("LM Roman Unslanted 10", Font.ITALIC, 18));
		lblQaulityBrilliance.setBounds(654, 67, 193, 31);
		headingpanel.add(lblQaulityBrilliance);
		
		
		working_p = new JPanel();
		working_p.setBackground(UIManager.getColor("ComboBox.disabledForeground"));
		working_p.setBounds(204, 162, 904, 466);
		bg.add(working_p);
		GridBagLayout gbl_working_p = new GridBagLayout();
		gbl_working_p.columnWidths = new int[]{215, 170, 78, 150, 147, 0};
		gbl_working_p.rowHeights = new int[]{30, 0, 10, 30, 30, 30, 30, 30, 265, 30, 0};
		gbl_working_p.columnWeights = new double[]{0.0, 1.0, 1.0, 0.0, 1.0, Double.MIN_VALUE};
		gbl_working_p.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		working_p.setLayout(gbl_working_p);
			
			JLabel lblDatetime = new JLabel("Date & Time :");
			lblDatetime.setFont(new Font("Dialog", Font.BOLD, 20));
			GridBagConstraints gbc_lblDatetime = new GridBagConstraints();
			gbc_lblDatetime.anchor = GridBagConstraints.EAST;
			gbc_lblDatetime.insets = new Insets(0, 0, 5, 5);
			gbc_lblDatetime.gridx = 0;
			gbc_lblDatetime.gridy = 1;
			working_p.add(lblDatetime, gbc_lblDatetime);
			
			date_time = new JTextField();
			date_time.setText(pdate);
			date_time.setFont(new Font("Dialog", Font.PLAIN, 18));
			date_time.setEditable(false);
			date_time.setColumns(10);
			GridBagConstraints gbc_date_time = new GridBagConstraints();
			gbc_date_time.insets = new Insets(0, 0, 5, 5);
			gbc_date_time.fill = GridBagConstraints.HORIZONTAL;
			gbc_date_time.gridx = 1;
			gbc_date_time.gridy = 1;
			working_p.add(date_time, gbc_date_time);
			
			JLabel lblSalesMan = new JLabel("Sales man :");
			lblSalesMan.setFont(new Font("Dialog", Font.BOLD, 20));
			GridBagConstraints gbc_lblSalesMan = new GridBagConstraints();
			gbc_lblSalesMan.anchor = GridBagConstraints.EAST;
			gbc_lblSalesMan.insets = new Insets(0, 0, 5, 5);
			gbc_lblSalesMan.gridx = 3;
			gbc_lblSalesMan.gridy = 1;
			working_p.add(lblSalesMan, gbc_lblSalesMan);
			
			sales_man = new JTextField();
			sales_man.setFont(new Font("Dialog", Font.PLAIN, 18));
			sales_man.setColumns(10);
			GridBagConstraints gbc_sales_man = new GridBagConstraints();
			gbc_sales_man.insets = new Insets(0, 0, 5, 0);
			gbc_sales_man.fill = GridBagConstraints.HORIZONTAL;
			gbc_sales_man.gridx = 4;
			gbc_sales_man.gridy = 1;
			sales_man.addKeyListener(new KeyAdapter() {
				public void keyTyped(KeyEvent e) {
					if(sales_man.getText().length() >=20)
						e.consume();
				}
			});
			working_p.add(sales_man, gbc_sales_man);
			JSeparator separator = new JSeparator();
			GridBagConstraints gbc_separator = new GridBagConstraints();
			gbc_separator.fill = GridBagConstraints.BOTH;
			gbc_separator.gridwidth = 5;
			gbc_separator.insets = new Insets(0, 0, 5, 0);
			gbc_separator.gridx = 0;
			gbc_separator.gridy = 2;
			working_p.add(separator, gbc_separator);
			
			JLabel lblCustomerDetails = new JLabel("CUSTOMER  DETAILS");
			lblCustomerDetails.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 20));
			GridBagConstraints gbc_lblCustomerDetails = new GridBagConstraints();
			gbc_lblCustomerDetails.gridwidth = 5;
			gbc_lblCustomerDetails.insets = new Insets(0, 0, 5, 0);
			gbc_lblCustomerDetails.gridx = 0;
			gbc_lblCustomerDetails.gridy = 3;
			working_p.add(lblCustomerDetails, gbc_lblCustomerDetails);
			
			JSeparator separator_1 = new JSeparator();
			separator_1.setForeground(new Color(0, 0, 205));
			GridBagConstraints gbc_separator_1 = new GridBagConstraints();
			gbc_separator_1.gridwidth = 5;
			gbc_separator_1.fill = GridBagConstraints.BOTH;
			gbc_separator_1.insets = new Insets(0, 0, 5, 0);
			gbc_separator_1.gridx = 0;
			gbc_separator_1.gridy = 4;
			working_p.add(separator_1, gbc_separator_1);
			
			JLabel lblCustomerName = new JLabel("Customer Name :");
			lblCustomerName.setFont(new Font("Dialog", Font.BOLD, 20));
			GridBagConstraints gbc_lblCustomerName = new GridBagConstraints();
			gbc_lblCustomerName.anchor = GridBagConstraints.EAST;
			gbc_lblCustomerName.insets = new Insets(0, 0, 5, 5);
			gbc_lblCustomerName.gridx = 0;
			gbc_lblCustomerName.gridy = 5;
			working_p.add(lblCustomerName, gbc_lblCustomerName);
			
			cust_name = new JTextField();
			cust_name.setFont(new Font("Dialog", Font.PLAIN, 18));
			cust_name.setColumns(10);
			GridBagConstraints gbc_cust_name = new GridBagConstraints();
			gbc_cust_name.fill = GridBagConstraints.BOTH;
			gbc_cust_name.insets = new Insets(0, 0, 5, 5);
			gbc_cust_name.gridx = 1;
			gbc_cust_name.gridy = 5;
			cust_name.addKeyListener(new KeyAdapter() {
				public void keyTyped(KeyEvent e) {
					if(cust_name.getText().length() >=20)
						e.consume();
				}
			});
			working_p.add(cust_name, gbc_cust_name);
			
			JLabel lblModelNo = new JLabel("Model no :");
			lblModelNo.setFont(new Font("Dialog", Font.BOLD, 20));
			GridBagConstraints gbc_lblModelNo = new GridBagConstraints();
			gbc_lblModelNo.anchor = GridBagConstraints.EAST;
			gbc_lblModelNo.insets = new Insets(0, 0, 5, 5);
			gbc_lblModelNo.gridx = 3;
			gbc_lblModelNo.gridy = 5;
			working_p.add(lblModelNo, gbc_lblModelNo);
			
			model_no = new JTextField();
			model_no.setFont(new Font("Dialog", Font.PLAIN, 18));
			model_no.setColumns(10);
			GridBagConstraints gbc_model_no = new GridBagConstraints();
			gbc_model_no.fill = GridBagConstraints.BOTH;
			gbc_model_no.insets = new Insets(0, 0, 5, 0);
			gbc_model_no.gridx = 4;
			gbc_model_no.gridy = 5;
			model_no.addKeyListener(new KeyAdapter() {
				public void keyTyped(KeyEvent e) {
					if(model_no.getText().length() >=20)
						e.consume();
				}
			});
			working_p.add(model_no, gbc_model_no);
			
			JLabel lblMobileNumber = new JLabel("Mobile Number :");
			lblMobileNumber.setFont(new Font("Dialog", Font.BOLD, 20));
			GridBagConstraints gbc_lblMobileNumber = new GridBagConstraints();
			gbc_lblMobileNumber.anchor = GridBagConstraints.EAST;
			gbc_lblMobileNumber.insets = new Insets(0, 0, 5, 5);
			gbc_lblMobileNumber.gridx = 0;
			gbc_lblMobileNumber.gridy = 6;
			working_p.add(lblMobileNumber, gbc_lblMobileNumber);
			
			mob_no = new JTextField();
			mob_no.setFont(new Font("Dialog", Font.PLAIN, 18));
			mob_no.setColumns(10);
			GridBagConstraints gbc_mob_no = new GridBagConstraints();
			gbc_mob_no.fill = GridBagConstraints.BOTH;
			gbc_mob_no.insets = new Insets(0, 0, 5, 5);
			gbc_mob_no.gridx = 1;
			gbc_mob_no.gridy = 6;
			mob_no.addKeyListener(new KeyAdapter() {
				public void keyTyped(KeyEvent e) {
					if(mob_no.getText().length() >=12)
						e.consume();
				}
			});
			working_p.add(mob_no, gbc_mob_no);
			
			JLabel lblimei = new JLabel("imei :");
			lblimei.setFont(new Font("Dialog", Font.BOLD, 20));
			GridBagConstraints gbc_lblimei = new GridBagConstraints();
			gbc_lblimei.anchor = GridBagConstraints.EAST;
			gbc_lblimei.insets = new Insets(0, 0, 5, 5);
			gbc_lblimei.gridx = 3;
			gbc_lblimei.gridy = 6;
			working_p.add(lblimei, gbc_lblimei);
			
			imei = new JTextField();
			imei.setFont(new Font("Dialog", Font.PLAIN, 18));
			imei.setColumns(10);
			GridBagConstraints gbc_imei = new GridBagConstraints();
			gbc_imei.fill = GridBagConstraints.BOTH;
			gbc_imei.insets = new Insets(0, 0, 5, 0);
			gbc_imei.gridx = 4;
			gbc_imei.gridy = 6;
			imei.addKeyListener(new KeyAdapter() {
				public void keyTyped(KeyEvent e) {
					if(imei.getText().length() >=15)
						e.consume();
				}
			});
			working_p.add(imei, gbc_imei);
			
			JLabel lblComplaints = new JLabel("Complaints");
			lblComplaints.setFont(new Font("Dialog", Font.BOLD, 20));
			GridBagConstraints gbc_lblComplaints = new GridBagConstraints();
			gbc_lblComplaints.gridwidth = 5;
			gbc_lblComplaints.insets = new Insets(0, 0, 5, 0);
			gbc_lblComplaints.gridx = 0;
			gbc_lblComplaints.gridy = 7;
			working_p.add(lblComplaints, gbc_lblComplaints);
			
			complaints = new JTextArea();
			complaints.setFont(new Font("Dialog", Font.PLAIN, 18));
			complaints.setBackground(UIManager.getColor("Desktop.background"));
			GridBagConstraints gbc_complaints = new GridBagConstraints();
			gbc_complaints.fill = GridBagConstraints.BOTH;
			gbc_complaints.gridwidth = 5;
			gbc_complaints.insets = new Insets(0, 0, 5, 0);
			gbc_complaints.gridx = 0;
			gbc_complaints.gridy = 8;
			complaints.addKeyListener(new KeyAdapter() {
				public void keyTyped(KeyEvent e) {
					if(complaints.getText().length() >=500)
						e.consume();
				}
			});
			complaints.setWrapStyleWord(true);
			complaints.setLineWrap(true);
			JScrollPane sc =new JScrollPane(complaints,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
			working_p.add(sc, gbc_complaints);
		
		sidepanel = new JPanel();
		sidepanel.setBackground(new Color(51, 0, 102));
		sidepanel.setBounds(0, 0, 192, 630);
		bg.add(sidepanel);
		sidepanel.setLayout(null);
		
		
		home_p = new JPanel();
		home_p.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		
		home_p.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				setColor(home_p);
				resetColor(search_p);
				resetColor(print_p);
				
				working_p.setVisible(true);
				search.setVisible(false);
				scrollPane.setVisible(false);
				
				
			}
		});
		
		home_p.setBackground(new Color(102, 0, 153));
		home_p.setBounds(12, 70, 162, 33);
		sidepanel.add(home_p);
		home_p.setLayout(null);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(Almadina.class.getResource("/almadina/img/home.png")));
		label.setBounds(12, 3, 40, 27);
		home_p.add(label);
		
		JLabel lblHome = new JLabel("HOME");
		lblHome.setForeground(new Color(255, 255, 255));
		lblHome.setBounds(60, 5, 70, 27);
		home_p.add(lblHome);
		
		
		
		
		
		
	
	
		
	
		scrollPane = new JScrollPane();
		scrollPane.setAutoscrolls(true);
		scrollPane.setBackground(UIManager.getColor("ComboBox.selectionBackground"));
		scrollPane.setBounds(480, 162, 360, 466);
		bg.add(scrollPane);
		

		JInternalFrame internalFrame = new JInternalFrame("New JInternalFrame");
		print_p = new JPanel();
		print_p.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		print_p.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				setColor(print_p);
				resetColor(home_p);
				resetColor(search_p);
				
				if(date_time.getText().equals("")||sales_man.getText().equals("")||cust_name.getText().equals("")||mob_no.getText().equals("")||
						model_no.getText().equals("")||imei.getText().equals("")||complaints.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Enter the details!!!!");
					working_p.setVisible(true);
					search.setVisible(false);
					scrollPane.setVisible(true);
					
				}else {
					
					try {
						Class.forName("org.sqlite.JDBC");
						Connection conn = DriverManager.getConnection("jdbc:sqlite:memory.db");
						
						PreparedStatement ps = conn.prepareStatement("insert into almadina(date_,sales_man,cust_name,mob_no,model_name,imei,symptoms)"
								+ " values (?,?,?,?,?,?,?)");
						ps.setString(1, date_time.getText());
						ps.setString(2, sales_man.getText());
						ps.setString(3, cust_name.getText());
						ps.setString(4, mob_no.getText());
						ps.setString(5, model_no.getText());
						ps.setString(6, imei.getText());
						ps.setString(7, complaints.getText());
						
						
						ps.executeUpdate();
					
						conn.close();
						
						working_p.setVisible(false);
						search.setVisible(false);
						scrollPane.setVisible(true);
						Receiptp rct = new Receiptp();
						if(internalFrame !=null) {
							 internalFrame.dispose();
			                    rct.invalidate();
			                    rct.revalidate();
			                    rct.repaint();
			                }
						 internalFrame.setTitle("Receipt");
						 internalFrame.setBorder(null);
						
			                scrollPane.setViewportView(internalFrame);
			                Container contentPane = internalFrame.getContentPane();
			                contentPane.removeAll();
			                contentPane.add( rct );
			                contentPane.revalidate();
			                contentPane.repaint();
			                internalFrame.setVisible(true);
						
			                Receiptp rc=new Receiptp();
			                try {
								rc.receipt.print();
							} catch (PrinterException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
						
					} catch (Exception e2) {
						// TODO: handle exception
						JOptionPane.showMessageDialog(null, "current imei exist");
					}
				}
				
				
			}
		});

		print_p.setBackground(new Color(102, 0, 153));
		print_p.setBounds(12, 237, 162, 33);
		print_p.setLayout(null);
		
		JLabel label_2 = new JLabel("");
		label_2.setIcon(new ImageIcon(Almadina.class.getResource("/almadina/img/printer.png")));
		label_2.setBounds(12, 3, 40, 27);
		print_p.add(label_2);
		
		JLabel lblPrint = new JLabel("PRINT");
		lblPrint.setForeground(new Color(255, 255, 255));
		lblPrint.setBounds(60, 12, 70, 15);
		print_p.add(lblPrint);
		
	
		
		search_p = new JPanel();
		search_p.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		search_p.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				setColor(search_p);
				resetColor(home_p);
				resetColor(print_p);
				
				working_p.setVisible(false);
				search.setVisible(true);
				scrollPane.setVisible(false);
			}
		});
		search_p.setBackground(new Color(102, 0, 153));
		search_p.setBounds(12, 155, 162, 33);
		sidepanel.add(search_p);
		search_p.setLayout(null);
		
		JLabel label_1 = new JLabel("");
		label_1.setIcon(new ImageIcon(Almadina.class.getResource("/almadina/img/search.png")));
		label_1.setBounds(12, 3, 40, 27);
		search_p.add(label_1);
		
		JLabel lblSearch = new JLabel("SEARCH");
		lblSearch.setForeground(new Color(255, 255, 255));
		lblSearch.setBounds(60, 10, 70, 15);
		search_p.add(lblSearch);
		sidepanel.add(print_p);
		
		JLabel lblgokulraj = new JLabel("_goku_l_raj");
		lblgokulraj.setBounds(55, 603, 89, 15);
		sidepanel.add(lblgokulraj);
		
			
			JButton btnSearch = new JButton("SEARCH");
			btnSearch.setBorder(UIManager.getBorder("DesktopIcon.border"));
			btnSearch.setOpaque(false);
			btnSearch.setFont(new Font("Roboto Slab", Font.BOLD, 14));
			btnSearch.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					if(imei_s.getText().equals("")) {
						JOptionPane.showMessageDialog(null, "Enter valid imei"); 
						
						
					}else {
						
					
					try {
						String str = imei_s.getText();
						
						Class.forName("org.sqlite.JDBC");				
						Connection con= DriverManager.getConnection("jdbc:sqlite:memory.db");
						PreparedStatement st = con.prepareStatement("SELECT * FROM almadina WHERE imei = ? ");
						st.setString(1, str);
			
						ResultSet rs = st.executeQuery();
						if(rs.next()) {
							//String s= rs.getString(1);
							String s1= rs.getString(2);
							String s2= rs.getString(3);
							String s3= rs.getString(4);
							String s4= rs.getString(5);
							String s5= rs.getString(6);
							String s6= rs.getString(7);
							//String s7= rs.getString(8);
							String s8= rs.getString(9);
							
							
							
							datetime_s.setText(s2);
							refno_s.setText(s1);
							salesman_s.setText(s3);
							custname_s.setText(s4);
							mobno_s.setText(s5);
							model_s.setText(s6);
							complaints_s.setText(s8);
						
						} else {  
			                JOptionPane.showMessageDialog(null, "Data not Found");  
			            }  
						con.close();
					} catch (Exception e) {
						// TODO: handle exception
						System.out.println(e);
					}
					}
				}	
			
			});
			
			search = new JPanel();
			search.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			search.setBackground(UIManager.getColor("DesktopIcon.background"));
			search.setBounds(204, 162, 904, 466);
			bg.add(search);
			search.setLayout(null);
			
			JPanel panel = new JPanel();
			panel.setBackground(UIManager.getColor("ComboBox.disabledForeground"));
			panel.setBounds(171, 0, 590, 466);
			search.add(panel);
			GridBagLayout gbl_panel = new GridBagLayout();
			gbl_panel.columnWidths = new int[]{161, 0, 90, 0};
			gbl_panel.rowHeights = new int[]{25, 0, 25, 25, 25, 25, 25, 0, 226, 0};
			gbl_panel.columnWeights = new double[]{0.0, 1.0, 0.0, Double.MIN_VALUE};
			gbl_panel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
			panel.setLayout(gbl_panel);
			
			JLabel lblIemi = new JLabel("imei :");
			lblIemi.setFont(new Font("Roboto Slab", Font.BOLD, 18));
			GridBagConstraints gbc_lblIemi = new GridBagConstraints();
			gbc_lblIemi.fill = GridBagConstraints.VERTICAL;
			gbc_lblIemi.insets = new Insets(0, 0, 5, 5);
			gbc_lblIemi.anchor = GridBagConstraints.EAST;
			gbc_lblIemi.gridx = 0;
			gbc_lblIemi.gridy = 0;
			panel.add(lblIemi, gbc_lblIemi);
			
			imei_s = new JTextField();
			imei_s.setFont(new Font("Dialog", Font.PLAIN, 18));
			imei_s.setColumns(10);
			imei_s.addKeyListener(new KeyAdapter() {
				public void keyTyped(KeyEvent e) {
					if(imei_s.getText().length() >=15)
						e.consume();
				}
			});
			GridBagConstraints gbc_imei_s = new GridBagConstraints();
			gbc_imei_s.insets = new Insets(0, 0, 5, 5);
			gbc_imei_s.fill = GridBagConstraints.BOTH;
			gbc_imei_s.gridx = 1;
			gbc_imei_s.gridy = 0;
			panel.add(imei_s, gbc_imei_s);
			GridBagConstraints gbc_btnSearch = new GridBagConstraints();
			gbc_btnSearch.anchor = GridBagConstraints.WEST;
			gbc_btnSearch.insets = new Insets(0, 0, 5, 0);
			gbc_btnSearch.gridx = 2;
			gbc_btnSearch.gridy = 0;
			panel.add(btnSearch, gbc_btnSearch);
			
			JSeparator separator_2 = new JSeparator();
			separator_2.setBackground(Color.BLACK);
			GridBagConstraints gbc_separator_2 = new GridBagConstraints();
			gbc_separator_2.gridwidth = 3;
			gbc_separator_2.fill = GridBagConstraints.BOTH;
			gbc_separator_2.insets = new Insets(0, 0, 5, 0);
			gbc_separator_2.gridx = 0;
			gbc_separator_2.gridy = 1;
			panel.add(separator_2, gbc_separator_2);
			
			JLabel lblDatetime_1 = new JLabel("Date&Time :");
			lblDatetime_1.setFont(new Font("Roboto Slab", Font.BOLD, 18));
			GridBagConstraints gbc_lblDatetime_1 = new GridBagConstraints();
			gbc_lblDatetime_1.fill = GridBagConstraints.VERTICAL;
			gbc_lblDatetime_1.anchor = GridBagConstraints.EAST;
			gbc_lblDatetime_1.insets = new Insets(0, 0, 5, 5);
			gbc_lblDatetime_1.gridx = 0;
			gbc_lblDatetime_1.gridy = 2;
			panel.add(lblDatetime_1, gbc_lblDatetime_1);
			
			datetime_s = new JTextField();
			datetime_s.setFont(new Font("Dialog", Font.PLAIN, 18));
			datetime_s.setEditable(false);
			datetime_s.setColumns(10);
			GridBagConstraints gbc_datetime_s = new GridBagConstraints();
			gbc_datetime_s.insets = new Insets(0, 0, 5, 5);
			gbc_datetime_s.fill = GridBagConstraints.BOTH;
			gbc_datetime_s.gridx = 1;
			gbc_datetime_s.gridy = 2;
			panel.add(datetime_s, gbc_datetime_s);
			
			JLabel lblRefno = new JLabel("Ref.No :");
			lblRefno.setFont(new Font("Roboto Slab", Font.BOLD, 18));
			GridBagConstraints gbc_lblRefno = new GridBagConstraints();
			gbc_lblRefno.fill = GridBagConstraints.VERTICAL;
			gbc_lblRefno.anchor = GridBagConstraints.EAST;
			gbc_lblRefno.insets = new Insets(0, 0, 5, 5);
			gbc_lblRefno.gridx = 0;
			gbc_lblRefno.gridy = 3;
			panel.add(lblRefno, gbc_lblRefno);
			
			refno_s = new JTextField();
			refno_s.setFont(new Font("Dialog", Font.PLAIN, 18));
			refno_s.setEditable(false);
			refno_s.setColumns(10);
			GridBagConstraints gbc_refno_s = new GridBagConstraints();
			gbc_refno_s.insets = new Insets(0, 0, 5, 5);
			gbc_refno_s.fill = GridBagConstraints.BOTH;
			gbc_refno_s.gridx = 1;
			gbc_refno_s.gridy = 3;
			panel.add(refno_s, gbc_refno_s);
			
			JLabel lblSalesman = new JLabel(" SalesMan :");
			lblSalesman.setFont(new Font("Roboto Slab", Font.BOLD, 18));
			GridBagConstraints gbc_lblSalesman = new GridBagConstraints();
			gbc_lblSalesman.fill = GridBagConstraints.VERTICAL;
			gbc_lblSalesman.anchor = GridBagConstraints.EAST;
			gbc_lblSalesman.insets = new Insets(0, 0, 5, 5);
			gbc_lblSalesman.gridx = 0;
			gbc_lblSalesman.gridy = 4;
			panel.add(lblSalesman, gbc_lblSalesman);
			
			salesman_s = new JTextField();
			salesman_s.setFont(new Font("Dialog", Font.PLAIN, 18));
			salesman_s.setEditable(false);
			salesman_s.setColumns(10);
			GridBagConstraints gbc_salesman_s = new GridBagConstraints();
			gbc_salesman_s.insets = new Insets(0, 0, 5, 5);
			gbc_salesman_s.fill = GridBagConstraints.BOTH;
			gbc_salesman_s.gridx = 1;
			gbc_salesman_s.gridy = 4;
			panel.add(salesman_s, gbc_salesman_s);
			
			JLabel lblCustomername = new JLabel("CustomerName :");
			lblCustomername.setFont(new Font("Roboto Slab", Font.BOLD, 18));
			GridBagConstraints gbc_lblCustomername = new GridBagConstraints();
			gbc_lblCustomername.fill = GridBagConstraints.VERTICAL;
			gbc_lblCustomername.anchor = GridBagConstraints.EAST;
			gbc_lblCustomername.insets = new Insets(0, 0, 5, 5);
			gbc_lblCustomername.gridx = 0;
			gbc_lblCustomername.gridy = 5;
			panel.add(lblCustomername, gbc_lblCustomername);
			
			custname_s = new JTextField();
			custname_s.setFont(new Font("Dialog", Font.PLAIN, 18));
			custname_s.setEditable(false);
			custname_s.setColumns(10);
			GridBagConstraints gbc_custname_s = new GridBagConstraints();
			gbc_custname_s.insets = new Insets(0, 0, 5, 5);
			gbc_custname_s.fill = GridBagConstraints.BOTH;
			gbc_custname_s.gridx = 1;
			gbc_custname_s.gridy = 5;
			panel.add(custname_s, gbc_custname_s);
			
			JLabel lblMobilenumber = new JLabel("MobileNumber :");
			lblMobilenumber.setFont(new Font("Roboto Slab", Font.BOLD, 18));
			GridBagConstraints gbc_lblMobilenumber = new GridBagConstraints();
			gbc_lblMobilenumber.fill = GridBagConstraints.VERTICAL;
			gbc_lblMobilenumber.anchor = GridBagConstraints.EAST;
			gbc_lblMobilenumber.insets = new Insets(0, 0, 5, 5);
			gbc_lblMobilenumber.gridx = 0;
			gbc_lblMobilenumber.gridy = 6;
			panel.add(lblMobilenumber, gbc_lblMobilenumber);
			
			mobno_s = new JTextField();
			mobno_s.setFont(new Font("Dialog", Font.PLAIN, 18));
			mobno_s.setEditable(false);
			mobno_s.setColumns(10);
			GridBagConstraints gbc_mobno_s = new GridBagConstraints();
			gbc_mobno_s.insets = new Insets(0, 0, 5, 5);
			gbc_mobno_s.fill = GridBagConstraints.BOTH;
			gbc_mobno_s.gridx = 1;
			gbc_mobno_s.gridy = 6;
			panel.add(mobno_s, gbc_mobno_s);
			
			JLabel lblModel = new JLabel("Model :");
			lblModel.setFont(new Font("Roboto Slab", Font.BOLD, 18));
			GridBagConstraints gbc_lblModel = new GridBagConstraints();
			gbc_lblModel.fill = GridBagConstraints.VERTICAL;
			gbc_lblModel.anchor = GridBagConstraints.EAST;
			gbc_lblModel.insets = new Insets(0, 0, 5, 5);
			gbc_lblModel.gridx = 0;
			gbc_lblModel.gridy = 7;
			panel.add(lblModel, gbc_lblModel);
			
			model_s = new JTextField();
			model_s.setFont(new Font("Dialog", Font.PLAIN, 18));
			model_s.setEditable(false);
			model_s.setColumns(10);
			GridBagConstraints gbc_model_s = new GridBagConstraints();
			gbc_model_s.insets = new Insets(0, 0, 5, 5);
			gbc_model_s.fill = GridBagConstraints.BOTH;
			gbc_model_s.gridx = 1;
			gbc_model_s.gridy = 7;
			panel.add(model_s, gbc_model_s);
			
			JLabel lblComplaints_1 = new JLabel("Complaints :");
			lblComplaints_1.setFont(new Font("Roboto Slab", Font.BOLD, 18));
			GridBagConstraints gbc_lblComplaints_1 = new GridBagConstraints();
			gbc_lblComplaints_1.anchor = GridBagConstraints.NORTHEAST;
			gbc_lblComplaints_1.insets = new Insets(0, 0, 0, 5);
			gbc_lblComplaints_1.gridx = 0;
			gbc_lblComplaints_1.gridy = 8;
			panel.add(lblComplaints_1, gbc_lblComplaints_1);
			
			complaints_s = new JTextArea();
			complaints_s.setFont(new Font("Dialog", Font.PLAIN, 18));
			complaints_s.setWrapStyleWord(true);
			complaints_s.setLineWrap(true);
			complaints_s.setEditable(false);
			complaints_s.setWrapStyleWord(true);
			complaints_s.setLineWrap(true);
			JScrollPane sccomp =new JScrollPane(complaints_s,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
			GridBagConstraints gbc_complaints_s = new GridBagConstraints();
			gbc_complaints_s.gridwidth = 2;
			gbc_complaints_s.fill = GridBagConstraints.BOTH;
			gbc_complaints_s.gridx = 1;
			gbc_complaints_s.gridy = 8;
			panel.add(sccomp, gbc_complaints_s);
		
		
		
	}
	void setColor(JPanel panel) {
		panel.setBackground(new Color(102,0,204));
	}
	void resetColor(JPanel panel) {
		panel.setBackground(new Color(102,0,153));
	}
}
