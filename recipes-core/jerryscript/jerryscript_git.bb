DESCRIPTION = "liblvgl"
SECTION = "gui"
LICENSE = "MIT"

SRCREV = "${AUTOREV}"

SRC_URI = "git://github.com/jerryscript-project/jerryscript.git;protocol=http \
            file://lto.patch"

LIC_FILES_CHKSUM = "file://${WORKDIR}/git/LICENSE;md5=24aad7f2ae67177238e23fd19b1aff70"
SRC_URI[sha256sum] = "035b06fb384763ae7102b231e77f389a4836b270e0f9ceb2bcfd36bb5454cbef"

S = "${WORKDIR}/git"

inherit pkgconfig cmake

# skip sanity check for already stripped binary /usr/bin/jerry
INSANE_SKIP_${PN}_append = "already-stripped"
