package app.lawnchair.lawnicons.screens.home;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;

import androidx.core.content.ContextCompat;
import androidx.core.graphics.drawable.DrawableCompat;

import app.lawnchair.lawnicons.R;

public class Icon {
    private String name;
    private Drawable icon;
    private boolean requestBtn = false;

    public Icon(String name, Drawable icon) {
        this.name = name;
        this.icon = icon;
    }

    public Icon(String name, Drawable icon, boolean requestBtn) {
        this.name = name;
        this.icon = icon;
        this.requestBtn = requestBtn;
    }

    public String getName() {
        return name;
    }

    public Drawable getIcon() { return icon; }

    public boolean isRequestBtn() {
        return requestBtn;
    }
}
