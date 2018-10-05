#!/bin/sh
### BEGIN INIT INFO
# Provides: SmartSafe
# Required-Start:    $all
# Required-Stop:     $all
# Default-Start:     0 1 2 3 4 5 6
# Default-Stop:
# Short-Description: Runs iSocket and the SmartSafeClientApp.
### END INIT INFO
iSocket -C/etc/opt/e2c/iSocketConfig -L/var/opt/e2c/iSocketLog -S/etc/opt/e2c/&
