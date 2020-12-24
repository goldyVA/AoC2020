import java.io.File;  // Import the File class
import java.io.FileNotFoundException;  // Import this class to handle errors
import java.util.*; // Import the Scanner class to read text files


public class Day24Part1 
{
  public static void main(String[] args) 
  {
    ArrayList<String> list = new ArrayList<String>();
    HashMap<String,Hexagon> tiles = new HashMap<String,Hexagon>();
    ArrayList<String> found = new ArrayList<String>();
    
    try 
    {
    	Scanner scan = new Scanner(new File("day24.txt"));
    	while(scan.hasNextLine())
    	{
    		list.add(scan.nextLine());
    	}
    }
    catch(Exception e) 
    {	
    }
    
    for(String a: list)
    {
    	if(tiles.containsKey(getTile(a)))
    	{
    		tiles.get(getTile(a)).changeColor();
    	}
    	else
    	{
    		String[] coordinates = getTile(a).split(" ");
    		int x = Integer.parseInt(coordinates[0]);
    		int y = Integer.parseInt(coordinates[1]);
    		tiles.put(getTile(a),new Hexagon(x,y));
    		tiles.get(getTile(a)).changeColor();
    	}
    }
    
    
    int count=0;
    for(String x : tiles.keySet())
    {
    	if(!tiles.get(x).getColor())
    		count++;
    }
    System.out.println(count);
    
    
    
    
    
  }
  
  public static String getTile(String a)
  {
	  int x = 0;
	  int y = 0;
	  for(int i = 0; i <a.length(); i++)
	  {
		  if(a.charAt(i) == 'e')
		  {
			  x+=2;
		  }
		  else if(a.charAt(i) == 'w')
		  {
			  x -=2;
		  }
		  else if(a.substring(i,i+2).equals("ne"))
		  {
			  x++;
			  y++;
			  i++;
		  }
		  else if(a.substring(i,i+2).equals("nw"))
		  {
			  x--;
			  y++;
			  i++;
		  }
		  else if(a.substring(i,i+2).equals("sw"))
		  {
			  x--;
			  y--;
			  i++;
		  }
		  else
		  {
			  x++;
			  y--;
			  i++;
		  }  
	  }
	  
	  return x+ " " +y;
	  
  }
  
  
}