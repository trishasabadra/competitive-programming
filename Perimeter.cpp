////#include <bits/stdc++.h>
//#include <string>
//#include <fstream>
//#include <iostream>
//#include <vector>
//#include <queue>
//#include <cmath>
//#include <map>
//
//using namespace std;
//typedef pair<int, int> pi;
//typedef long long ll;
//#define f first
//#define s second
//
//int dir[4][3][2] = { {{0, 1}, {-1, 0}, {0, -1}}, // left
//            {{0, -1}, {1, 0}, {0, 1}},  // right
//            {{1, 0}, {0, 1}, {-1, 0}},  // up
//            {{-1, 0}, {0, -1}, {1, 0}} }; // down
//
//int main() {
//  ios::sync_with_stdio(false);
//  cin.tie(nullptr);
//
//    int n; cin >> n; 
//    multimap<int, int> m; // <x, y>
//    int sx = 0, sy = 0; // start x, y
//    for (int i = 0; i < n; i++) {
//        int x, y;
//        m.insert({x, y});
//        if (y > sy) {sy = y; sx = x; }
//    }
//
//    multimap<int, int> vis; // if <x, y> is visited already
//    int curx = sx, cury = sy;
//    int curd = 0; // current direction: 0 = left, 1 = right, 2 = up, 3 = down
//    int count = 0;
//    while (true) {
//        for (int i = 0; i < 3; i++) {
//            int x = curx+dir[curd][i][0], y = cury+dir[curd][i][1];
//            bool haspoint = false;
//            for (auto itr = m.find(x); itr != m.end(); itr++) {
//                if (itr->s == y) {
//                    haspoint = true; break;
//                }
//            }
//            if (haspoint) {
//                curd = i;
//                curx = x; cury = y;
//                break;
//            }
//        }
//        if (curx == sx && cury == sy) break;
//        count++;
//    }
//    cout << count;
//}
///*
//  perimeter:
// dfs to trace perimeter
// start at one block and check up, down, left, right, for another non visted block. if none, then check diagonals.
//make sure next move is not opposite of previous move.
// mark blocks as visited
// same direction: +1, different direction: +2
// if going down, count on left, going up, count on right.
//
// start at top and go counter clockwise
// 1. go right/diagonal right
// 2. go forward
// 3. go left
//
// right of left = up
// front of left = left
// left of left = down
//
// right of right = down
// front of right = right
// left of right = up
//
// right of up = right
// front of up = up
// left of up = left
//
// right of down = left
// front of down = down
// left of down = right
//
//*/
