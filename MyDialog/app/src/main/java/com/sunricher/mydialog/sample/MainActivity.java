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

package com.sunricher.mydialog.sample;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.sunricher.mydialog.MyDialog;
import com.sunricher.mydialog.R;

/**
 * Created by 肖杰.
 */
public class MainActivity extends Activity {

    private Context mContext;
    private Button mBtnBaseDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mContext = this;

//        showBaseDialog(mContext);

        mBtnBaseDialog = (Button)findViewById(R.id.base);
        mBtnBaseDialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showBaseDialog(mContext);
            }
        });
    }

    private void showBaseDialog(Context context) {
        MyDialog.Builder builder = new MyDialog.Builder(context);
        builder.setTitle("Alert");
        builder.setMessage("Testing...");
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        builder.setNeutralButton("Neutral", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        builder.create().show();
    }
}
