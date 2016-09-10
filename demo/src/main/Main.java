package main;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import entity.Grid;

/** 
  * @author: ����ҵ 
  * @date: 2016��9��7�� ����8:20:04 
  * @version: 1.0 
  * @description: �������������
*/

public class Main {
	public static void main(String[] args) throws Exception {
		SimpleDateFormat dfs = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
        Date begin=dfs.parse(dfs.format(new Date()));
        
        
		String a = 	"800000000"
				+ 	"003600000"
				+ 	"070090200"
				+ 	"050007000"
				+ 	"000045700"
				+ 	"000100030"
				+ 	"001000068"
				+ 	"008500010"
				+ 	"090000400";
		Grid grid = Grid.create(a);
		List<Grid> solutions = new ArrayList<Grid>();
             
		solve(grid, solutions);
 
		printSolutions(grid, solutions);   
         
        Date end=dfs.parse(dfs.format(new Date()));
        long between=end.getTime()-begin.getTime();
        System.out.println("use Time:"+between+"ms");
	}
	
	private static void solve(Grid grid, List<Grid> solutions) {
		 
        if (solutions.size() >= 2) {
            return;
        }
 
        int loc = grid.findEmptyCell();
 
        if (loc < 0) {
            solutions.add(grid.clone());
            return;
        }
 
        for (int n=1; n<10; n++) {
            if (grid.set(loc, n)) {
                solve(grid, solutions);
 
                grid.clear(loc);
            }
        }
    }
 
    private static void printSolutions(Grid grid, List<Grid> solutions) {
        System.out.println("Original");
        System.out.println(grid);
 
        if (solutions.size() == 0) {
            System.out.println("Unsolveable");
        } else if (solutions.size() == 1) {
            System.out.println("Solved");
        } else {
            System.out.println("At least two solutions");
        }
 
        for (int i=0; i<solutions.size(); i++) {
            System.out.println(solutions.get(i));
        }
        System.out.println();
        System.out.println();
    }
}

//		int[][] a={	{8,0,0,2,3,0,1,4,9},
//					{0,1,0,7,0,0,2,6,0},
//					{0,0,0,0,0,0,0,3,0},
//					{0,0,4,0,0,0,0,8,5},
//					{0,0,0,0,0,0,0,0,0},
//					{7,6,0,0,0,8,0,0,0},
//					{6,0,7,8,0,0,0,0,0},
//					{0,0,0,0,6,0,0,0,4},
//					{0,3,0,1,2,9,8,7,0}};
//		String a = 	"781602905"
//				+ 	"902710000"
//				+ 	"006800012"
//				+ 	"200300851"
//				+ 	"073500004"
//				+ 	"008009360"
//				+ 	"190007080"
//				+ 	"867003409"
//				+ 	"005000100";

