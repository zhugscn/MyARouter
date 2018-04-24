package cn.zhuguangsheng.myarouter;

import android.app.Application;

import com.alibaba.android.arouter.launcher.ARouter;


/**
 * Created by zhuguangsheng on 2018/4/24.
 */

public class MyApplication extends Application {
    Application application;

    @Override
    public void onCreate() {
        super.onCreate();

        application = this;

        initARouter();
    }

    /**
     * 初始化路由
     */
    void initARouter(){
        if(BuildConfig.DEBUG) {
            ARouter.openLog();
            ARouter.openDebug();
        }
        ARouter.init(application);
    }
}

