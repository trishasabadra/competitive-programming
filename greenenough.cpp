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
//void setIO(string s) {
//    freopen((s + ".in").c_str(), "r", stdin);
//    freopen((s + ".out").c_str(), "w", stdout);
//}
//
//int mod;
//bool cmp(int a, int b) {return (a%mod) > (b%mod); }
//
//int main() {
//    ios::sync_with_stdio(false);
//    cin.tie(nullptr);
//    setIO("berries");
//    
//    int n, k; cin >> n >> k;
//    vector<int> arr(n);
//    for (int i = 0; i < n; i++) cin >> arr[i];
//
//    int best = 0;
//    for (int b = 1; b < 1000; b++) {
//        int count = 0; // # of buckets filled
//        for (int i = 0; i < n && count < k; i++) {
//            count += arr[i]/b;
//        }
//        
//        int bes = b*max(min(count,k)-k/2, 0); // # of berries bessie gets
//        mod = b;
//        sort(arr.begin(), arr.end(), cmp);
//        for (int i = 0; i < n && count < k; i++) {
//            count++;
//            if (count > k/2) bes += arr[i]%b;
//        }
//        
//        best = max(bes, best);
//        //cout << b << " " << bes << "\n";
//    }
//    
//    cout << best << "\n";
//}
///*
//binary search on X
// can't simulate all k days
// x must be less than n/m
// figure out when (n-g)/x becomes <= m
// find when it switches to next milk per gallon per day
// 
// ex. if n = 15, x = 3, m = 3
// n/x = y, 15/3 = 5
// y -> 4 when 4x <= n < 5x: 12 <= n < 15
// y -> 3 when 3x <= n < 4x: 9 <= n < 12
// since m = 3, y -> 3 when n < 12
// will keep substracting y until n is in next range
// 
// 2020 jan silver #1 berry picking:
// want to evenly distribute over all baskets
// divide each tree into baskets of b berries each
// if it doesn't fill all baskets go over leftovers and add those
// find max over all b for bessie
//*/
