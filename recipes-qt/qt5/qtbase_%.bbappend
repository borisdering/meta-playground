PACKAGECONFIG_append += "eglfs"
PACKAGECONFIG_remove += "xkbcommon-evdev"

QT_CONFIG_FLAGS_remove += "-no-eglfs"