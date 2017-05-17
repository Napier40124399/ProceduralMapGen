package GUI;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class PanelBuilder
{
	public PanelBuilder(JPanel panel, JFrame frame)
	{
		panel.setBounds(0,0,frame.getContentPane().getWidth(), frame.getContentPane().getHeight());
		frame.getContentPane().add(panel);
	}
	
	public void drawMap(int[][] map, int scale, Graphics g)
	{
		for(int i = 0; i < map.length; i++)
		{
			for(int j = 0; j < map[i].length; j++)
			{
				if(map[i][j] == 0)
				{
					g.setColor(Color.black);
				}else if(map[i][j] == 1)
				{
					g.setColor(Color.gray);
				}else if(map[i][j] == 2)
				{
					g.setColor(Color.green);
				}else if(map[i][j] == 3)
				{
					g.setColor(Color.red);
				}else if(map[i][j] == 4)
				{
					g.setColor(Color.cyan);
				}
				g.fillRect(i*scale,j*scale,scale,scale);
			}
		}
	}
}
