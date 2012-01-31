package com.jwetherell.algorithms;

import java.text.DecimalFormat;

import com.jwetherell.algorithms.search.BinarySearch;
import com.jwetherell.algorithms.search.LinearSearch;
import com.jwetherell.algorithms.search.InterpolationSearch;


public class Search {

    private static final DecimalFormat FORMAT = new DecimalFormat("#.######");
    private static final int SIZE = 99999;
    private static final int offset = 123;
    
    private static int[] sorted = null;
    
    public static void main(String[] args) {
        System.out.println("Generating sorted array.");
        sorted = new int[SIZE];
        for (int i=offset; i<offset+sorted.length; i++) {
            sorted[i-offset] = i;
        }
        System.out.println("Generated sorted array.");
        System.out.println();
        
        int value = sorted[9999];
        
        {
            System.out.println("Brute Force.");
            long before = System.nanoTime();
            int result = LinearSearch.find(value, sorted);
            long after = System.nanoTime();
            System.out.println("result="+result);
            System.out.println("Computed in "+FORMAT.format(after-before)+" ns");
            System.out.println();
            System.gc();
        }
        
        {
            System.out.println("Binary Search.");
            long before = System.nanoTime();
            int result = BinarySearch.find(value, sorted, false);
            long after = System.nanoTime();
            System.out.println("result="+result);
            System.out.println("Computed in "+FORMAT.format(after-before)+" ns");
            System.out.println();
            System.gc();
        }
        
        {
            System.out.println("Optimized Binary Search.");
            long before = System.nanoTime();
            int result = BinarySearch.find(value, sorted, true);
            long after = System.nanoTime();
            System.out.println("result="+result);
            System.out.println("Computed in "+FORMAT.format(after-before)+" ns");
            System.out.println();
            System.gc();
        }
        
        {
            System.out.println("Interpolation Search.");
            long before = System.nanoTime();
            int result = InterpolationSearch.find(value, sorted);
            long after = System.nanoTime();
            System.out.println("result="+result);
            System.out.println("Computed in "+FORMAT.format(after-before)+" ns");
            System.out.println();
            System.gc();
        }
    }
    
}