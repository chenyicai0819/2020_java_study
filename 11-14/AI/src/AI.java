import javax.microedition.lcdui.*;
import javax.microedition.midlet.*;
import java.io.*;

public class AI extends MIDlet
{
	Display display;
	MainCanvas mc;
	public AI(){
		display=Display.getDisplay(this);
		mc=new MainCanvas();
		display.setCurrent(mc);
	}
	public void startApp(){
	}
	public void destroyApp(boolean unc){
	}
	public void pauseApp(){
	}
}
class MainCanvas extends Canvas
{
	Image img,img1,img2,img3,currentImg;
	public MainCanvas(){
		try
		{
			img=Image.createImage("/sayo10.png");
			img1=Image.createImage("/sayo12.png");
			img2=Image.createImage("/sayo14.png");
			img3=Image.createImage("/sayo16.png");
			currentImg=img;
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
	}
	public void paint(Graphics g){
		g.setColor(0,0,0);
		g.fillRect(0,0,getWidth(),getHeight());
		g.drawImage(currentImg,120,100,0);//120x坐标，100y坐标
	}
	public void keyPressed(int keyCode){
		int action=getGameAction(keyCode);

		if(action==LEFT)
			currentImg=img1;
			System.out.println("向左转");
			repaint();

		if(action==RIGHT)
			currentImg=img3;
			System.out.println("向右转");
			repaint();

		if(action==UP)
			currentImg=img2;
			System.out.println("向上转");
			repaint();
		
		if(action==DOWN)
			currentImg=img;
			System.out.println("向下转");
			repaint();


	}
}