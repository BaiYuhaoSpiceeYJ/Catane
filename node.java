
public class node {
	int id;
	int occupy;		//-1��not occupied 0-3:occupied by player 1-4
	int type;	//1 ��ׯ����2 ���У�Convertissure or Delorean or Non)
	
	public node() {}
	
	public node(int _id, int _occupy, int _type) {
		id=_id;
		occupy=_occupy;
		type=_type;
	}					//���캯��
	
	public int get_id() {	//���ؽڵ�ID
		return id;
	}
	
	public int check_ocu() {	//����ռ����Ϣ
		return occupy;
	}
	

	
	public void set_ocu(int i) {	//����ռ����Ϣ
		occupy=i;
	}
	
	public int get_type() {	//���ؽڵ�����
		return type;
	}
	
	public void set_type(int s) {	//���Ľڵ�����
		type = s;
	}
	
}
