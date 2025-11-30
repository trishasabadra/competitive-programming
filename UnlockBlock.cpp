////#include <bits/stdc++.h>
//#include <string>
//#include <fstream>
//#include <iostream>
//#include <vector>
//#include <queue>
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
//    int B1, B2, B3; cin >> B1 >> B2 >> B3;
//    pi b1[B1], b2[B2], b3[B3];
//    int bound[3][4]; // bot left and top right corners of the bounding box of each block
//    bool filled1[100][100] = { false }, filled2[100][100] = { false }, filled3[100][100] = { false };
//    for (int i = 0; i < B1; i++) {
//        cin >> b1[i].f >> b1[i].s;
//        filled1[b1[i].f][b1[i].s] = true;
//        bound[0][0] = min(bound[0][0], b1[i].f);
//        bound[0][1] = min(bound[0][1], b1[i].s);
//        bound[0][2] = min(bound[0][2], b1[i].f);
//        bound[0][3] = min(bound[0][3], b1[i].s);
//    }
//    for (int i = 0; i < B2; i++) {
//        cin >> b2[i].f >> b2[i].s;
//        filled2[b2[i].f][b2[i].s] = true;
//        bound[1][0] = min(bound[1][0], b2[i].f);
//        bound[1][1] = min(bound[1][1], b2[i].s);
//        bound[1][2] = min(bound[1][2], b2[i].f);
//        bound[1][3] = min(bound[1][3], b2[i].s);
//    }
//    for (int i = 0; i < B3; i++) {
//        cin >> b3[i].f >> b3[i].s;
//        filled3[b3[i].f][b3[i].s] = true;
//        bound[2][0] = min(bound[2][0], b3[i].f);
//        bound[2][1] = min(bound[2][1], b3[i].s);
//        bound[2][2] = min(bound[2][2], b3[i].f);
//        bound[2][3] = min(bound[2][3], b3[i].s);
//    }
//    
//    bool vis[20][20][20][20] = { false };
////      for (int i = 0; i < 20; i++) {
////        for (int j = 0; j < 20; j++)
////            for (int k = 0; k < 20; k++) {
////                for (int m = 0; m < 20; m++) vis[i][j][k][m] = false;
////            }
////      }
//    
//      queue<pair<pi, pi>> coords; // <x1, y1> <x2, y2>
//      queue<int> layers; // layer
//    coords.push({{0, 0}, {0, 0}}); layers.push(0);
//      vis[0][0][0][0] = true;
//      while (!coords.empty()) {
//        int x1 = coords.front().f.f, y1 = coords.front().f.s, x2 = coords.front().s.f,
//          y2 = coords.front().s.s, layer = layers.front();
//        coords.pop(); layers.pop();
//          
//          // make sure this is a valid state = no blocks are overlapping
//          bool valid = true;
//          for (int i = 0; i < B1; i++) { // check block 1 against block 3
//              if (filled3[b1[i].f+x1][b1[i].s+y1]) valid = false;
//          }
//          for (int i = 0; i < B2; i++) { // check block 2 against block 3
//              if (filled3[b2[i].f+x2][b2[i].s+y2]) valid = false;
//          }
//          if (!valid) continue;
//          
//          // if no bounding boxes intersect, we are done
//          bool end = true;
//          for (int i = 0; i < 3; i++) {
//              for (int j = i+1; j < 3; j++) {
//                  // compare block i with j
//                  int area = (min(bound[i][2], bound[j][2]) - max(bound[i][0], bound[j][0])) * (min(bound[i][3], bound[j][3]) - max(bound[i][1], bound[j][1]));
//                  if (area > 0) { // if intersecting, we are not done
//                      end = false; break;
//                  }
//              }
//          }
//          if (end) {
//              cout << layer; break;
//          }
//          
//          // p1 moves, p2 moves, p3 moves (both p1 and p2 move relative to p3)
//          pi p1[12] = {{-1, 0}, {0, 0}, {-1, 0}, {1, 0}, {0, 0}, {1, 0}, {0, -1}, {0, 0}, {0, -1}, {0, 1}, {0, 0}, {0, 1}};
//          pi p2[12] = {{0, 0}, {-1, 0}, {-1, 0}, {0, 0}, {1, 0}, {1, 0}, {0, 0}, {0, -1}, {0, -1}, {0, 0}, {0, 1}, {0, 1}};
//          
//        for (int i = 0; i < 12; i++) {
//            int nx1 = p1[i].f, ny1 = p1[i].s, nx2 = p2[i].f, ny2 = p2[i].s;
//          if (!vis[nx1][ny1][nx2][ny2]) { // not visited this state yet
//              vis[nx1][ny1][nx2][ny2] = true;
//              coords.push({{nx1, ny1}, {nx2, ny2}}); layers.push(layer+1);
//          }
//        }
//      }
//
//}
///*
// BFS / DP:
// think of as directed graph:
//  - each node is a game state
//  - each edge is a move (an object moving in some direction)
// after a move in the game, we get a new game state = directed node connected to it
//find the minimum # of moves from start state to a target state
// 
// (x1, y1) (x2, y2) (x3, y3) = 3 pieces relative to starting position
// 
// only care about pieces position relative to each other
// if we fix the third piece, (x1, y1) (x2, y2) is relative to the third piece
// 
// 12 transitions:
// (-1, 0), (-1)
// 
// store each object as a list of x and y coordinates
// 
// bounding box = min and max x and y coordinates
// target state = no bounding boxes intersect
//  - offset coordinates by the transition
// valid state = no overlapping blocks
//  - use a boolean array, fill it with squares of each block
//*/
