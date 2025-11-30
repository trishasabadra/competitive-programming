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
//    string str = "";
//    for (int i = 0; i < n; i++) {
//        string c; cin >> c;
//        str += c;
//    }
//    
//    string ans = "";
//    while (!str.empty()) {
//        int i = 0;
//        while (i < str.size()/2 && str[i] == str[str.size()-i-1]) i++;
//        
//        if (str[i] < str[str.size()-i-1]) { // choose front
//            ans += str[0];
//            str = str.substr(1);
//        }
//        else { // choose back
//            ans += str.back();
//            str = str.substr(0, str.size()-1);
//        }
//    }
//    for (int i = 0; i < ans.length(); i += 80) {
//        if (i+80 < ans.length()) cout << ans.substr(i, 80) << "\n";
//        else cout << ans.substr(i) << "\n";
//    }
//}
///*
//if one side is smaller then the other, simple: choose the smaller
//if both are same, keep comparing next index till not same
//*/
//
