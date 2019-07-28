package com.example.library_activity_timetable.model;

import android.content.Context;
import android.graphics.Color;

import com.example.library_activity_timetable.R;
import com.example.library_activity_timetable.utils.ColorUtils;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 颜色池，管理课程项可挑选的颜色
 */

public class ScheduleColorPool{

    //使用集合维护颜色池
    private List<Integer> colorPool;

    /**
     * 得到颜色池的实例，即List集合
     * @return List<Integer>
     */
    public List<Integer> getPoolInstance() {
        if(colorPool==null) colorPool=new ArrayList<>();
        return colorPool;
    }

    /**
     * 根据索引获取颜色，索引越界默认返回 Color.GRAY
     * @param i 索引
     * @return int
     */
    public int getColor(int i){
        if(i<0||i>=size()) return Color.GRAY;
        return colorPool.get(i);
    }

    /**
     * 颜色池的大小
     * @return int
     */
    public int size(){
        if(getPoolInstance()==null) return 0;
        return getPoolInstance().size();
    }


    /**
     * 在颜色池中添加一些自定义的颜色
     * @param colorIds 多个颜色
     * @return ScheduleColorPool
     */
    public ScheduleColorPool add(int... colorIds){
        if(colorIds!=null){
            for(int i=0;i<colorIds.length;i++){
                colorPool.add(colorIds[i]);
            }
        }
        return this;
    }
}
