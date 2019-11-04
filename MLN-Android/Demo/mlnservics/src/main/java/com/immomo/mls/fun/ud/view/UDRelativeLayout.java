package com.immomo.mls.fun.ud.view;

import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

import com.immomo.mls.MLSConfigs;
import com.immomo.mls.fun.ui.LuaRelativeLayout;
import com.immomo.mls.util.LuaViewUtil;

import org.luaj.vm2.Globals;
import org.luaj.vm2.LuaValue;
import org.luaj.vm2.utils.LuaApiUsed;


@LuaApiUsed
public class UDRelativeLayout extends UDViewGroup<LuaRelativeLayout> {
    public static final String LUA_CLASS_NAME = "RelativeLayout";
    public static final String[] methods = {
            "left",
            "top",
            "right",
            "bottom",
            "alignParentTop",
            "alignParentBottom",
            "alignParentLeft",
            "alignParentRight",
    };

    @LuaApiUsed
    protected UDRelativeLayout(long L, LuaValue[] v) {
        super(L, v);
    }

    public UDRelativeLayout(Globals g, LuaRelativeLayout jud) {
        super(g, jud);
    }

    @Override
    protected LuaRelativeLayout newView(LuaValue[] init) {
        return new LuaRelativeLayout(getContext(), this);
    }

    @Override
    protected boolean clipToPadding() {
        return MLSConfigs.defaultClipContainer;
    }

    @Override
    protected boolean clipChildren() {
        return MLSConfigs.defaultClipContainer;
    }

    //<editor-fold desc="not support method">

    @LuaApiUsed
    public LuaValue[] left(LuaValue[] p) {
        UDView sourceUDView = (UDView) p[0], relativeUDView = (UDView) p[1];
        getView().leftTopRightBottom(relativeUDView, sourceUDView, RelativeLayout.RIGHT_OF);
        return null;
    }

    @LuaApiUsed
    public LuaValue[] top(LuaValue[] p) {
        UDView sourceUDView = (UDView) p[0], relativeUDView = (UDView) p[1];
        getView().leftTopRightBottom(relativeUDView, sourceUDView, RelativeLayout.BELOW);
        return null;
    }

    @LuaApiUsed
    public LuaValue[] right(LuaValue[] p) {
        UDView sourceUDView = (UDView) p[0], relativeUDView = (UDView) p[1];
        getView().leftTopRightBottom(sourceUDView, relativeUDView, RelativeLayout.RIGHT_OF);
        return null;
    }

    @LuaApiUsed
    public LuaValue[] bottom(LuaValue[] p) {
        UDView sourceUDView = (UDView) p[0], relativeUDView = (UDView) p[1];
        getView().leftTopRightBottom(sourceUDView, relativeUDView, RelativeLayout.BELOW);
        return null;
    }

    @LuaApiUsed
    public LuaValue[] alignParentTop(LuaValue[] p) {
        UDView sourceUDView = (UDView) p[0];
        getView().alignParentDependsRules(sourceUDView, RelativeLayout.ALIGN_PARENT_TOP);
        return null;
    }

    @LuaApiUsed
    public LuaValue[] alignParentBottom(LuaValue[] p) {
        UDView sourceUDView = (UDView) p[0];
        getView().alignParentDependsRules(sourceUDView, RelativeLayout.ALIGN_PARENT_BOTTOM);
        return null;
    }

    @LuaApiUsed
    public LuaValue[] alignParentLeft(LuaValue[] p) {
        UDView sourceUDView = (UDView) p[0];
        getView().alignParentDependsRules(sourceUDView, RelativeLayout.ALIGN_PARENT_LEFT);
        return null;
    }

    @LuaApiUsed
    public LuaValue[] alignParentRight(LuaValue[] p) {
        UDView sourceUDView = (UDView) p[0];
        getView().alignParentDependsRules(sourceUDView, RelativeLayout.ALIGN_PARENT_RIGHT);
        return null;
    }
    //</editor-fold>


    //<editor-fold desc="API">
    @Override
    public void insertView(UDView view, int index) {
        LuaRelativeLayout v = getView();
        if (v == null)
            return;
        View sub = view.getView();
        if (sub == null)
            return;
        ViewGroup.LayoutParams layoutParams = sub.getLayoutParams();
        layoutParams = v.applyLayoutParams(layoutParams,
                view.udLayoutParams);

        if (index > getView().getChildCount()) {
            index = -1;//index越界时，View放在末尾
        }

        v.addView(LuaViewUtil.removeFromParent(sub), index, layoutParams);
    }
    //</editor-fold>
}
