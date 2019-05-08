# This file was derived from the linux-yocto-custom.bb recipe in
# oe-core.
#
# linux-yocto-custom.bb:
#
#   A yocto-bsp-generated kernel recipe that uses the linux-yocto and
#   oe-core kernel classes to apply a subset of yocto kernel
#   management to git managed kernel repositories.
#
# Warning:
#
#   Building this kernel without providing a defconfig or BSP
#   configuration will result in build or boot errors. This is not a
#   bug.
#
# Notes:
#
#   patches: patches can be merged into to the source git tree itself,
#            added via the SRC_URI, or controlled via a BSP
#            configuration.
#
#   example configuration addition:
#            SRC_URI += "file://smp.cfg"
#   example patch addition:
#            SRC_URI += "file://0001-linux-version-tweak.patch
#   example feature addition:
#            SRC_URI += "file://feature.scc"
#

require recipes-kernel/linux/linux-imx.inc

DEPENDS += "lzop-native bc-native"

PV .= "+git${SRCPV}"

SRCBRANCH = "e2c"
SRCREV = "c8b119d991b4a3fd9c64194a62277e023349aa60"

SRC_URI = "git://github.com/etwoc/linux-fslc-e2c.git;branch=${SRCBRANCH}"

KERNEL_DEFCONFIG_imx6ul-sc100 = "${S}/arch/arm/configs/sc100_defconfig"

do_compile_prepend () {
#	cp ${WORKDIR}/imx6ul-sc100.dts \
#	${S}/arch/${ARCH}/boot/dts
	cp ${KERNEL_DEFCONFIG} ${WORKDIR}/defconfig	
}

LOCALVERSION_imx6ul-sc100 = "-mx6ul"





COMPATIBLE_MACHINE = "(mx6)"
