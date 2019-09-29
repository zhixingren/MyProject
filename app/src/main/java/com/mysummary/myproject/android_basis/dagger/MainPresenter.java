package com.mysummary.myproject.android_basis.dagger;

import javax.inject.Inject;

import dagger.Component;
import dagger.Module;
import dagger.Provides;

/**
 * Created by xingzhi on 2019-09-25.
 */
class MainPresenter {

    private MainContract.View mView;

    @Inject
    MainPresenter(MainContract.View view) {
        mView = view;
    }

    void loadData() {
        mView.updateUI();
    }

    @Module
    static class MainModule {

        private MainContract.View mView;

        MainModule(MainContract.View view) {
            mView = view;
        }

        @Provides
        MainContract.View provideMainView() {
            return mView;
        }

    }


    @Component(modules = MainModule.class)
    public interface MainComponent {
        void inject(DaggerActivity activity);
    }

}
