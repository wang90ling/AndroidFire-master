package com.jaydenxiao.androidfire.ui.resource.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.jaydenxiao.androidfire.R;
import com.jaydenxiao.androidfire.bean.LearnResourceInfo;
import com.jaydenxiao.androidfire.factory.FragmentFactory;
import com.jaydenxiao.androidfire.manager.PageSwitcherManager;
import com.jude.easyrecyclerview.adapter.BaseViewHolder;
import com.jude.easyrecyclerview.adapter.RecyclerArrayAdapter;

/**
 * Created by wangfengkai on 2016/10/14.
 */
public class DemoListAdapter extends RecyclerArrayAdapter<LearnResourceInfo> {

    public DemoListAdapter(Context context) {
        super(context);
    }

    @Override
    public BaseViewHolder OnCreateViewHolder(ViewGroup parent, int viewType) {
        return new LearnResourceViewHolder(parent);
    }


    class LearnResourceViewHolder extends BaseViewHolder<LearnResourceInfo> {

        private TextView tv_resourcename;
        private LinearLayout ll_resource_item;

        public LearnResourceViewHolder(ViewGroup parent) {
            super(parent, R.layout.learn_resource_item);
            tv_resourcename = $(R.id.tv_resourcename);
            ll_resource_item = $(R.id.ll_resource_item);
        }

        @Override
        public void setData(final LearnResourceInfo detail){
            tv_resourcename.setText(detail.getResourceName());

            ll_resource_item.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    String resourceId = detail.getResourceId();
                    if("001".equals(resourceId)){
                        //Toast.makeText(getContext(),"点击条目001",Toast.LENGTH_SHORT).show();
                        PageSwitcherManager.switchToPage(getContext(), FragmentFactory.FRAGMENT_TYPE_DEMO01);
                    }else if("002".equals(resourceId)){
                        //Toast.makeText(getContext(),"点击条目002",Toast.LENGTH_SHORT).show();
                        PageSwitcherManager.switchToPage(getContext(), FragmentFactory.FRAGMENT_TYPE_DEMO02);
                    }else if("003".equals(resourceId)){
                        //Toast.makeText(getContext(),"点击条目003",Toast.LENGTH_SHORT).show();
                        PageSwitcherManager.switchToPage(getContext(), FragmentFactory.FRAGMENT_TYPE_DEMO03);
                    }else if("004".equals(resourceId)){
                        Toast.makeText(getContext(),"点击条目004",Toast.LENGTH_SHORT).show();
                        PageSwitcherManager.switchToPage(getContext(), FragmentFactory.FRAGMENT_TYPE_MINE_APPLY);
                    }else if("005".equals(resourceId)){
                        Toast.makeText(getContext(),"点击条目005",Toast.LENGTH_SHORT).show();
                        PageSwitcherManager.switchToPage(getContext(), FragmentFactory.FRAGMENT_TYPE_MINE_APPLY);
                    }else if("006".equals(resourceId)){
                        Toast.makeText(getContext(),"点击条目006",Toast.LENGTH_SHORT).show();
                        PageSwitcherManager.switchToPage(getContext(), FragmentFactory.FRAGMENT_TYPE_MINE_APPLY);
                    }else if("007".equals(resourceId)){
                        Toast.makeText(getContext(),"点击条目007",Toast.LENGTH_SHORT).show();
                        PageSwitcherManager.switchToPage(getContext(), FragmentFactory.FRAGMENT_TYPE_MINE_APPLY);
                    }else if("008".equals(resourceId)){
                        Toast.makeText(getContext(),"点击条目008",Toast.LENGTH_SHORT).show();
                        PageSwitcherManager.switchToPage(getContext(), FragmentFactory.FRAGMENT_TYPE_MINE_APPLY);
                    }
                }
            });
        }
    }

}
