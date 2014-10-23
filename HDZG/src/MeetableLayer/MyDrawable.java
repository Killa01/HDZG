package MeetableLayer;							//���������
import static Layer.ConstantUtil.TILE_SIZE;

import java.io.Externalizable;						//���������
import java.io.IOException;							//���������
import java.io.ObjectInput;							//���������
import java.io.ObjectOutput;						//���������
import android.graphics.Bitmap;						//���������
import android.graphics.Canvas;						//���������
/*
 * �����з�װ��һ����ͼͼԪ����Ϣ��ÿ��MyDrawable�����ڵ�ͼ��ռ��һ�����ӣ�
 * �����а���ͼƬ���ã�ͼƬ��ߣ�ͼƬλ�ã�row��col������λ�����꣬����ͨ������
 * �Լ��Ƿ�����ı�־λ
 */
public class MyDrawable implements Externalizable{
	private static final long serialVersionUID = 919144009679011682L;	
	private int width;//ͼԪ�Ŀ��
	private int height;//ͼԪ�ĸ߶�
	public int col;//�ڴ��ͼ�����ڵ���
	public int row;//�ڴ��ͼ�����ڵ���
	private int refCol;//��λ�ο����ڱ�MyDrawable����ռ���У������½�Ϊԭ��
	private int refRow;//��λ�ο����ڱ�MyDrawable����ռ���У������½�Ϊԭ��
	private int [][] noThrough;//����ͨ������
	private Bitmap bmpSelf;
	private boolean meetable;
	
	public void writeExternal(ObjectOutput out) throws IOException {
		out.writeInt(getWidth());//ͼԪ�Ŀ��
		out.writeInt(getHeight());//ͼԪ�ĸ߶�
		out.writeInt(col);//�ڴ��ͼ�����ڵ���
		out.writeInt(row);//�ڴ��ͼ�����ڵ���
		out.writeInt(getRefCol());//��λ�ο����ڱ�MyDrawable����ռ���У������½�Ϊԭ��
		out.writeInt(getRefRow());//��λ�ο����ڱ�MyDrawable����ռ���У������½�Ϊԭ��
		out.writeObject(getNoThrough());//����ͨ������
		boolean meetable = false;
		out.writeBoolean(meetable);//�Ƿ��������
	}
	public void readExternal(ObjectInput in) throws IOException,
			ClassNotFoundException {
		setWidth(in.readInt());
		setHeight(in.readInt());
		col = in.readInt();
		row = in.readInt();
		setRefCol(in.readInt());
		setRefRow(in.readInt());
		setNoThrough((int[][]) in.readObject());
		boolean meetable = in.readBoolean();
	}
	public MyDrawable(){}//�޲ι�����
	//������
	public MyDrawable(Bitmap bmpSelf,boolean meetable,int width,int height,int col,int row,int refCol,int refRow,int [][] noThrough){
		this.setBmpSelf(bmpSelf);
		this.setWidth(width);
		this.setHeight(height);
		this.col = col;
		this.row = row;
		this.setRefCol(refCol);
		this.setRefRow(refRow);
		this.setNoThrough(noThrough);
		this.setMeetable(meetable);
	}
	//�����������Լ�
	public void drawSelf(Canvas canvas,int screenRow, int screenCol,int offsetX,int offsetY){
		int x = (screenCol-getRefCol())*TILE_SIZE;//����Լ���ӵ�еĿ��������Ͻǿ��x����
		int y = screenRow*TILE_SIZE+(getRefRow()+1)*TILE_SIZE-getHeight();//����Լ���ӵ�еĿ��������Ͻǿ��y����
		canvas.drawBitmap(getBmpSelf(), x-offsetX, y-offsetY, null);//�����Լ������Ͻǵ�xy���껭���Լ�
	}
	public int [][] getNoThrough() {
		return noThrough;
	}
	public void setNoThrough(int [][] noThrough) {
		this.noThrough = noThrough;
	}
	public int getRefRow() {
		return refRow;
	}
	public void setRefRow(int refRow) {
		this.refRow = refRow;
	}
	public int getRefCol() {
		return refCol;
	}
	public void setRefCol(int refCol) {
		this.refCol = refCol;
	}
	public int getHeight() {
		return height;
	}
	public void setHeight(int height) {
		this.height = height;
	}
	public int getWidth() {
		return width;
	}
	public void setWidth(int width) {
		this.width = width;
	}
	public boolean isMeetable() {
		return meetable;
	}
	public void setMeetable(boolean meetable) {
		this.meetable = meetable;
	}
	public Bitmap getBmpSelf() {
		return bmpSelf;
	}
	public void setBmpSelf(Bitmap bmpSelf) {
		this.bmpSelf = bmpSelf;
	}
}