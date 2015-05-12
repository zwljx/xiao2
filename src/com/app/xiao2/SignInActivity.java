package com.app.xiao2;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class SignInActivity extends Activity implements OnClickListener{

	EditText uname = null,upwd = null;
	Button btnsignin;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		
		 setContentView(R.layout.sign_in);
		 btnsignin = (Button)findViewById(R.id.btnsignin);
		 btnsignin.setOnClickListener(this);
		
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		 Intent intent = new Intent("com.app.xiao2.Xiao2Home");
         startActivity(intent);
         finish();
	}
	

}
