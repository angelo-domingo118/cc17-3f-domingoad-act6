package com.example.activity6_30daysapp

import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.progressindicator.LinearProgressIndicator

class MainActivity : AppCompatActivity() {
    private lateinit var tipsRecyclerView: RecyclerView
    private lateinit var tipAdapter: TipAdapter
    private lateinit var progressBar: LinearProgressIndicator
    private val tipsList = generateTips()
    private var completedTips = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        setTheme(R.style.Theme_Activity630DaysApp)
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        setupRecyclerView()
        setupProgressBar()
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    private fun setupRecyclerView() {
        tipsRecyclerView = findViewById(R.id.tipsRecyclerView)
        tipAdapter = TipAdapter(
            tipsList,
            { position, completed -> onTipStatusChanged(position, completed) }
        )
        tipsRecyclerView.layoutManager = LinearLayoutManager(this)
        tipsRecyclerView.adapter = tipAdapter
    }

    private fun setupProgressBar() {
        progressBar = findViewById(R.id.progressBar)
        updateProgress()
    }

    private fun onTipStatusChanged(position: Int, completed: Boolean) {
        tipsList[position].completed = completed
        completedTips = tipsList.count { it.completed }
        updateProgress()
    }

    private fun updateProgress() {
        progressBar.max = tipsList.size
        progressBar.progress = completedTips
    }

    private fun generateTips(): List<Tip> {
        return listOf(
            Tip("Stay Hydrated", "Drink at least 8 glasses of water today. Proper hydration is essential for overall health, improving digestion, skin health, and cognitive function.", R.drawable.day_1),
            Tip("Morning Yoga", "Start your day with a 20-minute yoga session. Yoga can improve flexibility, reduce stress, and increase mindfulness to set a positive tone for your day.", R.drawable.day_2),
            Tip("Healthy Breakfast", "Start your day with a nutritious breakfast. A balanced breakfast provides energy, improves focus, and helps maintain a healthy weight.", R.drawable.day_3),
            Tip("Take a Walk", "Go for a 30-minute walk in nature. Regular walks can improve cardiovascular health, boost mood, and provide an opportunity to connect with nature.", R.drawable.day_4),
            Tip("Mindful Meditation", "Practice 10 minutes of mindfulness meditation. Meditation can reduce stress, improve emotional health, and enhance self-awareness.", R.drawable.day_5),
            Tip("Eat More Fruits", "Include at least 2 servings of fruits in your diet today. Fruits are packed with essential vitamins, minerals, and antioxidants that support overall health.", R.drawable.day_6),
            Tip("Digital Detox", "Spend 2 hours away from screens and digital devices. This can improve sleep quality, reduce eye strain, and promote more meaningful personal interactions.", R.drawable.day_7),
            Tip("Gratitude Journal", "Write down 3 things you're grateful for today. Practicing gratitude can increase positivity, improve self-esteem, and enhance overall well-being.", R.drawable.day_8),
            Tip("Stretch Break", "Take a 5-minute stretch break every hour while working. Regular stretching can improve posture, reduce muscle tension, and increase productivity.", R.drawable.day_9),
            Tip("Connect with Nature", "Spend 15 minutes outdoors, observing nature. Nature exposure can reduce stress, improve mood, and boost vitamin D levels.", R.drawable.day_10),
            Tip("Deep Breathing", "Practice deep breathing exercises for 5 minutes. Deep breathing can help reduce stress, lower blood pressure, and improve lung capacity.", R.drawable.day_11),
            Tip("Healthy Snacking", "Choose a nutritious snack instead of processed foods. Healthy snacks can help maintain stable blood sugar levels and provide essential nutrients.", R.drawable.day_12),
            Tip("Posture Check", "Be mindful of your posture throughout the day. Good posture can reduce back pain, improve breathing, and increase confidence.", R.drawable.day_13),
            Tip("Learn Something New", "Spend 15 minutes learning a new skill or topic. Continuous learning keeps your mind sharp and can increase cognitive function.", R.drawable.day_14),
            Tip("Random Act of Kindness", "Do something nice for someone without expecting anything in return. Acts of kindness can boost happiness, improve relationships, and create a positive ripple effect.", R.drawable.day_15),
            Tip("Declutter Space", "Spend 10 minutes decluttering a small area in your home. A tidy environment can reduce stress, improve focus, and increase productivity.", R.drawable.day_16),
            Tip("Mindful Eating", "Eat one meal without distractions, focusing on the flavors and textures. Mindful eating can improve digestion, help with portion control, and enhance the enjoyment of your food.", R.drawable.day_17),
            Tip("Positive Affirmations", "Repeat positive affirmations to yourself throughout the day. Positive self-talk can boost confidence, reduce negative thoughts, and improve overall mental well-being.", R.drawable.day_18),
            Tip("Try a New Recipe", "Cook a healthy meal using a new recipe. Experimenting with cooking can be a fun way to learn new skills and ensure a varied, nutritious diet.", R.drawable.day_19),
            Tip("Digital Organization", "Spend 15 minutes organizing your digital files or inbox. A organized digital space can save time, reduce stress, and improve productivity.", R.drawable.day_20),
            Tip("Creative Expression", "Engage in a creative activity for 30 minutes (drawing, writing, etc.). Creative activities can reduce stress, improve problem-solving skills, and boost self-expression.", R.drawable.day_21),
            Tip("Phone a Friend", "Call a friend or family member you haven't spoken to in a while. Social connections are crucial for mental health and can provide emotional support.", R.drawable.day_22),
            Tip("Mindful Shopping", "Make a conscious effort to buy only what you need today. Mindful consumption can help save money, reduce clutter, and promote sustainability.", R.drawable.day_23),
            Tip("Bedtime Routine", "Establish a relaxing bedtime routine to improve sleep quality. A consistent sleep schedule can improve overall health, mood, and cognitive function.", R.drawable.day_24),
            Tip("Volunteer or Donate", "Contribute to a cause you care about, either through time or resources. Giving back to the community can increase happiness, provide a sense of purpose, and make a positive impact.", R.drawable.day_25),
            Tip("Try a New Hobby", "Explore a new hobby or interest for 30 minutes. Hobbies can reduce stress, provide a sense of accomplishment, and add joy to your life.", R.drawable.day_26),
            Tip("Mindful Listening", "Practice active listening in your conversations today. Mindful listening can improve relationships, enhance understanding, and make others feel valued.", R.drawable.day_27),
            Tip("Eco-Friendly Action", "Take one action to reduce your environmental impact today. Small eco-friendly actions can collectively make a significant difference for the planet.", R.drawable.day_28),
            Tip("Self-Reflection", "Spend 10 minutes reflecting on your personal growth and goals. Regular self-reflection can help you stay aligned with your values and make intentional progress.", R.drawable.day_29),
            Tip("Celebrate Progress", "Reflect on your wellness journey and celebrate your achievements. Acknowledging your progress can boost motivation and reinforce positive habits for long-term well-being.", R.drawable.day_30)
        )
    }

    private fun showTipDetails(tip: Tip) {
        // Implement this method to show a dialog or navigate to a new screen
        // with the full tip details
        Toast.makeText(this, "Show more details for: ${tip.title}", Toast.LENGTH_SHORT).show()
    }
}
