package app.lawnchair.lawnicons;

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
        this.role = role;
        this.avatar = avatar;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public Drawable getAvatar() {
        return avatar;
    }

    public void setAvatar(Drawable avatarURL) {
        this.avatar = avatarURL;
    }
}