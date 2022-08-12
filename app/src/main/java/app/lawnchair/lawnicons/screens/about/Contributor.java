package app.lawnchair.lawnicons.screens.about;

import android.graphics.drawable.Drawable;

public class Contributor {

    private String name;
    private String role;
    private Drawable avatar;
    private boolean last;

    public Contributor(String name, String role, Drawable avatar) {
        this.name = name;
        this.role = role;
        this.avatar = avatar;
    }

    public Contributor(String name, Drawable avatar, boolean last) {
        this.name = name;
        if(this.role==null)
            role = "Icon Artist";
        this.avatar = avatar;
        this.last = last;
    }

    public String getName() {
        return name;
    }

    public String getRole() {
        return role;
    }

    public Drawable getAvatar() {
        return avatar;
    }

    public boolean isLast() {
        return last;
    }
}