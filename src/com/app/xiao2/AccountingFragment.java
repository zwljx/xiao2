package com.app.xiao2;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;


public class AccountingFragment extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        View newsLayout = inflater.inflate(R.layout.tab_account, container,
                false);
        Button doAccount = (Button)newsLayout.findViewById(R.id.doaccount);
        doAccount.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent it =new Intent("com.app.xiao2.DoAccount");
				startActivity(it);
			}
		});
        Button acc_setting = (Button)newsLayout.findViewById(R.id.acc_setting);
        acc_setting.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent it =new Intent("com.app.xiao2.AccountSet");
				startActivity(it);
			}
		});
        
        return newsLayout;
    }
}
