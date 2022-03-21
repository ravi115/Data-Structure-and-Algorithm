package AdvancedProblem.recursive;

public class CanSum {

    static boolean canConstruct(int[] arr, int target) {

        if (target < 0) return false;
        if (target == 0 ) return true;
        for (int i = 0; i < arr.length; i++) {
            int result = target - arr[i];
            if (canConstruct(arr, result)) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println("Can sum of {7, [5, 3, 4, 7] } ::" + canConstruct(new int[]{5, 3, 4, 7}, 7));
        System.out.println("Can sum of {8, [2, 5, 7, 9] } ::" + canConstruct(new int[]{2, 5, 7, 9}, 8));
        System.out.println("Can sum of {7, [2, 4] } ::" + canConstruct(new int[]{2, 4}, 7));
        System.out.println("Can sum of {300, [7, 14] } ::" + canConstruct(new int[]{7, 14}, 300));
    }
}
