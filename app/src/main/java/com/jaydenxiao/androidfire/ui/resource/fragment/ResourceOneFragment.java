package com.jaydenxiao.androidfire.ui.resource.fragment;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.jaydenxiao.androidfire.R;
import com.jaydenxiao.androidfire.bean.BaseResourceInfo;
import com.jaydenxiao.androidfire.bean.LearnResourceInfo;
import com.jaydenxiao.androidfire.ui.resource.adapter.LearnResourceAdapter;
import com.jaydenxiao.androidfire.ui.resource.adapter.ResourceOneAdapter;
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
public class ResourceOneFragment extends BaseFragment
        implements RecyclerArrayAdapter.OnLoadMoreListener, PtrHandler {

    @Bind(R.id.tv_title_center)
    TextView tv_title_center;
    @Bind(R.id.rl_title_left)
    RelativeLayout rl_title_left;

    @Bind(R.id.ptrRecyclerView_resource_one)
    PtrEasyRecyclerView ptrRecyclerView_resource_one;
    private ResourceOneAdapter resourceOneAdapter;
    private ArrayList<BaseResourceInfo> resources;


    public static ResourceOneFragment newInstance() {
        return new ResourceOneFragment();
    }

    @Override
    protected int getLayoutResource() {
        return R.layout.fragment_resourceone;
    }

    @Override
    public void initPresenter() {
        resources = new ArrayList<BaseResourceInfo>();

        BaseResourceInfo resourceInfo1 = new BaseResourceInfo();
        resourceInfo1.setResourceId("001");
        resourceInfo1.setResourceName("稀土挖金");
        resourceInfo1.setResourceDetail("挖掘最优质的互联网技术/联合编辑每日精选内容/移动端优质阅读体验");
        resourceInfo1.setResourcePic(getActivity().getResources().getDrawable(R.mipmap.pic_icon01));
        resourceInfo1.setResourceUrl("http://gold.xitu.io/");
        resources.add(resourceInfo1);

        BaseResourceInfo resourceInfo2 = new BaseResourceInfo();
        resourceInfo2.setResourceId("002");
        resourceInfo2.setResourceName("干货集中营");
        resourceInfo2.setResourceDetail("Gank.io 每日分享妹子图和技术干货，还有供大家中午休息的休闲视频");
        resourceInfo2.setResourcePic(getActivity().getResources().getDrawable(R.mipmap.pic_icon02));
        resourceInfo2.setResourceUrl("aaaaaaaaaaa");
        resources.add(resourceInfo2);

        BaseResourceInfo resourceInfo3 = new BaseResourceInfo();
        resourceInfo3.setResourceId("003");
        resourceInfo3.setResourceName("泡在网上的日子");
        resourceInfo3.setResourceDetail("网站主要是关于web开发以及android开发两方面的资料，目前更侧重于android开发1111");
        resourceInfo3.setResourcePic(getActivity().getResources().getDrawable(R.mipmap.pic_icon03));
        resourceInfo3.setResourceUrl("aaaaaaaaaaa");
        resources.add(resourceInfo3);

        BaseResourceInfo resourceInfo4 = new BaseResourceInfo();
        resourceInfo4.setResourceId("004");
        resourceInfo4.setResourceName("技术社区");
        resourceInfo4.setResourceDetail("网站主要是关于web开发以及android开发两方面的资料，目前更侧重于android开发1111");
        resourceInfo4.setResourcePic(getActivity().getResources().getDrawable(R.mipmap.pic_icon04));
        resourceInfo4.setResourceUrl("aaaaaaaaaaa");
        resources.add(resourceInfo4);

        BaseResourceInfo resourceInfo5 = new BaseResourceInfo();
        resourceInfo5.setResourceId("005");
        resourceInfo5.setResourceName("技术社区");
        resourceInfo5.setResourceDetail("网站主要是关于web开发以及android开发两方面的资料，目前更侧重于android开发1111");
        resourceInfo5.setResourcePic(getActivity().getResources().getDrawable(R.drawable.addphoto));
        resourceInfo5.setResourceUrl("aaaaaaaaaaa");
        resources.add(resourceInfo5);


        BaseResourceInfo resourceInfo6 = new BaseResourceInfo();
        resourceInfo6.setResourceId("006");
        resourceInfo6.setResourceName("技术社区");
        resourceInfo6.setResourceDetail("网站主要是关于web开发以及android开发两方面的资料，目前更侧重于android开发1111");
        resourceInfo6.setResourcePic(getActivity().getResources().getDrawable(R.drawable.addphoto));
        resourceInfo6.setResourceUrl("aaaaaaaaaaa");
        resources.add(resourceInfo6);

        BaseResourceInfo resourceInfo7 = new BaseResourceInfo();
        resourceInfo7.setResourceId("007");
        resourceInfo7.setResourceName("技术社区");
        resourceInfo7.setResourceDetail("网站主要是关于web开发以及android开发两方面的资料，目前更侧重于android开发1111");
        resourceInfo7.setResourcePic(getActivity().getResources().getDrawable(R.drawable.addphoto));
        resourceInfo7.setResourceUrl("aaaaaaaaaaa");
        resources.add(resourceInfo7);


        BaseResourceInfo resourceInfo8 = new BaseResourceInfo();
        resourceInfo8.setResourceId("008");
        resourceInfo8.setResourceName("技术社区");
        resourceInfo8.setResourceDetail("网站主要是关于web开发以及android开发两方面的资料，目前更侧重于android开发1111");
        resourceInfo8.setResourcePic(getActivity().getResources().getDrawable(R.drawable.addphoto));
        resourceInfo8.setResourceUrl("aaaaaaaaaaa");
        resources.add(resourceInfo8);

        BaseResourceInfo resourceInfo9 = new BaseResourceInfo();
        resourceInfo9.setResourceId("009");
        resourceInfo9.setResourceName("技术社区");
        resourceInfo9.setResourceDetail("网站主要是关于web开发以及android开发两方面的资料，目前更侧重于android开发1111");
        resourceInfo9.setResourcePic(getActivity().getResources().getDrawable(R.drawable.addphoto));
        resourceInfo9.setResourceUrl("aaaaaaaaaaa");
        resources.add(resourceInfo9);
    }

    @Override
    protected void initView() {
        tv_title_center.setText("精品推荐");

        if(resourceOneAdapter == null){
            resourceOneAdapter = new ResourceOneAdapter(getContext());
            resourceOneAdapter.notifyDataSetChanged();
        }

        ptrRecyclerView_resource_one.setLayoutManager(new LinearLayoutManager(getContext()));
        ptrRecyclerView_resource_one.setAdapterWithProgress(resourceOneAdapter);

        resourceOneAdapter.setMore(R.layout.view_more, this);
        resourceOneAdapter.setNoMore(R.layout.view_nomore);
        resourceOneAdapter.setError(R.layout.view_error).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resourceOneAdapter.resumeMore();
            }
        });

        PtrFrameLayout ptrFrameLayout = ptrRecyclerView_resource_one.getPtrFrameLayout();
        ptrRecyclerView_resource_one.setRefreshListener(this);
        onRefreshBegin(ptrFrameLayout);

        /*resourceOneAdapter.addHeader(new RecyclerArrayAdapter.ItemView() {
            @Override
            public View onCreateView(ViewGroup parent) {
                LayoutInflater inflater=(LayoutInflater)getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                View view = inflater.inflate(R.layout.view_learn_resource_header, null);

                return view;
            }

            @Override
            public void onBindView(View headerView) {

            }
        });
*/


    }

    @OnClick(R.id.rl_title_left)
    public void goback(){
        getActivity().finish();
    }


    @Override
    public void onLoadMore() {

    }

    @Override
    public boolean checkCanDoRefresh(PtrFrameLayout frame, View content, View header) {
        return PtrDefaultHandler.checkContentCanBePulledDown(frame, content, header);
    }

    List<BaseResourceInfo> datas = new ArrayList<BaseResourceInfo>();

    @Override
    public void onRefreshBegin(PtrFrameLayout frame) {

        if(resources != null && resources.size() > 0){
            if (resources.size() < 2) {
                resourceOneAdapter.setNoMore(R.layout.view_nomore1);
            }
            datas.clear();
            datas.addAll(resources);
            resourceOneAdapter.clear();
            resourceOneAdapter.addAll(datas);
        }
    }
}
