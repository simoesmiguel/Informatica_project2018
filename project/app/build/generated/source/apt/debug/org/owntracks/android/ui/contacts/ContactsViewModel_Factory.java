// Generated by dagger.internal.codegen.ComponentProcessor (https://google.github.io/dagger).
package org.owntracks.android.ui.contacts;

import android.content.Context;
import dagger.MembersInjector;
import dagger.internal.Factory;
import dagger.internal.MembersInjectors;
import javax.inject.Provider;
import org.owntracks.android.data.repos.ContactsRepo;

public final class ContactsViewModel_Factory implements Factory<ContactsViewModel> {
  private final MembersInjector<ContactsViewModel> contactsViewModelMembersInjector;

  private final Provider<Context> contextProvider;

  private final Provider<ContactsRepo> contactsRepoProvider;

  public ContactsViewModel_Factory(
      MembersInjector<ContactsViewModel> contactsViewModelMembersInjector,
      Provider<Context> contextProvider,
      Provider<ContactsRepo> contactsRepoProvider) {
    assert contactsViewModelMembersInjector != null;
    this.contactsViewModelMembersInjector = contactsViewModelMembersInjector;
    assert contextProvider != null;
    this.contextProvider = contextProvider;
    assert contactsRepoProvider != null;
    this.contactsRepoProvider = contactsRepoProvider;
  }

  @Override
  public ContactsViewModel get() {
    return MembersInjectors.injectMembers(
        contactsViewModelMembersInjector,
        new ContactsViewModel(contextProvider.get(), contactsRepoProvider.get()));
  }

  public static Factory<ContactsViewModel> create(
      MembersInjector<ContactsViewModel> contactsViewModelMembersInjector,
      Provider<Context> contextProvider,
      Provider<ContactsRepo> contactsRepoProvider) {
    return new ContactsViewModel_Factory(
        contactsViewModelMembersInjector, contextProvider, contactsRepoProvider);
  }
}
