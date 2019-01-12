public class player {
	int id;
	String name;
	int position =0;	//��������������
	int score = 0;
	int resource[][]=new int[4][5];	//4 maps,0:mine,1:forest,2:brick,3:wheat,4:grass
	int initialcity;
	
	public player() {
		score = 0;
		position = 0;
		for(int i=0;i<4;i++) {
			for(int j=0;j<5;j++) {
				resource[i][j]=0;
			}
		}
	}
	
	public int get_id() {
		return id;
	}
	
	public void set_id(int _id) {
		id=_id;
	}
	
	public String get_name() {
		return name;
	}
	
	public void set_name(String _name) {
		StringBuilder str = new StringBuilder(_name);	//��������StringBuild��������������������Sring
		name=str.toString();
	}
	
	public int get_po() {	//������������
		return position;
	}
	
	public void set_po(int po) {	//������������
		position=po;
	}
	
	public int get_score() {
		return score;
	}
	
	public void add_score(int _score) {
		score+=_score;
	}
	
	public int get_resource(int type) {	//������������������
		return resource[position][type];
	}
	
	public String show_resource(int pos) {
		if(pos == 0) {
			return ("<html>"+ get_name()+" a<br>" + resource[get_po()][0]+" Gaz"+"<br>"+
					"          " + resource[get_po()][1]+" Acier"+"<br>"+	
					"          " + resource[get_po()][2]+" Eau de robinet"+"<br>"+
					"          " + resource[get_po()][3]+" Plastique "+"<br>"+
					"          " + resource[get_po()][4]+" Electricité"+"<br>"+
					 score + " points</html>");
		}
		else if(pos == 2) {
			return ("<html>"+ get_name()+" a<br>" + resource[get_po()][0]+" Charbon"+"<br>"+
					"          " + resource[get_po()][1]+" Fer"+"<br>"+
					"          " + resource[get_po()][2]+" Eau minirale"+"<br>"+
					"          " + resource[get_po()][3]+" Soie "+"<br>"+
					"          " + resource[get_po()][4]+" Télécopieur"+"<br>"+
					 score + " points</html>");
		}
		else if(pos == 1) {
			return ("<html>"+ get_name()+" a<br>" + resource[get_po()][0]+" Bois"+"<br>"+
					"          " + resource[get_po()][1]+" Roche"+"<br>"+
					"          " + resource[get_po()][2]+" Sable"+"<br>"+
					"          " + resource[get_po()][3]+" Soleil "+"<br>"+
					"          " + resource[get_po()][4]+" Combustible"+"<br>"+
					 score + " points</html>");
		}
		else if(pos == 3) {
			return ("<html>"+ get_name()+" a<br>" + resource[get_po()][0]+" Débit d’internet"+"<br>"+
					"          " + resource[get_po()][1]+" 3D matériaux"+"<br>"+
					"          " + resource[get_po()][2]+" Carte SIM"+"<br>"+
					"          " + resource[get_po()][3]+" Chargeur portable"+"<br>"+
					"          " + resource[get_po()][4]+" Routeur"+"<br>"+
					 score + " points</html>");
		}
		else {
			return("Position unknown");
		}
	}
	
	public void add_resource(int type, int number) {	//����������������������������������������0-4����������������������
		resource[position][type]=resource[position][type]+number;
	}
	
	public void lose_resource(int type,int number) {
		resource[position][type]=resource[position][type]-number;
	}
	
	public boolean enough(int type,int num) {		//����������������������������
		if(resource[position][type]>=num)
			return true;
		else return false;
	}
}
