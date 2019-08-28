package DP;

public class Water {
    public static void main(String[] args) {
        int [] a = {2,5,1,2,3,4,7,7,6};
        System.out.println(water1(a));
    }
    private static int water1(int[] arr)
    {
        int water=0;
        if(arr==null||arr.length<=1)
            return 0;
        int leftLargest=0,rightLargest=0;
        int[] left =new int[arr.length];
        //left 数组中保存每个元素左边的最大值，left[i]，表示数组中第i个元素的左边最大值。
        int[] right =new int[arr.length];
        //right数组中保存每个元素左边的最大值，right[i]，表示数组中第i个元素的右边最大值。
        for(int i=0;i<arr.length;i++)
        {
            leftLargest=Math.max(leftLargest,arr[i]);
            left[i]=leftLargest;
        }
        //先遍历一次找出每个元素左边最大值。
        for(int i=arr.length-1;i>=0;i--)
        {
            rightLargest=Math.max(rightLargest,arr[i]);
            right[i]=rightLargest;
        }
        //遍历找到每个元素右边最大值。
        for(int i=0;i<arr.length;i++)
        {
            int min = Math.min(left[i], right[i]);
            water+= min >arr[i]?min-arr[i]:0;
        }
        //利用当前元素的左边最大值和右边最大值求得存水量。
        return water;
    }

}
