package com.nutiteq.advancedmap;

import java.util.Map;

import javax.microedition.khronos.opengles.GL10;

import android.os.Handler;
import android.util.Log;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;

import com.nutiteq.components.MapPos;
import com.nutiteq.geometry.Marker;
import com.nutiteq.geometry.VectorElement;
import com.nutiteq.layers.raster.MBTilesMapLayer;
import com.nutiteq.layers.raster.db.MbTilesDatabaseHelper;
import com.nutiteq.projections.EPSG3857;
import com.nutiteq.ui.Label;
import com.nutiteq.ui.MapListener;
import com.nutiteq.ui.ViewLabel;

public class MapEventListener extends MapListener {

	private AdvancedMapActivity activity;

	// activity is often useful to handle click events
	public MapEventListener(AdvancedMapActivity activity) {
		this.activity = activity;
	}

	// Map drawing callbacks for OpenGL manipulations
	@Override
	public void onSurfaceChanged(GL10 gl, int width, int height) {
	}

	@Override
	public void onDrawFrameAfter3D(GL10 gl, float zoomPow2) {
	}

	@Override
	public void onDrawFrameBefore3D(GL10 gl, float zoomPow2) {
	}

	// Vector element (touch) handlers
	@Override
	public void onLabelClicked(VectorElement vectorElement, boolean longClick) {
		// Toast.makeText(activity, "onLabelClicked "+((DefaultLabel)
		// vectorElement.getLabel()).getTitle()+" longClick: "+longClick,
		// Toast.LENGTH_SHORT).show();
	}

	@Override
	public void onVectorElementClicked(VectorElement vectorElement, double x,
			double y, boolean longClick) {
		// Toast.makeText(activity, "onVectorElementClicked "+((DefaultLabel)
		// vectorElement.getLabel()).getTitle()+" longClick: "+longClick,
		// Toast.LENGTH_SHORT).show();

	}

	// Map View manipulation handlers
	@Override
	public void onMapClicked(final double x, final double y,
			final boolean longClick) {
		// x and y are in base map projection, we convert them to the familiar
		// WGS84
		Log.d("nm", "onMapClicked " + (new EPSG3857()).toWgs84(x, y).x + " "
				+ (new EPSG3857()).toWgs84(x, y).y + " longClick: " + longClick);

	}

	@Override
	public void onMapMoved() {
		// this method is also called from non-UI thread
	}

	// Progress indication handlers
	@Override
	public void onBackgroundTasksStarted() {
		// This method is called when mapping library is performing relatively
		// long lasting operations.
		// This is good place to show some progress indicator.
		// NOTE: in order to make title progress bar work, place
		// requestWindowFeature(Window.FEATURE_INDETERMINATE_PROGRESS)
		// just before setContentView call in your Activity's onCreate method.
		activity.setProgressBarIndeterminateVisibility(true);
	}

	@Override
	public void onBackgroundTasksFinished() {
		// This method is called when mapping library has finished all long
		// lasting operations.
		activity.setProgressBarIndeterminateVisibility(false);
	}

}
