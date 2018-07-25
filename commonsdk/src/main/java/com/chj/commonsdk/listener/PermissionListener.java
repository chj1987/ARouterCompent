package com.chj.commonsdk.listener;

import java.util.List;

public interface PermissionListener {
    void onGranted();

    void onGranted(List<String> deniedPermissions);
}
