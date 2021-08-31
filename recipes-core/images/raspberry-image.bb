# SUMMARY = "Basic raspberry pi image."
# LICENSE = "MIT"

# IMAGE_FEATURES += "splash package-management ssh-server-dropbear hwcodecs weston"

# inherit core-image

# CORE_IMAGE_BASE_INSTALL += "gtk+3-demo"
# CORE_IMAGE_BASE_INSTALL += "${@bb.utils.contains('DISTRO_FEATURES', 'x11', 'weston-xwayland matchbox-terminal', '', d)}"

# # DISTRO_FEATURES_append = " opengl wayland"
# # DISTRO_FEATURES_remove += "x11"

# # PREFERRED_PROVIDER_virtual/wpebackend = "wpebackend-fdo"
# # PACKAGECONFIG_pn-wpebackend-fdo = "wayland"
# # IMAGE_INSTALL_append += " vim weston wpewebkit cog libwpe wpebackend-fdo"

# # IMAGE_FSTYPES = "tar.xz ext3 rpi-sdimg"

# QB_MEM = "-m 512"

SUMMARY = "A very basic Wayland image with a terminal"

IMAGE_FEATURES += "splash package-management ssh-server-dropbear hwcodecs weston"

LICENSE = "MIT"

inherit core-image

CORE_IMAGE_BASE_INSTALL += "gtk+3-demo"
CORE_IMAGE_BASE_INSTALL += "${@bb.utils.contains('DISTRO_FEATURES', 'x11', 'weston-xwayland matchbox-terminal', '', d)}"

QB_MEM = "-m 512"