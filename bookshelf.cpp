////#include <bits/stdc++.h>
//#include <string>
//#include <fstream>
//#include <iostream>
//#include <vector>
//#include <queue>
//#include <cmath>
//
//using namespace std;
//typedef pair<int, int> pi;
//typedef long long ll;
//#define f first
//#define s second
//
//int main() {
//  ios::sync_with_stdio(false);
//  cin.tie(nullptr);
//    
//    int MX = 1e9;
//    int n, m; cin >> n >> m; // n books, sum width < m
//    int height[n], width[n]; // height and width
//    for (int i = 0; i < n; i++) cin >> height[i] >> width[i];
//    
//    int maxh[n][n]; // maxh[i][j] = max height between books (i, j) inclusive
//    for (int i = 0; i < n; i++) {
//        int mx = 0;
//        for (int j = i; j < n; j++) {
//            mx = max(mx, height[j]);
//            maxh[i][j] = mx;
//        }
//    }
//    
//    pi dp[n][n]; //min total height and accompaning width if book j is the last book on shelf i
//    for (int i = 0; i < n; i++)
//        for (int j = 0; j < n; j++)
//            if (i == 0) dp[i][j] = {MX, MX};
//
//    dp[0][0] = {height[0], width[0]};
//    for (int i = 0; i < n; i++) {
//        for (int j = 0; j < n; j++) {
//            // first shelf and within width
//            if (i == 0 && j > 0 && dp[0][j-1].s+width[j] <= m) {
//                dp[0][j] = {maxh[0][j], dp[0][j-1].s+width[j]};
//            }
//            else if (i > 0) {
//                int minh = MX, sumw = 0, minw = 0; // min total height, sum of width
//                // adding books to shelf from left to right
//                for (int k = j-1; k >= 0 && sumw+width[k+1] <= m; k--) {
//                    sumw += width[k+1];
//                    if (dp[i-1][k].f + maxh[k+1][j] <= minh) {
//                        minh = dp[i-1][k].f + maxh[k+1][j];
//                        minw = sumw;
//                    }
//                }
//                dp[i][j] = {minh, minw};
//            }
//        }
//    }
//    
//    int ans = MX;
//    // if last book is on the ith shelf
//    for (int i = 0; i < n; i++) ans = min(ans, dp[i][n-1].f);
//    cout << ans;
//}
///*
// dp
// minimize total height, constraint is the sum width < m
// groups are contigious
// for each book, choose which group it will be in
// height of shelf is largest height in group
// for each group, keep track of max height and total width
// dp[i][j] = min total height and accompaning width if book j is the last book on shelf i
// dp[i][j] = min(dp[i-1][k] + max height(k+1->j)) for all k < j
//                if book k is the last book on shelf i-1, and books k+1 -> j are on shelf i
// 
// pre-store max heights of all ranges
//*/
//
