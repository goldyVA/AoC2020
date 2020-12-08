import java.io.File;  // Import the File class
import java.io.FileNotFoundException;  // Import this class to handle errors
import java.util.*; // Import the Scanner class to read text files


public class Day7Part1
{
  public static void main(String[] args) 
  {
    ArrayList<String> list = new ArrayList<String>();
    ArrayList<String[]> formatted = new ArrayList<String[]>();
    
    try 
    {
    	Scanner scan = new Scanner(new File("day7.txt"));
    	while(scan.hasNextLine())
    	{
    		list.add(scan.nextLine());
    	}
    }
    catch(Exception e) 
    {	
    }
    
    //creates an array list called formatted with the formatted bags and what they contain
    for(int i = 0; i < list.size(); i++)
    {
    	String[] split = list.get(i).split(" contain |, ");
    	String[] temp = new String[split.length];
    	temp[0]=split[0].substring(0,split[0].indexOf(" bag"));
    	for(int j = 1; j<split.length;j++)
    	{
    		if(split[j].indexOf("other") != -1)
    			temp[j]=split[j];
    		else
    			temp[j]=split[j].substring(2,split[j].indexOf(" bag")) + ","+split[j].charAt(0);		
    	}
    	formatted.add(temp);
    }
    
    /*
    for(String[] x : formatted)
    {
    	for(String y: x)
    	{
    		System.out.println(y);
    	}
    	System.out.println();
    }
    */
    
    
    for(String[] x : formatted)
    {
    	rule(x[0],formatted);
    	System.out.println();
    	//sum+=rule(x[0],formatted);
    }
    
    
    
 
    ArrayList<String> gold = new ArrayList<String>();
    
    try 
    {
    	Scanner scan = new Scanner(new File("shinygold.txt"));
    	while(scan.hasNext())
    	{
    		gold.add(scan.next());
    	}
    }
    catch(Exception e) 
    {	
    }
    
    System.out.println(gold.size());
    
    
  }
  
  
  public static int rule(String x, ArrayList<String[]> formatted)
  {
	  //System.out.println(x);
	  for(String[] y : formatted)
	  {
		  if(y[0].indexOf(x)!=-1)
		  {
			  //System.out.println(y[0]);
			  if(y[1].indexOf("other")!=-1)
			  {
				 // System.out.println("one");
				  return 0;
			  }
			  for(int i = 1; i < y.length; i++)
			  {
				  if(y[i].indexOf("shiny gold")!=-1)
				  {
					  System.out.print("SHINYGOLD");
					  return 1;
				  }
				  else 
				  {
					  //System.out.println("three");
					  rule(y[i].substring(0,y[i].length()-2),formatted);
				  }
					  
			  }
		  }

		  
	  }
	  //System.out.println("four");
	  return 0;
  }
}