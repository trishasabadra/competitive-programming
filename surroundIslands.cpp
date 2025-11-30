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
//bool vis[501] = {false};
//vector<int> adj[501];
//vector<vector<int>> comp; // connected components (islands)
//int m = 0;
//void dfs(int num) {
//    vis[num] = true;
//    comp[m].push_back(num);
//    for (int n : adj[num]) {
//        if (!vis[n]) dfs(n);
//    }
//}
//
//int main() {
//  ios::sync_with_stdio(false);
//  cin.tie(nullptr);
//
//    // read in edges
//    int n; cin >> n;
//    for (int i = 0; i < n; i++) {
//        int a, b; cin >> a >> b;
//        adj[a-1].push_back(b-1); adj[b-1].push_back(a-1);
//    }
//
//    // read in costs
//    int cost[n][n];
//    for (int i = 0; i < n; i++)
//        for (int j = 0; j < n; j++) cin >> cost[i][j];
//
//    // make connected components
//    for (int i = 0; i < n; i++) {
//        if (!vis[i]) {
//            vector<int> v;
//            comp.push_back(v);
//            dfs(i);
//            m++;
//        }
//    }
//
//    // find min edge between every pair of components
//    int ans = 1e9;
//    for (int i = 0; i < m; i++) { // component i
//        int sum = 0; // sum of edges from i -> all j
//        for (int j = 0; j < m; j++) { // component j
//            if (j == i) continue;
//            int mn = 1001;
//            for (int a : comp[i]) {
//                for (int b : comp[j]) {
//                    mn = min(mn, cost[a][b]);
//                }
//            }
//            sum += mn;
//        }
//        ans = min(ans, sum*2);
//    }
//    cout << ans;
//}
///*
//dfs to make connected components (islands)
// want to connect islands with min edge cost possible
// choose one island to be the start and from start go to all other islands
// find min over all start islands
//*/
//
