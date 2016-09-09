package entity;

import java.util.ArrayList;

/** 
  * @author: ����ҵ 
  * @date: 2016��9��7�� ����8:22:08 
  * @version: 1.0 
  * @description: 9*9����ʵ����
*/

public class Sudo {
	private Block[][] blockArray = new Block[9][9];
	
	/**
	 * ���ݶ�ά���鹹������
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
	 * �����ַ�����������
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
	 * Լ����������
	 */
	public void simplify(){
		boolean ctn = false;
		for(int i=0;i<9;i++){
			for(int j=0;j<9;j++){
				Block block = blockArray[i][j];
				if(block.getValue()==0){
					//�����в�ɾ��
					for(int k=0;k<9;k++){
						Block temp = blockArray[i][k];
						if(k!=j&&temp.getValue()!=0){
							int index = block.getPossibleValue().indexOf(temp.getValue());
							if(index>=0) block.getPossibleValue().remove(index);
						}
					}
					//������в�ɾ��
					for(int k=0;k<9;k++){
						Block temp = blockArray[k][j];
						if(k!=i&&temp.getValue()!=0){
							int index = block.getPossibleValue().indexOf(temp.getValue());
							if(index>=0) block.getPossibleValue().remove(index);
						}
					}
					//���3*3��ɾ��
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
					//���ֻʣһ�������ϣ������޸�ctn��ʶλ
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
	 * @Description:չʾ����
	 * @return:void
	 * @time:2016��9��8�� ����12:10:26
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
	 * @Description:չʾÿ��λ�õĿ�ѡ����
	 * @return:void
	 * @time:2016��9��8�� ����12:32:38
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
