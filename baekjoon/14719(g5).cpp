#define _CRT_SECURE_NO_WARNINGS
#include<stdio.h>
#include<stdlib.h>
#include<math.h>
#include<string.h>

int main() {
	int res = 0;
	int n, m, arr[500];

	scanf("%d %d", &n, &m);
	for (int i = 0; i < m; i++)scanf("%d", &arr[i]);

	for (int i = 1; i < m-1; i++) {
		int left = 0, rigth = 0;
		for (int j = 0; j < i; j++)
			if (left < arr[j]) left = arr[j];

		for (int j = m-1; j > i; j--)
			if (rigth < arr[j])rigth = arr[j];
	
		if (left > arr[i] && rigth > arr[i])
			res += (left < rigth ? left : rigth)-arr[i];
	}
	printf("%d", res);
}
