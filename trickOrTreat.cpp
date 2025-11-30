////#include <bits/stdc++.h>
//#include <string>
//#include <fstream>
//#include <iostream>
//#include <queue>
//
//using namespace std;
//typedef pair<int, int> pi;
//typedef long long ll;
//#define f first
//#define s second
//
//bool vis[100001];
//int dist[100001], par[100001]; // node i -> par[i]
//
//void findCycle(int a) {
//    vector<int> chain; chain.push_back(a);
//    int b = par[a], count = 1; // b = start/end of cycle
//    while (true) { // find chain
//        chain.push_back(b);
//        if (vis[b]) break;
//        vis[b] = true;
//        b = par[b];
//        count++;
//    }
//    
//    // iterate through chain to count the distance for each node
//    bool incycle = false;
//    int bindex = 0; // index of node of start/end of cycle
//    for (int i = 0; i < chain.size(); i++) { // find distance of cycle
//        if (incycle) dist[chain[i]] = dist[b];
//        else if (chain[i] == b) {
//            incycle = true;
//            bindex = i;
//            if (dist[b] == -1) dist[b] = (int)chain.size()-i-1;
//        }
//    }
//    // distance of outside of cycle
//    for (int i = 0; i < bindex; i++) dist[chain[i]] = bindex-i+dist[b];
//}
//
//int main() {
//  ios::sync_with_stdio(false);
//  cin.tie(nullptr);
//    
//    int n; cin >> n;
//    int indegree[n]; // # of nodes that point to that node
//    for (int i = 0; i < n; i++) indegree[i] = 0;
//    for (int i = 0; i < n; i++) {
//        cin >> par[i]; par[i]--;
//        indegree[par[i]]++;
//    }
//    
//    queue<int> nums;
//    for (int i = 0; i < n; i++) {
//        if (indegree[i] == 0) nums.push(i);
//    }
//    
//    // go through all connected components starting with leaf nodes
//    for (int i = 0; i < n; i++) vis[i] = false;
//    for (int i = 0; i < n; i++) dist[i] = -1;
//    while (!nums.empty()) {
//        int a = nums.front();
//        // cout << a << "\n";
//        vis[a] = true;
//        nums.pop();
//        findCycle(a);
//    }
//    
//    // go through connected components with no leaves (only cycle)
//    for (int i = 0; i < n; i++) {
//        if (!vis[i]) {
//            vis[i] = true;
//            findCycle(i);
//        }
//    }
//    
//    // print
//    for (int i = 0; i < n; i++) cout << dist[i] << "\n";
//    
//}
///*
//problem 2: cycle length
// for each connected component, find the cycle
//all nodes inside circle = circle length
// node outside circle = length to circle + circle length
// 
//sample:
//6
//2
//4
//2
//3
//2
//5
// 
// output:
// 4
// 3
// 3
// 3
// 4
// 5
//*/
//
