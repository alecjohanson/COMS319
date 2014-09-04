import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;


public class BasicGUI {

	public static void main(String[] args) {
		
		JFrame frame = new JFrame("HelloWorldSwing!");
	    frame.setSize(new Dimension(370, 220));
	    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	   
	    frame.setContentPane(createContainers());
	    
	    //frame.pack();
	    frame.setVisible(true);
	}
	
	static JPanel createContainers() {
			
			JPanel mainPanel = createMainPanel();
			
			JLabel exampleLabel = new JLabel("Hello World!");
			exampleLabel.setFont(getArialFont());
			exampleLabel.setForeground(Color.BLACK);
			
			JPanel topRow = createTopRow(exampleLabel);
			mainPanel.add(topRow);
			
			JPanel middleRow = createMiddleRow(exampleLabel);
			middleRow.setSize((new Dimension(370, -1)));
			mainPanel.add(middleRow);
			
			JPanel bottomRow = createBottomRow(exampleLabel);
			mainPanel.add(bottomRow);
			
			return mainPanel;
			
		}
	
	static JPanel createMainPanel()
	{
		JPanel mainPanel = new JPanel();		
		mainPanel.setLayout(new BoxLayout (mainPanel, BoxLayout.Y_AXIS));
		return mainPanel;
	}
	
	static JPanel createTopRow(final JLabel exampleLabel)
	{
		JPanel topRowPanel = new JPanel();
		topRowPanel.setLayout(new BoxLayout (topRowPanel, BoxLayout.X_AXIS));
		
		//Add Label
		JLabel label = new JLabel("Text: ");
		topRowPanel.add(label);
		
		//Add textField
		JTextField textField = new JTextField("Hello World!");
		textField.addActionListener(
		    		// This is an ANONYMOUS class
		    		new ActionListener() {
		    				@Override
						public void actionPerformed(ActionEvent e) {
		    					exampleLabel.setText(e.getActionCommand());
						}
		    		}
		    	);
		String[] sizes = {"tiny", "small", "medium", "large"};
		final JComboBox spinner = new JComboBox(sizes);
		spinner.addActionListener(
	    		// This is an ANONYMOUS class
	    		new ActionListener() {
	    				@Override
					public void actionPerformed(ActionEvent e) {
	    					exampleLabel.setFont(exampleLabel.getFont().deriveFont(getFontSize((String)spinner.getSelectedItem())));
					}
	    		}
	    	);
		
		topRowPanel.add(textField);
		topRowPanel.add(spinner);
		return topRowPanel;
	}
	
	static float getFontSize(String fontName)
	{
		if (fontName.equals("tiny"))
			return 8;
		else if (fontName.equals("small"))
			return 12;
		else if (fontName.equals("medium"))
			return 20;
		else 
			return 28;
	}
	
	static Font getArialFont()
	{
		return new Font("Arial", 0, 8);
	}
	
	static JPanel createMiddleRow(final JLabel exampleLabel)
	{
		JPanel container = new JPanel();
		container.setLayout(new BorderLayout());

		container.add(getRadioButtonPanel(exampleLabel), BorderLayout.LINE_START);
		container.add(exampleLabel, BorderLayout.CENTER);
		
		return container;
	}
	
	static JPanel getRadioButtonPanel(final JLabel exampleLabel)
	{
		JPanel panel = new JPanel();
		panel.setLayout(new BoxLayout (panel, BoxLayout.Y_AXIS));
		
		JRadioButton rb_plain = new JRadioButton("Plain");
		rb_plain.setSelected(true);
		rb_plain.addActionListener(
	    		// This is an ANONYMOUS class
	    		new ActionListener() {
	    				@Override
					public void actionPerformed(ActionEvent e) {
	    					exampleLabel.setFont(exampleLabel.getFont().deriveFont(Font.PLAIN));
					}
	    		}
	    	);
		
		JRadioButton rb_bold = new JRadioButton("Bold");
		rb_bold.addActionListener(
	    		// This is an ANONYMOUS class
	    		new ActionListener() {
	    				@Override
					public void actionPerformed(ActionEvent e) {
	    					exampleLabel.setFont(exampleLabel.getFont().deriveFont(Font.BOLD));
					}
	    		}
	    	);
		
		JRadioButton rb_italic = new JRadioButton("Italic");
		rb_italic.addActionListener(
	    		// This is an ANONYMOUS class
	    		new ActionListener() {
	    				@Override
					public void actionPerformed(ActionEvent e) {
	    					exampleLabel.setFont(exampleLabel.getFont().deriveFont(Font.ITALIC));
					}
	    		}
	    	);
		
		JRadioButton rb_bold_italic = new JRadioButton("Bold Italic");
		rb_bold_italic.addActionListener(
	    		// This is an ANONYMOUS class
	    		new ActionListener() {
	    				@Override
					public void actionPerformed(ActionEvent e) {
	    					exampleLabel.setFont(exampleLabel.getFont().deriveFont(Font.BOLD | Font.ITALIC));
					}
	    		}
	    	);
		
		 ButtonGroup group = new ButtonGroup();
		 group.add(rb_plain);
		 group.add(rb_bold);
		 group.add(rb_italic);
		 group.add(rb_bold_italic);

		 panel.add(rb_plain);
		 panel.add(rb_bold);
		 panel.add(rb_italic);
		 panel.add(rb_bold_italic);
		
		return panel;
	}
	
	static JPanel createBottomRow(final JLabel exampleLabel)
	{
		JPanel bottomRow = new JPanel();
		
		JButton btn_show = new JButton("Show!");
		btn_show.addActionListener(
	    		// This is an ANONYMOUS class
	    		new ActionListener() {
	    				@Override
					public void actionPerformed(ActionEvent e) {
	    					if (exampleLabel.getForeground().equals(Color.BLACK))
	    						exampleLabel.setForeground(Color.RED);
	    					else
	    						exampleLabel.setForeground(Color.BLACK);
					}
	    		}
	    	);
		bottomRow.add(btn_show);
		
		final JButton btn_close = new JButton("Close");
		btn_close.addActionListener(
	    		// This is an ANONYMOUS class
	    		new ActionListener() {
	    				@Override
					public void actionPerformed(ActionEvent e) {
	    					Container frame = btn_close.getParent();
	    		            do 
	    		                frame = frame.getParent(); 
	    		            while (!(frame instanceof JFrame));                                      
	    		            ((JFrame) frame).dispose();
					}
	    		}
	    	);
		bottomRow.add(btn_close);
		
		return bottomRow;
	}
}





























