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
//        int n, m; cin >> n >> m; // length of string, # trials
//        bool arr[n][m], ans[m], vis[m];
//        for (int i = 0; i < m; i++) {
//            string s; cin >> s;
//            for (int j = 0; j < n; j++) arr[j][i] = stoi(s.substr(j, 1));
//            cin >> ans[i];
//            vis[i] = false;
//        }
//
////        for (int i = 0; i < n; i++) {
////            for (int j = 0; j < m; j++) cout << arr[i][j] << " ";
////            cout << "\n";
////        }
//
//        for (int i = 0; i < n; i++) { // at index i
//            int ans0 = -1, ans1 = -1;
//            bool con0 = true, con1 = true; // condition 0 and condition 1
//            for (int j = 0; j < m; j++) { // trial j
//                if (!vis[j] && arr[i][j]) {
//                    if (ans1 == -1) ans1 = ans[j];
//                    else if (ans1 != ans[j]) con1 = false;
//                }
//                else if (!vis[j] && !arr[i][j]) {
//                    if (ans0 == -1) ans0 = ans[j];
//                    else if (ans0 != ans[j]) con0 = false;
//                }
//            }
//            //cout << i << " " << con0 << " " << con1 << "\n";
//
//            for (int j = 0; j < m; j++) { // iterate through trials
//                if (!vis[j] && con1 && arr[i][j]) {
//                    vis[j] = true;
//                }
//                if (!vis[j] && con0 && !arr[i][j]) {
//                    vis[j] = true;
//                }
//            }
////            if (con0) {
////                for (int j = 0; j < m; j++) { // iterate through trials
////                    if (!arr[i][j]) {
////                        vis[j] = true;
////                    }
////                }
////            }
////            else if (con1) {
////                for (int j = 0; j < m; j++) { // iterate through trials
////                    if (arr[i][j]) {
////                        vis[j] = true;
////                    }
////                }
////            }
//        }
//
//        // else condition
//        int sa = -1;
//        for (int i = 0; i < m; i++) {
//            if (!vis[i]) {
//                if (sa == -1) sa = ans[i];
//                if (sa == ans[i]) vis[i] = true;
//            }
//        }
//
//        bool valid = true;
//        for (int i = 0; i < m; i++) {
//            if (!vis[i]) {
//                valid = false; break;
//            }
//        }
//
//        if (valid) cout << "OK\n";
//        else cout << "LIE\n";
//    }
//}
///*
//
// #3:
//
// check if all in the first index 0 have the same answer, if so remove them and do else if for next
// then first index 1
// then first index 0 so on...
// check if all in the second index have the same answer
// else statement: if rest don't follow rules but have the same answer
//
// 1
// 3 4
// 001 0
// 100 1
// 011 0
// 101 1
//*/
