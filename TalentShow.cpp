//#include <bits/stdc++.h>
//#include <string>
//#include <fstream>
//#include <iostream>
//
//using namespace std;
//typedef pair<int, int> pi;
//typedef long long ll;
//#define f first
//#define s second
//
//ll inf = 1000000000000000000LL;
//
//int main() {
//  ios::sync_with_stdio(false);
//  cin.tie(nullptr);
//    
//    int n, w; cin >> n >> w;
//    
//    int talent[n], weight[n];
//    for (int i = 0; i < n; i++) cin >> talent[i] >> weight[i];
//    
//    // BINARY SEARCH
//    ll l = 0, r = (1000 * 250 * 1000) + 1; // left, right
//    while (l < r) {
//        ll y = (r + l + 1) / 2; // middle
//        cout << l << " " << r << " " << y << "\n" << flush;
//        
//         // KNAPSACK DP
//        ll dp[w+1];
//        for (int i = 0; i <= w; i++) dp[i] = -inf;
//        dp[0] = 0;
//        
//        for (int i = 0; i < n; i++) { // cow index
//            ll score = 1000* (ll) talent[i] - y* (ll) weight[i];
//            for (int j = w; j >= 0; j--) { // weight
//                int k = min(w, j + weight[i]);
//                if (dp[j] != -inf && dp[k] < dp[j] + score) dp[k] = dp[j] + score;
//            }
//        }
//        if (dp[w] >= 0) l = y;
//        else r = y-1;
//    }
//    cout << l;
//}
///*
//n cows each have weight wi and talent level ti. choose cows to get largets ration of total talent : total weight but total weight >= W.
// n <= 250
// wi <= 10^6, ti <= 10^3
// W <= 1000
// 
// 1. binary search on ratio 1000x = y.
// 2. dp knapsack for max score
//    score[i] = 1000 * talent[i] - y * weight[i]
//    dp[i] = max score when total weight exactly j. if j = W, max score with weight >= j.
//    dp[i][j] = max(dp[i-1][j], dp[i-1][j-weight[i]] + score[i])
// 
// 3. answer = dp[n][w]
//*/
