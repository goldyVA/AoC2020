import java.io.File;  // Import the File class
import java.io.FileNotFoundException;  // Import this class to handle errors
import java.util.*; // Import the Scanner class to read text files


public class Day15 
{
  public static void main(String[] args) 
  {
    ArrayList<Integer> list = new ArrayList<Integer>();
  
    list.add(2);
    list.add(0);
    list.add(6);
    list.add(12);
    list.add(1);
    list.add(3);
    
    for(int i =6; i<2020; i++)
    {
    	
    	int previous = list.get(i-1);
    	list.remove(list.size()-1);
    	
    	
    	if(!list.contains(previous))
    	{
    		list.add(previous);
    		list.add(0);
    	}
    	else
    	{
    		int spot = list.lastIndexOf(previous);
    		list.add(previous);
    		list.add(i-spot-1);
    	}
    		
    }
    System.out.println(list.get(2019));
  }
}