package com.example.basicfrench;

import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.mlkit.common.model.DownloadConditions;
import com.google.mlkit.nl.translate.TranslateLanguage;
import com.google.mlkit.nl.translate.Translation;
import com.google.mlkit.nl.translate.Translator;
import com.google.mlkit.nl.translate.TranslatorOptions;

import java.util.Locale;

public class TranslateActivity extends AppCompatActivity {

    TextToSpeech tts;

    // Initializing the widgets
    private Spinner fromSpinner, toSpinner;
    private EditText sourceEdt;
    private Button btn;
    private TextView translatedTv;

    // Source array of String Data
    String[] fromLanguages = {
            "From", "English", "Hindi", "Telugu", "Tamil", "Kannada", "French"
    };

    String[] toLanguages = {
            "To", "English", "Hindi", "Telugu", "Tamil", "Kannada", "French"
    };

    // Language codes
    private String fromLanguageCode, toLanguageCode;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_translate);

        fromSpinner = findViewById(R.id.idFromSpinner);
        toSpinner = findViewById(R.id.idToSpinner);
        sourceEdt = findViewById(R.id.idEdtSource);
        translatedTv = findViewById(R.id.idTvTranslatedTV);
        btn = findViewById(R.id.btnTranslate);

        // Spinner 1
        fromSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                fromLanguageCode = GetLanguageCode(fromLanguages[position]);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        ArrayAdapter<String> fromAdapter = new ArrayAdapter<>(this, R.layout.spinner_item, fromLanguages);
        fromAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        fromSpinner.setAdapter(fromAdapter);

        toSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                toLanguageCode = GetLanguageCode(toLanguages[position]);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        ArrayAdapter<String> toAdapter = new ArrayAdapter<>(this, R.layout.spinner_item, toLanguages);
        toAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        toSpinner.setAdapter(toAdapter);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                translatedTv.setText("");
                if (sourceEdt.getText().toString().isEmpty())
                    Toast.makeText(getApplicationContext(), "Please Enter the text", Toast.LENGTH_SHORT).show();
                else if (fromLanguageCode.isEmpty()) {
                    Toast.makeText(getApplicationContext(), "Select Source Language", Toast.LENGTH_SHORT).show();
                } else if (toLanguageCode.isEmpty()) {
                    Toast.makeText(getApplicationContext(), "Select To Language", Toast.LENGTH_SHORT).show();
                } else {
                    TranslateText(fromLanguageCode, toLanguageCode, sourceEdt.getText().toString());
                }
            }
        });
    }

    private void TranslateText(String fromLanguageCode, String toLanguageCode, String src) {
        translatedTv.setText("Downloading Language Model");

        try {
            TranslatorOptions options = new TranslatorOptions.Builder()
                    .setSourceLanguage(fromLanguageCode)
                    .setTargetLanguage(toLanguageCode)
                    .build();
            Translator translator = Translation.getClient(options);
            DownloadConditions conditions = new DownloadConditions.Builder().build();
            translator.downloadModelIfNeeded(conditions).addOnSuccessListener(new OnSuccessListener<Void>() {
                @Override
                public void onSuccess(Void unused) {
                    translatedTv.setText("Translating....");
                    translator.translate(src).addOnSuccessListener(new OnSuccessListener<String>() {
                        @Override
                        public void onSuccess(String s) {

                            translatedTv.setText(s);
                            tts=new TextToSpeech(getApplicationContext(), new TextToSpeech.OnInitListener() {
                                @Override
                                public void onInit(int status) {
                                   if(status==TextToSpeech.SUCCESS){
                                       tts.setLanguage(Locale.FRENCH);
                                       tts.setSpeechRate(1.0f);
                                       tts.speak(translatedTv.getText().toString(),TextToSpeech.QUEUE_ADD,null);
                                   }
                                }
                            });
                        }
                    }).addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception e) {
                            Toast.makeText(getApplicationContext(), "Failed to translate", Toast.LENGTH_SHORT).show();
                        }
                    });
                }
            }).addOnFailureListener(new OnFailureListener() {
                @Override
                public void onFailure(@NonNull Exception e) {
                    Toast.makeText(getApplicationContext(), "Failed to download", Toast.LENGTH_SHORT).show();
                }
            });

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private String GetLanguageCode(String language) {
        String languageCode = "";

        switch (language) {
            case "English":
                languageCode = TranslateLanguage.ENGLISH;
                break;

            case "Hindi":
                languageCode = TranslateLanguage.HINDI;
                break;

            case "Telugu":
                languageCode = TranslateLanguage.TELUGU;
                break;

            case "Tamil":
                languageCode = TranslateLanguage.TAMIL;
                break;

            case "Kannada":
                languageCode = TranslateLanguage.KANNADA;
                break;

            case "French":
                languageCode = TranslateLanguage.FRENCH;
                break;
        }
        return languageCode;
    }
}
