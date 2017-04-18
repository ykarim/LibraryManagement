package view;

import model.Users;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class MakeAdmin extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2481109695547632300L;
	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField passwordField;
	JButton btnCreateAdmin;

	/**
	 * Launch the application.
	 */
	public static void main() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MakeAdmin frame = new MakeAdmin();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public MakeAdmin() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(MakeAdmin.class.getResource("SuperBooks_bookshelf.jpg")));
		setTitle("Create Admin");
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 470, 190);
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblCreateAdmin = new JLabel("Create Admin");
		lblCreateAdmin.setHorizontalAlignment(SwingConstants.CENTER);
		lblCreateAdmin.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblCreateAdmin.setBounds(6, 6, 438, 39);
		contentPane.add(lblCreateAdmin);
		
		JSeparator separator = new JSeparator();
		separator.setForeground(Color.BLACK);
		separator.setBounds(6, 33, 438, 12);
		contentPane.add(separator);
		
		JLabel lblUsername = new JLabel("Username:");
		lblUsername.setBounds(6, 71, 106, 16);
		contentPane.add(lblUsername);
		
		textField = new JTextField();
		textField.setBounds(274, 65, 170, 28);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setBounds(6, 99, 124, 16);
		contentPane.add(lblPassword);
		
		passwordField = new JPasswordField();
		passwordField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent arg0) {
				if(arg0.getKeyCode()==KeyEvent.VK_ENTER){
					String name=textField.getText().trim();
					char[] pass=passwordField.getPassword();
					String password=new String(pass).trim();
					if(password.contains("/<>/")){
						JOptionPane.showMessageDialog(null, "Please remove /<>/ from your password and try again.");
					}else{
						Users.addAdmin(name, password);
						JOptionPane.showMessageDialog(null, "You have successfully created an admin. You may now login using this account. Remember your password.");
						dispose();
					}
				}
			}
		});
		passwordField.setBounds(274, 93, 170, 28);
		contentPane.add(passwordField);
		
		btnCreateAdmin = new JButton("Create Admin");
		btnCreateAdmin.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String name=textField.getText().trim();
				char[] pass=passwordField.getPassword();
				String password=new String(pass).trim();
				if(password.contains("/<>/")){
					JOptionPane.showMessageDialog(null, "Please remove /<>/ from your password and try again.");
				}else{
					Users.addAdmin(name, password);
					JOptionPane.showMessageDialog(null, "You have successfully created an admin. You may now login using this account. Remember your password.");
					/*
					Packet07AddAdmin p7=new Packet07AddAdmin(name,password);
					Main.serverSocket.sendDataToAllClients(p7.getData());
					*/
					dispose();
				}
			}
		});
		btnCreateAdmin.setBounds(147, 118, 129, 29);
		contentPane.add(btnCreateAdmin);
	}
}
