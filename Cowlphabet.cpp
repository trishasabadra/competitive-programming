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
//int MOD = 97654321;
//
//int main() {
//  ios::sync_with_stdio(false);
//  cin.tie(nullptr);
//    
//    // INPUT
//    int U, L, n; cin >> U >> L >> n; // # of uppercase, lowercase, pairs
//    
//    vector<pi> p(n); vector<int> adj[52];
//    for (int i = 0; i < n; i++) {
//        string pair; cin >> pair;
//        // uppercase: (0, 25) lower: (26, 51)
//        p[i].f = pair[0]-65; p[i].s = pair[1]-65;
//        if (p[i].f > 26) p[i].f -= 6;
//        if (p[i].s > 26) p[i].s -= 6;
//        adj[p[i].s].push_back(p[i].f);
//    }
//    
//    // BASE CASE
//    int dp[U+1][L+1][52];
//    for (int i = 0; i <= U; i++) {
//        for (int j = 0; j <= L; j++) {
//            for (int k = 0; k < 52; k++) dp[i][j][k] = 0;
//        }
//    }
//    
//    for (int i = 0; i < 26; i++) dp[1][0][i] = 1;
//    for (int i = 26; i < 52; i++) dp[0][1][i] = 1;
//    
//    // DP[i]i][j][k] = # words with i uppercase, j lowercase, and end letter k
//    for (int i = 0; i <= U; i++) { // # of uppercase
//        for (int j = 0; j <= L; j++) { // # of lowercase
//            for (int k = 0; k < 52; k++) { // previous letter
//                for (int m : adj[k]) { // current letter
//                    int count = dp[i][j][m];
//                    if (m < 26 && i > 0) count += dp[i-1][j][k]; // cur letter is uppercase
//                    else if (m >= 26 && j > 0) count += dp[i][j-1][k]; // lowercase
//                    dp[i][j][m] = count % MOD;
//                }
//            }
//        }
//    }
//    
//    int ans = 0;
//    for (int i = 0; i < 52; i++) {
//        ans += dp[U][L][i] % MOD;
//        ans %= MOD;
//    }
//    cout << ans;
//}
///*
// 2 2 7
// AB
// ab
// BA
// ba
// Aa
// Bb
// bB
//
// Recursion: starting at 1 word what word can go next
//
// AB → Bb → ba = ABba
//
// Assign lowercase letters 1-26 and uppercase 27-52
// Adjacency list for start letter : end letter
// A: B, a
// a: b
// B: A, b
// b: a, B
//
// 27: 28, 1
// 1: 2
// 
// dp[i][j][k] = number of words with i uppercase, j lowercase, and starting with letter k
//
//*/
