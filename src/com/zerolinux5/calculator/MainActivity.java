package com.zerolinux5.calculator;

import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends Activity implements SensorEventListener {
	//accelerometer values
	private float mLastX, mLastY, mLastZ;
	private boolean mInitialized;
	private SensorManager mSensorManager;
	private Sensor mAccelerometer;
	private final float NOISE = (float) 6.0;
	
	//Main string
	long firstNumber, secondNumber, answer, continuation = 0;
	int whichNumber = 1, operation = 0;
	TextView display;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		//Create the buttons
		Button one = (Button)findViewById(R.id.button11);
		Button two = (Button)findViewById(R.id.button6);
		Button three = (Button)findViewById(R.id.button8);
		Button four = (Button)findViewById(R.id.button12);
		Button five = (Button)findViewById(R.id.button7);
		Button six = (Button)findViewById(R.id.button9);
		Button seven = (Button)findViewById(R.id.button3);
		Button eight = (Button)findViewById(R.id.button2);
		Button nine = (Button)findViewById(R.id.button4);
		Button zero = (Button)findViewById(R.id.button5);
		Button add = (Button)findViewById(R.id.button13);
		Button sub = (Button)findViewById(R.id.button14);
		Button mult = (Button)findViewById(R.id.button15);
		Button div = (Button)findViewById(R.id.button16);
		Button enter = (Button)findViewById(R.id.button17);
		
		//Give each button pictures
		one.setBackgroundResource(R.drawable.onex);
		two.setBackgroundResource(R.drawable.twox);
		three.setBackgroundResource(R.drawable.threex);
		four.setBackgroundResource(R.drawable.fourx);
		five.setBackgroundResource(R.drawable.fivex);
		six.setBackgroundResource(R.drawable.sixx);
		seven.setBackgroundResource(R.drawable.sevenx);
		eight.setBackgroundResource(R.drawable.eightx);
		nine.setBackgroundResource(R.drawable.ninex);
		zero.setBackgroundResource(R.drawable.zerox);
		add.setBackgroundResource(R.drawable.leftx);
		sub.setBackgroundResource(R.drawable.rightx);
		mult.setBackgroundResource(R.drawable.topx);
		div.setBackgroundResource(R.drawable.bottomx);
		enter.setBackgroundResource(R.drawable.middlex);
		
        //accelerometer
        mInitialized = false;
        mSensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        mAccelerometer = mSensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        mSensorManager.registerListener(this, mAccelerometer, SensorManager.SENSOR_DELAY_NORMAL);
        
        display = (TextView) findViewById(R.id.textView1);
        
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	
	@Override
	public void onConfigurationChanged(Configuration newConfig){
		//ignore orientation/keyboard change
		super.onConfigurationChanged(newConfig);
	}

	@Override
	public void onAccuracyChanged(Sensor sensor, int accuracy) {
		
	}

	@Override
	public void onSensorChanged(SensorEvent event) {
		float x = event.values[0];
		float y = event.values[1];
		float z = event.values[2];
		if (!mInitialized) {
			mLastX = x;
			mLastY = y;
			mLastZ = z;
			mInitialized = true;
		} else {
			float deltaX = Math.abs(mLastX - x);
			float deltaY = Math.abs(mLastY - y);
			float deltaZ = Math.abs(mLastZ - z);
			if (deltaX < NOISE) deltaX = (float)0.0;
			if (deltaY < NOISE) deltaY = (float)0.0;
			if (deltaZ < NOISE) deltaZ = (float)0.0;
			mLastX = x;
			mLastY = y;
			mLastZ = z;
			if(deltaX > 0 || deltaY > 0){
				clear();
			}
		}
	}
	
	public void one(View v){
		switch(whichNumber){
			case 1:
				if (continuation == 1){
					firstNumber = 0;
					continuation = 0;
				}
				firstNumber *= 10;
				firstNumber += 1;
		    	display.setText(Long.toString(firstNumber)); 
				break;
			case 2:
				secondNumber *= 10;
				secondNumber += 1;
				display.setText(Long.toString(secondNumber));
				break;
			case 3:
				
		}
	}
	
	public void two(View v){
		switch(whichNumber){
			case 1:
				if (continuation == 1){
					firstNumber = 0;
					continuation = 0;
				}
				firstNumber *= 10;
				firstNumber += 2;
				display.setText(Long.toString(firstNumber));
				break;
			case 2:
				secondNumber *= 10;
				secondNumber += 2;
				display.setText(Long.toString(secondNumber));
				break;
		}
	}
	
	public void three(View v){
		switch(whichNumber){
			case 1:
				if (continuation == 1){
					firstNumber = 0;
					continuation = 0;
				}
				firstNumber *= 10;
				firstNumber += 3;
				display.setText(Long.toString(firstNumber));
				break;
			case 2:
				secondNumber *= 10;
				secondNumber += 3;
				display.setText(Long.toString(secondNumber));
				break;
		}
	}
	
	public void four(View v){
		switch(whichNumber){
			case 1:
				if (continuation == 1){
					firstNumber = 0;
					continuation = 0;
				}
				firstNumber *= 10;
				firstNumber += 4;
				display.setText(Long.toString(firstNumber));
				break;
			case 2:
				secondNumber *= 10;
				secondNumber += 4;
				display.setText(Long.toString(secondNumber));
				break;
		}
	}
	
	public void five(View v){
		switch(whichNumber){
			case 1:
				if (continuation == 1){
					firstNumber = 0;
					continuation = 0;
				}
				firstNumber *= 10;
				firstNumber += 5;
				display.setText(Long.toString(firstNumber));
				break;
			case 2:
				secondNumber *= 10;
				secondNumber += 5;
				display.setText(Long.toString(secondNumber));
				break;
		}
	}
	
	public void six(View v){
		switch(whichNumber){
			case 1:
				if (continuation == 1){
					firstNumber = 0;
					continuation = 0;
				}
				firstNumber *= 10;
				firstNumber += 6;
				display.setText(Long.toString(firstNumber));
				break;
			case 2:
				secondNumber *= 10;
				secondNumber += 6;
				display.setText(Long.toString(secondNumber));
				break;
		}
	}
	
	public void seven(View v){
		switch(whichNumber){
			case 1:
				if (continuation == 1){
					firstNumber = 0;
					continuation = 0;
				}
				firstNumber *= 10;
				firstNumber += 7;
				display.setText(Long.toString(firstNumber));
				break;
			case 2:
				secondNumber *= 10;
				secondNumber += 7;
				display.setText(Long.toString(secondNumber));
				break;
		}
	}
	
	public void eight(View v){
		switch(whichNumber){
			case 1:
				if (continuation == 1){
					firstNumber = 0;
					continuation = 0;
				}
				firstNumber *= 10;
				firstNumber += 8;
				display.setText(Long.toString(firstNumber));
				break;
			case 2:
				secondNumber *= 10;
				secondNumber += 8;
				display.setText(Long.toString(secondNumber));
				break;
		}
	}
	
	public void nine(View v){
		switch(whichNumber){
			case 1:
				if (continuation == 1){
					firstNumber = 0;
					continuation = 0;
				}
				firstNumber *= 10;
				firstNumber += 9;
				display.setText(Long.toString(firstNumber));
				break;
			case 2:
				secondNumber *= 10;
				secondNumber += 9;
				display.setText(Long.toString(secondNumber));
				break;
		}
	}
	
	public void zero(View v){
		switch(whichNumber){
			case 1:
				if (continuation == 1){
					firstNumber = 0;
					continuation = 0;
				}
				firstNumber *= 10;
				display.setText(Long.toString(firstNumber));
				break;
			case 2:
				secondNumber *= 10;
				display.setText(Long.toString(secondNumber));
				break;
		}
	}
	
	public void add(View v){
		if (firstNumber != 0 && secondNumber!=0){
			enter(v);
		}
		whichNumber = 2;
		operation = 1;
	}
	
	public void sub(View v){
		if (firstNumber != 0 && secondNumber!=0){
			enter(v);
		}
		whichNumber = 2;
		operation = 2;
	}
	
	public void mult(View v){
		if (firstNumber != 0 && secondNumber!=0){
			enter(v);
		}
		whichNumber = 2;
		operation = 3;
	}
	
	public void div(View v){
		if (firstNumber != 0 && secondNumber!=0){
			enter(v);
		}
		whichNumber = 2;
		operation = 4;
	}
	
	public void enter(View v){
		switch (operation){
			case 1:
				answer = firstNumber + secondNumber;
				display.setText(Long.toString(answer));
				operation = 0;
				whichNumber = 1;
				firstNumber = answer;
				secondNumber = 0;
				continuation = 1;
				break;
			case 2:
				answer = firstNumber - secondNumber;
				display.setText(Long.toString(answer));
				operation = 0;
				whichNumber = 1;
				firstNumber = answer;
				secondNumber = 0;
				continuation = 1;
				break;
			case 3:
				answer = firstNumber * secondNumber;
				display.setText(Long.toString(answer));
				operation = 0;
				whichNumber = 1;
				firstNumber = answer;
				secondNumber = 0;
				continuation = 1;
				break;
			case 4:
				answer = firstNumber / secondNumber;
				display.setText(Long.toString(answer));
				operation = 0;
				whichNumber = 1;
				firstNumber = answer;
				secondNumber = 0;
				continuation = 1;
				break;
		}
	}
	
	public void clear(){
		if (operation == 0){
			firstNumber = 0;
			display.setText(Long.toString(firstNumber));
		} else {
			secondNumber = 0;
			display.setText(Long.toString(secondNumber));
		}
	}
}