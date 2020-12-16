import java.util.HashMap;

public class Day15Part2 
{
	public static void main(String[] args) 
	{
		HashMap<Integer,Integer> list = new HashMap<Integer,Integer>();
		list.put(2, 1);
		list.put(0, 2);
		list.put(6, 3);
		list.put(12, 4);
		list.put(1, 5);
		
		int nextNumber=3;
		
		for(int i = 6; i <30000000; i++)
		{
			int temp = nextNumber;
			if(list.containsKey(temp))
				nextNumber = i - list.get(temp); 
			else
				nextNumber = 0;
            list.put(temp, i);
			
		}
		
		System.out.println(nextNumber);
		
	}
}
