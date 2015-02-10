/*
 * Copyright (C) 2013 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.android.camera.app;

import android.app.Application;

import com.android.camera.util.CameraUtil;
import com.android.camera.util.UsageStatistics;
import com.google.android.gms.analytics.GoogleAnalytics;
import com.google.android.gms.analytics.Logger.LogLevel;
import com.google.android.gms.analytics.Tracker;

public class CameraApp extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        UsageStatistics.initialize(this);
        CameraUtil.initialize(this);
        
        this.getAnalyticsTracker();
    }
    
    private Tracker getAnalyticsTracker() {
    	if (mAnalyticsTracker == null) {
    	    GoogleAnalytics analytics = GoogleAnalytics.getInstance(this);
    	    analytics.enableAutoActivityReports(this);
    	    analytics.getLogger().setLogLevel(LogLevel.VERBOSE);

    	    mAnalyticsTracker = analytics.newTracker(mTrackerID);
    	    mAnalyticsTracker.enableAutoActivityTracking(true);
    	    mAnalyticsTracker.enableExceptionReporting(true);
    	}
    	return mAnalyticsTracker;
    }
    
    private Tracker mAnalyticsTracker;
    private String mTrackerID = "UA-59522160-1";
}

