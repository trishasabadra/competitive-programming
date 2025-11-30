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
//int n;
//void dfs(int num) {
//
//}
//
//int main() {
//  ios::sync_with_stdio(false);
//  cin.tie(nullptr);
//
//    int t; cin >> t;
//    while (t > 0) {
//        int n, k, d; cin >> n >> k >> d;
//        int arr[n];
//        for (int i = 0; i < n; i++) cin >> arr[i];
//        // two pointers
//        int sum[n], rnsum = 0, ri = 0;
//        for (int le = 0; le < n; le++) {
//            if (ri < le) ri = le;
//            while (ri < n && ri < le+d && arr[ri] != 0) {
//                rnsum += arr[ri];
//                ri++;
//            }
//            sum[le] = rnsum;
//            rnsum -= arr[le];
//        }
//        //        int ans = 0;
//        //        for (int i = 0; i < n; i++) ans = max(ans, sum[i]);
//        //        cout << ans << "\n";
//
//        int dp[n][k];
//        for (int i = 0; i < n; i++)
//            for (int j = 0; j < k; j++) dp[i][j] = 0;
//
//        dp[0][0] = sum[0];
//        for (int i = 1; i < n; i++) { // day i
//            for (int j = 0; j <= i && j < k; j++) { // use j cards
//                int m = 0;
//                if (i >= d && j > 0) m = dp[i-d][j-1];
//                dp[i][j] = max(dp[i-1][j], m+sum[i]);
//            }
//        }
//
////        for (int i = 0; i < n; i++) {
////            for (int j = 0; j < k; j++) cout << dp[i][j] << " ";
////            cout << "\n";
////        }
//
//        int ans = 0;
//        for (int j = 0; j < k; j++) ans = max(ans, dp[n-1][j]);
//        cout << ans << "\n";
//
//        t--;
//    }
//}
///*
//find sum if range starts at each index
// do two pointers to keep running sum
// if we reach 0, right pointer stops, left keeps moving right
//
// for choosing multiple:
// if you choose i, cannot choose indexes i->i+d
//
// dp[i][j] = max number of bread at day i, using j cards
//swipe on day i, don't swipe on day i
// dp[6][1] = max(dp[5][1], 13) = 21
// dp[6][2] = max(dp[5][2], dp[3][1]+13) = max(26, 34) = 34
//*/
//
