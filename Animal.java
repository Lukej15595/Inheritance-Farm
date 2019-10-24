//Jordan Leong
//Animal Object
//Spec: the more general class for all animals
import java.util.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class Animal extends Agriculture
{
	//private int babyPrice;
	//private int sellingPrice;
	//private int growTime;
	//private String name;

	public Animal()
	{
		super("Animal",30,2.00,.15,false);

	}
	public Animal(String name, int seconds, double sell, double price, boolean crop)
	{
		super(name, seconds, sell, price, crop);

	}

}