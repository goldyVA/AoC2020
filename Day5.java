import java.io.File; // Import the File class
import java.io.FileNotFoundException; // Import this class to handle errors
import java.util.*; // Import the Scanner class to read text files

public class Day5 
{
	public static void main(String[] args) 
	{
		ArrayList<String> list = new ArrayList<String>();
		ArrayList<Integer> passes = new ArrayList<Integer>();

		try 
		{
			Scanner scan = new Scanner(new File("day5.txt"));
			while (scan.hasNextLine()) 
			{
				list.add(scan.next());
			}
		} catch (Exception e) 
		{
		}

		//part 1
		int max = 0;
		for (String x : list) 
		{
			int low = 0;
			int high = 127;
			int mid = (low + high) / 2;

			for (int i = 0; i<8; i++) 
			{
				if (x.charAt(i) == 'F') 
				{
					high = mid;
					mid = (low + high) / 2;
				}
				if (x.charAt(i) == 'B') 
				{
					low = mid + 1;
					mid = (low + high) / 2;
				}
			}
			int row = mid;
			low = 0;
			high = 7;
			mid = (low + high) / 2;
		
			for (int i = 7; i < 10; i++) 
			{
				if (x.charAt(i) == 'L') 
				{
					high = mid;
					mid = (low + high) / 2;
				}
				if (x.charAt(i) == 'R') 
				{
					low = mid + 1;
					mid = (low + high) / 2;
				}
			}
			int column = mid;

			int seatID = row * 8 + column;
			if(seatID>max)
				max=seatID;
			passes.add(seatID); //for part 2
		}
		
		System.out.println(max);
		
		
		//part 2
		//all seat IDs already added to passes
		
		Collections.sort(passes);
		for(int i = 1; i < passes.size();i++)
		{
			if(passes.get(i)-passes.get(i-1)==2)
				System.out.println((passes.get(i-1)+passes.get(i))/2);
		}
	}
}