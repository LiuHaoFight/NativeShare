
package com.siemens.plugins.NativeShare;

import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.CordovaInterface;
import org.apache.cordova.CordovaWebView;

import android.util.Log;
import android.content.Intent;
import android.content.Context;

import org.json.JSONArray;
import org.json.JSONException;

/**
 * This class echoes a string called from JavaScript.
 */
public class NativeShare extends CordovaPlugin {

    private static final String TAG = NativeShare.class.getSimpleName();
    private Context mContext = null;

    @Override
    public void initialize(CordovaInterface cordova, CordovaWebView webView) {
        super.initialize(cordova, webView);
        this.mContext = cordova.getActivity().getApplicationContext();
    }

    @Override
    public void onResume(boolean multitasking) {
        super.onResume(multitasking);
        Log.d(TAG, "onResume");
    }

    @Override
    public void onPause(boolean multitasking) {
        super.onPause(multitasking);
        Log.d(TAG, "onPause");
    }

    @Override
    public boolean execute(String action, JSONArray args, CallbackContext callbackContext) throws JSONException {
        switch (action) {
            case "shareText":
                String text = args.getString(0);
                String title = args.getString(1);
                Intent intent = new Intent(Intent.ACTION_SEND);
                intent.setType("text/plain");
                intent.putExtra(Intent.EXTRA_TEXT, text);
                Intent shareIntent = Intent.createChooser(intent, title);
                shareIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                this.mContext.startActivity(shareIntent);
                return true;
        }
        return false;
    }

}
