package com.github.scotts.avro;

import org.apache.avro.reflect.Nullable;

public class ReflectedRecordClimber {

    private String gymName;
    @Nullable private String gymNickName;
    @Nullable private String gymLocation;
    private boolean offersTopRopeClimbing = true;
    private boolean offersLeadClimbing = false;
    private boolean offersBouldering = true;
    private boolean offersSpeedClimbing = false;

    // needed by the reflection
    public ReflectedRecordClimber() {
    }

    public ReflectedRecordClimber(String gymName) {
        this.gymName = gymName;
    }

    public String getGymName() {
        return gymName;
    }

    public void setGymName(String gymName) {
        this.gymName = gymName;
    }

    public String getGymNickName() {
        return gymNickName;
    }

    public void setGymNickName(String gymNickName) {
        this.gymNickName = gymNickName;
    }

    public String getGymLocation() {
        return gymLocation;
    }

    public void setGymLocation(String gymLocation) {
        this.gymLocation = gymLocation;
    }

    public boolean isOffersTopRopeClimbing() {
        return offersTopRopeClimbing;
    }

    public void setOffersTopRopeClimbing(boolean offersTopRopeClimbing) {
        this.offersTopRopeClimbing = offersTopRopeClimbing;
    }

    public boolean isOffersLeadClimbing() {
        return offersLeadClimbing;
    }

    public void setOffersLeadClimbing(boolean offersLeadClimbing) {
        this.offersLeadClimbing = offersLeadClimbing;
    }

    public boolean isOffersBouldering() {
        return offersBouldering;
    }

    public void setOffersBouldering(boolean offersBouldering) {
        this.offersBouldering = offersBouldering;
    }

    public boolean isOffersSpeedClimbing() {
        return offersSpeedClimbing;
    }

    public void setOffersSpeedClimbing(boolean offersSpeedClimbing) {
        this.offersSpeedClimbing = offersSpeedClimbing;
    }

}