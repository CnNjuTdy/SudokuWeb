package entity;

/** 
  * @author: 汤大业 
  * @date: 2016年9月7日 下午8:22:08 
  * @version: 1.0 
  * @description: 9*9数独实体类
*/

public class Sudo {
	private Block[][] blockArray = null;
	
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
					blockArray[i][j].setValue(resource[i][j]); 
				}
			}
		}
	}
	public Sudo(){
		
	}
	
	/*
	 * 约简数独阵列
	 */
	public void simplifyBlocks(){
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
							if(index>0) block.getPossibleValue().remove(index);
						}
					}
					//检查竖行并删除
					for(int k=0;k<9;k++){
						Block temp = blockArray[k][j];
						if(k!=i&&temp.getValue()!=0){
							int index = block.getPossibleValue().indexOf(temp.getValue());
							if(index>0) block.getPossibleValue().remove(index);
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
								if(index>0) block.getPossibleValue().remove(index);
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
			simplifyBlocks();
		}
	}
}
