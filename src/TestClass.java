
public class TestClass {

	public static void main(String s[]) {
		TestClass tc = new TestClass();
		tc.minMoves(new int[] {1,2147483647});
	}
	
	public int minMoves(int[] nums) {
		int count = 0;
		while (true) {
			int maxElem = findMaxElem(nums);
			int minElem = findMinElem(nums);
			System.out.println(maxElem);
			System.out.println(minElem);
			int diff = nums[maxElem] - nums[minElem];
			if (diff == 0) {
				break;
			}

			for (int i = 0; i < nums.length; i++) {
				if (i != maxElem) {
					nums[i] = nums[i] + diff;
				}
			}
			count = count + diff;
		}
		System.out.println(count);
		return count;
	}
	   
	        
	        
	    
	    private int findMaxElem(int[] nums){
	        int max = Integer.MIN_VALUE;
	        int maxPos = -1;
	        for(int i=0;i<nums.length;i++){
	            if(nums[i]>=max){
	                max = nums[i];
	                maxPos = i;
	            }
	        }
	        return maxPos;
	    }
	     private int findMinElem(int[] nums){
	        int min = Integer.MAX_VALUE;
	        int minPos = -1;
	        for(int i=0;i<nums.length;i++){
	            if(nums[i]<=min){
	                min = nums[i];
	                minPos = i;
	            }
	        }
	        return minPos;
	    }
	

	

}
