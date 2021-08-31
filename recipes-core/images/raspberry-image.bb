SUMMARY = "Basic raspberry pi image."
LICENCE = "MIT"

IMAGE_FEATURES += "splash"

inherit core-image-weston

DISTRO_FEATURES_append = " opengl wayland"
DISTRO_FEATURES_remove += "x11"

PREFERRED_PROVIDER_virtual/wpebackend = "wpebackend-fdo"
PACKAGECONFIG_pn-wpebackend-fdo = "wayland"
IMAGE_INSTALL_append += " vim weston wpewebkit cog libwpe wpebackend-fdo"

IMAGE_FSTYPES = "tar.xz ext3 rpi-sdimg"