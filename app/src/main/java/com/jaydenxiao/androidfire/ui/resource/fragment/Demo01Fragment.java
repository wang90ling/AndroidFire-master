package com.jaydenxiao.androidfire.ui.resource.fragment;

import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.jaydenxiao.androidfire.R;
import com.jaydenxiao.common.base.BaseFragment;
import com.jzxiang.pickerview.TimePickerDialog;
import com.jzxiang.pickerview.data.Type;
import com.jzxiang.pickerview.listener.OnDateSetListener;

import java.text.SimpleDateFormat;
import java.util.Date;

import butterknife.Bind;
import butterknife.OnClick;

/**
 * Created by wangfengkai on 2016/10/14.
 */
public class Demo01Fragment extends BaseFragment
        implements View.OnClickListener, OnDateSetListener {

    @Bind(R.id.tv_title_center)
    TextView tv_title_center;
    @Bind(R.id.rl_title_left)
    RelativeLayout rl_title_left;

    @Bind(R.id.btn_all)
    TextView btn_all;
    @Bind(R.id.btn_year_month_day)
    TextView btn_year_month_day;
    @Bind(R.id.btn_year_month)
    TextView btn_year_month;
    @Bind(R.id.btn_month_day_hour_minute)
    TextView btn_month_day_hour_minute;
    @Bind(R.id.btn_hour_minute)
    TextView btn_hour_minute;
    @Bind(R.id.tv_time)
    TextView tv_time;

    TimePickerDialog mDialogAll;
    TimePickerDialog mDialogYearMonth;
    TimePickerDialog mDialogYearMonthDay;
    TimePickerDialog mDialogMonthDayHourMinute;
    TimePickerDialog mDialogHourMinute;

    SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    public static Demo01Fragment newInstance() {
        return new Demo01Fragment();
    }

    @Override
    protected int getLayoutResource() {
        return R.layout.fragment_demo01;
    }

    @Override
    public void initPresenter() {
        long tenYears = 10L * 365 * 1000 * 60 * 60 * 24L;
        mDialogAll = new TimePickerDialog.Builder()
                .setCallBack(this)
                .setCancelStringId("Cancel")
                .setSureStringId("Sure")
                .setTitleStringId("TimePicker")
                .setYearText("Year")
                .setMonthText("Month")
                .setDayText("Day")
                .setHourText("Hour")
                .setMinuteText("Minute")
                .setCyclic(false)
                .setMinMillseconds(System.currentTimeMillis())
                .setMaxMillseconds(System.currentTimeMillis() + tenYears)
                .setCurrentMillseconds(System.currentTimeMillis())
                .setThemeColor(getResources().getColor(R.color.timepicker_dialog_bg))
                .setType(Type.ALL)
                .setWheelItemTextNormalColor(getResources().getColor(R.color.timetimepicker_default_text_color))
                .setWheelItemTextSelectorColor(getResources().getColor(R.color.timepicker_toolbar_bg))
                .setWheelItemTextSize(12)
                .build();

        mDialogYearMonth = new TimePickerDialog.Builder()
                .setType(Type.YEAR_MONTH)
                .setThemeColor(getResources().getColor(R.color.colorPrimary))
                .setCallBack(this)
                .build();
        mDialogYearMonthDay = new TimePickerDialog.Builder()
                .setType(Type.YEAR_MONTH_DAY)
                .setCallBack(this)
                .build();
        mDialogMonthDayHourMinute = new TimePickerDialog.Builder()
                .setType(Type.MONTH_DAY_HOUR_MIN)
                .setCallBack(this)
                .build();
        mDialogHourMinute = new TimePickerDialog.Builder()
                .setType(Type.HOURS_MINS)
                .setCallBack(this)
                .build();
    }

    @Override
    protected void initView() {
        tv_title_center.setText("酷炫的Android时间选择器");

    }

    @OnClick(R.id.rl_title_left)
    public void goback(){
        getActivity().finish();
    }


    @OnClick(R.id.btn_all)
    public void showAll(){
        mDialogAll.show(getFragmentManager(), "all");
    }

    @OnClick(R.id.btn_year_month_day)
    public void showYearMonthDay(){
        mDialogYearMonthDay.show(getFragmentManager(), "year_month_day");
    }

    @OnClick(R.id.btn_year_month)
    public void showYearMonth(){
        mDialogYearMonth.show(getFragmentManager(), "year_month");
    }

    @OnClick(R.id.btn_month_day_hour_minute)
    public void showMonthDayHourMinute(){
        mDialogMonthDayHourMinute.show(getFragmentManager(), "month_day_hour_minute");
    }

    @OnClick(R.id.btn_hour_minute)
    public void showHourMinute(){
        mDialogHourMinute.show(getFragmentManager(), "hour_minute");
    }

    @Override
    public void onClick(View v) {

    }

    @Override
    public void onDateSet(TimePickerDialog timePickerDialog, long millseconds) {
        String text = getDateToString(millseconds);
        tv_time.setText(text);
    }

    public String getDateToString(long time) {
        Date d = new Date(time);
        return sf.format(d);
    }
}
