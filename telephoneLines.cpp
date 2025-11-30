//// #include <bits/stdc++.h>
//#include <string>
//#include <fstream>
//#include <iostream>
//#include <vector>
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
//  ios::sync_with_stdio(false);
//  cin.tie(nullptr);
//
//    int n, m, k; cin >> n >> m >> k;// nodes, edges
//
//    int adj[n][n]; // <node, cost>
//    for (int i = 0; i < n; i++) {
//        for (int j = 0; j < n; j++) adj[i][j] = -1;
//    }
//    for (int i = 0; i < m; i++) {
//        int a, b, c; cin >> a >> b >> c; a--; b--;
//        adj[a][b] = c;
//        adj[b][a] = c;
//    }
//
//    // <dist, <index, count>
//    priority_queue<pair<int, pi>, vector<pair<int, pi>>, greater<pair<int, pi>> > pq;
//    int dist[n];
//    vector<int> par(n); // parent of each node i to create shortest path graph
//      par[0] = -1;
//    pq.push({0, {0, 0}}); dist[0] = 0;
//      for (int i = 1; i < n; i++) dist[i] = MX;
//
//    while (!pq.empty()) {
//        // sorts dist from smallest to greatest
//        int d = pq.top().f, i = pq.top().s.f, c = pq.top().s.s; // distance, index, count
//        cout << d << " " << i << " " << c << "\n";
//        pq.pop();
//
//        // if <= k edges, edge is free (cost = 0)
//        if (c < k) {
//            for (int j = 0; j < n; j++) {
//                if (adj[i][j] != -1) {
//                    dist[j] = 0;
//                    par[j] = i;
//                    pq.push({0, {j, c+1}});
//                }
//            }
//        }
//        else {
//            // recalculate cost of path if greater than k edges
//            vector<int> edges;
//            int cur = i;
//            while (cur != 0) {
//                edges.push_back(adj[cur][par[cur]]);
//                cur = par[cur];
//            }
//            sort(edges.begin(), edges.end(), greater<int>()); // sorts expensive to cheap
//
//            for (int j = 0; j < n; j++) {
//                if (adj[i][j] != -1) {
//                    int cst = adj[i][j]; // index of node j, cost
//                    if (cst > edges[k-1]) cst = edges[k-1];
//                    else if (edges.size() < k || cst < edges[k]) cst = d;
//                    
//                    if (dist[j] > cst) { // can improve dist
//                        dist[j] = cst;
//                        par[j] = i;
//                        pq.push({dist[j], {j, c+1}});
//                    }
//                }
//            }
//        }
//      }
//    cout << dist[n-1];
//
//
//}
///*
//
// problem 2: dijkstra, find min path from node 1 to n.
// if you use more then k edges, sum of length of longest remaining cable
//
// two options:
// make k first edges be free:
//    problem: have to pay for most expensive
// do normal dijkstra, then pay for most expensive:
//    problem: doesn't minimze path length
//
// 1. want to minimize path length
// 2. if we can't get under k edges, want to minimize cost of most expensive edges
//
// do twice?
// once try to minimize length
// second try to minimze cost
//
// or at every point of the path, go through path and recalculate cost of path
//
// pays for most expensive k edges
// we pay for most expensive not k edges
// keep track of k+1 expensive edges
// 
// k most expensive edges are free
// we pay for k+1th most expensive edge
// 
// keep track of number of edges and k+1th most expensive edge
// 
//
//*/
//
