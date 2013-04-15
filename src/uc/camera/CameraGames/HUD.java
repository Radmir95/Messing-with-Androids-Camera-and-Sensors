package uc.camera.CameraGames;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

public class HUD {
	SensorsOutput mSensors;
	EnemyPositions mEnemies;
	public void debugDraw(Canvas c){
		Paint redpaint = new Paint();redpaint.setColor(Color.RED);
		Paint greenpaint = new Paint();greenpaint.setColor(Color.GREEN);
		Paint bluepaint = new Paint();bluepaint.setColor(Color.BLUE);
		
		double rotation_X_axis=mSensors.rotation_x;
		double rotation_Y_axis=mSensors.rotation_y;
		double rotation_Z_axis=mSensors.rotation_z;
		
		
		c.drawText("rotation on X:"+rotation_X_axis, 50, 50, redpaint);
		c.drawText("rotation on Y:"+rotation_Y_axis, 50, 60, greenpaint);
		c.drawText("rotation on Z:"+rotation_Z_axis, 50, 70, bluepaint);
	}
	
	
	
	//Basic top down radar, (Just angle around y-axis)
	public void radarDraw(Canvas c){
		int cx=30; int cy=30; int radius=30;//circle centre, radius
		double angle=Math.PI*mSensors.rotation_y/180; //(-180,180), NORTH at 0
		int xi=(int) (cx+radius*Math.cos(angle)); //end of central radar ray
		int yi=(int) (cy+radius*Math.sin(angle)); //end of central radar ray
		
		Paint bluepaint = new Paint();bluepaint.setColor(Color.BLUE);
		Paint greenpaint = new Paint();greenpaint.setColor(Color.GREEN);
		c.drawCircle(cx, cy, radius, bluepaint);
		c.drawLine(cx, cy, xi, yi, greenpaint);
		
	}
	
	
	
	
	public HUD(SensorsOutput so,EnemyPositions enemies){
		mSensors =so;
		mEnemies = enemies;
	}
	public void draw(Canvas c){
		debugDraw(c);
		radarDraw(c);
	}
	
}