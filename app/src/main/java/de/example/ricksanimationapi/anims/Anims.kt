package de.example.ricksanimationapi.anims

import android.graphics.drawable.AnimationDrawable

var animMode = true
val timeLinearStart = 8
val timeFast = 1111
val timeSlow = 3333
val timeVerySlow = 8888

fun animsRoundFast(animList: List<AnimationDrawable>) {
    var anim: AnimationDrawable

    repeat(animList.size) {
        anim = animList[it]
        anim.setEnterFadeDuration(timeFast)
        anim.setExitFadeDuration(timeFast)
        anim.start()
    }
}

fun animsRoundSlow(animList: List<AnimationDrawable>) {
    var anim: AnimationDrawable

    repeat(animList.size) {
        anim = animList[it]
        anim.setEnterFadeDuration(timeSlow)
        anim.setExitFadeDuration(timeSlow)
        anim.start()
    }
}

fun animsRoundVerySlow(animList: List<AnimationDrawable>) {
    var anim: AnimationDrawable

    repeat(animList.size) {
        anim = animList[it]
        anim.setEnterFadeDuration(timeLinearStart)
        anim.setExitFadeDuration(timeVerySlow)
        anim.start()
    }
}

fun animLinearStartVerySlow(anim: AnimationDrawable) {
    anim.setEnterFadeDuration(timeLinearStart)
    anim.setExitFadeDuration(timeVerySlow)
    anim.start()
}

fun animRoundStartVerySlow(anim: AnimationDrawable) {
    anim.setEnterFadeDuration(timeVerySlow)
    anim.setExitFadeDuration(timeVerySlow)
    anim.start()
}

fun animRoundStartFast(anim: AnimationDrawable) {
    anim.setEnterFadeDuration(timeLinearStart)
    anim.setExitFadeDuration(timeFast)
    anim.start()
}

fun animBallFast(animList: List<AnimationDrawable> ) {
    var anim: AnimationDrawable

    repeat(animList.size) {
        anim = animList[it]
        anim.setEnterFadeDuration(timeLinearStart)
        anim.setExitFadeDuration(timeFast)
        anim.start()
    }
}