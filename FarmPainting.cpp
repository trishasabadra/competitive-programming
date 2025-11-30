////#include <bits/stdc++.h>
//#include <string>
//#include <fstream>
//#include <iostream>
//#include <vector>
//#include <set>
//
//using namespace std;
//typedef pair<int, int> pi;
//typedef long long ll;
//#define f first
//#define s second
//
//struct Point {
//    int x, y, index;
//    bool start;
//    Point(int x1, int y1, bool b, int i) {
//        x = x1; y = y1; start = b; index = i;
//    }
//};
//
//bool sortbyx(Point a, Point b) {
//    if (a.x == b.x && !b.start) return 1; // sort end before start
//    return a.x <= b.x;
//}
//bool sortbyy(Point a, Point b) {
//    if (a.y == b.y && !b.start) return 1; // sort end before start
//    return a.y <= b.y;
//}
//
//int main() {
//  ios::sync_with_stdio(false);
//  cin.tie(nullptr);
//    
//    int n; cin >> n;
//    vector<Point> xsort;
//    int x1[n], y1[n], x2[n], y2[n];
//    for (int i = 0; i < n; i++) {
//        cin >> x1[i] >> y1[i] >> x2[i] >> y2[i]; // left-bot, right-top corners
//        xsort.push_back(Point(x1[i], y1[i], true, i)); // left coord
//        xsort.push_back(Point(x2[i], y2[i], false, i)); // right coord
//    }
//    sort(xsort.begin(), xsort.end(), sortbyx);
//    
//    bool outside[n]; for (int i = 0; i < n; i++) outside[i] = true;
//    set<Point> ysort;
//    for (int i = 0; i < 2*n;) { // sweep left to right
//        int curX = xsort[i].x;
//        while (i < n && xsort[i].x == curX) {
//            if (xsort[i].start) { // starting new rectangle
//                ysort.insert(xsort[i]); // bottom left coord
//                ysort.insert(Point(xsort[i].x, y2[xsort[i].index], false, xsort[i].index)); // top left coord
//            }
//            else { // ending rectangle
//                ysort.erase(remove(ysort.begin(), ysort.end(), Point(x1[xsort[i].index], xsort[i].y, true, xsort[i].index)), ysort.end());
//                ysort.erase(remove(ysort.begin(), ysort.end(), Point(x1[xsort[i].index], y2[xsort[i].index], false, xsort[i].index)), ysort.end());
//            }
//            i++;
//        }
//        
//        int curRec = 0; // current number of rectangles
//        for (auto j : ysort) { // sweep bottom to top
//            if (j.start) {
//                if (curRec > 0) outside[j.index] = false;
//                curRec++;
//            }
//            else curRec--;
//        }
//    }
//    
//    int count = 0;
//    for (int i = 0; i < n; i++) count += outside[i];
//    cout << count;
//}
///*
// problem:
// - given non intersecting rectangles. rectangles can be enclosed within each other.
// - find the number of enclosures not inside another / outside of all others
//
// sweep line -> go from left to right on x-axis. if the y-coordinates are inside then subtract 1 from the counter. counter = n at the start.
// 
// sort by x-coordinate and label all start or finish, index, and y coordinate
// for each x-coordinate, sweepline on y-coords and find which intersect
//
//*/
