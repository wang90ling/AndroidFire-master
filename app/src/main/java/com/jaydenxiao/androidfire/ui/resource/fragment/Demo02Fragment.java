package com.jaydenxiao.androidfire.ui.resource.fragment;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.support.v4.media.session.MediaSessionCompat;
import android.support.v7.app.NotificationCompat;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.jaydenxiao.androidfire.R;

import com.jaydenxiao.androidfire.ui.resource.notification.DownloadService;
import com.jaydenxiao.androidfire.ui.resource.notification.ImageActivity;
import com.jaydenxiao.androidfire.ui.resource.notification.MediaService;
import com.jaydenxiao.androidfire.ui.resource.notification.SettingsActivity;
import com.jaydenxiao.common.base.BaseFragment;

import butterknife.Bind;
import butterknife.OnClick;

/**
 * Created by wangfengkai on 2016/10/14.
 */
public class Demo02Fragment extends BaseFragment {

    @Bind(R.id.tv_title_center)
    TextView tv_title_center;
    @Bind(R.id.rl_title_left)
    RelativeLayout rl_title_left;

    @Bind(R.id.tv_notification1)
    TextView tv_notification1;
    @Bind(R.id.tv_notification2)
    TextView tv_notification2;
    @Bind(R.id.tv_notification3)
    TextView tv_notification3;
    @Bind(R.id.tv_notification4)
    TextView tv_notification4;
    @Bind(R.id.tv_notification5)
    TextView tv_notification5;
    @Bind(R.id.tv_notification6)
    TextView tv_notification6;
    @Bind(R.id.tv_notification7)
    TextView tv_notification7;
    @Bind(R.id.tv_notification8)
    TextView tv_notification8;

    public static final int TYPE_Normal = 1;
    public static final int TYPE_Progress = 2;
    public static final int TYPE_BigText = 3;
    public static final int TYPE_Inbox = 4;
    public static final int TYPE_BigPicture = 5;
    public static final int TYPE_Hangup = 6;
    public static final int TYPE_Media = 7;
    public static final int TYPE_Customer = 8;
    private NotificationManager manger;
    private Intent service;

    public static Demo02Fragment newInstance() {
        return new Demo02Fragment();
    }

    @Override
    protected int getLayoutResource() {
        return R.layout.fragment_demo02;
    }

    @Override
    public void initPresenter() {

    }

    @Override
    protected void initView() {
        tv_title_center.setText("Notification消息推送");

        manger = (NotificationManager) getActivity().getSystemService(Context.NOTIFICATION_SERVICE);
        service = new Intent(getContext(),DownloadService.class);

    }

    @OnClick(R.id.rl_title_left)
    public void goback(){
        getActivity().finish();
    }


    @OnClick(R.id.tv_notification1)
    public void showNotification1(){
        simpleNotify();
    }

    @OnClick(R.id.tv_notification2)
    public void showNotification2(){
        getActivity().startService(service);
    }

    @OnClick(R.id.tv_notification3)
    public void showNotification3(){
        bigTextStyle();
    }

    @OnClick(R.id.tv_notification4)
    public void showNotification4(){
        inBoxStyle();
    }

    @OnClick(R.id.tv_notification5)
    public void showNotification5(){
        bigPictureStyle();
    }

    @OnClick(R.id.tv_notification6)
    public void showNotification6(){
        hangup();
    }

    @OnClick(R.id.tv_notification7)
    public void showNotification7(){
        mediaStyle();
    }

    @OnClick(R.id.tv_notification8)
    public void showNotification8(){
        Intent intent = new Intent(getContext(),MediaService.class);
        getActivity().startService(intent);
    }


    private void simpleNotify(){
        NotificationCompat.Builder builder = new NotificationCompat.Builder(getContext());
        //Ticker是状态栏显示的提示
        builder.setTicker("简单Notification");
        //第一行内容  通常作为通知栏标题
        builder.setContentTitle("标题");
        //第二行内容 通常是通知正文
        builder.setContentText("通知内容");
        //第三行内容 通常是内容摘要什么的 在低版本机器上不一定显示
        builder.setSubText("这里显示的是通知第三行内容！");
        //ContentInfo 在通知的右侧 时间的下面 用来展示一些其他信息
        //builder.setContentInfo("2");
        builder.setAutoCancel(true);
        builder.setNumber(2);
        builder.setSmallIcon(R.mipmap.ic_launcher);
        builder.setLargeIcon(BitmapFactory.decodeResource(getResources(),R.mipmap.push));
        Intent intent = new Intent(getContext(),SettingsActivity.class);
        PendingIntent pIntent = PendingIntent.getActivity(getContext(),1,intent,0);
        builder.setContentIntent(pIntent);
        //设置震动
        //long[] vibrate = {100,200,100,200};
        //builder.setVibrate(vibrate);

        builder.setDefaults(NotificationCompat.DEFAULT_ALL);
        Notification notification = builder.build();
        manger.notify(TYPE_Normal,notification);
    }


    private void bigTextStyle(){
        NotificationCompat.Builder builder = new NotificationCompat.Builder(getContext());
        builder.setContentTitle("BigTextStyle");
        builder.setContentText("BigTextStyle演示示例");
        builder.setSmallIcon(R.mipmap.ic_launcher);
        builder.setLargeIcon(BitmapFactory.decodeResource(getResources(),R.mipmap.notification));
        android.support.v4.app.NotificationCompat.BigTextStyle style = new android.support.v4.app.NotificationCompat.BigTextStyle();
        style.bigText("这里是点击通知后要显示的正文，可以换行可以显示很长很长很长很长很长很长很长很长很长很长很长很长很长很长很长很长很长很长");
        style.setBigContentTitle("点击后的标题");
        style.setSummaryText("末尾只一行的文字内容");
        builder.setStyle(style);
        builder.setAutoCancel(true);
        Intent intent = new Intent(getContext(),SettingsActivity.class);
        PendingIntent pIntent = PendingIntent.getActivity(getContext(),1,intent,0);
        builder.setContentIntent(pIntent);
        builder.setDefaults(NotificationCompat.DEFAULT_ALL);
        Notification notification = builder.build();
        manger.notify(TYPE_BigText,notification);
    }


    /**
     * 最多显示五行 再多会有截断
     */
    public void inBoxStyle(){
        NotificationCompat.Builder builder = new NotificationCompat.Builder(getContext());
        builder.setContentTitle("InboxStyle");
        builder.setContentText("InboxStyle演示示例");
        builder.setSmallIcon(R.mipmap.ic_launcher);
        builder.setLargeIcon(BitmapFactory.decodeResource(getResources(),R.mipmap.notification));
        android.support.v4.app.NotificationCompat.InboxStyle style = new android.support.v4.app.NotificationCompat.InboxStyle();
        style.setBigContentTitle("BigContentTitle")
                .addLine("第一行，第一行，第一行，第一行，第一行，第一行，第一行")
                .addLine("第二行")
                .addLine("第三行")
                .addLine("第四行")
                .addLine("第五行")
                .setSummaryText("SummaryText");
        builder.setStyle(style);
        builder.setAutoCancel(true);
        Intent intent = new Intent(getContext(),SettingsActivity.class);
        PendingIntent pIntent = PendingIntent.getActivity(getContext(),1,intent,0);
        builder.setContentIntent(pIntent);
        builder.setDefaults(NotificationCompat.DEFAULT_ALL);
        Notification notification = builder.build();
        manger.notify(TYPE_Inbox,notification);
    }


    public void bigPictureStyle(){
        NotificationCompat.Builder builder = new NotificationCompat.Builder(getContext());
        builder.setContentTitle("BigPictureStyle");
        builder.setContentText("BigPicture演示示例");
        builder.setSmallIcon(R.mipmap.ic_launcher);
        builder.setDefaults(NotificationCompat.DEFAULT_ALL);
        builder.setLargeIcon(BitmapFactory.decodeResource(getResources(),R.mipmap.notification));
        android.support.v4.app.NotificationCompat.BigPictureStyle style = new android.support.v4.app.NotificationCompat.BigPictureStyle();
        style.setBigContentTitle("BigContentTitle");
        style.setSummaryText("SummaryText");
        style.bigPicture(BitmapFactory.decodeResource(getResources(),R.mipmap.small));
        builder.setStyle(style);
        builder.setAutoCancel(true);
        Intent intent = new Intent(getContext(),ImageActivity.class);
        PendingIntent pIntent = PendingIntent.getActivity(getContext(),1,intent,0);
        builder.setContentIntent(pIntent);
        Notification notification = builder.build();
        manger.notify(TYPE_BigPicture,notification);
    }


    private void hangup(){
        if(Build.VERSION.SDK_INT < Build.VERSION_CODES.LOLLIPOP){
            Toast.makeText(getContext(), "此类通知在Android 5.0以上版本才会有横幅有效！", Toast.LENGTH_SHORT).show();
        }
        NotificationCompat.Builder builder = new NotificationCompat.Builder(getContext());
        builder.setContentTitle("横幅通知");
        builder.setContentText("请在设置通知管理中开启消息横幅提醒权限");
        builder.setDefaults(NotificationCompat.DEFAULT_ALL);
        builder.setSmallIcon(R.mipmap.ic_launcher);
        builder.setLargeIcon(BitmapFactory.decodeResource(getResources(),R.mipmap.notification));
        Intent intent = new Intent(getContext(),ImageActivity.class);
        PendingIntent pIntent = PendingIntent.getActivity(getContext(),1,intent,0);
        builder.setContentIntent(pIntent);
        builder.setFullScreenIntent(pIntent,true);
        builder.setAutoCancel(true);
        Notification notification = builder.build();
        manger.notify(TYPE_Hangup,notification);
    }

    private void mediaStyle(){
        NotificationCompat.Builder builder = new NotificationCompat.Builder(getContext());
        builder.setContentTitle("MediaStyle");
        builder.setContentText("Song Title");
        builder.setSmallIcon(R.mipmap.ic_launcher);
        builder.setLargeIcon(BitmapFactory.decodeResource(getResources(),R.mipmap.notification));
        builder.setDefaults(NotificationCompat.DEFAULT_ALL);
        Intent intent = new Intent(getContext(),ImageActivity.class);
        PendingIntent pIntent = PendingIntent.getActivity(getContext(),1,intent,0);
        builder.setContentIntent(pIntent);
        builder.addAction(R.mipmap.ic_previous_white,"",null);
        builder.addAction(R.mipmap.ic_stop_white,"",null);
        builder.addAction(R.mipmap.ic_play_arrow_white_18dp,"",pIntent);
        builder.addAction(R.mipmap.ic_next_white,"",null);
        NotificationCompat.MediaStyle style = new NotificationCompat.MediaStyle();
        style.setMediaSession(new MediaSessionCompat(getContext(),"MediaSession",
                new ComponentName(getActivity(),Intent.ACTION_MEDIA_BUTTON),null).getSessionToken());
        //CancelButton在5.0以下的机器有效
        style.setCancelButtonIntent(pIntent);
        style.setShowCancelButton(true);
        //设置要现实在通知右方的图标 最多三个
        style.setShowActionsInCompactView(2,3);
        builder.setStyle(style);
        builder.setShowWhen(false);
        Notification notification = builder.build();
        manger.notify(TYPE_Media,notification);
    }




}
