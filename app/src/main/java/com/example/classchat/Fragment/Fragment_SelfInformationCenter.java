package com.example.classchat.Fragment;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.support.v4.app.Fragment;
import android.support.v4.content.LocalBroadcastManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.classchat.Activity.Activity_IdAuthentation;
import com.example.classchat.Activity.MainActivity;
import com.example.classchat.R;


public class Fragment_SelfInformationCenter extends Fragment {

    //控件
    private ImageView avatarImageView;

    private LinearLayout linearLayoutforAnquan;
    private LinearLayout linearLayoutforKecheng;
    private LinearLayout linearLayoutforShoucang;
    private LinearLayout linearLayoutforShezhi;
    private LinearLayout linearLayoutforRenzheng;
    private LinearLayout linearLayoutforBangzhu;
    private LinearLayout linearLayoutforGuanyu;

    private TextView textViewforName;
    private TextView textViewforId;
    private TextView textViewforMoney;

    private String correctId;
    private String name;
    private String headPic;

    private Double money;

    //判断是否实名认证
    private int isAuthentation;
    private byte[] bytes;

    protected static final int UPDATE_PICTURE = 1;

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState){
        super.onViewCreated(view, savedInstanceState);

        avatarImageView=view.findViewById(R.id.user_head);

        linearLayoutforAnquan=view.findViewById(R.id.anquan);
        linearLayoutforBangzhu=view.findViewById(R.id.bangzhuyufankui);
        linearLayoutforGuanyu=view.findViewById(R.id.aboutus);
        linearLayoutforKecheng=view.findViewById(R.id.kecheng);
        linearLayoutforRenzheng=view.findViewById(R.id.shimingrenzheng);
        linearLayoutforShezhi=view.findViewById(R.id.shezhi);
        linearLayoutforShoucang=view.findViewById(R.id.shoucang);

        textViewforId=view.findViewById(R.id.user_stuID);
        textViewforMoney=view.findViewById(R.id.user_money);
        textViewforName=view.findViewById(R.id.user_name);

        //获得用户ID
        MainActivity activity = (MainActivity)getActivity();
        correctId = activity.getId();
        isAuthentation = activity.getIsAuthentation();

        //textViewforId.setText(correctId);//设置ID显示

        //加入点击事件
        linearLayoutforAnquan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), MainActivity.class);
                startActivity(intent);

            }
        });
        linearLayoutforBangzhu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(),MainActivity.class);
                startActivity(intent);
            }
        });
        linearLayoutforGuanyu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(),MainActivity.class);
                startActivity(intent);
            }
        });
        linearLayoutforKecheng.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(),MainActivity.class);
                startActivity(intent);
            }
        });
        linearLayoutforRenzheng.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), Activity_IdAuthentation.class);
                intent.putExtra("id",correctId);
                if(isAuthentation == 1)
                    startActivity(intent);
                else
                    Toast.makeText(getActivity(),"您已经实名认证过了",Toast.LENGTH_SHORT).show();
            }
        });
        linearLayoutforShoucang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(),MainActivity.class);
                startActivity(intent);
            }
        });
        linearLayoutforShezhi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(),MainActivity.class);
                startActivity(intent);
            }
        });


    }
















    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return  inflater.inflate(R.layout.fragment_fragment__self_information_center, container, false);
    }

    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }
}
