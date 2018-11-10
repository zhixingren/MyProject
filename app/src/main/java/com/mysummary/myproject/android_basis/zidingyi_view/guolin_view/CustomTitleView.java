package com.mysummary.myproject.android_basis.zidingyi_view.guolin_view;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.view.View;

import com.mysummary.myproject.R;


public class CustomTitleView extends View
{
	/**
	 *
	 */
	private String mTitleText;
	/**
	 *
	 */
	private int mTitleTextColor;
	/**
	 *
	 */
	private int mTitleTextSize;

	/**
	 *
	 */
	private Rect mBound;
	private Paint mPaint;

	public CustomTitleView(Context context, AttributeSet attrs)
	{
		this(context, attrs, 0);
	}

	public CustomTitleView(Context context)
	{
		this(context, null);
	}

	/**
	 *
	 * 
	 * @param context
	 * @param attrs
	 * @param defStyle
	 */
	public CustomTitleView(Context context, AttributeSet attrs, int defStyle)
	{
		super(context, attrs, defStyle);
		/**
		 *
		 */
		TypedArray a = context.getTheme().obtainStyledAttributes(attrs, R.styleable.CustomTitleView, defStyle, 0);

        mTitleText = a.getString(R.styleable.CustomTitleView_titleText);
        mTitleTextColor = a.getColor(R.styleable.CustomTitleView_titleTextColor,Color.BLACK);
        mTitleTextSize = a.getDimensionPixelSize(R.styleable.CustomTitleView_titleTextSize,(int) TypedValue.applyDimension(
                TypedValue.COMPLEX_UNIT_SP, 16, getResources().getDisplayMetrics()));



		a.recycle();

		/**
		 * ��û����ı��Ŀ�͸�
		 */
		mPaint = new Paint();
		mPaint.setTextSize(mTitleTextSize);
		// mPaint.setColor(mTitleTextColor);
		mBound = new Rect();
		mPaint.getTextBounds(mTitleText, 0, mTitleText.length(), mBound);

		this.setOnClickListener(new OnClickListener()
		{

			@Override
			public void onClick(View v)
			{
				mTitleText = randomText();
				postInvalidate();
			}

		});

	}
	private String randomText()
	{
		Random random = new Random();
		Set<Integer> set = new HashSet<Integer>();
		while (set.size() < 4)
		{
			int randomInt = random.nextInt(10);
			set.add(randomInt);
		}
		StringBuffer sb = new StringBuffer();
		for (Integer i : set)
		{
			sb.append("" + i);
		}

		return sb.toString();
	}

	@Override
	protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec)
	{
		 super.onMeasure(widthMeasureSpec, heightMeasureSpec);
//
		int width = 0;
		int height = 0;

		/**
		 * ���ÿ��
		 */
		int specMode = MeasureSpec.getMode(widthMeasureSpec);
		int specSize = MeasureSpec.getSize(widthMeasureSpec);
		switch (specMode)
		{
		case MeasureSpec.EXACTLY:// ��ȷָ����
			width = getPaddingLeft() + getPaddingRight() + specSize;
            Log.e("111",width+"");
			break;
		case MeasureSpec.AT_MOST:// һ��ΪWARP_CONTENT
			width = getPaddingLeft() + getPaddingRight() + mBound.width();
            Log.e("222",width+"");
			break;
		}

		/**
		 * ���ø߶�
		 */
		specMode = MeasureSpec.getMode(heightMeasureSpec);
		specSize = MeasureSpec.getSize(heightMeasureSpec);
		switch (specMode)
		{
		case MeasureSpec.EXACTLY:// ��ȷָ����
			height = getPaddingTop() + getPaddingBottom() + specSize;
            Log.e("333",height+"");
            break;
		case MeasureSpec.AT_MOST:// һ��ΪWARP_CONTENT
			height = getPaddingTop() + getPaddingBottom() + mBound.height();
            Log.e("444",height+"");
			break;
            case MeasureSpec.UNSPECIFIED:
                height = 200;
//                Log.e("555",height+"");
            break;
        }

		setMeasuredDimension(width, height);

	}

	@Override
	protected void onDraw(Canvas canvas)
	{
		mPaint.setColor(Color.YELLOW);
		canvas.drawRect(0, 0, getMeasuredWidth(), getMeasuredHeight(), mPaint);

		mPaint.setColor(mTitleTextColor);
		canvas.drawText(mTitleText, getWidth() / 2 - mBound.width() / 2, getHeight() / 2 + mBound.height() / 2, mPaint);
	}
}
