package org.owntracks.android.databinding;
import org.owntracks.android.R;
import org.owntracks.android.BR;
import android.view.View;
public class UiActivityStatusBinding extends android.databinding.ViewDataBinding  {

    private static final android.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = null;
        sViewsWithIds = new android.util.SparseIntArray();
        sViewsWithIds.put(R.id.toolbar, 8);
    }
    // views
    public final android.support.design.widget.CoordinatorLayout frame;
    private final android.widget.TextView mboundView1;
    private final android.widget.TextView mboundView2;
    private final android.widget.TextView mboundView3;
    private final android.widget.TextView mboundView4;
    private final android.widget.TextView mboundView5;
    private final android.widget.TextView mboundView6;
    private final android.widget.TextView mboundView7;
    public final android.support.v7.widget.Toolbar toolbar;
    // variables
    private org.owntracks.android.ui.status.StatusViewModel mVm;
    // values
    // listeners
    // Inverse Binding Event Handlers

    public UiActivityStatusBinding(android.databinding.DataBindingComponent bindingComponent, View root) {
        super(bindingComponent, root, 1);
        final Object[] bindings = mapBindings(bindingComponent, root, 9, sIncludes, sViewsWithIds);
        this.frame = (android.support.design.widget.CoordinatorLayout) bindings[0];
        this.frame.setTag(null);
        this.mboundView1 = (android.widget.TextView) bindings[1];
        this.mboundView1.setTag(null);
        this.mboundView2 = (android.widget.TextView) bindings[2];
        this.mboundView2.setTag(null);
        this.mboundView3 = (android.widget.TextView) bindings[3];
        this.mboundView3.setTag(null);
        this.mboundView4 = (android.widget.TextView) bindings[4];
        this.mboundView4.setTag(null);
        this.mboundView5 = (android.widget.TextView) bindings[5];
        this.mboundView5.setTag(null);
        this.mboundView6 = (android.widget.TextView) bindings[6];
        this.mboundView6.setTag(null);
        this.mboundView7 = (android.widget.TextView) bindings[7];
        this.mboundView7.setTag(null);
        this.toolbar = (android.support.v7.widget.Toolbar) bindings[8];
        setRootTag(root);
        // listeners
        invalidateAll();
    }

    @Override
    public void invalidateAll() {
        synchronized(this) {
                mDirtyFlags = 0x100L;
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
            case BR.vm :
                setVm((org.owntracks.android.ui.status.StatusViewModel) variable);
                return true;
        }
        return false;
    }

    public void setVm(org.owntracks.android.ui.status.StatusViewModel Vm) {
        updateRegistration(0, Vm);
        this.mVm = Vm;
        synchronized(this) {
            mDirtyFlags |= 0x1L;
        }
        notifyPropertyChanged(BR.vm);
        super.requestRebind();
    }
    public org.owntracks.android.ui.status.StatusViewModel getVm() {
        return mVm;
    }

    @Override
    protected boolean onFieldChange(int localFieldId, Object object, int fieldId) {
        switch (localFieldId) {
            case 0 :
                return onChangeVm((org.owntracks.android.ui.status.StatusViewModel) object, fieldId);
        }
        return false;
    }
    private boolean onChangeVm(org.owntracks.android.ui.status.StatusViewModel Vm, int fieldId) {
        switch (fieldId) {
            case BR.endpointState: {
                synchronized(this) {
                        mDirtyFlags |= 0x2L;
                }
                return true;
            }
            case BR.endpointMessage: {
                synchronized(this) {
                        mDirtyFlags |= 0x4L;
                }
                return true;
            }
            case BR.endpointQueue: {
                synchronized(this) {
                        mDirtyFlags |= 0x8L;
                }
                return true;
            }
            case BR.permissionLocation: {
                synchronized(this) {
                        mDirtyFlags |= 0x10L;
                }
                return true;
            }
            case BR.locationUpdated: {
                synchronized(this) {
                        mDirtyFlags |= 0x20L;
                }
                return true;
            }
            case BR.appStarted: {
                synchronized(this) {
                        mDirtyFlags |= 0x40L;
                }
                return true;
            }
            case BR.serviceStarted: {
                synchronized(this) {
                        mDirtyFlags |= 0x80L;
                }
                return true;
            }
            case BR._all: {
                synchronized(this) {
                        mDirtyFlags |= 0x1L;
                }
                return true;
            }
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
        org.owntracks.android.ui.status.StatusViewModel vm = mVm;
        java.lang.String appFormatDateVmLocationUpdated = null;
        org.owntracks.android.services.ServiceMessage.EndpointState vmEndpointState = null;
        boolean vmAppStartedJavaLangObjectNull = false;
        java.lang.String vmAppStartedJavaLangObjectNullAppFormatDateVmAppStartedMboundView6AndroidStringNa = null;
        java.lang.String vmLocationUpdatedJavaLangObjectNullAppFormatDateVmLocationUpdatedMboundView5AndroidStringNa = null;
        boolean vmLocationUpdatedJavaLangObjectNull = false;
        int vmEndpointQueue = 0;
        java.util.Date vmLocationUpdated = null;
        java.lang.String vmEndpointMessage = null;
        java.util.Date vmServiceStarted = null;
        java.lang.String vmEndpointMessageJavaLangObjectNullMboundView2AndroidStringNaVmEndpointMessage = null;
        java.lang.String appFormatDateVmAppStarted = null;
        java.lang.String vmServiceStartedJavaLangObjectNullAppFormatDateVmServiceStartedMboundView7AndroidStringNa = null;
        java.lang.String orgOwntracksAndroidSupportWidgetsBindingConversionsConvertToStringVmPermissionLocation = null;
        java.util.Date vmAppStarted = null;
        boolean vmEndpointMessageJavaLangObjectNull = false;
        java.lang.String orgOwntracksAndroidSupportWidgetsBindingConversionsConvertToStringVmEndpointQueue = null;
        boolean vmPermissionLocation = false;
        boolean vmServiceStartedJavaLangObjectNull = false;
        java.lang.String appFormatDateVmServiceStarted = null;

        if ((dirtyFlags & 0x1ffL) != 0) {


            if ((dirtyFlags & 0x103L) != 0) {

                    if (vm != null) {
                        // read vm.endpointState
                        vmEndpointState = vm.getEndpointState();
                    }
            }
            if ((dirtyFlags & 0x109L) != 0) {

                    if (vm != null) {
                        // read vm.endpointQueue
                        vmEndpointQueue = vm.getEndpointQueue();
                    }


                    // read org.owntracks.android.support.widgets.BindingConversions.convertToString(vm.endpointQueue)
                    orgOwntracksAndroidSupportWidgetsBindingConversionsConvertToStringVmEndpointQueue = org.owntracks.android.support.widgets.BindingConversions.convertToString(vmEndpointQueue);
            }
            if ((dirtyFlags & 0x121L) != 0) {

                    if (vm != null) {
                        // read vm.locationUpdated
                        vmLocationUpdated = vm.getLocationUpdated();
                    }


                    // read vm.locationUpdated != null
                    vmLocationUpdatedJavaLangObjectNull = (vmLocationUpdated) != (null);
                if((dirtyFlags & 0x121L) != 0) {
                    if(vmLocationUpdatedJavaLangObjectNull) {
                            dirtyFlags |= 0x1000L;
                    }
                    else {
                            dirtyFlags |= 0x800L;
                    }
                }
            }
            if ((dirtyFlags & 0x105L) != 0) {

                    if (vm != null) {
                        // read vm.endpointMessage
                        vmEndpointMessage = vm.getEndpointMessage();
                    }


                    // read vm.endpointMessage == null
                    vmEndpointMessageJavaLangObjectNull = (vmEndpointMessage) == (null);
                if((dirtyFlags & 0x105L) != 0) {
                    if(vmEndpointMessageJavaLangObjectNull) {
                            dirtyFlags |= 0x4000L;
                    }
                    else {
                            dirtyFlags |= 0x2000L;
                    }
                }
            }
            if ((dirtyFlags & 0x181L) != 0) {

                    if (vm != null) {
                        // read vm.serviceStarted
                        vmServiceStarted = vm.getServiceStarted();
                    }


                    // read vm.serviceStarted != null
                    vmServiceStartedJavaLangObjectNull = (vmServiceStarted) != (null);
                if((dirtyFlags & 0x181L) != 0) {
                    if(vmServiceStartedJavaLangObjectNull) {
                            dirtyFlags |= 0x10000L;
                    }
                    else {
                            dirtyFlags |= 0x8000L;
                    }
                }
            }
            if ((dirtyFlags & 0x141L) != 0) {

                    if (vm != null) {
                        // read vm.appStarted
                        vmAppStarted = vm.getAppStarted();
                    }


                    // read vm.appStarted != null
                    vmAppStartedJavaLangObjectNull = (vmAppStarted) != (null);
                if((dirtyFlags & 0x141L) != 0) {
                    if(vmAppStartedJavaLangObjectNull) {
                            dirtyFlags |= 0x400L;
                    }
                    else {
                            dirtyFlags |= 0x200L;
                    }
                }
            }
            if ((dirtyFlags & 0x111L) != 0) {

                    if (vm != null) {
                        // read vm.permissionLocation
                        vmPermissionLocation = vm.getPermissionLocation();
                    }


                    // read org.owntracks.android.support.widgets.BindingConversions.convertToString(vm.permissionLocation)
                    orgOwntracksAndroidSupportWidgetsBindingConversionsConvertToStringVmPermissionLocation = org.owntracks.android.support.widgets.BindingConversions.convertToString(vmPermissionLocation);
            }
        }
        // batch finished

        if ((dirtyFlags & 0x1000L) != 0) {

                // read App.formatDate(vm.locationUpdated)
                appFormatDateVmLocationUpdated = org.owntracks.android.App.formatDate(vmLocationUpdated);
        }
        if ((dirtyFlags & 0x105L) != 0) {

                // read vm.endpointMessage == null ? @android:string/na : vm.endpointMessage
                vmEndpointMessageJavaLangObjectNullMboundView2AndroidStringNaVmEndpointMessage = ((vmEndpointMessageJavaLangObjectNull) ? (mboundView2.getResources().getString(R.string.na)) : (vmEndpointMessage));
        }
        if ((dirtyFlags & 0x400L) != 0) {

                // read App.formatDate(vm.appStarted)
                appFormatDateVmAppStarted = org.owntracks.android.App.formatDate(vmAppStarted);
        }
        if ((dirtyFlags & 0x10000L) != 0) {

                // read App.formatDate(vm.serviceStarted)
                appFormatDateVmServiceStarted = org.owntracks.android.App.formatDate(vmServiceStarted);
        }

        if ((dirtyFlags & 0x141L) != 0) {

                // read vm.appStarted != null ? App.formatDate(vm.appStarted) : @android:string/na
                vmAppStartedJavaLangObjectNullAppFormatDateVmAppStartedMboundView6AndroidStringNa = ((vmAppStartedJavaLangObjectNull) ? (appFormatDateVmAppStarted) : (mboundView6.getResources().getString(R.string.na)));
        }
        if ((dirtyFlags & 0x121L) != 0) {

                // read vm.locationUpdated != null ? App.formatDate(vm.locationUpdated) : @android:string/na
                vmLocationUpdatedJavaLangObjectNullAppFormatDateVmLocationUpdatedMboundView5AndroidStringNa = ((vmLocationUpdatedJavaLangObjectNull) ? (appFormatDateVmLocationUpdated) : (mboundView5.getResources().getString(R.string.na)));
        }
        if ((dirtyFlags & 0x181L) != 0) {

                // read vm.serviceStarted != null ? App.formatDate(vm.serviceStarted) : @android:string/na
                vmServiceStartedJavaLangObjectNullAppFormatDateVmServiceStartedMboundView7AndroidStringNa = ((vmServiceStartedJavaLangObjectNull) ? (appFormatDateVmServiceStarted) : (mboundView7.getResources().getString(R.string.na)));
        }
        // batch finished
        if ((dirtyFlags & 0x103L) != 0) {
            // api target 1

            org.owntracks.android.support.widgets.BindingConversions.setText(this.mboundView1, vmEndpointState);
        }
        if ((dirtyFlags & 0x105L) != 0) {
            // api target 1

            android.databinding.adapters.TextViewBindingAdapter.setText(this.mboundView2, org.owntracks.android.support.widgets.BindingConversions.convertToString(vmEndpointMessageJavaLangObjectNullMboundView2AndroidStringNaVmEndpointMessage));
        }
        if ((dirtyFlags & 0x109L) != 0) {
            // api target 1

            android.databinding.adapters.TextViewBindingAdapter.setText(this.mboundView3, org.owntracks.android.support.widgets.BindingConversions.convertToString(orgOwntracksAndroidSupportWidgetsBindingConversionsConvertToStringVmEndpointQueue));
        }
        if ((dirtyFlags & 0x111L) != 0) {
            // api target 1

            android.databinding.adapters.TextViewBindingAdapter.setText(this.mboundView4, org.owntracks.android.support.widgets.BindingConversions.convertToString(orgOwntracksAndroidSupportWidgetsBindingConversionsConvertToStringVmPermissionLocation));
        }
        if ((dirtyFlags & 0x121L) != 0) {
            // api target 1

            android.databinding.adapters.TextViewBindingAdapter.setText(this.mboundView5, org.owntracks.android.support.widgets.BindingConversions.convertToString(vmLocationUpdatedJavaLangObjectNullAppFormatDateVmLocationUpdatedMboundView5AndroidStringNa));
        }
        if ((dirtyFlags & 0x141L) != 0) {
            // api target 1

            android.databinding.adapters.TextViewBindingAdapter.setText(this.mboundView6, org.owntracks.android.support.widgets.BindingConversions.convertToString(vmAppStartedJavaLangObjectNullAppFormatDateVmAppStartedMboundView6AndroidStringNa));
        }
        if ((dirtyFlags & 0x181L) != 0) {
            // api target 1

            android.databinding.adapters.TextViewBindingAdapter.setText(this.mboundView7, org.owntracks.android.support.widgets.BindingConversions.convertToString(vmServiceStartedJavaLangObjectNullAppFormatDateVmServiceStartedMboundView7AndroidStringNa));
        }
    }
    // Listener Stub Implementations
    // callback impls
    // dirty flag
    private  long mDirtyFlags = 0xffffffffffffffffL;

    public static UiActivityStatusBinding inflate(android.view.LayoutInflater inflater, android.view.ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, android.databinding.DataBindingUtil.getDefaultComponent());
    }
    public static UiActivityStatusBinding inflate(android.view.LayoutInflater inflater, android.view.ViewGroup root, boolean attachToRoot, android.databinding.DataBindingComponent bindingComponent) {
        return android.databinding.DataBindingUtil.<UiActivityStatusBinding>inflate(inflater, org.owntracks.android.R.layout.ui_activity_status, root, attachToRoot, bindingComponent);
    }
    public static UiActivityStatusBinding inflate(android.view.LayoutInflater inflater) {
        return inflate(inflater, android.databinding.DataBindingUtil.getDefaultComponent());
    }
    public static UiActivityStatusBinding inflate(android.view.LayoutInflater inflater, android.databinding.DataBindingComponent bindingComponent) {
        return bind(inflater.inflate(org.owntracks.android.R.layout.ui_activity_status, null, false), bindingComponent);
    }
    public static UiActivityStatusBinding bind(android.view.View view) {
        return bind(view, android.databinding.DataBindingUtil.getDefaultComponent());
    }
    public static UiActivityStatusBinding bind(android.view.View view, android.databinding.DataBindingComponent bindingComponent) {
        if (!"layout/ui_activity_status_0".equals(view.getTag())) {
            throw new RuntimeException("view tag isn't correct on view:" + view.getTag());
        }
        return new UiActivityStatusBinding(bindingComponent, view);
    }
    /* flag mapping
        flag 0 (0x1L): vm
        flag 1 (0x2L): vm.endpointState
        flag 2 (0x3L): vm.endpointMessage
        flag 3 (0x4L): vm.endpointQueue
        flag 4 (0x5L): vm.permissionLocation
        flag 5 (0x6L): vm.locationUpdated
        flag 6 (0x7L): vm.appStarted
        flag 7 (0x8L): vm.serviceStarted
        flag 8 (0x9L): null
        flag 9 (0xaL): vm.appStarted != null ? App.formatDate(vm.appStarted) : @android:string/na
        flag 10 (0xbL): vm.appStarted != null ? App.formatDate(vm.appStarted) : @android:string/na
        flag 11 (0xcL): vm.locationUpdated != null ? App.formatDate(vm.locationUpdated) : @android:string/na
        flag 12 (0xdL): vm.locationUpdated != null ? App.formatDate(vm.locationUpdated) : @android:string/na
        flag 13 (0xeL): vm.endpointMessage == null ? @android:string/na : vm.endpointMessage
        flag 14 (0xfL): vm.endpointMessage == null ? @android:string/na : vm.endpointMessage
        flag 15 (0x10L): vm.serviceStarted != null ? App.formatDate(vm.serviceStarted) : @android:string/na
        flag 16 (0x11L): vm.serviceStarted != null ? App.formatDate(vm.serviceStarted) : @android:string/na
    flag mapping end*/
    //end
}