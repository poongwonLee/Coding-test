import java.io.*;
import java.util.*;

public class Main {

	static int N, M, T;
	static int[][] tmpMap, map;
	static int[] dx = { 0, 0, 1, -1 }, dy = { 1, -1, 0, 0 };

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		T = Integer.parseInt(st.nextToken());

		map = new int[N][M];
		int upX = -1, upY = 0;
		int downX = -1, downY = 0;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == -1 && upX == -1) {
					upX = i;
					upY = j;
				} else if (map[i][j] == -1 && upX != -1) {
					downX = i;
					downY = j;
				}
			}
		}
		while (T-- != 0) {
			tmpMap = new int[N][M];
			for (int x = 0; x < N; x++) {
				for (int y = 0; y < M; y++) {
					int cnt = 0;
					for (int k = 0; k < 4; k++) {
						int xx = x + dx[k];
						int yy = y + dy[k];

						if (!(0 <= xx && xx < N && 0 <= yy && yy < M && map[x][y] > 0))
							continue;
						if(map[xx][yy]==-1)continue;
						cnt++;
						tmpMap[xx][yy] += map[x][y] / 5;

					}
					tmpMap[x][y] += map[x][y] - (map[x][y] / 5 * cnt);
				}
			}
			
		
			
			for(int i=0;i<N;i++) {
				for(int j=0;j<M;j++) {
					map[i][j]=tmpMap[i][j];
				}
			}
			
			for(int i=upX-1;i>=1;i--) 
				map[i][0]=map[i-1][0];
			
			for(int j=0;j<M-1;j++)
				map[0][j]=map[0][j+1];
			
			for(int i=0;i<upX;i++) 
				map[i][M-1]=map[i+1][M-1];
			
			for(int j=M-1;j>=2;j--)
				map[upX][j]=map[upX][j-1];
			map[upX][1]=0;
			
			
			for(int i=downX+1;i<N-1;i++) 
				map[i][0]=map[i+1][0];
			
			for(int j=0;j<M-1;j++)
				map[N-1][j]=map[N-1][j+1];
			
			for(int i=N-1;i>=downX;i--) 
				map[i][M-1]=map[i-1][M-1];
			
			for(int j=M-1;j>=2;j--)
				map[downX][j]=map[downX][j-1];
			map[downX][1]=0;
			
			
		}
		int res=0;
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				res+=map[i][j];
			}
		}
		System.out.println(res+2);

	}
}
