import java.util.Scanner;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.math.*;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.*;


public class plan {
	//��������
	int id;
	node list_node[]=new node[24];
	edge list_edge[]=new edge[30];
	condition list_condition[]=new condition[7];
	int echelle;
	
	 
		// * ��������������
	private static final int nodes[][] = new int[24][2];//��������������
	private static final int edges[][] = new int[30][4];//������������
	private static final int centers[][] = new int[7][2];//����������������
	
	public String info_selected = null;
	public int Pos = 0;
	public GameMap map; // ��������������
	
	public plan() {
		echelle=1;
		map = new GameMap();
	}
	
	public plan(int i) {
		id = i;
		echelle=1;
		map = new GameMap();
	}
	
	
	public int get_id() {
		return id;
	}
	
	public void set_id(int _id) {
		id=_id;
	}
		 
		 //* ��������
	protected void clearMap()
	{
		for(int i=0;i<24;i++)
		{
			list_node[i].set_ocu(-1);
		}
			
		for(int i=0;i<30;i++)
		{
			list_edge[i].set_ocu(-1);
		}
	}
	
	public int check_thief_po(){
		int pos = -1;
		for(int i=0;i<7;i++) {
			if(list_condition[i].check_valide()==false) {
				pos = i;
			}
		}
		return pos;
	}
				
	public int check_edgeocu(int id) { //������������������������
		int sym=0;
		if(id==0) {
			if((list_node[0].check_ocu()!=-1)&&(list_node[2].check_ocu()!=-1))
				sym=1;
		}
		if(id==1) {
			if((list_node[0].check_ocu()!=-1)&&(list_node[3].check_ocu()!=-1))
				sym=1;
		}
		if(id==2) {
			if((list_node[1].check_ocu()!=-1)&&(list_node[3].check_ocu()!=-1))
				sym=1;
		}
		if(id==3) {
			if((list_node[1].check_ocu()!=-1)&&(list_node[4].check_ocu()!=-1))
				sym=1;
		}
		if(id==4) {
			if((list_node[2].check_ocu()!=-1)&&(list_node[5].check_ocu()!=-1))
				sym=1;
		}
		if(id==5) {
			if((list_node[3].check_ocu()!=-1)&&(list_node[6].check_ocu()!=-1))
				sym=1;
		}
		if(id==6) {
			if((list_node[4].check_ocu()!=-1)&&(list_node[7].check_ocu()!=-1))
				sym=1;
		}
		if(id==7) {
			if((list_node[5].check_ocu()!=-1)&&(list_node[8].check_ocu()!=-1))
				sym=1;
		}
		if(id==8) {
			if((list_node[5].check_ocu()!=-1)&&(list_node[9].check_ocu()!=-1))
				sym=1;
		}
		if(id==9) {
			if((list_node[6].check_ocu()!=-1)&&(list_node[9].check_ocu()!=-1))
				sym=1;
		}
		if(id==10) {
			if((list_node[6].check_ocu()!=-1)&&(list_node[10].check_ocu()!=-1))
				sym=1;
		}
		if(id==11) {
			if((list_node[7].check_ocu()!=-1)&&(list_node[10].check_ocu()!=-1))
				sym=1;
		}
		if(id==12) {
			if((list_node[7].check_ocu()!=-1)&&(list_node[11].check_ocu()!=-1))
				sym=1;
		}
		if(id==13) {
			if((list_node[8].check_ocu()!=-1)&&(list_node[12].check_ocu()!=-1))
				sym=1;
		}
		if(id==14) {
			if((list_node[9].check_ocu()!=-1)&&(list_node[13].check_ocu()!=-1))
				sym=1;
		}
		if(id==15) {
			if((list_node[10].check_ocu()!=-1)&&(list_node[14].check_ocu()!=-1))
				sym=1;
		}
		if(id==16) {
			if((list_node[11].check_ocu()!=-1)&&(list_node[15].check_ocu()!=-1))
				sym=1;
		}
		if(id==17) {
			if((list_node[12].check_ocu()!=-1)&&(list_node[16].check_ocu()!=-1))
				sym=1;
		}
		if(id==18) {
			if((list_node[13].check_ocu()!=-1)&&(list_node[16].check_ocu()!=-1))
				sym=1;
		}
		if(id==19) {
			if((list_node[13].check_ocu()!=-1)&&(list_node[17].check_ocu()!=-1))
				sym=1;
		}
		if(id==20) {
			if((list_node[14].check_ocu()!=-1)&&(list_node[17].check_ocu()!=-1))
				sym=1;
		}
		if(id==21) {
			if((list_node[14].check_ocu()!=-1)&&(list_node[18].check_ocu()!=-1))
				sym=1;
		}
		if(id==22) {
			if((list_node[15].check_ocu()!=-1)&&(list_node[18].check_ocu()!=-1))
				sym=1;
		}
		if(id==23) {
			if((list_node[16].check_ocu()!=-1)&&(list_node[19].check_ocu()!=-1))
				sym=1;
		}
		if(id==24) {
			if((list_node[17].check_ocu()!=-1)&&(list_node[20].check_ocu()!=-1))
				sym=1;
		}
		if(id==25) {
			if((list_node[18].check_ocu()!=-1)&&(list_node[21].check_ocu()!=-1))
				sym=1;
		}
		if(id==26) {
			if((list_node[19].check_ocu()!=-1)&&(list_node[22].check_ocu()!=-1))
				sym=1;
		}
		if(id==27) {
			if((list_node[20].check_ocu()!=-1)&&(list_node[22].check_ocu()!=-1))
				sym=1;
		}
		if(id==28) {
			if((list_node[20].check_ocu()!=-1)&&(list_node[23].check_ocu()!=-1))
				sym=1;
		}
		if(id==29) {
			if((list_node[21].check_ocu()!=-1)&&(list_node[22].check_ocu()!=-1))
				sym=1;
		}
		return sym;
	}
	
	public int check_edgeocu1(int id,int eid) { //������������������������
		int sym=0;
		if(id==0) {
			if((list_node[0].check_ocu()==eid)||(list_node[2].check_ocu()==eid))
				sym=1;
		}
		if(id==1) {
			if((list_node[0].check_ocu()==eid)||(list_node[3].check_ocu()==eid))
				sym=1;
		}
		if(id==2) {
			if((list_node[1].check_ocu()==eid)||(list_node[3].check_ocu()==eid))
				sym=1;
		}
		if(id==3) {
			if((list_node[1].check_ocu()==eid)||(list_node[4].check_ocu()==eid))
				sym=1;
		}
		if(id==4) {
			if((list_node[2].check_ocu()==eid)||(list_node[5].check_ocu()==eid))
				sym=1;
		}
		if(id==5) {
			if((list_node[3].check_ocu()==eid)||(list_node[6].check_ocu()==eid))
				sym=1;
		}
		if(id==6) {
			if((list_node[4].check_ocu()==eid)||(list_node[7].check_ocu()==eid))
				sym=1;
		}
		if(id==7) {
			if((list_node[5].check_ocu()==eid)||(list_node[8].check_ocu()==eid))
				sym=1;
		}
		if(id==8) {
			if((list_node[5].check_ocu()==eid)||(list_node[9].check_ocu()==eid))
				sym=1;
		}
		if(id==9) {
			if((list_node[6].check_ocu()==eid)||(list_node[9].check_ocu()==eid))
				sym=1;
		}
		if(id==10) {
			if((list_node[6].check_ocu()==eid)||(list_node[10].check_ocu()==eid))
				sym=1;
		}
		if(id==11) {
			if((list_node[7].check_ocu()==eid)||(list_node[10].check_ocu()==eid))
				sym=1;
		}
		if(id==12) {
			if((list_node[7].check_ocu()==eid)||(list_node[11].check_ocu()==eid))
				sym=1;
		}
		if(id==13) {
			if((list_node[8].check_ocu()==eid)||(list_node[12].check_ocu()==eid))
				sym=1;
		}
		if(id==14) {
			if((list_node[9].check_ocu()==eid)||(list_node[13].check_ocu()==eid))
				sym=1;
		}
		if(id==15) {
			if((list_node[10].check_ocu()==eid)||(list_node[14].check_ocu()==eid))
				sym=1;
		}
		if(id==16) {
			if((list_node[11].check_ocu()==eid)||(list_node[15].check_ocu()==eid))
				sym=1;
		}
		if(id==17) {
			if((list_node[12].check_ocu()==eid)||(list_node[16].check_ocu()==eid))
				sym=1;
		}
		if(id==18) {
			if((list_node[13].check_ocu()==eid)||(list_node[16].check_ocu()==eid))
				sym=1;
		}
		if(id==19) {
			if((list_node[13].check_ocu()==eid)||(list_node[17].check_ocu()==eid))
				sym=1;
		}
		if(id==20) {
			if((list_node[14].check_ocu()==eid)||(list_node[17].check_ocu()==eid))
				sym=1;
		}
		if(id==21) {
			if((list_node[14].check_ocu()==eid)||(list_node[18].check_ocu()==eid))
				sym=1;
		}
		if(id==22) {
			if((list_node[15].check_ocu()==eid)||(list_node[18].check_ocu()==eid))
				sym=1;
		}
		if(id==23) {
			if((list_node[16].check_ocu()==eid)||(list_node[19].check_ocu()==eid))
				sym=1;
		}
		if(id==24) {
			if((list_node[17].check_ocu()==eid)||(list_node[20].check_ocu()==eid))
				sym=1;
		}
		if(id==25) {
			if((list_node[18].check_ocu()==eid)||(list_node[21].check_ocu()==eid))
				sym=1;
		}
		if(id==26) {
			if((list_node[19].check_ocu()==eid)||(list_node[22].check_ocu()==eid))
				sym=1;
		}
		if(id==27) {
			if((list_node[20].check_ocu()==eid)||(list_node[22].check_ocu()==eid))
				sym=1;
		}
		if(id==28) {
			if((list_node[20].check_ocu()==eid)||(list_node[23].check_ocu()==eid))
				sym=1;
		}
		if(id==29) {
			if((list_node[21].check_ocu()==eid)||(list_node[22].check_ocu()==eid))
				sym=1;
		}
		return sym;
	}
	
	public int check_nodeocu(int id) {//����������������������������������
		int sym=0;
		if(id==0) {
			if(((list_node[2].check_ocu()!=-1)&&(list_edge[0].check_ocu()!=-1))||((list_node[3].check_ocu()!=-1)&&(list_edge[1].check_ocu()!=-1))) 
				sym=1;
		}
		if(id==1) {
			if(((list_node[3].check_ocu()!=-1)&&(list_edge[2].check_ocu()!=-1))||((list_node[4].check_ocu()!=-1)&&(list_edge[3].check_ocu()!=-1))) 
				sym=1;
		}
		if(id==2) {
			if(((list_node[0].check_ocu()!=-1)&&(list_edge[0].check_ocu()!=-1))||((list_node[5].check_ocu()!=-1)&&(list_edge[4].check_ocu()!=-1))) 
				sym=1;
		}
		if(id==3) {
			if(((list_node[0].check_ocu()!=-1)&&(list_edge[1].check_ocu()!=-1))||((list_node[1].check_ocu()!=-1)&&(list_edge[2].check_ocu()!=-1))||((list_node[6].check_ocu()!=-1)&&(list_edge[5].check_ocu()!=-1))) 
				sym=1;
		}
		if(id==4) {
			if(((list_node[1].check_ocu()!=-1)&&(list_edge[3].check_ocu()!=-1))||((list_node[7].check_ocu()!=-1)&&(list_edge[6].check_ocu()!=-1))) 
				sym=1;
		}
		if(id==5) {
			if(((list_node[2].check_ocu()!=-1)&&(list_edge[4].check_ocu()!=-1))||((list_node[8].check_ocu()!=-1)&&(list_edge[7].check_ocu()!=-1))||((list_node[9].check_ocu()!=-1)&&(list_edge[8].check_ocu()!=-1))) 
				sym=1;
		}
		if(id==6) {
			if(((list_node[3].check_ocu()!=-1)&&(list_edge[5].check_ocu()!=-1))||((list_node[9].check_ocu()!=-1)&&(list_edge[9].check_ocu()!=-1))||((list_node[10].check_ocu()!=-1)&&(list_edge[10].check_ocu()!=-1))) 
				sym=1;
		}
		if(id==7) {
			if(((list_node[4].check_ocu()!=-1)&&(list_edge[6].check_ocu()!=-1))||((list_node[10].check_ocu()!=-1)&&(list_edge[11].check_ocu()!=-1))||((list_node[11].check_ocu()!=-1)&&(list_edge[12].check_ocu()!=-1))) 
				sym=1;
		}
		if(id==8) {
			if(((list_node[5].check_ocu()!=-1)&&(list_edge[7].check_ocu()!=-1))||((list_node[12].check_ocu()!=-1)&&(list_edge[13].check_ocu()!=-1))) 
				sym=1;
		}
		if(id==9) {
			if(((list_node[5].check_ocu()!=-1)&&(list_edge[8].check_ocu()!=-1))||((list_node[6].check_ocu()!=-1)&&(list_edge[9].check_ocu()!=-1))||((list_node[13].check_ocu()!=-1)&&(list_edge[14].check_ocu()!=-1))) 
				sym=1;
		}
		if(id==10) {
			if(((list_node[6].check_ocu()!=-1)&&(list_edge[10].check_ocu()!=-1))||((list_node[7].check_ocu()!=-1)&&(list_edge[11].check_ocu()!=-1))||((list_node[14].check_ocu()!=-1)&&(list_edge[15].check_ocu()!=-1))) 
				sym=1;
		}
		if(id==11) {
			if(((list_node[7].check_ocu()!=-1)&&(list_edge[12].check_ocu()!=-1))||((list_node[15].check_ocu()!=-1)&&(list_edge[16].check_ocu()!=-1))) 
				sym=1;
		}
		if(id==12) {
			if(((list_node[8].check_ocu()!=-1)&&(list_edge[13].check_ocu()!=-1))||((list_node[16].check_ocu()!=-1)&&(list_edge[17].check_ocu()!=-1))) 
				sym=1;
		}
		if(id==13) {
			if(((list_node[9].check_ocu()!=-1)&&(list_edge[14].check_ocu()!=-1))||((list_node[16].check_ocu()!=-1)&&(list_edge[18].check_ocu()!=-1))||((list_node[17].check_ocu()!=-1)&&(list_edge[19].check_ocu()!=-1))) 
				sym=1;
		}
		if(id==14) {
			if(((list_node[10].check_ocu()!=-1)&&(list_edge[15].check_ocu()!=-1))||((list_node[17].check_ocu()!=-1)&&(list_edge[20].check_ocu()!=-1))||((list_node[18].check_ocu()!=-1)&&(list_edge[21].check_ocu()!=-1))) 
				sym=1;
		}
		if(id==15) {
			if(((list_node[11].check_ocu()!=-1)&&(list_edge[16].check_ocu()!=-1))||((list_node[18].check_ocu()!=-1)&&(list_edge[22].check_ocu()!=-1))) 
				sym=1;
		}
		if(id==16) {
			if(((list_node[12].check_ocu()!=-1)&&(list_edge[17].check_ocu()!=-1))||((list_node[13].check_ocu()!=-1)&&(list_edge[18].check_ocu()!=-1))||((list_node[19].check_ocu()!=-1)&&(list_edge[23].check_ocu()!=-1))) 
				sym=1;
		}
		if(id==17) {
			if(((list_node[13].check_ocu()!=-1)&&(list_edge[19].check_ocu()!=-1))||((list_node[14].check_ocu()!=-1)&&(list_edge[20].check_ocu()!=-1))||((list_node[20].check_ocu()!=-1)&&(list_edge[24].check_ocu()!=-1))) 
				sym=1;
		}
		if(id==18) {
			if(((list_node[14].check_ocu()!=-1)&&(list_edge[20].check_ocu()!=-1))||((list_node[15].check_ocu()!=-1)&&(list_edge[22].check_ocu()!=-1))||((list_node[21].check_ocu()!=-1)&&(list_edge[25].check_ocu()!=-1))) 
				sym=1;
		}
		if(id==19) {
			if(((list_node[16].check_ocu()!=-1)&&(list_edge[23].check_ocu()!=-1))||((list_node[22].check_ocu()!=-1)&&(list_edge[26].check_ocu()!=-1))) 
				sym=1;
		}
		if(id==20) {
			if(((list_node[17].check_ocu()!=-1)&&(list_edge[24].check_ocu()!=-1))||((list_node[22].check_ocu()!=-1)&&(list_edge[27].check_ocu()!=-1))||((list_node[22].check_ocu()!=-1)&&(list_edge[28].check_ocu()!=-1))) 
				sym=1;
		}
		if(id==21) {
			if(((list_node[18].check_ocu()!=-1)&&(list_edge[25].check_ocu()!=-1))||((list_node[23].check_ocu()!=-1)&&(list_edge[29].check_ocu()!=-1))) 
				sym=1;
		}
		if(id==22) {
			if(((list_node[19].check_ocu()!=-1)&&(list_edge[26].check_ocu()!=-1))||((list_node[20].check_ocu()!=-1)&&(list_edge[27].check_ocu()!=-1))) 
				sym=1;
		}
		if(id==23) {
			if(((list_node[20].check_ocu()!=-1)&&(list_edge[28].check_ocu()!=-1))||((list_node[21].check_ocu()!=-1)&&(list_edge[29].check_ocu()!=-1))) 
				sym=1;
		}
		return sym;
	}
	
	public int check_area(int ereaid,int playerid){	//����������������������������������������
		int number = 0;
		if(ereaid == 0 && list_condition[0].check_valide()==true) {
			if(list_node[0].check_ocu()==playerid)number++;
			if(list_node[2].check_ocu()==playerid)number++;
			if(list_node[3].check_ocu()==playerid)number++;
			if(list_node[5].check_ocu()==playerid)number++;
			if(list_node[6].check_ocu()==playerid)number++;
			if(list_node[9].check_ocu()==playerid)number++;
			return number;
		}
		if(ereaid == 1 && list_condition[1].check_valide()==true) {
			if(list_node[1].check_ocu()==playerid)number++;
			if(list_node[3].check_ocu()==playerid)number++;
			if(list_node[4].check_ocu()==playerid)number++;
			if(list_node[6].check_ocu()==playerid)number++;
			if(list_node[7].check_ocu()==playerid)number++;
			if(list_node[10].check_ocu()==playerid)number++;
			return number;
		}
		if(ereaid == 2 && list_condition[2].check_valide()==true) {
			if(list_node[5].check_ocu()==playerid)number++;
			if(list_node[8].check_ocu()==playerid)number++;
			if(list_node[9].check_ocu()==playerid)number++;
			if(list_node[12].check_ocu()==playerid)number++;
			if(list_node[13].check_ocu()==playerid)number++;
			if(list_node[16].check_ocu()==playerid)number++;
			return number;
		}
		if(ereaid == 3 && list_condition[3].check_valide()==true) {
			if(list_node[7].check_ocu()==playerid)number++;
			if(list_node[10].check_ocu()==playerid)number++;
			if(list_node[11].check_ocu()==playerid)number++;
			if(list_node[14].check_ocu()==playerid)number++;
			if(list_node[15].check_ocu()==playerid)number++;
			if(list_node[18].check_ocu()==playerid)number++;
			return number;
		}
		if(ereaid == 4 && list_condition[4].check_valide()==true) {
			if(list_node[13].check_ocu()==playerid)number++;
			if(list_node[16].check_ocu()==playerid)number++;
			if(list_node[17].check_ocu()==playerid)number++;
			if(list_node[19].check_ocu()==playerid)number++;
			if(list_node[20].check_ocu()==playerid)number++;
			if(list_node[22].check_ocu()==playerid)number++;
			return number;
		}
		if(ereaid == 5 && list_condition[5].check_valide()==true) {
			if(list_node[14].check_ocu()==playerid)number++;
			if(list_node[17].check_ocu()==playerid)number++;
			if(list_node[18].check_ocu()==playerid)number++;
			if(list_node[20].check_ocu()==playerid)number++;
			if(list_node[21].check_ocu()==playerid)number++;
			if(list_node[23].check_ocu()==playerid)number++;
			return number;
		}
		else {
			return 0;
		}
	}
	
	
	public void move_thief(int pos){
		list_condition[check_thief_po()].set_valide(true);
		list_condition[Pos].set_valide(false);
	}
	
	//������������������
		{
				nodes[0][0] = 250;
				nodes[0][1] = 80;
				
				nodes[1][0] = 450;
				nodes[1][1] = 80;
				
				nodes[2][0] = 150;
				nodes[2][1] = 138;
				
				nodes[3][0] = 350;
				nodes[3][1] = 138;
				
				nodes[4][0] = 550;
				nodes[4][1] = 138;
				
				nodes[5][0] = 150;
				nodes[5][1] = 253;
				
				nodes[6][0] = 350;
				nodes[6][1] = 253;
				
				nodes[7][0] = 550;
				nodes[7][1] = 253;
				
				nodes[8][0] = 50;
				nodes[8][1] = 310;
				
				nodes[9][0] = 250;
				nodes[9][1] = 310;
				
				nodes[10][0] = 450;
				nodes[10][1] = 310;
				
				nodes[11][0] = 650;
				nodes[11][1] = 310;
				
				nodes[12][0] = 50;
				nodes[12][1] = 426;
				
				nodes[13][0] = 250;
				nodes[13][1] = 426;
				
				nodes[14][0] = 450;
				nodes[14][1] = 426;
				
				nodes[15][0] = 650;
				nodes[15][1] = 426;
				
				nodes[16][0] = 150;
				nodes[16][1] = 484;
				
				nodes[17][0] = 350;
				nodes[17][1] = 484;
				
				nodes[18][0] = 550;
				nodes[18][1] = 484;
				
				nodes[19][0] = 150;
				nodes[19][1] = 599;
				
				nodes[20][0] = 350;
				nodes[20][1] = 599;
				
				nodes[21][0] = 550;
				nodes[21][1] = 599;
				
				nodes[22][0] = 250;
				nodes[22][1] = 657;
				
				nodes[23][0] = 450;
				nodes[23][1] = 657;
			}
			
	//����������������
		{
				edges[0][0] = nodes[0][0];
				edges[0][1] = nodes[0][1];
				edges[0][2] = nodes[2][0];
				edges[0][3] = nodes[2][1];
				
				edges[1][0] = nodes[0][0];
				edges[1][1] = nodes[0][1];
				edges[1][2] = nodes[3][0];
				edges[1][3] = nodes[3][1];
				
				edges[2][0] = nodes[1][0];
				edges[2][1] = nodes[1][1];
				edges[2][2] = nodes[3][0];
				edges[2][3] = nodes[3][1];
				
				edges[3][0] = nodes[1][0];
				edges[3][1] = nodes[1][1];
				edges[3][2] = nodes[4][0];
				edges[3][3] = nodes[4][1];
				
				edges[4][0] = nodes[2][0];
				edges[4][1] = nodes[2][1];
				edges[4][2] = nodes[5][0];
				edges[4][3] = nodes[5][1];
				
				edges[5][0] = nodes[3][0];
				edges[5][1] = nodes[3][1];
				edges[5][2] = nodes[6][0];
				edges[5][3] = nodes[6][1];
				
				edges[6][0] = nodes[4][0];
				edges[6][1] = nodes[4][1];
				edges[6][2] = nodes[7][0];
				edges[6][3] = nodes[7][1];
				
				edges[7][0] = nodes[5][0];
				edges[7][1] = nodes[5][1];
				edges[7][2] = nodes[8][0];
				edges[7][3] = nodes[8][1];
				
				edges[8][0] = nodes[5][0];
				edges[8][1] = nodes[5][1];
				edges[8][2] = nodes[9][0];
				edges[8][3] = nodes[9][1];
				
				edges[9][0] = nodes[6][0];
				edges[9][1] = nodes[6][1];
				edges[9][2] = nodes[9][0];
				edges[9][3] = nodes[9][1];
				
				edges[10][0] = nodes[6][0];
				edges[10][1] = nodes[6][1];
				edges[10][2] = nodes[10][0];
				edges[10][3] = nodes[10][1];
				
				edges[11][0] = nodes[7][0];
				edges[11][1] = nodes[7][1];
				edges[11][2] = nodes[10][0];
				edges[11][3] = nodes[10][1];
				
				edges[12][0] = nodes[7][0];
				edges[12][1] = nodes[7][1];
				edges[12][2] = nodes[11][0];
				edges[12][3] = nodes[11][1];
				
				edges[13][0] = nodes[8][0];
				edges[13][1] = nodes[8][1];
				edges[13][2] = nodes[12][0];
				edges[13][3] = nodes[12][1];
				
				edges[14][0] = nodes[9][0];
				edges[14][1] = nodes[9][1];
				edges[14][2] = nodes[13][0];
				edges[14][3] = nodes[13][1];
				
				
				edges[15][0] = nodes[10][0];
				edges[15][1] = nodes[10][1];
				edges[15][2] = nodes[14][0];
				edges[15][3] = nodes[14][1];
				
				edges[16][0] = nodes[11][0];
				edges[16][1] = nodes[11][1];
				edges[16][2] = nodes[15][0];
				edges[16][3] = nodes[15][1];
				
				edges[17][0] = nodes[12][0];
				edges[17][1] = nodes[12][1];
				edges[17][2] = nodes[16][0];
				edges[17][3] = nodes[16][1];
				
				edges[18][0] = nodes[13][0];
				edges[18][1] = nodes[13][1];
				edges[18][2] = nodes[16][0];
				edges[18][3] = nodes[16][1];
				
				edges[19][0] = nodes[13][0];
				edges[19][1] = nodes[13][1];
				edges[19][2] = nodes[17][0];
				edges[19][3] = nodes[17][1];
				
				edges[20][0] = nodes[14][0];
				edges[20][1] = nodes[14][1];
				edges[20][2] = nodes[17][0];
				edges[20][3] = nodes[17][1];
				
				edges[21][0] = nodes[14][0];
				edges[21][1] = nodes[14][1];
				edges[21][2] = nodes[18][0];
				edges[21][3] = nodes[18][1];

				edges[22][0] = nodes[15][0];
				edges[22][1] = nodes[15][1];
				edges[22][2] = nodes[18][0];
				edges[22][3] = nodes[18][1];
				
				edges[23][0] = nodes[16][0];
				edges[23][1] = nodes[16][1];
				edges[23][2] = nodes[19][0];
				edges[23][3] = nodes[19][1];
			
				edges[24][0] = nodes[17][0];
				edges[24][1] = nodes[17][1];
				edges[24][2] = nodes[20][0];
				edges[24][3] = nodes[20][1];
			
				edges[25][0] = nodes[18][0];
				edges[25][1] = nodes[18][1];
				edges[25][2] = nodes[21][0];
				edges[25][3] = nodes[21][1];
				
				edges[26][0] = nodes[19][0];
				edges[26][1] = nodes[19][1];
				edges[26][2] = nodes[22][0];
				edges[26][3] = nodes[22][1];

				edges[27][0] = nodes[20][0];
				edges[27][1] = nodes[20][1];
				edges[27][2] = nodes[22][0];
				edges[27][3] = nodes[22][1];
				
				edges[28][0] = nodes[20][0];
				edges[28][1] = nodes[20][1];
				edges[28][2] = nodes[23][0];
				edges[28][3] = nodes[23][1];
				
				edges[29][0] = nodes[21][0];
				edges[29][1] = nodes[21][1];
				edges[29][2] = nodes[23][0];
				edges[29][3] = nodes[23][1];
				
			}
			
	//��������������������
		{
				centers[0][0] = 250;
				centers[0][1] = 196;
				
				centers[1][0] = 450;
				centers[1][1] = 196;
				
				centers[2][0] = 150;
				centers[2][1] = 368;
			
				centers[6][0] = 350;
				centers[6][1] = 368;
				
				centers[3][0] = 550;
				centers[3][1] = 368;
				
				centers[4][0] = 250;
				centers[4][1] = 542;
				
				centers[5][0] = 450;
				centers[5][1] = 542;
			}
	
	// * ����������������������������
	public class GameMap extends JPanel
	{
		private static final long serialVersionUID = 16578987565248L;
		
		public void paintComponent(Graphics g)
		{
			Graphics2D g2 = (Graphics2D)g;
			g2.setStroke(new BasicStroke(3.0f));
			super.paintComponent(g);
			// ������
			g.setColor(new Color(153,217,234)); 
			g.fillRect(0, 0,700,700); // ��������
					
			//��������
			g.setColor(new Color(127,127,127));//������mine
			final int xPoints[] = new int[6];
			{
				xPoints[0] = nodes[0][0];
				xPoints[1] = nodes[2][0];
				xPoints[2] = nodes[5][0];
				xPoints[3] = nodes[9][0];
				xPoints[4] = nodes[6][0];
				xPoints[5] = nodes[3][0];	
			}
			final int yPoints[] = new int[6];
			{
				yPoints[0] = nodes[0][1];
				yPoints[1] = nodes[2][1];
				yPoints[2] = nodes[5][1];
				yPoints[3] = nodes[9][1];
				yPoints[4] = nodes[6][1];
				yPoints[5] = nodes[3][1];	
			}
			g.fillPolygon(xPoints, yPoints,6);
				
			g.setColor(new Color(181,230,29));//��������grass
			{
				xPoints[0] = nodes[13][0];
				xPoints[1] = nodes[16][0];
				xPoints[2] = nodes[19][0];
				xPoints[3] = nodes[22][0];
				xPoints[4] = nodes[20][0];
				xPoints[5] = nodes[17][0];	
			}
		
			{	
				yPoints[0] = nodes[13][1];
				yPoints[1] = nodes[16][1];
				yPoints[2] = nodes[19][1];
				yPoints[3] = nodes[22][1];
				yPoints[4] = nodes[20][1];
				yPoints[5] = nodes[17][1];	
			}
			g.fillPolygon(xPoints, yPoints,6);
			
			g.setColor(new Color(34,177,76));//��������forest
			{
				xPoints[0] = nodes[1][0];
				xPoints[1] = nodes[3][0];
				xPoints[2] = nodes[6][0];
				xPoints[3] = nodes[10][0];
				xPoints[4] = nodes[7][0];
				xPoints[5] = nodes[4][0];	
			}
		
			{
				yPoints[0] = nodes[1][1];
				yPoints[1] = nodes[3][1];
				yPoints[2] = nodes[6][1];
				yPoints[3] = nodes[10][1];
				yPoints[4] = nodes[7][1];
				yPoints[5] = nodes[4][1];	
			}
			g.fillPolygon(xPoints, yPoints,6);
			
			{
				xPoints[0] = nodes[14][0];
				xPoints[1] = nodes[17][0];
				xPoints[2] = nodes[20][0];
				xPoints[3] = nodes[23][0];
				xPoints[4] = nodes[21][0];
				xPoints[5] = nodes[18][0];	
			}
		
			{
				yPoints[0] = nodes[14][1];
				yPoints[1] = nodes[17][1];
				yPoints[2] = nodes[20][1];
				yPoints[3] = nodes[23][1];
				yPoints[4] = nodes[21][1];
				yPoints[5] = nodes[18][1];	
			}
			g.fillPolygon(xPoints, yPoints,6);
			
			
			g.setColor(new Color(255,105,15));//������wheat
			{
				xPoints[0] = nodes[7][0];
				xPoints[1] = nodes[10][0];
				xPoints[2] = nodes[14][0];
				xPoints[3] = nodes[18][0];
				xPoints[4] = nodes[15][0];
				xPoints[5] = nodes[11][0];	
			}
		
			{
				yPoints[0] = nodes[7][1];
				yPoints[1] = nodes[10][1];
				yPoints[2] = nodes[14][1];
				yPoints[3] = nodes[18][1];
				yPoints[4] = nodes[15][1];				
				yPoints[5] = nodes[11][1];	
			}
		
			g.fillPolygon(xPoints, yPoints,6);
							
			g.setColor(new Color(255,201,14));//��������desert
			{
				xPoints[0] = nodes[6][0];
				xPoints[1] = nodes[9][0];
				xPoints[2] = nodes[13][0];
				xPoints[3] = nodes[17][0];
				xPoints[4] = nodes[14][0];
				xPoints[5] = nodes[10][0];	
			}
		
			{
				yPoints[0] = nodes[6][1];
				yPoints[1] = nodes[9][1];
				yPoints[2] = nodes[13][1];
				yPoints[3] = nodes[17][1];
				yPoints[4] = nodes[14][1];
				yPoints[5] = nodes[10][1];	
			}
			g.fillPolygon(xPoints, yPoints,6);
			
			
			g.setColor(new Color(136,0,21));//������brick
			{
				xPoints[0] = nodes[5][0];
				xPoints[1] = nodes[8][0];
				xPoints[2] = nodes[12][0];
				xPoints[3] = nodes[16][0];
				xPoints[4] = nodes[13][0];
				xPoints[5] = nodes[9][0];	
			}			
				
			{
				yPoints[0] = nodes[5][1];
				yPoints[1] = nodes[8][1];
				yPoints[2] = nodes[12][1];
				yPoints[3] = nodes[16][1];
				yPoints[4] = nodes[13][1];
				yPoints[5] = nodes[9][1];	
			}
			
			g.fillPolygon(xPoints, yPoints,6);
			
				
			//����
			for (int i=0; i < 24; i++)
			{
				if(info_selected == "Point" && i == Pos)
				{
					g.setColor(Color.WHITE);	
				}
				
				else {
					if(list_node[i].check_ocu() == -1	)
					{
						g.setColor(Color.BLACK);	
						if(i==0||i==4||i==8||i==15|i==19||i==23) {
							g.setColor(Color.BLUE);
						}
					}
					
					else if(list_node[i].check_ocu() == 0 )
					{
						g.setColor(Color.RED);
					}
						
					else if(list_node[i].check_ocu() == 1 )
					{
						g.setColor(Color.GREEN);
					}
				
					else if(list_node[i].check_ocu() == 2 )
					{
						g.setColor(Color.PINK);

					}
				
					else if(list_node[i].check_ocu() == 3 )
					{
						g.setColor(Color.YELLOW);	
					}
				}
				g.fillOval(nodes[i][0]-7,nodes[i][1]-7,15,15);
				
				if(list_node[i].get_type() == 2) {
					g.fillOval(nodes[i][0]-15,nodes[i][1]-15,30,30);
				}
			}
				
				
			//����
			for (int i=0; i < 30; i++)
			{
				if(info_selected == "Road" && i == Pos)
				{
					g.setColor(Color.WHITE);	
				}
				
				else {
					if(list_edge[i].check_ocu() == -1 )
					{
						g.setColor(Color.BLACK);
					
					}
				
					else if(list_edge[i].check_ocu() == 0 )
					{
						g.setColor(Color.RED);
					
					}
				
					else if(list_edge[i].check_ocu() == 1 )
					{
						g.setColor(Color.GREEN);
					
					}
				
					else if(list_edge[i].check_ocu() == 2 )
					{
						g.setColor(Color.PINK);
					
					}
				
					else if(list_edge[i].check_ocu() == 3 )
					{
						g.setColor(Color.YELLOW);
					
					}
					
				}
				
				
				g.drawLine(edges[i][0],edges[i][1],edges[i][2],edges[i][3]);
			}
			g.setColor(Color.BLACK);
			
			
			Font f = new Font("Times New Roman",Font.BOLD,16);
			if(id==0) {
			if(check_thief_po()==0)				//��������������������
			    g.fillRect(235,175,30,30);
			else
				{g.setFont(f);
				g.drawString("1.Gaz", 232, 196);}
			
			if(check_thief_po()==1)
			    g.fillRect(435,175,30,30);
			else
				{g.setFont(f);
				g.drawString("2.Acier", 425, 196);}
			
			if(check_thief_po()==2)
			    g.fillRect(135,350,30,30);
			else
				{g.setFont(f);
				g.drawString("3.Eau de robinet", 90, 368);}
			
			if(check_thief_po()==6)
			    g.fillRect(335,350,30,30);
			else
				{g.setFont(f);
				g.drawString("7.Désert", 325, 368);}
			
			if(check_thief_po()==3)
				g.fillRect(535,350,30,30);
			else
				{g.setFont(f);
				g.drawString("4.Plastique", 515,368);}
			
			if(check_thief_po()==4)
				g.fillRect(235,525,30,30);
			else
				{g.setFont(f);
				g.drawString("5.L’electricité", 205, 542);}
			
			if(check_thief_po()==5)
				g.fillRect(435,525,30,30);
			else
				{g.setFont(f);
				g.drawString("6.Acier", 432, 542);}}
			else if(id==1) {
				
				if(check_thief_po()==0)				
				    g.fillRect(235,175,30,30);
				else
					{g.setFont(f);
					g.drawString("1.Bois", 235, 196);}
				
				if(check_thief_po()==1)
				    g.fillRect(435,175,30,30);
				else
					{g.setFont(f);
					g.drawString("2.Roche", 430, 196);}
				
				if(check_thief_po()==2)
				    g.fillRect(135,350,30,30);
				else
					{g.setFont(f);
					g.drawString("3.Sable", 127, 368);}
				
				if(check_thief_po()==6)
				    g.fillRect(335,350,30,30);
				else
					{g.setFont(f);
					g.drawString("7.Désert", 325, 368);}
				
				if(check_thief_po()==3)
					g.fillRect(535,350,30,30);
				else
					{g.setFont(f);
					g.drawString("4.Soleil", 525, 368);}
				
				if(check_thief_po()==4)
					g.fillRect(235,525,30,30);
				else
					{g.setFont(f);
					g.drawString("5.Combustible", 205, 542);}
				
				if(check_thief_po()==5)
					g.fillRect(435,525,30,30);
				else
					{g.setFont(f);
					g.drawString("6.Roche", 430, 542);}
			}
                else if(id==2) {
				
				if(check_thief_po()==0)				//��������������������
				    g.fillRect(235,175,30,30);
				else
					{g.setFont(f);
					g.drawString("1.Charbon", 215, 196);}
				
				if(check_thief_po()==1)
				    g.fillRect(435,175,30,30);
				else
					{g.setFont(f);
					g.drawString("2.Fer", 435, 196);}
				
				if(check_thief_po()==2)
				    g.fillRect(135,350,30,30);
				else
					{g.setFont(f);
					g.drawString("3.Eau minirale", 100, 368);}
				
				if(check_thief_po()==6)
				    g.fillRect(335,350,30,30);
				else
					{g.setFont(f);
					g.drawString("7.Désert", 325, 368);}
				
				if(check_thief_po()==3)
					g.fillRect(535,350,30,30);
				else
					{g.setFont(f);
					g.drawString("4.Soie", 535, 368);}
				
				if(check_thief_po()==4)
					g.fillRect(235,525,30,30);
				else
					{g.setFont(f);
					g.drawString("5.Télécopieur", 205, 542);}
				
				if(check_thief_po()==5)
					g.fillRect(435,525,30,30);
				else
					{g.setFont(f);
					g.drawString("6.Fer", 435, 542);}
			}
                else if(id==3) {
    				
    				if(check_thief_po()==0)				//��������������������
    				    g.fillRect(235,175,30,30);
    				else
    					{g.setFont(f);
    					g.drawString("1.Débit d’internet", 185, 196);}
    				
    				if(check_thief_po()==1)
    				    g.fillRect(435,175,30,30);
    				else
    					{g.setFont(f);
    					g.drawString("2.3D matériaux", 395, 196);}
    				
    				if(check_thief_po()==2)
    				    g.fillRect(135,350,30,30);
    				else
    					{g.setFont(f);
    					g.drawString("3.Carte SIM", 105, 368);}
    				
    				if(check_thief_po()==6)
    				    g.fillRect(335,350,30,30);
    				else
    					{g.setFont(f);
    					g.drawString("7.Désert", 325, 368);}
    				
    				if(check_thief_po()==3)
    					g.fillRect(535,350,30,30);
    				else
    					{g.setFont(f);
    					g.drawString("4.Chargeur portable", 490, 368);}
    				
    				if(check_thief_po()==4)
    					g.fillRect(235,525,30,30);
    				else
    					{g.setFont(f);
    					g.drawString("5.Routeur", 220, 542);}
    				
    				if(check_thief_po()==5)
    					g.fillRect(435,525,30,30);
    				else
    					{g.setFont(f);
    					g.drawString("6.3D matériaux", 400, 542);}
    			}
			
		    if(info_selected == "Erea") {
				g.setColor(Color.WHITE);
				if(Pos==0)g.fillRect(235,175,30,30);
				if(Pos==1)g.fillRect(435,175,30,30);
				if(Pos==2)g.fillRect(135,350,30,30);
				if(Pos==6)g.fillRect(335,350,30,30);
				if(Pos==3)g.fillRect(535,350,30,30);
				if(Pos==4)g.fillRect(235,525,30,30);
				if(Pos==5)g.fillRect(435,525,30,30);
			}
		}
	}
	

	public void click() 
	{	
		map.addMouseListener(new MouseAdapter() 
		{
			// ������������
			public void mouseClicked(MouseEvent e) 
				{
					// ����������������������������������������������������
					
				int edgePos=-1 ;
				int nodePos=-1 ;
				int centerPos=-1;
				int shortest_index1=-1;
				int shortest_index2=-1;
				int index=-1;
				double shortest_distance1=99999.999;	
				double shortest_distance2=99999.999;
				double distance_to_each_node[] = new double[24];//��������������������������������
				double distance_to_each_center[] = new double[7];//����������������������������������
				for (int i=0;i<24;i++)
				{
					distance_to_each_node[i] = Math.sqrt((e.getX()-nodes[i][0])* (e.getX()-nodes[i][0]) + (e.getY()-nodes[i][1])* (e.getY()-nodes[i][1]));
				
				}
				
				for (int i=0;i<7;i++)
				{
					distance_to_each_center[i] = Math.sqrt(e.getX()-centers[i][0])* (e.getX()-centers[i][0]) + (e.getY()-centers[i][1])* (e.getY()-centers[i][1]);
				}
				
				for (int i=0;i<24;i++)//����������������������
				{
					if (distance_to_each_node[i]<shortest_distance1)
					{
						shortest_distance1=distance_to_each_node[i];
						shortest_index1 = i;
					}
				}			
				
				for (int i=0;i<24;i++)//������������������������
				{
					if (distance_to_each_node[i]<shortest_distance2 && i!=shortest_index1)
					{
						shortest_distance2=distance_to_each_node[i];
						shortest_index2 = i;
					}
				}
				
				if(shortest_distance1<=10)//������������������
				{
					nodePos = shortest_index1;
					index = 1;
					
				}
					
				else if(shortest_distance1+shortest_distance2<120)//����������������
				{
					if((shortest_index1==0 && shortest_index2==2)||(shortest_index1==2 && shortest_index2==0))
					{
						edgePos = 0;
						index = 2;
					}
					
					else if((shortest_index1==0 && shortest_index2==3)||(shortest_index1==3 && shortest_index2==0))
					{
						edgePos = 1;
						index = 2;
					}
						
					else if((shortest_index1==1 && shortest_index2==3)||(shortest_index1==3 && shortest_index2==1))
					{
						edgePos = 2;
						index = 2;
					}
					
					else if((shortest_index1==1 && shortest_index2==4)||(shortest_index1==4 && shortest_index2==1))
					{
						edgePos = 3;
						index = 2;
					}
						
					else if((shortest_index1==2 && shortest_index2==5)||(shortest_index1==5 && shortest_index2==2))
					{
						edgePos = 4;
						index = 2;
					}
						
					else if((shortest_index1==3 && shortest_index2==6)||(shortest_index1==6 && shortest_index2==3))
					{
						edgePos = 5;
						index = 2;
					}
						
					else if((shortest_index1==4 && shortest_index2==7)||(shortest_index1==7 && shortest_index2==4))
					{
						edgePos = 6;
						index = 2;
					}
						
					else if((shortest_index1==5 && shortest_index2==8)||(shortest_index1==8 && shortest_index2==5))
					{
						edgePos = 7;
						index = 2;
					}
					
					else if((shortest_index1==5 && shortest_index2==9)||(shortest_index1==9 && shortest_index2==5))
					{
						edgePos = 8;
						index = 2;
					}
					
					else if((shortest_index1==6 && shortest_index2==9)||(shortest_index1==9 && shortest_index2==6))
					{
						edgePos = 9;
						index = 2;
					}
					
					else if((shortest_index1==6 && shortest_index2==10)||(shortest_index1==10 && shortest_index2==6))
					{
						edgePos = 10;
						index = 2;
					}
					
					else if((shortest_index1==7 && shortest_index2==10)||(shortest_index1==10 && shortest_index2==7))
					{
						edgePos = 11;
						index = 2;
					}
					
					else if((shortest_index1==7 && shortest_index2==11)||(shortest_index1==11 && shortest_index2==7))
					{
						edgePos = 12;
						index = 2;
					}
					
					else if((shortest_index1==8 && shortest_index2==12)||(shortest_index1==12 && shortest_index2==8))
					{
						edgePos = 13;
						index = 2;
					}
					
					else if((shortest_index1==9 && shortest_index2==13)||(shortest_index1==13 && shortest_index2==9))
					{
						edgePos = 14;
						index = 2;
					}
					
					else if((shortest_index1==10 && shortest_index2==14)||(shortest_index1==14 && shortest_index2==10))
					{
						edgePos = 15;
						index = 2;
					}
					
					else if((shortest_index1==11 && shortest_index2==15)||(shortest_index1==15 && shortest_index2==11))
					{
						edgePos = 16;
						index = 2;
					}
					
					else if((shortest_index1==12 && shortest_index2==16)||(shortest_index1==16 && shortest_index2==12))
					{
						edgePos = 17;
						index = 2;
					}
					
					else if((shortest_index1==13 && shortest_index2==16)||(shortest_index1==16 && shortest_index2==13))
					{
						edgePos = 18;
						index = 2;
					}
					
					else if((shortest_index1==13 && shortest_index2==17)||(shortest_index1==17 && shortest_index2==13))
					{
						edgePos = 19;
						index = 2;
					}
					
					else if((shortest_index1==14 && shortest_index2==17)||(shortest_index1==17 && shortest_index2==14))
					{
						edgePos = 20;
						index = 2;
					}
					
					else if((shortest_index1==14 && shortest_index2==18)||(shortest_index1==18 && shortest_index2==14))
					{
						edgePos = 21;
						index = 2;
					}
					
					else if((shortest_index1==15 && shortest_index2==18)||(shortest_index1==18 && shortest_index2==15))
					{
						edgePos = 22;
						index = 2;
					}
					
					else if((shortest_index1==16 && shortest_index2==19)||(shortest_index1==19 && shortest_index2==16))
					{
						edgePos = 23;
						index = 2;
					}
					
					else if((shortest_index1==17 && shortest_index2==20)||(shortest_index1==20 && shortest_index2==17))
					{
						edgePos = 24;
						index = 2;
					}
					
					else if((shortest_index1==18 && shortest_index2==21)||(shortest_index1==21 && shortest_index2==18))
					{
						edgePos = 25;
						index = 2;
					}
					
					else if((shortest_index1==19 && shortest_index2==22)||(shortest_index1==22 && shortest_index2==19))
					{
						edgePos = 26;
						index = 2;
					}
					
					else if((shortest_index1==20 && shortest_index2==22)||(shortest_index1==22 && shortest_index2==20))
					{
						edgePos = 27;
						index = 2;
					}
					
					else if((shortest_index1==20 && shortest_index2==23)||(shortest_index1==23 && shortest_index2==20))
					{
						edgePos = 28;
						index = 2;
					}
					
					else if((shortest_index1==21 && shortest_index2==23)||(shortest_index1==23 && shortest_index2==21))
					{
						edgePos = 29;
						index = 2;
					}
				}
				
				
				else//����������������������������
				{
					for (int i=0;i<7;i++)//������������������������
					{
						if(distance_to_each_center[i]<150)
						{
							centerPos = i;
							index = 3;
							break;
						}
					}
				};
				
				
				
				if(index==1)
				{
					info_selected = "Point";
					Pos = nodePos;
					map.repaint();
				}
				
				else if(index==2)
				{
					info_selected = "Road";
					Pos = edgePos;
					map.repaint();
				}
				
				else if(index==3)
				{
					info_selected = "Erea";
					Pos = centerPos;
					map.repaint();
				}
				
			}
		});
	}
}