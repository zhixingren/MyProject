package com.mysummary.myproject.utils;


import android.content.Context;
import android.graphics.PixelFormat;
import android.view.Gravity;
import android.view.View;
import android.view.WindowManager;
import android.widget.Toast;

import com.mysummary.myproject.app.QiandaoApplication;


public class ToastUtil {
	private static Toast toast;
	/**
	 * 连续弹的吐司
	 * @param text
	 */
	public static void showToast(String text){
		if(toast==null){
			toast = Toast.makeText(QiandaoApplication.getContext(), text, Toast.LENGTH_SHORT);
		}
		toast.setText(text);
		toast.show();
	}
	
	public static void showToast(Integer num){
		if(toast==null){
			toast = Toast.makeText(QiandaoApplication.getContext(), num, Toast.LENGTH_SHORT);
		}
		toast.setText(num);
		toast.show();
	}
	
	
	public static View showInWindow(Context context, int resId) {
		// 视图
		View view = View.inflate(context, resId, null);
		// 获取管理�?
		WindowManager wm = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
		// wm.addView(视图, 布局参数); xml
		final WindowManager.LayoutParams params = new WindowManager.LayoutParams();
		params.height = WindowManager.LayoutParams.WRAP_CONTENT;// layout_height
		params.width = WindowManager.LayoutParams.WRAP_CONTENT;// layout_width
		params.gravity = Gravity.TOP | Gravity.LEFT;// 左上对齐
		params.x = 10;// 认为顶级布局是一相绝对布�?
		params.y = 10;
		// 相关参数
		//toast不需要支�? touch事件
//		params.flags = WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE// 不能聚集
//				| WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE// 不能拖动
//				| WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON;// 高亮
		//支持touch
		params.flags =  WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE|
				WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON;// 高亮
		params.format = PixelFormat.TRANSLUCENT;// 背景透明 background
//		params.type = WindowManager.LayoutParams.TYPE_TOAST;// 类型  涉及显示的叠加顺�?
		params.type = WindowManager.LayoutParams.TYPE_PRIORITY_PHONE;// 提高显示级别
		wm.addView(view, params);
		return view;
	}

	/**
	 * 关闭
	 * 
	 * @param context
	 * @param view
	 */
	public static void dismissInWindow(Context context, View view) {
		// 获取管理�?
		WindowManager wm = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);

		wm.removeView(view);
	}
}
