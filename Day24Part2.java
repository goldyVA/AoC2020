import java.io.File;  // Import the File class
import java.io.FileNotFoundException;  // Import this class to handle errors
import java.util.*; // Import the Scanner class to read text files


public class Day24Part2 
{
	
	static HashMap<String,Hexagon> tiles = new HashMap<String,Hexagon>();
	
  public static void main(String[] args) 
  {
    ArrayList<String> list = new ArrayList<String>();
   // static HashMap<String,Hexagon> tiles = new HashMap<String,Hexagon>();
    ArrayList<String> toChange = new ArrayList<String>();
    
    
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
    
    for(int i = -300; i < 300; i+=2)
    {
    	for(int j = -300; j < 300; j+=2)
    	{
    		if(!tiles.containsKey(i+" "+j))
    			tiles.put(i+" "+j, new Hexagon(i,j));
    	}
    }
    for(int i = -301; i < 301; i+=2)
    {
    	for(int j = -301; j < 301; j+=2)
    	{
    		if(!tiles.containsKey(i+" "+j))
    			tiles.put(i+" "+j, new Hexagon(i,j));
    	}
    }
    
    
    
    int count=0;
    for(String x : tiles.keySet())
    {
    	if(!tiles.get(x).getColor())
    		count++;
    }
    System.out.println(count);
    
    
    for(int k = 0; k<100; k++)
    {
    	for(int i = -250; i < 250; i++)
        {
        	for(int j = -250; j<250; j++)
        	{
        		if((i+j)%2==0)
        		{
        			String x = i+" "+j;
        			if(tiles.get(x).getColor())
        	    	{
        	    		if(countNeighbors(x)==2)
        	    			toChange.add(x);
        	    	}
        	    	else
        	    	{
        	    		if(countNeighbors(x)==0 || countNeighbors(x)>2)
        	    			toChange.add(x);
        	    	}
        		}
        	}
        }
    	

        for(String x: toChange)
        	tiles.get(x).changeColor();
        
        toChange.clear();
        count=0;
        for(String x : tiles.keySet())
        {
        	if(!tiles.get(x).getColor())
        		count++;
        }
        System.out.println(count);
    }
    
    
   
    
    
   
    
    
    
    
    
    
    
    
    
    
    
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
  
  public static int countNeighbors(String a)
  {
	  int count = 0;
	  String[] split = a.split(" ");
	  int x = Integer.parseInt(split[0]);
	  int y = Integer.parseInt(split[1]);
	  String one = (x+2) + " "+ y;
	  String two = (x+1) + " "+ (y+1);
	  String three = (x-1) + " "+ (y+1);
	  String four = (x-2) + " "+ y;
	  String five = (x-1) + " "+ (y-1);
	  String six = (x+1) + " "+ (y-1);
	  
	  if(tiles.containsKey(one)) 
	  {
		  if(tiles.get(one).getColor()== false)
			  count++;
	  }
	  if(tiles.containsKey(two)) 
	  {
		  if(tiles.get(two).getColor()== false)
			  count++;
	  }
	  if(tiles.containsKey(three)) 
	  {
		  if(tiles.get(three).getColor()== false)
			  count++;
	  }
	  if(tiles.containsKey(four)) 
	  {
		  if(tiles.get(four).getColor()== false)
			  count++;
	  }
	  if(tiles.containsKey(five)) 
	  {
		  if(tiles.get(five).getColor()== false)
			  count++;
	  }
	  if(tiles.containsKey(six)) 
	  {
		  if(tiles.get(six).getColor()== false)
			  count++;
	  }


	  
	  
	  return count;
	  
  }
  
  
}