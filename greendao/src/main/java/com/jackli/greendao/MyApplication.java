package com.jackli.greendao;

import android.app.Application;
import android.database.sqlite.SQLiteDatabase;

import com.jackli.greendao.test.DaoMaster;
import com.jackli.greendao.test.DaoSession;

public class MyApplication extends Application {


    private static MyApplication mApp;
    private static DaoSession mDaoSession;
    @Override
    public void onCreate() {
        super.onCreate();
        mApp = this;
        //配置数据库
        initGreenDao();
    }

    private void initGreenDao(){
        //创建数据库mydb.db
        DaoMaster.DevOpenHelper helper = new DaoMaster.DevOpenHelper(mApp,"mydb.db");
        //获取可写数据库
        SQLiteDatabase database = helper.getWritableDatabase();
        //获取数据库对象
        DaoMaster daoMaster = new DaoMaster(database);
        //获取Dao对象管理者
        mDaoSession = daoMaster.newSession();
    }
    public static DaoSession getmDaoSession(){
        return mDaoSession;
    }
}
