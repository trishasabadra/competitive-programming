//#include <bits/stdc++.h>
//#include <string>
//#include <fstream>
//#include <iostream>
//#include <vector>
//
//using namespace std;
//typedef pair<int, int> pi;
//typedef long long ll;
//#define f first
//#define s second
//
//int dist(int x1, int y1, int x2, int y2) { return pow(x1-x2, 2) + pow(y1-y2, 2); }
//
//int main() {
//  ios::sync_with_stdio(false);
//  cin.tie(nullptr);
//    
//    int n, m; cin >> n >> m;
//    int fx, fy, bx, by; cin >> fx >> fy >> bx >> by;
//    string fs, bs; cin >> fs >> bs;
//    
//    vector<pi> fpath, bpath;
//    fpath.push_back({fx, fy});
//    for (int i = 0; i < n; i++) {
//        if (fs[i] == 'N') fy++;
//        else if (fs[i] == 'S') fy--;
//        else if (fs[i] == 'E') fx++;
//        else if (fs[i] == 'W') fx--;
//        fpath.push_back({fx, fy});
//   }
//    //cout << "-------\n";
//    bpath.push_back({bx, by});
//    for (int i = 0; i < m; i++) {
//        if (bs[i] == 'N') by++;
//        else if (bs[i] == 'S') by--;
//        else if (bs[i] == 'E') bx++;
//        else if (bs[i] == 'W') bx--;
//        bpath.push_back({bx, by});
//    }
//    
//    int dp[n+1][m+1];
//    dp[0][0] = 0;
//    for (int i = 0; i <= n; i++) {
//        for (int j = 0; j <= m; j++) {
//            if (i == 0 && j == 0) continue;
//            int ans = INT_MAX;
//            int d = dist(fpath[i].f, fpath[i].s, bpath[j].f, bpath[j].s);
//            if (i > 0 && j > 0) ans = dp[i-1][j-1] + d;
//            if (i > 0) ans = min(ans, dp[i-1][j] + d);
//            if (j > 0) ans = min(ans, dp[i][j-1] + d);
//            dp[i][j] = ans;
//        }
//    }
//    cout << dp[n][m];
//}
///*
// dp[i][j] = min sum distance at fj's ith stop and bessie's jth stop
// dp[i][j] = min(dp[i-1][j-1] + dist, dp[i-1][j] + dist, dp[i][j-1] + dist)
// 
// example:
// (1, 1) = both go at same time, fj first, bes first
// (1, 1) = (0, 0), (1, 0), (0, 1)
// (1, 2) = (0, 1), (0, 2), (1, 1)
//*/
