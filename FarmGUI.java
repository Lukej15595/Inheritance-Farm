//Luke Jacobs
//Battleship GUI
//GUI for Battleship Game

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.BorderFactory;
import javax.swing.border.Border;

public class FarmGUI extends JFrame
{
	private JButton[][] boardButtons = new JButton[5][5];
	private JLabel lblTitle, lblComp, lblMoney, space;
	private ButtonListener listener;
	private JPanel oppPad,cp2, cp3;
	private JButton plot;
	Color brown = new Color(101, 67, 52);
	private Border blackline= BorderFactory.createLineBorder(Color.black), clearline = BorderFactory.createEmptyBorder(10, 10, 10, 10), clearline2 = BorderFactory.createEmptyBorder(10, 60, 10, 60);
	private Land land;
	private ImageIcon dirt,wheat,weed,sugar,indigo,cotton,horse,goat,pig,cow,dog,sheep, wheatdone,sugardone,indigodone,cottondone,horsedone,goatdone,pigdone,cowdone,dogdone,sheepdone,chicken, chickendone, dragon,dragondone;
	private double money;
	private Timer checkGrown;
	private TimerListener tmrListener;
	private int mutNum;


	public FarmGUI()
	{
		super("Farm");
		tmrListener = new TimerListener();
		checkGrown = new Timer(100,tmrListener);
		Container cp = getContentPane();
		cp.setLayout(new BorderLayout());
		BorderLayout cp22 = new BorderLayout();
		GridLayout buttonGrid = new GridLayout(5,5);
		plot = new JButton("new plot");
		cp2 = new JPanel();
		cp2.setLayout(cp22);
		cp3 = new JPanel();
		cp3.setLayout(new FlowLayout());
		oppPad = new JPanel();
		oppPad.setLayout(buttonGrid);
		oppPad.setBorder(clearline);
		dirt = new ImageIcon("dirt2.jpg");
		wheat = new ImageIcon("wheat.jpg");
		weed = new ImageIcon("weed.jpg");
		sugar = new ImageIcon("sugar.jpg");
		indigo = new ImageIcon("indigo.jpg");
		cotton = new ImageIcon("cotton.jpg");
		horse = new ImageIcon("horse.jpg");
		cow = new ImageIcon("cow.jpg");
		dog = new ImageIcon("dog.jpg");
		sheep = new ImageIcon("sheep.jpg");
		goat = new ImageIcon("goat.jpg");
		pig = new ImageIcon("pig.jpg");
		dirt = new ImageIcon("dirt2.jpg");
		wheatdone = new ImageIcon("wheatdone.jpg");
		sugardone = new ImageIcon("sugardone.jpg");
		indigodone = new ImageIcon("indigodone.jpg");
		cottondone = new ImageIcon("cottondone.jpg");
		horsedone = new ImageIcon("horsedone.jpg");
		cowdone = new ImageIcon("cowdone.jpg");
		dogdone = new ImageIcon("dogdone.jpg");
		sheepdone = new ImageIcon("sheepdone.jpg");
		goatdone = new ImageIcon("goatdone.jpg");
		pigdone = new ImageIcon("pigdone.jpg");
		chicken = new ImageIcon("chicken.jpg");
		chickendone = new ImageIcon("chickendone.jpg");
		dragon = new ImageIcon("dragon.jpg");
		dragondone = new ImageIcon("dragondone.jpg");
		lblTitle = new JLabel("                           Farm!!!");
		lblComp = new JLabel("                                               Your Pharm:");
		lblMoney = new JLabel("Money: $4.00");
		space = new JLabel("                                              new plot: $20.00   ");
		lblTitle.setFont(new Font("TW Cen MT", Font.PLAIN, 26));
		lblComp.setFont(new Font("TW Cen MT", Font.PLAIN, 14));
		lblMoney.setFont(new Font("TW Cen MT", Font.PLAIN, 14));
		land = new Land();
		money = 4.0;
		listener = new ButtonListener();
		plot.addActionListener(listener);
		mutNum = 15;
		for(int i = 0; i < boardButtons.length; i++)
		{
			for(int j = 0; j <boardButtons[i].length; j++)
			{
				boardButtons[i][j] = new JButton(" ");
				boardButtons[i][j].addActionListener(listener);
				boardButtons[i][j].setOpaque(true);
				boardButtons[i][j].setIcon(dirt);
				boardButtons[i][j].setEnabled(false);
			}
		}
		landSetUp();
		cp.add(lblTitle, BorderLayout.NORTH);
		cp2.add(lblComp, BorderLayout.NORTH);
		cp2.add(oppPad, BorderLayout.CENTER);
		cp3.add(lblMoney);
		cp3.add(space);
		cp3.add(plot);
		cp.add(cp2, BorderLayout.CENTER);
		cp.add(cp3,BorderLayout.SOUTH);

		for(int i = 0; i < boardButtons.length; i++)
		{
			for(int j = 0; j <boardButtons[i].length; j++)
			{
				oppPad.add(boardButtons[i][j]);
			}
		}
		setSize(500,550);
		setVisible(true);
		checkGrown.start();
	}
	public void landSetUp()
	{
		for(int i = 0; i < boardButtons.length; i++)
		{
			for(int j = 0; j <boardButtons[i].length; j++)
			{
				// --NEW STUFF--
				if(land.getPlot(i,j) != null)
				{
					boardButtons[i][j].setEnabled(true);
					boardButtons[i][j].setOpaque(false);
				}
			}
		}
	}
	public static void main(String[] args)
	{
		FarmGUI foo = new FarmGUI();
	}
	public class TimerListener implements ActionListener
	{
		public void actionPerformed(ActionEvent event)
		{
			for(int i = 0; i < boardButtons.length; i++)
			{
				for(int j = 0; j <boardButtons[0].length; j++)
				{
					if (land.getPlot(i,j)!=null)
					{
						if(land.getPlot(i,j).isGrown())
						{
							if (land.getPlot(i,j).getName().equals("Cotton"))
								boardButtons[i][j].setIcon(cottondone);
							else if (land.getPlot(i,j).getName().equals("Indigo"))
								boardButtons[i][j].setIcon(indigodone);
							else if (land.getPlot(i,j).getName().equals("Sugar Cane"))
								boardButtons[i][j].setIcon(sugardone);
							else if (land.getPlot(i,j).getName().equals("Wheat"))
								boardButtons[i][j].setIcon(wheatdone);
							else if (land.getPlot(i,j).getName().equals("Cow"))
								boardButtons[i][j].setIcon(cowdone);
							else if (land.getPlot(i,j).getName().equals("Horse"))
								boardButtons[i][j].setIcon(horsedone);
							else if (land.getPlot(i,j).getName().equals("Pig"))
								boardButtons[i][j].setIcon(pigdone);
							else if (land.getPlot(i,j).getName().equals("Sheep"))
								boardButtons[i][j].setIcon(sheepdone);
							else if (land.getPlot(i,j).getName().equals("Goat"))
								boardButtons[i][j].setIcon(goatdone);
							else if (land.getPlot(i,j).getName().equals("Chicken"))
								boardButtons[i][j].setIcon(chickendone);
							else if (land.getPlot(i,j).getName().equals("EnderDragon"))
							{
								boardButtons[i][j].setIcon(dragondone);
								JOptionPane.showMessageDialog(new Frame(),"You've Won the Game!\nYou may continue to farm.");
							}
							else
								boardButtons[i][j].setIcon(dogdone);
						}
					}
				}
			}
		}
	}
	private class ButtonListener implements ActionListener
	{
		public boolean checkMoney(double sub)
		{
			if(money-sub<0)
			{
				JOptionPane.showMessageDialog(new Frame(),"You don't have the money to purchase this item!");
				return false;
			}
			return true;
		}
		public void actionPerformed(ActionEvent event)
		{
			Object source = event.getSource();
			Object[] possibleValues = {"Wheat: $0.18","Cotton: $0.45", "Sugar: $0.75", "Indigo: $0.80","Chicken: $5.00","Dog: $10.00","Pig: $20.00","Cow: $30.00","Goat: $30.00","Sheep: $40.00","Horse: $60.00","ENDER DRAGON: $1,000.00"};
			if(source == plot)
			{
				if(money >= 20.0)
				{
					money = money - 20.0;
					lblMoney.setText("Money: $"+String.format("%.2f",money));
					land.addPlot();
					landSetUp();
				}
			}
			for(int i = 0; i < boardButtons.length; i++)
			{
				for(int j = 0; j <boardButtons[i].length; j++)
				{
					if(source == boardButtons[i][j])
					{
						System.out.println(i+" "+j);
						if(land.getPlot(i,j).compare(new Agriculture()))
						{
							Object selectedValue = JOptionPane.showInputDialog(null,
													"Choose a plant or animal", "Agriculture",
													JOptionPane.INFORMATION_MESSAGE, null,
													possibleValues, possibleValues[0]);
						System.out.print(selectedValue.toString());
							if(selectedValue.toString().equals("Wheat: $0.18"))
							{

								Agriculture w = new Wheat();
								if(checkMoney(w.getInitialPrice()))
								{
									money = money - w.getInitialPrice();
									land.setPlot(i,j,w);
									land.getPlot(i,j).grow();
									boardButtons[i][j].setIcon(wheat);
								}
							}
							else if(selectedValue.toString().equals("Cotton: $0.45"))
							{
								Agriculture c = new Cotton();
								if(checkMoney(c.getInitialPrice()))
								{
									land.setPlot(i,j,c);
									land.getPlot(i,j).grow();
									money = money - c.getInitialPrice();
									boardButtons[i][j].setIcon(cotton);
								}
							}
							else if(selectedValue.toString().equals("Sugar: $0.75"))
							{
								Agriculture s = new SugarCane();
								if(checkMoney(s.getInitialPrice()))
								{
									land.setPlot(i,j,s);
									land.getPlot(i,j).grow();
									money = money - s.getInitialPrice();
									boardButtons[i][j].setIcon(sugar);
								}
							}
							else if(selectedValue.toString().equals("Indigo: $0.80"))
							{
								Agriculture in = new Indigo();
								if(checkMoney(in.getInitialPrice()))
								{
									land.setPlot(i,j,in);
									land.getPlot(i,j).grow();
									money = money - in.getInitialPrice();
									boardButtons[i][j].setIcon(indigo);
								}
							}
							else if(selectedValue.toString().equals("Horse: $60.00"))
							{
								Agriculture h = new Horse();
								if(checkMoney(h.getInitialPrice()))
								{
									land.setPlot(i,j,h);
									land.getPlot(i,j).grow();
									money = money - h.getInitialPrice();
									boardButtons[i][j].setIcon(horse);
								}
							}
							else if(selectedValue.toString().equals("Dog: $10.00"))
							{
								Agriculture d = new Dog();
								if(checkMoney(d.getInitialPrice()))
								{
									land.setPlot(i,j,d);
									land.getPlot(i,j).grow();
									money = money-d.getInitialPrice();
									boardButtons[i][j].setIcon(dog);
								}
							}
							else if(selectedValue.toString().equals("Sheep: $40.00"))
							{
								Agriculture s = new Sheep();
								if(checkMoney(s.getInitialPrice()))
								{
									land.setPlot(i,j,s);
									land.getPlot(i,j).grow();
									money = money - s.getInitialPrice();
									boardButtons[i][j].setIcon(sheep);
								}
							}
							else if(selectedValue.toString().equals("Cow: $30.00"))
							{
								Agriculture ch = new Cow();
								if(checkMoney(ch.getInitialPrice()))
								{
									land.setPlot(i,j,ch);
									land.getPlot(i,j).grow();
									money = money - ch.getInitialPrice();
									boardButtons[i][j].setIcon(cow);
								}
							}
							else if(selectedValue.toString().equals("Goat: $30.00"))
							{
								Agriculture g = new Goat();
								if(checkMoney(g.getInitialPrice()))
								{
									land.setPlot(i,j,g);
									land.getPlot(i,j).grow();
									money = money - g.getInitialPrice();
									boardButtons[i][j].setIcon(goat);
								}
							}
							else if(selectedValue.toString().equals("Pig: $20.00"))
							{
								Agriculture p = new Pig();
								if(checkMoney(p.getInitialPrice()))
								{
									land.setPlot(i,j,p);
									land.getPlot(i,j).grow();
									money-= p.getInitialPrice();
									boardButtons[i][j].setIcon(pig);
								}
							}
							else if(selectedValue.toString().equals("Chicken: $5.00"))
							{
								Agriculture c = new Chicken();
								if(checkMoney(c.getInitialPrice()))
								{
									land.setPlot(i,j,c);
									land.getPlot(i,j).grow();
									money-= c.getInitialPrice();
									boardButtons[i][j].setIcon(chicken);
								}
							}
							else if(selectedValue.toString().equals("ENDER DRAGON: $1,000.00"))
							{
								Agriculture d = new EnderDragon();
								if(checkMoney(d.getInitialPrice()))
								{
									land.setPlot(i,j,d);
									land.getPlot(i,j).grow();
									money-= d.getInitialPrice();
									boardButtons[i][j].setIcon(dragon);
								}
							}
							lblMoney.setText("Money: $"+String.format("%.2f",money));
						}
						else if(land.getPlot(i,j).isGrown() == true)
						{
							System.out.println("harvest");
							money += land.getPlot(i,j).getPrice();
							lblMoney.setText("Money: $"+String.format("%.2f",money));
							land.setPlot(i,j,new Agriculture());
							boardButtons[i][j].setIcon(dirt);
						}
					}
				}
			}
		}
	}
}
