DESCRIPTION = "hello"
SECTION = "library"
LICENSE = "MIT"


SRC_URI = "file://hello.cpp \ 
            file://hello.h \ 
            file://CMakeLists.txt "

LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

S = "${WORKDIR}"

inherit pkgconfig cmake

cmake_do_install() {
    install -d ${D}${includedir}
    install -d ${D}${libdir}
    install -m 0755 ${WORKDIR}/hello.h ${D}${includedir}
    install -m 0755 libhello.a ${D}${libdir}
}

ALLOW_EMPTY_${PN} = "1"

# FILES_${PN} = "${libdir}liblvgl.a"
# FILES_${PN} = "/usr/lib/*.a /lib/*.a /usr/lib/liblvgl/*.a"
