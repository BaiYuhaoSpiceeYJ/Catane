
public class edge {
	int id;
	int occupy;		//-1：not occupied 0-3:occupied by player 1-4
	
	public edge() {}
	
	public edge(int _id, int _occupy) {
		id=_id;
		occupy=_occupy;
	}	
	//构造函数
	public int get_id() {	//返回节点ID
		return id;
	}
	
	
	
	public int check_ocu() {	//返回占有信息
		return occupy;
	}
	
	public void set_ocu(int i) {	//设置占有信息
		occupy=i;
	}
	

}
