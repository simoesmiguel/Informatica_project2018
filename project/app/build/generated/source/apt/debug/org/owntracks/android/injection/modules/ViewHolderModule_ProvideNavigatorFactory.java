// Generated by dagger.internal.codegen.ComponentProcessor (https://google.github.io/dagger).
package org.owntracks.android.injection.modules;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import org.owntracks.android.ui.base.navigator.Navigator;

public final class ViewHolderModule_ProvideNavigatorFactory implements Factory<Navigator> {
  private final ViewHolderModule module;

  public ViewHolderModule_ProvideNavigatorFactory(ViewHolderModule module) {
    assert module != null;
    this.module = module;
  }

  @Override
  public Navigator get() {
    return Preconditions.checkNotNull(
        module.provideNavigator(), "Cannot return null from a non-@Nullable @Provides method");
  }

  public static Factory<Navigator> create(ViewHolderModule module) {
    return new ViewHolderModule_ProvideNavigatorFactory(module);
  }
}
