package com.mxw.inandoutschool;

import android.content.Context;
import android.content.SharedPreferences;

public class SPUtils {
    public static SharedPreferences getSp(Context c){
        SharedPreferences sp = c.getSharedPreferences("Constant.SP_TABLE",c.MODE_PRIVATE);
        return sp;
    }
    public static boolean getBoolean(Context c, String key){
        SharedPreferences sp = getSp(c);
        boolean defValue = false;
//        if (key == Constant.NOTICE){
//            defValue = true;
//        }
        return sp.getBoolean(key,defValue);
    }
    public static void putBoolean(Context c, String key, boolean state){
        SharedPreferences sp = getSp(c);
        sp.edit().putBoolean(key,state).commit();
    }
    public static String getString(Context c, String key){
        SharedPreferences sp = getSp(c);
        return sp.getString(key,null);
    }
    public static void putString(Context c, String key, String value){
        SharedPreferences sp = getSp(c);
        sp.edit().putString(key,value).commit();
    }
    public static int getInt(Context c, String key){
        SharedPreferences sp = getSp(c);
        return sp.getInt(key,-1);
    }
    public static void putInt(Context c, String key, int value){
        SharedPreferences sp = getSp(c);
        sp.edit().putInt(key,value).commit();
    }
}
