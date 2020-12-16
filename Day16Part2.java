import java.io.File;  // Import the File class
import java.io.FileNotFoundException;  // Import this class to handle errors
import java.util.*; // Import the Scanner class to read text files


public class Day16Part2
{
  public static void main(String[] args) 
  {
    ArrayList<int[]> range = new ArrayList<int[]>();
    
    try 
    {
    	Scanner scan = new Scanner(new File("day16pt1.txt"));
    	while(scan.hasNextLine())
    	{
    		String x = scan.nextLine();
    		String[] temp = x.split(": |-| or ");
    		int first = Integer.parseInt(temp[1]);
    		int second = Integer.parseInt(temp[2]);
    		int third = Integer.parseInt(temp[3]);
    		int fourth = Integer.parseInt(temp[4]);
    		int[] input = {first,second,third,fourth};
    		range.add(input);
    	}
    }
    catch(Exception e) 
    {	
    }
    
    int[] myTicket = {127,109,139,113,67,137,71,97,53,103,163,167,131,83,157,101,107,79,73,89};
    
    ArrayList<int[]> tickets = new ArrayList<int[]>();
    try 
    {
    	Scanner scan = new Scanner(new File("day16data.txt"));
    	while(scan.hasNextLine())
    	{
    		String x = scan.nextLine();
    		String[] y = x.split(",");
    		int[] z = new int[y.length];
    		for(int i = 0; i < z.length; i++)
    		{
    			z[i] = Integer.parseInt(y[i]);
    		}
    		tickets.add(z);
    	}
    }
    catch(Exception e) 
    {	
    }
    
    
    ArrayList<int[]> validTickets = new ArrayList<int[]>();
    
    
    ArrayList<Integer> val = new ArrayList<Integer>();
    for(int[] x : range)
    {
    	for(int i = x[0]; i <= x[1]; i++)
    	{
    		if(!val.contains(i))
    			val.add(i);
    	}
    	for(int i = x[2]; i <= x[3]; i++)
    	{
    		if(!val.contains(i))
    			val.add(i);
    	}
    }
    
    
    Collections.sort(val);
    
   
    for(int[] x : tickets)
    {
    	boolean isValid = true;
    	for(int i = 0; i <x.length;i++)
    	{
    		if(!val.contains(x[i]))
    		{
    			isValid = false;
    		}
    	}
    	
    	if(isValid)
    	{
    		validTickets.add(x);
    	}
    }
    
    
    
    //PART 2 START

    for(int i = 0; i < range.size(); i++)
    {
    	for(int j = 0; j< range.size(); j ++)
    	{
    		System.out.print(checkColumn(validTickets,range,i,j)+ " ");
    	}
    	System.out.println();
    }
    

  }
  
  public static boolean checkColumn(ArrayList<int[]> tickets, ArrayList<int[]> ranges, int column, int row)
  {
	  boolean isValid = true;
	  for(int i = 0; i < tickets.size(); i++)
	  {
		  int ticketVal = tickets.get(i)[column];
		  //System.out.println(ticketVal + "     " + ranges.get(row)[0] + " " + ranges.get(row)[1] + " " + ranges.get(row)[2] + " " + ranges.get(row)[3]);
		  if((ticketVal>=ranges.get(row)[0] && ticketVal<=ranges.get(row)[1])||(ticketVal>=ranges.get(row)[2] && ticketVal<=ranges.get(row)[3]))
		  {  
			  //System.out.println("Yes");
		  }
		  else
		  {
			 // System.out.println("No");
			  isValid = false;
		  } 
	  } 
	  return isValid;
  }
  
  
 
  
}