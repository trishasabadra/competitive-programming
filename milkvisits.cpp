////#include <bits/stdc++.h>
//#include <string>
//#include <fstream>
//#include <iostream>
//#include <vector>
//#include <queue>
//#include <cmath>
//#include <set>
//#include <map>
//#include <stack>
//
//using namespace std;
//typedef pair<int, int> pi;
//typedef long long ll;
//#define f first
//#define s second
//
//const int MX = 1e5+5;
//vector<int> adj[MX];
//// EULER TOUR
//int timer = 0, st[MX], en[MX];
//void dfs(int node, int parent) {
//    st[node] = timer++;
//    for (int i : adj[node]) if (i != parent) dfs(i, node);
//    en[node] = timer-1;
//}
//
//// QUERIES
//vector<pair<int, pi>> queries[MX]; // list of queries at each node <index, <node to, milk type>>
//stack<int> milk[MX]; // if you visit milk x at node y, milk[x].add(y)
//bool ans[MX]; // if query i can be done
//int mtype[MX]; // milk type of cow i
//void dfs2(int node, int parent) {
//    milk[mtype[node]].push(node);
//    // go through queries
//    for (pair i : queries[node]) {
//        if (!milk[i.s.s].empty()) { // if that milk type exists
//            //cout << node << " " << i.f << " " << i.s.f << " " << i.s.s << " " << milk[i.s.s].top() << " " << lca.height[milk[i.s.s].top()] << " " << lca.lca(node, i.s.f) << "\n" << flush;
//            // query index, query node -> b, milk type, last ancestor of the query milk
//            int ind = i.f, b = i.s.f, mt = i.s.s, y = milk[mt].top();
//            if (!(st[y] <= st[node] && en[node] <= en[y])) ans[ind] = true; // y is NOT an ancestor of b
//            // if it is an ancestor, it could be higher than LCA -> would not work
//            // therefore we need to make sure y is LCA of (a, b)
//            // if any of y's children are ancestors of both, y is NOT LCA
//            bool isLCA = true;
//            for (int j : adj[y]) {
//                if (!(st[j] <= st[y] && en[y] <= en[j]) && // j is not parent of y
//                    st[j] <= st[node] && en[node] <= en[j] && // j is ancestor of node/a
//                    st[j] <= st[b] && en[b] <= en[j]) { // j is ancestor of b
//                    isLCA = false; break;
//                }
//            }
//            if (isLCA) ans[ind] = true;
//        }
//    }
//    // iterate through children
//    for (int i : adj[node]) if (i != parent) dfs2(i, node);
//    milk[mtype[node]].pop();
//}
//
//void setIO(string s) {
//    freopen((s + ".in").c_str(), "r", stdin);
//    freopen((s + ".out").c_str(), "w", stdout);
//}
//
//
//int main() {
//    ios::sync_with_stdio(false);
//    cin.tie(nullptr);
//    //setIO("milkvisits");
//    
//    int n, q; cin >> n >> q; // n cows, q queries (friends)
//    for (int i = 0; i < n; i++) {
//        cin >> mtype[i]; mtype[i]--;
//    }
//
//    for (int i = 0; i < n-1; i++) {
//        int a, b; cin >> a >> b; a--; b--;
//        adj[a].push_back(b); adj[b].push_back(a);
//    }
//
//    for (int i = 0; i < q; i++) {
//        int a, b, c; cin >> a >> b >> c; a--; b--; c--;
//        queries[a].push_back({i, {b, c}});
//        queries[b].push_back({i, {a, c}});
//    }
//    
////    int n = 5, q = 5;
////    int mtype[5] = {0, 0, 1, 0, 1};
////    for (int i = 0; i < n; i++) {
////            vector<int> v;
////            adj.push_back(v);
////        }
////    adj[0] = {1, 4}; adj[1] = {0, 2, 3}; adj[2] = {1}; adj[3] = {1}; adj[4] = {0};
////    queries[0] = {{0, {3, 0}}, {1, {3, 1}}, {2, {2, 1}}, {3, {2, 0}}};
////    queries[4] = {{4, {4, 0}}};
//    
//    dfs(0, -1); // euler tour
//    
//    for (int i = 0; i < q; i++) ans[i] = false;
//    dfs2(0, -1); // queries
//
//    for (int i = 0; i < q; i++) cout << ans[i];
//}
///*
//1. at each node store what queries we have to answer
//2. stack keeps last ancestor of a certain type of milk: if you visit milk a at node b, stack[a].add(b)
//3. when we reach the end of the query b/w nodes a and b, see if last ancestor of the query milk is <= LCA(a, b)
//    let y = last ancestor of the query milk, L = LCA(a, b)
//    case 1: y is not an ancestor of b, so it must be on the path a -> L: works
//    case 2: y = L: works
//    case 3: none of the above: does not work
//*/
//
