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
        contributors.add(new Contributor("nah", ResourcesCompat.getDrawable((context.getResources()), R.drawable.avatar_nah, null), false));
        contributors.add(new Contributor("Nino", ResourcesCompat.getDrawable((context.getResources()), R.drawable.avatar_nino, null), false));
        contributors.add(new Contributor("PaperGreg", ResourcesCompat.getDrawable((context.getResources()), R.drawable.avatar_papergreg, null), false));
        contributors.add(new Contributor("NeFeroN", ResourcesCompat.getDrawable((context.getResources()), R.drawable.avatar_neferon, null), false));
        contributors.add(new Contributor("RedSkulxHYDRA", ResourcesCompat.getDrawable((context.getResources()), R.drawable.avatar_redskul, null), false));
        contributors.add(new Contributor("Sepehr", ResourcesCompat.getDrawable((context.getResources()), R.drawable.avatar_sepehr, null), false));
        contributors.add(new Contributor("Jorge da Silva", ResourcesCompat.getDrawable((context.getResources()), R.drawable.avatar_jorge, null), false));
        contributors.add(new Contributor("Abdul Aziz Shakib", ResourcesCompat.getDrawable((context.getResources()), R.drawable.avatar_shakib, null), true));
    }

    public static ArrayList<Contributor> getContributors() {
        return contributors;
    }

    private static void loadLatestIcons() {
        latestIcons.add(new Icon("Wise", ResourcesCompat.getDrawable(context.getResources(), R.drawable.themed_icon_wise, null)));
        latestIcons.add(new Icon("Relive", ResourcesCompat.getDrawable(context.getResources(), R.drawable.themed_icon_relive, null)));
        latestIcons.add(new Icon("HiBy Music", ResourcesCompat.getDrawable(context.getResources(), R.drawable.themed_icon_hiby_music, null)));
        latestIcons.add(new Icon("Mi Fitness", ResourcesCompat.getDrawable(context.getResources(), R.drawable.themed_icon_mi_fitness, null)));
        latestIcons.add(new Icon("HryFine", ResourcesCompat.getDrawable(context.getResources(), R.drawable.themed_icon_hryfine, null)));
        latestIcons.add(new Icon("M2wear", ResourcesCompat.getDrawable(context.getResources(), R.drawable.themed_icon_m2wear, null)));
        latestIcons.add(new Icon("M2 Wear", ResourcesCompat.getDrawable(context.getResources(), R.drawable.themed_icon_m2_wear, null)));
        latestIcons.add(new Icon("MasWear", ResourcesCompat.getDrawable(context.getResources(), R.drawable.themed_icon_maswear, null)));
        latestIcons.add(new Icon("Wonderous", ResourcesCompat.getDrawable(context.getResources(), R.drawable.themed_icon_wonderous, null)));
        latestIcons.add(new Icon("Lingvist", ResourcesCompat.getDrawable(context.getResources(), R.drawable.themed_icon_lingvist, null)));
        latestIcons.add(new Icon("Tonkeeper", ResourcesCompat.getDrawable(context.getResources(), R.drawable.themed_icon_tonkeeper, null)));

        //Request Icons
        //latestIcons.add(new Icon("Request More", ResourcesCompat.getDrawable(context.getResources(), R.drawable.ic_request, null), true));
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
