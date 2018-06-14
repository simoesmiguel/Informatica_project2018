package org.owntracks.android.databinding;
import org.owntracks.android.R;
import org.owntracks.android.BR;
import android.view.View;
public class UiRowContactBinding extends android.databinding.ViewDataBinding  {

    private static final android.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = null;
        sViewsWithIds = new android.util.SparseIntArray();
        sViewsWithIds.put(R.id.textview_container, 4);
    }
    // views
    public final android.widget.RelativeLayout contactRow;
    public final android.widget.ImageView image;
    public final android.widget.TextView location;
    public final android.widget.TextView name;
    public final android.widget.LinearLayout textviewContainer;
    // variables
    private org.owntracks.android.model.FusedContact mContact;
    // values
    // listeners
    // Inverse Binding Event Handlers

    public UiRowContactBinding(android.databinding.DataBindingComponent bindingComponent, View root) {
        super(bindingComponent, root, 2);
        final Object[] bindings = mapBindings(bindingComponent, root, 5, sIncludes, sViewsWithIds);
        this.contactRow = (android.widget.RelativeLayout) bindings[0];
        this.contactRow.setTag(null);
        this.image = (android.widget.ImageView) bindings[1];
        this.image.setTag(null);
        this.location = (android.widget.TextView) bindings[3];
        this.location.setTag(null);
        this.name = (android.widget.TextView) bindings[2];
        this.name.setTag(null);
        this.textviewContainer = (android.widget.LinearLayout) bindings[4];
        setRootTag(root);
        // listeners
        invalidateAll();
    }

    @Override
    public void invalidateAll() {
        synchronized(this) {
                mDirtyFlags = 0x10L;
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
            case BR.contact :
                setContact((org.owntracks.android.model.FusedContact) variable);
                return true;
        }
        return false;
    }

    public void setContact(org.owntracks.android.model.FusedContact Contact) {
        updateRegistration(0, Contact);
        this.mContact = Contact;
        synchronized(this) {
            mDirtyFlags |= 0x1L;
        }
        notifyPropertyChanged(BR.contact);
        super.requestRebind();
    }
    public org.owntracks.android.model.FusedContact getContact() {
        return mContact;
    }

    @Override
    protected boolean onFieldChange(int localFieldId, Object object, int fieldId) {
        switch (localFieldId) {
            case 0 :
                return onChangeContact((org.owntracks.android.model.FusedContact) object, fieldId);
            case 1 :
                return onChangeContactMessageLocation((org.owntracks.android.messages.MessageLocation) object, fieldId);
        }
        return false;
    }
    private boolean onChangeContact(org.owntracks.android.model.FusedContact Contact, int fieldId) {
        switch (fieldId) {
            case BR.imageProvider: {
                synchronized(this) {
                        mDirtyFlags |= 0x4L;
                }
                return true;
            }
            case BR.fusedName: {
                synchronized(this) {
                        mDirtyFlags |= 0x8L;
                }
                return true;
            }
            case BR.messageLocation: {
                synchronized(this) {
                        mDirtyFlags |= 0x2L;
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
    private boolean onChangeContactMessageLocation(org.owntracks.android.messages.MessageLocation ContactMessageLocation, int fieldId) {
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

    @Override
    protected void executeBindings() {
        long dirtyFlags = 0;
        synchronized(this) {
            dirtyFlags = mDirtyFlags;
            mDirtyFlags = 0;
        }
        org.owntracks.android.model.FusedContact contact = mContact;
        java.lang.Integer contactImageProvider = null;
        org.owntracks.android.messages.MessageLocation contactMessageLocation = null;
        java.lang.String contactFusedName = null;

        if ((dirtyFlags & 0x1fL) != 0) {


            if ((dirtyFlags & 0x15L) != 0) {

                    if (contact != null) {
                        // read contact.imageProvider
                        contactImageProvider = contact.getImageProvider();
                    }
            }
            if ((dirtyFlags & 0x13L) != 0) {

                    if (contact != null) {
                        // read contact.messageLocation
                        contactMessageLocation = contact.getMessageLocation();
                    }
                    updateRegistration(1, contactMessageLocation);
            }
            if ((dirtyFlags & 0x19L) != 0) {

                    if (contact != null) {
                        // read contact.fusedName
                        contactFusedName = contact.getFusedName();
                    }
            }
        }
        // batch finished
        if ((dirtyFlags & 0x15L) != 0) {
            // api target 1

            org.owntracks.android.model.FusedContact.displayFaceInViewAsync(this.image, contactImageProvider, contact);
        }
        if ((dirtyFlags & 0x13L) != 0) {
            // api target 1

            org.owntracks.android.model.FusedContact.displayFusedLocationInViewAsync(this.location, contact, contactMessageLocation);
        }
        if ((dirtyFlags & 0x19L) != 0) {
            // api target 1

            android.databinding.adapters.TextViewBindingAdapter.setText(this.name, org.owntracks.android.support.widgets.BindingConversions.convertToString(contactFusedName));
        }
    }
    // Listener Stub Implementations
    // callback impls
    // dirty flag
    private  long mDirtyFlags = 0xffffffffffffffffL;

    public static UiRowContactBinding inflate(android.view.LayoutInflater inflater, android.view.ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, android.databinding.DataBindingUtil.getDefaultComponent());
    }
    public static UiRowContactBinding inflate(android.view.LayoutInflater inflater, android.view.ViewGroup root, boolean attachToRoot, android.databinding.DataBindingComponent bindingComponent) {
        return android.databinding.DataBindingUtil.<UiRowContactBinding>inflate(inflater, org.owntracks.android.R.layout.ui_row_contact, root, attachToRoot, bindingComponent);
    }
    public static UiRowContactBinding inflate(android.view.LayoutInflater inflater) {
        return inflate(inflater, android.databinding.DataBindingUtil.getDefaultComponent());
    }
    public static UiRowContactBinding inflate(android.view.LayoutInflater inflater, android.databinding.DataBindingComponent bindingComponent) {
        return bind(inflater.inflate(org.owntracks.android.R.layout.ui_row_contact, null, false), bindingComponent);
    }
    public static UiRowContactBinding bind(android.view.View view) {
        return bind(view, android.databinding.DataBindingUtil.getDefaultComponent());
    }
    public static UiRowContactBinding bind(android.view.View view, android.databinding.DataBindingComponent bindingComponent) {
        if (!"layout/ui_row_contact_0".equals(view.getTag())) {
            throw new RuntimeException("view tag isn't correct on view:" + view.getTag());
        }
        return new UiRowContactBinding(bindingComponent, view);
    }
    /* flag mapping
        flag 0 (0x1L): contact
        flag 1 (0x2L): contact.messageLocation
        flag 2 (0x3L): contact.imageProvider
        flag 3 (0x4L): contact.fusedName
        flag 4 (0x5L): null
    flag mapping end*/
    //end
}