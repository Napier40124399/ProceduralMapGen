package GUI;

import javax.swing.JFrame;

public class FrameBuilder
{
	private int frameHeight = 650;
	private int frameWidth = 650;
	public FrameBuilder(JFrame frame)
	{
		frame.setBounds(250,250,frameHeight,frameWidth);
		frame.setVisible(true);
		frame.setTitle("Map Generator");
		frame.setLayout(null);
	}
}
