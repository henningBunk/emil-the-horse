package bunk.henning.emil.model

import android.Manifest.permission.ACCESS_COARSE_LOCATION
import android.Manifest.permission.ACCESS_FINE_LOCATION
import android.Manifest.permission.BLUETOOTH_CONNECT
import android.Manifest.permission.BLUETOOTH_SCAN
import android.content.Context
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.core.content.ContextCompat
import androidx.core.content.PermissionChecker.PERMISSION_GRANTED

class PermissionModel {

    fun hasBluetoothPermission(context: Context): Boolean =
        getPermissionStrings().all {
            ContextCompat.checkSelfPermission(context, it) == PERMISSION_GRANTED
        }

    companion object {

        fun getPermissionStrings(): Array<String> {
            return when {
                Build.VERSION.SDK_INT >= Build.VERSION_CODES.S -> bluetoothPermissionsAndroid12
                else -> bluetoothPermissions
            }
        }

        private val bluetoothPermissions = arrayOf(
            ACCESS_COARSE_LOCATION,
            ACCESS_FINE_LOCATION
        )

        @RequiresApi(api = Build.VERSION_CODES.S)
        private val bluetoothPermissionsAndroid12 = arrayOf(
            BLUETOOTH_SCAN,
            BLUETOOTH_CONNECT
        )
    }
}
