package MeetableLayer;							//声明包语句
import static Layer.ConstantUtil.TILE_SIZE;

import java.io.Externalizable;						//引入相关类
import java.io.IOException;							//引入相关类
import java.io.ObjectInput;							//引入相关类
import java.io.ObjectOutput;						//引入相关类
import android.graphics.Bitmap;						//引入相关类
import android.graphics.Canvas;						//引入相关类
/*
 * 该类中封装了一个地图图元的信息，每个MyDrawable类是在地图上占有一个格子，
 * 该类中包含图片引用，图片宽高，图片位置（row，col），定位点坐标，不可通过矩阵
 * 以及是否可遇的标志位
 */
public class MyDrawable implements Externalizable{
	private static final long serialVersionUID = 919144009679011682L;	
	private int width;//图元的宽度
	private int height;//图元的高度
	public int col;//在大地图中所在的列
	public int row;//在大地图中所在的行
	private int refCol;//定位参考点在本MyDrawable中所占的列，以左下角为原点
	private int refRow;//定位参考点在本MyDrawable中所占的行，以左下角为原点
	private int [][] noThrough;//不可通过矩阵
	private Bitmap bmpSelf;
	private boolean meetable;
	
	public void writeExternal(ObjectOutput out) throws IOException {
		out.writeInt(getWidth());//图元的宽度
		out.writeInt(getHeight());//图元的高度
		out.writeInt(col);//在大地图中所在的列
		out.writeInt(row);//在大地图中所在的行
		out.writeInt(getRefCol());//定位参考点在本MyDrawable中所占的列，以左下角为原点
		out.writeInt(getRefRow());//定位参考点在本MyDrawable中所占的行，以左下角为原点
		out.writeObject(getNoThrough());//不可通过矩阵
		boolean meetable = false;
		out.writeBoolean(meetable);//是否可以遇到
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
	public MyDrawable(){}//无参构造器
	//构造器
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
	//方法：绘制自己
	public void drawSelf(Canvas canvas,int screenRow, int screenCol,int offsetX,int offsetY){
		int x = (screenCol-getRefCol())*TILE_SIZE;//求出自己所拥有的块数中左上角块的x坐标
		int y = screenRow*TILE_SIZE+(getRefRow()+1)*TILE_SIZE-getHeight();//求出自己所拥有的块数中左上角块的y坐标
		canvas.drawBitmap(getBmpSelf(), x-offsetX, y-offsetY, null);//根据自己的左上角的xy坐标画出自己
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