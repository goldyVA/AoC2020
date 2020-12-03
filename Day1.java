import java.io.File;  // Import the File class
import java.io.FileNotFoundException;  // Import this class to handle errors
import java.util.*; // Import the Scanner class to read text files


public class Day1 
{
  public static void main(String[] args) 
  {
    ArrayList<Integer> list = new ArrayList<Integer>();
    
    try 
    {
    	Scanner scan = new Scanner(new File("day1.txt"));
    	while(scan.hasNextInt())
    	{
    		list.add(scan.nextInt());
    	}
    }
    catch(Exception e) 
    {	
    }
    
    //part 1
    for(int i = 0; i < list.size()-1; i++)
    {
    	for(int j = i+1; j<list.size(); j++)
    	{
    		
    			if(list.get(i)+list.get(j)==2020)
    			{
    				System.out.println(list.get(i)*list.get(j) + " " + list.get(i)+ " "+ list.get(j));
    			}
    	}
    }  
    
    int count = 0;
    //part 2
    for(int i = 0; i < list.size()-2; i++)
    {
    	for(int j = i+1; j<list.size()-1; j++)
    	{
    		for(int k = j + 1; k<list.size();k++)
    		{
    			if(list.get(i)+list.get(j)+list.get(k)==2020)
    			{
    				
    				System.out.println(list.get(i)*list.get(j)*list.get(k) + " " + list.get(i)+ " "+ list.get(j)+" "+ list.get(k));
    			}
    		}
    	}
    } 
  }
}
