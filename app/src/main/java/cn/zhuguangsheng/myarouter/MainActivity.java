package cn.zhuguangsheng.myarouter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.alibaba.android.arouter.launcher.ARouter;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btn_login:
                ARouter.getInstance()
                        .build("/pos/login")
                        .navigation();
                break;
            case R.id.btn_module1_main:
                ARouter.getInstance()
                        .build("/mymodule1/main")
                        //.build("/mymodule1/second")
                        .navigation();
                break;
            default:
                break;
        }
    }
}
