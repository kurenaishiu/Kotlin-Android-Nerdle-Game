package com.example.myapplication

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    private val candidate= mutableListOf<String>()
    private val guess = mutableListOf<Char>()
    private val input11 by lazy { findViewById<TextView>(R.id.input11) }
    private val input12 by lazy { findViewById<TextView>(R.id.input12) }
    private val input13 by lazy { findViewById<TextView>(R.id.input13) }
    private val input14 by lazy { findViewById<TextView>(R.id.input14) }
    private val input15 by lazy { findViewById<TextView>(R.id.input15) }
    private val input16 by lazy { findViewById<TextView>(R.id.input16) }
    private val input21 by lazy { findViewById<TextView>(R.id.input21) }
    private val input22 by lazy { findViewById<TextView>(R.id.input22) }
    private val input23 by lazy { findViewById<TextView>(R.id.input23) }
    private val input24 by lazy { findViewById<TextView>(R.id.input24) }
    private val input25 by lazy { findViewById<TextView>(R.id.input25) }
    private val input26 by lazy { findViewById<TextView>(R.id.input26) }
    private val input31 by lazy { findViewById<TextView>(R.id.input31) }
    private val input32 by lazy { findViewById<TextView>(R.id.input32) }
    private val input33 by lazy { findViewById<TextView>(R.id.input33) }
    private val input34 by lazy { findViewById<TextView>(R.id.input34) }
    private val input35 by lazy { findViewById<TextView>(R.id.input35) }
    private val input36 by lazy { findViewById<TextView>(R.id.input36) }
    private val input41 by lazy { findViewById<TextView>(R.id.input41) }
    private val input42 by lazy { findViewById<TextView>(R.id.input42) }
    private val input43 by lazy { findViewById<TextView>(R.id.input43) }
    private val input44 by lazy { findViewById<TextView>(R.id.input44) }
    private val input45 by lazy { findViewById<TextView>(R.id.input45) }
    private val input46 by lazy { findViewById<TextView>(R.id.input46) }
    private val input51 by lazy { findViewById<TextView>(R.id.input51) }
    private val input52 by lazy { findViewById<TextView>(R.id.input52) }
    private val input53 by lazy { findViewById<TextView>(R.id.input53) }
    private val input54 by lazy { findViewById<TextView>(R.id.input54) }
    private val input55 by lazy { findViewById<TextView>(R.id.input55) }
    private val input56 by lazy { findViewById<TextView>(R.id.input56) }
    private val input61 by lazy { findViewById<TextView>(R.id.input61) }
    private val input62 by lazy { findViewById<TextView>(R.id.input62) }
    private val input63 by lazy { findViewById<TextView>(R.id.input63) }
    private val input64 by lazy { findViewById<TextView>(R.id.input64) }
    private val input65 by lazy { findViewById<TextView>(R.id.input65) }
    private val input66 by lazy { findViewById<TextView>(R.id.input66) }
    private var answer=""
    private var times=0
    private var win=false



    private fun push(x:Char){
        if (win){
        AlertDialog.Builder(this).setMessage("Already won").show()
        return
        }
        if (times==6){
            AlertDialog.Builder(this).setMessage("You have lost!\n Answer is $answer").show()
            return
        }
        if (guess.size==6){
            AlertDialog.Builder(this).setMessage("Maybe it is time to submit").show()
            return
        }
        var input=mutableListOf<TextView>(input11,input12,input13,input14,input15,input16)
        if (times==1){
            input= mutableListOf(input21,input22,input23,input24,input25,input26)
        }else if (times==2){
            input= mutableListOf(input31,input32,input33,input34,input35,input36)
        }else if (times==3){
            input= mutableListOf(input41,input42,input43,input44,input45,input46)
        }else if (times==4){
            input= mutableListOf(input51,input52,input53,input54,input55,input56)
        }else if (times==5){
            input= mutableListOf(input61,input62,input63,input64,input65,input66)
        }
        guess.add(x)
        input[guess.size-1].setTextColor(Color.parseColor("#000000"))
        input[guess.size-1].text="$x"
    }
    private fun pop(){
        if (win){
            AlertDialog.Builder(this).setMessage("Already won!").show()
            return
        }
        if (times==6){
            AlertDialog.Builder(this).setMessage("You have lost!\n Answer is $answer").show()
            return
        }
        if (guess.isEmpty()){
            AlertDialog.Builder(this).setMessage("Nothing to pop QQ").show()
            return
        }
        var input=mutableListOf<TextView>(input11,input12,input13,input14,input15,input16)
        if (times==1){
            input= mutableListOf(input21,input22,input23,input24,input25,input26)
        }else if (times==2){
            input= mutableListOf(input31,input32,input33,input34,input35,input36)
        }else if (times==3){
            input= mutableListOf(input41,input42,input43,input44,input45,input46)
        }else if (times==4){
            input= mutableListOf(input51,input52,input53,input54,input55,input56)
        }else if (times==5){
            input= mutableListOf(input61,input62,input63,input64,input65,input66)
        }
        guess.removeLast()
        input[guess.size].text=""
    }
    private fun judge(){
        if (win){
            AlertDialog.Builder(this).setMessage("Already won!").show()
            return
        }
        if (times==6){
            AlertDialog.Builder(this).setMessage("You have lost!\nAnswer is $answer").show()
            return
        }
        if (guess.size!=6){
            AlertDialog.Builder(this).setMessage("What you have entered is not valid\nPlease enter again").show()
            return
        }
        if (guess.joinToString("") !in candidate){
            AlertDialog.Builder(this).setMessage("This is not an valid equation").show()
            return
        }
        var input=mutableListOf<TextView>(input11,input12,input13,input14,input15,input16)
        if (times==1){
            input= mutableListOf(input21,input22,input23,input24,input25,input26)
        }else if (times==2){
            input= mutableListOf(input31,input32,input33,input34,input35,input36)
        }else if (times==3){
            input= mutableListOf(input41,input42,input43,input44,input45,input46)
        }else if (times==4){
            input= mutableListOf(input51,input52,input53,input54,input55,input56)
        }else if (times==5){
            input= mutableListOf(input61,input62,input63,input64,input65,input66)
        }
        if (guess.joinToString("")==answer){
            for (i in 0..5){
                input[i].setBackgroundColor(Color.parseColor("#398874"))
                input[i].setTextColor(Color.parseColor("#FFFFFF"))
            }
            AlertDialog.Builder(this).setMessage("You win! Congregation").show()
            win=true
            return
        }
        for (i in 0..5){
            if (guess[i]==answer[i]){
                input[i].setBackgroundColor(Color.parseColor("#398874"))
                input[i].setTextColor(Color.parseColor("#FFFFFF"))
            }else if (guess[i] in answer){
                input[i].setBackgroundColor(Color.parseColor("#820458"))
                input[i].setTextColor(Color.parseColor("#FFFFFF"))
            }else if (guess[i] !in answer){
                input[i].setBackgroundColor(Color.parseColor("#161803"))
                input[i].setTextColor(Color.parseColor("#FFFFFF"))
            }
        }
        times++
        if (times==6){
            AlertDialog.Builder(this).setMessage("You lose!\n Answer is $answer").show()
        }
        guess.clear()
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        for (a in 0..99){
            for (b in 0..99){
                val plus="$a+$b=${a+b}"
                if (plus.length==6) candidate.add(plus)
                val diff="$a-$b=${a-b}"
                if (a>=b && diff.length==6) candidate.add(diff)
                val times="${a}x$b=${a*b}"
                if (times.length==6) candidate.add(times)
                if (b!=0 && a%b==0){
                    val qua="$a/$b=${a/b}"
                    if (qua.length==6) candidate.add(qua)
                }
            }
        }
        candidate.shuffle()
        answer=candidate[0]
        //AlertDialog.Builder(this).setMessage(answer).show()
        findViewById<Button>(R.id.button0).setOnClickListener { push('0') }
        findViewById<Button>(R.id.button1).setOnClickListener { push('1') }
        findViewById<Button>(R.id.button2).setOnClickListener { push('2') }
        findViewById<Button>(R.id.button3).setOnClickListener { push('3') }
        findViewById<Button>(R.id.button4).setOnClickListener { push('4') }
        findViewById<Button>(R.id.button5).setOnClickListener { push('5') }
        findViewById<Button>(R.id.button6).setOnClickListener { push('6') }
        findViewById<Button>(R.id.button7).setOnClickListener { push('7') }
        findViewById<Button>(R.id.button8).setOnClickListener { push('8') }
        findViewById<Button>(R.id.button9).setOnClickListener { push('9') }
        findViewById<Button>(R.id.PLUS).setOnClickListener { push('+') }
        findViewById<Button>(R.id.MINUS).setOnClickListener { push('-') }
        findViewById<Button>(R.id.TIMES).setOnClickListener { push('x') }
        findViewById<Button>(R.id.DIVIDED).setOnClickListener { push('/') }
        findViewById<Button>(R.id.EQUAL).setOnClickListener { push('=') }
        findViewById<Button>(R.id.SUBMIT).setOnClickListener { judge() }
        findViewById<Button>(R.id.DELETE).setOnClickListener { pop() }
    }
}