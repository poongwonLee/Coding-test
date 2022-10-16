#include <iostream>
#include<vector>
#include<algorithm>
using namespace std;
int main() {

	int n, m, w, v;
	cin >> n >> m;
	vector<int> dy(m + 1, 0);
	for (int i = 0; i < n; i++) {
		cin >> w >> v;
		for (int j = m; j >= w; j--) {
			dy[j] = max(dy[j],dy[j-w]+v);
		}
	}
	cout << dy[m];
	return 0;
}