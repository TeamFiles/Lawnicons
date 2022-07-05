package app.lawnchair.lawnicons.screens.home;

import android.graphics.drawable.Drawable;

public class LatestIcon {
    private String name;
    private Drawable icon;

    public LatestIcon(String name, Drawable icon) {
        this.name = name;
        this.icon = icon;
    }

    public String getName() {
        return name;
    }

    public Drawable getIcon() { return icon; }
}
