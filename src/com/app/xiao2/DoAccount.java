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
import android.widget.TextView;

public class DoAccount extends Activity{

	
	
	    private Spinner spinner = null;  
	    private ArrayAdapter<String> adapter = null;  
	    private static final String [] type ={"系列1(￥30.00)","系列2(￥40.00)","c系列3(￥50.00)","c系列4(￥36.00)"};  
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		
		setContentView(R.layout.doaccount);
		spinner = (Spinner) findViewById(R.id.spinner);
		adapter = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,type); 
		spinner.setAdapter(adapter);  
	    spinner.setVisibility(View.VISIBLE);//设置默认显示  
	    ImageButton back = (ImageButton) findViewById(R.id.doacc_back);
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
