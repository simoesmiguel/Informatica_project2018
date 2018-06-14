
package android.databinding;
import org.owntracks.android.BR;
class DataBinderMapper  {
    final static int TARGET_MIN_SDK = 25;
    public DataBinderMapper() {
    }
    public android.databinding.ViewDataBinding getDataBinder(android.databinding.DataBindingComponent bindingComponent, android.view.View view, int layoutId) {
        switch(layoutId) {
                case org.owntracks.android.R.layout.ui_activity_configuration:
                    return org.owntracks.android.databinding.UiActivityConfigurationBinding.bind(view, bindingComponent);
                case org.owntracks.android.R.layout.activity_region:
                    return org.owntracks.android.databinding.ActivityRegionBinding.bind(view, bindingComponent);
                case org.owntracks.android.R.layout.ui_activity_status:
                    return org.owntracks.android.databinding.UiActivityStatusBinding.bind(view, bindingComponent);
                case org.owntracks.android.R.layout.ui_activity_contacts:
                    return org.owntracks.android.databinding.UiActivityContactsBinding.bind(view, bindingComponent);
                case org.owntracks.android.R.layout.ui_activity_load:
                    return org.owntracks.android.databinding.UiActivityLoadBinding.bind(view, bindingComponent);
                case org.owntracks.android.R.layout.ui_row_contact:
                    return org.owntracks.android.databinding.UiRowContactBinding.bind(view, bindingComponent);
                case org.owntracks.android.R.layout.ui_activity_map:
                    return org.owntracks.android.databinding.UiActivityMapBinding.bind(view, bindingComponent);
        }
        return null;
    }
    android.databinding.ViewDataBinding getDataBinder(android.databinding.DataBindingComponent bindingComponent, android.view.View[] views, int layoutId) {
        switch(layoutId) {
        }
        return null;
    }
    int getLayoutId(String tag) {
        if (tag == null) {
            return 0;
        }
        final int code = tag.hashCode();
        switch(code) {
            case -272495651: {
                if(tag.equals("layout/ui_activity_configuration_0")) {
                    return org.owntracks.android.R.layout.ui_activity_configuration;
                }
                break;
            }
            case -1477358288: {
                if(tag.equals("layout/activity_region_0")) {
                    return org.owntracks.android.R.layout.activity_region;
                }
                break;
            }
            case 2049144621: {
                if(tag.equals("layout/ui_activity_status_0")) {
                    return org.owntracks.android.R.layout.ui_activity_status;
                }
                break;
            }
            case 2024577230: {
                if(tag.equals("layout/ui_activity_contacts_0")) {
                    return org.owntracks.android.R.layout.ui_activity_contacts;
                }
                break;
            }
            case -578324063: {
                if(tag.equals("layout/ui_activity_load_0")) {
                    return org.owntracks.android.R.layout.ui_activity_load;
                }
                break;
            }
            case -1633787514: {
                if(tag.equals("layout/ui_row_contact_0")) {
                    return org.owntracks.android.R.layout.ui_row_contact;
                }
                break;
            }
            case -572324285: {
                if(tag.equals("layout/ui_activity_map_0")) {
                    return org.owntracks.android.R.layout.ui_activity_map;
                }
                break;
            }
        }
        return 0;
    }
    String convertBrIdToString(int id) {
        if (id < 0 || id >= InnerBrLookup.sKeys.length) {
            return null;
        }
        return InnerBrLookup.sKeys[id];
    }
    private static class InnerBrLookup {
        static String[] sKeys = new String[]{
            "_all"
            ,"appStarted"
            ,"configurationPretty"
            ,"contact"
            ,"effectiveConfiguration"
            ,"endpointMessage"
            ,"endpointQueue"
            ,"endpointState"
            ,"fusedLocationAccuracy"
            ,"fusedLocationDate"
            ,"fusedName"
            ,"id"
            ,"imageProvider"
            ,"item"
            ,"locationUpdated"
            ,"messageCard"
            ,"messageLocation"
            ,"name"
            ,"permissionLocation"
            ,"serviceStarted"
            ,"trackerId"
            ,"vm"};
    }
}