package top.niunaijun.blackbox.view.apps

import androidx.lifecycle.MutableLiveData
import top.niunaijun.blackbox.bean.AppInfo
import top.niunaijun.blackbox.data.AppsRepository
import top.niunaijun.blackbox.view.base.BaseViewModel
import java.io.File
import java.io.FileDescriptor

/**
 *
 * @Description:
 * @Author: wukaicheng
 * @CreateDate: 2021/4/29 22:36
 */
class AppsViewModel(private val repo: AppsRepository) : BaseViewModel() {

    val appsLiveData = MutableLiveData<List<AppInfo>>()

    val resultLiveData = MutableLiveData<Boolean>()

    val launchLiveData = MutableLiveData<Boolean>()

    fun getInstalledApps(userId: Int) {
        launchOnUI {
            repo.getVmInstallList(userId,appsLiveData)
        }
    }

    fun install(apk: File, userID: Int) {
        launchOnUI {
            repo.installApk(apk,userID,resultLiveData)
        }
    }

    fun install(packageName: String, userID: Int) {
        launchOnUI {
            repo.installApk(packageName,userID,resultLiveData)
        }
    }

    fun unInstall(packageName: String,userID: Int){
        launchOnUI {
            repo.unInstall(packageName,userID,resultLiveData)
        }
    }

    fun  launchApk(packageName:String,userID: Int){
        launchOnUI {
            println("launch")
            repo.launchApk(packageName,userID,launchLiveData)
        }
    }
}