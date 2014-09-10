import javax.smartcardio.Card;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

/**
 * Created by Kyle on 9/9/2014.
 * Simple memory match game 4 x 4 grid. Just to show logic of panels and etc.
 */
public class Portfolio1
{
	public static JButton[] gameCards = new JButton[16];
	public static Color[] colors = new Color[16];

	public static void main(String[] args)
	{

		JFrame frame = new JFrame("HelloWorldSwing!");
		frame.setSize(new Dimension(600, 480));
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		frame.setContentPane(createContainers());

		//frame.pack();
		frame.setVisible(true);
	}

	static JPanel createContainers()
	{
		JPanel mainPanel = createMainPanel();
		JPanel gamePanel = createGamePanel();

		JButton[] gameCards = createGameButtons();

		for (JButton button : gameCards)
		{
			gamePanel.add(button);
		}

		mainPanel.add(gamePanel);

		return mainPanel;

	}

	private static JPanel createGamePanel()
	{
		JPanel gamePanel = new JPanel();

		GridLayout gridLayout = new GridLayout(4, 4);
		gridLayout.setHgap(15);
		gridLayout.setVgap(15);

		gamePanel.setLayout(gridLayout);
		gamePanel.setBackground(Color.black);
		return gamePanel;
	}

	static JPanel createMainPanel()
	{
		JPanel mainPanel = new JPanel();
		mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.X_AXIS));
		return mainPanel;
	}

	private static JButton[] createGameButtons()
	{
		colors = generateGameColors(gameCards.length);

		for (int index = 0; index < gameCards.length; index++)
		{
			gameCards[index] = new JButton();
			createCard(index, colors[index]);
			gameCards[index].setSize(new Dimension(10, 10));
			gameCards[index].setBackground(Color.blue);
			assignAction(gameCards[index], index);
		}

		return gameCards;
	}

	private static void assignAction(JButton gameCard, final int index)
	{
		gameCard.addActionListener(
				new ActionListener()
				{
					@Override
					public void actionPerformed(ActionEvent e)
					{
						flipCard(index);
					}
				}
		);
	}

	private static Color[] generateGameColors(int numCards)
	{
		int numMatches = 0;

		if (numCards % 2 != 0)
			System.err.println("Cannot have odd amount of cards!");
		else
			numMatches = numCards / 2;

		Color[] cardColors = new Color[numCards];
		int[] cardValues = initializeValues(numMatches);
		randomizeArray(cardValues);

		int index = 0;

		for (int i : cardValues)
		{
			switch (i)
			{
				case 0:
					cardColors[index] = Color.GREEN;
					index++;
					break;
				case 1:
					cardColors[index] = Color.YELLOW;
					index++;
					break;
				case 2:
					cardColors[index] = Color.ORANGE;
					index++;
					break;
				case 3:
					cardColors[index] = Color.RED;
					index++;
					break;
				case 4:
					cardColors[index] = Color.CYAN;
					index++;
					break;
				case 5:
					cardColors[index] = Color.GRAY;
					index++;
					break;
				case 6:
					cardColors[index] = Color.MAGENTA;
					index++;
					break;
				case 7:
					cardColors[index] = Color.PINK;
					index++;
					break;
				case 8:
					cardColors[index] = Color.DARK_GRAY;
					index++;
					break;
				default:
					System.err.println("Game cannot be played with this amount of cards");
					break;
			}
		}
		return cardColors;
	}

	private static int[] randomizeArray(int[] arr)
	{
		Random rand = new Random();
		for (int i = arr.length - 1; i > 0; i--)
		{
			int index = rand.nextInt(i + 1);

			int temp = arr[index];
			arr[index] = arr[i];
			arr[i] = temp;
		}
		return new int[0];
	}

	private static int[] initializeValues(int maxValue)
	{
		int[] values = new int[maxValue * 2];
		int j = 0;

		for (int i = 0; i < maxValue; i++)
		{
			values[j] = i;
			values[j+1] = i;

			j += 2;
		}

		return values;
	}

	private static GameCard createCard(int index, Color color)
	{
		GameCard newCard = new GameCard(index, color);

		return newCard;
	}

	private static void flipCard(int index)
	{
		gameCards[index].setBackground(colors[index]);
	}
}