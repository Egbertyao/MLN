package com.immomo.mls.fun.ui;

import com.immomo.mls.base.ud.lv.ILView;
import com.immomo.mls.fun.ud.view.UDView;

import androidx.viewpager.widget.ViewPager;

/**
 * Created by XiongFangyu on 2018/9/27.
 */

public interface IViewPager<V extends UDView> extends ILView<V> {
    ViewPager getViewPager();

    boolean isAutoScroll();

    void setAutoScroll(boolean autoScroll);

    boolean isRepeat();

    void setRepeat(boolean repeat);

    float getFrameInterval();

    void setFrameInterval(float frameInterval);

    void setPageIndicator(PageIndicator pageIndicator);

    PageIndicator getPageIndicator();

    void addCallback(Callback c);

    void removeCallback(Callback c);

    public interface Callback {
        void callbackEndDrag(int p);
        void callbackStartDrag(int p);
    }
}
