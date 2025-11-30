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
//    int n, m; cin >> n >> m;
//    ll start[m+1], end[m+1];
//    for (int i = 0; i <= m; i++) {
//        start[i] = 0; end[i] = 0;
//    }
//    for (int i = 0; i < n; i++) {
//        int a, b; cin >> a >> b;
//        start[a]++; end[b]++;
//    }
//    
//    ll presum[2*m+2];
//    for (int i = 0; i <= 2*m+1; i++) presum[i] = 0;
//    for (int i = 0; i <= m; i++) {
//        for (int j = 0; j <= m; j++) {
//            presum[i+j] += start[i]*start[j];
//            presum[i+j+1] -= end[i]*end[j];
//        }
//    }
//    
//    for (int i = 1; i <= 2*m+1; i++) presum[i] += presum[i-1];
//    
//    for (int i = 0; i <= 2*m; i++) cout << presum[i] << "\n";
//}
///*
// 2021 december silver: convoluted intervals
//  O(m^2):
// prefix sum:
// for same:
//  orig[i] = x, presum[i] = x^2
// for (i, j)
// presum[i+j] = 2*orig[i]*orig[j]
//*/
