package GUI;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

import Maze.DFS;
import Maze.PrimsAlgorithm;

public class MainWindow
{
	//Variables
	private int scale = 5;
	private int mapHeight = 100;
	private int mapWidth = 100;
	private int speed = 10;
	//Components
	private JFrame frame;
	private JPanel panel;
	private Timer timer;
	//Instances
	private FrameBuilder frameBuilder;
	private PanelBuilder panelBuilder;
	private PrimsAlgorithm prim;
	private DFS dfs;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainWindow window = new MainWindow();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	private MainWindow()
	{
		initialize();
	}
	
	private void initialize()
	{
		//prim = new PrimsAlgorithm(mapHeight, mapWidth);
		dfs = new DFS(mapHeight, mapWidth);
		frame = new JFrame();
		panel = new JPanel()
		{
			@Override
			protected void paintComponent(Graphics g)
			{
				panelBuilder.drawMap(dfs.getGrid(), scale, g);
			}
		};
		frameBuilder = new FrameBuilder(frame);
		panelBuilder = new PanelBuilder(panel, frame);
		timer = new Timer(speed, new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				if(dfs.checkCompletion())
				{
					timer.stop();
					panel.repaint();
				}else
				{
					dfs.calculate();
					panel.repaint();
				}
			}
		});
		timer.start();
	}
}
