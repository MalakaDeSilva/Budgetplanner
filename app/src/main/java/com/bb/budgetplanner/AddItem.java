package com.bb.budgetplanner;

import android.content.Context;
import android.text.InputType;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

public class AddItem {
    Context ctx;

    public AddItem(Context ctx) {
        this.ctx = ctx;
    }

    public TextView itemLabel(Context context, String text){
        final ViewGroup.LayoutParams lparams = new ViewGroup.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.MATCH_PARENT);
        final TextView textView = new TextView(context);
        textView.setLayoutParams(lparams);
        textView.setTextSize(10);
        textView.setText(text);
        textView.setMaxEms(8);

        return textView;
    }

    public EditText itemLimit(Context context){
        final ViewGroup.LayoutParams lparams = new ViewGroup.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.MATCH_PARENT);
        final EditText editText = new EditText(context);
        int id = 0;
        editText.setId(id);
        editText.setMinEms(2);
        editText.setInputType(InputType.TYPE_CLASS_NUMBER | InputType.TYPE_NUMBER_FLAG_DECIMAL);

        return editText;
    }

}
