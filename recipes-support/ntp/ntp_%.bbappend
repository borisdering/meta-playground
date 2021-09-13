
do_install_append() {
	# replace the server line to actually fetch the time
# 	sed -i '/server 127.127.1.0/c\server 0.ubuntu.pool.ntp.org' ${D}${sysconfdir}/ntp.conf
    # sed -i '/server 0.ubuntu.pool.ntp.org\a server 1.ubuntu.pool.ntp.org' ${D}${sysconfdir}/ntp.conf
    # sed -i '/server 1.ubuntu.pool.ntp.org \a server 2.ubuntu.pool.ntp.org' ${D}${sysconfdir}/ntp.conf
}
