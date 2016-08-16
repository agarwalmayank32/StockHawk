package com.sam_chordas.android.stockhawk.ui;

import android.appwidget.AppWidgetManager;
import android.content.Intent;
import android.widget.RemoteViewsService;

public class WidgetService extends RemoteViewsService {
	/*
	 * So pretty simple just defining the Adapter of the listview
	 * here Adapter is ListProvider
	 * */

	@Override
	public RemoteViewsFactory onGetViewFactory(Intent intent) {
		intent.getIntExtra(AppWidgetManager.EXTRA_APPWIDGET_ID, AppWidgetManager.INVALID_APPWIDGET_ID);
		return (new ListProvider(getApplicationContext(), intent));
	}

}
