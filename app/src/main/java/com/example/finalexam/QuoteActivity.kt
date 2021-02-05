package com.example.finalexam

import android.app.AlarmManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.widget.Button
import kotlinx.android.synthetic.main.activity_quote.*
import java.util.*

class QuoteActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quote)
        putQuotesInPrefs()
        val alarmManager = getSystemService(Context.ALARM_SERVICE) as AlarmManager
        val alarmIntent = Intent(this, AlarmManager::class.java)
        val pendingIntent = PendingIntent.getBroadcast(this, 1, alarmIntent, 0)

        val timeFire = Calendar.getInstance().apply {
            timeInMillis = System.currentTimeMillis()
            set(Calendar.HOUR_OF_DAY, 12)
            set(Calendar.MINUTE, 0)
        }

        alarmManager.setRepeating(
            AlarmManager.RTC,
            timeFire.timeInMillis,
            24*60*60*1000,
            pendingIntent
        )

        profileButton1.setOnClickListener {
            startActivity(Intent(this, ProfileActivity::class.java))
            finish()
        }
        QuoteButton1.setOnClickListener{
            startActivity(Intent(this, QuoteActivity::class.java))
            finish()
        }

    }

    fun putQuotesInPrefs() {
        val editor = getSharedPreferences("KATSITA", Context.MODE_PRIVATE).edit()

        editor.putString("1", "It's not the size of the dog in the fight, but the size of the fight in the dog.\n" +
                "-Archie Griffen")
        editor.putString("2", "Nothing lasts forever. Not even your troubles.\n" +
                "-Arnold H Glasgow")
        editor.putString("3", "There are only two ways to live your life. One is as though nothing is a miracle. The other is as though everything is a miracle\n" +
                "-Albert Einstein")
        editor.putString("4", "Take chances, make mistakes. That's how you grow. Pain nourishes your courage. You have to fail in order to practice being brave.\n" +
                "-Mary Tyler Moore")
        editor.putString("5", "Being strong means rejoicing in who you are, complete with imperfections.\n" +
                "-Margaret Woodhouse")
        editor.putString("6", "If you don’t go after what you want, you’ll never have it. If you don’t ask, the answer is always no. If you don’t step forward, you’re always in the same place.\n" +
                "-Nora Roberts")
        editor.putString("7", "I've missed more than 9,000 shots in my career. I've lost almost 300 games. Twenty-six times I've been trusted to take the game-winning shot and missed. I've failed over and over and over again in my life. And that is why I succeed.\n" +
                "-Michael Jordan")
        editor.putString("8", "The only place you find success before work is in the dictionary.\n" +
                "-May V Smith")
        editor.putString("9", "You're going to fail your way to success, you have nothing to be ashamed of so keep your head up. It’s much easier to come up with excuses of why you can't do it. If you do what is easy your life will be hard.\n" +
                "-Les Brown")
        editor.putString("10", "A life spent making mistakes is not only more honorable, but more useful than a life spent doing nothing.\n" +
                "-George Bernard Shaw")
        editor.putString("11", "Nobody can make you feel inferior without your consent.\n" +
                "-Eleanor Roosevelt")
        editor.putString("12", "It took me a long time not to judge myself through someone else's eyes.\n" +
                "-Sally Field")
        editor.putString("13", "I quit being afraid when my first venture failed and the sky didn't fall down.\n" +
                "-Allen H Neuharth")
        editor.putString("14", "Hope never abandons you, you abandon it.\n" +
                "-George Weinberg")
        editor.putString("15", "The only thing keeping you from getting what you want is the story you keep telling yourself about why you don't have it. People who are willing to die to succeed will tend to succeed.\n" +
                "-Tony Robbins")
        editor.putString("16", "People are like stained-glass windows. They sparkle and shine when the sun is out, but when the darkness sets in their true beauty is revealed only if there is light from within.\n" +
                "-Elisabeth Kübler-Ross")
        editor.putString("17", "Nothing splendid has ever been achieved except by those who dared believe that something inside of them was superior to circumstance.\n" +
                "-Bruce Barton")
        editor.putString("18", "Aerodynamically the bumblebee shouldn't be able to fly, but the bumblebee doesn't know that so it goes on flying anyway.\n" +
                "-Mary Kay Ash")
        editor.putString("19", "The secret is in not giving up, of all the greats they didn't quit. If you quit I guarantee you're gonna fail, but you don't know what's gunna happen if you don't give in.\n" +
                "-Eric Thomas")
        editor.putString("20", "Just decide; what's it's gonna be, who you're gonna be and how your gonna do it, and then from that point, the universe will get out of your way.\n" +
                "-Will Smith")

        editor.apply()
    }


}