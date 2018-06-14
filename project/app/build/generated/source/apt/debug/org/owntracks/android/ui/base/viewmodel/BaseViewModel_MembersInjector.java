// Generated by dagger.internal.codegen.ComponentProcessor (https://google.github.io/dagger).
package org.owntracks.android.ui.base.viewmodel;

import dagger.MembersInjector;
import javax.inject.Provider;
import org.owntracks.android.ui.base.navigator.Navigator;
import org.owntracks.android.ui.base.view.MvvmView;

public final class BaseViewModel_MembersInjector<V extends MvvmView>
    implements MembersInjector<BaseViewModel<V>> {
  private final Provider<Navigator> navigatorProvider;

  public BaseViewModel_MembersInjector(Provider<Navigator> navigatorProvider) {
    assert navigatorProvider != null;
    this.navigatorProvider = navigatorProvider;
  }

  public static <V extends MvvmView> MembersInjector<BaseViewModel<V>> create(
      Provider<Navigator> navigatorProvider) {
    return new BaseViewModel_MembersInjector<V>(navigatorProvider);
  }

  @Override
  public void injectMembers(BaseViewModel<V> instance) {
    if (instance == null) {
      throw new NullPointerException("Cannot inject members into a null reference");
    }
    instance.navigator = navigatorProvider;
  }

  public static <V extends MvvmView> void injectNavigator(
      BaseViewModel<V> instance, Provider<Navigator> navigator) {
    instance.navigator = navigator;
  }
}