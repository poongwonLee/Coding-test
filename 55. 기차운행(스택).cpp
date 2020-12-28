#define _CRT_SECURE_NO_WARNINGS
#include <iostream>
#include <vector>
#include <queue>
#include <algorithm>
#include <stack>
#include <string.h>
using namespace std;
int main() {
	int n, x[30], idx = 0;
	stack<int> s;
	vector<char> str;
	scanf("%d", &n);

	for (int i = 0; i < n; i++)scanf("%d", &x[i]);

	

	for (int i = 1; i <= n; ) {
		
		if (s.empty() && idx != n) {
			s.push(x[idx++]);
			str.push_back('P');
			
		}
		else if (s.top() == i) {
			s.pop();
			i++;
			str.push_back('O');
		}
		else {
			s.push(x[idx++]);
			str.push_back('P');

		}
		if (s.empty()==0 && idx > n &&i>n) {
			
			break;
		}

	}
	if (s.empty() == 0)printf("impossible");
	else {
		for (int i = 0; i < str.size(); i++)printf("%c", str[i]);
	
	}
	

}