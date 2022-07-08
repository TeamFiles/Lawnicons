package app.lawnchair.lawnicons.screens.about;

import android.graphics.drawable.Drawable;

public class Contributor {

    private String name;
    private String role;
    private Drawable avatar;

    public Contributor(String name, String role, Drawable avatar) {
        this.name = name;
        this.role = role;
        this.avatar = avatar;
    }

    public Contributor(String name, Drawable avatar) {
        this.name = name;
        if(this.role==null)
            role = "Icon Artist";
        this.avatar = avatar;
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
}