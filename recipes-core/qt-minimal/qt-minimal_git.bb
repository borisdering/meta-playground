DESCRIPTION = "My hello world qt program"
SECTION = "examples"
LICENSE = "MIT"
PR = "r0"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

SRCREV = "${AUTOREV}"
SRC_URI =   "git://github.com/borisdering/qt-minimal.git"

S = "${WORKDIR}/git"

PROVIDES += " qt-minimal"

DEPENDS = "qtdeclarative qtwebengine qtbase qtgraphicaleffects"
RDEPENDS:${PN} = "liberation-fonts qtdeclarative-qmlplugins qtgraphicaleffects-qmlplugins"

inherit qmake5

do_install_append() {
    # Install application
    install -d ${D}${bindir}
    install -m 0755 qt-minimal ${D}${bindir}/
    cp ${S}/main.qml ${D}${bindir}/
}