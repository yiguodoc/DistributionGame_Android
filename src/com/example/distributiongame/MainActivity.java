package com.example.distributiongame;

import android.net.Uri;
import android.os.Bundle;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.view.KeyEvent;
import android.view.Window;
import android.view.Menu;
import android.webkit.WebView;
import android.webkit.WebChromeClient;
import android.webkit.WebViewClient;

public class MainActivity extends Activity {
	final Activity activity = this;  
	ProgressDialog dialog = null;  
	WebView browser;
	
	   @SuppressLint("SetJavaScriptEnabled")
	@Override
	    protected void onCreate(Bundle savedInstanceState) {
	        super.onCreate(savedInstanceState);
	        setContentView(R.layout.activity_main);
	        
	        //WebView
	        browser=(WebView)findViewById(R.id.webView);
	        

	        loadUrl("http://169.254.62.188:8080");
	        //֧��JS
	        browser.getSettings().setJavaScriptEnabled(true);
	        // ���ҳ�������ӣ����ϣ��������Ӽ����ڵ�ǰbrowser����Ӧ��  
	        // �������¿�Android��ϵͳbrowser����Ӧ�����ӣ����븲��webview��WebViewClient����  
	        browser.setWebViewClient(new WebViewClient() {  
	            public boolean shouldOverrideUrlLoading(WebView view, String url)  
	            {   
	                //  ��д�˷������������ҳ��������ӻ����ڵ�ǰ��webview����ת��������������Ǳ�  
	                view.loadUrl(url);  
	                return true;  
	            }  
	            
	            @Override  
                public void onPageFinished(WebView view,String url)  
                {  
                    dialog.dismiss();  
                }  
	        });    
	          
	    }  
	    
	   public void loadUrl(String url)  
	    {  
	        if(browser != null)  
	        {  
	        	browser.loadUrl(url);  
	            dialog = ProgressDialog.show(this,null,"ҳ������У����Ժ�..");  
	            browser.reload();  
	        }  
	    }  
	   
	    //go back
	    @Override  
	    public boolean onKeyDown(int keyCode, KeyEvent event) {  
	        WebView browser=(WebView)findViewById(R.id.webView);  
	        // Check if the key event was the Back button and if there's history  
	        if ((keyCode == KeyEvent.KEYCODE_BACK) && browser.canGoBack()) {  
	            browser.goBack();  
	            return true;  
	        }  
	      //  return true;  
	        // If it wasn't the Back key or there's no web page history, bubble up to the default  
	        // system behavior (probably exit the activity)  
	        return super.onKeyDown(keyCode, event);  
	    } 
	    
}