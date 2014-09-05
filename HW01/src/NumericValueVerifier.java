import javax.swing.*;

public class NumericValueVerifier extends InputVerifier
{
	private int minVal;
	private int maxVal;

	public NumericValueVerifier(int minVal, int maxVal)
	{
		this.minVal = minVal;
		this.maxVal = maxVal;
	}

	public boolean verify(JComponent input)
	{
		if (!isValidNumber(input))
		{
			JDialog frame = new JDialog();
			((JTextField) input).setText("");
			JOptionPane.showMessageDialog(frame, "Input Value needs to be an Integer between 1 and 10");
			return false;
		}

		return true;

	}

	private boolean isValidNumber(JComponent input)
	{
		JTextField textField = (JTextField) input;
		if (textField == null)
			return false;

		int val = -1;
		try 
		{
			val = Integer.parseInt(textField.getText());
		}
		catch (NumberFormatException e)
		{
			return false;
		}

		if (val < 1 || val > 10)
			return false;

		return true;
	}
}
