package com.android.camera.util;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;

public class IntentHelper {

    private static final String GALLERY_PACKAGE_NAME = "com.radcam.gallery";
    private static final String GALLERY_ACTIVITY_CLASS =
        "com.android.gallery3d.app.GalleryActivity";

    public static Intent getGalleryIntent(Context context) {
        return new Intent(Intent.ACTION_MAIN)
            .setClassName(GALLERY_PACKAGE_NAME, GALLERY_ACTIVITY_CLASS);
    }

    public static Intent getVideoPlayerIntent(Context context, Uri uri) {
        return new Intent(Intent.ACTION_VIEW)
            .setPackage(GALLERY_PACKAGE_NAME)
            .setDataAndType(uri, "video/*");
    }
}
