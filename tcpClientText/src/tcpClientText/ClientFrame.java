package tcpClientText;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class ClientFrame extends JFrame implements ActionListener{

	private static final long serialVersionUID = 1L;
	
	JLabel lblServerCountText;
	JLabel lblStatusValue;
	JTextField txtUserIn;
	JLabel lblStringValue;
	JButton btnCount ;
	int width = 700;
	int height = 200;
	
	public ClientFrame() {
		
		this.setLayout(new BorderLayout());
		this.setTitle("TCP Application: Count words in String");
		this.setSize(width, height);
		
		this.setLocationRelativeTo(null);
		txtUserIn = new JTextField(200);
		btnCount = new JButton("Count words");
		lblServerCountText = new JLabel("-");
		lblStringValue = new JLabel("-");
		lblStatusValue = new JLabel("-");
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		loadComponent();
		
		btnCount.addActionListener(this);
	
	}
	
	public void updateServerText (String serverTextCount) {
		
		this.lblServerCountText.setText(serverTextCount);
		
	}
	
	public void updateConnectionStatus (boolean connStatus) {
		

		// Default status. Assuming for the worst case scenario.
		String status = "No connection to server.";
		
		// Validate status of connection
		if (connStatus)
			status = "Connection has established.";
		// Update the status on frame
		this.lblStatusValue.setText(status);
	}
	
	private JPanel getServerCountPanel(Font font) {
		
		// Create component to display date retrieve from the server
		JPanel panel = new JPanel();
		JLabel lblCount = new JLabel ("Count (from Server): ");

		// Style the component
		lblCount.setFont(font);
		lblServerCountText.setFont(font);
		lblCount.setBackground(Color.WHITE);
		lblCount.setOpaque(true);
		lblServerCountText.setBackground(Color.WHITE);
		lblServerCountText.setOpaque(true);

		// Organize components into panel
		panel.add(lblCount);
		panel.add(lblServerCountText);
		
		return panel;
	} 
	
	private void loadComponent() {
		
		
		Font font = this.getFontStyle();
		
		// Get server status's panel and add to frame
		JPanel northPanel = this.loadNorthComponents(font);		
		this.add(northPanel, BorderLayout.NORTH);
		
		// Get server date's panel and add to frame
		JPanel center = getServerCountPanel(font);
		this.add(center, BorderLayout.CENTER);
		
	}
	
	private JPanel loadNorthComponents(Font font) {

		// Create components
		JPanel northPanel = new JPanel();
		JLabel label = new JLabel("Enter String: ");
		
		// Add to panel
		northPanel.add(label);
		northPanel.add(txtUserIn);
		northPanel.add(btnCount);
		
		return northPanel;
	}

	private Font getFontStyle() {
	
	Font font = new Font ("Serif", Font.PLAIN, 30);
	
	return font;
	}
	
	@Override
	/**
	 * Process user request
	 */
	public void actionPerformed(ActionEvent e) {
		
		String wordtocount = txtUserIn.getText();
		// Display word count.
		
		
		
	}

	
}
