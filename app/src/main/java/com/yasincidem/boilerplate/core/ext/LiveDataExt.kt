package com.yasincidem.boilerplate.core.ext

import androidx.lifecycle.*
import com.yasincidem.boilerplate.core.util.Event
import com.yasincidem.boilerplate.core.util.EventObserver

/*fun <P, R> LiveData<P>.map(body: (P) -> R): LiveData<R> {
    return Transformations.map(this, body)
}*/

inline fun <T> LiveData<T>.observe(owner: LifecycleOwner, crossinline observer: (T?) -> Unit) {
    this.observe(owner, Observer { observer(it) })
}

inline fun <T> LiveData<T>.observeNotNull(
    owner: LifecycleOwner,
    crossinline observer: (T) -> Unit
) {
    this.observe(owner, Observer { it?.run(observer) })
}

inline fun <T> LiveData<Event<T>>.observeEvent(
    owner: LifecycleOwner,
    crossinline eventObserver: (T?) -> Unit
) {
    this.observe(owner, EventObserver { eventObserver(it) })
}

inline fun <T> LiveData<Event<T>>.observeEventNotNull(
    owner: LifecycleOwner,
    crossinline eventObserver: (T) -> Unit
) {
    this.observe(owner, EventObserver { it?.run(eventObserver) })
}

fun <A, B> zipLiveData(a: LiveData<A>, b: LiveData<B>): LiveData<Pair<A, B>> {
    return MediatorLiveData<Pair<A, B>>().apply {
        var lastA: A? = null
        var lastB: B? = null

        fun update() {
            val localLastA = lastA
            val localLastB = lastB
            if (localLastA != null && localLastB != null)
                this.value = Pair(localLastA, localLastB)
        }

        addSource(a) {
            lastA = it
            update()
        }
        addSource(b) {
            lastB = it
            update()
        }
    }
}

fun <T, K, R> LiveData<T>.combineWith(
    liveData: LiveData<K>,
    block: (T?, K?) -> R,
): LiveData<R> {
    val result = MediatorLiveData<R>()
    result.addSource(this) {
        result.value = block(this.value, liveData.value)
    }
    result.addSource(liveData) {
        result.value = block(this.value, liveData.value)
    }
    return result
}

data class Quadruple<out A, out B, out C, out D>(val first: A, val second: B, val third: C, val forth: D)

data class Quintuple<out A, out B, out C, out D, out E>(val first: A, val second: B, val third: C, val fourth: D, val fifth: E)

/** A shorthand for a null LiveData object */
val NULL_LD = null as LiveData<Nothing>?

fun <X, Y> LiveData<X>.map(mapFunction: (X) -> Y): LiveData<Y> {
    return Transformations.map(this, mapFunction)
}

inline fun <reified A, reified B> zip(a: LiveData<A>, b: LiveData<B>) =
    internalZip(a, b, NULL_LD, NULL_LD, NULL_LD).map {
        // remove nullability
        Pair(it[0]!! as A, it[1]!! as B)
    }

inline fun <reified A, reified B, reified C> zip(a: LiveData<A>, b: LiveData<B>, c: LiveData<C>) =
    internalZip(a, b, c, NULL_LD, NULL_LD).map {
        Triple(it[0] as A, it[1] as B, it[2] as C)
    }

inline fun <reified A, reified B, reified C, reified D> zip(a: LiveData<A>, b: LiveData<B>, c: LiveData<C>, d: LiveData<D>) =
    internalZip(a, b, c, d, NULL_LD).map {
        Quadruple(it[0] as A, it[1] as B, it[2] as C, it[3] as D)
    }

inline fun <reified A, reified B, reified C, reified D, reified E> zip(a: LiveData<A>, b: LiveData<B>, c: LiveData<C>, d: LiveData<D>, e: LiveData<E>) =
    internalZip(a, b, c, d, e).map {
        Quintuple(it[0] as A, it[1] as B, it[2] as C, it[3] as D, it[4] as E)
    }

fun <A, B, C, D, E> internalZip(a: LiveData<A>?, b: LiveData<B>?, c: LiveData<C>?, d: LiveData<D>?, e: LiveData<E>?) =
    MediatorLiveData<ArrayList<Any?>>().apply {
        val data = arrayListOf<Any?>(null, null, null, null, null)

        var firstDispatched = false
        var secondDispatched = false
        var thirdDispatched = false
        var fourthDispatched = false
        var fifthDispatched = false

        fun dispatchIfNeeded() {
            // Check whether all non-null sources have a value.
            //  The method may be been invoked with just some of the parameters, in which case we don't care about the others.
            // E.g. there may be just A and B, so we're dealing with a Pair.
            if (a != null && (!firstDispatched || data[0] == null)) return
            if (b != null && (!secondDispatched || data[1] == null)) return
            if (c != null && (!thirdDispatched || data[2] == null)) return
            if (d != null && (!fourthDispatched || data[3] == null)) return
            if (e != null && (!fifthDispatched || data[4] == null)) return

            value = data
        }

        a?.let { addSource(a) { data[0] = it; firstDispatched = true; dispatchIfNeeded() } }
        b?.let { addSource(b) { data[1] = it; secondDispatched = true; dispatchIfNeeded() } }
        c?.let { addSource(c) { data[2] = it; thirdDispatched = true; dispatchIfNeeded() } }
        d?.let { addSource(d) { data[3] = it; fourthDispatched = true; dispatchIfNeeded() } }
        e?.let { addSource(e) { data[4] = it; fifthDispatched = true; dispatchIfNeeded() } }
    }