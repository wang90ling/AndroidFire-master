package com.jaydenxiao.androidfire.bean;

import android.graphics.drawable.Drawable;

/**
 * Created by wangfengkai on 2016/10/14.
 */
public class BaseResourceInfo {

    private String ResourceId;
    private String ResourceName;
    private String ResourceDetail;
    private String ResourceUrl;
    private Drawable ResourcePic;

    public String getResourceId() {
        return ResourceId;
    }

    public void setResourceId(String resourceId) {
        ResourceId = resourceId;
    }

    public String getResourceName() {
        return ResourceName;
    }

    public void setResourceName(String resourceName) {
        ResourceName = resourceName;
    }

    public String getResourceDetail() {
        return ResourceDetail;
    }

    public void setResourceDetail(String resourceDetail) {
        ResourceDetail = resourceDetail;
    }

    public String getResourceUrl() {
        return ResourceUrl;
    }

    public void setResourceUrl(String resourceUrl) {
        ResourceUrl = resourceUrl;
    }

    public Drawable getResourcePic() {
        return ResourcePic;
    }

    public void setResourcePic(Drawable resourcePic) {
        ResourcePic = resourcePic;
    }
}
