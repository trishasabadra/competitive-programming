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
//int h[2000], mxH;
//double mxS, mnS; // steepest increasing, shallowest decreasing
//bool pairworks(int i, int j) {
//    double slope = (double)(h[j]-h[i])/(j-i);
//    //cout << i << " " << j << " " << mxH << " " << mxS << " " << mnS << " " << slope << "\n";
//
//    bool valid;
//    if (slope == 0) valid = h[i] > mxH; // flat line
//    else if (max(h[i], h[j]) < mxH) valid = false; // heights are smaller
//    else if (min(h[i], h[j]) > mxH) valid = true; // heights are bigger
//    // case 2: decreasing order
//    else if (slope < 0) valid = mnS <= slope;
//    // case 3: increasing order
//    else valid = mxS <= slope;
//    
//    if (slope > 0) mxS = max(mxS, slope);
//    if (slope < 0) mnS = max(mnS, slope);
//    mxH = max(mxH, h[j]);
//    return valid;
//}
//
//int main() {
//  ios::sync_with_stdio(false);
//  cin.tie(nullptr);
//    
//    int n; cin >> n;
//    for (int i = 0; i < n; i++) cin >> h[i];
//    
////    bool pair[n][n]; int count = 0;
////    for (int i = 0; i < n; ++i) {
////        mxS = -1; mnS = 1e9; mxH = -1;
////        for (int j = i+1; j < n; j++) {
////            if (pairworks(i, j)) {
////                cout << i+1 << " " << j+1 << "\n";
////                pair[i][j] = true; count++;
////            }
////            else pair[i][j] = false;
////        }
////    }
//    //cout << count << "\n";
//    
//    int q; cin >> q;
//    while (q > 0) {
//        q--;
//        int x, y; cin >> x >> y; x--; // index x increases by y
//        h[x] += y;
//        
////        for (int i = 0; i < n; i++) cout << h[i] << " ";
////        cout << "\n";
//
//        int count = 0;
//        for (int i = 0; i < n; i++) {
//            mxS = -1; mnS = -1e9; mxH = -1;
//            for (int j = i+1; j < n; j++) {
//                if (pairworks(i, j)) {
//                    //cout << i << " " << j << "\n";
//                    count++;
//                }
//            }
//        }
//        
////        // adds new pairs
////        mxS = -1; mnS = 1e9; mxH = -1;
////        for (int j = i-1; j >= 0; j--) { // all pairs (j < i, i)
////            if (!pair[j][i] && pairworks(j, i)) {
////                pair[j][i] = true; count++;
////            }
////        }
////        mxS = -1; mnS = 1e9; mxH = -1;
////        for (int j = i+1; j < n; j++) { // all pairs (i, j > i)
////            if (!pair[i][j] && pairworks(i, j)) {
////                pair[i][j] = true; count++;
////            }
////        }
////
////        // removes pairs
////        for (int j = 0; j < i; j++) { // pairs (j < i, k > i)
////            if (j != i) {
////                mxS = -1; mnS = 1e9; mxH = -1;
////                for (int k = i+1; k < n; k++) {
////                    if (pair[j][k] && !pairworks(j, k)) {
////                        pair[j][k] = false; count--;
////                    }
////                }
////            }
////        }
//
//        cout << count << "\n";
//    }
//}
///*
// 
// problem 2:
// exactly like frisbee
// update: binary search tree?
// can brute force find all pairs initially
// for each query cannot refind each pair - must see what it blocks and what is added
// height always increases
// when updating, could potentially obstruct all mountains after it
// also check all pairs it is with to see if works
// 
// (i, j) see each other if for all i < k < j:
// 1. min(h[i], h[j]) > h[k] OR
//    2a. if h[i] < h[k] < h[j]: slope[i][j] >= slope[i][k]
//    2b. if h[i] > h[k] > h[j]: slope[i][j] <= slope[i][k]
// 
// decreasing order: must be one with negative slope that is less negative for it to obstruct
//*/
