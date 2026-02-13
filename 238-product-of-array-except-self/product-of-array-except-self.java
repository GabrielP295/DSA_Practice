class Solution {
    public int[] productExceptSelf(int[] nums) {
        /*
        Input: array of integers
        Output: array of integers where each index is all numbers in input array multiplied together
        except the one at the current index
        Assume each product will fit within integer array
        The input array will have at least two values

        [1,2,4,6] 1
                  ^
        [48,24,12,8]
        -Use output array to store the before values and then multiply the after values into the array
        -Itrerate through list going forward until index is reached, then do the same backwards
        -Store multiplied answer retrieved from before indices to be able to multiply in one go
        */
        int[] products = new int[nums.length];
        int beforeValue = 1;
        for(int i = 0; i < nums.length; i++) {
            products[i] = beforeValue;
            beforeValue *= nums[i];
        }

        int afterValue = 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            products[i] *= afterValue;
            afterValue *= nums[i];
        }

        return products;
    }
}  
