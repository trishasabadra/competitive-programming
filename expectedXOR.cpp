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
//double round_to(double value) {
//    return (int)(value * 1000.0) / 1000.0;
//}
//
//int main() {
//  ios::sync_with_stdio(false);
//  cin.tie(nullptr);
//
//    int n, x; cin >> n >> x;
//    int p = pow(2, n);
//    
//    vector<int> presum;
//    presum.push_back(0);
//    if (x >= p) {
//        for (int i = 1; i < p; i++) presum.push_back(i);
//    }
//    else {
//        bool dontinclude[300000] = {};
//        dontinclude[x] = true;
//        for (int i = 1; i < p; i++) {
//            if (!dontinclude[i]) {
//                presum.push_back(i);
//                dontinclude[i^x] = true;
//            }
//        }
//    }
//    cout << presum.size()-1 << "\n";
//    for (int i = 1; i < presum.size(); i++) {
//        cout << (presum[i]^presum[i-1]) << " ";
//    }
//    
//}
///*
// first construct prefix xor array p
// in p, we can't repeat elements (b/c the elements would make 0)
// if x > 2^n then we can use all numbers 1 -> 2^n-1
// otherwise if we include a, we can't use a xor x for all a
//*/
//
