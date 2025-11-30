////#include <bits/stdc++.h>
//#include <string>
//#include <fstream>
//#include <iostream>
//#include <vector>
//#include <cmath>
//#include <queue>
//
//using namespace std;
//typedef pair<int, int> pi;
//typedef long long ll;
//#define f first
//#define s second
//
//int MX = 1e9;
//
//int main() {
//    ios::sync_with_stdio(false);
//    cin.tie(nullptr);
//
//    // read in graph
//    int n, m, k; cin >> n >> m >> k; // n pastures (n-1 cows), m edges, k donuts
//    vector<pi> adj[n+1];
//    for (int i = 0; i < m; i++) {
//        int a, b, t; cin >> a >> b >> t;
//        adj[a-1].push_back({b-1, t});
//        adj[b-1].push_back({a-1, t});
//    }
//
//    // DIJKSTRA for original graph (no donut)
//    priority_queue<pi, vector<pi>, greater<pi> > pq; // dist, index
//    int dist[n];
//    pq.push(make_pair(0, n-1)); dist[n-1] = 0;
//    for (int i = 0; i < n-1; i++) dist[i] = MX;
//
//    while (!pq.empty()) {
//        int d = pq.top().f, i = pq.top().s; //{dist, index} sorts from least to greatest
//        pq.pop();
//        for (pi j : adj[i]) {
//            int nd = j.f, cst = j.s; // index of node j, cost
//            if (dist[nd] > d+cst) { // can improve dist
//                dist[nd] = d+cst;
//                pq.push(make_pair(dist[nd], nd));
//            }
//        }
//    }
//
////    for (int i = 0; i < n; i++) cout << dist[i] << " ";
////    cout << "\n";
//
//    // read in donuts
//    int donut[n]; for (int i = 0; i < n; i++) donut[i] = -1;
//    for (int i = 0; i < k; i++) {
//        int a, b; cin >> a >> b; // index, donut value
//        donut[a-1] = max(donut[a-1], b);
//    }
//    // add edges from donut node to new 'end' node
//    for (int i = 0; i < n; i++) {
//        if (donut[i] != -1) {
//            adj[n].push_back({i, dist[i]-donut[i]});
//        }
//    }
//
//    // DIJKSTRA for new path that includes a donut
//    int newdist[n+1];
//    pq.push(make_pair(0, n)); newdist[n] = 0;
//    for (int i = 0; i < n; i++) newdist[i] = MX;
//
//    while (!pq.empty()) {
//        int d = pq.top().f, i = pq.top().s; //{dist, index} sorts from least to greatest
//        pq.pop();
//        for (pi j : adj[i]) {
//            int nd = j.f, cst = j.s; // index of node j, cost
//            if (newdist[nd] > d+cst) { // can improve dist
//                newdist[nd] = d+cst;
//                pq.push(make_pair(newdist[nd], nd));
//            }
//        }
//    }
//
//    for (int i = 0; i < n-1; i++) {
//        if (newdist[i] <= dist[i]) cout << "1\n";
//        else cout << "0\n";
//    }
//
//}
///*
// only eats donut if: path with donut - donut value <= original path
// original path: dijkstra starting at N to find shortest path between all nodes and barn
// path with donut:
//    - make a new 'end' node
//    - add edges from donut nodes to end node -> forces cow to pick up donut
//        - edge weight = dist(donut, n) - donut value
//    - can have negative edge weight, use bellman ford instead of dijkstra
// */
