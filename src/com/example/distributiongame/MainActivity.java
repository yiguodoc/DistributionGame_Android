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
	        //支持JS
	        browser.getSettings().setJavaScriptEnabled(true);
	        // 如果页面中链接，如果希望点击链接继续在当前browser中响应，  
	        // 而不是新开Android的系统browser中响应该链接，必须覆盖webview的WebViewClient对象  
	        browser.setWebViewClient(new WebViewClient() {  
	            public boolean shouldOverrideUrlLoading(WebView view, String url)  
	            {   
	                //  重写此方法表明点击网页里面的链接还是在当前的webview里跳转，不跳到浏览器那边  
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
	            dialog = ProgressDialog.show(this,null,"页面加载中，请稍后..");  
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