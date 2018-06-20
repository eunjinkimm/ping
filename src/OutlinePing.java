import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

import javax.net.ssl.ExtendedSSLSession;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JToolBar;
import javax.swing.border.BevelBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.SoftBevelBorder;

public class OutlinePing extends JFrame {

	public OutlinePing() {
		// Menu Begin
		JMenuBar menubar = new JMenuBar();
		
		setJMenuBar(menubar);		//add 메소드 대신 setMenuBar 사용
		
		JMenu scanMenu = new JMenu("Scan");
		JMenu goToMenu = new JMenu("Go to");
		JMenu commandsMenu = new JMenu("Commands");
		JMenu favoritesMenu = new JMenu("Favorites");
		JMenu toolsMenu = new JMenu("Tools");
		JMenu helpMenu = new JMenu("Help");
		
		menubar.add(scanMenu);
		menubar.add(goToMenu);
		menubar.add(commandsMenu);
		menubar.add(favoritesMenu);
		menubar.add(toolsMenu);
		menubar.add(helpMenu);
		
		JMenuItem loadFromFilesAction = new JMenuItem("Load from file...");
		JMenuItem exportAllAction = new JMenuItem("Export all...");
		JMenuItem exportSelectionAction = new JMenuItem("Export selection...");
		JMenuItem quitAction = new JMenuItem("Quit");
		
		scanMenu.add(loadFromFilesAction);
		scanMenu.add(exportAllAction);
		scanMenu.add(exportSelectionAction);
		scanMenu.addSeparator();
		scanMenu.add(quitAction);
		
		JMenuItem nextAliveHostAction = new JMenuItem("Next alive host");
		JMenuItem nextOpenPortAction = new JMenuItem("Next open port");
		JMenuItem nexDeadtHostAction = new JMenuItem("Next dead host");
		JMenuItem previousAliveHostAction = new JMenuItem("Previous alive host");
		JMenuItem previousOpenPortAction = new JMenuItem("Previous open port");
		JMenuItem previousDeadtHostAction = new JMenuItem("Previous dead host");
		JMenuItem findAction = new JMenuItem("Find...");
		
		goToMenu.add(nextAliveHostAction);
		goToMenu.add(nextOpenPortAction);
		goToMenu.add(nexDeadtHostAction);
		goToMenu.addSeparator();
		goToMenu.add(previousAliveHostAction);
		goToMenu.add(previousOpenPortAction);
		goToMenu.add(previousDeadtHostAction);
		goToMenu.addSeparator();
		goToMenu.add(findAction);
		
		JMenuItem showDetailsAction = new JMenuItem("Show details");
		JMenuItem rescanIPsAction = new JMenuItem("Rescan IP(s)");
		JMenuItem deleteIPsAction = new JMenuItem("Delete IP(s)");
		JMenuItem copyIPAction = new JMenuItem("Copy IP");
		JMenuItem copyDetailsAction = new JMenuItem("Copy details");
		JMenuItem openAction = new JMenuItem("Open");
		
		commandsMenu.add(showDetailsAction);
		commandsMenu.addSeparator();
		commandsMenu.add(rescanIPsAction);
		commandsMenu.add(deleteIPsAction);
		commandsMenu.addSeparator();
		commandsMenu.add(copyIPAction);
		commandsMenu.add(copyDetailsAction);
		commandsMenu.addSeparator();
		commandsMenu.add(openAction);
		
		JMenuItem addCurrentAction = new JMenuItem("Add current...");
		JMenuItem manageFavoritesAction = new JMenuItem("Manage favorites...");
		
		favoritesMenu.add(addCurrentAction);
		favoritesMenu.add(manageFavoritesAction);
		
		JMenuItem preferencesAction = new JMenuItem("Preferences...");
		JMenuItem fetchersAction = new JMenuItem("Fetchers...");
		JMenuItem selectionAction = new JMenuItem("Selection");
		JMenuItem scanStatisticsAction = new JMenuItem("Scan statistics");
		
		toolsMenu.add(preferencesAction);
		toolsMenu.add(fetchersAction);
		toolsMenu.addSeparator();
		toolsMenu.add(selectionAction);
		toolsMenu.add(scanStatisticsAction);
		
		JMenuItem gettingStartedAction = new JMenuItem("Getting Started");
		JMenuItem officialWebsiteAction = new JMenuItem("Official Website");
		JMenuItem FAQAction = new JMenuItem("FAQ");
		JMenuItem reportAnIssueAction = new JMenuItem("Report an issue");
		JMenuItem pluginsAction = new JMenuItem("Plugins");
		JMenuItem commandlineUsageAction = new JMenuItem("Command-line usage");
		JMenuItem checkForNewerVersionAction = new JMenuItem("Check for newer version...");
		JMenuItem aboutAction = new JMenuItem("About");
		
		helpMenu.add(gettingStartedAction);
		helpMenu.addSeparator();
		helpMenu.add(officialWebsiteAction);
		helpMenu.add(FAQAction);
		helpMenu.add(reportAnIssueAction);
		helpMenu.add(pluginsAction);
		helpMenu.addSeparator();
		helpMenu.add(commandlineUsageAction);
		helpMenu.addSeparator();
		helpMenu.add(checkForNewerVersionAction);
		helpMenu.addSeparator();
		helpMenu.add(aboutAction);
		
		quitAction.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		
		FAQAction.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					Runtime.getRuntime().exec("cmd.exe /c start chrome www.angryip.org/faq/");
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		
		officialWebsiteAction.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					Runtime.getRuntime().exec("cmd.exe /c start chrome www.angryip.org");
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		
		reportAnIssueAction.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					Runtime.getRuntime().exec("cmd.exe /c start chrome www.github.com/angryip/ipscan/issues");
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		
		pluginsAction.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					Runtime.getRuntime().exec("cmd.exe /c start chrome www.angryip.org/contribute/plugins.html");
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		
		addCurrentAction.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				JFrame jf = new JFrame("Add a favorite");
				setLayout(new FlowLayout());
				JPanel jp = new JPanel();
				JButton jb1 = new JButton("OK");
				JButton jb2 = new JButton("Cancle");
				jp.add(jb1);
				jp.add(jb2);
				jf.add(jp, BorderLayout.SOUTH);
				jf.setLocation(100, 150);
				jf.setSize(500, 200);
				jf.setVisible(true);
			}
		});
		// Mune End
		
		// Status bar Begin
		
		JPanel statusPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
		statusPanel.setBorder(new BevelBorder(BevelBorder.LOWERED));
		add(statusPanel, BorderLayout.SOUTH);
		JLabel readyLabel = new JLabel("Ready");
		readyLabel.setPreferredSize(new Dimension(250, 16));
		readyLabel.setBorder(new EtchedBorder(EtchedBorder.RAISED));
		JLabel displayLabel = new JLabel("Display: All");
		displayLabel.setPreferredSize(new Dimension(160, 16));
		displayLabel.setBorder(new EtchedBorder(EtchedBorder.RAISED));
		JLabel threadLabel = new JLabel("Thread: 0");
		threadLabel.setPreferredSize(new Dimension(180, 16));
		threadLabel.setBorder(new EtchedBorder(EtchedBorder.RAISED));
		
		statusPanel.add(readyLabel);
		statusPanel.add(displayLabel);
		statusPanel.add(threadLabel);
		
		// Status bar End
		
		// Table begin
		
		String[] titles = new String[] {
			"IP", "Ping", "Hostname", "TTL", "Ports [0+]"	
		};
		Object[][] stats = initTable();
		
		JTable jTable = new JTable(stats, titles);
		
		JScrollPane sp = new JScrollPane(jTable);
		add(sp, BorderLayout.CENTER);
		// Table end
		
		// Toolbar Begin
		
		Font myFont = new Font("Serif", Font.BOLD, 16);
		JToolBar toolbar1 = new JToolBar();
		toolbar1.setLayout(new FlowLayout(FlowLayout.LEFT));
		JToolBar toolbar2 = new JToolBar();
		toolbar2.setLayout(new FlowLayout(FlowLayout.LEFT));
		
		JLabel rangeStartLabel = new JLabel("IP Range: ");
		JTextField rangeStartTextField = new JTextField(15);
		JLabel rangeEndLabel = new JLabel("to ");
		JTextField rangeEndTextField = new JTextField(15);
		JComboBox IPRangeComboBox = new JComboBox();
		IPRangeComboBox.addItem("IP Range"); //IP 고정주소가 C급
		IPRangeComboBox.addItem("Random");
		IPRangeComboBox.addItem("Text File");
		JButton settingButton = new JButton();
		settingButton.setIcon(new ImageIcon("C:/Users/Administrator/Documents/NetworkExample/PingExample/src/seticon.png"));
		
		rangeStartLabel.setFont(myFont);
		rangeStartLabel.setPreferredSize(new Dimension(80, 30));
		rangeEndLabel.setFont(myFont);
		rangeEndLabel.setPreferredSize(new Dimension(20, 30));
		IPRangeComboBox.setPreferredSize(new Dimension(90, 30));
		settingButton.setFont(myFont);
		settingButton.setPreferredSize(new Dimension(30, 30));
		
		toolbar1.add(rangeStartLabel);
		toolbar1.add(rangeStartTextField);
		toolbar1.add(rangeEndLabel);
		toolbar1.add(rangeEndTextField);
		toolbar1.add(IPRangeComboBox);
		toolbar1.add(settingButton);
		
		JLabel hostNameLabel = new JLabel("Hostname: ");
		JTextField hostNameTextField = new JTextField(15);
		JButton upButton = new JButton("IP↑");
		JComboBox optionComboBox = new JComboBox();
		optionComboBox.addItem("Netmask");
		optionComboBox.addItem("/24");
		optionComboBox.addItem("/26");
		optionComboBox.addItem("/16");
		optionComboBox.addItem("255...192");
		optionComboBox.addItem("255...128");
		optionComboBox.addItem("255...0");
		optionComboBox.addItem("255...0.0");
		optionComboBox.addItem("255...0.0.0");
		JButton startButton = new JButton("▶ Start");
		JButton MenuButton = new JButton();
		MenuButton.setIcon(new ImageIcon("C:/Users/Administrator/Documents/NetworkExample/PingExample/src/menuicon.png"));
		
		hostNameLabel.setFont(myFont);
		hostNameTextField.setPreferredSize(new Dimension(90, 30));
		upButton.setPreferredSize(new Dimension(42, 30));
		optionComboBox.setPreferredSize(new Dimension(150, 30));
		startButton.setPreferredSize(new Dimension(90, 30));
		MenuButton.setFont(myFont);
		MenuButton.setPreferredSize(new Dimension(30, 30));
		
		toolbar2.add(hostNameLabel);
		toolbar2.add(hostNameTextField);
		toolbar2.add(upButton);
		toolbar2.add(optionComboBox);
		toolbar2.add(startButton);
		toolbar2.add(MenuButton);
		
		JPanel pane = new JPanel(new BorderLayout());
		pane.add(toolbar1, BorderLayout.NORTH);
		pane.add(toolbar2, BorderLayout.SOUTH);
		
		add(pane, BorderLayout.NORTH);
		
		// Toolbar End
		
		String myIp = null;
		String myHostname = null;
		try {
			InetAddress ia = InetAddress.getLocalHost();
			myIp = ia.getHostAddress();
			myHostname = ia.getHostName();
		} catch (Exception e) {
		}
		String fixedIp = myIp.substring(0, myIp.lastIndexOf(".") + 1);
		rangeStartTextField.setText(fixedIp + "1");
		rangeEndTextField.setText(fixedIp + "254");
		hostNameTextField.setText(myHostname);
		
		setSize(640, 640);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
		
		startButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				pinging[] pg = new pinging[254];
				// add
				for (int i = 0; i <= 253; i++) {
					pg[i] = new pinging(fixedIp+(i+1));
					pg[i].start();
				}
				
				for (int i = 0; i <= 253; i++) {
					Object[] msg = pg[i].getMsg();
					stats[i][0] = msg[0];
					if(msg[1] != null) {
						stats[i][1] = msg[1];
					} else {
						stats[i][1] = "[n/a]";
					}
					if(msg[2] != null) {
						stats[i][2] = msg[2];
					} else {
						stats[i][2] = "[n/s]";
					}
					if(msg[3] != null) {
						stats[i][3] = msg[3];
					} else {
						stats[i][3] = "[n/s]";
					}
					
				}
				for(int i = 0 ; i <= 253 ; i++) {
					Object[] msg = pg[i].getMsg();
					if(msg[1] != null || msg[2] != null || msg[3] != null) {
						final ExecutorService es = Executors.newFixedThreadPool(20);
						final String ip = (String) stats[i][0];
						final int timeout = 10;
						final List<Future<ScanResult>> futures = new ArrayList<>();
						//65535 , 1024
						for (int port = 1; port <=1024; port++) {
							futures.add(portIsOpen(es, ip, port, timeout));
						}
						try {
							es.awaitTermination(200L, TimeUnit.MILLISECONDS);
							int openPorts = 0;
							String openPortNumber = "";
							for (final Future<ScanResult> f : futures) {
								if (f.get().isOpen()) {
									openPorts++;
									openPortNumber= openPortNumber + f.get().getPort() + ", ";
								}
							}
							if(openPortNumber == ""){
								stats[i][4] = "[n/s]";
							} else{
								stats[i][4] = openPortNumber.substring(0, openPortNumber.length() - 2);
							} 
						} catch (Exception e2) {
							// TODO: handle exception
						}
					}
				}
				jTable.repaint();
			}
		});
	}
	
	public static Future<ScanResult> portIsOpen(final ExecutorService es, final String ip, final int port, final int timeout){
		return es.submit(new Callable<ScanResult>() {

			@Override
			public ScanResult call() {
				try {
					Socket socket = new Socket();
					socket.connect(new InetSocketAddress(ip, port), timeout);
					socket.close();
					return new ScanResult(port, true);
				} catch (IOException e) {
					return new ScanResult(port, false);
				}
			}
			
		});
	}
	
	public Object[][] initTable(){
		Object[][] result = new Object[254][5];
		return result;
	}
	
	public static void main(String[] args) {

		OutlinePing op = new OutlinePing();
		
	}

}
