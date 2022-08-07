To contribute icons to Lawnicons by TeamFiles,

1. Prepare your icon in SVG Format with the dimensions of 36x36px

2. Using Android Studio, convert the SVG to an XML drawable, and add the XML drawable to the app/src/main/res/drawable directory. Follow the naming conventions below to name the drawable:

   - The generic syntax for naming drawables is 'themed_icon_appname
   - The 'themed_icon_' prefix is a must.
   - The app name should contain only small letters and numbers. No symbols other than '_' are allowed.
   - Example: themed_icon_colorwaver

3. Add a new line to app/src/main/res/xml/grayscale_icon_map.xml, and map the new icon to a package name and app name

    ```xml
    <icon drawable="@drawable/themed_icon_colorwaver" name="Colorwaver" package="com.mrousavy.colorwaver" />
    ```

4. You are now ready to open a pull request. We recommend you to set the base branch as `wip`
