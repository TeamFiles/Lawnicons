package app.lawnchair.lawnicons;

import android.content.Context;

import androidx.core.content.res.ResourcesCompat;

import java.lang.reflect.Field;
import java.util.ArrayList;

import app.lawnchair.lawnicons.screens.about.Contributor;
import app.lawnchair.lawnicons.screens.home.Icon;

public class Data {

    private static Context context;

    public static void setContext(Context context) {
        Data.context = context;
    }

    public static ArrayList<Contributor> contributors () {
        ArrayList<Contributor> contributors = new ArrayList<>();
        contributors.add(new Contributor("Rufus IR", "Lawnicons by TeamFiles Project Leader", ResourcesCompat.getDrawable((context.getResources()), R.drawable.avatar_rufus, null)));
        contributors.add(new Contributor("pranshoe.", "Lawnicons by TeamFiles Project Co-leader", ResourcesCompat.getDrawable(context.getResources(), R.drawable.avatar_pranshoe, null)));
        contributors.add(new Contributor("Looper", "Lawnicons by TeamFiles Project Co-leader", ResourcesCompat.getDrawable(context.getResources(), R.drawable.avatar_looper, null)));
        contributors.add(new Contributor("Sauron", "Logo Designer", ResourcesCompat.getDrawable(context.getResources(), R.drawable.avatar_sauron, null)));
        contributors.add(new Contributor("Saitama", "TeamFiles Founder", ResourcesCompat.getDrawable(context.getResources(), R.drawable.avatar_saitama, null)));
        contributors.add(new Contributor("Arnav Puranik", "Core Team", ResourcesCompat.getDrawable(context.getResources(), R.drawable.avatar_arnav, null)));
        contributors.add(new Contributor("nah", ResourcesCompat.getDrawable((context.getResources()), R.drawable.avatar_nah, null)));
        contributors.add(new Contributor("Nino", ResourcesCompat.getDrawable((context.getResources()), R.drawable.avatar_nino, null)));
        contributors.add(new Contributor("PaperGreg", ResourcesCompat.getDrawable((context.getResources()), R.drawable.avatar_papergreg, null)));
        contributors.add(new Contributor("NeFeroN", ResourcesCompat.getDrawable((context.getResources()), R.drawable.avatar_neferon, null)));
        contributors.add(new Contributor("RedSkulxHYDRA", ResourcesCompat.getDrawable((context.getResources()), R.drawable.avatar_redskul, null)));
        contributors.add(new Contributor("Sepehr", ResourcesCompat.getDrawable((context.getResources()), R.drawable.avatar_sepehr, null)));
        contributors.add(new Contributor("Jorge da Silva", ResourcesCompat.getDrawable((context.getResources()), R.drawable.avatar_jorge, null)));
        contributors.add(new Contributor("Abdul Aziz Shakib", ResourcesCompat.getDrawable((context.getResources()), R.drawable.avatar_shakib, null)));
        return contributors;
    }

    public static ArrayList<Icon> latestIcons() {
        ArrayList<Icon> icons = new ArrayList<>();
        icons.add(new Icon("No kangs", ResourcesCompat.getDrawable(context.getResources(), R.drawable.no_kangs, null)));
        return icons;
    }

    public static ArrayList<Icon> allIcons() {
        Field[] drawablesFields = R.drawable.class.getFields();
        ArrayList<Icon> themedIcons = new ArrayList<>();

        for (Field themedIcon : drawablesFields) {
            try {
                if (themedIcon.getName().contains("themed_icon") && !themedIcon.getName().contains("themed_icon_calendar")) {
                    themedIcons.add(new Icon(context.getDrawable(themedIcon.getInt(null))));
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return themedIcons;
    }

}
