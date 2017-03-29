package com.wl.testdialogfragment;

import android.content.DialogInterface;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;

/**
 * Created by le on 2017/3/29.
 */

public class PromptDialog extends DialogFragment {
    private Button mBtn;

    public static final PromptDialog getintens() {
        PromptDialog pd = new PromptDialog();
        return pd;
    }


    private PromptDialog() {

    }


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        //取消标题
        getDialog().requestWindowFeature(Window.FEATURE_NO_TITLE);
        //设置dialog外的是否点击取消
        getDialog().setCanceledOnTouchOutside(false);
        //设置返回键点击
        setCancelable(true);
        // 背景透明，只有动画时才能看到，如对话框下陷上弹前，背景只是对话框本身大小且在将要显示的位置
        getDialog().getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        View view = inflater.inflate(R.layout.dialogview, null);
        mBtn = (Button) view.findViewById(R.id.dialog_btn);
        mBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dismiss();
            }
        });
        final Animation anim = AnimationUtils.loadAnimation(getActivity(), R.anim.animotion);
        anim.setDuration(1000);
        view.startAnimation(anim);

        return view;
    }

    @Override
    public void onStart() {
        super.onStart();
        getDialog().getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
    }

    @Override
    public void onCancel(DialogInterface dialog) {
        super.onCancel(dialog);
    }
}
