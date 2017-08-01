package com.nat.weex;

import android.Manifest;
import android.app.Activity;

import com.nat.geolocation.HLConstant;
import com.nat.geolocation.HLGeoModule;
import com.nat.geolocation.HLModuleResultListener;
import com.nat.geolocation.HLUtil;
import com.nat.permission.PermissionChecker;
import com.taobao.weex.annotation.JSMethod;
import com.taobao.weex.bridge.JSCallback;
import com.taobao.weex.common.WXModule;

import java.util.HashMap;

/**
 * Created by Daniel on 17/2/17.
 * Copyright (c) 2017 Nat. All rights reserved.
 */

public class GeolocationModule extends WXModule {

    JSCallback mGetCallback;
    JSCallback mWatchCallback;
    HashMap<String, Object> mWatchParam;
    public static final int GET_REQUEST_CODE = 103;
    public static final int WATCH_REQUEST_CODE = 104;

    @JSMethod
    public void get(final JSCallback jsCallback){
        boolean b = PermissionChecker.lacksPermissions(mWXSDKInstance.getContext(), Manifest.permission.ACCESS_FINE_LOCATION, Manifest.permission.ACCESS_COARSE_LOCATION);
        if (b) {
            mGetCallback = jsCallback;
            HashMap<String, String> dialog = new HashMap<>();
            dialog.put("title", "权限申请");
            dialog.put("message", "请允许定位权限");
            PermissionChecker.requestPermissions((Activity) mWXSDKInstance.getContext(), dialog, new com.nat.permission.HLModuleResultListener() {
                @Override
                public void onResult(Object o) {
                    if (o != null && o.toString().equals("true")) {
                        jsCallback.invoke(HLUtil.getError(HLConstant.LOCATION_PERMISSION_DENIED, HLConstant.LOCATION_PERMISSION_DENIED_CODE));
                    }
                }
            }, GET_REQUEST_CODE, Manifest.permission.ACCESS_FINE_LOCATION, Manifest.permission.ACCESS_COARSE_LOCATION);
        } else {
            HLGeoModule.getInstance(mWXSDKInstance.getContext()).get(new HLModuleResultListener() {
                @Override
                public void onResult(Object o) {
                    jsCallback.invoke(o);
                }
            });
        }
    }

    @JSMethod
    public void watch(HashMap<String, Object> param, final JSCallback jsCallback){
        boolean b = PermissionChecker.lacksPermissions(mWXSDKInstance.getContext(), Manifest.permission.ACCESS_FINE_LOCATION, Manifest.permission.ACCESS_COARSE_LOCATION);
        if (b) {
            mWatchCallback = jsCallback;
            mWatchParam = param;
            HashMap<String, String> dialog = new HashMap<>();
            dialog.put("title", "权限申请");
            dialog.put("message", "请允许定位权限");
            PermissionChecker.requestPermissions((Activity) mWXSDKInstance.getContext(), dialog, new com.nat.permission.HLModuleResultListener() {
                @Override
                public void onResult(Object o) {
                    if (o != null && o.toString().equals("true")) {
                        jsCallback.invoke(HLUtil.getError(HLConstant.LOCATION_PERMISSION_DENIED, HLConstant.LOCATION_PERMISSION_DENIED_CODE));
                    }
                }
            }, WATCH_REQUEST_CODE, Manifest.permission.ACCESS_FINE_LOCATION, Manifest.permission.ACCESS_COARSE_LOCATION);
        } else {
            HLGeoModule.getInstance(mWXSDKInstance.getContext()).watch(param, new HLModuleResultListener() {
                @Override
                public void onResult(Object o) {
                    jsCallback.invokeAndKeepAlive(o);
                }
            });
        }
    }

    @JSMethod
    public void clearWatch(final JSCallback jsCallback){
        HLGeoModule.getInstance(mWXSDKInstance.getContext()).clearWatch(new HLModuleResultListener() {
            @Override
            public void onResult(Object o) {
                jsCallback.invoke(o);
            }
        });
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == GET_REQUEST_CODE) {
            if (PermissionChecker.hasAllPermissionsGranted(grantResults)) {
                HLGeoModule.getInstance(mWXSDKInstance.getContext()).get(new HLModuleResultListener() {
                    @Override
                    public void onResult(Object o) {
                        mGetCallback.invoke(o);
                    }
                });
            } else {
                if (mGetCallback != null) mGetCallback.invoke(HLUtil.getError(HLConstant.LOCATION_PERMISSION_DENIED, HLConstant.LOCATION_PERMISSION_DENIED_CODE));
            }
        }

        if (requestCode == WATCH_REQUEST_CODE) {
            if (PermissionChecker.hasAllPermissionsGranted(grantResults)) {
                HLGeoModule.getInstance(mWXSDKInstance.getContext()).watch(mWatchParam, new HLModuleResultListener() {
                    @Override
                    public void onResult(Object o) {
                        mWatchCallback.invokeAndKeepAlive(o);
                    }
                });
            } else {
                if (mWatchCallback != null) mWatchCallback.invoke(HLUtil.getError(HLConstant.LOCATION_PERMISSION_DENIED, HLConstant.LOCATION_PERMISSION_DENIED_CODE));
            }
        }
    }
}
