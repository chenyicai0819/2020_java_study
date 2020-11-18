```java
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
	int leftFlag,rightFlag,upFlag,downFlag;

	Image downImg,downImg1,downImg2,
			leftImg,leftImg1,leftImg2,
			rightImg,rightImg1,rightImg2,
			upImg,upImg1,upImg2,
			currentImg;
	public MainCanvas(){
		try
		{
			downImg=Image.createImage("/sayo10.png");
			downImg1=Image.createImage("/sayo00.png");
			downImg2=Image.createImage("/sayo20.png");

			leftImg=Image.createImage("/sayo12.png");
			leftImg1=Image.createImage("/sayo02.png");
			leftImg2=Image.createImage("/sayo22.png");

			upImg=Image.createImage("/sayo14.png");
			upImg1=Image.createImage("/sayo04.png");
			upImg2=Image.createImage("/sayo24.png");

			rightImg=Image.createImage("/sayo16.png");
			rightImg1=Image.createImage("/sayo06.png");
			rightImg2=Image.createImage("/sayo26.png");

			currentImg=downImg;
			x=120;
			y=100;
			leftFlag=1;
			rightFlag=1;
			upFlag=1;
			downFlag=1;
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
	}
	public void paint(Graphics g){
		g.setColor(135,206,235);
		g.fillRect(0,0,getWidth(),getHeight());
		g.drawImage(currentImg,x,y,0);
	}
	public void keyPressed(int keyCode){
		
		int action=getGameAction(keyCode);
		if (action==LEFT){
			if(leftFlag==1){
				currentImg=leftImg1;
				leftFlag++;
			}
			else if(leftFlag==2){
				currentImg=leftImg2;
				leftFlag=1;
			}
			x=x-1;
		}
		else if  (action==RIGHT){
			if(rightFlag==1){
				currentImg=rightImg1;
				rightFlag++;
			}
			else if(rightFlag==2){
				currentImg=rightImg2;
				rightFlag=1;
			}
			x=x+1;
		}
		else if(action==UP){
			if(upFlag==1){
				currentImg=upImg1;
				upFlag++;
			}
			else if(upFlag==2){
				currentImg=upImg2;
				upFlag=1;
			}
			y=y-1;
		}
		else if(action==DOWN){
			if(downFlag==1){
				currentImg=downImg1;
				downFlag++;
			}
			else if(downFlag==2){
				currentImg=downImg2;
				downFlag=1;
			}
			y=y+1;
		}
		repaint();

	}
}
```