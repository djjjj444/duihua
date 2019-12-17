package com.example.duihua;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.text.Editable;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public  class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button button_login = (Button)findViewById(R.id.button1);
        Button button_tips = (Button)findViewById(R.id.button2);

        button_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                LayoutInflater inflater=getLayoutInflater();
               final View v=(inflater.inflate(R.layout.login_dialog,null));
                builder.setView(v)
                        .setTitle("login")
                        .setPositiveButton("login",new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int which) {

                                EditText editText = (EditText)v.findViewById(R.id.uid);
                                EditText editText2 = (EditText)v.findViewById(R.id.pwd);
                                String uid = editText.getText().toString();
                                String pwd = editText2.getText().toString();
                                if(uid.equals("abc")&& pwd.equals("123")){
                                    Toast.makeText(MainActivity.this,"登陆成功",Toast.LENGTH_LONG).show();
                                }else
                                    Toast.makeText(MainActivity.this,"密码不正确",Toast.LENGTH_LONG).show();
                            }
                        }).setNegativeButton("cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int which) {

                    }
                });

                builder.show();
            }
        });

        button_tips.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder_tips =new AlertDialog.Builder(MainActivity.this);
                builder_tips.setMessage("用户名为abc，密码为123")
                        .setTitle("Tips");
                builder_tips.setPositiveButton("确定", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(MainActivity.this,"用户按下确定",Toast.LENGTH_SHORT).show();
                    }
                });
                builder_tips.setNegativeButton("取消", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(MainActivity.this,"用户按下取消",Toast.LENGTH_SHORT).show();
                    }
                });
                builder_tips.setNeutralButton("忽略", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(MainActivity.this,"用户按下忽略",Toast.LENGTH_SHORT).show();
                    }
                });
                builder_tips.show();
            }
        });

    }


}
