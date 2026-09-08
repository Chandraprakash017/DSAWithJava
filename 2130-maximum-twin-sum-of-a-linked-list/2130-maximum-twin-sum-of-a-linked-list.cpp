/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode() : val(0), next(nullptr) {}
 *     ListNode(int x) : val(x), next(nullptr) {}
 *     ListNode(int x, ListNode *next) : val(x), next(next) {}
 * };
 */
class Solution {
public:
    int pairSum(ListNode* head) {
        vector<int> ans;
        ListNode* curr=head;
        while(curr!=nullptr){
            ans.push_back(curr->val);
            curr=curr->next;
        }
        int n=ans.size();
        int left=0,right=n-1;
        int twinsum=0;
        for(int i=0;i<n;i++){
            int mtwinsum=ans[i]+ans[n-1-i];
            twinsum=max(twinsum,mtwinsum);
            
        }
        return twinsum;
       
            
        }
        
    
};