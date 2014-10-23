package Layer;

import java.util.ArrayList;

import wyf.ytl.General;
import static Layer.ConstantUtil.*;

public class CityInfo { 
	public String cityName;//城池名称
	public int country;//所属国家
	public int army;//兵力
	public int food;//粮草
	public int level;//等级
	public int baseAttack = 20;//每个士兵的基础攻击力
	public int baseDefend = 15;//每个士兵的基础防御力
	public int citizen;//居民
	public int warTank = 0;//战车的个数，用于增加攻城力
	public int warTower = 0;//箭垛的个数用于增加防御力
	
	public final int info;
	public ArrayList<General> guardGeneral = new ArrayList<General>();//武将列表
	
	public CityInfo(String cityName, int country, int army, int food,
			int level, int baseAttack, int baseDefend, int citizen,
			int warTank, int warTower, General guardGeneral,int info) {//构造器
		this.cityName = cityName;
		this.country = country;
		this.army = army;
		this.food = food;
		this.level = level;
		this.baseAttack = baseAttack;
		this.baseDefend = baseDefend;
		this.citizen = citizen;
		this.warTank = warTank;
		this.warTower = warTower;
		this.guardGeneral.add(guardGeneral);
		this.info = info;
	}	
	
	public void setBackToInit(){//恢复到默认		
		for(int i=0; i<CITY_INFO.size(); i++){
			CityInfo ci = CITY_INFO.get(i);
			if(ci.info == this.info){
				this.cityName = ci.cityName;
				this.country = ci.country;
				this.army = ci.army;
				this.food = ci.food;
				this.level = ci.level;
				this.baseAttack = ci.baseAttack;
				this.baseDefend = ci.baseDefend;
				this.citizen = ci.citizen;
				this.warTank = ci.warTank;
				this.warTower = ci.warTower;
				this.guardGeneral = ci.guardGeneral;
				break;
			}
		}
	}
}
