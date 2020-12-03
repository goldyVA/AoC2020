import java.io.File;  // Import the File class
import java.io.FileNotFoundException;  // Import this class to handle errors
import java.util.*; // Import the Scanner class to read text files


public class Day3 
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
    
    //part1
    count = 0;
    int sum = 0;
    for(int i = 0; i < array.length;i++)
    {
    	if(array[i][count] == '#')
    		sum++;
    	
    	count = count +3;
    	if(count>30)
    		count = count - 31;
    }
    
    System.out.println(sum);
    
    
    //part2
    
    //first
    count = 0;
    long product = 1;
    sum = 0;
    for(int i = 0; i < array.length;i++)
    {
    	if(array[i][count] == '#')
    		sum++;
    	
    	count = count +1;
    	if(count>30)
    		count = count - 31;
    }
    product *= sum;
    
    //second
    count = 0;
    sum = 0;
    for(int i = 0; i < array.length;i++)
    {
    	if(array[i][count] == '#')
    		sum++;
    	
    	count = count +3;
    	if(count>30)
    		count = count - 31;
    }
    product *= sum;
    
  //third
    count = 0;
    sum = 0;
    for(int i = 0; i < array.length;i++)
    {
    	if(array[i][count] == '#')
    		sum++;
    	
    	count = count +5;
    	if(count>30)
    		count = count - 31;
    }
    product *= sum;
    
  //fourth
    count = 0;
    sum = 0;
    for(int i = 0; i < array.length;i++)
    {
    	if(array[i][count] == '#')
    		sum++;
    	
    	count = count +7;
    	if(count>30)
    		count = count - 31;
    }
    product *= sum;
    
  //fifth
    count = 0;
    sum = 0;
    for(int i = 0; i < array.length;i+=2)
    {
    	if(array[i][count] == '#')
    		sum++;
    	
    	count = count +1;
    	if(count>30)
    		count = count - 31;
    }
    product *= sum;
    
    System.out.println(product);
  }
}