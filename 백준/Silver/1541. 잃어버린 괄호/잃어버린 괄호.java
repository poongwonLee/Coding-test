import java.io.*;
import java.util.*;

public class Main {
	static TreeMap<Integer, Integer> tm = new TreeMap<>();

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String str = br.readLine();
		String[] strList = str.split("-");

		ArrayList<Integer> arr = new ArrayList<>();
		for (int i = 0; i < strList.length; i++) {
			int addNum = 0;
			if (strList[i].contains("+")) {
				
				String[] tmpList = strList[i].split("\\+");
				for (int j = 0; j < tmpList.length; j++)
					addNum += Integer.parseInt(tmpList[j]);
				
			} else
				addNum = Integer.parseInt(strList[i]);
			arr.add(addNum);
		}
		
		
		int res=arr.get(0);
		for (int i = 1; i < arr.size(); i++)
			res-=arr.get(i);
		System.out.println(res);
	}
}