// Generated by dagger.internal.codegen.ComponentProcessor (https://google.github.io/dagger).
package org.owntracks.android.data.repos;

import dagger.internal.Factory;

public enum MemoryContactsRepo_Factory implements Factory<MemoryContactsRepo> {
  INSTANCE;

  @Override
  public MemoryContactsRepo get() {
    return new MemoryContactsRepo();
  }

  public static Factory<MemoryContactsRepo> create() {
    return INSTANCE;
  }
}