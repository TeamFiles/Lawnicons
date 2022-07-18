package app.lawnchair.lawnicons.screens.home;

import android.content.Context;
import android.content.res.Configuration;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.widget.ImageView;

import androidx.core.content.ContextCompat;
import androidx.core.graphics.drawable.DrawableCompat;

import java.lang.reflect.Field;
import java.util.ArrayList;

import app.lawnchair.lawnicons.R;

public class Icon {
    private String name;
    private Drawable icon;

    public Icon(Drawable icon) { this.icon = icon; }

    public Icon(String name, Drawable icon) {
        this.name = name;
        this.icon = icon;
    }

    public String getName() {
        return name;
    }

    public Drawable getIcon() { return icon; }

    public static void setDrawableColor(ImageView icon, Context context) {
        DrawableCompat.setTint(icon.getDrawable(), ContextCompat.getColor(context.getApplicationContext(), R.color.app_icon_color));
    }
}
