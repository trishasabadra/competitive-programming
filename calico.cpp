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
////    char co[9] = {'m', 'n', 'p', 't', 'k', 's', 'w', 'j', 'l'}, vo[5] = {'a', 'e', 'i', 'o', 'u'};
////    string ill[6] = {"wu", "wo", "ji", "ti", "nn", "nm"};
////    set<string> illegal;
////    for (int i = 0; i < 6; i++) illegal.insert(ill[i]);
////    set<char> cons, vowel;
////    for (int i = 0; i < 9; i++) cons.insert(co[i]);
////    for (int i = 0; i < 5; i++) vowel.insert(vo[i]);
////
////
////    int t; cin >> t;
////    while (t > 0) {
////        string str; cin >> str;
////        bool valid = true;
////        for (int i = 0; i < str.length(); i++) {
////            if ((i > 0 && illegal.count(str.substr(i-1, 2))) ||
////                (i+1 < str.length() && (illegal.count(str.substr(i, 2)) ||
////                                        (vowel.count(str[i]) && vowel.count(str[i+1]))))) {
////                valid = false;
////                break;
////            }
////
////            char c = str[i];
////            if (!vowel.count(c)) { // if not starting with vowel
////                char v = str[i+1];
////                if (!cons.count(c) || !vowel.count(v)) {
////                    valid = false; break;
////                }
////                i++;
////            }
////            if (i+1 < str.length()) { // optional n at end
////                if (str[i+1] == 'n') i++;
////            }
////        }
////        if (valid) cout << "pona\n" << flush;
////        else cout << "ike\n" << flush;
////        t--;
////    }
//
////    int t; cin >> t;
////    while (t > 0) {
////        int n; cin >> n;
////        int power[n], dist[n];
////        for (int i = 0; i < n; i++) cin >> power[i];
////        for (int i = 0; i < n; i++) cin >> dist[i];
////
////        ll mintime = 1e17;
////        for (int i = 0; i < n; i++) { // if we start at position i
////            int j = i;
////            ll cur = 0;
////            while (true) {
////                if (cur < power[j]) cur = power[j];
////                if ((j+1)%n == i) break;
////                cur += dist[j];
////                j++; j %= n;
////            }
////            mintime = min(mintime, cur);
////        }
////        cout << mintime << "\n";
////        t--;
////    }
//
//    int t; cin >> t;
//    while (t > 0) {
//        int n; cin >> n;
//        string str; cin >> str;
//        set<char> vis;
//        bool valid = true;
//        for (char c : str) {
//            if (!vis.count(c)) vis.insert(c);
//            else {
//                if (vis.size() < 6) {
//                    valid = false; break;
//                }
//            }
//            if (vis.size() == 7) {
//                vis.clear();
//            }
//        }
//        if (valid) cout << "YES\n";
//        else cout << "NO\n";
//        t--;
//    }
//}
///*
//if same letter too close, not possible
// store positions of each letter
// letters can only be close if at end of bag and start of bag
// make bag (i.e take ordering of letters)
// holding only works if we don't want to use only ONE character
// simulate game
//*/
