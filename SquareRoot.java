public class SquareRoot {
    public static int squereRoot(int num) {
        int start = 1;
        int end = num;
        int ans = -1;
        while(start <= end) {
            int mid = start + (end - start) / 2;
            int sqr = mid * mid;
            if(sqr == num) {
                return mid;
            } else if(sqr < num) {
                ans = mid;
                start = mid + 1;
            } else {
                end = mid -1;
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        int num = 5;
        System.out.println(squereRoot(num));
    }
}