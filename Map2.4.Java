package com.Gatane;


import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
 

public class FiveChessGame 
{
	// * 控件属性
	private JFrame frame; // 五子棋游戏的窗口框架
	private GameMap map; // 五子棋游戏的窗口容器
	private JMenuBar bar; // 菜单
	private JMenu game; // 菜单项
	private JMenuItem[] items; // 菜单下拉项
 

	// * 静态数据属性
	//private static final int length = 115; //六边形边长
	//private static final int interval = 100;//六边形边长除以根号3再乘2
	private static final int nodes[][] = new int[24][2];//每个顶点的坐标
	private static final int edges[][] = new int[30][4];//每条边的坐标
	private static final int centers[][] = new int[7][2];//每个中心点的坐标
	
	//确认每个顶点的坐标
	{
		nodes[0][0] = 250;
		nodes[0][1] = 100;
		
		nodes[1][0] = 450;
		nodes[1][1] = 100;
		
		nodes[2][0] = 150;
		nodes[2][1] = 158;
		
		nodes[3][0] = 350;
		nodes[3][1] = 158;
		
		nodes[4][0] = 550;
		nodes[4][1] = 158;
		
		nodes[5][0] = 150;
		nodes[5][1] = 273;
		
		nodes[6][0] = 350;
		nodes[6][1] = 273;
		
		nodes[7][0] = 550;
		nodes[7][1] = 273;
		
		nodes[8][0] = 50;
		nodes[8][1] = 330;
		
		nodes[9][0] = 250;
		nodes[9][1] = 330;
		
		nodes[10][0] = 450;
		nodes[10][1] = 330;
		
		nodes[11][0] = 650;
		nodes[11][1] = 330;
		
		nodes[12][0] = 50;
		nodes[12][1] = 446;
		
		nodes[13][0] = 250;
		nodes[13][1] = 446;
		
		nodes[14][0] = 450;
		nodes[14][1] = 446;
		
		nodes[15][0] = 650;
		nodes[15][1] = 446;
		
		nodes[16][0] = 150;
		nodes[16][1] = 504;
		
		nodes[17][0] = 350;
		nodes[17][1] = 504;
		
		nodes[18][0] = 550;
		nodes[18][1] = 504;
		
		nodes[19][0] = 150;
		nodes[19][1] = 619;
		
		nodes[20][0] = 350;
		nodes[20][1] = 619;
		
		nodes[21][0] = 550;
		nodes[21][1] = 619;
		
		nodes[22][0] = 250;
		nodes[22][1] = 677;
		
		nodes[23][0] = 450;
		nodes[23][1] = 677;
	}
	
	//确认每条边的坐标
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
	
	//确认每个中心点的坐标
	{
		centers[0][0] = 250;
		centers[0][1] = 216;
		
		centers[1][0] = 450;
		centers[1][1] = 216;
		
		centers[2][0] = 150;
		centers[2][1] = 388;
		
		centers[3][0] = 350;
		centers[3][1] = 388;
		
		centers[4][0] = 550;
		centers[4][1] = 388;
		
		centers[5][0] = 250;
		centers[5][1] = 562;
		
		centers[6][0] = 450;
		centers[6][1] = 562;
	}
	
	
	//* 数据属性
	private int playerID ; // true黑,false白
	private int list_nodes[] = new int [24];
	private int list_edges[] = new int [30];
	private int list_centers[] = new int [7];
 
	public FiveChessGame() 
	{
		playerID = 1; // 游戏玩家一开始
		clearMap();
		createGUI();
	}
 
	 //* 对GUI控件的创建
	private void createGUI() 
	{
		frame = new JFrame("Gatane"); // 实现五子棋游戏窗口框架
		map = new GameMap(); // 实现五子棋游戏窗口容器
		bar = new JMenuBar(); // 建立菜单栏
		game = new JMenu("游戏"); // 建立名为“游戏”的菜单
		items = new JMenuItem[2]; // game菜单下创建2个子菜单项
		game.add(items[0] = new JMenuItem("重新开始"));// 第一个子菜单为“重新开始”
		game.add(items[1] = new JMenuItem("退出")); // 第二个子菜单为“退出”
	}
 
	 //* 清空地图
	protected void clearMap()
	{
		for(int i=0;i<24;i++)
		{
			list_nodes[i] = 0;
		}
		
		for(int i=0;i<30;i++)
		{
			list_edges[i] = 0;
		}
	}
 
	
	// * 运行游戏
	public void start() 
	{
		//map.setPreferredSize(new Dimension(ROW_WIDTH * (BOARD_SIZE - 1) + SPACE* 2, ROW_WIDTH * (BOARD_SIZE - 1) + SPACE * 2));
		map.setPreferredSize(new Dimension(700,700));
		map.addMouseListener(new MouseAdapter() 
		{
			// 鼠标点击事件
			public void mouseClicked(MouseEvent e) 
			{
				// 将用户鼠标事件的座标转换成对应顶点或者边数组的座标。
				

				int edgePos=-1 ;
				int nodePos=-1 ;
				int centerPos=-1;
				int shortest_index1=-1;
				int shortest_index2=-1;
				int index=-1;
				double shortest_distance1=99999.999;
				double shortest_distance2=99999.999;
				double distance_to_each_node[] = new double[24];//记录用户鼠标的点到每个顶点的距离
				double distance_to_each_center[] = new double[7];//记录用户鼠标的点到每个中心点的距离
				for (int i=0;i<24;i++)
				{
					distance_to_each_node[i] = Math.sqrt((e.getX()-nodes[i][0])* (e.getX()-nodes[i][0]) + (e.getY()-nodes[i][1])* (e.getY()-nodes[i][1]));
				
				}
				
				for (int i=0;i<7;i++)
				{
					distance_to_each_center[i] = Math.sqrt(e.getX()-centers[i][0])* (e.getX()-centers[i][0]) + (e.getY()-centers[i][1])* (e.getY()-centers[i][1]);
				}
				
				for (int i=0;i<24;i++)//找到距离哪一个顶点最近
				{
					if (distance_to_each_node[i]<shortest_distance1)
					{
						shortest_distance1=distance_to_each_node[i];
						shortest_index1 = i;
					}
				}
			
				
				for (int i=0;i<24;i++)//找到距离哪一个顶点第二近
				{
					if (distance_to_each_node[i]<shortest_distance2 && i!=shortest_index1)
					{
						shortest_distance2=distance_to_each_node[i];
						shortest_index2 = i;
					}
				}
				
				if(shortest_distance1<=10)//用户想操作的是顶点
				{
					nodePos = shortest_index1;
					index = 1;
					
				}
				
				
				else if(shortest_distance1+shortest_distance2<120)//用户想操作的是边
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
				
				
				else//用户想操作六边形或者操作错误
				{
					for (int i=0;i<7;i++)//找到距离哪一个中心点最近
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
					list_nodes[nodePos] = playerID;
				}
				
				else if(index==2)
				{
					list_edges[edgePos] = playerID;
					
				}
				
				else if(index==3)
				{
					list_centers[centerPos] = playerID;
					
				}
				
				else
				{
					
				}
				
	
				
				//if (board[xPos][yPos] == '+') 
				{// 判断是否下过棋
					//board[xPos][yPos] = player ? 'b' : 'w'; // 给虚拟键盘赋值
					map.repaint(); // 通过读取board数组进行贴图
					//if (isWin(xPos, yPos)) 
					{// 如果有满足胜利条件的玩家了
						map.repaint(); // 刷新图像
						//String str = player ? "黑方胜利" : "白方胜利";
						//JOptionPane.showMessageDialog(null, str, "游戏结束",JOptionPane.PLAIN_MESSAGE); // 弹出消息框
						//clearMap(); // 清空棋盘
						map.repaint(); // 刷新棋盘
						if(playerID!=4)
							playerID = playerID+1; // 新一局继续黑子先下
						else
							playerID = 1;
					}
					
				}
			}
		});
	
		// 点击重新开始事件
		items[0].addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				String str = "是否要重新开始游戏?";
				// 添加消息对话框
				if (JOptionPane.showConfirmDialog(null, str, "重新开始",JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION)
				{
					clearMap(); // 清空棋盘
					map.repaint(); // 刷新棋盘
					playerID = 1; // 玩家为黑棋
				}
			}	
		});
	
		// 点击退出事件
		items[1].addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e)
			{
				String str = "是否要退出游戏?";
				// 添加消息对话框
				if (JOptionPane.showConfirmDialog(null, str, "重新开始",JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION)
				{
					System.exit(0); // 退出
				}
			}
		});
	
		// 点关闭按钮事件
		frame.addWindowListener(new WindowAdapter()
		{
			public void windowClosing(WindowEvent e) 
			{
				String str = "是否要退出游戏?";
				// 添加消息对话框
				if (JOptionPane.showConfirmDialog(null, str, "退出游戏",JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION)
				{
					System.exit(0); // 退出
				}
			}
		});
		bar.add(game);
		frame.setJMenuBar(bar);
		frame.add(map);
		frame.pack();
		frame.setLocation(250, 50);
		frame.setResizable(false);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
	}
 


	// * 内部容器类，用于实现图像处理
	private class GameMap extends JPanel
	{
		private static final long serialVersionUID = 16578987565248L;
 
		public void paintComponent(Graphics g)
		{
			super.paintComponent(g);
			// 画棋盘
			g.setColor(new Color(153,217,234)); 
			g.fillRect(0, 0,700,700); // 填充棋盘
			
			
			//画六边形
			g.setColor(new Color(127,127,127));//灰色，mine
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
			
			g.setColor(new Color(181,230,29));//浅绿色，grass
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
			
			g.setColor(new Color(34,177,76));//深绿色，forest
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
			
			
			g.setColor(new Color(255,105,15));//橙色，wheat
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
			
			
			g.setColor(new Color(255,201,14));//金黄色，desert
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
			
			
			g.setColor(new Color(136,0,21));//褐色，brick
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
			
			
			//画点
			for (int i=0; i < 24; i++)
			{
				if(list_nodes[i] == 0 )
				{
					g.setColor(Color.BLACK);

				}
				
				else if(list_nodes[i] == 1 )
				{
					g.setColor(Color.RED);

				}
				
				else if(list_nodes[i] == 2 )
				{
					g.setColor(Color.GREEN);

				}
				
				else if(list_nodes[i] == 3 )
				{
					g.setColor(Color.BLUE);

				}
				
				else if(list_nodes[i] == 4 )
				{
					g.setColor(Color.YELLOW);

				}
				g.fillOval(nodes[i][0]-7,nodes[i][1]-7,15,15);
			}
			
			
			//画边
			for (int i=0; i < 30; i++)
			{
				if(list_edges[i] == 0 )
				{
					g.setColor(Color.BLACK);
					
				}
				
				else if(list_edges[i] == 1 )
				{
					g.setColor(Color.RED);
					
				}
				
				else if(list_edges[i] == 2 )
				{
					g.setColor(Color.GREEN);
					
				}
				
				else if(list_edges[i] == 3 )
				{
					g.setColor(Color.BLUE);
					
				}
				
				else if(list_edges[i] == 4 )
				{
					g.setColor(Color.YELLOW);
					
				}
				
				
				g.drawLine(edges[i][0],edges[i][1],edges[i][2],edges[i][3]);
			}
			
		
		}
	}
 
	public static void main(String[] args) 
	{
		FiveChessGame game = new FiveChessGame();
		game.start();
	}
	
	
}
