package com.app.xiao2;

import java.util.ArrayList;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

public class MyQaFrag extends Fragment{
	
	
	    String[] titles={"G410AT 性能如何，值得入手吗？","西门子电冰箱怎么样？有详细解释吗","Z50-70有几个配置？",
	    		};  
	   
	    int[] resIds={R.drawable.noanswer,R.drawable.answerd,R.drawable.answerd};  
	
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		View newsLayout = inflater.inflate(R.layout.tab_myqa, container,
                false);  
		
		 ListView listView = (ListView) newsLayout.findViewById(R.id.questions);  
	      
		 
		 listView.setAdapter(new ListViewAdapter(titles,resIds)); 
		
		
		 Button goQue = (Button) newsLayout.findViewById(R.id.myqa_goques);
		 goQue.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent it = new Intent("com.app.xiao2.GetQuestions");
				startActivity(it);
				
			}
		});
		
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
						Intent it = new Intent("com.app.xiao2.Conversation");
						startActivity(it);
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
	public static MyQaFrag newInstance() {
		// TODO Auto-generated method stub
		return new MyQaFrag();
	}  
}
