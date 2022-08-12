#include <iostream>
#include<string>
#include <vector>
#include <queue>
#include <algorithm>
#include <stack>
#include <string.h>
#include<cstdio>
#include<cstdlib>

using namespace std;
int n, m,MIN=2100000000;
int ch[14], arr[50][50],res,sum;
vector <pair<int, int> > chic;
vector <pair<int, int> > hs;
void dfs(int s,int L) {
	if (m == L) {
		int sum2 = 0, dis;
		for (int i = 0; i < hs.size(); i++) {
			 dis = 2140000000;
			for (int j = 0; j < m; j++) {
				sum= abs(hs[i].first - chic[ch[j]].first) + abs(hs[i].second - chic[ch[j]].second);
				if (dis > sum)dis = sum;
			}
			sum2 += dis;
		}
		if (MIN > sum2)MIN = sum2;
		
		
	}
	else {
		for (int i = s; i < chic.size(); i++) {
			ch[L] = i;
			dfs(i + 1, L + 1);
		}

	}

	
}
int main() {
	int a;
	scanf("%d %d", &n, &m);

	for (int i = 0; i < n; i++) {
		for (int j = 0; j < n; j++) {
			scanf("%d", &a);
			if (a == 1)hs.push_back(make_pair(i,j));
			if (a == 2)chic.push_back(make_pair(i,j));
		}
	}
	dfs(0, 0);
	printf("%d", MIN);
	return 0;
}