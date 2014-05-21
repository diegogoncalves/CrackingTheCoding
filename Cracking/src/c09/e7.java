package c09;

public class e7 {
	void PaintFill(int screen[][],int point[],int color){
		paintPixel(screen,point,color,screen[point[0]][point[1]]);
	}

	private void paintPixel(int[][] screen, int[] point,int newColor, int oldColor) {
		if(point[0]>=screen.length||point[0]<0 ||
				point[1]>=screen[0].length||point[1]<0){
			return;
		}
		else if(screen[point[0]][point[1]]==oldColor){
			screen[point[0]][point[1]]=newColor;
			int s[]={point[0]-1,point[1]};
			paintPixel(screen, s, newColor, oldColor);
			s[0]=point[0]+1;s[1]=point[1];
			paintPixel(screen, s, newColor, oldColor);
			s[0]=point[0];s[1]=point[1]-1;
			paintPixel(screen, s, newColor, oldColor);
			s[0]=point[0];s[1]=point[1]+1;
			paintPixel(screen, s, newColor, oldColor);
		}

	}
}
