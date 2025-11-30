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
//    const int mx = 5e6;
//    bool isprime[mx+1] = {false};
//       isprime[1] = true; isprime[2] = true;
//       for (int i = 2; i <= sqrt(mx); i++) {
//           if (isprime[i]) {
//               for (int j = 2*i; j <= mx; j+=i) {
//                   isprime[j] = false;
//               }
//           }
//       }
//       set<int> s;
//       for (int i = 1; i <= mx; i++) {
//           if (isprime[i]) s.insert(i);
//       }
//
//       int t; cin >> t;
//       while (t > 0) {
//           t--;
//           int n; cin >> n;
//           int minsteps = mx; bool fjwins = true;
//           for (int i = 0; i < n; i++) {
//               int a; cin >> a;
//               if (a % 4 == 0) {
//                   if (a/2 < minsteps) {
//                       minsteps = a/2; fjwins = false;
//                   }
//               }
//               else {
//                   int p = a;
//                   while (p > 0) {
//                       if (isprime[p] && a-p % 4 == 0) break;
//                       p--;
//                   }
//                   if ((a-p)/2+1 < minsteps) {
//                       minsteps = (a-p)/2; fjwins = true;
//                   }
//               }
//           }
//           if (fjwins) cout << "Farmer John\n";
//           else cout << "Farmer Nhoj\n";
//       }
//}
///*
//silver dec22 circular barn
//
// - winning strategy: get to multiple of 4 (whoever starts with a multiple of 4 loses)
// - want to win fast and lose slow
// - winner is whoever wins in minimum # rounds
// - if multiple of 4:
//    - fj loses
//    - loser will remove 1 because they want to lose slowly
//    - since loser removes 1, winner has to remove 3 to stay a multiple of 4
//    - # of rounds = ai/2
// - if not multiple of 4:
//    - fj wins
//    - remove largest prime to reach multiple of 4
//    - follow multiple of 4
//    - # of rounds = (ai - prime)/2
//
//*/
