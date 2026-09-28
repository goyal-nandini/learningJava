package com.nandini.oops.exceptionHandling;

public class Demo2 {

    public static void main(String[] args) {
        int[] arr = {1, 2, 3};
        try {
            System.out.println(arr[5]);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Index is invalid");
        }
        System.out.println("Program still running");
    }
}
/*
| Keyword | Real Meaning            |
| ------- | ----------------------- |
| try     | risky area              |
| catch   | emergency handler       |
| throw   | manually create problem |
| throws  | warning to caller       |
| finally | cleanup section         |

Exception handling is basically: controlled program failure.
Instead of:
💥 sudden crash
*/
