package cn.linjie;

import java.util.Arrays;

public class TestDemo03 {
    public static void main(String[] args) {
        //创建一个数组
        Integer[] arr1 = {10,11,12,13,14};
        System.out.println(Arrays.toString(arr1));
        swap1(arr1,1,3);
        System.out.println(Arrays.toString(arr1));

        //创建一个String类型的数组，实现bb和dd位置交换
        String[] arr2 = {"aa","bb","cc","dd","ff"};
        System.out.println(Arrays.toString(arr2));
        swap1(arr2,1,3);
        System.out.println(Arrays.toString(arr2));
    }

    /**
     * 使用泛型方法 需要定义一个类型 使用大写的字母表示T:这个T表示任意的类型
     * 写在返回值void之前
     * ====表示定义了一个类型 这个类型是T
     * 在下面就可以使用这个类型了 T
     */
    public static <T> void swap1(T[] arr,int a,int b){
        T temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

    /*private static void swap1(String[] arr1, int i, int i1) {
        //定义一个中间变量
        String temp = arr1[i];
        arr1[i] = arr1[i1];
        arr1[i1] = temp;
    }

    private static void swap1(int[] arr1, int i, int i1) {
        //定义一个中间变量
        int temp = arr1[i];
        arr1[i] = arr1[i1];
        arr1[i1] = temp;
    }

     */
}
