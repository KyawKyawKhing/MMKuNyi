package com.aceplus.kunyi.mvp.presenter

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import com.aceplus.kunyi.mvp.view.BaseView

/**
 * Created by kkk on 7/26/2018.
 */
abstract class BasePresenter<V : BaseView>(view: V) : ViewModel() {
    protected var mView: V? = view
    protected var mErrorLiveData: MutableLiveData<String> = MutableLiveData()
}