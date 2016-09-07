package entity;

import java.util.ArrayList;

/** 
  * @author: 汤大业 
  * @date: 2016年9月7日 下午8:40:52 
  * @version: 1.0 
  * @description: TODO
*/

public class Block {
	private int value;
	private ArrayList<Integer> possibleValue;
	
	public Block(int value) {
		this.value = value;
		if(value == 0)
			this.possibleValue = null;
		else{
			possibleValue = new ArrayList<Integer>();
			for(int i=1;i<10;i++){
				possibleValue.add(i);
			}
		}
	}
	
	public int getValue() {
		return value;
	}
	public void setValue(int value) {
		this.value = value;
	}

	public ArrayList<Integer> getPossibleValue() {
		return possibleValue;
	}

	public void setPossibleValue(ArrayList<Integer> possibleValue) {
		this.possibleValue = possibleValue;
	}
	
}
