// Generated by dagger.internal.codegen.ComponentProcessor (https://google.github.io/dagger).
package org.owntracks.android.ui.load;

import dagger.MembersInjector;
import javax.inject.Provider;
import org.owntracks.android.ui.base.navigator.Navigator;

public final class LoadViewModel_MembersInjector implements MembersInjector<LoadViewModel> {
  private final Provider<Navigator> navigatorProvider;

  public LoadViewModel_MembersInjector(Provider<Navigator> navigatorProvider) {
    assert navigatorProvider != null;
    this.navigatorProvider = navigatorProvider;
  }

  public static MembersInjector<LoadViewModel> create(Provider<Navigator> navigatorProvider) {
    return new LoadViewModel_MembersInjector(navigatorProvider);
  }

  @Override
  public void injectMembers(LoadViewModel instance) {
    if (instance == null) {
      throw new NullPointerException("Cannot inject members into a null reference");
    }
    org.owntracks.android.ui.base.viewmodel.BaseViewModel_MembersInjector.injectNavigator(
        instance, navigatorProvider);
  }
}
