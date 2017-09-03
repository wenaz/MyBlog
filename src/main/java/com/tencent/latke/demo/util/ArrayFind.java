package com.tencent.latke.demo.util;

/**
 * Created by ansonwen on 2017/8/31.
 */
public class ArrayFind {
    public boolean Find(int target,int[][] array){
        int m=array.length;
        int n=array[0].length;
        int i=0;
        int j=n-1;
        while (i<n&&j>=0){
            if (array[i][j]==target)
                return true;
            else if (array[i][j]>target)
                j--;
            else if (array[i][j]<target)
                i++;
        }
        return false;

    }

}
