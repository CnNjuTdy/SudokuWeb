package main;

import entity.Sudo;

/** 
  * @author: 汤大业 
  * @date: 2016年9月7日 下午8:20:04 
  * @version: 1.0 
  * @description: 数独解决的主类
*/

public class Main {
	public static void main(String[] args) {
//		int[][] a={	{8,0,0,2,3,0,1,4,9},
//					{0,1,0,7,0,0,2,6,0},
//					{0,0,0,0,0,0,0,3,0},
//					{0,0,4,0,0,0,0,8,5},
//					{0,0,0,0,0,0,0,0,0},
//					{7,6,0,0,0,8,0,0,0},
//					{6,0,7,8,0,0,0,0,0},
//					{0,0,0,0,6,0,0,0,4},
//					{0,3,0,1,2,9,8,7,0}};
		String a = 	"781602905"
				+ 	"902710000"
				+ 	"006800012"
				+ 	"200300851"
				+ 	"073500004"
				+ 	"008009360"
				+ 	"190007080"
				+ 	"867003409"
				+ 	"005000100";
		Sudo sudo = new Sudo(a);
		sudo.disply();
		System.out.println("-------------------------------");
		sudo.simplify();
		sudo.disply();
	}
}
