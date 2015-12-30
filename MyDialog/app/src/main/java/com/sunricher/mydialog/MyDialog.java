/*
 * Copyright (C) 2015 The LGA Open Source Project
 *
 * MyDialog
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.sunricher.mydialog;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * Created by 肖杰.
 */
public class MyDialog extends Dialog implements DialogInterface {

    private MyDialog(Context context, int themeResId) {
        super(context, R.style.Dialog);
    }

    public static class Builder {

        private final Context mContext;
        private String mMessage;
        private String mTitle;
        private View mContentView;
        private String mPositiveBtnText;
        private OnClickListener mPositiveBtnClickListener;
        private String mNegativeBtnText;
        private OnClickListener mNegativeBtnClickListener;
        private String mNeutralBtnText;
        private OnClickListener mNeutralBtnClickListener;

        public Builder(Context context) {
            mContext = context;
        }

        public Builder setMessage(String message) {
            mMessage = message;
            return this;
        }

        public Builder setMessage(int messageResId) {
            mMessage = (String) mContext.getText(messageResId);
            return this;
        }

        public Builder setTitle(String title) {
            mTitle = title;
            return this;
        }

        public Builder setTitle(int titleResId) {
            mTitle = (String) mContext.getText(titleResId);
            return this;
        }

        public Builder setContentView(View v) {
            mContentView = v;
            return this;
        }

        public Builder setPositiveButton(String positiveBtnText, OnClickListener listener) {
            mPositiveBtnText = positiveBtnText;
            mPositiveBtnClickListener = listener;
            return this;
        }

        public Builder setPositiveButton(int positiveBtnTextResId, OnClickListener listener) {
            mPositiveBtnText = (String) mContext.getText(positiveBtnTextResId);
            mPositiveBtnClickListener = listener;
            return this;
        }

        public Builder setNegativeButton(String negativeBtnText, OnClickListener listener) {
            mNegativeBtnText = negativeBtnText;
            mNegativeBtnClickListener = listener;
            return this;
        }

        public Builder setNegativeButton(int negativeBtnTextResId, OnClickListener listener) {
            mNegativeBtnText = (String) mContext.getText(negativeBtnTextResId);
            mNegativeBtnClickListener = listener;
            return this;
        }

        public Builder setNeutralButton(String neutralBtnText, OnClickListener listener) {
            mNeutralBtnText = neutralBtnText;
            mNeutralBtnClickListener = listener;
            return this;
        }

        public Builder setNeutralButton(int neutralBtnTextResId, OnClickListener listener) {
            mNeutralBtnText = (String) mContext.getText(neutralBtnTextResId);
            mNeutralBtnClickListener = listener;
            return this;
        }

        public MyDialog create() {
            LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View layout = inflater.inflate(R.layout.view_dialog, null);
            ViewGroup.LayoutParams params = new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
            final MyDialog dialog = new MyDialog(mContext, R.style.Dialog);
            dialog.setContentView(layout, params);

            if(mTitle != null) {
                TextView title = (TextView) layout.findViewById(R.id.title);
                title.setText(mTitle);
                title.setVisibility(View.VISIBLE);
            }

            if(mMessage != null) {
                TextView message = (TextView) layout.findViewById(R.id.message);
                message.setText(mMessage);
                message.setVisibility(View.VISIBLE);
            } else if(mContentView != null) {
                LinearLayout content = (LinearLayout)layout.findViewById(R.id.content);
                content.removeAllViews();
                LinearLayout.LayoutParams contentParams = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
                content.addView(mContentView, contentParams);
            }

            if(mPositiveBtnText != null) {
                Button positiveBtn = ((Button) layout.findViewById(R.id.positive));
                positiveBtn.setText(mPositiveBtnText);
                if(mPositiveBtnClickListener != null) {
                    positiveBtn.setOnClickListener(new View.OnClickListener() {

                        @Override
                        public void onClick(View v) {
                            mPositiveBtnClickListener.onClick(dialog, DialogInterface.BUTTON_POSITIVE);
                        }
                    });
                }
                positiveBtn.setVisibility(View.VISIBLE);
            }

            if(mNeutralBtnText != null) {
                Button neutralBtn = ((Button) layout.findViewById(R.id.neutral));
                neutralBtn.setText(mNeutralBtnText);
                if(mNeutralBtnClickListener != null) {
                    neutralBtn.setOnClickListener(new View.OnClickListener() {

                        @Override
                        public void onClick(View v) {
                            mNeutralBtnClickListener.onClick(dialog, DialogInterface.BUTTON_NEUTRAL);
                        }
                    });
                }
                neutralBtn.setVisibility(View.VISIBLE);
            }

            if(mNegativeBtnText != null) {
                Button negativeBtn = ((Button) layout.findViewById(R.id.negative));
                negativeBtn.setText(mNegativeBtnText);
                if(mNegativeBtnClickListener != null) {
                    negativeBtn.setOnClickListener(new View.OnClickListener() {

                        @Override
                        public void onClick(View v) {
                            mNegativeBtnClickListener.onClick(dialog, DialogInterface.BUTTON_NEGATIVE);
                        }
                    });
                }
                negativeBtn.setVisibility(View.VISIBLE);
            }

            return dialog;
        }
    }
}
