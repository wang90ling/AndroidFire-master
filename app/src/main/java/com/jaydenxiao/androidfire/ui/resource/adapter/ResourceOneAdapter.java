package com.jaydenxiao.androidfire.ui.resource.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.jaydenxiao.androidfire.R;
import com.jaydenxiao.androidfire.bean.BaseResourceInfo;
import com.jaydenxiao.androidfire.bean.LearnResourceInfo;
import com.jaydenxiao.androidfire.factory.FragmentFactory;
import com.jaydenxiao.androidfire.manager.PageSwitcherManager;
import com.jude.easyrecyclerview.adapter.BaseViewHolder;
import com.jude.easyrecyclerview.adapter.RecyclerArrayAdapter;

/**
 * Created by wangfengkai on 2016/10/14.
 */
public class ResourceOneAdapter extends RecyclerArrayAdapter<BaseResourceInfo> {

    public ResourceOneAdapter(Context context) {
        super(context);
    }

    @Override
    public BaseViewHolder OnCreateViewHolder(ViewGroup parent, int viewType) {
        return new ResourceOneViewHolder(parent);
    }

    class ResourceOneViewHolder extends BaseViewHolder<BaseResourceInfo> {

        private TextView tv_resourcename,tv_resourcedetail;
        private LinearLayout ll_resource_item;
        private ImageView iv_resource_icon;

        public ResourceOneViewHolder(ViewGroup parent) {
            super(parent, R.layout.resource_one_item);
            tv_resourcename = $(R.id.tv_resourcename);
            tv_resourcedetail = $(R.id.tv_resourcedetail);
            iv_resource_icon = $(R.id.iv_resource_icon);
            ll_resource_item = $(R.id.ll_resource_item);
        }

        @Override
        public void setData(final BaseResourceInfo detail){
            tv_resourcename.setText(detail.getResourceName());
            tv_resourcedetail.setText(detail.getResourceDetail());
            iv_resource_icon.setImageDrawable(detail.getResourcePic());
            final String resourceUrl = detail.getResourceUrl();
            ll_resource_item.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String resourceId = detail.getResourceId();
                    //Toast.makeText(getContext(),resourceUrl,Toast.LENGTH_SHORT).show();
                    PageSwitcherManager.switchToPage(getContext(), FragmentFactory.FRAGMENT_TYPE_WEBVIEW);
                }
            });
        }
    }

}
