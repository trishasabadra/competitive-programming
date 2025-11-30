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
//    int arr[300][300];
//    for (int i = 0; i < n; i++)
//        for (int j = i; j < n; j++) cin >> arr[i][j];
//    
//    int ans[n]; ans[n-1] = 0;
//    for (int i = n-2; i >= 0; i--) {
//        // + pair difference
//        ans[i] = ans[i+1] + arr[i][i+1];
//
//        // see if works for all previous differences
//        bool works = true;
//        int mn = ans[i], mx = ans[i];
//        for (int j = i+1; j < n; j++) {
//            mn = min(ans[j], mn);
//            mx = max(ans[j], mx);
//            if (mx-mn != arr[i][j]) {
//                works = false;
//                break;
//            }
//        }
//
//        if (!works) ans[i] = ans[i+1] - arr[i][i+1]; // since + doesn't work, - must work
//    }
//
//    for (int a : ans) cout << a << " ";
//}
///*
//silver dec22 range reconstruction
//last number is 0
//
//*/
