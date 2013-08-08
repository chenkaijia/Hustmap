package com.example.aimhustermap;

import java.util.ArrayList;
import java.util.List;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONObject;

import com.umeng.fb.FeedbackAgent;

import android.R.interpolator;
import android.app.Activity;
import android.media.AsyncPlayer;
import android.os.AsyncTask;
import android.os.Bundle;
import android.text.StaticLayout;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;
import com.umeng.analytics.MobclickAgent;

public class FeedbackActivity extends Activity{
	
    public final String FEEDBACK_URL = "http://202.114.18.224/Comment/AddComment";
//    public final String TAG = "";
    
//    public final static String FEEDBACKURL = "202.114.18.224/Comment/AddComment";
    
    public final static String COMMENT = "Comment";
	
//	Button send ;
//	EditText feedbackMs ;
//	JSONParser jsonParser = new JSONParser();
	
//	ProgressBar progressBar;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		this.requestWindowFeature(Window.FEATURE_NO_TITLE);//去掉标题栏
		
		 ManagerApp app = (ManagerApp)this.getApplication();
	        app.addActivity(this);
//		setContentView(R.layout.feedback_activity);

		
		
		FeedbackAgent agent = new FeedbackAgent(this);
		agent.startFeedbackActivity();
		
//		send = (Button)findViewById(R.id.feedback_button);
//		send.setOnClickListener(new View.OnClickListener() {
//			
//			@Override
//			public void onClick(View v) {
//				// TODO Auto-generated method stub
//				System.out.println("onclick");
//				feedbackMs = (EditText)findViewById(R.id.feedback_et);
//				if (feedbackMs.getText().toString().equals("")) {
//					Toast.makeText(getApplicationContext(), "还没输入", Toast.LENGTH_SHORT).show();
//					
//				}
//				else {
//					new Up().execute();
//					System.out.println("send");
//				}
//				
//			}
//		});
	}
	
//	
//	class Up extends AsyncTask<String, Integer, String>{
//
//		@Override
//		protected String doInBackground(String... params) {
//			// TODO Auto-generated method stub
//			feedbackMs = (EditText)findViewById(R.id.feedback_et);
//			String message = feedbackMs.getText().toString();
//			
//			List<NameValuePair> param = new ArrayList<NameValuePair>();
//			param.add(new BasicNameValuePair(COMMENT, message));
//			
//			try {
//				System.out.println("0001");
////				jsonParser.makeHttpRequest(FEEDBACK_URL, "POST", param);
//				JSONObject jsonObject = jsonParser.makeHttpRequest(FEEDBACK_URL, "POST", param);
//				System.out.println("002");
//				String ms = jsonObject.getString(COMMENT);
//				System.out.println("ms---->"+ms);
//				return ms;
//			} catch (Exception e) {
//				// TODO: handle exception
//				e.printStackTrace();
//				return "";
//			}
//			
//		}
//		
//		@Override  
//        protected void onProgressUpdate(Integer... values) {  
//            // 更新进度  
//			System.out.println("update progress");
//			progressBar = (ProgressBar) findViewById(R.id.send_progress);
//			progressBar.setVisibility(View.VISIBLE);
//			progressBar.setMax(100);
//			progressBar.setProgress(values[0]);
//            
//        } 
//	
//	}
	public void onResume() {
	    super.onResume();
	    MobclickAgent.onPause(this);
	}
	public void onPause() {
	    super.onPause();
	    MobclickAgent.onPause(this);
	}
	
}
