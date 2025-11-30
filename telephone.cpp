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
//    int n, m, k; cin >> n >> m >> k;
//    vector<pi> adj[n];
//    for (int i = 0; i < m; i++) {
//        int a, b, c; cin >> a >> b >> c; a--; b--;
//        adj[a].push_back({b, c}); adj[b].push_back({a, c});
//    }
//    
//        queue<int> nums, layers;
//    queue<vector<int>> costs;
//      // int vis[n]; vis[0] = true; for (int i = 1; i < n; i++) vis[i] = false;
//      nums.push(0); layers.push(0);
//    vector<int> temp; costs.push(temp);
//    int ans = 1e6+1;
//      while (!nums.empty()) {
//          int a = nums.front(), layer = layers.front();
//          vector<int> c = costs.front();
//          nums.pop(); layers.pop(); costs.pop();
//          // vis[a] = true;
//
//          if (a == n-1) {
//              if (c.size() <= k) {
//                  ans = 0; break;
//              }
//              sort(c.rbegin(), c.rend());
//              ans = min(ans, c[k]);
//          }
//        
//        for (pi b : adj[a]) {
//          // if (!vis[b]) nums.push(b); layers.push(layer+1);
//            nums.push(b.f); layers.push(layer+1);
//            vector<int> v(c);
//            v.push_back(b.s);
//            costs.push(v);
//        }
//      }
//    if (ans == 1e6+1) cout << -1;
//    else cout << ans;
//}
///*
//optimizations:
// if cost is smaller than k+1th, then don't add
// use set instead of vector. how to get kth index? - maybe keep removing from start till we get that size?
// don't visit node if k+1th something idk
//*/
