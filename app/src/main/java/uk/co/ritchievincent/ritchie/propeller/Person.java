package uk.co.ritchievincent.ritchie.propeller;

/**
 * Created by Ritchie on 17/01/2017.
 */

class Person {

    private String mId;
    private String mFirstName;
    private String mLastName;
    private String mTeam;
    private String mEmail;
    private String mExtension;
    private String mPosition;
    private String mImage;
    private String mOffice;
    private String mFilm;
    private String mSong;
    private String mHoliday;

    public Person(String id, String firstName, String lastName, String team, String email, String extension, String position, String image, String office, String film, String song, String holiday) {
        mId = id;
        mFirstName = firstName;
        mLastName = lastName;
        mTeam = team;
        mEmail = email;
        mExtension = extension;
        mPosition = position;
        mImage = image;
        mOffice = office;
        mFilm = film;
        mSong = song;
        mHoliday = holiday;
    }

    String getId() {
        return mId;
    }

    String getFirstName() {
        return mFirstName;
    }

    String getLastName() {
        return mLastName;
    }

    String getTeam() {
        return mTeam;
    }

    String getEmail() {
        return mEmail;
    }

    String getExtension() {
        return mExtension;
    }

    String getPosition() {
        return mPosition;
    }

    String getImage() {
        return mImage;
    }

    String getOffice() {
        return mOffice;
    }

    String getFilm() {
        return mFilm;
    }

    String getSong() {
        return mSong;
    }

    String getHoliday() {
        return mHoliday;
    }

    @Override
    public String toString() {
        return "Person{" +
                "mId='" + mId + '\'' +
                ", mFirstName='" + mFirstName + '\'' +
                ", mLastName='" + mLastName + '\'' +
                ", mTeam='" + mTeam + '\'' +
                ", mEmail='" + mEmail + '\'' +
                ", mExtension='" + mExtension + '\'' +
                ", mPosition='" + mPosition + '\'' +
                ", mImage='" + mImage + '\'' +
                ", mOffice='" + mOffice + '\'' +
                ", mFilm='" + mFilm + '\'' +
                ", mSong='" + mSong + '\'' +
                ", mHoliday='" + mHoliday + '\'' +
                '}';
    }
}
