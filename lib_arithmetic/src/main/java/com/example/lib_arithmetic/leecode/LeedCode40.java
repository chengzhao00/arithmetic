package com.example.lib_arithmetic.leecode;
import java.util.Arrays;
import java.util.Random;

/**
 * @Author: MR-Cheng
 * @CreateDate: 2020/9/7 下午3:41
 * @Version: 1.0
 * @Description:
 */
public class LeedCode40 {


    static class Solution {

        public int[] getLeastNumbers(int[] arr, int k) {
            Random ran = new Random();
            selsectK(arr,k - 1,0,arr.length-1,ran);
            return Arrays.copyOf(arr,k);
        }

        public int selsectK(int[] arr,int k,int l , int r,Random ran){
            int p = partition(arr,l,r,ran);
            if(k == p){
                return arr[p];
            }
            if (k < p)
                return selsectK(arr,k,0,p-1,ran);

            return selsectK(arr,k,p+1,r,ran);
        }

        public int partition(int[] arr,int l, int r,Random ran){
            int p = l + ran.nextInt(r - l +1); // 生成一个随机数进行划分
            swape(arr,l,p);// 将随机的位置放在首位
            int i = l +1, j = r;
            while(true){
                while(i <= j && arr[i] < arr[l]){
                    i++;
                }
                while(j >= i && arr[j] > arr[l] ){
                    j--;
                }
                if(i >= j){
                    break;
                }
                swape(arr,i,j);
                i++;
                j--;
            }
            swape(arr,l,j);
            return j;
        }

        private void swape(int[] arr,int i ,int j){
            int t = arr[i];
            arr[i] = arr[j];
            arr[j] = t;
        }
    }

    public static void main(String[] args) {
        int[] nusm = {0,0,0,2,0,5};
        int[] arr = new Solution().getLeastNumbers(nusm,5);
        for (int i : arr) {
            System.out.print(i+"->");
        }
    }

}
