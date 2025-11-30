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
// ios::sync_with_stdio(false);
//  cin.tie(nullptr);
//  //setIO("cowmbat");
//
//    int n, m, K; cin >> n >> m >> K;
//    //int n = 5, m = 5, K = 2;
//    string in; cin >> in;
//    vector<int> arr;
//    for (char c : in) arr.push_back(c-97);
//    
//    int cost[m][m]; // cost[i][j] = cost to switch letter i to j
//    for (int i = 0; i < m; i++)
//        for (int j = 0; j < m; j++) cin >> cost[i][j];
//
//    // FLOYD WARSHALL ON COST
//    for (int k = 0; k < m; k++) {
//        for (int i = 0; i < m; i++) {
//          for (int j = 0; j < m; j++) {
//            cost[i][j] = min(cost[i][j], cost[i][k] + cost[k][j]);
//          }
//        }
//      }
//    
//    // PREFIX SUM/ RUNNING SUM
//    int sum[n][m]; // sum[i][j] = sum if all indices 0->i are changed to j
//    for (int j = 0; j < m; j++) { // choose color
//        int rnsum = 0;
//        for (int i = 0; i < n; i++) { // iterate through word
//            rnsum += cost[arr[i]][j];
//            sum[i][j] = rnsum;
//        }
//    }
//    
//    int dp[n][m]; // dp[i][j] = index i, letter j has streak >= K
//    // base case
//    for (int i = 0; i < n; i++)
//        for (int j = 0; j < m; j++) dp[i][j] = 1e7;
//    for (int j = 0; j < m; j++) dp[K-1][j] = sum[K-1][j];
//    
//    // dp
//    for (int i = K-1; i < n-1; i++) { // index i
//        for (int j = 0; j < m; j++) { // current color j
//            if (dp[i][j] == 1e7) continue;
//            // switch colors
//            if (i+K < n) { // can start a new streak at this index
//                for (int c = 0; c < m; c++) { // try all new colors
//                    if (c != j) {
//                        dp[i+K][c] = min(dp[i+K][c], dp[i][j] + (sum[i+K][c]-sum[i][c]));
//                        //cout << i << " " << j << " " << c << " " << (sum[i+K][c]-sum[i][c]) << "\n";
//                    }
//                }
//            }
//            
//            // continue streak
//            dp[i+1][j] = min(dp[i+1][j], dp[i][j] + cost[arr[i+1]][j]);
//        }
//    }
//    
//    int ans = 1e7;
//    for (int j = 0; j < m; j++) ans = min(ans, dp[n-1][j]);
//    
//    cout << ans;
//}
///*
// 2. moortal cowmbat
//  FIRST DO FLOYD WARSHALL ON COST ARRAY
//  string dp = min cost to change string A into string B
//  here we can end with anything as long as it follow requirements
// 
//  dp[i] = min cost to make first i indices follow rules
//  dp[i][j] = min cost to make first i indices follow rules and last streak ends with j
// 
//  transition: can continue streak or change to different color
//  how do we make sure streak is at least k length?
//  dp[i][j][k] = index i, letter j with streak k
//  different color: can change to any color with streak 1
//  dp[i+1][j][k+1] = dp[i][j][k] + cost[i+1][j]
//  for all c not j: dp[i+1][c][1] = dp[i][j][k]+cost[i][c]
//  can only switch to new color if previous streak >= K rule
// 
// dp[i][j][K] = min cost if streak >= K
// do we have to keep track of k?
// can we just keep track of if it is < k and > k
// dp[i][j] = at index i letter j ALREADY has streak >= K
//                OR
// dp[i][j] = STARTING at index i, letter j has streak >= K
// we are doing = K, how to deal with >= K?
// dp[i][j][0/1] = index i, letter j has/ does not have streak >= K
// how do we know when it crosses K?
// 
//
//*/
