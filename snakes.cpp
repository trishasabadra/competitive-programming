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
//void setIO(string s) {
//    freopen((s + ".in").c_str(), "r", stdin);
//    freopen((s + ".out").c_str(), "w", stdout);
//}
//
//int main() {
//  ios::sync_with_stdio(false);
//  cin.tie(nullptr);
//  setIO("snakes");
//    
//    int n, m; cin >> n >> m; // n integers, max m changes
//    int arr[n];
//    for (int i = 0; i < n; i++) cin >> arr[i];
//    
//    int dp[n][m+1][n], mindp[n][m+1];
//    // base case
//    for (int i = 0; i < n; i++)
//        for (int j = 0; j <= m; j++) {
//            mindp[i][j] = 5e8;
//            for (int k = 0; k < n; k++) dp[i][j][k] = 5e8;
//        }
//    
//    for (int k = 0; k < n; k++) {
//        if (arr[k] >= arr[0]) {
//            dp[0][0][k] = arr[k]-arr[0];
//            mindp[0][0] = min(mindp[0][0], dp[0][0][k]);
//        }
//    }
//    
//    // dp
//    for (int i = 1; i < n; i++) {
//        for (int j = 0; j <= i && j <= m; j++) {
//            for (int k = 0; k < n; k++) {
//                if (arr[k] >= arr[i]) {
//                    dp[i][j][k] = min(dp[i][j][k], dp[i-1][j][k] + arr[k]-arr[i]); // no change
//                    if (j > 0) dp[i][j][k] = min(dp[i][j][k], mindp[i-1][j-1] + arr[k]-arr[i]); // change
//                    
//                    mindp[i][j] = min(mindp[i][j], dp[i][j][k]);
//                }
//            }
//        }
//    }
//    
//    cout << mindp[n-1][m];
//}
///*
//dp[i][j] = min waste if j changes by index i
// at each index can change or not change
// change to what?
//    - would always change to current number or number after in array
//    - must change to number >= current number
// 
// dp[i][j][k] = min waste if <= j changes by i, arr[i] -> arr[k] for all k >= i
// at each index can change or not change
// NOT change if i = k: dp[i][j][k] = min(dp[i-1][j][k] + arr[k]-arr[i]) for all arr[k] >= arr[i]
//    - choose best from previous numbers
// change if i != k: dp[i][j][k] = mindp[i-1][j-1] + arr[k]-arr[i] if arr[k] >= arr[i]
//    - previous number doesn't matter (can be any) since we are changing
// 
// BASE CASE:
// at index 0 can start we always have 0 changes and can start with any arr[k] for all k < n
// 
//6 2
//6 5 10 2 9 7
// 
//7 3
//3 4 13 7 13 1 5
//*/
