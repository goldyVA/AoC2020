import java.io.File;  // Import the File class
import java.io.FileNotFoundException;  // Import this class to handle errors
import java.util.*; // Import the Scanner class to read text files


public class Day2 
{
  public static void main(String[] args) 
  {
    ArrayList<String> list = new ArrayList<String>();
    
    try 
    {
    	Scanner scan = new Scanner(new File("day2.txt"));
    	while(scan.hasNext())
    	{
    		list.add(scan.nextLine());
    	}
    }
    catch(Exception e) 
    {	
    }
    
    //Part 1
    int low = 0;
    int high =0;
    String letter = "";
    String password = "";
    int count = 0;
    
    for(int i = 0; i < list.size(); i++)
    {
    	String whole = list.get(i);
    	low = Integer.parseInt(whole.substring(0,whole.indexOf("-")));
    	whole = whole.substring(whole.indexOf("-")+1);
    	high = Integer.parseInt(whole.substring(0,whole.indexOf(" ")));
    	whole = whole.substring(whole.indexOf(" ")+1);
    	letter = whole.substring(0,1);
    	whole = whole.substring(whole.indexOf(" ")+1);
    	password = whole;
    	
    	int number = 0;
    	for(int a = 0; a<password.length();a++)
    	{
    		if(password.substring(a,a+1).equals(letter) )
    			number++;
    	}
    	
    	if(number >= low && number <= high)
    		count++;	
    }
    System.out.println(count);
    
    
    //Part 2
    count = 0;
    for(int i = 0; i < list.size(); i++)
    {
    	String whole = list.get(i);
    	low = Integer.parseInt(whole.substring(0,whole.indexOf("-")));
    	whole = whole.substring(whole.indexOf("-")+1);
    	high = Integer.parseInt(whole.substring(0,whole.indexOf(" ")));
    	whole = whole.substring(whole.indexOf(" ")+1);
    	letter = whole.substring(0,1);
    	whole = whole.substring(whole.indexOf(" ")+1);
    	password = whole;
    	
    	int first = 0;
    	int second = 0;
    	if(password.substring(low-1,low).equals(letter))
    		first++;
    	if(password.substring(high-1,high).equals(letter))
    		second++;
    	
    	if((first+second) == 1)
    	{
    		count++;
    	}
    }
    System.out.println(count);
  }
}
