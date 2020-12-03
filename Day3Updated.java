
import java.io.File;  // Import the File class
import java.io.FileNotFoundException;  // Import this class to handle errors
import java.util.*; // Import the Scanner class to read text files


public class Day3Updated
{
  public static void main(String[] args) 
  {
    ArrayList<String> list = new ArrayList<String>();
    char[][] array = new char[323][31];
    
    try 
    {
    	Scanner scan = new Scanner(new File("day3.txt"));
    	while(scan.hasNextLine())
    	{
    		list.add(scan.next());
    	}
    }
    catch(Exception e) 
    {	
    }
    
    //put in an array
    int count = 0;
    for(String x: list)
    {
    	for(int i = 0; i<x.length(); i++)
    	{
    		array[count][i] = x.charAt(i);
    	}
    	count++;
    }
    
    //part 1
    System.out.println(part1(array, 3, 1));
    
    //part 2
    long product = part2(array, 1, 1) * part2(array, 3, 1) * part2(array, 5, 1) * part2(array, 7, 1) * part2(array, 1, 2);
    System.out.println(product);
    
  }
  
  public static long part1(char[][] array, int right, int down)
  {
	  	int count = 0;
	    int sum = 0;
	    for(int i = 0; i < array.length;i+=down)
	    {
	    	if(array[i][count] == '#')
	    		sum++;
	    	
	    	count = count +right;
	    	if(count>30)
	    		count = count - 31;
	    }
	    
	    return sum;
  }
  
  public static long part2(char[][] array, int right, int down)
  {
	  	int count = 0;
	    
	  	int sum = 0;
	    for(int i = 0; i < array.length;i+=down)
	    {
	    	if(array[i][count] == '#')
	    		sum++;
	    	
	    	count = count +right;
	    	if(count>30)
	    		count = count - 31;
	    }
	    return sum;
  }
  
}
