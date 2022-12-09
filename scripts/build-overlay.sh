#Check if JAVA is installed
if java -version 2>/dev/null
then
    echo "Java installation verified..."
else
    echo "Java is not installed, please install it and try again!"
    exit
fi

#Declaring variables for file paths
drawable="../ThemedIconsOverlay/res/drawable"
xml="../ThemedIconsOverlay/res/xml"

#Delete redundant files inside ThemedIconsOverlay folder
rm -rf $drawable $xml 2>/dev/null
rm ../ThemedIconsOverlay/res/values/public.xml 2>/dev/null
echo "Deleted old files!"

#Copy drawables from Lawnicons project to the overlay
echo "Copying drawables from Lawnicons app folder..."
mkdir -p $drawable $xml 2>/dev/null
if cp ../app/src/main/res/drawable/themed* $drawable
then
    echo "Done copying!"
else
    echo "Error occurred while trying to copy the files!!!"
    echo "Did you modify any folders?"
    echo "Try cloning this repo once more and try again"
    exit
fi

#Copy grayscale_icon_map.xml from Lawnicons project to the overlay
echo "Copying grayscale_icon_map.xml from Lawnicons app folder..."
if cp ../app/src/main/res/xml/grayscale_icon_map.xml $xml
then
    echo "Done!"
else
    echo "Error occurred while trying to copy grayscale_icon_map.xml!!!"
    echo "Did you modify any folders or files?"
    echo "Try cloning this repo once more and try again"
    exit
fi

#Build apk using apktool
echo "Building ThemedIconsOverlay.apk..."
if java -jar apktool.jar b ../ThemedIconsOverlay
then
    echo "Built successfully!"
else
    echo "Error occurred while trying to build apk!!!"
    echo "Try to resolve the errors above and try again."
fi