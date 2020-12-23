import java.io.File;  // Import the File class
import java.io.FileNotFoundException;  // Import this class to handle errors
import java.util.*; // Import the Scanner class to read text files


public class Day22Part2 
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
    	int yourCard = you.remove(0);
    	int crabCard = crab.remove(0);
    	
    	if(yourCard <= you.size() && crabCard <=crab.size())
    	{
    		String winner = recursiveCombat(yourCard, crabCard, you,crab);
    		if(winner.equals("you"))
    		{
    			you.add(yourCard);
    			you.add(crabCard);
    		}
    		else
    		{
    			crab.add(crabCard);
    			crab.add(yourCard);
    		}
    	}
    	else
    	{
    		if(yourCard > crabCard)
    		{
    			you.add(yourCard);
    			you.add(crabCard);
    		}
    		else
    		{
    			crab.add(crabCard);
    			crab.add(yourCard);
    		}
    	}
    }
    
    int count = 0;
    while(crab.size()>0)
    {
    	count += crab.size()*crab.remove(0);
    }
    System.out.println(count);
    count = 0;
    while(you.size()>0)
    {
    	count += you.size()*you.remove(0);
    }
    System.out.println(count);
    
    
  }
  
  public static String handToString(ArrayList<Integer> deck)
  {
	  String x ="";
	  for(int y: deck)
	  {
		  x+= y+ " ";
	  }
	  return x;
  }
  
  public static String recursiveCombat(int y, int c, ArrayList<Integer> yDeck, ArrayList<Integer> cDeck)
  {
	  ArrayList<String> youPrevious = new ArrayList<String>();
	  ArrayList<String> crabPrevious = new ArrayList<String>();
	  
	  ArrayList<Integer> yCopy = new ArrayList<Integer>();
	  ArrayList<Integer> cCopy = new ArrayList<Integer>();
	  
	  for(int i: yDeck)
		  yCopy.add(i);
	  for(int i: cDeck)
		  cCopy.add(i);
	  
	  while(yCopy.size()>y)
		  yCopy.remove(yCopy.size()-1);
	  while(cCopy.size()>c)
		  cCopy.remove(cCopy.size()-1);
	  
	
	  while(yCopy.size()!=0 && cCopy.size()!=0)
	  {
		  if(youPrevious.contains(handToString(yCopy)) || crabPrevious.contains(handToString(cCopy)))
		  {
		    	return "you";
		  }
		  youPrevious.add(handToString(yCopy));
		  crabPrevious.add(handToString(cCopy));
		  
		  int yourCard = yCopy.remove(0);
		  int crabCard = cCopy.remove(0);
		  if(yourCard <= yCopy.size() && crabCard <=cCopy.size())
		  {
	    		String winner = recursiveCombat(yourCard, crabCard, yCopy,cCopy);
	    		if(winner.equals("you"))
	    		{
	    			yCopy.add(yourCard);
					yCopy.add(crabCard);
	    		}
	    		else
	    		{
	    			cCopy.add(crabCard);
					cCopy.add(yourCard);
	    		}
		  }
		  else
		  {
			  if(yourCard > crabCard)
			  {
				  yCopy.add(yourCard);
				  yCopy.add(crabCard);
			  }
			  else
			  {
				  cCopy.add(crabCard);
				  cCopy.add(yourCard);
			  }
		  }  
	  }
	  if(cCopy.size()==0)
		  return "you";
	  else
		  return "crab"; 
  }
}