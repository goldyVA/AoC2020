import java.io.File;  // Import the File class
import java.io.FileNotFoundException;  // Import this class to handle errors
import java.util.*; // Import the Scanner class to read text files


public class Day13Part1 
{
  public static void main(String[] args) 
  {
    ArrayList<String> list = new ArrayList<String>();
    
    try 
    {
    	Scanner scan = new Scanner(new File("day13.txt"));
    	while(scan.hasNextLine())
    	{
    		list.add(scan.next());
    	}
    }
    catch(Exception e) 
    {	
    }
    
    int timestamp = Integer.parseInt(list.get(0));
    System.out.println(timestamp);
    String[] buses = list.get(1).split(",");
    
    int smallest = Integer.MAX_VALUE;
    int answer = 0;
    for(String x: buses)
    {
    	if(!x.equals("x"))
    	{
    		//System.out.println(earliest(timestamp,Integer.parseInt(x)) + " " +x);
    		if(earliest(timestamp,Integer.parseInt(x))<smallest)
    		{
    			smallest = earliest(timestamp,Integer.parseInt(x));
    			answer = earliest(timestamp,Integer.parseInt(x))*Integer.parseInt(x);
    		}
    				
    		
    		
    	}
    }
    
    System.out.println(answer);
    
    
    
    
    
    
  }
  
  public static int earliest(int time, int number)
  {
	  return  (time/number)*number+number-time;  
  }
  
  
}