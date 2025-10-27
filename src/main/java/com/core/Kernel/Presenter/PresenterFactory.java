package com.core.Kernel.Presenter;

import java.util.HashMap;

public abstract class PresenterFactory {
    private final HashMap<PresenterEnum, Presenter<?>> presenters;

    protected PresenterFactory(HashMap<PresenterEnum, Presenter<?>> presenters){
        this.presenters = presenters;
    }

    public Presenter<?> selectPresenter(PresenterEnum presenter){
        return this.presenters.get(presenter);
    }
}
