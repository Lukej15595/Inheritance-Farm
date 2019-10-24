//Luke Jacobs
//Farm Runner
// basic runner for objects

public class FarmRunner
{
	public static void main (String args[])
	{
		/*SugarCane sc = new SugarCane();
		System.out.println(sc.getName());
		Crop c = new Crop();
		System.out.println(c.getName());
		Land land = new Land();
		land.setPlot(0,0,c);
		System.out.println(land.getPlot(0,0).getName());*/
		Agriculture a = new Agriculture();
		a.grow();
	}
}
