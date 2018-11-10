package com.mysummary.myproject.materialdesign.activity;

import android.support.design.widget.Snackbar;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.mysummary.myproject.R;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TextInputActivity extends AppCompatActivity implements View.OnClickListener{

    TextInputLayout text_input_layout ;
    Button btn_sure;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_text_input);

        initView();

    }

    private void initView() {
        text_input_layout = findViewById(R.id.text_input_layout);
        btn_sure = findViewById(R.id.btn_sure);
        btn_sure.setOnClickListener(this);



        text_input_layout.getEditText().addTextChangedListener(new TextWatcher() {

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

    }

    // 判断手机号格式的正则表达式
    private boolean regexTel(String tel) {
        Pattern pattern = Pattern.compile("^(13[0-9]|15[012356789]|17[678]|18[0-9]|14[57])[0-9]{8}$");
        Matcher matcher = pattern.matcher(tel);
        return matcher.matches();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_sure:
                EditText editText = text_input_layout.getEditText();
                String s = editText.getText().toString();

                if (regexTel(s)){
                    //不显示错误信息
                    text_input_layout.setErrorEnabled(false);
                    Snackbar.make(text_input_layout,""+s,Snackbar.LENGTH_SHORT).show();

                }else {
                    // 显示错误提示信息
                    text_input_layout.setError("请输入合法手机号码");

                }
                break;

        }
    }
}
