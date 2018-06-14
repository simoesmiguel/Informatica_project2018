// Generated by dagger.internal.codegen.ComponentProcessor (https://google.github.io/dagger).
package org.owntracks.android.ui.configuration;

import dagger.MembersInjector;
import javax.inject.Provider;
import org.greenrobot.eventbus.EventBus;
import org.owntracks.android.ui.base.navigator.Navigator;

public final class ConfigurationActivity_MembersInjector
    implements MembersInjector<ConfigurationActivity> {
  private final Provider<ConfigurationMvvm.ViewModel> viewModelProvider;

  private final Provider<EventBus> eventBusProvider;

  private final Provider<Navigator> navigatorProvider;

  public ConfigurationActivity_MembersInjector(
      Provider<ConfigurationMvvm.ViewModel> viewModelProvider,
      Provider<EventBus> eventBusProvider,
      Provider<Navigator> navigatorProvider) {
    assert viewModelProvider != null;
    this.viewModelProvider = viewModelProvider;
    assert eventBusProvider != null;
    this.eventBusProvider = eventBusProvider;
    assert navigatorProvider != null;
    this.navigatorProvider = navigatorProvider;
  }

  public static MembersInjector<ConfigurationActivity> create(
      Provider<ConfigurationMvvm.ViewModel> viewModelProvider,
      Provider<EventBus> eventBusProvider,
      Provider<Navigator> navigatorProvider) {
    return new ConfigurationActivity_MembersInjector(
        viewModelProvider, eventBusProvider, navigatorProvider);
  }

  @Override
  public void injectMembers(ConfigurationActivity instance) {
    if (instance == null) {
      throw new NullPointerException("Cannot inject members into a null reference");
    }
    org.owntracks.android.ui.base.BaseActivity_MembersInjector.injectViewModel(
        instance, viewModelProvider);
    org.owntracks.android.ui.base.BaseActivity_MembersInjector.injectEventBus(
        instance, eventBusProvider);
    org.owntracks.android.ui.base.BaseActivity_MembersInjector.injectNavigator(
        instance, navigatorProvider);
  }
}
