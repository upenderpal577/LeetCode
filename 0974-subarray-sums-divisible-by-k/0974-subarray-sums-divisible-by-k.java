class Solution {
    public int subarraysDivByK(int[] nums, int k) {
        int[] freq = new int[k];
        freq[0] = 1;

        int sum = 0;
        int count = 0;

        for (int num : nums) {
            sum += num;

            int rem = ((sum % k) + k) % k;

            count += freq[rem];
            freq[rem]++;
        }

        return count;
    }
}