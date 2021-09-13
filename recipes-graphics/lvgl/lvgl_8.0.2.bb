DESCRIPTION = "liblvgl"
SECTION = "gui"
LICENSE = "MIT"

SRCREV = "${AUTOREV}"

SRC_URI = "git://github.com/lvgl/lvgl.git;protocol=http;branch=release/v8.0 \ 
            file://lv_conf.patch "

LIC_FILES_CHKSUM = "file://${WORKDIR}/git/LICENCE.txt;md5=a922b508d4aab4ffea2a27d0714bd4b8"
SRC_URI[sha256sum] = "035b06fb384763ae7102b231e77f389a4836b270e0f9ceb2bcfd36bb5454cbef"

S = "${WORKDIR}/git"

inherit cmake

do_configure_append() {
    cp ${WORKDIR}/git/lv_conf_template.h ${WORKDIR}/git/lv_conf.h
}

cmake_do_install() {
    # install -d ${D}${includedir}
    install -d ${D}${libdir}
    # install -m 0755 ${WORKDIR}/git/lvgl.h ${D}${includedir}
    install -m 0755 liblvgl.a ${D}${libdir}
}

# So the way our system works, we assume that a recipe will have a main
# package and in the case of a library that that will contain the actual
# library file; the dev package just contains headers and the non-
# versioned symlink to the library. Thus if you install the -dev package,
# it's assumed it won't be of any use unless you install the main
# package, hence the hard dependency. Also, the -staticdev package
# depends upon the -dev package. However, if the main package is empty,
# it won't be produced at all, but the -dev package still depends upon it
# and you'll get the error above. If all you want to do is ship a static
# .a file in the -staticdev package and you're never going to have a main
# package, probably the thing to do is just drop the dependency on the
ALLOW_EMPTY_${PN} = "1"
