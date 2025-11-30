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
//int main() {
//  ios::sync_with_stdio(false);
//  cin.tie(nullptr);
//    
//    int n; cin >> n;
//    vector<pair<int, pair<ll, int>>> nodes; // <height, <width, index>>
//    int i = 0, mn = 1e6;
//    for (int j = 0; j < n; j++) {
//        ll w; int h; cin >> w >> h;
//        nodes.push_back({h, {w, j}});
//        if (h < mn) {
//            mn = h;
//            i = j;
//        }
//    }
//    
//    ll ans = 0;
//    ll time[n]; for (int j = 0; j < n; j++) time[j] = 0;
//    while(i < nodes.size()) {
//        // keep going right until no longer decreasing
//        while (i < nodes.size()-1 && nodes[i].f > nodes[i+1].f) i++;
//        
//        // keep going left until no longer decreasing
//        while (i > 0 && nodes[i].f > nodes[i-1].f) i--;
//        
//        //cout << nodes[i].f << " " << nodes[i].s.f;
//        // spreads to right
//        if (i == 0 || (i < nodes.size()-1 && nodes[i+1].f < nodes[i-1].f)) {
//            //cout << " right\n";
//            time[nodes[i].s.s] = ans + nodes[i].s.f;
//            ans += nodes[i].s.f * (nodes[i+1].f - nodes[i].f);
//            nodes[i+1].s.f += nodes[i].s.f; // add cur width to right
//            nodes.erase(nodes.begin() + i); // remove cur
//        }
//        else { // spreads to left
//            //cout << " left\n";
//            time[nodes[i].s.s] = ans + nodes[i].s.f;
//            ans += nodes[i].s.f * (nodes[i-1].f - nodes[i].f);
//            nodes[i-1].s.f += nodes[i].s.f; // add cur width to left
//            nodes.erase(nodes.begin() + i); // remove cur node
//            i--;
//        }
//    }
//    
//    for (ll t : time) cout << t << "\n";
//    
//}
///*
//2 7 4 3
// if level to right has smaller height, goes to that level
// keep going right until level to right is greater
// then go back
// 
// if smaller then height to right, do one level of current
// then fill till next height.
// add current width to next height width
// 
// each node is height, width
// keep combining nodes together until you have super node at end
// 
// 8
// 4 10
// 3 9
// 4 7
// 2 3
// 5 2
// 3 1
// 1 4
// 4 5
//*/
//
