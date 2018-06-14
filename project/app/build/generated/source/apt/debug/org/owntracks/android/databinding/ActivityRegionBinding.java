package org.owntracks.android.databinding;
import org.owntracks.android.R;
import org.owntracks.android.BR;
import android.view.View;
public class ActivityRegionBinding extends android.databinding.ViewDataBinding  {

    private static final android.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = null;
        sViewsWithIds = new android.util.SparseIntArray();
        sViewsWithIds.put(R.id.toolbar, 8);
        sViewsWithIds.put(R.id.shareWrapper, 9);
        sViewsWithIds.put(R.id.descShare, 10);
        sViewsWithIds.put(R.id.share, 11);
    }
    // views
    public final com.rengwuxian.materialedittext.MaterialEditText beaconMajor;
    public final com.rengwuxian.materialedittext.MaterialEditText beaconMinor;
    public final com.rengwuxian.materialedittext.MaterialEditText beaconUUID;
    public final android.widget.TextView descShare;
    public final com.rengwuxian.materialedittext.MaterialEditText description;
    public final com.rengwuxian.materialedittext.MaterialEditText latitude;
    public final com.rengwuxian.materialedittext.MaterialEditText longitude;
    private final android.widget.LinearLayout mboundView0;
    public final com.rengwuxian.materialedittext.MaterialEditText radius;
    public final android.widget.Switch share;
    public final android.widget.RelativeLayout shareWrapper;
    public final android.support.v7.widget.Toolbar toolbar;
    // variables
    private org.owntracks.android.db.Waypoint mItem;
    // values
    // listeners
    // Inverse Binding Event Handlers

    public ActivityRegionBinding(android.databinding.DataBindingComponent bindingComponent, View root) {
        super(bindingComponent, root, 0);
        final Object[] bindings = mapBindings(bindingComponent, root, 12, sIncludes, sViewsWithIds);
        this.beaconMajor = (com.rengwuxian.materialedittext.MaterialEditText) bindings[6];
        this.beaconMajor.setTag(null);
        this.beaconMinor = (com.rengwuxian.materialedittext.MaterialEditText) bindings[7];
        this.beaconMinor.setTag(null);
        this.beaconUUID = (com.rengwuxian.materialedittext.MaterialEditText) bindings[5];
        this.beaconUUID.setTag(null);
        this.descShare = (android.widget.TextView) bindings[10];
        this.description = (com.rengwuxian.materialedittext.MaterialEditText) bindings[1];
        this.description.setTag(null);
        this.latitude = (com.rengwuxian.materialedittext.MaterialEditText) bindings[2];
        this.latitude.setTag(null);
        this.longitude = (com.rengwuxian.materialedittext.MaterialEditText) bindings[3];
        this.longitude.setTag(null);
        this.mboundView0 = (android.widget.LinearLayout) bindings[0];
        this.mboundView0.setTag(null);
        this.radius = (com.rengwuxian.materialedittext.MaterialEditText) bindings[4];
        this.radius.setTag(null);
        this.share = (android.widget.Switch) bindings[11];
        this.shareWrapper = (android.widget.RelativeLayout) bindings[9];
        this.toolbar = (android.support.v7.widget.Toolbar) bindings[8];
        setRootTag(root);
        // listeners
        invalidateAll();
    }

    @Override
    public void invalidateAll() {
        synchronized(this) {
                mDirtyFlags = 0x2L;
        }
        requestRebind();
    }

    @Override
    public boolean hasPendingBindings() {
        synchronized(this) {
            if (mDirtyFlags != 0) {
                return true;
            }
        }
        return false;
    }

    public boolean setVariable(int variableId, Object variable) {
        switch(variableId) {
            case BR.item :
                setItem((org.owntracks.android.db.Waypoint) variable);
                return true;
        }
        return false;
    }

    public void setItem(org.owntracks.android.db.Waypoint Item) {
        this.mItem = Item;
        synchronized(this) {
            mDirtyFlags |= 0x1L;
        }
        notifyPropertyChanged(BR.item);
        super.requestRebind();
    }
    public org.owntracks.android.db.Waypoint getItem() {
        return mItem;
    }

    @Override
    protected boolean onFieldChange(int localFieldId, Object object, int fieldId) {
        switch (localFieldId) {
        }
        return false;
    }

    @Override
    protected void executeBindings() {
        long dirtyFlags = 0;
        synchronized(this) {
            dirtyFlags = mDirtyFlags;
            mDirtyFlags = 0;
        }
        org.owntracks.android.db.Waypoint item = mItem;
        java.lang.String orgOwntracksAndroidSupportWidgetsBindingConversionsConvertIntegerToStringItemBeaconMajor = null;
        java.lang.String orgOwntracksAndroidSupportWidgetsBindingConversionsConvertIntegerToStringItemBeaconMinor = null;
        java.lang.Integer itemBeaconMajor = null;
        java.lang.String itemBeaconUUID = null;
        java.lang.Integer itemBeaconMinor = null;
        double itemGeofenceLatitude = 0.0;
        java.lang.String itemDescription = null;
        java.lang.Integer itemGeofenceRadius = null;
        java.lang.String orgOwntracksAndroidSupportWidgetsBindingConversionsConvertIntegerToStringItemGeofenceRadius = null;
        double itemGeofenceLongitude = 0.0;

        if ((dirtyFlags & 0x3L) != 0) {



                if (item != null) {
                    // read item.beaconMajor
                    itemBeaconMajor = item.getBeaconMajor();
                    // read item.beaconUUID
                    itemBeaconUUID = item.getBeaconUUID();
                    // read item.beaconMinor
                    itemBeaconMinor = item.getBeaconMinor();
                    // read item.geofenceLatitude
                    itemGeofenceLatitude = item.getGeofenceLatitude();
                    // read item.description
                    itemDescription = item.getDescription();
                    // read item.geofenceRadius
                    itemGeofenceRadius = item.getGeofenceRadius();
                    // read item.geofenceLongitude
                    itemGeofenceLongitude = item.getGeofenceLongitude();
                }


                // read org.owntracks.android.support.widgets.BindingConversions.convertIntegerToString(item.beaconMajor)
                orgOwntracksAndroidSupportWidgetsBindingConversionsConvertIntegerToStringItemBeaconMajor = org.owntracks.android.support.widgets.BindingConversions.convertIntegerToString(itemBeaconMajor);
                // read org.owntracks.android.support.widgets.BindingConversions.convertIntegerToString(item.beaconMinor)
                orgOwntracksAndroidSupportWidgetsBindingConversionsConvertIntegerToStringItemBeaconMinor = org.owntracks.android.support.widgets.BindingConversions.convertIntegerToString(itemBeaconMinor);
                // read org.owntracks.android.support.widgets.BindingConversions.convertIntegerToString(item.geofenceRadius)
                orgOwntracksAndroidSupportWidgetsBindingConversionsConvertIntegerToStringItemGeofenceRadius = org.owntracks.android.support.widgets.BindingConversions.convertIntegerToString(itemGeofenceRadius);
        }
        // batch finished
        if ((dirtyFlags & 0x3L) != 0) {
            // api target 1

            android.databinding.adapters.TextViewBindingAdapter.setText(this.beaconMajor, org.owntracks.android.support.widgets.BindingConversions.convertToString(orgOwntracksAndroidSupportWidgetsBindingConversionsConvertIntegerToStringItemBeaconMajor));
            android.databinding.adapters.TextViewBindingAdapter.setText(this.beaconMinor, org.owntracks.android.support.widgets.BindingConversions.convertToString(orgOwntracksAndroidSupportWidgetsBindingConversionsConvertIntegerToStringItemBeaconMinor));
            android.databinding.adapters.TextViewBindingAdapter.setText(this.beaconUUID, org.owntracks.android.support.widgets.BindingConversions.convertToString(itemBeaconUUID));
            android.databinding.adapters.TextViewBindingAdapter.setText(this.description, org.owntracks.android.support.widgets.BindingConversions.convertToString(itemDescription));
            android.databinding.adapters.TextViewBindingAdapter.setText(this.latitude, org.owntracks.android.support.widgets.BindingConversions.convertDoubleToString(itemGeofenceLatitude));
            android.databinding.adapters.TextViewBindingAdapter.setText(this.longitude, org.owntracks.android.support.widgets.BindingConversions.convertDoubleToString(itemGeofenceLongitude));
            android.databinding.adapters.TextViewBindingAdapter.setText(this.radius, org.owntracks.android.support.widgets.BindingConversions.convertToString(orgOwntracksAndroidSupportWidgetsBindingConversionsConvertIntegerToStringItemGeofenceRadius));
        }
    }
    // Listener Stub Implementations
    // callback impls
    // dirty flag
    private  long mDirtyFlags = 0xffffffffffffffffL;

    public static ActivityRegionBinding inflate(android.view.LayoutInflater inflater, android.view.ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, android.databinding.DataBindingUtil.getDefaultComponent());
    }
    public static ActivityRegionBinding inflate(android.view.LayoutInflater inflater, android.view.ViewGroup root, boolean attachToRoot, android.databinding.DataBindingComponent bindingComponent) {
        return android.databinding.DataBindingUtil.<ActivityRegionBinding>inflate(inflater, org.owntracks.android.R.layout.activity_region, root, attachToRoot, bindingComponent);
    }
    public static ActivityRegionBinding inflate(android.view.LayoutInflater inflater) {
        return inflate(inflater, android.databinding.DataBindingUtil.getDefaultComponent());
    }
    public static ActivityRegionBinding inflate(android.view.LayoutInflater inflater, android.databinding.DataBindingComponent bindingComponent) {
        return bind(inflater.inflate(org.owntracks.android.R.layout.activity_region, null, false), bindingComponent);
    }
    public static ActivityRegionBinding bind(android.view.View view) {
        return bind(view, android.databinding.DataBindingUtil.getDefaultComponent());
    }
    public static ActivityRegionBinding bind(android.view.View view, android.databinding.DataBindingComponent bindingComponent) {
        if (!"layout/activity_region_0".equals(view.getTag())) {
            throw new RuntimeException("view tag isn't correct on view:" + view.getTag());
        }
        return new ActivityRegionBinding(bindingComponent, view);
    }
    /* flag mapping
        flag 0 (0x1L): item
        flag 1 (0x2L): null
    flag mapping end*/
    //end
}