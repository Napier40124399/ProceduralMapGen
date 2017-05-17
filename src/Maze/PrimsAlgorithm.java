package Maze;

import java.awt.Point;
import java.util.ArrayList;

public class PrimsAlgorithm
{
	private int height;
	private int width;
	private int[][] grid; // 0 means blocked 1 means open
	private int curIndex_X = 0;
	private int curIndex_Y = 0;
	private ArrayList<Point> frontier = new ArrayList<Point>();

	public PrimsAlgorithm(int height, int width)
	{
		this.height = height;
		this.width = width;
		prepare();
	}

	private void prepare()
	{
		grid = new int[height][width];
		grid[2][2] = 1;
		curIndex_X = 2;
		curIndex_X = 2;
	}

	private void computeNeighbours(int ii, int jj)
	{
		int choice = 0;
		if (grid[ii][jj - 2] == 0)
		{
			frontier.add(new Point(ii,jj-2));
		} else if (grid[ii - 2][jj] == 0)
		{
			frontier.add(new Point(ii-2,jj));
		} else if (grid[ii + 2][jj] == 0)
		{
			frontier.add(new Point(ii+2,jj));
		} else if (grid[ii][jj + 2] == 0)
		{
			frontier.add(new Point(ii,jj+2));
		}
	}
	
	private void doTurn()
	{
		computeNeighbours(curIndex_X, curIndex_Y);
		double rand = Math.random()*frontier.size();
		int x = (int) frontier.get((int) rand).getX();
		int y = (int) frontier.get((int) rand).getY();
		grid[x][y] = 1;
		x = x+curIndex_X / 2;
		y = y+curIndex_Y / 2;
		grid[x][y] = 1;
	}
	
	private void changeState()
	{
		
	}

	public int[][] getGrid()
	{
		return grid;
	}

	public void calculate()
	{
		doTurn();
	}
}
