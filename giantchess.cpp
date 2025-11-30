//#include </usr/local/include/bits/stdc++.h>
////#include <bits/stdc++.h>
//#define ms(x, a) memset(x, a, sizeof(x))
//const int MX = 2e5+5, MOD = 1e9+7;
//
//using namespace std;
//typedef pair<int, int> pi;
//typedef long long ll;
//#define f first
//#define s second
//
//bool sortbysec(const pair<int,int> &a, const pair<int,int> &b){
//    if (a.first == b.first) return (a.second < b.second);
//    else return (a.first < b.first);
//}
//
//// return a^b in O(log b) time
//ll binpow(ll a, ll b, ll p) {
//    ll res = 1;
//    a %= p;
//    while (b > 0) {
//        if (b & 1) res = (res*a) % p;
//        a = (a*a) % p;
//        b >>= 1;
//    }
//    return res;
//}
//ll modInverse(ll n, ll p) {
//    return binpow(n, p-2, p);
//}
//
//ll fct[MX]; // factorial
//ll choose(int n, int r) {
//    return (fct[n]*modInverse(fct[r], MOD) % MOD * modInverse(fct[n-r], MOD) % MOD) % MOD;
//}
//
//ll posMod(ll i) {
//    return (i % MOD + MOD) % MOD;
//}
//
//int main() {
//  ios::sync_with_stdio(false);
//  cin.tie(nullptr);
//
//    // read input
//    int h, w, n; cin >> h >> w >> n; h--; w--;
//    vector<pi> coord;
//    coord.push_back(pair{0, 0});
//    for (int i = 0; i < n; i++) {
//        int r, c; cin >> r >> c;
//        coord.push_back(pair{r-1, c-1});
//    }
//    sort(coord.begin(), coord.end(), sortbysec);
//
//    // factorial
//    fct[0] = 1;
//    for (ll i = 1; i < MX; i++) fct[i] = (fct[i-1]*i) % MOD;
//
//    ll dp[n+1];
//    for (int i = n; i >= 0; i--) { // largest to smallest
//        int r = coord[i].f, c = coord[i].s;
//        dp[i] = choose(h + w - r - c, h - r) % MOD;
//        for (int j = n; j > i; j--) {
//            int r2 = coord[j].f, c2 = coord[j].s;
//            if (c2 < c) continue;
//            dp[i] -= posMod(choose(r2 + c2 - r - c, r2 - r) * dp[j]);
//            dp[i] = posMod(dp[i]);
//            //cout << i << " " << j << " " << choose(r2 + c2 - r - c, r2 - r) << " " << dp[j] << "\n";
//        }
//        //cout << r << " " << c << " " << dp[i] << "\n";
//    }
//
//    cout << posMod(dp[0]);
//
//
//
//}
///*
//solution ideas:
// - count # of ways (0, 0) -> bad cell AND bad cell -> (h, w)
// - start top left bad cell to bottom right
// - at each bad cell, find the # of paths that go through previous bad cells
//    = (0, 0) -> b1 * b1 -> b2
//    - already have first part
//- only n = 2000 bad cells so can do n^2
//
// debug: sorting, mod!,
//*/
