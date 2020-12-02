import java.io.File; // Import the File class
import java.io.FileNotFoundException; // Import this class to handle errors
import java.util.*; // Import the Scanner class to read text files

public class Day2Updated {
	public static void main(String[] args) {
		ArrayList<String> list = new ArrayList<String>();

		try {
			Scanner scan = new Scanner(new File("day2.txt"));
			while (scan.hasNext()) {
				list.add(scan.nextLine());
			}
		} catch (Exception e) {
		}

		// Part 1
		int count = 0;

		for (int i = 0; i < list.size(); i++) {
			String whole = list.get(i);
			String[] parts = whole.split(" |-|: ");

			int number = 0;
			for (int a = 0; a < parts[3].length(); a++) {
				if (parts[3].substring(a, a + 1).equals(parts[2]))
					number++;

			}

			if (number >= Integer.parseInt(parts[0]) && number <= Integer.parseInt(parts[1]))
				count++;

		}
		System.out.println(count);

		// Part 2
		count = 0;
		for (int i = 0; i < list.size(); i++) {

			String whole = list.get(i);
			String[] parts = whole.split(" |-|: ");

			int first = 0;
			int second = 0;
			if (parts[3].substring(Integer.parseInt(parts[0]) - 1, Integer.parseInt(parts[0])).equals(parts[2]))
				first++;
			if (parts[3].substring(Integer.parseInt(parts[1]) - 1, Integer.parseInt(parts[1])).equals(parts[2]))
				second++;

			if ((first + second) == 1) {
				count++;
			}

		}
		System.out.println(count);

	}
}