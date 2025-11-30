////#include <bits/stdc++.h>
//#include <string>
//#include <fstream>
//#include <iostream>
//#include <vector>
//#include <cmath>
//
//using namespace std;
//typedef pair<int, int> pi;
//typedef long long ll;
//#define f first
//#define s second
//
//int BIT[1000002], n;
//void update(int x) {
//      for(; x <= n; x += x&-x)
//        BIT[x]++;
//}
//int query(int x) { // sum from arr[0] -> x
//     int sum = 0;
//     for(; x > 0; x -= x&-x)
//        sum += BIT[x];
//     return sum;
//}
//
//bool sortbysec(const pair<double,int> &a, const pair<double,int> &b) {
//    if (fabs(a.f - b.f) < 0.00000001) return a.s > b.s;
//    return a.f > b.f;
//}
//
//int main() {
//  ios::sync_with_stdio(false);
//  cin.tie(nullptr);
//    
//    int l, c; cin >> n >> l >> c; // # of cows, l laps, track length
//    vector<int> speed(n+1);
//    for (int i = 1; i <= n; i++) cin >> speed[i];
//    sort(speed.begin(), speed.end());
//    
//    // calculate laps
//    double endtime = ((double) c/ (double) speed[n]) * l; // speed per lap * # of laps
//    
//    vector<pair<double, int>> dsort; // sorted by decimal part of lap
//    for (int i = 1; i <= n; i++) {
//        double lap = (speed[i] * endtime) / (double) c;
//        dsort.push_back({lap - (int) lap, lap});
//    }
//    sort(dsort.begin(), dsort.end(), sortbysec);
//    
//    vector<pair<double, int>> lapsort; // sorted by full lap
//    for (int i = 1; i <= n; i++)
//        lapsort.push_back({dsort[i].f+dsort[i].s, i});
//    sort(lapsort.begin(), lapsort.end());
//    
////    for (int i = 0; i < n; i++) cout << "(" << dsort[i].f << ", " << dsort[i].s << ") ";
////    cout << "\n";
////    for (int i = 0; i < n; i++) cout << "(" << lapsort[i].f << ", " << lapsort[i].s << ") ";
////    cout << "\n";
//    
//    // overcounting
//    ll count = 0;
//    for (int i = 2; i <= n; i++) count += (int)lapsort[i].f * i - (int)lapsort[i-1].f * (n-i);
//    
//    // BINARY INDEX TREE
//    for (int i = 1; i <= n; i++) BIT[i] = 0;
//    for (int i = 1; i <= n; i++) { // iterate in increasing order
//        //cout << count << " ";
//        count -= query(lapsort[i].s);
//        update(lapsort[i].s);
//    }
//    
//    cout << count;
//}
///*
//
// - sort from slowest to fastest
// - prefix sum: at each cow, use information from previous cow to know how many cows this cow overtook
// - for each cow, find what lap it is at and position in lap at the end
// - want to compute summation floor(lap(b) - lap(a)) for all b > a
// - problem: floor(b - a) != floor(b) - floor(a) ex: floor(2.2 - 1.3) != floor(2.2) - floor(1.3)
// - BINARY INDEX TREE to count the number of errors:
//    - sort in decreasing order of decimal place, then integer
//    - all 0 in start, mark as 1 when visited
//    - errors = sum of all elements before (add up 1's and 0's)
// 
//4 4 10
//10
//3
//4
//8
//*/
