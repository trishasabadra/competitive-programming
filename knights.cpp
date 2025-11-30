//#include </usr/local/include/bits/stdc++.h>
////#include <bits/stdc++.h>
//#define ms(x, a) memset(x, a, sizeof(x))
//const int MX = 1e5+5, MOD = 1e9+7;
//
//using namespace std;
//typedef pair<int, int> pi;
//typedef long long ll;
//#define f first
//#define s second
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
//    // factorial
//    fct[0] = 1;
//    for (ll i = 1; i < MX; i++) fct[i] = (fct[i-1]*i) % MOD;
//
//    int n, h; cin >> n >> h;
//    int arr[h];
//    ll tot = 0, left = n, sum = 0;
//    for (int i = 0; i < h; i++) {
//        cin >> arr[i];
//        left -= arr[i]; // # knights not counted in house
//        ll dbl = (((fct[sum] * fct[arr[i]]) % MOD) * fct[left]) % MOD; // double count
//        sum += arr[i]; sum %= MOD; // # of knights counted in house
//        // # left! * # in houses!
//        if (i > 0) tot += posMod(fct[sum] * fct[left] - dbl);
//        else tot += (fct[sum] * fct[left]) % MOD;
//
//        tot = posMod(tot);
//
//        cout << tot << " " << left << " " << dbl << " " << sum << "\n";
//    }
//
//    ll ans = posMod(fct[n] - tot);
//    if (left == 0) ans = 0;
//    cout << ans;
//}
///*
//
//*/
