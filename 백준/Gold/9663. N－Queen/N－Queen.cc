#define _CRT_SECURE_NO_WARNINGS
#include<iostream>
#include<queue>
#include<vector>
#include<stdio.h>

using namespace std;

int n, cnt, col[15];

int attack(int r1, int c1, int r2, int c2) {
	if (c1 == c2)return true;
	if (r1 - c1 == r2 - c2)return true;
	if (r1 + c1 == r2 + c2)return true;
	return false;
}
void func(int row) {
	if (row == n) {
		cnt++;
	}
	else {
		for (int c = 0; c < n; c++) {
			bool check = true;
			for (int i = 0; i < row ; i++) {
				if (attack(row, c, i, col[i])) {
					check = false;
					break;
				}
			}
			if (check) {
				col[row] = c;
				func(row + 1);
				col[row] = 0;
			}
		}
	}
}
int main() {
	scanf("%d", &n);
	func(0);
	printf("%d", cnt);
}