	#include <stdio.h>
	#include <string.h>
	#include <math.h>
	#pragma warning (disable:4996)

void merge(int a[], int low, int mid, int high) {
	int b[1000000];
	int i = low;
	int j = mid + 1;
	int k = 0;
	while (i <= mid&&j<=high) {
		if (a[i] <= a[j]) {
			b[k] = a[i];
			i++;
			k++;
		}
		else {
			b[k] = a[j];
			j++;
			k++;
		}
	}
	while (i <= mid) {
		b[k] = a[i];
		i++;
		k++;
	}
	while (j <= high) {
		b[k] = a[j];
		j++;
		k++;
	}
	k--;
	while (k >= 0) {
		a[low + k] = b[k];
		k--;
	}
}
void mergesort(int a[], int low, int high) {
	int mid = (low + high) / 2;
	if (low < high) {
		mergesort(a, low, mid);
		mergesort(a, mid + 1, high);
		merge(a, low, mid, high);

	}
	else return;
}
int main() {
	int a[1000000];
	int k;
	
	scanf("%d", &k);
	for (int i = 0;i < k;i++)scanf("%d", &a[i]);

	mergesort(a, 0, k-1);
	for (int i = k-1;i >= 0;i--)printf("%d\n", a[i]);
}