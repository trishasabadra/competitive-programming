////#include <bits/stdc++.h>
//#include <string>
//#include <fstream>
//#include <iostream>
//#include <vector>
//#include <map>
//#include <set>
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
//    int n, m = 1e6; cin >> n;
//    //map<int, set<int>> m; // icecream : cows
//    set<int> arr[m]; // arr[icecream] : cows
//    int sum = 0;
//    for (int i = 0; i < n; i++) {
//        int flav[5];
//        for (int j = 0; j < 5; j++) cin >> flav[j];
//        
//        int count = 0;
//        for (int a : flav) { // singles
//            count += arr[a].size();
//            set<int> temp;
//            temp.insert(arr[a].begin(), arr[a].end());
//            for (int b : flav) { // doubles
//                if (a == b) continue;
//                temp.insert(arr[b].begin(), arr[b].end()); // a U b
//                count -= (arr[a].size() + arr[b].size() - temp.size());
//                for (int c : flav) { // triples
//                    
//                }
//            }
//        }
//        
//    }
//}
///*
//problem 3:
//- PIE: property of inclusion exclusion
// - PIE on ice cream flavors. find the union
// (do while reading in input) for each cow, do PIE to find union of all 5 ice cream flavors
// PIE: |a U b| = |a| + |b| - |a ∩ b|
// |a U b U c U d U e| = |a|+...+|e| -|a∩b|-...-|a∩e|-...-|d∩e|
//                     = 1 - 2∩ + 3∩ - 4∩ + 5∩
// |a∩b| = |a| + |b| - |a U b|
//*/
