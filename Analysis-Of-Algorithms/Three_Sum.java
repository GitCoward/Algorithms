import java.util.*;
class Three_Sum{
	public static int sum(int [] arr, int target){
		Arrays.sort(arr);
		int count = 0;
		Map<Integer, Integer> sums = new HashMap<Integer, Integer>();
		for (int i = 0; i < arr.length; i++){
			sums.put(arr[i], i);
		}
		for (int i = 0; i < arr.length - 1; i++){
			for (int j = i + 1; j < arr.length; j++){
				int value = arr[i] + arr[j];
				Integer index = sums.get(target - value);
				if(index != null && index > i && index > j){
					System.out.println("" + arr[i] + " + " + 
						arr[j] + " + " + arr[index] + " = 0");
					count++;
				}
			}
		}
		return count;
	}
	public static void main(String args[]){
		int [] a = new int[]{10, 20, -10, -30, -20, 0};
		System.out.println("count: "+sum(a, 0));
	}
}