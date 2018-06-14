// Generated by dagger.internal.codegen.ComponentProcessor (https://google.github.io/dagger).
package org.owntracks.android.injection.modules;

import android.support.v4.app.FragmentManager;
import dagger.internal.Factory;
import dagger.internal.Preconditions;

public final class ActivityModule_ProvideFragmentManagerFactory
    implements Factory<FragmentManager> {
  private final ActivityModule module;

  public ActivityModule_ProvideFragmentManagerFactory(ActivityModule module) {
    assert module != null;
    this.module = module;
  }

  @Override
  public FragmentManager get() {
    return Preconditions.checkNotNull(
        module.provideFragmentManager(),
        "Cannot return null from a non-@Nullable @Provides method");
  }

  public static Factory<FragmentManager> create(ActivityModule module) {
    return new ActivityModule_ProvideFragmentManagerFactory(module);
  }
}
