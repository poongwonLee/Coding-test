#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h>
#include<string.h>
#include<stdlib.h>
#include<stdbool.h>
#define min1(a,b)(a<b?a:b)
#define min2(a,b,c)(min1(a,b)<c?min1(a,b):c)
int main() {
	int n, i, a, b, c;
	int x[1000001] = { 0, };
	scanf("%d", &n);
	for (i = 2; i <= n; i++) {
		a = b = c = 9999999;
		if (i % 3 == 0)a = x[i / 3];
		if (i % 2 == 0)b = x[i / 2];
		c = x[i - 1];
		x[i] = min2(a, b, c)+1;
	}
	printf("%d", x[n]);
	
}