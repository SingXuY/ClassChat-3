package com.example.classchat.Activity;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;

import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Spinner;

import com.example.classchat.Adapter.Adapter_AuthListAdapter;
import com.example.classchat.R;

import java.util.ArrayList;
import java.util.List;

/**
 * 这是实名认证界面
 */
public class Activity_IdAuthentation extends AppCompatActivity {
    private EditText name;
    private EditText id_card;
    private EditText st_card;
    private Spinner university;
    private Spinner college;
    private ImageView face;
    private ImageView card;
    private Button confirm;
    private Context mContext;

    private String name_;
    private String id_card_;
    private String st_card_;
    private String university_;
    private String college_;
    //TODO 这里是俩个图片资源的声明

    private Boolean  face_checked=false;
    private Boolean  card_checked=false;

    private AlertDialog.Builder builder1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity__id_authentation);

        mContext=this;
        name=(EditText)findViewById(R.id.auth_name);
        id_card=(EditText)findViewById(R.id.auth_number);
        st_card=(EditText)findViewById(R.id.auth_st_number);
        face=(ImageView)findViewById(R.id.auth_photo_face);
        card=(ImageView)findViewById(R.id.auth_photo_card);
        confirm=(Button)findViewById(R.id.auth_confirm);
        university=(Spinner)findViewById(R.id.auth_university);
        college=(Spinner)findViewById(R.id.auth_colloge);






       //TODO 这里传入大学数组为 uni赋值
       List<String> uni=new ArrayList<String>();

       final Adapter_AuthListAdapter adapter1=new Adapter_AuthListAdapter(mContext,uni);
       university.setAdapter(adapter1);
       university.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {
               university_=(String)adapter1.getItem(pos);
                List<String> col=new ArrayList<String>();
               //Todo 这里把university_作为搜索专业索引传入数据库,获得专业数组为col赋值

                final Adapter_AuthListAdapter adapter2=new Adapter_AuthListAdapter(mContext,col);
                college.setAdapter(adapter2);
                college.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {
                        college_=(String)adapter2.getItem(pos);
                    }
                    @Override
                    public void onNothingSelected(AdapterView<?> parent) {
                    }
                });;
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });

       face.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               //TODO 这里调用相册获得人脸图片资源，初始化图片属性； 并把控件背景设为它，方法为：face.setImageResource( ... );face.invalidate();
               //TODO若设置成功，把face_checked设为true，供下文判断
           }
       });
        card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //TODO 这里调用相册获得人脸图片资源，初始化图片属性； 并把控件背景设为它，方法为：card.setImageResource( ... );card.invalidate();
                //TODO若设置成功，把card_checked设为true，供下文判断
            }
        });


        //信息补全提示框1
        builder1 = new AlertDialog.Builder(this);
        builder1.setTitle("提示");
        builder1.setMessage("请补全实名认证信息哦");
        builder1.setPositiveButton("确定", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
            }
        });



        //提交审核按钮
       confirm.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {

               if(TextUtils.isEmpty(name.getText())||TextUtils.isEmpty(id_card.getText())||TextUtils.isEmpty(st_card.getText())||!face_checked||!card_checked||university_==null||college_==null)
               { builder1.show(); }
               else{
                   name_=name.getText().toString();
                   id_card_=id_card.getText().toString();
                   st_card_=st_card.getText().toString();
                   //TODO name_ id_card_ university_ college_ st_card分别为名字，身份证号，大学，学院，学号，这里传回数据库

         /**             if（判断是否数据格式是否正确等）{
                       显示相应提示框
                   }
                   else{
                       通过，等待验证，跳转页面
                   }**/
               }

           }
       });
    }



    }




