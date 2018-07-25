package com.chj.commonsdk.arouter;

public interface RouterHub {

    /**
     * 组名
     */
    String APP = "/app";//宿主 App 组件
    String CUSTOM = "/custom";
    String VIDEO = "/video";

    /**
     * 服务组件, 用于给每个组件暴露特有的服务
     */
    String SERVICE = "/service";


    /**
     * 分组
     */
    String CUSTOM_CUSTOMACTIVITY = CUSTOM + "/CustomActivity";

    /**
     * 分组
     */
    String VIDEO_VIDEOACTIVITY = VIDEO + "/VideoActivity";

}
