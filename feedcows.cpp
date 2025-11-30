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
//    int t; cin >> t;
//    while (t > 0) {
//        t--;
//        int n, k; cin >> n >> k;
//        string s; cin >> s;
//        int ans[n]; // 0 = ., 1 = H, 2 = G
//        for (int i = 0; i < n; i++) ans[i] = 0;
//
//        int leH, riH = -1, leG, riG = -1, tot = 0;
//        for (int i = 0; i < n; i++) {
////            cout << riH << " ";
////            for (int i = 0; i < n; i++) {
////                if (ans[i] == 0) cout << ".";
////                else if (ans[i] == 1) cout << "H";
////                else cout << "G";
////            }
////            cout << "\n";
//            if (s[i] == 'H' && i >= riH) {
//                leH = i; riH = i+2*k+1;
////                if (i+k > n) {
////                    for (int j = i; )
////                }
//                if (ans[min(i+k, n-1)] == 2) ans[min(i+k, n-1)-1] = 1;
//                else ans[min(i+k, n-1)] = 1;
//                tot++;
//            }
//            else if (s[i] == 'G' && i >= riG) {
//                leG = i; riG = i+2*k+1;
//                if (ans[min(i+k, n-1)] == 1) ans[min(i+k, n-1)-1] = 2;
//                else ans[min(i+k, n-1)] = 2;
//                tot++;
//            }
//        }
//
//        //cout << "output:\n";
//        cout << tot << "\n";
//        for (int i = 0; i < n; i++) {
//            if (ans[i] == 0) cout << ".";
//            else if (ans[i] == 1) cout << "H";
//            else cout << "G";
//        }
//        if (t > 0) cout << "\n";
//    }
//}
///*
// binary search on number of patches we place
//   - binary search on both # of h and # of g
//  sliding window -> find number of cows that patch will reach
//  brute force: each patch can be H, G, or empty. try to maximize empty
//
// 1
// 11 2
// GHGGHHHHGGG
//*/
