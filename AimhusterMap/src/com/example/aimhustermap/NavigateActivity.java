package com.example.aimhustermap;

import com.umeng.analytics.MobclickAgent;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.Window;

public class NavigateActivity extends Activity{

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		this.requestWindowFeature(Window.FEATURE_NO_TITLE); 
		 ManagerApp app = (ManagerApp)this.getApplication();
	        app.addActivity(this);
	}
	
	@Override
	public boolean onKeyDown(int keyCode,KeyEvent event){
		
		if (keyCode == KeyEvent.KEYCODE_BACK && event.getRepeatCount() == 0) {
			Intent intent = new Intent();
			intent.setClass(NavigateActivity.this, SettingActivity.class);
			NavigateActivity.this.startActivity(intent);
			
			overridePendingTransition(R.anim.push_right_in, R.anim.push_right_out);
			NavigateActivity.this.finish();
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
	    MobclickAgent.onPause(this);
	}
	

}
