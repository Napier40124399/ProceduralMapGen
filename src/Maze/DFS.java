package Maze;

import java.awt.Point;
import java.util.Stack;

public class DFS
{
	private int height;
	private int width;
	private int[][] grid;
	private Point curPos = new Point(4, 4);
	private int direction = 3;
	private Stack visited = new Stack();
	private boolean up;
	private boolean left;
	private boolean right;
	private boolean down;
	private boolean complete = false;
	private int tolerance = 3;

	public DFS(int height, int width)
	{
		this.height = height;
		this.width = width;
		grid = new int[width][height];
		grid[4][4] = 2;
	}

	private void movement()
	{
		double temp = Math.random() * 4;
		direction = (int) temp;
	}

	private void checkPossible()
	{
		switch (direction)
		{
		case 0:
			up();
			break;
		case 1:
			left();
			break;
		case 2:
			right();
			break;
		case 3:
			down();
			break;
		}
	}

	private void checkDeadEnd()
	{
		int posX = (int) curPos.getX();
		int posY = (int) curPos.getY();
		
		up = false;
		down = false;
		left = false;
		right = false;
		
		if(curPos.getY() > 1)
		{
			if (grid[(int) curPos.getX()][(int) curPos.getY() - 2] == 0)
			{
				up = true;
			}
		}
		
		if(curPos.getX() > 1)
		{
			if (grid[(int) curPos.getX() - 2][(int) curPos.getY()] == 0)
			{
				left = true;
			}
		}
		
		if(curPos.getX() < width - tolerance)
		{
			if (grid[(int) curPos.getX() + 2][(int) curPos.getY()] == 0)
			{
				right = true;
			}
		}
		
		if(curPos.getY() < height - tolerance)
		{
			if (grid[(int) curPos.getX()][(int) curPos.getY() + 2] == 0)
			{
				down = true;
			}
		}
		
		if(!up && !down && !left && !right)
		{
			visited.pop();
			if(visited.isEmpty())
			{
				complete = true;
			}else
			{
				curPos = (Point) visited.peek();
				calculate();
			}
		}
	}
	
	private void up()
	{
		if (curPos.getY() < 2)
		{
			checkDeadEnd();
		} else if (grid[(int) curPos.getX()][(int) curPos.getY() - 2] == 0)
		{
			// ok
			grid[(int) curPos.getX()][(int) curPos.getY() - 1] = 1;
			grid[(int) curPos.getX()][(int) curPos.getY() - 2] = 1;
			curPos = new Point((int) curPos.getX(), (int) curPos.getY() - 2);
			visited.push(new Point(curPos));
		}else
		{
			checkDeadEnd();
		}
	}

	private void left()
	{
		if (curPos.getX() < 2)
		{
			checkDeadEnd();
		} else if (grid[(int) curPos.getX() - 2][(int) curPos.getY()] == 0)
		{
			// ok
			grid[(int) curPos.getX() - 1][(int) curPos.getY()] = 1;
			grid[(int) curPos.getX() - 2][(int) curPos.getY()] = 1;
			curPos = new Point((int) curPos.getX() - 2, (int) curPos.getY());
			visited.push(new Point(curPos));
		}else
		{
			checkDeadEnd();
		}
	}

	private void right()
	{
		if (curPos.getX() > width - tolerance)
		{
			checkDeadEnd();
		} else if (grid[(int) curPos.getX() + 2][(int) curPos.getY()] == 0)
		{
			// ok
			grid[(int) curPos.getX() + 1][(int) curPos.getY()] = 1;
			grid[(int) curPos.getX() + 2][(int) curPos.getY()] = 1;
			curPos = new Point((int) curPos.getX() + 2, (int) curPos.getY());
			visited.push(new Point(curPos));
		}else
		{
			checkDeadEnd();
		}
	}

	private void down()
	{
		if (curPos.getY() > height - tolerance)
		{
			checkDeadEnd();
		} else if (grid[(int) curPos.getX()][(int) curPos.getY() + 2] == 0)
		{
			// ok
			grid[(int) curPos.getX()][(int) curPos.getY() + 1] = 1;
			grid[(int) curPos.getX()][(int) curPos.getY() + 2] = 1;
			curPos = new Point((int) curPos.getX(), (int) curPos.getY() + 2);
			visited.push(new Point(curPos));
		}else
		{
			checkDeadEnd();
		}
	}
	
	public void calculate()
	{
		if(!complete)
		{
			movement();
			checkPossible();
		}
	}
	
	public int[][] getGrid()
	{
		return grid;
	}
	
	public boolean checkCompletion()
	{
		return complete;
	}
}
