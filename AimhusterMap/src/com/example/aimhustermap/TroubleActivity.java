package com.example.aimhustermap;

import com.example.aimhustermap.thread.SleepThread;
import com.umeng.analytics.MobclickAgent;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.Window;
import android.widget.Button;

public class TroubleActivity extends Activity{

	Button back ;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_trouble);
		 ManagerApp app = (ManagerApp)this.getApplication();
	        app.addActivity(this);
	        
	        back = (Button)findViewById(R.id.back_trouble);
	        back.setOnClickListener(new View.OnClickListener() {
				
				@Override
				public void onClick(View v) {
					// TODO Auto-generated method stub
					Intent intent = new Intent();
					intent.setClass(TroubleActivity.this, SettingActivity.class);
					TroubleActivity.this.startActivity(intent);
					
					overridePendingTransition(R.anim.push_right_in, R.anim.push_right_out);
					TroubleActivity.this.finish();
				}
			});
	
	}
	
	@Override
	public boolean onKeyDown(int keyCode,KeyEvent event){
		
		if (keyCode == KeyEvent.KEYCODE_BACK && event.getRepeatCount() == 0) {
			Intent intent = new Intent();
			intent.setClass(TroubleActivity.this, SettingActivity.class);
            TroubleActivity.this.startActivity(intent);
			
			overridePendingTransition(R.anim.push_right_in, R.anim.push_right_out);
			TroubleActivity.this.finish();
			return true ;
		}
		
		return false;
	}
	
	public void onResume() {
	    super.onResume();
	    MobclickAgent.onPause(this);
	}
	public void onPause() {
	    super.onPause();
	    SleepThread thread = new SleepThread();
	    thread.start();
	    MobclickAgent.onPause(this);
	}
	
}
