////#include </usr/local/include/bits/stdc++.h>
//#include <bits/stdc++.h>
//#define ms(x, a) memset(x, a, sizeof(x))
//const int MX = 2e5+5, MOD = 998244353;
//
//using namespace std;
//typedef pair<int, int> pi;
//typedef long long ll;
//#define f first
//#define s second
//
//ll posMod(ll i) {
//    return (i % MOD + MOD) % MOD;
//}
//
//int main() {
//  ios::sync_with_stdio(false);
//  cin.tie(nullptr);
//
//    int n; cin >> n;
//    int p[n-1]; // parent
//    vector<int> adj[n];
//    for (int i = 0; i < n - 1; i++) {
//        cin >> p[i]; p[i]--;
//        adj[p[i]].push_back(i + 1);
//    }
//    
//    ll dp[n][3];
//    for (int i = 0; i < n; i++) {
//        for (int j = 0; j < 3; j++) dp[i][j] = 0;
//    }
//    
//    for (int i = n - 1; i >= 0; i--) {
//        if (adj[i].size() > 0) {
//            dp[i][2] = 1;
//            for (auto v : adj[i]) {
//                int sum1 = posMod(dp[v][0] + dp[v][1]), sum2 = posMod(dp[v][0] + dp[v][2]);
//                dp[i][0] = posMod((posMod(dp[i][0] + dp[i][1]) * sum1 % MOD) + posMod(dp[i][0] * sum2));
//                dp[i][1] = posMod((dp[i][2] * sum1 % MOD) + (dp[i][1] * sum2 % MOD));
//                dp[i][2] = dp[i][2] * sum2 % MOD;
//            }
//        }
//        else
//            dp[i][0] = 1;
//    }
//    cout << posMod(dp[0][0] + dp[0][2]);
//    
//}
///*
// on/off | use light
//dp[n] [0/1]  [0/1] = minimum cost to reach this state
//0, 0 = off & not used = initally inf
//0, 1 = off & used = initally inf
//1, 0 = on & not used = children have to be lit up already b/c not using light = sum over all children: min ((1, 0), (1, 1)) -> doesn't matter if children are on or not
//1, 1 = on & used = cost + sum over all children: min over all dp states
//
// where do we root the tree?
//
// if off at the beginning, you parent needs to light you up
//
// complementary counting = total - bad
// bad:
//
// overcounting?
//
//*/
