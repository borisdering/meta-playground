SUMMARY = "Basic raspberry pi image."
LICENSE = "MIT"

IMAGE_FEATURES += "splash package-management ssh-server-dropbear hwcodecs"

DISTRO_FEATURES_append = " opengl wayland weston wifi"
DISTRO_FEATURES_remove += "x11"

inherit core-image

CORE_IMAGE_BASE_INSTALL += "gtk+3-demo"
CORE_IMAGE_BASE_INSTALL += "${@bb.utils.contains('DISTRO_FEATURES', 'x11', 'weston-xwayland matchbox-terminal', '', d)}"

QB_MEM = "-m 512"

# Enable systemd
DISTRO_FEATURES_append = " systemd "
DISTRO_FEATURES_BACKFILL_CONSIDERED = "sysvinit"
VIRTUAL-RUNTIME_init_manager = "systemd"
VIRTUAL-RUNTIME_initscripts = ""

# used for wifi
IMAGE_INSTALL_append = " linux-firmware-rpidistro-bcm43430 "

# install wpe and wpe backend
PREFERRED_RPROVIDER_virtual/wpebackend = "wpebackend-fdo"
PACKAGECONFIG_pn-wpebackend-fdo = "wayland"
IMAGE_INSTALL_append += " wpewebkit cog libwpe wpebackend-fdo"

# install weston
IMAGE_INSTALL_append = " weston"

# install qt stuff
IMAGE_INSTALL_append = " qtbase qtbase-plugins qtwebengine"

# IMAGE_FSTYPES = "tar.xz ext3 rpi-sdimg"
IMAGE_INSTALL_append += "vim nano weston"