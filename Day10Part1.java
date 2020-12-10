import java.io.File;  // Import the File class
import java.io.FileNotFoundException;  // Import this class to handle errors
import java.util.*; // Import the Scanner class to read text files


public class Day10Part1 
{
  public static void main(String[] args) 
  {
    ArrayList<Integer> list = new ArrayList<Integer>();
    
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
    
 
    int ones = 0;
    int twos = 0;
    int threes = 0;
    
    for(int i =0; i<list.size();i++)
    {
    	if(i==0)
    	{
    		if(list.get(i)==1)
    			ones++;
    		if(list.get(i)==2)
    			twos++;
    		if(list.get(i)==3)
    			threes++;
    	}
    	else
    	{
    		if(list.get(i)-list.get(i-1)==1)
    			ones++;
    		if(list.get(i)-list.get(i-1)==2)
    			twos++;
    		if(list.get(i)-list.get(i-1)==3)
    			threes++;
    		if(i==list.size()-1)
    			threes++;
    	}
    }
    
    System.out.println(ones+ " "+ twos+ " " + threes);
    System.out.println(ones*threes);

  }
}