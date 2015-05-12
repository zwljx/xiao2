package com.app.xiao2;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.Window;
import android.widget.TextView;

public class SplashActivity extends Activity{
	 private static final int FAILURE = 0; // 没登陆过
	    private static final int SUCCESS = 1; // 登陆过
	    
	    private static final int SHOW_TIME_MIN = 3000;
	    
	    @Override
	    protected void onCreate(Bundle savedInstanceState) {
	        super.onCreate(savedInstanceState);
	        
	        setContentView(R.layout.splash);
	 
	      
	 
	       
	        new AsyncTask<Void, Void, Integer>() {
	 
	            @Override
	            protected Integer doInBackground(Void... params) {
	            	int result;
	                long startTime = System.currentTimeMillis();
	                result = loadingCache();
	                long loadingTime = System.currentTimeMillis() - startTime;
	                if (loadingTime < SHOW_TIME_MIN) {
	                    try {
	                        Thread.sleep(SHOW_TIME_MIN - loadingTime);
	                    } catch (InterruptedException e) {
	                        e.printStackTrace();
	                    }
	                }
	                return result;
	            }
	 
	            @Override
	            protected void onPostExecute(Integer result) {
	               Intent intent ;
	               if(result==SUCCESS)
	            	   intent= new Intent("com.app.xiao2.Xiao2Home");
	               else
	            	   intent= new Intent("com.app.xiao2.SignInActivity");
	               startActivity(intent);
	               finish();
	               overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
	            };
	        }.execute(new Void[]{});
	    }
	 
	    private int loadingCache() {
	        //检查 登陆过没
	        return FAILURE;
	    }
	 

}
