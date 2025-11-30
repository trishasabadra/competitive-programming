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
//#define bitinc(x) (x&-x);
//
//void setIO(string s) {
//    freopen((s + ".in").c_str(), "r", stdin);
//    freopen((s + ".out").c_str(), "w", stdout);
//}
//
//const int mx = 100005;
//vector<int> adj[mx];
//int st[mx], en[mx], timer = 1, val[mx], bit[4*mx];
//int  par[mx][22]; // par[i][j] = 2^jth parent of node i in dfs tree
//void dfs(int node, int p) { // sparse tree + euler tour
//    st[node] = timer++;
//    par[node][0] = p;
//    for (int i = 1; i < 22; i++) { // sparse table
//        par[node][i] = par[par[node][i-1]][i-1];
//    }
//
//    for (int i : adj[node]) if (i != p) dfs(i, node);
//    en[node] = timer-1;
//}
//
//bool anc(int a, int b) { // returns whether a is an ancestor of b
//    return st[a] <= st[b] && en[b] <= en[a];
//}
//
//int lca(int a, int b) {
//    if (anc(a, b)) return a;
//    for (int i = 21; i >= 0; i--) { // iterates from highest parent of a to lowest
//        if (par[a][b] >= 0 && !anc(par[a][i], b)) a = par[b][i];
//    }
//    return par[a][0];
//}
//
//// prefix xor. reversable = done onto itself
//int XOR(int ind)
//{
//    int xo = 0;
//    while(ind > 0)
//    {
//        xo ^= bit[ind];
//        ind -= bitinc(ind);
//    }
//    return xo;
//}
//
//// binary index tree update
//void upd(int ind, int val)
//{
//    while(ind <= timer)
//    {
//        bit[ind] ^= val;
//        ind += bitinc(ind);
//    }
//}
//
//int main() {
//    ios::sync_with_stdio(false);
//    cin.tie(nullptr);
//    //setIO("file_name");
//
//    for (int i = 0; i < 4*mx; i++) bit[i] = 0;
//
//    int n, q; cin >> n >> q;
//    for (int i = 0; i < n; i++) cin >> val[i];
//
//    for (int i = 0; i < n-1; i++) {
//        int a, b; cin >> a >> b; a--; b--;
//        adj[a].push_back(b); adj[b].push_back(a);
//    }
//
//    // euler tour
//    dfs(0, -1);
//
//    for (int i = 0; i < q; i++) {
//        int t, a, b; cin >> t >> a >> b;
//        if (t == 1) { // change query
//            a--;
//            // erase old value
//            upd(st[a], val[a]);
//            upd(en[a], val[a]);
//            // add new value
//            val[a] = b;
//            upd(st[a], val[a]);
//            upd(en[a], val[a]);
//        }
//        else { // path query
//            a--; b--;
//            int c = lca(a, b);
//            cout << (XOR(st[a]) ^ XOR(st[b]) ^ val[c]) << "\n";
//        }
//    }
//}
///*
//
// root at 1 and find xor of 1 to all nodes
// answer = 1 -> a xor 1 -> b xor lca(a,b)
// lca: do binary search and store the level each node is on. lca(a, b) = min of levels - 1. if a or b is 1, lca is 1.
//
// what to do for changing values?
// observations:
//  - changed value only affects path if that node is on the path
//  - changed value must be ancestor of either a or b
//  - store all changed values in map: <node : value>
//  - at each path query, go through all values in map to see if that node is an ancestor <- too slow
//  - if on path, do answer xor oldval xor newval
//*/
////