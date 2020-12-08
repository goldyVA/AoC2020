import java.io.File;  // Import the File class
import java.io.FileNotFoundException;  // Import this class to handle errors
import java.util.*; // Import the Scanner class to read text files


public class Day8 
{
  public static void main(String[] args) 
  {
    ArrayList<Instruction> list = new ArrayList<Instruction>();
    
    try 
    {
    	Scanner scan = new Scanner(new File("day8.txt"));
    	while(scan.hasNextLine())
    	{
    		String a = scan.next();
    		int b = scan.nextInt();
    		list.add(new Instruction(a,b));
    	}
    }
    catch(Exception e) 
    {	
    }
    
    
    //part 1
    int accumulator = 0;
    int position = 0;
    boolean done = false;
    while(!done)
    {
    	String nextOperation = list.get(position).getOperation();
    	list.get(position).execute();
    	if(nextOperation.equals("nop"))
    	{
    		position++;
    		if(list.get(position).hasBeenExecuted())
    		{
    			done = true;
    		}
    			
    	}
    	else if(nextOperation.equals("acc"))
    	{
    		accumulator += list.get(position).getArgument();
    		position++;
    		if(list.get(position).hasBeenExecuted())
    		{
    			done = true;
    		}
    	}
    	else
    	{
    		position += list.get(position).getArgument();
    		if(list.get(position).hasBeenExecuted())
    		{
    			done = true;
    		}
    	}
    }
    
    System.out.println(accumulator);
    
    
    
    //part 2 
    for(int i = 0; i<list.size(); i++)
    {
    	list.get(i).changeOperation();
    	//System.out.println(list.get(i).toString());
    	 accumulator = 0;
    	 position = 0;
    	 
    	 done = false;
    	 int count = 0;
    	 while(!done && count<640)
    	 {
    		 count++;
    		 String nextOperation = list.get(position).getOperation();
    		 if(nextOperation.equals("nop"))
    		 {
    			 position++;
    			 if(position == list.size()-1)
    			 {
    				 done = true;
    			 }
    	    			
    		 }
    		 else if(nextOperation.equals("acc"))
    		 {
    	 		accumulator += list.get(position).getArgument();
    	 		position++;
    	 		if(position == list.size()-1)
    	 		{
    	 			done = true;
    	    	}
    		 }
    		 else
    		 {
    			 position += list.get(position).getArgument();
    			 if(position == list.size()-1)
    			 {
    				 done = true;
    			 }
    		 }
    	 }
    	 
    	 if(done)
    	 {
    		 System.out.println(accumulator);
    		 break;
    	 }
    	 
    	 list.get(i).changeOperation();
    	
    	 System.out.println();
    }
    
    
    
  }
}