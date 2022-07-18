package app.lawnchair.lawnicons;

import android.content.Context;

import androidx.core.content.res.ResourcesCompat;

import java.util.ArrayList;

import app.lawnchair.lawnicons.screens.about.Contributor;
import app.lawnchair.lawnicons.screens.home.Icon;

public class Data extends Thread {

    private static Context context;
    private static ArrayList<Contributor> contributors = new ArrayList<>();
    private static ArrayList<Icon> latestIcons = new ArrayList<>();
    private static boolean loadedFlag = false;

    public static void setContext(Context context) {
        Data.context = context;
    }

    private static void loadContributors () {
        contributors.add(new Contributor("Rufus IR", "Lawnicons by TeamFiles Project Leader", ResourcesCompat.getDrawable((context.getResources()), R.drawable.avatar_rufus, null)));
        contributors.add(new Contributor("pranshoe.", "Lawnicons by TeamFiles Project Co-leader", ResourcesCompat.getDrawable(context.getResources(), R.drawable.avatar_pranshoe, null)));
        contributors.add(new Contributor("Looper", "Lawnicons by TeamFiles Project Co-leader", ResourcesCompat.getDrawable(context.getResources(), R.drawable.avatar_looper, null)));
        contributors.add(new Contributor("Sauron", "Logo Designer", ResourcesCompat.getDrawable(context.getResources(), R.drawable.avatar_sauron, null)));
        contributors.add(new Contributor("Gori", "Backend Developer", ResourcesCompat.getDrawable(context.getResources(), R.drawable.avatar_gori, null)));
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
    }

    public static ArrayList<Contributor> getContributors() {
        return contributors;
    }

    private static void loadLatestIcons() {
        latestIcons.add(new Icon("No kangs", ResourcesCompat.getDrawable(context.getResources(), R.drawable.no_kangs, null)));
    }

    public static ArrayList<Icon> getLatestIcons() {
        return latestIcons;
    }

    @Override
    public void run() {
        super.run();
        if (!loadedFlag) {
            loadContributors();
            loadLatestIcons();
            loadedFlag = true;
        }
    }
}
