package com.app.xiao2;

import java.util.ArrayList;
import java.util.List;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

public class IndexContainer extends Fragment {
	private View view1, view2;//需要滑动的页卡  
    private ViewPager viewPager;//viewpager  
    
    private List<View> viewList;//把需要滑动的页卡添加到这个list中  
   
    
    private ArrayList<Fragment> mArryList; 
   
     
 
    @Override
	public void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		
		 mArryList = new ArrayList<Fragment>();  
		 IndexFragment index =  (IndexFragment) IndexFragment.newInstance();
		 AnnouncementFragment anno = (AnnouncementFragment) AnnouncementFragment.newInstance();
         mArryList.add(index);
         mArryList.add(anno);
         
     }

	@Override
public View onCreateView(LayoutInflater inflater, ViewGroup container,
		Bundle savedInstanceState) {
	// TODO Auto-generated method stub
    	View newsLayout = inflater.inflate(R.layout.tab_index_container, container,  
                false);
    	initView(newsLayout);
    	
	return  newsLayout;
}

	private void initView(View layout) { 
        viewPager = (ViewPager) layout.findViewById(R.id.viewpager); 
       
          
        view1 = layout.findViewById(R.layout.tab_index);  
        view2 = layout.findViewById(R.layout.tab_announcement);  
       
        view1= View.inflate(getActivity(), R.layout.tab_index, null);
        view2= View.inflate(getActivity(), R.layout.tab_announcement, null);
       
  
        viewList = new ArrayList<View>();// 将要分页显示的View装入数组中  
        viewList.add(view1);  
        viewList.add(view2);  
       
        PagerAdapter mAdapter = new MyFragmentAdapter(getChildFragmentManager()); 
      
  
       
        viewPager.setAdapter(mAdapter); 
        viewPager.setCurrentItem(0);
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
	    }  
}
