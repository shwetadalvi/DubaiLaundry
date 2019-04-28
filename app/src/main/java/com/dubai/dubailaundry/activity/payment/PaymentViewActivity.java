package com.dubai.dubailaundry.activity.payment;


import android.content.Intent;
import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;

import com.dubai.dubailaundry.Almosky;
import com.dubai.dubailaundry.R;
import com.dubai.dubailaundry.TabHostActivity;
import com.dubai.dubailaundry.common.BaseActivity;
import com.dubai.dubailaundry.utils.constants.ApiConstants;
import com.leo.simplearcloader.SimpleArcDialog;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;

import org.json.JSONException;
import org.json.JSONObject;

import androidx.annotation.Nullable;
import cn.pedant.SweetAlert.SweetAlertDialog;
import cz.msebera.android.httpclient.entity.StringEntity;
import cz.msebera.android.httpclient.message.BasicHeader;
import cz.msebera.android.httpclient.protocol.HTTP;


public class PaymentViewActivity extends BaseActivity {

    String orderData;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_paymentview);

        WebView wv=(WebView)findViewById(R.id.wv_payment);

        wv.setWebViewClient(new CustomWebViewClient());
        WebSettings webSetting = wv.getSettings();
        webSetting.setJavaScriptEnabled(true);
        webSetting.setDisplayZoomControls(true);


        String tranId= getIntent().getStringExtra("tranID");
        String payPage= getIntent().getStringExtra("payPage");
        orderData= getIntent().getStringExtra("orderData");

        String html ="<html>\n" +
                "\n" +
                "<body onload=\"document.frm1.submit()\">\n" +
                "\n" +
                "\n" +
                "<form name=\"frm1\" action=\""+payPage+"\" method=\"post\"> \n" +
                "  <input type='Hidden' name='TransactionID' value='"+tranId+"'/>\n" +
                "  <input type=\"submit\" value=\"Redirecting....\">\n" +
                "</form>\n" +
                "</body>\n" +
                "</html>";

        wv.loadData(html, "text/html", "utf-8");

        wv.setWebViewClient(new WebViewClient() {


            public void onPageFinished(WebView view, String url) {
                
                
                if(url.equals("http://148.72.64.138:3007/payment/message")){
                    
                    finishOrder();
                }

            }
        });

    }

    private void finishOrder() {

        try{

            StringEntity entity = null;
            final SimpleArcDialog dialog = new SimpleArcDialog(PaymentViewActivity.this);
            try {
                entity = new StringEntity(orderData.toString());
                entity.setContentEncoding(new BasicHeader(HTTP.CONTENT_TYPE, "application/json"));
                dialog.show();
            } catch (Exception e) {
//Exception
            }

            String url = ApiConstants.BaseUrl + ApiConstants.normalorderUrl;

            new AsyncHttpClient().post(null, url, entity, "application/json", new AsyncHttpResponseHandler() {
                @Override
                public void onSuccess(int statusCode, cz.msebera.android.httpclient.Header[] headers, byte[] responseBody) {
                    try {
                        dialog.dismiss();
                        String object = new String(responseBody);
                        JSONObject jsonObject = new JSONObject(object);
                        String result = jsonObject.getString("result");

                        if (result.equals("Data Inserted")) {
                            new SweetAlertDialog(PaymentViewActivity.this, SweetAlertDialog.NORMAL_TYPE)
                                    .setTitleText("Success")
                                    .setContentText("Success")
                                    .setConfirmText("Ok")
                                    .setConfirmClickListener(new SweetAlertDialog.OnSweetClickListener() {
                                        @Override
                                        public void onClick(SweetAlertDialog sDialog) {


                                            sDialog.dismissWithAnimation();

                                            Almosky.getInst().setIronList(null);
                                            Almosky.getInst().setCartcount(0);
                                            Almosky.getInst().setWashList(null);
                                            Almosky.getInst().setDrycleanList(null);
                                            Almosky.getInst().setCartamount(0);
                                            // Almosky.getInst().setServiceId(0);
                                            Almosky.getInst().setAddress("");
                                            Almosky.getInst().setNisabClub(false);

                                            Intent go = new Intent(PaymentViewActivity.this, TabHostActivity.class);
                                            go.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_CLEAR_TOP);
                                            startActivity(go);


                                        }
                                    })
                                    .show();
                            // Toast.makeText(getApplicationContext(),"success",Toast.LENGTH_LONG).show();
                        }
                    } catch (JSONException e) {
                        Toast.makeText(getApplicationContext(), "Error occure", Toast.LENGTH_LONG).show();
                    }
                }

                @Override
                public void onFailure(int statusCode, cz.msebera.android.httpclient.Header[] headers, byte[] responseBody, Throwable error) {

                }
            });


        }catch (Exception e){

        }
    }

    private class CustomWebViewClient extends WebViewClient{
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            view.loadUrl(url);
            return true;
        }
    }
}
