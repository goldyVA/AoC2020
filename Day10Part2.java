import java.io.File;  // Import the File class
import java.io.FileNotFoundException;  // Import this class to handle errors
import java.util.*; // Import the Scanner class to read text files


public class Day10Part2 
{
  public static void main(String[] args) 
  {
    ArrayList<Integer> list = new ArrayList<Integer>();
    ArrayList<Boolean> flagged = new ArrayList<Boolean>();
    
    try 
    {
    	Scanner scan = new Scanner(new File("day10.txt"));
    	while(scan.hasNextLine())
    	{
    		list.add(scan.nextInt());
    	}
    	Collections.sort(list);
    }
    catch(Exception e) 
    {	
    }
    
    int count = 0;
    for(int i = 0; i<list.size()-1;i++)
    {
    	if(i==0)
    	{
    		if(list.get(i+1)-list.get(i)==3)
    			flagged.add(true);
    		else
    			flagged.add(false);
    	}
    	else 
    	{
    		if(list.get(i)-list.get(i-1)==3 || list.get(i+1)-list.get(i)==3)
    			flagged.add(true);
    		else
    			flagged.add(false);
    	}
    }
    flagged.add(true);
    
    
    long product = 1;
    for(int i=0;i<flagged.size()-1;i++)
    {
    	if(!flagged.get(i))
    	{
    		if(!flagged.get(i+1))
    		{
    			if(!flagged.get(i+2))
    			{
    				product*=7;
    				i+=2;
    			}
    			else
    			{
    				product*=4;
    				i+=1;
    			}
    		}
    		else
    		{
    			product*=2;
    		}
    	}
    	
    }
    System.out.println(product);
    	
    	
    
    
    
    
   
  }
}