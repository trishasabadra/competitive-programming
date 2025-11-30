////#include <bits/stdc++.h>
//#include <string>
//#include <fstream>
//#include <iostream>
//#include <vector>
//#include <queue>
//#include <cmath>
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
//    priority_queue<int, vector<int>, greater<int>> time, dist;
//    for (int i = 0; i < n; i++) {
//        char c; int j; cin >> c >> j;
//        if (c == 'T') time.push(j);
//        else dist.push(j);
//    }
//    
//    double prevdist = 0, prevtime = 0, speed = 1;
//    while (!time.empty() || !dist.empty()) {
//        double curtime = 0, curdist = 0;
//        if (!time.empty()) curtime = time.top()-prevtime;
//        if (!dist.empty()) curdist = dist.top()-prevdist;
//        // compare which comes before
//        if (dist.empty() || (!time.empty() && curtime < curdist*speed)) {
//            time.pop();
//            prevtime += curtime;
//            prevdist += curtime/speed;
//        }
//        else {
//            dist.pop();
//            prevtime += curdist*speed;
//            prevdist += curdist;
//        }
//        speed++;
//        cout << prevtime << " " << prevdist << "\n";
//    }
//    //cout << (1000-prevdist)/speed << " ";
//    int ans = round(prevtime + (1000-prevdist)*speed);
//    cout << ans;
//}
///*
//keep track of smallest time and smallest distance and compare which comes first
//*/
//
//
