//#include </usr/local/include/bits/stdc++.h>
////#include <bits/stdc++.h>
//#define ms(x, a) memset(x, a, sizeof(x))
//const int MX = 1e5+5;
//
//using namespace std;
//typedef pair<int, int> pi;
//typedef long long ll;
//#define f first
//#define s second
//
//int gcd(int a, int b){
//    return b == 0 ? a : gcd(b, a % b);
//}
//
//int table[150001][25];
//
//// it builds sparse table.
//void buildSparseTable(int arr[], int n)
//{
//    // GCD of single element is element itself
//    for (int i = 0; i < n; i++)
//        table[i][0] = arr[i];
//
//    // Build sparse table
//    for (int j = 1; j <= log2(n); j++)
//        for (int i = 0; i <= n - (1 << j); i++)
//            table[i][j] = gcd(table[i][j - 1],
//                    table[i + (1 << (j - 1))][j - 1]);
//}
//
//// Returns GCD of arr[L..R]
//int query(int L, int R){
//    int j = (int)log2(R - L + 1);
//    return gcd(table[L][j], table[R - (1 << j) + 1][j]);
//}
//
//int main() {
//  ios::sync_with_stdio(false);
//  cin.tie(nullptr);
//
//    int n, m; cin >> n >> m;
//    
//    //cout << "hello1" << flush;
//    
//    // at each index, store starts and ends of ranges (ins + del)
//    short ins[n+1][17]; // ranges
//    //cout << "after" << flush;
//    for (int i = 0; i <= n; i++) {
//        //cout << i << " " << flush;
//        for (int j = 0; j < 17; j++) ins[i][j] = 0; 
//    }
//    
//    //cout << "hello2" << flush;
//    
//    int x[m], y[m], z[m];
//    for (int i = 0; i < m; i++) {
//        cin >> x[i] >> y[i] >> z[i];
//        ins[x[i]-1][z[i]]++; ins[y[i]][z[i]]--; // y or y-1?
//    }
//
//    // sweep line
//    int arr[17], ans[n];
//    ms(arr, 0);
//    for (int i = 0; i < n; i++) {
//        int lcm = 1;
//        for (int j = 1; j <= 16; j++) {
//            arr[j] += ins[i][j];
//            if (arr[j] > 0) {
//                lcm = lcm*j / gcd(lcm, j);
//            }
//        }
//        ans[i] = lcm;
//        //cout << lcm << " ";
//    }
//
//    // verify with sparse table
//    buildSparseTable(ans, n);
//    for (int i = 0; i < m; i++) {
//        if (query(x[i]-1, y[i]-1) != z[i]) {
//            cout << "Impossible";
//            return 0;
//        }
//    }
//
//    // otherwise print answer
//    for (int i = 0; i < n; i++) cout << ans[i] << " ";
//}
///*
//solution idea:
// - sweep line: at each index, +1 if add, -1 if remove
// - at each index, insert list and delete list
// - lcm(a, b) = a*b/gcd(a, b)
// - sparse table to check if answer is valid
// 
// 3 6
// 1 3 5
// 2 6 8
// 3 5 4
//
//*/
