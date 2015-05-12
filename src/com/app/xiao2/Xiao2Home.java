package com.app.xiao2;



import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

import android.app.ActionBar;
import android.app.ActionBar.LayoutParams;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTabHost;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.util.Log;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;
import android.widget.TabHost.OnTabChangeListener;
import android.widget.TextView;

public class Xiao2Home  extends FragmentActivity {
	
	

	private String[] mMenuTitles;
	private String[] mMenuActivity={"MyInfoActivity","MyCustomerActivity","MyPointsActivity","MySettingActivity"};
	private DrawerLayout mDrawerLayout;
	private ListView mDrawerList;
	public static RequestQueue requestQueue;
    //public static final String ARG_MENU_INDEX = "MenuIndex";
	
	private FragmentTabHost mTabHost = null;;  
    private View indicator = null;  
  
  	//private LayoutInflater layoutInflater;
    private int tabcount=4;	

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_xiao2_home);
        
        mMenuTitles = getResources().getStringArray(R.array.drawer_item);
        
        mDrawerLayout = (DrawerLayout)findViewById(R.id.drawer_layout);
        mDrawerList = (ListView)findViewById(R.id.left_drawer);
        
      
        mDrawerLayout.setDrawerShadow(R.drawable.drawer_shadow, GravityCompat.START);
        
        mDrawerList.setAdapter(new ArrayAdapter<String>(this, R.layout.drawer_list_item, mMenuTitles));
        mDrawerList.setOnItemClickListener(new DrawerItemClickListener());
       
        mTabHost = (FragmentTabHost) findViewById(android.R.id.tabhost);  
        mTabHost.setup(this, getSupportFragmentManager(), R.id.realtabcontent); 
     //  final TabWidget tabWidget = mTabHost.getTabWidget();
      // tabWidget.setStripEnabled(false);
       
       
       indicator = getIndicatorView("首页", R.layout.tab_item_view,R.drawable.tab_index_normal);  
       mTabHost.addTab(mTabHost.newTabSpec("index")  
               .setIndicator(indicator), IndexContainer.class, null);  
       
       indicator = getIndicatorView("问答", R.layout.tab_item_view,R.drawable.tab_qa_normal);  
       mTabHost.addTab(  
               mTabHost.newTabSpec("qa").setIndicator(indicator),  
               QaFragment.class, null);  
 
       indicator = getIndicatorView("记账", R.layout.tab_item_view,R.drawable.tab_accounting_normal);  
       mTabHost.addTab(  
               mTabHost.newTabSpec("accounting").setIndicator(indicator),  
               AccountingFragment.class, null);  
       indicator = getIndicatorView("任务", R.layout.tab_item_view,R.drawable.tab_assignment_normal);  
       mTabHost.addTab(  
               mTabHost.newTabSpec("assignment").setIndicator(indicator),  
               AssignmentFragment.class, null);  
       
       
    for(int i=0;i<tabcount;i++)
    	mTabHost.getTabWidget().getChildAt(i).setBackgroundResource(R.drawable.selector_tab_background);
       
      
      
    mTabHost.setCurrentTabByTag("首页");
    	   
      /*  mTabHost.setOnTabChangedListener(new OnTabChangeListener() {
			
			@Override
			public void onTabChanged(String tabId) {
			    
			}
		});*/
		
		
	
    }
    private View getIndicatorView(String name, int layoutId,int drawableId) {  
        View v = getLayoutInflater().inflate(layoutId, null);  
        TextView tv = (TextView) v.findViewById(R.id.textview);  
        tv.setText(name);  
        ImageView imageView = (ImageView) v.findViewById(R.id.imageview);
		imageView.setImageResource(drawableId);
		
		
        
        return v;  
    }  
    
    
    @Override  
    protected void onDestroy() {  
        // TODO Auto-generated method stub  
        super.onDestroy();  
        mTabHost = null;  
    } 
    @Override
	public boolean onCreateOptionsMenu(Menu menu) {
		ActionBar actionBar = this.getActionBar();       
        ActionBar.LayoutParams params=new ActionBar.LayoutParams(LayoutParams.MATCH_PARENT,LayoutParams.MATCH_PARENT,Gravity.CENTER );
        View view=LayoutInflater.from(this).inflate(R.layout.actionbar, null);
        actionBar.setCustomView(view,params);
        actionBar.setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        actionBar.setDisplayShowCustomEnabled(true);
        ImageButton drawermenu = (ImageButton) this.findViewById(R.id.drawer_menu);
        drawermenu.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				if (!mDrawerLayout.isDrawerOpen(mDrawerList))
	    		{
	    		mDrawerLayout.openDrawer(mDrawerList);
	    		}else
	    			mDrawerLayout.closeDrawer(mDrawerList);
			}
		});
        return true;
	}
    
    private class DrawerItemClickListener implements  ListView.OnItemClickListener{

		@Override
		public void onItemClick(AdapterView<?> parent, View view, int position,
				long id) {
			// TODO Auto-generated method stub
			 selectItem(position);
		}

		private void selectItem(int position) {
			// TODO Auto-generated method stub
			//Drawer 跳转到设置页面
			
			Bundle args  = new Bundle();
			args.putInt(MyInfoActivity.ARG_MENU_INDEX, position);
		
			Intent intent = new Intent("com.app.xiao2."+mMenuActivity[position]);
			
			
			
			intent.putExtras(args);
			mDrawerList.setItemChecked(position, false);
			//setTitle(mMenuTitles[position]);
			mDrawerLayout.closeDrawer(mDrawerList);
			startActivity(intent);
			
		}
		

    	
    	
    }


    public boolean onKeyDown(int keyCode, KeyEvent event) {
    	if (keyCode == KeyEvent.KEYCODE_MENU
    			&& event.getAction() == KeyEvent.ACTION_DOWN) {
    		// 菜单键打开drawer
    		if (!mDrawerLayout.isDrawerOpen(mDrawerList))
    		{
    		mDrawerLayout.openDrawer(mDrawerList);
    		return true;
    		}
    		else
    			return super.onKeyDown(keyCode, event);
    	}
    	if (keyCode == KeyEvent.KEYCODE_BACK
    			&& event.getAction() == KeyEvent.ACTION_DOWN) {
    		// 返回键关闭drawer
    		
    		ViewPager vp = (ViewPager) findViewById(R.id.viewpager);
    		if (mDrawerLayout.isDrawerOpen(mDrawerList))
    			{
    			mDrawerLayout.closeDrawer(mDrawerList);
    			return true;
    			}
    		else if(vp!=null&&vp.getCurrentItem()==1)
    		{
    			vp.setCurrentItem(0);
    			return true;
    		}
    		else
    			return super.onKeyDown(keyCode, event);
    		
    		
    	}
    	return super.onKeyDown(keyCode, event);
    	
    }
	
    public static RequestQueue getRQInstance(Context context){
    	if(requestQueue==null)
    	{
    		synchronized (Xiao2Home.class) {
    			if(requestQueue==null)
    			{
    				requestQueue=Volley.newRequestQueue(context);
    			
    			}
				
			}
    	}
    	return requestQueue;
	}
}


 