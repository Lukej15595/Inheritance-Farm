// Luke Jacobs
// CROP MASTER CLASS
// CROP PARENT CLASS MODEL
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Agriculture extends JFrame
{
	private String name;
	private int  seconds,count;
	private double price;
	private double initialPrice;
	private boolean isCrop, grown;
	private Timer growth;
	private TimerListener tmrListener;

	public Agriculture()
	{
		name = "Item";
		seconds = 60;
		count = 0;
		price = 10.00;
		initialPrice = 1.00;
		tmrListener = new TimerListener();
		growth = new Timer(960,tmrListener);
		grown = false;
	}
	public Agriculture(String name,int seconds,double price,double initialPrice,boolean isCrop)
	{
		this.name = name;
		this.seconds = seconds;
		this.price = price;
		this.initialPrice = initialPrice;
		this.isCrop = isCrop;
		count = 0;
		tmrListener = new TimerListener();
		growth = new Timer(1000,tmrListener);
		grown = false;
	}
	public String getName()
	{
		return name;
	}
	public double getSeconds()
	{
		return seconds;
	}
	public double getPrice()
	{
		return price;
	}
	public double getInitialPrice()
	{
		return initialPrice;
	}
	public boolean getIsCrop()
	{
		return isCrop;
	}
	public boolean compare(Agriculture a)
	{
		if (name.equals(a.name))
		{
			if(seconds == a.seconds)
			{
				if (price == a.price)
				{
					if(initialPrice == a.initialPrice)
					{
						return true;
					}
				}
			}
		}
		return false;
	}
	public void grow()
	{
		growth.start();
		System.out.println("started");
	}

	public boolean isGrown()
	{
		return grown;
	}
	public class TimerListener implements ActionListener
	{
		public void actionPerformed(ActionEvent event)
		{
			if(count == seconds)
			{
				System.out.println(count);
				System.out.println("stopped");
				growth.stop();
				grown = true;
			}
			else
			{
				count++;
				System.out.println(count);
			}
		}
	}
}