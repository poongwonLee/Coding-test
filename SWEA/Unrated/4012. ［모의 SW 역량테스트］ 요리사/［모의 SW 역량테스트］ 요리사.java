import java.util.*;
import java.io.*;
import java.lang.reflect.Array;

class Solution {
	static int n, min ;
	static int arr[][];
	static int[] select;

	static void dfs(int v, int idx) {
		if (v == n / 2 - 1) {
			ArrayList<Integer> listA = new ArrayList<>();
			ArrayList<Integer> listB = new ArrayList<>();
			for (int i = 0; i < select.length; i++) {
				if (select[i] == 0)
					listA.add(i);
				else
					listB.add(i);
			}
			int sum=0;
			for(int i=0;i<listA.size();i++) {
				for(int j=i+1;j<listA.size();j++) {
					sum+=arr[listA.get(i)][listA.get(j)];
					sum+=arr[listA.get(j)][listA.get(i)];
				}
			}
			int sum2=0;
			for(int i=0;i<listB.size();i++) {
				for(int j=i+1;j<listB.size();j++) {
					sum2+=arr[listB.get(i)][listB.get(j)];
					sum2+=arr[listB.get(j)][listB.get(i)];
				}
			}
			min=Math.min(min, Math.abs(sum-sum2));
			return;
		}
		for (int i = idx; i < n - 1; i++) {
			select[i + 1] = 1;
			dfs(v + 1, i + 1);
			select[i + 1] = 0;
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();

		int testcase = Integer.parseInt(br.readLine());
		for (int test = 1; test <= testcase; test++) {
			min = Integer.MAX_VALUE;
			n = Integer.parseInt(br.readLine());
			arr = new int[n][n];
			for (int i = 0; i < n; i++) {
				String[] str = br.readLine().split(" ");
				for (int j = 0; j < n; j++)
					arr[i][j] = Integer.parseInt(str[j]);
			}
			select = new int[n];
			select[0] = 1;
			dfs(0, 0);

			sb.append("#").append(test).append(" ");
			sb.append(min).append("\n");
		}
		System.out.println(sb);
	}
}
