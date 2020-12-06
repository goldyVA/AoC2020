import java.io.File;  // Import the File class
import java.io.FileNotFoundException;  // Import this class to handle errors
import java.util.*; // Import the Scanner class to read text files


public class Day6 
{
  public static void main(String[] args) 
  {
    ArrayList<String> list = new ArrayList<String>();
    
    try 
    {
    	Scanner scan = new Scanner(new File("day6.txt"));
    	while(scan.hasNextLine())
    	{
    		list.add(scan.nextLine());
    	}
    }
    catch(Exception e) 
    {	
    }
    
    //set up the groups for part 1
    ArrayList<String> array = new ArrayList<String>();
    String x = "";
    for(int i = 0; i < list.size();i++)
    {
    	if(list.get(i).isBlank())
    	{
    		array.add(x);
    		x="";
    	}
    	else
    	{
    		x+=list.get(i);
    	}
    	
    	if(i==list.size()-1)
    	{
    		x+=list.get(i);
    		array.add(x);
    	}	
    }
    
    //part 1
    int sum = 0;
    for(String a : array)
    {
    	ArrayList<String> letters = new ArrayList<String>();
    	for(int i = 0; i<a.length();i++)
    	{
    		String letter = a.substring(i, i+1);
    		if(!letters.contains(letter))
    			letters.add(letter);
    	}
    	sum+=letters.size();
    }
    System.out.println(sum);
    
  //set up the groups for part 2
    array.clear();
    x = "";
    for(int i = 0; i < list.size();i++)
    {
    	if(list.get(i).isBlank())
    	{
    		x=x.substring(1);
    		array.add(x);
    		x="";
    	}
    	else
    	{
    		x=x + " " +list.get(i);
    	}
    	
    	if(i==list.size()-1)
    	{
    		x= x + " " +list.get(i);
    		x=x.substring(1);
    		array.add(x);
    	}	
    }
    
   
    sum = 0;
    for(int i = 0; i <array.size(); i++)
    {
    	String[] split = array.get(i).split(" ");
    	for(int j = 97; j<=122; j++)
    	{
    		boolean allContains = true;
    		for(String a: split)
    		{
    			String c = Character.toString((char) j);
    			if(a.indexOf(c) == -1)
    				allContains = false;
    		}
    		if(allContains)
    			sum++;
    	}
    }
    System.out.println(sum);   
  }
}