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
//int main() {
//  ios::sync_with_stdio(false);
//  cin.tie(nullptr);
//
//    int n; cin >> n;
//    bool adj[n][n];
//    int arr[n][n];
//    for (int i = 0; i < n; i++) {
//        bool addedge = true;
//        for (int j = 0; j < n; j++) {
//            int a; cin >> a; a--;
//            arr[i][j] = a;
//            if (addedge) adj[i][a] = true;
//            else adj[i][a] = false;
//            if (a == i) addedge = false;
//        }
//    }
//
//    bool reach[n][n];
//    for (int i = 0; i < n; i++) {
//        for (int j = 0; j < n; j++) reach[i][j] = false;
//        reach[i][i] = true;
//      }
//
//    for (int k = 0; k < n; k++) {
//        for (int i = 0; i < n; i++) {
//          for (int j = 0; j < n; j++) {
//            reach[i][j] = adj[i][j] || (reach[i][k] && reach[k][j]);
//          }
//        }
//      }
//
//    for (int i = 0; i < n; i++) {
//        for (int j : arr[i]) {
//            if (reach[j][i]) {
//                cout << j+1 << "\n";
//                break;
//            }
//        }
//    }
//
//}
///*
//2022 feb silver #1: redristributing gifts
// O(n^3):
//make edge from i -> j if cow i wants gift j
// floyd-warshall to find all pairs(i, j) that are reachable
// if i -> j is reachable and j -> i is reachable, there is a cycle with i and j and thus i can be assigned to j
// answer is min over all j for all i
// */
