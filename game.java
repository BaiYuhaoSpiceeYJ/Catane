import java.util.Scanner;
import java.awt.BasicStroke;
import java.awt.Font;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.math.*;

import javax.swing.*;


public class game{
	

	player list_players[];
	plan list_plans[];
	
	
	public JFrame frame; 
	JPanel panel = new JPanel();
	JMenuBar bar; 
	JMenu game; 
	JMenuItem[] items1; 
	JLabel head ;
	JLabel resource;
	JLabel resource2;
	JLabel info;
	JTextField name;
	JTextField[][] deal_number= new JTextField[2][5];
	JButton[] items2 = new JButton[4];
	JButton City;
	JButton build;
	JButton dice;
	JButton traverser;
	JButton deal;
	JButton deal_type[] = new JButton[3];
	JButton next;
	JButton[] player = new JButton[4];
	JButton[][] ressource = new JButton[2][5];
	JButton[] bank_deal = new JButton[5];
	JButton[] port_deal = new JButton[5];
 	JButton confirm;
	JButton confirm2;
	JButton confirm3;
	JButton confirm4;
	JButton confirm5;
	JButton draw;
	JButton[] exchange=new JButton[3];
	JButton changePlayer;
	JButton changePlayer2;
	
	
	public static int step = 0;	
	public static int button=-1; 
	public static int playerID =0; 
	public static int number = 0;
	public static int winner = -1;
	public static int id_selected = -1;
	public static int enough = 1;
	public static int counter = 1;
	public static int type_voulu=-1;
	public static int type_consomme=-1;
	
	public game(){
		setup();
	}
	
	private void creatGUI() {
		//������frame
		frame = new JFrame("Catane"); 
		frame.setSize(1000,790);
		frame.add(panel);
		panel.setLayout(null);
    	
    	//����������
		bar = new JMenuBar(); // ����������
		game = new JMenu(""); // ����������������������
		items1 = new JMenuItem[2]; // game����������2����������
		items2[0] = new JButton("Tunnel");
		items2[1] = new JButton("Delorean");
		items2[2] = new JButton("Convertisseur");
		items2[3] = new JButton("Carte");
		deal_type[0] = new JButton("Joueur");
		deal_type[1] = new JButton("Banque");
		deal_type[2] = new JButton("Port");
		for(int i=0;i<2;i++) {
			for(int j=0;j<5;j++) {
				deal_number[i][j] = new JTextField("0");
			}
		}
		for(int i=0;i<4;i++) {
			player[i] = new JButton("");
		}
		for(int i=0;i<5;i++) {
			for(int j=0;j<2;j++)
			{
				ressource[j][i]=new JButton(""+(i+1));
			}
			bank_deal[i] = new JButton(""+(i+1));
			port_deal[i] = new JButton(""+(i+1));
		}
		City = new JButton("Convertisseur");
		build = new JButton("Construire");
		dice = new JButton("Dé");
		traverser = new JButton("Traverser");
		deal = new JButton("Commerce");
		head = new JLabel("Bienvenue dans l'île Catane!",JLabel.CENTER);
		resource = new JLabel("");
		resource2 = new JLabel("");
		info = new JLabel("",JLabel.CENTER);
		name = new JTextField("Bienvenue dans l'île Catane!");
		next = new JButton("Suivant");
		confirm = new JButton("Confirme");
		confirm2 = new JButton("Confirme");
		confirm3 = new JButton("Confirme");
		confirm4 = new JButton("Confirme");
		confirm5 = new JButton("Confirme");
		draw = new JButton("Tirer");
		exchange[0] = new JButton("échanger");
		exchange[1] = new JButton("échanger");
		exchange[2] = new JButton("échanger");
		changePlayer = new JButton("Fin du tour");
		changePlayer2 = new JButton("Fin du tour");
		
		//��������
		Font f1 = new Font("Times New Roman",Font.BOLD,20);
		Font f2 = new Font("Times New Roman",Font.BOLD,13);
		Font f3 = new Font("Arial Unicode MS",Font.BOLD,13);
		Font f4 = new Font("Times New Roman",Font.BOLD,10);
		items2[0].setFont(f4);
		items2[1].setFont(f4);
		items2[2].setFont(f4);
		items2[3].setFont(f4);
		deal_type[0].setFont(f2);
		deal_type[1].setFont(f2);
		deal_type[2].setFont(f2);
		player[0].setFont(f4);
		player[1].setFont(f4);
		player[2].setFont(f4);
		player[3].setFont(f4);
		for(int i=0;i<5;i++) {
			for(int j=0;j<2;j++)
			{
				ressource[j][i].setFont(f4);
			}
			bank_deal[i].setFont(f4);
			port_deal[i].setFont(f4);
		}
		for(int i=0;i<2;i++) {
			for(int j=0;j<5;j++) {
				deal_number[i][j].setFont(f2);
			}
		}
		City.setFont(f2);
		build.setFont(f4);
		dice.setFont(f4);
		traverser.setFont(f4);
		deal.setFont(f4);
		head.setFont(f1);
		name.setFont(f3);
		resource.setFont(f3);
		resource2.setFont(f3);
		info.setFont(f3);
		next.setFont(f2);
		confirm.setFont(f2);
		confirm2.setFont(f2);
		confirm3.setFont(f2);
		confirm4.setFont(f2);
		confirm5.setFont(f2);
		draw.setFont(f2);
		exchange[0].setFont(f2);
		exchange[1].setFont(f2);
		exchange[2].setFont(f2);
		changePlayer.setFont(f2);
		changePlayer2.setFont(f2);
		
		//������������
		items2[0].setBounds(702,440,70,30);
		items2[1].setBounds(773,440,70,30);
		items2[2].setBounds(844,440,70,30);
		items2[3].setBounds(915,440,70,30);
		deal_type[0].setBounds(715,440,80,35);
		deal_type[1].setBounds(805,440,85,35);
		deal_type[2].setBounds(900,440,80,35);
		deal_number[0][0].setBounds(810,130,20,18);
		deal_number[0][1].setBounds(810,150,20,18);
		deal_number[0][2].setBounds(810,170,20,18);
		deal_number[0][3].setBounds(810,190,20,18);
		deal_number[0][4].setBounds(810,210,20,18);
		deal_number[1][0].setBounds(830,130,20,18);
		deal_number[1][1].setBounds(830,150,20,18);
		deal_number[1][2].setBounds(830,170,20,18);
		deal_number[1][3].setBounds(830,190,20,18);
		deal_number[1][4].setBounds(830,210,20,18);
		player[0].setBounds(702,380,70,30);
		player[1].setBounds(773,380,70,30);
		player[2].setBounds(844,380,70,30);
		player[3].setBounds(915,380,70,30);
		for(int i=0;i<2;i++)
		{
		ressource[i][0].setBounds(710,410,40,20);
		ressource[i][1].setBounds(765,410,40,20);
		ressource[i][2].setBounds(820,410,40,20);
		ressource[i][3].setBounds(875,410,40,20);
		ressource[i][4].setBounds(930,410,40,20);
		}
		bank_deal[0].setBounds(710,390,40,20);
		bank_deal[1].setBounds(765,390,40,20);
		bank_deal[2].setBounds(820,390,40,20);
		bank_deal[3].setBounds(875,390,40,20);
		bank_deal[4].setBounds(930,390,40,20);
		port_deal[0].setBounds(710,390,40,20);
		port_deal[1].setBounds(765,390,40,20);
		port_deal[2].setBounds(820,390,40,20);
		port_deal[3].setBounds(875,390,40,20);
		port_deal[4].setBounds(930,390,40,20);
		City.setBounds(850,520,115,30);
		build.setBounds(702,520,70,30);
		dice.setBounds(773,520,70,30);
		deal.setBounds(844,520,70,30);
		traverser.setBounds(915,520,70,30);
		head.setBounds(0,0,1000,50);
		next.setBounds(820,580,80,30);
		confirm.setBounds(810,580,90,30);
		confirm2.setBounds(810,580,90,30);
		confirm3.setBounds(810,580,90,30);
		confirm4.setBounds(810,580,90,30);
		confirm5.setBounds(810,580,90,30);
		draw.setBounds(830,360,40,20);
		exchange[0].setBounds(810,580,80,40);
		exchange[1].setBounds(810,580,80,40);
		exchange[2].setBounds(810,580,80,40);
		name.setBounds(760,300,180,40);
		changePlayer.setBounds(800,640,100,40);
		changePlayer2.setBounds(800,640,100,40);
		panel.setBounds(0,0,1000,750);;
		resource.setBounds(720,80,100,200);
		resource2.setBounds(860,80,100,200);
		info.setBounds(740,300,220,40);
		for(int i=0;i<4;i++){
			list_plans[i].map.setPreferredSize(new Dimension(700,700));
			list_plans[i].map.setBounds(0,50,700,700);
		}
		

		bar.add(game);
		frame.setJMenuBar(bar);
		panel.add(head);
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		


		frame.addWindowListener(new WindowAdapter()
		{
			public void windowClosing(WindowEvent e) 
			{
				String str = "Vous voulez terminer le jeu?";
			
				if (JOptionPane.showConfirmDialog(null, str, "Terminer le jeu?",JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION)
				{
					System.exit(0);
				}
			}
		});
	}
	

	public void setup() {
		list_players = new player[4];
		list_plans = new plan[4];
		for(int i=0;i<4;i++)
		{
			list_players[i] = new player();
			list_plans[i] = new plan(i);
			list_plans[0].echelle=4;
			for(int j=0;j<24;j++)	
			{
				list_plans[i].list_node[j] = new node(j,-1,-1);	
			}
			for(int n=0;n<30;n++)	
			{
				list_plans[i].list_edge[n] = new edge(n,-1);	
			}
		
			list_plans[i].list_condition[0] = new condition(0,true,0);
			list_plans[i].list_condition[1] = new condition(1,true,1);
			list_plans[i].list_condition[2] = new condition(2,true,2);
			list_plans[i].list_condition[3] = new condition(3,true,3);
			list_plans[i].list_condition[4] = new condition(4,true,4);
			list_plans[i].list_condition[5] = new condition(5,true,1);
			list_plans[i].list_condition[6] = new condition(6,false,5);	
			list_plans[i].map.setBounds(0,40,700,700);
		}

	
		creatGUI();
	}
	

	public void go() {
		panel.add(next);
		String openning[]= {"Saisir le nom de joueur 1 !",
							"Saisir le nom de joueur 2 !",
							"Saisir le nom de joueur 3 !",
							"Saisir le nom de joueur 4 !",
							"Le jeu commence !","",""};
		next.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
	    		if(step<4) {
	    			head.setText(openning[step]);
	    			panel.add(name);
	   				name.setText("Joueur "+ (step+1));
	    			panel.remove(next);
	    			panel.add(confirm);			
	    			panel.repaint();
	    			step++;
	   				if(step==5)next.setText("Allez");
	   			}
	    		else if(step==4) {
	    			head.setText(openning[step]);
	    			panel.remove(name);
	   				panel.repaint();
	   				step++;
	   				next.setText("Allez");
	    		}
	    		else if(step==5){
	    			panel.remove(next);
	    			head.setText("Bienvenue dans la 2015");
	    			frame.repaint();
	    			panel.repaint();
	    			step1();
	   			}
	   		}
	   	});
		confirm.addActionListener(new ActionListener() {
	   		public void actionPerformed(ActionEvent e) {
	   			list_players[step-1].set_name(name.getText());
	   			head.setText("Hello "+list_players[step-1].get_name()+" !");
	   			panel.remove(name);
    			panel.remove(confirm);
    			panel.add(next);
	    		panel.repaint();
	    	}		
	   	});
	}
		
	public void step1() {	//initial city
		playerID = 0;
		OpenWindow(list_players[0].get_po());
		info.setText("<html>"+list_players[0].get_name()+", Choisissez votre "+"<br>" +"premier convertisseur");
		panel.add(info);
		click();
		panel.add(City);
		panel.repaint();
		
		City.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e)	//��������
			{
				button=2;
				info.setText("Choisissez un point pour construire");
				click();
				panel.add(confirm3);
				panel.remove(City);
				panel.repaint();
				
				confirm3.addActionListener(new ActionListener() {
			   		public void actionPerformed(ActionEvent e) {
			   			if(info_return()=="Point"&&list_plans[list_players[playerID].get_po()].list_node[pos_return()].check_ocu()==-1) //������������������
						{ 
							list_plans[list_players[playerID].get_po()].list_node[pos_return()].set_ocu(playerID);
							list_plans[list_players[playerID].get_po()].list_node[pos_return()].set_type(button);
							list_players[playerID].initialcity=pos_return();
							info.setText("Le convertisseur a été construit !");
							list_plans[list_players[playerID].get_po()].info_selected=null;
							confirm3.removeActionListener(this);
				   			panel.remove(City);
				   			panel.remove(confirm3);
				   			panel.add(changePlayer2);
				   			panel.repaint();
						}
						else if(info_return()=="Point"&&list_plans[list_players[playerID].get_po()].list_node[pos_return()].check_ocu()!=-1) 
						{
							info.setText("Le point est occupé par " + 
							list_players[list_plans[list_players[playerID].get_po()].list_node[pos_return()].check_ocu()].get_name());
							list_plans[list_players[playerID].get_po()].info_selected=null;
							confirm3.removeActionListener(this);	
						}
						
			    	}		
			   	});
			}
		});
		
		changePlayer2.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e)
			{
				CloseWindow(list_players[playerID].get_po());	//������������
				if(playerID < 3) {
					playerID = playerID+1; // 
					info.setText("<html>"+list_players[playerID].get_name()+", Choisissez votre "+"<br>" +"premier convertisseur");
					panel.add(City);
					panel.remove(changePlayer2);
					panel.repaint();
					OpenWindow(list_players[playerID].get_po());	//������������
				}
				else {
					playerID = 0;
					changePlayer2.removeActionListener(this);
					City.removeActionListener(this);
					panel.remove(changePlayer2);
					panel.repaint();
					step2();
				}
			}
		});
	}
	
	public void step2() {
		resource.setText(list_players[playerID].show_resource(list_players[playerID].get_po()));
		info.setText("C'est le tour de "+list_players[playerID].get_name());
		for(int i=0;i<4;i++) {
			player[i].setText(""+ list_players[i].get_name());
		}
		main_screen();
	
		build.addActionListener(new ActionListener() {
	   		public void actionPerformed(ActionEvent e) {
	   			main_screen();
	   			panel.add(items2[0]);
	   			panel.add(items2[1]);
	   			panel.add(items2[2]);
	   			panel.add(items2[3]);
	   			info.setText( "Où vous voulez construire?");
	   			panel.repaint();
	   			
	   			items2[0].addActionListener(new ActionListener() 
	   			{
	   				public void actionPerformed(ActionEvent e)	
	   				{
	   					button=0;	
	   					info.setText("Choisissez un point pour construire");
	   					click();
	   					panel.add(confirm2);
	   					panel.repaint();
	   					
	   					confirm2.addActionListener(new ActionListener() {
	   				   		public void actionPerformed(ActionEvent e) {
	   				   			if(list_plans[list_players[playerID].get_po()].check_edgeocu1(pos_return(),playerID)==1&&button==0&&info_return()=="Road"&&list_plans[list_players[playerID].get_po()].list_edge[pos_return()].check_ocu()==-1&&(list_plans[list_players[playerID].get_po()].check_edgeocu(pos_return())==0)) //������������������
	   							{
	   				   				if(list_players[playerID].get_resource(0)>=1 && list_players[playerID].get_resource(1)>=1)
	   				   				{
	   				   					list_plans[list_players[playerID].get_po()].list_edge[pos_return()].set_ocu(playerID);
	   				   					info.setText("Le tunnel temporel a été construit !");
	   				   					list_plans[list_players[playerID].get_po()].info_selected=null;
	   				   					confirm2.removeActionListener(this);
	   				   					list_players[playerID].lose_resource(0, 1);
	   				   					list_players[playerID].lose_resource(1, 1);
	   				   					resource.setText(list_players[playerID].show_resource(list_players[playerID].get_po()));
	   				   					panel.remove(items2[0]);
	   				   					panel.remove(items2[1]);
	   				   					panel.remove(items2[2]);
	   				   					panel.remove(items2[3]);
	   				   					panel.remove(dice);
	   				   					panel.remove(build);
	   				   					panel.remove(deal);
	   					   				panel.remove(traverser);
	   					   				panel.remove(confirm2);
	   					   				panel.add(changePlayer);
	   					   				panel.repaint();
	   				   				}
	   				   				else {
	   				   					info.setText("Vous n'avez pas assez de ressource.");
	   				   				}
	   							}
	   				   			else if(list_plans[list_players[playerID].get_po()].check_edgeocu1(pos_return(),playerID)==0)
	   				   			{
	   				   			info.setText("<html>"+ "Vous n'avez pas de Delorean"+"<br>"+" ou convertisseur à côté.");
	   				   		    list_plans[list_players[playerID].get_po()].info_selected=null;
	   				   		    confirm2.removeActionListener(this);
	   				   			}
	   							else if(info_return()=="Road"&&list_plans[list_players[playerID].get_po()].list_edge[pos_return()].check_ocu()!=-1)
	   							{
	   								info.setText("Ce tunnel est occupé par " + 
	   								list_players[list_plans[list_players[playerID].get_po()].list_edge[pos_return()].check_ocu()].get_name());
	   								list_plans[list_players[playerID].get_po()].info_selected=null;
	   								confirm2.removeActionListener(this);
	   							}
	   							else if(list_plans[list_players[playerID].get_po()].check_edgeocu(pos_return())==1) {
	   								info.setText("<html>"+ "Les deux points à côté sont"+"<br>"+ " déjà occupés." );
	   								list_plans[list_players[playerID].get_po()].info_selected=null;
	   								confirm2.removeActionListener(this);	
	   							}
	   				    	}		
	   				   	});
	   				}
	   			});
	   			
	   			items2[1].addActionListener(new ActionListener() 
	   			{
	   				public void actionPerformed(ActionEvent e)	//��������
	   				{
	   					button=1;	
	   					info.setText("Choisissez un point pour construire");
	   					click();
	   					panel.add(confirm2);
	   					panel.repaint();
	   					
	   					confirm2.addActionListener(new ActionListener() {
	   				   		public void actionPerformed(ActionEvent e) {
	   				   			if(button==1&&info_return()=="Point"&&list_plans[list_players[playerID].get_po()].list_node[pos_return()].check_ocu()==-1&&(list_plans[list_players[playerID].get_po()].check_nodeocu(pos_return())==0)) //������������������
	   							{ 
	   				   				if(list_players[playerID].get_resource(0)>=1 && list_players[playerID].get_resource(1)>=1 && list_players[playerID].get_resource(2)>=1) {
	   				   					list_plans[list_players[playerID].get_po()].list_node[pos_return()].set_ocu(playerID);
	   				   					list_plans[list_players[playerID].get_po()].list_node[pos_return()].set_type(button);	//button=1, ����
	   				   					list_players[playerID].add_score(1); 	//������
	   				   					info.setText("Le Delorean a été construit !");
	   				   					list_plans[list_players[playerID].get_po()].info_selected=null;
	   				   					confirm2.removeActionListener(this);
	   				   					list_players[playerID].lose_resource(0, 1);
	   				   					list_players[playerID].lose_resource(1, 1);
	   				   					list_players[playerID].lose_resource(2, 1);
	   				   					resource.setText(list_players[playerID].show_resource(list_players[playerID].get_po()));
	   				   					panel.remove(items2[0]);
	   				   					panel.remove(items2[1]);
	   				   					panel.remove(items2[2]);
	   				   					panel.remove(items2[3]);
	   				   					panel.remove(confirm2);
	   				   					panel.remove(dice);
	   				   					panel.remove(build);
	   				   					panel.remove(deal);
	   				   					panel.remove(traverser);
	   				   					panel.add(changePlayer);
	   				   					check_winner();
	   				   					if(winner !=-1) {
	   				   						panel.removeAll();
	   				   						panel.add(head);
	   				   						head.setText(list_players[winner].name + " gagne le jeu!");
	   				   						panel.repaint();
	   				   					}
	   				   					panel.repaint();
	   				   				}
	   				   				else {
	   				   					info.setText("Vous n'avez pas assez de ressource.");
	   				   				}
	   							}
	   							else if(info_return()=="Point"&&list_plans[list_players[playerID].get_po()].list_node[pos_return()].check_ocu()!=-1) 
	   							{
	   								info.setText("Ce point est occupé par " + 
	   								list_players[list_plans[list_players[playerID].get_po()].list_node[pos_return()].check_ocu()].get_name());
	   								list_plans[list_players[playerID].get_po()].info_selected=null;
	   								confirm2.removeActionListener(this);
	   							}
	   							else if(list_plans[list_players[playerID].get_po()].check_nodeocu(pos_return())==1) {
	   								info.setText("<html>"+ "Ce point est déjà connecté"+"<br>"+ " avec un autre point." );
	   								list_plans[list_players[playerID].get_po()].info_selected=null;
	   								confirm3.removeActionListener(this);	
	   							}
	   				    	}		
	   				   	});
	   				}
	   			});
	   			
	   			items2[2].addActionListener(new ActionListener() 
	   			{
	   				public void actionPerformed(ActionEvent e)	//��������
	   				{
	   					button=2;
	   					info.setText("Choisissez un point pour construire");
	   					click();
	   					panel.add(confirm2);
	   					panel.repaint();
	   					
	   					confirm2.addActionListener(new ActionListener() {
	   				   		public void actionPerformed(ActionEvent e) {
	   				   			if(button==2&&info_return()=="Point"&&list_plans[list_players[playerID].get_po()].list_node[pos_return()].check_ocu()==-1&&(list_plans[list_players[playerID].get_po()].check_nodeocu(pos_return())==0)) //������������������
	   							{ 
	   				   				if(list_players[playerID].get_resource(1)>=2 && list_players[playerID].get_resource(3)>=1 && list_players[playerID].get_resource(4)>=1) {
	   				   					list_plans[list_players[playerID].get_po()].list_node[pos_return()].set_ocu(playerID);
	   				   					list_plans[list_players[playerID].get_po()].list_node[pos_return()].set_type(button);
	   				   					list_players[playerID].add_score(2); 	//������
	   				   					info.setText("Le convertisseur a été construit !");
	   				   					list_plans[list_players[playerID].get_po()].info_selected=null;
	   				   					confirm2.removeActionListener(this);
	   				   					list_players[playerID].lose_resource(1, 2);
	   				   					list_players[playerID].lose_resource(3, 1);
	   				   					list_players[playerID].lose_resource(4, 1);
	   				   					resource.setText(list_players[playerID].show_resource(list_players[playerID].get_po()));
	   				   					panel.remove(items2[0]);
	   				   					panel.remove(items2[1]);
	   				   					panel.remove(items2[2]);
	   				   					panel.remove(items2[3]);
	   				   					panel.remove(confirm2);
	   				   					panel.remove(dice);
	   				   					panel.remove(build);
	   				   					panel.remove(deal);
	   				   					panel.remove(traverser);
	   				   					panel.add(changePlayer);
	   				   					check_winner();
	   				   					if(winner !=-1) {
	   				   						panel.removeAll();
	   				   						panel.add(head);
	   				   						head.setText(list_players[winner].name + " gagne le jeu !");
	   				   						panel.repaint();
	   				   					}
	   				   					panel.repaint();
	   				   				}
	   				   				else {
	   				   					info.setText("Vous n'avez pas assez de ressource.");
	   				   				}
	   							}
	   							else if(info_return()=="Point"&&list_plans[list_players[playerID].get_po()].list_node[pos_return()].check_ocu()!=-1) 
	   							{
	   								info.setText("Ce point est occupé par " + 
	   								list_players[list_plans[list_players[playerID].get_po()].list_node[pos_return()].check_ocu()].get_name());
	   								list_plans[list_players[playerID].get_po()].info_selected=null;
	   								confirm2.removeActionListener(this);	
	   							}
	   							else if(list_plans[list_players[playerID].get_po()].check_nodeocu(pos_return())==1) {
	   								info.setText("<html>"+ "Ce point est déjà connecté"+"<br>"+ " avec un autre point." );
	   								list_plans[list_players[playerID].get_po()].info_selected=null;
	   								confirm3.removeActionListener(this);	
	   							}
	   				    	}		
	   				   	});
	   				}
	   			});
	   			
	   			items2[3].addActionListener(new ActionListener() {
	   		   		public void actionPerformed(ActionEvent e) {
	   		   			info.setText("Tirez une carte développée");
	   		   			for(int i=0;i<4;i++) {
	   		   				panel.remove(items2[i]);
	   		   			}
	   		   			counter=1;
	   		   			panel.add(draw);
	   		   			panel.repaint();
	   		   			
	   		   			draw.addActionListener(new ActionListener() {
	   		   				public void actionPerformed(ActionEvent e) {
	   		   					
	   		   					if((list_players[playerID].get_resource(0)<1 && counter == 1)|| (list_players[playerID].get_resource(1)<2 && counter == 1)){
	   		   						info.setText("Vous n'avez pas assez de ressource.");
	   		   						counter = 0;
	   		   					}
	   		   					
	   		   					else if(list_players[playerID].get_resource(0)>=1 && list_players[playerID].get_resource(1)>=2 && counter == 1) {
		   							resource.setText(list_players[playerID].show_resource(list_players[playerID].get_po()));
		   							panel.repaint();
		   							
	   		   						int random = (int)(1+Math.random()*(10-1+1));
	   		   						if(random == 1 && counter ==1) {
	   		   							info.setText("You got a wonder(score+1)");
	   		   							list_players[playerID].add_score(1);
	   		   							panel.remove(draw);
	   		   							counter = 0;
	   		   							list_players[playerID].lose_resource(0, 1);
	   		   							list_players[playerID].lose_resource(1, 2);
	   		   							panel.removeAll();
	   		   							panel.add(resource);
	   		   							panel.add(info);
	   		   							panel.add(head);
	   		   							panel.add(changePlayer);
	   		   							OpenWindow(list_players[playerID].get_po());
	   		   							resource.setText(list_players[playerID].show_resource(list_players[playerID].get_po()));
	   		   							panel.repaint();
	   		   						}
	   		   						else if(random>=2 && random<=5 && counter ==1) {
	   		   							info.setText("<html>"+ "Vous pouvez construire un"+"<br>"+ " tunnel gratuitement");
	   		   							button=0;
	   		   							panel.removeAll();
	   		   							panel.add(resource);
	   		   							panel.add(info);
	   		   							panel.add(head);
	   		   							OpenWindow(list_players[playerID].get_po());
	   		   							click();
	   		   							panel.add(confirm2);
	   		   							counter = 0;
	   		   							list_players[playerID].lose_resource(0, 1);
	   		   							list_players[playerID].lose_resource(1, 2);
	   		   							resource.setText(list_players[playerID].show_resource(list_players[playerID].get_po()));
	   		   							panel.repaint();
	   		   							
	   		   							confirm2.addActionListener(new ActionListener() {
	   		   								public void actionPerformed(ActionEvent e) {
	   		   									if(button==0&&info_return()=="Road"&&list_plans[list_players[playerID].get_po()].list_edge[pos_return()].check_ocu()==-1&&(list_plans[list_players[playerID].get_po()].check_edgeocu(pos_return())==0)) //������������������
	   		   									{
	   		   										list_plans[list_players[playerID].get_po()].list_edge[pos_return()].set_ocu(playerID);
	   		   										info.setText("Le tunnel temporel a été construit !");
	   		   										resource.setText(list_players[playerID].show_resource(list_players[playerID].get_po()));
	   		   										list_plans[list_players[playerID].get_po()].info_selected=null;
	   		   										confirm2.removeActionListener(this);
	   		   										panel.remove(items2[0]);
	   		   										panel.remove(items2[1]);
	   		   										panel.remove(items2[2]);
	   		   										panel.remove(dice);
	   		   										panel.remove(build);
	   		   										panel.remove(deal);
	   		   										panel.remove(traverser);
	   		   										panel.remove(confirm2);
	   		   										panel.add(changePlayer);
	   		   										panel.repaint();
	   		   									}	
	   		   									else if(info_return()=="Road"&&list_plans[list_players[playerID].get_po()].list_edge[pos_return()].check_ocu()!=-1)
	   		   									{
	   		   										info.setText("Le tunnel est occupé par " + 
	   		   										list_players[list_plans[list_players[playerID].get_po()].list_edge[pos_return()].check_ocu()].get_name());
	   		   										list_plans[list_players[playerID].get_po()].info_selected=null;
	   		   										confirm2.removeActionListener(this);
	   		   									}
	   		   									else if(list_plans[list_players[playerID].get_po()].check_edgeocu(pos_return())==1) {
	   		   										info.setText("<html>"+ "Les deux points à côté"+"<br>"+ " sont déjà occupés." );
	   		   										list_plans[list_players[playerID].get_po()].info_selected=null;
	   		   										confirm3.removeActionListener(this);	
	   		   									}
	   		   								}		
	   		   							});

	   		   						}
	   		   						else if(random>=6 && random<=10 && counter ==1) {
	   		   							info.setText("Vous pouvez déplacer le Biff");
	   		   							panel.removeAll();
	   		   							panel.add(resource);
	   		   							panel.add(info);
	   		   							panel.add(head);
	   		   							OpenWindow(list_players[playerID].get_po());
	   		   							click();
	   		   							panel.add(confirm5);
	   		   							counter = 0;
	   		   							list_players[playerID].lose_resource(0, 1);
	   		   							list_players[playerID].lose_resource(1, 2);
	   		   							resource.setText(list_players[playerID].show_resource(list_players[playerID].get_po()));
	   		   							panel.repaint();
	   		   							
	   		   							confirm5.addActionListener(new ActionListener() {
	   		   								public void actionPerformed(ActionEvent e) {
	   		   									if(info_return() == "Erea") {
	   		   										list_plans[list_players[playerID].get_po()].move_thief(pos_return());
	   		   										info.setText("<html>"+"Vous avez déplacé le Biff"+"<br>"+" en hexagone "+(list_plans[list_players[playerID].get_po()].check_thief_po()+1)+"</html>");
	   		   										list_plans[list_players[playerID].get_po()].info_selected=null;	
	   		   										panel.removeAll();
	   		   										panel.add(resource);
	   		   										panel.add(info);
	   		   										panel.add(head);
	   		   										panel.add(changePlayer);
	   		   										OpenWindow(list_players[playerID].get_po());
	   		   										panel.repaint();
	   		   									}	
	   		   								}		
	   		   							});
	   		   						}	
	   		   					}
	   		   				}		
	   		   			});
	   		   			
	   		  
	   		    	}		
	   		   	});
	   			
	    	}		
	   	});
		
		dice.addActionListener(new ActionListener() {
	   		public void actionPerformed(ActionEvent e) {
	   			main_screen();
	   			number = dice();
	   			info.setText("Vous avez un dé " + number);
	   			if(number-1<6){
	   				check_dice(number);
	   				panel.remove(dice);
		   			panel.remove(build);
		   			panel.remove(deal);
		   			panel.remove(traverser);
		   			resource.setText(list_players[playerID].show_resource(list_players[playerID].get_po()));
		   			panel.add(changePlayer);
		   			panel.repaint();
	   			}
	   			else if(number-1 == 6) {
	   				info.setText("Vous avez un 7. Déplacez le Biff ");
	   				panel.remove(dice);
	   				panel.remove(build);
	   				panel.remove(deal);
	   				panel.remove(traverser);
	   				click();
	   				panel.add(confirm4);
	   				panel.repaint();
	   			}
	   			
	   			confirm4.addActionListener(new ActionListener() {
	   		   		public void actionPerformed(ActionEvent e) {
							if(info_return() == "Erea") {
	   		   				list_plans[list_players[playerID].get_po()].move_thief(pos_return());
	   		   				info.setText("<html>"+"Vous avez déplacé le Biff "+"<br>"+"en hexagone "+(list_plans[list_players[playerID].get_po()].check_thief_po()+1));
	   		   				list_plans[list_players[playerID].get_po()].info_selected=null;
	   		   				turn_over();
	   		   			}
	   		    	}		
	   		   	});
	    	}		
	   	});
		
		deal.addActionListener(new ActionListener() {
	   		public void actionPerformed(ActionEvent e) {
	   			main_screen();
	   			info.setText("Quel type de commerce vous voulez");
	   			panel.add(deal_type[0]);
	   			panel.add(deal_type[1]);
	   			panel.add(deal_type[2]);
	   			panel.repaint();
	   			
	   			deal_type[0].addActionListener(new ActionListener() {
			   		public void actionPerformed(ActionEvent e) {
			   			info.setText("Avec quel joueur ?");
			   			panel.remove(deal_type[0]);
			   			panel.remove(deal_type[1]);
			   			panel.remove(deal_type[2]);
			   			panel.add(player[0]);
			   			panel.add(player[1]);
			   			panel.add(player[2]);
			   			panel.add(player[3]);
			   			counter = 1;
			   			panel.repaint();
			   			
			   			for(int i=0;i<4;i++) {
			   				int id = i;
			   				player[id].addActionListener(new ActionListener() {
			   					public void actionPerformed(ActionEvent e) {
			   						if(list_players[playerID].get_po()!=list_players[id].get_po()) {
			   							info.setText("Vous n'êtes pas dans la même époque.");
			   						}
			   						else if(playerID == id) {
			   							info.setText("<html>"+"Vous pouvez pas échanger"+"<br>"+" avec vous-même.");
			   						}	
			   						else {
			   							for(int m=0;m<2;m++) {
			   								for(int j=0;j<5;j++) {
			   									deal_number[m][j].setText("0");;
			   								}	
			   							}
			   							info.setText("Saisissez les nombres du commerce");
			   							resource2.setText(list_players[id].show_resource(list_players[playerID].get_po()));
			   							panel.add(resource2);
			   							for(int n=0;n<2;n++) {
			   								for(int m=0;m<5;m++) {
			   									panel.add(deal_number[n][m]);	
			   								}
			   							}	
			   							id_selected = id;
			   							panel.add(exchange[0]);
			   							panel.repaint();
			   						}
			   					}
			   				});   			
			   			}
			   			
			   			exchange[0].addActionListener(new ActionListener() {
			   				public void actionPerformed(ActionEvent e) {
			   					enough = 1;
		  						for(int m=0;m<5;m++) {
		  							if(!list_players[playerID].enough(m, Integer.parseInt(deal_number[0][m].getText()))&&counter==1){ 
		   								info.setText("Pas de assez de ressource");
		   								panel.repaint();
		   								enough = 0;
		   							}
		   							if(!list_players[id_selected].enough(m, Integer.parseInt(deal_number[1][m].getText()))&&counter==1) { 
		   								info.setText("Pas de assez de ressource");
		   								panel.repaint();
		   								enough = 0;
			   						}
			   					}
			   					if(enough == 1 && counter == 1) {
			   						for(int r=0;r<5;r++){
			   							list_players[playerID].add_resource(r, Integer.parseInt(deal_number[1][r].getText()));
			   							list_players[playerID].lose_resource(r, Integer.parseInt(deal_number[0][r].getText()));
			   							list_players[id_selected].add_resource(r, Integer.parseInt(deal_number[0][r].getText()));
		 								list_players[id_selected].lose_resource(r, Integer.parseInt(deal_number[1][r].getText()));
		  							}
		   							info.setText("Transaction avec succès !");
		   							main_screen();
		   							panel.add(resource2);
		   							resource.setText(list_players[playerID].show_resource(list_players[playerID].get_po()));
		   							resource2.setText(list_players[id_selected].show_resource(list_players[id_selected].get_po()));	
		   							counter = 0;
		   							exchange[0].removeActionListener(this);
			   						panel.repaint();
			   					}
			   				}		
			   			});
			   		}
			   	});	
	   			
	   			deal_type[1].addActionListener(new ActionListener() {
			   		public void actionPerformed(ActionEvent e) {
			   			info.setText("Quel type de ressource vous voulez");
			   			panel.remove(deal_type[0]);
			   			panel.remove(deal_type[1]);
			   			panel.remove(deal_type[2]);
			   			panel.add(ressource[0][0]);
			   			panel.add(ressource[0][1]);
			   			panel.add(ressource[0][2]);
			   			panel.add(ressource[0][3]);
			   			panel.add(ressource[0][4]);
   						counter = 1;
			   			panel.repaint();
			   			
			   			for(int i=0;i<5;i++) {
			   				int id = i;
			   				ressource[0][id].addActionListener(new ActionListener() {
			   					public void actionPerformed(ActionEvent e) {
			   						type_voulu=id;
			   						info.setText("<html>"+ "Choissiez un type de ressource"+"<br>"+" pour échanger"+"("+list_plans[list_players[playerID].get_po()].echelle+":1)");
			   						for(int j=0;j<5;j++) {
			   							panel.add(bank_deal[j]);
			   							panel.remove(ressource[0][j]);
			   						}
			   						ressource[0][id].removeActionListener(this);
			   						panel.repaint();	
			   					}
			   				});   
			   				
			   				bank_deal[id].addActionListener(new ActionListener() {
			   					public void actionPerformed(ActionEvent e) {	
			   						enough = 1;
			   						if(!list_players[playerID].enough(id,list_plans[list_players[playerID].get_po()].echelle)&&counter==1)  {
			   							info.setText("Vous n'avez pas au moins "+list_plans[list_players[playerID].get_po()].echelle+" ressource "+(id+1));
			   							enough = 0;
			   						}
			   						if(enough == 1 && counter == 1){
			   							list_players[playerID].lose_resource(id, list_plans[list_players[playerID].get_po()].echelle);
			   							list_players[playerID].add_resource(type_voulu, 1);
			   							counter = 0;
			   							info.setText("Transaction avec succès");
			   							main_screen();
			   							resource.setText(list_players[playerID].show_resource(list_players[playerID].get_po()));
			   							bank_deal[id].removeActionListener(this);
			   							panel.repaint();
			   						}
			   					}
			   				});   
			   				
			   			}
			   		}
			   	});	
	   			
	   			deal_type[2].addActionListener(new ActionListener() {
			   		public void actionPerformed(ActionEvent e) {
			   			info.setText("Quel type de ressource vous voulez");
			   			panel.remove(deal_type[0]);
			   			panel.remove(deal_type[1]);
			   			panel.remove(deal_type[2]);
			   			panel.add(ressource[1][0]);
			   			panel.add(ressource[1][1]);
			   			panel.add(ressource[1][2]);
			   			panel.add(ressource[1][3]);
			   			panel.add(ressource[1][4]);
   						counter = 1;
			   			panel.repaint();
			   			
			   			for(int i=0;i<5;i++) {
			   				int id = i;
			   				ressource[1][id].addActionListener(new ActionListener() {
			   					public void actionPerformed(ActionEvent e) {
			   						type_voulu=id;
			   						info.setText("<html>"+ "Choisir un type de ressouce "+"<br>"+"pour échanger(3:1)");
			   						for(int j=0;j<5;j++) {
			   							panel.add(port_deal[j]);
			   							panel.remove(ressource[1][j]);
			   						}
			   						ressource[1][id].removeActionListener(this);
			   						panel.repaint();	
			   					}
			   				});  
			   				
			   				port_deal[id].addActionListener(new ActionListener() {
			   					public void actionPerformed(ActionEvent e) {
			   						enough = 1;
			   						if(id==0&&counter==1) {
			   							if(list_plans[list_players[playerID].get_po()].list_node[0].check_ocu()!=playerID) {
			   								info.setText("Vous n'avez pas le même type du port");
			   								panel.repaint();
			   							}
			   							else {
			   								if(!list_players[playerID].enough(id,3))  {
					   							info.setText("Vous n'avez pas au moins 3 "+ "ressource "+(id+1));
					   							enough = 0;
					   						}
					   						if(enough == 1){
					   							list_players[playerID].lose_resource(id, 3);
					   							list_players[playerID].add_resource(type_voulu, 1);
					   							counter = 0;
					   							info.setText("Transaction avec succès");
					   							resource.setText(list_players[playerID].show_resource(list_players[playerID].get_po()));
					   							port_deal[id].removeActionListener(this);
					   							main_screen();
					   						}
			   							}
			   						}
			   						else if(id==1&&counter==1) {
			   							if((list_plans[list_players[playerID].get_po()].list_node[4].check_ocu()!=playerID&&list_plans[list_players[playerID].get_po()].list_node[23].check_ocu()!=playerID)) {
			   								info.setText("Vous n'avez pas le même type du port");
			   								panel.repaint();
			   							}
			   							else {
			   								if(!list_players[playerID].enough(id,3))  {
					   							info.setText("Vous n'avez pas au moins 3 "+ "ressource "+(id+1));
					   							enough = 0;
					   						}
					   						if(enough == 1){
					   							list_players[playerID].lose_resource(id, 3);
					   							list_players[playerID].add_resource(type_voulu, 1);
					   							counter = 0;
					   							info.setText("Transaction avec succès");
					   							resource.setText(list_players[playerID].show_resource(list_players[playerID].get_po()));
					   							port_deal[id].removeActionListener(this);
					   							main_screen();
					   						}
			   							}
			   						}
			   						else if(id==2&&counter==1) {
			   							if(list_plans[list_players[playerID].get_po()].list_node[8].check_ocu()!=playerID) {
			   								info.setText("Vous n'avez pas le même type du port");
			   								panel.repaint();
			   							}
			   							else {
			   								if(!list_players[playerID].enough(id,3))  {
					   							info.setText("Vous n'avez pas au moins 3 "+ "ressource "+(id+1));
					   							enough = 0;
					   						}
					   						if(enough == 1){
					   							list_players[playerID].lose_resource(id, 3);
					   							list_players[playerID].add_resource(type_voulu, 1);
					   							counter = 0;
					   							info.setText("Transaction avec succès");
					   							resource.setText(list_players[playerID].show_resource(list_players[playerID].get_po()));
					   							port_deal[id].removeActionListener(this);
					   							main_screen();
					   						}
			   							}
			   						}
			   						else if(id==3&&counter==1) {
			   							if(list_plans[list_players[playerID].get_po()].list_node[15].check_ocu()!=playerID) {
			   								info.setText("Vous n'avez pas le même type du port");
			   								panel.repaint();
			   							}
			   							else {
			   								if(!list_players[playerID].enough(id,3))  {
					   							info.setText("Vous n'avez pas au moins 3 "+ "ressource "+(id+1));
					   							enough = 0;
					   						}
					   						if(enough == 1){
					   							list_players[playerID].lose_resource(id, 3);
					   							list_players[playerID].add_resource(type_voulu, 1);
					   							counter = 0;
					   							info.setText("Transaction avec succès");
					   							resource.setText(list_players[playerID].show_resource(list_players[playerID].get_po()));
					   							port_deal[id].removeActionListener(this);
					   							main_screen();
					   						}
			   							}
			   						}
			   						else if(id==4&&counter==1) {
			   							if(list_plans[list_players[playerID].get_po()].list_node[19].check_ocu()!=playerID) {
			   								info.setText("Vous n'avez pas le même type du port");
			   								panel.repaint();
			   							}
			   							else {
			   								if(!list_players[playerID].enough(id,3)) {
					   							info.setText("Vous n'avez pas au moins 3 "+ "ressource "+(id+1));
					   							enough = 0;
					   						}
					   						if(enough == 1){
					   							list_players[playerID].lose_resource(id, 3);
					   							list_players[playerID].add_resource(type_voulu, 1);
					   							counter = 0;
					   							info.setText("Transaction avec succès");
					   							resource.setText(list_players[playerID].show_resource(list_players[playerID].get_po()));
					   							port_deal[id].removeActionListener(this);
					   							main_screen();
					   						}
			   							}
			   						}
			   					}
			   				});   	
			   			}
			   			
			   		}
			   	});	 			
	    	}		
	   	});	
		
		traverser.addActionListener(new ActionListener() {
	   		public void actionPerformed(ActionEvent e) {
	   			if(check_city()<2)info.setText("<html>"+"Vous avez seulement"+"<br>"+" un convertisseur");
	   			else {
	   				CloseWindow(list_players[playerID].get_po());
	   				if(list_players[playerID].get_po()==0) {
	   					list_players[playerID].set_po(list_players[playerID].get_po()+1);
	   				}
	   				else{
	   					list_players[playerID].set_po(0);
	   				}
	   				OpenWindow(list_players[playerID].get_po());
	   				info.setText("Vous êtes allé dans le plateau "+(list_plans[list_players[playerID].get_po()].id+1));
	   				list_plans[list_players[playerID].get_po()].list_node[list_players[playerID].initialcity].set_ocu(playerID);
	   				list_plans[list_players[playerID].get_po()].list_node[list_players[playerID].initialcity].set_type(2);
		   			panel.remove(dice);
		   			panel.remove(build);
		   			panel.remove(deal);
		   			panel.remove(traverser);
		   			panel.add(changePlayer);
		   			resource.setText(list_players[playerID].show_resource(list_players[playerID].get_po()));
		   			panel.repaint();
	   			}
	   				
	   		}
		});
		
		changePlayer.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e)
			{
				CloseWindow(list_players[playerID].get_po());	//������������
				if(playerID < 3)
					playerID = playerID+1; // ������������������
				else
					playerID = 0;
				info.setText("C'est le tour de "+list_players[playerID].get_name());
				resource.setText(list_players[playerID].show_resource(list_players[playerID].get_po()));
				main_screen();
			}
		});
	}
	
	public void CloseWindow(int i) {
		panel.remove(list_plans[i].map);
	}
	
	public void OpenWindow(int i) {
		panel.add(list_plans[i].map);
		if(i==0) {head.setText("C'est l'année 1985");}
		if(i==1) {head.setText("C'est l'année 1905");}
		if(i==2) {head.setText("C'est l'année 1965");}
		if(i==3) {head.setText("C'est l'année 2015");}
		panel.repaint();
	}
	
	public void click() {		//��������������������������������������
		list_plans[list_players[playerID].get_po()].click();
	}
	
	public String info_return() {
		return list_plans[list_players[playerID].get_po()].info_selected;
	}
	
	public int pos_return() {
		return list_plans[list_players[playerID].get_po()].Pos;
	}
	
	public int dice() {	//������
		int dice = (int)(1+Math.random()*(100-1+1));
		if(dice>0 && dice<=15) {
			return (int)1;
		}
		else if(dice>15 && dice<=25) {
			return (int)2;
		}
		else if(dice>25 && dice<=40) {
			return (int)3;
		}
		else if(dice>40 && dice<=55) {
			return (int)4;
		}
		else if(dice>55 && dice<=70) {
			return (int)5;
		}
		else if(dice>70 && dice<=80) {
			return (int)6;
		}
		else if(dice>80 && dice<=100) {
			return (int)7;
		}
		else {
			return (int)0;
		}
	}
	
	public void check_dice(int dice){	//��������������������������
		if(dice-1!=6) {	//������������
			for(int i=0;i<4;i++) {	//������������
				if(list_players[i].get_po() == list_players[playerID].get_po()) {	//������������������������������������������
					list_players[i].add_resource(list_plans[list_players[playerID].get_po()].list_condition[dice-1].get_type(), list_plans[list_players[playerID].get_po()].check_area(dice-1, i));
				}
			}
		}
		else if(dice-1 == 6) {	//��������
			
		}
	}
	
	public void check_winner() {
		for(int i=0;i<4;i++) {	//��������
			if(list_players[i].get_score()>=6) {
				winner = i;
			}
		}
	}
	
	public void check_echelle(plan p,player[] play) {
		int num=0;
		for(int i=0;i<4;i++) {
			if(p.id==play[i].get_po())num++;
		}
		if(num>p.echelle)p.echelle=num;
	}
	
	public int check_city() {
	   int num=0;
	   for(int i=0;i<24;i++) {
		   if((list_plans[list_players[playerID].get_po()].list_node[i].get_type()==2)&&(list_plans[list_players[playerID].get_po()].list_node[i].check_ocu()==playerID))
			   num++;
	   }
	   return num;
   }
	
	public void main_screen() {
		panel.removeAll();
		panel.add(resource);
		panel.add(head);
		panel.add(info);
		panel.add(build);
		panel.add(dice);
		panel.add(deal);
		panel.add(traverser);
		OpenWindow(list_players[playerID].get_po());
		panel.repaint();
	}
	
	public void turn_over() {
		panel.removeAll();
		panel.add(resource);
		panel.add(info);
		panel.add(head);
		panel.add(changePlayer);
		OpenWindow(list_players[playerID].get_po());
		panel.repaint();
	}
	
}

