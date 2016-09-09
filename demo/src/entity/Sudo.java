package entity;

import java.util.ArrayList;

/** 
  * @author: 汤大业 
  * @date: 2016年9月7日 下午8:22:08 
  * @version: 1.0 
  * @description: 9*9数独实体类
*/

public class Sudo {
	private Block[][] blockArray = new Block[9][9];
	
	/**
	 * 根据二维数组构造数独
	 * @param resource
	 */
	public Sudo(int[][] resource){
		if(resource.length!=9||resource[0].length!=9){
			System.out.println("warning!");
			return;
		}
		else{
			for(int i=0;i<9;i++){
				for(int j=0;j<9;j++){
					blockArray[i][j] = new Block(resource[i][j]); 
				}
			}
		}
	}
	/**
	 * 根据字符串构造数独
	 * @param resource
	 */
	public Sudo(String resource){
		if(resource.length()!=81){
			System.out.println("warning!");
			return;
		}
		else{
			for(int i=0;i<9;i++){
				for(int j=0;j<9;j++){
					blockArray[i][j] = new Block(Integer.parseInt(resource.substring(i*9+j, i*9+j+1))); 
				}
			}
		}
	}
	public Sudo(){
		
	}
	
	/*
	 * 约简数独阵列
	 */
	public void simplify(){
		boolean ctn = false;
		for(int i=0;i<9;i++){
			for(int j=0;j<9;j++){
				Block block = blockArray[i][j];
				if(block.getValue()==0){
					//检查横行并删除
					for(int k=0;k<9;k++){
						Block temp = blockArray[i][k];
						if(k!=j&&temp.getValue()!=0){
							int index = block.getPossibleValue().indexOf(temp.getValue());
							if(index>=0) block.getPossibleValue().remove(index);
						}
					}
					//检查竖行并删除
					for(int k=0;k<9;k++){
						Block temp = blockArray[k][j];
						if(k!=i&&temp.getValue()!=0){
							int index = block.getPossibleValue().indexOf(temp.getValue());
							if(index>=0) block.getPossibleValue().remove(index);
						}
					}
					//检查3*3并删除
					int m = i-i%3;
					int n = j-j%3;
					for(int s=m;s<m+3;s++){
						for(int t=n;t<n+3;t++){
							Block temp = blockArray[s][t];
							if(s!=i&&t!=j&&temp.getValue()!=0){
								int index = block.getPossibleValue().indexOf(temp.getValue());
								if(index>=0) block.getPossibleValue().remove(index);
							}
						}
					}
					//如果只剩一个，填上，并且修改ctn标识位
					if(block.getPossibleValue().size()==1){
						block.setValue(block.getPossibleValue().get(0));
						ctn = true;
					}
				}
			}
		}
		if(ctn){
			ctn=false;
			simplify();
			
		}
	}
	
	/**
	 * 
	 * @Description:展示数独
	 * @return:void
	 * @time:2016年9月8日 下午12:10:26
	 */
	public void disply(){
		for(int i=0;i<9;i++){
			for(int j=0;j<9;j++){
				if(j!=8)
					System.out.print(blockArray[i][j].getValue()+" ");
				else
					System.out.println(blockArray[i][j].getValue());
			}
		}
	}
	/**
	 * 
	 * @Description:展示每个位置的可选数字
	 * @return:void
	 * @time:2016年9月8日 下午12:32:38
	 */
	public void displyPossible(){
		for(int i=0;i<9;i++){
			for(int j=0;j<9;j++){
				ArrayList<Integer> list = blockArray[i][j].getPossibleValue();
				for(int k=0;k<list.size();k++){
					System.out.print(list.get(k)+" ");
				}
				System.out.println();
			}
		}
	}
}
