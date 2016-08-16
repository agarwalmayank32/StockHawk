package com.sam_chordas.android.stockhawk.service;

import android.app.IntentService;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.widget.Toast;

import com.google.android.gms.gcm.GcmNetworkManager;
import com.google.android.gms.gcm.TaskParams;
import com.sam_chordas.android.stockhawk.R;

/**
 * Created by sam_chordas on 10/1/15.
 */
public class StockIntentService extends IntentService {

  public StockIntentService(){
    super(StockIntentService.class.getName());
  }

  public StockIntentService(String name) {
    super(name);
  }

  @Override protected void onHandleIntent(Intent intent) {

    StockTaskService stockTaskService = new StockTaskService(this);

    String tag =intent.getStringExtra("tag");
    Bundle arguments = intent.getExtras();
    try {
      stockTaskService.onRunTask(new TaskParams(tag,arguments));
    }catch (Exception e){
      Handler handler = new Handler(getMainLooper());
      handler.post(new Runnable() {
        @Override
        public void run() {
          Context context = getApplicationContext();
          Toast.makeText(context,context.getString(R.string.error_no_symbol),Toast.LENGTH_SHORT).show();
        }
      });
      e.printStackTrace();
    }
  }
}
