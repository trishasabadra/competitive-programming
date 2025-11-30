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
//int n;
//// <x, y> : # of times this coord is visited using i instructions for all i < n
//map<pair<ll, ll>, vector<int>> m;
//void add(ll x, ll y, int i) {
//    if (m.count({x, y})) {
//        m[{x, y}][i]++;
//    }
//    else {
//        vector<int> v(n+1, 0); v[i] = 1;
//        m.insert({{x, y}, v});
//    }
//}
//
//vector<pair<ll, ll>> instruct(40);
//// coord <x, y>, # of instructions to get to this point, index of cur instruction
//void dfs(ll curx, ll cury, int i, int j) {
//    if (j == n) return;
//    
//    // don't use instruction
//    dfs(curx, cury, i, j+1);
//    
//    // use instruction
//    ll x = curx+instruct[j].f, y = cury+instruct[j].s;
//    if (m.count({x, y})) { // already contains point
//        m[{x, y}][i+1] += m[{curx, cury}][i];
//        if (m[{x, y}][i+1] == 1) dfs(x, y, i+1, j+1); // only dfs if haven't seen # of instructions
//    }
//    else { // doesn't contain point
//        vector<int> v(n, 0);
//        v[i+1] = m[{curx, cury}][i];
//        m.insert({{x, y}, v});
//        dfs(x, y, i+1, j+1);
//    }
//}
//
//int main() {
//  ios::sync_with_stdio(false);
//  cin.tie(nullptr);
//
//    int ex, ey; cin >> n >> ex >> ey;
//    for (int i = 0; i < n; i++) cin >> instruct[i].f >> instruct[i].s;
//    
//    add(0, 0, 0);
//    dfs(0, 0, 0, 0);
//
//    if (m.count({ex, ey})) {
//        for (int i = 1; i <= n; i++) cout << m[{ex, ey}][i] << "\n";
//    }
//    else {
//        for (int i = 0; i < n; i++) cout << "0\n";
//    }
//}
///*
// 2022 feb silver #2: robot instructions
// knapsack: choose each instruction or not
//dp[i] = list of current coordinates using first i instructions
//dp[i][j] = # of ways to reach end using j of first i instructions
//
// problem: need to know end points of previous instructions
//dp[i] = # of ways to reach end using first i instructions
//dp[i][j][k] = # of ways to reach <j, k> using first i instructions
// keep <j, k> in a vector because they can be very big
// 
// if we can reach <1, 3> with 3 instructions in 3 ways, we can reach <2, 4> with
// 
//
//*/
