class Solution {

    List<List<Integer>> ans = new ArrayList<>();

    public List<List<Integer>> combinationSum(int[] candidates, int target) {

        backtrack(0, candidates, target, new ArrayList<>());
        return ans;
    }

    void backtrack(int index, int[] candidates, int target,
                   List<Integer> curr) {

        if (target == 0) {
            ans.add(new ArrayList<>(curr));
            return;
        }

        if (index == candidates.length)
            return;

        // Take current element
        if (candidates[index] <= target) {
            curr.add(candidates[index]);
            backtrack(index, candidates,
                      target - candidates[index], curr);
            curr.remove(curr.size() - 1);
        }

        // Skip current element
        backtrack(index + 1, candidates, target, curr);
    }
}