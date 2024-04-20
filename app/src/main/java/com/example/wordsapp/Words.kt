package com.example.wordsapp

import android.os.Parcelable
import kotlinx.parcelize.Parcelize


@Parcelize
data class Words(
    var alphabet: String = "",
    var contentWord: String = "",
    ):Parcelable

val alphabetsData = ('A'..'Z').map{it.toString()}.toMutableList()


enum class  Wordlist(val char: String, val words: ArrayList<String>){
    A("A",arrayListOf("Apple","Ash")),
    B("B",arrayListOf("Butterfly","Brave")),
    C("C",arrayListOf("Clown","Crash")),
    D("D",arrayListOf("Dive","Dash")),
    E("E",arrayListOf("Elevator","Entity")),
    F("F",arrayListOf("Freesia","Fall")),
    G("G",arrayListOf("Groove","Glance")),
    H("H",arrayListOf("Home","Hen")),
    I("I",arrayListOf("Illusion","Indent")),
    J("J",arrayListOf("Jeep","Jump")),
    K("K",arrayListOf("Kidney","Kiack")),
    L("L",arrayListOf("Leap","Lamb")),
    M("M",arrayListOf("Monkey","Misery")),
    N("N",arrayListOf("Neat","Nearby")),
    O("O",arrayListOf("Ordinary","Orange")),
    P("P",arrayListOf("Pineapple","Pale")),
    Q("Q",arrayListOf("Quest","Queen")),
    R("R",arrayListOf("Rush","Runaway")),
    S("S",arrayListOf("Save","Sand")),
    T("T",arrayListOf("Throne","Thunder")),
    U("U",arrayListOf("User","Umbrella")),
    V("V",arrayListOf("View","Vacation")),
    W("W",arrayListOf("Wall","Wonder")),
    X("X",arrayListOf("Xylem","Xylophone")),
    Y("Y",arrayListOf("Yellow","Yarn")),
    Z("Z ",arrayListOf("Zombie","Zebra")),


}