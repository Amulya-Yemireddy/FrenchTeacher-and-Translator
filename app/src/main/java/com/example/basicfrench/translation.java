package com.example.basicfrench;

public class translation {
    int translationbtn;
    String transFrench;
    String transEnglish;



    public translation(int translationbtn, String transFrench, String transEnglish) {
        this.translationbtn = translationbtn;
        this.transFrench = transFrench;
        this.transEnglish = transEnglish;

    }

    public int getTranslationbtn() {
        return translationbtn;
    }

    public void setTranslationbtn(int translationbtn) {
        this.translationbtn = translationbtn;
    }

    public String getTransFrench() {
        return transFrench;
    }

    public void setTransFrench(String transFrench) {
        this.transFrench = transFrench;
    }

    public String getTransEnglish() {
        return transEnglish;
    }

    public void setTransEnglish(String transEnglish) {
        this.transEnglish = transEnglish;
    }


}
