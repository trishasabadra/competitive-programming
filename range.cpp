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
//    int n; cin >> n;
//    int arr[n][n];
//    for (int i = 0; i < n; i++)
//        for (int j = i; j < n; j++) cin >> arr[i][j];
//    
//    // bfs
//    queue<int> nums, index;
//    queue<vector<int>> ans;
//    vector<int> v; v.push_back(0);
//    nums.push(0); index.push(0); ans.push(v);
//      while (!nums.empty()) {
//          int a = nums.front(), i = index.front();
//          v = ans.front();
//          nums.pop(); index.pop(); ans.pop();
//          
//          int mn = 1e9, mx = 0;
//          bool valid = true;
//          for (int j = i; j >= 0; j--) {
//              mn = min(mn, v[j]); mx = max(mx, v[j]);
//              if (mx-mn != arr[j][i]) {
//                  valid = false; break;
//              }
//          }
//          if (!valid) continue;
//          
//          if (i == n-1) {
//              for (int j = 0; j < n-1; j++) cout << v[j] << " ";
//              cout << v[n-1];
//              break;
//          }
//          
//          vector<int> v1(v), v2(v);
//
//          int b = a+arr[i][i+1];
//          v1.push_back(b);
//          nums.push(b); index.push(i+1); ans.push(v1);
//          
//          b = a-arr[i][i+1];
//          v2.push_back(b);
//          nums.push(b); index.push(i+1); ans.push(v2);
//      }
//
//}
///*
//
//*/
