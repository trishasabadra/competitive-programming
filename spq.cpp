//#include </usr/local/include/bits/stdc++.h>
////#include <bits/stdc++.h>
//#define ms(x, a) memset(x, a, sizeof(x))
//const int MX = 1e5+5, MOD = 1e9+7;
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
//    vector<pi> adj[n+1];
//    for (int i = 0; i < m; i++) {
//        int u, v, w; cin >> u >> v >> w;
//        adj[u].push_back(pair{v, w});
//        adj[v].push_back(pair{u, w});
//    }
//
//
//    int minD[n][n];
//    queue<int> nodes;
//    nodes.push(1);
//    while (!nodes.empty()) {
//        int root = nodes.front(); nodes.pop();
//        
//        // DIJKSTRA
//        priority_queue<pi, vector<pi>, greater<pi> > pq; // dist, index
//        int dist[n+1];
//          pq.push(make_pair(0, root)); dist[root] = 0;
//          for (int i = 1; i <= n; i++) dist[i] = INT_MAX;
//
//          while (!pq.empty()) {
//            int d = pq.top().f, i = pq.top().s; //{dist, index} sorts from least to greatest
//            pq.pop();
//            for (pi j : adj[i]) {
//              int nd = j.f, cst = j.s; // index of node j, cost
//              if (dist[nd] > d+cst) { // can improve dist
//                dist[nd] = d+cst;
//                pq.push(make_pair(dist[nd], nd));
//              }
//            }
//          }
//
//    }
//}
///*
//dijkstra - for each node, compute shortest dist from it to every node in subtree using only edges in its subtree
// 
// find lca, then go through all ancestors
//*/
