#include <vector>
#include <map>
#include <algorithm>
using namespace std;

class Solution {
public:
    int maximumSaleItems(vector<vector<int>>& items, int budget) {
        int maxFactor = 0;
        long long minPrice = 4e18;
        for (const auto& it : items) {
            maxFactor = max(maxFactor, it[0]);
            minPrice = min(minPrice, (long long)it[1]);
        }

        // freq[f] = number of items with factor == f
        vector<long long> freq(maxFactor + 1, 0);
        for (const auto& it : items) {
            freq[it[0]]++;
        }

        // multCount[f] = number of items whose factor is a multiple of f
        vector<long long> multCount(maxFactor + 1, 0);
        for (int f = 1; f <= maxFactor; ++f) {
            if (freq[f] == 0) continue;
            for (int m = f; m <= maxFactor; m += f) {
                multCount[f] += freq[m];
            }
        }

        // Map price -> total number of "2-for-price" bonus opportunities
        map<long long, long long> bonusByCost;
        for (const auto& it : items) {
            int f = it[0];
            long long cost = it[1];
            long long targets = multCount[f] - 1; // exclude item itself
            if (targets > 0 && cost <= 2 * minPrice) {
                bonusByCost[cost] += targets;
            }
        }

        long long remBudget = budget;
        long long totalItems = 0;

        for (const auto& [cost, avail] : bonusByCost) {
            if (remBudget < cost) break;
            long long take = min(avail, remBudget / cost);
            // Each taken copy gives 1 purchased item + 1 free item = 2 items
            totalItems += 2 * take;
            remBudget -= take * cost;
        }

        totalItems += remBudget / minPrice;
        return (int)totalItems;
    }
};