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
	int x,y;
	Image downImg,leftImg,rightImg,upImg,currentImg;
	public MainCanvas(){
		try
		{
			downImg=Image.createImage("/sayo10.png");
			leftImg=Image.createImage("/sayo12.png");
			upImg=Image.createImage("/sayo14.png");
			rightImg=Image.createImage("/sayo16.png");
			currentImg=downImg;
			x=120;
			y=100;
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
	}
	public void paint(Graphics g){
		g.setColor(0,0,0);
		g.fillRect(0,0,getWidth(),getHeight());
		g.drawImage(currentImg,x,y,0);//120x×ø±ê£¬100y×ø±ê
	}
	public void keyPressed(int keyCode){
		
		int action=getGameAction(keyCode);
		if (action==LEFT){
			currentImg=leftImg;
			x=x-1;
		}
		
		else if  (action==RIGHT){
			currentImg=rightImg;
			x=x+1;
		}
		else if(action==UP){
			currentImg=upImg;
			y=y-1;
		}
		else if(action==DOWN){
			currentImg=downImg;
			y=y+1;
		}
		repaint();
	}
}