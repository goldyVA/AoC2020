import java.io.File;  // Import the File class
import java.io.FileNotFoundException;  // Import this class to handle errors
import java.util.*; // Import the Scanner class to read text files


public class Day14Part1 
{
  public static void main(String[] args) 
  {
    ArrayList<String> list = new ArrayList<String>();
    
    try 
    {
    	Scanner scan = new Scanner(new File("day14.txt"));
    	while(scan.hasNextLine())
    	{
    		list.add(scan.nextLine());
    	}
    }
    catch(Exception e) 
    {	
    }
    //set up memory
    String[] memory = new String[99999];
    for(int i = 0; i <memory.length;i++)
    {
    	memory[i] = "000000000000000000000000000000000000";
    }
    
    String mask = "";
    
    for(int i = 0; i < list.size(); i++)
    {
    	String x = list.get(i);
    	
    	if(x.contains("mask"))
    	{
    		String[] split = x.split(" ");
    		mask = split[2];
    	}
    	else
    	{
    		String[] split = x.split(" ");
    		int memoryLoc = Integer.parseInt(split[0].substring(split[0].indexOf("[")+1, split[0].indexOf("]")));
    		int integerVal = Integer.parseInt(split[2]);
    		
    		String binaryVal = Integer.toBinaryString(integerVal);
    		while(binaryVal.length()<36)
    		{
    			binaryVal = "0" +binaryVal;
    		}
    		
    		
    		StringBuilder temp = new StringBuilder(memory[memoryLoc]);
    		for(int j =0; j<36;j++)
    		{
    			if(mask.charAt(j) == 'X')
    				temp.setCharAt(j, binaryVal.charAt(j));
    			else if(mask.charAt(j) == '1')
    				temp.setCharAt(j, '1');
    			else
    				temp.setCharAt(j, '0');
    		}
    		
    		memory[memoryLoc] = temp.toString();
    	}
    }
    
    long sum = 0;
    for(String x: memory)
    {
    	sum += Long.parseLong(x,2);
    }
    
    System.out.println(sum);
    
    
    
  }
}