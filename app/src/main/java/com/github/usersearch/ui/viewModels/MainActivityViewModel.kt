package com.github.usersearch.ui.viewModels

import com.github.usersearch.data.api.UserSearchAPI
import com.github.usersearch.data.models.UserItem
import com.github.usersearch.data.repository.UserSearchRepository
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import io.reactivex.subjects.PublishSubject
import javax.inject.Inject

class MainActivityViewModel @Inject constructor(val userSearchAPI: UserSearchAPI) {

    val PAGE_SIZE = 100

    private var searchDisposable: Disposable? = null

    private var userSearchRepository: UserSearchRepository

    internal val usersListPS: PublishSubject<List<UserItem>> = PublishSubject.create()

    internal val errorMessagePS: PublishSubject<String> = PublishSubject.create()

    internal val isLoadingPS: PublishSubject<Boolean> = PublishSubject.create()

    internal val noMoreItemPS: PublishSubject<Boolean> = PublishSubject.create()

    internal var pageNumber: Int = 1

    internal var searchQuery: String? = null

    init {
        userSearchRepository = UserSearchRepository(userSearchAPI)
        isLoadingPS.onNext(false)
        noMoreItemPS.onNext(false)
    }

    /*internal fun getNextPageUsers() {
        getUsers(searchQuery, pageNumber + 1)
    }*/

    internal fun getUsers(searchQuery: String?, pageNumber: Int = 1) {
        if (searchQuery.isNullOrBlank()) return

        searchDisposable?.dispose()

        this.searchQuery = searchQuery
        this.pageNumber = pageNumber

        searchDisposable = userSearchRepository.searchUser(searchQuery)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .doOnSubscribe { isLoadingPS.onNext(true) }
            .doAfterTerminate { isLoadingPS.onNext(false) }
            .subscribe({
                /*                noMoreItemPS.value = it.size < PAGE_SIZE

                // Update future forecast info
                if (pageNumber == 1) usersListPS.value?.clear()
                usersListPS.value?.addAll(it)
                usersListPS.recall()*/
                usersListPS.onNext(it)
            }, {
                //noMoreItemPS.onNext(false)
                it.printStackTrace()
                errorMessagePS.onNext(it.localizedMessage)
            })
    }

}