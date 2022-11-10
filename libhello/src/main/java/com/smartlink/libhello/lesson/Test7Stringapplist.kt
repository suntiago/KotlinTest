package com.smartlink.libhello.lesson

class Test7Stringapplist {
    val listPrivapp = """
SystemUI
VpnDialogs
WallpaperCropper
WfoService
accountService
autoTestServer
bluetoothService
devMode
juheting
mainService
notifyService
ota
pingbao
settingService
speechService
tboxService
vehicleService
yingyongshangdian"""
    val listVendorapp = """
"""

    companion object {
        /** 我是main入口函数 **/
        @JvmStatic
        fun main(args: Array<String>) {
            for (i in 0..1280) {
                println("<dimen name=\"dp_$i\">${i * 1.5}dp</dimen>")
            }
        }

    }
}