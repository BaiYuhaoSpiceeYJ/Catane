
public class condition {
	int id;
	boolean valide;		//1:true 0:false(the land produce nothing)
	int type;	//0:mine,1:forest,2:brick,3:wheat,4:grass,5:dessert,
				//无论哪个图，0号资源需求量最大，所以每个图有两个1号资源点
	public condition() {}
	
	public condition(int _id,boolean _valide,int _type){
		id=_id;
		valide=_valide;
		type=_type;
	}
	
	public int get_id() {	//返回id
		return id;
	}
	
	public boolean check_valide() {	//确认生效状态
		return valide;
	}
	
	public void set_valide(boolean flag) {	//更改生效状态
		valide=flag;
	}
	
	public int get_type() {	//返回土地类型
		return type;
	}
	
}
