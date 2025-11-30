////#include <bits/stdc++.h>
//#include <string>
//#include <fstream>
//#include <iostream>
//#include <vector>
//#include <queue>
//#include <cmath>
//#include <set>
//#include <map>
//
//using namespace std;
//typedef pair<int, int> pi;
//typedef long long ll;
//#define f first
//#define s second
//
//int compress(int n) { return 4*n/5; } // compress
//
//int main() {
//  ios::sync_with_stdio(false);
//  cin.tie(nullptr);
//
//    int n, t, k; cin >> n >> t >> k;
//    int h[n], val[n]; // height, value
//    for (int i = 0; i < n; i++) cin >> val[i] >> h[i];
//
////    int n = 3, t = 53, k = 25;
////    int h[3] = {25, 5, 10}, val[3] = {100, 20, 40};
//
//    // base case
//    int dp[t+1][t+1];
//    for (int i = 0; i <= t; i++)
//        for (int j = 0; j <= t; j++) dp[i][j] = -1;
//    dp[0][0] = 0;
//
//    // dp
//    for (int b = 0; b <= t; b++) { // height b
//        for (int a = 0; a <= b; a++) { // compressed height a
//            if (dp[b][a] == -1) continue;
//            for (int i = 0; i < n; i++) { // colors
//                int j = a+compress(b-a);
//                //cout << b << " " << a << " " << j << " " << i << "\n" << flush;
//                if (h[i] >= k && j+h[i] <= t)
//                    dp[j+h[i]][j] = max(dp[b][a] + val[i], dp[j+h[i]][j]);
//                else if (h[i] < k) dp[b+h[i]][a] = max(dp[b][a] + val[i], dp[b+h[i]][a]);
//            }
//        }
//        //cout << "\n" << flush;
//    }
//
////    for (int i = 0; i <= t; i++) {
////        for (int j = 0; j <= t; j++) cout << dp[i][j] << " " << flush;
////        cout << "\n" << flush;
////    }
//
//    int ans = 0;
//    for (int i = 0; i <= t; i++) {
//        for (int j = 0; j <= t; j++) ans = max(ans, dp[i][j]);
//    }
//    cout << ans;
//
//}
///*
//dp
// dp[i][j] = max val at height i, current color j
// how to keep track of what part is already compressed?
// dp[i][j] = max val at height i, height j is already compressed
//
// bottom up:
// dp[comp(0)+25][0] = dp[25] = dp[0]+100 = 100
// dp[0+5][0] = dp[5] = dp[0]+20 = 20
// dp[0+10][0] = dp[10] = dp[0]+40 = 40
// dp[comp(5)+25][comp(5)] = dp[29][4] = dp[5]+100 = 120
// dp[comp(10)+25][comp[10]] = dp[33][8] = dp[10]+100 = 140
// dp[8+comp(33-8)+25][8+comp(25)] = dp[53][28] = dp[33][8]+100 = 240
//
// IF i >= k:
// dp[a+comp(b-a)+i][a+comp(b-a)] = dp[b][a] + val[i]
// ELSE
// dp[b+i][a] = dp[b][a] + val[i]
//
//4 45 20
//3 5
//8 10
//10 15
//15 25
//
// 4 55 15
// 20 5
// 30 10
// 40 20
// 50 15
//*/
