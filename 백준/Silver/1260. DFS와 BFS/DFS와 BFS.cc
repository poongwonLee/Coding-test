#include <iostream>
#include<string>
#include <queue>
#include <vector>
#include<set>
#include<map>

#include <algorithm>
#include <stack>
#include <string.h>
#include<cstdio>
#include<cstdlib>

using namespace std;

int ch[1001] = { 0, };
int arr[1001][1001];
int a, b, c;
void dfs(int L) {
	ch[L] = 1;
	printf("%d " , L);
	for (int i = 1; i <= a; i++) {
		if (ch[i] == 1 || arr[L][i] == 0)continue;
			dfs(i);
	}
}
int main()
{
	
	int x, y, z;
	scanf("%d %d %d", &a, &b, &c);
	for (int i = 0; i < b; i++) {
		scanf("%d %d", &x, &y);
		arr[x][y] = 1;
		arr[y][x] = 1;
	}
	dfs(c);
	printf("\n");
	int ch[1001] = { 0, };
	queue <int> q;
	q.push(c);
	ch[c] = 1;
	while (!q.empty()) {
		int tmp = q.front();
		q.pop();
		printf("%d ", tmp);
		for (int i = 1; i <= a; i++) {
			if (ch[i] == 0 && arr[tmp][i] != 0) {
				q.push(i);
				ch[i] = 1;
			}
		}
	}
}