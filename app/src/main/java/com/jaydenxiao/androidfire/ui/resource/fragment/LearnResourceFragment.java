package com.jaydenxiao.androidfire.ui.resource.fragment;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.jaydenxiao.androidfire.R;
import com.jaydenxiao.androidfire.app.AppApplication;
import com.jaydenxiao.androidfire.bean.BannerModel;
import com.jaydenxiao.androidfire.bean.LearnResourceInfo;
import com.jaydenxiao.androidfire.engine.Engine;
import com.jaydenxiao.androidfire.ui.resource.adapter.LearnResourceAdapter;
import com.jaydenxiao.common.base.BaseFragment;
import com.jude.easyrecyclerview.PtrEasyRecyclerView;
import com.jude.easyrecyclerview.adapter.RecyclerArrayAdapter;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.OnClick;
import cn.bingoogolapple.bgabanner.BGABanner;
import in.srain.cube.views.ptr.PtrDefaultHandler;
import in.srain.cube.views.ptr.PtrFrameLayout;
import in.srain.cube.views.ptr.PtrHandler;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by wangfengkai on 2016/10/14.
 */
public class LearnResourceFragment extends BaseFragment
        implements RecyclerArrayAdapter.OnLoadMoreListener, PtrHandler,
        BGABanner.OnItemClickListener, BGABanner.Adapter{

    @Bind(R.id.tv_title_center)
    TextView tv_title_center;
    @Bind(R.id.rl_title_left)
    RelativeLayout rl_title_left;
    @Bind(R.id.ptrRecyclerView_learn_resource)
    PtrEasyRecyclerView ptrRecyclerView_learn_resource;
    private LearnResourceAdapter learnResourceAdapter;
    private List<LearnResourceInfo> resources,resources1;
    private Engine mEngine;

    public static LearnResourceFragment newInstance() {
        return new LearnResourceFragment();
    }

    @Override
    protected int getLayoutResource() {
        return R.layout.fragment_learn_resource;
    }

    @Override
    public void initPresenter() {
        resources = new ArrayList<LearnResourceInfo>();

        LearnResourceInfo resourceInfo1 = new LearnResourceInfo();
        resourceInfo1.setResourceId("001");
        resourceInfo1.setResourceName("精品推荐");
        resourceInfo1.setResourceUrl("aaaaaaaaaaa");
        resources.add(resourceInfo1);

        LearnResourceInfo resourceInfo2 = new LearnResourceInfo();
        resourceInfo2.setResourceId("002");
        resourceInfo2.setResourceName("技术社区");
        resourceInfo2.setResourceUrl("aaaaaaaaaaa");
        resources.add(resourceInfo2);

        LearnResourceInfo resourceInfo3 = new LearnResourceInfo();
        resourceInfo3.setResourceId("003");
        resourceInfo3.setResourceName("学习教程");
        resourceInfo3.setResourceUrl("aaaaaaaaaaa");
        resources.add(resourceInfo3);

        LearnResourceInfo resourceInfo4 = new LearnResourceInfo();
        resourceInfo4.setResourceId("004");
        resourceInfo4.setResourceName("开源代码");
        resourceInfo4.setResourceUrl("aaaaaaaaaaa");
        resources.add(resourceInfo4);


        LearnResourceInfo resourceInfo5 = new LearnResourceInfo();
        resourceInfo5.setResourceId("005");
        resourceInfo5.setResourceName("知名博客");
        resourceInfo5.setResourceUrl("aaaaaaaaaaa");
        resources.add(resourceInfo5);

        LearnResourceInfo resourceInfo6 = new LearnResourceInfo();
        resourceInfo6.setResourceId("006");
        resourceInfo6.setResourceName("使用工具");
        resourceInfo6.setResourceUrl("aaaaaaaaaaa");
        resources.add(resourceInfo6);

        LearnResourceInfo resourceInfo7 = new LearnResourceInfo();
        resourceInfo7.setResourceId("007");
        resourceInfo7.setResourceName("资源文档");
        resourceInfo7.setResourceUrl("aaaaaaaaaaa");
        resources.add(resourceInfo7);

        LearnResourceInfo resourceInfo8 = new LearnResourceInfo();
        resourceInfo8.setResourceId("008");
        resourceInfo8.setResourceName("开发框架");
        resourceInfo8.setResourceUrl("aaaaaaaaaaa");
        resources.add(resourceInfo8);

        LearnResourceInfo resourceInfo9 = new LearnResourceInfo();
        resourceInfo9.setResourceId("009");
        resourceInfo9.setResourceName("前言资讯");
        resourceInfo9.setResourceUrl("aaaaaaaaaaa");
        resources.add(resourceInfo9);

        LearnResourceInfo resourceInfo10 = new LearnResourceInfo();
        resourceInfo10.setResourceId("010");
        resourceInfo10.setResourceName("服务集成");
        resourceInfo10.setResourceUrl("aaaaaaaaaaa");
        resources.add(resourceInfo10);

        LearnResourceInfo resourceInfo11 = new LearnResourceInfo();
        resourceInfo11.setResourceId("011");
        resourceInfo11.setResourceName("设计资源");
        resourceInfo11.setResourceUrl("aaaaaaaaaaa");
        resources.add(resourceInfo11);

        LearnResourceInfo resourceInfo12 = new LearnResourceInfo();
        resourceInfo12.setResourceId("012");
        resourceInfo12.setResourceName("求职招聘");
        resourceInfo12.setResourceUrl("aaaaaaaaaaa");
        resources.add(resourceInfo12);

        LearnResourceInfo resourceInfo13 = new LearnResourceInfo();
        resourceInfo13.setResourceId("013");
        resourceInfo13.setResourceName("私活兼职");
        resourceInfo13.setResourceUrl("aaaaaaaaaaa");
        resources.add(resourceInfo13);

        LearnResourceInfo resourceInfo14 = new LearnResourceInfo();
        resourceInfo14.setResourceId("014");
        resourceInfo14.setResourceName("平台市场");
        resourceInfo14.setResourceUrl("aaaaaaaaaaa");
        resources.add(resourceInfo14);

        LearnResourceInfo resourceInfo15 = new LearnResourceInfo();
        resourceInfo15.setResourceId("015");
        resourceInfo15.setResourceName("广告服务");
        resourceInfo15.setResourceUrl("aaaaaaaaaaa");
        resources.add(resourceInfo15);
    }

    @Override
    protected void initView() {
        tv_title_center.setText("资源分享");

        mEngine = AppApplication.getInstance().getEngine();

        if(learnResourceAdapter == null){
            learnResourceAdapter = new LearnResourceAdapter(getContext());
            learnResourceAdapter.notifyDataSetChanged();
        }

        ptrRecyclerView_learn_resource.setLayoutManager(new LinearLayoutManager(getContext()));
        ptrRecyclerView_learn_resource.setAdapterWithProgress(learnResourceAdapter);

        learnResourceAdapter.setMore(R.layout.view_more, this);
        learnResourceAdapter.setNoMore(R.layout.view_nomore);
        learnResourceAdapter.setError(R.layout.view_error).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                learnResourceAdapter.resumeMore();
            }
        });

        PtrFrameLayout ptrFrameLayout = ptrRecyclerView_learn_resource.getPtrFrameLayout();
        ptrRecyclerView_learn_resource.setRefreshListener(this);
        onRefreshBegin(ptrFrameLayout);
        learnResourceAdapter.addHeader(new RecyclerArrayAdapter.ItemView() {
            @Override
            public View onCreateView(ViewGroup parent) {
                LayoutInflater inflater=(LayoutInflater)getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                View view = inflater.inflate(R.layout.view_learn_resource_header, null);
                BGABanner banner = (BGABanner)view.findViewById(R.id.banner_main_zoomStack);
                loadData(banner, 6);
                return view;
            }

            @Override
            public void onBindView(View headerView) {

            }
        });
    }

    private void loadData(final BGABanner banner, int count) {
        mEngine.fetchItemsWithItemCount(count).enqueue(new Callback<BannerModel>() {
            @Override
            public void onResponse(Call<BannerModel> call, Response<BannerModel> response) {
                BannerModel bannerModel = response.body();

                banner.setAdapter(LearnResourceFragment.this);
                banner.setData(bannerModel.imgs, bannerModel.tips);
            }

            @Override
            public void onFailure(Call<BannerModel> call, Throwable t) {
                Toast.makeText(getContext(), "网络数据加载失败", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @OnClick(R.id.rl_title_left)
    public void goback(){
        getActivity().finish();
    }

    List<LearnResourceInfo> datas1 = new ArrayList<LearnResourceInfo>();


    @Override
    public void onLoadMore() {
         System.out.println("===resources.size====="+resources.size());
        if(resources.size() == 15){
            ptrRecyclerView_learn_resource.setRefreshing(false);
            learnResourceAdapter.stopMore();
            Toast.makeText(getContext(),"没有更多数据啦！",Toast.LENGTH_SHORT).show();
            /*learnResourceAdapter.setNoMore(R.layout.view_nomore1);
            learnResourceAdapter.notifyDataSetChanged();*/
        }
    }

    @Override
    public boolean checkCanDoRefresh(PtrFrameLayout frame, View content, View header) {
        return PtrDefaultHandler.checkContentCanBePulledDown(frame, content, header);
    }

    List<LearnResourceInfo> datas = new ArrayList<LearnResourceInfo>();

    @Override
    public void onRefreshBegin(PtrFrameLayout frame) {

        if(resources != null && resources.size() > 0){
            if (resources.size() < 2) {
                learnResourceAdapter.setNoMore(R.layout.view_nomore1);
            }
            datas.clear();
            datas.addAll(resources);
            learnResourceAdapter.clear();
            learnResourceAdapter.addAll(datas);
        }
    }

    @Override
    public void fillBannerItem(BGABanner banner, View view, Object model, int position) {
        Glide.with(getContext())
                .load(model)
                .placeholder(R.mipmap.holder)
                .error(R.mipmap.holder)
                .into((ImageView) view);
    }

    @Override
    public void onBannerItemClick(BGABanner banner, View view, Object model, int position) {
        Toast.makeText(getContext(), "点击了第" + (position + 1) + "页", Toast.LENGTH_SHORT).show();
    }
}
