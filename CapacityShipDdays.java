public class CapacityShipDdays {
    public static int shipWithinDDays(int nums[], int D) {
        int min = 0;
        int max = 0;
        for(int w : nums) {
            min = Math.min(min, max);
            max += w;
        }
        int res = max;
        while(min <= max) {
            int mid = min + (max - min) / 2;
            if(canBeShipped(nums, mid) <= D) {
                max = mid - 1;
                res = mid;
            } else {
                min = mid + 1;
            }
        }
        return res;
    }
    public static int canBeShipped(int nums[] , int capacity) {
        int ship = 1; 
        int currCapp = 0;
        for(int w : nums) {
            currCapp += w;
            if(currCapp > capacity) {
                ship++;
                currCapp = w;
            }
        }
        return ship;
    }

    public static void main(String[] args) {
        int nums[] = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
        System.out.println(shipWithinDDays(nums, 5));
    }
}
