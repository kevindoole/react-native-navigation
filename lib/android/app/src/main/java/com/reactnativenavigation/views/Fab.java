package com.reactnativenavigation.views;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;

import com.github.clans.fab.FloatingActionButton;
import com.reactnativenavigation.anim.FabAnimator;
import com.reactnativenavigation.anim.FabCollapseBehaviour;
import com.reactnativenavigation.interfaces.ScrollEventListener;
import com.reactnativenavigation.utils.ImageLoader;
import com.reactnativenavigation.utils.ImageLoadingListenerAdapter;

import java.util.Collections;
import java.util.List;


public class Fab extends FloatingActionButton implements FabAnimator {

    private String id = "";
    private FabCollapseBehaviour collapseBehaviour;

    public Fab(Context context, String id) {
        super(context);
        collapseBehaviour = new FabCollapseBehaviour(this);
        this.id = id;
    }

    public void applyIcon(String icon) {
        new ImageLoader().loadIcons(getContext(), Collections.singletonList(icon), new ImageLoadingListenerAdapter() {
            @Override
            public void onComplete(@NonNull List<Drawable> drawables) {
                setImageDrawable(drawables.get(0));
            }

            @Override
            public void onError(Throwable error) {
                error.printStackTrace();
            }
        });
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Fab fab = (Fab) o;

        return id.equals(fab.id);
    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }

    @Override
    public void show() {
        show(true);
    }

    @Override
    public void hide() {
        hide(true);
    }

    public void enableCollapse(@NonNull ScrollEventListener scrollEventListener) {
        collapseBehaviour.enableCollapse(scrollEventListener);
    }

    public void disableCollapse() {
        collapseBehaviour.disableCollapse();
    }

    public String getFabId() {
        return id;
    }
}
