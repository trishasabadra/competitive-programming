////#include <bits/stdc++.h>
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
//int main() {
//  ios::sync_with_stdio(false);
//  cin.tie(nullptr);
//    
//    int n, m; cin >> n >> m;
//    vector<int> pos(n), cost(m);
//    for (int i = 0; i < n; i++) cin >> pos[i];
//    sort(pos.begin(), pos.end());
//    for (int i = 0; i < m; i++) cin >> cost[i];
//    for (int i = m-2; i >= 0; i--) cost[i] = min(cost[i], cost[i+1]);
//    
//    int dp[n];
//    for (int i = 0; i < n; i++) {
//        dp[i] = cost[pos[i]-pos[0]];
//        for (int j = 1; j <= i; j++) {
//            dp[i] = min(dp[i], dp[j-1]+cost[pos[i]-pos[j]]);
//        }
//        //cout << pos[i] << " " << dp[i] << "\n";
//    }
//    cout << dp[n-1];
//}
///*
//problem 1: umbrella
// dp[i] = min cost covering the first i cows
// dp[i] = min over all j for range (j, i): dp[j-1] + cost[pos[i]-pos[j]+1]
//*/
//
