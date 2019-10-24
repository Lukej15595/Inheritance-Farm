// Luke Jacobs
// CROP MASTER CLASS
// CROP PARENT CLASS MODEL
import java.util.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class Crop extends Agriculture
{
	private String name;
	private int  seconds;
	private double price;
	private double seedPrice;
	private boolean isCrop;

	public Crop()
	{
		super("Crop",30,2.00,.15,true);
	}

	public Crop(String name,int seconds,double price,double seedPrice,boolean isCrop)
	{
		super(name,seconds,price,seedPrice,isCrop);
	}
}

