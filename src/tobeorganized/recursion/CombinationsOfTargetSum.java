package tobeorganized.recursion;

/**
 * LeetCode Problem - 39,40,216,377<br>
 * Given a set of candidate numbers (candidates) (without duplicates) and a target number (target),
 * find all unique combinations in candidates where the candidate numbers sums to target.<br>
 *
 * <p>Combinational Sum 1 - The same repeated number may be chosen from candidates unlimited number
 * of times. All numbers (including target) will be positive integers. The solution set must not
 * contain duplicate combinations.
 *
 * <p>Combinational Sum 2 - Each number in candidates may only be used once in the combination.All
 * numbers (including target) will be positive integers. The solution set must not contain duplicate
 * combinations.
 *
 * <p>Combinational Sum 3 - Find all possible combinations of k numbers that add up to a number n,
 * given that only numbers from 1 to 9 can be used and each combination should be a unique set of
 * numbers.
 *
 * <p>Combinational Sum 4 - Given an integer array with all positive numbers and no duplicates, find
 * the number of possible combinations that add up to a positive integer target.
 */
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

class CombinationsOfTargetSum {

  private int[] dp;

  public static void main(String[] args) {

    System.out.println(combinationSum1(new int[] {2, 3, 6, 7}, 7).toString());
    System.out.println(combinationSum1(new int[] {2, 3, 5}, 8).toString());
  }

  // combinational Sum 1  (Time Complexity - O(n^2), Space complexity - O(n))
  public static List<List<Integer>> combinationSum1(int[] nums, int target) {
    if (target == 0 || nums.length == 0) {
      return Collections.EMPTY_LIST;
    }
    List<List<Integer>> result = new ArrayList<>();
    backTrackCombinationSum1(nums, result, new ArrayList<Integer>(), 0, target);

    return result;
  }

  private static void backTrackCombinationSum1(
      int[] nums, List<List<Integer>> result, List<Integer> tempList, int start, int target) {
    if (target == 0) {
      result.add(new ArrayList<>(tempList));
    } else if (target < 0) {
      return;
    } else {
      for (int i = start; i < nums.length; i++) {
        tempList.add(nums[i]);
        backTrackCombinationSum1(nums, result, tempList, i, target - nums[i]);
        tempList.remove(tempList.size() - 1);
      }
    }
  }

  // combinational sum 2 (Time Complexity - O(n^2), Space complexity - O(n))
  public List<List<Integer>> combinationSum2(int[] candidates, int target) {
    if (target == 0 || candidates.length == 0) {
      return Collections.EMPTY_LIST;
    }
    List<List<Integer>> result = new ArrayList<>();
    Arrays.sort(candidates);
    backtrackCombinationSum2(candidates, result, new ArrayList<Integer>(), 0, target);
    return result;
  }

  private void backtrackCombinationSum2(
      int[] nums, List<List<Integer>> result, List<Integer> tempList, int start, int target) {
    if (target == 0) {
      result.add(new ArrayList<>(tempList));
    } else if (target < 0) {
      return;
    } else {
      for (int i = start; i < nums.length; i++) {
        if (i > start && nums[i] == nums[i - 1]) {
          continue;
        }
        tempList.add(nums[i]);
        backtrackCombinationSum2(nums, result, tempList, i + 1, target - nums[i]);
        tempList.remove(tempList.size() - 1);
      }
    }
  }

  // combinational sum 3 (Time Complexity - O(n^2), Space complexity - O(n))
  public List<List<Integer>> combinationSum3(int k, int n) {
    List<List<Integer>> ans = new ArrayList<>();
    backtrackCombinationSum3(ans, new ArrayList<Integer>(), k, 1, n);
    return ans;
  }

  private void backtrackCombinationSum3(
      List<List<Integer>> ans, List<Integer> comb, int k, int start, int n) {
    if (comb.size() == k && n == 0) {
      List<Integer> li = new ArrayList<Integer>(comb);
      ans.add(li);
      return;
    }
    for (int i = start; i <= 9; i++) {
      comb.add(i);
      backtrackCombinationSum3(ans, comb, k, i + 1, n - i);
      comb.remove(comb.size() - 1);
    }
  }

  // combinational Sum 4  (Time Complexity - O(mn), Space complexity - O(n))
  public int combinationSum4TopDown(int[] nums, int target) {
    dp = new int[target + 1];
    Arrays.fill(dp, -1);
    dp[0] = 1;
    return combinationSum4Helper(nums, target);
  }

  private int combinationSum4Helper(int[] nums, int target) {
    if (dp[target] != -1) {
      return dp[target];
    }
    int res = 0;
    for (int i = 0; i < nums.length; i++) {
      if (target >= nums[i]) {
        res += combinationSum4Helper(nums, target - nums[i]);
      }
    }
    dp[target] = res;
    return res;
  }

  public int combinationSum4BottomUp(int[] nums, int target) {
    int[] comb = new int[target + 1];
    comb[0] = 1;
    for (int i = 1; i < comb.length; i++) {
      for (int j = 0; j < nums.length; j++) {
        if (i - nums[j] >= 0) {
          comb[i] += comb[i - nums[j]];
        }
      }
    }
    return comb[target];
  }
}
