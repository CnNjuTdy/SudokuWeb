package main;

import java.util.ArrayList;

/** 
  * @author: ����ҵ 
  * @date: 2016��9��7�� ����8:20:04 
  * @version: 1.0 
  * @description: �������������
*/

public class Main {
	public static void main(String[] args) {
		ArrayList<Integer> a = new ArrayList<Integer>();
		a.add(1);
		a.add(2);
		a.add(3);
		for(int i=0;i<a.size();i++){
			System.out.print(a.get(i));
		}
		System.out.println();
		a.remove(a.indexOf(2));
		for(int i=0;i<a.size();i++){
			System.out.print(a.get(i));
		}
	}
}
