package app.lawnchair.lawnicons.screens.icons;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.Log;

import android.content.res.XmlResourceParser;

import java.util.ArrayList;
import java.util.Collections;
import java.util.ListIterator;

import app.lawnchair.lawnicons.R;
import app.lawnchair.lawnicons.screens.home.Icon;

public class GetIconInfo {

    private static Context context;

    private static ArrayList<Icon> allIcons = new ArrayList<>();
    private static boolean loadedFlag = false;

    public static void setContext(Context context) {
        GetIconInfo.context = context;
    }

    private static void nukeInfoFromXML() {

        Log.i("Icons", "All Icons Cleared");

        int xmlID = R.xml.grayscale_icon_map;
        int missedCount = 0;
        int errorCount = 0;
        int dupCount = 0;

        try {
            if(xmlID != 0) {
                XmlResourceParser parser = context.getResources().getXml(xmlID);
                int depth = parser.getDepth();
                int type;
                do {
                    type = parser.next();
                    if (type != XmlResourceParser.START_TAG)
                        continue;
                    if (parser.getName().equals("icon")) {
                        String appName = parser.getAttributeValue(null, "name");
                        if (appName == null || appName.equals("MISSING") || appName.equals("DUPLICATE") || appName.isEmpty()) {
                            if (appName.equals("DUPLICATE")) {
                                dupCount++;
                            } else {
                                missedCount++;
                            }
                            continue;
                        }
                        int appIconId = parser.getAttributeResourceValue(null, "drawable", 0);
                        Log.i("App Name", appName);

                        Drawable appIcon;
                        try {
                            appIcon = context.getDrawable(appIconId);
                            allIcons.add(new Icon(appName, appIcon));
                            Log.i("Status", "Got");
                        } catch (Exception e) {
                            Log.i("Status", "Rip");
                            errorCount++;
                            e.printStackTrace();
                        }
                    }
                } while ((type != XmlResourceParser.END_TAG || depth < parser.getDepth()) && type != XmlResourceParser.END_DOCUMENT);
            }
            Log.i("Icons displayed", String.valueOf(allIcons.size()));
            Log.i("Icons without name", String.valueOf(missedCount));
            Log.i("Duplicate Icons", String.valueOf(dupCount));
            Log.i("Icons with defect and can't be read", String.valueOf(errorCount));
            Log.i("Total icons", String.valueOf(allIcons.size() + missedCount + errorCount));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static ArrayList<Icon> getAllIcons() {
        if (!loadedFlag) {
            nukeInfoFromXML();
            loadedFlag = true;
        }
        return allIcons;
    }

}
