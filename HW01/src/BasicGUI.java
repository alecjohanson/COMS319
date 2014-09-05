import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.border.Border;


public class BasicGUI
{

	public static void main(String[] args)
	{

		JFrame frame = new JFrame("HelloWorldSwing!");
		frame.setSize(new Dimension(370, 220));
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		frame.setContentPane(createContainers());

		//frame.pack();
		frame.setVisible(true);
	}

	static JPanel createContainers()
	{
		JLabel displayedText = new JLabel("Hello World!");
		displayedText.setFont(getArialFont());
		displayedText.setForeground(Color.BLACK);
		
		JPanel mainPanel = createMainPanel();
		JPanel topRow = createTopRow(displayedText);
		JPanel middleRow = createMiddleRowPanel(displayedText);
		JPanel bottomRow = createBottomRow(displayedText);

		middleRow.setSize((new Dimension(370, -1)));
		
		mainPanel.add(topRow);
		mainPanel.add(middleRow);
		mainPanel.add(bottomRow);

		return mainPanel;

	}

	static JPanel createMainPanel()
	{
		JPanel mainPanel = new JPanel();
		mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
		return mainPanel;
	}

	static JPanel createTopRow(final JLabel exampleLabel)
	{
		JPanel topRowPanel = new JPanel();
		Border paddingBorder = BorderFactory.createEmptyBorder(10, 10, 0, 10);
		
		topRowPanel.setBorder(paddingBorder);
		topRowPanel.setLayout(new BoxLayout(topRowPanel, BoxLayout.X_AXIS));

		//Add Label
		JLabel label = new JLabel("Text: ");
		topRowPanel.add(label);

		//Add textField
		JTextField textField = new JTextField("Hello World!");
		textField.addActionListener(
			// This is an ANONYMOUS class
			new ActionListener()
			{
				@Override
				public void actionPerformed(ActionEvent e)
				{
					exampleLabel.setText(e.getActionCommand());
				}
			}
		);
		
		//Add comboBox for size selection
		String[] sizes = {"tiny", "small", "medium", "large"};
		final JComboBox sizeSelector = new JComboBox(sizes);
		sizeSelector.addActionListener(
			// This is an ANONYMOUS class
			new ActionListener()
			{
				@Override
				public void actionPerformed(ActionEvent e)
				{
					exampleLabel.setFont(exampleLabel.getFont().deriveFont(getFontSize(sizeSelector.getSelectedItem().toString())));
				}
			}
		);

		topRowPanel.add(textField);
		topRowPanel.add(sizeSelector);
		
		return topRowPanel;
	}

	static JPanel createMiddleRowPanel(final JLabel displayedText)
	{
		JPanel middleRowPanel = new JPanel();
		middleRowPanel.setLayout(new BorderLayout());

		middleRowPanel.add(createRadioButtonPanel(displayedText), BorderLayout.LINE_START);
		middleRowPanel.add(displayedText, BorderLayout.CENTER);

		return middleRowPanel;
	}

	static JPanel createRadioButtonPanel(final JLabel displayedText)
	{
		JPanel panel = new JPanel();
		Border paddingBorder = BorderFactory.createEmptyBorder(0, 5, 10, 10);

		panel.setBorder(paddingBorder);
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

		JRadioButton rb_plain = new JRadioButton("Plain");
		rb_plain.setSelected(true);
		rb_plain.addActionListener(
				// This is an ANONYMOUS class
				new ActionListener()
				{
					@Override
					public void actionPerformed(ActionEvent e)
					{
						displayedText.setFont(displayedText.getFont().deriveFont(Font.PLAIN));
					}
				}
		);

		JRadioButton rb_bold = new JRadioButton("Bold");
		rb_bold.addActionListener(
				// This is an ANONYMOUS class
				new ActionListener()
				{
					@Override
					public void actionPerformed(ActionEvent e)
					{
						displayedText.setFont(displayedText.getFont().deriveFont(Font.BOLD));
					}
				}
		);

		JRadioButton rb_italic = new JRadioButton("Italic");
		rb_italic.addActionListener(
				// This is an ANONYMOUS class
				new ActionListener()
				{
					@Override
					public void actionPerformed(ActionEvent e)
					{
						displayedText.setFont(displayedText.getFont().deriveFont(Font.ITALIC));
					}
				}
		);

		JRadioButton rb_bold_italic = new JRadioButton("Bold Italic");
		rb_bold_italic.addActionListener(
				// This is an ANONYMOUS class
				new ActionListener()
				{
					@Override
					public void actionPerformed(ActionEvent e)
					{
						displayedText.setFont(displayedText.getFont().deriveFont(Font.BOLD | Font.ITALIC));
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

	static JPanel createBottomRow(final JLabel displayedText)
	{
		JPanel bottomRow = new JPanel();
		bottomRow.setLayout(new BoxLayout(bottomRow, BoxLayout.X_AXIS));
		JPanel showPanel = new JPanel();
		JPanel closePanel = new JPanel();
		
		JButton btn_show = new JButton("Show!");
		
		btn_show.addActionListener(
				// This is an ANONYMOUS class
				new ActionListener()
				{
					@Override
					public void actionPerformed(ActionEvent e)
					{
						if (displayedText.getForeground().equals(Color.BLACK))
							displayedText.setForeground(Color.RED);
						else
							displayedText.setForeground(Color.BLACK);
					}
				}
		);
		showPanel.add(btn_show);

		final JButton btn_close = new JButton("Close");
		
		btn_close.addActionListener(
				// This is an ANONYMOUS class
				new ActionListener()
				{
					@Override
					public void actionPerformed(ActionEvent e)
					{
						Container frame = btn_close.getParent();
						do
							frame = frame.getParent();
						while (!(frame instanceof JFrame));
						((JFrame) frame).dispose();
					}
				}
		);
		closePanel.add(btn_close);

		bottomRow.add(showPanel);
		bottomRow.add(closePanel);
		
		return bottomRow;
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
}





























