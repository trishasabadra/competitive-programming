////#include <bits/stdc++.h>
//#include <string>
//#include <fstream>
//#include <iostream>
//#include <vector>
//#include <map>
//
//using namespace std;
//typedef pair<int, int> pi;
//typedef long long ll;
//#define f first
//#define s second
//
//map<string, int> dp; // counts number of times each string can be broken
//int MOD = 2014;
//void dfs(string s) {
//    int count = 1, n = s.size();
//    for (int i = 1; i < n; i++) {
//        string left = s.substr(0, i), right = s.substr(i);
//        if (i > n/2) { // left string > right string
//            // if right part is the front or back of left
//            if (left.substr(0, n-i).compare(right) == 0 || left.substr(i-n+i).compare(right) == 0) {
//                //cout << s << " " << left << " " << right << "\n";
//                if (!dp.count(left)) dfs(left);
//                count += dp.find(left)->s % MOD;
//            }
//        }
//        else if (i < (double)n/2) {
//            if (right.substr(0, i).compare(left) == 0 || right.substr(n-i-i).compare(left) == 0) {
//                //cout << s << " " << left << " " << right << "\n";
//                if (!dp.count(right)) dfs(right);
//                count += dp.find(right)->s % MOD;
//            }
//        }
//    }
//    cout << s << " " << count << "\n";
//    dp.insert({s, count % MOD});
//}
//
//int main() {
//  ios::sync_with_stdio(false);
//  cin.tie(nullptr);
//
//    string str; cin >> str; // final string
//    dfs(str);
//    cout << dp.find(str)->s-1;
//}
///*
//len = string length
// # of encryptions = 2 * (len-1 + len-1)
// 2 * because can add original to front or back
// len-1 because can remove len-1 times from front or back
//
// dp[i][j] = # of ways to produce range (i, j) of the string
//
// some problem with mod. subtracting 1 after modding won't work
//*/
//
//
