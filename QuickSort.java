package character01.sort;

import java.util.Arrays;

public class QuickSort {
    public static void main(String[] args) {
        int[] arr = new int[]{5,9,7,4,3,8,6,10};
        int high = arr.length-1;
        quickSort(arr,0,high);
        System.out.println(Arrays.toString(arr));
    }
    public static void quickSort(int[] arr,int low,int high){
        /*快排出现错误Exception in thread "main"java.lang.StackOverflowError（堆栈溢出错误）。
        出错原因是在定义数组的初始位置跟结束位置时没有定义他们之间的大小关系，即数组的初始位置start必须小于结束位置end，
        即在定义排序方法的开始位置添加 if 条件语句。*/
        if(low>high){
            return;
        }
        int pivot = arr[low];//基准
        int i = low,j = high;
        int temp;
        while(i < j){
            while(pivot <= arr[j] && i<j){
                j--;
            }
            while(pivot >= arr[i] && i<j){
                i++;
            }
            temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }
        //将基准与i和j相同的位置的元素互换
        arr[low] = arr[i];
        arr[i] = pivot;
        //递归调用
        quickSort(arr,low,i-1);
        quickSort(arr,i+1,high);


    }
}
