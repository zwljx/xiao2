package com.app.xiao2;

import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.DisplayMetrics;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;



import com.viewpagerindicator.*;


public class QaFragment extends Fragment{
	
	
	

	private View view1, view2;//需要滑动的页卡  
    private ViewPager viewPager;//viewpager  
  
 
    private List<View> viewList;//把需要滑动的页卡添加到这个list中  
    private List<String> titleList;//viewpager的标题  
    private ArrayList<Fragment> mArryList; 
   
    
    public void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		
		 mArryList = new ArrayList<Fragment>();  
		 MyQaFrag myqa =  (MyQaFrag) MyQaFrag.newInstance();
		 FavoQaFrag favoqa = (FavoQaFrag) FavoQaFrag.newInstance();
         mArryList.add(myqa);
         mArryList.add(favoqa);
         
     }
    
    
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		
		final Context contextThemeWrapper = new ContextThemeWrapper(getActivity(), R.style.StyledIndicators);
		
		LayoutInflater localInflater = inflater.cloneInContext(contextThemeWrapper); 
			View layout = localInflater.inflate(R.layout.tab_qa,container,false);
		
		
		   initView(layout);
		   
		
		
        
        return layout; 
	}
	private void initView(View layout) { 
        viewPager = (ViewPager) layout.findViewById(R.id.viewpager); 
        //pagerTitleStrip = (PagerTitleStrip) findViewById(R.id.pagertitle); 
        TabPageIndicator tabIndicator = (TabPageIndicator)layout.findViewById(R.id.pagertab);
       
        
          
        view1 = layout.findViewById(R.layout.tab_myqa);  
        view2 = layout.findViewById(R.layout.tab_favoqa);  
       
        view1= View.inflate(getActivity(), R.layout.tab_myqa, null);
        view2= View.inflate(getActivity(), R.layout.tab_favoqa, null);
       
  
        viewList = new ArrayList<View>();// 将要分页显示的View装入数组中  
        viewList.add(view1);  
        viewList.add(view2);  
        titleList = new ArrayList<String>();// 每个页面的Title数据  
        titleList.add("我的");  
        titleList.add("收藏");  
  
      
  
        PagerAdapter mAdapter = new MyFragmentAdapter(getChildFragmentManager()); 
        viewPager.setAdapter(mAdapter);  
        tabIndicator.setViewPager(viewPager);
       
    }  
	private class MyFragmentAdapter extends FragmentPagerAdapter {  
		  
        public MyFragmentAdapter(FragmentManager fm) {  
            super(fm);  
        }  
  
        @Override  
        public Fragment getItem(int position) {  
            return mArryList.get(position);  
        }  
  
        @Override  
        public int getCount() {  
            return mArryList.size();  
        }

		@Override
		public CharSequence getPageTitle(int position) {
			// TODO Auto-generated method stub
			return titleList.get(position);
		}  
    }  
}
