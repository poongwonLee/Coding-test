#define _CRT_SECURE_NO_WARNINGS
#include<iostream>
#include<queue>
#include<vector>
#include<stdio.h>
#include<algorithm>

using namespace std;

int L, C, cnt,check[15];
char ch[15];
string str;
void func(int k, int a, int b, string str,int idx) {
	if (L == k) {

		if (a >= 1 && b >= 2) {
			cout << str << endl;
		}
	}
	else {
		for (int i = idx+1; i < C; i++) {
			if (check[i] == 0) {
				check[i] = 1;
				if (ch[i] == 'a' || ch[i] == 'e' || ch[i] == 'i' || ch[i] == 'o' || ch[i] == 'u')
					a += 1;
				else b += 1;

				func(k+ 1, a, b, str + ch[i],i);
				if (ch[i] == 'a' || ch[i] == 'e' || ch[i] == 'i' || ch[i] == 'o' || ch[i] == 'u')
					a -= 1;
				else b -= 1;
				check[i] = 0;
			}

		}
	}
}
int main() {
	scanf("%d %d", &L, &C);
	getchar();
	for (int i = 0; i < C; i++) {
		scanf("%c", &ch[i]);
		getchar();
	}
	sort(ch, ch + C);
	func(0, 0, 0, "",-1);
}