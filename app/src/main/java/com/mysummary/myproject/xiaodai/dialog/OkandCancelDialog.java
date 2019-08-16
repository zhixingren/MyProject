package com.mysummary.myproject.xiaodai.dialog;


import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.view.Display;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;

import com.mysummary.myproject.R;


@SuppressLint("WrongViewCast")
public class OkandCancelDialog extends Dialog {

    public OkandCancelDialog(Context context) {
        super(context);
    }

    public OkandCancelDialog(Context context, int theme) {
        super(context, theme);
    }

    @SuppressLint("WrongViewCast")
    public static class Builder {
        private Context context; //上下文对象
        private String title; //对话框标题
        private String message; //对话框内容
        private String confirm_btnText; //按钮名称“确定”
        private String cancel_btnText; //按钮名称“取消”
        private String three; //按钮名称“取消”
        private View contentView; //对话框中间加载的其他布局界面
        /*按钮坚挺事件*/
        private OnClickListener confirm_btnClickListener;
        private OnClickListener cancel_btnClickListener;
        private OnClickListener three_btnClickListener;
        private View layout;


        public Builder(Context context, String title, String message) {
            this.context = context;
            this.message = message;
            this.title = title;
        }

        /*设置对话框信息*/
        public Builder setMessage(String message) {
            this.message = message;
            return this;
        }

        public Builder setMessage(int message) {
            this.message = (String) context.getText(message);
            return this;
        }

        public Builder setTitle(int title) {
            this.title = (String) context.getText(title);
            return this;
        }

        public Builder setTitle(String title) {
            this.title = title;
            return this;
        }

        public View getView() {
            return layout;
        }

        /**
         * 设置对话框界面
         *
         * @param v View
         * @return
         */
        public Builder setContentView(View v) {
            this.contentView = v;
            return this;
        }

        public Builder setPositiveButton(int confirm_btnText,
                                         OnClickListener listener) {
            this.confirm_btnText = (String) context
                    .getText(confirm_btnText);
            this.confirm_btnClickListener = listener;
            return this;
        }

        public Builder setPositiveButtonThree(String confirm_btnText,
                                              OnClickListener listener) {
            this.three = confirm_btnText;
            this.three_btnClickListener = listener;
            return this;
        }

        public Builder setPositiveButton(String confirm_btnText,
                                         OnClickListener listener) {
            this.confirm_btnText = confirm_btnText;
            this.confirm_btnClickListener = listener;
            return this;
        }


        public Builder setNegativeButton(int cancel_btnText,
                                         OnClickListener listener) {
            this.cancel_btnText = (String) context
                    .getText(cancel_btnText);
            this.cancel_btnClickListener = listener;
            return this;
        }

        public Builder setNegativeButton(String cancel_btnText,
                                         OnClickListener listener) {
            this.cancel_btnText = cancel_btnText;
            this.cancel_btnClickListener = listener;
            return this;
        }

        public OkandCancelDialog create(int resource, String flag) {
            LayoutInflater inflater = (LayoutInflater) context
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            // instantiate the dialog with the custom Theme
            final OkandCancelDialog dialog = new OkandCancelDialog(context, R.style.mystyle);
            layout = inflater.inflate(resource, null);
            dialog.addContentView(layout, new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT));
            dialog.setCanceledOnTouchOutside(true);
            Window dialogWindow = dialog.getWindow();

            if (!flag.isEmpty()) {
                dialogWindow.setWindowAnimations(R.style.DialogAnimation);// 设置动画效果
                // //将设置好的属性set回去
                dialogWindow.setGravity(Gravity.CENTER_HORIZONTAL | Gravity.BOTTOM);
            }

            WindowManager m = ((AppCompatActivity) context).getWindowManager();
            Display d = m.getDefaultDisplay(); // 获取屏幕宽、高用
            WindowManager.LayoutParams p = dialogWindow.getAttributes();
//			val p = attributes ;// 获取对话框当前的参数值
//        p.height = (d.height * 0.4).toInt() // 高度设置为屏幕的0.6
            if (!flag.isEmpty()) {
                p.width = WindowManager.LayoutParams.MATCH_PARENT;

            } else {
                p.width = (int) (d.getWidth() * 0.8); // 宽度设置为屏幕的0.65
            }
            p.height = WindowManager.LayoutParams.WRAP_CONTENT;// 宽度设置为屏幕的0.65
            dialogWindow.setAttributes(p);
            // set the dialog title
            ((TextView) layout.findViewById(R.id.tv_hint_title)).setText(title);
//			((TextView) layout.findViewById(R.id.title)).getPaint().setFakeBoldText(true);
            //((TextView) layout.findViewById(R.id.tv_hint)).setText(message);


            if (flag.equals("list")) {
                ((TextView) layout.findViewById(R.id.tv_content1))
                        .setText(confirm_btnText);
                if (confirm_btnClickListener != null) {
                    ((TextView) layout.findViewById(R.id.tv_content1))
                            .setOnClickListener(new View.OnClickListener() {
                                public void onClick(View v) {
                                    confirm_btnClickListener.onClick(dialog,
                                            DialogInterface.BUTTON_NEUTRAL);
                                }
                            });
                }

                ((TextView) layout.findViewById(R.id.tv_content2))
                        .setText(three);
                if (three_btnClickListener != null) {
                    ((TextView) layout.findViewById(R.id.tv_content2))
                            .setOnClickListener(new View.OnClickListener() {
                                public void onClick(View v) {
                                    three_btnClickListener.onClick(dialog,
                                            DialogInterface.BUTTON_NEUTRAL);
                                }
                            });
                }

                ((TextView) layout.findViewById(R.id.tv_content1))
                        .setText(cancel_btnText);
                if (cancel_btnClickListener != null) {
                    ((TextView) layout.findViewById(R.id.tv_content1))
                            .setOnClickListener(new View.OnClickListener() {
                                public void onClick(View v) {
                                    cancel_btnClickListener.onClick(dialog,
                                            DialogInterface.BUTTON_NEUTRAL);
                                }
                            });
                }


            } else {

                // set the confirm button
                if (confirm_btnText != null) {
                    ((TextView) layout.findViewById(R.id.tv_ok))
                            .setText(confirm_btnText);
                    if (confirm_btnClickListener != null) {
                        ((TextView) layout.findViewById(R.id.tv_ok))
                                .setOnClickListener(new View.OnClickListener() {
                                    public void onClick(View v) {
                                        confirm_btnClickListener.onClick(dialog,
                                                DialogInterface.BUTTON_POSITIVE);
                                    }
                                });
                    }
                } else {
                    // if no confirm button just set the visibility to GONE
                    layout.findViewById(R.id.tv_ok).setVisibility(
                            View.GONE);
                }
                // set the cancel button
                if (cancel_btnText != null) {
                    ((TextView) layout.findViewById(R.id.tv_cancle))
                            .setText(cancel_btnText);
                    if (cancel_btnClickListener != null) {
                        ((TextView) layout.findViewById(R.id.tv_cancle))
                                .setOnClickListener(new View.OnClickListener() {
                                    public void onClick(View v) {
                                        cancel_btnClickListener.onClick(dialog,
                                                DialogInterface.BUTTON_NEGATIVE);
                                    }
                                });
                    }
                } else {
                    // if no confirm button just set the visibility to GONE
                    layout.findViewById(R.id.tv_cancle).setVisibility(
                            View.GONE);
                }

            }


            dialog.setContentView(layout);
            return dialog;
        }

    }
}
