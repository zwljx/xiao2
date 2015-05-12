package com.app.xiao2;





import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.ImageLoader.ImageCache;
import com.android.volley.toolbox.ImageLoader.ImageListener;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.Parcelable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.util.LruCache;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.TextView;
import android.widget.Toast;





public class IndexFragment extends Fragment implements OnClickListener {
	
	
	
	

	

	

	private static final String TAG = "xiao2 Indextab";
	private int screenWidth;
	private float xDown,xUp;
	boolean goAnno=false;
	boolean isAdStart= false;
	private  MyHandler mHandler = new MyHandler();
	public static final int GOTOANNO = 0,ADSCROLL=1;
	
	//adbanner 
	
	public static String IMAGE_CACHE_PATH="imageloader/Cache";//
	
	private ViewPager adViewpager;
	private List<ImageView> imageViews;//
	
	private List<View> dots;//
	private List<View> dotList;
	
	private int currentItem = 0;//
	private View dot0,dot1,dot2,dot3,dot4;
	
	//
	private ScheduledExecutorService scheduledExecutorService;
	
	//
	private ImageLoader mImageLoader;
	private RequestQueue reque;
	
	
	//
	private List<AdDomain> adList;
	
	//
	private TextView annoArea;
	
	//
	private ImageButton qiangButton;
	
	
	 public static Fragment newInstance() {  
         return new IndexFragment();  
     }  
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		
		View newsLayout = inflater.inflate(R.layout.tab_index, container,  
                false);
		
		DisplayMetrics displaymetrics = new DisplayMetrics();
		getActivity().getWindowManager().getDefaultDisplay().getMetrics(displaymetrics);
		screenWidth = displaymetrics.widthPixels;
		
		
		//
		annoArea=(TextView)newsLayout.findViewById(R.id.announce_area);
		annoArea.setOnClickListener(this);
		
		//
		qiangButton=(ImageButton)newsLayout.findViewById(R.id.qiang);
		qiangButton.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent it = new Intent("com.app.xiao2.GetQuestions");
				startActivity(it);
				
			}
		});
		
		//dbanner
		reque= Xiao2Home.getRQInstance(getActivity());
		
		 mImageLoader = new ImageLoader(reque, new BitmapCache()); 
		 
		 initAdData(newsLayout);  
		 
		 
		 
		
        startAd();  
         
        return newsLayout; 
	}
	
	


	private void initAdData(View newsLayout) {
		 adList = getBannerAd();  
		  
	        imageViews = new ArrayList<ImageView>();  
	  
	        // 鐐� 
	        dots = new ArrayList<View>();  
	        dotList = new ArrayList<View>();  
	        dot0 = newsLayout.findViewById(R.id.v_dot0);  
	        dot1 = newsLayout.findViewById(R.id.v_dot1);  
	        dot2 = newsLayout.findViewById(R.id.v_dot2);  
	        dot3 = newsLayout.findViewById(R.id.v_dot3);  
	        dot4 = newsLayout.findViewById(R.id.v_dot4);  
	        dots.add(dot0);  
	        dots.add(dot1);  
	        dots.add(dot2);  
	        dots.add(dot3);  
	        dots.add(dot4);  
	          
	        
	  
	        adViewpager = (ViewPager) newsLayout.findViewById(R.id.baner_vp);  
	        adViewpager.setAdapter(new AdViewPagerAdapter());// 
	        // 
	        adViewpager.setOnPageChangeListener(new MyPageChangeListener());  
	        addDynamicView();  
		
	}




	private void addDynamicView() {
		// 
        for (int i = 0; i < adList.size(); i++) {  
            ImageView imageView = new ImageView(getActivity());  
            // 
            
            ImageListener listener = ImageLoader.getImageListener(imageView,  
			        R.drawable.network_failed, R.drawable.network_failed); 
            mImageLoader.get(adList.get(i).getImgUrl(),listener);  
            imageView.setScaleType(ScaleType.CENTER_CROP);  
            imageViews.add(imageView);  
            dots.get(i).setVisibility(View.VISIBLE);  
            dotList.add(dots.get(i));  
        }  
	}




	private List<AdDomain> getBannerAd() {
		 
	        List<AdDomain> adList = new ArrayList<AdDomain>();  
	  
	        AdDomain adDomain = new AdDomain();  
	        adDomain.setId("108078");  
	        
	        adDomain.setImgUrl("http://g.hiphotos.baidu.com/image/w%3D310/sign=bb99d6add2c8a786be2a4c0f5708c9c7/d50735fae6cd7b8900d74cd40c2442a7d9330e29.jpg");  
	       
	        adList.add(adDomain);  
	  
	        AdDomain adDomain2 = new AdDomain();  
	        adDomain2.setId("108078");  
	      
	        adDomain2.setImgUrl("http://g.hiphotos.baidu.com/image/w%3D310/sign=7cbcd7da78f40ad115e4c1e2672e1151/eaf81a4c510fd9f9a1edb58b262dd42a2934a45e.jpg");  
	     
	        adList.add(adDomain2);  
	  
	        AdDomain adDomain3 = new AdDomain();  
	        adDomain3.setId("108078");  
	         
	        adDomain3.setImgUrl("http://e.hiphotos.baidu.com/image/w%3D310/sign=392ce7f779899e51788e3c1572a6d990/8718367adab44aed22a58aeeb11c8701a08bfbd4.jpg");  
	      
	        adList.add(adDomain3);  
	  
	        AdDomain adDomain4 = new AdDomain();  
	        adDomain4.setId("108078");  
	       
	        adDomain4.setImgUrl("http://d.hiphotos.baidu.com/image/w%3D310/sign=54884c82b78f8c54e3d3c32e0a282dee/a686c9177f3e670932e4cf9338c79f3df9dc55f2.jpg");  
	      
	        adList.add(adDomain4);  
	  
	        AdDomain adDomain5 = new AdDomain();  
	        adDomain5.setId("108078");  
	       
	        adDomain5.setImgUrl("http://e.hiphotos.baidu.com/image/w%3D310/sign=66270b4fe8c4b7453494b117fffd1e78/0bd162d9f2d3572c7dad11ba8913632762d0c30d.jpg");  
	       
	        adList.add(adDomain5);  
	  
	        return adList;  
	    }  
	




	

	
	
	public class AdViewPagerAdapter extends PagerAdapter{

		@Override
		public int getCount() {
			// TODO Auto-generated method stub
			return adList.size();
		}

		@Override
		public void destroyItem(View container, int position, Object object) {
			// TODO Auto-generated method stub
			((ViewPager) container).removeView((View) object);
		}

		@Override
		public void finishUpdate(View container) {
			
		}

		@Override
		public Object instantiateItem(ViewGroup container, int position) {
			// TODO Auto-generated method stub
			ImageView iv = imageViews.get(position);
			((ViewPager)container).addView(iv);
			final AdDomain adDomain = adList.get(position);
			iv.setOnClickListener(new OnClickListener() {
				
				@Override
				public void onClick(View v) {
					// 
					
				}
			});
			return iv;
		}

		@Override
		public void restoreState(Parcelable state, ClassLoader loader) {
			
		}

		@Override
		public Parcelable saveState() {
			return null;
		}

		@Override
		public void startUpdate(View container) {
			
		}

		@Override
		public boolean isViewFromObject(View arg0, Object arg1) {
			// TODO Auto-generated method stub
			return arg0 == arg1;
		}
		
	}
	
	
	private void startAd()
	{
		scheduledExecutorService = Executors.newSingleThreadScheduledExecutor();
		scheduledExecutorService.scheduleAtFixedRate(new ScrollTask(), 1, 2, TimeUnit.SECONDS);
	     isAdStart=true;
	}
	
	private class ScrollTask implements Runnable{

		@Override
		public void run() {
			synchronized (adViewpager) {
			 currentItem=(currentItem+1)%imageViews.size();
			 Message msg = mHandler.obtainMessage(ADSCROLL);
				mHandler.sendMessage(msg);			 
			}
			
		}
		
	}
	
	
	@Override
	public void onResume() {
		// TODO Auto-generated method stub
		super.onResume();
		if(!isAdStart)
			startAd();
	}

	//fragment 
	@Override
	public void onStop() {
		// TODO Auto-generated method stub
		super.onStop();
		scheduledExecutorService.shutdown();
		isAdStart=false;
	}
	
	
	public class BitmapCache implements ImageCache {  
		  
	    private LruCache<String, Bitmap> mCache;  
	  
	    public BitmapCache() {  
	        int maxSize = 10 * 1024 * 1024;  
	        mCache = new LruCache<String, Bitmap>(maxSize) {  
	            @Override  
	            protected int sizeOf(String key, Bitmap bitmap) {  
	                return bitmap.getRowBytes() * bitmap.getHeight();  
	            }  
	        };  
	    }  
	  
	    @Override  
	    public Bitmap getBitmap(String url) {  
	        return mCache.get(url);  
	    }  
	  
	    @Override  
	    public void putBitmap(String url, Bitmap bitmap) {  
	        mCache.put(url, bitmap);  
	    }  
	  
	}  
	
	 private class MyPageChangeListener implements OnPageChangeListener {  
		  
	        private int oldPosition = 0;  
	  
	        @Override  
	        public void onPageScrollStateChanged(int arg0) {  
	              
	        }  
	  
	        @Override  
	        public void onPageScrolled(int arg0, float arg1, int arg2) {  
	              
	        }  
	  
	        @Override  
	        public void onPageSelected(int position) {  
	            currentItem = position;  
	            AdDomain adDomain = adList.get(position);  
	            
	            dots.get(oldPosition).setBackgroundResource(R.drawable.dot_normal);  
	            dots.get(position).setBackgroundResource(R.drawable.dot_focused);  
	            oldPosition = position;  
	        }  
	    }  
	
	private class MyHandler extends Handler{

		

		@Override
		public void handleMessage(Message msg) {
			// TODO Auto-generated method stub
			switch(msg.what){
			
			case ADSCROLL:
				adViewpager.setCurrentItem(currentItem);
				break;
				
			}
		}
		
	}

   //
	@Override
	public void onClick(View v) {
		
	     
	     ViewPager vp = (ViewPager) getActivity().findViewById(R.id.viewpager);
	     vp.setCurrentItem(1);
		
	}
	
}
