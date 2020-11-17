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

	Image downImg,downImg1,downImg2,
			leftImg,leftImg1,leftImg2,
			rightImg,rightImg1,rightImg2,
			upImg,upImg1,upImg2,currentImg;
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
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
	}
	public void paint(Graphics g){
		g.setColor(0,0,0);
		g.fillRect(0,0,getWidth(),getHeight());
		g.drawImage(currentImg,x,y,0);//120x���꣬100y����
	}
	public void keyPressed(int keyCode){
		
		int action=getGameAction(keyCode);
		if (action==LEFT){
			if(currentImg==leftImg||currentImg==leftImg1||currentImg==leftImg2){
				if(currentImg==leftImg||currentImg==leftImg1){
					if(currentImg==leftImg1){
						currentImg=leftImg2;
					}
					else currentImg=leftImg1;
				}
				else currentImg=leftImg;
			}
			else currentImg=leftImg;
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



	/*public void keyPressed1(int keyCode){

		int action=getGameAction(keyCode);
		if (action==LEFT){
			if (currentImg==leftImg1) {currentImg=leftImg2;}
			else currentImg=leftImg1;

		}

		else if  (action==RIGHT){
			if (currentImg=s=rightImg1) {currentImg=rightImg2;}
			else currentImg=rightImg1;

		}
		else if(action==UP){
			if (currentImg==upImg1) {currentImg=upImg2;}
			else currentImg=upImg1;

		}
		else if(action==DOWN){
			if (currentImg==downImg1) {currentImg=downImg2;}
			else currentImg=downImg1;

		}
		repaint();
	}*/
}