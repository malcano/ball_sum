package src;
import java.util.Arrays;
import java.lang.Math;

public class Sum {
    public static int maxSubsequence(int[] arr) {

        if(arr.length==0)//배열의 길이가 0일 때 0을 return
            return 0;

        if(Arrays.stream(arr).max().getAsInt()<0)//배열 원소 중 가장 큰 수가 0보다 작을 때, 즉 모든 요소가 음수일 때 0을 return
            return 0;
        //이하 분할정복법을 이용한 부분수열 알고리즘 구현

        return dnqMax(arr,0,arr.length-1);
    }
    public static int dnqMax(int arr[], int start, int end)
    {
        int max = 0;
        if (start == end ) // 배열에 요소가 하나일 경우
            return arr[start];//그 자체가 최대
        int mid = (start+end)/2; //배열의 중간 위치
        int leftSum = Integer.MIN_VALUE;//좌측 수열의 합 초기화
        int rightSum = Integer.MIN_VALUE;//우측 수열의 초기화

        //부분수열이 좌측, 혹은 우측에 몰려있는 경우
        int leftCase = dnqMax(arr, start, mid);//좌측 최대 합
        int rightCase = dnqMax(arr, mid+1,end);//우측 최대 합

        int subsetSum = Math.max(leftCase,rightCase);//둘 중 합이 큰 경우
//
        //This is just for check logic
//        System.out.println(Arrays.toString(arr));
//        System.out.println("Leftcase = " + leftCase);
//        System.out.println("Rightcase = " + rightCase);
//
//
//        System.out.println("subsetsum = " + subsetSum);

        // 부분수열이 양 쪽에 걸쳐 있을 경우를 위한 for loop
        for (int i = mid;i>=start;i--)
        {
            max += arr[i];
            leftSum = Math.max(max,leftSum);
        } //좌측의 오른쪽 요소부터 하나씩 대입

        max = 0;// max 초기화

        for(int i = mid+1 ; i<=end;i++ )
        {
            max += arr[i];
            rightSum = Math.max(max,rightSum);
        }//우측의 앞 원소부터 하나씩 대입

        return Math.max(subsetSum,leftSum+rightSum);//부분 수열 중 큰 것 return
    }
}