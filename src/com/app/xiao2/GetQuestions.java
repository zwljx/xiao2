package com.app.xiao2;

import com.app.xiao2.MyQaFrag.ListViewAdapter;

import android.app.Activity;
import android.app.Instrumentation;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.BaseAdapter;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

public class GetQuestions extends Activity{
	
    String[] titles={"G410AT 性能如何，值得入手吗？","西门子电冰箱怎么样？有详细解释吗","Z50-70有几个配置？",
    		"N4030内存最大扩展","G410AT散热如何？","1100共有几个颜色可以选择?"};  
   
    int[] resIds={R.drawable.noanswer,R.drawable.answering,R.drawable.answerd,
    		R.drawable.answering,R.drawable.answerd,R.drawable.answerd};  



@Override
protected void onCreate(Bundle savedInstanceState) {
	// TODO Auto-generated method stub
	super.onCreate(savedInstanceState);
	setContentView(R.layout.getquestions);
 ListView listView = (ListView) findViewById(R.id.allquestions);  
      
	 
	 listView.setAdapter(new ListViewAdapter(titles,resIds)); 
	 ImageButton back = (ImageButton) findViewById(R.id.que_back);
		back.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
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
        LayoutInflater inflater = (LayoutInflater)getSystemService(Context.LAYOUT_INFLATER_SERVICE);  

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
