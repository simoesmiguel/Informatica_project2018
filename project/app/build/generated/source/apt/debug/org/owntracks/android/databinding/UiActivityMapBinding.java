package org.owntracks.android.databinding;
import org.owntracks.android.R;
import org.owntracks.android.BR;
import android.view.View;
public class UiActivityMapBinding extends android.databinding.ViewDataBinding  {

    private static final android.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = new android.databinding.ViewDataBinding.IncludedLayouts(15);
        sIncludes.setIncludes(1, 
            new String[] {"ui_row_contact"},
            new int[] {6},
            new int[] {R.layout.ui_row_contact});
        sViewsWithIds = new android.util.SparseIntArray();
        sViewsWithIds.put(R.id.appBarLayout, 7);
        sViewsWithIds.put(R.id.toolbar, 8);
        sViewsWithIds.put(R.id.mapView, 9);
        sViewsWithIds.put(R.id.locationDateLabel, 10);
        sViewsWithIds.put(R.id.accLabel, 11);
        sViewsWithIds.put(R.id.tidLabel, 12);
        sViewsWithIds.put(R.id.topicLabel, 13);
        sViewsWithIds.put(R.id.moreButton, 14);
    }
    // views
    public final android.widget.TextView acc;
    public final android.widget.TextView accLabel;
    public final android.support.design.widget.AppBarLayout appBarLayout;
    public final android.widget.LinearLayout bottomSheetLayout;
    public final org.owntracks.android.databinding.UiRowContactBinding contactPeek;
    public final android.support.design.widget.CoordinatorLayout coordinatorLayout;
    public final android.widget.TextView id;
    public final android.widget.TextView locationDate;
    public final android.widget.TextView locationDateLabel;
    public final com.google.android.gms.maps.MapView mapView;
    public final android.widget.ImageView moreButton;
    public final android.widget.TextView tid;
    public final android.widget.TextView tidLabel;
    public final android.support.v7.widget.Toolbar toolbar;
    public final android.widget.TextView topicLabel;
    // variables
    private org.owntracks.android.ui.map.MapViewModel mVm;
    // values
    // listeners
    // Inverse Binding Event Handlers

    public UiActivityMapBinding(android.databinding.DataBindingComponent bindingComponent, View root) {
        super(bindingComponent, root, 3);
        final Object[] bindings = mapBindings(bindingComponent, root, 15, sIncludes, sViewsWithIds);
        this.acc = (android.widget.TextView) bindings[3];
        this.acc.setTag(null);
        this.accLabel = (android.widget.TextView) bindings[11];
        this.appBarLayout = (android.support.design.widget.AppBarLayout) bindings[7];
        this.bottomSheetLayout = (android.widget.LinearLayout) bindings[1];
        this.bottomSheetLayout.setTag(null);
        this.contactPeek = (org.owntracks.android.databinding.UiRowContactBinding) bindings[6];
        setContainedBinding(this.contactPeek);
        this.coordinatorLayout = (android.support.design.widget.CoordinatorLayout) bindings[0];
        this.coordinatorLayout.setTag(null);
        this.id = (android.widget.TextView) bindings[5];
        this.id.setTag(null);
        this.locationDate = (android.widget.TextView) bindings[2];
        this.locationDate.setTag(null);
        this.locationDateLabel = (android.widget.TextView) bindings[10];
        this.mapView = (com.google.android.gms.maps.MapView) bindings[9];
        this.moreButton = (android.widget.ImageView) bindings[14];
        this.tid = (android.widget.TextView) bindings[4];
        this.tid.setTag(null);
        this.tidLabel = (android.widget.TextView) bindings[12];
        this.toolbar = (android.support.v7.widget.Toolbar) bindings[8];
        this.topicLabel = (android.widget.TextView) bindings[13];
        setRootTag(root);
        // listeners
        invalidateAll();
    }

    @Override
    public void invalidateAll() {
        synchronized(this) {
                mDirtyFlags = 0x80L;
        }
        contactPeek.invalidateAll();
        requestRebind();
    }

    @Override
    public boolean hasPendingBindings() {
        synchronized(this) {
            if (mDirtyFlags != 0) {
                return true;
            }
        }
        if (contactPeek.hasPendingBindings()) {
            return true;
        }
        return false;
    }

    public boolean setVariable(int variableId, Object variable) {
        switch(variableId) {
            case BR.vm :
                setVm((org.owntracks.android.ui.map.MapViewModel) variable);
                return true;
        }
        return false;
    }

    public void setVm(org.owntracks.android.ui.map.MapViewModel Vm) {
        updateRegistration(0, Vm);
        this.mVm = Vm;
        synchronized(this) {
            mDirtyFlags |= 0x1L;
        }
        notifyPropertyChanged(BR.vm);
        super.requestRebind();
    }
    public org.owntracks.android.ui.map.MapViewModel getVm() {
        return mVm;
    }

    @Override
    protected boolean onFieldChange(int localFieldId, Object object, int fieldId) {
        switch (localFieldId) {
            case 0 :
                return onChangeVm((org.owntracks.android.ui.map.MapViewModel) object, fieldId);
            case 1 :
                return onChangeContactPeek((org.owntracks.android.databinding.UiRowContactBinding) object, fieldId);
            case 2 :
                return onChangeVmContact((org.owntracks.android.model.FusedContact) object, fieldId);
        }
        return false;
    }
    private boolean onChangeVm(org.owntracks.android.ui.map.MapViewModel Vm, int fieldId) {
        switch (fieldId) {
            case BR.contact: {
                synchronized(this) {
                        mDirtyFlags |= 0x4L;
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
    private boolean onChangeContactPeek(org.owntracks.android.databinding.UiRowContactBinding ContactPeek, int fieldId) {
        switch (fieldId) {
            case BR._all: {
                synchronized(this) {
                        mDirtyFlags |= 0x2L;
                }
                return true;
            }
        }
        return false;
    }
    private boolean onChangeVmContact(org.owntracks.android.model.FusedContact VmContact, int fieldId) {
        switch (fieldId) {
            case BR.fusedLocationDate: {
                synchronized(this) {
                        mDirtyFlags |= 0x8L;
                }
                return true;
            }
            case BR.fusedLocationAccuracy: {
                synchronized(this) {
                        mDirtyFlags |= 0x10L;
                }
                return true;
            }
            case BR.trackerId: {
                synchronized(this) {
                        mDirtyFlags |= 0x20L;
                }
                return true;
            }
            case BR.id: {
                synchronized(this) {
                        mDirtyFlags |= 0x40L;
                }
                return true;
            }
            case BR._all: {
                synchronized(this) {
                        mDirtyFlags |= 0x4L;
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
        org.owntracks.android.ui.map.MapViewModel vm = mVm;
        java.lang.String vmContactTrackerId = null;
        java.lang.String appFormatDateVmContactFusedLocationDate = null;
        long vmContactFusedLocationDate = 0L;
        org.owntracks.android.model.FusedContact vmContact = null;
        java.lang.String vmContactId = null;
        java.lang.String vmContactFusedLocationAccuracy = null;

        if ((dirtyFlags & 0xfdL) != 0) {



                if (vm != null) {
                    // read vm.contact
                    vmContact = vm.getContact();
                }
                updateRegistration(2, vmContact);

            if ((dirtyFlags & 0xa5L) != 0) {

                    if (vmContact != null) {
                        // read vm.contact.trackerId
                        vmContactTrackerId = vmContact.getTrackerId();
                    }
            }
            if ((dirtyFlags & 0x8dL) != 0) {

                    if (vmContact != null) {
                        // read vm.contact.fusedLocationDate
                        vmContactFusedLocationDate = vmContact.getFusedLocationDate();
                    }


                    // read App.formatDate(vm.contact.fusedLocationDate)
                    appFormatDateVmContactFusedLocationDate = org.owntracks.android.App.formatDate(vmContactFusedLocationDate);
            }
            if ((dirtyFlags & 0xc5L) != 0) {

                    if (vmContact != null) {
                        // read vm.contact.id
                        vmContactId = vmContact.getId();
                    }
            }
            if ((dirtyFlags & 0x95L) != 0) {

                    if (vmContact != null) {
                        // read vm.contact.fusedLocationAccuracy
                        vmContactFusedLocationAccuracy = vmContact.getFusedLocationAccuracy();
                    }
            }
        }
        // batch finished
        if ((dirtyFlags & 0x95L) != 0) {
            // api target 1

            android.databinding.adapters.TextViewBindingAdapter.setText(this.acc, org.owntracks.android.support.widgets.BindingConversions.convertToString(vmContactFusedLocationAccuracy));
        }
        if ((dirtyFlags & 0x85L) != 0) {
            // api target 1

            this.contactPeek.setContact(vmContact);
        }
        if ((dirtyFlags & 0xc5L) != 0) {
            // api target 1

            android.databinding.adapters.TextViewBindingAdapter.setText(this.id, org.owntracks.android.support.widgets.BindingConversions.convertToString(vmContactId));
        }
        if ((dirtyFlags & 0x8dL) != 0) {
            // api target 1

            android.databinding.adapters.TextViewBindingAdapter.setText(this.locationDate, org.owntracks.android.support.widgets.BindingConversions.convertToString(appFormatDateVmContactFusedLocationDate));
        }
        if ((dirtyFlags & 0xa5L) != 0) {
            // api target 1

            android.databinding.adapters.TextViewBindingAdapter.setText(this.tid, org.owntracks.android.support.widgets.BindingConversions.convertToString(vmContactTrackerId));
        }
        executeBindingsOn(contactPeek);
    }
    // Listener Stub Implementations
    // callback impls
    // dirty flag
    private  long mDirtyFlags = 0xffffffffffffffffL;

    public static UiActivityMapBinding inflate(android.view.LayoutInflater inflater, android.view.ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, android.databinding.DataBindingUtil.getDefaultComponent());
    }
    public static UiActivityMapBinding inflate(android.view.LayoutInflater inflater, android.view.ViewGroup root, boolean attachToRoot, android.databinding.DataBindingComponent bindingComponent) {
        return android.databinding.DataBindingUtil.<UiActivityMapBinding>inflate(inflater, org.owntracks.android.R.layout.ui_activity_map, root, attachToRoot, bindingComponent);
    }
    public static UiActivityMapBinding inflate(android.view.LayoutInflater inflater) {
        return inflate(inflater, android.databinding.DataBindingUtil.getDefaultComponent());
    }
    public static UiActivityMapBinding inflate(android.view.LayoutInflater inflater, android.databinding.DataBindingComponent bindingComponent) {
        return bind(inflater.inflate(org.owntracks.android.R.layout.ui_activity_map, null, false), bindingComponent);
    }
    public static UiActivityMapBinding bind(android.view.View view) {
        return bind(view, android.databinding.DataBindingUtil.getDefaultComponent());
    }
    public static UiActivityMapBinding bind(android.view.View view, android.databinding.DataBindingComponent bindingComponent) {
        if (!"layout/ui_activity_map_0".equals(view.getTag())) {
            throw new RuntimeException("view tag isn't correct on view:" + view.getTag());
        }
        return new UiActivityMapBinding(bindingComponent, view);
    }
    /* flag mapping
        flag 0 (0x1L): vm
        flag 1 (0x2L): contactPeek
        flag 2 (0x3L): vm.contact
        flag 3 (0x4L): vm.contact.fusedLocationDate
        flag 4 (0x5L): vm.contact.fusedLocationAccuracy
        flag 5 (0x6L): vm.contact.trackerId
        flag 6 (0x7L): vm.contact.id
        flag 7 (0x8L): null
    flag mapping end*/
    //end
}