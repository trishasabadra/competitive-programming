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
//// generate all permutations
//bool vis[14] = {false};
//int adj[14][3]; // 1-indexed!
//int mincost = 1e5, n;
//// current number, inverse indexed, not vis numbers, running sum
//void permute(vector<int> inv, vector<int> vis, int cost, int size) {
//    if (cost >= mincost) return;
//    if (size == n) mincost = min(mincost, cost);
//    for (int i = 0; i < vis.size(); i++) {
//        vector<int> v(vis); v.erase(v.begin() + i);
//        vector<int> tempinv(inv); tempinv[vis[i]] = size;
//        
//        int curcost = cost;
//        for (int j : adj[vis[i]]) {
//            //cout << "(" << j << ": " << inv[j] << ") ";
//            if (inv[j] != -1) curcost += (size-inv[j]);
//        }
//        
//        cout << vis[i] << " " << curcost << " " << size << "\n" << flush;
//        permute(tempinv, v, curcost, size+1);
//    }
//}
//
//int main() {
//  ios::sync_with_stdio(false);
//  cin.tie(nullptr);
//    
//    cin >> n;
//    for (int i = 1; i <= n; i++) cin >> adj[i][0] >> adj[i][1] >> adj[i][2];
//
//    vector<int> inv(n+1), vis;
//    for (int i = 1; i <= n; i++) {
//        inv[i] = -1;
//        vis.push_back(i);
//    }
//    permute(inv, vis, 0, 0);
//    
//    cout << mincost;
//}
///*
//worst case: try all permutations. for each permutation find cost. O(n! * n)
// pruning: during dfs, at each permution keep a running sum of the cost. if the sum exceeds the cost we have
// gotten before, end the current permutation.
// to find the running sum in O(1) do inverse indexing. when adding a number check if 3 friends are already in the list.
//*/
//
