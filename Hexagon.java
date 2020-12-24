
public class Hexagon 
{
	private int x;
	private int y;
	private boolean isWhite;
	
	public Hexagon(int xinit, int yinit)
	{
		x = xinit;
		y = yinit;
		isWhite = true;
	}
	
	public void changeColor()
	{
		isWhite = !isWhite;
	}
	
	public int getX()
	{
		return x;
	}
	
	public int getY()
	{
		return y;
	}
	
	public boolean getColor()
	{
		return isWhite;
	}
	
	public String toString()
	{
		return x+" " +y;
	}
}
