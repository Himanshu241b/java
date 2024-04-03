package Feb_27;

public class ProductArrayPuzzle_GFG {
    public static void main(String[] args) {
        long[] nums = {1, 2, 4, 0, 5};
        int n = nums.length;
        long[] ans = new long[nums.length];

        long product = 1;
        int isZero = 0;
        for(long i: nums)
        {
            if(i != 0){
                product *= i;
            }
            else isZero++;
        }

        for(int i=0; i<n; i++)
        {
            if(isZero == 1)
            {
                if(nums[i] != 0) ans[i] = 0;
                else ans[i] = product;
            }
            else if(isZero > 1) ans[i] = 0;
            else ans[i] = product/nums[i];
        }

        for(long i: ans) System.out.println(i + " ");
    }
}
