
public class condition {
	int id;
	boolean valide;		//1:true 0:false(the land produce nothing)
	int type;	//0:mine,1:forest,2:brick,3:wheat,4:grass,5:dessert,
				//�����ĸ�ͼ��0����Դ�������������ÿ��ͼ������1����Դ��
	public condition() {}
	
	public condition(int _id,boolean _valide,int _type){
		id=_id;
		valide=_valide;
		type=_type;
	}
	
	public int get_id() {	//����id
		return id;
	}
	
	public boolean check_valide() {	//ȷ����Ч״̬
		return valide;
	}
	
	public void set_valide(boolean flag) {	//������Ч״̬
		valide=flag;
	}
	
	public int get_type() {	//������������
		return type;
	}
	
}
