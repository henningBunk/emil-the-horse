package bunk.henning.emil

import android.app.Application
import androidx.lifecycle.ViewModelProvider

class ViewModelFactory(
    private val application: Application,
) : ViewModelProvider.Factory {

    override fun <T : androidx.lifecycle.ViewModel?> create(modelClass: Class<T>): T {
        return ViewModel(application) as T
    }
}
