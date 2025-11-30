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
//const int MX = 2e5;
//vector<int> adj[MX];
//ll arr[MX], treesum[MX]; // sum of the ith subtree
//ll subtreesum(int num, int par) {
//    treesum[num] = arr[num];
//    for (int n : adj[num]) {
//        if (n == par) continue;
//        treesum[num] += subtreesum(n, num);
//    }
//    return treesum[num];
//}
//
//vector<pair<pi, ll>> ans;
//void dfs(int num, int par) {
//    // iterate through positive treesums (take)
//    for (int n : adj[num])
//        if (n != par) dfs(n, num);
//
//    // iterate through negative treesums (par gives to child)
//    for (int n : adj[num]) {
//        if (n == par || treesum[n] > 0) continue;
//        if (treesum[n] < 0) { // num gives to n
//            ans.push_back({{num, n}, -treesum[n]});
//        }
//        dfs(n, num);
//    }
//
//    // child gives remaining to parent
//    if (treesum[num] > 0) { // num takes from n
//        ans.push_back({{num, par}, treesum[num]});
//    }
//}
//
//int main() {
//  ios::sync_with_stdio(false);
//  cin.tie(nullptr);
//
//    int n; cin >> n;
//    ll sum = 0;
//    for (int i = 0; i < n; i++) {
//        cin >> arr[i];
//        sum += arr[i];
//    }
//    for (int i = 0; i < n; i++) arr[i] -= sum/n;
//
//    for (int i = 0; i < n-1; i++) {
//        int u, v; cin >> u >> v; u--; v--;
//        adj[u].push_back(v);
//        adj[v].push_back(u);
//    }
//
//    subtreesum(0, -1);
//    dfs(0, -1);
//
//    cout << ans.size() << "\n";
//    for (auto p : ans) {
//        cout << p.f.f+1 << " " << p.f.s+1 << " " << p.s << "\n";
//    }
//}
///*
// silver dec22 barn tree
// sub tree sums
// if -x, the subtree needs x haybales, if +x, the subtree can give x haybales
// iterate through children with positive hay first and take
// then iterate through children with negative hay and give
// only give if you have enough (don't want to give multiple times)
//*/
