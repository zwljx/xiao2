package com.app.xiao2;

import android.app.Activity;
import android.app.Instrumentation;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.Spinner;

public class AccountSet extends Activity {
	
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		
		setContentView(R.layout.accountset);
		  ImageButton back = (ImageButton) findViewById(R.id.accset_back);
		    back.setOnClickListener(new OnClickListener() {
				
				@Override
				public void onClick(View v) {
					// TODO Auto-generated method stub
					new Thread(){
						   public void run() {
						    try{
						     Instrumentation inst = new Instrumentation();
						     inst.sendKeyDownUpSync(KeyEvent.KEYCODE_BACK);
						    }
						    catch (Exception e) {
						                 Log.e("Exception when onBack", e.toString());
						             }
						   }
						  }.start();
				}
				
			});
	}

}
