LOCATION=$(curl -s https://api.github.com/repos/iBotPeaches/Apktool/releases/latest \
| grep "browser_download_url" \
| awk '{ print $2 }' \
| sed 's/"//g' )     

wget $LOCATION -P build/

DRAWABLES=`git diff --name-only HEAD^ -- app/src/main/res/drawable HEAD`
GRAYSCALE=`git diff --name-only HEAD^ -- app/src/main/res/xml HEAD`

echo `git diff --name-only HEAD^ -- ../app/src/main/res/drawable HEAD`

java -jar build/apktool*.jar d build/ThemedIconsOverlay.apk -o build/ThemedIconsOverlay
mv build/ThemedIconsOverlay.apk build/ThemedIconsOverlay.old.apk

if [ -z "$DRAWABLES"]
then
    echo "No drawable changes"
else
    echo "Drawable changes"
    for i in $DRAWABLES
    do
        echo "Copying $i"
        cp $i build/ThemedIconsOverlay/res/drawable
    done
fi

if [ -z "$GRAYSCALE" ]
then
    echo "No grayscale changes"
else
    echo "Grayscale changes"
    for i in $GRAYSCALE
    do
        echo "Copying $i"
        cp $i build/ThemedIconsOverlay/res/xml
    done
fi

java -jar build/apktool*.jar b build/ThemedIconsOverlay -o build/ThemedIconsOverlay.apk