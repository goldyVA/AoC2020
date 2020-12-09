import java.io.File;  // Import the File class
import java.io.FileNotFoundException;  // Import this class to handle errors
import java.util.*; // Import the Scanner class to read text files


public class Day9 
{
  public static void main(String[] args) 
  {
    ArrayList<Long> list = new ArrayList<Long>();
    
    try 
    {
    	Scanner scan = new Scanner(new File("day9.txt"));
    	while(scan.hasNextLine())
    	{
    		list.add(scan.nextLong());
    	}
    }
    catch(Exception e) 
    {	
    }
    
    long key = Long.MIN_VALUE;
    //part 1
    for(int i =25; i<list.size();i++)
    {
    	long[] temp = new long[52];
    	int count = 0;
    	for(int j = i - 25; j < i; j++)
    	{
    		temp[count] = list.get(j); 
    		count++;
    	}
    	
    	boolean found = false;
    	for(int a = 0; a<25; a++)
    	{
    		for(int b = 1; b<25; b++)
    		{
    			if(temp[a]+temp[b]==list.get(i))
    				found = true;
    		}		
    	}
    	if(!found)
    	{
    		key=list.get(i);
    		System.out.println(list.get(i));
    	}

    }
 
    
    //part 2
    ArrayList<Long> temp2 = new ArrayList<Long>();
    for(int i =0; i <900; i++)
    {
    	long sum = list.get(i);
    	for(int j = i+1; j<i+100; j++)
    	{
    		sum += list.get(j);
    		
    		if(sum == key)
    		{
    			for(int a = i; a<j; a++)
    			{
    				temp2.add(list.get(a));
    			}
    		}
    	}
    }
    
    long min = Long.MAX_VALUE;
    long max = Long.MIN_VALUE;
    for(long x: temp2)
    {
    	if(x>max)
    		max=x;
    	if(x<min)
    		min=x;
    }
    
    System.out.println(min);
    System.out.println(max);
    System.out.println(min+max);
    
    
  }
}