package entity;

/** 
  * @author: ����ҵ 
  * @date: 2016��9��7�� ����8:22:08 
  * @version: 1.0 
  * @description: 9*9����ʵ����
*/

public class Sudo {
	private Block[][] blockArray = null;
	
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
					blockArray[i][j].setValue(resource[i][j]); 
				}
			}
		}
	}
	public Sudo(){
		
	}
	
	/*
	 * Լ����������
	 */
	public void simplifyBlocks(){
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
							if(index>0) block.getPossibleValue().remove(index);
						}
					}
					//������в�ɾ��
					for(int k=0;k<9;k++){
						Block temp = blockArray[k][j];
						if(k!=i&&temp.getValue()!=0){
							int index = block.getPossibleValue().indexOf(temp.getValue());
							if(index>0) block.getPossibleValue().remove(index);
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
								if(index>0) block.getPossibleValue().remove(index);
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
			simplifyBlocks();
		}
	}
}