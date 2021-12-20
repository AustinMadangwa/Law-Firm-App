package com.example.lawfirmapp.LocalData;

import com.example.lawfirmapp.R;

public class ContactUsData {
    private final String socialMediaName;
    private final String socialMediaLink;
    private final int socialMediaImageID;

    public static  final ContactUsData[] socialMediaData = {
            new ContactUsData("Instagram","https://www.instagram.com", R.drawable.instagram_icon),
            new ContactUsData("Facebook","https://www.facebook.com", R.drawable.facebook_icon),
            new ContactUsData("Twitter","https://twitter.com", R.drawable.twitter_icon),
            new ContactUsData("SnapChat","https://www.snapchat.com", R.drawable.snapchat_icon),
            new ContactUsData("LinkedIn","https://www.linkedin.com", R.drawable.linkedin_icon),
            new ContactUsData("Skype","https://www.skype.com", R.drawable.skype),
            new ContactUsData("Telegram","https://www.telegram.com", R.drawable.telegram),
            new ContactUsData("WhatsApp","https://www.whatsapp.com", R.drawable.whatsapp_icon),
            new ContactUsData("Wechat","https://www.wechat.com", R.drawable.wechat_icon),
            new ContactUsData("Google","https://www.google.com", R.drawable.google_icon),
            new ContactUsData("YouTube","https://www.youtube.com", R.drawable.youtube_icon),
    };


    public ContactUsData(String socialMediaName, String socialMediaLink, int socialMediaImageID) {
        this.socialMediaName = socialMediaName;
        this.socialMediaLink = socialMediaLink;
        this.socialMediaImageID = socialMediaImageID;
    }

    public String getSocialMediaName() {
        return this.socialMediaName;
    }

    public String getSocialMediaLink() {
        return this.socialMediaLink;
    }

    public int getSocialMediaImageID() {
        return this.socialMediaImageID;
    }

    @Override
    public String toString() {
        return  socialMediaName;
    }
}
