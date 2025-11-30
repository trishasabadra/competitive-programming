//#include <bits/stdc++.h>
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
//    vector<ll> arr(n);
//    for (int i = 0; i < n; i++) cin >> arr[i];
//    sort(arr.rbegin(), arr.rend());
//
//    ll maxmoney = 0, tuition = 0;
//    for (int i = 0; i < n; i++) {
//        ll cur = (i+1)*arr[i];
//        if (cur >= maxmoney) {
//            maxmoney = cur; tuition = arr[i];
//        }
//    }
//    cout << maxmoney << " " << tuition;
//}
///*
//
//*/
