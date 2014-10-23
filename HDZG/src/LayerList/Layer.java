package LayerList;

import java.io.Serializable;

import CityInfo.GameData;
import MeetableLayer.MyDrawable;
import android.content.res.Resources;

/**
 *  
 * ����Ϊ��ͼ���²㣬
 *
 */

public class Layer implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -9052906322948980410L;
	private MyDrawable[][] mapMatrix;
	
	public Layer(){}
	
	public MyDrawable[][] getMapMatrix(){//mapMatrix��get����
		return mapMatrix;
	}
	
	public Layer(Resources resources){//������
		this.mapMatrix = GameData.mapData;
	}
	
	public int[][] getNotIn(){//�õ���ͨ������
		int[][] result = new int[40][60];
		for(int i=0; i<mapMatrix.length; i++){
			for(int j=0; j<mapMatrix[i].length; j++){
				int x = mapMatrix[i][j].col - mapMatrix[i][j].getRefCol();
				int y = mapMatrix[i][j].row + mapMatrix[i][j].getRefRow();
				int[][] notIn = mapMatrix[i][j].getNoThrough();
				for(int k=0; k<notIn.length; k++){
					result[y-notIn[k][1]][x+notIn[k][0]] = 1;
				}
			}
		}
		return result;
	}
}
