package com.mysummary.myproject.xiaodai.dialog;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.PixelFormat;
import android.graphics.drawable.ColorDrawable;
import android.view.Gravity;
import android.view.View;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.PopupWindow;

import com.mysummary.myproject.R;


public class WindowUtils {

	public static View showInWindow(Context context, int resId, int x, int y) {
		View view = View.inflate(context, resId, null);
		WindowManager wm = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);

		WindowManager.LayoutParams params = new WindowManager.LayoutParams();
		params.width = WindowManager.LayoutParams.WRAP_CONTENT;
		params.height = WindowManager.LayoutParams.WRAP_CONTENT;
		params.gravity = Gravity.TOP | Gravity.LEFT;
		params.format = PixelFormat.TRANSLUCENT;
		params.flags = WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE | WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON;
		params.type = WindowManager.LayoutParams.TYPE_PRIORITY_PHONE;
		params.x = x;
		params.y = y;
		wm.addView(view, params);
		return view;
	}

	@SuppressLint("ResourceAsColor")
	public static PopupWindow showPopWindow(Context context, View positionView, View view, int x, int y) {

		PopupWindow popwindow = new PopupWindow(view, LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
		
		popwindow.setOutsideTouchable(true);
		
		popwindow.setBackgroundDrawable(new ColorDrawable(android.R.color.transparent));
		popwindow.showAtLocation(positionView, Gravity.LEFT | Gravity.TOP, x, y);
		
		return popwindow;
	}

	/**
	 * 一个带监听的确定键的dialog
	 * @param context 当前activity的上下文
	 * @param title dialog标题
	 * @param message dialog内容
	 * @param ok_text 确定键内容
	 */
//	public static void OkDialog(Context context, String title, String message, String ok_text, DialogInterface.OnClickListener okListener){
//		OkDialog.Builder builder = new OkDialog.Builder(context,title,message,ok_text);
//		builder.setPositiveButton(ok_text, okListener);
//		builder.create(R.layout.dialog_ok).show();
//
//	}

	/**
	 * 一个确定键的dialog
	 * @param context 当前activity的上下文
	 * @param title dialog标题
	 * @param message dialog内容
	 * @param ok_text 确定键内容
	 */
//	public static void OkDialog(Context context, String title, String message, String ok_text){
//		OkDialog.Builder builder = new OkDialog.Builder(context,title,message,ok_text);
//		builder.create(R.layout.dialog_ok).show();
//	}
	/**
	 * 确定键和取消键的dialog
	 * @param context 当前activity的上下文
	 * @param title dialog标题
	 * @param message dialog内容
	 * @param ok_text 确定键内容
	 * @param cancel_text 取消键内容
	 * @param listener 确定或取消的监听 实现它来进行接下来的操作 DialogInterface.OnClickListener 
	 */
	public static void OkandCancleDialog(Context context, String title, String message, String ok_text, String cancel_text, DialogInterface.OnClickListener okListener, DialogInterface.OnClickListener cancelListener){
		OkandCancelDialog.Builder builder = new OkandCancelDialog.Builder(context,title,message);
		builder.setPositiveButton(ok_text, okListener);
		builder.setNegativeButton(cancel_text, cancelListener);
		builder.create(R.layout.dialog_ok_cancle,"").show();
	}


	public static void listDialog(String flag,Context context, String title, String message, String ok_text, String cancel_text, String three_text,DialogInterface.OnClickListener okListener, DialogInterface.OnClickListener cancelListener,DialogInterface.OnClickListener three){
		OkandCancelDialog.Builder builder = new OkandCancelDialog.Builder(context,title,message);
		builder.setPositiveButton(ok_text, okListener);
		builder.setNegativeButton(cancel_text, cancelListener);
		builder.setPositiveButtonThree(three_text,three);

		builder.create(R.layout.dialog_list_cancle,"list").show();
	}


}
