import java.io.File;  // Import the File class
import java.io.FileNotFoundException;  // Import this class to handle errors
import java.util.*; // Import the Scanner class to read text files


public class Day12 
{
  private static int direction = 0;
  private static int x = 0;
  private static int y = 0;
  private static int waypointX = 10;
  private static int waypointY = 1;

  public static void main(String[] args) 
  {
    ArrayList<String> list = new ArrayList<String>();
    
    try 
    {
    	Scanner scan = new Scanner(new File("day12.txt"));
    	while(scan.hasNextLine())
    	{
    		list.add(scan.nextLine());
    	}
    }
    catch(Exception e) 
    {	
    }

    //Part 1
    for(String input: list)
    {
    	char code = input.charAt(0);
    	int amount = Integer.parseInt(input.substring(1));
    	updatePositionPart1(code,amount);	
    }
    System.out.println(Math.abs(x)+Math.abs(y));
    
    //Part 2
    direction = 0;
    x = 0;
    y = 0;
    for(String input: list)
    {
    	char code = input.charAt(0);
    	int amount = Integer.parseInt(input.substring(1));
    	updatePositionPart2(code,amount);	
    }
    System.out.println(Math.abs(x)+Math.abs(y));
 
  }
  
  public static void updatePositionPart2(char code, int amount)
  {
	  if(code == 'F')
	  {
		  x += amount*waypointX;
		  y += amount*waypointY;
			  
	  }
	  else if(code == 'L' || code == 'R')
	  {
		  int tempX = waypointX;
		  int tempY = waypointY;
		  if(code == 'L')
		  {
			  if(amount == 90)
			  {
				  waypointX = -tempY;
				  waypointY = tempX;
			  }
			  if(amount == 180)
			  {
				  waypointX = -tempX;
				  waypointY = -tempY;
			  }
			  if(amount == 270)
			  {
				  waypointX = tempY;
				  waypointY = -tempX;
			  }
		  }
		 if(code == 'R')
		  {
			  if(amount == 90)
			  {
				  waypointX = tempY;
				  waypointY = -tempX;
			  }
			  if(amount == 180)
			  {
				  waypointX = -tempX;
				  waypointY = -tempY;
			  }
			  if(amount == 270)
			  {
				  waypointX = -tempY;
				  waypointY = tempX;
			  }
		  }
	  }
	  else
	  {
		  switch(code)
		  {
		  case 'N':
			  waypointY+=amount;
			  break;
		  case 'S':
			  waypointY-=amount;
			  break;
		  case 'E':
			  waypointX+=amount;
			  break;
		  case 'W':
			  waypointX-=amount;
			  break;
		  }
	  }
  }
  
  public static void updatePositionPart1(char code, int amount)
  {
	  if(code == 'F')
	  {
		  if(direction == 0)
			  x+=amount;
		  else if(direction == 90)
			  y+=amount;
		  else if(direction == 180)
			  x-=amount;
		  else
			  y-=amount;
			  
	  }
	  else if(code == 'L' || code == 'R')
	  {
		  if(code == 'L')
			  direction += amount;
		  else
			  direction -= amount;
		  
		  
		  if(direction > 270)
			  direction -= 360;
		  if(direction < 0)
			  direction += 360;
	  }
	  else
	  {
		  switch(code)
		  {
		  case 'N':
			  y+=amount;
			  break;
		  case 'S':
			  y-=amount;
			  break;
		  case 'E':
			  x+=amount;
			  break;
		  case 'W':
			  x-=amount;
			  break;
		  }
	  }
  }

}