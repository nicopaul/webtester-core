package info.novatec.testit.webtester.internal;

import java.util.HashSet;
import java.util.Set;

import info.novatec.testit.webtester.api.annotations.Internal;
import info.novatec.testit.webtester.internal.annotations.DefaultValue;
import info.novatec.testit.webtester.internal.annotations.Documentation;
import info.novatec.testit.webtester.internal.annotations.TypeDefinition;


@Internal
public enum NamedProperties {

    @Documentation("URL of the default entry point for the application under test.")
    @TypeDefinition(Constants.RESOURCE_URL)
    BROWSER_DEFAULT_ENTRY_POINT("browser.defaultEntryPoint"),

    @Documentation("Whether or not leftover browsers should be closed automatically when the JVM is shut down."
        + "\nSetting this property will have no impact on the browser's close method or other mechanisms for closing"
        + " the browser either automatically or manually (i.e. JUnitRunner extension)")
    @TypeDefinition(Constants.BOOLEAN)
    @DefaultValue("false")
    CLEANUP_LEFTOVER_BROWSERS("cleanup.closeLeftoverBrowsers"),

    @Documentation("Format pattern for timestamps to be used when printing timestamps.")
    @TypeDefinition(Constants.SIMPLE_DATE_FORMAT)
    @DefaultValue("MMM dd HH:mm:ss yyyy")
    TIMESTAMP_PATTERN("timestamp.pattern"),

    @Documentation("Folder in which to save screenshots if not otherwise specified.")
    @TypeDefinition(Constants.FOLDER_PATH)
    @DefaultValue("screenshots")
    FOLDERS_SCREENSHOT("folders.screenshot"),

    @Documentation("Folder in which to save source code of pages if not otherwise specified.")
    @TypeDefinition(Constants.FOLDER_PATH)
    @DefaultValue("sourcecode")
    FOLDERS_SOURCECODE("folders.sourcecode"),

    @Documentation("Folder in which to save log files if not otherwise specified.")
    @TypeDefinition(Constants.FOLDER_PATH)
    @DefaultValue("logs")
    FOLDERS_LOG("folders.log"),

    @Documentation("Whether or not color highlighting of used elements should be active or not.")
    @TypeDefinition(Constants.BOOLEAN)
    @DefaultValue("false")
    MARKINGS_ACTIVATED("markings.activated"),

    @Documentation("Color to use for the background of used elements if color highlighting is active.")
    @TypeDefinition(Constants.HEX_COLOR)
    @DefaultValue("#ffd2a5")
    MARKINGS_COLOR_USED_BACKGROUND("markings.color.used.background"),

    @Documentation("Color to use for the outline of used elements if color highlighting is active.")
    @TypeDefinition(Constants.HEX_COLOR)
    @DefaultValue("#916f22")
    MARKINGS_COLOR_USED_OUTLINE("markings.color.used.outline"),

    @Documentation("Color to use for the background of read elements if color highlighting is active.")
    @TypeDefinition(Constants.HEX_COLOR)
    @DefaultValue("#90ee90")
    MARKINGS_COLOR_READ_BACKGROUND("markings.color.read.background"),

    @Documentation("Color to use fot the outline of read elements if color highlighting is active")
    @TypeDefinition(Constants.HEX_COLOR)
    @DefaultValue("#008000")
    MARKINGS_COLOR_READ_OUTLINE("markings.color.read.outline"),

    @Documentation("Default timeout for wait operations.")
    @TypeDefinition(Constants.SECONDS_AS_INT)
    @DefaultValue("2")
    WAIT_TIMEOUT("wait.timeout"),

    @Documentation("Default interval in which to check a condition for wait operations.")
    @TypeDefinition(Constants.MILISECONDS_AS_INT)
    @DefaultValue("100")
    WAIT_INTERVAL("wait.interval");

    private final String key;

    NamedProperties(String key) {
        this.key = key;
    }

    public String getKey() {
        return key;
    }

    public static Set<String> getKeys() {
        Set<String> keys = new HashSet<>();
        for (NamedProperties configurationKey : values()) {
            keys.add(configurationKey.getKey());
        }
        return keys;
    }

    private interface Constants {

        String BOOLEAN = "boolean [true, false]";
        String FOLDER_PATH = "String [absolute or relative path to be initialized as a java.io.File instance]";
        String HEX_COLOR = "String [HEX RGB code starting with'#']";
        String SECONDS_AS_INT = "int [seconds]";
        String MILISECONDS_AS_INT = "int [miliseconds]";
        String SIMPLE_DATE_FORMAT =
            "String [Java SimpleDateFormat style as described here: https://docs.oracle.com/javase/6/docs/api/java/text/SimpleDateFormat.html]";
        String RESOURCE_URL = "String [Resource URL]";

    }

}
