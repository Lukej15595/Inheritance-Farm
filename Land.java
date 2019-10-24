// Luke Jacobs
// Land
// 2D array of plots
import java.util.*;
public class Land
{
	private Agriculture[][] land;
	public Land()
	{
		land = new Agriculture[5][5];
		land[0][0] = new Agriculture();
		land[0][1] = new Agriculture();
		land[1][0] = new Agriculture();
		land[1][1] = new Agriculture();
		land[0][2] = new Agriculture();
		land[1][2] = new Agriculture();
	}

	public void addPlot()//doesn't work
	{
		int row = 0;
		int col = 0;
		boolean done = false;
		for(int r = 0;r < land.length;r++)
		{
			for(int c = 0;c < land[r].length;c++)
			{
				if(land[r][c] == null && done == false)
				{
					row = r;
					col = c;
					land[row][col] = new Agriculture();
					done = true;
				}
			}
		}
	}
	public void placeItem(Agriculture a,int i,int k)
	{
		for(int r = 0;r < land.length;r++)
		{
			for(int c = 0;c < land[r].length;c++)
			{
				if( r == i && c == k)
				{
					land[r][c] = a;
				}
			}
		}
	}
	public Agriculture getPlot(int x,int y)
	{
		for(int r = 0;r < land.length;r++)
		{
			for(int c = 0;c < land[r].length;c++)
			{
				if(r == x && c == y)
				{
					return land[r][c];
				}
			}
		}
		return new Agriculture();
	}
	public Agriculture[][] getLand()
	{
		return land;
	}

	public void setPlot(int x,int y,Agriculture a)
	{
		for(int r = 0;r < land.length;r++)
		{
			for(int c = 0;c < land[r].length;c++)
			{
				if(r == x && c == y)
				{
					land[r][c] = a;
				}
			}
		}
	}
}
