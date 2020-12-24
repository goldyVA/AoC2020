import java.io.File;  // Import the File class
import java.io.FileNotFoundException;  // Import this class to handle errors
import java.util.*; // Import the Scanner class to read text files


public class Day23Part1
{
  public static void main(String[] args) 
  {
    
    String start = "158937462";
    ArrayList<Integer> list = new ArrayList<Integer>();
    for(int i = 0; i<start.length(); i++)
    {
    	list.add(Integer.parseInt(start.substring(i, i+1)));
    }
    
    int currentNum = list.get(0);
    int currentPos = 0;
	
	int next1 = -1;
	int next2 = -1;
	int next3 = -1;
    for(int i = 0; i <100; i++)
    {
    	currentNum = list.get(currentPos);
    	
    	int nextPick = currentPos;
    	if(nextPick == 8)
    		nextPick=-1;
    	next1 = list.remove(nextPick+1);
    	if(nextPick == 7)
    		nextPick=-1;
    	next2 = list.remove(nextPick+1);
    	if(nextPick == 6)
    		nextPick=-1;
    	next3 = list.remove(nextPick+1);
    	
    	int targetNum = destinationNum(currentNum,next1,next2,next3);
    	int targetPos = -1;
    	for(int j =0;j<list.size();j++)
    	{
    		if(list.get(j) == targetNum)
    			targetPos = j;
    	}
    	
    	list.add(targetPos+1, next1);
    	list.add(targetPos+2, next2);
    	list.add(targetPos+3, next3);
        
        for(int j = 0; j <list.size(); j++)
        	if(currentNum == list.get(j))
        		currentPos = j;
        
        currentPos++;
    	if(currentPos == list.size())
    		currentPos = 0;
    }
    
    int onePos = -1;
    for(int i =0; i <list.size();i++)
    {
    	if(list.get(i) ==1)
    		onePos = i;
    }
    
    for(int i = onePos+1; i<list.size();i++)
    	System.out.print(list.get(i));
    for(int i =0; i<onePos; i++)
    	System.out.print(list.get(i));
  }
  
  public static int destinationNum(int current, int pick1, int pick2, int pick3)
  {
	boolean done = false;
	if(current==1)
		current = 9;
	else
		current--;
	while(!done)
	{
		if(current==pick1 || current==pick2 ||current==pick3)
		{
			if(current==1)
				current = 9;
			else
				current--;
		}
		else
			done = true;
	}
	  
	return current;
  }
  
}