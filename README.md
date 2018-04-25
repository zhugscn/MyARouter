 �����ARouter��Android�������ܵ��㷺��ӭ�����ϵ�����Ҳ���٣�Ȼ��ֻ�����������������ʹ��ԭ����github������
https://github.com/alibaba/ARouter
��ʹ�õİ汾�����£�

![image.png](https://upload-images.jianshu.io/upload_images/5117013-4330e36a1049dc55.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)

���������ǽ���������ʵ�飺
1. ����һ����APP
    ����MainActivity�е���һ��LoginActivity
2. ����һ��module
    ����MainActivity�������module������

���ϼ��ǿ���ʱ���õĳ������ر��ǵ�2������ͬ�˿�����ͬ��module, ����������Լ������

ARouter��ithub��Ŀ���Ѿ�˵�ĺ�����ˣ�ʹ�÷�ʽ�ܼ򵥣�����ʽ���á�
Ȼ����һЩ����û��˵���ף��������ظ��£�
1. module��build.gradle��Ӧ����
1)��android{defaultconfig �μ���
        javaCompileOptions {
            annotationProcessorOptions {
                arguments = [moduleName: project.getName()]
            }
        }
2) ��dependencies�μ���
    //ARouter��Ҫ�ӵ�����
    compile 'com.alibaba:arouter-api:1.3.1'
    annotationProcessor 'com.alibaba:arouter-compiler:1.1.4'

2. ��app��build.gradle
ͬ��module����⻹����Ҫ�ӱ���module�Ĳ���
    //ARouter��Ҫ��ʽָ������module,�����module���û���ʾ�Ҳ���
    compile project(":mymodule1")

3. ��ʼ��
�������Application�������onCreate����õ��������
```
   /**
     * ��ʼ��·��
     */
    void initARouter(){
        if(BuildConfig.DEBUG) {
            ARouter.openLog();
            ARouter.openDebug();
        }
        ARouter.init(application);
    }
```

4. ע��ָ��ÿһ�����(Activity)��uri
����
```
@Route(path="/pos/login")
public class LoginActivity extends AppCompatActivity {
```
���У���һ��pos�ǽ��飬 ��2��������

5. ���÷���
```
                ARouter.getInstance()
                        .build("/pos/login")
                        .navigation();
```

6. ����
ע�ⲻͬ��module���鲻���ظ����������ʱ���д���
���Կɼ�,module��þ���ҵ���ϵĻ��֣����߹����϶�����

������github�� https://github.com/zhugscn/MyARouter.git
