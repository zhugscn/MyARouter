 阿里的ARouter在Android社区中受到广泛欢迎，网上的文章也不少，然而只有亲自试验才真正好使。原来的github在这里
https://github.com/alibaba/ARouter
我使用的版本是以下：

![image.png](https://upload-images.jianshu.io/upload_images/5117013-4330e36a1049dc55.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)

接下来我们将做这样的实验：
1. 创建一个主APP
    并在MainActivity中调另一个LoginActivity
2. 创建一个module
    并在MainActivity调用这个module的内容

以上即是开发时常用的场景，特别是第2个，不同人开发不同的module, 集成起来按约定调用

ARouter的ithub项目里已经说的很清楚了，使用方式很简单，是链式调用。
然而，一些配置没有说明白，这里再重复下：
1. module的build.gradle中应加入
1)在android{defaultconfig 段加入
        javaCompileOptions {
            annotationProcessorOptions {
                arguments = [moduleName: project.getName()]
            }
        }
2) 在dependencies段加入
    //ARouter需要加的引用
    compile 'com.alibaba:arouter-api:1.3.1'
    annotationProcessor 'com.alibaba:arouter-compiler:1.1.4'

2. 主app的build.gradle
同上module里，另外还必须要加编译module的部分
    //ARouter需要显式指定编译module,否则跨module调用会提示找不到
    compile project(":mymodule1")

3. 初始化
建议放在Application里，我是在onCreate里调用的下面这个
```
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
```

4. 注解指定每一个组件(Activity)的uri
例如
```
@Route(path="/pos/login")
public class LoginActivity extends AppCompatActivity {
```
其中，第一个pos是叫组， 第2个是名字

5. 调用方法
```
                ARouter.getInstance()
                        .build("/pos/login")
                        .navigation();
```

6. 其它
注意不同的module的组不能重复，否则调用时会有错误
由以可见,module最好就是业务上的划分，或者功能上独立的

代码在github上 https://github.com/zhugscn/MyARouter.git
