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
//int main() {
//  ios::sync_with_stdio(false);
//  cin.tie(nullptr);
//
//    int n, money, cones; cin >> n >> money >> cones; // # of friends, total money, total ice cream
//    vector<pair<int, pi>> cows(n); // icecream of each friend, popularity, money
//    for (int i = 0; i < n; i++) cin >> cows[i].s.f >> cows[i].s.s >> cows[i].f;
//    sort(cows.begin(), cows.end()); // sort in increasing order of icecream
//
//    int dp[n+1][money+cones+1]; // max popularity at cow i and j money and cones left
//    for (int i = 0; i <= n; i++)
//        for (int j = 0; j <= money+cones; j++) dp[i][j] = 0;
//    dp[0][money+cones] = 0;
//
//    for (int i = 0; i < n; i++) { // friend i
//        int c = cows[i].f, p = cows[i].s.f, m = cows[i].s.s; // cones, popularity, money of friend i
//        for (int j = 0; j <= money+cones; j++) { // j money+cones left
//            dp[i+1][j] = max(dp[i+1][j], dp[i][j]); // don't use friend
//            // use friend, use all cones first, then use money
//            if (j - c*m >= money) { // pay full in cones
//                dp[i+1][j-c*m] = max(dp[i+1][j-c*m], dp[i][j] + p);
//            }
//            else if (j > money) { // pay as much in cones and rest in money
//                int costleft = m - (j-money) / c;
//                if (money - costleft >= 0) {
//                    dp[i+1][money-costleft] = max(dp[i+1][money-costleft], dp[i][j] + p);
//                }
//            }
//            else if (j-m >= 0) { // pay full in money
//                dp[i+1][j-m] = max(dp[i+1][j-m], dp[i][j]+p);
//            }
//        }
//    }
//
//    int ans = 0;
//    for (int i = 0; i <= money+cones; i++) ans = max(ans, dp[n][i]);
//
//    cout << ans;
//}
///*
//gold dec22 bribing friends
// 
//knapsack: choose each friend or not
// maximize popularity
// constraint: money and ice cream
// price is dependent on money and ice cream
//sort cows in increasing order of icecream
// 
//*/
