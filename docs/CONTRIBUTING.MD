To contribute icons to Lawnicons by TeamFiles,

1. Prepare your icon in the SVG Format in the dimensions of 36x36px

2. Using Android Studio, convert the SVG to an XML drawable, and add the XML drawable to the app/src/main/res/drawable directory. Use snake case with the prefix `themed_icon` for the drawable name(e.g., themed_icon_colorwaver). You can keep all settings at their defaults

3. Add a new line to app/src/main/res/xml/grayscale_icon_map.xml, and map the new icon to a package name and app name

    ```xml
    <icon drawable="@drawable/themed_icon_colorwaver" name="Colorwaver" package="com.mrousavy.colorwaver" />
    ```

4. You are now ready to open a pull request. It is requested to set the base branch as `wip`