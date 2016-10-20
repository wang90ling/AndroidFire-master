package com.jaydenxiao.androidfire.ui.resource.fragment;

import android.support.v7.widget.LinearLayoutManager;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.jaydenxiao.androidfire.R;
import com.jaydenxiao.androidfire.bean.LearnResourceInfo;
import com.jaydenxiao.androidfire.ui.resource.adapter.DemoListAdapter;
import com.jaydenxiao.androidfire.ui.resource.adapter.LearnResourceAdapter;
import com.jaydenxiao.common.base.BaseFragment;
import com.jude.easyrecyclerview.PtrEasyRecyclerView;
import com.jude.easyrecyclerview.adapter.RecyclerArrayAdapter;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.OnClick;
import in.srain.cube.views.ptr.PtrDefaultHandler;
import in.srain.cube.views.ptr.PtrFrameLayout;
import in.srain.cube.views.ptr.PtrHandler;

/**
 * Created by wangfengkai on 2016/10/14.
 */
public class DemoListFragment extends BaseFragment
        implements RecyclerArrayAdapter.OnLoadMoreListener, PtrHandler {

    @Bind(R.id.tv_title_center)
    TextView tv_title_center;
    @Bind(R.id.rl_title_left)
    RelativeLayout rl_title_left;
    @Bind(R.id.ptrRecyclerView_demo_list)
    PtrEasyRecyclerView ptrRecyclerView_demo_list;
    private DemoListAdapter learnResourceAdapter;
    private List<LearnResourceInfo> resources,resources1;

    public static DemoListFragment newInstance() {
        return new DemoListFragment();
    }

    @Override
    protected int getLayoutResource() {
        return R.layout.fragment_demolist;
    }

    @Override
    public void initPresenter() {
        resources = new ArrayList<LearnResourceInfo>();

        LearnResourceInfo resourceInfo1 = new LearnResourceInfo();
        resourceInfo1.setResourceId("001");
        resourceInfo1.setResourceName("酷炫的Android时间选择器");
        resourceInfo1.setResourceUrl("aaaaaaaaaaa");
        resources.add(resourceInfo1);

        LearnResourceInfo resourceInfo2 = new LearnResourceInfo();
        resourceInfo2.setResourceId("002");
        resourceInfo2.setResourceName("Android Notification消息推送");
        resourceInfo2.setResourceUrl("aaaaaaaaaaa");
        resources.add(resourceInfo2);

        LearnResourceInfo resourceInfo3 = new LearnResourceInfo();
        resourceInfo3.setResourceId("003");
        resourceInfo3.setResourceName("Android APP版本更新");
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
    }

    @Override
    protected void initView() {
        tv_title_center.setText("Demo01");

        if(learnResourceAdapter == null){
            learnResourceAdapter = new DemoListAdapter(getContext());
            learnResourceAdapter.notifyDataSetChanged();
        }

        ptrRecyclerView_demo_list.setLayoutManager(new LinearLayoutManager(getContext()));
        ptrRecyclerView_demo_list.setAdapterWithProgress(learnResourceAdapter);

        learnResourceAdapter.setMore(R.layout.view_more, this);
        learnResourceAdapter.setNoMore(R.layout.view_nomore);
        learnResourceAdapter.setError(R.layout.view_error).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                learnResourceAdapter.resumeMore();
            }
        });

        PtrFrameLayout ptrFrameLayout = ptrRecyclerView_demo_list.getPtrFrameLayout();
        ptrRecyclerView_demo_list.setRefreshListener(this);
        onRefreshBegin(ptrFrameLayout);

    }

    @OnClick(R.id.rl_title_left)
    public void goback(){
        getActivity().finish();
    }


    List<LearnResourceInfo> datas1 = new ArrayList<LearnResourceInfo>();


    @Override
    public void onLoadMore() {
        System.out.println("===resources.size====="+resources.size());
        if(resources.size() == 8){
            ptrRecyclerView_demo_list.setRefreshing(false);
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

}
