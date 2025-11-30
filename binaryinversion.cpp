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
//    int n; cin >> n;
//    int a[n], b[n];
//    for (int i = 0; i < n; i++) cin >> a[i];
//    for (int i = 0; i < n; i++) cin >> b[i];
//    
//    queue<int> azero, aone; // indices of 0 and 1 in a
//    stack<int> bzero, bone; // indices of 0 and 1 in b
//    int ainv = 0, binv = 0; // # inversions in a and b
//    for (int i = n-1; i >= 0; i--) {
//        if (a[i] == 0) azero.push(i);
//        else {
//            aone.push(i);
//            ainv += azero.size();
//        }
//        
//        if (b[i] == 0) bzero.push(i);
//        else {
//            bone.push(i);
//            binv += bzero.size();
//        }
//    }
//    
//    // choose swap 0 <-> 1:
//    // swaps[i] = min # of total swaps if we do i middle swaps, dif[i] = |ainv - binv|
//    ll swaps = 0, dif = ainv - binv, ans = abs(dif);
//    for (int i = 1; i < n && !azero.empty() && !bone.empty(); i++) { // i middle swaps
//        swaps += n-azero.front() + bone.top(); // set up to get to next middle swap
//        dif += -azero.front() - bone.top() + azero.size() - bone.size() + n - 1;
//        ans = min(ans, swaps+abs(dif));
//        azero.pop(); bone.pop();
//    }
//    //cout << ans;
//    
//    // choose swap 1 <-> 0:
//    swaps = 0; dif = ainv-binv;
//    for (int i = 1; i < n && !aone.empty() && !bzero.empty(); i++) { // i middle swaps
//        swaps += n-aone.front() + bzero.top(); // set up to get to next middle swap
//        dif += aone.front() + bzero.top() + aone.size() - bzero.size() - n + 1;
//        ans = min(ans, swaps+abs(dif));
//        aone.pop(); bzero.pop();
//    }
//    
//    cout << ans;
//}
///*
// A = first half, B = second half
// make # of inversions in A = # of inversions in B
// can only swap adjacent elements
// minimize swaps
// 
// OBSERVATION:
// - only swap if 0-1
// - swap only changes # of inversions by 1
// - for only individual swaps answer = abs(A inversions - B inversions)
// - middle swap formulas:
//    ans = A inv - B inv
//    0 <-> 1: change in ans = -N + 0T
//    1 <-> 0: change in ans = N - 0T
// - only want to do one kind of middle swap because they cancel each other out
// 
// ALGORITHM:
// - choose one swap and simulate swap 0, 1,... N times
//    - keep 2 pointers of nearest on each side to do swap
//    - keep track of total number of swaps
// - take min over |A inv - B inv| for all N time swaps
// 
// 6
// 1 0 0 0 1 0 0 0 0 1 0 1
//*/
