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

	Image HeroLeftImg[]=new Image[3];
	Image HeroRightImg[]=new Image[3];
	Image HeroUpImg[]=new Image[3];
	Image HeroDownImg[]=new Image[3];
	Image currentImg;

	public MainCanvas(){
		try
		{
			for(int i=0;i<HeroDownImg.length;i++){
				HeroDownImg[i]=Image.createImage("/sayo"+i+"0.png");
			}
			for(int i=0;i<HeroLeftImg.length;i++){
				HeroLeftImg[i]=Image.createImage("/sayo"+i+"2.png");
			}
			for(int i=0;i<HeroUpImg.length;i++){
				HeroUpImg[i]=Image.createImage("/sayo"+i+"4.png");
			}
			for(int i=0;i<HeroRightImg.length;i++){
				HeroRightImg[i]=Image.createImage("/sayo"+i+"6.png");
			}
			/*
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
			 */
			currentImg=HeroLeftImg[1];
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
				currentImg=HeroLeftImg[0];
				leftFlag++;
			}
			else if(leftFlag==2){
				currentImg=HeroLeftImg[2];
				leftFlag=1;
			}
			x=x-1;
		}
		else if  (action==RIGHT){
			if(rightFlag==1){
				currentImg=HeroRightImg[0];
				rightFlag++;
			}
			else if(rightFlag==2){
				currentImg=HeroRightImg[2];
				rightFlag=1;
			}
			x=x+1;
		}
		else if(action==UP){
			if(upFlag==1){
				currentImg=HeroUpImg[0];
				upFlag++;
			}
			else if(upFlag==2){
				currentImg=HeroUpImg[2];
				upFlag=1;
			}
			y=y-1;
		}
		else if(action==DOWN){
			if(downFlag==1){
				currentImg=HeroDownImg[0];
				downFlag++;
			}
			else if(downFlag==2){
				currentImg=HeroDownImg[2];
				downFlag=1;
			}
			y=y+1;
		}
		repaint();

	}
}
