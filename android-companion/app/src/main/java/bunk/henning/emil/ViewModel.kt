package bunk.henning.emil

import android.app.Application
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.AndroidViewModel
import bunk.henning.emil.model.PermissionModel

class ViewModel(application: Application) : AndroidViewModel(application) {

    private val permissionModel = PermissionModel()

    var hasPermissions: Boolean by mutableStateOf(permissionModel.hasBluetoothPermission(application))
        private set

    fun onBrighterClicked() {

    }

    fun onDarkerClicked() {

    }

    fun onBpmSet() {

    }

    fun onModeSelected() {

    }

    fun checkPermissions() {
        hasPermissions = permissionModel.hasBluetoothPermission(getApplication())
    }
}
