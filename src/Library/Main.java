package Library;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.border.EmptyBorder;

import net.LibServer;

public class Main extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	public static LibServer serverSocket;
	public JLabel lblRunning;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					if(isInternetReachable()){
						Main frame = new Main();
						frame.setVisible(true);
					}else{
						JOptionPane.showMessageDialog(null, "Please connect to the internet and try again.");
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Main() {
		readSavedFile();
		setResizable(false);
		setTitle("Library Server");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 480, 220);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Library Server");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(86, 11, 292, 25);
		contentPane.add(lblNewLabel);
		
		JLabel labelip = new JLabel("Your IP Address is:");
		labelip.setFont(new Font("Times New Roman", Font.BOLD, 15));
		labelip.setBounds(10, 65, 200, 50);
		contentPane.add(labelip);
		
		JLabel labelIPAddress = new JLabel("");
		labelIPAddress.setHorizontalAlignment(SwingConstants.CENTER);
		labelIPAddress.setBounds(264, 65, 200, 44);
		contentPane.add(labelIPAddress);
		try {
			labelIPAddress.setText(getIp());
			
			JButton btnStartServer = new JButton("Start Server");
			btnStartServer.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					Thread t = new Thread(new Runnable() {
					    public void run() {
					    	/*
					    	Thread x= new Thread(new Runnable() {
					    		public void run(){
					    			 for(;;){
								    	System.out.println(Users.admins);
								    	System.out.println(Users.adminPasswords);
								    	System.out.println(Book.libraryBooks);
								    }
					    		}
					    	});
					    	x.start();
					    	*/
					    	
					    	lblRunning.setText("Running");
					    	lblRunning.setForeground(Color.GREEN);
					    	btnStartServer.setEnabled(false);

					    	try{
					    		serverSocket=new LibServer();
					    		serverSocket.libServer();
					    		try{
					    			serverSocket.run();
					    		
					    		}catch(Exception e){
					    			
					    		}
					    	}catch(Exception e){
					    		JOptionPane.showMessageDialog(null, "Cannot start server. Please try again. Error: "+e.toString());
					    		lblRunning.setForeground(Color.RED);
					    		lblRunning.setText("Not Running");
					    	}
					       SwingUtilities.invokeLater(new Runnable() {
					           public void run() { 	   
					        	  
					           }
					       });
					    }
					 });
					 t.start();
					
				}

				
			});
			btnStartServer.setBounds(86, 140, 120, 23);
			contentPane.add(btnStartServer);
			
			JButton btnStopServer = new JButton(" Stop Server");
			btnStopServer.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					try{
						serverSocket.interrupt();
						lblRunning.setForeground(Color.red);
						lblRunning.setText("Not Running");
						btnStartServer.setEnabled(true);
					}catch(Exception e){
						
					}
				}
			});
			btnStopServer.setBounds(216, 140, 120, 23);
			contentPane.add(btnStopServer);
			
			JLabel lblStatus = new JLabel("Status:");
			lblStatus.setFont(new Font("Times New Roman", Font.BOLD, 15));
			lblStatus.setBounds(10, 106, 46, 14);
			contentPane.add(lblStatus);
			
			lblRunning = new JLabel("");
			lblRunning.setHorizontalAlignment(SwingConstants.CENTER);
			lblRunning.setBounds(264, 107, 200, 14);
			contentPane.add(lblRunning);
			lblRunning.setText("Not Running");
			lblRunning.setForeground(Color.RED);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(this, "Error Getting IP Address. Please check your interent connection.");
			System.err.println("Error Getting IP Address. Please check your interent connection.");
			e.printStackTrace();
		}
		
	}
	
	 public static String getIp() throws Exception {
	        URL whatismyip = new URL("http://checkip.amazonaws.com");
	        BufferedReader in = null;
	        try {
	            in = new BufferedReader(new InputStreamReader(
	                    whatismyip.openStream()));
	            String ip = in.readLine();
	            return ip;
	        } finally {
	            if (in != null) {
	                try {
	                    in.close();
	                } catch (IOException e) {
	                    e.printStackTrace();
	                }
	            }
	        }
	    }
	 
	 public static boolean isInternetReachable()
	    {
	        try {
	            //make a URL to a known source
	            URL url = new URL("http://www.google.com");

	            //open a connection to that source
	            HttpURLConnection urlConnect = (HttpURLConnection)url.openConnection();

	            //trying to retrieve data from the source. If there
	            //is no connection, this line will fail
	            @SuppressWarnings("unused")
				Object objData = urlConnect.getContent();

	        } catch (Exception e) {              
	            e.printStackTrace();
	            return false;
	        }

	        return true;
	    }
	 
	 public void readSavedFile(){
			addWindowListener(new WindowAdapter() {
			    @Override
				public void windowClosing(WindowEvent e) {
			    	final File file=new File(System.getProperty("user.home")+"/configUser.properties");
			    	file.delete();
			    	final File file1=new File(System.getProperty("user.home")+"/configBook.properties");
			    	file1.delete();
			        Import_Export.saveBookSetting();
			        Import_Export.saveUserSettings();
			    }
			  
			    @Override
				public void windowOpened(WindowEvent e) {
			        Import_Export.readSettings();
			    }
			});
		}
}
