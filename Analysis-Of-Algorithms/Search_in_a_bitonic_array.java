class Test{
	static int [] arr = new int[]{1, 2, 3, 4, 6, 8, 11, 13, 34, 54, 32, 23, 21, 13, 11};
	public static boolean left_search(int key, int lo, int hi){
		while(lo < hi - 1){
			int mid = (lo + hi) / 2;
			if (key < arr[mid]){
				hi = mid;
			}else{
				lo = mid;
			}
		}
		return key == arr[lo];
	}

	public static boolean right_search(int key, int lo, int hi){
		while(lo < hi - 1){
			int mid = (lo + hi) / 2;
			if (key < arr[mid]){
				lo = mid;
			}else{
				hi = mid;
			}
		}
		return key == arr[hi];
	}

	public static boolean search(int key){
		int lo = 0;
		int hi = arr.length - 1;
		while(lo < hi - 1){
			int mid = (lo + hi) / 2;
			if (key < arr[mid]){
				return left_search(key, lo, mid) ||
						right_search(key, mid, hi);
			}else{
				if(arr[mid] < arr[mid + 1]){
					lo = mid;
				}else{
					hi = mid;
				}
			}
		}
		return arr[lo] == key || arr[hi] == key;
	}

	public static void main(String args[]){
		System.out.println(search(Integer.valueOf(args[0])));
	}
}