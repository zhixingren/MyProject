package com.mysummary.myproject.broadcast.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.widget.Toast;

/**
 * Created by xingzhi on 2018/4/21.
 */

public class NetworkStateReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        String networkState = getNetworkState(context);
        Toast.makeText(context, "网络状态 : " + networkState, Toast.LENGTH_LONG).show();
    }

    // 判断联网状态
    private String getNetworkState(Context context) {
        // 获得连接管理者
        ConnectivityManager connManager = (ConnectivityManager) context
                .getSystemService(Context.CONNECTIVITY_SERVICE);

        // 通过连接管理者获取网络连接信息
        NetworkInfo info = connManager.getActiveNetworkInfo();
        if (info == null) {
            return "Network Disconnected";
        } else if (info.getType() == ConnectivityManager.TYPE_MOBILE) {
            return "Mobile Network";
        } else if (info.getType() == ConnectivityManager.TYPE_WIFI) {
            return "Wifi Network";
        }
        return null;
    }

}
