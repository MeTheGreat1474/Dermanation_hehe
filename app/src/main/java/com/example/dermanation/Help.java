package com.example.dermanation;

import android.os.Bundle;
import android.util.Xml;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import java.io.IOException;
import java.io.InputStream;

public class Help extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_help);

        LinearLayout faqLayout = findViewById(R.id.LLFaq);

        try {
            InputStream is = getResources().openRawResource(R.raw.faq);
            XmlPullParser parser = Xml.newPullParser();
            parser.setFeature(XmlPullParser.FEATURE_PROCESS_NAMESPACES, false);
            parser.setInput(is, null);

            int eventType = parser.getEventType();
            TextView questionView = null;
            TextView answerView = null;

            while (eventType != XmlPullParser.END_DOCUMENT) {
                String name = null;
                switch (eventType) {
                    case XmlPullParser.START_TAG:
                        name = parser.getName();
                        if (name.equals("question")) {
                            questionView = new TextView(this);
                            questionView.setText(parser.nextText());
                            questionView.setTypeface(null, android.graphics.Typeface.BOLD);
                            faqLayout.addView(questionView);
                        } else if (name.equals("answer")) {
                            answerView = new TextView(this);
                            answerView.setText(parser.nextText());
                            answerView.setPadding(15, 0, 0, 10);
                            faqLayout.addView(answerView);
                        }
                        break;
                }
                eventType = parser.next();
            }
            is.close();
        } catch (XmlPullParserException | IOException e) {
            e.printStackTrace();
        }
    }
}