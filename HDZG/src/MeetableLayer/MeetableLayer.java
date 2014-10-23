package MeetableLayer;

import java.io.Serializable;


import CityInfo.GameData2;
import LayerList.Hero;
import LayerList.Layer;
import android.content.res.Resources;

public class MeetableLayer extends Layer implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1265133035026861860L;
	private MyMeetableDrawable[][] mapMatrixMeetable;//ʵ�ʵ�ͼ
	private MyMeetableDrawable[][] mapMatrixForMeetable;//��������
	
	public MeetableLayer(){}
	
	public MeetableLayer(Resources resources) {
		super(resources);
		
		this.mapMatrixMeetable = GameData2.mapData;
		initMapMatrixForMeetable();
	}

	public MyDrawable[][] getMapMatrix()
	{
		return mapMatrixMeetable;
	}
	
	public void initMapMatrixForMeetable(){//�����������mapMatrixForMeetable
		mapMatrixForMeetable = new MyMeetableDrawable[40][60]; 
		for(int i=0; i<mapMatrixMeetable.length; i++){
			for(int j=0; j<mapMatrixMeetable[i].length; j++){
				if(mapMatrixMeetable[i][j] != null){
					int x = mapMatrixMeetable[i][j].col - mapMatrixMeetable[i][j].getRefCol();
					int y = mapMatrixMeetable[i][j].row + mapMatrixMeetable[i][j].getRefRow();
					int[][] meetableMatrix = mapMatrixMeetable[i][j].getMeetableMatrix();
					for(int k=0; k<meetableMatrix.length; k++){
						mapMatrixForMeetable[y-meetableMatrix[k][1]][x+meetableMatrix[k][0]] = mapMatrixMeetable[i][j];
					}					
				}
			}
		}
	}
	
	public MyMeetableDrawable check(Hero hero){//����Ƿ�����
		int col = hero.col;//��ȡӢ�۵�����
		int row = hero.row;//��ȡӢ�۵�����
		switch(hero.direction%4){//�����Ȱ�����鿴
		case 0://����
			if(mapMatrixForMeetable[row][col-1] != null){//��߼�⵽�˿�����
				return mapMatrixForMeetable[row][col-1];
			}
			else if(mapMatrixForMeetable[row][col+1] != null){//�ұ߼�⵽�˿�����
				return mapMatrixForMeetable[row][col+1];
			}
			break;
		case 1://����
			if(mapMatrixForMeetable[row-1][col] != null){//�ϱ߼�⵽�˿�����
				return mapMatrixForMeetable[row-1][col];
			}
			else if(mapMatrixForMeetable[row+1][col] != null){//�±߼�⵽�˿�����
				return mapMatrixForMeetable[row+1][col];
			}
			break;
		case 2://����
			if(mapMatrixForMeetable[row-1][col] != null){//�ϱ߼�⵽�˿�����
				return mapMatrixForMeetable[row-1][col];
			}
			else if(mapMatrixForMeetable[row+1][col] != null){//�±߼�⵽�˿�����
				return mapMatrixForMeetable[row+1][col];
			}
			break;
		case 3://����
			if(mapMatrixForMeetable[row][col-1] != null){//��߼�⵽�˿�����
				return mapMatrixForMeetable[row][col-1];
			}
			else if(mapMatrixForMeetable[row][col+1] != null){//�ұ߼�⵽�˿�����
				return mapMatrixForMeetable[row][col+1];
			}
			break;
		}
		return null;
	}
}