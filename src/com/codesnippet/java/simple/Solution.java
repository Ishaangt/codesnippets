package com.codesnippet.java.simple;

import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
    	//threeInputPrintfFormating();
    	//series1();
    	//primitiveDataTypes();
    	staticVars();
    }
    
    private static void threeInputPrintfFormating() {
    	Scanner sc=new Scanner(System.in);
        System.out.println("================================");
        for(int i=0;i<3;i++)
        {
        	String s1=sc.next();
            int x=sc.nextInt();
            System.out.printf("%-15s%03d\n",s1,x); //String 15 width with 3 decimal padding. End with NextLine.
        }
        System.out.println("================================");
    }
    
    private static void series1() {
    	Scanner in = new Scanner(System.in);
        int t=in.nextInt();
        for(int i=0;i<t;i++){
            int a = in.nextInt();
            int b = in.nextInt();
            int n = in.nextInt();
            int ans = (int) (a + (Math.pow(2, 0)*b));
            System.out.print(ans + " ");
            for(int j = 1; j < n; j++) {
            	ans = (int) (ans + Math.pow(2, j)*b);
                System.out.print(ans + " ");
            }
            System.out.println("");
        }
        in.close();
    }
    
	private static void primitiveDataTypes() {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		for (int i = 0; i < t; i++) {
			try {
				long x = sc.nextLong();
				System.out.println(x + " can be fitted in:");
				if (x >= -128 && x <= 127)
					System.out.println("* byte");
				if (x >= -32768 && x <= 32767)
					System.out.println("* short");
				if (x >= -Math.pow(2,31) && x <= Math.pow(2,31)-1)
					System.out.println("* int");
				if (x >= -Math.pow(2,63) && x <= Math.pow(2,63)-1)
					System.out.println("* long");
			} catch (Exception e) {
				System.out.println(sc.next() + " can't be fitted anywhere.");
			}
		}
	}
	
	private static void staticVars() {

		boolean flag = false;
		int B, H,area = 0;
		final String err = "Breadth and height must be positive";
		Scanner scn = new Scanner(System.in);
		B = scn.nextInt();
		H = scn.nextInt();
		flag = false;
		try {
			if (B <= 0 || H <= 0) {
				throw new Exception();
			} else {
				flag = true;
				area = B * H;
			}
			System.out.println(area);	
		} catch (Exception e) {
			System.out.println(e + ": " + err);
		}
	}
}

