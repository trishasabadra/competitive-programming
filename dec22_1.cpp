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
//vector<int> adj[200000];
//int arr[200000], goal = 0, subtree[200000]; // how many haybales each subtree needs from above
//vector<pair<pi, int>> opr; // operation: <<source, destination>, # of bales>
//
//void dfs(int num, int par) {
//    subtree[num] = goal-arr[num];
//    // first time to get all from children
//    //cout << num+1 << " " << arr[num] << " " << subtree[num] << "\n";
//    for (int n : adj[num]) {
//        if (n != par) {
//            //cout << "    " << n << "\n";
//            dfs(n, num);
//            subtree[num] += subtree[n]; // how many they need
//            cout << num+1 << " -> " << n+1 << " " << arr[n] << " " << subtree[n] << "\n";
//        }
//    }
//    // second time to distribute to children
//    for (int n : adj[num]) {
//        if (n != par) {
//            cout << num+1 << " " << arr[num] << " " << subtree[n] << " " << arr[n] << "\n";
//            if (arr[num] >= subtree[n] && arr[n] < goal) { // give to child
//                int give = subtree[n];
//                opr.push_back({{num+1, n+1}, give});
//                arr[n] += give;
//                arr[num] -= give;
//                dfs(n, num); // only do dfs if can give to child
//                subtree[num] = subtree[num]-subtree[n]; // that subtree is done now
//                cout << "2 " << num+1 << " -> " << n+1 << " " << arr[n] << " " << subtree[n] << "\n";
//            }
//        }
//    }
//
//    // only give to parent if subtree is done
//    if (par != -1 && arr[num] > goal) { // not root
//        int give = arr[num]-goal;
//        opr.push_back({{num+1, par+1}, give});
//        arr[par] += give;
//        arr[num] = goal;
//    }
//}
//
//int main() {
//  ios::sync_with_stdio(false);
//  cin.tie(nullptr);
//
//    int n; cin >> n;
//    for (int i = 0; i < n; i++) {
//        cin >> arr[i];
//        goal += arr[i];
//    }
//    goal /= n;
//
//    for (int i = 0; i < n-1; i++) {
//        int a, b; cin >> a >> b; a--; b--;
//        adj[a].push_back(b); adj[b].push_back(a);
//    }
//
//    dfs(4, -1);
//    cout << opr.size() << "\n";
//    for (auto p : opr) cout << p.f.f << " " << p.f.s << " " << p.s << "\n";
//}
///*
// #1:
//each must end with tot/n haybales
// minimize operations
// - binary search?
// - greedy
// start at leaves and go up. since it is a tree each leaf only points to one node, must give or take from them.
// go through all leaves, then next level, so on to root
// if has too many, must give all to par
// only give if it completes the goal, don't want to give same node multiple times
// if parent gets more, go back to all children. must finish all children before finishing itself
// at each subtree, store how many needed for subtree
//
// 8
// 10 1 0 1 1 0 0 11
// 5 4
// 4 8
// 5 2
// 2 6
// 2 1
// 3 6
// 6 7
//
// #3:
//
//*/
