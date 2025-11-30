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
//struct Point {
//    int pos, index, radius; bool isstart;
//    Point (int p, int i, int r, bool b) {
//        pos = p; index = i; radius = r; isstart = b;
//    }
//};
//bool sortpos(Point a, Point b) {return a.pos < b.pos;} // increasing order of position
//bool sortradius(Point a, Point b) {return a.radius > b.radius;} // decreasing order of radius
//
//int main() {
//  ios::sync_with_stdio(false);
//  cin.tie(nullptr);
//
//    int n; cin >> n;
//    vector<Point> line; // <pos, <index, is start>>
//    for (int i = 0; i < n; i++) {
//        int x, r; cin >> x >> r;
//        line.push_back(Point(x-r, i, r, true));
//        line.push_back(Point(x+r, i, r, false));
//    }
//    sort(line.begin(), line.end(), sortpos); // sorts based on position
//
//    stack<int> circles; // tells us last added circle
//    bool consec[n]; // if circle n is consecutive/ can be divided into two regions
//    for (int i = 0; i < n; i++) consec[i] = true;
//    for (int i = 0; i < 2*n;) {
//        vector<Point> starts;
//        while (i < 2*n) {
//            if (line[i].isstart) starts.push_back(line[i]);
//            else circles.pop(); // remove ends
//            i++;
//            if (line[i].pos != line[i-1].pos) break;
//        }
//        // check
//        sort(starts.begin(), starts.end(), sortradius); // sort starts based on radius
//        for (Point j : starts) circles.push(j.index);  // add starts
//        if (!circles.empty()) consec[circles.top()] = false;
//    }
//
//    int ans = n+1;
//    for (int i = 0; i < n; i++) ans += consec[i];
//    cout << ans;
//}
///*
// KEY OBSERVATION: a circle is either one or two regions
//    - only two regions if divided into above and below
//        - only divided if all circles inside are consecutive (no gaps in between)
//        - not consecutive if:
//            - not at very end and a circle is ending but another is not starting
//            - no other circle is starting with it
//            - no other circle is ending with it
//            - less than 2 circles inside it
//    - answer = n+1 + # circle that can be divided into two regions
//    - make number line and insert start and end x-axis of each circle
//    - use stack to keep track of circles. add circle index to stack when starting, pop when ending.
//    - want to end circles first, then start
//    - add starts in decreasing order of radius
//*/
