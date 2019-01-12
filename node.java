
public class node {
	int id;
	int occupy;		//-1：not occupied 0-3:occupied by player 1-4
	int type;	//1 村庄还是2 城市（Convertissure or Delorean or Non)
	
	public node() {}
	
	public node(int _id, int _occupy, int _type) {
		id=_id;
		occupy=_occupy;
		type=_type;
	}					//构造函数
	
	public int get_id() {	//返回节点ID
		return id;
	}
	
	public int check_ocu() {	//返回占有信息
		return occupy;
	}
	

	
	public void set_ocu(int i) {	//设置占有信息
		occupy=i;
	}
	
	public int get_type() {	//返回节点类型
		return type;
	}
	
	public void set_type(int s) {	//更改节点类型
		type = s;
	}
	
}
