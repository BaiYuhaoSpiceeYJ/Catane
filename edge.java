
public class edge {
	int id;
	int occupy;		//-1��not occupied 0-3:occupied by player 1-4
	
	public edge() {}
	
	public edge(int _id, int _occupy) {
		id=_id;
		occupy=_occupy;
	}	
	//���캯��
	public int get_id() {	//���ؽڵ�ID
		return id;
	}
	
	
	
	public int check_ocu() {	//����ռ����Ϣ
		return occupy;
	}
	
	public void set_ocu(int i) {	//����ռ����Ϣ
		occupy=i;
	}
	

}
