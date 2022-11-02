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
        latestIcons.add(new Icon("Gett", ResourcesCompat.getDrawable(context.getResources(), R.drawable.themed_icon_gett, null)));
        latestIcons.add(new Icon("adidas Running", ResourcesCompat.getDrawable(context.getResources(), R.drawable.themed_icon_adidas_running, null)));
        latestIcons.add(new Icon("Radio FM", ResourcesCompat.getDrawable(context.getResources(), R.drawable.themed_icon_radio_fm, null)));
        latestIcons.add(new Icon("The Guardian Editions", ResourcesCompat.getDrawable(context.getResources(), R.drawable.themed_icon_the_guardian_editions, null)));
        latestIcons.add(new Icon("Guardian", ResourcesCompat.getDrawable(context.getResources(), R.drawable.themed_icon_guardian, null)));
        latestIcons.add(new Icon("ASKfm", ResourcesCompat.getDrawable(context.getResources(), R.drawable.themed_icon_askfm, null)));
        latestIcons.add(new Icon("Kahoot!", ResourcesCompat.getDrawable(context.getResources(), R.drawable.themed_icon_kahoot, null)));
        latestIcons.add(new Icon("ho.", ResourcesCompat.getDrawable(context.getResources(), R.drawable.themed_icon_ho, null)));
        latestIcons.add(new Icon("didUP - Famiglia", ResourcesCompat.getDrawable(context.getResources(), R.drawable.themed_icon_didup_famiglia, null)));
        latestIcons.add(new Icon("Ola Electric", ResourcesCompat.getDrawable(context.getResources(), R.drawable.themed_icon_ola_electric, null)));
        latestIcons.add(new Icon("PlantNet", ResourcesCompat.getDrawable(context.getResources(), R.drawable.themed_icon_plantnet, null)));
        latestIcons.add(new Icon("Financial Times", ResourcesCompat.getDrawable(context.getResources(), R.drawable.themed_icon_financial_times, null)));
        latestIcons.add(new Icon("Washington Post", ResourcesCompat.getDrawable(context.getResources(), R.drawable.themed_icon_washington_post, null)));
        latestIcons.add(new Icon("Hotels.com", ResourcesCompat.getDrawable(context.getResources(), R.drawable.themed_icon_hotels_com, null)));
        latestIcons.add(new Icon("Cheapflights", ResourcesCompat.getDrawable(context.getResources(), R.drawable.themed_icon_cheapflights, null)));
        latestIcons.add(new Icon("Skyscanner", ResourcesCompat.getDrawable(context.getResources(), R.drawable.themed_icon_skyscanner, null)));
        latestIcons.add(new Icon("Ryanair", ResourcesCompat.getDrawable(context.getResources(), R.drawable.themed_icon_ryanair, null)));
        latestIcons.add(new Icon("Wizz Air", ResourcesCompat.getDrawable(context.getResources(), R.drawable.themed_icon_wizz_air, null)));
        latestIcons.add(new Icon("KAYAK", ResourcesCompat.getDrawable(context.getResources(), R.drawable.themed_icon_kayak, null)));
        latestIcons.add(new Icon("Revanced Manager", ResourcesCompat.getDrawable(context.getResources(), R.drawable.themed_icon_revanced_manager, null)));

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
