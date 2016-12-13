package ru.spbau.design.messenger;

import ru.spbau.design.messenger.view.IView;

public interface IMessenger {
    void updateViews();

    void addView(IView view);
}
