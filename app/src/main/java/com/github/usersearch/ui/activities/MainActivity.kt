package com.github.usersearch.ui.activities

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.github.usersearch.R
import com.github.usersearch.ui.adapters.UsersAdapter
import com.github.usersearch.ui.viewModels.MainActivityViewModel
import com.jakewharton.rxbinding2.widget.RxTextView
import dagger.android.support.DaggerAppCompatActivity
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import kotlinx.android.synthetic.main.activity_main.*
import java.util.concurrent.TimeUnit
import javax.inject.Inject

class MainActivity : DaggerAppCompatActivity() {

    @Inject
    lateinit var mainActivityViewModel: MainActivityViewModel

    private val compositeDisposable: CompositeDisposable = CompositeDisposable()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initViews()
    }

    override fun onDestroy() {
        compositeDisposable.clear()
        super.onDestroy()
    }

    //region Initialization Methods

    private fun initViews() {
        // Loader Subscription
        compositeDisposable.add(mainActivityViewModel.isLoadingPS
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe {
                loader.visibility = if (it) View.VISIBLE else View.GONE
            })

        // Empty UserList Subscription
        compositeDisposable.add(mainActivityViewModel.usersListPS
            .filter { it.isNullOrEmpty() }
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe {
                recyclerView.visibility = View.GONE
            })

        // UserList Subscription
        compositeDisposable.add(mainActivityViewModel.usersListPS
            .filter { it.isNotEmpty() }
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe {
                recyclerView.visibility = View.VISIBLE
                (recyclerView.adapter as UsersAdapter).addItemsToList(it)
            })

        compositeDisposable.add(mainActivityViewModel.errorMessagePS
            .filter { it.isNotEmpty() }
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe {
                Toast.makeText(this, it, Toast.LENGTH_SHORT).show()
            })

        initRecyclerView()
        addEditTextListener()
    }

    private fun initRecyclerView() {
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = UsersAdapter()
    }

    private fun addEditTextListener() {
        compositeDisposable.add(RxTextView.afterTextChangeEvents(editText)
            .debounce(300, TimeUnit.MILLISECONDS)
            .map { it.view().text.toString() }
            .filter { it.isNotEmpty() }
            .distinctUntilChanged()
            .subscribe { mainActivityViewModel.getUsers(it, 1) }
        )
    }

    //endregion

}
