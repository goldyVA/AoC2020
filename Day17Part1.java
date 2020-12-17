import java.io.File; // Import the File class
import java.io.FileNotFoundException; // Import this class to handle errors
import java.util.*; // Import the Scanner class to read text files

public class Day17Part1 {
	public static void main(String[] args) {

		ArrayList<String> input = new ArrayList<String>();
		ArrayList<int[][]> grid = new ArrayList<int[][]>();
		try {
			Scanner scan = new Scanner(new File("day17.txt"));
			while (scan.hasNextLine()) {
				input.add(scan.nextLine());
			}
		} catch (Exception e) {
		}

		int[][] layer = new int[30][30];
		for (int i = 0; i < 8; i++) {
			String[] temp = input.get(i).split("");
			for (int j = 0; j < 8; j++) {
				String x = temp[j];
				int value = x.equals("#") ? 1 : 0;
				layer[i + 10][j + 10] = value;
			}
		}
		for (int i = 0; i < 10; i++)
			grid.add(new int[30][30]);
		grid.add(10, layer);
		for (int i = 11; i < 20; i++)
			grid.add(new int[30][30]);

		for (int v = 0; v < 6; v++) {
			ArrayList<String> toChange = new ArrayList<String>();
			for (int i = 1; i < 29; i++) {
				for (int j = 1; j < 29; j++) {
					for (int k = 1; k < 19; k++) {
						ArrayList<String> near = nearby(i, j, k);
						int[][] temporary = grid.get(k);
						int count = 0;
						for (String loop : near) {
							String[] loop1 = loop.split(",");
							int d = Integer.parseInt(loop1[0]);
							int e = Integer.parseInt(loop1[1]);
							int f = Integer.parseInt(loop1[2]);
							if (grid.get(f)[d][e] == 1)
								count++;
						}
						if (grid.get(k)[i][j] == 1) {
							if (count == 2 || count == 3) {
							} else {
								toChange.add(i + "," + j + "," + k);
							}
						} else {
							if (count == 3) {
								toChange.add(i + "," + j + "," + k);
							}
						}
					}
				}
			}

			for (String a : toChange) {
				String[] split = a.split(",");
				int d = Integer.parseInt(split[0]);
				int e = Integer.parseInt(split[1]);
				int f = Integer.parseInt(split[2]);
				if (grid.get(f)[d][e] == 1)
					grid.get(f)[d][e] = 0;
				else
					grid.get(f)[d][e] = 1;
			}

		}

		// Count
		int count = 0;
		for (int i = 1; i < 29; i++) {
			for (int j = 1; j < 29; j++) {
				for (int k = 1; k < 19; k++) {
					if (grid.get(k)[i][j] == 1)
						count++;
				}
			}
		}
		System.out.println(count);

	}

	public static ArrayList<String> nearby(int x, int y, int z) {
		ArrayList<String> near = new ArrayList<String>();
		for (int i = x - 1; i <= x + 1; i++) {
			for (int j = y - 1; j <= y + 1; j++) {
				for (int k = z - 1; k <= z + 1; k++) {
					if (i == x && j == y && k == z) {

					} else
						near.add(i + "," + j + "," + k);
				}
			}
		}

		return near;
	}

}