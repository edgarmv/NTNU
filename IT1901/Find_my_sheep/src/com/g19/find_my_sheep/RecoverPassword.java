package com.g19.find_my_sheep;


import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;

import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class RecoverPassword extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_recover_password);
		Button reg = (Button) findViewById(R.id.b3Recover);
		reg.setOnClickListener(new View.OnClickListener() {
		    
        	public void onClick(View arg0) {
        		new recoverPassword().execute();
        	}
			
		});
		
	}
	
private class recoverPassword extends AsyncTask<Void,Void,Integer>{

	
	@Override
	protected void onPostExecute(Integer result) {
		// TODO Auto-generated method stub
		super.onPostExecute(result);
		TextView display = (TextView) findViewById(R.id.tvLog);
		display.setText(Integer.toString(result));
		new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
            	Intent intent = new Intent(RecoverPassword.this, ResetPassword.class);
            	startActivity(intent);
            	finish();
            }
        }, 3000);
	}

	@Override
	protected Integer doInBackground(Void... params) {
		// TODO Auto-generated method stub
		return reg();
		
	}
	
	private int reg() {
		
		HttpClient httpclient = new DefaultHttpClient();
		HttpPost httppost = new HttpPost("http://129.241.126.66/cgi-bin/recovery.py");
	 
	    final EditText username = (EditText) findViewById(R.id.etUser);

	    String usernameString = username.getText().toString();
	    
	    try {
		    // Add your data
		    List<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>(1);
		    nameValuePairs.add(new BasicNameValuePair("username", usernameString));
		    
		    httppost.setEntity(new UrlEncodedFormEntity(nameValuePairs));
		 
		    // Execute HTTP Post Request
		    HttpResponse response = httpclient.execute(httppost);
		    return response.getStatusLine().getStatusCode();
		    
		 
		} catch (ClientProtocolException e) {
		    // TODO Auto-generated catch block
		} catch (IOException e) {
		    // TODO Auto-generated catch block
		} catch(Exception e){
			e.printStackTrace();
		}
	    
	    return 0;
		}
	}
}

		
		
	
	

