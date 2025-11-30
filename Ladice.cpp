//#include <bits/stdc++.h>
//#include <string>
//#include <fstream>
//#include <iostream>
//#include <vector>
//
//using namespace std;
//typedef pair<int, int> pi;
//typedef long long ll;
//#define f first
//#define s second
//
//int cnt[300001]; // count[i] = # of times connected component of i is called
//
//struct DSU {
//    vector<int> e;
//    DSU(int N) { e = vector<int>(N, -1); }
//
//    // get representive component / root node (uses path compression)
//    int get(int x) { return e[x] < 0 ? x : e[x] = get(e[x]); }
//
//  // see if a and b are in the same connected component
//    bool same_set(int a, int b) { return get(a) == get(b); }
//
//    int size(int x) { return -e[get(x)]; } // size of component with node x
//
//    bool unite(int x, int y) {  // connect components of x and y
//        x = get(x); y = get(y);
//        cnt[x] += 1;
//        //cnt[y] = x;
//        if (x == y) return false;
//        if (e[x] > e[y]) swap(x, y);
//        e[x] += e[y]; e[y] = x;
//        cnt[x] += cnt[y];
//        return true;
//    }
//};
//
//int main() {
//  ios::sync_with_stdio(false);
//  cin.tie(nullptr);
//
//    int n, m; cin >> n >> m;
//    
//    DSU dsu(m);
//    for (int i = 0; i < n; i++) cnt[i] = 0;
//    
//    for (int i = 0; i < n; i++) {
//        int a, b; cin >> a >> b; a--; b--;
//        dsu.unite(a, b);
//        if (dsu.size(a) >= cnt[dsu.get(a)]) cout << "LADICA\n";
//        else {
//            cnt[dsu.get(a)]--;
//            cout << "SMECE\n";
//        }
//        //cout << dsu.size(a) << " " << dsu.get(a)+1 << " " << cnt[dsu.get(a)] << "\n";
//    }
//    
//}
///*
// problem 7:
// brute force
// 
// given n items, m drawers. each item has a first (A) and second (B) choice drawer. only 1 item can go in a drawer. iterate through items in order and assign it to A if empty, else B if empty
// 
// if the size of the connected component >= number of items, allowed
// else not allowed
//*/
