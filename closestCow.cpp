//#include <bits/stdc++.h>
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
//bool sortbysec(const pair<int,int> &a, const pair<int,int> &b) {
//    if (a.first == b.first) return (a.second < b.second);
//    return a.first > b.first;
//}
//
//int main() {
//  ios::sync_with_stdio(false);
//  cin.tie(nullptr);
//    
//    int k, m, n; cin >> k >> m >> n;
//    vector<pi> patch;
//    for (int i = 0; i < k; i++) {
//        int p, t; cin >> p >> t;
//        patch.push_back({p, t});
//    }
//    sort(patch.begin(), patch.end());
//    
//    vector<int> adv(m); // adversary cow locations
//    for (int i = 0; i < m; i++) cin >> adv[i];
//    sort(adv.begin(), adv.end());
//    
//    vector<pi> ans;
//    int j = 0;
//    for (int i = 0; i < m; i++) { // interval is adv[i-1] -> adv[i]
//        vector<pi> pos;
//        int totsum = 0;
//        while (j < k && patch[j].f < adv[i]) {
//            pos.push_back(patch[j]);
//            totsum += patch[j].s;
//            j++;
//        }
//        
//        if (i == 0) {
//            ans.push_back({totsum, 1}); continue;
//        }
//        
//        double size = ((double)adv[i]-adv[i-1])/2; // size of sliding window
//        int sum = 0, maxsum = 0, temp = 0;
//        for (int p = 0; p < pos.size();) { // add new patch every time
//            double le = max(pos[p].f-size, (double)adv[i-1]);
//            // remove from start
//            while (temp < p && pos[temp].f <= le) {
//                sum -= pos[temp].s; temp++;
//            }
//            // add to end
//            while (p < pos.size() && pos[p].f <= le+size) {
//                sum += pos[p].s; p++;
//            }
//            maxsum = max(maxsum, sum);
//        }
//        //cout << maxsum << " " << totsum << "\n";
//        ans.push_back({maxsum, 1});
//        ans.push_back({totsum-maxsum, 2});
//    }
//    int sum = 0;
//    while (j < k) {
//        //cout << patch[j].s << " ";
//        sum += patch[j].s; j++;
//    }
//    //cout << sum << "\n";
//    ans.push_back({sum, 1});
//    
//    sort(ans.begin(), ans.end(), sortbysec);
//    
//    int totsum = 0;
//    for (int i = 0; i < n && i < ans.size(); i++) totsum += ans[i].f;
//    cout << totsum;
//}
///*
// closest cow wins
//k grass patches, m opponent cow locations (all diff from k), place n cows
//1. iterate through all intervals of adversary's
//2. can put 1 cow in interval or 2
//    - sliding window of size (right-left)/2 for max tastiness of 1 cow
//        - only care about important windows (have at least one patch)
//    - 2 cows can take all patches in interval
//3. add all 1 cow tastiness to vector. for 2 cow tastiness, add (2 cow tasty - 1 cow tasty) because this will only be added if 1 cow tasty is already added. for ties, put 1 cow before.
//4. sort and choose the n highest #
//
//*/
