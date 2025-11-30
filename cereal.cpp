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
//bool vis[100000] = {false}; // if node i is paired with an edge
//bool cowvis[100000] = {false};
//vector<pi> adj[100000];
//vector<int> order;
//void dfs(int num) {
//    for (pi n : adj[num]) {
//        if (!vis[num] || !vis[n.f]) {
//            if (!vis[num]) vis[num] = true;
//            else vis[n.f] = true;
//            order.push_back(n.s);
//            cowvis[n.s] = true;
//            dfs(n.f);
//        }
//    }
//}
//
//int main() {
//  ios::sync_with_stdio(false);
//  cin.tie(nullptr);
//    
//    int m, n; cin >> m >> n; // m = # of cows, n = # of cereal
//    
//    int indeg[n];
//    for (int i = 0; i < n; i++) indeg[i] = 0;
//    
//    for (int i = 0; i < m; i++) {
//        int a, b; cin >> a >> b; a--; b--;
//        adj[a].push_back({b, i});
//        indeg[b]++;
//    }
//    
//    // prioritize roots
//    queue<int> nums;
//    for (int i = 0; i < n; i++) if (indeg[i] == 0) nums.push(i);
//    while (!nums.empty()) {
//        int num = nums.front(); nums.pop();
//        for (pi n : adj[num]) {
//            if (!vis[num] || !vis[n.f]) {
//                if (!vis[num]) vis[num] = true;
//                else vis[n.f] = true;
//                order.push_back(n.s);
//                cowvis[n.s] = true;
//                indeg[n.f]--;
//                if (indeg[n.f] == 0) nums.push(n.f);
//            }
//        }
//    }
//    
//    // rest are cycles, order doesn't matter
//    for (int i = 0; i < n; i++) {
//        if (!vis[i]) dfs(i);
//    }
//    
//    // univisted edges = hungry cows
//    int count = 0;
//    for (int i = 0; i < m; i++) {
//        if (!cowvis[i]) {
//            //cout << i << " ";
//            count++;
//            order.push_back(i);
//        }
//    }
//    
//    cout << count << "\n";
//    for (int i = 0; i < m; i++) cout << order[i]+1 << "\n";
//}
///*
// EDGE = COW, NODE = CEREAL
// pair up nodes with edges
// make edge between cereal (nodes)
// if more nodes than edges in connected component, all cows get cereal
// else edges - nodes = # cows go hungry
// hard part: finding permutation that works
// if arrow is pointing to node from different node, means that this node is second place to that node
// **for ordering, start at node with indegree 0. if no indegree 0, start at any
// 
// once we know how many go hungry, try all permutations. if it exceeds the hunger than stop
//
//*/
