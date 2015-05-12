package com.app.xiao2;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;






public class AnnouncementFragment extends Fragment  {
	
	

    String[] titles={"国美2014年第四次会议胜利召开","联想s330手机勇夺CES大奖","RKA团队再造佳绩",
    		"北京国美团队发扬吃苦耐劳精神","南京苏宁中央广场店举行庆典活动","yoga机型迎来销售高潮","大于十条自动滚动"};  
   
    int[] resIds={R.drawable.noanswer,R.drawable.noanswer,R.drawable.answerd,
    		R.drawable.answerd,R.drawable.answerd,R.drawable.noanswer,R.drawable.noanswer};  
	
	
	
	 public static Fragment newInstance() {  
         return new AnnouncementFragment();  
     }  
	
	 @Override
		public View onCreateView(LayoutInflater inflater, ViewGroup container,
				Bundle savedInstanceState) {
			// TODO Auto-generated method stub
			View newsLayout = inflater.inflate(R.layout.tab_announcement, container,
	                false);  
			
			 ListView listView = (ListView) newsLayout.findViewById(R.id.articles);  
		      
			 
			 listView.setAdapter(new ListViewAdapter(titles,resIds)); 
			
			
			
			
			return newsLayout;
		}
		public class ListViewAdapter extends BaseAdapter {  
	        View[] itemViews;  
	  
	        public ListViewAdapter(String[] itemTitles,  
	                int[] itemImageRes) {  
	            itemViews = new View[itemTitles.length];  
	  
	            for (int i = 0; i < itemViews.length; i++) {  
	                itemViews[i] = makeItemView(itemTitles[i],
	                        itemImageRes[i]); 
	                itemViews[i].setOnClickListener(new OnClickListener() {
						
						@Override
						public void onClick(View v) {
							// TODO Auto-generated method stub
							/*Intent it = new Intent("com.app.xiao2.Conversation");
							startActivity(it);*/
						}
					});
	            }  
	        }  
	  
	        public int getCount() {  
	            return itemViews.length;  
	        }  
	  
	        public View getItem(int position) {  
	            return itemViews[position];  
	        }  
	  
	        public long getItemId(int position) {  
	            return position;  
	        }  
	  
	        private View makeItemView(String strTitle, int resId) {  
	            LayoutInflater inflater = (LayoutInflater)getActivity() 
	                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);  
	  
	            // 使用View的对象itemView与R.layout.item关联  
	            View itemView = inflater.inflate(R.layout.question_item, null);  
	  
	            // 通过findViewById()方法实例R.layout.item内各组件  
	            TextView title = (TextView) itemView.findViewById(R.id.ItemTitle);  
	            title.setText(strTitle);  
	            
	            ImageView image = (ImageView) itemView.findViewById(R.id.ItemPic);  
	            image.setImageResource(resId);  
	              
	            return itemView;  
	        }  
	  
	        public View getView(int position, View convertView, ViewGroup parent) {  
	            if (convertView == null)  
	                return itemViews[position];  
	            return convertView;  
	        }  
	    }
	
	
	
	
}
