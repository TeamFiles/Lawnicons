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
        latestIcons.add(new Icon("OnePlus Camera", ResourcesCompat.getDrawable(context.getResources(), R.drawable.themed_icon_oneplus_camera, null)));
        latestIcons.add(new Icon("Naver Dictionary", ResourcesCompat.getDrawable(context.getResources(), R.drawable.themed_icon_naver_dict, null)));
        latestIcons.add(new Icon("Halyk", ResourcesCompat.getDrawable(context.getResources(), R.drawable.themed_icon_halyk, null)));
        latestIcons.add(new Icon("Forte", ResourcesCompat.getDrawable(context.getResources(), R.drawable.themed_icon_forte_bank, null)));
        latestIcons.add(new Icon("Home Credit", ResourcesCompat.getDrawable(context.getResources(), R.drawable.themed_icon_homecredit, null)));
        latestIcons.add(new Icon("Doppelreim", ResourcesCompat.getDrawable(context.getResources(), R.drawable.themed_icon_doppelreim, null)));
        latestIcons.add(new Icon("Xenowerk", ResourcesCompat.getDrawable(context.getResources(), R.drawable.themed_icon_xenowerk, null)));
        latestIcons.add(new Icon("WA Stickers", ResourcesCompat.getDrawable(context.getResources(), R.drawable.themed_icon_wastickers, null)));
        latestIcons.add(new Icon("OI Safe", ResourcesCompat.getDrawable(context.getResources(), R.drawable.themed_icon_oisafe, null)));
        latestIcons.add(new Icon("Post & DHL", ResourcesCompat.getDrawable(context.getResources(), R.drawable.themed_icon_post_dhl, null)));
        latestIcons.add(new Icon("Wordscapes", ResourcesCompat.getDrawable(context.getResources(), R.drawable.themed_icon_wordscapes, null)));
        latestIcons.add(new Icon("WienMobil", ResourcesCompat.getDrawable(context.getResources(), R.drawable.themed_icon_wienmobil, null)));
        latestIcons.add(new Icon("LEO Dictionary", ResourcesCompat.getDrawable(context.getResources(), R.drawable.themed_icon_leo, null)));
        latestIcons.add(new Icon("FL Studio Mobile", ResourcesCompat.getDrawable(context.getResources(), R.drawable.themed_icon_flm, null)));
        latestIcons.add(new Icon("Bitmoji", ResourcesCompat.getDrawable(context.getResources(), R.drawable.themed_icon_bitmoji, null)));
        latestIcons.add(new Icon("vtosters", ResourcesCompat.getDrawable(context.getResources(), R.drawable.themed_icon_vtosters, null)));
        //Request Icons
        latestIcons.add(new Icon("Request More", ResourcesCompat.getDrawable(context.getResources(), R.drawable.ic_request, null), true));
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
