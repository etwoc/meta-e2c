DESCRIPTION = "Copies iSocket files to the image"
LICENSE = "CLOSED"

FILESEXTRAPATHS_prepend := "${THISDIR}/files:"
SRC_URI += "file://iSocket  file://iSocketConfig file://SoftwareTerms.txt file://iSocketLog"

S = "${WORKDIR}"

INSANE_SKIP_${PN} = "ldflags"
INHIBIT_PACKAGE_DEBUG_SPLIT = "1"
INHIBIT_PACKAGE_STRIP = "1"
DEPENDS = "libusb"

do_install() {
  install -d ${D}${bindir}
  install -m 755 iSocket ${D}${bindir}

  install -d ${D}${sysconfdir}/e2c/
  install -m 666 iSocketConfig ${D}${sysconfdir}/e2c/
  install -m 666 SoftwareTerms.txt ${D}${sysconfdir}/e2c/

  install -d ${D}${localstatedir}/opt/e2c/
  install -m 666 iSocketLog ${D}${localstatedir}/opt/e2c/
}