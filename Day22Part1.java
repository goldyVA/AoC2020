import java.io.File;  // Import the File class
import java.io.FileNotFoundException;  // Import this class to handle errors
import java.util.*; // Import the Scanner class to read text files


public class Day22Part1 
{
  public static void main(String[] args) 
  {
	ArrayList<String> list = new ArrayList<String>();
    ArrayList<Integer> you = new ArrayList<Integer>();
    ArrayList<Integer> crab = new ArrayList<Integer>();
    
    try 
    {
    	Scanner scan = new Scanner(new File("day22.txt"));
    	while(scan.hasNextLine())
    	{
    		list.add(scan.nextLine());
    	}
    }
    catch(Exception e) 
    {	
    }
    
    list.remove(0);
    list.remove(25);
    for(int x = 0; x<25;x++)
    	you.add(Integer.parseInt(list.get(x)));
    for(int x = 25; x<50;x++)
    	crab.add(Integer.parseInt(list.get(x)));
    
    while(you.size()!=0 && crab.size()!=0)
    {
    	int y = you.remove(0);
    	int c = crab.remove(0);
    	
    	if(y > c)
    	{
    		you.add(y);
    		you.add(c);
    	}
    	else
    	{
    		crab.add(c);
    		crab.add(y);
    	}
    }
   
    int count = 0;
    while(you.size()>0)
    {
    	count += you.size()*you.remove(0);
    }
    System.out.println(count);
    
    count = 0;
    while(crab.size()>0)
    {
    	count += crab.size()*crab.remove(0);
    }
    System.out.println(count);
    
    
  }
}