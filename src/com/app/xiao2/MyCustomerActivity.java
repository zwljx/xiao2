package com.app.xiao2;



import android.os.Bundle;
import android.app.Activity;

import android.widget.ImageView;

public class MyCustomerActivity extends Activity {
	//public static final String ARG_PLANET_NUMBER = "planet_number";
	 public static final String ARG_MENU_INDEX = "MenuIndex";
	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.mycustomer_frag);
		Bundle args =this.getIntent().getExtras();
		int i = args.getInt(ARG_MENU_INDEX);
		
		//String title = getResources().getStringArray(R.array.drawer_item)[i];
		int imageId = getResources().getIdentifier("mars", "drawable", getPackageName());
		((ImageView)findViewById(R.id.image)).setImageResource(imageId);
		//setTitle(title);
	}


	
		
		
		
		
		
		
		
		
		
	   

}
